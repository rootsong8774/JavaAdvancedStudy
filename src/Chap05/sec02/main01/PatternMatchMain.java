package Chap05.sec02.main01;

public class PatternMatchMain {

    public static void main(String[] args) {
        System.out.println("1. Matches() 함수의 사용");
        String str1 = "A001_아메리카노_4000";

        boolean matches1 = str1.matches("A001_아메리카노_4000");
        boolean matches2 = str1.matches("[A-z][0-9]{3}_[가-힣]+_[1-9][0-9]+");
        boolean matches3 = str1.matches("(\\w|[가-힣])+");
        boolean matches4 = str1.matches("[A-z0-9]+");

        System.out.println("\tmatches1=" + matches1);
        System.out.println("\tmatches2=" + matches2);
        System.out.println("\tmatches3=" + matches3);
        System.out.println("\tmatches4=" + matches4);

        System.out.println("2.split() 함수의 사용");

        String str2 = "a1     a2 a3";
        String[] split = str2.split("\\s+");
        int index = 0;
        for (String s : split) {
            System.out.println("\tsplit() : [" + (index++) + "]=" + s);
        }

        System.out.println("3. replaceAll(), replaceFirst() 함수의 사용");

        String str3 = str2.replaceAll("\\s+", " ");
        System.out.println("\t공백의 처리 - 1개 이상을 1개로 변환 str3 =:" + str3);

        String str4 = "12AB 34CD";
        System.out.println("\t변경전 str4 =" + str4);
        String str5 = str4.replaceAll("([0-9]+)([A-z]+)", "$2-$1");
        System.out.println("\treplaceAll : str5= " + str5);
        String str6 = str4.replaceFirst("([0-9]+)([A-z]+)", "$2-$1");
        System.out.println("\treplaceFirst : str6= " + str6);
    }

}
