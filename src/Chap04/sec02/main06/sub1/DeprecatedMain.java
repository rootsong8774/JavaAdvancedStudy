package Chap04.sec02.main06.sub1;

public class DeprecatedMain {

    public static void main(String[] args) {
        final MyThread thread1 = new MyThread();
        thread1.start();

        Thread thread2 = new Thread(() -> {
            System.out.println("thread2 2초간 대기");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {

            }
            System.out.println("thread2 - thread1.suspend() 이후 2초간 대기");

            thread1.suspend();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread2 - thread1.resume() 이후 2초간 대기");
            thread1.resume();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("thread2 - thread1.stop()");
            thread1.stop();

            System.out.println("thread2 종료");


        });
        thread2.start();
    }

    public static class MyThread extends Thread {

        @Override
        public void run() {
            int count =0;
            while (true){
                System.out.println("thread 작업 중");
                try {
                    Thread.sleep(800);
                } catch (InterruptedException e) {

                }
                System.out.println("thread1 ["+(++count)+"]");
            }
        }
    }
}
