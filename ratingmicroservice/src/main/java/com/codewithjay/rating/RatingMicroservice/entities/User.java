package com.codewithjay.rating.RatingMicroservice.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("user_user")
@Data
public class User {
    @Id
    private String id;
    private String userName;

    private String password;


}
