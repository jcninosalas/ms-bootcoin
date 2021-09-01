package com.everis.msbootcoin.config;

import com.everis.msbootcoin.consumer.EventConsumer;
import com.everis.msbootcoin.event.TransactionEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class TransactionConsumerConfig {

    private final EventConsumer<TransactionEvent> transactionEventEventConsumer;

    public TransactionConsumerConfig(EventConsumer<TransactionEvent> transactionEventEventConsumer) {
        this.transactionEventEventConsumer = transactionEventEventConsumer;
    }

    @Bean
    Consumer<TransactionEvent> transactionEventConsumer() {
        return transactionEventEventConsumer::consumeEvent;
    }
}
