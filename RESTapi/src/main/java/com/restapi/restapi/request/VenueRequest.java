package com.restapi.restapi.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VenueRequest {

    private double squareMeter;
    private int guests;
    private int beds;
    private int bathrooms;

    private String title;
    private String description;

    private String street;
    private String city;
    private String zip;
    private String country;

    private String type;

    List<String> amenities;

    int price;

    private String coverPhoto;
    private List<VenueMediaRequest> media;

    /*

    {
        "name": "värdet",
        "name": "värdet",
        "name": "värdet",
        "name": "värdet",
        "name": "värdet",
        "name": "värdet",
        "name": "värdet"
        "amenitiesRequest": {
            "wifi": false,
            "wifi": false,
            "wifi": false,
            "wifi": false,
            "wifi": false,
            "wifi": false
        }

        "images": [
            "image1": "url1",
            "image1": "url1",
            "image1": "url1",
            "image1": "url1",
        ]
    }
     */

}
