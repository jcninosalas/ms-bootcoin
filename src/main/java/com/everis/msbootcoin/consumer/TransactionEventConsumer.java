package com.everis.msbootcoin.consumer;

import com.everis.msbootcoin.event.TransactionEvent;
import com.everis.msbootcoin.repository.BootCoinAccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Date;

@Component
@Slf4j
public class TransactionEventConsumer implements EventConsumer<TransactionEvent> {

    @Autowired
    private BootCoinAccountRepository repository;

    @Override
    public void consumeEvent(TransactionEvent event) {
           log.info("Transaction event recieved: {}", event.toString());
           repository.findByPhoneNumber(event.getPhoneNumber())
                   .flatMap( account -> {
                       account.setAccountBalance(event.getBalanceToUpdate());
                       account.setModifiedAt(Date.from(Instant.now()));
                       return repository.save(account);
                   }).subscribe();
    }
}
