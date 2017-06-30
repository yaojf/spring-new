package com.yaojiafeng.common.yml;

import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.net.URL;

/**
 * @author yaojiafeng
 * @create 2017-06-30 下午2:19
 */
public class Ymls {

    public static void load() throws FileNotFoundException {
        Yaml yaml = new Yaml();
        Me me = yaml.loadAs(Ymls.class.getResourceAsStream("/yml/me.yaml"), Me.class);
        System.out.println(me);
    }


    public static void dump() throws IOException {
        Yaml yaml = new Yaml();
        Me me = yaml.loadAs(Ymls.class.getResourceAsStream("/yml/me.yaml"), Me.class);
        yaml.dump(me, new FileWriter("/Users/zcy/IdeaProjects/spring-new/common/src/main/resources/yml/me2.yaml"));
    }

    public static void main(String[] args) throws IOException {
        load();
//        dump();
    }

}
