package com.avatrade.util;

import org.apache.xmlbeans.ResourceLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class PropertiesFileUtil {

    Properties configProp;
    public static final Logger log = LoggerFactory.getLogger(PropertiesFileUtil.class);

    public PropertiesFileUtil() {

       // InputStream in = this.getClass().getClassLoader().getResourceAsStream("config/default.properties");
        try ( InputStream in = this.getClass()
                .getClassLoader()
                .getResourceAsStream("config/default.properties")){

            configProp = new Properties();
            configProp.load(in);

            for(String key: configProp.stringPropertyNames()){
                if(System.getProperties().containsKey(key)){
                    configProp.setProperty(key, System.getProperty(key));
                }
            }
            // To display the property key and value
            for(String key: configProp.stringPropertyNames()){
                System.out.println(key+ "--->"+configProp.getProperty(key));
            }
        } catch (IOException e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return configProp.getProperty(key);
    }

}
