package Chap02.sec03.main01;

public class LambdaMain {

    private int operate(int x, int y, Math math) {
        return math.operation(x, y);
    }

    interface Math {

        int operation(int x, int y);
    }

    interface Echo {

        void echo(String msg);
    }

    interface Process {

        void echo();
    }

    public static void main(String[] args) {
        LambdaMain lambdaMain = new LambdaMain();
        /*Math add = new Math() {
            @Override
            public int operation(int x, int y) {
                return x + y;
            }
        };*/
        Math add = (x, y) -> x + y;
        Math sub = (x, y) -> x - y;
        Math mul = (x, y) -> x * y;
        Math div = (x, y) -> x / y;
        System.out.println("20 + 5 = "+ lambdaMain.operate(20, 5, add));

        Echo msg1 = msg -> System.out.println(msg);
        Process msg2 =  () -> System.out.println("Hello");
        msg1.echo("AAAA");
        msg2.echo();


    }

}
