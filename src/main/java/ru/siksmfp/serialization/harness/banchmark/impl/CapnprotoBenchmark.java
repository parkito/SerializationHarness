package ru.siksmfp.serialization.harness.banchmark.impl;

import org.capnproto.ArrayInputStream;
import org.capnproto.ArrayOutputStream;
import org.capnproto.MessageReader;
import org.capnproto.Serialize;
import org.capnproto.StructReader;
import org.openjdk.jmh.annotations.Benchmark;
import ru.siksmfp.serialization.harness.banchmark.api.ParentBenchmark;
import ru.siksmfp.serialization.harness.model.capnp.UserModel;
import ru.siksmfp.serialization.harness.state.impl.CapnprotoUserState;

import java.io.IOException;
import java.nio.ByteBuffer;

public class CapnprotoBenchmark extends ParentBenchmark<CapnprotoUserState, StructReader> {

    @Benchmark
    @Override
    public byte[] serializationBenchmark(CapnprotoUserState state) {
        try (ArrayOutputStream os = new ArrayOutputStream(ByteBuffer.allocate(1024))) {
            Serialize.write(os, state.getInputObject());
            return os.getWriteBuffer().array();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Benchmark
    @Override
    public UserModel.User.Reader deSerializationBenchmark(CapnprotoUserState state) {
        try {
            MessageReader read = Serialize.read(new ArrayInputStream(ByteBuffer.wrap(state.getOutputObject().array())));
            return read.getRoot(UserModel.User.factory);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

//java 8
//    Benchmark                                    Mode  Cnt    Score    Error  Units
//    CapnprotoBenchmark.deSerializationBenchmark  avgt   10  139.210 ± 24.013  ns/op
//    CapnprotoBenchmark.serializationBenchmark    avgt   10  140.925 ± 17.287  ns/op

