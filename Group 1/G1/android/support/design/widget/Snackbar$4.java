package android.support.design.widget;

import android.view.View;

class Snackbar$4 implements OnDismissListener {
    final /* synthetic */ Snackbar this$0;
    
    Snackbar$4(final Snackbar this$0) {
        this$0 = this$0;
        super();
    }
    
    @Override
    public void onDismiss(final View view) {
        view.setVisibility(8);
        Snackbar.access$000(this$0, 0);
    }
    
    @Override
    public void onDragStateChanged(final int n) {
        switch (n) {
            default:
            case 1:
            case 2:
                SnackbarManager.getInstance().cancelTimeout(Snackbar.access$200(this$0));
            case 0:
                SnackbarManager.getInstance().restoreTimeout(Snackbar.access$200(this$0));
        }
    }
}