/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.location.Location;
import android.os.IInterface;
import com.google.android.gms.common.api.internal.aq;
import com.google.android.gms.location.ActivityRecognitionResult;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.GestureRequest;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.internal.LocationRequestInternal;
import com.google.android.gms.location.internal.LocationRequestUpdateData;
import com.google.android.gms.location.internal.i;
import com.google.android.gms.location.internal.l;
import com.google.android.gms.location.internal.r;
import com.google.android.gms.location.w;
import java.util.List;

public interface o
extends IInterface {
    public Location a();

    public ActivityRecognitionResult a(String var1);

    public void a(long var1, boolean var3, PendingIntent var4);

    public void a(PendingIntent var1);

    public void a(PendingIntent var1, aq var2);

    public void a(PendingIntent var1, l var2, String var3);

    public void a(Location var1);

    public void a(Location var1, int var2);

    public void a(GeofencingRequest var1, PendingIntent var2, l var3);

    public void a(GestureRequest var1, PendingIntent var2, aq var3);

    public void a(LocationRequest var1, PendingIntent var2);

    public void a(LocationRequest var1, w var2);

    public void a(LocationRequest var1, w var2, String var3);

    public void a(LocationSettingsRequest var1, r var2, String var3);

    public void a(LocationRequestInternal var1, PendingIntent var2);

    public void a(LocationRequestInternal var1, w var2);

    public void a(LocationRequestUpdateData var1);

    public void a(i var1);

    public void a(l var1, String var2);

    public void a(w var1);

    public void a(List var1, PendingIntent var2, l var3, String var4);

    public void a(boolean var1);

    public void a(String[] var1, l var2, String var3);

    public Location b(String var1);

    public void b(PendingIntent var1);

    public void b(PendingIntent var1, aq var2);

    public LocationAvailability c(String var1);

    public void c(PendingIntent var1, aq var2);

    public void d(PendingIntent var1, aq var2);

    public void e(PendingIntent var1, aq var2);
}

