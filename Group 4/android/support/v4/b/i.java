/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.b;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v4.b.h;

class i
implements h {
    i() {
    }

    @Override
    public Intent a(ComponentName componentName) {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.setComponent(componentName);
        intent.addCategory("android.intent.category.LAUNCHER");
        return intent;
    }
}

