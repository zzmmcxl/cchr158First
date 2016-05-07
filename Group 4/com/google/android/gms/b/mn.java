/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import com.google.android.gms.b.mm;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class mn {
    public static String a(mm mm2) {
        if (mm2 == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        try {
            mn.a(null, mm2, new StringBuffer(), stringBuffer);
            return stringBuffer.toString();
        }
        catch (IllegalAccessException var3_2) {
            return "Error printing proto: " + var3_2.getMessage();
        }
        catch (InvocationTargetException var2_3) {
            return "Error printing proto: " + var2_3.getMessage();
        }
    }

    private static String a(String string) {
        StringBuffer stringBuffer = new StringBuffer();
        int n2 = 0;
        while (n2 < string.length()) {
            char c2 = string.charAt(n2);
            if (n2 == 0) {
                stringBuffer.append(Character.toLowerCase(c2));
            } else if (Character.isUpperCase(c2)) {
                stringBuffer.append('_').append(Character.toLowerCase(c2));
            } else {
                stringBuffer.append(c2);
            }
            ++n2;
        }
        return stringBuffer.toString();
    }

    private static void a(String string, Object object, StringBuffer stringBuffer, StringBuffer stringBuffer2) {
        Field[] arrfield;
        Class class_;
        int n2;
        int n3;
        if (object == null) {
            return;
        }
        if (object instanceof mm) {
            n2 = stringBuffer.length();
            if (string != null) {
                stringBuffer2.append(stringBuffer).append(mn.a(string)).append(" <\n");
                stringBuffer.append("  ");
            }
            class_ = object.getClass();
            arrfield = class_.getFields();
            n3 = arrfield.length;
        } else {
            String string2 = mn.a(string);
            stringBuffer2.append(stringBuffer).append(string2).append(": ");
            if (object instanceof String) {
                String string3 = mn.b((String)object);
                stringBuffer2.append("\"").append(string3).append("\"");
            } else if (object instanceof byte[]) {
                mn.a((byte[])object, stringBuffer2);
            } else {
                stringBuffer2.append(object);
            }
            stringBuffer2.append("\n");
            return;
        }
        for (int i2 = 0; i2 < n3; ++i2) {
            Field field = arrfield[i2];
            int n4 = field.getModifiers();
            String string4 = field.getName();
            if ("cachedSize".equals(string4) || (n4 & 1) != 1 || (n4 & 8) == 8 || string4.startsWith("_") || string4.endsWith("_")) continue;
            Class class_2 = field.getType();
            Object object2 = field.get(object);
            if (class_2.isArray()) {
                if (class_2.getComponentType() == Byte.TYPE) {
                    mn.a(string4, object2, stringBuffer, stringBuffer2);
                    continue;
                }
                int n5 = object2 == null ? 0 : Array.getLength(object2);
                for (int i3 = 0; i3 < n5; ++i3) {
                    mn.a(string4, Array.get(object2, i3), stringBuffer, stringBuffer2);
                }
                continue;
            }
            mn.a(string4, object2, stringBuffer, stringBuffer2);
        }
        Method[] arrmethod = class_.getMethods();
        int n6 = arrmethod.length;
        int n7 = 0;
        do {
            block19 : {
                if (n7 >= n6) {
                    if (string == null) return;
                    stringBuffer.setLength(n2);
                    stringBuffer2.append(stringBuffer).append(">\n");
                    return;
                }
                String string5 = arrmethod[n7].getName();
                if (string5.startsWith("set")) {
                    Method method;
                    String string6 = string5.substring(3);
                    try {
                        Method method2 = class_.getMethod("has" + string6, new Class[0]);
                        if (!((Boolean)method2.invoke(object, new Object[0])).booleanValue()) break block19;
                    }
                    catch (NoSuchMethodException var21_21) {}
                    try {
                        method = class_.getMethod("get" + string6, new Class[0]);
                    }
                    catch (NoSuchMethodException var23_23) {
                        break block19;
                    }
                    mn.a(string6, method.invoke(object, new Object[0]), stringBuffer, stringBuffer2);
                }
            }
            ++n7;
        } while (true);
    }

    private static void a(byte[] arrby, StringBuffer stringBuffer) {
        if (arrby == null) {
            stringBuffer.append("\"\"");
            return;
        }
        stringBuffer.append('\"');
        int n2 = 0;
        do {
            if (n2 >= arrby.length) {
                stringBuffer.append('\"');
                return;
            }
            int n3 = 255 & arrby[n2];
            if (n3 == 92 || n3 == 34) {
                stringBuffer.append('\\').append((char)n3);
            } else if (n3 >= 32 && n3 < 127) {
                stringBuffer.append((char)n3);
            } else {
                Object[] arrobject = new Object[]{n3};
                stringBuffer.append(String.format("\\%03o", arrobject));
            }
            ++n2;
        } while (true);
    }

    private static String b(String string) {
        if (string.startsWith("http")) return mn.c(string);
        if (string.length() <= 200) return mn.c(string);
        string = string.substring(0, 200) + "[...]";
        return mn.c(string);
    }

    private static String c(String string) {
        int n2 = string.length();
        StringBuilder stringBuilder = new StringBuilder(n2);
        int n3 = 0;
        while (n3 < n2) {
            char c2 = string.charAt(n3);
            if (c2 >= ' ' && c2 <= '~' && c2 != '\"' && c2 != '\'') {
                stringBuilder.append(c2);
            } else {
                Object[] arrobject = new Object[]{c2};
                stringBuilder.append(String.format("\\u%04x", arrobject));
            }
            ++n3;
        }
        return stringBuilder.toString();
    }
}

