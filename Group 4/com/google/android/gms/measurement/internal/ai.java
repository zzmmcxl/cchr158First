/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.measurement.internal;

import android.support.v4.g.a;
import android.text.TextUtils;
import com.google.android.gms.b.la;
import com.google.android.gms.b.lb;
import com.google.android.gms.b.lc;
import com.google.android.gms.b.ld;
import com.google.android.gms.b.le;
import com.google.android.gms.b.lf;
import com.google.android.gms.b.lm;
import com.google.android.gms.b.ln;
import com.google.android.gms.b.lo;
import com.google.android.gms.b.ls;
import com.google.android.gms.measurement.internal.ab;
import com.google.android.gms.measurement.internal.ak;
import com.google.android.gms.measurement.internal.bc;
import com.google.android.gms.measurement.internal.be;
import com.google.android.gms.measurement.internal.bm;
import com.google.android.gms.measurement.internal.bx;
import com.google.android.gms.measurement.internal.cl;
import java.util.HashSet;
import java.util.regex.Pattern;

class ai
extends cl {
    ai(bx bx2) {
        super(bx2);
    }

    private Boolean a(lb lb2, ln ln2, long l2) {
        if (lb2.e != null) {
            Boolean bl2 = new bm(lb2.e).a(l2);
            if (bl2 == null) {
                return null;
            }
            if (!bl2.booleanValue()) {
                return false;
            }
        }
        HashSet<String> hashSet = new HashSet<String>();
        for (lc lc2 : lb2.c) {
            if (TextUtils.isEmpty((CharSequence)lc2.d)) {
                this.s().c().a("null or empty param name in filter. event", ln2.b);
                return null;
            }
            hashSet.add(lc2.d);
        }
        a a2 = new a();
        for (lo lo2 : ln2.a) {
            if (!hashSet.contains(lo2.a)) continue;
            if (lo2.c != null) {
                a2.put(lo2.a, lo2.c);
                continue;
            }
            if (lo2.d != null) {
                a2.put(lo2.a, lo2.d);
                continue;
            }
            if (lo2.b == null) {
                this.s().c().a("Unknown value for param. event, param", ln2.b, lo2.a);
                return null;
            }
            a2.put(lo2.a, lo2.b);
        }
        lc[] arrlc = lb2.c;
        int n2 = arrlc.length;
        int n3 = 0;
        while (n3 < n2) {
            lc lc3 = arrlc[n3];
            String string = lc3.d;
            if (TextUtils.isEmpty((CharSequence)string)) {
                this.s().c().a("Event has empty param name. event", ln2.b);
                return null;
            }
            Object v2 = a2.get(string);
            if (v2 instanceof Long) {
                if (lc3.b == null) {
                    this.s().c().a("No number filter for long param. event, param", ln2.b, string);
                    return null;
                }
                Boolean bl3 = new bm(lc3.b).a((Long)v2);
                if (bl3 == null) {
                    return null;
                }
                if (!bl3.booleanValue()) {
                    return false;
                }
            } else if (v2 instanceof Float) {
                if (lc3.b == null) {
                    this.s().c().a("No number filter for float param. event, param", ln2.b, string);
                    return null;
                }
                Boolean bl4 = new bm(lc3.b).a(((Float)v2).floatValue());
                if (bl4 == null) {
                    return null;
                }
                if (!bl4.booleanValue()) {
                    return false;
                }
            } else if (v2 instanceof String) {
                if (lc3.a == null) {
                    this.s().c().a("No string filter for String param. event, param", ln2.b, string);
                    return null;
                }
                Boolean bl5 = new ab(lc3.a).a((String)v2);
                if (bl5 == null) {
                    return null;
                }
                if (!bl5.booleanValue()) {
                    return false;
                }
            } else {
                if (v2 == null) {
                    this.s().z().a("Missing param for filter. event, param", ln2.b, string);
                    return false;
                }
                this.s().c().a("Unknown param type. event, param", ln2.b, string);
                return null;
            }
            ++n3;
        }
        return true;
    }

    private Boolean a(le le2, ls ls2) {
        lc lc2 = le2.c;
        if (lc2 == null) {
            this.s().c().a("Missing property filter. property", ls2.b);
            return null;
        }
        if (ls2.d != null) {
            if (lc2.b != null) return new bm(lc2.b).a(ls2.d);
            this.s().c().a("No number filter for long property. property", ls2.b);
            return null;
        }
        if (ls2.e != null) {
            if (lc2.b != null) return new bm(lc2.b).a(ls2.e.floatValue());
            this.s().c().a("No number filter for float property. property", ls2.b);
            return null;
        }
        if (ls2.c == null) {
            this.s().c().a("User property has no value, property", ls2.b);
            return null;
        }
        if (lc2.a != null) return new ab(lc2.a).a(ls2.c);
        if (lc2.b == null) {
            this.s().c().a("No string or number filter defined. property", ls2.b);
            return null;
        }
        bm bm2 = new bm(lc2.b);
        if (!lc2.b.b.booleanValue()) {
            if (!this.a(ls2.c)) {
                this.s().c().a("Invalid user property value for Long number filter. property, value", ls2.b, ls2.c);
                return null;
            }
            try {
                return bm2.a(Long.parseLong(ls2.c));
            }
            catch (NumberFormatException var7_6) {
                this.s().c().a("User property value exceeded Long value range. property, value", ls2.b, ls2.c);
                return null;
            }
        }
        if (!this.b(ls2.c)) {
            this.s().c().a("Invalid user property value for Float number filter. property, value", ls2.b, ls2.c);
            return null;
        }
        try {
            float f2 = Float.parseFloat(ls2.c);
            if (!Float.isInfinite(f2)) {
                return bm2.a(f2);
            }
            this.s().c().a("User property value exceeded Float value range. property, value", ls2.b, ls2.c);
            return null;
        }
        catch (NumberFormatException var5_8) {
            this.s().c().a("User property value exceeded Float value range. property, value", ls2.b, ls2.c);
            return null;
        }
    }

    @Override
    protected void a() {
    }

    void a(String string, la[] arrla) {
        this.n().a(string, arrla);
    }

    boolean a(String string) {
        return Pattern.matches("[+-]?[0-9]+", string);
    }

    /*
     * Exception decompiling
     */
    lm[] a(String var1_1, ln[] var2_2, ls[] var3_3) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[UNCONDITIONALDOLOOP]], but top level block is 3[UNCONDITIONALDOLOOP]
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

    boolean b(String string) {
        return Pattern.matches("[+-]?(([0-9]+\\.?)|([0-9]*\\.[0-9]+))", string);
    }
}

