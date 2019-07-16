package ru.siksmfp.serialization.harness.banchmark;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import ru.siksmfp.serialization.harness.model.User;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class StandardSerializationBenchmark extends ParentBenchmark {

    @State(Scope.Benchmark)
    public static class StandardUserState {
        public byte[] serializedUser;

        @Setup(Level.Trial)
        public void setUp() {
            try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
                 ObjectOutputStream out = new ObjectOutputStream(bos)) {
                out.writeObject(ParentBenchmark.constructUser());
                out.flush();
                serializedUser = bos.toByteArray();
            } catch (IOException e) {
                e.printStackTrace();
                throw new IllegalStateException("Incorrect serialization process");
            }
        }
    }

//    @Benchmark
    public byte[] serializationBenchmark(UserState state) {
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
