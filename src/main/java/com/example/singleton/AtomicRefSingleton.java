package com.example.singleton;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReference;

public final class AtomicRefSingleton implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final AtomicReference<AtomicRefSingleton> REF = new AtomicReference<>();

    private AtomicRefSingleton() {}

    public static AtomicRefSingleton getInstance() {
        AtomicRefSingleton current = REF.get();
        if (current != null) return current;
        AtomicRefSingleton newInst = new AtomicRefSingleton();
        if (REF.compareAndSet(null, newInst)) {
            return newInst;
        } else {
            return REF.get();
        }
    }

    private Object readResolve() {
        return getInstance();
    }
}
