package Chap04.sec02.main01;

import java.lang.Thread.State;

public class ThreadGroupMain {

    public static void main(String[] args) {
        ThreadGroup threadGroup = new ThreadGroup("threadGroup");

        Thread thread1 = new Thread(threadGroup, "thread1") {
            @Override
            public void run() {

                try {

                    Thread.sleep(1000);
                    print();


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        print();
        thread1.start();




    }

    public static void print(){
        Thread thread = Thread.currentThread();
        ThreadGroup threadGroup = thread.getThreadGroup();
        String groupName = threadGroup.getName();
        int activeCount = threadGroup.activeCount();
        int activeGroupCount = threadGroup.activeGroupCount();

        String name = thread.getName();
        int priority = thread.getPriority();
        State state = thread.getState();
        int activeCount2 = Thread.activeCount();

        System.out.println(name + "\t ThreadGroup groupName ["+ groupName +"]");
        System.out.println(name + "\t ThreadGroup activeCount ["+ activeCount +"]");
        System.out.println(name + "\t ThreadGroup activeGroupCount ["+ activeGroupCount +"]");

        System.out.println(name + "\t Thread name ["+ name +"]");
        System.out.println(name + "\t Thread priority ["+ priority +"]");
        System.out.println(name + "\t Thread state ["+ state +"]");
        System.out.println(name + "\t Thread activeCount2 ["+ activeCount2 +"]");

    }

}
