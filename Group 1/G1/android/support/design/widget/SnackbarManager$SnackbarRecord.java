package android.support.design.widget;

import java.lang.ref.WeakReference;

private static class SnackbarRecord
{
    private final WeakReference<Callback> callback;
    private int duration;
    
    SnackbarRecord(final int duration, final Callback callback) {
        super();
        this.callback = new WeakReference<Callback>(callback);
        this.duration = duration;
    }
    
    static /* synthetic */ int access$100(final SnackbarRecord snackbarRecord) {
        return snackbarRecord.duration;
    }
    
    static /* synthetic */ int access$102(final SnackbarRecord snackbarRecord, final int duration) {
        return snackbarRecord.duration = duration;
    }
    
    static /* synthetic */ WeakReference access$200(final SnackbarRecord snackbarRecord) {
        return snackbarRecord.callback;
    }
    
    boolean isSnackbar(final Callback callback) {
        return callback != null && this.callback.get() == callback;
    }
}
