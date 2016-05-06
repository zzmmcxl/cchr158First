package android.support.v7.widget;

import android.view.ViewParent;
import android.text.TextUtils$TruncateAt;
import android.text.TextUtils;
import android.widget.Toast;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityEvent;
import android.widget.TextView;
import android.widget.ImageView;
import android.view.View$OnLongClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.view.View$MeasureSpec;
import android.widget.AdapterView;
import android.os.Build$VERSION;
import android.content.res.Configuration;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.ViewCompat;
import android.widget.SpinnerAdapter;
import android.view.View$OnClickListener;
import android.widget.AbsListView$LayoutParams;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.support.v7.appcompat.R;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.support.v7.view.ActionBarPolicy;
import android.content.Context;
import android.view.animation.DecelerateInterpolator;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.widget.Spinner;
import android.view.animation.Interpolator;
import android.widget.AdapterView$OnItemSelectedListener;
import android.widget.HorizontalScrollView;

public class ScrollingTabContainerView extends HorizontalScrollView implements AdapterView$OnItemSelectedListener
{
    private static final int FADE_DURATION = 200;
    private static final String TAG = "ScrollingTabContainerView";
    private static final Interpolator sAlphaInterpolator;
    private boolean mAllowCollapse;
    private int mContentHeight;
    int mMaxTabWidth;
    private int mSelectedTabIndex;
    int mStackedTabMaxWidth;
    private TabClickListener mTabClickListener;
    private LinearLayoutCompat mTabLayout;
    Runnable mTabSelector;
    private Spinner mTabSpinner;
    protected final VisibilityAnimListener mVisAnimListener;
    protected ViewPropertyAnimatorCompat mVisibilityAnim;
    
    static {
        sAlphaInterpolator = (Interpolator)new DecelerateInterpolator();
    }
    
    public ScrollingTabContainerView(final Context context) {
        super(context);
        mVisAnimListener = new VisibilityAnimListener();
        this.setHorizontalScrollBarEnabled(false);
        final ActionBarPolicy value = ActionBarPolicy.get(context);
        this.setContentHeight(value.getTabContainerHeight());
        mStackedTabMaxWidth = value.getStackedTabMaxWidth();
        this.addView((View)(mTabLayout = this.createTabLayout()), new ViewGroup$LayoutParams(-2, -1));
    }
    
    static /* synthetic */ LinearLayoutCompat access$200(final ScrollingTabContainerView scrollingTabContainerView) {
        return scrollingTabContainerView.mTabLayout;
    }
    
    static /* synthetic */ TabView access$300(final ScrollingTabContainerView scrollingTabContainerView, final ActionBar.Tab tab, final boolean b) {
        return scrollingTabContainerView.createTabView(tab, b);
    }
    
    private Spinner createSpinner() {
        final AppCompatSpinner appCompatSpinner = new AppCompatSpinner(this.getContext(), null, R.attr.actionDropDownStyle);
        appCompatSpinner.setLayoutParams((ViewGroup$LayoutParams)new LinearLayoutCompat.LayoutParams(-2, -1));
        appCompatSpinner.setOnItemSelectedListener((AdapterView$OnItemSelectedListener)this);
        return appCompatSpinner;
    }
    
    private LinearLayoutCompat createTabLayout() {
        final LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(this.getContext(), null, R.attr.actionBarTabBarStyle);
        linearLayoutCompat.setMeasureWithLargestChildEnabled(true);
        linearLayoutCompat.setGravity(17);
        linearLayoutCompat.setLayoutParams((ViewGroup$LayoutParams)new LinearLayoutCompat.LayoutParams(-2, -1));
        return linearLayoutCompat;
    }
    
    private TabView createTabView(final ActionBar.Tab tab, final boolean b) {
        final TabView tabView = new TabView(this.getContext(), tab, b);
        if (b) {
            tabView.setBackgroundDrawable((Drawable)null);
            tabView.setLayoutParams((ViewGroup$LayoutParams)new AbsListView$LayoutParams(-1, mContentHeight));
            return tabView;
        }
        tabView.setFocusable(true);
        if (mTabClickListener == null) {
            mTabClickListener = new TabClickListener(this);
        }
        tabView.setOnClickListener((View$OnClickListener)mTabClickListener);
        return tabView;
    }
    
