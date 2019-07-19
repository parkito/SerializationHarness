package ru.siksmfp.serialization.harness.banchmark.impl;

import org.capnproto.ArrayInputStream;
import org.capnproto.ArrayOutputStream;
import org.capnproto.Serialize;
import org.openjdk.jmh.annotations.Benchmark;
import ru.siksmfp.serialization.harness.banchmark.api.ParentBenchmark;
import ru.siksmfp.serialization.harness.model.capnp.UserModel;
import ru.siksmfp.serialization.harness.model.standart.User;
import ru.siksmfp.serialization.harness.serializetion.api.Serializer;
import ru.siksmfp.serialization.harness.serializetion.impl.CapnprotoSerializer;
import ru.siksmfp.serialization.harness.state.impl.CapnprotoUserState;
import ru.siksmfp.serialization.harness.state.impl.InputUserState;

import java.io.IOException;
import java.nio.ByteBuffer;

public class CapnprotoBenchmark extends ParentBenchmark<CapnprotoUserState> {

    private Serializer<User> serializer = new CapnprotoSerializer();

    @Benchmark
    @Override
    public byte[] serializationBenchmark(InputUserState state) {
        return serializer.serialize(state.getInputObject());
    }

    @Benchmark
    @Override
    public User deSerializationBenchmark(CapnprotoUserState state) {
        return serializer.deSerialize(state.getOutputObject());
    }

    public static void main(String[] args) {
        CapnprotoUserState state = new CapnprotoUserState();
        state.setUp();
        try (ArrayOutputStream os = new ArrayOutputStream(ByteBuffer.allocate(1024))) {
            Serialize.write(os, state.getInputObject());
            System.out.println(Serialize.read(new ArrayInputStream(ByteBuffer.wrap(os.getWriteBuffer().array())))
                    .getRoot(UserModel.User.factory).getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

//java 8
//    Benchmark                                    Mode  Cnt    Score    Error  Units
//    CapnprotoBenchmark.deSerializationBenchmark  avgt   10  139.210 ± 24.013  ns/op
//    CapnprotoBenchmark.serializationBenchmark    avgt   10  140.925 ± 17.287  ns/op

