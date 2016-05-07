/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.support.v7.widget.ch;
import android.support.v7.widget.ff;

class cp {
    public ff a;
    public ff b;
    public int c;
    public int d;
    public int e;
    public int f;

    private cp(ff ff2, ff ff3) {
        this.a = ff2;
        this.b = ff3;
    }

    private cp(ff ff2, ff ff3, int n2, int n3, int n4, int n5) {
        this(ff2, ff3);
        this.c = n2;
        this.d = n3;
        this.e = n4;
        this.f = n5;
    }

    /* synthetic */ cp(ff ff2, ff ff3, int n2, int n3, int n4, int n5, ch ch2) {
        this(ff2, ff3, n2, n3, n4, n5);
    }

    public String toString() {
        return "ChangeInfo{oldHolder=" + this.a + ", newHolder=" + this.b + ", fromX=" + this.c + ", fromY=" + this.d + ", toX=" + this.e + ", toY=" + this.f + '}';
    }
}

