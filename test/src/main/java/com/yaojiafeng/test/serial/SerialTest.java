package com.yaojiafeng.test.serial;

import com.alibaba.fastjson.JSON;
import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.*;

/**
 * jdk序列化会校验serialVersionUID，如果没有设置serialVersionUID编译时会自动生成
 * ，并且随着类的属性或方法不一样serialVersionUID会变化，所以修改类会报错
 * <p>
 * Hessian2序列化不会校验serialVersionUID，所以修改类不会报错
 * <p>
 * Created by yaojiafeng on 2018/12/28 5:55 PM.
 */
public class SerialTest {

    @Test
    public void serialize() throws IOException {
        StoreCouponOperatorTO storeCouponOperatorTO = new StoreCouponOperatorTO();
        storeCouponOperatorTO.setCouponId(1L);
        storeCouponOperatorTO.setOperator("1");
        storeCouponOperatorTO.setStoreId(1L);

        byte[] serialize = serialize(storeCouponOperatorTO);
        FileOutputStream fileOutputStream = new FileOutputStream(new File("serialize"));
        fileOutputStream.write(serialize);
        fileOutputStream.close();
    }

    @Test
    public void deserialize() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File("serialize"));

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        IOUtils.copyLarge(fileInputStream, byteArrayOutputStream);
        Object deserialize = deserialize(byteArrayOutputStream.toByteArray());

        System.out.println(JSON.toJSONString(deserialize));
    }


    public static byte[] serialize(Object obj) throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        Hessian2Output ho = new Hessian2Output(os);
        byte[] cc = null;
        try {
            if (obj == null) throw new NullPointerException();
            ho.writeObject(obj);
            ho.flushBuffer();
            cc = os.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ho.close();
        }
        return cc;
    }

    public static Object deserialize(byte[] by) throws IOException {
        try {
            if (by == null) throw new NullPointerException();
            ByteArrayInputStream is = new ByteArrayInputStream(by);
            Hessian2Input hi = new Hessian2Input(is);
            return hi.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
