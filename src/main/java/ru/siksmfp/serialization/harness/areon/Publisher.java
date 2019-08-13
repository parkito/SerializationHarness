package ru.siksmfp.serialization.harness.areon;

import io.aeron.ConcurrentPublication;

public class Publisher {
    private ConcurrentPublication publication = AreonConfig.AERON.addPublication(AreonConfig.AREON_ADDRESS, AreonConfig.STREAM_ID);

}
