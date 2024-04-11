package com.example.Telegram_mby.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Data
@PropertySource("/telegram.properties")
public class BotTelegramModel {
    @Value("${bot.username}")
    private String username;
    @Value("${bot.token}")
    private String token;
}
