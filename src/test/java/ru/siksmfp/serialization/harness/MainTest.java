package ru.siksmfp.serialization.harness;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;

public class MainTest {

    @Benchmark
    @BenchmarkMode(Mode.All)
    public void test() {
        for (long i = 0; i < 100; i++) {
            System.out.println(Math.sqrt(i));
        }
    }

    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(args);
    }
}