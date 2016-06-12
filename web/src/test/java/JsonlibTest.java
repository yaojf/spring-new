/**
 * qccr.com Inc.
 * Copyright (c) 2014-2016 All Rights Reserved.
 */

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import net.sf.json.xml.XMLSerializer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author yaojiafeng
 * @since $Revision:1.0.0, $Date: 16/5/17 上午10:33 $
 */
public class JsonlibTest {


    private JSONArray jsonArray = null;
    private JSONObject jsonObject = null;

    private Student bean = null;

    @Before
    public void init() {
        jsonArray = new JSONArray();
        jsonObject = new JSONObject();

        bean = new Student();
        bean.setAddress("address");
        bean.setEmail("email");
        bean.setId(1);
        bean.setName("haha");
        Birthday day = new Birthday();
        day.setBirthday("2010-11-22");
        bean.setBirthday(day);
    }

    @After
    public void destory() {
        jsonArray = null;
        jsonObject = null;
        bean = null;
        System.gc();
    }

    public final void fail(String string) {
        System.out.println(string);
    }

    public final void failRed(String string) {
        System.err.println(string);
    }

    @Test
    public void writeObject2XML() {
        XMLSerializer xmlSerializer = new XMLSerializer();
        fail("==============Java String Array >>> XML ==================");
        //xmlSerializer.setElementName("bean");
        fail(xmlSerializer.write(JSONArray.fromObject(bean)));

        String[] sa = {"a", "b", "c"};
        fail("==============Java String Array >>> XML ==================");
        fail(xmlSerializer.write(JSONArray.fromObject(sa)));
        fail("==============Java boolean Array >>> XML ==================");
        boolean[] bo = { true, false, true };
        fail(xmlSerializer.write(JSONArray.fromObject(bo)));
        fail(xmlSerializer.write(JSONSerializer.toJSON(bo)));
        Object[] o = { 1, "a", true, 'A', sa, bo };
        fail("==============Java Object Array >>> JSON Array ==================");
        fail(xmlSerializer.write(JSONArray.fromObject(o)));
        fail(xmlSerializer.write(JSONSerializer.toJSON(o)));
        fail("==============Java String >>> JSON ==================");
        fail(xmlSerializer.write(JSONArray.fromObject("['json','is','easy']")).toString());
        fail(xmlSerializer.write(JSONObject.fromObject("{'json':'is easy'}")).toString());
        fail(xmlSerializer.write(JSONSerializer.toJSON("['json','is','easy']")).toString());
    }
}
