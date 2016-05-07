/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import com.google.android.gms.b.fi;
import com.google.android.gms.b.kn;

@fi
public class hm
extends MutableContextWrapper {
    private Activity a;
    private Context b;
    private Context c;

    public hm(Context context) {
        super(context);
        this.setBaseContext(context);
    }

    public Activity a() {
        return this.a;
    }

    public Context b() {
        return this.c;
    }

    public Object getSystemService(String string) {
        return this.c.getSystemService(string);
    }

    public void setBaseContext(Context context) {
        this.b = context.getApplicationContext();
        Activity activity = context instanceof Activity ? (Activity)context : null;
        this.a = activity;
        this.c = context;
        super.setBaseContext(this.b);
    }

    public void startActivity(Intent intent) {
        if (this.a != null && !kn.h()) {
            this.a.startActivity(intent);
            return;
        }
        intent.setFlags(268435456);
        this.b.startActivity(intent);
    }
}

