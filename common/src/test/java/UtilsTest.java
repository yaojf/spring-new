import com.yaojiafeng.common.util.VelocityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by yaojiafeng on 16/1/31.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-common.xml"})
public class UtilsTest {


    @Test
    public void test() {
        System.out.println(VelocityUtils.merge());
    }
}
