package com.jayrajurkar.microservices.entities;

import jakarta.persistence.*;
import lombok.*;

import javax.lang.model.element.Name;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="micro_users")
public class User {
    @Id
    @Column(name = "ID")
    String userId;

    @Column(name="NAME",length = 30)
    String name;

    @Column(name="ABOUT")
    String about;

    @Column(name="EMAIl")
    String email;

    @Transient
    List<Rating> ratings = new ArrayList<>();

}
