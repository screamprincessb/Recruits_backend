package com.sense.service.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class GeneratUtil {

    private static final String PATTERN_DT_ATTACH = "yyyyMMddHHmmssSSS";
    private static final Integer LENGTH = 8;

    public static synchronized String fileNameAttach() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(PATTERN_DT_ATTACH);
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now).concat("_").concat(RandomUtil.randomStringInteger(LENGTH));
    }

    public static synchronized String patchFolder(Map<String, String> CONFIG) {
        return CONFIG.get(LoadConfig.PATH_ATTACHMENT).concat("/");
    }

    public static synchronized String patchTempFolder(Map<String, String> CONFIG) {
        return CONFIG.get(LoadConfig.PATH_ATTACHMENT).concat(CONFIG.get(LoadConfig.PATH_TEMP_FOLDER));
    }

    public static synchronized String getPatchFloderProject(Map<String, String> CONFIG) {
        return CONFIG.get(LoadConfig.PATH_ATTACHMENT).concat("/");
    }

    public static synchronized String getPatchFloderAttach(String attachFileName) {
        if (StringUtil.isnotnull(attachFileName)) {
            String year = attachFileName.substring(0, 4);
            String month = attachFileName.substring(4, 6);
            return year.concat("/").concat(month).concat("/").concat(attachFileName);
        } else {
            return "";
        }
    }

    public static synchronized String getPatchFloderAttach(String attachFileName, Map<String, String> CONFIG) {
        if (StringUtil.isnotnull(attachFileName)) {
            String year = attachFileName.substring(0, 4);
            String month = attachFileName.substring(4, 6);
            return year.concat("/").concat(month).concat("/").concat(CONFIG.get(LoadConfig.PREFIX_THUMBNAIL)).concat(attachFileName);
        } else {
            return "";
        }
    }

    //save full Patch branchCode/year/jobCode
    public static synchronized String getPatchFloderAttach1(String attachFileName) {
        
        if (StringUtil.isnotnull(attachFileName)) {
            return attachFileName.replace("/fileattach/", "");
        } else {
            return "";
        }
    }

    //save full Patch branchCode/year/jobCode
    public static synchronized String getPatchFloderAttach1(String attachFileName, Map<String, String> CONFIG) {
       //thumbnail_
        if (StringUtil.isnotnull(attachFileName)) {
            String[] arr = attachFileName.split("/");
            String fileName = arr[arr.length-1];
            String fileNameAddThumbnail = CONFIG.get(LoadConfig.PREFIX_THUMBNAIL).concat(fileName);
            String dataFileName = attachFileName.replace(fileName, fileNameAddThumbnail);
            return dataFileName.replace("/fileattach/", "");
        } else {
            return "";
        }
    }
}
