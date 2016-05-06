package android.support.v4.os;

import android.os.Bundle;

class MyRunnable implements Runnable
{
    final int mResultCode;
    final Bundle mResultData;
    final /* synthetic */ ResultReceiver this$0;
    
    MyRunnable(final ResultReceiver this$0, final int mResultCode, final Bundle mResultData) {
        this$0 = this$0;
        super();
        mResultCode = mResultCode;
        mResultData = mResultData;
    }
    
    @Override
    public void run() {
        this$0.onReceiveResult(mResultCode, mResultData);
    }
}
