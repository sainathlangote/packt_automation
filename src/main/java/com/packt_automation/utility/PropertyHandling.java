package com.packt_automation.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyHandling {
    Properties properties;
    public PropertyHandling() throws IOException {
        String filepath= System.getProperty("user.dir")+"/Config.properties";
        try {
            FileInputStream file= new FileInputStream(filepath);
            properties= new Properties();
            properties.load(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    public String getproperty(String key) {
        String value= properties.getProperty(key);
        System.out.println(value);
        return value;
    }
}
