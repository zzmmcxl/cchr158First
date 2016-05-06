package android.support.v7.widget;

import android.view.ViewGroup$MarginLayoutParams;
import android.view.Window$Callback;
import android.support.v7.view.menu.MenuPresenter;
import android.view.Menu;
import android.os.Parcelable;
import android.util.SparseArray;
import android.os.Build$VERSION;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.view.ViewGroup$LayoutParams;
import android.content.res.TypedArray;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.util.AttributeSet;
import android.content.Context;
import android.support.v7.appcompat.R;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.NestedScrollingParentHelper;
import android.support.v4.widget.ScrollerCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.graphics.Rect;
import android.support.v4.view.NestedScrollingParent;
import android.view.ViewGroup;

public class ActionBarOverlayLayout extends ViewGroup implements DecorContentParent, NestedScrollingParent
{
    static final int[] ATTRS;
    private static final String TAG = "ActionBarOverlayLayout";
    private final int ACTION_BAR_ANIMATE_DELAY;
    private int mActionBarHeight;
    private ActionBarContainer mActionBarTop;
    private ActionBarVisibilityCallback mActionBarVisibilityCallback;
    private final Runnable mAddActionBarHideOffset;
    private boolean mAnimatingForFling;
    private final Rect mBaseContentInsets;
    private final Rect mBaseInnerInsets;
    private ContentFrameLayout mContent;
    private final Rect mContentInsets;
    private ViewPropertyAnimatorCompat mCurrentActionBarTopAnimator;
    private DecorToolbar mDecorToolbar;
    private ScrollerCompat mFlingEstimator;
    private boolean mHasNonEmbeddedTabs;
    private boolean mHideOnContentScroll;
    private int mHideOnContentScrollReference;
    private boolean mIgnoreWindowContentOverlay;
    private final Rect mInnerInsets;
    private final Rect mLastBaseContentInsets;
    private final Rect mLastInnerInsets;
    private int mLastSystemUiVisibility;
    private boolean mOverlayMode;
    private final NestedScrollingParentHelper mParentHelper;
    private final Runnable mRemoveActionBarHideOffset;
    private final ViewPropertyAnimatorListener mTopAnimatorListener;
    private Drawable mWindowContentOverlay;
    private int mWindowVisibility;
    
    static {
        ATTRS = new int[] { R.attr.actionBarSize, 16842841 };
    }
    
    public ActionBarOverlayLayout(final Context context) {
        this(context, null);
    }
    
    public ActionBarOverlayLayout(final Context context, final AttributeSet set) {
        super(context, set);
        mWindowVisibility = 0;
        mBaseContentInsets = new Rect();
        mLastBaseContentInsets = new Rect();
        mContentInsets = new Rect();
        mBaseInnerInsets = new Rect();
        mInnerInsets = new Rect();
        mLastInnerInsets = new Rect();
        ACTION_BAR_ANIMATE_DELAY = 600;
        mTopAnimatorListener = new ViewPropertyAnimatorListenerAdapter() {
            final /* synthetic */ ActionBarOverlayLayout this$0;
            
            ActionBarOverlayLayout$1() {
                this$0 = this$0;
                super();
            }
            
            @Override
            public void onAnimationCancel(final View view) {
                mCurrentActionBarTopAnimator = null;
                mAnimatingForFling = false;
            }
            
            @Override
            public void onAnimationEnd(final View view) {
                mCurrentActionBarTopAnimator = null;
                mAnimatingForFling = false;
            }
        };
        mRemoveActionBarHideOffset = new Runnable() {
            final /* synthetic */ ActionBarOverlayLayout this$0;
            
            ActionBarOverlayLayout$2() {
                this$0 = this$0;
                super();
            }
            
            @Override
            public void run() {
                this$0.haltActionBarHideOffsetAnimations();
                mCurrentActionBarTopAnimator = ViewCompat.animate((View)mActionBarTop).translationY(0.0f).setListener(mTopAnimatorListener);
            }
        };
        mAddActionBarHideOffset = new Runnable() {
            final /* synthetic */ ActionBarOverlayLayout this$0;
            
            ActionBarOverlayLayout$3() {
                this$0 = this$0;
                super();
            }
            
            @Override
            public void run() {
                this$0.haltActionBarHideOffsetAnimations();
                mCurrentActionBarTopAnimator = ViewCompat.animate((View)mActionBarTop).translationY(-mActionBarTop.getHeight()).setListener(mTopAnimatorListener);
            }
        };
        this.init(context);
        mParentHelper = new NestedScrollingParentHelper(this);
    }
    
