package com.everis.msbootcoin.config;

import com.everis.msbootcoin.event.BootCoinAccountCreatedEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.util.function.Supplier;

@Configuration
public class AccountCreatedPublisherConfig {

    @Bean
    Sinks.Many<BootCoinAccountCreatedEvent> sink() {
        return Sinks.many()
                .multicast()
                .directBestEffort();
    }

    @Bean
    public Supplier<Flux<BootCoinAccountCreatedEvent>> accountCreatedPublisher (
            Sinks.Many<BootCoinAccountCreatedEvent> publisher) {
        return publisher::asFlux;
    }
}
