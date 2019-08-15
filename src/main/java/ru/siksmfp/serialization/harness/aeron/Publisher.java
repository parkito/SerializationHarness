package ru.siksmfp.serialization.harness.aeron;

import io.aeron.ConcurrentPublication;
import org.agrona.DirectBuffer;

public class Publisher {
    private ConcurrentPublication publication;

    public Publisher(AeronContext aeronContext) {
        publication = aeronContext.addPublisher();
    }

    public void publish(DirectBuffer buffer) {
        publication.offer(buffer);
    }
}