    static /* synthetic */ ViewPropertyAnimatorCompat access$002(final ActionBarOverlayLayout actionBarOverlayLayout, final ViewPropertyAnimatorCompat mCurrentActionBarTopAnimator) {
        return actionBarOverlayLayout.mCurrentActionBarTopAnimator = mCurrentActionBarTopAnimator;
    }
    
    static /* synthetic */ boolean access$102(final ActionBarOverlayLayout actionBarOverlayLayout, final boolean mAnimatingForFling) {
        return actionBarOverlayLayout.mAnimatingForFling = mAnimatingForFling;
    }
    
    static /* synthetic */ void access$200(final ActionBarOverlayLayout actionBarOverlayLayout) {
        actionBarOverlayLayout.haltActionBarHideOffsetAnimations();
    }
    
    static /* synthetic */ ViewPropertyAnimatorListener access$300(final ActionBarOverlayLayout actionBarOverlayLayout) {
        return actionBarOverlayLayout.mTopAnimatorListener;
    }
    
    static /* synthetic */ ActionBarContainer access$400(final ActionBarOverlayLayout actionBarOverlayLayout) {
        return actionBarOverlayLayout.mActionBarTop;
    }
    
    private void addActionBarHideOffset() {
        this.haltActionBarHideOffsetAnimations();
        mAddActionBarHideOffset.run();
    }
    
    private boolean applyInsets(final View view, final Rect rect, final boolean b, final boolean b2, final boolean b3, final boolean b4) {
        final LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        boolean b5 = false;
        if (b) {
            final int leftMargin = layoutParams.leftMargin;
            final int left = rect.left;
            b5 = false;
            if (leftMargin != left) {
                b5 = true;
                layoutParams.leftMargin = rect.left;
            }
        }
        if (b2 && layoutParams.topMargin != rect.top) {
            b5 = true;
            layoutParams.topMargin = rect.top;
        }
        if (b4 && layoutParams.rightMargin != rect.right) {
            b5 = true;
            layoutParams.rightMargin = rect.right;
        }
        if (b3 && layoutParams.bottomMargin != rect.bottom) {
            b5 = true;
            layoutParams.bottomMargin = rect.bottom;
        }
        return b5;
    }
    
    private DecorToolbar getDecorToolbar(final View view) {
        if (view instanceof DecorToolbar) {
            return (DecorToolbar)view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar)view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }
    
    private void haltActionBarHideOffsetAnimations() {
        this.removeCallbacks(mRemoveActionBarHideOffset);
        this.removeCallbacks(mAddActionBarHideOffset);
        if (mCurrentActionBarTopAnimator != null) {
            mCurrentActionBarTopAnimator.cancel();
        }
    }
    
    private void init(final Context context) {
        int mIgnoreWindowContentOverlay = 1;
        final TypedArray obtainStyledAttributes = this.getContext().getTheme().obtainStyledAttributes(ATTRS);
        mActionBarHeight = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        mWindowContentOverlay = obtainStyledAttributes.getDrawable(mIgnoreWindowContentOverlay);
        boolean willNotDraw;
        if (mWindowContentOverlay == null) {
            willNotDraw = (mIgnoreWindowContentOverlay != 0);
        }
        else {
            willNotDraw = false;
        }
        this.setWillNotDraw(willNotDraw);
        obtainStyledAttributes.recycle();
        if (context.getApplicationInfo().targetSdkVersion >= 19) {
            mIgnoreWindowContentOverlay = 0;
        }
        this.mIgnoreWindowContentOverlay = (mIgnoreWindowContentOverlay != 0);
        mFlingEstimator = ScrollerCompat.create(context);
    }
    
