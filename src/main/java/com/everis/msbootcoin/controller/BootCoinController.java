package com.everis.msbootcoin.controller;

import com.everis.msbootcoin.model.BootCoinAccount;
import com.everis.msbootcoin.service.BootCoinAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("bootcoin")
public class BootCoinController {

    @Autowired
    private BootCoinAccountService service;

    @PostMapping
    public Mono<BootCoinAccount> create(@RequestBody BootCoinAccount account) {
        return service.create(account);
    }
}
