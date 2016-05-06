package android.support.v7.widget;

import java.util.Iterator;
import java.util.ArrayList;

class DefaultItemAnimator$3 implements Runnable {
    final /* synthetic */ DefaultItemAnimator this$0;
    final /* synthetic */ ArrayList val$additions;
    
    DefaultItemAnimator$3(final DefaultItemAnimator this$0, final ArrayList val$additions) {
        this$0 = this$0;
        val$additions = val$additions;
        super();
    }
    
    @Override
    public void run() {
        final Iterator<ViewHolder> iterator = val$additions.iterator();
        while (iterator.hasNext()) {
            DefaultItemAnimator.access$400(this$0, iterator.next());
        }
        val$additions.clear();
        DefaultItemAnimator.access$500(this$0).remove(val$additions);
    }
}