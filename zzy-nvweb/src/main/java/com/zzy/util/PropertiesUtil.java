package com.zzy.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Author shitongtong
 * <p>
 * Created by shitongtong on 2017/7/18.
 */
public class PropertiesUtil {
    public static Properties getProperties(String propertiesName) {
        Properties p = new Properties();
        try {
            InputStream inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream(propertiesName);
            p.load(inputStream);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return p;
    }

}
