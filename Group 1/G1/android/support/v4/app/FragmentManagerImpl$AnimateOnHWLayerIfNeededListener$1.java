package android.support.v4.app;

import android.graphics.Paint;
import android.support.v4.view.ViewCompat;

class FragmentManagerImpl$AnimateOnHWLayerIfNeededListener$1 implements Runnable {
    final /* synthetic */ AnimateOnHWLayerIfNeededListener this$0;
    
    FragmentManagerImpl$AnimateOnHWLayerIfNeededListener$1(final AnimateOnHWLayerIfNeededListener this$0) {
        this$0 = this$0;
        super();
    }
    
    @Override
    public void run() {
        ViewCompat.setLayerType(AnimateOnHWLayerIfNeededListener.access$000(this$0), 2, null);
    }
}