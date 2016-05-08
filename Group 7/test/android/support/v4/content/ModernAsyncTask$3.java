package android.support.v4.content;

import android.support.v4.content.ModernAsyncTask;
import android.util.Log;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class ModernAsyncTask$3 extends FutureTask<Result> {
   ModernAsyncTask$3(ModernAsyncTask var1, Callable var2) {
      super(var2);
      this.this$0 = var1;
   }

   protected void done() {
      try {
         Object var1 = this.get();
         ModernAsyncTask.access$300(this.this$0, var1);
      } catch (InterruptedException var2) {
         Log.w("AsyncTask", var2);
      } catch (ExecutionException var3) {
         throw new RuntimeException("An error occurred while executing doInBackground()", var3.getCause());
      } catch (CancellationException var4) {
         ModernAsyncTask.access$300(this.this$0, (Object)null);
      } catch (Throwable var5) {
         throw new RuntimeException("An error occurred while executing doInBackground()", var5);
      }
   }
}
