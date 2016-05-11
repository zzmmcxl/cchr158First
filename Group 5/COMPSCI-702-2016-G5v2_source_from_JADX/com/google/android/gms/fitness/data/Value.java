package com.google.android.gms.fitness.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.fitness.FitnessActivities;
import com.google.android.gms.internal.zzmy;
import com.google.android.gms.vision.barcode.Barcode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public final class Value implements SafeParcelable {
    public static final Creator<Value> CREATOR;
    private final int mVersionCode;
    private final int zzawZ;
    private float zzaxe;
    private boolean zzaxq;
    private String zzaxr;
    private Map<String, MapValue> zzaxs;
    private int[] zzaxt;
    private float[] zzaxu;
    private byte[] zzaxv;

    static {
        CREATOR = new zzu();
    }

    public Value(int format) {
        this(3, format, false, 0.0f, null, null, null, null, null);
    }

    Value(int versionCode, int format, boolean isSet, float value, String stringValue, Bundle mapValue, int[] intArrayValue, float[] floatArrayValue, byte[] blob) {
        this.mVersionCode = versionCode;
        this.zzawZ = format;
        this.zzaxq = isSet;
        this.zzaxe = value;
        this.zzaxr = stringValue;
        this.zzaxs = zzv(mapValue);
        this.zzaxt = intArrayValue;
        this.zzaxu = floatArrayValue;
        this.zzaxv = blob;
    }

    private boolean zza(Value value) {
        if (this.zzawZ != value.zzawZ || this.zzaxq != value.zzaxq) {
            return false;
        }
        switch (this.zzawZ) {
            case CompletionEvent.STATUS_FAILURE /*1*/:
                return asInt() == value.asInt();
            case CompletionEvent.STATUS_CONFLICT /*2*/:
                return this.zzaxe == value.zzaxe;
            case CompletionEvent.STATUS_CANCELED /*3*/:
                return zzw.equal(this.zzaxr, value.zzaxr);
            case Barcode.PHONE /*4*/:
                return zzw.equal(this.zzaxs, value.zzaxs);
            case Barcode.PRODUCT /*5*/:
                return Arrays.equals(this.zzaxt, value.zzaxt);
            case Barcode.SMS /*6*/:
                return Arrays.equals(this.zzaxu, value.zzaxu);
            case Barcode.TEXT /*7*/:
                return Arrays.equals(this.zzaxv, value.zzaxv);
            default:
                return this.zzaxe == value.zzaxe;
        }
    }

    private static Map<String, MapValue> zzv(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        bundle.setClassLoader(MapValue.class.getClassLoader());
        Map<String, MapValue> arrayMap = new ArrayMap(bundle.size());
        for (String str : bundle.keySet()) {
            arrayMap.put(str, bundle.getParcelable(str));
        }
        return arrayMap;
    }

    public String asActivity() {
        return FitnessActivities.getName(asInt());
    }

    public float asFloat() {
        zzx.zza(this.zzawZ == 2, (Object) "Value is not in float format");
        return this.zzaxe;
    }

    public int asInt() {
        boolean z = true;
        if (this.zzawZ != 1) {
            z = false;
        }
        zzx.zza(z, (Object) "Value is not in int format");
        return Float.floatToRawIntBits(this.zzaxe);
    }

    public String asString() {
        zzx.zza(this.zzawZ == 3, (Object) "Value is not in string format");
        return this.zzaxr;
    }

    public void clearKey(String key) {
        zzx.zza(this.zzawZ == 4, (Object) "Attempting to set a key's value to a field that is not in FLOAT_MAP format.  Please check the data type definition and use the right format.");
        if (this.zzaxs != null) {
            this.zzaxs.remove(key);
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return this == o || ((o instanceof Value) && zza((Value) o));
    }

    public int getFormat() {
        return this.zzawZ;
    }

    @Nullable
    public Float getKeyValue(String key) {
        zzx.zza(this.zzawZ == 4, (Object) "Value is not in float map format");
        return (this.zzaxs == null || !this.zzaxs.containsKey(key)) ? null : Float.valueOf(((MapValue) this.zzaxs.get(key)).asFloat());
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(Float.valueOf(this.zzaxe), this.zzaxr, this.zzaxs, this.zzaxt, this.zzaxu, this.zzaxv);
    }

    public boolean isSet() {
        return this.zzaxq;
    }

    public void setActivity(String activity) {
        setInt(FitnessActivities.zzdm(activity));
    }

    public void setFloat(float value) {
        zzx.zza(this.zzawZ == 2, (Object) "Attempting to set an float value to a field that is not in FLOAT format.  Please check the data type definition and use the right format.");
        this.zzaxq = true;
        this.zzaxe = value;
    }

    public void setInt(int value) {
        zzx.zza(this.zzawZ == 1, (Object) "Attempting to set an int value to a field that is not in INT32 format.  Please check the data type definition and use the right format.");
        this.zzaxq = true;
        this.zzaxe = Float.intBitsToFloat(value);
    }

    public void setKeyValue(String key, float value) {
        zzx.zza(this.zzawZ == 4, (Object) "Attempting to set a key's value to a field that is not in FLOAT_MAP format.  Please check the data type definition and use the right format.");
        this.zzaxq = true;
        if (this.zzaxs == null) {
            this.zzaxs = new HashMap();
        }
        this.zzaxs.put(key, MapValue.zzc(value));
    }

    public void setString(String value) {
        zzx.zza(this.zzawZ == 3, (Object) "Attempting to set a string value to a field that is not in STRING format.  Please check the data type definition and use the right format.");
        this.zzaxq = true;
        this.zzaxr = value;
    }

    public String toString() {
        if (!this.zzaxq) {
            return "unset";
        }
        switch (this.zzawZ) {
            case CompletionEvent.STATUS_FAILURE /*1*/:
                return Integer.toString(asInt());
            case CompletionEvent.STATUS_CONFLICT /*2*/:
                return Float.toString(this.zzaxe);
            case CompletionEvent.STATUS_CANCELED /*3*/:
                return this.zzaxr;
            case Barcode.PHONE /*4*/:
                return new TreeMap(this.zzaxs).toString();
            case Barcode.PRODUCT /*5*/:
                return Arrays.toString(this.zzaxt);
            case Barcode.SMS /*6*/:
                return Arrays.toString(this.zzaxu);
            case Barcode.TEXT /*7*/:
                return zzmy.zza(this.zzaxv, 0, this.zzaxv.length, false);
            default:
                return FitnessActivities.UNKNOWN;
        }
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzu.zza(this, dest, flags);
    }

    String zzuA() {
        return this.zzaxr;
    }

    Bundle zzuB() {
        if (this.zzaxs == null) {
            return null;
        }
        Bundle bundle = new Bundle(this.zzaxs.size());
        for (Entry entry : this.zzaxs.entrySet()) {
            bundle.putParcelable((String) entry.getKey(), (Parcelable) entry.getValue());
        }
        return bundle;
    }

    int[] zzuC() {
        return this.zzaxt;
    }

    float[] zzuD() {
        return this.zzaxu;
    }

    byte[] zzuE() {
        return this.zzaxv;
    }

    float zzuv() {
        return this.zzaxe;
    }
}
