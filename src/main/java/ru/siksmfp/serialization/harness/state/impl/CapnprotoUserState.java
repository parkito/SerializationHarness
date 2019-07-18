package ru.siksmfp.serialization.harness.state.impl;

import org.capnproto.ArrayOutputStream;
import org.capnproto.MessageBuilder;
import org.capnproto.Serialize;
import org.capnproto.StructList;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import ru.siksmfp.serialization.harness.model.capnp.UserModel;
import ru.siksmfp.serialization.harness.state.api.BenchmarkState;

import java.io.IOException;
import java.nio.ByteBuffer;

import static ru.siksmfp.serialization.harness.state.StateConstant.DZRERZHINSK_CITY;
import static ru.siksmfp.serialization.harness.state.StateConstant.DZRERZHINSK_POPULATION;
import static ru.siksmfp.serialization.harness.state.StateConstant.ID_1;
import static ru.siksmfp.serialization.harness.state.StateConstant.ID_2;
import static ru.siksmfp.serialization.harness.state.StateConstant.ID_3;
import static ru.siksmfp.serialization.harness.state.StateConstant.ID_4;
import static ru.siksmfp.serialization.harness.state.StateConstant.ID_5;
import static ru.siksmfp.serialization.harness.state.StateConstant.MOSCOW_CITY;
import static ru.siksmfp.serialization.harness.state.StateConstant.MOSCOW_POPULATION;
import static ru.siksmfp.serialization.harness.state.StateConstant.NAME;
import static ru.siksmfp.serialization.harness.state.StateConstant.SIGNATURE;
import static ru.siksmfp.serialization.harness.state.StateConstant.SPB_CITY;
import static ru.siksmfp.serialization.harness.state.StateConstant.SPB_POPULATION;
import static ru.siksmfp.serialization.harness.state.StateConstant.TOKIO_CITY;
import static ru.siksmfp.serialization.harness.state.StateConstant.TOKIO_POPULATION;
import static ru.siksmfp.serialization.harness.state.StateConstant.VLADIVASTOK_CITY;
import static ru.siksmfp.serialization.harness.state.StateConstant.VLADIVASTOK_POPULATION;

@State(Scope.Benchmark)
public class CapnprotoUserState implements BenchmarkState<MessageBuilder, ByteBuffer> {

    private MessageBuilder user;
    private ByteBuffer serializedUser;

    @Override
    public MessageBuilder getInputObject() {
        return user;
    }

    @Override
    public ByteBuffer getOutputObject() {
        return serializedUser;
    }

    @Setup(Level.Trial)
    @Override
    public void setUp() {
        user = new MessageBuilder();

        UserModel.User.Builder user = this.user.initRoot(UserModel.User.factory);
        user.setId(ID_1);
        user.setName(NAME);
        user.setSignature(SIGNATURE);

        StructList.Builder<UserModel.Address.Builder> addresses = user.initAddresses(5);

        UserModel.Address.Builder address1 = addresses.get(0);
        address1.setId(ID_1);
        address1.setCity(MOSCOW_CITY);
        address1.setPopulation(MOSCOW_POPULATION);

        UserModel.Address.Builder address2 = addresses.get(1);
        address2.setId(ID_2);
        address2.setCity(SPB_CITY);
        address2.setPopulation(SPB_POPULATION);

        UserModel.Address.Builder address3 = addresses.get(2);
        address3.setId(ID_3);
        address3.setCity(DZRERZHINSK_CITY);
        address3.setPopulation(DZRERZHINSK_POPULATION);

        UserModel.Address.Builder address4 = addresses.get(3);
        address4.setId(ID_4);
        address4.setCity(VLADIVASTOK_CITY);
        address4.setPopulation(VLADIVASTOK_POPULATION);

        UserModel.Address.Builder address5 = addresses.get(4);
        address5.setId(ID_5);
        address5.setCity(TOKIO_CITY);
        address5.setPopulation(TOKIO_POPULATION);

        try (ArrayOutputStream os = new ArrayOutputStream(ByteBuffer.allocate(1024))) {
            Serialize.write(os, this.user);
            serializedUser = os.getWriteBuffer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

