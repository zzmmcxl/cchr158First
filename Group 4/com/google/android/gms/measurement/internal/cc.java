/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Binder;
import android.os.Process;
import android.text.TextUtils;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.common.r;
import com.google.android.gms.measurement.internal.AppMetadata;
import com.google.android.gms.measurement.internal.EventParcel;
import com.google.android.gms.measurement.internal.UserAttributeParcel;
import com.google.android.gms.measurement.internal.af;
import com.google.android.gms.measurement.internal.ag;
import com.google.android.gms.measurement.internal.ay;
import com.google.android.gms.measurement.internal.bc;
import com.google.android.gms.measurement.internal.be;
import com.google.android.gms.measurement.internal.bn;
import com.google.android.gms.measurement.internal.br;
import com.google.android.gms.measurement.internal.bt;
import com.google.android.gms.measurement.internal.bx;
import com.google.android.gms.measurement.internal.cd;
import com.google.android.gms.measurement.internal.ce;
import com.google.android.gms.measurement.internal.cf;
import com.google.android.gms.measurement.internal.cg;
import com.google.android.gms.measurement.internal.ch;
import com.google.android.gms.measurement.internal.ci;
import com.google.android.gms.measurement.internal.cj;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class cc
extends ay {
    private final bx a;
    private final boolean b;

    public cc(bx bx2) {
        bf.a(bx2);
        this.a = bx2;
        this.b = false;
    }

    public cc(bx bx2, boolean bl2) {
        bf.a(bx2);
        this.a = bx2;
        this.b = bl2;
    }

    static /* synthetic */ bx a(cc cc2) {
        return cc2.a;
    }

    private void b(String string) {
        if (TextUtils.isEmpty((CharSequence)string)) {
            this.a.f().b().a("Measurement Service called without app package");
            throw new SecurityException("Measurement Service called without app package");
        }
        try {
            this.c(string);
            return;
        }
        catch (SecurityException var2_2) {
            this.a.f().b().a("Measurement Service called with invalid calling package", string);
            throw var2_2;
        }
    }

    private void c(String string) {
        int n2 = this.b ? Process.myUid() : Binder.getCallingUid();
        if (r.a(this.a.p(), n2, string)) {
            return;
        }
        if (!r.b(this.a.p(), n2)) throw new SecurityException(String.format("Unknown calling package name '%s'.", string));
        if (!this.a.y()) return;
        throw new SecurityException(String.format("Unknown calling package name '%s'.", string));
    }

    /*
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    @Override
    public List a(AppMetadata var1_1, boolean var2_2) {
        bf.a(var1_1);
        this.b(var1_1.b);
        var4_3 = this.a.h().a(new ci(this, var1_1));
        try {
            var6_4 = (List)var4_3.get();
            var7_5 = new ArrayList<UserAttributeParcel>(var6_4.size());
            var8_6 = var6_4.iterator();
            while (var8_6.hasNext() != false) {
                var9_7 = (af)var8_6.next();
                if (!var2_2 && ag.g(var9_7.b)) continue;
                var7_5.add(new UserAttributeParcel(var9_7));
            }
            return var7_5;
        }
        catch (InterruptedException var5_8) {}
        ** GOTO lbl-1000
        catch (ExecutionException var5_10) {}
lbl-1000: // 2 sources:
        {
            this.a.f().b().a("Failed to get user attributes", var5_9);
            return null;
        }
    }

    @Override
    public void a(AppMetadata appMetadata) {
        bf.a(appMetadata);
        this.b(appMetadata.b);
        this.a.h().a(new cj(this, appMetadata));
    }

    @Override
    public void a(EventParcel eventParcel, AppMetadata appMetadata) {
        bf.a(eventParcel);
        bf.a(appMetadata);
        this.b(appMetadata.b);
        this.a.h().a(new ce(this, appMetadata, eventParcel));
    }

    @Override
    public void a(EventParcel eventParcel, String string, String string2) {
        bf.a(eventParcel);
        bf.a(string);
        this.b(string);
        this.a.h().a(new cf(this, string2, eventParcel, string));
    }

    @Override
    public void a(UserAttributeParcel userAttributeParcel, AppMetadata appMetadata) {
        bf.a(userAttributeParcel);
        bf.a(appMetadata);
        this.b(appMetadata.b);
        if (userAttributeParcel.a() == null) {
            this.a.h().a(new cg(this, appMetadata, userAttributeParcel));
            return;
        }
        this.a.h().a(new ch(this, appMetadata, userAttributeParcel));
    }

    /*
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    void a(String var1_1) {
        if (TextUtils.isEmpty((CharSequence)var1_1) != false) return;
        var2_2 = var1_1.split(":", 2);
        if (var2_2.length != 2) return;
        try {
            var4_3 = Long.valueOf(var2_2[0]);
            ** if (var4_3 <= 0) goto lbl-1000
        }
        catch (NumberFormatException var3_4) {
            this.a.f().c().a("Combining sample with a non-number weight", var2_2[0]);
            return;
        }
lbl-1000: // 1 sources:
        {
            this.a.e().b.a(var2_2[1], var4_3);
            return;
        }
lbl-1000: // 1 sources:
        {
        }
        this.a.f().c().a("Combining sample with a non-positive weight", var4_3);
    }

    @Override
    public void b(AppMetadata appMetadata) {
        bf.a(appMetadata);
        this.b(appMetadata.b);
        this.a.h().a(new cd(this, appMetadata));
    }
}

