/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.PowerManager;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.b.je;
import com.google.android.gms.b.kn;
import com.google.android.gms.b.kp;
import com.google.android.gms.b.kq;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.common.stats.i;
import com.google.android.gms.common.stats.k;
import java.util.List;

public class md {
    private static String a = "WakeLock";
    private static String b = "*gcore*:";
    private static boolean c = false;
    private final PowerManager.WakeLock d;
    private WorkSource e;
    private final int f;
    private final String g;
    private final String h;
    private final Context i;
    private boolean j;
    private int k;
    private int l;

    public md(Context context, int n2, String string) {
        String string2 = context == null ? null : context.getPackageName();
        this(context, n2, string, null, string2);
    }

    @SuppressLint(value={"UnwrappedWakeLock"})
    public md(Context context, int n2, String string, String string2, String string3) {
        this.j = true;
        bf.a(string, (Object)"Wake lock name can NOT be empty");
        this.f = n2;
        this.h = string2;
        this.i = context.getApplicationContext();
        this.g = !kp.a(string3) && "com.google.android.gms" != string3 ? b + string : string;
        this.d = ((PowerManager)context.getSystemService("power")).newWakeLock(n2, string);
        if (!kq.a(this.i)) return;
        if (kp.a(string3)) {
            if (f.a && je.b()) {
                Log.e((String)a, (String)("callingPackage is not supposed to be empty for wakelock " + this.g + "!"), (Throwable)new IllegalArgumentException());
                string3 = "com.google.android.gms";
            } else {
                string3 = context.getPackageName();
            }
        }
        this.e = kq.a(context, string3);
        this.a(this.e);
    }

    private String a(String string, boolean bl2) {
        if (!this.j) return this.h;
        if (!bl2) return this.h;
        return string;
    }

    /*
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    private void a(String var1_1) {
        var2_2 = this.b(var1_1);
        var3_3 = this.a(var1_1, var2_2);
        if (md.c) {
            Log.d((String)md.a, (String)("Release:\n mWakeLockName: " + this.g + "\n mSecondaryName: " + this.h + "\nmReferenceCounted: " + this.j + "\nreason: " + var1_1 + "\n mOpenEventCount" + this.l + "\nuseWithReason: " + var2_2 + "\ntrackingName: " + var3_3));
        }
        // MONITORENTER : this
        if (!this.j) ** GOTO lbl9
        this.k = var5_4 = -1 + this.k;
        if (var5_4 == 0 || var2_2) ** GOTO lbl-1000
lbl9: // 2 sources:
        if (!this.j && this.l == 1) lbl-1000: // 2 sources:
        {
            k.a().a(this.i, i.a(this.d, var3_3), 8, this.g, var3_3, this.f, kq.b(this.e));
            this.l = -1 + this.l;
        }
        // MONITOREXIT : this
    }

    /*
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    private void a(String var1_1, long var2_2) {
        var4_3 = this.b(var1_1);
        var5_4 = this.a(var1_1, var4_3);
        if (md.c) {
            Log.d((String)md.a, (String)("Acquire:\n mWakeLockName: " + this.g + "\n mSecondaryName: " + this.h + "\nmReferenceCounted: " + this.j + "\nreason: " + var1_1 + "\nmOpenEventCount" + this.l + "\nuseWithReason: " + var4_3 + "\ntrackingName: " + var5_4 + "\ntimeout: " + var2_2));
        }
        // MONITORENTER : this
        if (!this.j) ** GOTO lbl10
        var7_5 = this.k;
        this.k = var7_5 + 1;
        if (var7_5 == 0 || var4_3) ** GOTO lbl-1000
lbl10: // 2 sources:
        if (!this.j && this.l == 0) lbl-1000: // 2 sources:
        {
            k.a().a(this.i, i.a(this.d, var5_4), 7, this.g, var5_4, this.f, kq.b(this.e), var2_2);
            this.l = 1 + this.l;
        }
        // MONITOREXIT : this
    }

    private boolean b(String string) {
        if (TextUtils.isEmpty((CharSequence)string)) return false;
        if (string.equals(this.h)) return false;
        return true;
    }

    public void a() {
        this.a((String)null);
        this.d.release();
    }

    public void a(long l2) {
        if (!kn.c() && this.j) {
            Log.wtf((String)a, (String)("Do not acquire with timeout on reference counted WakeLocks before ICS. wakelock: " + this.g));
        }
        this.a(null, l2);
        this.d.acquire(l2);
    }

    public void a(WorkSource workSource) {
        if (!kq.a(this.i)) return;
        if (workSource == null) return;
        if (this.e != null) {
            this.e.add(workSource);
        } else {
            this.e = workSource;
        }
        this.d.setWorkSource(this.e);
    }

    public void a(boolean bl2) {
        this.d.setReferenceCounted(bl2);
        this.j = bl2;
    }

    public boolean b() {
        return this.d.isHeld();
    }
}

