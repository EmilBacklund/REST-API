package com.restapi.restapi.repositories;

import com.restapi.restapi.models.language.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language, Long> {
}
