package android.support.v7.widget;

import android.view.ActionMode$Callback;
import android.support.v7.view.ActionMode;
import android.view.ViewGroup$LayoutParams;
import android.graphics.drawable.Drawable$Callback;
import android.view.View$MeasureSpec;
import android.view.MotionEvent;
import android.widget.FrameLayout$LayoutParams;
import android.content.res.TypedArray;
import android.support.v7.appcompat.R;
import android.os.Build$VERSION;
import android.util.AttributeSet;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;

public class ActionBarContainer extends FrameLayout
{
    private View mActionBarView;
    Drawable mBackground;
    private View mContextView;
    private int mHeight;
    boolean mIsSplit;
    boolean mIsStacked;
    private boolean mIsTransitioning;
    Drawable mSplitBackground;
    Drawable mStackedBackground;
    private View mTabContainer;
    
    public ActionBarContainer(final Context context) {
        this(context, null);
    }
    
    public ActionBarContainer(final Context context, final AttributeSet set) {
        boolean b = true;
        super(context, set);
        ActionBarBackgroundDrawable backgroundDrawable;
        if (Build$VERSION.SDK_INT >= 21) {
            backgroundDrawable = new ActionBarBackgroundDrawableV21(this);
        }
        else {
            backgroundDrawable = new ActionBarBackgroundDrawable(this);
        }
        this.setBackgroundDrawable((Drawable)backgroundDrawable);
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, R.styleable.ActionBar);
        mBackground = obtainStyledAttributes.getDrawable(R.styleable.ActionBar_background);
        mStackedBackground = obtainStyledAttributes.getDrawable(R.styleable.ActionBar_backgroundStacked);
        mHeight = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ActionBar_height, -1);
        if (this.getId() == R.id.split_action_bar) {
            mIsSplit = b;
            mSplitBackground = obtainStyledAttributes.getDrawable(R.styleable.ActionBar_backgroundSplit);
        }
        obtainStyledAttributes.recycle();
        if (mIsSplit) {
            if (mSplitBackground != null) {
                b = false;
            }
        }
        else if (mBackground != null || mStackedBackground != null) {
            b = false;
        }
        this.setWillNotDraw(b);
    }
    
    private int getMeasuredHeightWithMargins(final View view) {
        final FrameLayout$LayoutParams frameLayout$LayoutParams = (FrameLayout$LayoutParams)view.getLayoutParams();
        return view.getMeasuredHeight() + frameLayout$LayoutParams.topMargin + frameLayout$LayoutParams.bottomMargin;
    }
    
    private boolean isCollapsed(final View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }
    
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (mBackground != null && mBackground.isStateful()) {
            mBackground.setState(this.getDrawableState());
        }
        if (mStackedBackground != null && mStackedBackground.isStateful()) {
            mStackedBackground.setState(this.getDrawableState());
        }
        if (mSplitBackground != null && mSplitBackground.isStateful()) {
            mSplitBackground.setState(this.getDrawableState());
        }
    }
    
    public View getTabContainer() {
        return mTabContainer;
    }
    
    public void jumpDrawablesToCurrentState() {
        if (Build$VERSION.SDK_INT >= 11) {
            super.jumpDrawablesToCurrentState();
            if (mBackground != null) {
                mBackground.jumpToCurrentState();
            }
            if (mStackedBackground != null) {
                mStackedBackground.jumpToCurrentState();
            }
            if (mSplitBackground != null) {
                mSplitBackground.jumpToCurrentState();
            }
        }
    }
    
    public void onFinishInflate() {
        super.onFinishInflate();
        mActionBarView = this.findViewById(R.id.action_bar);
        mContextView = this.findViewById(R.id.action_context_bar);
    }
    
    public boolean onInterceptTouchEvent(final MotionEvent motionEvent) {
        return mIsTransitioning || super.onInterceptTouchEvent(motionEvent);
    }
    
    public void onLayout(final boolean b, final int n, final int n2, final int n3, final int n4) {
        super.onLayout(b, n, n2, n3, n4);
        final View mTabContainer = this.mTabContainer;
        final boolean mIsStacked = mTabContainer != null && mTabContainer.getVisibility() != 8;
        if (mTabContainer != null && mTabContainer.getVisibility() != 8) {
            final int measuredHeight = this.getMeasuredHeight();
            final FrameLayout$LayoutParams frameLayout$LayoutParams = (FrameLayout$LayoutParams)mTabContainer.getLayoutParams();
            mTabContainer.layout(n, measuredHeight - mTabContainer.getMeasuredHeight() - frameLayout$LayoutParams.bottomMargin, n3, measuredHeight - frameLayout$LayoutParams.bottomMargin);
        }
        int n5;
        if (mIsSplit) {
            final Drawable mSplitBackground = this.mSplitBackground;
            n5 = 0;
            if (mSplitBackground != null) {
                this.mSplitBackground.setBounds(0, 0, this.getMeasuredWidth(), this.getMeasuredHeight());
                n5 = 1;
            }
        }
        else {
            final Drawable mBackground = this.mBackground;
            n5 = 0;
            if (mBackground != null) {
                if (mActionBarView.getVisibility() == 0) {
                    this.mBackground.setBounds(mActionBarView.getLeft(), mActionBarView.getTop(), mActionBarView.getRight(), mActionBarView.getBottom());
                }
                else if (mContextView != null && mContextView.getVisibility() == 0) {
                    this.mBackground.setBounds(mContextView.getLeft(), mContextView.getTop(), mContextView.getRight(), mContextView.getBottom());
                }
                else {
                    this.mBackground.setBounds(0, 0, 0, 0);
                }
                n5 = 1;
            }
            this.mIsStacked = mIsStacked;
            if (mIsStacked && mStackedBackground != null) {
                mStackedBackground.setBounds(mTabContainer.getLeft(), mTabContainer.getTop(), mTabContainer.getRight(), mTabContainer.getBottom());
                n5 = 1;
            }
        }
        if (n5 != 0) {
            this.invalidate();
        }
    }
    
    public void onMeasure(final int n, int measureSpec) {
        if (mActionBarView == null && View$MeasureSpec.getMode(measureSpec) == Integer.MIN_VALUE && mHeight >= 0) {
            measureSpec = View$MeasureSpec.makeMeasureSpec(Math.min(mHeight, View$MeasureSpec.getSize(measureSpec)), Integer.MIN_VALUE);
        }
        super.onMeasure(n, measureSpec);
        if (mActionBarView != null) {
            final int mode = View$MeasureSpec.getMode(measureSpec);
            if (mTabContainer != null && mTabContainer.getVisibility() != 8 && mode != 1073741824) {
                int n2;
                if (!this.isCollapsed(mActionBarView)) {
                    n2 = this.getMeasuredHeightWithMargins(mActionBarView);
                }
                else if (!this.isCollapsed(mContextView)) {
                    n2 = this.getMeasuredHeightWithMargins(mContextView);
                }
                else {
                    n2 = 0;
                }
                int size;
                if (mode == Integer.MIN_VALUE) {
                    size = View$MeasureSpec.getSize(measureSpec);
                }
                else {
                    size = Integer.MAX_VALUE;
                }
                this.setMeasuredDimension(this.getMeasuredWidth(), Math.min(n2 + this.getMeasuredHeightWithMargins(mTabContainer), size));
            }
        }
    }
    
    public boolean onTouchEvent(final MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }
    
    public void setPrimaryBackground(final Drawable mBackground) {
        boolean willNotDraw = true;
        if (this.mBackground != null) {
            this.mBackground.setCallback((Drawable$Callback)null);
            this.unscheduleDrawable(this.mBackground);
        }
        if ((this.mBackground = mBackground) != null) {
            mBackground.setCallback((Drawable$Callback)this);
            if (mActionBarView != null) {
                this.mBackground.setBounds(mActionBarView.getLeft(), mActionBarView.getTop(), mActionBarView.getRight(), mActionBarView.getBottom());
            }
        }
        if (mIsSplit) {
            if (mSplitBackground != null) {
                willNotDraw = false;
            }
        }
        else if (this.mBackground != null || mStackedBackground != null) {
            willNotDraw = false;
        }
        this.setWillNotDraw(willNotDraw);
        this.invalidate();
    }
    
    public void setSplitBackground(final Drawable mSplitBackground) {
        boolean willNotDraw = true;
        if (this.mSplitBackground != null) {
            this.mSplitBackground.setCallback((Drawable$Callback)null);
            this.unscheduleDrawable(this.mSplitBackground);
        }
        if ((this.mSplitBackground = mSplitBackground) != null) {
            mSplitBackground.setCallback((Drawable$Callback)this);
            if (mIsSplit && this.mSplitBackground != null) {
                this.mSplitBackground.setBounds(0, 0, this.getMeasuredWidth(), this.getMeasuredHeight());
            }
        }
        if (mIsSplit) {
            if (this.mSplitBackground != null) {
                willNotDraw = false;
            }
        }
        else if (mBackground != null || mStackedBackground != null) {
            willNotDraw = false;
        }
        this.setWillNotDraw(willNotDraw);
        this.invalidate();
    }
    
    public void setStackedBackground(final Drawable mStackedBackground) {
        boolean willNotDraw = true;
        if (this.mStackedBackground != null) {
            this.mStackedBackground.setCallback((Drawable$Callback)null);
            this.unscheduleDrawable(this.mStackedBackground);
        }
        if ((this.mStackedBackground = mStackedBackground) != null) {
            mStackedBackground.setCallback((Drawable$Callback)this);
            if (mIsStacked && this.mStackedBackground != null) {
                this.mStackedBackground.setBounds(mTabContainer.getLeft(), mTabContainer.getTop(), mTabContainer.getRight(), mTabContainer.getBottom());
            }
        }
        if (mIsSplit) {
            if (mSplitBackground != null) {
                willNotDraw = false;
            }
        }
        else if (mBackground != null || this.mStackedBackground != null) {
            willNotDraw = false;
        }
        this.setWillNotDraw(willNotDraw);
        this.invalidate();
    }
    
    public void setTabContainer(final ScrollingTabContainerView mTabContainer) {
        if (this.mTabContainer != null) {
            this.removeView(this.mTabContainer);
        }
        if ((this.mTabContainer = (View)mTabContainer) != null) {
            this.addView((View)mTabContainer);
            final ViewGroup$LayoutParams layoutParams = mTabContainer.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            mTabContainer.setAllowCollapse(false);
        }
    }
    
    public void setTransitioning(final boolean mIsTransitioning) {
        this.mIsTransitioning = mIsTransitioning;
        int descendantFocusability;
        if (mIsTransitioning) {
            descendantFocusability = 393216;
        }
        else {
            descendantFocusability = 262144;
        }
        this.setDescendantFocusability(descendantFocusability);
    }
    
    public void setVisibility(final int visibility) {
        super.setVisibility(visibility);
        final boolean b = visibility == 0;
        if (mBackground != null) {
            mBackground.setVisible(b, false);
        }
        if (mStackedBackground != null) {
            mStackedBackground.setVisible(b, false);
        }
        if (mSplitBackground != null) {
            mSplitBackground.setVisible(b, false);
        }
    }
    
    public ActionMode startActionModeForChild(final View view, final ActionMode.Callback callback) {
        return null;
    }
    
    public android.view.ActionMode startActionModeForChild(final View view, final ActionMode$Callback actionMode$Callback) {
        return null;
    }
    
    protected boolean verifyDrawable(final Drawable drawable) {
        return (drawable == mBackground && !mIsSplit) || (drawable == mStackedBackground && mIsStacked) || (drawable == mSplitBackground && mIsSplit) || super.verifyDrawable(drawable);
    }
}
