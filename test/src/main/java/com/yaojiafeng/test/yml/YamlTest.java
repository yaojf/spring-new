package com.yaojiafeng.test.yml;

import org.junit.Test;
import org.yaml.snakeyaml.Yaml;

/**
 * @author yaojiafeng
 * @create 2017-08-02 下午4:59
 */
public class YamlTest {

    @Test
    public void testYml(){

        Yaml yaml = new Yaml();
        Object load = yaml.load(YamlTest.class.getResourceAsStream("/application-test.yml"));
        System.out.println(load);
    }
}
