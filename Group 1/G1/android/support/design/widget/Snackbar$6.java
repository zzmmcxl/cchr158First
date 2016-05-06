package android.support.design.widget;

import android.view.View;

class Snackbar$6 implements OnLayoutChangeListener {
    final /* synthetic */ Snackbar this$0;
    
    Snackbar$6(final Snackbar this$0) {
        this$0 = this$0;
        super();
    }
    
    @Override
    public void onLayoutChange(final View view, final int n, final int n2, final int n3, final int n4) {
        Snackbar.access$400(this$0);
        Snackbar.access$500(this$0).setOnLayoutChangeListener(null);
    }
}