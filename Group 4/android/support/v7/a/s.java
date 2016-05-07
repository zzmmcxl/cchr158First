/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.a.as;
import android.support.v7.a.e;
import android.support.v7.b.b;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.Window;

public class s
extends as
implements DialogInterface {
    private e a;

    s(Context context, int n2, boolean bl2) {
        super(context, s.a(context, n2));
        this.a = new e(this.getContext(), this, this.getWindow());
    }

    static int a(Context context, int n2) {
        if (n2 >= 16777216) {
            return n2;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(b.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    static /* synthetic */ e a(s s2) {
        return s2.a;
    }

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a.a();
    }

    public boolean onKeyDown(int n2, KeyEvent keyEvent) {
        if (!this.a.a(n2, keyEvent)) return super.onKeyDown(n2, keyEvent);
        return true;
    }

    public boolean onKeyUp(int n2, KeyEvent keyEvent) {
        if (!this.a.b(n2, keyEvent)) return super.onKeyUp(n2, keyEvent);
        return true;
    }

    @Override
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.a.a(charSequence);
    }
}

