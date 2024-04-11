package com.example.Telegram_mby.Service;

import com.example.Telegram_mby.model.Person;
import com.example.Telegram_mby.repository.RepositoryUser;
import jakarta.annotation.PostConstruct;
import org.springframework.transaction.annotation.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private RepositoryUser repositoryUser;

    @PostConstruct
    @Transactional
    public void defaultPerson() {
        repositoryUser.save(Person.builder()
                .password("sd")
                .username("sdsd")
                .build());
    }
    @Override
    @Transactional(readOnly = true)
    public Optional<Person> getPersonDataBase(Long id) {
        return repositoryUser.findById(id);
    }
}
