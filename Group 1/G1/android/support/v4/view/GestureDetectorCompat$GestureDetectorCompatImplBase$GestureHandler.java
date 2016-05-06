package android.support.v4.view;

import android.os.Message;
import android.os.Handler;

private class GestureHandler extends Handler
{
    final /* synthetic */ GestureDetectorCompatImplBase this$0;
    
    GestureHandler(final GestureDetectorCompatImplBase this$0) {
        this$0 = this$0;
        super();
    }
    
    GestureHandler(final GestureDetectorCompatImplBase this$0, final Handler handler) {
        this$0 = this$0;
        super(handler.getLooper());
    }
    
    public void handleMessage(final Message message) {
        switch (message.what) {
            default:
                throw new RuntimeException("Unknown message " + message);
            case 1:
                GestureDetectorCompatImplBase.access$100(this$0).onShowPress(GestureDetectorCompatImplBase.access$000(this$0));
                break;
            case 2:
                GestureDetectorCompatImplBase.access$200(this$0);
            case 3:
                if (GestureDetectorCompatImplBase.access$300(this$0) == null) {
                    break;
                }
                if (!GestureDetectorCompatImplBase.access$400(this$0)) {
                    GestureDetectorCompatImplBase.access$300(this$0).onSingleTapConfirmed(GestureDetectorCompatImplBase.access$000(this$0));
                    return;
                }
                GestureDetectorCompatImplBase.access$502(this$0, true);
        }
    }
}
