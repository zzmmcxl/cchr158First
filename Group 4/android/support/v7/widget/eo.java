/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.er;
import android.support.v7.widget.fc;
import android.view.View;
import android.view.ViewGroup;

public abstract class eo {
    @Deprecated
    public void a(Canvas canvas, RecyclerView recyclerView) {
    }

    public void a(Canvas canvas, RecyclerView recyclerView, fc fc2) {
        this.a(canvas, recyclerView);
    }

    @Deprecated
    public void a(Rect rect, int n2, RecyclerView recyclerView) {
        rect.set(0, 0, 0, 0);
    }

    public void a(Rect rect, View view, RecyclerView recyclerView, fc fc2) {
        this.a(rect, ((er)view.getLayoutParams()).e(), recyclerView);
    }

    @Deprecated
    public void b(Canvas canvas, RecyclerView recyclerView) {
    }

    public void b(Canvas canvas, RecyclerView recyclerView, fc fc2) {
        this.b(canvas, recyclerView);
    }
}

