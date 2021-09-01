package com.everis.msbootcoin.repository;

import com.everis.msbootcoin.model.BootCoinAccount;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface BootCoinAccountRepository extends ReactiveMongoRepository <BootCoinAccount, String> {

    Mono<BootCoinAccount> findByPhoneNumber(String phoneNumber);
}
