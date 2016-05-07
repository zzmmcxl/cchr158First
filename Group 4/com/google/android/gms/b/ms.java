/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.os.SystemClock;
import com.google.android.gms.b.k;
import com.google.android.gms.b.l;
import com.google.android.gms.b.me;
import com.google.android.gms.b.mu;
import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class ms
implements k {
    private final Map a = new LinkedHashMap(16, 0.75f, true);
    private long b = 0;
    private final File c;
    private final int d;

    public ms(File file) {
        this(file, 5242880);
    }

    public ms(File file, int n2) {
        this.c = file;
        this.d = n2;
    }

    static int a(InputStream inputStream) {
        return 0 | ms.e(inputStream) << 0 | ms.e(inputStream) << 8 | ms.e(inputStream) << 16 | ms.e(inputStream) << 24;
    }

    private void a(int n2) {
        long l2;
        long l3;
        int n3;
        block6 : {
            if (this.b + (long)n2 < (long)this.d) {
                return;
            }
            if (me.b) {
                me.a("Pruning old cache entries.", new Object[0]);
            }
            l3 = this.b;
            l2 = SystemClock.elapsedRealtime();
            Iterator iterator = this.a.entrySet().iterator();
            int n4 = 0;
            while (iterator.hasNext()) {
                mu mu2 = (mu)iterator.next().getValue();
                if (this.c(mu2.b).delete()) {
                    this.b -= mu2.a;
                } else {
                    Object[] arrobject = new Object[]{mu2.b, this.d(mu2.b)};
                    me.b("Could not delete cache entry for key=%s, filename=%s", arrobject);
                }
                iterator.remove();
                n3 = n4 + 1;
                if ((float)(this.b + (long)n2) >= 0.9f * (float)this.d) {
                    n4 = n3;
                    continue;
                }
                break block6;
            }
            n3 = n4;
        }
        if (!me.b) return;
        Object[] arrobject = new Object[]{n3, this.b - l3, SystemClock.elapsedRealtime() - l2};
        me.a("pruned %d files, %d bytes, %d ms", arrobject);
    }

    static void a(OutputStream outputStream, int n2) {
        outputStream.write(255 & n2 >> 0);
        outputStream.write(255 & n2 >> 8);
        outputStream.write(255 & n2 >> 16);
        outputStream.write(255 & n2 >> 24);
    }

    static void a(OutputStream outputStream, long l2) {
        outputStream.write((byte)(l2 >>> 0));
        outputStream.write((byte)(l2 >>> 8));
        outputStream.write((byte)(l2 >>> 16));
        outputStream.write((byte)(l2 >>> 24));
        outputStream.write((byte)(l2 >>> 32));
        outputStream.write((byte)(l2 >>> 40));
        outputStream.write((byte)(l2 >>> 48));
        outputStream.write((byte)(l2 >>> 56));
    }

    static void a(OutputStream outputStream, String string) {
        byte[] arrby = string.getBytes("UTF-8");
        ms.a(outputStream, (long)arrby.length);
        outputStream.write(arrby, 0, arrby.length);
    }

    private void a(String string, mu mu2) {
        if (!this.a.containsKey(string)) {
            this.b += mu2.a;
        } else {
            mu mu3 = (mu)this.a.get(string);
            this.b += mu2.a - mu3.a;
        }
        this.a.put(string, mu2);
    }

    static void a(Map map, OutputStream outputStream) {
        if (map == null) {
            ms.a(outputStream, 0);
            return;
        }
        ms.a(outputStream, map.size());
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            ms.a(outputStream, (String)entry.getKey());
            ms.a(outputStream, (String)entry.getValue());
        }
    }

    private static byte[] a(InputStream inputStream, int n2) {
        int n3;
        int n4;
        byte[] arrby = new byte[n2];
        for (n4 = 0; n4 < n2 && (n3 = inputStream.read(arrby, n4, n2 - n4)) != -1; n4 += n3) {
        }
        if (n4 == n2) return arrby;
        throw new IOException("Expected " + n2 + " bytes, read " + n4 + " bytes");
    }

    static long b(InputStream inputStream) {
        return 0 | (255 & (long)ms.e(inputStream)) << 0 | (255 & (long)ms.e(inputStream)) << 8 | (255 & (long)ms.e(inputStream)) << 16 | (255 & (long)ms.e(inputStream)) << 24 | (255 & (long)ms.e(inputStream)) << 32 | (255 & (long)ms.e(inputStream)) << 40 | (255 & (long)ms.e(inputStream)) << 48 | (255 & (long)ms.e(inputStream)) << 56;
    }

    static String c(InputStream inputStream) {
        return new String(ms.a(inputStream, (int)ms.b(inputStream)), "UTF-8");
    }

    private String d(String string) {
        int n2 = string.length() / 2;
        String string2 = String.valueOf(string.substring(0, n2).hashCode());
        return string2 + String.valueOf(string.substring(n2).hashCode());
    }

    static Map d(InputStream inputStream) {
        int n2 = ms.a(inputStream);
        Map<String, String> map = n2 == 0 ? Collections.emptyMap() : new HashMap(n2);
        int n3 = 0;
        while (n3 < n2) {
            map.put(ms.c(inputStream).intern(), ms.c(inputStream).intern());
            ++n3;
        }
        return map;
    }

    private static int e(InputStream inputStream) {
        int n2 = inputStream.read();
        if (n2 != -1) return n2;
        throw new EOFException();
    }

    private void e(String string) {
        mu mu2 = (mu)this.a.get(string);
        if (mu2 == null) return;
        this.b -= mu2.a;
        this.a.remove(string);
    }

    /*
     * Exception decompiling
     */
    @Override
    public l a(String var1_1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [11[CATCHBLOCK]], but top level block is 17[UNCONDITIONALDOLOOP]
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

    /*
     * Exception decompiling
     */
    @Override
    public void a() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [9[CATCHBLOCK], 16[UNCONDITIONALDOLOOP]], but top level block is 18[UNCONDITIONALDOLOOP]
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

    @Override
    public void a(String string, l l2) {
        // MONITORENTER : this
        this.a(l2.a.length);
        File file = this.c(string);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            mu mu2 = new mu(string, l2);
            if (!mu2.a(fileOutputStream)) {
                fileOutputStream.close();
                Object[] arrobject = new Object[]{file.getAbsolutePath()};
                me.b("Failed to write header for %s", arrobject);
                throw new IOException();
            }
            fileOutputStream.write(l2.a);
            fileOutputStream.close();
            this.a(string, mu2);
            return;
        }
        catch (IOException var7_7) {
            if (!file.delete()) {
                Object[] arrobject = new Object[]{file.getAbsolutePath()};
                me.b("Could not clean up file %s", arrobject);
            }
            // MONITOREXIT : this
            return;
        }
    }

    public void b(String string) {
        // MONITORENTER : this
        boolean bl2 = this.c(string).delete();
        this.e(string);
        if (!bl2) {
            Object[] arrobject = new Object[]{string, this.d(string)};
            me.b("Could not delete cache entry for key=%s, filename=%s", arrobject);
        }
        // MONITOREXIT : this
        return;
    }

    public File c(String string) {
        return new File(this.c, this.d(string));
    }
}

