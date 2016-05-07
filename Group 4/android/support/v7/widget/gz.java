/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.graphics.Rect;
import android.os.Build;
import android.support.v4.h.bo;
import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class gz {
    private static Method a;

    static {
        if (Build.VERSION.SDK_INT < 18) return;
        try {
            a = View.class.getDeclaredMethod("computeFitSystemWindows", Rect.class, Rect.class);
            if (a.isAccessible()) return;
            a.setAccessible(true);
            return;
        }
        catch (NoSuchMethodException var0) {
            Log.d((String)"ViewUtils", (String)"Could not find method computeFitSystemWindows. Oh well.");
            return;
        }
    }

    public static int a(int n2, int n3) {
        return n2 | n3;
    }

    public static void a(View view, Rect rect, Rect rect2) {
        if (a == null) return;
        try {
            a.invoke((Object)view, new Object[]{rect, rect2});
            return;
        }
        catch (Exception var3_3) {
            Log.d((String)"ViewUtils", (String)"Could not invoke computeFitSystemWindows", (Throwable)var3_3);
            return;
        }
    }

    public static boolean a(View view) {
        if (bo.h(view) != 1) return false;
        return true;
    }

    public static void b(View view) {
        if (Build.VERSION.SDK_INT < 16) return;
        try {
            Method method = view.getClass().getMethod("makeOptionalFitsSystemWindows", new Class[0]);
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            method.invoke((Object)view, new Object[0]);
            return;
        }
        catch (NoSuchMethodException var5_2) {
            Log.d((String)"ViewUtils", (String)"Could not find method makeOptionalFitsSystemWindows. Oh well...");
            return;
        }
        catch (InvocationTargetException var3_3) {
            Log.d((String)"ViewUtils", (String)"Could not invoke makeOptionalFitsSystemWindows", (Throwable)var3_3);
            return;
        }
        catch (IllegalAccessException var1_4) {
            Log.d((String)"ViewUtils", (String)"Could not invoke makeOptionalFitsSystemWindows", (Throwable)var1_4);
            return;
        }
    }
}

