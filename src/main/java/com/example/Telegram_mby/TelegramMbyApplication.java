package com.example.Telegram_mby;

import com.example.Telegram_mby.Util.Consumer;
import com.example.Telegram_mby.model.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TelegramMbyApplication {

	public static void main(String[] args) {
		SpringApplication.run(TelegramMbyApplication.class, args);
		System.out.println(Consumer.postRest());
	}
}