    private void postAddActionBarHideOffset() {
        this.haltActionBarHideOffsetAnimations();
        this.postDelayed(mAddActionBarHideOffset, 600L);
    }
    
    private void postRemoveActionBarHideOffset() {
        this.haltActionBarHideOffsetAnimations();
        this.postDelayed(mRemoveActionBarHideOffset, 600L);
    }
    
    private void removeActionBarHideOffset() {
        this.haltActionBarHideOffsetAnimations();
        mRemoveActionBarHideOffset.run();
    }
    
    private boolean shouldHideActionBarOnFling(final float n, final float n2) {
        mFlingEstimator.fling(0, 0, 0, (int)n2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        final int finalY = mFlingEstimator.getFinalY();
        final int height = mActionBarTop.getHeight();
        boolean b = false;
        if (finalY > height) {
            b = true;
        }
        return b;
    }
    
    public boolean canShowOverflowMenu() {
        this.pullChildren();
        return mDecorToolbar.canShowOverflowMenu();
    }
    
    protected boolean checkLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        return viewGroup$LayoutParams instanceof LayoutParams;
    }
    
    public void dismissPopups() {
        this.pullChildren();
        mDecorToolbar.dismissPopupMenus();
    }
    
    public void draw(final Canvas canvas) {
        super.draw(canvas);
        if (mWindowContentOverlay != null && !mIgnoreWindowContentOverlay) {
            int n;
            if (mActionBarTop.getVisibility() == 0) {
                n = (int)(0.5f + (mActionBarTop.getBottom() + ViewCompat.getTranslationY((View)mActionBarTop)));
            }
            else {
                n = 0;
            }
            mWindowContentOverlay.setBounds(0, n, this.getWidth(), n + mWindowContentOverlay.getIntrinsicHeight());
            mWindowContentOverlay.draw(canvas);
        }
    }
    
    protected boolean fitSystemWindows(final Rect rect) {
        this.pullChildren();
        if ((0x100 & ViewCompat.getWindowSystemUiVisibility((View)this)) != 0x0) {}
        boolean applyInsets = this.applyInsets((View)mActionBarTop, rect, true, true, false, true);
        mBaseInnerInsets.set(rect);
        ViewUtils.computeFitSystemWindows((View)this, mBaseInnerInsets, mBaseContentInsets);
        if (!mLastBaseContentInsets.equals((Object)mBaseContentInsets)) {
            applyInsets = true;
            mLastBaseContentInsets.set(mBaseContentInsets);
        }
        if (applyInsets) {
            this.requestLayout();
        }
        return true;
    }
    
