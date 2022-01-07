package Chap02.sec02.main01;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesLoadMain {

    public static void main(String[] args) {
        Properties properties = new Properties();
        FileInputStream fis = null;

        try {
            fis = new FileInputStream("src/Chap02/sec02/main01/conf.properties");
            properties.load(fis);
            if(fis!=null) {
                fis.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(Object o:properties.keySet()){
            System.out.println(o+ ":"+properties.getProperty((String) o));

        }
    }
}
