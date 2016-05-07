/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.support.v7.widget.Toolbar;
import android.support.v7.widget.y;
import android.view.MenuItem;

class gl
implements y {
    final /* synthetic */ Toolbar a;

    gl(Toolbar toolbar) {
        this.a = toolbar;
    }

    @Override
    public boolean a(MenuItem menuItem) {
        if (Toolbar.a(this.a) == null) return false;
        return Toolbar.a(this.a).a(menuItem);
    }
}

