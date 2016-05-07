/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.app;

import android.support.v4.app.au;
import android.transition.Transition;
import android.view.View;
import android.view.ViewTreeObserver;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

final class ay
implements ViewTreeObserver.OnPreDrawListener {
    final /* synthetic */ View a;
    final /* synthetic */ Transition b;
    final /* synthetic */ ArrayList c;
    final /* synthetic */ Transition d;
    final /* synthetic */ ArrayList e;
    final /* synthetic */ Transition f;
    final /* synthetic */ ArrayList g;
    final /* synthetic */ Map h;
    final /* synthetic */ ArrayList i;
    final /* synthetic */ Transition j;
    final /* synthetic */ View k;

    ay(View view, Transition transition, ArrayList arrayList, Transition transition2, ArrayList arrayList2, Transition transition3, ArrayList arrayList3, Map map, ArrayList arrayList4, Transition transition4, View view2) {
        this.a = view;
        this.b = transition;
        this.c = arrayList;
        this.d = transition2;
        this.e = arrayList2;
        this.f = transition3;
        this.g = arrayList3;
        this.h = map;
        this.i = arrayList4;
        this.j = transition4;
        this.k = view2;
    }

    public boolean onPreDraw() {
        this.a.getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this);
        if (this.b != null) {
            au.a((Object)this.b, this.c);
        }
        if (this.d != null) {
            au.a((Object)this.d, this.e);
        }
        if (this.f != null) {
            au.a((Object)this.f, this.g);
        }
        for (Map.Entry entry : this.h.entrySet()) {
            ((View)entry.getValue()).setTransitionName((String)entry.getKey());
        }
        int n2 = this.i.size();
        int n3 = 0;
        do {
            if (n3 >= n2) {
                this.j.excludeTarget(this.k, false);
                return true;
            }
            this.j.excludeTarget((View)this.i.get(n3), false);
            ++n3;
        } while (true);
    }
}

