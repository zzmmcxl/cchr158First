/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.os.Bundle;
import android.os.IInterface;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.a;
import com.google.android.gms.b.df;
import com.google.android.gms.b.dm;
import com.google.android.gms.b.dp;
import java.util.List;

public interface dc
extends IInterface {
    public com.google.android.gms.a.a a();

    public void a(com.google.android.gms.a.a var1, AdRequestParcel var2, String var3, a var4, String var5);

    public void a(com.google.android.gms.a.a var1, AdRequestParcel var2, String var3, df var4);

    public void a(com.google.android.gms.a.a var1, AdRequestParcel var2, String var3, String var4, df var5);

    public void a(com.google.android.gms.a.a var1, AdRequestParcel var2, String var3, String var4, df var5, NativeAdOptionsParcel var6, List var7);

    public void a(com.google.android.gms.a.a var1, AdSizeParcel var2, AdRequestParcel var3, String var4, df var5);

    public void a(com.google.android.gms.a.a var1, AdSizeParcel var2, AdRequestParcel var3, String var4, String var5, df var6);

    public void a(AdRequestParcel var1, String var2);

    public void a(AdRequestParcel var1, String var2, String var3);

    public void b();

    public void c();

    public void d();

    public void e();

    public void f();

    public boolean g();

    public dm h();

    public dp i();

    public Bundle j();

    public Bundle k();

    public Bundle l();
}

