/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.ActionBarContainer;
import android.support.v7.widget.c;

class d
extends c {
    public d(ActionBarContainer actionBarContainer) {
        super(actionBarContainer);
    }

    public void getOutline(Outline outline) {
        if (this.a.d) {
            if (this.a.c == null) return;
            this.a.c.getOutline(outline);
            return;
        }
        if (this.a.a == null) return;
        this.a.a.getOutline(outline);
    }
}

