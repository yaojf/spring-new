import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import com.yaojiafeng.service.user.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.io.IOException;

/**
 * Created by yaojiafeng on 16/1/31.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-service.xml"})
public class TaskTest {

    @Inject
    private UserService userService;

    @Test
    public void test() throws IOException {
        userService.getUser(1);
    }
}
