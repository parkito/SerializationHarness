package ru.siksmfp.serialization.harness.banchmark;

import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import ru.siksmfp.serialization.harness.model.Address;
import ru.siksmfp.serialization.harness.model.User;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Fork(value = 2, jvmArgs = {"-Xms2G", "-Xmx2G"})
@Measurement(iterations = 5)
@Warmup(iterations = 5)
public abstract class ParentBenchmark {

    @State(Scope.Benchmark)
    public static class UserState {
        public User user;
        public byte[] serializedUser;

        @Setup(Level.Trial)
        public void setUp() {
            Address address1 = new Address(1L, "Moscow", 15_000_000);
            Address address2 = new Address(3L, "SPB", 5_000_000);
            Address address3 = new Address(4L, "Dzerzhinsk", 250_000);
            Address address4 = new Address(5L, "Vladivastok", 1_000_000);
            Address address5 = new Address(6L, "Tokio", 30_000_000);

            User newUser = new User();
            newUser.setId(100L);
            newUser.setName("name");
            newUser.setAddresses(Arrays.asList(address1, address2, address3, address4, address4, address5));
            newUser.setSignature("longUniqGoodUserSignatureForSecurity".getBytes());
            user = newUser;

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
}
