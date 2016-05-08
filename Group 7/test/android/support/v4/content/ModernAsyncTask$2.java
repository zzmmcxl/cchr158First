package android.support.v4.content;

import android.os.Process;
import android.support.v4.content.ModernAsyncTask;
import android.support.v4.content.ModernAsyncTask$1;
import android.support.v4.content.ModernAsyncTask$WorkerRunnable;

class ModernAsyncTask$2 extends ModernAsyncTask$WorkerRunnable<Params, Result> {
   ModernAsyncTask$2(ModernAsyncTask var1) {
      super((ModernAsyncTask$1)null);
      this.this$0 = var1;
   }

   public Result call() throws Exception {
      ModernAsyncTask.access$100(this.this$0).set(true);
      Process.setThreadPriority(10);
      return ModernAsyncTask.access$200(this.this$0, this.this$0.doInBackground(this.mParams));
   }
}
