/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.a;

import android.app.UiModeManager;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.a.ab;
import android.support.v7.a.bm;
import android.support.v7.a.v;
import android.support.v7.a.z;
import android.util.DisplayMetrics;
import android.view.Window;

class aa
extends z {
    private static bm r;
    private int s = -100;
    private boolean t;
    private boolean u = true;

    aa(Context context, Window window, v v2) {
        super(context, window, v2);
    }

    private int c(int n2) {
        int n3 = 2;
        switch (n2) {
            default: {
                n3 = 1;
            }
            case 2: {
                return n3;
            }
            case 0: {
                if (!this.s().a()) return 1;
                return n3;
            }
            case -1: 
        }
        switch (((UiModeManager)this.a.getSystemService("uimode")).getNightMode()) {
            case 2: {
                return n3;
            }
            default: {
                return 1;
            }
            case 0: 
        }
        return 0;
    }

    private boolean d(int n2) {
        int n3;
        Resources resources = this.a.getResources();
        Configuration configuration = resources.getConfiguration();
        int n4 = 48 & configuration.uiMode;
        switch (n2) {
            default: {
                n3 = 0;
                break;
            }
            case 1: {
                n3 = 16;
                break;
            }
            case 2: {
                n3 = 32;
            }
        }
        boolean bl2 = false;
        if (n4 == n3) return bl2;
        configuration.uiMode = n3 | -49 & configuration.uiMode;
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        return true;
    }

    private int r() {
        int n2;
        if (this.s == -100) {
            n2 = aa.i();
            return this.c(n2);
        }
        n2 = this.s;
        return this.c(n2);
    }

    private bm s() {
        if (r != null) return r;
        r = new bm(this.a.getApplicationContext());
        return r;
    }

    @Override
    Window.Callback a(Window.Callback callback) {
        return new ab(this, callback);
    }

    @Override
    public void a(Bundle bundle) {
        super.a(bundle);
        if (bundle == null) return;
        if (this.s != -100) return;
        this.s = bundle.getInt("appcompat:local_night_mode", -100);
    }

    @Override
    public void c(Bundle bundle) {
        super.c(bundle);
        if (this.s == -100) return;
        bundle.putInt("appcompat:local_night_mode", this.s);
    }

    @Override
    public boolean h() {
        this.t = true;
        return this.d(this.r());
    }

    @Override
    public boolean m() {
        return this.u;
    }
}

