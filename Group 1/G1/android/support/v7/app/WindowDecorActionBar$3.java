package android.support.v7.app;

import android.view.View;
import android.support.v4.view.ViewPropertyAnimatorUpdateListener;

class WindowDecorActionBar$3 implements ViewPropertyAnimatorUpdateListener {
    final /* synthetic */ WindowDecorActionBar this$0;
    
    WindowDecorActionBar$3(final WindowDecorActionBar this$0) {
        this$0 = this$0;
        super();
    }
    
    @Override
    public void onAnimationUpdate(final View view) {
        ((View)WindowDecorActionBar.access$200(this$0).getParent()).invalidate();
    }
}