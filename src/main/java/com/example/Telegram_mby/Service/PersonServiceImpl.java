package com.example.Telegram_mby.Service;

import com.example.Telegram_mby.exception.ResourceNotFoundException;
import com.example.Telegram_mby.exception.SaveException;
import com.example.Telegram_mby.exception.UpdateNotFoundException;
import com.example.Telegram_mby.model.Logging;
import com.example.Telegram_mby.model.Person;
import com.example.Telegram_mby.repository.LoggingRepository;
import com.example.Telegram_mby.repository.RepositoryUser;
import jakarta.annotation.PostConstruct;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final LoggingRepository loggingRepository;
    private final RepositoryUser repositoryUser;

    @PostConstruct
    @Transactional
    public void defaultPerson() {
        Logging logging = Logging.builder()
                .timeSave(Timestamp.valueOf(LocalDateTime.now()))
                .timeUpdate(null)
                .build();
        loggingRepository.save(logging);
        repositoryUser.save(Person.builder()
                .firstName("Tolstikov")
                .lastName("Zahar")
                .patronymic("Andreevich")
                .email("tolst.0.2.5@bk.ru")
                .number("89121560274")
                .logging(logging)
                .build());

    }
    @Override
    @Transactional(readOnly = true)
    public Person getPersonDataBase(Long id) {
        return repositoryUser.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Person with id " + id + " not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Person> getAllPersonDataBase() {
        return repositoryUser.findAll();
    }

    @Override
    @Transactional
    public void deletePersonDataBase(Long id) {
        repositoryUser.deleteById(id);
    }

    @Override
    @Transactional
    public void sevePersonDataBase(Person person, BindingResult result) {

        if (result.hasErrors())
            throw new SaveException(ResponseEntity.badRequest().body(errors(result)))  ;
        if (repositoryUser.getByEmail(person.getEmail()).isEmpty())
            repositoryUser.save(person);
        else {
            throw new SaveException("this user is registered");
        }
    }

    @Override
    @Transactional
    public void updatePersonDataBase(Person person, BindingResult result) {
        if (result.hasErrors())
            throw new UpdateNotFoundException(ResponseEntity.badRequest().body(errors(result)))  ;

        if (repositoryUser.getByEmail(person.getEmail()).isPresent())
            repositoryUser.save(new Person(repositoryUser.getByEmail(person.getEmail()).get().getId(), person));
        else {
            throw new UpdateNotFoundException("it is not possible to update this email because it is not in our resource");
        }
    }
    private List<String> errors(BindingResult result) {
        return result.getAllErrors().stream()
                .map(err -> err instanceof FieldError ? ((FieldError) err).getField() + ":"
                        + err.getDefaultMessage() : err.getDefaultMessage()).collect(Collectors.toList());
    }
}