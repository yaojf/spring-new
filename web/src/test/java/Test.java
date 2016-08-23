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


}
