/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Build;
import com.google.android.gms.b.kf;
import com.google.android.gms.measurement.internal.ag;
import com.google.android.gms.measurement.internal.ai;
import com.google.android.gms.measurement.internal.aj;
import com.google.android.gms.measurement.internal.ak;
import com.google.android.gms.measurement.internal.ba;
import com.google.android.gms.measurement.internal.bc;
import com.google.android.gms.measurement.internal.bn;
import com.google.android.gms.measurement.internal.bs;
import com.google.android.gms.measurement.internal.bt;
import com.google.android.gms.measurement.internal.bx;
import com.google.android.gms.measurement.internal.cl;
import com.google.android.gms.measurement.internal.d;
import com.google.android.gms.measurement.internal.i;
import com.google.android.gms.measurement.internal.u;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class aq
extends cl {
    private long a;
    private String b;

    aq(bx bx2) {
        super(bx2);
    }

    @Override
    protected void a() {
        Calendar calendar = Calendar.getInstance();
        this.a = TimeUnit.MINUTES.convert(calendar.get(15) + calendar.get(16), TimeUnit.MILLISECONDS);
        Locale locale = Locale.getDefault();
        this.b = locale.getLanguage().toLowerCase(Locale.ENGLISH) + "-" + locale.getCountry().toLowerCase(Locale.ENGLISH);
    }

    public String b() {
        this.G();
        return Build.MODEL;
    }

    public String c() {
        this.G();
        return Build.VERSION.RELEASE;
    }

    public long v() {
        this.G();
        return this.a;
    }

    public String w() {
        this.G();
        return this.b;
    }
}

