# Singleton Benchmarks (Java)

This Maven project contains several singleton implementations and two ways to benchmark them:

- `SimpleSingletonBenchmark` — a lightweight `System.nanoTime()` harness for quick checks.
- `SingletonJmhBenchmark` — a proper JMH microbenchmark.

## Build

Requires a JDK (1.8+) and Maven.

To compile:
```
mvn -q compile
```

To run the quick harness:
```
# run compiled classes (no special jar)
java -cp target/classes com.example.singleton.SimpleSingletonBenchmark
```

To run the JMH benchmarks (builds a shaded jar named `benchmarks.jar` in `target/`):
```
mvn -DskipTests package
java -jar target/benchmarks.jar
```

Notes:
- JMH is the recommended way to get reliable microbenchmarks.
- The simple harness is useful for quick, approximate comparisons. Results will vary with JVM, CPU, and environment.
