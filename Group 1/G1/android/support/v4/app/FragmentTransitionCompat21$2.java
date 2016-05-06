package android.support.v4.app;

import java.util.Iterator;
import java.util.Collection;
import java.util.Map;
import java.util.ArrayList;
import android.transition.Transition;
import android.view.View;
import android.view.ViewTreeObserver$OnPreDrawListener;

static final class FragmentTransitionCompat21$2 implements ViewTreeObserver$OnPreDrawListener {
    final /* synthetic */ View val$container;
    final /* synthetic */ Transition val$enterTransition;
    final /* synthetic */ ArrayList val$enteringViews;
    final /* synthetic */ ViewRetriever val$inFragment;
    final /* synthetic */ Map val$nameOverrides;
    final /* synthetic */ View val$nonExistentView;
    final /* synthetic */ Map val$renamedViews;
    
    FragmentTransitionCompat21$2(final View val$container, final Transition val$enterTransition, final View val$nonExistentView, final ViewRetriever val$inFragment, final Map val$nameOverrides, final Map val$renamedViews, final ArrayList val$enteringViews) {
        this.val$container = val$container;
        this.val$enterTransition = val$enterTransition;
        this.val$nonExistentView = val$nonExistentView;
        this.val$inFragment = val$inFragment;
        this.val$nameOverrides = val$nameOverrides;
        this.val$renamedViews = val$renamedViews;
        this.val$enteringViews = val$enteringViews;
        super();
    }
    
    public boolean onPreDraw() {
        val$container.getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver$OnPreDrawListener)this);
        if (val$enterTransition != null) {
            val$enterTransition.removeTarget(val$nonExistentView);
        }
        final View view = val$inFragment.getView();
        if (view != null) {
            if (!val$nameOverrides.isEmpty()) {
                FragmentTransitionCompat21.findNamedViews(val$renamedViews, view);
                val$renamedViews.keySet().retainAll(val$nameOverrides.values());
                for (final Map.Entry<K, String> entry : val$nameOverrides.entrySet()) {
                    final View view2 = (View)val$renamedViews.get(entry.getValue());
                    if (view2 != null) {
                        view2.setTransitionName((String)entry.getKey());
                    }
                }
            }
            if (val$enterTransition != null) {
                FragmentTransitionCompat21.access$000(val$enteringViews, view);
                val$enteringViews.removeAll(val$renamedViews.values());
                val$enteringViews.add(val$nonExistentView);
                FragmentTransitionCompat21.addTargets(val$enterTransition, val$enteringViews);
            }
        }
        return true;
    }
}