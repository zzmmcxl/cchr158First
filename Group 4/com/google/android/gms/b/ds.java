/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.provider.CalendarContract;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.g;
import com.google.android.gms.b.ad;
import com.google.android.gms.b.dt;
import com.google.android.gms.b.du;
import com.google.android.gms.b.ef;
import com.google.android.gms.b.fi;
import com.google.android.gms.b.hb;
import com.google.android.gms.d;
import java.util.Map;

@fi
public class ds
extends ef {
    private final Map a;
    private final Context b;
    private String c;
    private long d;
    private long e;
    private String f;
    private String g;

    public ds(hb hb2, Map map) {
        super(hb2, "createCalendarEvent");
        this.a = map;
        this.b = hb2.e();
        this.c();
    }

    static /* synthetic */ Context a(ds ds2) {
        return ds2.b;
    }

    private String a(String string) {
        if (!TextUtils.isEmpty((CharSequence)((CharSequence)this.a.get(string)))) return (String)this.a.get(string);
        return "";
    }

    private void c() {
        this.c = this.a("description");
        this.f = this.a("summary");
        this.d = this.e("start_ticks");
        this.e = this.e("end_ticks");
        this.g = this.a("location");
    }

    private long e(String string) {
        String string2 = (String)this.a.get(string);
        if (string2 == null) {
            return -1;
        }
        try {
            return Long.parseLong(string2);
        }
        catch (NumberFormatException var3_4) {
            return -1;
        }
    }

    public void a() {
        if (this.b == null) {
            this.b("Activity context is not available.");
            return;
        }
        if (!g.c().c(this.b).f()) {
            this.b("This feature is not available on the device.");
            return;
        }
        AlertDialog.Builder builder = g.c().b(this.b);
        builder.setTitle((CharSequence)g.f().a(d.create_calendar_title, "Create calendar event"));
        builder.setMessage((CharSequence)g.f().a(d.create_calendar_message, "Allow Ad to create a calendar event?"));
        builder.setPositiveButton((CharSequence)g.f().a(d.accept, "Accept"), (DialogInterface.OnClickListener)new dt(this));
        builder.setNegativeButton((CharSequence)g.f().a(d.decline, "Decline"), (DialogInterface.OnClickListener)new du(this));
        builder.create().show();
    }

    @TargetApi(value=14)
    Intent b() {
        Intent intent = new Intent("android.intent.action.EDIT").setData(CalendarContract.Events.CONTENT_URI);
        intent.putExtra("title", this.c);
        intent.putExtra("eventLocation", this.g);
        intent.putExtra("description", this.f);
        if (this.d > -1) {
            intent.putExtra("beginTime", this.d);
        }
        if (this.e > -1) {
            intent.putExtra("endTime", this.e);
        }
        intent.setFlags(268435456);
        return intent;
    }
}

