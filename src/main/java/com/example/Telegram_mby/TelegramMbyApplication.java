package com.example.Telegram_mby;

import com.example.Telegram_mby.Util.Consumer;
import com.example.Telegram_mby.model.Person;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.ref.WeakReference;
import java.util.*;
import java.util.stream.Collectors;

@SpringBootApplication
public class TelegramMbyApplication {

	public static void main(String[] args) {
		SpringApplication.run(TelegramMbyApplication.class, args);

	}
}
