package Chap05.sec02.main03;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadAndMatcherMain {

    public static void main(String[] args) throws IOException {
        String str = readFile(ReadAndMatcherMain.class,1);

        System.out.println("==============================================");

        String pattern = "new\\s+([^(\\[]+)([(\\[])";
        Matcher matcher = Pattern.compile(pattern).matcher(str);
        int count = 0;

        while (matcher.find()) {
            System.out.println((++count) + "번째 검색");
            System.out.println("\t그룹1 검색 값 = " + matcher.group(1));
        }
    }


    public static String readFile(Class<?> clazz, int type) throws IOException {
        String name = clazz.getName();
        name = "src/" + name.replace(".", "/") + ".java";
        System.out.println("파일 상대 경로 = " + name);
        String str;

        if (type == 1) {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(name));
            ByteArrayOutputStream bias = new ByteArrayOutputStream();
            byte[] by = new byte[1024];
            while (true) {
                int read = bis.read(by);
                if (read == -1) {
                    break;
                }
                bias.write(by, 0, read);
            }
            str = bias.toString();


        } else {
            BufferedReader br = new BufferedReader(new FileReader(name));
            StringBuilder sb = new StringBuilder();
            while(true){
                String readLine = br.readLine();
                if(readLine==null){
                    break;
                }
                sb.append(readLine).append("\r\n");
            }
            str = sb.toString();


        }
        return str;

    }
}


