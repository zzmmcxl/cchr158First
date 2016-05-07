/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.support.v7.widget.df;
import android.support.v7.widget.dg;
import android.view.MotionEvent;
import android.view.View;

class dq
implements View.OnTouchListener {
    final /* synthetic */ df a;

    private dq(df df2) {
        this.a = df2;
    }

    /* synthetic */ dq(df df2, dg dg2) {
        this(df2);
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int n2 = motionEvent.getAction();
        int n3 = (int)motionEvent.getX();
        int n4 = (int)motionEvent.getY();
        if (n2 == 0 && df.b(this.a) != null && df.b(this.a).isShowing() && n3 >= 0 && n3 < df.b(this.a).getWidth() && n4 >= 0 && n4 < df.b(this.a).getHeight()) {
            df.d(this.a).postDelayed((Runnable)df.c(this.a), 250);
            return false;
        }
        if (n2 != 1) return false;
        df.d(this.a).removeCallbacks((Runnable)df.c(this.a));
        return false;
    }
}

