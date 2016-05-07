/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.google.android.gms.ads.internal.g;
import com.google.android.gms.b.fi;
import com.google.android.gms.b.fp;
import com.google.android.gms.b.gk;
import com.google.android.gms.b.gl;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@fi
public class gj {
    private final Context a;
    private String b;
    private final float c;
    private float d;
    private float e;
    private float f;
    private int g = 0;

    public gj(Context context) {
        this.a = context;
        this.c = context.getResources().getDisplayMetrics().density;
    }

    public gj(Context context, String string) {
        this(context);
        this.b = string;
    }

    static /* synthetic */ Context a(gj gj2) {
        return gj2.a;
    }

    static String a(String string) {
        if (TextUtils.isEmpty((CharSequence)string)) {
            return "No debug information";
        }
        String string2 = string.replaceAll("\\+", "%20");
        Uri uri = new Uri.Builder().encodedQuery(string2).build();
        StringBuilder stringBuilder = new StringBuilder();
        Map map = g.c().a(uri);
        Iterator iterator = map.keySet().iterator();
        do {
            if (!iterator.hasNext()) {
                String string3 = stringBuilder.toString().trim();
                if (!TextUtils.isEmpty((CharSequence)string3)) return string3;
                return "No debug information";
            }
            String string4 = (String)iterator.next();
            stringBuilder.append(string4).append(" = ").append((String)map.get(string4)).append("\n\n");
        } while (true);
    }

    private void a() {
        if (!(this.a instanceof Activity)) {
            fp.c("Can not create dialog without Activity Context");
            return;
        }
        String string = gj.a(this.b);
        AlertDialog.Builder builder = new AlertDialog.Builder(this.a);
        builder.setMessage((CharSequence)string);
        builder.setTitle((CharSequence)"Ad Information");
        builder.setPositiveButton((CharSequence)"Share", (DialogInterface.OnClickListener)new gk(this, string));
        builder.setNegativeButton((CharSequence)"Close", (DialogInterface.OnClickListener)new gl(this));
        builder.create().show();
    }

    void a(int n2, float f2, float f3) {
        if (n2 == 0) {
            this.g = 0;
            this.d = f2;
            this.e = f3;
            this.f = f3;
            return;
        }
        if (this.g == -1) return;
        if (n2 != 2) {
            if (n2 != 1) return;
            if (this.g != 4) return;
            this.a();
            return;
        }
        if (f3 > this.e) {
            this.e = f3;
        } else if (f3 < this.f) {
            this.f = f3;
        }
        if (this.e - this.f > 30.0f * this.c) {
            this.g = -1;
            return;
        }
        if (this.g == 0 || this.g == 2) {
            if (f2 - this.d >= 50.0f * this.c) {
                this.d = f2;
                this.g = 1 + this.g;
            }
        } else if ((this.g == 1 || this.g == 3) && f2 - this.d <= -50.0f * this.c) {
            this.d = f2;
            this.g = 1 + this.g;
        }
        if (this.g != 1 && this.g != 3) {
            if (this.g != 2) return;
            if (f2 >= this.d) return;
            this.d = f2;
            return;
        }
        if (f2 <= this.d) return;
        this.d = f2;
    }

    public void a(MotionEvent motionEvent) {
        int n2 = motionEvent.getHistorySize();
        int n3 = 0;
        do {
            if (n3 >= n2) {
                this.a(motionEvent.getActionMasked(), motionEvent.getX(), motionEvent.getY());
                return;
            }
            this.a(motionEvent.getActionMasked(), motionEvent.getHistoricalX(0, n3), motionEvent.getHistoricalY(0, n3));
            ++n3;
        } while (true);
    }
}

