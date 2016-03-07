package com.nuc.device.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * Created by leopold on 2015/7/20.
 */
public final class NumberUtil {
    private static final DecimalFormat myformat = new DecimalFormat("0.00");


    public static double sum(Number... number) {
        double result = 0;
        if (number != null) {
            for (Number num : number) {
                result += num.doubleValue();
            }
        }
        return result;
    }

    /**
     * 如果是null 则返回0
     *
     * @param value
     * @return
     */
    public static boolean isNull(Long value) {
        return value == null;
    }

    /**
     * Description: 如果null 返回0.0
     *
     * @param value
     * @return
     * @Version1.0 2015-9-9 上午9:45:51 by 杨利鹏（lpyang@10101111.com）创建
     */
    public static Double isNull(Double value) {
        return value == null ? 0.0 : value;
    }

    /**
     * 将数字格式化成2位小数
     *
     * @param number
     * @return
     */
    public static String fmt2p(Number number) {
        return myformat.format(number);
    }

    public static boolean anyEquals(Number obj, Number... param) {
        if (CollectionsTools.isNotEmpty(param)) {
            for (Number o : param) {
                if (NumberUtil.isEquals(obj, o)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 判断数值o1 和数值o2是否相等
     *
     * @param o1
     * @param o2
     * @return
     */
    public static boolean isEquals(Number o1, Number o2) {
        if (o1 == o2) {
            return true;
        } else if (o1 == null || o2 == null) {
            return false;
        } else if (o1 instanceof Double || o1 instanceof Float || o2 instanceof Double || o2 instanceof Float) {
            return o1.doubleValue() == o2.doubleValue();
        } else {
            return o1.longValue() == o2.longValue();
        }
    }

    public static Short parseShort(Object o) {
        if (o instanceof Number) {
            return ((Number) o).shortValue();
        } else if (o instanceof String) {
            try {
                return Short.parseShort((String) o);
            } catch (NumberFormatException e) {
                Double d = parseDouble(o);
                if (d != null)
                    return d.shortValue();
            }
        }
        return null;
    }

    public static Byte parseByte(Object o) {
        if (o instanceof Number) {
            return ((Number) o).byteValue();
        } else if (o instanceof String) {
            try {
                return Byte.parseByte((String) o);
            } catch (NumberFormatException e) {
                Double d = parseDouble(o);
                if (d != null)
                    return d.byteValue();
            }
        }
        return null;
    }


    public static Integer parseInt(Object o) {
        if (o instanceof Number) {
            return ((Number) o).intValue();
        } else if (o instanceof String) {
            try {
                return Integer.parseInt((String) o);
            } catch (NumberFormatException e) {
                Double d = parseDouble(o);
                if (d != null)
                    return d.intValue();
            }
        }
        return null;
    }

    public static Long parseLong(Object o) {
        if (o instanceof Number) {
            return ((Number) o).longValue();
        } else if (o instanceof String) {
            try {
                return Long.parseLong((String) o);
            } catch (NumberFormatException e) {
                Double d = parseDouble(o);
                if (d != null)
                    return d.longValue();
            }
        }
        return null;
    }

    /**
     * 如果是null 则返回0
     *
     * @param value
     * @return
     */
    public static int isNull0(Integer value) {
        return isNull(value, 0);
    }

    /**
     * 如果是null 则返回newValue
     *
     * @param value
     * @return
     */
    public static int isNull(Integer value, int newValue) {
        return value == null ? newValue : value;
    }

    /**
     * 如果是null
     *
     * @param value
     * @return
     */
    public static boolean isNull(Integer value) {
        return value == null;
    }

    public static Float parseFloat(Object o) {
        if (o instanceof Number) {
            return ((Number) o).floatValue();
        } else if (o instanceof String) {
            try {
                return Float.parseFloat((String) o);
            } catch (NumberFormatException e) {
                Double d = parseDouble(o);
                if (d != null)
                    return d.floatValue();
            }
        }
        return null;
    }

    public static Double parseDouble(Object o) {
        if (o instanceof Number) {
            return ((Number) o).doubleValue();
        } else if (o instanceof String) {
            try {
                return Double.parseDouble((String) o);
            } catch (NumberFormatException e) {
            }
        }
        return null;
    }

    /**
     * Description: 四舍五入
     *
     * @param enDouble 被四舍五入值
     * @param rountNum 精确到的位数：如：0,保留整数；1，保留一位小数
     * @return
     * @Version1.0 2015-7-31 下午12:03:05 by 陈永旺（yw.chen02@10101111.com）创建
     */
    public static Double roundDouble(Double enDouble, int rountNum) {
        if (enDouble == null) {
            return null;
        }

        BigDecimal bd = new BigDecimal(enDouble);
        return bd.setScale(rountNum, BigDecimal.ROUND_HALF_UP).doubleValue();

    }

    private NumberUtil() {

    }
}