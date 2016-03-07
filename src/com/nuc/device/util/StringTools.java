package com.nuc.device.util;

import com.alibaba.fastjson.JSON;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by guoqiang on 2015/6/29.
 */
public final class StringTools {
    private static final String CURRENT_PROJECT_PACKAGE_NAME = "com.ucar.cdms";

    public static String getStatementParameter(String str, Object... objects) {
        if (!isBlank(str)) {
            if (objects != null && objects.length > 0) {
                for (int i = 0; i < objects.length; i++) {
                    str = str.replace("${" + i + "}", objects[i] == null ? ""
                            : objects[i].toString());
                }
            }
        }
        return str;
    }

    /**
     * 格式化参数方便打印日志
     *
     * @param objects
     * @return
     */
    public static String formatParam(Object... objects) {
        StringBuilder builder = new StringBuilder(1024);
        builder.append("param{");
        if (CollectionsTools.isNotEmpty(objects)) {
            for (int i = 0; i < objects.length; i += 2) {
                if (i != 0) {
                    builder.append(",");
                }
                Object o1 = objects[i];
                builder.append(o1).append("=");
                if ((i + 1) < objects.length) {
                    builder.append(objects[i + 1]);
                }
            }
        }
        builder.append("}");
        return builder.toString();
    }

    /**
     * 获取异常打印信息
     *
     * @param e
     * @return
     */
    public static String toString(Throwable e) {
        StringWriter sw = new StringWriter(1024);
        e.printStackTrace(new PrintWriter(sw));
        return sw.getBuffer().toString();
    }

    public static String toStringOfCurrentProject(Throwable e) {
        StackTraceElement[] stacks = e.getStackTrace();
        int offset = findCurrentBack(stacks);
        return getStackDesc(stacks, 0, offset + 1);
    }

    public static String toJSONString(Object o) {
        return JSON.toJSONString(o);
    }

    /**
     * build如果已经有数据则添加 逗号
     *
     * @param builder
     * @param value
     */
    public static void appendAndPreComma(StringBuilder builder, String value) {
        if (builder.length() > 1) {
            builder.append(",");
        }
        builder.append(value);
    }

    public static String formatJSON(String template, Object... objects) {
        return format(template, FormatType.JSON, objects);
    }

    public static String formatString(String template, Object... objects) {
        return format(template, FormatType.STRING, objects);
    }

    /**
     * 针对模板内容和后续参数进行格式化
     *
     * @param template
     * @param objects
     * @return
     */
    public static String format(String template, FormatType type, Object... objects) {
        StringBuilder builder = new StringBuilder(template.length() * 2);
        for (int i = 0; i < template.length(); i++) {
            char c = template.charAt(i);
            int next = i + 1;
            //如果是特殊字符并且后续还有数值那么直接输出后面的字符 并且索引向后+1
            if (c == '\\' && next < template.length()) {
                char nextC = template.charAt(next);
                builder.append(nextC);
                i = next;
                continue;
            } else if (c == '[') {//如果是遇到[ 开始那么则是需要进行后续参数的传入
                int index = template.indexOf(']', next);//必须后面有] 才是有值的范围
                if (index != -1) {
                    String temp = template.substring(next, index);
                    Integer objIndex = NumberUtil.parseInt(temp);
                    if (objIndex != null) {
                        builder.append(toString(objIndex - 1, type, objects));
                        i = index;
                        continue;
                    }
                }
            }
            builder.append(c);
        }
        return builder.toString();
    }

    public static boolean isNotEmpty(String s) {
        return s != null && s.length() > 0;
    }

    public static boolean isEmpty(String s) {
        return !isNotEmpty(s);
    }

    public static boolean isBlank(String str) {
        if (isEmpty(str))
            return true;
        for (int i = 0; i < str.length(); i++)
            if (!Character.isWhitespace(str.charAt(i)))
                return false;

        return true;
    }

    private static String toString(int i, FormatType type, Object... objects) {
        String s = null;
        if (objects != null && i >= 0 && i < objects.length) {
            if (type == FormatType.JSON) {
                s = JSON.toJSONString(objects[i]);
            } else if (type == FormatType.STRING) {
                s = String.valueOf(objects[i]);
            }
        }
        return String.valueOf(s);
    }

    public static int findCurrentBack(StackTraceElement[] stacks) {
        int result = stacks.length - 1;
        for (; result > -1; result--) {
            StackTraceElement stack = stacks[result];
            if (stack.getClassName().startsWith(CURRENT_PROJECT_PACKAGE_NAME)) {
                return result;
            }
        }
        return -1;
    }

    public static String getStackDesc(StackTraceElement[] stack, int start, int offset) {
        int len = stack.length;
        if (offset < 1 || len < 1 || start < 0) {
            return "";
        }
        StringBuilder builder = new StringBuilder((50 * len) + 10);
        for (int i = start; i < offset && i < len; i++) {
            StackTraceElement s = null;
            builder.append(stack[i]).append("\n");
        }
        return builder.toString();
    }

    public static String getStackDesc(StackTraceElement[] stack) {
        return getStackDesc(stack, 0, stack.length);
    }

    public static String getString(Object o) {
        return o == null ? null : o.toString();
    }

    public static String getStringNotNull(Object obj) {
        if (obj != null) {
            return obj.toString();
        }
        return "";
    }

    public static List<String> getCurrentStackList(StackTraceElement[] stackTraceElements) {
        List<String> list = new LinkedList<String>();
        int idx = findCurrentBack(stackTraceElements);
        if (idx > -1) {
            for (int i = 0; i <= idx; i++) {
                list.add(stackTraceElements[i].toString());
            }
        } else if (stackTraceElements.length > 0) {
            list.add(stackTraceElements[0].toString());
        }
        return list;
    }

    public static enum FormatType {
        JSON, STRING;
    }

    private StringTools() {

    }

    /**
     * Description: 去掉字符串前后的空格
     *
     * @param value
     * @return
     */
    public static String toTrim(String value) {
        return null == value ? null : value.trim();
    }

    /**
     * Description: 只剩下中文英文字母及数字
     *
     * @param character
     * @return
     */
    public static String filterChineseAlphabetNumber(String character) {
        if (isEmpty(character)) return character;
        return character.replaceAll("[^0-9a-zA-Z\\u4e00-\\u9fa5]", "");
    }

}
