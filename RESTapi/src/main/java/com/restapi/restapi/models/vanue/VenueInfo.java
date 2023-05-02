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
public class VenueInfo {
    @Id
    @GeneratedValue
    private Long id;
    private Integer price;
    private Integer guestQuantity;
    private Integer beds;
    private Double squareMeter;
    @Lob
    private String description;
}
