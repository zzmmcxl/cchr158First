package android.support.design.widget;

import android.view.ViewParent;
import android.support.v4.widget.TextViewCompat;
import android.widget.Toast;
import android.view.accessibility.AccessibilityNodeInfo;
import android.annotation.TargetApi;
import android.support.v7.app.ActionBar;
import android.view.accessibility.AccessibilityEvent;
import android.view.ViewGroup$MarginLayoutParams;
import android.text.Layout;
import android.widget.TextView;
import android.widget.ImageView;
import android.view.View$OnLongClickListener;
import java.lang.ref.WeakReference;
import android.support.v7.widget.AppCompatDrawableManager;
import android.support.annotation.DrawableRes;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;
import android.graphics.drawable.Drawable;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.widget.LinearLayout;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Annotation;
import android.support.annotation.ColorInt;
import java.util.Iterator;
import android.view.View$MeasureSpec;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.LinearLayout$LayoutParams;
import android.support.v4.view.ViewCompat;
import android.support.annotation.NonNull;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.design.R;
import android.view.ViewGroup$LayoutParams;
import android.view.View;
import android.widget.FrameLayout$LayoutParams;
import android.util.AttributeSet;
import android.content.Context;
import android.support.v4.view.ViewPager;
import java.util.ArrayList;
import android.content.res.ColorStateList;
import android.database.DataSetObserver;
import android.support.v4.view.PagerAdapter;
import android.support.v4.util.Pools;
import android.widget.HorizontalScrollView;

public class TabLayout extends HorizontalScrollView
{
    private static final int ANIMATION_DURATION = 300;
    private static final int DEFAULT_GAP_TEXT_ICON = 8;
    private static final int DEFAULT_HEIGHT = 48;
    private static final int DEFAULT_HEIGHT_WITH_TEXT_ICON = 72;
    private static final int FIXED_WRAP_GUTTER_MIN = 16;
    public static final int GRAVITY_CENTER = 1;
    public static final int GRAVITY_FILL = 0;
    private static final int INVALID_WIDTH = -1;
    public static final int MODE_FIXED = 1;
    public static final int MODE_SCROLLABLE = 0;
    private static final int MOTION_NON_ADJACENT_OFFSET = 24;
    private static final int TAB_MIN_WIDTH_MARGIN = 56;
    private static final Pools.Pool<Tab> sTabPool;
    private int mContentInsetStart;
    private int mMode;
    private OnTabSelectedListener mOnTabSelectedListener;
    private TabLayoutOnPageChangeListener mPageChangeListener;
    private PagerAdapter mPagerAdapter;
    private DataSetObserver mPagerAdapterObserver;
    private final int mRequestedTabMaxWidth;
    private final int mRequestedTabMinWidth;
    private ValueAnimatorCompat mScrollAnimator;
    private final int mScrollableTabMinWidth;
    private Tab mSelectedTab;
    private final int mTabBackgroundResId;
    private int mTabGravity;
    private int mTabMaxWidth;
    private int mTabPaddingBottom;
    private int mTabPaddingEnd;
    private int mTabPaddingStart;
    private int mTabPaddingTop;
    private final SlidingTabStrip mTabStrip;
    private int mTabTextAppearance;
    private ColorStateList mTabTextColors;
    private float mTabTextMultiLineSize;
    private float mTabTextSize;
    private final Pools.Pool<TabView> mTabViewPool;
    private final ArrayList<Tab> mTabs;
    private ViewPager mViewPager;
    
    static {
        sTabPool = new Pools.SynchronizedPool<Tab>(16);
    }
    
    public TabLayout(final Context context) {
        this(context, null);
    }
    
    public TabLayout(final Context context, final AttributeSet set) {
        this(context, set, 0);
    }
    
