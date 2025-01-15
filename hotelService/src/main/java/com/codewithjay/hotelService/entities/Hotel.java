package com.codewithjay.hotelService.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Data
@Entity
@Table(name="hotels")
public class Hotel {

    @Id
    private String hotelId;

    private String hotelName;

    private String location;

    private String about;


}
