package com.sense.service.validate;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;


public class RestValidateResourceBundleUtil {

    private Locale locale;
    private String baseName;

    public RestValidateResourceBundleUtil() {
        this.locale = Locale.US;
    }

    public RestValidateResourceBundleUtil(Locale locale) {
        this.locale = locale;
    }

    public String getMessage(String key) {
        String rtnMessage = "error";
        try {
            ResourceBundle rb = ResourceBundle.getBundle(this.baseName,
                    this.locale);
            rtnMessage = rb.getString(key);
            return rtnMessage;
        } catch (MissingResourceException e) {
            //e.printStackTrace();
        } finally {
        }
        return rtnMessage;
    }

    public String getMessage(String baseName, String key) {
        String rtnMessage = "error";
        try {
            ResourceBundle rb = ResourceBundle.getBundle(baseName, this.locale);
            rtnMessage = rb.getString(key);
            return rtnMessage;
        } catch (MissingResourceException e) {
            e.printStackTrace();
        } finally {
        }
        return rtnMessage;
    }

    public String formatMessage(String msg, Object[] params) {
        return MessageFormat.format(msg, params);
    }

    public String getBaseName() {
        return this.baseName;
    }

    public void setBaseName(String baseName) {
        this.baseName = baseName;
    }
}
