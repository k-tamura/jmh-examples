package org.t246osslab.sample.jmh;

import org.openjdk.jmh.annotations.Benchmark;

import java.io.IOException;
import java.util.logging.*;

public class MyBenchmark {
    static Logger logger = Logger.getLogger(MyBenchmark.class.getName());

    static {
        try {
            logger.setLevel(Level.INFO);
            Handler handler = new FileHandler("test.log");
            logger.addHandler(handler);
            Formatter formatter = new SimpleFormatter();
            handler.setFormatter(formatter);
            logger.setUseParentHandlers(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Benchmark
    public void testMethod() {
        if (logger.isLoggable(Level.INFO)) {
            logger.info("Logger is " + logger.getLevel() + " level.");
        }
    }

    @Benchmark
    public void testMethod2() {
        logger.info("Logger is " + logger.getLevel() + " level.");
    }
}
