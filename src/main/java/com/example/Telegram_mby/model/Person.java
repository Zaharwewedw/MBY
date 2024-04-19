package com.example.Telegram_mby.model;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @Column
    private String username;
    @Column
    private String password;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Person(Long id, Person person) {
        this.id = id;
        this.username = person.getUsername();
        this.password = person.getPassword();
    }
}
