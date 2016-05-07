/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.h;

import android.animation.ValueAnimator;
import android.support.v4.h.ds;
import android.support.v4.h.dv;
import android.view.View;
import android.view.ViewPropertyAnimator;

class dr {
    public static void a(View view, dv dv2) {
        ds ds2 = null;
        if (dv2 != null) {
            ds2 = new ds(dv2, view);
        }
        view.animate().setUpdateListener((ValueAnimator.AnimatorUpdateListener)ds2);
    }
}

