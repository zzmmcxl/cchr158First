package android.support.v4.app;

import android.view.View;
import android.view.ViewTreeObserver$OnPreDrawListener;

class BackStackRecord$3 implements ViewTreeObserver$OnPreDrawListener {
    final /* synthetic */ BackStackRecord this$0;
    final /* synthetic */ int val$containerId;
    final /* synthetic */ View val$sceneRoot;
    final /* synthetic */ TransitionState val$state;
    final /* synthetic */ Object val$transition;
    
    BackStackRecord$3(final BackStackRecord this$0, final View val$sceneRoot, final TransitionState val$state, final int val$containerId, final Object val$transition) {
        this$0 = this$0;
        val$sceneRoot = val$sceneRoot;
        val$state = val$state;
        val$containerId = val$containerId;
        val$transition = val$transition;
        super();
    }
    
    public boolean onPreDraw() {
        val$sceneRoot.getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver$OnPreDrawListener)this);
        BackStackRecord.access$300(this$0, val$state, val$containerId, val$transition);
        return true;
    }
}