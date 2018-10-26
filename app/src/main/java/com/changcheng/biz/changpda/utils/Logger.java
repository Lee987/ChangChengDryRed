package com.changcheng.biz.changpda.utils;

import android.util.Log;

/**@author*/

public class Logger {
    private static boolean debug = true;
    private static int showLength = 3999;

    /**
     * 分段打印出较长log文本
     *
     * @param logContent 打印文本
     * @param tag        打印log的标记
     */
    public static void i(String tag, String logContent) {
        if (!debug) {
            return;
        }
        if (logContent.length() > showLength) {
            String show = logContent.substring(0, showLength);
            Log.i(tag, show);
            /*剩余的字符串如果大于规定显示的长度，截取剩余字符串进行递归，否则打印结果*/
            if ((logContent.length() - showLength) > showLength) {
                String partLog = logContent.substring(showLength, logContent.length());
                i(tag, partLog);
            } else {
                String printLog = logContent.substring(showLength, logContent.length());
                Log.i(tag, printLog);
            }
        } else {
            Log.i(tag, logContent);
        }
    }

    /**
     * 分段打印出较长log文本
     *
     * @param logContent 打印文本
     * @param tag        打印log的标记
     */
    public static void e(String tag, String logContent) {
        if (!debug) {
            return;
        }
        if (logContent.length() > showLength) {
            String show = logContent.substring(0, showLength);
            Log.e(tag, show);
            /*剩余的字符串如果大于规定显示的长度，截取剩余字符串进行递归，否则打印结果*/
            if ((logContent.length() - showLength) > showLength) {
                String partLog = logContent.substring(showLength, logContent.length());
                e(tag, partLog);
            } else {
                String printLog = logContent.substring(showLength, logContent.length());
                Log.e(tag, printLog);
            }
        } else {
            Log.e(tag, logContent);
        }
    }

    /**
     * 分段打印出较长log文本
     *
     * @param logContent 打印文本
     * @param tag        打印log的标记
     */
    public static void d(String tag, String logContent) {
        if (!debug) {
            return;
        }
        if (logContent.length() > showLength) {
            String show = logContent.substring(0, showLength);
            Log.d(tag, show);
            /*剩余的字符串如果大于规定显示的长度，截取剩余字符串进行递归，否则打印结果*/
            if ((logContent.length() - showLength) > showLength) {
                String partLog = logContent.substring(showLength, logContent.length());
                d(tag, partLog);
            } else {
                String printLog = logContent.substring(showLength, logContent.length());
                Log.d(tag, printLog);
            }
        } else {
            Log.d(tag, logContent);
        }
    }
}
