package com.restapi.restapi.responses;


import com.restapi.restapi.models.vanue.Venue;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HomeScreen {

    List<TrendingVenue> trendingVenues;
    List<AffordableVenue> affordableVenues;
    List<TrendingCountries> trendingCountries;

//    @Data
//    @Builder
    //@AllArgsConstructor
    //@NoArgsConstructor
    class TrendingVenue{
        private Long id;
        private String image;
        private int rating;
        private String title;
        private String description;
        private int price;
        //limit 2
        public TrendingVenue(Venue venue){
            this.id = venue.getId();
            this.image = venue.getDisplayImage();
            this.title = venue.getTitle();
            this.description = venue.getInfo().getDescription();
            this.price = venue.getInfo().getPrice();
            this.rating = venue.getRating().getRating();
        }
    }

//    @Data
//    @Builder
//    @AllArgsConstructor
//    @NoArgsConstructor
    class AffordableVenue{
        private Long id;
        private String image;
        //private int priceScore;
        private int price;
        //limit 6
        public AffordableVenue(Venue venue){
            this.id = venue.getId();
            this.image = venue.getDisplayImage();
            this.price = venue.getInfo().getPrice();
        }
    }

//    @Data
//    @Builder
//    @AllArgsConstructor
//    @NoArgsConstructor
    class TrendingCountries{
        private String image;
        //private int rating;
        private String country;
        //private String description;
        //private int price;
        //6
        public TrendingCountries(Venue venue){
            this.image = venue.getDisplayImage();
            this.country = venue.getVenueLocation().getCountry();
        }
    }
}