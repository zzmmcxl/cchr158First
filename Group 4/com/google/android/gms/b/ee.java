/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.n;
import com.google.android.gms.ads.internal.g;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.b.ad;
import com.google.android.gms.b.ce;
import com.google.android.gms.b.eb;
import com.google.android.gms.b.ed;
import com.google.android.gms.b.ef;
import com.google.android.gms.b.fi;
import com.google.android.gms.b.fp;
import com.google.android.gms.b.hb;
import com.google.android.gms.b.hc;
import java.util.Map;
import org.json.JSONObject;

@fi
public class ee
extends ef
implements ce {
    DisplayMetrics a;
    int b = -1;
    int c = -1;
    int d = -1;
    int e = -1;
    int f = -1;
    int g = -1;
    private final hb h;
    private final Context i;
    private final WindowManager j;
    private final ad k;
    private float l;
    private int m;

    public ee(hb hb2, Context context, ad ad2) {
        super(hb2);
        this.h = hb2;
        this.i = context;
        this.k = ad2;
        this.j = (WindowManager)context.getSystemService("window");
    }

    private void g() {
        this.a = new DisplayMetrics();
        Display display = this.j.getDefaultDisplay();
        display.getMetrics(this.a);
        this.l = this.a.density;
        this.m = display.getRotation();
    }

    private void h() {
        int[] arrn = new int[2];
        this.h.getLocationOnScreen(arrn);
        this.a(n.a().b(this.i, arrn[0]), n.a().b(this.i, arrn[1]));
    }

    private eb i() {
        return new ed().b(this.k.a()).a(this.k.b()).c(this.k.f()).d(this.k.c()).e(this.k.d()).a();
    }

    void a() {
        this.b = n.a().b(this.a, this.a.widthPixels);
        this.c = n.a().b(this.a, this.a.heightPixels);
        Activity activity = this.h.e();
        if (activity != null && activity.getWindow() != null) {
            int[] arrn = g.c().a(activity);
            this.d = n.a().b(this.a, arrn[0]);
            this.e = n.a().b(this.a, arrn[1]);
            return;
        }
        this.d = this.b;
        this.e = this.c;
    }

    public void a(int n2, int n3) {
        int n4 = this.i instanceof Activity ? g.c().d((Activity)this.i)[0] : 0;
        this.b(n2, n3 - n4, this.f, this.g);
        this.h.k().a(n2, n3);
    }

    @Override
    public void a(hb hb2, Map map) {
        this.c();
    }

    void b() {
        if (this.h.j().e) {
            this.f = this.b;
            this.g = this.c;
            return;
        }
        this.h.measure(0, 0);
        this.f = n.a().b(this.i, this.h.getMeasuredWidth());
        this.g = n.a().b(this.i, this.h.getMeasuredHeight());
    }

    public void c() {
        this.g();
        this.a();
        this.b();
        this.e();
        this.f();
        this.h();
        this.d();
    }

    void d() {
        if (fp.a(2)) {
            fp.c("Dispatching Ready Event.");
        }
        this.c(this.h.n().b);
    }

    void e() {
        this.a(this.b, this.c, this.d, this.e, this.l, this.m);
    }

    void f() {
        eb eb2 = this.i();
        this.h.a("onDeviceFeaturesReceived", eb2.a());
    }
}

