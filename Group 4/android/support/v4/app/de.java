/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.app.dc;

class de {
    static Bundle a(dc dc2) {
        Bundle bundle = new Bundle();
        bundle.putString("resultKey", dc2.a());
        bundle.putCharSequence("label", dc2.b());
        bundle.putCharSequenceArray("choices", dc2.c());
        bundle.putBoolean("allowFreeFormInput", dc2.d());
        bundle.putBundle("extras", dc2.e());
        return bundle;
    }

    static Bundle[] a(dc[] arrdc) {
        if (arrdc == null) {
            return null;
        }
        Bundle[] arrbundle = new Bundle[arrdc.length];
        int n2 = 0;
        while (n2 < arrdc.length) {
            arrbundle[n2] = de.a(arrdc[n2]);
            ++n2;
        }
        return arrbundle;
    }
}

