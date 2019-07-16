package ru.siksmfp.serialization.harness.state.impl;

import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import ru.siksmfp.serialization.harness.model.standart.Address;
import ru.siksmfp.serialization.harness.model.standart.User;
import ru.siksmfp.serialization.harness.state.api.BenchmarkState;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;

import static ru.siksmfp.serialization.harness.state.StateConstant.ID_1;
import static ru.siksmfp.serialization.harness.state.StateConstant.ID_2;
import static ru.siksmfp.serialization.harness.state.StateConstant.ID_3;
import static ru.siksmfp.serialization.harness.state.StateConstant.ID_4;
import static ru.siksmfp.serialization.harness.state.StateConstant.ID_5;

@State(Scope.Benchmark)
public class StandardUserState implements BenchmarkState {

    public User user;
    public byte[] serializedUser;

    @Setup(Level.Trial)
    @Override
    public void setUp() {
        Address address1 = new Address(ID_1, "Moscow", 15_000_000);
        Address address2 = new Address(ID_2, "SPB", 5_000_000);
        Address address3 = new Address(ID_3, "Dzerzhinsk", 250_000);
        Address address4 = new Address(ID_4, "Vladivastok", 1_000_000);
        Address address5 = new Address(ID_5, "Tokio", 30_000_000);

        User user = new User();
        user.setId(ID_1);
        user.setName("name");
        user.setAddresses(Arrays.asList(address1, address2, address3, address4, address4, address5));
        user.setSignature("longUniqGoodUserSignatureForSecurity".getBytes());

        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutputStream out = new ObjectOutputStream(bos)) {
            out.writeObject(user);
            out.flush();
            serializedUser = bos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalStateException("Incorrect serialization process");
        }
    }
}