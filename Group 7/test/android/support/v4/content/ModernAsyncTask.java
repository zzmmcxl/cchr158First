package android.support.v4.content;

import android.os.Handler;
import android.support.v4.content.ModernAsyncTask$1;
import android.support.v4.content.ModernAsyncTask$2;
import android.support.v4.content.ModernAsyncTask$3;
import android.support.v4.content.ModernAsyncTask$4;
import android.support.v4.content.ModernAsyncTask$AsyncTaskResult;
import android.support.v4.content.ModernAsyncTask$InternalHandler;
import android.support.v4.content.ModernAsyncTask$Status;
import android.support.v4.content.ModernAsyncTask$WorkerRunnable;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

abstract class ModernAsyncTask<Params, Progress, Result> {
   private static final int CORE_POOL_SIZE = 5;
   private static final int KEEP_ALIVE = 1;
   private static final String LOG_TAG = "AsyncTask";
   private static final int MAXIMUM_POOL_SIZE = 128;
   private static final int MESSAGE_POST_PROGRESS = 2;
   private static final int MESSAGE_POST_RESULT = 1;
   public static final Executor THREAD_POOL_EXECUTOR;
   private static volatile Executor sDefaultExecutor;
   private static ModernAsyncTask$InternalHandler sHandler;
   private static final BlockingQueue<Runnable> sPoolWorkQueue = new LinkedBlockingQueue(10);
   private static final ThreadFactory sThreadFactory = new ModernAsyncTask$1();
   private final FutureTask<Result> mFuture;
   private volatile ModernAsyncTask$Status mStatus;
   private final AtomicBoolean mTaskInvoked;
   private final ModernAsyncTask$WorkerRunnable<Params, Result> mWorker;

   static {
      THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(5, 128, 1L, TimeUnit.SECONDS, sPoolWorkQueue, sThreadFactory);
      sDefaultExecutor = THREAD_POOL_EXECUTOR;
   }

   public ModernAsyncTask() {
      this.mStatus = ModernAsyncTask$Status.PENDING;
      this.mTaskInvoked = new AtomicBoolean();
      this.mWorker = new ModernAsyncTask$2(this);
      this.mFuture = new ModernAsyncTask$3(this, this.mWorker);
   }

   public static void execute(Runnable var0) {
      sDefaultExecutor.execute(var0);
   }

   private void finish(Result var1) {
      if(this.isCancelled()) {
         this.onCancelled(var1);
      } else {
         this.onPostExecute(var1);
      }

      this.mStatus = ModernAsyncTask$Status.FINISHED;
   }

   private static Handler getHandler() {
      // $FF: Couldn't be decompiled
   }

   private Result postResult(Result var1) {
      getHandler().obtainMessage(1, new ModernAsyncTask$AsyncTaskResult(this, new Object[]{var1})).sendToTarget();
      return var1;
   }

   private void postResultIfNotInvoked(Result var1) {
      if(!this.mTaskInvoked.get()) {
         this.postResult(var1);
      }

   }

   public static void setDefaultExecutor(Executor var0) {
      sDefaultExecutor = var0;
   }

   public final boolean cancel(boolean var1) {
      return this.mFuture.cancel(var1);
   }

   protected abstract Result doInBackground(Params... var1);

   public final ModernAsyncTask<Params, Progress, Result> execute(Params... var1) {
      return this.executeOnExecutor(sDefaultExecutor, var1);
   }

   public final ModernAsyncTask<Params, Progress, Result> executeOnExecutor(Executor var1, Params... var2) {
      if(this.mStatus != ModernAsyncTask$Status.PENDING) {
         switch(ModernAsyncTask$4.$SwitchMap$android$support$v4$content$ModernAsyncTask$Status[this.mStatus.ordinal()]) {
         case 1:
            throw new IllegalStateException("Cannot execute task: the task is already running.");
         case 2:
            throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
         }
      }

      this.mStatus = ModernAsyncTask$Status.RUNNING;
      this.onPreExecute();
      this.mWorker.mParams = var2;
      var1.execute(this.mFuture);
      return this;
   }

   public final Result get() throws InterruptedException, ExecutionException {
      return this.mFuture.get();
   }

   public final Result get(long var1, TimeUnit var3) throws InterruptedException, ExecutionException, TimeoutException {
      return this.mFuture.get(var1, var3);
   }

   public final ModernAsyncTask$Status getStatus() {
      return this.mStatus;
   }

   public final boolean isCancelled() {
      return this.mFuture.isCancelled();
   }

   protected void onCancelled() {
   }

   protected void onCancelled(Result var1) {
      this.onCancelled();
   }

   protected void onPostExecute(Result var1) {
   }

   protected void onPreExecute() {
   }

   protected void onProgressUpdate(Progress... var1) {
   }

   protected final void publishProgress(Progress... var1) {
      if(!this.isCancelled()) {
         getHandler().obtainMessage(2, new ModernAsyncTask$AsyncTaskResult(this, var1)).sendToTarget();
      }

   }
}
