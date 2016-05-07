/*
 * Decompiled with CFR 0_115.
 */
package android.support.design.widget;

import android.os.Parcel;
import android.support.design.widget.AppBarLayout$Behavior$SavedState;

final class f
implements android.support.v4.e.f {
    f() {
    }

    public AppBarLayout$Behavior$SavedState a(Parcel parcel, ClassLoader classLoader) {
        return new AppBarLayout$Behavior$SavedState(parcel, classLoader);
    }

    public AppBarLayout$Behavior$SavedState[] a(int n2) {
        return new AppBarLayout$Behavior$SavedState[n2];
    }

    @Override
    public /* synthetic */ Object b(Parcel parcel, ClassLoader classLoader) {
        return this.a(parcel, classLoader);
    }

    @Override
    public /* synthetic */ Object[] b(int n2) {
        return this.a(n2);
    }
}

