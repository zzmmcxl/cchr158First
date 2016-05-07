/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.bn;
import android.support.v4.app.bt;
import android.support.v4.app.ce;
import android.widget.RemoteViews;
import java.util.ArrayList;

public class bs {
    Notification A;
    public Notification B = new Notification();
    public ArrayList C;
    public Context a;
    public CharSequence b;
    public CharSequence c;
    PendingIntent d;
    PendingIntent e;
    RemoteViews f;
    public Bitmap g;
    public CharSequence h;
    public int i;
    int j;
    boolean k = true;
    public boolean l;
    public ce m;
    public CharSequence n;
    int o;
    int p;
    boolean q;
    String r;
    boolean s;
    String t;
    public ArrayList u = new ArrayList();
    boolean v = false;
    String w;
    Bundle x;
    int y = 0;
    int z = 0;

    public bs(Context context) {
        this.a = context;
        this.B.when = System.currentTimeMillis();
        this.B.audioStreamType = -1;
        this.j = 0;
        this.C = new ArrayList();
    }

    private void a(int n2, boolean bl2) {
        if (bl2) {
            Notification notification = this.B;
            notification.flags = n2 | notification.flags;
            return;
        }
        Notification notification = this.B;
        notification.flags &= ~ n2;
    }

    protected static CharSequence c(CharSequence charSequence) {
        if (charSequence == null) {
            return charSequence;
        }
        if (charSequence.length() <= 5120) return charSequence;
        return charSequence.subSequence(0, 5120);
    }

    public Notification a() {
        return bn.a().a(this, this.b());
    }

    public bs a(int n2) {
        this.B.icon = n2;
        return this;
    }

    public bs a(PendingIntent pendingIntent) {
        this.d = pendingIntent;
        return this;
    }

    public bs a(CharSequence charSequence) {
        this.b = bs.c(charSequence);
        return this;
    }

    public bs a(boolean bl2) {
        this.a(16, bl2);
        return this;
    }

    public bs b(CharSequence charSequence) {
        this.c = bs.c(charSequence);
        return this;
    }

    protected bt b() {
        return new bt();
    }
}

