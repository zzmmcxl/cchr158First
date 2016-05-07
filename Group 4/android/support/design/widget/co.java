/*
 * Decompiled with CFR 0_115.
 */
package android.support.design.widget;

import android.os.Build;
import android.support.design.widget.bu;
import android.support.design.widget.bx;
import android.support.design.widget.by;
import android.support.design.widget.cb;
import android.support.design.widget.cd;

final class co
implements bx {
    co() {
    }

    @Override
    public bu a() {
        void var1_2;
        if (Build.VERSION.SDK_INT >= 12) {
            cd cd2 = new cd();
            return new bu((by)var1_2);
        }
        cb cb2 = new cb();
        return new bu((by)var1_2);
    }
}