    private boolean isCollapsed() {
        return mTabSpinner != null && mTabSpinner.getParent() == this;
    }
    
    private void performCollapse() {
        if (this.isCollapsed()) {
            return;
        }
        if (mTabSpinner == null) {
            mTabSpinner = this.createSpinner();
        }
        this.removeView((View)mTabLayout);
        this.addView((View)mTabSpinner, new ViewGroup$LayoutParams(-2, -1));
        if (mTabSpinner.getAdapter() == null) {
            mTabSpinner.setAdapter((SpinnerAdapter)new TabAdapter(this));
        }
        if (mTabSelector != null) {
            this.removeCallbacks(mTabSelector);
            mTabSelector = null;
        }
        mTabSpinner.setSelection(mSelectedTabIndex);
    }
    
    private boolean performExpand() {
        if (!this.isCollapsed()) {
            return false;
        }
        this.removeView((View)mTabSpinner);
        this.addView((View)mTabLayout, new ViewGroup$LayoutParams(-2, -1));
        this.setTabSelected(mTabSpinner.getSelectedItemPosition());
        return false;
    }
    
    public void addTab(final ActionBar.Tab tab, final int n, final boolean b) {
        final TabView tabView = this.createTabView(tab, false);
        mTabLayout.addView((View)tabView, n, (ViewGroup$LayoutParams)new LinearLayoutCompat.LayoutParams(0, -1, 1.0f));
        if (mTabSpinner != null) {
            ((TabAdapter)mTabSpinner.getAdapter()).notifyDataSetChanged();
        }
        if (b) {
            tabView.setSelected(true);
        }
        if (mAllowCollapse) {
            this.requestLayout();
        }
    }
    
    public void addTab(final ActionBar.Tab tab, final boolean b) {
        final TabView tabView = this.createTabView(tab, false);
        mTabLayout.addView((View)tabView, (ViewGroup$LayoutParams)new LinearLayoutCompat.LayoutParams(0, -1, 1.0f));
        if (mTabSpinner != null) {
            ((TabAdapter)mTabSpinner.getAdapter()).notifyDataSetChanged();
        }
        if (b) {
            tabView.setSelected(true);
        }
        if (mAllowCollapse) {
            this.requestLayout();
        }
    }
    
    public void animateToTab(final int n) {
        final View child = mTabLayout.getChildAt(n);
        if (mTabSelector != null) {
            this.removeCallbacks(mTabSelector);
        }
        this.post(mTabSelector = new Runnable() {
            final /* synthetic */ ScrollingTabContainerView this$0;
            final /* synthetic */ View val$tabView;
            
            ScrollingTabContainerView$1() {
                this$0 = this$0;
                super();
            }
            
            @Override
            public void run() {
                this$0.smoothScrollTo(child.getLeft() - (this$0.getWidth() - child.getWidth()) / 2, 0);
                mTabSelector = null;
            }
        });
    }
    
