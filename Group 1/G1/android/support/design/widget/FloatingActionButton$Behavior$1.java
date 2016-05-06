package android.support.design.widget;

import android.view.View;
import android.support.v4.view.ViewCompat;

class FloatingActionButton$Behavior$1 implements AnimatorUpdateListener {
    final /* synthetic */ Behavior this$0;
    final /* synthetic */ FloatingActionButton val$fab;
    
    FloatingActionButton$Behavior$1(final Behavior this$0, final FloatingActionButton val$fab) {
        this$0 = this$0;
        val$fab = val$fab;
        super();
    }
    
    @Override
    public void onAnimationUpdate(final ValueAnimatorCompat valueAnimatorCompat) {
        ViewCompat.setTranslationY((View)val$fab, valueAnimatorCompat.getAnimatedFloatValue());
    }
}