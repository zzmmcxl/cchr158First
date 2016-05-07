/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.b.kf;
import com.google.android.gms.b.lj;
import com.google.android.gms.b.lm;
import com.google.android.gms.b.ln;
import com.google.android.gms.b.lp;
import com.google.android.gms.b.lq;
import com.google.android.gms.b.ls;
import com.google.android.gms.measurement.AppMeasurementReceiver;
import com.google.android.gms.measurement.AppMeasurementService;
import com.google.android.gms.measurement.a;
import com.google.android.gms.measurement.internal.AppMetadata;
import com.google.android.gms.measurement.internal.EventParams;
import com.google.android.gms.measurement.internal.EventParcel;
import com.google.android.gms.measurement.internal.UserAttributeParcel;
import com.google.android.gms.measurement.internal.ad;
import com.google.android.gms.measurement.internal.af;
import com.google.android.gms.measurement.internal.ag;
import com.google.android.gms.measurement.internal.ai;
import com.google.android.gms.measurement.internal.aj;
import com.google.android.gms.measurement.internal.ak;
import com.google.android.gms.measurement.internal.al;
import com.google.android.gms.measurement.internal.aq;
import com.google.android.gms.measurement.internal.ar;
import com.google.android.gms.measurement.internal.as;
import com.google.android.gms.measurement.internal.b;
import com.google.android.gms.measurement.internal.ba;
import com.google.android.gms.measurement.internal.bc;
import com.google.android.gms.measurement.internal.be;
import com.google.android.gms.measurement.internal.bf;
import com.google.android.gms.measurement.internal.bh;
import com.google.android.gms.measurement.internal.bk;
import com.google.android.gms.measurement.internal.bn;
import com.google.android.gms.measurement.internal.bq;
import com.google.android.gms.measurement.internal.bs;
import com.google.android.gms.measurement.internal.bt;
import com.google.android.gms.measurement.internal.by;
import com.google.android.gms.measurement.internal.bz;
import com.google.android.gms.measurement.internal.c;
import com.google.android.gms.measurement.internal.ca;
import com.google.android.gms.measurement.internal.ck;
import com.google.android.gms.measurement.internal.cl;
import com.google.android.gms.measurement.internal.d;
import com.google.android.gms.measurement.internal.i;
import com.google.android.gms.measurement.internal.u;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class bx {
    private static c a;
    private static volatile bx b;
    private final Context c;
    private final aj d;
    private final bn e;
    private final bc f;
    private final bt g;
    private final u h;
    private final bs i;
    private final a j;
    private final ag k;
    private final ak l;
    private final bf m;
    private final kf n;
    private final i o;
    private final aq p;
    private final d q;
    private final ba r;
    private final bk s;
    private final ad t;
    private final ai u;
    private final boolean v;
    private Boolean w;
    private List x;
    private int y;
    private int z;

    bx(c c2) {
        com.google.android.gms.common.internal.bf.a(c2);
        this.c = c2.a;
        this.n = c2.l(this);
        this.d = c2.a(this);
        bn bn2 = c2.b(this);
        bn2.H();
        this.e = bn2;
        bc bc2 = c2.c(this);
        bc2.H();
        this.f = bc2;
        this.f().x().a("App measurement is starting up, version", this.d().M());
        this.f().x().a("To enable debug logging run: adb shell setprop log.tag.GMPM VERBOSE");
        this.f().y().a("Debug logging enabled");
        this.k = c2.i(this);
        aq aq2 = c2.n(this);
        aq2.H();
        this.p = aq2;
        ba ba2 = c2.o(this);
        ba2.H();
        this.r = ba2;
        ak ak2 = c2.j(this);
        ak2.H();
        this.l = ak2;
        ai ai2 = c2.r(this);
        ai2.H();
        this.u = ai2;
        bf bf2 = c2.k(this);
        bf2.H();
        this.m = bf2;
        i i2 = c2.m(this);
        i2.H();
        this.o = i2;
        d d2 = c2.h(this);
        d2.H();
        this.q = d2;
        ad ad2 = c2.q(this);
        ad2.H();
        this.t = ad2;
        this.s = c2.p(this);
        this.j = c2.g(this);
        u u2 = c2.e(this);
        u2.H();
        this.h = u2;
        bs bs2 = c2.f(this);
        bs2.H();
        this.i = bs2;
        bt bt2 = c2.d(this);
        bt2.H();
        this.g = bt2;
        if (this.y != this.z) {
            this.f().b().a("Not all components initialized", this.y, this.z);
        }
        this.v = true;
        if (!this.d.N() && !this.y()) {
            if (this.c.getApplicationContext() instanceof Application) {
                if (Build.VERSION.SDK_INT >= 14) {
                    this.l().b();
                } else {
                    this.f().y().a("Not tracking deep linking pre-ICS");
                }
            } else {
                this.f().c().a("Application context is not an Application");
            }
        }
        this.g.a(new by(this));
    }

    private boolean D() {
        this.x();
        if (this.x == null) return false;
        return true;
    }

    private boolean E() {
        this.x();
        this.a();
        if (this.n().C()) return true;
        if (TextUtils.isEmpty((CharSequence)this.n().x())) return false;
        return true;
    }

    private void F() {
        this.x();
        this.a();
        if (!this.b() || !this.E()) {
            this.u().b();
            this.v().b();
            return;
        }
        long l2 = this.G();
        if (l2 == 0) {
            this.u().b();
            this.v().b();
            return;
        }
        if (!this.o().b()) {
            this.u().a();
            this.v().b();
            return;
        }
        long l3 = this.e().e.a();
        long l4 = this.d().X();
        if (!this.m().a(l3, l4)) {
            l2 = Math.max(l2, l3 + l4);
        }
        this.u().b();
        long l5 = l2 - this.q().a();
        if (l5 <= 0) {
            this.v().a(1);
            return;
        }
        this.f().z().a("Upload scheduled in approximately ms", l5);
        this.v().a(l5);
    }

    private long G() {
        long l2 = this.q().a();
        long l3 = this.d().aa();
        long l4 = this.d().Y();
        long l5 = this.e().c.a();
        long l6 = this.e().d.a();
        long l7 = Math.max(this.n().A(), this.n().B());
        if (l7 == 0) {
            return 0;
        }
        long l8 = l2 - Math.abs(l7 - l2);
        long l9 = l2 - Math.abs(l5 - l2);
        long l10 = l2 - Math.abs(l6 - l2);
        long l11 = Math.max(l9, l10);
        long l12 = l3 + l8;
        if (!this.m().a(l11, l4)) {
            l12 = l11 + l4;
        }
        if (l10 == 0) return l12;
        if (l10 < l8) return l12;
        int n2 = 0;
        while (n2 < this.d().ac()) {
            if ((l12 += (long)(1 << n2) * this.d().ab()) > l10) return l12;
            ++n2;
        }
        return 0;
    }

    public static bx a(Context context) {
        com.google.android.gms.common.internal.bf.a((Object)context);
        com.google.android.gms.common.internal.bf.a((Object)context.getApplicationContext());
        if (b != null) return b;
        // MONITORENTER : com.google.android.gms.measurement.internal.bx.class
        if (b == null) {
            c c2 = a != null ? a : new c(context);
            b = c2.a();
        }
        // MONITOREXIT : com.google.android.gms.measurement.internal.bx.class
        return b;
    }

    /*
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    private void a(int var1_1, Throwable var2_2, byte[] var3_3) {
        this.x();
        this.a();
        if (var3_3 == null) {
            var3_3 = new byte[]{};
        }
        var4_4 = this.x;
        this.x = null;
        if ((var1_1 == 200 || var1_1 == 204) && var2_2 == null) {
            this.e().c.a(this.q().a());
            this.e().d.a(0);
            this.F();
            this.f().z().a("Successful upload. Got network response. code, size", var1_1, var3_3.length);
            this.n().b();
            try {
                for (Long var8_6 : var4_4) {
                    this.n().a(var8_6);
                }
                this.n().c();
            }
            finally {
                this.n().v();
            }
            if (this.o().b() && this.E()) {
                this.B();
                return;
            }
            this.F();
            return;
        }
        this.f().z().a("Network upload failed. Will retry later. code, error", var1_1, var2_2);
        this.e().d.a(this.q().a());
        if (var1_1 == 503) ** GOTO lbl-1000
        var5_8 = false;
        if (var1_1 == 429) lbl-1000: // 2 sources:
        {
            if (var5_8 = true) {
                this.e().e.a(this.q().a());
            }
        }
        this.F();
    }

    private void a(Bundle bundle, int n2) {
        if (bundle.getLong("_err") != 0) return;
        bundle.putLong("_err", (long)n2);
    }

    static /* synthetic */ void a(bx bx2, int n2, Throwable throwable, byte[] arrby) {
        bx2.a(n2, throwable, arrby);
    }

    static /* synthetic */ void a(bx bx2, String string, int n2, Throwable throwable, byte[] arrby) {
        bx2.a(string, n2, throwable, arrby);
    }

    private void a(ck ck2) {
        if (ck2 != null) return;
        throw new IllegalStateException("Component not created");
    }

    /*
     * Exception decompiling
     */
    private void a(String var1_1, int var2_2, Throwable var3_3, byte[] var4_4) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // java.lang.IllegalStateException: Backjump on non jumping statement [] lbl43 : TryStatement: try { 6[TRYBLOCK]

        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.Cleaner$1.call(Cleaner.java:44)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.Cleaner$1.call(Cleaner.java:22)
        // org.benf.cfr.reader.util.graph.GraphVisitorDFS.process(GraphVisitorDFS.java:68)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.Cleaner.removeUnreachableCode(Cleaner.java:54)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.RemoveDeterministicJumps.apply(RemoveDeterministicJumps.java:35)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:519)
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

    private void a(List list) {
        boolean bl2 = !list.isEmpty();
        com.google.android.gms.common.internal.bf.b(bl2);
        if (this.x != null) {
            this.f().b().a("Set uploading progress before finishing the previous upload");
            return;
        }
        this.x = new ArrayList(list);
    }

    /*
     * Exception decompiling
     */
    private boolean a(String var1_1, long var2_2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 5[UNCONDITIONALDOLOOP]
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:394)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:446)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:2869)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:817)
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

    private lm[] a(String string, ls[] arrls, ln[] arrln) {
        com.google.android.gms.common.internal.bf.a(string);
        return this.w().a(string, arrln, arrls);
    }

    private void b(cl cl2) {
        if (cl2 == null) {
            throw new IllegalStateException("Component not created");
        }
        if (cl2.E()) return;
        throw new IllegalStateException("Component not initialized");
    }

    private void c(AppMetadata appMetadata) {
        boolean bl2;
        boolean bl3 = true;
        this.x();
        this.a();
        com.google.android.gms.common.internal.bf.a(appMetadata);
        com.google.android.gms.common.internal.bf.a(appMetadata.b);
        b b2 = this.n().b(appMetadata.b);
        String string = this.e().b(appMetadata.b);
        if (b2 == null) {
            b b3 = new b(this, appMetadata.b);
            b3.a(this.e().b());
            b3.c(string);
            b2 = b3;
            bl2 = bl3;
        } else {
            boolean bl4 = string.equals(b2.e());
            bl2 = false;
            if (!bl4) {
                b2.c(string);
                b2.a(this.e().b());
                bl2 = bl3;
            }
        }
        if (!TextUtils.isEmpty((CharSequence)appMetadata.c) && !appMetadata.c.equals(b2.d())) {
            b2.b(appMetadata.c);
            bl2 = bl3;
        }
        if (appMetadata.f != 0 && appMetadata.f != b2.j()) {
            b2.c(appMetadata.f);
            bl2 = bl3;
        }
        if (!TextUtils.isEmpty((CharSequence)appMetadata.d) && !appMetadata.d.equals(b2.h())) {
            b2.d(appMetadata.d);
            bl2 = bl3;
        }
        if (!TextUtils.isEmpty((CharSequence)appMetadata.e) && !appMetadata.e.equals(b2.i())) {
            b2.e(appMetadata.e);
            bl2 = bl3;
        }
        if (appMetadata.g != b2.k()) {
            b2.d(appMetadata.g);
            bl2 = bl3;
        }
        if (appMetadata.i != b2.l()) {
            b2.a(appMetadata.i);
        } else {
            bl3 = bl2;
        }
        if (!bl3) return;
        this.n().a(b2);
    }

    void A() {
        if (!this.d().N()) return;
        throw new IllegalStateException("Unexpected call on package side");
    }

    public void B() {
        int n2;
        long l2;
        String string;
        List list;
        List list2;
        String string2;
        block20 : {
            n2 = 0;
            this.x();
            this.a();
            if (!this.d().N()) {
                Boolean bl2 = this.e().v();
                if (bl2 == null) {
                    this.f().c().a("Upload data called on the client side before use of service was decided");
                    return;
                }
                if (bl2.booleanValue()) {
                    this.f().b().a("Upload called in the client side when service should be used");
                    return;
                }
            }
            if (this.D()) {
                this.f().c().a("Uploading requested multiple times");
                return;
            }
            if (!this.o().b()) {
                this.f().c().a("Network not connected, ignoring upload request");
                this.F();
                return;
            }
            l2 = this.q().a();
            this.a(l2 - this.d().W());
            long l3 = this.e().c.a();
            if (l3 != 0) {
                this.f().y().a("Uploading events. Elapsed time since last upload attempt (ms)", Math.abs(l2 - l3));
            }
            if (!TextUtils.isEmpty((CharSequence)(string2 = this.n().x()))) {
                int n3 = this.d().c(string2);
                int n4 = this.d().d(string2);
                list2 = this.n().a(string2, n3, n4);
                if (list2.isEmpty()) return;
                Iterator iterator = list2.iterator();
                while (iterator.hasNext()) {
                    lq lq2 = (lq)((Pair)iterator.next()).first;
                    if (TextUtils.isEmpty((CharSequence)lq2.s)) continue;
                    string = lq2.s;
                    break block20;
                }
            } else {
                String string3 = this.n().b(l2 - this.d().W());
                if (TextUtils.isEmpty((CharSequence)string3)) return;
                b b2 = this.n().b(string3);
                if (b2 == null) return;
                String string4 = this.d().a(b2.d(), b2.c());
                try {
                    URL uRL = new URL(string4);
                    this.f().z().a("Fetching remote configuration", b2.b());
                    lj lj2 = this.j().a(b2.b());
                    android.support.v4.g.a a2 = null;
                    if (lj2 != null) {
                        Long l4 = lj2.a;
                        a2 = null;
                        if (l4 != null) {
                            a2 = new android.support.v4.g.a();
                            a2.put("Config-Version", String.valueOf(lj2.a));
                        }
                    }
                    this.o().a(string3, uRL, a2, new ca(this));
                    return;
                }
                catch (MalformedURLException var12_30) {
                    this.f().b().a("Failed to parse config URL. Not fetching", string4);
                    return;
                }
            }
            string = null;
        }
        if (string != null) {
            for (int i2 = 0; i2 < list2.size(); ++i2) {
                lq lq3 = (lq)((Pair)list2.get((int)i2)).first;
                if (TextUtils.isEmpty((CharSequence)lq3.s) || lq3.s.equals(string)) continue;
                list = list2.subList(0, i2);
                break;
            }
        } else {
            list = list2;
        }
        lp lp2 = new lp();
        lp2.a = new lq[list.size()];
        ArrayList<Object> arrayList = new ArrayList<Object>(list.size());
        while (n2 < lp2.a.length) {
            lp2.a[n2] = (lq)((Pair)list.get((int)n2)).first;
            arrayList.add(((Pair)list.get((int)n2)).second);
            lp2.a[n2].r = this.d().M();
            lp2.a[n2].d = l2;
            lp2.a[n2].z = this.d().N();
            ++n2;
        }
        String string5 = this.f().a(2) ? ag.b(lp2) : null;
        byte[] arrby = this.m().a(lp2);
        String string6 = this.d().V();
        try {
            URL uRL = new URL(string6);
            this.a(arrayList);
            this.e().d.a(l2);
            String string7 = "?";
            if (lp2.a.length > 0) {
                string7 = lp2.a[0].o;
            }
            this.f().z().a("Uploading data. app, uncompressed size, data", string7, arrby.length, string5);
            this.o().a(string2, uRL, arrby, null, new bz(this));
            return;
        }
        catch (MalformedURLException var29_22) {
            this.f().b().a("Failed to parse upload URL. Not uploading", string6);
            return;
        }
    }

    void C() {
        this.z = 1 + this.z;
    }

    void a() {
        if (this.v) return;
        throw new IllegalStateException("AppMeasurement is not initialized");
    }

    void a(AppMetadata appMetadata) {
        this.x();
        this.a();
        com.google.android.gms.common.internal.bf.a(appMetadata.b);
        this.c(appMetadata);
    }

    /*
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    void a(EventParcel var1_1, AppMetadata var2_2) {
        block23 : {
            block24 : {
                block22 : {
                    block21 : {
                        var3_3 = System.nanoTime();
                        this.x();
                        this.a();
                        var5_4 = var2_2.b;
                        com.google.android.gms.common.internal.bf.a(var5_4);
                        if (TextUtils.isEmpty((CharSequence)var2_2.c)) {
                            return;
                        }
                        if (!var2_2.i) {
                            this.c(var2_2);
                            return;
                        }
                        if (this.j().b(var5_4, var1_1.b)) {
                            this.f().z().a("Dropping blacklisted event", var1_1.b);
                            return;
                        }
                        if (this.f().a(2)) {
                            this.f().z().a("Logging event", var1_1);
                        }
                        this.n().b();
                        var8_5 = var1_1.c.b();
                        this.c(var2_2);
                        if ("_iap".equals(var1_1.b) || "ecommerce_purchase".equals(var1_1.b)) {
                            var9_6 = var8_5.getString("currency");
                            var10_7 = var8_5.getLong("value");
                            if (!TextUtils.isEmpty((CharSequence)var9_6) && var10_7 > 0 && (var12_8 = var9_6.toUpperCase(Locale.US)).matches("[A-Z]{3}")) {
                                var30_9 = "_ltv_" + var12_8;
                                var31_10 = this.n().c(var5_4, var30_9);
                                if (var31_10 == null || !(var31_10.d instanceof Long)) {
                                    this.n().a(var5_4, -1 + this.d().b(var5_4));
                                    var32_11 = new af(var5_4, var30_9, this.q().a(), var10_7);
                                } else {
                                    var34_19 = (Long)var31_10.d;
                                    var32_11 = new af(var5_4, var30_9, this.q().a(), var10_7 + var34_19);
                                }
                                this.n().a(var32_11);
                            }
                        }
                        var13_12 = ag.a(var1_1.b);
                        var14_13 = ag.a(var8_5);
                        var15_14 = this.n();
                        var16_15 = this.z();
                        var18_16 = var13_12 != false && var14_13 != false;
                        var19_17 = var15_14.a(var16_15, var5_4, var13_12, var18_16);
                        var20_18 = var19_17.b - this.d().B();
                        if (var20_18 <= 0) break block21;
                        if (var20_18 % 1000 != 1) ** GOTO lbl46
                        try {
                            this.f().c().a("Data loss. Too many events logged. count", var19_17.b);
lbl46: // 2 sources:
                            this.n().c();
                            return;
                        }
                        finally {
                            this.n().v();
                        }
                    }
                    if (!var13_12) ** GOTO lbl63
                    var28_21 = var19_17.a - this.d().C();
                    if (var28_21 <= 0) break block22;
                    this.a(var5_4, 2);
                    if (var28_21 % 1000 != 1) ** GOTO lbl60
                    this.f().c().a("Data loss. Too many public events logged. count", var19_17.a);
lbl60: // 2 sources:
                    this.n().c();
                    this.n().v();
                    return;
                }
                if (!var13_12 || !var14_13) ** GOTO lbl69
                if (var19_17.c - this.d().D() > 0) {
                    var8_5.remove("_c");
                    this.a(var8_5, 4);
                }
lbl69: // 4 sources:
                if ((var22_22 = this.n().c(var5_4)) > 0) {
                    this.f().c().a("Data lost. Too many events stored on disk, deleted", var22_22);
                }
                var24_23 = new ar(this, var1_1.d, var5_4, var1_1.b, var1_1.e, 0, var8_5);
                var25_24 = this.n().a(var5_4, var24_23.b);
                if (var25_24 != null) break block23;
                if (this.n().g(var5_4) < (long)this.d().A()) break block24;
                this.f().c().a("Too many event names used, ignoring event. name, supported count", var24_23.b, this.d().A());
                this.a(var5_4, 1);
                this.n().v();
                return;
            }
            var26_25 = new as(var5_4, var24_23.b, 0, 0, var24_23.d);
        }
        var24_23 = var24_23.a(this, var25_24.e);
        var26_25 = var27_26 = var25_24.a(var24_23.d);
        this.n().a(var26_25);
        this.a(var24_23, var2_2);
        this.n().c();
        if (this.f().a(2)) {
            this.f().z().a("Event recorded", var24_23);
        }
        this.n().v();
        this.F();
        this.f().z().a("Background event processing time, ms", (500000 + (System.nanoTime() - var3_3)) / 1000000);
    }

    void a(EventParcel eventParcel, String string) {
        b b2 = this.n().b(string);
        if (b2 == null || TextUtils.isEmpty((CharSequence)b2.h())) {
            this.f().y().a("No app data available; dropping event", string);
            return;
        }
        try {
            String string2 = this.p().getPackageManager().getPackageInfo((String)string, (int)0).versionName;
            if (b2.h() != null && !b2.h().equals(string2)) {
                this.f().c().a("App version does not match; dropping event", string);
                return;
            }
        }
        catch (PackageManager.NameNotFoundException var4_5) {
            this.f().c().a("Could not find package", string);
        }
        this.a(eventParcel, new AppMetadata(string, b2.d(), b2.h(), b2.i(), b2.j(), b2.k(), null, b2.l(), false));
    }

    void a(UserAttributeParcel userAttributeParcel, AppMetadata appMetadata) {
        this.x();
        this.a();
        if (TextUtils.isEmpty((CharSequence)appMetadata.c)) {
            return;
        }
        if (!appMetadata.i) {
            this.c(appMetadata);
            return;
        }
        this.m().c(userAttributeParcel.b);
        Object object = this.m().c(userAttributeParcel.b, userAttributeParcel.a());
        if (object == null) return;
        af af2 = new af(appMetadata.b, userAttributeParcel.b, userAttributeParcel.c, object);
        this.f().y().a("Setting user property", af2.b, object);
        this.n().b();
        try {
            this.c(appMetadata);
            boolean bl2 = this.n().a(af2);
            this.n().c();
            if (bl2) {
                this.f().y().a("User property set", af2.b, af2.d);
                return;
            }
            this.f().w().a("Ignoring user property. Value too long", af2.b, af2.d);
            return;
        }
        finally {
            this.n().v();
        }
    }

    void a(ar ar2, AppMetadata appMetadata) {
        this.x();
        this.a();
        com.google.android.gms.common.internal.bf.a(ar2);
        com.google.android.gms.common.internal.bf.a(appMetadata);
        com.google.android.gms.common.internal.bf.a(ar2.a);
        com.google.android.gms.common.internal.bf.b(ar2.a.equals(appMetadata.b));
        lq lq2 = new lq();
        lq2.a = 1;
        lq2.i = "android";
        lq2.o = appMetadata.b;
        lq2.n = appMetadata.e;
        lq2.p = appMetadata.d;
        lq2.q = appMetadata.f;
        lq2.y = appMetadata.c;
        Long l2 = appMetadata.g == 0 ? null : Long.valueOf(appMetadata.g);
        lq2.v = l2;
        Pair pair = this.e().a(appMetadata.b);
        if (pair != null && pair.first != null && pair.second != null) {
            lq2.s = (String)pair.first;
            lq2.t = (Boolean)pair.second;
        }
        lq2.k = this.s().b();
        lq2.j = this.s().c();
        lq2.m = (int)this.s().v();
        lq2.l = this.s().w();
        lq2.r = null;
        lq2.d = null;
        lq2.e = null;
        lq2.f = null;
        b b2 = this.n().b(appMetadata.b);
        if (b2 == null) {
            b2 = new b(this, appMetadata.b);
            b2.a(this.e().b());
            b2.b(appMetadata.c);
            b2.c(this.e().b(appMetadata.b));
            b2.e(0);
            b2.a(0);
            b2.b(0);
            b2.d(appMetadata.d);
            b2.e(appMetadata.e);
            b2.c(appMetadata.f);
            b2.d(appMetadata.g);
            b2.a(appMetadata.i);
            this.n().a(b2);
        }
        lq2.u = b2.c();
        List list = this.n().a(appMetadata.b);
        lq2.c = new ls[list.size()];
        for (int i2 = 0; i2 < list.size(); ++i2) {
            ls ls2;
            lq2.c[i2] = ls2 = new ls();
            ls2.b = ((af)list.get((int)i2)).b;
            ls2.a = ((af)list.get((int)i2)).c;
            this.m().a(ls2, ((af)list.get((int)i2)).d);
        }
        try {
            long l3 = this.n().b(lq2);
            this.n().a(ar2, l3);
            return;
        }
        catch (IOException var13_11) {
            this.f().b().a("Data loss. Failed to insert raw event metadata", var13_11);
            return;
        }
    }

    void a(cl cl2) {
        this.y = 1 + this.y;
    }

    void a(String string, int n2) {
    }

    public void a(boolean bl2) {
        this.F();
    }

    boolean a(long l2) {
        return this.a(null, l2);
    }

    public void b(AppMetadata appMetadata) {
        this.x();
        this.a();
        com.google.android.gms.common.internal.bf.a(appMetadata);
        com.google.android.gms.common.internal.bf.a(appMetadata.b);
        if (TextUtils.isEmpty((CharSequence)appMetadata.c)) {
            return;
        }
        if (!appMetadata.i) {
            this.c(appMetadata);
            return;
        }
        long l2 = this.q().a();
        this.n().b();
        try {
            b b2 = this.n().b(appMetadata.b);
            if (b2 != null && b2.h() != null && !b2.h().equals(appMetadata.d)) {
                Bundle bundle = new Bundle();
                bundle.putString("_pv", b2.h());
                this.a(new EventParcel("_au", new EventParams(bundle), "auto", l2), appMetadata);
            }
            this.c(appMetadata);
            if (this.n().a(appMetadata.b, "_f") == null) {
                this.a(new UserAttributeParcel("_fot", l2, 3600000 * (1 + l2 / 3600000), "auto"), appMetadata);
                Bundle bundle = new Bundle();
                bundle.putLong("_c", 1);
                this.a(new EventParcel("_f", new EventParams(bundle), "auto", l2), appMetadata);
            } else if (appMetadata.j) {
                this.a(new EventParcel("_cd", new EventParams(new Bundle()), "auto", l2), appMetadata);
            }
            this.n().c();
            return;
        }
        finally {
            this.n().v();
        }
    }

    void b(UserAttributeParcel userAttributeParcel, AppMetadata appMetadata) {
        this.x();
        this.a();
        if (TextUtils.isEmpty((CharSequence)appMetadata.c)) {
            return;
        }
        if (!appMetadata.i) {
            this.c(appMetadata);
            return;
        }
        this.f().y().a("Removing user property", userAttributeParcel.b);
        this.n().b();
        try {
            this.c(appMetadata);
            this.n().b(appMetadata.b, userAttributeParcel.b);
            this.n().c();
            this.f().y().a("User property removed", userAttributeParcel.b);
            return;
        }
        finally {
            this.n().v();
        }
    }

    protected boolean b() {
        boolean bl2 = true;
        this.a();
        this.x();
        if (this.w != null) return this.w;
        boolean bl3 = this.m().f("android.permission.INTERNET") && this.m().f("android.permission.ACCESS_NETWORK_STATE") && AppMeasurementReceiver.a(this.p()) && AppMeasurementService.a(this.p()) ? bl2 : false;
        this.w = bl3;
        if (this.w == false) return this.w;
        if (this.d().N()) return this.w;
        if (TextUtils.isEmpty((CharSequence)this.t().c())) {
            bl2 = false;
        }
        this.w = bl2;
        return this.w;
    }

    protected void c() {
        this.x();
        if (this.y() && (!this.g.E() || this.g.F())) {
            this.f().b().a("Scheduler shutting down before Scion.start() called");
            return;
        }
        this.n().y();
        if (!this.b()) {
            if (this.e().w()) {
                if (!this.m().f("android.permission.INTERNET")) {
                    this.f().b().a("App is missing INTERNET permission");
                }
                if (!this.m().f("android.permission.ACCESS_NETWORK_STATE")) {
                    this.f().b().a("App is missing ACCESS_NETWORK_STATE permission");
                }
                if (!AppMeasurementReceiver.a(this.p())) {
                    this.f().b().a("AppMeasurementReceiver not registered/enabled");
                }
                if (!AppMeasurementService.a(this.p())) {
                    this.f().b().a("AppMeasurementService not registered/enabled");
                }
                this.f().b().a("Uploading is not possible. App measurement disabled");
            }
        } else if (!(this.d().N() || this.y() || TextUtils.isEmpty((CharSequence)this.t().c()))) {
            this.l().c();
        }
        this.F();
    }

    public aj d() {
        return this.d;
    }

    public bn e() {
        this.a((ck)this.e);
        return this.e;
    }

    public bc f() {
        this.b(this.f);
        return this.f;
    }

    public bc g() {
        if (this.f == null) return null;
        if (!this.f.E()) return null;
        return this.f;
    }

    public bt h() {
        this.b(this.g);
        return this.g;
    }

    public u i() {
        this.b(this.h);
        return this.h;
    }

    public bs j() {
        this.b(this.i);
        return this.i;
    }

    bt k() {
        return this.g;
    }

    public d l() {
        this.b(this.q);
        return this.q;
    }

    public ag m() {
        this.a(this.k);
        return this.k;
    }

    public ak n() {
        this.b(this.l);
        return this.l;
    }

    public bf o() {
        this.b(this.m);
        return this.m;
    }

    public Context p() {
        return this.c;
    }

    public kf q() {
        return this.n;
    }

    public i r() {
        this.b(this.o);
        return this.o;
    }

    public aq s() {
        this.b(this.p);
        return this.p;
    }

    public ba t() {
        this.b(this.r);
        return this.r;
    }

    public bk u() {
        if (this.s != null) return this.s;
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    public ad v() {
        this.b(this.t);
        return this.t;
    }

    public ai w() {
        this.b(this.u);
        return this.u;
    }

    public void x() {
        this.h().f();
    }

    protected boolean y() {
        return false;
    }

    long z() {
        return (this.q().a() + this.e().c()) / 1000 / 60 / 60 / 24;
    }
}

