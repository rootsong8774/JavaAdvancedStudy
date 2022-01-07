package Chap02.sec02.main02;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesStoreMain {

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put("Subject","Server Programming");
        properties.put("End date", "2022/01/28");
        properties.put("FrameWork","Spring");
        properties.put("Score","80");
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("src/Chap02/sec02/main02/conf.properties");
            properties.store(fos,"Subject Description");
            if(fos!=null){
                fos.close();
            }
            System.out.println("Save Complete");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
