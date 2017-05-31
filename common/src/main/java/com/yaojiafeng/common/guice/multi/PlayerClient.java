package com.yaojiafeng.common.guice.multi;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.name.Named;


/**
 * Created by yaojiafeng on 2017/5/31 下午7:43.
 */
public class PlayerClient {
    public static void main(String[] args) {

        PlayerModule module = new PlayerModule();
        Injector injector = Guice.createInjector(new Module[]{module});

        PlayerClient playerClient = injector.getInstance(PlayerClient.class);

        playerClient.goodPlayer.bat();
        playerClient.badPlayer.bat();
    }


    @Named("Good")
    @Inject
    Player goodPlayer;

    @Named("Bad")
    @Inject
    Player badPlayer;
}
