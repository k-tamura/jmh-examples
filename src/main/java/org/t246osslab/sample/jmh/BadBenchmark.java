package org.t246osslab.sample.jmh;

import java.io.IOException;
import java.util.logging.*;

public class BadBenchmark {
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

    public static void main(String[] args) {

        int MAX_LOOP_COUNT = 1000;
        System.out.println(MAX_LOOP_COUNT + "回実行した処理時間の比較（単位：ミリ秒）");
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < MAX_LOOP_COUNT; i++) {
            if (logger.isLoggable(Level.INFO))
                logger.info("Logger is " + logger.getLevel() + " level.");
        }
        System.out.println("1つ目: " + (System.currentTimeMillis() - startTime));

        startTime = System.currentTimeMillis();
        for (int i = 0; i < MAX_LOOP_COUNT; i++) {
            logger.info("Logger is " + logger.getLevel() + " level.");
        }
        System.out.println("2つ目: " + (System.currentTimeMillis() - startTime));
    }
}
