package Chap03.sec02.lambda01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class ExcuteAroundMain {
    static String filepath =
         Objects.requireNonNull(ExcuteAroundMain.class.getResource("data.txt")).getPath();

    public static void main(String[] args) throws IOException {
        System.out.println(processFileLimited());
        System.out.println(processFile(BufferedReader::readLine));
        System.out.println("===============================");
        System.out.println(processFile((BufferedReader br) -> br.readLine()+"\t"+br.readLine()));

    }

    public static String processFileLimited() throws IOException {
        FileReader fr = new FileReader(filepath);
        BufferedReader br = new BufferedReader(fr);
        return br.readLine();
    }

    public static String processFile(BufferedReaderProcessor p) throws IOException {
        FileReader fr = new FileReader(filepath);
        BufferedReader br = new BufferedReader(fr);
        return p.process(br);
    }

    @FunctionalInterface
    public interface BufferedReaderProcessor {
        String process(BufferedReader b) throws IOException;
    }


}
