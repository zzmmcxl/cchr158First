package android.support.design.widget;

class Snackbar$3 implements SnackbarManager.Callback {
    final /* synthetic */ Snackbar this$0;
    
    Snackbar$3(final Snackbar this$0) {
        this$0 = this$0;
        super();
    }
    
    @Override
    public void dismiss(final int n) {
        Snackbar.access$100().sendMessage(Snackbar.access$100().obtainMessage(1, n, 0, (Object)this$0));
    }
    
    @Override
    public void show() {
        Snackbar.access$100().sendMessage(Snackbar.access$100().obtainMessage(0, (Object)this$0));
    }
}