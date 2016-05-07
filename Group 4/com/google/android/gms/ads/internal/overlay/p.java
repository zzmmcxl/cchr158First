/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.gms.ads.internal.b;
import com.google.android.gms.ads.internal.overlay.m;
import com.google.android.gms.ads.internal.overlay.n;
import com.google.android.gms.ads.internal.overlay.o;
import com.google.android.gms.ads.internal.overlay.w;
import com.google.android.gms.b.av;
import com.google.android.gms.b.az;
import com.google.android.gms.b.fi;
import com.google.android.gms.b.hb;
import com.google.android.gms.common.internal.d;
import java.util.HashMap;
import java.util.Map;

@fi
public class p
extends FrameLayout
implements m {
    private final hb a;
    private final FrameLayout b;
    private final w c;
    private n d;
    private boolean e;
    private boolean f;
    private TextView g;
    private long h;
    private String i;
    private String j;

    public p(Context context, hb hb2, int n2, az az2, av av2) {
        super(context);
        this.a = hb2;
        this.b = new FrameLayout(context);
        this.addView((View)this.b, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
        d.a(hb2.g());
        this.d = hb2.g().b.a(context, hb2, n2, az2, av2);
        if (this.d != null) {
            this.b.addView((View)this.d, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1, 17));
        }
        this.g = new TextView(context);
        this.g.setBackgroundColor(-16777216);
        this.i();
        this.c = new w(this);
        this.c.b();
        if (this.d != null) {
            this.d.a(this);
        }
        if (this.d != null) return;
        this.a("AdVideoUnderlay Error", "Allocating player failed.");
    }

    public static void a(hb hb2) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("event", "no_video_view");
        hb2.a("onVideoEvent", hashMap);
    }

    private /* varargs */ void a(String string, String ... arrstring) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("event", string);
        int n2 = arrstring.length;
        int n3 = 0;
        String string2 = null;
        do {
            if (n3 >= n2) {
                this.a.a("onVideoEvent", hashMap);
                return;
            }
            String string3 = arrstring[n3];
            if (string2 != null) {
                hashMap.put(string2, string3);
                string3 = null;
            }
            ++n3;
            string2 = string3;
        } while (true);
    }

    private void i() {
        if (this.k()) return;
        this.b.addView((View)this.g, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
        this.b.bringChildToFront((View)this.g);
    }

    private void j() {
        if (!this.k()) return;
        this.b.removeView((View)this.g);
    }

    private boolean k() {
        if (this.g.getParent() == null) return false;
        return true;
    }

    private void l() {
        if (this.a.e() == null) {
            return;
        }
        if (!this.e) return;
        if (this.f) return;
        this.a.e().getWindow().clearFlags(128);
        this.e = false;
    }

    public void a() {
        if (this.d == null) {
            return;
        }
        if (!TextUtils.isEmpty((CharSequence)this.j)) {
            this.d.setMimeType(this.i);
            this.d.setVideoPath(this.j);
            return;
        }
        this.a("no_src", new String[0]);
    }

    public void a(float f2) {
        if (this.d == null) {
            return;
        }
        this.d.a(f2);
    }

    public void a(int n2) {
        if (this.d == null) {
            return;
        }
        this.d.a(n2);
    }

    public void a(int n2, int n3, int n4, int n5) {
        if (n4 == 0) return;
        if (n5 == 0) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(n4 + 2, n5 + 2);
        layoutParams.setMargins(n2 - 1, n3 - 1, 0, 0);
        this.b.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
        this.requestLayout();
    }

    public void a(MotionEvent motionEvent) {
        if (this.d == null) {
            return;
        }
        this.d.dispatchTouchEvent(motionEvent);
    }

    public void a(String string) {
        this.j = string;
    }

    public void a(String string, String string2) {
        this.a("error", "what", string, "extra", string2);
    }

    public void b() {
        if (this.d == null) {
            return;
        }
        this.d.d();
    }

    public void c() {
        if (this.d == null) {
            return;
        }
        this.d.b();
    }

    public void d() {
        if (this.d == null) {
            return;
        }
        this.d.e();
    }

    public void e() {
        if (this.d == null) {
            return;
        }
        this.d.f();
    }

    public void f() {
        if (this.d == null) {
            return;
        }
        TextView textView = new TextView(this.d.getContext());
        textView.setText((CharSequence)("AdMob - " + this.d.a()));
        textView.setTextColor(-65536);
        textView.setBackgroundColor(-256);
        this.b.addView((View)textView, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-2, -2, 17));
        this.b.bringChildToFront((View)textView);
    }

    public void g() {
        this.c.a();
        if (this.d != null) {
            this.d.c();
        }
        this.l();
    }

    void h() {
        if (this.d == null) {
            return;
        }
        long l2 = this.d.getCurrentPosition();
        if (this.h == l2) return;
        if (l2 <= 0) return;
        this.j();
        float f2 = (float)l2 / 1000.0f;
        String[] arrstring = new String[]{"time", String.valueOf(f2)};
        this.a("timeupdate", arrstring);
        this.h = l2;
    }

    public void setMimeType(String string) {
        this.i = string;
    }
}

