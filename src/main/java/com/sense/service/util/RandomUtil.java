package com.sense.service.util;

import java.util.Random;

public class RandomUtil {

    private static final String STR_SOURCE_0 = "123456789";
    private static final String STR_SOURCE_1 = "1234567890";
    private static final String STR_SOURCE_2 = "123456789ABCDEFGHIJKLMNPQRSTUVWXYZabcdefghijkmnpqrstuvwxyz";
    private static final String[] color = new String[]{"#ff6600", "#808080", "#ff9966", "#0eb9ed", "#ff00ff", "#00ff00", "#ffff00", "#cc33ff", "#800080", "#008000", "#ccf01a", "#993300", "#ff6600", "#808080", "#ff9966", "#0eb9ed", "#ff00ff", "#00ff00", "#ffff00", "#cc33ff", "#800080", "#008000", "#ccf01a", "#993300", "#ff6600", "#808080", "#ff9966", "#0eb9ed", "#ff00ff", "#00ff00", "#ffff00", "#cc33ff", "#800080", "#008000", "#ccf01a", "#993300"};

    private static synchronized String randomStringInt(int len) {
        Random rnd = new Random();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < len; i++) {
            sb.append(STR_SOURCE_1.charAt(rnd.nextInt(STR_SOURCE_1.length())));
        }

        return sb.toString();
    }

    public static synchronized Integer randomInteger(int len) {
        String str = randomStringInt(len);

        while (str.substring(0, 1).equals("0")) {
            str = randomStringInt(len);
        }

        return Integer.parseInt(str);
    }

    public static synchronized String randomString(int len) {
        Random rnd = new Random();

        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            sb.append(STR_SOURCE_2.charAt(rnd.nextInt(STR_SOURCE_2.length())));
        }
        return sb.toString();
    }

    public static synchronized String randomStringInteger(int len) {
        Random rnd = new Random();

        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            sb.append(STR_SOURCE_1.charAt(rnd.nextInt(STR_SOURCE_1.length())));
        }
        return sb.toString();
    }

    public static synchronized String randomIntString(int len) {
        Random rnd = new Random();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < len - 1; i++) {
            sb.append(STR_SOURCE_1.charAt(rnd.nextInt(STR_SOURCE_1.length())));
        }

        sb.insert(0, STR_SOURCE_0.charAt(rnd.nextInt(STR_SOURCE_0.length())));

        return sb.toString();
    }

    public static String randomColor(Integer index) {
          Random rnd = new Random();
        if (index == color.length) {
            index = 0;
        }else{
           index = rnd.nextInt(color.length);
        }
        return color[index];
    }

}
