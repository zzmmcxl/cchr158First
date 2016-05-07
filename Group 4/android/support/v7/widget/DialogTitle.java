/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.b.l;
import android.text.Layout;
import android.util.AttributeSet;
import android.widget.TextView;

public class DialogTitle
extends TextView {
    public DialogTitle(Context context) {
        super(context);
    }

    public DialogTitle(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DialogTitle(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
    }

    protected void onMeasure(int n2, int n3) {
        super.onMeasure(n2, n3);
        Layout layout = this.getLayout();
        if (layout == null) return;
        int n4 = layout.getLineCount();
        if (n4 <= 0) return;
        if (layout.getEllipsisCount(n4 - 1) <= 0) return;
        this.setSingleLine(false);
        this.setMaxLines(2);
        TypedArray typedArray = this.getContext().obtainStyledAttributes(null, l.TextAppearance, 16842817, 16973892);
        int n5 = typedArray.getDimensionPixelSize(l.TextAppearance_android_textSize, 0);
        if (n5 != 0) {
            this.setTextSize(0, (float)n5);
        }
        typedArray.recycle();
        super.onMeasure(n2, n3);
    }
}

