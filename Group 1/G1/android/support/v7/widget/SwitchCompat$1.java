package android.support.v7.widget;

import android.view.animation.Animation;
import android.view.animation.Animation$AnimationListener;

class SwitchCompat$1 implements Animation$AnimationListener {
    final /* synthetic */ SwitchCompat this$0;
    final /* synthetic */ boolean val$newCheckedState;
    
    SwitchCompat$1(final SwitchCompat this$0, final boolean val$newCheckedState) {
        this$0 = this$0;
        val$newCheckedState = val$newCheckedState;
        super();
    }
    
    public void onAnimationEnd(final Animation animation) {
        if (SwitchCompat.access$100(this$0) == animation) {
            final SwitchCompat this$0 = this.this$0;
            float n;
            if (val$newCheckedState) {
                n = 1.0f;
            }
            else {
                n = 0.0f;
            }
            SwitchCompat.access$200(this$0, n);
            SwitchCompat.access$102(this.this$0, null);
        }
    }
    
    public void onAnimationRepeat(final Animation animation) {
    }
    
    public void onAnimationStart(final Animation animation) {
    }
}