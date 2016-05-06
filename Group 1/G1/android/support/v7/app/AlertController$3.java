package android.support.v7.app;

import android.view.View;

class AlertController$3 implements Runnable {
    final /* synthetic */ AlertController this$0;
    final /* synthetic */ View val$bottom;
    final /* synthetic */ View val$top;
    
    AlertController$3(final AlertController this$0, final View val$top, final View val$bottom) {
        this$0 = this$0;
        val$top = val$top;
        val$bottom = val$bottom;
        super();
    }
    
    @Override
    public void run() {
        AlertController.access$800((View)AlertController.access$900(this$0), val$top, val$bottom);
    }
}