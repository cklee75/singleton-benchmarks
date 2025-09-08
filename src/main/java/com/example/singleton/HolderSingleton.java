package com.example.singleton;

import java.io.Serializable;

public final class HolderSingleton implements Serializable {
    private static final long serialVersionUID = 1L;

    private HolderSingleton() {
        if (Holder.INSTANCE != null) {
            throw new IllegalStateException("Instance already created");
        }
    }

    private static class Holder {
        static final HolderSingleton INSTANCE = new HolderSingleton();
    }

    public static HolderSingleton getInstance() {
        return Holder.INSTANCE;
    }

    private Object readResolve() {
        return getInstance();
    }
}
