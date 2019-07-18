package ru.siksmfp.serialization.harness;

public class Main {

    //run all benchmarks
    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(args);
    }
}


//        Benchmark                                                Mode  Cnt      Score      Error  Units
//        CapnprotoBenchmark.deSerializationBenchmark              avgt   10    130.823 ±   30.060  ns/op
//        CapnprotoBenchmark.serializationBenchmark                avgt   10    145.487 ±   22.092  ns/op
//        CoflerBenchmark.deSerializationBenchmark                 avgt   10    271.117 ±   34.895  ns/op
//        CoflerBenchmark.serializationBenchmark                   avgt   10    184.792 ±   37.363  ns/op
//        FlatBufferBenchmark.deSerializationBenchmark             avgt   10    470.639 ±   42.592  ns/op
//        FlatBufferBenchmark.serializationBenchmark               avgt   10    208.432 ±   10.183  ns/op
//        SbeBenchmark.deSerializationBenchmark                    avgt   10    829.490 ±  104.786  ns/op
//        SbeBenchmark.serializationBenchmark                      avgt   10   1170.203 ±   47.437  ns/op
//        StandardSerializationBenchmark.deSerializationBenchmark  avgt   10  24733.463 ± 3909.145  ns/op
//        StandardSerializationBenchmark.serializationBenchmark    avgt   10   4570.557 ±  496.812  ns/op
