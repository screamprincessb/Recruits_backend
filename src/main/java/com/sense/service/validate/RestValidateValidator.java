package com.sense.service.validate;

import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Component;

@Component
public class RestValidateValidator {

    private String propName = "com.sense.service.validate.validate";

    private RestValidateResourceBundleUtil resourceUtil;

    public RestValidateValidator() {
        //resourceUtil = new RestValidateResourceBundleUtil(new Locale("th", "TH"));
        resourceUtil = new RestValidateResourceBundleUtil(new Locale("en", "US"));
        resourceUtil.setBaseName(propName);
    }

    public RestValidateValidator(Locale locale) {
        resourceUtil = new RestValidateResourceBundleUtil(locale);
        resourceUtil.setBaseName(propName);
    }

    public void checkNull(Object value, String fieldName) throws Exception {
        if (value == null) {
            throw new RestValidateException(resourceUtil, "PreConCode.1010",
                    new Object[]{fieldName});
        }
    }

    public void checkLengthEqualZero(String value, String fieldName)
            throws Exception {
        if (value.length() == 0) {
            throw new RestValidateException(resourceUtil, "PreConCode.1016",
                    new Object[]{fieldName});
        }
    }

    public void validateLengthEqualZeroWithTrim(String value, String fieldName)
            throws Exception {
        if (value.trim().length() == 0) {
            throw new RestValidateException(resourceUtil, "PreConCode.1016",
                    new Object[]{fieldName});
        }
    }

    public void checkNotNumeric(String value, String fieldName)
            throws Exception {
        if (!value.matches(RestValidateRegExpConst.ONLY_NUMERIC)) {
            throw new RestValidateException(resourceUtil, "PreConCode.1018",
                    new Object[]{fieldName});
        }
    }

    @SuppressWarnings("rawtypes")
    public void checkSizeListLessThanOrEqualZero(List valueList, String fieldName)
            throws Exception {
        if (valueList.size() <= 0) {
            throw new RestValidateException(resourceUtil, "PreConCode.1019",
                    new Object[]{fieldName, "0"});
        }
    }

    public void checkValueNotIn(String value, String[] existStringArray, String fieldName)
            throws Exception {
        if (!isExistString(value, existStringArray)) {
            throw new RestValidateException(resourceUtil,
                    "PreConCode.1002", new Object[]{fieldName,
                        stringArray2String(existStringArray)});
        }
    }

    public void checkLessThanOrEqual(Integer value, Integer compareValue, String fieldName)
            throws Exception {
        if (value <= compareValue) {
            throw new RestValidateException(resourceUtil, "PreConCode.1009",
                    new Object[]{fieldName, compareValue});
        }
    }

    public void checkLessThanOrEqual(String value, Integer compareValue, String fieldName)
            throws Exception {
        Integer iValue = new Integer(value);

        if (iValue <= compareValue) {
            throw new RestValidateException(resourceUtil, "PreConCode.1009",
                    new Object[]{fieldName, compareValue});
        }
    }

    private boolean isExistString(String str, String[] existStringArray) {
        boolean isFound = false;

        for (int i = 0; i < existStringArray.length; i++) {
            if (str.equals(existStringArray[i])) {
                isFound = true;
                break;
            }
        }

        return isFound;
    }

    private String stringArray2String(String[] stringArray) {
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

}
