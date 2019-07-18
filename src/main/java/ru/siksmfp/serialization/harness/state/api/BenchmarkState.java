package ru.siksmfp.serialization.harness.state.api;

public interface BenchmarkState<I,O> {

    I getInputObject();

    O getOutputObject();

    void setUp();

}
