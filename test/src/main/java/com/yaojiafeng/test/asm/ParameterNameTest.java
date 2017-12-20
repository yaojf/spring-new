package com.yaojiafeng.test.asm;

import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.core.ParameterNameDiscoverer;

/**
 * 根据class文件解析方法参数名
 *
 * 解析的方法不能是接口的方法，因为接口方法字节码不保存参数名称
 *
 * @author yaojiafeng
 * @create 2017-07-04 下午2:54
 * @see http://blog.csdn.net/wwwwenl/article/details/53427039
 */
public class ParameterNameTest {

    public static void main(String[] args) {
        ParameterNameDiscoverer parameterNameDiscoverer =
                new LocalVariableTableParameterNameDiscoverer();
        try {
            String[] parameterNames = parameterNameDiscoverer
                    .getParameterNames(ParameterNameTest.class.getDeclaredMethod("test",
                            String.class, int.class));
            System.out.print("test : ");
            for (String parameterName : parameterNames) {
                System.out.print(parameterName + ' ');
            }
        } catch (NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }
    }

    public static void test(String param1, int param2) {
        System.out.println(param1 + param2);
    }

}
