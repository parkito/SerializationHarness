package ru.siksmfp.serialization.harness.banchmark;

import org.openjdk.jmh.annotations.Benchmark;
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


    @Benchmark
    public boolean findArrayListBenchmark(ListState arrayListState) {
        return arrayListState.arrayList.contains("256");
    }

    @Benchmark
    public boolean findLinkedListBenchmark(ListState arrayListState) {
        return arrayListState.arrayList.contains("256");
    }
}
