/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.view.menu;

import android.content.Context;
import android.os.Build;
import android.support.v4.d.a.a;
import android.support.v4.d.a.b;
import android.support.v4.d.a.c;
import android.support.v7.view.menu.ac;
import android.support.v7.view.menu.ae;
import android.support.v7.view.menu.o;
import android.support.v7.view.menu.t;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

public final class ab {
    public static Menu a(Context context, a a2) {
        if (Build.VERSION.SDK_INT < 14) throw new UnsupportedOperationException();
        return new ac(context, a2);
    }

    public static MenuItem a(Context context, b b2) {
        if (Build.VERSION.SDK_INT >= 16) {
            return new t(context, b2);
        }
        if (Build.VERSION.SDK_INT < 14) throw new UnsupportedOperationException();
        return new o(context, b2);
    }

    public static SubMenu a(Context context, c c2) {
        if (Build.VERSION.SDK_INT < 14) throw new UnsupportedOperationException();
        return new ae(context, c2);
    }
}

