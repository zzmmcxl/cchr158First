package android.support.v4.app;

import android.support.v4.util.ArrayMap;
import java.util.Map;
import java.util.ArrayList;
import android.view.View;
import android.view.ViewTreeObserver$OnPreDrawListener;

class BackStackRecord$2 implements ViewTreeObserver$OnPreDrawListener {
    final /* synthetic */ BackStackRecord this$0;
    final /* synthetic */ Fragment val$inFragment;
    final /* synthetic */ boolean val$isBack;
    final /* synthetic */ Fragment val$outFragment;
    final /* synthetic */ View val$sceneRoot;
    final /* synthetic */ ArrayList val$sharedElementTargets;
    final /* synthetic */ Object val$sharedElementTransition;
    final /* synthetic */ TransitionState val$state;
    
    BackStackRecord$2(final BackStackRecord this$0, final View val$sceneRoot, final Object val$sharedElementTransition, final ArrayList val$sharedElementTargets, final TransitionState val$state, final boolean val$isBack, final Fragment val$inFragment, final Fragment val$outFragment) {
        this$0 = this$0;
        val$sceneRoot = val$sceneRoot;
        val$sharedElementTransition = val$sharedElementTransition;
        val$sharedElementTargets = val$sharedElementTargets;
        val$state = val$state;
        val$isBack = val$isBack;
        val$inFragment = val$inFragment;
        val$outFragment = val$outFragment;
        super();
    }
    
    public boolean onPreDraw() {
        val$sceneRoot.getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver$OnPreDrawListener)this);
        if (val$sharedElementTransition != null) {
            FragmentTransitionCompat21.removeTargets(val$sharedElementTransition, val$sharedElementTargets);
            val$sharedElementTargets.clear();
            final ArrayMap access$000 = BackStackRecord.access$000(this$0, val$state, val$isBack, val$inFragment);
            FragmentTransitionCompat21.setSharedElementTargets(val$sharedElementTransition, val$state.nonExistentView, access$000, val$sharedElementTargets);
            BackStackRecord.access$100(this$0, access$000, val$state);
            BackStackRecord.access$200(this$0, val$state, val$inFragment, val$outFragment, val$isBack, access$000);
        }
        return true;
    }
}