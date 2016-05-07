/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.google.android.gms.b.kf;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.measurement.e;
import com.google.android.gms.measurement.internal.AppMetadata;
import com.google.android.gms.measurement.internal.ag;
import com.google.android.gms.measurement.internal.ai;
import com.google.android.gms.measurement.internal.aj;
import com.google.android.gms.measurement.internal.ak;
import com.google.android.gms.measurement.internal.aq;
import com.google.android.gms.measurement.internal.bc;
import com.google.android.gms.measurement.internal.be;
import com.google.android.gms.measurement.internal.bn;
import com.google.android.gms.measurement.internal.bs;
import com.google.android.gms.measurement.internal.bt;
import com.google.android.gms.measurement.internal.bx;
import com.google.android.gms.measurement.internal.cl;
import com.google.android.gms.measurement.internal.d;
import com.google.android.gms.measurement.internal.i;
import com.google.android.gms.measurement.internal.u;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import javax.security.auth.x500.X500Principal;

public class ba
extends cl {
    private static final X500Principal a = new X500Principal("CN=Android Debug,O=Android,C=US");
    private String b;
    private String c;
    private String d;
    private String e;
    private long f;
    private String g;

    ba(bx bx2) {
        super(bx2);
    }

    AppMetadata a(String string) {
        boolean bl2;
        String string2 = this.b();
        String string3 = this.c();
        String string4 = this.v();
        String string5 = this.w();
        long l2 = this.x();
        long l3 = this.y();
        boolean bl3 = this.t().w();
        if (!this.t().m) {
            bl2 = true;
            return new AppMetadata(string2, string3, string4, string5, l2, l3, string, bl3, bl2);
        }
        bl2 = false;
        return new AppMetadata(string2, string3, string4, string5, l2, l3, string, bl3, bl2);
    }

    @Override
    protected void a() {
        String string;
        boolean bl2;
        String string2 = "Unknown";
        String string3 = "Unknown";
        PackageManager packageManager = this.m().getPackageManager();
        String string4 = packageManager.getInstallerPackageName(string = this.m().getPackageName());
        if (string4 == null) {
            string4 = "manual_install";
        } else if ("com.android.vending".equals(string4)) {
            string4 = "";
        }
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(this.m().getPackageName(), 0);
            if (packageInfo != null) {
                CharSequence charSequence = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                if (!TextUtils.isEmpty((CharSequence)charSequence)) {
                    string3 = charSequence.toString();
                }
                string2 = packageInfo.versionName;
            }
        }
        catch (PackageManager.NameNotFoundException var6_13) {
            this.s().b().a("Error retrieving package info: appName", string3);
        }
        this.b = string;
        this.d = string4;
        this.c = string2;
        this.e = string3;
        MessageDigest messageDigest = ag.e("MD5");
        if (messageDigest == null) {
            this.s().b().a("Could not get MD5 instance");
            this.f = -1;
        } else {
            this.f = 0;
            try {
                if (!this.z()) {
                    PackageInfo packageInfo = packageManager.getPackageInfo(this.m().getPackageName(), 64);
                    if (packageInfo.signatures != null && packageInfo.signatures.length > 0) {
                        this.f = ag.c(messageDigest.digest(packageInfo.signatures[0].toByteArray()));
                    }
                }
            }
            catch (PackageManager.NameNotFoundException var8_15) {
                this.s().b().a("Package name not found", (Object)var8_15);
            }
        }
        Status status = this.u().N() ? e.a(this.m(), "-", true) : e.a(this.m());
        boolean bl3 = status != null && status.e();
        if (!bl3) {
            this.a(status);
        }
        if (bl3) {
            bl2 = e.c();
            if (bl2) {
                this.s().z().a("AppMeasurement enabled");
            } else {
                this.s().x().a("AppMeasurement disabled with google_app_measurement_enable=0");
            }
        } else {
            bl2 = false;
        }
        this.g = "";
        if (this.u().N()) return;
        try {
            String string5 = e.a();
            if (TextUtils.isEmpty((CharSequence)string5)) {
                string5 = "";
            }
            this.g = string5;
            if (!bl2) return;
            this.s().z().a("App package, google app id", this.b, this.g);
            return;
        }
        catch (IllegalStateException var12_16) {
            this.s().b().a("getGoogleAppId or isMeasurementEnabled failed with exception", var12_16);
            return;
        }
    }

    protected void a(Status status) {
        if (status == null) {
            this.s().b().a("GoogleService failed to initialize (no status)");
            return;
        }
        this.s().b().a("GoogleService failed to initialize, status", status.f(), status.c());
    }

    String b() {
        this.G();
        return this.b;
    }

    String c() {
        this.G();
        return this.g;
    }

    String v() {
        this.G();
        return this.c;
    }

    String w() {
        this.G();
        return this.d;
    }

    long x() {
        return this.u().M();
    }

    long y() {
        this.G();
        return this.f;
    }

    /*
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    boolean z() {
        try {
            PackageInfo packageInfo = this.m().getPackageManager().getPackageInfo(this.m().getPackageName(), 64);
            if (packageInfo == null) return true;
            if (packageInfo.signatures == null) return true;
            if (packageInfo.signatures.length <= 0) return true;
            Signature signature = packageInfo.signatures[0];
            return ((X509Certificate)CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(signature.toByteArray()))).getSubjectX500Principal().equals(a);
        }
        catch (CertificateException var2_4) {
            this.s().b().a("Error obtaining certificate", var2_4);
        }
        return true;
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            this.s().b().a("Package name not found", (Object)nameNotFoundException);
            return true;
        }
    }
}

