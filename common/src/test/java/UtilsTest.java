import com.yaojiafeng.common.util.VelocityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by yaojiafeng on 16/1/31.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-common.xml", "classpath:spring.xml"})
public class UtilsTest {


    @Test
    public void test() {
        System.out.println(VelocityUtils.merge());
    }

    @Resource
    @Qualifier("languageChangesMap")
    private Map<String, String> languageChangesMap;

    @Test
    public void testAutowired() {
        System.out.println(languageChangesMap.getClass().getSimpleName());
        System.out.println(languageChangesMap);
    }

}
