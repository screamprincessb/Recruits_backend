package com.sense.service.validate;

public class RestValidateException extends Exception {

    private static final long serialVersionUID = -1382880916572862365L;
    private String key;
    private Object replaceString[];
    private String msg;

    public RestValidateException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public RestValidateException(RestValidateResourceBundleUtil util, String key,
            Object replaceString[]) {
        this.key = key;
        this.replaceString = replaceString;
        prepareError(util);
    }

    private void prepareError(RestValidateResourceBundleUtil util) {
        msg = util.getMessage(key);
        if (replaceString != null) {
            msg = util.formatMessage(msg, replaceString);
        }
    }

    public String getMessage() {
        return (new StringBuilder()).append(msg).toString();
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object[] getReplaceString() {
        return replaceString;
    }

    public void setReplaceString(Object replaceString[]) {
        this.replaceString = replaceString;
    }
}
