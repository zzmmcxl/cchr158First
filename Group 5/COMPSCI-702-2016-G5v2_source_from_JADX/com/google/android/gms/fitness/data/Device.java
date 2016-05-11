package com.google.android.gms.fitness.data;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.provider.Settings.Secure;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zznv;
import com.google.android.gms.internal.zzoz;
import com.woop.tryreverseengineerthis.BuildConfig;

public final class Device implements SafeParcelable {
    public static final Creator<Device> CREATOR;
    public static final int TYPE_CHEST_STRAP = 4;
    public static final int TYPE_PHONE = 1;
    public static final int TYPE_SCALE = 5;
    public static final int TYPE_TABLET = 2;
    public static final int TYPE_UNKNOWN = 0;
    public static final int TYPE_WATCH = 3;
    private final int mVersionCode;
    private final int zzabB;
    private final String zzadc;
    private final String zzawI;
    private final String zzawJ;
    private final String zzawK;
    private final int zzawL;

    static {
        CREATOR = new zzi();
    }

    Device(int versionCode, String manufacturer, String model, String version, String uid, int type, int platformType) {
        this.mVersionCode = versionCode;
        this.zzawI = (String) zzx.zzz(manufacturer);
        this.zzawJ = (String) zzx.zzz(model);
        this.zzadc = BuildConfig.FLAVOR;
        this.zzawK = (String) zzx.zzz(uid);
        this.zzabB = type;
        this.zzawL = platformType;
    }

    public Device(String manufacturer, String model, String uid, int type) {
        this(manufacturer, model, BuildConfig.FLAVOR, uid, type, TYPE_UNKNOWN);
    }

    public Device(String manufacturer, String model, String version, String uid, int type, int platformType) {
        this(TYPE_PHONE, manufacturer, model, BuildConfig.FLAVOR, uid, type, platformType);
    }

    public static Device getLocalDevice(Context context) {
        int zzaG = zznv.zzaG(context);
        return new Device(Build.MANUFACTURER, Build.MODEL, VERSION.RELEASE, zzaC(context), zzaG, TYPE_TABLET);
    }

    private boolean zza(Device device) {
        return zzw.equal(this.zzawI, device.zzawI) && zzw.equal(this.zzawJ, device.zzawJ) && zzw.equal(this.zzadc, device.zzadc) && zzw.equal(this.zzawK, device.zzawK) && this.zzabB == device.zzabB && this.zzawL == device.zzawL;
    }

    private static String zzaC(Context context) {
        return Secure.getString(context.getContentResolver(), "android_id");
    }

    private boolean zzus() {
        return zzur() == TYPE_PHONE;
    }

    public int describeContents() {
        return TYPE_UNKNOWN;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof Device) && zza((Device) that));
    }

    public String getManufacturer() {
        return this.zzawI;
    }

    public String getModel() {
        return this.zzawJ;
    }

    String getStreamIdentifier() {
        Object[] objArr = new Object[TYPE_WATCH];
        objArr[TYPE_UNKNOWN] = this.zzawI;
        objArr[TYPE_PHONE] = this.zzawJ;
        objArr[TYPE_TABLET] = this.zzawK;
        return String.format("%s:%s:%s", objArr);
    }

    public int getType() {
        return this.zzabB;
    }

    public String getUid() {
        return this.zzawK;
    }

    public String getVersion() {
        return this.zzadc;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        Object[] objArr = new Object[TYPE_SCALE];
        objArr[TYPE_UNKNOWN] = this.zzawI;
        objArr[TYPE_PHONE] = this.zzawJ;
        objArr[TYPE_TABLET] = this.zzadc;
        objArr[TYPE_WATCH] = this.zzawK;
        objArr[TYPE_CHEST_STRAP] = Integer.valueOf(this.zzabB);
        return zzw.hashCode(objArr);
    }

    public String toString() {
        Object[] objArr = new Object[TYPE_CHEST_STRAP];
        objArr[TYPE_UNKNOWN] = getStreamIdentifier();
        objArr[TYPE_PHONE] = this.zzadc;
        objArr[TYPE_TABLET] = Integer.valueOf(this.zzabB);
        objArr[TYPE_WATCH] = Integer.valueOf(this.zzawL);
        return String.format("Device{%s:%s:%s:%s}", objArr);
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzi.zza(this, parcel, flags);
    }

    public int zzur() {
        return this.zzawL;
    }

    public String zzut() {
        return zzus() ? this.zzawK : zzoz.zzdF(this.zzawK);
    }
}
