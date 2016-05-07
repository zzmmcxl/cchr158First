/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.h.bi;
import android.support.v7.b.b;
import android.support.v7.widget.am;
import android.support.v7.widget.ar;
import android.support.v7.widget.bq;
import android.support.v7.widget.gh;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.TextView;

public class an
extends Button
implements bi {
    private final ar a = ar.a();
    private final am b;
    private final bq c;

    public an(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.buttonStyle);
    }

    public an(Context context, AttributeSet attributeSet, int n2) {
        super(gh.a(context), attributeSet, n2);
        this.b = new am((View)this, this.a);
        this.b.a(attributeSet, n2);
        this.c = bq.a((TextView)this);
        this.c.a(attributeSet, n2);
        this.c.a();
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.b != null) {
            this.b.c();
        }
        if (this.c == null) return;
        this.c.a();
    }

    @Override
    public ColorStateList getSupportBackgroundTintList() {
        if (this.b == null) return null;
        return this.b.a();
    }

    @Override
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.b == null) return null;
        return this.b.b();
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName((CharSequence)Button.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName((CharSequence)Button.class.getName());
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.b == null) return;
        this.b.a(drawable);
    }

    public void setBackgroundResource(int n2) {
        super.setBackgroundResource(n2);
        if (this.b == null) return;
        this.b.a(n2);
    }

    public void setSupportAllCaps(boolean bl2) {
        if (this.c == null) return;
        this.c.a(bl2);
    }

    @Override
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.b == null) return;
        this.b.a(colorStateList);
    }

    @Override
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.b == null) return;
        this.b.a(mode);
    }

    public void setTextAppearance(Context context, int n2) {
        super.setTextAppearance(context, n2);
        if (this.c == null) return;
        this.c.a(context, n2);
    }
}

