package ru.siksmfp.serialization.harness;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;

public class MainTest {

    @Benchmark
    @BenchmarkMode(Mode.All)
    @Fork(value = 1, warmups = 2)
    public void test() {
        for (long i = 0; i < 100; i++) {
            System.out.println(Math.sqrt(i));
        }
    }

    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(args);
    }
}