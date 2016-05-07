/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import com.google.android.gms.b.fi;
import com.google.android.gms.b.fp;
import com.google.android.gms.b.hb;
import org.json.JSONException;
import org.json.JSONObject;

@fi
public class ef {
    private final hb a;
    private final String b;

    public ef(hb hb2) {
        this(hb2, "");
    }

    public ef(hb hb2, String string) {
        this.a = hb2;
        this.b = string;
    }

    public void a(int n2, int n3, int n4, int n5) {
        try {
            JSONObject jSONObject = new JSONObject().put("x", n2).put("y", n3).put("width", n4).put("height", n5);
            this.a.a("onSizeChanged", jSONObject);
            return;
        }
        catch (JSONException var5_6) {
            fp.b("Error occured while dispatching size change.", (Throwable)var5_6);
            return;
        }
    }

    public void a(int n2, int n3, int n4, int n5, float f2, int n6) {
        try {
            JSONObject jSONObject = new JSONObject().put("width", n2).put("height", n3).put("maxSizeWidth", n4).put("maxSizeHeight", n5).put("density", (double)f2).put("rotation", n6);
            this.a.a("onScreenInfoChanged", jSONObject);
            return;
        }
        catch (JSONException var7_8) {
            fp.b("Error occured while obtaining screen information.", (Throwable)var7_8);
            return;
        }
    }

    public void b(int n2, int n3, int n4, int n5) {
        try {
            JSONObject jSONObject = new JSONObject().put("x", n2).put("y", n3).put("width", n4).put("height", n5);
            this.a.a("onDefaultPositionReceived", jSONObject);
            return;
        }
        catch (JSONException var5_6) {
            fp.b("Error occured while dispatching default position.", (Throwable)var5_6);
            return;
        }
    }

    public void b(String string) {
        try {
            JSONObject jSONObject = new JSONObject().put("message", (Object)string).put("action", (Object)this.b);
            this.a.a("onError", jSONObject);
            return;
        }
        catch (JSONException var2_3) {
            fp.b("Error occurred while dispatching error event.", (Throwable)var2_3);
            return;
        }
    }

    public void c(String string) {
        try {
            JSONObject jSONObject = new JSONObject().put("js", (Object)string);
            this.a.a("onReadyEventReceived", jSONObject);
            return;
        }
        catch (JSONException var2_3) {
            fp.b("Error occured while dispatching ready Event.", (Throwable)var2_3);
            return;
        }
    }

    public void d(String string) {
        try {
            JSONObject jSONObject = new JSONObject().put("state", (Object)string);
            this.a.a("onStateChanged", jSONObject);
            return;
        }
        catch (JSONException var2_3) {
            fp.b("Error occured while dispatching state change.", (Throwable)var2_3);
            return;
        }
    }
}

