package android.support.v4.app;

import android.view.animation.Animation;
import android.view.View;

class FragmentManagerImpl$5 extends AnimateOnHWLayerIfNeededListener {
    final /* synthetic */ FragmentManagerImpl this$0;
    final /* synthetic */ Fragment val$fragment;
    
    FragmentManagerImpl$5(final FragmentManagerImpl this$0, final View view, final Animation animation, final Fragment val$fragment) {
        this$0 = this$0;
        val$fragment = val$fragment;
        super(view, animation);
    }
    
    @Override
    public void onAnimationEnd(final Animation animation) {
        super.onAnimationEnd(animation);
        if (val$fragment.mAnimatingAway != null) {
            val$fragment.mAnimatingAway = null;
            this$0.moveToState(val$fragment, val$fragment.mStateAfterAnimating, 0, 0, false);
        }
    }
}