/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.google.android.gms.b.fi;
import com.google.android.gms.b.gj;

@fi
final class f
extends RelativeLayout {
    gj a;

    public f(Context context, String string) {
        super(context);
        this.a = new gj(context, string);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.a.a(motionEvent);
        return false;
    }
}

