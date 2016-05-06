package android.support.v4.app;

import java.util.Iterator;
import java.util.Map;
import android.view.View;
import java.util.ArrayList;
import android.transition.Transition;
import android.view.ViewTreeObserver$OnPreDrawListener;

static final class FragmentTransitionCompat21$4 implements ViewTreeObserver$OnPreDrawListener {
    final /* synthetic */ Transition val$enterTransition;
    final /* synthetic */ ArrayList val$enteringViews;
    final /* synthetic */ Transition val$exitTransition;
    final /* synthetic */ ArrayList val$exitingViews;
    final /* synthetic */ ArrayList val$hiddenViews;
    final /* synthetic */ View val$nonExistentView;
    final /* synthetic */ Transition val$overallTransition;
    final /* synthetic */ Map val$renamedViews;
    final /* synthetic */ View val$sceneRoot;
    final /* synthetic */ ArrayList val$sharedElementTargets;
    final /* synthetic */ Transition val$sharedElementTransition;
    
    FragmentTransitionCompat21$4(final View val$sceneRoot, final Transition val$enterTransition, final ArrayList val$enteringViews, final Transition val$exitTransition, final ArrayList val$exitingViews, final Transition val$sharedElementTransition, final ArrayList val$sharedElementTargets, final Map val$renamedViews, final ArrayList val$hiddenViews, final Transition val$overallTransition, final View val$nonExistentView) {
        this.val$sceneRoot = val$sceneRoot;
        this.val$enterTransition = val$enterTransition;
        this.val$enteringViews = val$enteringViews;
        this.val$exitTransition = val$exitTransition;
        this.val$exitingViews = val$exitingViews;
        this.val$sharedElementTransition = val$sharedElementTransition;
        this.val$sharedElementTargets = val$sharedElementTargets;
        this.val$renamedViews = val$renamedViews;
        this.val$hiddenViews = val$hiddenViews;
        this.val$overallTransition = val$overallTransition;
        this.val$nonExistentView = val$nonExistentView;
        super();
    }
    
    public boolean onPreDraw() {
        val$sceneRoot.getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver$OnPreDrawListener)this);
        if (val$enterTransition != null) {
            FragmentTransitionCompat21.removeTargets(val$enterTransition, val$enteringViews);
        }
        if (val$exitTransition != null) {
            FragmentTransitionCompat21.removeTargets(val$exitTransition, val$exitingViews);
        }
        if (val$sharedElementTransition != null) {
            FragmentTransitionCompat21.removeTargets(val$sharedElementTransition, val$sharedElementTargets);
        }
        for (final Map.Entry<K, View> entry : val$renamedViews.entrySet()) {
            ((View)entry.getValue()).setTransitionName((String)entry.getKey());
        }
        for (int size = val$hiddenViews.size(), i = 0; i < size; ++i) {
            val$overallTransition.excludeTarget((View)val$hiddenViews.get(i), false);
        }
        val$overallTransition.excludeTarget(val$nonExistentView, false);
        return true;
    }
}