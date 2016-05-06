package android.support.design.widget;

import java.lang.ref.WeakReference;
import android.os.Message;
import android.os.Handler$Callback;
import android.os.Looper;
import android.os.Handler;

class SnackbarManager
{
    private static final int LONG_DURATION_MS = 2750;
    private static final int MSG_TIMEOUT = 0;
    private static final int SHORT_DURATION_MS = 1500;
    private static SnackbarManager sSnackbarManager;
    private SnackbarRecord mCurrentSnackbar;
    private final Handler mHandler;
    private final Object mLock;
    private SnackbarRecord mNextSnackbar;
    
    private SnackbarManager() {
        super();
        mLock = new Object();
        mHandler = new Handler(Looper.getMainLooper(), (Handler$Callback)new Handler$Callback() {
            final /* synthetic */ SnackbarManager this$0;
            
            SnackbarManager$1() {
                this$0 = this$0;
                super();
            }
            
            public boolean handleMessage(final Message message) {
                switch (message.what) {
                    default:
                        return false;
                    case 0:
                        this$0.handleTimeout((SnackbarRecord)message.obj);
                        return true;
                }
            }
        });
    }
    
    static /* synthetic */ void access$000(final SnackbarManager snackbarManager, final SnackbarRecord snackbarRecord) {
        snackbarManager.handleTimeout(snackbarRecord);
    }
    
    private boolean cancelSnackbarLocked(final SnackbarRecord snackbarRecord, final int n) {
        final Callback callback = (Callback)snackbarRecord.callback.get();
        if (callback != null) {
            mHandler.removeCallbacksAndMessages((Object)snackbarRecord);
            callback.dismiss(n);
            return true;
        }
        return false;
    }
    
    static SnackbarManager getInstance() {
        if (sSnackbarManager == null) {
            sSnackbarManager = new SnackbarManager();
        }
        return sSnackbarManager;
    }
    
    private void handleTimeout(final SnackbarRecord snackbarRecord) {
        synchronized (mLock) {
            if (mCurrentSnackbar == snackbarRecord || mNextSnackbar == snackbarRecord) {
                this.cancelSnackbarLocked(snackbarRecord, 2);
            }
        }
    }
    
    private boolean isCurrentSnackbarLocked(final Callback callback) {
        return mCurrentSnackbar != null && mCurrentSnackbar.isSnackbar(callback);
    }
    
    private boolean isNextSnackbarLocked(final Callback callback) {
        return mNextSnackbar != null && mNextSnackbar.isSnackbar(callback);
    }
    
    private void scheduleTimeoutLocked(final SnackbarRecord snackbarRecord) {
        if (snackbarRecord.duration == -2) {
            return;
        }
        int access$100 = 2750;
        if (snackbarRecord.duration > 0) {
            access$100 = snackbarRecord.duration;
        }
        else if (snackbarRecord.duration == -1) {
            access$100 = 1500;
        }
        mHandler.removeCallbacksAndMessages((Object)snackbarRecord);
        mHandler.sendMessageDelayed(Message.obtain(mHandler, 0, (Object)snackbarRecord), (long)access$100);
    }
    
    private void showNextSnackbarLocked() {
        if (mNextSnackbar != null) {
            mCurrentSnackbar = mNextSnackbar;
            mNextSnackbar = null;
            final Callback callback = (Callback)mCurrentSnackbar.callback.get();
            if (callback == null) {
                mCurrentSnackbar = null;
                return;
            }
            callback.show();
        }
    }
    
    public void cancelTimeout(final Callback callback) {
        synchronized (mLock) {
            if (this.isCurrentSnackbarLocked(callback)) {
                mHandler.removeCallbacksAndMessages((Object)mCurrentSnackbar);
            }
        }
    }
    
    public void dismiss(final Callback callback, final int n) {
        synchronized (mLock) {
            if (this.isCurrentSnackbarLocked(callback)) {
                this.cancelSnackbarLocked(mCurrentSnackbar, n);
            }
            else if (this.isNextSnackbarLocked(callback)) {
                this.cancelSnackbarLocked(mNextSnackbar, n);
            }
        }
    }
    
    public boolean isCurrent(final Callback callback) {
        synchronized (mLock) {
            return this.isCurrentSnackbarLocked(callback);
        }
    }
    
    public boolean isCurrentOrNext(final Callback callback) {
        while (true) {
            synchronized (mLock) {
                if (this.isCurrentSnackbarLocked(callback)) {
                    return true;
                }
                if (this.isNextSnackbarLocked(callback)) {
                    return true;
                }
                return false;
            }
            return true;
            b = false;
            return b;
        }
    }
    
    public void onDismissed(final Callback callback) {
        synchronized (mLock) {
            if (this.isCurrentSnackbarLocked(callback)) {
                mCurrentSnackbar = null;
                if (mNextSnackbar != null) {
                    this.showNextSnackbarLocked();
                }
            }
        }
    }
    
    public void onShown(final Callback callback) {
        synchronized (mLock) {
            if (this.isCurrentSnackbarLocked(callback)) {
                this.scheduleTimeoutLocked(mCurrentSnackbar);
            }
        }
    }
    
    public void restoreTimeout(final Callback callback) {
        synchronized (mLock) {
            if (this.isCurrentSnackbarLocked(callback)) {
                this.scheduleTimeoutLocked(mCurrentSnackbar);
            }
        }
    }
    
    public void show(final int n, final Callback callback) {
        while (true) {
            while (true) {
                synchronized (mLock) {
                    if (this.isCurrentSnackbarLocked(callback)) {
                        mCurrentSnackbar.duration = n;
                        mHandler.removeCallbacksAndMessages((Object)mCurrentSnackbar);
                        this.scheduleTimeoutLocked(mCurrentSnackbar);
                        return;
                    }
                    if (this.isNextSnackbarLocked(callback)) {
                        mNextSnackbar.duration = n;
                        if (mCurrentSnackbar != null && this.cancelSnackbarLocked(mCurrentSnackbar, 4)) {
                            return;
                        }
                        break;
                    }
                }
                mNextSnackbar = new SnackbarRecord(n, callback);
                continue;
            }
        }
        mCurrentSnackbar = null;
        this.showNextSnackbarLocked();
    }
    // monitorexit(o)
}
