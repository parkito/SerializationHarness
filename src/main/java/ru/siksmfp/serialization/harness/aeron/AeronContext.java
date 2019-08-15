package ru.siksmfp.serialization.harness.aeron;

import io.aeron.Aeron;
import io.aeron.ConcurrentPublication;
import io.aeron.Subscription;
import io.aeron.driver.MediaDriver;

public class AeronContext {
    private Aeron aeronInstance;
    private String contextAddress;
    private int contextId;

    public AeronContext(int contextId, String contextAddress) {
        this.contextId = contextId;
        this.contextAddress = contextAddress;
        MediaDriver mediaDriver = MediaDriver.launchEmbedded();
        Aeron.Context aeronContext = new Aeron.Context().aeronDirectoryName(mediaDriver.aeronDirectoryName());
        aeronInstance = Aeron.connect(aeronContext);
    }

    public int getContextId() {
        return contextId;
    }

    public Aeron getAeronInstance() {
        return aeronInstance;
    }

    public ConcurrentPublication addPublisher() {
        return aeronInstance.addPublication(contextAddress, contextId);
    }

    public Subscription addSubscriber() {
        return aeronInstance.addSubscription(contextAddress, contextId);
    }
}
