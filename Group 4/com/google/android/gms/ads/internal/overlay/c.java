/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.internal.InterstitialAdParameterParcel;
import com.google.android.gms.ads.internal.b;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.a;
import com.google.android.gms.ads.internal.g;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.d;
import com.google.android.gms.ads.internal.overlay.e;
import com.google.android.gms.ads.internal.overlay.l;
import com.google.android.gms.ads.internal.overlay.q;
import com.google.android.gms.ads.internal.overlay.r;
import com.google.android.gms.ads.internal.overlay.s;
import com.google.android.gms.ads.internal.overlay.t;
import com.google.android.gms.ads.internal.overlay.u;
import com.google.android.gms.ads.internal.overlay.v;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.b.az;
import com.google.android.gms.b.bq;
import com.google.android.gms.b.cf;
import com.google.android.gms.b.ch;
import com.google.android.gms.b.eg;
import com.google.android.gms.b.ek;
import com.google.android.gms.b.f;
import com.google.android.gms.b.fi;
import com.google.android.gms.b.fp;
import com.google.android.gms.b.hb;
import com.google.android.gms.b.hc;
import com.google.android.gms.b.he;
import java.util.Collections;
import java.util.Map;

@fi
public class c
extends ek
implements v {
    static final int a = Color.argb((int)0, (int)0, (int)0, (int)0);
    AdOverlayInfoParcel b;
    hb c;
    com.google.android.gms.ads.internal.overlay.g d;
    s e;
    boolean f = false;
    FrameLayout g;
    WebChromeClient.CustomViewCallback h;
    boolean i = false;
    boolean j = false;
    RelativeLayout k;
    boolean l = false;
    int m = 0;
    q n;
    private final Activity o;
    private boolean p;
    private boolean q = false;
    private boolean r = true;

    public c(Activity activity) {
        this.o = activity;
        this.n = new u();
    }

    static /* synthetic */ Activity a(c c2) {
        return c2.o;
    }

    public void a() {
        this.m = 2;
        this.o.finish();
    }

    public void a(int n2) {
        this.o.setRequestedOrientation(n2);
    }

    /*
     * Exception decompiling
     */
    @Override
    public void a(Bundle var1_1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: First case is not immediately after switch.
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.SwitchReplacer.examineSwitchContiguity(SwitchReplacer.java:366)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.SwitchReplacer.rebuildSwitches(SwitchReplacer.java:334)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:539)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
        // org.benf.cfr.reader.Main.doJar(Main.java:129)
        // org.benf.cfr.reader.Main.main(Main.java:181)
        // the.bytecode.club.bytecodeviewer.decompilers.CFRDecompiler.decompileToZip(CFRDecompiler.java:245)
        // the.bytecode.club.bytecodeviewer.gui.MainViewerGUI$18$1$3.run(MainViewerGUI.java:1107)
        throw new IllegalStateException("Decompilation failed");
    }

    public void a(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        this.g = new FrameLayout((Context)this.o);
        this.g.setBackgroundColor(-16777216);
        this.g.addView(view, -1, -1);
        this.o.setContentView((View)this.g);
        this.l();
        this.h = customViewCallback;
        this.f = true;
    }

    public void a(hb hb2, Map map) {
        this.n.a(hb2, map);
    }

    public void a(boolean bl2) {
        int n2 = bl2 ? 50 : 32;
        this.e = new s((Context)this.o, n2, this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        int n3 = bl2 ? 11 : 9;
        layoutParams.addRule(n3);
        this.e.a(bl2, this.b.h);
        this.k.addView((View)this.e, (ViewGroup.LayoutParams)layoutParams);
    }

    public void a(boolean bl2, boolean bl3) {
        if (this.e == null) return;
        this.e.a(bl2, bl3);
    }

    public void b() {
        if (this.b != null && this.f) {
            this.a(this.b.k);
        }
        if (this.g != null) {
            this.o.setContentView((View)this.k);
            this.l();
            this.g.removeAllViews();
            this.g = null;
        }
        if (this.h != null) {
            this.h.onCustomViewHidden();
            this.h = null;
        }
        this.f = false;
    }

    protected void b(int n2) {
        this.c.a(n2);
    }

    @Override
    public void b(Bundle bundle) {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.i);
    }

    protected void b(boolean bl2) {
        b b2;
        Window window;
        if (!this.p) {
            this.o.requestWindowFeature(1);
        }
        if ((window = this.o.getWindow()) == null) {
            throw new e("Invalid activity, no window available.");
        }
        if (!this.j || this.b.q != null && this.b.q.c) {
            window.setFlags(1024, 1024);
        }
        boolean bl3 = this.b.e.k().b();
        this.l = false;
        if (bl3) {
            if (this.b.k == g.e().a()) {
                boolean bl4 = this.o.getResources().getConfiguration().orientation == 1;
                this.l = bl4;
            } else if (this.b.k == g.e().b()) {
                boolean bl5 = this.o.getResources().getConfiguration().orientation == 2;
                this.l = bl5;
            }
        }
        fp.a("Delay onShow to next orientation change: " + this.l);
        this.a(this.b.k);
        if (g.e().a(window)) {
            fp.a("Hardware acceleration on the AdActivity window enabled.");
        }
        if (!this.j) {
            this.k.setBackgroundColor(-16777216);
        } else {
            this.k.setBackgroundColor(a);
        }
        this.o.setContentView((View)this.k);
        this.l();
        if (bl2) {
            this.c = g.d().a((Context)this.o, this.b.e.j(), true, bl3, null, this.b.n, null, this.b.e.g());
            this.c.k().a(null, null, this.b.f, this.b.j, true, this.b.o, null, this.b.e.k().a(), null);
            this.c.k().a(new d(this));
            if (this.b.m != null) {
                this.c.loadUrl(this.b.m);
            } else {
                if (this.b.i == null) throw new e("No URL or HTML to display in ad overlay.");
                this.c.loadDataWithBaseURL(this.b.g, this.b.i, "text/html", "UTF-8", null);
            }
            if (this.b.e != null) {
                this.b.e.b(this);
            }
        } else {
            this.c = this.b.e;
            this.c.a((Context)this.o);
        }
        this.c.a(this);
        ViewParent viewParent = this.c.getParent();
        if (viewParent != null && viewParent instanceof ViewGroup) {
            ((ViewGroup)viewParent).removeView(this.c.b());
        }
        if (this.j) {
            this.c.setBackgroundColor(a);
        }
        this.k.addView(this.c.b(), -1, -1);
        if (!bl2 && !this.l) {
            this.p();
        }
        this.a(bl3);
        if (this.c.l()) {
            this.a(bl3, true);
        }
        r r2 = (b2 = this.c.g()) != null ? b2.c : null;
        if (r2 != null) {
            this.n = r2.a(this.o, this.c, this.k);
            return;
        }
        fp.d("Appstreaming controller is null.");
    }

    @Override
    public void c() {
        this.m = 1;
        this.o.finish();
    }

    @Override
    public void d() {
        this.m = 0;
    }

    @Override
    public boolean e() {
        boolean bl2 = true;
        this.m = 0;
        if (this.c == null) {
            return bl2;
        }
        if (!this.c.r() || !this.n.d()) {
            bl2 = false;
        }
        if (bl2) return bl2;
        this.c.a("onbackblocked", Collections.emptyMap());
        return bl2;
    }

    @Override
    public void f() {
    }

    @Override
    public void g() {
    }

    @Override
    public void h() {
        if (this.b != null && this.b.l == 4) {
            if (this.i) {
                this.m = 3;
                this.o.finish();
            } else {
                this.i = true;
            }
        }
        if (this.b.d != null) {
            this.b.d.c();
        }
        if (this.c != null && !this.c.p()) {
            g.e().b(this.c);
        } else {
            fp.d("The webview does not exit. Ignoring action.");
        }
        this.n.b();
    }

    @Override
    public void i() {
        this.n.a();
        this.b();
        if (this.b.d != null) {
            this.b.d.b();
        }
        if (!(this.c == null || this.o.isFinishing() && this.d != null)) {
            g.e().a(this.c);
        }
        this.n();
    }

    @Override
    public void j() {
        this.n();
    }

    @Override
    public void k() {
        if (this.c != null) {
            this.k.removeView(this.c.b());
        }
        this.n();
    }

    @Override
    public void l() {
        this.p = true;
    }

    public void m() {
        this.k.removeView((View)this.e);
        this.a(true);
    }

    protected void n() {
        if (!this.o.isFinishing()) return;
        if (this.q) {
            return;
        }
        this.q = true;
        if (this.c != null) {
            this.b(this.m);
            this.k.removeView(this.c.b());
            if (this.d != null) {
                this.c.a(this.d.d);
                this.c.a(false);
                this.d.c.addView(this.c.b(), this.d.a, this.d.b);
                this.d = null;
            } else if (this.o.getApplicationContext() != null) {
                this.c.a(this.o.getApplicationContext());
            }
            this.c = null;
        }
        if (this.b != null && this.b.d != null) {
            this.b.d.a();
        }
        this.n.c();
    }

    public void o() {
        if (!this.l) return;
        this.l = false;
        this.p();
    }

    protected void p() {
        this.c.d();
    }
}

