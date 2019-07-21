package ru.siksmfp.serialization.harness;

public class Main {

    //run all benchmarks
    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(args);
    }
}


//        CapnprotoBenchmark.deSerializationBenchmark              avgt   10   1204.938 ±  254.563  ns/op
//        CapnprotoBenchmark.serializationBenchmark                avgt   10   3721.140 ± 1410.057  ns/op
//        CapnprotoOptimizedBenchmark.deSerializationBenchmark     avgt   10   1383.317 ±  152.262  ns/op
//        CapnprotoOptimizedBenchmark.serializationBenchmark       avgt   10   1998.041 ±  814.209  ns/op
//        CapnprotoPackedBenchmark.deSerializationBenchmark        avgt   10   2325.421 ±  646.966  ns/op
//        CapnprotoPackedBenchmark.serializationBenchmark          avgt   10   4364.955 ± 1503.640  ns/op
//        CoflerBenchmark.deSerializationBenchmark                 avgt   10    582.123 ±  133.977  ns/op
//        CoflerBenchmark.serializationBenchmark                   avgt   10    562.222 ±  118.964  ns/op
//        FlatBufferBenchmark.deSerializationBenchmark             avgt   10    966.860 ±  274.069  ns/op
//        FlatBufferBenchmark.serializationBenchmark               avgt   10   1242.209 ±  288.190  ns/op
//        SbeBenchmark.deSerializationBenchmark                    avgt   10    697.312 ±  240.313  ns/op
//        SbeBenchmark.serializationBenchmark                      avgt   10   1014.844 ±  118.201  ns/op
//        StandardSerializationBenchmark.deSerializationBenchmark  avgt   10  47852.448 ± 8796.435  ns/op
//        StandardSerializationBenchmark.serializationBenchmark    avgt   10   9313.576 ±  957.115  ns/op

