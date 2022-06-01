package com.usecase.springtraining.InterceptorRegistry;

import java.util.Timer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TimerRegistry {
	@Bean
    public Timer getTimer(){
        return new Timer();
    }

}
