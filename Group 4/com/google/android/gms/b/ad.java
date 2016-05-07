/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import com.google.android.gms.b.fi;
import com.google.android.gms.common.internal.bf;
import java.util.List;

@fi
public class ad {
    private final Context a;

    public ad(Context context) {
        bf.a((Object)context, (Object)"Context can not be null");
        this.a = context;
    }

    public static boolean e() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    public boolean a() {
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse((String)"tel:"));
        return this.a(intent);
    }

    public boolean a(Intent intent) {
        bf.a((Object)intent, (Object)"Intent can not be null");
        boolean bl2 = this.a.getPackageManager().queryIntentActivities(intent, 0).isEmpty();
        boolean bl3 = false;
        if (bl2) return bl3;
        return true;
    }

    public boolean b() {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse((String)"sms:"));
        return this.a(intent);
    }

    public boolean c() {
        if (!ad.e()) return false;
        if (this.a.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) return false;
        return true;
    }

    public boolean d() {
        return true;
    }

    @TargetApi(value=14)
    public boolean f() {
        Intent intent = new Intent("android.intent.action.INSERT").setType("vnd.android.cursor.dir/event");
        if (Build.VERSION.SDK_INT < 14) return false;
        if (!this.a(intent)) return false;
        return true;
    }
}

