package com.example.Telegram_mby.Util;

import com.example.Telegram_mby.Service.PersonServiceImpl;
import com.example.Telegram_mby.model.Person;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@AllArgsConstructor
public class PersonValidator implements Validator {

    private final PersonServiceImpl personService;
    @Override
    public boolean supports(@NonNull Class<?> clazz) {
      return Person.class.equals(clazz);
    }

    @Override
    public void validate(@NonNull Object target, @NonNull Errors errors) {

    }
}
