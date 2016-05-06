package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class FloatingActionButtonIcs$2 extends AnimatorListenerAdapter {
    final /* synthetic */ FloatingActionButtonIcs this$0;
    final /* synthetic */ boolean val$fromUser;
    final /* synthetic */ InternalVisibilityChangedListener val$listener;
    
    FloatingActionButtonIcs$2(final FloatingActionButtonIcs this$0, final boolean val$fromUser, final InternalVisibilityChangedListener val$listener) {
        this$0 = this$0;
        val$fromUser = val$fromUser;
        val$listener = val$listener;
        super();
    }
    
    public void onAnimationEnd(final Animator animator) {
        if (val$listener != null) {
            val$listener.onShown();
        }
    }
    
    public void onAnimationStart(final Animator animator) {
        this$0.mView.internalSetVisibility(0, val$fromUser);
    }
}