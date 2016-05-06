package android.support.design.widget;

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Annotation;
import android.support.v4.os.ParcelableCompat;
import android.os.Parcel;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.os.Parcelable$Creator;
import android.view.View$BaseSavedState;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.os.Parcelable;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
import android.view.ViewGroup$MarginLayoutParams;
import android.widget.LinearLayout$LayoutParams;
import android.view.ViewGroup$LayoutParams;
import android.content.res.TypedArray;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import java.util.ArrayList;
import android.view.View;
import android.support.design.R;
import android.util.AttributeSet;
import android.content.Context;
import java.util.List;
import android.support.v4.view.WindowInsetsCompat;
import android.widget.LinearLayout;

@CoordinatorLayout.DefaultBehavior("Landroid/support/design/widget/AppBarLayout$Behavior;")
public class AppBarLayout extends LinearLayout
{
    private static final int INVALID_SCROLL_RANGE = -1;
    private static final int PENDING_ACTION_ANIMATE_ENABLED = 4;
    private static final int PENDING_ACTION_COLLAPSED = 2;
    private static final int PENDING_ACTION_EXPANDED = 1;
    private static final int PENDING_ACTION_NONE;
    private int mDownPreScrollRange;
    private int mDownScrollRange;
    boolean mHaveChildWithInterpolator;
    private WindowInsetsCompat mLastInsets;
    private final List<OnOffsetChangedListener> mListeners;
    private int mPendingAction;
    private float mTargetElevation;
    private int mTotalScrollRange;
    
    public AppBarLayout(final Context context) {
        this(context, null);
    }
    
