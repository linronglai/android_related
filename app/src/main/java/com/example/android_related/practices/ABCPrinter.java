package com.example.android_related.practices;

public class ABCPrinter implements Runnable {
    static int count = 1;
    private final int threadId;

    public ABCPrinter(int id) {
        threadId = id;
    }
    @Override
    public void run() {
        while(true) {
            synchronized (ABCPrinter.class) {
                if (count >= 100) {
                    break;
                }
                if (count % 3 == threadId) {
                    System.out.println(count);
                    count++;
                }
            }
        }
    }
}
