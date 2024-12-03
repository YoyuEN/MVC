package com.yoyuen.springmvc;
import java.util.concurrent.atomic.AtomicInteger;

public class SequenceGenerator {
    private static final AtomicInteger seq = new AtomicInteger(0);

    public static int getNextSequence() {
        return seq.incrementAndGet();
    }
}
