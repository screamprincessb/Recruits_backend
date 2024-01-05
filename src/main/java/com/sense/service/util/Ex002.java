package com.sense.service.util;

import com.sense.service.util.GeneratUtil;

public class Ex002 implements Runnable {

    private void test() {
        //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss-SSS-n");
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
//        LocalDateTime now = LocalDateTime.now();
//        System.out.println(dtf.format(now) + "_" + RandomUtil.randomStringInteger(8));
          System.out.println(GeneratUtil.fileNameAttach());
    }

    @Override
    public void run() {
        this.test();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Ex002 app = new Ex002();

            Thread thread = new Thread(app);
            thread.start();
        }
    }

}
