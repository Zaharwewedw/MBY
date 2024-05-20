package com.example.Telegram_mby.Service;

import com.example.Telegram_mby.model.Logging;
import com.example.Telegram_mby.model.Person;

import java.util.List;
import java.util.Optional;

public interface LoggingService  {

    Optional<Logging> getLoggingDataBase(Long id);

    List<Logging> getAllLoggingDataBase();

    void deleteLoggingDataBase(Long id);

    void seveLoggingDataBase(Logging person);

    void updateLoggingDataBase(Person person);
}
