/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.aa;
import android.support.v4.app.ag;
import android.support.v4.app.ah;
import android.support.v4.app.at;
import android.support.v4.app.x;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewParent;
import android.view.Window;

public class w
extends x
implements DialogInterface.OnCancelListener,
DialogInterface.OnDismissListener {
    int a = 0;
    int b = 0;
    boolean c = true;
    boolean d = true;
    int e = -1;
    Dialog f;
    boolean g;
    boolean h;
    boolean i;

    public int a() {
        return this.b;
    }

    @Override
    public void a(Activity activity) {
        super.a(activity);
        if (this.i) return;
        this.h = false;
    }

    public void a(Dialog dialog, int n2) {
        switch (n2) {
            default: {
                return;
            }
            case 3: {
                dialog.getWindow().addFlags(24);
            }
            case 1: 
            case 2: 
        }
        dialog.requestWindowFeature(1);
    }

    @Override
    public void a(Bundle bundle) {
        super.a(bundle);
        boolean bl2 = this.G == 0;
        this.d = bl2;
        if (bundle == null) return;
        this.a = bundle.getInt("android:style", 0);
        this.b = bundle.getInt("android:theme", 0);
        this.c = bundle.getBoolean("android:cancelable", true);
        this.d = bundle.getBoolean("android:showsDialog", this.d);
        this.e = bundle.getInt("android:backStackId", -1);
    }

    public void a(ah ah2, String string) {
        this.h = false;
        this.i = true;
        at at2 = ah2.a();
        at2.a(this, string);
        at2.a();
    }

    void a(boolean bl2) {
        if (this.h) {
            return;
        }
        this.h = true;
        this.i = false;
        if (this.f != null) {
            this.f.dismiss();
            this.f = null;
        }
        this.g = true;
        if (this.e >= 0) {
            this.i().a(this.e, 1);
            this.e = -1;
            return;
        }
        at at2 = this.i().a();
        at2.a(this);
        if (bl2) {
            at2.b();
            return;
        }
        at2.a();
    }

    @Override
    public LayoutInflater b(Bundle bundle) {
        if (!this.d) {
            return super.b(bundle);
        }
        this.f = this.c(bundle);
        if (this.f == null) return (LayoutInflater)this.C.g().getSystemService("layout_inflater");
        this.a(this.f, this.a);
        return (LayoutInflater)this.f.getContext().getSystemService("layout_inflater");
    }

    @Override
    public void b() {
        super.b();
        if (this.i) return;
        if (this.h) return;
        this.h = true;
    }

    public void b(boolean bl2) {
        this.d = bl2;
    }

    public Dialog c(Bundle bundle) {
        return new Dialog((Context)this.g(), this.a());
    }

    @Override
    public void c() {
        super.c();
        if (this.f == null) return;
        this.g = false;
        this.f.show();
    }

    @Override
    public void d() {
        super.d();
        if (this.f == null) return;
        this.f.hide();
    }

    @Override
    public void d(Bundle bundle) {
        super.d(bundle);
        if (!this.d) {
            return;
        }
        View view = this.n();
        if (view != null) {
            if (view.getParent() != null) {
                throw new IllegalStateException("DialogFragment can not be attached to a container view");
            }
            this.f.setContentView(view);
        }
        this.f.setOwnerActivity((Activity)this.g());
        this.f.setCancelable(this.c);
        this.f.setOnCancelListener((DialogInterface.OnCancelListener)this);
        this.f.setOnDismissListener((DialogInterface.OnDismissListener)this);
        if (bundle == null) return;
        Bundle bundle2 = bundle.getBundle("android:savedDialogState");
        if (bundle2 == null) return;
        this.f.onRestoreInstanceState(bundle2);
    }

    @Override
    public void e() {
        super.e();
        if (this.f == null) return;
        this.g = true;
        this.f.dismiss();
        this.f = null;
    }

    @Override
    public void e(Bundle bundle) {
        Bundle bundle2;
        super.e(bundle);
        if (this.f != null && (bundle2 = this.f.onSaveInstanceState()) != null) {
            bundle.putBundle("android:savedDialogState", bundle2);
        }
        if (this.a != 0) {
            bundle.putInt("android:style", this.a);
        }
        if (this.b != 0) {
            bundle.putInt("android:theme", this.b);
        }
        if (!this.c) {
            bundle.putBoolean("android:cancelable", this.c);
        }
        if (!this.d) {
            bundle.putBoolean("android:showsDialog", this.d);
        }
        if (this.e == -1) return;
        bundle.putInt("android:backStackId", this.e);
    }

    public void onCancel(DialogInterface dialogInterface) {
    }

    public void onDismiss(DialogInterface dialogInterface) {
        if (this.g) return;
        this.a(true);
    }
}

