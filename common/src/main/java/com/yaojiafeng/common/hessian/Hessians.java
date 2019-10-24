package com.yaojiafeng.common.hessian;

import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;
import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * hession序列化目前来看是针对field字段来进行序列化和反序列化，跟set get方法无关
 * <p>
 * 反序列化的对象增减字段不会影响反序列化结果，新增的字段为null，减少的字段忽略，不会报异常，而且不会校验serialVersionUID
 *
 * 序列化方式必须配对使用，不同序列化反序列化方式会报异常（比如用Hessian序列化，用Hessian2反序列化会报异常，反之亦然）
 *
 * 当反序列化找不到对应的类时，会打印类找不到异常警告，但是反序列化能成功，返回的值为HashMap
 * @author yaojiafeng
 * @create 2017-06-29 下午3:48
 */
public class Hessians {

    public static byte[] serialize2(Object obj) throws IOException {
        if (obj == null) throw new NullPointerException();

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        Hessian2Output ho = new Hessian2Output(os);
        ho.writeObject(obj);
        ho.flush();
        return os.toByteArray();
    }

    public static Object deserialize2(byte[] by) throws IOException {
        if (by == null) throw new NullPointerException();

        ByteArrayInputStream is = new ByteArrayInputStream(by);
        Hessian2Input hi = new Hessian2Input(is);
        return hi.readObject();
    }

    public static byte[] serialize(Object obj) throws IOException {
        if (obj == null) throw new NullPointerException();

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        HessianOutput ho = new HessianOutput(os);
        ho.writeObject(obj);
        ho.flush();
        return os.toByteArray();
    }

    public static Object deserialize(byte[] by) throws IOException {
        if (by == null) throw new NullPointerException();

        ByteArrayInputStream is = new ByteArrayInputStream(by);
        HessianInput hi = new HessianInput(is);
        return hi.readObject();
    }

    public static void main(String[] args) throws IOException {

        City city = new City(1L, "beijing");

        // hessian
        byte[] bytes = serialize(city);

        Object o = deserialize(bytes);

        System.out.println(o);


        // hessian2
        bytes = serialize2(city);

        o = deserialize2(bytes);

        System.out.println(o);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class City implements java.io.Serializable {

        private Long id;

        private String cityName;

    }

}
