package com.everis.msbootcoin.publisher;

import com.everis.msbootcoin.event.BootCoinAccountCreatedEvent;
import com.everis.msbootcoin.model.BootCoinAccount;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Sinks;

@Component
@Slf4j
public class BootCoinAccountCreatedEventPublisher {

    private final Sinks.Many<BootCoinAccountCreatedEvent> sink;

    @Autowired
    public BootCoinAccountCreatedEventPublisher(Sinks.Many<BootCoinAccountCreatedEvent> sink) {
        this.sink = sink;
    }

    public void process(BootCoinAccount account) {
        var event = BootCoinAccountCreatedEvent.builder()
                .accountId(account.getId())
                .phoneNumber(account.getPhoneNumber())
                .build();
        log.info("Event to be published : {}", event.toString());
        sink.emitNext(event, Sinks.EmitFailureHandler.FAIL_FAST);
    }
}
