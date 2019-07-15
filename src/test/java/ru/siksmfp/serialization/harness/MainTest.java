package ru.siksmfp.serialization.harness;

import org.openjdk.jmh.annotations.Benchmark;

public class MainTest {

    @Benchmark
    public void test() {
        System.out.println(Math.sqrt(10023.1));
    }

    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(args);
    }
}