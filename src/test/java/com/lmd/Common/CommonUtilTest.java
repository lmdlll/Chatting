package com.lmd.Common;

import org.junit.Assert;
import org.junit.Test;

import java.util.Properties;

import static org.junit.Assert.*;

public class CommonUtilTest {
    @Test
    public void loadProperties() {
        String name = "datasource.properties";
        Properties p = CommonUtil.loadProperties(name);
        Assert.assertNotNull(p);
    }
}
