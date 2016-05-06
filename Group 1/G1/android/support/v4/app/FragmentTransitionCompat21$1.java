package android.support.v4.app;

import android.transition.Transition;
import android.graphics.Rect;
import android.transition.Transition$EpicenterCallback;

static final class FragmentTransitionCompat21$1 extends Transition$EpicenterCallback {
    final /* synthetic */ Rect val$epicenter;
    
    FragmentTransitionCompat21$1(final Rect val$epicenter) {
        this.val$epicenter = val$epicenter;
        super();
    }
    
    public Rect onGetEpicenter(final Transition transition) {
        return val$epicenter;
    }
}