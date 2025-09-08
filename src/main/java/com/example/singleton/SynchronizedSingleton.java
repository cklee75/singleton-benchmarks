package com.example.singleton;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicBoolean;

public final class SynchronizedSingleton implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final AtomicBoolean created = new AtomicBoolean(false);

    private static SynchronizedSingleton instance;

    private SynchronizedSingleton() {
        if (!created.compareAndSet(false, true)) {
            throw new IllegalStateException("Instance already created");
        }
    }

    public static synchronized SynchronizedSingleton getInstance() {
        if (instance == null) {
            instance = new SynchronizedSingleton();
        }
        return instance;
    }

    private Object readResolve() {
        return getInstance();
    }
}
