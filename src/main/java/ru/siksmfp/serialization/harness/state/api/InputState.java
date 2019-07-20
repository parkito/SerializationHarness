package ru.siksmfp.serialization.harness.state.api;

public interface InputState<T> extends BenchmarkState {

    T getInputObject();
}
