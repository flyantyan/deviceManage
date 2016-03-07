package com.nuc.device.util.dynamic;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author     : leopold
 * @group      : THS_JAVA_PLATFORM
 * @Comments   : 自定义类加载器
 * @Version    : 1.0.0
 */
public class DynamicClassLoader extends URLClassLoader {
    public DynamicClassLoader(ClassLoader parent) {
        super(new URL[0], parent);
    }
 
    public Class findClassByClassName(String className) throws ClassNotFoundException {
        return this.findClass(className);
    }
 
    public Class loadClass(String fullName, JavaClassObject jco) {
        byte[] classData = jco.getBytes();
        return this.defineClass(fullName, classData, 0, classData.length);
    }
}