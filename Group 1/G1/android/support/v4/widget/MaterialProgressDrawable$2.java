package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Animation$AnimationListener;

class MaterialProgressDrawable$2 implements Animation$AnimationListener {
    final /* synthetic */ MaterialProgressDrawable this$0;
    final /* synthetic */ Ring val$ring;
    
    MaterialProgressDrawable$2(final MaterialProgressDrawable this$0, final Ring val$ring) {
        this$0 = this$0;
        val$ring = val$ring;
        super();
    }
    
    public void onAnimationEnd(final Animation animation) {
    }
    
    public void onAnimationRepeat(final Animation animation) {
        val$ring.storeOriginals();
        val$ring.goToNextColor();
        val$ring.setStartTrim(val$ring.getEndTrim());
        if (mFinishing) {
            mFinishing = false;
            animation.setDuration(1332L);
            val$ring.setShowArrow(false);
            return;
        }
        MaterialProgressDrawable.access$402(this$0, (1.0f + MaterialProgressDrawable.access$400(this$0)) % 5.0f);
    }
    
    public void onAnimationStart(final Animation animation) {
        MaterialProgressDrawable.access$402(this$0, 0.0f);
    }
}