package com.restapi.restapi.models.vanue;

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
public class VenueLocation {
    @Id
    @GeneratedValue
    private Long id;
    private String street;
    private String city;
    private String zip;
    private String country;
}
