package android.support.v4.content;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import android.util.Log;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

class ModernAsyncTask$3 extends FutureTask<Result> {
    final /* synthetic */ ModernAsyncTask this$0;
    
    ModernAsyncTask$3(final ModernAsyncTask this$0, final Callable callable) {
        this$0 = this$0;
        super(callable);
    }
    
    @Override
    protected void done() {
        try {
            ModernAsyncTask.access$300(this$0, ((FutureTask<Object>)this).get());
        }
        catch (InterruptedException ex) {
            Log.w("AsyncTask", (Throwable)ex);
        }
        catch (ExecutionException ex2) {
            throw new RuntimeException("An error occurred while executing doInBackground()", ex2.getCause());
        }
        catch (CancellationException ex3) {
            ModernAsyncTask.access$300(this$0, null);
        }
        catch (Throwable t) {
            throw new RuntimeException("An error occurred while executing doInBackground()", t);
        }
    }
}