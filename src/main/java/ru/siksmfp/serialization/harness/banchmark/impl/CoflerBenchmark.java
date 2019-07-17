package ru.siksmfp.serialization.harness.banchmark.impl;

import org.openjdk.jmh.annotations.Benchmark;
import ru.siksmfp.serialization.harness.banchmark.api.ParentBenchmark;
import ru.siksmfp.serialization.harness.model.cofler.User;
import ru.siksmfp.serialization.harness.state.impl.CoflerUserState;

public class CoflerBenchmark extends ParentBenchmark<CoflerUserState, User> {

    @Benchmark
    @Override
    public byte[] serializationBenchmark(CoflerUserState state) {
        byte[] bytes = new byte[1024];
        state.user.marshal(bytes, 0);
        return bytes;
    }

    @Benchmark
    @Override
    public User deSerializationBenchmark(CoflerUserState state) {
        User user = new User();
        user.unmarshal(state.serializedUser, 0);
        return user;
    }

    //java 8

//    Benchmark                                 Mode  Cnt    Score     Error  Units
//    CoflerBenchmark.deSerializationBenchmark  avgt   10  285.095 ±  84.780  ns/op
//    CoflerBenchmark.serializationBenchmark    avgt   10  539.067 ± 243.713  ns/op
}