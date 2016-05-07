/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.stats;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Debug;
import android.os.Parcelable;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.b.je;
import com.google.android.gms.b.ke;
import com.google.android.gms.b.ko;
import com.google.android.gms.common.stats.ConnectionEvent;
import com.google.android.gms.common.stats.d;
import com.google.android.gms.common.stats.f;
import com.google.android.gms.common.stats.g;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class b {
    private static final Object a = new Object();
    private static b b;
    private static Integer h;
    private final List c;
    private final List d;
    private final List e;
    private final List f;
    private g g;
    private g i;

    private b() {
        if (b.c() == f.b) {
            this.c = Collections.EMPTY_LIST;
            this.d = Collections.EMPTY_LIST;
            this.e = Collections.EMPTY_LIST;
            this.f = Collections.EMPTY_LIST;
            return;
        }
        String string = (String)d.b.c();
        List<String> list = string == null ? Collections.EMPTY_LIST : Arrays.asList(string.split(","));
        this.c = list;
        String string2 = (String)d.c.c();
        List<String> list2 = string2 == null ? Collections.EMPTY_LIST : Arrays.asList(string2.split(","));
        this.d = list2;
        String string3 = (String)d.d.c();
        List<String> list3 = string3 == null ? Collections.EMPTY_LIST : Arrays.asList(string3.split(","));
        this.e = list3;
        String string4 = (String)d.e.c();
        List<String> list4 = string4 == null ? Collections.EMPTY_LIST : Arrays.asList(string4.split(","));
        this.f = list4;
        this.g = new g(1024, (Long)d.f.c());
        this.i = new g(1024, (Long)d.f.c());
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public static b a() {
        Object object = a;
        // MONITORENTER : object
        if (b == null) {
            b = new b();
        }
        // MONITOREXIT : object
        return b;
    }

    private String a(ServiceConnection serviceConnection) {
        return String.valueOf((long)Process.myPid() << 32 | (long)System.identityHashCode((Object)serviceConnection));
    }

    private void a(Context context, String string, int n2, String string2, String string3, String string4, String string5) {
        long l2 = System.currentTimeMillis();
        int n3 = b.c() & f.f;
        String string6 = null;
        if (n3 != 0) {
            string6 = null;
            if (n2 != 13) {
                string6 = ko.a(3, 5);
            }
        }
        long l3 = 0;
        if ((b.c() & f.h) != 0) {
            l3 = Debug.getNativeHeapAllocatedSize();
        }
        ConnectionEvent connectionEvent = n2 == 1 || n2 == 4 || n2 == 14 ? new ConnectionEvent(l2, n2, null, null, null, null, string6, string, SystemClock.elapsedRealtime(), l3) : new ConnectionEvent(l2, n2, string2, string3, string4, string5, string6, string, SystemClock.elapsedRealtime(), l3);
        context.startService(new Intent().setComponent(f.a).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", (Parcelable)connectionEvent));
    }

    private void a(Context context, String string, String string2, Intent intent, int n2) {
        String string3;
        String string4;
        String string5 = null;
        if (!this.b()) return;
        if (this.g == null) {
            return;
        }
        if (n2 == 4 || n2 == 1) {
            if (!this.g.b(string)) return;
            string4 = null;
            string3 = null;
        } else {
            ServiceInfo serviceInfo = b.b(context, intent);
            if (serviceInfo == null) {
                Object[] arrobject = new Object[]{string2, intent.toUri(0)};
                Log.w((String)"ConnectionTracker", (String)String.format("Client %s made an invalid request %s", arrobject));
                return;
            }
            string3 = serviceInfo.processName;
            string4 = serviceInfo.name;
            string5 = ko.a(context);
            if (!this.a(string5, string2, string3, string4)) return;
            this.g.a(string);
        }
        this.a(context, string, n2, string5, string2, string3, string4);
    }

    private boolean a(Context context, Intent intent) {
        ComponentName componentName = intent.getComponent();
        if (componentName == null) return false;
        if (!com.google.android.gms.common.internal.f.a) return ke.a(context, componentName.getPackageName());
        if (!"com.google.android.gms".equals(componentName.getPackageName())) return ke.a(context, componentName.getPackageName());
        return false;
    }

    private boolean a(String string, String string2, String string3, String string4) {
        int n2 = b.c();
        if (this.c.contains(string)) return false;
        if (this.d.contains(string2)) return false;
        if (this.e.contains(string3)) return false;
        if (this.f.contains(string4)) return false;
        if (!string3.equals(string)) return true;
        if ((n2 & f.g) == 0) return true;
        return false;
    }

    private static ServiceInfo b(Context context, Intent intent) {
        List list = context.getPackageManager().queryIntentServices(intent, 128);
        if (list != null && list.size() != 0) {
            if (list.size() <= 1) return ((ResolveInfo)list.get((int)0)).serviceInfo;
            Object[] arrobject = new Object[]{intent.toUri(0), ko.a(3, 20)};
            Log.w((String)"ConnectionTracker", (String)String.format("Multiple handlers found for this intent: %s\n Stack trace: %s", arrobject));
            Iterator iterator = list.iterator();
            if (!iterator.hasNext()) return ((ResolveInfo)list.get((int)0)).serviceInfo;
            Log.w((String)"ConnectionTracker", (String)((ResolveInfo)iterator.next()).serviceInfo.name);
            return null;
        }
        Object[] arrobject = new Object[]{intent.toUri(0), ko.a(3, 20)};
        Log.w((String)"ConnectionTracker", (String)String.format("There are no handler of this intent: %s\n Stack trace: %s", arrobject));
        return null;
    }

    private boolean b() {
        if (!com.google.android.gms.common.internal.f.a) {
            return false;
        }
        if (b.c() == f.b) return false;
        return true;
    }

    private static int c() {
        if (h != null) return h;
        try {
            int n2 = ke.a() ? (Integer)d.a.c() : f.b;
            h = n2;
        }
        catch (SecurityException var0_1) {
            h = f.b;
            return h;
        }
        return h;
    }

    @SuppressLint(value={"UntrackedBindService"})
    public void a(Context context, ServiceConnection serviceConnection) {
        context.unbindService(serviceConnection);
        this.a(context, this.a(serviceConnection), (String)null, (Intent)null, 1);
    }

    public void a(Context context, ServiceConnection serviceConnection, String string, Intent intent) {
        this.a(context, this.a(serviceConnection), string, intent, 3);
    }

    public boolean a(Context context, Intent intent, ServiceConnection serviceConnection, int n2) {
        return this.a(context, context.getClass().getName(), intent, serviceConnection, n2);
    }

    @SuppressLint(value={"UntrackedBindService"})
    public boolean a(Context context, String string, Intent intent, ServiceConnection serviceConnection, int n2) {
        if (this.a(context, intent)) {
            Log.w((String)"ConnectionTracker", (String)"Attempted to bind to a service in a STOPPED package.");
            return false;
        }
        boolean bl2 = context.bindService(intent, serviceConnection, n2);
        if (!bl2) return bl2;
        this.a(context, this.a(serviceConnection), string, intent, 2);
        return bl2;
    }

    public void b(Context context, ServiceConnection serviceConnection) {
        this.a(context, this.a(serviceConnection), (String)null, (Intent)null, 4);
    }
}

