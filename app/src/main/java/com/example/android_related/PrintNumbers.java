package com.example.android_related;

public class PrintNumbers {
    private static final Object lock = new Object();
    private static int count = 1;  // 从 1 开始
    private static final int MAX = 100;

    public static class PrintTaskV2 implements Runnable {
        private int threadId;

        public PrintTaskV2(int threadId) {
            this.threadId = threadId;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    // 判断当前数字是否可以由该线程打印
                    if (count > MAX) {
                        break;  // 打印完成，退出
                    }
                    // 判断是否该线程打印
                    if (count % 3 == threadId % 3) {
                        System.out.print(count + " ");
                        count++;
                    }
                }
            }
        }
    }
}
