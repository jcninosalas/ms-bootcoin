package com.everis.msbootcoin.service.impl;

import com.everis.msbootcoin.model.BootCoinAccount;
import com.everis.msbootcoin.repository.BootCoinAccountRepository;
import com.everis.msbootcoin.service.BootCoinAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class BootCoinAccountServiceImpl implements BootCoinAccountService {

    @Autowired
    private BootCoinAccountRepository repository;

    @Override
    public Mono<BootCoinAccount> create(BootCoinAccount account) {
        return repository.save(account);
    }
}
