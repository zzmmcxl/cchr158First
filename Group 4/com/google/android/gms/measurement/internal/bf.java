/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.gms.b.kf;
import com.google.android.gms.measurement.internal.ag;
import com.google.android.gms.measurement.internal.ai;
import com.google.android.gms.measurement.internal.aj;
import com.google.android.gms.measurement.internal.ak;
import com.google.android.gms.measurement.internal.aq;
import com.google.android.gms.measurement.internal.ba;
import com.google.android.gms.measurement.internal.bc;
import com.google.android.gms.measurement.internal.bh;
import com.google.android.gms.measurement.internal.bj;
import com.google.android.gms.measurement.internal.bn;
import com.google.android.gms.measurement.internal.bs;
import com.google.android.gms.measurement.internal.bt;
import com.google.android.gms.measurement.internal.bx;
import com.google.android.gms.measurement.internal.cl;
import com.google.android.gms.measurement.internal.d;
import com.google.android.gms.measurement.internal.i;
import com.google.android.gms.measurement.internal.u;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

public class bf
extends cl {
    public bf(bx bx2) {
        super(bx2);
    }

    static /* synthetic */ byte[] a(bf bf2, HttpURLConnection httpURLConnection) {
        return bf2.a(httpURLConnection);
    }

    private byte[] a(HttpURLConnection httpURLConnection) {
        InputStream inputStream = null;
        try {
            int n2;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            inputStream = httpURLConnection.getInputStream();
            byte[] arrby = new byte[1024];
            while ((n2 = inputStream.read(arrby)) > 0) {
                byteArrayOutputStream.write(arrby, 0, n2);
            }
            byte[] arrby2 = byteArrayOutputStream.toByteArray();
            return arrby2;
        }
        finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    protected HttpURLConnection a(URL uRL) {
        URLConnection uRLConnection = uRL.openConnection();
        if (!(uRLConnection instanceof HttpURLConnection)) {
            throw new IOException("Failed to obtain HTTP connection");
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection)uRLConnection;
        httpURLConnection.setDefaultUseCaches(false);
        httpURLConnection.setConnectTimeout((int)this.u().H());
        httpURLConnection.setReadTimeout((int)this.u().I());
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setDoInput(true);
        return httpURLConnection;
    }

    @Override
    protected void a() {
    }

    public void a(String string, URL uRL, Map map, bh bh2) {
        this.f();
        this.G();
        com.google.android.gms.common.internal.bf.a(uRL);
        com.google.android.gms.common.internal.bf.a(bh2);
        this.r().b(new bj(this, string, uRL, null, map, bh2));
    }

    public void a(String string, URL uRL, byte[] arrby, Map map, bh bh2) {
        this.f();
        this.G();
        com.google.android.gms.common.internal.bf.a(uRL);
        com.google.android.gms.common.internal.bf.a(arrby);
        com.google.android.gms.common.internal.bf.a(bh2);
        this.r().b(new bj(this, string, uRL, arrby, map, bh2));
    }

    public boolean b() {
        NetworkInfo networkInfo;
        this.G();
        ConnectivityManager connectivityManager = (ConnectivityManager)this.m().getSystemService("connectivity");
        try {
            NetworkInfo networkInfo2;
            networkInfo = networkInfo2 = connectivityManager.getActiveNetworkInfo();
            if (networkInfo == null) return false;
        }
        catch (SecurityException var2_4) {
            return false;
        }
        if (!networkInfo.isConnected()) return false;
        return true;
    }
}

