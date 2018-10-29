package com.changcheng.biz.changpda.utils;

import com.changcheng.biz.changpda.R;
import com.changcheng.biz.changpda.base.BaseApplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TimeUtil {

    public static final String FORMAT_1 = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMAT_2 = "yyyy.MM.dd";
    public static final String FORMAT_3 = "yyyy-MM-dd";
    public static final String FORMAT_4 = "yyyy.MM.dd HH:mm:ss";

    public static final String FORMAT_YYYYMM = "yyyy-MM";
    public static final String FORMAT_YYYYMMDD = "yyyy-MM-dd";
    public static final String FORMAT_YYYYMMDD_2 = "yyyy/MM/dd";
    public static final String FORMAT_YYYYMMDD_3 = "yyyy年MM月dd日";

    public static final String FORMAT_YYYYMM01 = "yyyy-MM-01";
    public static final String FORMAT_YYYYMMDDHHMM = "yyyy-MM-dd HH:mm";
    public static final String FORMAT_YYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMAT_HHMMSS = "yyyy-MM-dd HH:mm:ss +0000";
    public static final String FORMAT_HHMM = "HH:mm";
    public static final String FORMAT_MM_DD_HHMM = "MM/dd HH:mm";

    public static String getTime(long time, String format) {
        if (time < 1000) {
            return "";
        } else {
            SimpleDateFormat myFmt = new SimpleDateFormat(format);
            Date date = new Date(time);
            return myFmt.format(date);
        }
    }

    public static String formatValidityDate(long dateBegin, long dateEnd) {
        return BaseApplication.getIntance().getString(R.string.text_money_date, format(dateBegin, FORMAT_YYYYMMDD), format(dateEnd, FORMAT_YYYYMMDD));
    }

    public static String format(long date, String formatStr) {
        if (date == 0l){
            return "    暂无    ";
        }
        SimpleDateFormat format = new SimpleDateFormat(formatStr);
        return format.format(new Date(date));
    }

    public static long parse(String str, String formatStr) {
        SimpleDateFormat format = new SimpleDateFormat(formatStr);
        try {
            return format.parse(str).getTime();
        } catch (ParseException e) {
            return 0;
        }
    }

    public static int getSeason(Date date) {

        int season = 0;

        Calendar c = Calendar.getInstance();
        if (date!=null)c.setTime(date);
        int month = c.get(Calendar.MONTH);
        switch (month) {
            case Calendar.JANUARY:
            case Calendar.FEBRUARY:
            case Calendar.MARCH:
                season = 1;
                break;
            case Calendar.APRIL:
            case Calendar.MAY:
            case Calendar.JUNE:
                season = 2;
                break;
            case Calendar.JULY:
            case Calendar.AUGUST:
            case Calendar.SEPTEMBER:
                season = 3;
                break;
            case Calendar.OCTOBER:
            case Calendar.NOVEMBER:
            case Calendar.DECEMBER:
                season = 4;
                break;
            default:
                break;
        }
        return season;
    }
    public static String getStrNum(String args) {
        String regEx = "[^0-9]";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(args);
        return matcher.replaceAll("").trim();
    }
}
