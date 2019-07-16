package ru.siksmfp.serialization.harness.banchmark;

import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SimpleBenchmark extends ParentBenchmark {

    @State(Scope.Benchmark)
    public static class ListState {

        public List<String> arrayList;
        public List<String> linkedList;

        @Setup(Level.Trial)
        public void setUp() {
            arrayList = new ArrayList<>();
            linkedList = new LinkedList<>();
            for (int i = 0; i < 1000; i++) {
                arrayList.add(String.valueOf(i));
                linkedList.add(String.valueOf(i));
            }
        }
    }


    //    @Benchmark
    public String findArrayListBenchmark(ListState listState) {
        return listState.arrayList.get(900);
    }

    //    @Benchmark
    public String findLinkedListBenchmark(ListState listState) {
        return listState.linkedList.get(900);
    }

    //java 8
//    Benchmark                                Mode  Cnt    Score   Error  Units
//    SimpleBenchmark.findArrayListBenchmark   avgt   10    3.068 ± 0.066  ns/op
//    SimpleBenchmark.findLinkedListBenchmark  avgt   10  113.641 ± 1.518  ns/op

    //java 11
//    Benchmark                                Mode  Cnt    Score   Error  Units
//    SimpleBenchmark.findArrayListBenchmark   avgt   10    3.267 ± 0.172  ns/op
//    SimpleBenchmark.findLinkedListBenchmark  avgt   10  114.343 ± 1.283  ns/op
}
