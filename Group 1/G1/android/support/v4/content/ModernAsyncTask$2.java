package android.support.v4.content;

import android.os.Process;

class ModernAsyncTask$2 extends WorkerRunnable<Params, Result> {
    final /* synthetic */ ModernAsyncTask this$0;
    
    ModernAsyncTask$2(final ModernAsyncTask this$0) {
        this$0 = this$0;
        super();
    }
    
    @Override
    public Result call() throws Exception {
        ModernAsyncTask.access$100(this$0).set(true);
        Process.setThreadPriority(10);
        return (Result)ModernAsyncTask.access$200(this$0, this$0.doInBackground(this.mParams));
    }
}