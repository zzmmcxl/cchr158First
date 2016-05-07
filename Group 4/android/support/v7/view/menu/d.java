/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.view.menu;

import android.content.Context;
import android.support.v4.h.bo;
import android.support.v7.view.menu.aa;
import android.support.v7.view.menu.ad;
import android.support.v7.view.menu.i;
import android.support.v7.view.menu.m;
import android.support.v7.view.menu.x;
import android.support.v7.view.menu.y;
import android.support.v7.view.menu.z;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.ArrayList;

public abstract class d
implements x {
    protected Context a;
    protected Context b;
    protected i c;
    protected LayoutInflater d;
    protected LayoutInflater e;
    protected z f;
    private y g;
    private int h;
    private int i;
    private int j;

    public d(Context context, int n2, int n3) {
        this.a = context;
        this.d = LayoutInflater.from((Context)context);
        this.h = n2;
        this.i = n3;
    }

    public y a() {
        return this.g;
    }

    public z a(ViewGroup viewGroup) {
        if (this.f != null) return this.f;
        this.f = (z)this.d.inflate(this.h, viewGroup, false);
        this.f.a(this.c);
        this.b(true);
        return this.f;
    }

    public View a(m m2, View view, ViewGroup viewGroup) {
        aa aa2 = view instanceof aa ? (aa)view : this.b(viewGroup);
        this.a(m2, aa2);
        return (View)aa2;
    }

    public void a(int n2) {
        this.j = n2;
    }

    @Override
    public void a(Context context, i i2) {
        this.b = context;
        this.e = LayoutInflater.from((Context)this.b);
        this.c = i2;
    }

    @Override
    public void a(i i2, boolean bl2) {
        if (this.g == null) return;
        this.g.a(i2, bl2);
    }

    public abstract void a(m var1, aa var2);

    public void a(y y2) {
        this.g = y2;
    }

    protected void a(View view, int n2) {
        ViewGroup viewGroup = (ViewGroup)view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup)this.f).addView(view, n2);
    }

    public boolean a(int n2, m m2) {
        return true;
    }

    @Override
    public boolean a(ad ad2) {
        if (this.g == null) return false;
        return this.g.a(ad2);
    }

    @Override
    public boolean a(i i2, m m2) {
        return false;
    }

    protected boolean a(ViewGroup viewGroup, int n2) {
        viewGroup.removeViewAt(n2);
        return true;
    }

    public aa b(ViewGroup viewGroup) {
        return (aa)this.d.inflate(this.i, viewGroup, false);
    }

    @Override
    public void b(boolean bl2) {
        int n2;
        ViewGroup viewGroup = (ViewGroup)this.f;
        if (viewGroup == null) {
            return;
        }
        if (this.c == null) {
            n2 = 0;
        } else {
            this.c.j();
            ArrayList arrayList = this.c.i();
            int n3 = arrayList.size();
            n2 = 0;
            for (int i2 = 0; i2 < n3; ++i2) {
                int n4;
                m m2 = (m)arrayList.get(i2);
                if (this.a(n2, m2)) {
                    View view = viewGroup.getChildAt(n2);
                    m m3 = view instanceof aa ? ((aa)view).getItemData() : null;
                    View view2 = this.a(m2, view, viewGroup);
                    if (m2 != m3) {
                        view2.setPressed(false);
                        bo.u(view2);
                    }
                    if (view2 != view) {
                        this.a(view2, n2);
                    }
                    n4 = n2 + 1;
                } else {
                    n4 = n2;
                }
                n2 = n4;
            }
        }
        while (n2 < viewGroup.getChildCount()) {
            if (this.a(viewGroup, n2)) continue;
            ++n2;
        }
    }

    @Override
    public boolean b() {
        return false;
    }

    @Override
    public boolean b(i i2, m m2) {
        return false;
    }
}

