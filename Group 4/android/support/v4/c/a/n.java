/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.c.a;

import android.graphics.drawable.Drawable;
import android.util.Log;
import java.lang.reflect.Method;

class n {
    private static Method a;
    private static boolean b;
    private static Method c;
    private static boolean d;

    public static int a(Drawable drawable) {
        if (!d) {
            try {
                c = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
                c.setAccessible(true);
            }
            catch (NoSuchMethodException var4_2) {
                Log.i((String)"DrawableCompatJellybeanMr1", (String)"Failed to retrieve getLayoutDirection() method", (Throwable)var4_2);
            }
            d = true;
        }
        if (c == null) return -1;
        try {
            return (Integer)c.invoke((Object)drawable, new Object[0]);
        }
        catch (Exception var1_3) {
            Log.i((String)"DrawableCompatJellybeanMr1", (String)"Failed to invoke getLayoutDirection() via reflection", (Throwable)var1_3);
            c = null;
        }
        return -1;
    }

    public static void a(Drawable drawable, int n2) {
        if (!b) {
            try {
                Class[] arrclass = new Class[]{Integer.TYPE};
                a = Drawable.class.getDeclaredMethod("setLayoutDirection", arrclass);
                a.setAccessible(true);
            }
            catch (NoSuchMethodException var7_5) {
                Log.i((String)"DrawableCompatJellybeanMr1", (String)"Failed to retrieve setLayoutDirection(int) method", (Throwable)var7_5);
            }
            b = true;
        }
        if (a == null) return;
        try {
            Method method = a;
            Object[] arrobject = new Object[]{n2};
            method.invoke((Object)drawable, arrobject);
            return;
        }
        catch (Exception var2_6) {
            Log.i((String)"DrawableCompatJellybeanMr1", (String)"Failed to invoke setLayoutDirection(int) via reflection", (Throwable)var2_6);
            a = null;
            return;
        }
    }
}

