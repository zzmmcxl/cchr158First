package android.support.v4.app;

import android.view.View;

class BackStackRecord$1 implements ViewRetriever {
    final /* synthetic */ BackStackRecord this$0;
    final /* synthetic */ Fragment val$inFragment;
    
    BackStackRecord$1(final BackStackRecord this$0, final Fragment val$inFragment) {
        this$0 = this$0;
        val$inFragment = val$inFragment;
        super();
    }
    
    @Override
    public View getView() {
        return val$inFragment.getView();
    }
}