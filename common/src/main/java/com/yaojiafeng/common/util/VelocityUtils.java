package com.yaojiafeng.common.util;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.ui.velocity.VelocityEngineUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yaojiafeng on 16/1/31.
 */
public abstract class VelocityUtils {

    public static String merge() {
        VelocityEngine velocityEngine = ApplicationUtils.getApplicationContext().getBean(VelocityEngine.class);

        Map<String, Object> model = new HashMap<>();
        model.put("name", "yaojiafeng");
        String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "email.vm", model);

        return text;
    }


}
