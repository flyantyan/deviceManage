package com.nuc.device.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

/**
 * Created by guoqiang on 2015/06/02.
 * 时间工具类
 */
public final class TimeTools {
    private static final long MI_OF_HOUR = 60 * 60 * 1000;//1小时毫秒数
    private static final String YYYY_MM_DD = "yyyy-MM-dd";
    private static final String YYYY_MM_DD_HH_MI_SS = "yyyy-MM-dd HH:mm:ss";
    private static final String YYYY_MM_DD_HH_MI_SS_S = "yyyy-MM-dd HH:mm:ss.SSS";

    public static String format(Date date, String format) {
        if (date == null || format == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    public static String format4YYYYMMDD(Date date) {
        return format(date, YYYY_MM_DD);
    }

    public static String formatAllTime(Date date) {
        return format(date, YYYY_MM_DD_HH_MI_SS_S);
    }

    public static String format4YYYYMMDDHHMISS(Date date) {
        return format(date, YYYY_MM_DD_HH_MI_SS);
    }

    public static Date parse(String time, String format) {
        if (StringTools.isEmpty(time)) {
            return null;
        }
        try {
            return new SimpleDateFormat(format).parse(time);
        } catch (ParseException e) {
        }
        return null;
    }

    public static Date parseYYYY_MM_DD(String time) {
        return parse(time, YYYY_MM_DD);
    }

    public static Date parseYYYY_MM_DD_HH_MI_SS(String time) {
        return parse(time, YYYY_MM_DD_HH_MI_SS);
    }


    public static String getNowTimeStr() {
        return format4YYYYMMDDHHMISS(createNowTime());
    }

    /**
     * 克隆一个新的时间对象
     *
     * @param date
     * @return
     */
    public static Date cloneDate(Date date) {
        return new Date(date.getTime());
    }

    /**
     * 创建一个当前时间的时间对象
     *
     * @return
     */
    public static Date createNowTime() {
        return getCalendar().getTime();
    }

    public static String getNowTimeAllStr() {
        return formatAllTime(createNowTime());
    }

    /**
     * 根据年月日创建时间 时分秒默认为0
     *
     * @param year
     * @param month
     * @param date
     * @return
     */
    public static Date createTime(int year, int month, int date) {
        return createTime(year, month, date, 0, 0, 0);
    }

    /**
     * 根据年月日时分秒创建时间
     *
     * @param year
     * @param month
     * @param date
     * @param hour
     * @param minute
     * @param second
     * @return
     */
    public static Date createTime(int year, int month, int date, int hour, int minute, int second) {
        Calendar calendar = getCalendar();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, date);
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, second);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }


    /**
     * Description: 返回需要获得的某一天的结束时间 如 昨天的结束时间:2015-08-09 23:59:59
     *
     * @param date
     * @param selectDate 想要获取的时间参数  以当天为例 -1表示前一天   +1表示后一天  0 表示 当天
     * @Version1.0 2015-8-10 上午9:01:57 by 雷霆（leiting01@10101111.com）创建
     */
    public static void setEndDay(Date date, int selectDate) {
        if (date == null) {
            return;
        }
        Calendar calendar = getCalendar();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        calendar.add(Calendar.DATE, selectDate);
        date.setTime(calendar.getTimeInMillis());
    }

    /**
     * Description: 返回需要获得的某一天的开始时间 如 2015-08-09 00:00:00
     *
     * @param date
     * @param selectDate 想要获取的时间参数  以当天为例 -1表示前一天   +1表示后一天  0 表示 当天
     * @Version1.0 2015-8-10 上午9:01:57 by 雷霆（leiting01@10101111.com）创建
     */
    public static void setStartDay(Date date, int selectDate) {
        if (date == null) {
            return;
        }
        Calendar calendar = getCalendar();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.add(Calendar.DATE, selectDate);
        date.setTime(calendar.getTimeInMillis());
    }


    /**
     * Description: 该方法用于获取想要的某一天的开始时间 如 2015-08-09 00:00:00
     *
     * @param date       需要设置的日期
     * @param selectDate 需要设置的天数
     * @return
     * @Version1.0 2015-8-25 上午10:42:57 by 雷霆（leiting01@10101111.com）创建
     */
    public static boolean setSomeDay0H0M0S(Date date, Integer selectDate) {
        Calendar calendar = getCalendar();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.add(Calendar.DATE, selectDate);
        date.setTime(calendar.getTimeInMillis());
        return true;
    }


    /**
     * 时间设置到明天的0点0分0秒
     *
     * @param date
     */
    public static void setNextDay0H0M0S0MS(Date date) {
        Calendar calendar = getCalendar();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.add(Calendar.DATE, 1);
        date.setTime(calendar.getTimeInMillis());
    }

    /**
     * 设置Date到当天的0点0分0秒0毫秒
     *
     * @param date
     */
    public static void set0H0M0S0MS(Date date) {
        Calendar calendar = getCalendar();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        date.setTime(calendar.getTimeInMillis());
    }

    public static void setLastDay0H0M0S(Date date) {
        Calendar calendar = getCalendar();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.add(Calendar.DATE, -1);
        date.setTime(calendar.getTimeInMillis());
    }

