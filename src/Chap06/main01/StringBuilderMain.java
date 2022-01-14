package Chap06.main01;

public class StringBuilderMain {

    public static void main(String[] args) {
        String str = "java study";
        StringBuilder sb = new StringBuilder("a");
        sb.append("b");
        sb.append(5);
        System.out.println(sb.append(str));
        sb.insert(3,"insrt String");
        System.out.println(sb);
        sb.delete(3,15);
        System.out.println(sb);
        sb.replace(3,7,"");
        System.out.println(sb);
        sb.setLength(0);
        System.out.println(sb+" : "+sb.length());


    }

}
