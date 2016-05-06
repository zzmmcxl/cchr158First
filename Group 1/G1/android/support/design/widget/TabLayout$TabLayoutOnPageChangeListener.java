package android.support.design.widget;

import java.lang.ref.WeakReference;
import android.support.v4.view.ViewPager;

public static class TabLayoutOnPageChangeListener implements OnPageChangeListener
{
    private int mPreviousScrollState;
    private int mScrollState;
    private final WeakReference<TabLayout> mTabLayoutRef;
    
    public TabLayoutOnPageChangeListener(final TabLayout tabLayout) {
        super();
        this.mTabLayoutRef = new WeakReference<TabLayout>(tabLayout);
    }
    
    static /* synthetic */ void access$400(final TabLayoutOnPageChangeListener tabLayoutOnPageChangeListener) {
        tabLayoutOnPageChangeListener.reset();
    }
    
    private void reset() {
        mScrollState = 0;
        mPreviousScrollState = 0;
    }
    
    @Override
    public void onPageScrollStateChanged(final int mScrollState) {
        mPreviousScrollState = this.mScrollState;
        this.mScrollState = mScrollState;
    }
    
    @Override
    public void onPageScrolled(final int n, final float n2, final int n3) {
        final TabLayout tabLayout = (TabLayout)mTabLayoutRef.get();
        if (tabLayout != null) {
            TabLayout.access$2700(tabLayout, n, n2, mScrollState != 2 || mPreviousScrollState == 1, mScrollState != 2 || mPreviousScrollState != 0);
        }
    }
    
    @Override
    public void onPageSelected(final int n) {
        final TabLayout tabLayout = (TabLayout)mTabLayoutRef.get();
        if (tabLayout != null && tabLayout.getSelectedTabPosition() != n) {
            tabLayout.selectTab(tabLayout.getTabAt(n), mScrollState == 0 || (mScrollState == 2 && mPreviousScrollState == 0));
        }
    }
}
