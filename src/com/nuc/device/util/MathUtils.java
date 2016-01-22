package com.nuc.device.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2015/11/24
 * Time:0:54
 */
public class MathUtils {

    /**
     * 乘法(四舍五入)
     * @param a
     * @param b
     * @return
     */
    public static Double multiplication (Double a,Double b){

        BigDecimal aDecimal = new BigDecimal(0);
        BigDecimal bDecimal = new BigDecimal(0);

        if(a != null){
            aDecimal = new BigDecimal(String.valueOf(a));
        }

        if(b != null){
            bDecimal = new BigDecimal(String.valueOf(b));
        }


        BigDecimal result = aDecimal.multiply(bDecimal).setScale(0,BigDecimal.ROUND_HALF_UP);

        return result.doubleValue();

    }

    /**
     * 减法
     * @param a
     * @param b
     * @return
     */
    public static Double subtraction (Double a,Double b){

        BigDecimal aDecimal = new BigDecimal(0);
        BigDecimal bDecimal = new BigDecimal(0);

        if(a != null){
            aDecimal = new BigDecimal(String.valueOf(a));
        }

        if(b != null){
            bDecimal = new BigDecimal(String.valueOf(b));
        }


        BigDecimal result = aDecimal.subtract(bDecimal);

        return result.doubleValue();

    }


    /**
     * 除法
     * @param a
     * @param b
     * @return
     */
    public static Double division(Double a,Double b,Integer precision){

        BigDecimal aDecimal = new BigDecimal(0);
        BigDecimal bDecimal = new BigDecimal(0);

        if(a != null){
            aDecimal = new BigDecimal(String.valueOf(a));
        }

        if(b != null){
            bDecimal = new BigDecimal(String.valueOf(b));
        }


        BigDecimal result = aDecimal.divide(bDecimal, precision, RoundingMode.HALF_DOWN);

        return result.doubleValue();

    }


    /**
     * 加法
     * @param a
     * @param b
     * @return
     */
    public static Double add(Double a, Double b) {

        BigDecimal aDecimal = new BigDecimal(0);
        BigDecimal bDecimal = new BigDecimal(0);

        if(a != null){
            aDecimal = new BigDecimal(String.valueOf(a));
        }

        if(b != null){
            bDecimal = new BigDecimal(String.valueOf(b));
        }


        BigDecimal result = aDecimal.add(bDecimal);

        return result.doubleValue();
    }
    
    /**
     * 乘法保留2为小数
     * @param a
     * @param b
     * @return
     */
    public static Double multiplicationPointTwo (Double a,Double b){

        BigDecimal aDecimal = new BigDecimal(0);
        BigDecimal bDecimal = new BigDecimal(0);
        java.text.DecimalFormat   df   =new   java.text.DecimalFormat("#.00"); 
        if(a != null){
            aDecimal = new BigDecimal(String.valueOf(a));
        }

        if(b != null){
            bDecimal = new BigDecimal(String.valueOf(b));
        }

         
        Double result=Double.valueOf(df.format(aDecimal.multiply(bDecimal)));
        return result;

    }
    
    /**
     * 减法保留2为小数
     * @param a
     * @param b
     * @return
     */
    public static Double subtractionPointTwo (Double a,Double b){

        BigDecimal aDecimal = new BigDecimal(0);
        BigDecimal bDecimal = new BigDecimal(0);
        java.text.DecimalFormat   df   =new   java.text.DecimalFormat("#.00"); 
        if(a != null){
            aDecimal = new BigDecimal(String.valueOf(a));
        }

        if(b != null){
            bDecimal = new BigDecimal(String.valueOf(b));
        }


        Double result=Double.valueOf(df.format(aDecimal.subtract(bDecimal)));

        return result;

    }
    
    /**
     * 加法保留2为小数
     * @param a
     * @param b
     * @return
     */
    public static Double addPointTwo(Double a, Double b) {

        BigDecimal aDecimal = new BigDecimal(0);
        BigDecimal bDecimal = new BigDecimal(0);
        java.text.DecimalFormat   df   =new   java.text.DecimalFormat("#.00"); 
        if(a != null){
            aDecimal = new BigDecimal(String.valueOf(a));
        }

        if(b != null){
            bDecimal = new BigDecimal(String.valueOf(b));
        }


        Double result=Double.valueOf(df.format(aDecimal.add(bDecimal)));

        return result;
    }
    
    /**
     * 除法
     * @param a
     * @param b
     * @return
     */
    public static Double divisionPrecision(Double a,Double b,Integer precision){

        BigDecimal aDecimal = new BigDecimal(0);
        BigDecimal bDecimal = new BigDecimal(0);
       //java.text.DecimalFormat   df   =new   java.text.DecimalFormat("#.00"); 
        if(a != null){
            aDecimal = new BigDecimal(String.valueOf(a));
        }

        if(b != null){
            bDecimal = new BigDecimal(String.valueOf(b));
        }


        BigDecimal result = aDecimal.divide(bDecimal, precision, BigDecimal.ROUND_FLOOR);

        return result.doubleValue();

    }
    /**
     * 
     * @param d
     * @param n
     * @return
     */
    
    public static double getCeil(double d,int n){
		BigDecimal b = new BigDecimal(String.valueOf(d));
		b = b.divide(BigDecimal.ONE,n,BigDecimal.ROUND_CEILING);
		return b.doubleValue();
	}


}
