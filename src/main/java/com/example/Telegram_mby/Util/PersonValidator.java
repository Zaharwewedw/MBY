package com.example.Telegram_mby.Util;

import com.example.Telegram_mby.model.Person;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PersonValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
      return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
