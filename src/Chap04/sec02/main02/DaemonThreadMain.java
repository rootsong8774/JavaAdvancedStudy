package Chap04.sec02.main02;

public class DaemonThreadMain {

    public static void main(String[] args) {
        Thread thread1 =new Thread("thread1") {
            @Override
            public void run() {
                print(6);
            }
        };
        thread1.setDaemon(true);
        thread1.start();
        print(1);

    }

    public static void print(int count) {
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
