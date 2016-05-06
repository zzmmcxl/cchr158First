package android.support.v4.content;

import java.util.concurrent.TimeoutException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import android.util.Log;
import java.util.concurrent.Callable;
import android.os.Process;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import android.os.Message;
import android.os.Looper;
import android.os.Handler;

private static class InternalHandler extends Handler
{
    public InternalHandler() {
        super(Looper.getMainLooper());
    }
    
    public void handleMessage(final Message message) {
        final AsyncTaskResult asyncTaskResult = (AsyncTaskResult)message.obj;
        switch (message.what) {
            default:
            case 1:
                ((ModernAsyncTask<Object, Object, Object>)asyncTaskResult.mTask).finish(asyncTaskResult.mData[0]);
            case 2:
                asyncTaskResult.mTask.onProgressUpdate(asyncTaskResult.mData);
        }
    }
}
