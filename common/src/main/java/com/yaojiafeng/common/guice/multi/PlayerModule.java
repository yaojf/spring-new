package com.yaojiafeng.common.guice.multi;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.name.Names;

/**
 * Created by yaojiafeng on 2017/5/31 下午7:41.
 */
public class PlayerModule implements Module {

    public void configure(Binder binder) {

        binder.bind(Player.class).annotatedWith(Names.named("Good")).to(
                GoodPlayer.class);
        binder.bind(Player.class).annotatedWith(Names.named("Bad")).to(
                BadPlayer.class);
    }

}
