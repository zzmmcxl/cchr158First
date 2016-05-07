/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.measurement.internal.EventParams;
import com.google.android.gms.measurement.internal.ag;
import com.google.android.gms.measurement.internal.bc;
import com.google.android.gms.measurement.internal.be;
import com.google.android.gms.measurement.internal.bx;
import java.util.Iterator;
import java.util.Set;

public class ar {
    final String a;
    final String b;
    final String c;
    final long d;
    final long e;
    final EventParams f;

    ar(bx bx2, String string, String string2, String string3, long l2, long l3, Bundle bundle) {
        bf.a(string2);
        bf.a(string3);
        this.a = string2;
        this.b = string3;
        if (TextUtils.isEmpty((CharSequence)string)) {
            string = null;
        }
        this.c = string;
        this.d = l2;
        this.e = l3;
        if (this.e != 0 && this.e > this.d) {
            bx2.f().c().a("Event created with reverse previous/current timestamps");
        }
        this.f = this.a(bx2, bundle);
    }

    private ar(bx bx2, String string, String string2, String string3, long l2, long l3, EventParams eventParams) {
        bf.a(string2);
        bf.a(string3);
        bf.a(eventParams);
        this.a = string2;
        this.b = string3;
        if (TextUtils.isEmpty((CharSequence)string)) {
            string = null;
        }
        this.c = string;
        this.d = l2;
        this.e = l3;
        if (this.e != 0 && this.e > this.d) {
            bx2.f().c().a("Event created with reverse previous/current timestamps");
        }
        this.f = eventParams;
    }

    private EventParams a(bx bx2, Bundle bundle) {
        if (bundle == null) return new EventParams(new Bundle());
        if (bundle.isEmpty()) return new EventParams(new Bundle());
        Bundle bundle2 = new Bundle(bundle);
        Iterator iterator = bundle2.keySet().iterator();
        while (iterator.hasNext()) {
            String string = (String)iterator.next();
            if (string == null) {
                iterator.remove();
                continue;
            }
            Object object = bx2.m().a(string, bundle2.get(string));
            if (object == null) {
                iterator.remove();
                continue;
            }
            bx2.m().a(bundle2, string, object);
        }
        return new EventParams(bundle2);
    }

    ar a(bx bx2, long l2) {
        return new ar(bx2, this.c, this.a, this.b, this.d, l2, this.f);
    }

    public String toString() {
        return "Event{appId='" + this.a + '\'' + ", name='" + this.b + '\'' + ", params=" + this.f + '}';
    }
}

