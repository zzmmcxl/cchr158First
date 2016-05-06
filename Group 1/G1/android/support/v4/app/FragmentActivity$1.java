package android.support.v4.app;

import android.os.Message;
import android.os.Handler;

class FragmentActivity$1 extends Handler {
    final /* synthetic */ FragmentActivity this$0;
    
    FragmentActivity$1(final FragmentActivity this$0) {
        this$0 = this$0;
        super();
    }
    
    public void handleMessage(final Message message) {
        switch (message.what) {
            default:
                super.handleMessage(message);
                break;
            case 1:
                if (mStopped) {
                    this$0.doReallyStop(false);
                    return;
                }
                break;
            case 2:
                this$0.onResumeFragments();
                mFragments.execPendingActions();
        }
    }
}