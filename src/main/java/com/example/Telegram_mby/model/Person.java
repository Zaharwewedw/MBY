package com.example.Telegram_mby.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.*;

@Entity
@Builder
@Data
@Table
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Person {

    @Column
    @Email
    private String email;

    @Column
    private String lastName;

    @Column
    private String firstName;

    @Column
    private String patronymic;

    @Column
    private String number;

    @OneToOne
    @JsonIgnore
    private Logging logging;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Person(Long id, Person person) {
        this.id = id;
        this.email = person.getEmail();
        this.patronymic = person.getPatronymic();
        this.firstName = person.getFirstName();
        this.lastName = person.getLastName();
        this.number = person.getNumber();
    }
}
