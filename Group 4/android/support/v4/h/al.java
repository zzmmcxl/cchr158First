/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.h;

import android.os.Build;
import android.support.v4.d.a.b;
import android.support.v4.h.am;
import android.support.v4.h.an;
import android.support.v4.h.ao;
import android.support.v4.h.ap;
import android.support.v4.h.n;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

public final class al {
    static final ap a;

    static {
        int n2 = Build.VERSION.SDK_INT;
        if (n2 >= 14) {
            a = new ao();
            return;
        }
        if (n2 >= 11) {
            a = new an();
            return;
        }
        a = new am();
    }

    public static MenuItem a(MenuItem menuItem, n n2) {
        if (menuItem instanceof b) {
            return ((b)menuItem).a(n2);
        }
        Log.w((String)"MenuItemCompat", (String)"setActionProvider: item does not implement SupportMenuItem; ignoring");
        return menuItem;
    }

    public static MenuItem a(MenuItem menuItem, View view) {
        if (!(menuItem instanceof b)) return a.a(menuItem, view);
        return ((b)menuItem).setActionView(view);
    }

    public static View a(MenuItem menuItem) {
        if (!(menuItem instanceof b)) return a.a(menuItem);
        return ((b)menuItem).getActionView();
    }

    public static void a(MenuItem menuItem, int n2) {
        if (menuItem instanceof b) {
            ((b)menuItem).setShowAsAction(n2);
            return;
        }
        a.a(menuItem, n2);
    }

    public static MenuItem b(MenuItem menuItem, int n2) {
        if (!(menuItem instanceof b)) return a.b(menuItem, n2);
        return ((b)menuItem).setActionView(n2);
    }

    public static boolean b(MenuItem menuItem) {
        if (!(menuItem instanceof b)) return a.b(menuItem);
        return ((b)menuItem).expandActionView();
    }

    public static boolean c(MenuItem menuItem) {
        if (!(menuItem instanceof b)) return a.c(menuItem);
        return ((b)menuItem).isActionViewExpanded();
    }
}

