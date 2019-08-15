package ru.siksmfp.serialization.harness.aeron;

public class AeronMain {

    public static void main(String[] args) {
        AeronContext context = new AeronContext(1, "aeron:udp?endpoint=localhost:40123");
    }
}
