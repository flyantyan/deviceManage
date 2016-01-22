package com.nuc.device.base;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * sqlSession的切面类
 * Created by chris on 2015/10/20.
 */
public class SqlSessionAspect {
    private static final Logger logger = LoggerFactory.getLogger(SqlSessionAspect.class);

    /**
     * 在方法执行之后关闭session
     *
     * @param jp
     */
    public void doAfter(JoinPoint jp) {
        try {
            Method method = jp.getTarget().getClass().getSuperclass().getMethod("closeSession");
            method.invoke(jp.getTarget());
            logger.info("执行方法：" + jp.getSignature().getName() + "打开的session已关闭");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
