package android.support.design.widget;

import android.view.View;

class Snackbar$5 implements OnAttachStateChangeListener {
    final /* synthetic */ Snackbar this$0;
    
    Snackbar$5(final Snackbar this$0) {
        this$0 = this$0;
        super();
    }
    
    @Override
    public void onViewAttachedToWindow(final View view) {
    }
    
    @Override
    public void onViewDetachedFromWindow(final View view) {
        if (this$0.isShownOrQueued()) {
            Snackbar.access$100().post((Runnable)new Runnable() {
                final /* synthetic */ Snackbar$5 this$1;
                
                Snackbar$5$1() {
                    this$1 = this$1;
                    super();
                }
                
                @Override
                public void run() {
                    Snackbar.access$300(this$0, 3);
                }
            });
        }
    }
}