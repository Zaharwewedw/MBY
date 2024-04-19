package com.example.Telegram_mby.Service;

import com.example.Telegram_mby.model.Person;
import com.example.Telegram_mby.repository.RepositoryUser;
import jakarta.annotation.PostConstruct;
import org.springframework.transaction.annotation.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {

    private RepositoryUser repositoryUser;

    @PostConstruct
    @Transactional
    public void defaultPerson() {
        repositoryUser.save(Person.builder()
                .password("sd")
                .username("Zahar")
                .build());
    }
    @Override
    @Transactional(readOnly = true)
    public Optional<Person> getPersonDataBase(Long id) {
        return repositoryUser.findById(id);
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
    public void sevePersonDataBase(Person person) {
        repositoryUser.save(person);
    }

    @Override
    @Transactional
    public void updatePersonDataBase(Person person) {
        if (repositoryUser.getByUsername(person.getUsername()).isPresent())
            repositoryUser.save(new Person(repositoryUser.getByUsername(person.getUsername()).get().getId(), person));
    }
}
