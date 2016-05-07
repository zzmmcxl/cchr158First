/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.bj;
import android.support.v7.widget.bn;
import android.support.v7.widget.bo;
import android.support.v7.widget.bp;
import android.support.v7.widget.df;
import android.support.v7.widget.gz;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.SpinnerAdapter;

class bm
extends df {
    final /* synthetic */ bj a;
    private CharSequence c;
    private ListAdapter d;
    private final Rect e;

    public bm(bj bj2, Context context, AttributeSet attributeSet, int n2) {
        this.a = bj2;
        super(context, attributeSet, n2);
        this.e = new Rect();
        this.a((View)bj2);
        this.a(true);
        this.a(0);
        this.a(new bn(this, bj2));
    }

    static /* synthetic */ ListAdapter a(bm bm2) {
        return bm2.d;
    }

    static /* synthetic */ boolean a(bm bm2, View view) {
        return bm2.b(view);
    }

    static /* synthetic */ void b(bm bm2) {
        bm2.c();
    }

    private boolean b(View view) {
        if (!android.support.v4.h.bo.C(view)) return false;
        if (!view.getGlobalVisibleRect(this.e)) return false;
        return true;
    }

    public CharSequence a() {
        return this.c;
    }

    @Override
    public void a(ListAdapter listAdapter) {
        super.a(listAdapter);
        this.d = listAdapter;
    }

    public void a(CharSequence charSequence) {
        this.c = charSequence;
    }

    /*
     * Unable to fully structure code
     */
    void b() {
        var1_1 = this.d();
        if (var1_1 != null) {
            var1_1.getPadding(bj.b(this.a));
            var11_2 = gz.a((View)this.a) != false ? bj.b((bj)this.a).right : - bj.b((bj)this.a).left;
            var3_3 = var11_2;
        } else {
            var2_10 = bj.b(this.a);
            bj.b((bj)this.a).right = 0;
            var2_10.left = 0;
            var3_3 = 0;
        }
        var4_4 = this.a.getPaddingLeft();
        var5_5 = this.a.getPaddingRight();
        var6_6 = this.a.getWidth();
        if (bj.c(this.a) != -2) ** GOTO lbl18
        var8_7 = bj.a(this.a, (SpinnerAdapter)this.d, this.d());
        if (var8_7 <= (var9_8 = this.a.getContext().getResources().getDisplayMetrics().widthPixels - bj.b((bj)this.a).left - bj.b((bj)this.a).right)) ** GOTO lbl23
        ** GOTO lbl24
lbl18: // 1 sources:
        if (bj.c(this.a) == -1) {
            this.f(var6_6 - var4_4 - var5_5);
        } else {
            this.f(bj.c(this.a));
        }
        ** GOTO lbl25
lbl23: // 1 sources:
        var9_8 = var8_7;
lbl24: // 2 sources:
        this.f(Math.max(var9_8, var6_6 - var4_4 - var5_5));
lbl25: // 3 sources:
        var7_9 = gz.a((View)this.a) != false ? var3_3 + (var6_6 - var5_5 - this.h()) : var3_3 + var4_4;
        this.b(var7_9);
    }

    @Override
    public void c() {
        boolean bl2 = this.k();
        this.b();
        this.g(2);
        super.c();
        this.m().setChoiceMode(1);
        this.h(this.a.getSelectedItemPosition());
        if (bl2) {
            return;
        }
        ViewTreeObserver viewTreeObserver = this.a.getViewTreeObserver();
        if (viewTreeObserver == null) return;
        bo bo2 = new bo(this);
        viewTreeObserver.addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)bo2);
        this.a(new bp(this, bo2));
    }
}

