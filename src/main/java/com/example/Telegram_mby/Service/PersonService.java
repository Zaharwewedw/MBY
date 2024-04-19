package com.example.Telegram_mby.Service;

import com.example.Telegram_mby.model.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {

    Optional<Person> getPersonDataBase(Long id);

    List<Person> getAllPersonDataBase();

    void deletePersonDataBase(Long id);

    void sevePersonDataBase(Person person);

    void updatePersonDataBase(Person person);
}
