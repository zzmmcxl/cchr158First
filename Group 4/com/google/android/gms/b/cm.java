/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.content.Context;
import android.graphics.Color;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.google.android.gms.ads.internal.client.n;
import com.google.android.gms.ads.internal.overlay.p;
import com.google.android.gms.b.ce;
import com.google.android.gms.b.fi;
import com.google.android.gms.b.fp;
import com.google.android.gms.b.ha;
import com.google.android.gms.b.hb;
import java.util.Map;
import java.util.WeakHashMap;
import org.json.JSONObject;

@fi
public final class cm
implements ce {
    private final Map a = new WeakHashMap();

    private static int a(Context context, Map map, String string, int n2) {
        String string2 = (String)map.get(string);
        if (string2 == null) return n2;
        try {
            int n3 = n.a().a(context, Integer.parseInt(string2));
            return n3;
        }
        catch (NumberFormatException var5_6) {
            fp.d("Could not parse " + string + " in a video GMSG: " + string2);
            return n2;
        }
    }

    @Override
    public void a(hb hb2, Map map) {
        String string = (String)map.get("action");
        if (string == null) {
            fp.d("Action missing from video GMSG.");
            return;
        }
        if (fp.a(3)) {
            JSONObject jSONObject = new JSONObject(map);
            jSONObject.remove("google.afma.Notify_dt");
            fp.a("Video GMSG: " + string + " " + jSONObject.toString());
        }
        if ("background".equals(string)) {
            String string2 = (String)map.get("color");
            if (TextUtils.isEmpty((CharSequence)string2)) {
                fp.d("Color parameter missing from color video GMSG.");
                return;
            }
            try {
                p p2;
                int n2 = Color.parseColor((String)string2);
                ha ha2 = hb2.s();
                if (ha2 != null && (p2 = ha2.a()) != null) {
                    p2.setBackgroundColor(n2);
                    return;
                }
                this.a.put(hb2, n2);
                return;
            }
            catch (IllegalArgumentException var31_9) {
                fp.d("Invalid color parameter in video GMSG.");
                return;
            }
        }
        ha ha3 = hb2.s();
        if (ha3 == null) {
            fp.d("Could not get underlay container for a video GMSG.");
            return;
        }
        boolean bl2 = "new".equals(string);
        boolean bl3 = "position".equals(string);
        if (bl2 || bl3) {
            int n3;
            Context context = hb2.getContext();
            int n4 = cm.a(context, map, "x", 0);
            int n5 = cm.a(context, map, "y", 0);
            int n6 = cm.a(context, map, "w", -1);
            int n7 = cm.a(context, map, "h", -1);
            try {
                int n8;
                n3 = n8 = Integer.parseInt((String)map.get("player"));
            }
            catch (NumberFormatException var14_22) {
                n3 = 0;
            }
            if (bl2 && ha3.a() == null) {
                ha3.a(n4, n5, n6, n7, n3);
                if (!this.a.containsKey(hb2)) return;
                int n9 = (Integer)this.a.get(hb2);
                p p3 = ha3.a();
                p3.setBackgroundColor(n9);
                p3.f();
                return;
            }
            ha3.a(n4, n5, n6, n7);
            return;
        }
        p p4 = ha3.a();
        if (p4 == null) {
            p.a(hb2);
            return;
        }
        if ("click".equals(string)) {
            Context context = hb2.getContext();
            int n10 = cm.a(context, map, "x", 0);
            int n11 = cm.a(context, map, "y", 0);
            long l2 = SystemClock.uptimeMillis();
            MotionEvent motionEvent = MotionEvent.obtain((long)l2, (long)l2, (int)0, (float)n10, (float)n11, (int)0);
            p4.a(motionEvent);
            motionEvent.recycle();
            return;
        }
        if ("currentTime".equals(string)) {
            String string3 = (String)map.get("time");
            if (string3 == null) {
                fp.d("Time parameter missing from currentTime video GMSG.");
                return;
            }
            try {
                p4.a((int)(1000.0f * Float.parseFloat(string3)));
                return;
            }
            catch (NumberFormatException var23_30) {
                fp.d("Could not parse time parameter from currentTime video GMSG: " + string3);
                return;
            }
        }
        if ("hide".equals(string)) {
            p4.setVisibility(4);
            return;
        }
        if ("load".equals(string)) {
            p4.a();
            return;
        }
        if ("mimetype".equals(string)) {
            p4.setMimeType((String)map.get("mimetype"));
            return;
        }
        if ("muted".equals(string)) {
            if (Boolean.parseBoolean((String)map.get("muted"))) {
                p4.d();
                return;
            }
            p4.e();
            return;
        }
        if ("pause".equals(string)) {
            p4.b();
            return;
        }
        if ("play".equals(string)) {
            p4.c();
            return;
        }
        if ("show".equals(string)) {
            p4.setVisibility(0);
            return;
        }
        if ("src".equals(string)) {
            p4.a((String)map.get("src"));
            return;
        }
        if ("volume".equals(string)) {
            String string4 = (String)map.get("volume");
            if (string4 == null) {
                fp.d("Level parameter missing from volume video GMSG.");
                return;
            }
            try {
                p4.a(Float.parseFloat(string4));
                return;
            }
            catch (NumberFormatException var21_32) {
                fp.d("Could not parse volume parameter from volume video GMSG: " + string4);
                return;
            }
        }
        if ("watermark".equals(string)) {
            p4.f();
            return;
        }
        fp.d("Unknown video action: " + string);
    }
}

