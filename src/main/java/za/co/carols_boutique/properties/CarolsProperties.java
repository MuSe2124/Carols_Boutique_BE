package za.co.carols_boutique.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class CarolsProperties {

    private static File file = new File("CarolsDatabase.properties");
    private static InputStream is;
    private static String url;
    private static String username;
    private static String password;
    private static Properties p = new Properties();

    public static String read(String key){
        try {
            p = new Properties();
            is = new FileInputStream(file);

            p.load(is);
        } catch (IOException ignore) {
        }
        return p.getProperty(key);
    }
    
    public static String getUrl() {
        url = read("url");
        return url;
    }

    public static String getUsername() {
        username = read("username");
        return username;
    }

    public static String getPassword() {
        password = read("password");
        return password;
    }

}
