package ru.siksmfp.serialization.harness.aeron;

import io.aeron.Subscription;

public class Subscriber {
    private Subscription subscription;

    public Subscriber(AeronContext context) {
        subscription = context.addSubscriber();
    }
}
