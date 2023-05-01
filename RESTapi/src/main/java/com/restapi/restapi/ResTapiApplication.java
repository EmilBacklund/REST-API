package com.restapi.restapi;

import com.restapi.restapi.models.language.Language;
import com.restapi.restapi.models.user.Role;
import com.restapi.restapi.models.user.User;
import com.restapi.restapi.models.user.UserInfo;
import com.restapi.restapi.repositories.LanguageRepository;
import com.restapi.restapi.repositories.UserRepository;
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
    public CommandLineRunner hej(LanguageRepository languageRepository, UserRepository userRepository){
        return (args -> {

            userRepository.save(User.builder()
                    .email("email@mail.se")
                    .password("123")
                    .role(Role.USER)
                    .info(UserInfo.builder()
                            .firstName("sven")
                            .lastName("svensson")
                            .birthDate("1923")
                            .build())
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
