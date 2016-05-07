/*
 * Decompiled with CFR 0_115.
 */
package android.support.design.widget;

import android.os.Parcel;
import android.support.design.widget.CoordinatorLayout$SavedState;
import android.support.v4.e.f;

final class v
implements f {
    v() {
    }

    public CoordinatorLayout$SavedState a(Parcel parcel, ClassLoader classLoader) {
        return new CoordinatorLayout$SavedState(parcel, classLoader);
    }

    public CoordinatorLayout$SavedState[] a(int n2) {
        return new CoordinatorLayout$SavedState[n2];
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

