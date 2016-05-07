/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.d.a;

import android.support.v4.h.aq;
import android.support.v4.h.n;
import android.view.MenuItem;
import android.view.View;

public interface b
extends MenuItem {
    public b a(aq var1);

    public b a(n var1);

    public n a();

    public boolean collapseActionView();

    public boolean expandActionView();

    public View getActionView();

    public boolean isActionViewExpanded();

    public MenuItem setActionView(int var1);

    public MenuItem setActionView(View var1);

    public void setShowAsAction(int var1);

    public MenuItem setShowAsActionFlags(int var1);
}

