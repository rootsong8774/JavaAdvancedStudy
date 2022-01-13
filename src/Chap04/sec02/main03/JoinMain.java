package Chap04.sec02.main03;

public class JoinMain {

    public static void main(String[] args) {
        Thread thread1 = new MyThread("thread1", 3);
        Thread thread2 = new MyThread("thread2", 3);
        Thread thread3 = new MyThread("thread3", 3);
        Thread thread4 = new MyThread("thread4", 3);

        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread3.start();
        try {
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread4.start();

    }

    public static class MyThread extends Thread {

        private final int count;

        public MyThread(String name, int count) {
            this.count = count;
            this.setName(name);
        }

        public void run() {
            Thread thread = Thread.currentThread();
            for (int i = 0; i < count; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(thread.getName() + "[" + (i + 1) + "]");
            }
        }
    }
}
