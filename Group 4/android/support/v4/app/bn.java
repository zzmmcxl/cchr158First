/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.app;

import android.graphics.Bitmap;
import android.os.Build;
import android.support.v4.app.bl;
import android.support.v4.app.bm;
import android.support.v4.app.bo;
import android.support.v4.app.bq;
import android.support.v4.app.br;
import android.support.v4.app.bu;
import android.support.v4.app.bv;
import android.support.v4.app.bw;
import android.support.v4.app.bx;
import android.support.v4.app.by;
import android.support.v4.app.bz;
import android.support.v4.app.ca;
import android.support.v4.app.cb;
import android.support.v4.app.cc;
import android.support.v4.app.cd;
import android.support.v4.app.ce;
import android.support.v4.app.ck;
import android.support.v4.app.cq;
import java.util.ArrayList;
import java.util.Iterator;

public class bn {
    private static final bv a;

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            a = new bx();
            return;
        }
        if (Build.VERSION.SDK_INT >= 20) {
            a = new bw();
            return;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            a = new cd();
            return;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            a = new cc();
            return;
        }
        if (Build.VERSION.SDK_INT >= 14) {
            a = new cb();
            return;
        }
        if (Build.VERSION.SDK_INT >= 11) {
            a = new ca();
            return;
        }
        if (Build.VERSION.SDK_INT >= 9) {
            a = new bz();
            return;
        }
        a = new by();
    }

    static /* synthetic */ bv a() {
        return a;
    }

    static /* synthetic */ void a(bl bl2, ArrayList arrayList) {
        bn.b(bl2, arrayList);
    }

    static /* synthetic */ void a(bm bm2, ce ce2) {
        bn.b(bm2, ce2);
    }

    private static void b(bl bl2, ArrayList arrayList) {
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            bl2.a((bo)iterator.next());
        }
    }

    private static void b(bm bm2, ce ce2) {
        if (ce2 == null) return;
        if (ce2 instanceof br) {
            br br2 = (br)ce2;
            cq.a(bm2, br2.d, br2.f, br2.e, br2.a);
            return;
        }
        if (ce2 instanceof bu) {
            bu bu2 = (bu)ce2;
            cq.a(bm2, bu2.d, bu2.f, bu2.e, bu2.a);
            return;
        }
        if (!(ce2 instanceof bq)) return;
        bq bq2 = (bq)ce2;
        cq.a(bm2, bq2.d, bq2.f, bq2.e, bq2.a, bq2.b, bq2.c);
    }
}

