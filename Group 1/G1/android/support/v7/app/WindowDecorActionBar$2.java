package android.support.v7.app;

import android.support.v7.view.ViewPropertyAnimatorCompatSet;
import android.view.View;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;

class WindowDecorActionBar$2 extends ViewPropertyAnimatorListenerAdapter {
    final /* synthetic */ WindowDecorActionBar this$0;
    
    WindowDecorActionBar$2(final WindowDecorActionBar this$0) {
        this$0 = this$0;
        super();
    }
    
    @Override
    public void onAnimationEnd(final View view) {
        WindowDecorActionBar.access$302(this$0, null);
        WindowDecorActionBar.access$200(this$0).requestLayout();
    }
}