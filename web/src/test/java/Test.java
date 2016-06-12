import com.thoughtworks.xstream.XStream;
import com.yaojiafeng.dao.bean.User;
import com.yaojiafeng.web.core.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by yaojiafeng on 16/2/2.
 */
public class Test {


    @org.junit.Test
    public void test() {
        ExecutorService executorService =
                Executors.newFixedThreadPool(1);

        Runnable task = () -> {
            System.out.println(System.currentTimeMillis());
            int a = 1 / 0;
            System.out.println(a);
        };

        for (int i = 0; i < 10; i++) {
            executorService.execute(task);
        }
    }


    @org.junit.Test
    public void test2() {
        int v = (int) (Math.random() * 9000 + 1000);
        System.out.println(v);
    }


    @org.junit.Test
    public void test3() {
        XStream xStream = new XStream();
        List<User> users = new ArrayList<>();


        User u1 = new User();
        u1.setUserID(1L);
        u1.setUserName("zhaoyang1");
        User u2 = new User();
        u2.setUserID(2L);
        u2.setUserName("zhaoyang2");
        users.add(u1);
        users.add(u2);

        Map<String, Object> data = new HashMap<>();
        data.put("code","0");
        data.put("msg","success");
        data.put("info",users);

        Response response = new Response();
        response.setCode(0);
        response.setMsg("success");
        response.setInfo(users);

        System.out.println(xStream.toXML(response));


    }

}
