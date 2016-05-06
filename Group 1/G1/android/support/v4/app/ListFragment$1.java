package android.support.v4.app;

import android.view.View;

class ListFragment$1 implements Runnable {
    final /* synthetic */ ListFragment this$0;
    
    ListFragment$1(final ListFragment this$0) {
        this$0 = this$0;
        super();
    }
    
    @Override
    public void run() {
        mList.focusableViewAvailable((View)mList);
    }
}