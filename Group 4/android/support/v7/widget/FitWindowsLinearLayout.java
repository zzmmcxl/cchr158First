/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.ct;
import android.support.v7.widget.cu;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class FitWindowsLinearLayout
extends LinearLayout
implements ct {
    private cu a;

    public FitWindowsLinearLayout(Context context) {
        super(context);
    }

    public FitWindowsLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected boolean fitSystemWindows(Rect rect) {
        if (this.a == null) return super.fitSystemWindows(rect);
        this.a.a(rect);
        return super.fitSystemWindows(rect);
    }

    @Override
    public void setOnFitSystemWindowsListener(cu cu2) {
        this.a = cu2;
    }
}

