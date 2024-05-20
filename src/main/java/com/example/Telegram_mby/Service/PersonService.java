package com.example.Telegram_mby.Service;

import com.example.Telegram_mby.model.Person;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Optional;

public interface PersonService {

    Person getPersonDataBase(Long id);

    List<Person> getAllPersonDataBase();

    void deletePersonDataBase(Long id);

    void sevePersonDataBase(Person person, BindingResult result);

    void updatePersonDataBase(Person person, BindingResult result);
}
