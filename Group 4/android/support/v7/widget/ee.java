/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.aj;
import android.support.v7.widget.ak;
import android.support.v7.widget.ca;
import android.support.v7.widget.ep;
import android.support.v7.widget.fc;
import android.support.v7.widget.ff;
import android.view.View;

class ee
implements aj {
    final /* synthetic */ RecyclerView a;

    ee(RecyclerView recyclerView) {
        this.a = recyclerView;
    }

    @Override
    public ff a(int n2) {
        ff ff2 = this.a.a(n2, true);
        if (ff2 == null) {
            return null;
        }
        if (this.a.c.c(ff2.a)) return null;
        return ff2;
    }

    @Override
    public void a(int n2, int n3) {
        this.a.a(n2, n3, true);
        this.a.h = true;
        fc.a(this.a.g, n3);
    }

    @Override
    public void a(int n2, int n3, Object object) {
        this.a.a(n2, n3, object);
        this.a.i = true;
    }

    @Override
    public void a(ak ak2) {
        this.c(ak2);
    }

    @Override
    public void b(int n2, int n3) {
        this.a.a(n2, n3, false);
        this.a.h = true;
    }

    @Override
    public void b(ak ak2) {
        this.c(ak2);
    }

    @Override
    public void c(int n2, int n3) {
        this.a.e(n2, n3);
        this.a.h = true;
    }

    void c(ak ak2) {
        switch (ak2.a) {
            default: {
                return;
            }
            case 1: {
                this.a.e.a(this.a, ak2.b, ak2.d);
                return;
            }
            case 2: {
                this.a.e.b(this.a, ak2.b, ak2.d);
                return;
            }
            case 4: {
                this.a.e.a(this.a, ak2.b, ak2.d, ak2.c);
                return;
            }
            case 8: 
        }
        this.a.e.a(this.a, ak2.b, ak2.d, 1);
    }

    @Override
    public void d(int n2, int n3) {
        this.a.d(n2, n3);
        this.a.h = true;
    }
}

