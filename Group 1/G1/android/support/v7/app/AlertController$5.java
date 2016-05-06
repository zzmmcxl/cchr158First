package android.support.v7.app;

import android.view.View;

class AlertController$5 implements Runnable {
    final /* synthetic */ AlertController this$0;
    final /* synthetic */ View val$bottom;
    final /* synthetic */ View val$top;
    
    AlertController$5(final AlertController this$0, final View val$top, final View val$bottom) {
        this$0 = this$0;
        val$top = val$top;
        val$bottom = val$bottom;
        super();
    }
    
    @Override
    public void run() {
        AlertController.access$800((View)AlertController.access$1000(this$0), val$top, val$bottom);
    }
}