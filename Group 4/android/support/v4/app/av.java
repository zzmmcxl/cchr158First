/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.app;

import android.graphics.Rect;
import android.transition.Transition;

final class av
extends Transition.EpicenterCallback {
    final /* synthetic */ Rect a;

    av(Rect rect) {
        this.a = rect;
    }

    public Rect onGetEpicenter(Transition transition) {
        return this.a;
    }
}

