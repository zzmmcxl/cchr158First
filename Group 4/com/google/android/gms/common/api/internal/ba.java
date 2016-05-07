/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v4.app.aa;
import android.support.v4.app.ah;
import android.support.v4.app.at;
import android.support.v4.app.x;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.ap;
import com.google.android.gms.common.api.internal.bb;
import com.google.android.gms.common.api.n;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.common.j;
import com.google.android.gms.common.r;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class ba
extends x
implements DialogInterface.OnCancelListener {
    protected ap a;
    private boolean b;
    private boolean c;
    private int d = -1;
    private ConnectionResult e;
    private final Handler f = new Handler(Looper.getMainLooper());
    private final SparseArray g = new SparseArray();

    static /* synthetic */ int a(ba ba2, int n2) {
        ba2.d = n2;
        return n2;
    }

    static /* synthetic */ ConnectionResult a(ba ba2, ConnectionResult connectionResult) {
        ba2.e = connectionResult;
        return connectionResult;
    }

    /*
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    private static ba a() {
        var1_1 = var6 = Class.forName("com.google.android.gms.common.api.internal.SupportLifecycleFragmentImpl");
        if (var1_1 == null) return null;
        return (ba)var1_1.newInstance();
        catch (LinkageError var0_3) {}
        ** GOTO lbl-1000
        catch (RuntimeException var2_7) {}
        ** GOTO lbl-1000
        catch (InstantiationException var2_9) {
            ** GOTO lbl-1000
        }
        catch (ExceptionInInitializerError var2_10) {
            ** GOTO lbl-1000
        }
        catch (IllegalAccessException var2_11) {}
lbl-1000: // 4 sources:
        {
            if (Log.isLoggable((String)"GmsSupportLifecycleFrag", (int)3) == false) return null;
            Log.d((String)"GmsSupportLifecycleFrag", (String)"Unable to instantiate SupportLifecycleFragmentImpl class", (Throwable)var2_8);
        }
        return null;
        catch (SecurityException var0_5) {
            ** GOTO lbl-1000
        }
        catch (ClassNotFoundException var0_6) {}
lbl-1000: // 3 sources:
        {
            if (Log.isLoggable((String)"GmsSupportLifecycleFrag", (int)3) == false) return null;
            Log.d((String)"GmsSupportLifecycleFrag", (String)"Unable to find SupportLifecycleFragmentImpl class", (Throwable)var0_4);
            return null;
        }
    }

    public static ba a(aa aa2) {
        ba ba2;
        bf.b("Must be called from main thread of process");
        ah ah2 = aa2.f();
        try {
            ba2 = (ba)ah2.a("GmsSupportLifecycleFrag");
            if (ba2 == null) return null;
        }
        catch (ClassCastException var2_3) {
            throw new IllegalStateException("Fragment with tag GmsSupportLifecycleFrag is not a SupportLifecycleFragment", var2_3);
        }
        if (!ba2.l()) return ba2;
        return null;
    }

    private static String a(ConnectionResult connectionResult) {
        return connectionResult.e() + " (" + connectionResult.c() + ": " + r.a(connectionResult.c()) + ')';
    }

    static /* synthetic */ void a(ba ba2, int n2, ConnectionResult connectionResult) {
        ba2.c(n2, connectionResult);
    }

    static /* synthetic */ boolean a(ba ba2) {
        return ba2.b;
    }

    static /* synthetic */ boolean a(ba ba2, boolean bl2) {
        ba2.c = bl2;
        return bl2;
    }

    public static ba b(aa aa2) {
        ba ba2 = ba.a(aa2);
        ah ah2 = aa2.f();
        if (ba2 != null) return ba2;
        ba2 = ba.a();
        if (ba2 == null) {
            Log.w((String)"GmsSupportLifecycleFrag", (String)"Unable to find connection error message resources (Did you include play-services-base and the proper proguard rules?); error dialogs may be unavailable.");
            ba2 = new ba();
        }
        ah2.a().a(ba2, "GmsSupportLifecycleFrag").b();
        ah2.b();
        return ba2;
    }

    static /* synthetic */ boolean b(ba ba2) {
        return ba2.c;
    }

    static /* synthetic */ Handler c(ba ba2) {
        return ba2.f;
    }

    private void c(int n2, ConnectionResult connectionResult) {
        Log.w((String)"GmsSupportLifecycleFrag", (String)"Unresolved error while connecting client. Stopping auto-manage.");
        bb bb2 = (bb)this.g.get(n2);
        if (bb2 != null) {
            this.a(n2);
            com.google.android.gms.common.api.r r2 = bb2.c;
            if (r2 != null) {
                r2.a(connectionResult);
            }
        }
        this.L();
    }

    protected j K() {
        return j.b();
    }

    protected void L() {
        this.c = false;
        this.d = -1;
        this.e = null;
        if (this.a != null) {
            this.a.b();
            this.a = null;
        }
        int n2 = 0;
        while (n2 < this.g.size()) {
            ((bb)this.g.valueAt((int)n2)).b.e();
            ++n2;
        }
    }

    public void a(int n2) {
        bb bb2 = (bb)this.g.get(n2);
        this.g.remove(n2);
        if (bb2 == null) return;
        bb2.a();
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public void a(int var1_1, int var2_2, Intent var3_3) {
        var4_4 = true;
        switch (var1_1) {
            case 2: {
                if (this.K().a((Context)this.g()) != 0) break;
                ** GOTO lbl11
            }
            case 1: {
                if (var2_2 == -1) ** GOTO lbl11
                if (var2_2 != 0) break;
                this.e = new ConnectionResult(13, null);
            }
        }
        var4_4 = false;
lbl11: // 3 sources:
        if (var4_4) {
            this.L();
            return;
        }
        this.c(this.d, this.e);
    }

    protected void a(int n2, ConnectionResult connectionResult) {
        Log.w((String)"GmsSupportLifecycleFrag", (String)("Failed to connect due to user resolvable error " + ba.a(connectionResult)));
        this.c(n2, connectionResult);
    }

    public void a(int n2, n n3, com.google.android.gms.common.api.r r2) {
        bf.a(n3, (Object)"GoogleApiClient instance cannot be null");
        boolean bl2 = this.g.indexOfKey(n2) < 0;
        bf.a(bl2, (Object)("Already managing a GoogleApiClient with id " + n2));
        bb bb2 = new bb(this, n2, n3, r2);
        this.g.put(n2, (Object)bb2);
        if (!this.b) return;
        if (this.c) return;
        n3.e();
    }

    @Override
    public void a(Bundle bundle) {
        super.a(bundle);
        if (bundle == null) return;
        this.c = bundle.getBoolean("resolving_error", false);
        this.d = bundle.getInt("failed_client_id", -1);
        if (this.d < 0) return;
        this.e = new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent)bundle.getParcelable("failed_resolution"));
    }

    @Override
    public void a(String string, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] arrstring) {
        super.a(string, fileDescriptor, printWriter, arrstring);
        int n2 = 0;
        while (n2 < this.g.size()) {
            ((bb)this.g.valueAt(n2)).a(string, fileDescriptor, printWriter, arrstring);
            ++n2;
        }
    }

    protected void b(int n2, ConnectionResult connectionResult) {
        Log.w((String)"GmsSupportLifecycleFrag", (String)"Unable to connect, GooglePlayServices is updating.");
        this.c(n2, connectionResult);
    }

    @Override
    public void c() {
        super.c();
        this.b = true;
        if (this.c) return;
        int n2 = 0;
        while (n2 < this.g.size()) {
            ((bb)this.g.valueAt((int)n2)).b.e();
            ++n2;
        }
    }

    @Override
    public void d() {
        super.d();
        this.b = false;
        int n2 = 0;
        while (n2 < this.g.size()) {
            ((bb)this.g.valueAt((int)n2)).b.g();
            ++n2;
        }
    }

    @Override
    public void e(Bundle bundle) {
        super.e(bundle);
        bundle.putBoolean("resolving_error", this.c);
        if (this.d < 0) return;
        bundle.putInt("failed_client_id", this.d);
        bundle.putInt("failed_status", this.e.c());
        bundle.putParcelable("failed_resolution", (Parcelable)this.e.d());
    }

    public void onCancel(DialogInterface dialogInterface) {
        this.c(this.d, new ConnectionResult(13, null));
    }
}

