/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import com.google.android.gms.b.b;
import com.google.android.gms.b.di;
import com.google.android.gms.b.fk;
import com.google.android.gms.b.hy;
import com.google.android.gms.b.kt;
import com.google.android.gms.b.ku;
import com.google.android.gms.b.l;
import com.google.android.gms.b.lt;
import com.google.android.gms.b.me;
import com.google.android.gms.b.mq;
import com.google.android.gms.b.mz;
import java.io.InputStream;
import java.util.Comparator;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.impl.cookie.DateUtils;

public class mp
implements di {
    protected static final boolean a = me.b;
    private static int d = 3000;
    private static int e = 4096;
    protected final mz b;
    protected final mq c;

    public mp(mz mz2) {
        this(mz2, new mq(e));
    }

    public mp(mz mz2, mq mq2) {
        this.b = mz2;
        this.c = mq2;
    }

    protected static Map a(Header[] arrheader) {
        TreeMap<String, String> treeMap = new TreeMap<String, String>(String.CASE_INSENSITIVE_ORDER);
        int n2 = 0;
        while (n2 < arrheader.length) {
            treeMap.put(arrheader[n2].getName(), arrheader[n2].getValue());
            ++n2;
        }
        return treeMap;
    }

    private void a(long l2, hy hy2, byte[] arrby, StatusLine statusLine) {
        if (!a) {
            if (l2 <= (long)d) return;
        }
        Object[] arrobject = new Object[5];
        arrobject[0] = hy2;
        arrobject[1] = l2;
        Integer n2 = arrby != null ? Integer.valueOf(arrby.length) : "null";
        arrobject[2] = n2;
        arrobject[3] = statusLine.getStatusCode();
        arrobject[4] = hy2.s().b();
        me.b("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", arrobject);
    }

    private static void a(String string, hy hy2, lt lt2) {
        kt kt2 = hy2.s();
        int n2 = hy2.r();
        try {
            kt2.a(lt2);
        }
        catch (lt var5_6) {
            Object[] arrobject = new Object[]{string, n2};
            hy2.b(String.format("%s-timeout-giveup [timeout=%s]", arrobject));
            throw var5_6;
        }
        Object[] arrobject = new Object[]{string, n2};
        hy2.b(String.format("%s-retry [timeout=%s]", arrobject));
    }

    private void a(Map map, l l2) {
        if (l2 == null) {
            return;
        }
        if (l2.b != null) {
            map.put("If-None-Match", l2.b);
        }
        if (l2.d <= 0) return;
        map.put("If-Modified-Since", DateUtils.formatDate((Date)new Date(l2.d)));
    }

    private byte[] a(HttpEntity httpEntity) {
        b b2 = new b(this.c, (int)httpEntity.getContentLength());
        byte[] arrby = null;
        try {
            int n2;
            InputStream inputStream = httpEntity.getContent();
            arrby = null;
            if (inputStream == null) {
                throw new ku();
            }
            arrby = this.c.a(1024);
            while ((n2 = inputStream.read(arrby)) != -1) {
                b2.write(arrby, 0, n2);
            }
            byte[] arrby2 = b2.toByteArray();
            return arrby2;
        }
        finally {
            httpEntity.consumeContent();
            this.c.a(arrby);
            b2.close();
        }
    }

    /*
     * Exception decompiling
     */
    @Override
    public fk a(hy var1_1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 5[TRYBLOCK]
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
}

