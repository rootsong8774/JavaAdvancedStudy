package Chap04.sec02.main04;

public class InterruptMain {

    public static void main(String[] args) {
        Thread thread = new MyThread();

        thread.start();

        try {
            Thread.sleep(3500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }

    public static class MyThread extends Thread{

        @Override
        public void run() {
            Thread thread = Thread.currentThread();
            int i=0;
            while (true) {

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    break;
                }

                System.out.println(thread.getName()+"["+(i+1)+"]");
                i++;
            }
            System.out.println("Logic Terminated");

        }

    }
}
