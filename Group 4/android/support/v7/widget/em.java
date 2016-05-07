/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.support.v7.widget.ff;
import android.view.View;

public class em {
    public int a;
    public int b;
    public int c;
    public int d;

    public em a(ff ff2) {
        return this.a(ff2, 0);
    }

    public em a(ff ff2, int n2) {
        View view = ff2.a;
        this.a = view.getLeft();
        this.b = view.getTop();
        this.c = view.getRight();
        this.d = view.getBottom();
        return this;
    }
}

