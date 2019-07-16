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

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Fork(value = 2, jvmArgs = {"-Xms2G", "-Xmx2G"})
@Measurement(iterations = 5)
@Warmup(iterations = 5)
public abstract class ParentBenchmark {

    public static User constructUser() {
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
        return user;
    }

    @State(Scope.Benchmark)
    public static class UserState {
        public User user;

        @Setup(Level.Trial)
        public void setUp() {
            user = constructUser();
        }
    }

}
