/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.ads.internal.util.client;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.ads.a.e;
import com.google.android.gms.ads.b;
import com.google.android.gms.ads.d;
import com.google.android.gms.ads.g;
import com.google.android.gms.b.fi;
import com.google.android.gms.b.kn;
import java.lang.reflect.Method;

@fi
public class a {
    public static final Handler a = new Handler(Looper.getMainLooper());
    private static final String b = d.class.getName();
    private static final String c = g.class.getName();
    private static final String d = com.google.android.gms.ads.a.d.class.getName();
    private static final String e = e.class.getName();
    private static final String f = com.google.android.gms.ads.c.a.class.getName();
    private static final String g = b.class.getName();

    public int a(Context context, int n2) {
        return this.a(context.getResources().getDisplayMetrics(), n2);
    }

    public int a(DisplayMetrics displayMetrics, int n2) {
        return (int)TypedValue.applyDimension((int)1, (float)n2, (DisplayMetrics)displayMetrics);
    }

    public boolean a() {
        if (Looper.myLooper() != Looper.getMainLooper()) return false;
        return true;
    }

    public boolean a(Context context) {
        if (context.getResources().getConfiguration().orientation != 2) {
            return false;
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if ((int)((float)displayMetrics.heightPixels / displayMetrics.density) >= 600) return false;
        return true;
    }

    public int b(Context context, int n2) {
        Display display = ((WindowManager)context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        display.getMetrics(displayMetrics);
        return this.b(displayMetrics, n2);
    }

    public int b(DisplayMetrics displayMetrics, int n2) {
        return Math.round((float)n2 / displayMetrics.density);
    }

    /*
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    public boolean b(Context context) {
        int n3;
        int n2;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        Display display = ((WindowManager)context.getSystemService("window")).getDefaultDisplay();
        if (kn.d()) {
            display.getRealMetrics(displayMetrics);
            n2 = displayMetrics.heightPixels;
            n3 = displayMetrics.widthPixels;
        } else {
            int n4;
            n2 = (Integer)Display.class.getMethod("getRawHeight", new Class[0]).invoke((Object)display, new Object[0]);
            n3 = n4 = ((Integer)Display.class.getMethod("getRawWidth", new Class[0]).invoke((Object)display, new Object[0])).intValue();
        }
        display.getMetrics(displayMetrics);
        int n5 = displayMetrics.heightPixels;
        int n6 = displayMetrics.widthPixels;
        if (n5 != n2) return false;
        if (n6 != n3) return false;
        return true;
        catch (Exception exception) {
            return false;
        }
    }

    public int c(Context context) {
        int n2 = context.getResources().getIdentifier("navigation_bar_width", "dimen", "android");
        if (n2 <= 0) return 0;
        return context.getResources().getDimensionPixelSize(n2);
    }
}

