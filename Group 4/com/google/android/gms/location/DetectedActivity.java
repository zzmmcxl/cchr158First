/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.bc;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.b;
import com.google.android.gms.location.c;
import java.util.Comparator;

public class DetectedActivity
implements SafeParcelable {
    public static final c CREATOR;
    public static final Comparator a;
    public static final int[] b;
    int c;
    int d;
    private final int e;

    static {
        a = new b();
        b = new int[]{0, 1, 2, 4, 5, 6, 7, 8, 10, 11, 12, 13, 14};
        CREATOR = new c();
    }

    public DetectedActivity(int n2, int n3, int n4) {
        this.e = n2;
        this.c = n3;
        this.d = n4;
    }

    public static String a(int n2) {
        switch (n2) {
            default: {
                return Integer.toString(n2);
            }
            case 0: {
                return "IN_VEHICLE";
            }
            case 1: {
                return "ON_BICYCLE";
            }
            case 2: {
                return "ON_FOOT";
            }
            case 3: {
                return "STILL";
            }
            case 4: {
                return "UNKNOWN";
            }
            case 5: {
                return "TILTING";
            }
            case 7: {
                return "WALKING";
            }
            case 8: 
        }
        return "RUNNING";
    }

    private int b(int n2) {
        if (n2 <= 15) return n2;
        return 4;
    }

    public int a() {
        return this.b(this.c);
    }

    public int b() {
        return this.d;
    }

    public int c() {
        return this.e;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (this.getClass() != object.getClass()) {
            return false;
        }
        DetectedActivity detectedActivity = (DetectedActivity)object;
        if (this.c != detectedActivity.c) return false;
        if (this.d == detectedActivity.d) return true;
        return false;
    }

    public int hashCode() {
        Object[] arrobject = new Object[]{this.c, this.d};
        return bc.a(arrobject);
    }

    public String toString() {
        return "DetectedActivity [type=" + DetectedActivity.a(this.a()) + ", confidence=" + this.d + "]";
    }

    public void writeToParcel(Parcel parcel, int n2) {
        c.a(this, parcel, n2);
    }
}

