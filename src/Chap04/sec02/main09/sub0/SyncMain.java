package Chap04.sec02.main09.sub0;

import java.util.ArrayList;
import java.util.List;

public class SyncMain {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        Thread t1 = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    break;
                }
                synchronized (list) {
                    if (list.size() > 0) {
                        list.remove(list.size() - 1);
                    }
                }
            }
        });

        Thread t2 = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    break;
                }
                synchronized (list) {
                    int size = list.size();
                    if (size > 0) {
                        System.out.println(
                            "list size [" + list.size() + "]" + ", Last Value [" + list.get(
                                size - 1)
                                + "], list " + list);
                    }
                }
            }
        });

        Thread t3 = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    break;
                }
                synchronized (list) {
                    list.add(list.size());
                }
                if (!t1.isAlive() || !t2.isAlive()) {
                    t1.interrupt();
                    t2.interrupt();
                }
            }
        });
        t1.start();
        t2.start();
        t3.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.interrupt();
        t2.interrupt();
        t3.interrupt();
    }

}
