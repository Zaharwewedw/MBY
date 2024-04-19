package com.example.Telegram_mby.controller;


import com.example.Telegram_mby.Service.PersonServiceImpl;
import com.example.Telegram_mby.Util.PersonValidator;
import com.example.Telegram_mby.model.Person;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/person")
@AllArgsConstructor
public class PersonController {

    private final PersonValidator personValidator;
    private final PersonServiceImpl personService;

    @GetMapping("/{id}")
    public ResponseEntity<Person> getRestControllerPerson(@PathVariable("id") Long id) {

        return personService.getPersonDataBase(id)
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }
    @GetMapping
    public ResponseEntity<?> getAllRestControllerPerson() {
        List<Person> persons = personService.getAllPersonDataBase();
        return new ResponseEntity<>(persons, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> updateRestControllerPerson(@Valid @RequestBody Person person, BindingResult result) {
        personValidator.validate(person, result);

        if (result.hasErrors()) {
            List<String> errors = result.getAllErrors().stream()
                    .map(err -> err instanceof FieldError ? ((FieldError) err).getField() + ":"
                            + err.getDefaultMessage() : err.getDefaultMessage()).collect(Collectors.toList());

            return ResponseEntity.badRequest().body(errors);
        }

        personService.updatePersonDataBase(person);
        return ResponseEntity.ok("Пользователь успешно добавлен");
    }

    @PostMapping
    public ResponseEntity<?> PostRestControllerPerson(@Valid @RequestBody Person person, BindingResult result) {
        personValidator.validate(person, result);

        if (result.hasErrors()) {
            List<String> errors = result.getAllErrors().stream()
                    .map(err -> err instanceof FieldError ? ((FieldError) err).getField() + ":"
                            + err.getDefaultMessage() : err.getDefaultMessage()).collect(Collectors.toList());

            return ResponseEntity.badRequest().body(errors);
        }

        personService.sevePersonDataBase(person);
        return ResponseEntity.ok("Пользователь успешно обновлен");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRestControllerPerson(@PathVariable("id") Long id) {
        personService.deletePersonDataBase(id);
        return ResponseEntity.ok("Пользователь успешно удален");
    }
}
