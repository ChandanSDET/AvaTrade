package com.avatrade.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFileUtil {

    Properties configProp;

    public PropertiesFileUtil() {
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("conf.properties");
        try {
            configProp = new Properties();
            configProp.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return configProp.getProperty(key);
    }

}
