package android.support.v4.view;

import android.database.DataSetObserver;

private class PageListener extends DataSetObserver implements OnPageChangeListener, OnAdapterChangeListener
{
    private int mScrollState;
    final /* synthetic */ PagerTitleStrip this$0;
    
    private PageListener(final PagerTitleStrip this$0) {
        this$0 = this$0;
        super();
    }
    
    PageListener(final PagerTitleStrip pagerTitleStrip, final PagerTitleStrip$1 object) {
        this(pagerTitleStrip);
    }
    
    public void onAdapterChanged(final PagerAdapter pagerAdapter, final PagerAdapter pagerAdapter2) {
        this$0.updateAdapter(pagerAdapter, pagerAdapter2);
    }
    
    public void onChanged() {
        this$0.updateText(mPager.getCurrentItem(), mPager.getAdapter());
        final float n = fcmpl(PagerTitleStrip.access$100(this$0), 0.0f);
        float access$100 = 0.0f;
        if (n >= 0) {
            access$100 = PagerTitleStrip.access$100(this$0);
        }
        this$0.updateTextPositions(mPager.getCurrentItem(), access$100, true);
    }
    
    public void onPageScrollStateChanged(final int mScrollState) {
        this.mScrollState = mScrollState;
    }
    
    public void onPageScrolled(int n, final float n2, final int n3) {
        if (n2 > 0.5f) {
            ++n;
        }
        this$0.updateTextPositions(n, n2, false);
    }
    
    public void onPageSelected(final int n) {
        if (mScrollState == 0) {
            this$0.updateText(mPager.getCurrentItem(), mPager.getAdapter());
            final float n2 = fcmpl(PagerTitleStrip.access$100(this$0), 0.0f);
            float access$100 = 0.0f;
            if (n2 >= 0) {
                access$100 = PagerTitleStrip.access$100(this$0);
            }
            this$0.updateTextPositions(mPager.getCurrentItem(), access$100, true);
        }
    }
}
