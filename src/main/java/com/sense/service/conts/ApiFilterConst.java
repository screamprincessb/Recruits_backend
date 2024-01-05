package com.sense.service.conts;

public class ApiFilterConst {
    
    public static final String TOKEN_KEY_NAME = "token";
    public static final String ZONE_URL = "ZoneUrl";
    
    public static final String ATTR_DATA_NAME = "attrData";
    
    public static final String DEFAULT_VALUE_TOKEN_KEY = "dev";

    public final static String ROLE_NAME_USER = "USER";
    public final static String ROLE_NAME_ADMIN = "ADMIN";
    public final static String ROLE_NAME_SUPER_ADMIN = "SUPER_ADMIN";
    public final static String ROLE_NAME_EXTERNAL = "EXTERNAL";
    public final static String ROLE_NAME_SYSTEM = "SYSTEM";

    public final static String CONTEXT_NAME = "/Recruits";
    
    public final static String PATH_LEVEL_ROLE_PUBLIC = "public"; // not require token
    public final static String PATH_LEVEL_ROLE_SECURE = "secure"; //role SUPER_ADMIN
    public final static String PATH_LEVEL_ROLE_INTERNAL = "internal"; //role USER
    public final static String PATH_LEVEL_ROLE_EXTERNAL = "external"; //role EXTERNAL
    public final static String PATH_LEVEL_ROLE_MANAGE = "manage"; //role ADMIN
    public final static String PATH_LEVEL_ROLE_SYSTEM = "system"; //role SYSTEM
    
}
