package com.everis.msbootcoin.event;

import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@ToString
public class TransactionEvent implements  Event{

    private static final String EVENT = "TransactionBootCoinEvent";
    private String phoneNumber;
    private BigDecimal balanceToUpdate;

    @Override
    public String getEvent() {
        return EVENT;
    }
}
