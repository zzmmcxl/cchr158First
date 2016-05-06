package android.support.design.widget;

import android.view.View;
import android.view.View$OnClickListener;

class Snackbar$2 implements View$OnClickListener {
    final /* synthetic */ Snackbar this$0;
    final /* synthetic */ View$OnClickListener val$listener;
    
    Snackbar$2(final Snackbar this$0, final View$OnClickListener val$listener) {
        this$0 = this$0;
        val$listener = val$listener;
        super();
    }
    
    public void onClick(final View view) {
        val$listener.onClick(view);
        Snackbar.access$000(this$0, 1);
    }
}