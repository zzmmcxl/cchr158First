package android.support.v4.os;

import android.os.Bundle;

class MyResultReceiver extends Stub
{
    final /* synthetic */ ResultReceiver this$0;
    
    MyResultReceiver(final ResultReceiver this$0) {
        this$0 = this$0;
        super();
    }
    
    public void send(final int n, final Bundle bundle) {
        if (mHandler != null) {
            mHandler.post((Runnable)this$0.new MyRunnable(n, bundle));
            return;
        }
        this$0.onReceiveResult(n, bundle);
    }
}
