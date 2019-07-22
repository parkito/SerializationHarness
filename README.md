# Java Serialization Harness
#### Performance testing of Java serialization frameworks.

**Serialization** is the process of converting an object into a stream of bytes.
Almost all systems today use serialization as way of communication.

There are lot of Java frameworks aimed to make serialization faster.

This test suit benchmarks most popular of them.

### Current rating list

##### Environment:
     Model:                         MacBook Pro (15-inch, 2018)
     Processor Name:	        Intel Core i7
     Processor Speed:	        2,2 GHz
     Number of Processors:	        1
     Total Number of Cores:	        6
     L2 Cache (per Core):	        256 KB
     L3 Cache:	                9 MB
     Hyper-Threading Technology:	Enabled
     Memory                         16 GB 2400 MHz DDR4
 
1) Colfer (best)
2) SBE
3) FlatBuffers
4) Cap’n’Proto Java 
5) Java standart serialization mechanism (worst)

Current statistics (simple object serialization)

        Benchmark                                                Mode  Cnt      Score      Error  Units
        CoflerBenchmark.serializationBenchmark                   avgt   10    562.222 ±  118.964  ns/op
        CoflerBenchmark.deSerializationBenchmark                 avgt   10    582.123 ±  133.977  ns/op
        
        SbeBenchmark.serializationBenchmark                      avgt   10   1014.844 ±  118.201  ns/op
        SbeBenchmark.deSerializationBenchmark                    avgt   10    697.312 ±  240.313  ns/op
        
        FlatBufferBenchmark.serializationBenchmark               avgt   10   1242.209 ±  288.190  ns/op
        FlatBufferBenchmark.deSerializationBenchmark             avgt   10    966.860 ±  274.069  ns/op
        
        CapnprotoOptimizedBenchmark.serializationBenchmark       avgt   10   1998.041 ±  814.209  ns/op
        CapnprotoOptimizedBenchmark.deSerializationBenchmark     avgt   10   1383.317 ±  152.262  ns/op
        
        CapnprotoBenchmark.deSerializationBenchmark              avgt   10   1204.938 ±  254.563  ns/op
        CapnprotoBenchmark.serializationBenchmark                avgt   10   3721.140 ± 1410.057  ns/op
        
        CapnprotoPackedBenchmark.deSerializationBenchmark        avgt   10   2325.421 ±  646.966  ns/op
        CapnprotoPackedBenchmark.serializationBenchmark          avgt   10   4364.955 ± 1503.640  ns/op
        
        StandardSerializationBenchmark.deSerializationBenchmark  avgt   10  47852.448 ± 8796.435  ns/op
        StandardSerializationBenchmark.serializationBenchmark    avgt   10   9313.576 ±  957.115  ns/op


#### Test running

1) Build project using maven

`mvn clean install`

2) Run tests

`java -jar target/benchmarks.jar`

#### Adding custom tests

Tests use simple User object to benchmark serialization.
If you want to benchmark your own framework or a different object you may
include custom benchmark into existed test structure.

To include custom benchmark you should


1) Create your model in ru.siksmfp.serialization.harness.dto package