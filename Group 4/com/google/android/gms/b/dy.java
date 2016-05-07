/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.android.gms.ads.internal.g;
import com.google.android.gms.b.ad;
import com.google.android.gms.b.dz;
import com.google.android.gms.b.ea;
import com.google.android.gms.b.ef;
import com.google.android.gms.b.fi;
import com.google.android.gms.b.hb;
import com.google.android.gms.d;
import java.util.Map;

@fi
public class dy
extends ef {
    private final Map a;
    private final Context b;

    public dy(hb hb2, Map map) {
        super(hb2, "storePicture");
        this.a = map;
        this.b = hb2.e();
    }

    static /* synthetic */ Context a(dy dy2) {
        return dy2.b;
    }

    DownloadManager.Request a(String string, String string2) {
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse((String)string));
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, string2);
        g.e().a(request);
        return request;
    }

    String a(String string) {
        return Uri.parse((String)string).getLastPathSegment();
    }

    public void a() {
        if (this.b == null) {
            this.b("Activity context is not available");
            return;
        }
        if (!g.c().c(this.b).c()) {
            this.b("Feature is not supported by the device.");
            return;
        }
        String string = (String)this.a.get("iurl");
        if (TextUtils.isEmpty((CharSequence)string)) {
            this.b("Image url cannot be empty.");
            return;
        }
        if (!URLUtil.isValidUrl((String)string)) {
            this.b("Invalid image url: " + string);
            return;
        }
        String string2 = this.a(string);
        if (!g.c().b(string2)) {
            this.b("Image type not recognized: " + string2);
            return;
        }
        AlertDialog.Builder builder = g.c().b(this.b);
        builder.setTitle((CharSequence)g.f().a(d.store_picture_title, "Save image"));
        builder.setMessage((CharSequence)g.f().a(d.store_picture_message, "Allow Ad to store image in Picture gallery?"));
        builder.setPositiveButton((CharSequence)g.f().a(d.accept, "Accept"), (DialogInterface.OnClickListener)new dz(this, string, string2));
        builder.setNegativeButton((CharSequence)g.f().a(d.decline, "Decline"), (DialogInterface.OnClickListener)new ea(this));
        builder.create().show();
    }
}

