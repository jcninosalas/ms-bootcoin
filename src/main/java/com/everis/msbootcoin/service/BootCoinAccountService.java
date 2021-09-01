package com.everis.msbootcoin.service;

import com.everis.msbootcoin.model.BootCoinAccount;
import reactor.core.publisher.Mono;

public interface BootCoinAccountService {

    Mono<BootCoinAccount> create (BootCoinAccount account);
}
