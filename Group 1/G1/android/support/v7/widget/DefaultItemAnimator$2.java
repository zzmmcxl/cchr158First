package android.support.v7.widget;

import java.util.Iterator;
import java.util.ArrayList;

class DefaultItemAnimator$2 implements Runnable {
    final /* synthetic */ DefaultItemAnimator this$0;
    final /* synthetic */ ArrayList val$changes;
    
    DefaultItemAnimator$2(final DefaultItemAnimator this$0, final ArrayList val$changes) {
        this$0 = this$0;
        val$changes = val$changes;
        super();
    }
    
    @Override
    public void run() {
        final Iterator<ChangeInfo> iterator = val$changes.iterator();
        while (iterator.hasNext()) {
            DefaultItemAnimator.access$200(this$0, (ChangeInfo)iterator.next());
        }
        val$changes.clear();
        DefaultItemAnimator.access$300(this$0).remove(val$changes);
    }
}