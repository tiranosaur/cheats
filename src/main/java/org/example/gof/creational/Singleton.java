package org.example.gof.creational;

import lombok.*;

public class Singleton {
    public static void main(String[] args) {
        System.out.println(SimpliestSingleton.instance.equals(SimpliestSingleton.instance));

        DoubleCheckedSingleton singleton1 = DoubleCheckedSingleton.getInstance();
        DoubleCheckedSingleton singleton2 = DoubleCheckedSingleton.getInstance();
        System.out.println(singleton1.equals(singleton2));
    }
}

@Getter
enum SimpliestSingleton {
    instance;
    private String level;
}

class SimpleSingleton {
    public static SimpleSingleton instance = new SimpleSingleton();
}

class SynchronizedSingleton {
    private static SynchronizedSingleton instance;

    private SynchronizedSingleton() {
    }

    public synchronized static SynchronizedSingleton getInstance() {
        if (instance == null) {
            instance = new SynchronizedSingleton();
        }
        return instance;
    }
}

class DoubleCheckedSingleton {
    private volatile static DoubleCheckedSingleton instance;

    private DoubleCheckedSingleton() {
    }

    public static DoubleCheckedSingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckedSingleton.class) {
                if (instance == null) {
                    instance = new DoubleCheckedSingleton();
                }
            }
        }
        return instance;
    }
}