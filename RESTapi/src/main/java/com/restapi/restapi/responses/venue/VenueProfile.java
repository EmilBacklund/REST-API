package com.restapi.restapi.responses.venue;

import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VenueProfile {
    private Long id;
    private String title;
    private String coverPhoto;
    private String type;
    private long owner;
    private List<String> amenities;
    private List<VenueProfileRating> venueProfileRatings;
    private Integer price;
    private Integer guestQuantity;
    private Integer beds;
    private Double squareMeter;
    @Lob
    private String description;
    private String street;
    private String city;
    private String zip;
    private String country;
    private List<VenueProfileMedia> media;
    private Date created;
    private Date updated;
}
