/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.ads;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.internal.util.client.b;
import com.google.android.gms.b.eh;
import com.google.android.gms.b.ej;

public class AdActivity
extends Activity {
    private ej a;

    private void a() {
        if (this.a == null) return;
        try {
            this.a.l();
            return;
        }
        catch (RemoteException var1_1) {
            b.c("Could not forward setContentViewSet to ad overlay:", (Throwable)var1_1);
            return;
        }
    }

    public void onBackPressed() {
        boolean bl2 = true;
        try {
            if (this.a != null) {
                boolean bl3;
                bl2 = bl3 = this.a.e();
            }
        }
        catch (RemoteException var2_3) {
            b.c("Could not forward onBackPressed to ad overlay:", (Throwable)var2_3);
        }
        if (!bl2) return;
        super.onBackPressed();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = eh.a(this);
        if (this.a == null) {
            b.d("Could not create ad overlay.");
            this.finish();
            return;
        }
        try {
            this.a.a(bundle);
            return;
        }
        catch (RemoteException var2_2) {
            b.c("Could not forward onCreate to ad overlay:", (Throwable)var2_2);
            this.finish();
            return;
        }
    }

    protected void onDestroy() {
        try {
            if (this.a != null) {
                this.a.k();
            }
        }
        catch (RemoteException var1_1) {
            b.c("Could not forward onDestroy to ad overlay:", (Throwable)var1_1);
        }
        super.onDestroy();
    }

    protected void onPause() {
        try {
            if (this.a != null) {
                this.a.i();
            }
        }
        catch (RemoteException var1_1) {
            b.c("Could not forward onPause to ad overlay:", (Throwable)var1_1);
            this.finish();
        }
        super.onPause();
    }

    protected void onRestart() {
        super.onRestart();
        try {
            if (this.a == null) return;
            this.a.f();
            return;
        }
        catch (RemoteException var1_1) {
            b.c("Could not forward onRestart to ad overlay:", (Throwable)var1_1);
            this.finish();
            return;
        }
    }

    protected void onResume() {
        super.onResume();
        try {
            if (this.a == null) return;
            this.a.h();
            return;
        }
        catch (RemoteException var1_1) {
            b.c("Could not forward onResume to ad overlay:", (Throwable)var1_1);
            this.finish();
            return;
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        try {
            if (this.a != null) {
                this.a.b(bundle);
            }
        }
        catch (RemoteException var2_2) {
            b.c("Could not forward onSaveInstanceState to ad overlay:", (Throwable)var2_2);
            this.finish();
        }
        super.onSaveInstanceState(bundle);
    }

    protected void onStart() {
        super.onStart();
        try {
            if (this.a == null) return;
            this.a.g();
            return;
        }
        catch (RemoteException var1_1) {
            b.c("Could not forward onStart to ad overlay:", (Throwable)var1_1);
            this.finish();
            return;
        }
    }

    protected void onStop() {
        try {
            if (this.a != null) {
                this.a.j();
            }
        }
        catch (RemoteException var1_1) {
            b.c("Could not forward onStop to ad overlay:", (Throwable)var1_1);
            this.finish();
        }
        super.onStop();
    }

    public void setContentView(int n2) {
        super.setContentView(n2);
        this.a();
    }

    public void setContentView(View view) {
        super.setContentView(view);
        this.a();
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        this.a();
    }
}

