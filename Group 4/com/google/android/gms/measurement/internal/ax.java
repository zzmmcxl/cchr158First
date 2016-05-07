/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.measurement.internal;

import android.os.IInterface;
import com.google.android.gms.measurement.internal.AppMetadata;
import com.google.android.gms.measurement.internal.EventParcel;
import com.google.android.gms.measurement.internal.UserAttributeParcel;
import java.util.List;

public interface ax
extends IInterface {
    public List a(AppMetadata var1, boolean var2);

    public void a(AppMetadata var1);

    public void a(EventParcel var1, AppMetadata var2);

    public void a(EventParcel var1, String var2, String var3);

    public void a(UserAttributeParcel var1, AppMetadata var2);

    public void b(AppMetadata var1);
}

