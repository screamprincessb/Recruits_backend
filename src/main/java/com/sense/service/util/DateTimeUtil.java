package com.sense.service.util;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import org.apache.commons.lang3.StringUtils;

public class DateTimeUtil {

    public final static String pattern = "dd-MMM-yyyy";
    public final static String PATTERN_DB = "yyyy-MM-dd";
    public final static String PATTERN_DT_DB = "yyyy-MM-dd HH:mm:ss";
    public final static String SELECT_FROM_TIME = " 00:00:00";
    public final static String SELECT_TO_TIME = " 23:59:59";
    public final static String PATTERN_SP = "yyyyMMdd";
    public final static String PATTERN_JSON = "dd/MM/yyyy";
    public final static long day = 1000 * 60 * 60 * 24;

    public static Date stringToDateDB(String date) {
        try {
            return date != null ? (new SimpleDateFormat(PATTERN_DT_DB, Locale.US)).parse(date.trim()) : null;
        } catch (ParseException ex) {
        }
        return null;
    }

    public static Date getFirstDayOfYear() {
        Calendar cal = new GregorianCalendar(Locale.US);
        cal.setTime(DateTimeUtil.getSystemDate());
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.DAY_OF_YEAR, 1);
        return cal.getTime();
    }

    public static Date getLastDayOfYear() {
        Calendar cal = new GregorianCalendar(Locale.US);
        cal.setTime(DateTimeUtil.getSystemDate());
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MONTH, 11);
        cal.set(Calendar.DAY_OF_MONTH, 31);
        return cal.getTime();
    }

    public static Date getFirstDay7() {
        Calendar cal = new GregorianCalendar(Locale.US);
        cal.setTime(DateTimeUtil.getSystemDate());
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.setTimeInMillis(System.currentTimeMillis() - (7 * day));
        return cal.getTime();
    }

    public static Date getFirstDayOfMonth() {
//        Calendar cal = new GregorianCalendar(Locale.US);
//        cal.setTime(DateTimeUtil.getSystemDate());
//        cal.set(Calendar.HOUR_OF_DAY, 0);
//        cal.set(Calendar.MINUTE, 0);
//        cal.set(Calendar.SECOND, 0);
//        cal.set(Calendar.DAY_OF_MONTH, 1);
        //
        Calendar cal = new GregorianCalendar(Locale.US);
        cal.setTime(DateTimeUtil.getSystemDate());
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.setTimeInMillis(System.currentTimeMillis() - (30 * day));
        return cal.getTime();
    }

    public static Date getFirstOneDayOfMonth() {
        Calendar cal = new GregorianCalendar(Locale.US);
        cal.setTime(DateTimeUtil.getSystemDate());
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.DAY_OF_MONTH, 1);

        return cal.getTime();
    }

    public static Date getLastDayOfMonth() {
        Calendar cal = new GregorianCalendar(Locale.US);
        cal.setTime(DateTimeUtil.getSystemDate());
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DATE));
        return cal.getTime();
    }

    public static boolean checkAfterDate(Date start, Date end) {
        boolean check = false;
        if (start != null && end != null) {
            if (start.after(end)) {
                check = true;
            }
        }
        return check;
    }

    public static String dateToStringReport(Date date) {
        DateFormat d = new SimpleDateFormat("d", new Locale("th", "TH"));
        DateFormat f = new SimpleDateFormat("yyyyMM", new Locale("th", "TH"));
        f.format(date);
        return d.format(date).concat(" ").concat(converMonthYear(f.format(date)));
    }

    public static String dateToStringTh(Date date, String pattern) {
        String dataStr = "";
        if (date != null) {
            DateFormat f = new SimpleDateFormat(pattern, new Locale("th", "TH"));
            dataStr = f.format(date);

        }

        return dataStr;
    }

    public static Date getFirstSystemDate() {
        Calendar cal = new GregorianCalendar(Locale.US);
        cal.setTime(DateTimeUtil.getSystemDate());
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        return cal.getTime();
    }

    public static Date getLastSystemDate() {
        Calendar cal = new GregorianCalendar(Locale.US);
        cal.setTime(DateTimeUtil.getSystemDate());
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        return cal.getTime();
    }

    public static Date getFirstSystemTime(Date date) {
        Calendar cal = new GregorianCalendar(Locale.US);
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        return cal.getTime();
    }

    public static Date getSystemDate() {
        Calendar c = new GregorianCalendar(Locale.US);
        return c.getTime();
    }

    public static Date getSystemDateThai() {
        Calendar c = new GregorianCalendar(Locale.US);
        return c.getTime();
    }

    public static String strCurrentDateOnPatternDate(String patternDate) {
        Calendar c = new GregorianCalendar(Locale.US);
        c.setTimeInMillis(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat(patternDate, Locale.US);
        return sdf.format(c.getTime());
    }

    public static Date stringToDate(String date) {
        try {
            return date != null ? (new SimpleDateFormat("yyyyMMdd HHmmss", Locale.US)).parse(date.trim()) : null;
        } catch (ParseException ex) {
        }
        return null;
    }

    public static Date stringToDateForGraph(String date) {
        Date d = null;
        try {
            if (date != null) {
                d = new SimpleDateFormat("yyyyMMdd HHmmss", Locale.US).parse(date.trim());
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(d);
                calendar.add(Calendar.HOUR, 7);
                return calendar.getTime();
            }
        } catch (ParseException ex) {
        }
        return d;
    }

    public static Date stringToDate2(String date) {
        try {
            return date != null ? (new SimpleDateFormat("yyyyMMdd", Locale.US)).parse(date.trim()) : null;
        } catch (ParseException ex) {
        }
        return null;
    }

    public static Date stringToDateTime(String date, String format) {
        try {
            return date != null ? (new SimpleDateFormat(format, Locale.US)).parse(date.trim()) : null;
        } catch (ParseException ex) {
        }
        return null;
    }

    public static Date getDateLong(String l) {
        if (l == null) {
            return null;
        }
        return new Date(Long.parseLong(l));
    }

    public static Date getDateLong(long l) {
        if (l == 0 || l < 0) {
            return null;
        }

        return new Date(l);
    }

    public static String converMonthYear(String dateStr) {
        if (dateStr.length() < 6) {
            return null;
        } else {
            String yyyy = dateStr.substring(0, 4);
            String mm = dateStr.substring(4, 6);
            if (null != mm) {
                switch (mm) {
                    case "01":
                        mm = "มกราคม";
                        break;
                    case "02":
                        mm = "กุมภาพันธ์";
                        break;
                    case "03":
                        mm = "มีนาคม";
                        break;
                    case "04":
                        mm = "เมษายน";
                        break;
                    case "05":
                        mm = "พฤษภาคม";
                        break;
                    case "06":
                        mm = "มิถุนายน";
                        break;
                    case "07":
                        mm = "กรกฎาคม";
                        break;
                    case "08":
                        mm = "สิงหาคม";
                        break;
                    case "09":
                        mm = "กันยายน";
                        break;
                    case "10":
                        mm = "ตุลาคม";
                        break;
                    case "11":
                        mm = "พฤศจิกายน";
                        break;
                    case "12":
                        mm = "ธันวาคม";
                        break;
                    default:
                        break;
                }
            }
            return mm + " " + yyyy;
        }
    }

    public static String converMonthYearTH(String dateStr) {
        if (dateStr.length() < 6) {
            return null;
        } else {
            String yyyy = dateStr.substring(0, 4);
            String mm = dateStr.substring(4, 6);
            if (null != mm) {
                switch (mm) {
                    case "01":
                        mm = "มกราคม";
                        break;
                    case "02":
                        mm = "กุมภาพันธ์";
                        break;
                    case "03":
                        mm = "มีนาคม";
                        break;
                    case "04":
                        mm = "เมษายน";
                        break;
                    case "05":
                        mm = "พฤษภาคม";
                        break;
                    case "06":
                        mm = "มิถุนายน";
                        break;
                    case "07":
                        mm = "กรกฎาคม";
                        break;
                    case "08":
                        mm = "สิงหาคม";
                        break;
                    case "09":
                        mm = "กันยายน";
                        break;
                    case "10":
                        mm = "ตุลาคม";
                        break;
                    case "11":
                        mm = "พฤศจิกายน";
                        break;
                    case "12":
                        mm = "ธันวาคม";
                        break;
                    default:
                        break;
                }
            }
            return mm + " " + String.valueOf(Integer.valueOf(yyyy) + 543);
        }
    }

    public static String converMonthYear2(String dateStr) {
        if (dateStr.length() < 6) {
            return null;
        } else {
            String yyyy = dateStr.substring(0, 4);
            String mm = dateStr.substring(4, 6);
            if (null != mm) {
                switch (mm) {
                    case "01":
                        mm = "ม.ค.";
                        break;
                    case "02":
                        mm = "ก.พ.";
                        break;
                    case "03":
                        mm = "มี.ค.";
                        break;
                    case "04":
                        mm = "เม.ย.";
                        break;
                    case "05":
                        mm = "พ.ค.";
                        break;
                    case "06":
                        mm = "มิ.ย.";
                        break;
                    case "07":
                        mm = "ก.ค.";
                        break;
                    case "08":
                        mm = "ส.ค.";
                        break;
                    case "09":
                        mm = "ก.ย.";
                        break;
                    case "10":
                        mm = "ต.ค.";
                        break;
                    case "11":
                        mm = "พ.ย.";
                        break;
                    case "12":
                        mm = "ธ.ค.";
                        break;
                    default:
                        break;
                }
            }
            return mm + " " + yyyy;
        }
    }

    public static String converMonthDesc(String month) {
        String mm = "";

        if (null != month) {
            switch (month) {
                case "01":
                    mm = "มกราคม";
                    break;
                case "02":
                    mm = "กุมภาพันธ์";
                    break;
                case "03":
                    mm = "มีนาคม";
                    break;
                case "04":
                    mm = "เมษายน";
                    break;
                case "05":
                    mm = "พฤษภาคม";
                    break;
                case "06":
                    mm = "มิถุนายน";
                    break;
                case "07":
                    mm = "กรกฎาคม";
                    break;
                case "08":
                    mm = "สิงหาคม";
                    break;
                case "09":
                    mm = "กันยายน";
                    break;
                case "10":
                    mm = "ตุลาคม";
                    break;
                case "11":
                    mm = "พฤศจิกายน";
                    break;
                case "12":
                    mm = "ธันวาคม";
                    break;
                default:
                    break;
            }
        }
        return mm;
    }

    public static String converMonthDescEn(String month) {
        String mm = "";
        if (null != month) {
            switch (month) {
                case "01":
                    mm = "Jan";
                    break;
                case "02":
                    mm = "Feb";
                    break;
                case "03":
                    mm = "Mar";
                    break;
                case "04":
                    mm = "Apr";
                    break;
                case "05":
                    mm = "May";
                    break;
                case "06":
                    mm = "Jun";
                    break;
                case "07":
                    mm = "Jul";
                    break;
                case "08":
                    mm = "Aug";
                    break;
                case "09":
                    mm = "Sep";
                    break;
                case "10":
                    mm = "Oct";
                    break;
                case "11":
                    mm = "Nov";
                    break;
                case "12":
                    mm = "Dec";
                    break;
                default:
                    break;
            }
        }
        return mm;
    }

    public static String converReportTitle(String yearFrom, String yearTo, String monthFrom, String monthTo) {
        String reportTitle;
        String yf = String.valueOf(Integer.valueOf(yearFrom) + 543);
        String yt = String.valueOf(Integer.valueOf(yearTo) + 543);
        reportTitle = converMonthYear(yf + monthFrom) + " ถึง " + converMonthYear(yt + monthTo);
        return reportTitle;
    }

    public static List<String> converDayDesc(String[] days) {
        List<String> result = new ArrayList<>();
        if (days.length == 0) {
            return result;
        } else {
            for (int i = 0; i < days.length; i++) {
                String day = days[i];
                if (null != day) {
                    switch (day) {
                        case "2":
                            result.add("จันทร์");
                            break;
                        case "3":
                            result.add("อังคาร");
                            break;
                        case "4":
                            result.add("พุธ");
                            break;
                        case "5":
                            result.add("พฤหัสบดี");
                            break;
                        case "6":
                            result.add("ศุกร์");
                            break;
                        case "7":
                            result.add("เสาร์");
                            break;
                        default:
                            result.add("อาทิตย์");
                            break;
                    }
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {

//        System.out.println("1." + getDateLong("1442854203"));
//        long l = 1442854203 * 1000;
//        System.out.println(getLastDayOfYear());
        System.out.println("aaaa>>>>" + dateToStringTh(DateTimeUtil.getSystemDate(), "yyyy"));
    }

    /**
     * add days to date in java
     *
     * @param date
     * @param days
     * @return
     */
    public static Date addDays(Date date, int days) {
        GregorianCalendar cal = new GregorianCalendar(Locale.US);
        cal.setTime(date);
        cal.add(Calendar.DATE, days);

        return cal.getTime();
    }

    /**
     * subtract days to date in java
     *
     * @param date
     * @param days
     * @return
     */
    public static Date subtractDays(Date date, int days) {
        GregorianCalendar cal = new GregorianCalendar(Locale.US);
        cal.setTime(date);
        cal.add(Calendar.DATE, -days);

        return cal.getTime();
    }

    public static String dateToStringReportMonthYear(Date date) {
        DateFormat f = new SimpleDateFormat("yyyyMM", new Locale("th", "TH"));
        f.format(date);
        return converMonthYear(f.format(date));
    }

    public static String dateToString(Date date, String pattern, Locale l) {
        if (StringUtils.isBlank(pattern)) {
            pattern = "dd-MM-yyyy";
        }
        return date != null ? (new SimpleDateFormat(pattern, l)).format(date) : null;
    }

    public static String converDayMonthYear2(String dateStr) {
        if (dateStr.length() < 6) {
            return null;
        } else {
            String yyyy = dateStr.substring(0, 4);
            String mm = dateStr.substring(4, 6);
            String dd = dateStr.substring(6, 8);
            if (null != mm) {
                switch (mm) {
                    case "01":
                        mm = "ม.ค.";
                        break;
                    case "02":
                        mm = "ก.พ.";
                        break;
                    case "03":
                        mm = "มี.ค.";
                        break;
                    case "04":
                        mm = "เม.ย.";
                        break;
                    case "05":
                        mm = "พ.ค.";
                        break;
                    case "06":
                        mm = "มิ.ย.";
                        break;
                    case "07":
                        mm = "ก.ค.";
                        break;
                    case "08":
                        mm = "ส.ค.";
                        break;
                    case "09":
                        mm = "ก.ย.";
                        break;
                    case "10":
                        mm = "ต.ค.";
                        break;
                    case "11":
                        mm = "พ.ย.";
                        break;
                    case "12":
                        mm = "ธ.ค.";
                        break;
                    default:
                        break;
                }
            }
            return dd + " " + mm + " " + String.valueOf(Integer.valueOf(yyyy) + 543);
        }
    }

    public static String dateToStringReportFull(Date date) {
//        DateFormat d = new SimpleDateFormat("d", new Locale("th", "TH"));
//        DateFormat f = new SimpleDateFormat("yyyyMM", new Locale("th", "TH"));
//        f.format(date);
//        return "วัน".concat(converDayDesc(date).concat("ที่ ").concat(d.format(date).concat(" ").concat(converMonthYear(f.format(date)))));
        Format formatter1 = new SimpleDateFormat("EEEE ที่ d MMMM พ.ศ. yyyy", new Locale("th", "TH", "TH"));
        return formatter1.format(date);
    }

    public static String dateToStringReportFull2(Date date) {
//        DateFormat d = new SimpleDateFormat("d", new Locale("th", "TH"));
//        DateFormat f = new SimpleDateFormat("yyyyMM", new Locale("th", "TH"));
//        f.format(date);
//        return "วันที่ ".concat(d.format(date).concat(" ").concat(converMonthYear(f.format(date))));
        Format formatter = new SimpleDateFormat("วันที่ d MMMM พ.ศ. yyyy", new Locale("th", "TH", "TH"));
        return formatter.format(date);
    }

    public static String dateToStringReportArabic(Date date) {
//        DateFormat d = new SimpleDateFormat("d", new Locale("th", "TH"));
//        DateFormat f = new SimpleDateFormat("yyyyMM", new Locale("th", "TH"));
//        f.format(date);
//        return "วันที่ ".concat(d.format(date).concat(" ").concat(converMonthYear(f.format(date))));
        Format formatter = new SimpleDateFormat("วันที่ d MMMM พ.ศ. yyyy", new Locale("th", "TH"));
        return formatter.format(date);
    }
}