    protected LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }
    
    protected /* bridge */ ViewGroup$LayoutParams generateDefaultLayoutParams() {
        return (ViewGroup$LayoutParams)this.generateDefaultLayoutParams();
    }
    
    public LayoutParams generateLayoutParams(final AttributeSet set) {
        return new LayoutParams(this.getContext(), set);
    }
    
    public /* bridge */ ViewGroup$LayoutParams generateLayoutParams(final AttributeSet set) {
        return (ViewGroup$LayoutParams)this.generateLayoutParams(set);
    }
    
    protected ViewGroup$LayoutParams generateLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        return (ViewGroup$LayoutParams)new LayoutParams(viewGroup$LayoutParams);
    }
    
    public int getActionBarHideOffset() {
        if (mActionBarTop != null) {
            return -(int)ViewCompat.getTranslationY((View)mActionBarTop);
        }
        return 0;
    }
    
    public int getNestedScrollAxes() {
        return mParentHelper.getNestedScrollAxes();
    }
    
    public CharSequence getTitle() {
        this.pullChildren();
        return mDecorToolbar.getTitle();
    }
    
    public boolean hasIcon() {
        this.pullChildren();
        return mDecorToolbar.hasIcon();
    }
    
    public boolean hasLogo() {
        this.pullChildren();
        return mDecorToolbar.hasLogo();
    }
    
    public boolean hideOverflowMenu() {
        this.pullChildren();
        return mDecorToolbar.hideOverflowMenu();
    }
    
    public void initFeature(final int n) {
        this.pullChildren();
        switch (n) {
            default:
            case 2:
                mDecorToolbar.initProgress();
            case 5:
                mDecorToolbar.initIndeterminateProgress();
            case 109:
                this.setOverlayMode(true);
        }
    }
    
    public boolean isHideOnContentScrollEnabled() {
        return mHideOnContentScroll;
    }
    
    public boolean isInOverlayMode() {
        return mOverlayMode;
    }
    
    public boolean isOverflowMenuShowPending() {
        this.pullChildren();
        return mDecorToolbar.isOverflowMenuShowPending();
    }
    
    public boolean isOverflowMenuShowing() {
        this.pullChildren();
        return mDecorToolbar.isOverflowMenuShowing();
    }
    
    protected void onConfigurationChanged(final Configuration configuration) {
        if (Build$VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        this.init(this.getContext());
        ViewCompat.requestApplyInsets((View)this);
    }
    
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.haltActionBarHideOffsetAnimations();
    }
    
    protected void onLayout(final boolean b, final int n, final int n2, final int n3, final int n4) {
        final int childCount = this.getChildCount();
        final int paddingLeft = this.getPaddingLeft();
        final int n5 = n3 - n - this.getPaddingRight();
        final int paddingTop = this.getPaddingTop();
        final int n6 = n4 - n2 - this.getPaddingBottom();
        for (int i = 0; i < childCount; ++i) {
            final View child = this.getChildAt(i);
            if (child.getVisibility() != 8) {
                final LayoutParams layoutParams = (LayoutParams)child.getLayoutParams();
                final int measuredWidth = child.getMeasuredWidth();
                final int measuredHeight = child.getMeasuredHeight();
                final int n7 = paddingLeft + layoutParams.leftMargin;
                final int n8 = paddingTop + layoutParams.topMargin;
                child.layout(n7, n8, n7 + measuredWidth, n8 + measuredHeight);
            }
        }
    }
    
    protected void onMeasure(final int n, final int n2) {
        this.pullChildren();
        this.measureChildWithMargins((View)mActionBarTop, n, 0, n2, 0);
        final LayoutParams layoutParams = (LayoutParams)mActionBarTop.getLayoutParams();
        final int max = Math.max(0, mActionBarTop.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin);
        final int max2 = Math.max(0, mActionBarTop.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin);
        final int combineMeasuredStates = ViewUtils.combineMeasuredStates(0, ViewCompat.getMeasuredState((View)mActionBarTop));
        boolean b;
        if ((0x100 & ViewCompat.getWindowSystemUiVisibility((View)this)) != 0x0) {
            b = true;
        }
        else {
            b = false;
        }
        int n3;
        if (b) {
            n3 = mActionBarHeight;
            if (mHasNonEmbeddedTabs && mActionBarTop.getTabContainer() != null) {
                n3 += mActionBarHeight;
            }
        }
        else {
            final int visibility = mActionBarTop.getVisibility();
            n3 = 0;
            if (visibility != 8) {
                n3 = mActionBarTop.getMeasuredHeight();
            }
        }
        mContentInsets.set(mBaseContentInsets);
        mInnerInsets.set(mBaseInnerInsets);
        if (!mOverlayMode && !b) {
            final Rect mContentInsets = this.mContentInsets;
            mContentInsets.top += n3;
            final Rect mContentInsets2 = this.mContentInsets;
            mContentInsets2.bottom += 0;
        }
        else {
            final Rect mInnerInsets = this.mInnerInsets;
            mInnerInsets.top += n3;
            final Rect mInnerInsets2 = this.mInnerInsets;
            mInnerInsets2.bottom += 0;
        }
        this.applyInsets((View)mContent, mContentInsets, true, true, true, true);
        if (!mLastInnerInsets.equals((Object)mInnerInsets)) {
            mLastInnerInsets.set(mInnerInsets);
            mContent.dispatchFitSystemWindows(mInnerInsets);
        }
        this.measureChildWithMargins((View)mContent, n, 0, n2, 0);
        final LayoutParams layoutParams2 = (LayoutParams)mContent.getLayoutParams();
        final int max3 = Math.max(max, mContent.getMeasuredWidth() + layoutParams2.leftMargin + layoutParams2.rightMargin);
        final int max4 = Math.max(max2, mContent.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin);
        final int combineMeasuredStates2 = ViewUtils.combineMeasuredStates(combineMeasuredStates, ViewCompat.getMeasuredState((View)mContent));
        this.setMeasuredDimension(ViewCompat.resolveSizeAndState(Math.max(max3 + (this.getPaddingLeft() + this.getPaddingRight()), this.getSuggestedMinimumWidth()), n, combineMeasuredStates2), ViewCompat.resolveSizeAndState(Math.max(max4 + (this.getPaddingTop() + this.getPaddingBottom()), this.getSuggestedMinimumHeight()), n2, combineMeasuredStates2 << 16));
    }
    
    public boolean onNestedFling(final View view, final float n, final float n2, final boolean b) {
        if (!mHideOnContentScroll || !b) {
            return false;
        }
        if (this.shouldHideActionBarOnFling(n, n2)) {
            this.addActionBarHideOffset();
        }
        else {
            this.removeActionBarHideOffset();
        }
        return mAnimatingForFling = true;
    }
    
    public boolean onNestedPreFling(final View view, final float n, final float n2) {
        return false;
    }
    
    public void onNestedPreScroll(final View view, final int n, final int n2, final int[] array) {
    }
    
    public void onNestedScroll(final View view, final int n, final int n2, final int n3, final int n4) {
        this.setActionBarHideOffset(mHideOnContentScrollReference += n2);
    }
    
    public void onNestedScrollAccepted(final View view, final View view2, final int n) {
        mParentHelper.onNestedScrollAccepted(view, view2, n);
        mHideOnContentScrollReference = this.getActionBarHideOffset();
        this.haltActionBarHideOffsetAnimations();
        if (mActionBarVisibilityCallback != null) {
            mActionBarVisibilityCallback.onContentScrollStarted();
        }
    }
    
    public boolean onStartNestedScroll(final View view, final View view2, final int n) {
        return (n & 0x2) != 0x0 && mActionBarTop.getVisibility() == 0 && mHideOnContentScroll;
    }
    
    public void onStopNestedScroll(final View view) {
        if (mHideOnContentScroll && !mAnimatingForFling) {
            if (mHideOnContentScrollReference <= mActionBarTop.getHeight()) {
                this.postRemoveActionBarHideOffset();
            }
            else {
                this.postAddActionBarHideOffset();
            }
        }
        if (mActionBarVisibilityCallback != null) {
            mActionBarVisibilityCallback.onContentScrollStopped();
        }
    }
    
    public void onWindowSystemUiVisibilityChanged(final int mLastSystemUiVisibility) {
        boolean b = true;
        if (Build$VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(mLastSystemUiVisibility);
        }
        this.pullChildren();
        final int n = mLastSystemUiVisibility ^ this.mLastSystemUiVisibility;
        this.mLastSystemUiVisibility = mLastSystemUiVisibility;
        final boolean b2 = (mLastSystemUiVisibility & 0x4) == 0x0 && b;
        final boolean b3 = (mLastSystemUiVisibility & 0x100) != 0x0 && b;
        if (mActionBarVisibilityCallback != null) {
            final ActionBarVisibilityCallback mActionBarVisibilityCallback = this.mActionBarVisibilityCallback;
            if (b3) {
                b = false;
            }
            mActionBarVisibilityCallback.enableContentAnimations(b);
            if (b2 || !b3) {
                this.mActionBarVisibilityCallback.showForSystem();
            }
            else {
                this.mActionBarVisibilityCallback.hideForSystem();
            }
        }
        if ((n & 0x100) != 0x0 && mActionBarVisibilityCallback != null) {
            ViewCompat.requestApplyInsets((View)this);
        }
    }
    
    protected void onWindowVisibilityChanged(final int mWindowVisibility) {
        super.onWindowVisibilityChanged(mWindowVisibility);
        this.mWindowVisibility = mWindowVisibility;
        if (mActionBarVisibilityCallback != null) {
            mActionBarVisibilityCallback.onWindowVisibilityChanged(mWindowVisibility);
        }
    }
    
    void pullChildren() {
        if (mContent == null) {
            mContent = (ContentFrameLayout)this.findViewById(R.id.action_bar_activity_content);
            mActionBarTop = (ActionBarContainer)this.findViewById(R.id.action_bar_container);
            mDecorToolbar = this.getDecorToolbar(this.findViewById(R.id.action_bar));
        }
    }
    
    public void restoreToolbarHierarchyState(final SparseArray<Parcelable> sparseArray) {
        this.pullChildren();
        mDecorToolbar.restoreHierarchyState(sparseArray);
    }
    
    public void saveToolbarHierarchyState(final SparseArray<Parcelable> sparseArray) {
        this.pullChildren();
        mDecorToolbar.saveHierarchyState(sparseArray);
    }
    
    public void setActionBarHideOffset(final int n) {
        this.haltActionBarHideOffsetAnimations();
        ViewCompat.setTranslationY(mActionBarTop, (float)(-Math.max(0, Math.min(n, mActionBarTop.getHeight()))));
    }
    
    public void setActionBarVisibilityCallback(final ActionBarVisibilityCallback mActionBarVisibilityCallback) {
        this.mActionBarVisibilityCallback = mActionBarVisibilityCallback;
        if (this.getWindowToken() != null) {
            this.mActionBarVisibilityCallback.onWindowVisibilityChanged(mWindowVisibility);
            if (mLastSystemUiVisibility != 0) {
                this.onWindowSystemUiVisibilityChanged(mLastSystemUiVisibility);
                ViewCompat.requestApplyInsets((View)this);
            }
        }
    }
    
    public void setHasNonEmbeddedTabs(final boolean mHasNonEmbeddedTabs) {
        this.mHasNonEmbeddedTabs = mHasNonEmbeddedTabs;
    }
    
    public void setHideOnContentScrollEnabled(final boolean mHideOnContentScroll) {
        if (mHideOnContentScroll != this.mHideOnContentScroll && !(this.mHideOnContentScroll = mHideOnContentScroll)) {
            this.haltActionBarHideOffsetAnimations();
            this.setActionBarHideOffset(0);
        }
    }
    
    public void setIcon(final int icon) {
        this.pullChildren();
        mDecorToolbar.setIcon(icon);
    }
    
    public void setIcon(final Drawable icon) {
        this.pullChildren();
        mDecorToolbar.setIcon(icon);
    }
    
    public void setLogo(final int logo) {
        this.pullChildren();
        mDecorToolbar.setLogo(logo);
    }
    
    public void setMenu(final Menu menu, final MenuPresenter.Callback callback) {
        this.pullChildren();
        mDecorToolbar.setMenu(menu, callback);
    }
    
    public void setMenuPrepared() {
        this.pullChildren();
        mDecorToolbar.setMenuPrepared();
    }
    
    public void setOverlayMode(final boolean mOverlayMode) {
        this.mOverlayMode = mOverlayMode;
        mIgnoreWindowContentOverlay = (mOverlayMode && this.getContext().getApplicationInfo().targetSdkVersion < 19);
    }
    
    public void setShowingForActionMode(final boolean b) {
    }
    
    public void setUiOptions(final int n) {
    }
    
    public void setWindowCallback(final Window$Callback windowCallback) {
        this.pullChildren();
        mDecorToolbar.setWindowCallback(windowCallback);
    }
    
    public void setWindowTitle(final CharSequence windowTitle) {
        this.pullChildren();
        mDecorToolbar.setWindowTitle(windowTitle);
    }
    
    public boolean shouldDelayChildPressedState() {
        return false;
    }
    
    public boolean showOverflowMenu() {
        this.pullChildren();
        return mDecorToolbar.showOverflowMenu();
    }
}
