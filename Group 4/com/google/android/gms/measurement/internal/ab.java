/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.b.lf;
import com.google.android.gms.common.internal.bf;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

class ab {
    final int a;
    final boolean b;
    final String c;
    final List d;
    final String e;
    final boolean f;

    /*
     * Unable to fully structure code
     */
    public ab(lf var1_1) {
        super();
        bf.a(var1_1);
        if (var1_1.a != null && var1_1.a != 0) ** GOTO lbl6
        var3_2 = false;
        ** GOTO lbl14
lbl6: // 1 sources:
        if (var1_1.a != 6) ** GOTO lbl10
        if (var1_1.d != null && var1_1.d.length != 0) ** GOTO lbl-1000
        var3_2 = false;
        ** GOTO lbl14
lbl10: // 1 sources:
        if (var1_1.b == null) {
            var3_2 = false;
        } else lbl-1000: // 2 sources:
        {
            var3_2 = true;
        }
lbl14: // 4 sources:
        if (var3_2) {
            this.a = var1_1.a;
            var4_3 = var1_1.c;
            var5_4 = false;
            if (var4_3 != null) {
                var7_5 = var1_1.c;
                var5_4 = false;
                if (var7_5) {
                    var5_4 = true;
                }
            }
            this.b = var5_4;
            this.c = this.b != false || this.a == 1 || this.a == 6 ? var1_1.b : var1_1.b.toUpperCase(Locale.ENGLISH);
            var6_6 = var1_1.d == null ? null : this.a(var1_1.d, this.b);
            this.d = var6_6;
            this.e = this.a == 1 ? this.c : null;
        } else {
            this.a = 0;
            this.b = false;
            this.c = null;
            this.d = null;
            this.e = null;
        }
        this.f = var3_2;
    }

    private List a(String[] arrstring, boolean bl2) {
        if (bl2) {
            return Arrays.asList(arrstring);
        }
        List<String> list = new ArrayList<String>();
        int n2 = arrstring.length;
        int n3 = 0;
        while (n3 < n2) {
            list.add(arrstring[n3].toUpperCase(Locale.ENGLISH));
            ++n3;
        }
        return list;
    }

    /*
     * Exception decompiling
     */
    public Boolean a(String var1_1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.CannotPerformDecode: reachable test BLOCK was exited and re-entered.
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.Misc.getFarthestReachableInRange(Misc.java:143)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.SwitchReplacer.examineSwitchContiguity(SwitchReplacer.java:385)
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
}

