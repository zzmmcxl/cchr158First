/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.os.IBinder;
import android.support.v7.widget.df;
import android.view.View;

class dh
implements Runnable {
    final /* synthetic */ df a;

    dh(df df2) {
        this.a = df2;
    }

    @Override
    public void run() {
        View view = this.a.e();
        if (view == null) return;
        if (view.getWindowToken() == null) return;
        this.a.c();
    }
}

