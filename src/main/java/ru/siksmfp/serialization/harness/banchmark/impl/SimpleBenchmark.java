package ru.siksmfp.serialization.harness.banchmark.impl;

import org.openjdk.jmh.annotations.Benchmark;
import ru.siksmfp.serialization.harness.state.impl.ListState;

public class SimpleBenchmark {

    @Benchmark
    public String findArrayListBenchmark(ListState listState) {
        return listState.arrayList.get(900);
    }

    @Benchmark
    public String findLinkedListBenchmark(ListState listState) {
        return listState.linkedList.get(900);
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

