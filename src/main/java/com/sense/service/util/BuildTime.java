package com.sense.service.util;

import com.sense.service.util.DateTimeUtil;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BuildTime {

    public static String getLastModifiedDate() throws IOException, URISyntaxException {
        Date date = DateTimeUtil.getSystemDate();
        URL resource = BuildTime.class.getProtectionDomain().getCodeSource().getLocation();
        if (resource == null) {
            throw new IllegalStateException("Failed to find class file for class: " + BuildTime.class.getName());
        }
        switch (resource.getProtocol()) {
            case "file":
                //System.out.println(new File(resource.toURI()).lastModified());
                date.setTime(new File(resource.toURI()).lastModified());
                break;
            case "jar":
                String path = resource.getPath();
                //System.out.println(new File(path.substring(5, path.indexOf("!"))).lastModified());
                date.setTime(new File(path.substring(5, path.indexOf("!"))).lastModified());
                break;
            default:
                break;
        }
        return BackEndDateTimeUtil.convertDateTimeToDB2(date, BackEndDateTimeUtil.DATE_TIME_FORMAT_5);
    }

    public static void main(String[] args) {
        try {
            System.out.println(BuildTime.getLastModifiedDate());
        } catch (IOException ex) {
            Logger.getLogger(BuildTime.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(BuildTime.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
