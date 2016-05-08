package android.support.v4.content;

import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.ModernAsyncTask;
import android.support.v4.os.OperationCanceledException;
import java.util.concurrent.CountDownLatch;

final class AsyncTaskLoader$LoadTask extends ModernAsyncTask<Void, Void, D> implements Runnable {
   private final CountDownLatch mDone;
   boolean waiting;

   AsyncTaskLoader$LoadTask(AsyncTaskLoader var1) {
      this.this$0 = var1;
      this.mDone = new CountDownLatch(1);
   }

   protected D doInBackground(Void... var1) {
      try {
         Object var3 = this.this$0.onLoadInBackground();
         return var3;
      } catch (OperationCanceledException var2) {
         if(!this.isCancelled()) {
            throw var2;
         } else {
            return null;
         }
      }
   }

   protected void onCancelled(D var1) {
      boolean var3 = false;

      try {
         var3 = true;
         this.this$0.dispatchOnCancelled(this, var1);
         var3 = false;
      } finally {
         if(var3) {
            this.mDone.countDown();
         }
      }

      this.mDone.countDown();
   }

   protected void onPostExecute(D var1) {
      boolean var3 = false;

      try {
         var3 = true;
         this.this$0.dispatchOnLoadComplete(this, var1);
         var3 = false;
      } finally {
         if(var3) {
            this.mDone.countDown();
         }
      }

      this.mDone.countDown();
   }

   public void run() {
      this.waiting = false;
      this.this$0.executePendingTask();
   }

   public void waitForLoader() {
      try {
         this.mDone.await();
      } catch (InterruptedException var2) {
         ;
      }
   }
}
