package com.yaojiafeng.test.lombok;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by yaojiafeng on 2018/8/24 上午11:35.
 */
@AllArgsConstructor(staticName = "create")
@Data
public class Example {

    private int foo;

    private String bar;

    /**
     * 自定义方法覆盖lombok自动生成方法
     * @return
     */
    public String getBar() {
        return "bar";
    }
}
