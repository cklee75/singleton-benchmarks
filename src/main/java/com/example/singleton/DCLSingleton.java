package com.example.singleton;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicBoolean;

public final class DCLSingleton implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final AtomicBoolean created = new AtomicBoolean(false);

    private static volatile DCLSingleton instance;

    private DCLSingleton() {
        if (!created.compareAndSet(false, true)) {
            throw new IllegalStateException("Instance already created");
        }
    }

    public static DCLSingleton getInstance() {
        if (instance == null) {
            synchronized (DCLSingleton.class) {
                if (instance == null) {
                    instance = new DCLSingleton();
                }
            }
        }
        return instance;
    }

    private Object readResolve() {
        return getInstance();
    }
}