    public AppBarLayout(final Context context, final AttributeSet set) {
        super(context, set);
        mTotalScrollRange = -1;
        mDownPreScrollRange = -1;
        mDownScrollRange = -1;
        mPendingAction = 0;
        this.setOrientation(1);
        ThemeUtils.checkAppCompatTheme(context);
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, R.styleable.AppBarLayout, 0, R.style.Widget_Design_AppBarLayout);
        mTargetElevation = obtainStyledAttributes.getDimensionPixelSize(R.styleable.AppBarLayout_elevation, 0);
        this.setBackgroundDrawable(obtainStyledAttributes.getDrawable(R.styleable.AppBarLayout_android_background));
        if (obtainStyledAttributes.hasValue(R.styleable.AppBarLayout_expanded)) {
            this.setExpanded(obtainStyledAttributes.getBoolean(R.styleable.AppBarLayout_expanded, false));
        }
        obtainStyledAttributes.recycle();
        ViewUtils.setBoundsViewOutlineProvider((View)this);
        mListeners = new ArrayList<OnOffsetChangedListener>();
        ViewCompat.setElevation((View)this, mTargetElevation);
        ViewCompat.setOnApplyWindowInsetsListener(this, (OnApplyWindowInsetsListener)new OnApplyWindowInsetsListener() {
            final /* synthetic */ AppBarLayout this$0;
            
            AppBarLayout$1() {
                this$0 = this$0;
                super();
            }
            
            @Override
            public WindowInsetsCompat onApplyWindowInsets(final View view, final WindowInsetsCompat windowInsetsCompat) {
                return this$0.onWindowInsetChanged(windowInsetsCompat);
            }
        });
    }
    
    static /* synthetic */ WindowInsetsCompat access$000(final AppBarLayout appBarLayout, final WindowInsetsCompat windowInsetsCompat) {
        return appBarLayout.onWindowInsetChanged(windowInsetsCompat);
    }
    
    static /* synthetic */ boolean access$100(final AppBarLayout appBarLayout) {
        return appBarLayout.hasScrollableChildren();
    }
    
    static /* synthetic */ int access$200(final AppBarLayout appBarLayout) {
        return appBarLayout.getDownNestedPreScrollRange();
    }
    
    static /* synthetic */ int access$300(final AppBarLayout appBarLayout) {
        return appBarLayout.getUpNestedPreScrollRange();
    }
    
    static /* synthetic */ int access$400(final AppBarLayout appBarLayout) {
        return appBarLayout.getDownNestedScrollRange();
    }
    
    static /* synthetic */ int access$500(final AppBarLayout appBarLayout) {
        return appBarLayout.getPendingAction();
    }
    
    static /* synthetic */ void access$600(final AppBarLayout appBarLayout) {
        appBarLayout.resetPendingAction();
    }
    
    static /* synthetic */ boolean access$700(final AppBarLayout appBarLayout) {
        return appBarLayout.hasChildWithInterpolator();
    }
    
    static /* synthetic */ List access$800(final AppBarLayout appBarLayout) {
        return appBarLayout.mListeners;
    }
    
    static /* synthetic */ int access$900(final AppBarLayout appBarLayout) {
        return appBarLayout.getTopInset();
    }
    
    private int getDownNestedPreScrollRange() {
        if (mDownPreScrollRange != -1) {
            return mDownPreScrollRange;
        }
        int n = 0;
        for (int i = -1 + this.getChildCount(); i >= 0; --i) {
            final View child = this.getChildAt(i);
            final LayoutParams layoutParams = (LayoutParams)child.getLayoutParams();
            final int measuredHeight = child.getMeasuredHeight();
            final int mScrollFlags = layoutParams.mScrollFlags;
            if ((mScrollFlags & 0x5) == 0x5) {
                final int n2 = n + (layoutParams.topMargin + layoutParams.bottomMargin);
                if ((mScrollFlags & 0x8) != 0x0) {
                    n = n2 + ViewCompat.getMinimumHeight(child);
                }
                else if ((mScrollFlags & 0x2) != 0x0) {
                    n = n2 + (measuredHeight - ViewCompat.getMinimumHeight(child));
                }
                else {
                    n = n2 + measuredHeight;
                }
            }
            else if (n > 0) {
                break;
            }
        }
        return mDownPreScrollRange = Math.max(0, n - this.getTopInset());
    }
    
    private int getDownNestedScrollRange() {
        if (mDownScrollRange != -1) {
            return mDownScrollRange;
        }
        int n = 0;
        for (int i = 0; i < this.getChildCount(); ++i) {
            final View child = this.getChildAt(i);
            final LayoutParams layoutParams = (LayoutParams)child.getLayoutParams();
            final int n2 = child.getMeasuredHeight() + (layoutParams.topMargin + layoutParams.bottomMargin);
            final int mScrollFlags = layoutParams.mScrollFlags;
            if ((mScrollFlags & 0x1) == 0x0) {
                break;
            }
            n += n2;
            if ((mScrollFlags & 0x2) != 0x0) {
                n -= ViewCompat.getMinimumHeight(child) + this.getTopInset();
                break;
            }
        }
        return mDownScrollRange = Math.max(0, n);
    }
    
    private int getPendingAction() {
        return mPendingAction;
    }
    
    private int getTopInset() {
        if (mLastInsets != null) {
            return mLastInsets.getSystemWindowInsetTop();
        }
        return 0;
    }
    
    private int getUpNestedPreScrollRange() {
        return this.getTotalScrollRange();
    }
    
    private boolean hasChildWithInterpolator() {
        return mHaveChildWithInterpolator;
    }
    
    private boolean hasScrollableChildren() {
        return this.getTotalScrollRange() != 0;
    }
    
    private void invalidateScrollRanges() {
        mTotalScrollRange = -1;
        mDownPreScrollRange = -1;
        mDownScrollRange = -1;
    }
    
    private WindowInsetsCompat onWindowInsetChanged(final WindowInsetsCompat windowInsetsCompat) {
        final boolean fitsSystemWindows = ViewCompat.getFitsSystemWindows((View)this);
        WindowInsetsCompat mLastInsets = null;
        if (fitsSystemWindows) {
            mLastInsets = windowInsetsCompat;
        }
        if (mLastInsets != this.mLastInsets) {
            this.mLastInsets = mLastInsets;
            this.invalidateScrollRanges();
        }
        return windowInsetsCompat;
    }
    
    private void resetPendingAction() {
        mPendingAction = 0;
    }
    
    public void addOnOffsetChangedListener(final OnOffsetChangedListener onOffsetChangedListener) {
        if (onOffsetChangedListener != null && !mListeners.contains(onOffsetChangedListener)) {
            mListeners.add(onOffsetChangedListener);
        }
    }
    
    protected boolean checkLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        return viewGroup$LayoutParams instanceof LayoutParams;
    }
    
    protected LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -2);
    }
    
    protected /* bridge */ ViewGroup$LayoutParams generateDefaultLayoutParams() {
        return (ViewGroup$LayoutParams)this.generateDefaultLayoutParams();
    }
    
    protected /* bridge */ LinearLayout$LayoutParams generateDefaultLayoutParams() {
        return this.generateDefaultLayoutParams();
    }
    
    public LayoutParams generateLayoutParams(final AttributeSet set) {
        return new LayoutParams(this.getContext(), set);
    }
    
    protected LayoutParams generateLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        if (viewGroup$LayoutParams instanceof LinearLayout$LayoutParams) {
            return new LayoutParams((LinearLayout$LayoutParams)viewGroup$LayoutParams);
        }
        if (viewGroup$LayoutParams instanceof ViewGroup$MarginLayoutParams) {
            return new LayoutParams((ViewGroup$MarginLayoutParams)viewGroup$LayoutParams);
        }
        return new LayoutParams(viewGroup$LayoutParams);
    }
    
    public /* bridge */ ViewGroup$LayoutParams generateLayoutParams(final AttributeSet set) {
        return (ViewGroup$LayoutParams)this.generateLayoutParams(set);
    }
    
    protected /* bridge */ ViewGroup$LayoutParams generateLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        return (ViewGroup$LayoutParams)this.generateLayoutParams(viewGroup$LayoutParams);
    }
    
    public /* bridge */ LinearLayout$LayoutParams generateLayoutParams(final AttributeSet set) {
        return this.generateLayoutParams(set);
    }
    
    protected /* bridge */ LinearLayout$LayoutParams generateLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        return this.generateLayoutParams(viewGroup$LayoutParams);
    }
    
    final int getMinimumHeightForVisibleOverlappingContent() {
        final int topInset = this.getTopInset();
        final int minimumHeight = ViewCompat.getMinimumHeight((View)this);
        if (minimumHeight != 0) {
            return topInset + minimumHeight * 2;
        }
        final int childCount = this.getChildCount();
        if (childCount >= 1) {
            return topInset + 2 * ViewCompat.getMinimumHeight(this.getChildAt(childCount - 1));
        }
        return 0;
    }
    
    public float getTargetElevation() {
        return mTargetElevation;
    }
    
    public final int getTotalScrollRange() {
        if (mTotalScrollRange != -1) {
            return mTotalScrollRange;
        }
        int n = 0;
        for (int i = 0; i < this.getChildCount(); ++i) {
            final View child = this.getChildAt(i);
            final LayoutParams layoutParams = (LayoutParams)child.getLayoutParams();
            final int measuredHeight = child.getMeasuredHeight();
            final int mScrollFlags = layoutParams.mScrollFlags;
            if ((mScrollFlags & 0x1) == 0x0) {
                break;
            }
            n += measuredHeight + layoutParams.topMargin + layoutParams.bottomMargin;
            if ((mScrollFlags & 0x2) != 0x0) {
                n -= ViewCompat.getMinimumHeight(child);
                break;
            }
        }
        return mTotalScrollRange = Math.max(0, n - this.getTopInset());
    }
    
    protected void onLayout(final boolean b, final int n, final int n2, final int n3, final int n4) {
        super.onLayout(b, n, n2, n3, n4);
        this.invalidateScrollRanges();
        mHaveChildWithInterpolator = false;
        for (int i = 0; i < this.getChildCount(); ++i) {
            if (((LayoutParams)this.getChildAt(i).getLayoutParams()).getScrollInterpolator() != null) {
                mHaveChildWithInterpolator = true;
                break;
            }
        }
    }
    
    protected void onMeasure(final int n, final int n2) {
        super.onMeasure(n, n2);
        this.invalidateScrollRanges();
    }
    
    public void removeOnOffsetChangedListener(final OnOffsetChangedListener onOffsetChangedListener) {
        if (onOffsetChangedListener != null) {
            mListeners.remove(onOffsetChangedListener);
        }
    }
    
    public void setExpanded(final boolean b) {
        this.setExpanded(b, ViewCompat.isLaidOut((View)this));
    }
    
    public void setExpanded(final boolean b, final boolean b2) {
        int n;
        if (b) {
            n = 1;
        }
        else {
            n = 2;
        }
        int n2;
        if (b2) {
            n2 = 4;
        }
        else {
            n2 = 0;
        }
        mPendingAction = (n2 | n);
        this.requestLayout();
    }
    
    public void setOrientation(final int orientation) {
        if (orientation != 1) {
            throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
        }
        super.setOrientation(orientation);
    }
    
    public void setTargetElevation(final float mTargetElevation) {
        this.mTargetElevation = mTargetElevation;
    }
}
