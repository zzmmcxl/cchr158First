/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.ads.b;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.ads.b.b;
import com.google.android.gms.ads.b.c;
import com.google.android.gms.b.h;
import com.google.android.gms.b.i;
import com.google.android.gms.common.internal.bf;
import java.io.IOException;

public class a {
    com.google.android.gms.common.h a;
    h b;
    boolean c;
    Object d = new Object();
    c e;
    final long f;
    private final Context g;

    public a(Context context, long l2) {
        bf.a((Object)context);
        this.g = context;
        this.c = false;
        this.f = l2;
    }

    static h a(Context context, com.google.android.gms.common.h h2) {
        try {
            return i.a(h2.a());
        }
        catch (InterruptedException var3_3) {
            throw new IOException("Interrupted exception");
        }
        catch (Throwable var2_4) {
            throw new IOException(var2_4);
        }
    }

    /*
     * Exception decompiling
     */
    static com.google.android.gms.common.h a(Context var0) {
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

    public static b b(Context context) {
        a a2 = new a(context, -1);
        try {
            a2.a(false);
            b b2 = a2.a();
            return b2;
        }
        finally {
            a2.b();
        }
    }

    public static void b(boolean bl2) {
    }

    /*
     * Enabled unnecessary exception pruning
     */
    private void c() {
        Object object = this.d;
        // MONITORENTER : object
        if (this.e != null) {
            this.e.a();
            try {
                this.e.join();
            }
            catch (InterruptedException var3_2) {}
        }
        if (this.f > 0) {
            this.e = new c(this, this.f);
        }
        // MONITOREXIT : object
    }

    /*
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    public b a() {
        bf.c("Calling this from your main thread can lead to deadlock");
        // MONITORENTER : this
        if (!this.c) {
            var7_1 = this.d;
            // MONITORENTER : var7_1
            if (this.e == null) throw new IOException("AdvertisingIdClient is not connected.");
            if (!this.e.b()) {
                throw new IOException("AdvertisingIdClient is not connected.");
            }
            // MONITOREXIT : var7_1
            try {
                this.a(false);
                ** if (this.c) goto lbl-1000
            }
            catch (Exception var9_2) {
                throw new IOException("AdvertisingIdClient cannot reconnect.", var9_2);
            }
lbl-1000: // 1 sources:
            {
                throw new IOException("AdvertisingIdClient cannot reconnect.");
            }
lbl-1000: // 1 sources:
            {
            }
        }
        bf.a(this.a);
        bf.a(this.b);
        try {
            var4_3 = new b(this.b.a(), this.b.a(true));
            // MONITOREXIT : this
        }
        catch (RemoteException var5_4) {
            Log.i((String)"AdvertisingIdClient", (String)"GMS remote exception ", (Throwable)var5_4);
            throw new IOException("Remote exception");
        }
        this.c();
        return var4_3;
    }

    protected void a(boolean bl2) {
        bf.c("Calling this from your main thread can lead to deadlock");
        // MONITORENTER : this
        if (this.c) {
            this.b();
        }
        this.a = a.a(this.g);
        this.b = a.a(this.g, this.a);
        this.c = true;
        if (bl2) {
            this.c();
        }
        // MONITOREXIT : this
        return;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public void b() {
        bf.c("Calling this from your main thread can lead to deadlock");
        // MONITORENTER : this
        if (this.g == null || this.a == null) {
            // MONITOREXIT : this
            return;
        }
        try {
            if (this.c) {
                com.google.android.gms.common.stats.b.a().a(this.g, this.a);
            }
        }
        catch (IllegalArgumentException var2_1) {
            Log.i((String)"AdvertisingIdClient", (String)"AdvertisingIdClient unbindService failed.", (Throwable)var2_1);
        }
        this.c = false;
        this.b = null;
        this.a = null;
        // MONITOREXIT : this
    }

    protected void finalize() {
        this.b();
        super.finalize();
    }
}

