package android.support.v4.app;

import android.transition.Transition;
import android.graphics.Rect;
import android.transition.Transition$EpicenterCallback;

static final class FragmentTransitionCompat21$3 extends Transition$EpicenterCallback {
    private Rect mEpicenter;
    final /* synthetic */ EpicenterView val$epicenterView;
    
    FragmentTransitionCompat21$3(final EpicenterView val$epicenterView) {
        this.val$epicenterView = val$epicenterView;
        super();
    }
    
    public Rect onGetEpicenter(final Transition transition) {
        if (mEpicenter == null && val$epicenterView.epicenter != null) {
            mEpicenter = FragmentTransitionCompat21.access$100(val$epicenterView.epicenter);
        }
        return mEpicenter;
    }
}