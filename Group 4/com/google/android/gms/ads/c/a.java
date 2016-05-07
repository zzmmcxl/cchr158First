/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.ads.c;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.c;
import com.google.android.gms.ads.internal.client.b;

public final class a
extends ViewGroup {
    private final b a;

    public com.google.android.gms.ads.a getAdListener() {
        return this.a.a();
    }

    public c getAdSize() {
        return this.a.b();
    }

    public String getAdUnitId() {
        return this.a.d();
    }

    protected void onLayout(boolean bl2, int n2, int n3, int n4, int n5) {
        View view = this.getChildAt(0);
        if (view == null) return;
        if (view.getVisibility() == 8) return;
        int n6 = view.getMeasuredWidth();
        int n7 = view.getMeasuredHeight();
        int n8 = (n4 - n2 - n6) / 2;
        int n9 = (n5 - n3 - n7) / 2;
        view.layout(n8, n9, n6 + n8, n7 + n9);
    }

    protected void onMeasure(int n2, int n3) {
        int n4;
        int n5;
        View view = this.getChildAt(0);
        if (view != null && view.getVisibility() != 8) {
            this.measureChild(view, n2, n3);
            n4 = view.getMeasuredWidth();
            n5 = view.getMeasuredHeight();
        } else {
            c c2 = this.getAdSize();
            if (c2 != null) {
                Context context = this.getContext();
                n4 = c2.b(context);
                n5 = c2.a(context);
            } else {
                n5 = 0;
                n4 = 0;
            }
        }
        int n6 = Math.max(n4, this.getSuggestedMinimumWidth());
        int n7 = Math.max(n5, this.getSuggestedMinimumHeight());
        this.setMeasuredDimension(View.resolveSize((int)n6, (int)n2), View.resolveSize((int)n7, (int)n3));
    }

    public void setAdListener(com.google.android.gms.ads.a a2) {
        this.a.a(a2);
    }

    public void setAdSize(c c2) {
        this.a.a(c2);
    }

    public void setAdUnitId(String string) {
        this.a.a(string);
    }
}

