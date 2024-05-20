package com.example.Telegram_mby.controller;


import com.example.Telegram_mby.Service.PersonServiceImpl;
import com.example.Telegram_mby.Util.PersonValidator;
import com.example.Telegram_mby.model.Person;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@Tag(name="Users", description="applications for working with users interacting with the database")
@RestController
@RequestMapping("/api/person")
@AllArgsConstructor
public class PersonController {

    private final PersonValidator personValidator;
    private final PersonServiceImpl personService;

    @Operation(summary = "get one user by id")
    @GetMapping("/{id}")
    public Person getRestControllerPerson(@PathVariable("id") Long id) {
        return personService.getPersonDataBase(id);
    }
    @GetMapping
    @Operation(summary = "Get all users from the database")
    @ResponseStatus(HttpStatus.OK)
    public List<Person> getAllRestControllerPerson() {
        return personService.getAllPersonDataBase();
    }

    @Operation(summary = "update the user in the database")
    @PutMapping
    public ResponseEntity<?> updateRestControllerPerson(@RequestBody @Valid Person person,
                                                        BindingResult result) {
        personValidator.validate(person, result);
        personService.updatePersonDataBase(person, result);
        return ResponseEntity.ok("Пользователь успешно обновлен");
    }

    @Operation(summary = "Save the user to the database")
    @PostMapping
    public ResponseEntity<?> PostRestControllerPerson(@RequestBody @Valid Person person, BindingResult result) {
        personValidator.validate(person, result);
        personService.sevePersonDataBase(person, result);
        return ResponseEntity.ok("Пользователь успешно добавлен");
    }

    @Operation(summary = "Delete a user by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRestControllerPerson(@PathVariable("id") Long id) {
        personService.deletePersonDataBase(id);
        return ResponseEntity.ok("Пользователь успешно удален");
    }
}
