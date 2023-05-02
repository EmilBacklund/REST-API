package com.restapi.restapi.models.vanue;

import com.restapi.restapi.models.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Venue {
    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String displayImage;
    private boolean available;
    @ManyToOne
    @JoinColumn
    private User owner;
    @OneToOne(cascade = CascadeType.ALL)
    private Availabilities availabilities;
    @OneToOne(cascade = CascadeType.ALL)
    private Rating rating;
    @OneToOne(cascade = CascadeType.ALL)
    private VenueInfo info;
    @OneToOne(cascade = CascadeType.ALL)
    private VenueLocation venueLocation;
    @OneToOne(cascade = CascadeType.ALL)
    private VenueMedia venueMedia;
    private Date created;
    private Date updated;

    @PrePersist
    protected void onCreate() {
        created = new Date();
    }
    @PreUpdate
    protected void onUpdate() {
        updated = new Date();
    }

}
