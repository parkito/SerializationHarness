package ru.siksmfp.serialization.harness.state.impl;

import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import ru.siksmfp.serialization.harness.state.api.BenchmarkState;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@State(Scope.Benchmark)
public class ListState implements BenchmarkState<List<String> ,List<String> > {

    private List<String> arrayList;
    private List<String> linkedList;

    @Override
    public List<String> getInputObject() {
        return arrayList;
    }

    @Override
    public List<String> getOutputObject() {
        return linkedList;
    }

    @Setup(Level.Trial)
    @Override
    public void setUp() {
        arrayList = new ArrayList<>();
        linkedList = new LinkedList<>();
        for (int i = 0; i < 1000; i++) {
            arrayList.add(String.valueOf(i));
            linkedList.add(String.valueOf(i));
        }
    }
}
