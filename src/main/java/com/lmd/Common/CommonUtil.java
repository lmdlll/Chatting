package com.lmd.Common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 封装公共工具方法，入加载配置文件、json序列化等
 */
//ctrl+shift+t
public class CommonUtil {

    //加载配置的文件
    public static Properties loadProperties(String fileName){
        Properties properties = new Properties();
        InputStream in = CommonUtil.class.getClassLoader().getResourceAsStream(fileName);
        try {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();

        return properties;
    }
}
