/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.support.v4.g.o;
import android.support.v4.g.p;
import android.support.v7.widget.em;

class gw {
    static o d = new p(20);
    int a;
    em b;
    em c;

    private gw() {
    }

    static gw a() {
        gw gw2 = (gw)d.a();
        if (gw2 != null) return gw2;
        return new gw();
    }

    static void a(gw gw2) {
        gw2.a = 0;
        gw2.b = null;
        gw2.c = null;
        d.a(gw2);
    }

    static void b() {
        while (d.a() != null) {
        }
    }
}

