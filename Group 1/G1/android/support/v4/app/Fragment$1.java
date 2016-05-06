package android.support.v4.app;

import android.support.annotation.Nullable;
import android.view.View;

class Fragment$1 extends FragmentContainer {
    final /* synthetic */ Fragment this$0;
    
    Fragment$1(final Fragment this$0) {
        this$0 = this$0;
        super();
    }
    
    @Nullable
    @Override
    public View onFindViewById(final int n) {
        if (mView == null) {
            throw new IllegalStateException("Fragment does not have a view");
        }
        return mView.findViewById(n);
    }
    
    @Override
    public boolean onHasView() {
        return mView != null;
    }
}