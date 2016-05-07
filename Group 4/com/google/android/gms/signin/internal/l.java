/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.internal.ac;
import com.google.android.gms.b.lz;
import com.google.android.gms.b.ma;
import com.google.android.gms.common.api.q;
import com.google.android.gms.common.api.r;
import com.google.android.gms.common.api.s;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.ae;
import com.google.android.gms.common.internal.ap;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.common.internal.t;
import com.google.android.gms.common.internal.y;
import com.google.android.gms.signin.internal.SignInRequest;
import com.google.android.gms.signin.internal.SignInResponse;
import com.google.android.gms.signin.internal.d;
import com.google.android.gms.signin.internal.g;
import com.google.android.gms.signin.internal.h;

public class l
extends y
implements lz {
    private final boolean d;
    private final t e;
    private final Bundle f;
    private Integer g;

    public l(Context context, Looper looper, boolean bl2, t t2, Bundle bundle, q q2, r r2) {
        super(context, looper, 44, t2, q2, r2);
        this.d = bl2;
        this.e = t2;
        this.f = bundle;
        this.g = t2.j();
    }

    public l(Context context, Looper looper, boolean bl2, t t2, ma ma2, q q2, r r2) {
        this(context, looper, bl2, t2, l.a(t2), q2, r2);
    }

    public static Bundle a(t t2) {
        ma ma2 = t2.i();
        Integer n2 = t2.j();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", (Parcelable)t2.b());
        if (n2 != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", n2.intValue());
        }
        if (ma2 == null) return bundle;
        bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", ma2.a());
        bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", ma2.b());
        bundle.putString("com.google.android.gms.signin.internal.serverClientId", ma2.c());
        bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
        bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", ma2.d());
        bundle.putString("com.google.android.gms.signin.internal.hostedDomain", ma2.e());
        bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", ma2.f());
        return bundle;
    }

    private ResolveAccountRequest t() {
        Account account = this.e.c();
        boolean bl2 = "<<default account>>".equals(account.name);
        GoogleSignInAccount googleSignInAccount = null;
        if (!bl2) return new ResolveAccountRequest(account, this.g, googleSignInAccount);
        googleSignInAccount = ac.a(this.n()).a();
        return new ResolveAccountRequest(account, this.g, googleSignInAccount);
    }

    protected g a(IBinder iBinder) {
        return h.a(iBinder);
    }

    @Override
    protected String a() {
        return "com.google.android.gms.signin.service.START";
    }

    @Override
    public void a(ap ap2, boolean bl2) {
        try {
            ((g)this.r()).a(ap2, this.g, bl2);
            return;
        }
        catch (RemoteException var3_3) {
            Log.w((String)"SignInClientImpl", (String)"Remote service probably died when saveDefaultAccount is called");
            return;
        }
    }

    @Override
    public void a(d d2) {
        bf.a(d2, (Object)"Expecting a valid ISignInCallbacks");
        try {
            ResolveAccountRequest resolveAccountRequest = this.t();
            ((g)this.r()).a(new SignInRequest(resolveAccountRequest), d2);
            return;
        }
        catch (RemoteException var3_3) {
            Log.w((String)"SignInClientImpl", (String)"Remote service probably died when signIn is called");
            try {
                d2.a(new SignInResponse(8));
                return;
            }
            catch (RemoteException var5_4) {
                Log.wtf((String)"SignInClientImpl", (String)"ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", (Throwable)var3_3);
                return;
            }
        }
    }

    @Override
    protected /* synthetic */ IInterface b(IBinder iBinder) {
        return this.a(iBinder);
    }

    @Override
    protected String b() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    @Override
    protected Bundle c() {
        String string = this.e.g();
        if (this.n().getPackageName().equals(string)) return this.f;
        this.f.putString("com.google.android.gms.signin.internal.realClientPackageName", this.e.g());
        return this.f;
    }

    @Override
    public void f() {
        try {
            ((g)this.r()).a(this.g);
            return;
        }
        catch (RemoteException var1_1) {
            Log.w((String)"SignInClientImpl", (String)"Remote service probably died when clearAccountFromSessionStore is called");
            return;
        }
    }

    @Override
    public boolean i() {
        return this.d;
    }

    @Override
    public void k() {
        this.a(new ae(this));
    }
}

