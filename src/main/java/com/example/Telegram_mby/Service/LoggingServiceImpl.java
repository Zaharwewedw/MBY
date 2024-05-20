package com.example.Telegram_mby.Service;

import com.example.Telegram_mby.model.Logging;
import com.example.Telegram_mby.model.Person;
import com.example.Telegram_mby.repository.LoggingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LoggingServiceImpl implements LoggingService {

    private final LoggingRepository loggingRepository;
    @Override
    public Optional<Logging> getLoggingDataBase(Long id) {
        return loggingRepository.findById(id);
    }

    @Override
    public List<Logging> getAllLoggingDataBase() {
        return loggingRepository.findAll();
    }

    @Override
    public void deleteLoggingDataBase(Long id) {
        loggingRepository.deleteById(id);
    }

    @Override
    public void seveLoggingDataBase(Logging person) {
        loggingRepository.save(person);
    }

    @Override
    public void updateLoggingDataBase(Person person) {

    }

    /*@Override
    public void updateLoggingDataBase(Person person) {
        if (loggingRepository.getPersonByIdLogging(person.getEmail()).isPresent())
            loggingRepository.save(new Logging(loggingRepository.);
    }*/
}
