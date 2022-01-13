package Chap04.sec03.main01;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolMain {

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(3);

        Runnable r1 = new MyRunnable("Thread - 1");
        Runnable r2 = new MyRunnable("Thread - 2");

        Callable<String> c1 = new MyCallable("Thread - 3");
        Callable<String> c2 = new MyCallable("Thread - 4");

        pool.execute(r1);

        Future<?> submit = pool.submit(r2);
        Future<String> submit2 = pool.submit(c1);
        Future<String> submit3 = pool.submit(c2);

        System.out.println("Thread terminated");
    }

    public static class MyRunnable implements Runnable{
        private final String name;

        public MyRunnable(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            for(int i = 0; i<3 ; i++){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(name + "\t: "+i);
            }
        }
    }

    public static class MyCallable implements Callable<String>{
        private final String name;

        public MyCallable(String name) {
            this.name = name;
        }

        @Override
        public String call()  {
            for(int i = 0; i<3; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(name + "\t: "+i);

            }
            return null;
        }
    }

}
