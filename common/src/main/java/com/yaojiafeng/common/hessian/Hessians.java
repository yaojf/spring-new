package com.yaojiafeng.common.hessian;

import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;
import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * hession序列化目前来看是针对field字段来进行序列化和反序列化，跟set get方法无关
 *
 * 反序列化的对象增减字段不会影响反序列化结果，新增的字段为null，减少的字段忽略
 *
 * @author yaojiafeng
 * @create 2017-06-29 下午3:48
 */
public class Hessians {

    public static byte[] serialize2(Object obj) throws IOException {
        if (obj == null) throw new NullPointerException();

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        Hessian2Output ho = new Hessian2Output(os);
        ho.writeObject(obj);
        return os.toByteArray();
    }

    public static Object deserialize2(byte[] by) throws IOException {
        if (by == null) throw new NullPointerException();

        ByteArrayInputStream is = new ByteArrayInputStream(by);
        Hessian2Input hi = new Hessian2Input(is);
        return hi.readObject();
    }

    public static byte[] serialize(Object obj) throws IOException{
        if(obj==null) throw new NullPointerException();

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        HessianOutput ho = new HessianOutput(os);
        ho.writeObject(obj);
        return os.toByteArray();
    }

    public static Object deserialize(byte[] by) throws IOException{
        if(by==null) throw new NullPointerException();

        ByteArrayInputStream is = new ByteArrayInputStream(by);
        HessianInput hi = new HessianInput(is);
        return hi.readObject();
    }

    public static void main(String[] args) throws IOException {

        City city = new City(1L, "beijing");

        byte[] bytes = serialize(city);

        Object o = deserialize(bytes);

        System.out.println(o);
    }


    private static class City implements java.io.Serializable {

        private Long id;

        private String cityName;

        public City(Long id, String cityName) {
            this.id = id;
            this.cityName = cityName;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        @Override
        public String toString() {
            return "City{" +
                    "id=" + id +
                    ", cityName='" + cityName + '\'' +
                    '}';
        }
    }

}
