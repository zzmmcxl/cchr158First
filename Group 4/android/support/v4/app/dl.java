/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.app;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.dj;
import android.support.v4.app.dm;

class dl
implements dj {
    dl() {
    }

    @Override
    public PendingIntent a(Context context, Intent[] arrintent, int n2, int n3, Bundle bundle) {
        arrintent[0] = new Intent(arrintent[0]).addFlags(268484608);
        return dm.a(context, n2, arrintent, n3);
    }
}

