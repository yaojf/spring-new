package com.yaojiafeng.test.disconf;

import com.baidu.disconf.client.common.annotations.DisconfFile;
import com.baidu.disconf.client.common.annotations.DisconfFileItem;
import com.baidu.disconf.client.common.annotations.DisconfUpdateService;
import org.springframework.stereotype.Service;

/**
 * Created by yaojiafeng on 2018/12/4 5:54 PM.
 */
@Service
@DisconfFile(filename = "info.properties")
@DisconfUpdateService(classes = {Info.class}, itemKeys = {"name"})
public class Info {

    private String phone;

    @DisconfFileItem(name = "phone", associateField = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
