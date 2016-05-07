/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.app;

import android.app.RemoteInput;
import android.os.Bundle;
import android.support.v4.app.dc;

class da {
    static RemoteInput[] a(dc[] arrdc) {
        if (arrdc == null) {
            return null;
        }
        RemoteInput[] arrremoteInput = new RemoteInput[arrdc.length];
        int n2 = 0;
        while (n2 < arrdc.length) {
            dc dc2 = arrdc[n2];
            arrremoteInput[n2] = new RemoteInput.Builder(dc2.a()).setLabel(dc2.b()).setChoices(dc2.c()).setAllowFreeFormInput(dc2.d()).addExtras(dc2.e()).build();
            ++n2;
        }
        return arrremoteInput;
    }
}

