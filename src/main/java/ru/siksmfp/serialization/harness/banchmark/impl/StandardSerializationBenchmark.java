package ru.siksmfp.serialization.harness.banchmark.impl;

import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import ru.siksmfp.serialization.harness.banchmark.api.ParentBenchmark;
import ru.siksmfp.serialization.harness.model.Address;
import ru.siksmfp.serialization.harness.model.User;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class StandardSerializationBenchmark extends ParentBenchmark {

    @State(Scope.Benchmark)
    public static class StandardUserState {
        public User user;
        public byte[] serializedUser;

        @Setup(Level.Trial)
        public void setUp() {
            Address address1 = new Address(1L, "Moscow", 15_000_000);
            Address address2 = new Address(3L, "SPB", 5_000_000);
            Address address3 = new Address(4L, "Dzerzhinsk", 250_000);
            Address address4 = new Address(5L, "Vladivastok", 1_000_000);
            Address address5 = new Address(6L, "Tokio", 30_000_000);

            User user = new User();
            user.setId(100L);
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

    //    @Benchmark
    public byte[] serializationBenchmark(StandardUserState state) {
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutputStream out = new ObjectOutputStream(bos)) {
            out.writeObject(state.user);
            out.flush();
            return bos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalStateException("Incorrect serialization process");
        }
    }

    //    @Benchmark
    public User deSerializationBenchmark(StandardUserState state) {
        try (ByteArrayInputStream bis = new ByteArrayInputStream(state.serializedUser);
             ObjectInput in = new ObjectInputStream(bis)) {
            return (User) in.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new IllegalStateException("Incorrect de-serialization process");
        }
    }


//    java 8

//    Benchmark                                                Mode  Cnt      Score      Error  Units
//    StandardSerializationBenchmark.deSerializationBenchmark  avgt   10  22148.122 ± 3252.490  ns/op
//    StandardSerializationBenchmark.serializationBenchmark    avgt   10   4313.692 ±  446.117  ns/op

    //java11
//    StandardSerializationBenchmark.deSerializationBenchmark  avgt   10  25613.718 ± 5648.547  ns/op
//    StandardSerializationBenchmark.serializationBenchmark    avgt   10   4483.647 ±  926.454  ns/op

}
