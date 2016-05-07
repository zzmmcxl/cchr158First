/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.support.v4.h.bo;
import android.support.v7.b.g;
import android.support.v7.b.i;
import android.support.v7.b.j;
import android.support.v7.widget.ActivityChooserView;
import android.support.v7.widget.z;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class ag
extends BaseAdapter {
    final /* synthetic */ ActivityChooserView a;
    private z b;
    private int c;
    private boolean d;
    private boolean e;
    private boolean f;

    public int a() {
        int n2 = 0;
        int n3 = this.c;
        this.c = Integer.MAX_VALUE;
        int n4 = View.MeasureSpec.makeMeasureSpec((int)0, (int)0);
        int n5 = View.MeasureSpec.makeMeasureSpec((int)0, (int)0);
        int n6 = this.getCount();
        View view = null;
        int n7 = 0;
        do {
            if (n2 >= n6) {
                this.c = n3;
                return n7;
            }
            view = this.getView(n2, view, null);
            view.measure(n4, n5);
            n7 = Math.max(n7, view.getMeasuredWidth());
            ++n2;
        } while (true);
    }

    public void a(int n2) {
        if (this.c == n2) return;
        this.c = n2;
        this.notifyDataSetChanged();
    }

    public void a(z z2) {
        z z3 = ActivityChooserView.a(this.a).d();
        if (z3 != null && this.a.isShown()) {
            z3.unregisterObserver((Object)ActivityChooserView.g(this.a));
        }
        this.b = z2;
        if (z2 != null && this.a.isShown()) {
            z2.registerObserver((Object)ActivityChooserView.g(this.a));
        }
        this.notifyDataSetChanged();
    }

    public void a(boolean bl2) {
        if (this.f == bl2) return;
        this.f = bl2;
        this.notifyDataSetChanged();
    }

    public void a(boolean bl2, boolean bl3) {
        if (this.d == bl2) {
            if (this.e == bl3) return;
        }
        this.d = bl2;
        this.e = bl3;
        this.notifyDataSetChanged();
    }

    public ResolveInfo b() {
        return this.b.b();
    }

    public int c() {
        return this.b.a();
    }

    public z d() {
        return this.b;
    }

    public boolean e() {
        return this.d;
    }

    public int getCount() {
        int n2 = this.b.a();
        if (!this.d && this.b.b() != null) {
            --n2;
        }
        int n3 = Math.min(n2, this.c);
        if (!this.f) return n3;
        ++n3;
        return n3;
    }

    public Object getItem(int n2) {
        switch (this.getItemViewType(n2)) {
            default: {
                throw new IllegalArgumentException();
            }
            case 1: {
                return null;
            }
            case 0: 
        }
        if (this.d) return this.b.a(n2);
        if (this.b.b() == null) return this.b.a(n2);
        ++n2;
        return this.b.a(n2);
    }

    public long getItemId(int n2) {
        return n2;
    }

    public int getItemViewType(int n2) {
        if (!this.f) return 0;
        if (n2 != -1 + this.getCount()) return 0;
        return 1;
    }

    public View getView(int n2, View view, ViewGroup viewGroup) {
        switch (this.getItemViewType(n2)) {
            default: {
                throw new IllegalArgumentException();
            }
            case 1: {
                if (view != null) {
                    if (view.getId() == 1) return view;
                }
                view = LayoutInflater.from((Context)this.a.getContext()).inflate(i.abc_activity_chooser_view_list_item, viewGroup, false);
                view.setId(1);
                ((TextView)view.findViewById(g.title)).setText((CharSequence)this.a.getContext().getString(j.abc_activity_chooser_view_see_all));
                return view;
            }
            case 0: 
        }
        if (view == null || view.getId() != g.list_item) {
            view = LayoutInflater.from((Context)this.a.getContext()).inflate(i.abc_activity_chooser_view_list_item, viewGroup, false);
        }
        PackageManager packageManager = this.a.getContext().getPackageManager();
        ImageView imageView = (ImageView)view.findViewById(g.icon);
        ResolveInfo resolveInfo = (ResolveInfo)this.getItem(n2);
        imageView.setImageDrawable(resolveInfo.loadIcon(packageManager));
        ((TextView)view.findViewById(g.title)).setText(resolveInfo.loadLabel(packageManager));
        if (this.d && n2 == 0 && this.e) {
            bo.c(view, true);
            return view;
        }
        bo.c(view, false);
        return view;
    }

    public int getViewTypeCount() {
        return 3;
    }
}

