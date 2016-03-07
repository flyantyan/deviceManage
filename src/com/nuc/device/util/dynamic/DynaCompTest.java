package com.nuc.device.util.dynamic;

public class DynaCompTest {
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 3; i++) {
            String fullName = "DynaClass";
            StringBuilder src = new StringBuilder();
            src.append("public class DynaClass {\n");
            src.append("  static int i=100;  public String toString() {\n");
            src.append("    new NoSave();    return (i++)+\"Hello, I am \" + ");
            src.append("this.getClass().getSimpleName();\n");
            src.append("    }\n");
            src.append("}\n");

            System.out.println(src);
            DynamicEngine de = DynamicEngine.getInstance();
            Object instance = de.javaCodeToObject(fullName, src.toString());
            System.out.println(instance);
        }
    }
}
