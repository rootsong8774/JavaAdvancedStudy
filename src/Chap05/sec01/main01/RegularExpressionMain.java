package Chap05.sec01.main01;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionMain {

    public static void main(String[] args) {
        String str = "한글연습1234";

        boolean matches = str.matches("^[가-힣]+[0-9]+$");
        System.out.println("전체검색= "+matches);

        boolean matches2 = str.matches("[가-힣]+");
        System.out.println("부분검색= "+matches2);

        Matcher matcher = Pattern.compile("[가-힣]+").matcher(str);
        while(matcher.find()) {
            System.out.println("추출문자= "+matcher.group());
        }
    }

}
