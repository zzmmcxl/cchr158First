/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.bf;
import android.support.v4.app.bg;
import android.support.v4.b.g;
import android.util.Log;

class bh
implements bg {
    bh() {
    }

    @Override
    public Intent a(Activity activity) {
        String string = bf.b(activity);
        if (string == null) {
            return null;
        }
        ComponentName componentName = new ComponentName((Context)activity, string);
        try {
            if (bf.b((Context)activity, componentName) != null) return new Intent().setComponent(componentName);
            return g.a(componentName);
        }
        catch (PackageManager.NameNotFoundException var4_5) {
            Log.e((String)"NavUtils", (String)("getParentActivityIntent: bad parentActivityName '" + string + "' in manifest"));
            return null;
        }
    }

    @Override
    public String a(Context context, ActivityInfo activityInfo) {
        if (activityInfo.metaData == null) {
            return null;
        }
        String string = activityInfo.metaData.getString("android.support.PARENT_ACTIVITY");
        if (string == null) {
            return null;
        }
        if (string.charAt(0) != '.') return string;
        return context.getPackageName() + string;
    }

    @Override
    public boolean a(Activity activity, Intent intent) {
        String string = activity.getIntent().getAction();
        if (string == null) return false;
        if (string.equals("android.intent.action.MAIN")) return false;
        return true;
    }

    @Override
    public void b(Activity activity, Intent intent) {
        intent.addFlags(67108864);
        activity.startActivity(intent);
        activity.finish();
    }
}

