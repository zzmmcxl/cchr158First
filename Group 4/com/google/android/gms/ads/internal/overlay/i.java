/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.ads.internal.overlay;

import android.graphics.drawable.Drawable;
import android.view.Window;
import com.google.android.gms.ads.internal.overlay.c;
import com.google.android.gms.ads.internal.overlay.h;

class i
implements Runnable {
    final /* synthetic */ Drawable a;
    final /* synthetic */ h b;

    i(h h2, Drawable drawable) {
        this.b = h2;
        this.a = drawable;
    }

    @Override
    public void run() {
        c.a(this.b.a).getWindow().setBackgroundDrawable(this.a);
    }
}

