package android.support.v7.widget;

import android.view.View;
import android.support.v4.view.ViewCompat;

class ActionBarOverlayLayout$2 implements Runnable {
    final /* synthetic */ ActionBarOverlayLayout this$0;
    
    ActionBarOverlayLayout$2(final ActionBarOverlayLayout this$0) {
        this$0 = this$0;
        super();
    }
    
    @Override
    public void run() {
        ActionBarOverlayLayout.access$200(this$0);
        ActionBarOverlayLayout.access$002(this$0, ViewCompat.animate((View)ActionBarOverlayLayout.access$400(this$0)).translationY(0.0f).setListener(ActionBarOverlayLayout.access$300(this$0)));
    }
}