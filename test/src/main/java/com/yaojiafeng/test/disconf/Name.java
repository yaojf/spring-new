package com.yaojiafeng.test.disconf;

import com.baidu.disconf.client.common.annotations.DisconfItem;
import org.springframework.stereotype.Service;

/**
 * Created by yaojiafeng on 2018/12/4 6:01 PM.
 */
@Service
public class Name {

    private String name;

    @DisconfItem(key = "name", associateField = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
