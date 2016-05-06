package android.support.v7.app;

import android.support.v7.view.ViewPropertyAnimatorCompatSet;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;

class WindowDecorActionBar$1 extends ViewPropertyAnimatorListenerAdapter {
    final /* synthetic */ WindowDecorActionBar this$0;
    
    WindowDecorActionBar$1(final WindowDecorActionBar this$0) {
        this$0 = this$0;
        super();
    }
    
    @Override
    public void onAnimationEnd(final View view) {
        if (WindowDecorActionBar.access$000(this$0) && WindowDecorActionBar.access$100(this$0) != null) {
            ViewCompat.setTranslationY(WindowDecorActionBar.access$100(this$0), 0.0f);
            ViewCompat.setTranslationY((View)WindowDecorActionBar.access$200(this$0), 0.0f);
        }
        WindowDecorActionBar.access$200(this$0).setVisibility(8);
        WindowDecorActionBar.access$200(this$0).setTransitioning(false);
        WindowDecorActionBar.access$302(this$0, null);
        this$0.completeDeferredDestroyActionMode();
        if (WindowDecorActionBar.access$400(this$0) != null) {
            ViewCompat.requestApplyInsets((View)WindowDecorActionBar.access$400(this$0));
        }
    }
}