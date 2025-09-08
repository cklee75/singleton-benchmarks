package com.example.singleton;

import java.util.function.Supplier;

public class SimpleSingletonBenchmark {

    private static void bench(String name, Supplier<Object> supplier) {
        // warmup
        for (int i = 0; i < 200_000; i++) supplier.get();

        final int iters = 5;
        final int calls = 2_000_000;

        long totalTime = 0;
        for (int it = 0; it < iters; it++) {
            long t0 = System.nanoTime();
            for (int i = 0; i < calls; i++) {
                supplier.get();
            }
            long t1 = System.nanoTime();
            long elapsed = t1 - t0;
            totalTime += elapsed;
            System.out.printf("%s - iter %d: average ns/call = %.2f%n",
                name, it, (double) elapsed / calls);
            // short pause
            try { Thread.sleep(100); } catch (InterruptedException ignored) {}
        }
        System.out.printf("%s - overall avg ns/call = %.2f%n",
                name, (double) totalTime / (iters * calls));
    }

    public static void main(String[] args) {
        bench("Eager", () -> EagerSingleton.getInstance());
        bench("Synchronized", () -> SynchronizedSingleton.getInstance());
        bench("DCL", () -> DCLSingleton.getInstance());
        bench("Holder", () -> HolderSingleton.getInstance());
        bench("Enum", () -> EnumSingleton.INSTANCE);
        bench("AtomicRef", () -> AtomicRefSingleton.getInstance());
    }
}
