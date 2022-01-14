package Chap05.sec02.main02;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternAndMatcherMain {

    public static void main(String[] args) {
        String str = "a001가 a002나 a003다 가나다";

        Matcher matcher = Pattern.compile("([a])([0-9]+)").matcher(str);
        print("그룹 수", matcher.groupCount());
        System.out.println("-----------------------------");

        while (matcher.find()) {
            print("패턴검색 전체--------> ", matcher.group());
            print("패턴검색 검색1", matcher.group(1));
            print("패턴검색 검색2", matcher.group(2));
        }

        matcher.reset();
        System.out.println("-----------------------------");
        while (matcher.find()) {
            String msg = "전체 검색 값 = "+matcher.group();
            msg +=" ["+matcher.start();
            msg +=" ~ "+matcher.end()+"]";
            System.out.println(msg);
        }

        matcher.reset();
        System.out.println("-----------------------------");
        while (matcher.find()) {
            String msg = "그룹1 검색 값 = "+matcher.group(1);
            msg +=" ("+matcher.start(1);
            msg +=" ~ "+matcher.end(1)+")";
            String msg2 = "그룹1 검색 값 = "+matcher.group(2);
            msg2 +=" ("+matcher.start(2);
            msg2 +=" ~ "+matcher.end(2)+")";

            System.out.println(msg);
            System.out.println(msg2);
        }



    }

    public static void print(String title, Object value) {
        System.out.println(title + "[" + value + "]");
    }

}
