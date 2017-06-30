package com.yaojiafeng.common.hessian;

import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;
import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
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

        byte[] bytes = serialize2(city);

        Object o = deserialize2(bytes);

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
