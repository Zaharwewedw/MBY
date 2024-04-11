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

//    public static BuilderPerson builder() {
//        return new BuilderPerson(new Person());
//    }

   /* public static class BuilderPerson {
        Person person;

        public BuilderPerson(Person person) {
            this.person = person;
        }
        public BuilderPerson buildUsername(String username){
            person.setUsername(username);
            return this;
        }
        public BuilderPerson buildPassword(String password){
            person.setPassword(password);
            return this;
        }

        public Person build() {
            return this.person;
        }
    }*/
}
