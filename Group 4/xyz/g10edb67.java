/*
 * Decompiled with CFR 0_115.
 */
package xyz;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Address;
import android.location.Geocoder;
import android.os.IBinder;
import android.support.v4.app.bs;
import android.support.v4.app.dh;
import android.support.v7.a.ax;
import com.google.android.gms.maps.model.LatLng;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import xyz.a;
import xyz.c;
import xyz.lpsdt5r;

public class g10edb67
extends Service {
    Map a = new HashMap();
    SharedPreferences b;
    private double c = 12.32;
    private double d = 44.56;
    private String e = c.a("2Rz65JfgxrWkNiyzrLNXXg==");
    private int f = 86400;

    public static double a(a a2) {
        double d2 = (Double)a2.a(0);
        double d3 = (Double)a2.a(1);
        double d4 = (Double)a2.a(2);
        double d5 = (Double)a2.a(3);
        Double d6 = Math.toRadians(d3 - d2);
        Double d7 = Math.toRadians(d5 - d4);
        Double d8 = g10edb67.b(new a(d6, d7, d2, d3));
        return Math.sqrt(Math.pow(1000.0 * (6371.0 * Double.valueOf(2.0 * Math.atan2(Math.sqrt(d8), Math.sqrt(1.0 - d8)))), 2.0) + Math.pow(0.0, 2.0));
    }

    public static double b(a a2) {
        double d2 = (Double)a2.a(0);
        double d3 = (Double)a2.a(1);
        double d4 = (Double)a2.a(2);
        double d5 = (Double)a2.a(3);
        return Math.sin(d2 / 2.0) * Math.sin(d2 / 2.0) + Math.cos(Math.toRadians(d4)) * Math.cos(Math.toRadians(d5)) * Math.sin(d3 / 2.0) * Math.sin(d3 / 2.0);
    }

    private PendingIntent c() {
        Intent intent = new Intent(this.getApplicationContext(), (Class)lpsdt5r.class);
        dh dh2 = dh.a((Context)this);
        dh2.a(lpsdt5r.class);
        dh2.a(intent);
        return dh2.a(0, 134217728);
    }

    private void c(a a2) {
        this.d(new a(((Intent)a2.a(0)).getStringExtra(c.a("IPiWepEfrJlYCoZghsy/iA=="))));
        this.b();
        this.a();
    }

    private void d(a a2) {
        String string = (String)a2.a(0);
        Geocoder geocoder = new Geocoder((Context)this);
        try {
            Address address = (Address)geocoder.getFromLocationName(string, 1).get(0);
            this.c = address.getLatitude();
            this.d = address.getLongitude();
            return;
        }
        catch (Exception var4_5) {
            return;
        }
    }

    private void e(a a2) {
        int n2 = (Integer)a2.a(0);
        int n3 = (Integer)a2.a(1);
        int n4 = (Integer)a2.a(2);
        int n5 = (Integer)a2.a(3);
        SharedPreferences.Editor editor = (SharedPreferences.Editor)a2.a(4);
        int n6 = n2 - n3;
        try {
            if (n6 > this.f) throw new NullPointerException();
            this.f(new a(c.a("IS89sxBwBfF9We1Giuh7rA=="), c.a("RmLwroN3lPTLmT9xyFymlRjrZ05YfezhfTl+qeEisiRQYc5/wLEve2X9SSUhVzCe")));
            editor.putInt(c.a("ZQ9xa+4xIps3FoC89ue0xA=="), 0).apply();
            editor.putInt(c.a("kR1ZvIo9H9uhmlpJJ12UNw=="), 0).apply();
            editor.putInt(c.a("u4O97ebp2+O0uUI1sFoQyA=="), 0).apply();
            return;
        }
        catch (NullPointerException var8_8) {
            editor.putInt(c.a("ZQ9xa+4xIps3FoC89ue0xA=="), n4).apply();
            editor.putInt(c.a("kR1ZvIo9H9uhmlpJJ12UNw=="), n5).apply();
            editor.putInt(c.a("u4O97ebp2+O0uUI1sFoQyA=="), n2).apply();
            return;
        }
    }

    private void f(a a2) {
        String string = (String)a2.a(0);
        String string2 = (String)a2.a(1);
        ax ax2 = new ax((Context)this);
        ax2.a(2130837638).a(string).b(string2).a(this.c());
        ax2.a(true);
        ((NotificationManager)this.getSystemService("notification")).notify(0, ax2.a());
    }

    public void a() {
        String string = c.a("MAsNJL4Cjil82eDFrsW+OQ==");
        Iterator iterator = this.a.keySet().iterator();
        double d2 = Double.MAX_VALUE;
        String string2 = string;
        while (iterator.hasNext()) {
            String string3;
            double d3;
            String string4 = (String)iterator.next();
            LatLng latLng = (LatLng)this.a.get(string4);
            double d4 = g10edb67.a(new a(this.c, latLng.a, this.d, latLng.b));
            if (d4 < d2) {
                string3 = string4;
                d3 = d4;
            } else {
                try {
                    throw new NullPointerException();
                }
                catch (NullPointerException var12_8) {
                    d3 = d2;
                    string3 = string2;
                }
            }
            d2 = d3;
            string2 = string3;
        }
        int n2 = 1 + this.b.getInt(string2, 0);
        this.b.edit().putInt(string2, n2).apply();
        if (n2 % 5 != 0) throw new NullPointerException();
        try {
            this.f(new a(c.a("IS89sxBwBfF9We1Giuh7rA=="), c.a("hNZCvS1v7lQxettpsbbM+A==") + Integer.toString(n2) + c.a("2kIMOW37VdW9UPOzxaqU3g==") + string2 + c.a("B2Obz4ywnyE0sd8RynHJBg==")));
            return;
        }
        catch (NullPointerException var7_12) {
            return;
        }
    }

    public void b() {
        int n2 = Calendar.getInstance().get(13);
        int n3 = this.b.getInt(c.a("ZQ9xa+4xIps3FoC89ue0xA=="), 0);
        int n4 = this.b.getInt(c.a("kR1ZvIo9H9uhmlpJJ12UNw=="), 0);
        int n5 = this.b.getInt(c.a("u4O97ebp2+O0uUI1sFoQyA=="), 0);
        SharedPreferences.Editor editor = this.b.edit();
        if (n3 != 0) throw new NullPointerException();
        try {
            editor.putInt(c.a("ZQ9xa+4xIps3FoC89ue0xA=="), n2).apply();
            return;
        }
        catch (NullPointerException var6_6) {
            if (n4 != 0) throw new NullPointerException();
            try {
                editor.putInt(c.a("kR1ZvIo9H9uhmlpJJ12UNw=="), n2).apply();
                return;
            }
            catch (NullPointerException var7_7) {
                if (n5 != 0) throw new NullPointerException();
                try {
                    editor.putInt(c.a("u4O97ebp2+O0uUI1sFoQyA=="), n2).apply();
                    this.e(new a(n2, n3, n4, n5, editor));
                    return;
                }
                catch (NullPointerException var8_8) {
                    this.e(new a(n2, n3, n4, n5, editor));
                    return;
                }
            }
        }
    }

    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException(c.a("hJ+P0OD3pPj3/Gmqjj4Hq38SUXCQha8NNzZEOW2Q88A="));
    }

    public void onCreate() {
        this.b = this.getSharedPreferences(c.a("cSL48qR7eZD8Q2AlLTAD0Im5bKk3e1nFWjGVbfTFU7o="), 0);
        this.a.put(c.a("r+8acMKp6CH0KEEo8T8X6A=="), new LatLng(25.27, 133.77));
        this.a.put(c.a("uAfZ4cavUH2qrE0WpAw+1Q=="), new LatLng(34.04, 100.62));
        this.a.put(c.a("rRkRrizXnlj+QVUVVQzbFA=="), new LatLng(8.78, 37.5));
        this.a.put(c.a("Cptoy8faqkZq/giLI6bv3A=="), new LatLng(54.52, 15.25));
        this.a.put(c.a("mIG2SCdMDALBSkWngtIbRA=="), new LatLng(37.09, 95.71));
    }

    public int onStartCommand(Intent intent, int n2, int n3) {
        this.c(new a(intent));
        return super.onStartCommand(intent, n2, n3);
    }

    public void onTaskRemoved(Intent intent) {
        super.onTaskRemoved(intent);
        this.stopSelf();
    }
}

