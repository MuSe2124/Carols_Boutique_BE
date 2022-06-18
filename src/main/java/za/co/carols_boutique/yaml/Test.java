/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.co.carols_boutique.yaml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

/**
 *
 * @author muaad
 */
public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        CarolsYAML c = new CarolsYAML();
        System.out.println(c.getUrl());
        System.out.println(c.getPassword());
        System.out.println(c.getUsername());
    }
}
