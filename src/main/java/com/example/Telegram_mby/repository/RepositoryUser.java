package com.example.Telegram_mby.repository;

import com.example.Telegram_mby.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositoryUser extends JpaRepository<Person, Long> {

    Optional<Person> getByUsername(String username);
}
