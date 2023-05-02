package com.restapi.restapi.repositories;

import com.restapi.restapi.models.vanue.Venue;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VenueRepository extends CrudRepository<Venue, Long> {
}
