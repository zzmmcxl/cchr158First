/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.a.a;
import android.support.v7.a.aa;
import android.support.v7.a.ac;
import android.support.v7.a.ae;
import android.support.v7.a.v;
import android.support.v7.a.z;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

public abstract class w {
    private static int a = -1;

    w() {
    }

    public static w a(Activity activity, v v2) {
        return w.a((Context)activity, activity.getWindow(), v2);
    }

    public static w a(Dialog dialog, v v2) {
        return w.a(dialog.getContext(), dialog.getWindow(), v2);
    }

    private static w a(Context context, Window window, v v2) {
        int n2 = Build.VERSION.SDK_INT;
        if (n2 >= 23) {
            return new ac(context, window, v2);
        }
        if (n2 >= 14) {
            return new aa(context, window, v2);
        }
        if (n2 < 11) return new ae(context, window, v2);
        return new z(context, window, v2);
    }

    public static int i() {
        return a;
    }

    public abstract a a();

    public abstract void a(int var1);

    public abstract void a(Configuration var1);

    public abstract void a(Bundle var1);

    public abstract void a(Toolbar var1);

    public abstract void a(View var1);

    public abstract void a(View var1, ViewGroup.LayoutParams var2);

    public abstract void a(CharSequence var1);

    public abstract MenuInflater b();

    public abstract void b(Bundle var1);

    public abstract void b(View var1, ViewGroup.LayoutParams var2);

    public abstract boolean b(int var1);

    public abstract void c();

    public abstract void c(Bundle var1);

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public abstract void g();

    public abstract boolean h();
}

