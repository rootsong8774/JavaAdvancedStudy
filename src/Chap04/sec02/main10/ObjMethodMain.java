package Chap04.sec02.main10;

import java.util.ArrayList;
import java.util.List;

public class ObjMethodMain {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        Thread t1 = new Thread(() -> {
            while (true) {
                synchronized (list) {
                    System.out.println("Thread 1 wait");

                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Thread 1 Executed");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            while (true) {
                synchronized (list) {
                    System.out.println("Thread 2 wait");

                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Thread 2 Executed");
                }
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (list) {
                list.notifyAll();
            }

        });

        t1.start();
        t2.start();
        t3.start();


    }

}
