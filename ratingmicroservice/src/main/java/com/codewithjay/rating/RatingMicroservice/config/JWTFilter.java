package com.codewithjay.rating.RatingMicroservice.config;

import com.codewithjay.rating.RatingMicroservice.service.Impl.JWTService;
import com.codewithjay.rating.RatingMicroservice.service.MyUserDetailsService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.core.SecurityContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JWTFilter extends OncePerRequestFilter {
    @Autowired
    private JWTService jwtService;

    @Autowired
    ApplicationContext context;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authRequest = request.getHeader("Authorization");
        String token = null;
        String userName = null;

        if(authRequest!=null && authRequest.startsWith("Bearer")){
            token = authRequest.substring(7);
            userName = jwtService.extractUserName(token);
        }
        if(userName!=null && SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails user = context.getBean(MyUserDetailsService.class).loadUserByUsername(userName);


            if(jwtService.validateToken(token,user)){
                UsernamePasswordAuthenticationToken authToken =
                        new UsernamePasswordAuthenticationToken(user,null,user.getAuthorities());
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            }

        }
        filterChain.doFilter(request,response);


    }
}
