package android.support.v4.os;

import android.os.Build$VERSION;
import android.os.AsyncTask;

public final class AsyncTaskCompat
{
    private AsyncTaskCompat() {
        super();
    }
    
    public static <Params, Progress, Result> AsyncTask<Params, Progress, Result> executeParallel(final AsyncTask<Params, Progress, Result> asyncTask, final Params... array) {
        if (asyncTask == null) {
            throw new IllegalArgumentException("task can not be null");
        }
        if (Build$VERSION.SDK_INT >= 11) {
            AsyncTaskCompatHoneycomb.<Params, Object, Object>executeParallel((android.os.AsyncTask<Params, Object, Object>)asyncTask, array);
            return asyncTask;
        }
        asyncTask.execute((Object[])array);
        return asyncTask;
    }
}
