package com.sense.service;

import com.sense.service.util.RandomUtil;


public class AppHelper {

    private String serverId;
    private static AppHelper instance;

    private AppHelper() {
        serverId = RandomUtil.randomIntString(8);
    }

    public static AppHelper getInstance() {
        if (instance == null) {
            instance = new AppHelper();
        }

        return instance;
    }

    public void clearInstance() {
        instance = null;
    }

    public String getServerId() {
        return serverId;
    }

}
