package com.sense.service.util;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class BackEndDateTimeUtil {

    public static final String DATE_TIME_FORMAT_1 = "dd/MM/yyyy HH:mm:ss:SSS";
    public static final String DATE_TIME_FORMAT_2 = "dd/MM/yyyy HH:mm:ss";
    public static final String DATE_TIME_FORMAT_3 = "dd/MM/yyyy";
    public static final String DATE_TIME_FORMAT_4 = "HH:mm:ss";
    public static final String DATE_TIME_FORMAT_5 = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_TIME_FORMAT_6 = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final String DATE_TIME_FORMAT_7 = "yyyyMMdd HHmmss";
    public static final String DATE_TIME_FORMAT_8 = "yyyyMMdd HHmmssSSS";
    public static final String DATE_TIME_FORMAT_9 = "yyyy-MM-dd";
    public static final String DATE_TIME_FORMAT_10 = "yyyyMMddHHmmss";
    public static final String DATE_TIME_FORMAT_11 = "dd/MM/yyyy HH:mm:ss.SSS";
    public static final String DATE_TIME_FORMAT_12 = "yyyy-MM-dd HH:mm:ss:SSS";
    //
    public static final String DATE_TIME_FORMAT_TO_DB = "yyyyMMdd";
    public static final String TIME_FROM_DB = "000000";
    public static final String TIME_TO_DB = "235959";
    public static final String YYYYMMDDHH24MISS = "yyyymmddhh24miss";
    //
    public static String fillZeroNumber(int value, int position) {
        String result;

        result = Integer.toString(value);
        while (result.length() < position) {
            result = "0" + result;
        }

        return result;
    }

    public static String convertDateToDB(Date date) {
        String result;

        SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME_FORMAT_TO_DB, Locale.US);
        result = sdf.format(date);

        return result;
    }
    
    public static String convertDateTimeToDB(Date date) {
        String result;

        SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME_FORMAT_10, Locale.US);
        result = sdf.format(date);

        return result;
    }
    
    public static String convertDateTimeToDB2(Date date,String dtFormat){
        String result;

        SimpleDateFormat sdf = new SimpleDateFormat(dtFormat, Locale.US);
        result = sdf.format(date);

        return result;
    }
    
    public static String convertDateTime2String(long milliSec, String dtFormat) {
        String result;

        SimpleDateFormat sdf = new SimpleDateFormat(dtFormat, Locale.US);
        result = sdf.format(milliSec);

        return result;
    }

    public static Date convertString2DateTime(String dateTimeString,
            String dtFormat) {
        Date result;

        SimpleDateFormat sdf = new SimpleDateFormat(dtFormat, Locale.US);
        try {
            result = sdf.parse(dateTimeString);
        } catch (ParseException e) {
            result = null;
        }

        return result;
    }

    public static String stringDateTimeFull(long milliSec) {
        // DD/MM/YYYY HH:mm:ss:lll
        return convertDateTime2String(milliSec, DATE_TIME_FORMAT_1);
    }

    public static String stringDateTimeDBFull(long milliSec) {
        // YYYY-MM-DD HH:mm:ss.lll
        return convertDateTime2String(milliSec, DATE_TIME_FORMAT_6);
    }

    public static String stringDateTime(long milliSec) {
        // DD/MM/YYYY HH:mm:ss
        return convertDateTime2String(milliSec, DATE_TIME_FORMAT_2);
    }

    public static String stringDateTimeDB(long milliSec) {
        // YYYY-MM-DD HH:mm:ss
        return convertDateTime2String(milliSec, DATE_TIME_FORMAT_5);
    }

    public static String stringDate(long milliSec) {
        // DD/MM/YYYY
        return convertDateTime2String(milliSec, DATE_TIME_FORMAT_3);
    }

    public static String stringDateDB(long milliSec) {
        // YYYY-MM-DD
        return convertDateTime2String(milliSec, DATE_TIME_FORMAT_9);
    }

    public static String stringTime(long milliSec) {
        // HH:mm:ss
        return convertDateTime2String(milliSec, DATE_TIME_FORMAT_4);
    }



    public static String convertStringDate2StringDateDB(String strDate) {
        // DD/MM/YYYY ---> YYYY-MM-DD

        String year = strDate.substring(6, 10);
        String month = strDate.substring(3, 5);
        String day = strDate.substring(0, 2);

        String showDate = year + "-" + month + "-" + day;

        return showDate;
    }

    public static String convertStringDateDBStringDate(String strDate) {
        // YYYY-MM-DD ---> DD/MM/YYYY

        String year = strDate.substring(0, 4);
        String month = strDate.substring(5, 7);
        String day = strDate.substring(8, 10);

        String showDate = day + "/" + month + "/" + year;

        return showDate;
    }

    public static long convertDateTimeString2Long(String strDateTime) {
        // Format of Parameter = DD/MM/YYYY HH:mm:ss:lll OR DD/MM/YYYY HH:mm:ss
        // OR DD/MM/YYYY

        if (strDateTime.length() == 10) {
            strDateTime += " 00:00:00";
        }

        if (strDateTime.length() == 19) {
            strDateTime += ":000";
        }

        return convertString2DateTime(strDateTime, DATE_TIME_FORMAT_1)
                .getTime();
    }
    
    public static long convertDateTimeStringDB2Long(String strDateTime) {
        // Format of Parameter = YYYY-MM-DD HH:mm:ss.lll OR YYYY-MM-DD HH:mm:ss
        // OR YYYY-MM-DD

        if (strDateTime.length() == 10) {
            strDateTime += " 00:00:00";
        }

        if (strDateTime.length() == 19) {
            strDateTime += ".000";
        }

        return convertString2DateTime(strDateTime, DATE_TIME_FORMAT_6)
                .getTime();
    }

    public static Timestamp removeMilliSec(Timestamp ts) {
        //SSS

        Timestamp result = null;

        if (ts != null) {
            long dtBefore = ts.getTime();
            String st = convertDateTime2String(dtBefore, DATE_TIME_FORMAT_2);
            long dtAfter = convertDateTimeString2Long(st);

            result = new Timestamp(dtAfter);
        }

        return result;
    }

    public static Date[] arrangeMilliSec(Date date) {
        //add begin and end 'SSS'
        Date[] result = {null, null};

        if (date != null) {
            String sDt = convertDateTime2String(date.getTime(), DATE_TIME_FORMAT_2);
            String sDt1 = sDt + ":000";
            String sDt2 = sDt + ":999";

            result[0] = convertString2DateTime(sDt1, DATE_TIME_FORMAT_1);
            result[1] = convertString2DateTime(sDt2, DATE_TIME_FORMAT_1);
        }

        return result;
    }

    public static Timestamp currentTimeStamp() {
        Calendar cal = Calendar.getInstance(Locale.US);
        Timestamp ts = new Timestamp(cal.getTimeInMillis());
        return ts;
    }

    public static Date currentDateTime() {
        Calendar cal = Calendar.getInstance(Locale.US);
        Date dt = new Date(cal.getTimeInMillis());
        return dt;
    }

    public static long currentMillis() {
        Calendar cal = Calendar.getInstance(Locale.US);
        long mills = cal.getTimeInMillis();
        return mills;
    }

    public static int getDay(Date dt) {
        int result;

        DateFormat sdf = new SimpleDateFormat("dd", Locale.US);
        String str = sdf.format(dt);

        result = Integer.parseInt(str);

        return result;
    }

    public static int getMonth(Date dt) {
        int result;

        DateFormat sdf = new SimpleDateFormat("MM", Locale.US);
        String str = sdf.format(dt);

        result = Integer.parseInt(str);

        return result;
    }

    public static int getYear(Date dt) {
        int result;

        DateFormat sdf = new SimpleDateFormat("yyyy", Locale.US);
        String str = sdf.format(dt);

        result = Integer.parseInt(str);

        return result;
    }

    public static int getYearShort(Date dt) {
        int result;

        DateFormat sdf = new SimpleDateFormat("yy", Locale.US);
        String str = sdf.format(dt);

        result = Integer.parseInt(str);

        return result;
    }

    public static int getQuarter(Date dt) {
        int result = 0;

        DateFormat sdf = new SimpleDateFormat("MM", Locale.US);
        String str = sdf.format(dt);

        int month = Integer.parseInt(str);
        switch (month) {
            case 1:
            case 2:
            case 3:
                result = 1;
                break;
            case 4:
            case 5:
            case 6:
                result = 2;
                break;
            case 7:
            case 8:
            case 9:
                result = 3;
                break;
            case 10:
            case 11:
            case 12:
                result = 4;
                break;

        }

        return result;
    }

    public static int getHour(Date dt) {
        int result;

        DateFormat sdf = new SimpleDateFormat("HH", Locale.US);
        String str = sdf.format(dt);

        result = Integer.parseInt(str);

        return result;
    }

    public static int getMinute(Date dt) {
        int result;

        DateFormat sdf = new SimpleDateFormat("mm", Locale.US);
        String str = sdf.format(dt);

        result = Integer.parseInt(str);

        return result;
    }

    public static int getSecond(Date dt) {
        int result;

        DateFormat sdf = new SimpleDateFormat("ss", Locale.US);
        String str = sdf.format(dt);

        result = Integer.parseInt(str);

        return result;
    }

    public static int getMilliSec(Date dt) {
        int result;

        DateFormat sdf = new SimpleDateFormat("SSS", Locale.US);
        String str = sdf.format(dt);

        result = Integer.parseInt(str);

        return result;
    }

    public static String getCurrentMonth() {
        DateFormat sdf = new SimpleDateFormat("MM", Locale.US);
        String result = sdf.format(currentDateTime());

        return result;
    }

    public static String getCurrentYear() {
        DateFormat sdf = new SimpleDateFormat("yyyy", Locale.US);
        String result = sdf.format(currentDateTime());
        return result;
    }

    public static Date getDateTimeOfFirstDayInMonth(int month, int year) {
        String sMonth;
        String sYear;
        String sDay = "01";

        if (month == 0) {
            sMonth = getCurrentMonth();
        } else {
            sMonth = fillZeroNumber(month, 2);
        }

        if (year == 0) {
            sYear = getCurrentYear();
        } else {
            sYear = fillZeroNumber(year, 4);
        }

        String dt = sYear + sMonth + sDay + " 000000";

        Date result = null;
        DateFormat sdf = new SimpleDateFormat(DATE_TIME_FORMAT_7, Locale.US);
        try {
            result = sdf.parse(dt);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        return result;
    }

    public static Date getDateTimeOfLastDayInMonth(int month, int year) {
        String sMonth;
        String sYear;
        String sDay = null;

        if (month == 0) {
            sMonth = getCurrentMonth();
        } else {
            sMonth = fillZeroNumber(month, 2);
        }

        if (year == 0) {
            sYear = getCurrentYear();
        } else {
            sYear = fillZeroNumber(year, 4);
        }

        //find last day
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMM");
        Date convertedDate;
        try {
            convertedDate = dateFormat.parse(sYear + sMonth);
            Calendar c = Calendar.getInstance();
            c.setTime(convertedDate);

            int day = c.getActualMaximum(Calendar.DAY_OF_MONTH);
            sDay = fillZeroNumber(day, 2);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        String dt = sYear + sMonth + sDay + " 235959";

        Date result = null;
        DateFormat sdf = new SimpleDateFormat(DATE_TIME_FORMAT_7, Locale.US);
        try {
            result = sdf.parse(dt);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        return result;
    }

    public static Date getDateTimeFullOfFirstDayInMonth(int month, int year) {
        String sMonth;
        String sYear;
        String sDay = "01";

        if (month == 0) {
            sMonth = getCurrentMonth();
        } else {
            sMonth = fillZeroNumber(month, 2);
        }

        if (year == 0) {
            sYear = getCurrentYear();
        } else {
            sYear = fillZeroNumber(year, 4);
        }

        String dt = sYear + sMonth + sDay + " 000000000";

        Date result = null;
        DateFormat sdf = new SimpleDateFormat(DATE_TIME_FORMAT_8, Locale.US);
        try {
            result = sdf.parse(dt);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        return result;
    }

    public static Date getDateTimeFullOfLastDayInMonth(int month, int year) {
        String sMonth;
        String sYear;
        String sDay = null;

        if (month == 0) {
            sMonth = getCurrentMonth();
        } else {
            sMonth = fillZeroNumber(month, 2);
        }

        if (year == 0) {
            sYear = getCurrentYear();
        } else {
            sYear = fillZeroNumber(year, 4);
        }

        //find last day
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMM");
        Date convertedDate;
        try {
            convertedDate = dateFormat.parse(sYear + sMonth);
            Calendar c = Calendar.getInstance();
            c.setTime(convertedDate);

            int day = c.getActualMaximum(Calendar.DAY_OF_MONTH);
            sDay = fillZeroNumber(day, 2);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        String dt = sYear + sMonth + sDay + " 235959999";

        Date result = null;
        DateFormat sdf = new SimpleDateFormat(DATE_TIME_FORMAT_8, Locale.US);
        try {
            result = sdf.parse(dt);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        return result;
    }

    public static Date getDateTimeFromInfo(int day, int month, int year, int hour,
            int minute, int second, int milliSec) {
        Date result = null;

        String sDate = fillZeroNumber(day, 2);
        String sMonth = fillZeroNumber(month, 2);
        String sYear = fillZeroNumber(year, 4);
        String sHour = fillZeroNumber(hour, 2);
        String sMinute = fillZeroNumber(minute, 2);
        String sSecond = fillZeroNumber(second, 2);
        String sMilliSec = fillZeroNumber(milliSec, 3);

        String sDt = sDate + "/" + sMonth + "/" + sYear + " " + sHour + ":" + sMinute + ":"
                + sSecond + ":" + sMilliSec;

        result = convertString2DateTime(sDt, DATE_TIME_FORMAT_1);

        return result;
    }

    public static Timestamp addMonth(long currentDateTime, int monthNum) {
        Calendar cal = Calendar.getInstance(Locale.US);
        cal.setTimeInMillis(currentDateTime);

        cal.add(Calendar.MONTH, monthNum);

        Timestamp ts = new Timestamp(cal.getTimeInMillis());
        return ts;
    }

    public static Timestamp addDay(long currentDateTime, int dayNum) {
        Calendar cal = Calendar.getInstance(Locale.US);
        cal.setTimeInMillis(currentDateTime);

        cal.add(Calendar.DAY_OF_MONTH, dayNum);

        Timestamp ts = new Timestamp(cal.getTimeInMillis());
        return ts;
    }

    public static Timestamp addYear(long currentDateTime, int yearNum) {
        Calendar cal = Calendar.getInstance(Locale.US);
        cal.setTimeInMillis(currentDateTime);

        cal.add(Calendar.YEAR, yearNum);

        Timestamp ts = new Timestamp(cal.getTimeInMillis());
        return ts;
    }
    
    public static Timestamp addMin(long currentDateTime, int minNum) {
        Calendar cal = Calendar.getInstance(Locale.US);
        cal.setTimeInMillis(currentDateTime);

        cal.add(Calendar.MINUTE, minNum);

        Timestamp ts = new Timestamp(cal.getTimeInMillis());
        return ts;
    }

    public static int findDay(String date) {
        // DD/MM/YYYY
        return new Integer(date.substring(0, 2));
    }

    public static int findMonth(String date) {
        // DD/MM/YYYY
        return new Integer(date.substring(3, 5));
    }

    public static int findYear(String date) {
        // DD/MM/YYYY
        return new Integer(date.substring(6, 10));
    }

    public static boolean isBeforeDate(String startDate, String endDate) {
        // DD/MM/YYYY
        int day = findDay(startDate);
        int month = findMonth(startDate);
        int year = findYear(startDate);
        month--;
        Calendar startCal = new GregorianCalendar(year, month, day);

        day = findDay(endDate);
        month = findMonth(endDate);
        year = findYear(endDate);
        month--;
        Calendar endCal = new GregorianCalendar(year, month, day);

        return startCal.before(endCal);
    }

    public static boolean isAfterDate(String startDate, String endDate) {
        // DD/MM/YYYY
        int day = findDay(startDate);
        int month = findMonth(startDate);
        int year = findYear(startDate);
        month--;
        Calendar startCal = new GregorianCalendar(year, month, day);

        day = findDay(endDate);
        month = findMonth(endDate);
        year = findYear(endDate);
        month--;
        Calendar endCal = new GregorianCalendar(year, month, day);

        return startCal.after(endCal);
    }

    public static boolean isEqualsDate(String startDate, String endDate) {
        // DD/MM/YYYY
        int day = findDay(startDate);
        int month = findMonth(startDate);
        int year = findYear(startDate);
        month--;
        Calendar startCal = new GregorianCalendar(year, month, day);

        day = findDay(endDate);
        month = findMonth(endDate);
        year = findYear(endDate);
        month--;
        Calendar endCal = new GregorianCalendar(year, month, day);

        return startCal.equals(endCal);
    }

    public static boolean isBeforeDateOrEqualsDate(String startDate,
            String endDate) {
        // DD/MM/YYYY
        boolean result = false;

        boolean b1 = isBeforeDate(startDate, endDate);
        boolean b2 = isEqualsDate(startDate, endDate);

        if ((b1 == true) || (b2 == true)) {
            result = true;
        }

        return result;
    }

    public static boolean isAfterDateOrEqualsDate(String startDate,
            String endDate) {
        // DD/MM/YYYY
        boolean result = false;

        boolean b1 = isAfterDate(startDate, endDate);
        boolean b2 = isEqualsDate(startDate, endDate);

        if ((b1 == true) || (b2 == true)) {
            result = true;
        }

        return result;
    }

    public static String convert2DateTimeForDB(long milliSec) {
        // ---> YYYY-MM-DD HH:mm:ss
        return convertDateTime2String(milliSec, DATE_TIME_FORMAT_5);
    }

    public static String convert2DateTimeForDB(Date dateTime) {
        // ---> YYYY-MM-DD HH:mm:ss
        long millSec = dateTime.getTime();
        return convert2DateTimeForDB(millSec);
    }

    public static String convert2DateTimeFullForDB(long milliSec) {
        // ---> YYYY-MM-DD HH:mm:ss:lll

        return convertDateTime2String(milliSec, DATE_TIME_FORMAT_6);
    }

    public static String convert2DateTimeFullForDB(Date dateTime) {
        // ---> YYYY-MM-DD HH:mm:ss:lll
        long millSec = dateTime.getTime();
        return convert2DateTimeFullForDB(millSec);
    }

    public static String elapseTimeMsg(long milisDiff) {
        if (milisDiff < 1000) {
            return "0 second";
        }

        String formattedTime = "";
        long secondInMillis = 1000;
        long minuteInMillis = secondInMillis * 60;
        long hourInMillis = minuteInMillis * 60;
        long dayInMillis = hourInMillis * 24;
        long weekInMillis = dayInMillis * 7;
        long monthInMillis = dayInMillis * 30;

        int timeElapsed[] = new int[6];
        // Define time units - plural cases are handled inside loop
        String timeElapsedText[] = {"second", "minute", "hour", "day", "week",
            "month"};
        timeElapsed[5] = (int) (milisDiff / monthInMillis); // months
        milisDiff = milisDiff % monthInMillis;
        timeElapsed[4] = (int) (milisDiff / weekInMillis); // weeks
        milisDiff = milisDiff % weekInMillis;
        timeElapsed[3] = (int) (milisDiff / dayInMillis); // days
        milisDiff = milisDiff % dayInMillis;
        timeElapsed[2] = (int) (milisDiff / hourInMillis); // hours
        milisDiff = milisDiff % hourInMillis;
        timeElapsed[1] = (int) (milisDiff / minuteInMillis); // minutes
        milisDiff = milisDiff % minuteInMillis;
        timeElapsed[0] = (int) (milisDiff / secondInMillis); // seconds

        // Only adds 3 significant high valued units
        for (int i = (timeElapsed.length - 1), j = 0; i >= 0 && j < 3; i--) {
            // loop from high to low time unit
            if (timeElapsed[i] > 0) {
                formattedTime += ((j > 0) ? ", " : "") + timeElapsed[i] + " "
                        + timeElapsedText[i]
                        + ((timeElapsed[i] > 1) ? "s" : "");
                ++j;
            }
        } // end for - build string

        return formattedTime;
    }
}