package com.everis.msbootcoin.service.impl;

import com.everis.msbootcoin.model.BootCoinAccount;
import com.everis.msbootcoin.publisher.BootCoinAccountCreatedEventPublisher;
import com.everis.msbootcoin.repository.BootCoinAccountRepository;
import com.everis.msbootcoin.service.BootCoinAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;

@Service
public class BootCoinAccountServiceImpl implements BootCoinAccountService {

    @Autowired
    private BootCoinAccountRepository repository;

    @Autowired
    private BootCoinAccountCreatedEventPublisher publisher;

    /*
    Al registrase un nuevo monedero se publica un evento que consumira el servivio de transacciones
    */
    @Override
    public Mono<BootCoinAccount> create(BootCoinAccount account) {
        account.setAccountBalance(BigDecimal.valueOf(20));
        account.setCreatedAt(Date.from(Instant.now()));
        return repository.save(account)
                .doOnSuccess(registedAccount -> publisher.process(registedAccount));
    }
}
