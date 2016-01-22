package com.nuc.device.util;

import java.util.Random;

/**
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2015/11/26
 * Time:0:57
 */
public class BuildSerialNumber {
    private final static char[] numberArry={'0','1','2','3',
            '4','5','6','7','8','9'};
    private final static Random random=new Random();
    public static String getCurrentTime(){
        return String.valueOf(System.currentTimeMillis());
    }
    public static String getSimpleNo(int length){
        StringBuilder stringBuilder=new StringBuilder(getCurrentTime());
        for(int i=0;i<length-13;i++){
            stringBuilder.append(numberArry[random.nextInt(10)]);
        }
        return stringBuilder.toString();
    }
}
