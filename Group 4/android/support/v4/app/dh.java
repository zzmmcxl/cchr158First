/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.app;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.bf;
import android.support.v4.app.di;
import android.support.v4.app.dj;
import android.support.v4.app.dk;
import android.support.v4.app.dl;
import android.support.v4.b.c;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

public final class dh
implements Iterable {
    private static final dj a;
    private final ArrayList b = new ArrayList();
    private final Context c;

    static {
        if (Build.VERSION.SDK_INT >= 11) {
            a = new dl();
            return;
        }
        a = new dk();
    }

    private dh(Context context) {
        this.c = context;
    }

    public static dh a(Context context) {
        return new dh(context);
    }

    public PendingIntent a(int n2, int n3) {
        return this.a(n2, n3, null);
    }

    public PendingIntent a(int n2, int n3, Bundle bundle) {
        if (this.b.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot getPendingIntent");
        }
        Intent[] arrintent = this.b.toArray((T[])new Intent[this.b.size()]);
        arrintent[0] = new Intent(arrintent[0]).addFlags(268484608);
        return a.a(this.c, arrintent, n2, n3, bundle);
    }

    public dh a(Activity activity) {
        boolean bl2 = activity instanceof di;
        Intent intent = null;
        Intent intent2 = !bl2 || (intent = ((di)activity).a()) == null ? bf.a(activity) : intent;
        if (intent2 == null) return this;
        ComponentName componentName = intent2.getComponent();
        if (componentName == null) {
            componentName = intent2.resolveActivity(this.c.getPackageManager());
        }
        this.a(componentName);
        this.a(intent2);
        return this;
    }

    public dh a(ComponentName componentName) {
        int n2 = this.b.size();
        try {
            Intent intent = bf.a(this.c, componentName);
            while (intent != null) {
                Intent intent2;
                this.b.add(n2, intent);
                intent = intent2 = bf.a(this.c, intent.getComponent());
            }
            return this;
        }
        catch (PackageManager.NameNotFoundException var3_5) {
            Log.e((String)"TaskStackBuilder", (String)"Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException((Throwable)var3_5);
        }
    }

    public dh a(Intent intent) {
        this.b.add(intent);
        return this;
    }

    public dh a(Class class_) {
        return this.a(new ComponentName(this.c, class_));
    }

    public void a() {
        this.a((Bundle)null);
    }

    public void a(Bundle bundle) {
        if (this.b.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        Intent[] arrintent = this.b.toArray((T[])new Intent[this.b.size()]);
        arrintent[0] = new Intent(arrintent[0]).addFlags(268484608);
        if (c.a(this.c, arrintent, bundle)) return;
        Intent intent = new Intent(arrintent[-1 + arrintent.length]);
        intent.addFlags(268435456);
        this.c.startActivity(intent);
    }

    public Iterator iterator() {
        return this.b.iterator();
    }
}

