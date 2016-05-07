/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v4.app.bh;
import android.support.v4.app.bj;

class bi
extends bh {
    bi() {
    }

    @Override
    public Intent a(Activity activity) {
        Intent intent = bj.a(activity);
        if (intent != null) return intent;
        return this.b(activity);
    }

    @Override
    public String a(Context context, ActivityInfo activityInfo) {
        String string = bj.a(activityInfo);
        if (string != null) return string;
        return super.a(context, activityInfo);
    }

    @Override
    public boolean a(Activity activity, Intent intent) {
        return bj.a(activity, intent);
    }

    Intent b(Activity activity) {
        return super.a(activity);
    }

    @Override
    public void b(Activity activity, Intent intent) {
        bj.b(activity, intent);
    }
}

