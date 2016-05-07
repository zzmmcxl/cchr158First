/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.app;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.c;

final class b
implements Runnable {
    final /* synthetic */ String[] a;
    final /* synthetic */ Activity b;
    final /* synthetic */ int c;

    b(String[] arrstring, Activity activity, int n2) {
        this.a = arrstring;
        this.b = activity;
        this.c = n2;
    }

    @Override
    public void run() {
        int[] arrn = new int[this.a.length];
        PackageManager packageManager = this.b.getPackageManager();
        String string = this.b.getPackageName();
        int n2 = this.a.length;
        int n3 = 0;
        do {
            if (n3 >= n2) {
                ((c)this.b).onRequestPermissionsResult(this.c, this.a, arrn);
                return;
            }
            arrn[n3] = packageManager.checkPermission(this.a[n3], string);
            ++n3;
        } while (true);
    }
}

