package com.yaojiafeng.test.asm;

import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.core.ParameterNameDiscoverer;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * 根据class文件解析方法参数名
 * <p>
 * 解析的方法不能是接口的方法，因为接口方法字节码不保存参数名称
 *
 * @author yaojiafeng
 * @create 2017-07-04 下午2:54
 * @see http://blog.csdn.net/wwwwenl/article/details/53427039
 */
public class ParameterNameTest {

    public static void main(String[] args) {
        spring();
        jdk();
    }

    public static void test(String param1, int param2) {
        System.out.println(param1 + param2);
    }

    public static void spring() {
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

    /**
     * java8需设置编译参数-parameters
     */
    public static void jdk() {
        System.out.println();
        Method method = null;
        try {
            method = ParameterNameTest.class.getDeclaredMethod("test",
                    String.class, int.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        for (Parameter p : method.getParameters()) {
            System.out.println("parameter: " + p.getType().getName() + ", " + p.getName());
        }
    }

}
