/*
 * Decompiled with CFR 0_115.
 */
package xyz;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.List;
import xyz.d;

public class a {
    List a = new ArrayList();

    public a(double d2, double d3, double d4, double d5) {
        this.a.add(d2);
        this.a.add(d3);
        this.a.add(d4);
        this.a.add(d5);
    }

    public a(int n2) {
        this.a.add(n2);
    }

    public a(int n2, double d2, double d3) {
        this.a.add(n2);
        this.a.add(d2);
        this.a.add(d3);
    }

    public a(int n2, int n3, int n4, int n5, SharedPreferences.Editor editor) {
        this.a.add(n2);
        this.a.add(n3);
        this.a.add(n4);
        this.a.add(n5);
        this.a.add(editor);
    }

    public a(int n2, List list) {
        this.a.add(n2);
        this.a.add(list);
    }

    public a(Intent intent) {
        this.a.add(intent);
    }

    public a(String string) {
        this.a.add(string);
    }

    public a(String string, String string2) {
        this.a.add(string);
        this.a.add(string2);
    }

    public a(String string, String string2, PendingIntent pendingIntent) {
        this.a.add(string);
        this.a.add(string2);
        this.a.add(pendingIntent);
    }

    public a(d d2) {
        this.a.add(d2);
    }

    public Object a(int n2) {
        return this.a.get(n2);
    }
}

