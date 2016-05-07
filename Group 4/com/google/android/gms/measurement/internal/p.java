/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.common.stats.b;
import com.google.android.gms.measurement.internal.ax;
import com.google.android.gms.measurement.internal.ay;
import com.google.android.gms.measurement.internal.bb;
import com.google.android.gms.measurement.internal.bc;
import com.google.android.gms.measurement.internal.be;
import com.google.android.gms.measurement.internal.bt;
import com.google.android.gms.measurement.internal.bx;
import com.google.android.gms.measurement.internal.i;
import com.google.android.gms.measurement.internal.q;
import com.google.android.gms.measurement.internal.r;
import com.google.android.gms.measurement.internal.s;
import com.google.android.gms.measurement.internal.t;

public class p
implements ServiceConnection,
com.google.android.gms.common.api.q,
com.google.android.gms.common.api.r {
    final /* synthetic */ i a;
    private volatile boolean b;
    private volatile bb c;

    protected p(i i2) {
        this.a = i2;
    }

    static /* synthetic */ boolean a(p p2, boolean bl2) {
        p2.b = bl2;
        return bl2;
    }

    public void a() {
        this.a.f();
        Context context = this.a.m();
        // MONITORENTER : this
        if (this.b) {
            this.a.s().z().a("Connection attempt already in progress");
            // MONITOREXIT : this
            return;
        }
        if (this.c != null) {
            this.a.s().z().a("Already awaiting connection attempt");
            // MONITOREXIT : this
            return;
        }
        this.c = new bb(context, Looper.getMainLooper(), com.google.android.gms.common.internal.t.a(context), this, this);
        this.a.s().z().a("Connecting to remote service");
        this.b = true;
        this.c.l();
        // MONITOREXIT : this
        return;
    }

    @Override
    public void a(int n2) {
        bf.b("MeasurementServiceConnection.onConnectionSuspended");
        this.a.s().y().a("Service connection suspended");
        this.a.r().a(new t(this));
    }

    public void a(Intent intent) {
        this.a.f();
        Context context = this.a.m();
        b b2 = b.a();
        // MONITORENTER : this
        if (this.b) {
            this.a.s().z().a("Connection attempt already in progress");
            // MONITOREXIT : this
            return;
        }
        this.b = true;
        b2.a(context, intent, i.a(this.a), 129);
        // MONITOREXIT : this
        return;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    @Override
    public void a(Bundle bundle) {
        bf.b("MeasurementServiceConnection.onConnected");
        // MONITORENTER : this
        try {
            ax ax2 = (ax)this.c.r();
            this.c = null;
            this.a.r().a(new s(this, ax2));
            // MONITOREXIT : this
            return;
        }
        catch (IllegalStateException var2_3) {
        }
        catch (DeadObjectException var4_4) {}
        this.c = null;
        this.b = false;
    }

    @Override
    public void a(ConnectionResult connectionResult) {
        bf.b("MeasurementServiceConnection.onConnectionFailed");
        bc bc2 = this.a.n.g();
        if (bc2 != null) {
            bc2.c().a("Service connection failed", connectionResult);
        }
        // MONITORENTER : this
        this.b = false;
        this.c = null;
        // MONITOREXIT : this
        return;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        ax ax2;
        block11 : {
            bf.b("MeasurementServiceConnection.onServiceConnected");
            // MONITORENTER : this
            if (iBinder == null) {
                this.b = false;
                this.a.s().b().a("Service connected with null binder");
                // MONITOREXIT : this
                return;
            }
            ax2 = null;
            try {
                String string = iBinder.getInterfaceDescriptor();
                boolean bl2 = "com.google.android.gms.measurement.internal.IMeasurementService".equals(string);
                ax2 = null;
                if (bl2) {
                    ax2 = ay.a(iBinder);
                    this.a.s().z().a("Bound to IMeasurementService interface");
                    break block11;
                }
                this.a.s().b().a("Got binder with a wrong descriptor", string);
                ax2 = null;
            }
            catch (RemoteException var4_6) {
                this.a.s().b().a("Service connect failed to get IMeasurementService");
            }
        }
        if (ax2 != null) {
            this.a.r().a(new q(this, ax2));
            return;
        }
        this.b = false;
        try {
            b.a().a(this.a.m(), i.a(this.a));
            // MONITOREXIT : this
            return;
        }
        catch (IllegalArgumentException var6_7) {
            return;
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        bf.b("MeasurementServiceConnection.onServiceDisconnected");
        this.a.s().y().a("Service disconnected");
        this.a.r().a(new r(this, componentName));
    }
}

