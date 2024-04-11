package com.example.Telegram_mby.Service;

import com.example.Telegram_mby.model.Person;

import java.util.Optional;

public interface UserService {
    Optional<Person> getPersonDataBase(Long id);
}