    public static void setLastMonth1D0H0M0S(Date date) {
        Calendar calendar = getCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.add(Calendar.MONTH, -1);
        date.setTime(calendar.getTimeInMillis());
    }

    public static void setDate(Date date, int field, int value) {
        Calendar calendar = getCalendar();
        calendar.setTime(date);
        calendar.set(field, value);
        date.setTime(calendar.getTimeInMillis());
    }

    /**
     * 返回2个时间中间相差的unit数量
     *
     * @param date1
     * @param date2
     * @param unit
     * @return
     */
    public static long dateDiff(Date date1, Date date2, TimeUnit unit) {
        return (date2.getTime() - date1.getTime()) / unit.toMillis(1);
    }

    /**
     * 得到当前时期是几号
     *
     * @param date
     * @return
     */
    public static int getMonthDate(Date date) {
        Calendar calendar = getCalendar();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    public static int getMonth(Date date) {
        Calendar calendar = getCalendar();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH);
    }

    public static int getYear(Date date) {
        Calendar calendar = getCalendar();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }


    /**
     * 判断time1是否在time2的一小时之后
     *
     * @param time1
     * @param time2
     * @return
     */
    public static boolean afterOneHour(Date time1, Date time2) {
        return (time1.getTime() - time2.getTime()) > MI_OF_HOUR;
    }

    public static Calendar getCalendar() {
        return Calendar.getInstance();
    }

    /**
     * Description: 获取当前月份
     *
     * @return
     * @Version1.0 2015-7-21 下午8:23:03 by 陈永旺（yw.chen02@10101111.com）创建
     */
    public static int getCurrentMonth(Date date) {
        GregorianCalendar g = new GregorianCalendar();
        g.setTime(date);
        int month = (int) g.get(Calendar.MONTH) + 1;

        return month;
    }

    /**
     * Description: 获取指定日期为星期几（星期日为1，星期六为7）
     *
     * @return
     * @Version1.0 2015-7-21 下午8:23:05 by 陈永旺（yw.chen02@10101111.com）创建
     */
    public static int getWeekByDate(Date date) {
        GregorianCalendar g = new GregorianCalendar();
        g.setTime(date);
        int week = (int) g.get(Calendar.DAY_OF_WEEK);

        return week;
    }

    /**
     * Description: 获取指定日期，的指定天数后的日期
     *
     * @param inDate
     * @param dayNum
     * @return
     * @Version1.0 2015-8-3 下午4:53:07 by 陈永旺（yw.chen02@10101111.com）创建
     */
    public static Date getDateAfterNum(Date inDate, int dayNum) {
        Calendar calendar = getCalendar();
        calendar.setTime(inDate);
        calendar.add(Calendar.DATE, dayNum);
        return calendar.getTime();
    }

    /**
     * Description: 返回需要获得的某一天的开始时间 如 2015-08-09 00:00:00
     *
     * @param date
     * @param selectDate 想要获取的时间参数  以当天为例 -1表示前一天   +1表示后一天  0 表示 当天
     * @return
     * @Version1.0 2015-8-26 上午9:30:56 by 杨利鹏（lpyang@10101111.com）创建
     */
    public static Date getStartDay(Date date, int selectDate) {

        Calendar calendar = getCalendar();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.add(Calendar.DATE, selectDate);
        date.setTime(calendar.getTimeInMillis());
        return date;
    }

    /**
     * Description: 获取date在当天的第几个小时
     *
     * @param date
     * @return
     */
    public static int getHours(Date date) {
        Calendar calendar = getCalendar();
        calendar.setTime(date);
        return calendar.get(Calendar.HOUR_OF_DAY);
    }


    /**
     * 将当前时间增加几分钟
     *
     * @param date
     * @param minute
     * @return
     */
    public static Date addMinutes(Date date, int minute) {

        Calendar calendar = getCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, minute);
        return calendar.getTime();

    }

    /**
     * 比较两个时间大小
     *
     * @param dateA
     * @param dateB
     * @return
     */
    public static Date getBigger(Date dateA, Date dateB) {
        if (dateA.before(dateB))
            return dateB;
        else
            return dateA;
    }

    /**
     * 获取日期的时分
     *
     * @param date
     * @return
     */
    public static String getHourAndMinute(Date date) {
        int hour = date.getHours();
        int minute = date.getMinutes();
        if (minute < 10) {
            return hour + ":0" + minute;
        } else {
            return hour + ":" + minute;
        }
    }

    public static Date parseDate(Object o) {
        if (o instanceof Date) {
            return (Date) o;
        } else if (o instanceof Number) {
            return new Date(((Number) o).longValue());
        } else if (o instanceof String) {
            Long num = NumberUtil.parseLong(o);
            if (num != null) {
                return new Date(num);
            } else {
                String str = o.toString();
                Date date = parse(o.toString(), YYYY_MM_DD_HH_MI_SS_S);
                if (date == null) {
                    date = parseYYYY_MM_DD_HH_MI_SS(str);
                }
                if (date == null) {
                    date = parseYYYY_MM_DD(str);
                }
                return date;
            }
        }
        return null;
    }

    private TimeTools() {
    }

    public static void addTimeField(Date date, int timeField, int offset) {
        Calendar calendar = getCalendar();
        calendar.setTime(date);
        calendar.add(timeField,offset);
        date.setTime(calendar.getTimeInMillis());
    }
}
