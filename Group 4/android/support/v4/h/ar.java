/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.h;

import android.view.MenuItem;
import android.view.View;

class ar {
    public static MenuItem a(MenuItem menuItem, View view) {
        return menuItem.setActionView(view);
    }

    public static View a(MenuItem menuItem) {
        return menuItem.getActionView();
    }

    public static void a(MenuItem menuItem, int n2) {
        menuItem.setShowAsAction(n2);
    }

    public static MenuItem b(MenuItem menuItem, int n2) {
        return menuItem.setActionView(n2);
    }
}

