package android.support.v4.content;

import android.os.Message;
import android.os.Looper;
import java.util.concurrent.TimeoutException;
import android.os.Handler;
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

abstract class ModernAsyncTask<Params, Progress, Result>
{
    private static final int CORE_POOL_SIZE = 5;
    private static final int KEEP_ALIVE = 1;
    private static final String LOG_TAG = "AsyncTask";
    private static final int MAXIMUM_POOL_SIZE = 128;
    private static final int MESSAGE_POST_PROGRESS = 2;
    private static final int MESSAGE_POST_RESULT = 1;
    public static final Executor THREAD_POOL_EXECUTOR;
    private static volatile Executor sDefaultExecutor;
    private static InternalHandler sHandler;
    private static final BlockingQueue<Runnable> sPoolWorkQueue;
    private static final ThreadFactory sThreadFactory;
    private final FutureTask<Result> mFuture;
    private volatile Status mStatus;
    private final AtomicBoolean mTaskInvoked;
    private final WorkerRunnable<Params, Result> mWorker;
    
    static {
        sThreadFactory = new ThreadFactory() {
            private final AtomicInteger mCount = new AtomicInteger(1);
            
            ModernAsyncTask$1() {
                super();
            }
            
            @Override
            public Thread newThread(final Runnable runnable) {
                return new Thread(runnable, "ModernAsyncTask #" + mCount.getAndIncrement());
            }
        };
        sPoolWorkQueue = new LinkedBlockingQueue<Runnable>(10);
        THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(5, 128, 1L, TimeUnit.SECONDS, sPoolWorkQueue, sThreadFactory);
        sDefaultExecutor = THREAD_POOL_EXECUTOR;
    }
    
    public ModernAsyncTask() {
        super();
        mStatus = Status.PENDING;
        mTaskInvoked = new AtomicBoolean();
        mWorker = (WorkerRunnable<Params, Result>)new WorkerRunnable<Params, Result>() {
            final /* synthetic */ ModernAsyncTask this$0;
            
            ModernAsyncTask$2() {
                this$0 = this$0;
                super();
            }
            
            @Override
            public Result call() throws Exception {
                mTaskInvoked.set(true);
                Process.setThreadPriority(10);
                return (Result)this$0.postResult(this$0.doInBackground(this.mParams));
            }
        };
        mFuture = new FutureTask<Result>(mWorker) {
            final /* synthetic */ ModernAsyncTask this$0;
            
            ModernAsyncTask$3(final Callable callable) {
                this$0 = this$0;
                super(callable);
            }
            
            @Override
            protected void done() {
                try {
                    this$0.postResultIfNotInvoked(((FutureTask<Object>)this).get());
                }
                catch (InterruptedException ex) {
                    Log.w("AsyncTask", (Throwable)ex);
                }
                catch (ExecutionException ex2) {
                    throw new RuntimeException("An error occurred while executing doInBackground()", ex2.getCause());
                }
                catch (CancellationException ex3) {
                    this$0.postResultIfNotInvoked(null);
                }
                catch (Throwable t) {
                    throw new RuntimeException("An error occurred while executing doInBackground()", t);
                }
            }
        };
    }
    
    static /* synthetic */ AtomicBoolean access$100(final ModernAsyncTask modernAsyncTask) {
        return modernAsyncTask.mTaskInvoked;
    }
    
    static /* synthetic */ Object access$200(final ModernAsyncTask modernAsyncTask, final Object o) {
        return modernAsyncTask.postResult(o);
    }
    
    static /* synthetic */ void access$300(final ModernAsyncTask modernAsyncTask, final Object o) {
        modernAsyncTask.postResultIfNotInvoked(o);
    }
    
    static /* synthetic */ void access$400(final ModernAsyncTask modernAsyncTask, final Object o) {
        modernAsyncTask.finish(o);
    }
    
    public static void execute(final Runnable runnable) {
        sDefaultExecutor.execute(runnable);
    }
    
    private void finish(final Result result) {
        if (this.isCancelled()) {
            this.onCancelled(result);
        }
        else {
            this.onPostExecute(result);
        }
        mStatus = Status.FINISHED;
    }
    
    private static Handler getHandler() {
        synchronized (ModernAsyncTask.class) {
            if (sHandler == null) {
                sHandler = new InternalHandler();
            }
            return sHandler;
        }
    }
    
    private Result postResult(final Result result) {
        getHandler().obtainMessage(1, (Object)new AsyncTaskResult(this, new Object[] { result })).sendToTarget();
        return result;
    }
    
    private void postResultIfNotInvoked(final Result result) {
        if (!mTaskInvoked.get()) {
            this.postResult(result);
        }
    }
    
    public static void setDefaultExecutor(final Executor sDefaultExecutor) {
        ModernAsyncTask.sDefaultExecutor = sDefaultExecutor;
    }
    
    public final boolean cancel(final boolean b) {
        return mFuture.cancel(b);
    }
    
    protected abstract Result doInBackground(final Params... p0);
    
    public final ModernAsyncTask<Params, Progress, Result> execute(final Params... array) {
        return this.executeOnExecutor(sDefaultExecutor, array);
    }
    
    public final ModernAsyncTask<Params, Progress, Result> executeOnExecutor(final Executor executor, final Params... mParams) {
        if (mStatus != Status.PENDING) {
            switch (mStatus) {
                case RUNNING:
                    throw new IllegalStateException("Cannot execute task: the task is already running.");
                case FINISHED:
                    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        mStatus = Status.RUNNING;
        this.onPreExecute();
        mWorker.mParams = mParams;
        executor.execute(mFuture);
        return this;
    }
    
    public final Result get() throws InterruptedException, ExecutionException {
        return mFuture.get();
    }
    
    public final Result get(final long n, final TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return mFuture.get(n, timeUnit);
    }
    
    public final Status getStatus() {
        return mStatus;
    }
    
    public final boolean isCancelled() {
        return mFuture.isCancelled();
    }
    
    protected void onCancelled() {
    }
    
    protected void onCancelled(final Result result) {
        this.onCancelled();
    }
    
    protected void onPostExecute(final Result result) {
    }
    
    protected void onPreExecute() {
    }
    
    protected void onProgressUpdate(final Progress... array) {
    }
    
    protected final void publishProgress(final Progress... array) {
        if (!this.isCancelled()) {
            getHandler().obtainMessage(2, (Object)new AsyncTaskResult(this, (Object[])array)).sendToTarget();
        }
    }
}
