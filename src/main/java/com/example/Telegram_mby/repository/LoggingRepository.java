package com.example.Telegram_mby.repository;

import com.example.Telegram_mby.model.Logging;
import com.example.Telegram_mby.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface LoggingRepository extends JpaRepository<Logging, Long> {

    @Query(value = "SELECT p WHERE person p LEFT JOIN FETCH p.logging WHERE p.email = :email", nativeQuery = true)
    Optional<Person> getPersonByIdLogging(@Param("email") String email);
}
