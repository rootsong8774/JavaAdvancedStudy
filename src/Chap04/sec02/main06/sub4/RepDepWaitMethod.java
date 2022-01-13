package Chap04.sec02.main06.sub4;

public class RepDepWaitMethod {

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

            thread1.threadSuspend();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread2 - thread1.resume() 이후 2초간 대기");
            thread1.threadResume();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("thread2 - thread1.stop()");
            thread1.threadStop();

            System.out.println("thread2 종료");


        });
        thread2.start();
    }

    public static class MyThread extends Thread {

        boolean suspend = false;
        boolean stop = false;

        @Override
        public void run() {
            int count = 0;
            while (!stop) {
                System.out.println("thread1 작업 중");
                try {
                    Thread.sleep(800);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (suspend) {
                    synchronized (this) {
                        try {
                            wait();
                        } catch (InterruptedException e) {

                        }
                    }
                }
                System.out.println("thread1 [" + (++count) + "]");
            }
        }

        public void threadStop() {
            stop = true;
        }
        public void threadSuspend() {
            suspend = true;
        }
        public void threadResume() {
            suspend = false;
            interrupt();
        }
    }

}
