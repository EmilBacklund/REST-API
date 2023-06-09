package com.restapi.restapi.models.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserAddress {

    @Id
    @GeneratedValue
    private Long id;
    private String address;
    private String city;
    private String zip;
    private String country;

}
