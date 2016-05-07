/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.a;

import android.content.Context;
import android.os.Build;
import android.support.v4.app.bs;
import android.support.v4.app.bt;
import android.support.v7.a.aw;
import android.support.v7.a.ay;
import android.support.v7.a.az;
import android.support.v7.a.ba;

public class ax
extends bs {
    public ax(Context context) {
        super(context);
    }

    @Override
    protected bt b() {
        if (Build.VERSION.SDK_INT >= 21) {
            return new ba(null);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return new az(null);
        }
        if (Build.VERSION.SDK_INT < 14) return super.b();
        return new ay(null);
    }
}

