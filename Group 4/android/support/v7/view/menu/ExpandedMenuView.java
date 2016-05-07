/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.view.menu.i;
import android.support.v7.view.menu.k;
import android.support.v7.view.menu.m;
import android.support.v7.view.menu.z;
import android.support.v7.widget.gk;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

public final class ExpandedMenuView
extends ListView
implements k,
z,
AdapterView.OnItemClickListener {
    private static final int[] a = new int[]{16842964, 16843049};
    private i b;
    private int c;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842868);
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet);
        this.setOnItemClickListener((AdapterView.OnItemClickListener)this);
        gk gk2 = gk.a(context, attributeSet, a, n2, 0);
        if (gk2.f(0)) {
            this.setBackgroundDrawable(gk2.a(0));
        }
        if (gk2.f(1)) {
            this.setDivider(gk2.a(1));
        }
        gk2.a();
    }

    @Override
    public void a(i i2) {
        this.b = i2;
    }

    @Override
    public boolean a(m m2) {
        return this.b.a(m2, 0);
    }

    public int getWindowAnimations() {
        return this.c;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.setChildrenDrawingCacheEnabled(false);
    }

    public void onItemClick(AdapterView adapterView, View view, int n2, long l2) {
        this.a((m)this.getAdapter().getItem(n2));
    }
}

