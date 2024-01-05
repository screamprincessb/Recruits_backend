package com.sense.service.util;
import java.util.Arrays;
import java.util.List;

public class ServiceUtil {

    public static boolean isFoundInList(List<String> dataList, String chkStr) {
        return dataList.stream()
                .anyMatch(data -> data.equals(chkStr));
    }

    public static boolean isFoundInListIgnoreCase(List<String> chkList, String chkStr) {
        return chkList.stream()
                .anyMatch(data -> data.equalsIgnoreCase(chkStr));
    }

    public static boolean isFoundInMultiString(String multiStr, String chkStr, String separator) {
        String[] sArr = multiStr.split("\\" + separator);
        List<String> list = Arrays.asList(sArr);
        return list.stream()
                .anyMatch(data -> data.trim().equals(chkStr));
    }

    public static boolean isFoundInMultiStringIgnoreCase(String multiStr, String chkStr, String separator) {

        String[] sArr = multiStr.split("\\" + separator);
        List<String> list = Arrays.asList(sArr);

        return list.stream()
                .anyMatch(data -> data.trim().equalsIgnoreCase(chkStr));
    }

    public static String xuriToPathName(String uri, String contextName) {

        return uri.replaceFirst(contextName, "");
    }

    public static String xuriToContextPath(String uri, String contextName) {
        String pathName = xuriToPathName(uri, contextName);
        int ind = pathName.lastIndexOf("/");
        String contextPath = pathName.substring(0, ind);

        return contextPath;
    }
    
    public static String uriToRolePath(String uri) {
        String[] strArr = uri.split("/");
        String roletPath = strArr[3];

        return roletPath;
    }

}
