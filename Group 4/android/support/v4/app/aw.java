/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.app;

import android.support.v4.app.au;
import android.support.v4.app.ba;
import android.transition.Transition;
import android.view.View;
import android.view.ViewTreeObserver;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

final class aw
implements ViewTreeObserver.OnPreDrawListener {
    final /* synthetic */ View a;
    final /* synthetic */ Transition b;
    final /* synthetic */ View c;
    final /* synthetic */ ba d;
    final /* synthetic */ Map e;
    final /* synthetic */ Map f;
    final /* synthetic */ ArrayList g;

    aw(View view, Transition transition, View view2, ba ba2, Map map, Map map2, ArrayList arrayList) {
        this.a = view;
        this.b = transition;
        this.c = view2;
        this.d = ba2;
        this.e = map;
        this.f = map2;
        this.g = arrayList;
    }

    public boolean onPreDraw() {
        View view;
        this.a.getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this);
        if (this.b != null) {
            this.b.removeTarget(this.c);
        }
        if ((view = this.d.a()) == null) return true;
        if (!this.e.isEmpty()) {
            au.a(this.f, view);
            this.f.keySet().retainAll(this.e.values());
            for (Map.Entry entry : this.e.entrySet()) {
                String string = (String)entry.getValue();
                View view2 = (View)this.f.get(string);
                if (view2 == null) continue;
                view2.setTransitionName((String)entry.getKey());
            }
        }
        if (this.b == null) return true;
        au.a(this.g, view);
        this.g.removeAll(this.f.values());
        this.g.add(this.c);
        au.b((Object)this.b, this.g);
        return true;
    }
}

