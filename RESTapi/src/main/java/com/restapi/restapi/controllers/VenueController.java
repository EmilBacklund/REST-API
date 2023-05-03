package com.restapi.restapi.controllers;

import com.restapi.restapi.models.vanue.Venue;
import com.restapi.restapi.repositories.VenueRepository;
import com.restapi.restapi.responses.home.AffordableVenue;
import com.restapi.restapi.responses.home.HomeScreen;
import com.restapi.restapi.responses.home.TrendingCountries;
import com.restapi.restapi.responses.home.TrendingVenue;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class VenueController {

    private final VenueRepository venueRepository;

    @GetMapping("get/home")
    public ResponseEntity<HomeScreen> homeScreen(){
        List<Venue> ratingList = venueRepository.findVenueWithHighestAverageRating(PageRequest.of(0, 2));
        List<Venue> budgetList = venueRepository.findVenueByLowestPricePerSquareMeter(PageRequest.of(0, 6));
        List<Venue> countryList = venueRepository.findVenuesByMostPopularCountry(PageRequest.of(0, 6));
        HomeScreen homeScreen = new HomeScreen();
        ratingList.forEach(homeScreen::trendingVenue);
        budgetList.forEach(homeScreen::affordableVenue);
        countryList.forEach(homeScreen::trendingCountries);
        return ResponseEntity.ok(homeScreen);
    }

    @GetMapping("get/venue/rating")
    public ResponseEntity<List<TrendingVenue>> venueByRating(@RequestParam(value = "page", defaultValue = "0") int page,
                                                            @RequestParam(value = "limit", defaultValue = "30") int limit){
        return ResponseEntity.ok(venueRepository.findVenueWithHighestAverageRating(
                PageRequest.of(page, limit))
                .stream().map(TrendingVenue::new)
                .collect(Collectors.toList()));
    }

    @GetMapping("get/venue/budget")
    public ResponseEntity<List<AffordableVenue>> venueByBudget(@RequestParam(value = "page", defaultValue = "0") int page,
                                                             @RequestParam(value = "limit", defaultValue = "30") int limit){
        return ResponseEntity.ok(venueRepository.findVenueByLowestPricePerSquareMeter(
                        PageRequest.of(page, limit))
                .stream().map(AffordableVenue::new)
                .collect(Collectors.toList()));
    }

    @GetMapping("get/venue/country")
    public ResponseEntity<List<TrendingCountries>> venueByCountry(@RequestParam(value = "page", defaultValue = "0") int page,
                                                                  @RequestParam(value = "limit", defaultValue = "30") int limit){
        return ResponseEntity.ok(venueRepository.findVenueByLowestPricePerSquareMeter(
                        PageRequest.of(page, limit))
                .stream().map(TrendingCountries::new)
                .collect(Collectors.toList()));
    }

    @PostMapping("post/venue/register")
    public ResponseEntity<String> registerVenue(@PostMapping )
}
