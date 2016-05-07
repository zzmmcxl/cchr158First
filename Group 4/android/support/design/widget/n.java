/*
 * Decompiled with CFR 0_115.
 */
package android.support.design.widget;

import android.graphics.Outline;
import android.graphics.Rect;
import android.support.design.widget.m;

class n
extends m {
    n() {
    }

    public void getOutline(Outline outline) {
        this.copyBounds(this.b);
        outline.setOval(this.b);
    }
}

