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
public class Availabilities {
    @Id
    @GeneratedValue
    private Long id;

    private boolean wifi;
    private boolean parking;
    private boolean breakfast;
    private boolean pets;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Venue venue;

}
