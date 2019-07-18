package ru.siksmfp.serialization.harness.banchmark.api;

import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Warmup;
import ru.siksmfp.serialization.harness.state.api.BenchmarkState;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Fork(value = 2, jvmArgs = {"-Xms2G", "-Xmx2G"})
@Measurement(iterations = 5)
@Warmup(iterations = 5)
public abstract class ParentBenchmark<S extends BenchmarkState, M> {

    public abstract byte[] serializationBenchmark(S state);

    public abstract M deSerializationBenchmark(S state);
}
