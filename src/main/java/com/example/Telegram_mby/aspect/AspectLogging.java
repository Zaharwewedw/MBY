package com.example.Telegram_mby.aspect;

import lombok.AllArgsConstructor;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.TreeMap;

@Component
@Aspect
@AllArgsConstructor
public class AspectLogging {
    @Before("execution(public * getAllPersonDataBase())")
    public void beforeLoggingServiceGetAllPersonDataBase() {
        System.out.println("test");
    }
}
