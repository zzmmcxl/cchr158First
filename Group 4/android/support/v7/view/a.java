/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.view;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.v4.h.cn;
import android.support.v7.b.b;
import android.support.v7.b.c;
import android.support.v7.b.e;
import android.support.v7.b.h;
import android.support.v7.b.l;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.ViewConfiguration;

public class a {
    private Context a;

    private a(Context context) {
        this.a = context;
    }

    public static a a(Context context) {
        return new a(context);
    }

    public int a() {
        return this.a.getResources().getInteger(h.abc_max_action_buttons);
    }

    public boolean b() {
        if (Build.VERSION.SDK_INT >= 19) {
            return true;
        }
        if (!cn.b(ViewConfiguration.get((Context)this.a))) return true;
        return false;
    }

    public int c() {
        return this.a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public boolean d() {
        if (this.a.getApplicationInfo().targetSdkVersion < 16) return this.a.getResources().getBoolean(c.abc_action_bar_embed_tabs_pre_jb);
        return this.a.getResources().getBoolean(c.abc_action_bar_embed_tabs);
    }

    public int e() {
        TypedArray typedArray = this.a.obtainStyledAttributes(null, l.ActionBar, b.actionBarStyle, 0);
        int n2 = typedArray.getLayoutDimension(l.ActionBar_height, 0);
        Resources resources = this.a.getResources();
        if (!this.d()) {
            n2 = Math.min(n2, resources.getDimensionPixelSize(e.abc_action_bar_stacked_max_height));
        }
        typedArray.recycle();
        return n2;
    }

    public boolean f() {
        if (this.a.getApplicationInfo().targetSdkVersion >= 14) return false;
        return true;
    }

    public int g() {
        return this.a.getResources().getDimensionPixelSize(e.abc_action_bar_stacked_tab_max_width);
    }
}

