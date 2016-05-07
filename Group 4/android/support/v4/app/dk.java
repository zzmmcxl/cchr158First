/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.app;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.dj;

class dk
implements dj {
    dk() {
    }

    @Override
    public PendingIntent a(Context context, Intent[] arrintent, int n2, int n3, Bundle bundle) {
        Intent intent = new Intent(arrintent[-1 + arrintent.length]);
        intent.addFlags(268435456);
        return PendingIntent.getActivity((Context)context, (int)n2, (Intent)intent, (int)n3);
    }
}

