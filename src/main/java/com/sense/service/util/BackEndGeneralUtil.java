package com.sense.service.util;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class BackEndGeneralUtil {

    public static boolean isExistString(String str, String[] existStringArray) {
        boolean isFound = false;

        for (int i = 0; i < existStringArray.length; i++) {
            if (str.equals(existStringArray[i])) {
                isFound = true;
                break;
            }
        }

        return isFound;
    }

    public static String StringArray2String(String[] stringArray) {
        String result;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stringArray.length; i++) {
            String str = stringArray[i];
            sb.append("'");
            sb.append(str);
            sb.append("'");
            if (i < (stringArray.length - 1)) {
                sb.append(", ");
            }

        }

        result = sb.toString();

        return result;
    }

    public static String showNumberFormat(double value, int precision) {
        String fm = "#.";
        for (int i = 0; i < precision; i++) {
            fm = fm + "0";
        }

        NumberFormat formatter = new DecimalFormat(fm);
        return formatter.format(value);

    }

    public static boolean isUndefined(String value) {
        boolean result = false;

        if (value == null) {
            result = true;
        } else if (value.trim().length() == 0) {
            result = true;
        }

        return result;
    }

    public static boolean isDefined(String value) {
        return !isUndefined(value);
    }

    public static String convertNull2WhiteSpace(String inputStr) {
        String result;

        if (inputStr == null) {
            result = "";
        } else {
            result = inputStr;
        }

        return result;
    }

    public static String convertWhiteSpace2Null(String inputStr) {
        String result;
        if (inputStr == null) {
            result = null;
        } else if (inputStr.trim().length() == 0) {
            result = null;
        } else {
            result = inputStr.trim();
        }

        return result;
    }

    public static List<String> stringParam2List(String strParam,
            String delimiter) {
        // strMsg = "DM-01-01-01-01, MPS001"
        // delimiter = ","

        List<String> resultList = new ArrayList<String>();

        String[] strArr = null;
        if ((strParam != null) && (delimiter != null)) {
            strArr = strParam.trim().split(delimiter.trim());
        }

        if (strArr != null) {
            for (String s : strArr) {
                if ((s != null) && (s.trim().length() > 0)) {
                    resultList.add(s.trim());
                }

            }
        }

        return resultList;
    }

    public static double convertNullValue(Double value) {
        double result;
        if (value == null) {
            result = 0;
        } else {
            result = value;
        }

        return result;
    }

    public static int convertNullValue(Integer value) {
        int result;
        if (value == null) {
            result = 0;
        } else {
            result = value;
        }

        return result;
    }

    public static double convertString2Double(String value) {
        double result;
        if (value == null) {
            result = 0.0;
        } else {
            result = new Double(value);
        }

        return result;
    }

    public static int convertString2Integer(String value) {
        int result;
        if (value == null) {
            result = 0;
        } else {
            result = new Integer(value);
        }

        return result;
    }

}