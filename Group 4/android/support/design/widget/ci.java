/*
 * Decompiled with CFR 0_115.
 */
package android.support.design.widget;

import android.graphics.Rect;
import android.support.design.widget.cg;
import android.support.design.widget.ch;
import android.view.View;
import android.view.ViewGroup;

class ci
implements ch {
    private ci() {
    }

    /* synthetic */ ci(cg cg2) {
        this();
    }

    @Override
    public void a(ViewGroup viewGroup, View view, Rect rect) {
        viewGroup.offsetDescendantRectToMyCoords(view, rect);
        rect.offset(view.getScrollX(), view.getScrollY());
    }
}

