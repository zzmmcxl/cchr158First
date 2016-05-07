/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.support.v7.widget.bj;
import android.support.v7.widget.bm;
import android.view.ViewTreeObserver;
import android.widget.PopupWindow;

class bp
implements PopupWindow.OnDismissListener {
    final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener a;
    final /* synthetic */ bm b;

    bp(bm bm2, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        this.b = bm2;
        this.a = onGlobalLayoutListener;
    }

    public void onDismiss() {
        ViewTreeObserver viewTreeObserver = this.b.a.getViewTreeObserver();
        if (viewTreeObserver == null) return;
        viewTreeObserver.removeGlobalOnLayoutListener(this.a);
    }
}

