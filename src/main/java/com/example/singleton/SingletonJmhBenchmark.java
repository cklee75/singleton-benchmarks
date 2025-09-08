package com.example.singleton;

import org.openjdk.jmh.annotations.*;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(2)
public class SingletonJmhBenchmark {

    @Benchmark
    public Object eager() {
        return EagerSingleton.getInstance();
    }

    @Benchmark
    public Object synchronizedMethod() {
        return SynchronizedSingleton.getInstance();
    }

    @Benchmark
    public Object dcl() {
        return DCLSingleton.getInstance();
    }

    @Benchmark
    public Object holder() {
        return HolderSingleton.getInstance();
    }

    @Benchmark
    public Object enumSingleton() {
        return EnumSingleton.INSTANCE;
    }

    @Benchmark
    public Object atomicRef() {
        return AtomicRefSingleton.getInstance();
    }
}
