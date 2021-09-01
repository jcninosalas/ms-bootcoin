package com.everis.msbootcoin.consumer;

import com.everis.msbootcoin.event.Event;

public interface EventConsumer<T extends Event> {
    void consumeEvent(T event);
}