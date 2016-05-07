/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.location;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.bc;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.a;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ActivityRecognitionResult
implements SafeParcelable {
    public static final a CREATOR = new a();
    List a;
    long b;
    long c;
    int d;
    Bundle e;
    private final int f;

    public ActivityRecognitionResult(int n2, List list, long l2, long l3, int n3, Bundle bundle) {
        this.f = n2;
        this.a = list;
        this.b = l2;
        this.c = l3;
        this.d = n3;
        this.e = bundle;
    }

    private static boolean a(Bundle bundle, Bundle bundle2) {
        String string;
        if (bundle == null && bundle2 == null) {
            return true;
        }
        if (bundle == null) {
            if (bundle2 != null) return false;
        }
        if (bundle != null && bundle2 == null) {
            return false;
        }
        if (bundle.size() != bundle2.size()) {
            return false;
        }
        Iterator iterator = bundle.keySet().iterator();
        do {
            if (!iterator.hasNext()) return true;
            string = (String)iterator.next();
            if (bundle2.containsKey(string)) continue;
            return false;
        } while (!(bundle.get(string) == null ? bundle2.get(string) != null : (bundle.get(string) instanceof Bundle ? !ActivityRecognitionResult.a(bundle.getBundle(string), bundle2.getBundle(string)) : !bundle.get(string).equals(bundle2.get(string)))));
        return false;
    }

    public int a() {
        return this.f;
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
        ActivityRecognitionResult activityRecognitionResult = (ActivityRecognitionResult)object;
        if (this.b != activityRecognitionResult.b) return false;
        if (this.c != activityRecognitionResult.c) return false;
        if (this.d != activityRecognitionResult.d) return false;
        if (!bc.a((Object)this.a, (Object)activityRecognitionResult.a)) return false;
        if (ActivityRecognitionResult.a(this.e, activityRecognitionResult.e)) return true;
        return false;
    }

    public int hashCode() {
        Object[] arrobject = new Object[]{this.b, this.c, this.d, this.a, this.e};
        return bc.a(arrobject);
    }

    public String toString() {
        return "ActivityRecognitionResult [probableActivities=" + this.a + ", timeMillis=" + this.b + ", elapsedRealtimeMillis=" + this.c + "]";
    }

    public void writeToParcel(Parcel parcel, int n2) {
        a.a(this, parcel, n2);
    }
}

