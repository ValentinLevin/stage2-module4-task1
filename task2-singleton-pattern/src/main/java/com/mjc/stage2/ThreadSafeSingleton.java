package com.mjc.stage2;

public class ThreadSafeSingleton {
    private static ThreadSafeSingleton instance = null;

    private ThreadSafeSingleton() {}

    public static ThreadSafeSingleton getInstance() {
        if (instance != null) {
            return instance;
        }
        synchronized(ThreadSafeSingleton.class) {
            if (instance == null) {
                instance = new ThreadSafeSingleton();
            }
            return instance;
        }
    }
}
