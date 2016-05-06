package android.support.design.widget;

import android.view.animation.Animation;

class FloatingActionButtonEclairMr1$2 extends AnimationListenerAdapter {
    final /* synthetic */ FloatingActionButtonEclairMr1 this$0;
    final /* synthetic */ InternalVisibilityChangedListener val$listener;
    
    FloatingActionButtonEclairMr1$2(final FloatingActionButtonEclairMr1 this$0, final InternalVisibilityChangedListener val$listener) {
        this$0 = this$0;
        val$listener = val$listener;
        super();
    }
    
    @Override
    public void onAnimationEnd(final Animation animation) {
        if (val$listener != null) {
            val$listener.onShown();
        }
    }
}