package Chap04.sec02.main05;

public class InterruptedMain {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            Thread t = Thread.currentThread();

            t.interrupt();
            System.out.println("1-1 isInterrupted() ="+t.isInterrupted());
            System.out.println("1-2 isInterrupted() ="+t.isInterrupted());
            System.out.println("1-3 interrupted() ="+Thread.interrupted());

            t.interrupt();
            System.out.println("2-1 interrupted() ="+Thread.interrupted());
            System.out.println("2-2 interrupted() ="+Thread.interrupted());
            System.out.println("2-3 isInterrupted() ="+t.isInterrupted());

            t.interrupt();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("3-1 isInterrupted() ="+t.isInterrupted());
                System.out.println("3-2 isInterrupted() ="+t.isInterrupted());
            }

            t.interrupt();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("4-1 interrupted() ="+Thread.interrupted());
                System.out.println("4-2 interrupted() ="+Thread.interrupted());
            }
        });
        thread.start();

        Thread thread2 = new Thread(){
            @Override
            public void run() {
                while (true) {
                    boolean interrupted = this.isInterrupted();
                    if(interrupted){

                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException e) {
                            System.out.println("5. isInterrupted(): InterruptedException 구간에서 break");
                            break;
                        }
                        System.out.println("5. isInterrupted() : Interrupted Exception 없이 break");
                        break;
                    }
                }
            }
        };

        thread2.start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread2.interrupt();

        Thread thread3 = new Thread() {
            @Override
            public void run() {
                while(true) {
                    boolean interrupted = this.interrupted();
                    if(interrupted){

                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException e) {
                            System.out.println("6. interrupted(): InterruptedException 구간에서 break");
                            break;
                        }
                        System.out.println("6. interrupted() : Interrupted Exception 없이 break");
                        break;
                    }
                }
            }
        };

        thread3.start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread3.interrupt();
    }
}
