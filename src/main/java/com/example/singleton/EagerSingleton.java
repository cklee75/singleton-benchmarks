package com.example.singleton;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicBoolean;

public final class EagerSingleton implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final AtomicBoolean created = new AtomicBoolean(false);

    private static final EagerSingleton INSTANCE = new EagerSingleton();

    private EagerSingleton() {
        if (!created.compareAndSet(false, true)) {
            throw new IllegalStateException("Instance already created");
        }
    }

    public static EagerSingleton getInstance() {
        return INSTANCE;
    }

    private Object readResolve() {
        return getInstance();
    }
}
