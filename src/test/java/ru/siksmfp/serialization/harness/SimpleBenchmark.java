package ru.siksmfp.serialization.harness;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Warmup;
import ru.siksmfp.serialization.harness.state.impl.ListState;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Fork(value = 2, jvmArgs = {"-Xms2G", "-Xmx2G"})
@Measurement(iterations = 5)
@Warmup(iterations = 5)
public class SimpleBenchmark {

    @Benchmark
    public String findArrayListBenchmark(ListState listState) {
        return listState.arrayList.get(900);
    }

    @Benchmark
    public String findLinkedListBenchmark(ListState listState) {
        return listState.linkedList.get(900);
    }

    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(args);
    }
}

//java 8
//    Benchmark                                Mode  Cnt    Score   Error  Units
//    SimpleBenchmark.findArrayListBenchmark   avgt   10    3.068 ± 0.066  ns/op
//    SimpleBenchmark.findLinkedListBenchmark  avgt   10  113.641 ± 1.518  ns/op

//java 11
//    Benchmark                                Mode  Cnt    Score   Error  Units
//    SimpleBenchmark.findArrayListBenchmark   avgt   10    3.267 ± 0.172  ns/op
//    SimpleBenchmark.findLinkedListBenchmark  avgt   10  114.343 ± 1.283  ns/op