    public TabLayout(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        mTabs = new ArrayList<Tab>();
        mTabMaxWidth = Integer.MAX_VALUE;
        mTabViewPool = new Pools.SimplePool<TabView>(12);
        ThemeUtils.checkAppCompatTheme(context);
        this.setHorizontalScrollBarEnabled(false);
        super.addView((View)(mTabStrip = new SlidingTabStrip(context)), 0, (ViewGroup$LayoutParams)new FrameLayout$LayoutParams(-2, -1));
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, R.styleable.TabLayout, n, R.style.Widget_Design_TabLayout);
        mTabStrip.setSelectedIndicatorHeight(obtainStyledAttributes.getDimensionPixelSize(R.styleable.TabLayout_tabIndicatorHeight, 0));
        mTabStrip.setSelectedIndicatorColor(obtainStyledAttributes.getColor(R.styleable.TabLayout_tabIndicatorColor, 0));
        final int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TabLayout_tabPadding, 0);
        mTabPaddingBottom = dimensionPixelSize;
        mTabPaddingEnd = dimensionPixelSize;
        mTabPaddingTop = dimensionPixelSize;
        mTabPaddingStart = dimensionPixelSize;
        mTabPaddingStart = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingStart, mTabPaddingStart);
        mTabPaddingTop = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingTop, mTabPaddingTop);
        mTabPaddingEnd = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingEnd, mTabPaddingEnd);
        mTabPaddingBottom = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingBottom, mTabPaddingBottom);
        mTabTextAppearance = obtainStyledAttributes.getResourceId(R.styleable.TabLayout_tabTextAppearance, R.style.TextAppearance_Design_Tab);
        final TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(mTabTextAppearance, R.styleable.TextAppearance);
        try {
            mTabTextSize = obtainStyledAttributes2.getDimensionPixelSize(R.styleable.TextAppearance_android_textSize, 0);
            mTabTextColors = obtainStyledAttributes2.getColorStateList(R.styleable.TextAppearance_android_textColor);
            obtainStyledAttributes2.recycle();
            if (obtainStyledAttributes.hasValue(R.styleable.TabLayout_tabTextColor)) {
                mTabTextColors = obtainStyledAttributes.getColorStateList(R.styleable.TabLayout_tabTextColor);
            }
            if (obtainStyledAttributes.hasValue(R.styleable.TabLayout_tabSelectedTextColor)) {
                mTabTextColors = createColorStateList(mTabTextColors.getDefaultColor(), obtainStyledAttributes.getColor(R.styleable.TabLayout_tabSelectedTextColor, 0));
            }
            mRequestedTabMinWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TabLayout_tabMinWidth, -1);
            mRequestedTabMaxWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TabLayout_tabMaxWidth, -1);
            mTabBackgroundResId = obtainStyledAttributes.getResourceId(R.styleable.TabLayout_tabBackground, 0);
            mContentInsetStart = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TabLayout_tabContentStart, 0);
            mMode = obtainStyledAttributes.getInt(R.styleable.TabLayout_tabMode, 1);
            mTabGravity = obtainStyledAttributes.getInt(R.styleable.TabLayout_tabGravity, 0);
            obtainStyledAttributes.recycle();
            final Resources resources = this.getResources();
            mTabTextMultiLineSize = resources.getDimensionPixelSize(R.dimen.design_tab_text_size_2line);
            mScrollableTabMinWidth = resources.getDimensionPixelSize(R.dimen.design_tab_scrollable_min_width);
            this.applyModeAndGravity();
        }
        finally {
            obtainStyledAttributes2.recycle();
        }
    }
    
    static /* synthetic */ int access$1000(final TabLayout tabLayout) {
        return tabLayout.mTabPaddingStart;
    }
    
    static /* synthetic */ int access$1100(final TabLayout tabLayout) {
        return tabLayout.mTabPaddingTop;
    }
    
    static /* synthetic */ int access$1200(final TabLayout tabLayout) {
        return tabLayout.mTabPaddingEnd;
    }
    
    static /* synthetic */ int access$1300(final TabLayout tabLayout) {
        return tabLayout.mTabPaddingBottom;
    }
    
    static /* synthetic */ int access$1400(final TabLayout tabLayout) {
        return tabLayout.getTabMaxWidth();
    }
    
    static /* synthetic */ int access$1500(final TabLayout tabLayout) {
        return tabLayout.mTabMaxWidth;
    }
    
    static /* synthetic */ float access$1600(final TabLayout tabLayout) {
        return tabLayout.mTabTextSize;
    }
    
    static /* synthetic */ float access$1700(final TabLayout tabLayout) {
        return tabLayout.mTabTextMultiLineSize;
    }
    
    static /* synthetic */ int access$1800(final TabLayout tabLayout) {
        return tabLayout.mMode;
    }
    
    static /* synthetic */ int access$1900(final TabLayout tabLayout) {
        return tabLayout.mTabTextAppearance;
    }
    
    static /* synthetic */ ColorStateList access$2000(final TabLayout tabLayout) {
        return tabLayout.mTabTextColors;
    }
    
    static /* synthetic */ int access$2100(final TabLayout tabLayout, final int n) {
        return tabLayout.dpToPx(n);
    }
    
    static /* synthetic */ int access$2200(final TabLayout tabLayout) {
        return tabLayout.mTabGravity;
    }
    
    static /* synthetic */ int access$2202(final TabLayout tabLayout, final int mTabGravity) {
        return tabLayout.mTabGravity = mTabGravity;
    }
    
    static /* synthetic */ void access$2300(final TabLayout tabLayout, final boolean b) {
        tabLayout.updateTabViews(b);
    }
    
    static /* synthetic */ void access$2700(final TabLayout tabLayout, final int n, final float n2, final boolean b, final boolean b2) {
        tabLayout.setScrollPosition(n, n2, b, b2);
    }
    
    static /* synthetic */ void access$2800(final TabLayout tabLayout) {
        tabLayout.populateFromPagerAdapter();
    }
    
    static /* synthetic */ int access$900(final TabLayout tabLayout) {
        return tabLayout.mTabBackgroundResId;
    }
    
    private void addTabFromItemView(@NonNull final TabItem tabItem) {
        final Tab tab = this.newTab();
        if (tabItem.mText != null) {
            tab.setText(tabItem.mText);
        }
        if (tabItem.mIcon != null) {
            tab.setIcon(tabItem.mIcon);
        }
        if (tabItem.mCustomLayout != 0) {
            tab.setCustomView(tabItem.mCustomLayout);
        }
        this.addTab(tab);
    }
    
    private void addTabView(final Tab tab, final int n, final boolean b) {
        final TabView access$200 = tab.mView;
        mTabStrip.addView((View)access$200, n, (ViewGroup$LayoutParams)this.createLayoutParamsForTabs());
        if (b) {
            access$200.setSelected(true);
        }
    }
    
    private void addTabView(final Tab tab, final boolean b) {
        final TabView access$200 = tab.mView;
        mTabStrip.addView((View)access$200, (ViewGroup$LayoutParams)this.createLayoutParamsForTabs());
        if (b) {
            access$200.setSelected(true);
        }
    }
    
    private void addViewInternal(final View view) {
        if (view instanceof TabItem) {
            this.addTabFromItemView((TabItem)view);
            return;
        }
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }
    
    private void animateToTab(final int n) {
        if (n == -1) {
            return;
        }
        if (this.getWindowToken() == null || !ViewCompat.isLaidOut((View)this) || mTabStrip.childrenNeedLayout()) {
            this.setScrollPosition(n, 0.0f, true);
            return;
        }
        final int scrollX = this.getScrollX();
        final int calculateScrollXForTab = this.calculateScrollXForTab(n, 0.0f);
        if (scrollX != calculateScrollXForTab) {
            if (mScrollAnimator == null) {
                (mScrollAnimator = ViewUtils.createAnimator()).setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
                mScrollAnimator.setDuration(300);
                mScrollAnimator.setUpdateListener((ValueAnimatorCompat.AnimatorUpdateListener)new ValueAnimatorCompat.AnimatorUpdateListener() {
                    final /* synthetic */ TabLayout this$0;
                    
                    TabLayout$1() {
                        this$0 = this$0;
                        super();
                    }
                    
                    @Override
                    public void onAnimationUpdate(final ValueAnimatorCompat valueAnimatorCompat) {
                        this$0.scrollTo(valueAnimatorCompat.getAnimatedIntValue(), 0);
                    }
                });
            }
            mScrollAnimator.setIntValues(scrollX, calculateScrollXForTab);
            mScrollAnimator.start();
        }
        mTabStrip.animateIndicatorToPosition(n, 300);
    }
    
    private void applyModeAndGravity() {
        final int mMode = this.mMode;
        int max = 0;
        if (mMode == 0) {
            max = Math.max(0, mContentInsetStart - mTabPaddingStart);
        }
        ViewCompat.setPaddingRelative((View)mTabStrip, max, 0, 0, 0);
        switch (this.mMode) {
            case 1:
                mTabStrip.setGravity(1);
                break;
            case 0:
                mTabStrip.setGravity(8388611);
                break;
        }
        this.updateTabViews(true);
    }
    
    private int calculateScrollXForTab(final int n, final float n2) {
        final int mMode = this.mMode;
        int n3 = 0;
        if (mMode == 0) {
            final View child = mTabStrip.getChildAt(n);
            View child2;
            if (n + 1 < mTabStrip.getChildCount()) {
                child2 = mTabStrip.getChildAt(n + 1);
            }
            else {
                child2 = null;
            }
            int width;
            if (child != null) {
                width = child.getWidth();
            }
            else {
                width = 0;
            }
            int width2 = 0;
            if (child2 != null) {
                width2 = child2.getWidth();
            }
            n3 = child.getLeft() + (int)(0.5f * (n2 * (width + width2))) + child.getWidth() / 2 - this.getWidth() / 2;
        }
        return n3;
    }
    
    private void configureTab(final Tab tab, final int position) {
        tab.setPosition(position);
        mTabs.add(position, tab);
        for (int size = mTabs.size(), i = position + 1; i < size; ++i) {
            ((Tab)mTabs.get(i)).setPosition(i);
        }
    }
    
    private static ColorStateList createColorStateList(final int n, final int n2) {
        final int[][] array = new int[2][];
        final int[] array2 = new int[2];
        array[0] = TabLayout.SELECTED_STATE_SET;
        array2[0] = n2;
        final int n3 = 0 + 1;
        array[n3] = TabLayout.EMPTY_STATE_SET;
        array2[n3] = n;
        return new ColorStateList(array, array2);
    }
    
    private LinearLayout$LayoutParams createLayoutParamsForTabs() {
        final LinearLayout$LayoutParams linearLayout$LayoutParams = new LinearLayout$LayoutParams(-2, -1);
        this.updateTabViewLayoutParams(linearLayout$LayoutParams);
        return linearLayout$LayoutParams;
    }
    
    private TabView createTabView(@NonNull final Tab tab) {
        TabView tabView;
        if (mTabViewPool != null) {
            tabView = mTabViewPool.acquire();
        }
        else {
            tabView = null;
        }
        if (tabView == null) {
            tabView = new TabView(this.getContext());
        }
        tabView.setTab(tab);
        tabView.setFocusable(true);
        tabView.setMinimumWidth(this.getTabMinWidth());
        return tabView;
    }
    
    private int dpToPx(final int n) {
        return Math.round(this.getResources().getDisplayMetrics().density * (float)n);
    }
    
    private int getDefaultHeight() {
        int n = 0;
        final int size = mTabs.size();
        boolean b;
        while (true) {
            b = false;
            if (n >= size) {
                break;
            }
            final Tab tab = (Tab)mTabs.get(n);
            if (tab != null && tab.getIcon() != null && !TextUtils.isEmpty(tab.getText())) {
                b = true;
                break;
            }
            ++n;
        }
        if (b) {
            return 72;
        }
        return 48;
    }
    
    private float getScrollPosition() {
        return mTabStrip.getIndicatorPosition();
    }
    
    private int getTabMaxWidth() {
        return mTabMaxWidth;
    }
    
    private int getTabMinWidth() {
        if (mRequestedTabMinWidth != -1) {
            return mRequestedTabMinWidth;
        }
        if (mMode == 0) {
            return mScrollableTabMinWidth;
        }
        return 0;
    }
    
    private int getTabScrollRange() {
        return Math.max(0, mTabStrip.getWidth() - this.getWidth() - this.getPaddingLeft() - this.getPaddingRight());
    }
    
    private void populateFromPagerAdapter() {
        this.removeAllTabs();
        if (mPagerAdapter != null) {
            final int count = mPagerAdapter.getCount();
            for (int i = 0; i < count; ++i) {
                this.addTab(this.newTab().setText(mPagerAdapter.getPageTitle(i)), false);
            }
            if (mViewPager != null && count > 0) {
                final int currentItem = mViewPager.getCurrentItem();
                if (currentItem != this.getSelectedTabPosition() && currentItem < this.getTabCount()) {
                    this.selectTab(this.getTabAt(currentItem));
                }
            }
            return;
        }
        this.removeAllTabs();
    }
    
    private void removeTabViewAt(final int n) {
        final TabView tabView = (TabView)mTabStrip.getChildAt(n);
        mTabStrip.removeViewAt(n);
        if (tabView != null) {
            tabView.reset();
            mTabViewPool.release(tabView);
        }
        this.requestLayout();
    }
    
    private void setPagerAdapter(@Nullable final PagerAdapter mPagerAdapter, final boolean b) {
        if (this.mPagerAdapter != null && mPagerAdapterObserver != null) {
            this.mPagerAdapter.unregisterDataSetObserver(mPagerAdapterObserver);
        }
        this.mPagerAdapter = mPagerAdapter;
        if (b && mPagerAdapter != null) {
            if (mPagerAdapterObserver == null) {
                mPagerAdapterObserver = new PagerAdapterObserver(this);
            }
            mPagerAdapter.registerDataSetObserver(mPagerAdapterObserver);
        }
        this.populateFromPagerAdapter();
    }
    
    private void setScrollPosition(final int n, final float n2, final boolean b, final boolean b2) {
        final int round = Math.round(n2 + (float)n);
        if (round >= 0 && round < mTabStrip.getChildCount()) {
            if (b2) {
                mTabStrip.setIndicatorPositionFromTabPosition(n, n2);
            }
            if (mScrollAnimator != null && mScrollAnimator.isRunning()) {
                mScrollAnimator.cancel();
            }
            this.scrollTo(this.calculateScrollXForTab(n, n2), 0);
            if (b) {
                this.setSelectedTabView(round);
            }
        }
    }
    
    private void setSelectedTabView(final int n) {
        final int childCount = mTabStrip.getChildCount();
        if (n < childCount && !mTabStrip.getChildAt(n).isSelected()) {
            for (int i = 0; i < childCount; ++i) {
                mTabStrip.getChildAt(i).setSelected(i == n);
            }
        }
    }
    
    private void updateAllTabs() {
        for (int i = 0; i < mTabs.size(); ++i) {
            ((Tab)mTabs.get(i)).updateView();
        }
    }
    
    private void updateTabViewLayoutParams(final LinearLayout$LayoutParams linearLayout$LayoutParams) {
        if (mMode == 1 && mTabGravity == 0) {
            linearLayout$LayoutParams.width = 0;
            linearLayout$LayoutParams.weight = 1.0f;
            return;
        }
        linearLayout$LayoutParams.width = -2;
        linearLayout$LayoutParams.weight = 0.0f;
    }
    
    private void updateTabViews(final boolean b) {
        for (int i = 0; i < mTabStrip.getChildCount(); ++i) {
            final View child = mTabStrip.getChildAt(i);
            child.setMinimumWidth(this.getTabMinWidth());
            this.updateTabViewLayoutParams((LinearLayout$LayoutParams)child.getLayoutParams());
            if (b) {
                child.requestLayout();
            }
        }
    }
    
    public void addTab(@NonNull final Tab tab) {
        this.addTab(tab, mTabs.isEmpty());
    }
    
    public void addTab(@NonNull final Tab tab, final int n) {
        this.addTab(tab, n, mTabs.isEmpty());
    }
    
    public void addTab(@NonNull final Tab tab, final int n, final boolean b) {
        if (tab.mParent != this) {
            throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
        }
        this.addTabView(tab, n, b);
        this.configureTab(tab, n);
        if (b) {
            tab.select();
        }
    }
    
    public void addTab(@NonNull final Tab tab, final boolean b) {
        if (tab.mParent != this) {
            throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
        }
        this.addTabView(tab, b);
        this.configureTab(tab, mTabs.size());
        if (b) {
            tab.select();
        }
    }
    
    public void addView(final View view) {
        this.addViewInternal(view);
    }
    
    public void addView(final View view, final int n) {
        this.addViewInternal(view);
    }
    
    public void addView(final View view, final int n, final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        this.addViewInternal(view);
    }
    
    public void addView(final View view, final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        this.addViewInternal(view);
    }
    
    public /* bridge */ ViewGroup$LayoutParams generateLayoutParams(final AttributeSet set) {
        return (ViewGroup$LayoutParams)this.generateLayoutParams(set);
    }
    
    public FrameLayout$LayoutParams generateLayoutParams(final AttributeSet set) {
        return this.generateDefaultLayoutParams();
    }
    
    public int getSelectedTabPosition() {
        if (mSelectedTab != null) {
            return mSelectedTab.getPosition();
        }
        return -1;
    }
    
    @Nullable
    public Tab getTabAt(final int n) {
        return mTabs.get(n);
    }
    
    public int getTabCount() {
        return mTabs.size();
    }
    
    public int getTabGravity() {
        return mTabGravity;
    }
    
    public int getTabMode() {
        return mMode;
    }
    
    @Nullable
    public ColorStateList getTabTextColors() {
        return mTabTextColors;
    }
    
    @NonNull
    public Tab newTab() {
        Tab tab = (Tab)sTabPool.acquire();
        if (tab == null) {
            tab = new Tab();
        }
        tab.mParent = this;
        tab.mView = this.createTabView(tab);
        return tab;
    }
    
    protected void onMeasure(final int n, int n2) {
        final int n3 = this.dpToPx(this.getDefaultHeight()) + this.getPaddingTop() + this.getPaddingBottom();
        switch (View$MeasureSpec.getMode(n2)) {
            case Integer.MIN_VALUE:
                n2 = View$MeasureSpec.makeMeasureSpec(Math.min(n3, View$MeasureSpec.getSize(n2)), 1073741824);
                break;
            case 0:
                n2 = View$MeasureSpec.makeMeasureSpec(n3, 1073741824);
                break;
        }
        final int size = View$MeasureSpec.getSize(n);
        if (View$MeasureSpec.getMode(n) != 0) {
            int mRequestedTabMaxWidth;
            if (this.mRequestedTabMaxWidth > 0) {
                mRequestedTabMaxWidth = this.mRequestedTabMaxWidth;
            }
            else {
                mRequestedTabMaxWidth = size - this.dpToPx(56);
            }
            mTabMaxWidth = mRequestedTabMaxWidth;
        }
        super.onMeasure(n, n2);
        if (this.getChildCount() == 1) {
            final View child = this.getChildAt(0);
            final int mMode = this.mMode;
            int n4 = 0;
            switch (mMode) {
                case 0:
                    if (child.getMeasuredWidth() < this.getMeasuredWidth()) {
                        n4 = 1;
                    }
                    else {
                        n4 = 0;
                    }
                    break;
                case 1:
                    if (child.getMeasuredWidth() != this.getMeasuredWidth()) {
                        n4 = 1;
                    }
                    else {
                        n4 = 0;
                    }
                    break;
            }
            if (n4 != 0) {
                child.measure(View$MeasureSpec.makeMeasureSpec(this.getMeasuredWidth(), 1073741824), getChildMeasureSpec(n2, this.getPaddingTop() + this.getPaddingBottom(), child.getLayoutParams().height));
            }
        }
    }
    
    public void removeAllTabs() {
        for (int i = -1 + mTabStrip.getChildCount(); i >= 0; --i) {
            this.removeTabViewAt(i);
        }
        final Iterator<Tab> iterator = mTabs.iterator();
        while (iterator.hasNext()) {
            final Tab tab = (Tab)iterator.next();
            iterator.remove();
            tab.reset();
            sTabPool.release(tab);
        }
        mSelectedTab = null;
    }
    
    public void removeTab(final Tab tab) {
        if (tab.mParent != this) {
            throw new IllegalArgumentException("Tab does not belong to this TabLayout.");
        }
        this.removeTabAt(tab.getPosition());
    }
    
    public void removeTabAt(final int n) {
        int position;
        if (mSelectedTab != null) {
            position = mSelectedTab.getPosition();
        }
        else {
            position = 0;
        }
        this.removeTabViewAt(n);
        final Tab tab = (Tab)mTabs.remove(n);
        if (tab != null) {
            tab.reset();
            sTabPool.release(tab);
        }
        for (int size = mTabs.size(), i = n; i < size; ++i) {
            ((Tab)mTabs.get(i)).setPosition(i);
        }
        if (position == n) {
            Tab tab2;
            if (mTabs.isEmpty()) {
                tab2 = null;
            }
            else {
                tab2 = mTabs.get(Math.max(0, n - 1));
            }
            this.selectTab(tab2);
        }
    }
    
    void selectTab(final Tab tab) {
        this.selectTab(tab, true);
    }
    
    void selectTab(final Tab mSelectedTab, final boolean b) {
        if (this.mSelectedTab == mSelectedTab) {
            if (this.mSelectedTab != null) {
                if (mOnTabSelectedListener != null) {
                    mOnTabSelectedListener.onTabReselected(this.mSelectedTab);
                }
                this.animateToTab(mSelectedTab.getPosition());
            }
        }
        else {
            if (b) {
                int position;
                if (mSelectedTab != null) {
                    position = mSelectedTab.getPosition();
                }
                else {
                    position = -1;
                }
                if (position != -1) {
                    this.setSelectedTabView(position);
                }
                if ((this.mSelectedTab == null || this.mSelectedTab.getPosition() == -1) && position != -1) {
                    this.setScrollPosition(position, 0.0f, true);
                }
                else {
                    this.animateToTab(position);
                }
            }
            if (this.mSelectedTab != null && mOnTabSelectedListener != null) {
                mOnTabSelectedListener.onTabUnselected(this.mSelectedTab);
            }
            this.mSelectedTab = mSelectedTab;
            if (this.mSelectedTab != null && mOnTabSelectedListener != null) {
                mOnTabSelectedListener.onTabSelected(this.mSelectedTab);
            }
        }
    }
    
    public void setOnTabSelectedListener(final OnTabSelectedListener mOnTabSelectedListener) {
        this.mOnTabSelectedListener = mOnTabSelectedListener;
    }
    
    public void setScrollPosition(final int n, final float n2, final boolean b) {
        this.setScrollPosition(n, n2, b, true);
    }
    
    public void setSelectedTabIndicatorColor(@ColorInt final int selectedIndicatorColor) {
        mTabStrip.setSelectedIndicatorColor(selectedIndicatorColor);
    }
    
    public void setSelectedTabIndicatorHeight(final int selectedIndicatorHeight) {
        mTabStrip.setSelectedIndicatorHeight(selectedIndicatorHeight);
    }
    
    public void setTabGravity(final int mTabGravity) {
        if (this.mTabGravity != mTabGravity) {
            this.mTabGravity = mTabGravity;
            this.applyModeAndGravity();
        }
    }
    
    public void setTabMode(final int mMode) {
        if (mMode != this.mMode) {
            this.mMode = mMode;
            this.applyModeAndGravity();
        }
    }
    
    public void setTabTextColors(final int n, final int n2) {
        this.setTabTextColors(createColorStateList(n, n2));
    }
    
    public void setTabTextColors(@Nullable final ColorStateList mTabTextColors) {
        if (this.mTabTextColors != mTabTextColors) {
            this.mTabTextColors = mTabTextColors;
            this.updateAllTabs();
        }
    }
    
    @Deprecated
    public void setTabsFromPagerAdapter(@Nullable final PagerAdapter pagerAdapter) {
        this.setPagerAdapter(pagerAdapter, false);
    }
    
    public void setupWithViewPager(@Nullable final ViewPager mViewPager) {
        if (this.mViewPager != null && mPageChangeListener != null) {
            this.mViewPager.removeOnPageChangeListener((ViewPager.OnPageChangeListener)mPageChangeListener);
        }
        if (mViewPager == null) {
            this.mViewPager = null;
            this.setOnTabSelectedListener(null);
            this.setPagerAdapter(null, true);
            return;
        }
        final PagerAdapter adapter = mViewPager.getAdapter();
        if (adapter == null) {
            throw new IllegalArgumentException("ViewPager does not have a PagerAdapter set");
        }
        this.mViewPager = mViewPager;
        if (mPageChangeListener == null) {
            mPageChangeListener = new TabLayoutOnPageChangeListener(this);
        }
        mPageChangeListener.reset();
        mViewPager.addOnPageChangeListener((ViewPager.OnPageChangeListener)mPageChangeListener);
        this.setOnTabSelectedListener((OnTabSelectedListener)new ViewPagerOnTabSelectedListener(mViewPager));
        this.setPagerAdapter(adapter, true);
    }
    
    public boolean shouldDelayChildPressedState() {
        return this.getTabScrollRange() > 0;
    }
}
