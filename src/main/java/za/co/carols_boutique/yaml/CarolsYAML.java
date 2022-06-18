/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.co.carols_boutique.yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.yaml.snakeyaml.Yaml;

/**
 *
 * @author muaad
 */
public class CarolsYAML {
    private String url;
    private String username;
    private String password;
    private InputStream is;
    private Yaml yaml;
    private Map<String, String> data;

    public CarolsYAML() {
        try {
            is = new FileInputStream(new File("C:\\Users\\muaad\\OneDrive\\Desktop\\Carols_Boutique_BE\\CarolsDatabase.yml"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CarolsYAML.class.getName()).log(Level.SEVERE, null, ex);
        }
        yaml = new Yaml();
        data = yaml.load(is);
        setUrl(data.get("url"));
        setUsername(data.get("username"));
        setPassword(data.get("password"));
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
