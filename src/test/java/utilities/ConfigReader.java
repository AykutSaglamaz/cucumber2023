package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    // Bu class configuration.properties file/dosyadaki bilgileri okumak icindir

    private static Properties properties;

    static {
        //properties file path'i
        String path = "configuration.properties";

        try {
            //file/dosyayi ac
            FileInputStream fileInputStream = new FileInputStream(path);
            // properties objecti aktif et/calistir
            properties = new Properties();

            // dosyayi yukle
            properties.load(fileInputStream);
            //dosyayi kapat
            fileInputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    // getProperti(key) ==> value

    public static String getProperty(String key){
        String value = properties.getProperty(key);
        return value;

        // return properties.getProperty(key);
    }

}
