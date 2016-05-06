package android.support.design.widget;

import android.view.animation.Animation;
import android.view.animation.Animation$AnimationListener;

class StateListAnimator$1 implements Animation$AnimationListener {
    final /* synthetic */ StateListAnimator this$0;
    
    StateListAnimator$1(final StateListAnimator this$0) {
        this$0 = this$0;
        super();
    }
    
    public void onAnimationEnd(final Animation animation) {
        if (StateListAnimator.access$000(this$0) == animation) {
            StateListAnimator.access$002(this$0, null);
        }
    }
    
    public void onAnimationRepeat(final Animation animation) {
    }
    
    public void onAnimationStart(final Animation animation) {
    }
}