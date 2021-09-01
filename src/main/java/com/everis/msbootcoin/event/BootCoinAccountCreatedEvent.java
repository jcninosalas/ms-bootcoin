package com.everis.msbootcoin.event;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class BootCoinAccountCreatedEvent implements  Event{

    private static final String EVENT = "BootCoinAccountCreated";
    private String accountId;
    private String phoneNumber;

    @Override
    public String getEvent() {
        return null;
    }
}
