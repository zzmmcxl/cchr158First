/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

public class Space
extends View {
    public Space(Context context) {
        this(context, null);
    }

    public Space(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public Space(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        if (this.getVisibility() != 0) return;
        this.setVisibility(4);
    }

    private static int a(int n2, int n3) {
        int n4 = View.MeasureSpec.getMode((int)n3);
        int n5 = View.MeasureSpec.getSize((int)n3);
        switch (n4) {
            default: {
                return n2;
            }
            case Integer.MIN_VALUE: {
                return Math.min(n2, n5);
            }
            case 1073741824: 
        }
        return n5;
    }

    public void draw(Canvas canvas) {
    }

    protected void onMeasure(int n2, int n3) {
        this.setMeasuredDimension(Space.a(this.getSuggestedMinimumWidth(), n2), Space.a(this.getSuggestedMinimumHeight(), n3));
    }
}

