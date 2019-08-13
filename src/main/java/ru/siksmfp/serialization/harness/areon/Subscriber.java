package ru.siksmfp.serialization.harness.areon;

import io.aeron.Subscription;

public class Subscriber {
    private Subscription subscription = AreonConfig.AERON.addSubscription(AreonConfig.AREON_ADDRESS, AreonConfig.STREAM_ID);
}
