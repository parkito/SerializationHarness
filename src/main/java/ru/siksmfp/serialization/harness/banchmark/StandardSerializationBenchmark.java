package ru.siksmfp.serialization.harness.banchmark;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import ru.siksmfp.serialization.harness.model.User;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class StandardSerializationBenchmark extends ParentBenchmark {

//    @Benchmark
//    @BenchmarkMode(Mode.All)
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
//    @BenchmarkMode(Mode.All)
    public User deSerializationBenchmark(UserState state) {
        try (ByteArrayInputStream bis = new ByteArrayInputStream(state.serializedUser);
             ObjectInput in = new ObjectInputStream(bis)) {
            return (User) in.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new IllegalStateException("Incorrect de-serialization process");
        }
    }
}
