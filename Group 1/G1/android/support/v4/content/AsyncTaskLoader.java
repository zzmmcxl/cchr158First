package android.support.v4.content;

import android.support.v4.os.OperationCanceledException;
import java.util.concurrent.CountDownLatch;
import android.support.v4.util.TimeUtils;
import java.io.PrintWriter;
import java.io.FileDescriptor;
import android.os.SystemClock;
import android.content.Context;
import android.os.Handler;
import java.util.concurrent.Executor;

public abstract class AsyncTaskLoader<D> extends Loader<D>
{
    static final boolean DEBUG = false;
    static final String TAG = "AsyncTaskLoader";
    volatile LoadTask mCancellingTask;
    private final Executor mExecutor;
    Handler mHandler;
    long mLastLoadCompleteTime;
    volatile LoadTask mTask;
    long mUpdateThrottle;
    
    public AsyncTaskLoader(final Context context) {
        this(context, ModernAsyncTask.THREAD_POOL_EXECUTOR);
    }
    
    private AsyncTaskLoader(final Context context, final Executor mExecutor) {
        super(context);
        mLastLoadCompleteTime = -10000L;
        mExecutor = mExecutor;
    }
    
    public void cancelLoadInBackground() {
    }
    
    void dispatchOnCancelled(final LoadTask loadTask, final D n) {
        this.onCanceled(n);
        if (mCancellingTask == loadTask) {
            this.rollbackContentChanged();
            mLastLoadCompleteTime = SystemClock.uptimeMillis();
            mCancellingTask = null;
            this.deliverCancellation();
            this.executePendingTask();
        }
    }
    
    void dispatchOnLoadComplete(final LoadTask loadTask, final D n) {
        if (mTask != loadTask) {
            this.dispatchOnCancelled(loadTask, n);
            return;
        }
        if (this.isAbandoned()) {
            this.onCanceled(n);
            return;
        }
        this.commitContentChanged();
        mLastLoadCompleteTime = SystemClock.uptimeMillis();
        mTask = null;
        this.deliverResult(n);
    }
    
    @Override
    public void dump(final String s, final FileDescriptor fileDescriptor, final PrintWriter printWriter, final String[] array) {
        super.dump(s, fileDescriptor, printWriter, array);
        if (mTask != null) {
            printWriter.print(s);
            printWriter.print("mTask=");
            printWriter.print(mTask);
            printWriter.print(" waiting=");
            printWriter.println(mTask.waiting);
        }
        if (mCancellingTask != null) {
            printWriter.print(s);
            printWriter.print("mCancellingTask=");
            printWriter.print(mCancellingTask);
            printWriter.print(" waiting=");
            printWriter.println(mCancellingTask.waiting);
        }
        if (mUpdateThrottle != 0L) {
            printWriter.print(s);
            printWriter.print("mUpdateThrottle=");
            TimeUtils.formatDuration(mUpdateThrottle, printWriter);
            printWriter.print(" mLastLoadCompleteTime=");
            TimeUtils.formatDuration(mLastLoadCompleteTime, SystemClock.uptimeMillis(), printWriter);
            printWriter.println();
        }
    }
    
    void executePendingTask() {
        if (mCancellingTask == null && mTask != null) {
            if (mTask.waiting) {
                mTask.waiting = false;
                mHandler.removeCallbacks((Runnable)mTask);
            }
            if (mUpdateThrottle <= 0L || SystemClock.uptimeMillis() >= mLastLoadCompleteTime + mUpdateThrottle) {
                ((ModernAsyncTask<Void, Object, Object>)mTask).executeOnExecutor(mExecutor, (Void[])null);
                return;
            }
            mTask.waiting = true;
            mHandler.postAtTime((Runnable)mTask, mLastLoadCompleteTime + mUpdateThrottle);
        }
    }
    
    public boolean isLoadInBackgroundCanceled() {
        return mCancellingTask != null;
    }
    
    public abstract D loadInBackground();
    
    @Override
    protected boolean onCancelLoad() {
        if (mTask != null) {
            if (mCancellingTask != null) {
                if (mTask.waiting) {
                    mTask.waiting = false;
                    mHandler.removeCallbacks((Runnable)mTask);
                }
                mTask = null;
            }
            else {
                if (mTask.waiting) {
                    mTask.waiting = false;
                    mHandler.removeCallbacks((Runnable)mTask);
                    mTask = null;
                    return false;
                }
                final boolean cancel = mTask.cancel(false);
                if (cancel) {
                    mCancellingTask = mTask;
                    this.cancelLoadInBackground();
                }
                mTask = null;
                return cancel;
            }
        }
        return false;
    }
    
    public void onCanceled(final D n) {
    }
    
    @Override
    protected void onForceLoad() {
        super.onForceLoad();
        this.cancelLoad();
        mTask = new LoadTask();
        this.executePendingTask();
    }
    
    protected D onLoadInBackground() {
        return this.loadInBackground();
    }
    
    public void setUpdateThrottle(final long mUpdateThrottle) {
        this.mUpdateThrottle = mUpdateThrottle;
        if (mUpdateThrottle != 0L) {
            mHandler = new Handler();
        }
    }
    
    public void waitForLoader() {
        final LoadTask mTask = this.mTask;
        if (mTask != null) {
            mTask.waitForLoader();
        }
    }
}
