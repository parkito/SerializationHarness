package ru.siksmfp.serialization.harness.areon;

import io.aeron.Aeron;
import io.aeron.driver.MediaDriver;

public class AreonConfig {
    private static final MediaDriver driver;
    private static final Aeron.Context CONTEXT;

    static {
        driver = MediaDriver.launchEmbedded();
        CONTEXT = new Aeron.Context().aeronDirectoryName(driver.aeronDirectoryName());
        AERON = Aeron.connect(CONTEXT);
    }

    public static final int STREAM_ID = 10;
    public static final String AREON_ADDRESS = "aeron:udp?endpoint=localhost:40123";
    public static final Aeron AERON;
}
