/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.g;
import com.google.android.gms.b.ef;
import com.google.android.gms.b.eg;
import com.google.android.gms.b.fi;
import com.google.android.gms.b.fp;
import com.google.android.gms.b.hb;
import com.google.android.gms.b.kg;
import java.util.Map;
import java.util.Set;

@fi
public class dv
extends ef {
    static final Set a = kg.a("top-left", "top-right", "top-center", "center", "bottom-left", "bottom-right", "bottom-center");
    private String b = "top-right";
    private boolean c = true;
    private int d = 0;
    private int e = 0;
    private int f = -1;
    private int g = 0;
    private int h = 0;
    private int i = -1;
    private final Object j = new Object();
    private final hb k;
    private final Activity l;
    private AdSizeParcel m;
    private ImageView n;
    private LinearLayout o;
    private eg p;
    private PopupWindow q;
    private RelativeLayout r;
    private ViewGroup s;

    public dv(hb hb2, eg eg2) {
        super(hb2, "resize");
        this.k = hb2;
        this.l = hb2.e();
        this.p = eg2;
    }

    private void b(Map map) {
        String string;
        if (!TextUtils.isEmpty((CharSequence)((CharSequence)map.get("width")))) {
            this.i = g.c().a((String)map.get("width"));
        }
        if (!TextUtils.isEmpty((CharSequence)((CharSequence)map.get("height")))) {
            this.f = g.c().a((String)map.get("height"));
        }
        if (!TextUtils.isEmpty((CharSequence)((CharSequence)map.get("offsetX")))) {
            this.g = g.c().a((String)map.get("offsetX"));
        }
        if (!TextUtils.isEmpty((CharSequence)((CharSequence)map.get("offsetY")))) {
            this.h = g.c().a((String)map.get("offsetY"));
        }
        if (!TextUtils.isEmpty((CharSequence)((CharSequence)map.get("allowOffscreen")))) {
            this.c = Boolean.parseBoolean((String)map.get("allowOffscreen"));
        }
        if (TextUtils.isEmpty((CharSequence)(string = (String)map.get("customClosePosition")))) return;
        this.b = string;
    }

    private int[] d() {
        if (!this.c()) {
            return null;
        }
        if (this.c) {
            int[] arrn = new int[]{this.d + this.g, this.e + this.h};
            return arrn;
        }
        int[] arrn = g.c().b(this.l);
        int[] arrn2 = g.c().d(this.l);
        int n2 = arrn[0];
        int n3 = this.d + this.g;
        int n4 = this.e + this.h;
        if (n3 < 0) {
            n3 = 0;
        } else if (n3 + this.i > n2) {
            n3 = n2 - this.i;
        }
        if (n4 < arrn2[0]) {
            n4 = arrn2[0];
            return new int[]{n3, n4};
        } else {
            if (n4 + this.f <= arrn2[1]) return new int[]{n3, n4};
            n4 = arrn2[1] - this.f;
        }
        return new int[]{n3, n4};
    }

    void a(int n2, int n3) {
        if (this.p == null) return;
        this.p.a(n2, n3, this.i, this.f);
    }

    /*
     * Exception decompiling
     */
    public void a(Map var1_1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: First case is not immediately after switch.
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.SwitchReplacer.examineSwitchContiguity(SwitchReplacer.java:366)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.SwitchReplacer.replaceRawSwitches(SwitchReplacer.java:65)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:425)
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

    public void a(boolean bl2) {
        Object object = this.j;
        // MONITORENTER : object
        if (this.q != null) {
            this.q.dismiss();
            this.r.removeView(this.k.b());
            if (this.s != null) {
                this.s.removeView((View)this.n);
                this.s.addView(this.k.b());
                this.k.a(this.m);
            }
            if (bl2) {
                this.d("default");
                if (this.p != null) {
                    this.p.a();
                }
            }
            this.q = null;
            this.r = null;
            this.s = null;
            this.o = null;
        }
        // MONITOREXIT : object
        return;
    }

    boolean a() {
        if (this.i <= -1) return false;
        if (this.f <= -1) return false;
        return true;
    }

    void b(int n2, int n3) {
        this.a(n2, n3 - g.c().d(this.l)[0], this.i, this.f);
    }

    public boolean b() {
        Object object = this.j;
        // MONITORENTER : object
        if (this.q == null) return false;
        boolean bl2 = true;
        // MONITOREXIT : object
        return bl2;
    }

    public void c(int n2, int n3) {
        this.d = n2;
        this.e = n3;
    }

    /*
     * Unable to fully structure code
     */
    boolean c() {
        var1_1 = g.c().b(this.l);
        var2_2 = g.c().d(this.l);
        var3_3 = var1_1[0];
        var4_4 = var1_1[1];
        if (this.i < 50 || this.i > var3_3) {
            fp.d("Width is too small or too large.");
            return false;
        }
        if (this.f < 50 || this.f > var4_4) {
            fp.d("Height is too small or too large.");
            return false;
        }
        if (this.f == var4_4 && this.i == var3_3) {
            fp.d("Cannot resize to a full-screen ad.");
            return false;
        }
        if (this.c == false) return true;
        var5_5 = this.b;
        var6_6 = -1;
        switch (var5_5.hashCode()) {
            case -1012429441: {
                if (var5_5.equals("top-left")) {
                    var6_6 = 0;
                    ** break;
                }
                ** GOTO lbl41
            }
            case 1755462605: {
                if (var5_5.equals("top-center")) {
                    var6_6 = 1;
                    ** break;
                }
                ** GOTO lbl41
            }
            case -1364013995: {
                if (var5_5.equals("center")) {
                    var6_6 = 2;
                    ** break;
                }
                ** GOTO lbl41
            }
            case -655373719: {
                if (var5_5.equals("bottom-left")) {
                    var6_6 = 3;
                    ** break;
                }
                ** GOTO lbl41
            }
            case 1288627767: {
                if (var5_5.equals("bottom-center")) {
                    var6_6 = 4;
                }
            }
lbl41: // 12 sources:
            default: {
                ** GOTO lbl46
            }
            case 1163912186: 
        }
        if (var5_5.equals("bottom-right")) {
            var6_6 = 5;
        }
lbl46: // 4 sources:
        switch (var6_6) {
            default: {
                var7_7 = -50 + (this.d + this.g + this.i);
                var8_8 = this.e + this.h;
                break;
            }
            case 0: {
                var7_7 = this.d + this.g;
                var8_8 = this.e + this.h;
                break;
            }
            case 1: {
                var7_7 = -25 + (this.d + this.g + this.i / 2);
                var8_8 = this.e + this.h;
                break;
            }
            case 2: {
                var7_7 = -25 + (this.d + this.g + this.i / 2);
                var8_8 = -25 + (this.e + this.h + this.f / 2);
                break;
            }
            case 3: {
                var7_7 = this.d + this.g;
                var8_8 = -50 + (this.e + this.h + this.f);
                break;
            }
            case 4: {
                var7_7 = -25 + (this.d + this.g + this.i / 2);
                var8_8 = -50 + (this.e + this.h + this.f);
                break;
            }
            case 5: {
                var7_7 = -50 + (this.d + this.g + this.i);
                var8_8 = -50 + (this.e + this.h + this.f);
            }
        }
        if (var7_7 < 0) return false;
        if (var7_7 + 50 > var3_3) return false;
        if (var8_8 < var2_2[0]) return false;
        if (var8_8 + 50 > var2_2[1]) return false;
        return true;
    }
}

