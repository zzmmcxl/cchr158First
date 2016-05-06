package android.support.v4.view;

import android.view.View;
import android.view.View$OnClickListener;

class PagerTabStrip$1 implements View$OnClickListener {
    final /* synthetic */ PagerTabStrip this$0;
    
    PagerTabStrip$1(final PagerTabStrip this$0) {
        this$0 = this$0;
        super();
    }
    
    public void onClick(final View view) {
        this$0.mPager.setCurrentItem(-1 + this$0.mPager.getCurrentItem());
    }
}