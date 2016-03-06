package com.nuc.device.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2015/11/24
 * Time:0:54
 */
public class CommonUtil {

	public static final double ZERO_AMOUNT = 0.00;
	public static final Double MINUTE_PER_HOUR = 60.0;
	
	public static final Integer DIFF_ONEHOUR = 3600000;

	/**
	 * Description: 将分钟数转为小时+分钟的描述 ps.69 TO 1小时9分钟
	 * 
	 * @param
	 *            minute 分钟
	 * @return String h小时m分钟
	 */
	public static String FromMinuteToHourAndMinute(Double minute) {
		if (minute == null) {
			return null;
		}
		if (minute.compareTo(MINUTE_PER_HOUR) < 0) {
			return new BigDecimal(minute).toString() + "分钟";
		}
		BigDecimal hourBd = new BigDecimal(minute / MINUTE_PER_HOUR);
		BigDecimal minuteBd = new BigDecimal(minute % MINUTE_PER_HOUR);
		if (hourBd == null || minuteBd == null) {
			return null;
		}
		hourBd = hourBd.setScale(0, BigDecimal.ROUND_DOWN);
		minuteBd = minuteBd.setScale(0, BigDecimal.ROUND_HALF_DOWN);
		StringBuffer hour = new StringBuffer();
		hour.append(hourBd.toString()).append("小时");
		if (minuteBd.intValue() != 0) {
			hour.append(minuteBd.toString()).append("分钟");
		}
		return hour.toString();
	}

	/**
	 * Description: 将double值转为字符串 去掉小数点后0，Ps. 3.0 to 3 || 3.7 to 3.7
	 * 
	 * @param d
	 * @return
	 */
	public static String doubleTrans(double d) {
		if (Math.round(d) - d == 0) {
			return String.valueOf((long) d);
		}
		return String.valueOf(d);
	}
	
	/**
	 * Description: 判断租车时间是否在一个小时内
	 * @param startTime 出发时间
	 * @param orderTime 订单创建时间
	 * @return
	 */
	public static boolean compareTime(Date startTime, Date orderTime){
		return (startTime.getTime() - orderTime.getTime()) > DIFF_ONEHOUR;
	}


    /**
     * 计算日期差值
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @param unit 单位
     * @return Integer
     */
    public static Integer timeDiff(Date startTime, Date endTime,Unit unit){

        if(startTime == null || endTime == null){
            return null;
        }

        long mileSecond = endTime.getTime()-startTime.getTime();

        long unitMileSecond = unit.getMileSecond();

        long timeDiff = mileSecond/unitMileSecond;

        return  (int)timeDiff;

    }
	
	/**
	 * 整型转长整型
	 * @param v
	 * @return
	 */
	public static Long int2Long(Integer v){
		if(v == null){
			return null;
		}
		String str = String.valueOf(v);
		return Long.valueOf(str);
	}
	
	/**
	 * double转BigDecimal
	 * Description: 
	 * @param doubleValue
	 * @return
	 */
	public static BigDecimal double2BigDecimal(Double doubleValue){
		BigDecimal bigDecimalValue = null;
		if(doubleValue == null){
			doubleValue = 0d;
		}
		bigDecimalValue = new BigDecimal(doubleValue);
		return bigDecimalValue;
	}


	public static enum Unit {
		DAY(3600000 * 24), HOUR(3600000);

		private long mileSecond;

		Unit(long mileSecond) {
			this.mileSecond = mileSecond;
		}

		public long getMileSecond() {
			return mileSecond;
		}
	}
	public static String toMD5String(String value){
		String result=null;
		try {
			MessageDigest messageDigest=MessageDigest.getInstance("MD5");
			BASE64Encoder base64Encoder=new BASE64Encoder();
			result=base64Encoder.encode(messageDigest.digest(value.getBytes("utf-8")));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}
	public static Integer long2Integer(Long value){
		if(value==null){
			return null;
		}
		return Integer.parseInt(value.toString());
	}
}