    public void animateToVisibility(final int n) {
        if (mVisibilityAnim != null) {
            mVisibilityAnim.cancel();
        }
        if (n == 0) {
            if (this.getVisibility() != 0) {
                ViewCompat.setAlpha((View)this, 0.0f);
            }
            final ViewPropertyAnimatorCompat alpha = ViewCompat.animate((View)this).alpha(1.0f);
            alpha.setDuration(200L);
            alpha.setInterpolator(sAlphaInterpolator);
            alpha.setListener(mVisAnimListener.withFinalVisibility(alpha, n));
            alpha.start();
            return;
        }
        final ViewPropertyAnimatorCompat alpha2 = ViewCompat.animate((View)this).alpha(0.0f);
        alpha2.setDuration(200L);
        alpha2.setInterpolator(sAlphaInterpolator);
        alpha2.setListener(mVisAnimListener.withFinalVisibility(alpha2, n));
        alpha2.start();
    }
    
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (mTabSelector != null) {
            this.post(mTabSelector);
        }
    }
    
    protected void onConfigurationChanged(final Configuration configuration) {
        if (Build$VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        final ActionBarPolicy value = ActionBarPolicy.get(this.getContext());
        this.setContentHeight(value.getTabContainerHeight());
        mStackedTabMaxWidth = value.getStackedTabMaxWidth();
    }
    
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (mTabSelector != null) {
            this.removeCallbacks(mTabSelector);
        }
    }
    
    public void onItemSelected(final AdapterView<?> adapterView, final View view, final int n, final long n2) {
        ((TabView)view).getTab().select();
    }
    
    public void onMeasure(final int n, final int n2) {
        final int mode = View$MeasureSpec.getMode(n);
        final boolean fillViewport = mode == 1073741824;
        this.setFillViewport(fillViewport);
        final int childCount = mTabLayout.getChildCount();
        if (childCount > 1 && (mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            if (childCount > 2) {
                mMaxTabWidth = (int)(0.4f * View$MeasureSpec.getSize(n));
            }
            else {
                mMaxTabWidth = View$MeasureSpec.getSize(n) / 2;
            }
            mMaxTabWidth = Math.min(mMaxTabWidth, mStackedTabMaxWidth);
        }
        else {
            mMaxTabWidth = -1;
        }
        final int measureSpec = View$MeasureSpec.makeMeasureSpec(mContentHeight, 1073741824);
        int n3;
        if (!fillViewport && mAllowCollapse) {
            n3 = 1;
        }
        else {
            n3 = 0;
        }
        if (n3 != 0) {
            mTabLayout.measure(0, measureSpec);
            if (mTabLayout.getMeasuredWidth() > View$MeasureSpec.getSize(n)) {
                this.performCollapse();
            }
            else {
                this.performExpand();
            }
        }
        else {
            this.performExpand();
        }
        final int measuredWidth = this.getMeasuredWidth();
        super.onMeasure(n, measureSpec);
        final int measuredWidth2 = this.getMeasuredWidth();
        if (fillViewport && measuredWidth != measuredWidth2) {
            this.setTabSelected(mSelectedTabIndex);
        }
    }
    
    public void onNothingSelected(final AdapterView<?> adapterView) {
    }
    
    public void removeAllTabs() {
        mTabLayout.removeAllViews();
        if (mTabSpinner != null) {
            ((TabAdapter)mTabSpinner.getAdapter()).notifyDataSetChanged();
        }
        if (mAllowCollapse) {
            this.requestLayout();
        }
    }
    
    public void removeTabAt(final int n) {
        mTabLayout.removeViewAt(n);
        if (mTabSpinner != null) {
            ((TabAdapter)mTabSpinner.getAdapter()).notifyDataSetChanged();
        }
        if (mAllowCollapse) {
            this.requestLayout();
        }
    }
    
    public void setAllowCollapse(final boolean mAllowCollapse) {
        this.mAllowCollapse = mAllowCollapse;
    }
    
    public void setContentHeight(final int mContentHeight) {
        this.mContentHeight = mContentHeight;
        this.requestLayout();
    }
    
    public void setTabSelected(final int n) {
        mSelectedTabIndex = n;
        for (int childCount = mTabLayout.getChildCount(), i = 0; i < childCount; ++i) {
            final View child = mTabLayout.getChildAt(i);
            final boolean selected = i == n;
            child.setSelected(selected);
            if (selected) {
                this.animateToTab(n);
            }
        }
        if (mTabSpinner != null && n >= 0) {
            mTabSpinner.setSelection(n);
        }
    }
    
    public void updateTab(final int n) {
        ((TabView)mTabLayout.getChildAt(n)).update();
        if (mTabSpinner != null) {
            ((TabAdapter)mTabSpinner.getAdapter()).notifyDataSetChanged();
        }
        if (mAllowCollapse) {
            this.requestLayout();
        }
    }
}
