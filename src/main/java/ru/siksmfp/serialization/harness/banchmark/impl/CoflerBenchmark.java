package ru.siksmfp.serialization.harness.banchmark.impl;

import org.openjdk.jmh.annotations.Benchmark;
import ru.siksmfp.serialization.harness.banchmark.api.ParentBenchmark;
import ru.siksmfp.serialization.harness.model.cofler.User;
import ru.siksmfp.serialization.harness.state.impl.CoflerUserState;

public class CoflerBenchmark extends ParentBenchmark<CoflerUserState, User> {

    @Benchmark
    @Override
    protected byte[] serializationBenchmark(CoflerUserState state) {
        byte[] bytes = new byte[1024];
        state.user.marshal(bytes, 0);
        return bytes;
    }

    @Benchmark
    @Override
    protected User deSerializationBenchmark(CoflerUserState state) {
        User user = new User();
        user.unmarshal(state.serializedUser, 0);
        return user;
    }
}