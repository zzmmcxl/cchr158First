/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.a.ae;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.ar;
import android.view.KeyEvent;
import android.view.MotionEvent;

class ap
extends ContentFrameLayout {
    final /* synthetic */ ae a;

    public ap(ae ae2, Context context) {
        this.a = ae2;
        super(context);
    }

    private boolean a(int n2, int n3) {
        if (n2 < -5) return true;
        if (n3 < -5) return true;
        if (n2 > 5 + this.getWidth()) return true;
        if (n3 <= 5 + this.getHeight()) return false;
        return true;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (this.a.a(keyEvent)) return true;
        if (!super.dispatchKeyEvent(keyEvent)) return false;
        return true;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) return super.onInterceptTouchEvent(motionEvent);
        if (!this.a((int)motionEvent.getX(), (int)motionEvent.getY())) return super.onInterceptTouchEvent(motionEvent);
        ae.d(this.a, 0);
        return true;
    }

    public void setBackgroundResource(int n2) {
        this.setBackgroundDrawable(ar.a().a(this.getContext(), n2));
    }
}

