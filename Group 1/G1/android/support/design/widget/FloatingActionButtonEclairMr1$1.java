package android.support.design.widget;

import android.view.animation.Animation;

class FloatingActionButtonEclairMr1$1 extends AnimationListenerAdapter {
    final /* synthetic */ FloatingActionButtonEclairMr1 this$0;
    final /* synthetic */ boolean val$fromUser;
    final /* synthetic */ InternalVisibilityChangedListener val$listener;
    
    FloatingActionButtonEclairMr1$1(final FloatingActionButtonEclairMr1 this$0, final boolean val$fromUser, final InternalVisibilityChangedListener val$listener) {
        this$0 = this$0;
        val$fromUser = val$fromUser;
        val$listener = val$listener;
        super();
    }
    
    @Override
    public void onAnimationEnd(final Animation animation) {
        FloatingActionButtonEclairMr1.access$202(this$0, false);
        this$0.mView.internalSetVisibility(8, val$fromUser);
        if (val$listener != null) {
            val$listener.onHidden();
        }
    }
    
    @Override
    public void onAnimationStart(final Animation animation) {
        FloatingActionButtonEclairMr1.access$202(this$0, true);
    }
}