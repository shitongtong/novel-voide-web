package com.zzy.novel.util;

/**
 * 转换类
 *
 * @Author shitongtong
 * <p>
 * Created by shitongtong on 2018/4/28.
 */
public class ParseUtil {
    /**
     * @param str
     * @param defaultDouble
     * @return double
     * @Author: lulei
     * @Description: 将字符串转化为double
     */
    public static double parseStringToDouble(String str, double defaultDouble) {
        double re = defaultDouble;
        try {
            re = Double.parseDouble(str);
        } catch (Exception e) {
        }
        return re;
    }

    /**
     * @param str
     * @param defaultInt
     * @return int
     * @Author: lulei
     * @Description: 将字符串转化为int
     */
    public static int parseStringToInt(String str, int defaultInt) {
        int re = defaultInt;
        try {
            re = Integer.parseInt(str);
        } catch (Exception e) {
        }
        return re;
    }

    /**
     * @param str
     * @param defaultLong
     * @return
     * @Author:lulei
     * @Description:将字符串转化为long
     */
    public static long parseStringToLong(String str, long defaultLong) {
        long re = defaultLong;
        try {
            re = Long.parseLong(str);
        } catch (Exception e) {
        }
        return re;
    }
}
