package android.support.v4.content;

import android.support.v4.os.OperationCanceledException;
import java.util.concurrent.CountDownLatch;

final class LoadTask extends ModernAsyncTask<Void, Void, D> implements Runnable
{
    private final CountDownLatch mDone;
    final /* synthetic */ AsyncTaskLoader this$0;
    boolean waiting;
    
    LoadTask(final AsyncTaskLoader this$0) {
        this$0 = this$0;
        super();
        mDone = new CountDownLatch(1);
    }
    
    @Override
    protected /* bridge */ Object doInBackground(final Object[] array) {
        return this.doInBackground((Void[])array);
    }
    
    @Override
    protected D doInBackground(final Void... array) {
        try {
            return this$0.onLoadInBackground();
        }
        catch (OperationCanceledException ex) {
            if (!this.isCancelled()) {
                throw ex;
            }
            return null;
        }
    }
    
    @Override
    protected void onCancelled(final D n) {
        try {
            this$0.dispatchOnCancelled(this, n);
        }
        finally {
            mDone.countDown();
        }
    }
    
    @Override
    protected void onPostExecute(final D n) {
        try {
            this$0.dispatchOnLoadComplete(this, n);
        }
        finally {
            mDone.countDown();
        }
    }
    
    @Override
    public void run() {
        waiting = false;
        this$0.executePendingTask();
    }
    
    public void waitForLoader() {
        try {
            mDone.await();
        }
        catch (InterruptedException ex) {}
    }
}
