package com.sense.backend.common.helper;

import com.sense.backend.hb.entity.common.CoreConfig;
import com.sense.backend.hb.service.CoreConfigService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConfigHelper {

    private final CoreConfigService coreConfigService;

    private static ConfigHelper instance;
    private static Map<String, String> FILE_CONFIG;

    private ConfigHelper() {
        FILE_CONFIG = new HashMap();
        coreConfigService = HBHelper.instance().service(CoreConfigService.class);
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM CORE_CONFIG WHERE ISDELETED=0 ");
        List<CoreConfig> cfs = coreConfigService.findBySQL(sql.toString());
        for (CoreConfig cf : cfs) {
            FILE_CONFIG.put(cf.getVarCode(), cf.getVarValue());
        }
    }

    public static ConfigHelper getInstance() {
        if (instance == null) {
            instance = new ConfigHelper();
        }

        return instance;
    }

    public void clearInstance() {
        instance = null;
    }

    public Map<String, String> getConfig() {
        return FILE_CONFIG;
    }

}
