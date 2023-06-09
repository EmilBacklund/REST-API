package com.restapi.restapi;

import com.restapi.restapi.models.user.Role;
import com.restapi.restapi.models.user.User;
import com.restapi.restapi.models.user.UserInfo;
import com.restapi.restapi.models.vanue.*;
import com.restapi.restapi.repositories.AmenityRepository;
import com.restapi.restapi.repositories.LanguageRepository;
import com.restapi.restapi.repositories.UserRepository;
import com.restapi.restapi.repositories.VenueRepository;
import jakarta.persistence.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;


@SpringBootApplication
public class ResTapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResTapiApplication.class, args);
    }

    @Bean
    public CommandLineRunner hej(LanguageRepository languageRepository,
                                 UserRepository userRepository,
                                 VenueRepository venueRepository,
                                 AmenityRepository amenityRepository
                                 ){
        return (args -> {





            userRepository.save(
                    User.builder()
                    .email("email@mail.se")
                    .password("123")
                    .role(Role.USER)
                    .info(UserInfo.builder()
                            .firstName("sven")
                            .lastName("svensson")
                            .birthDate("1923")
                            .build())
                    .build());

            userRepository.save(
                    User.builder()
                            .email("bla@mail.se")
                            .password("123")
                            .role(Role.USER)
                            .info(UserInfo.builder()
                                    .firstName("saga")
                                    .lastName("svensson")
                                    .birthDate("5523")
                                    .build())
                            .build());

            userRepository.save(
                    User.builder()
                            .email("klo@mail.se")
                            .password("123")
                            .role(Role.USER)
                            .info(UserInfo.builder()
                                    .firstName("mårten")
                                    .lastName("klasson")
                                    .birthDate("52132")
                                    .build())
                            .build());

            User rater = userRepository.findByEmail("bla@mail.se").orElseThrow(() -> new EntityNotFoundException("User not found"));
            User rater2 = userRepository.findByEmail("klo@mail.se").orElseThrow(() -> new EntityNotFoundException("User not found"));
            User owner = userRepository.findByEmail("email@mail.se").orElseThrow(() -> new EntityNotFoundException("User not found"));



                    amenityRepository.saveAll(List.of(Amenity.builder()
                            .amenity("Wifi")
                            .build(),
                            Amenity.builder()
                                    .amenity("Free Parking")
                                    .build(),
                            Amenity.builder()
                                    .amenity("Paid Parking")
                                    .build(),
                            Amenity.builder()
                                    .amenity("Public Transportation")
                                    .build(),
                            Amenity.builder()
                                    .amenity("EV Charging Station")
                                    .build(),
                            Amenity.builder()
                                    .amenity("Handicap Accessibility")
                                    .build(),Amenity.builder()
                                    .amenity("Restrooms")
                                    .build(),Amenity.builder()
                                    .amenity("Cot / Baby crib")
                                    .build(),Amenity.builder()
                                    .amenity("Highchair")
                                    .build(),Amenity.builder()
                                    .amenity("Air Conditioning")
                                    .build(),Amenity.builder()
                                    .amenity("TV")
                                    .build(),
                            Amenity.builder()
                                    .amenity("Kitchen")
                                    .build(),Amenity.builder()
                                    .amenity("BBQ Grill")
                                    .build(),
                            Amenity.builder()
                                    .amenity("Fire Pit")
                                    .build(),Amenity.builder()
                                    .amenity("Indoor Fireplace")
                                    .build(),Amenity.builder()
                                    .amenity("Outdoor Shower")
                                    .build(),Amenity.builder()
                                    .amenity("Washing Machine")
                                    .build(),Amenity.builder()
                                    .amenity("Dishwasher")
                                    .build(),Amenity.builder()
                                    .amenity("Pool")
                                    .build(),Amenity.builder()
                                    .amenity("Hot tub")
                                    .build(),Amenity.builder()
                                    .amenity("Sauna")
                                    .build(),Amenity.builder()
                                    .amenity("Tennis")
                                    .build(),Amenity.builder()
                                    .amenity("Beach Access")
                                    .build(),Amenity.builder()
                                    .amenity("Lake Access")
                                    .build(),Amenity.builder()
                                    .amenity("Diving Access")
                                    .build(),Amenity.builder()
                                    .amenity("Fishing")
                                    .build(),Amenity.builder()
                                    .amenity("Riding")
                                    .build(),Amenity.builder()
                                    .amenity("Exercise Nearby")
                                    .build(),Amenity.builder()
                                    .amenity("Hunting")
                                    .build(),Amenity.builder()
                                    .amenity("Golf")
                                    .build(),Amenity.builder()
                                    .amenity("Ski")
                                    .build(),Amenity.builder()
                                    .amenity("First Aid Kit")
                                    .build(),Amenity.builder()
                                    .amenity("Fire Extinguisher")
                                    .build(),
                            Amenity.builder()
                                    .amenity("Smoke Alarm")
                                    .build()));


            venueRepository.save(Venue.builder()
                            .title("title")
                            .coverPhoto("image")
                            .available(true)
                            .owner(owner)
                            .type("house")
                            .amenity(amenityRepository.findByAmenityIn(List.of("Wifi", "Kitchen")))
                            .rating(List.of(Rating.builder()
                                                    .rating(3)
                                                    .comment("yay")
                                                    .rater(rater)
                                            .build(),
                                            Rating.builder()
                                                    .rating(2)
                                                    .comment("yay")
                                                    .rater(rater2)
                                            .build()))
                            .info(VenueInfo.builder()
                                    .price(5000)
                                    .guestQuantity(5)
                                    .beds(5)
                                    .squareMeter(100D)
                                    .build())
                            .venueLocation(VenueLocation.builder()
                                    .street("gata")
                                    .city("sthlm")
                                    .zip("124321")
                                    .country("nor")
                                    .build())
                            .venueMedia(List.of(VenueMedia.builder()
                                                    .description("kök")
                                                    .image("bild")
                                                .build(),
                                                VenueMedia.builder()
                                                    .description("toa")
                                                    .image("bild")
                                                .build()))
                            .build());

            venueRepository.save(Venue.builder()
                    .title("title")
                    .coverPhoto("image")
                    .available(true)
                    .owner(owner)
                    .amenity(amenityRepository.findByAmenityIn(List.of("Wifi", "Kitchen")))
                    .rating(List.of(Rating.builder()
                                    .rating(1)
                                    .comment("yay")
                                    .rater(rater)
                                    .build(),
                            Rating.builder()
                                    .rating(2)
                                    .comment("yay")
                                    .rater(rater2)
                                    .build()))
                    .info(VenueInfo.builder()
                            .price(5000)
                            .guestQuantity(5)
                            .beds(5)
                            .squareMeter(102D)
                            .build())
                    .venueLocation(VenueLocation.builder()
                            .street("gata")
                            .city("sthlm")
                            .zip("124321")
                            .country("nor")
                            .build())
                    .venueMedia(List.of(VenueMedia.builder()
                                    .description("kök")
                                    .image("bild")
                                    .build(),
                            VenueMedia.builder()
                                    .description("toa")
                                    .image("bild")
                                    .build()))
                    .build());

            venueRepository.save(Venue.builder()
                    .title("title")
                    .coverPhoto("image")
                    .available(true)
                    .owner(owner)
                    .amenity(amenityRepository.findByAmenityIn(List.of("Wifi", "Kitchen")))
                    .rating(List.of(Rating.builder()
                                    .rating(4)
                                    .comment("yay")
                                    .rater(rater)
                                    .build(),
                            Rating.builder()
                                    .rating(3)
                                    .comment("yay")
                                    .rater(rater2)
                                    .build()))
                    .info(VenueInfo.builder()
                            .price(5000)
                            .guestQuantity(5)
                            .beds(5)
                            .squareMeter(105D)
                            .build())
                    .venueLocation(VenueLocation.builder()
                            .street("gata")
                            .city("sthlm")
                            .zip("124321")
                            .country("nor")
                            .build())
                    .venueMedia(List.of(VenueMedia.builder()
                                    .description("kök")
                                    .image("bild")
                                    .build(),
                            VenueMedia.builder()
                                    .description("toa")
                                    .image("bild")
                                    .build()))
                    .build());

            venueRepository.save(Venue.builder()
                    .title("title")
                    .coverPhoto("image")
                    .available(true)
                    .owner(owner)
                    .amenity(amenityRepository.findByAmenityIn(List.of("Wifi", "Kitchen")))
                    .rating(List.of(Rating.builder()
                                    .rating(4)
                                    .comment("yay")
                                    .rater(rater)
                                    .build(),
                            Rating.builder()
                                    .rating(4)
                                    .comment("yay")
                                    .rater(rater2)
                                    .build()))
                    .info(VenueInfo.builder()
                            .price(5000)
                            .guestQuantity(5)
                            .beds(5)
                            .squareMeter(109D)
                            .build())
                    .venueLocation(VenueLocation.builder()
                            .street("gata")
                            .city("sthlm")
                            .zip("124321")
                            .country("ty")
                            .build())
                    .venueMedia(List.of(VenueMedia.builder()
                                    .description("kök")
                                    .image("bild")
                                    .build(),
                            VenueMedia.builder()
                                    .description("toa")
                                    .image("bild")
                                    .build()))
                    .build());

            venueRepository.save(Venue.builder()
                    .title("title")
                    .coverPhoto("image")
                    .available(true)
                    .owner(owner)
                    .amenity(amenityRepository.findByAmenityIn(List.of("Wifi", "Kitchen")))
                    .rating(List.of(Rating.builder()
                                    .rating(3)
                                    .comment("yay")
                                    .rater(rater)
                                    .build(),
                            Rating.builder()
                                    .rating(2)
                                    .comment("yay")
                                    .rater(rater2)
                                    .build()))
                    .info(VenueInfo.builder()
                            .price(5000)
                            .guestQuantity(5)
                            .beds(5)
                            .squareMeter(80D)
                            .build())
                    .venueLocation(VenueLocation.builder()
                            .street("gata")
                            .city("sthlm")
                            .zip("124321")
                            .country("swe")
                            .build())
                    .venueMedia(List.of(VenueMedia.builder()
                                    .description("kök")
                                    .image("bild")
                                    .build(),
                            VenueMedia.builder()
                                    .description("toa")
                                    .image("bild")
                                    .build()))
                    .build());

            venueRepository.save(Venue.builder()
                    .title("title")
                    .coverPhoto("image")
                    .available(true)
                    .owner(owner)
                    .amenity(amenityRepository.findByAmenityIn(List.of("Wifi", "Kitchen")))
                    .rating(List.of(Rating.builder()
                                    .rating(1)
                                    .comment("yay")
                                    .rater(rater)
                                    .build(),
                            Rating.builder()
                                    .rating(5)
                                    .comment("yay")
                                    .rater(rater2)
                                    .build()))
                    .info(VenueInfo.builder()
                            .price(5000)
                            .guestQuantity(5)
                            .beds(5)
                            .squareMeter(200D)
                            .build())
                    .venueLocation(VenueLocation.builder()
                            .street("gata")
                            .city("sthlm")
                            .zip("124321")
                            .country("swe")
                            .build())
                    .venueMedia(List.of(VenueMedia.builder()
                                    .description("kök")
                                    .image("bild")
                                    .build(),
                            VenueMedia.builder()
                                    .description("toa")
                                    .image("bild")
                                    .build()))
                    .build());

            venueRepository.save(Venue.builder()
                    .title("title")
                    .coverPhoto("image")
                    .available(true)
                    .owner(owner)
                    .amenity(amenityRepository.findByAmenityIn(List.of("Wifi", "Kitchen")))
                    .rating(List.of(Rating.builder()
                                    .rating(4)
                                    .comment("yay")
                                    .rater(rater)
                                    .build(),
                            Rating.builder()
                                    .rating(4)
                                    .comment("yay")
                                    .rater(rater2)
                                    .build()))
                    .info(VenueInfo.builder()
                            .price(5000)
                            .guestQuantity(5)
                            .beds(5)
                            .squareMeter(77D)
                            .build())
                    .venueLocation(VenueLocation.builder()
                            .street("gata")
                            .city("sthlm")
                            .zip("124321")
                            .country("swe")
                            .build())
                    .venueMedia(List.of(VenueMedia.builder()
                                    .description("kök")
                                    .image("bild")
                                    .build(),
                            VenueMedia.builder()
                                    .description("toa")
                                    .image("bild")
                                    .build()))
                    .build());

            venueRepository.save(Venue.builder()
                    .title("title")
                    .coverPhoto("image")
                    .available(true)
                    .owner(owner)
                    .amenity(amenityRepository.findByAmenityIn(List.of("Wifi", "Kitchen")))
                    .rating(List.of(Rating.builder()
                                    .rating(3)
                                    .comment("yay")
                                    .rater(rater)
                                    .build(),
                            Rating.builder()
                                    .rating(3)
                                    .comment("yay")
                                    .rater(rater2)
                                    .build()))
                    .info(VenueInfo.builder()
                            .price(5000)
                            .guestQuantity(5)
                            .beds(5)
                            .squareMeter(124D)
                            .build())
                    .venueLocation(VenueLocation.builder()
                            .street("gata")
                            .city("sthlm")
                            .zip("124321")
                            .country("swe")
                            .build())
                    .venueMedia(List.of(VenueMedia.builder()
                                    .description("kök")
                                    .image("bild")
                                    .build(),
                            VenueMedia.builder()
                                    .description("toa")
                                    .image("bild")
                                    .build()))
                    .build());

            venueRepository.save(Venue.builder()
                    .title("title")
                    .coverPhoto("image")
                    .available(true)
                    .owner(owner)
                    .amenity(amenityRepository.findByAmenityIn(List.of("Wifi", "Kitchen")))
                    .rating(List.of(Rating.builder()
                                    .rating(3)
                                    .comment("yay")
                                    .rater(rater)
                                    .build(),
                            Rating.builder()
                                    .rating(2)
                                    .comment("yay")
                                    .rater(rater2)
                                    .build()))
                    .info(VenueInfo.builder()
                            .price(5000)
                            .guestQuantity(5)
                            .beds(5)
                            .squareMeter(421D)
                            .build())
                    .venueLocation(VenueLocation.builder()
                            .street("gata")
                            .city("sthlm")
                            .zip("124321")
                            .country("swe")
                            .build())
                    .venueMedia(List.of(VenueMedia.builder()
                                    .description("kök")
                                    .image("bild")
                                    .build(),
                            VenueMedia.builder()
                                    .description("toa")
                                    .image("bild")
                                    .build()))
                    .build());

            venueRepository.save(Venue.builder()
                    .title("title")
                    .coverPhoto("image")
                    .available(true)
                    .owner(owner)
                    .amenity(amenityRepository.findByAmenityIn(List.of("Wifi", "Kitchen")))
                    .rating(List.of(Rating.builder()
                                    .rating(3)
                                    .comment("yay")
                                    .rater(rater)
                                    .build(),
                            Rating.builder()
                                    .rating(4)
                                    .comment("yay")
                                    .rater(rater2)
                                    .build()))
                    .info(VenueInfo.builder()
                            .price(5000)
                            .guestQuantity(5)
                            .beds(5)
                            .squareMeter(523D)
                            .build())
                    .venueLocation(VenueLocation.builder()
                            .street("gata")
                            .city("sthlm")
                            .zip("124321")
                            .country("swe")
                            .build())
                    .venueMedia(List.of(VenueMedia.builder()
                                    .description("kök")
                                    .image("bild")
                                    .build(),
                            VenueMedia.builder()
                                    .description("toa")
                                    .image("bild")
                                    .build()))
                    .build());

            venueRepository.save(Venue.builder()
                    .title("title")
                    .coverPhoto("image")
                    .available(true)
                    .owner(owner)
                    .amenity(amenityRepository.findByAmenityIn(List.of("Wifi", "Kitchen")))
                    .rating(List.of(Rating.builder()
                                    .rating(2)
                                    .comment("yay")
                                    .rater(rater)
                                    .build(),
                            Rating.builder()
                                    .rating(3)
                                    .comment("yay")
                                    .rater(rater2)
                                    .build()))
                    .info(VenueInfo.builder()
                            .price(5000)
                            .guestQuantity(5)
                            .beds(5)
                            .squareMeter(55D)
                            .build())
                    .venueLocation(VenueLocation.builder()
                            .street("gata")
                            .city("sthlm")
                            .zip("124321")
                            .country("swe")
                            .build())
                    .venueMedia(List.of(VenueMedia.builder()
                                    .description("kök")
                                    .image("bild")
                                    .build(),
                            VenueMedia.builder()
                                    .description("toa")
                                    .image("bild")
                                    .build()))
                    .build());

            venueRepository.save(Venue.builder()
                    .title("title")
                    .coverPhoto("image")
                    .available(true)
                    .owner(owner)
                    .amenity(amenityRepository.findByAmenityIn(List.of("Wifi", "Kitchen")))
                    .rating(List.of(Rating.builder()
                                    .rating(2)
                                    .comment("yay")
                                    .rater(rater)
                                    .build(),
                            Rating.builder()
                                    .rating(5)
                                    .comment("yay")
                                    .rater(rater2)
                                    .build()))
                    .info(VenueInfo.builder()
                            .price(5000)
                            .guestQuantity(5)
                            .beds(5)
                            .squareMeter(99D)
                            .build())
                    .venueLocation(VenueLocation.builder()
                            .street("gata")
                            .city("sthlm")
                            .zip("124321")
                            .country("swe")
                            .build())
                    .venueMedia(List.of(VenueMedia.builder()
                                    .description("kök")
                                    .image("bild")
                                    .build(),
                            VenueMedia.builder()
                                    .description("toa")
                                    .image("bild")
                                    .build()))
                    .build());

            venueRepository.save(Venue.builder()
                    .title("title")
                    .coverPhoto("image")
                    .available(true)
                    .owner(owner)
                    .amenity(amenityRepository.findByAmenityIn(List.of("Wifi", "Kitchen")))
                    .rating(List.of(Rating.builder()
                                    .rating(3)
                                    .comment("yay")
                                    .rater(rater)
                                    .build(),
                            Rating.builder()
                                    .rating(2)
                                    .comment("yay")
                                    .rater(rater2)
                                    .build()))
                    .info(VenueInfo.builder()
                            .price(5000)
                            .guestQuantity(5)
                            .beds(5)
                            .squareMeter(76D)
                            .build())
                    .venueLocation(VenueLocation.builder()
                            .street("gata")
                            .city("sthlm")
                            .zip("124321")
                            .country("swe")
                            .build())
                    .venueMedia(List.of(VenueMedia.builder()
                                    .description("kök")
                                    .image("bild")
                                    .build(),
                            VenueMedia.builder()
                                    .description("toa")
                                    .image("bild")
                                    .build()))
                    .build());

            venueRepository.save(Venue.builder()
                    .title("title")
                    .coverPhoto("image")
                    .available(true)
                    .owner(owner)
                    .amenity(amenityRepository.findByAmenityIn(List.of("Wifi", "Kitchen")))
                    .rating(List.of(Rating.builder()
                                    .rating(3)
                                    .comment("yay")
                                    .rater(rater)
                                    .build(),
                            Rating.builder()
                                    .rating(3)
                                    .comment("yay")
                                    .rater(rater2)
                                    .build()))
                    .info(VenueInfo.builder()
                            .price(5000)
                            .guestQuantity(5)
                            .beds(5)
                            .squareMeter(99D)
                            .build())
                    .venueLocation(VenueLocation.builder()
                            .street("gata")
                            .city("sthlm")
                            .zip("124321")
                            .country("swe")
                            .build())
                    .venueMedia(List.of(VenueMedia.builder()
                                    .description("kök")
                                    .image("bild")
                                    .build(),
                            VenueMedia.builder()
                                    .description("toa")
                                    .image("bild")
                                    .build()))
                    .build());

//            List<String> list = List.of("Afrikaans",
//                    "Albanian",
//                    "Amharic",
//                    "Arabic",
//                    "Armenian",
//                    "Assamese",
//                    "Aymara",
//                    "Azerbaijani",
//                    "Bambara",
//                    "Basque",
//                    "Belarusian",
//                    "Bengali",
//                    "Bhojpuri",
//                    "Bosnian",
//                    "Bulgarian",
//                    "Catalan",
//                    "Cebuano",
//                    "Chinese",
//                    "Corsican",
//                    "Croatian",
//                    "Czech",
//                    "Danish",
//                    "Dhivehi",
//                    "Dogri",
//                    "Dutch",
//                    "English",
//                    "Esperanto",
//                    "Estonian",
//                    "Ewe",
//                    "Finnish",
//                    "French",
//                    "Frisian",
//                    "Galician",
//                    "Georgian",
//                    "German",
//                    "Greek",
//                    "Guarani",
//                    "Gujarati",
//                    "Haitian Creole",
//                    "Hausa",
//                    "Hawaiian",
//                    "Hebrew",
//                    "Hindi",
//                    "Hmong",
//                    "Hungarian",
//                    "Icelandic",
//                    "Igbo",
//                    "Ilocano",
//                    "Indonesian",
//                    "Irish",
//                    "Italian",
//                    "Japanese",
//                    "Javanese",
//                    "Kannada",
//                    "Kazakh",
//                    "Khmer",
//                    "Kinyarwanda",
//                    "Konkani",
//                    "Korean",
//                    "Krio",
//                    "Kurdish",
//                    "Kurdish",
//                    "Kyrgyz",
//                    "Lao",
//                    "Latin",
//                    "Latvian",
//                    "Lingala",
//                    "Lithuanian",
//                    "Luganda",
//                    "Luxembourgish",
//                    "Macedonian",
//                    "Maithili",
//                    "Malagasy",
//                    "Malay",
//                    "Malayalam",
//                    "Maltese",
//                    "Maori",
//                    "Marathi",
//                    "Meiteilon",
//                    "Mizo",
//                    "Mongolian",
//                    "Myanmar",
//                    "Nepali",
//                    "Norwegian",
//                    "Nyanja",
//                    "Odia",
//                    "Oromo",
//                    "Pashto",
//                    "Persian",
//                    "Polish",
//                    "Portuguese",
//                    "Punjabi",
//                    "Quechua",
//                    "Romanian",
//                    "Russian",
//                    "Samoan",
//                    "Sanskri",
//                    "Scots Gaelic",
//                    "Sepedi",
//                    "Serbian",
//                    "Sesotho",
//                    "Shona",
//                    "Sindhi",
//                    "Sinhala",
//                    "Slovak",
//                    "Slovenian",
//                    "Somali",
//                    "Spanish",
//                    "Sundanese",
//                    "Swahili",
//                    "Swedish",
//                    "Tagalog",
//                    "Tajik",
//                    "Tamil",
//                    "Tatar",
//                    "Telugu",
//                    "Thai",
//                    "Tigrinya",
//                    "Tsonga",
//                    "Turkish",
//                    "Turkmen",
//                    "Twi",
//                    "Ukrainian",
//                    "Urdu",
//                    "Uyghur",
//                    "Uzbek",
//                    "Vietnamese",
//                    "Welsh",
//                    "Xhosa",
//                    "Yiddish",
//                    "Yoruba",
//                    "Zulu");
//
//            list.forEach(e->{
//                languageRepository.save(new Language(e));
//            });
        });
    }
}
