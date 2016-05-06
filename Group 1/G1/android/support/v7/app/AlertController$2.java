package android.support.v7.app;

import android.view.View;
import android.support.v4.widget.NestedScrollView;

class AlertController$2 implements OnScrollChangeListener {
    final /* synthetic */ AlertController this$0;
    final /* synthetic */ View val$bottom;
    final /* synthetic */ View val$top;
    
    AlertController$2(final AlertController this$0, final View val$top, final View val$bottom) {
        this$0 = this$0;
        val$top = val$top;
        val$bottom = val$bottom;
        super();
    }
    
    @Override
    public void onScrollChange(final NestedScrollView nestedScrollView, final int n, final int n2, final int n3, final int n4) {
        AlertController.access$800((View)nestedScrollView, val$top, val$bottom);
    }
}