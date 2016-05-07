/*
 * Decompiled with CFR 0_115.
 */
package android.support.design.widget;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.FloatingActionButton$Behavior;
import android.support.design.widget.bu;
import android.support.design.widget.bw;
import android.support.v4.h.bo;
import android.view.View;

class aa
implements bw {
    final /* synthetic */ FloatingActionButton a;
    final /* synthetic */ FloatingActionButton$Behavior b;

    aa(FloatingActionButton$Behavior floatingActionButton$Behavior, FloatingActionButton floatingActionButton) {
        this.b = floatingActionButton$Behavior;
        this.a = floatingActionButton;
    }

    @Override
    public void a(bu bu2) {
        bo.b((View)this.a, bu2.d());
    }
}

