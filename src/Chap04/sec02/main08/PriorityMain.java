package Chap04.sec02.main08;

public class PriorityMain {

    public static class MyThread extends Thread {

        boolean available = true;
        boolean stop = false;

        public MyThread(int priority) {
            this.setPriority(priority);
        }

        public void setAvailable(boolean available) {
            this.available = available;
        }

        public void setStop(boolean stop) {
            this.stop = stop;
        }

        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            int count = 0;

            while(!stop) {
                if(available) {
                    System.out.println(name + " Thread 실행["+(++count)+"]");
                } else {
                    System.out.println(name + " Yield() 실행["+(++count)+"]");
                    Thread.yield();
                }
            }
        }
    }

    public static void main(String[] args) {
        MyThread t1 = new MyThread(1);
        MyThread t2 = new MyThread(5);
        MyThread t3 = new MyThread(10);

        t1.setName("Thread-1");
        t2.setName("Thread-2");
        t3.setName("Thread-3");


        t1.start();
        t2.start();
        t3.start();



        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {

        }

        t1.setStop(true);
        t2.setStop(true);
        t3.setStop(true);

    }
}
