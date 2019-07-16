package ru.siksmfp.serialization.harness.banchmark;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import ru.siksmfp.serialization.harness.model.User;

public class FlatBufferBenchmark extends ParentBenchmark {

    @State(Scope.Benchmark)
    private static class FlatBufferUserState {
        public byte[] serializedUser;

        @Setup(Level.Trial)
        public void setUp() {
        }
    }

    @Benchmark
    public byte[] serializationBenchmark(UserState state) {
        return null;
    }

    @Benchmark
    public User deSerializationBenchmark(UserState state) {
        return null;
    }
}
