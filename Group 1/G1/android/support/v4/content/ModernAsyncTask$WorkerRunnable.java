package android.support.v4.content;

import java.util.concurrent.Callable;

private abstract static class WorkerRunnable<Params, Result> implements Callable<Result>
{
    Params[] mParams;
    
    private WorkerRunnable() {
        super();
    }
    
    WorkerRunnable(final ModernAsyncTask$1 threadFactory) {
        this();
    }
}
