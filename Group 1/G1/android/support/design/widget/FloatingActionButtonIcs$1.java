package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class FloatingActionButtonIcs$1 extends AnimatorListenerAdapter {
    private boolean mCancelled;
    final /* synthetic */ FloatingActionButtonIcs this$0;
    final /* synthetic */ boolean val$fromUser;
    final /* synthetic */ InternalVisibilityChangedListener val$listener;
    
    FloatingActionButtonIcs$1(final FloatingActionButtonIcs this$0, final boolean val$fromUser, final InternalVisibilityChangedListener val$listener) {
        this$0 = this$0;
        val$fromUser = val$fromUser;
        val$listener = val$listener;
        super();
    }
    
    public void onAnimationCancel(final Animator animator) {
        FloatingActionButtonIcs.access$002(this$0, false);
        mCancelled = true;
    }
    
    public void onAnimationEnd(final Animator animator) {
        FloatingActionButtonIcs.access$002(this$0, false);
        if (!mCancelled) {
            this$0.mView.internalSetVisibility(8, val$fromUser);
            if (val$listener != null) {
                val$listener.onHidden();
            }
        }
    }
    
    public void onAnimationStart(final Animator animator) {
        FloatingActionButtonIcs.access$002(this$0, true);
        mCancelled = false;
        this$0.mView.internalSetVisibility(0, val$fromUser);
    }
}