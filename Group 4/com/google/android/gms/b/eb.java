/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import com.google.android.gms.b.ec;
import com.google.android.gms.b.ed;
import com.google.android.gms.b.fi;
import com.google.android.gms.b.fp;
import org.json.JSONException;
import org.json.JSONObject;

@fi
public class eb {
    private final boolean a;
    private final boolean b;
    private final boolean c;
    private final boolean d;
    private final boolean e;

    private eb(ed ed2) {
        this.a = ed.a(ed2);
        this.b = ed.b(ed2);
        this.c = ed.c(ed2);
        this.d = ed.d(ed2);
        this.e = ed.e(ed2);
    }

    /* synthetic */ eb(ed ed2, ec ec2) {
        this(ed2);
    }

    public JSONObject a() {
        try {
            return new JSONObject().put("sms", this.a).put("tel", this.b).put("calendar", this.c).put("storePicture", this.d).put("inlineVideo", this.e);
        }
        catch (JSONException var1_2) {
            fp.b("Error occured while obtaining the MRAID capabilities.", (Throwable)var1_2);
            return null;
        }
    }
}

