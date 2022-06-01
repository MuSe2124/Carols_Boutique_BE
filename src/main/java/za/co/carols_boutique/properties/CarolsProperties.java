/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.co.carols_boutique.properties;

import java.util.Properties;

/**
 *
 * @author muaad
 */
public class CarolsProperties {
    private Properties carol_boutique_properties;
    
    public void addToFile(String key, String value){
        carol_boutique_properties.setProperty(key, value);
    }
    
    public void deleteFromFile(String key){
        carol_boutique_properties.remove(key);
    }
    
    public void updateFile(String key, String oldObject, String newObject){
        carol_boutique_properties.replace(key, oldObject, newObject);
    }
    
    public void getFile(String key){
        carol_boutique_properties.get(key);
    }
}
