/*
 * Decompiled with CFR 0_115.
 */
package xyz;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.bs;
import android.support.v4.app.dh;
import android.support.v7.a.ax;
import android.text.TextUtils;
import com.google.android.gms.location.e;
import com.google.android.gms.location.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import xyz.a;
import xyz.c;
import xyz.d;
import xyz.g;
import xyz.lpsdt5r;

public class z1flnjcn
extends IntentService {
    private static final String a = c.a("LCTbCjy7o3dzYM9nw7d9hzHsW1VW7w/zGlWi7b65vtY=");
    private g b;

    public z1flnjcn() {
        super(a);
    }

    public z1flnjcn(String string) {
        super(string);
    }

    private void a(a a2) {
        String string = (String)a2.a(0);
        String string2 = (String)a2.a(1);
        Intent intent = new Intent(this.getApplicationContext(), (Class)lpsdt5r.class);
        dh dh2 = dh.a((Context)this);
        dh2.a(lpsdt5r.class);
        dh2.a(intent);
        if (string == null) throw new NullPointerException();
        try {
            this.d(new a(string, string2, dh2.a(0, 134217728)));
            return;
        }
        catch (NullPointerException var8_6) {
            this.d(new a(string, string2, dh2.a(0, 268435456)));
            return;
        }
    }

    /*
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    private String b(a var1_1) {
        var2_2 = (Integer)var1_1.a(0);
        var3_3 = (List)var1_1.a(1);
        var4_4 = this.c(new a(var2_2));
        var5_5 = new ArrayList<String>();
        if (var4_4 != null) throw new NullPointerException();
        try {
            var12_6 = var3_3.iterator();
lbl8: // 2 sources:
            if (var12_6.hasNext() == false) return TextUtils.join((CharSequence)c.a("OPZpgFYXVkz2oDnfEih9lg=="), var5_5);
            var13_7 = (e)var12_6.next();
            var14_8 = var3_3.iterator();
            ** GOTO lbl14
        }
        catch (NullPointerException var6_15) {
            ** GOTO lbl27
lbl14: // 1 sources:
            do {
                if (!var14_8.hasNext()) ** GOTO lbl8
                var15_9 = (e)var14_8.next();
                var16_10 = new a(Integer.parseInt(var13_7.a()));
                var17_11 = this.b.c(var16_10);
                var18_12 = new a(Integer.parseInt(var15_9.a()));
                var19_13 = this.b.c(var18_12);
                try {
                    if (var17_11.a() == var19_13.a()) throw new NullPointerException();
                    var17_11.b(new a(Integer.parseInt(var13_7.a())));
                }
                catch (NullPointerException var20_14) {}
            } while (true);
lbl27: // 1 sources:
            var7_16 = var3_3.iterator();
            while (var7_16.hasNext() != false) {
                var8_17 = new a(Integer.parseInt(((e)var7_16.next()).a()));
                var9_18 = this.b.c(var8_17);
                if (var9_18 == null) throw new NullPointerException();
                try {
                    if (var9_18.a() == null) throw new NullPointerException();
                    if (var9_18.a().equals(c.a("UGHOf8CxL3tl/UklIVcwng==")) != false) throw new NullPointerException();
                    var5_5.add(var9_18.a());
                }
                catch (NullPointerException var10_19) {}
            }
            return TextUtils.join((CharSequence)c.a("OPZpgFYXVkz2oDnfEih9lg=="), var5_5);
        }
    }

    private String c(a a2) {
        switch ((Integer)a2.a(0)) {
            default: {
                return "What is happening?";
            }
            case 1: {
                return c.a("gXWDOwOJTPtejCKYd+xO3A==");
            }
            case 2: {
                return c.a("nhcS2OLcs466gR2ECT09DjaWXfPQVSufaDpUgGWJqEo=");
            }
            case 4: {
                return c.a("EqjDf47V37sFOy5pwmldxdHONI/vwrNRVvDVZuk9/L0=");
            }
            case -1: 
        }
        return c.a("SF5BrFYgR/XTvH6t4N8uHG8ePmanNhS1xNHzn7FPj+Y=");
    }

    private void d(a a2) {
        String string = (String)a2.a(0);
        String string2 = (String)a2.a(1);
        PendingIntent pendingIntent = (PendingIntent)a2.a(2);
        ax ax2 = new ax((Context)this);
        ax2.a(2130837638).a(string).b(string2).a(pendingIntent);
        ax2.a(true);
        ((NotificationManager)this.getSystemService("notification")).notify(0, ax2.a());
    }

    public void onCreate() {
        super.onCreate();
        this.b = new g((Context)this);
    }

    /*
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    protected void onHandleIntent(Intent intent) {
        h h2 = h.a(intent);
        try {
            if (!h2.a()) throw new NullPointerException();
            return;
        }
        catch (NullPointerException var3_3) {
            block9 : {
                int n2 = h2.b();
                double d2 = n2;
                try {
                    double d3 = Math.pow(d2, 2.0);
                    if (d3 <= 0.0) break block9;
                    if (n2 != 1) throw new NullPointerException();
                }
                catch (NullPointerException var7_8) {
                    if (n2 != 4) throw new NullPointerException();
                    try {
                        String string = this.b(new a(n2, h2.c()));
                        this.a(new a(this.c(new a(n2)), string));
                        return;
                    }
                    catch (NullPointerException var8_11) {
                        return;
                    }
                }
                String string = this.b(new a(n2, h2.c()));
                this.a(new a(this.c(new a(n2)), string));
                return;
                {
                    catch (NullPointerException nullPointerException) {
                        return;
                    }
                }
            }
            throw new NullPointerException();
        }
    }
}

