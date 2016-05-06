package android.support.v7.widget;

import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.MotionEventCompat;
import android.view.MotionEvent;
import android.content.res.TypedArray;
import android.os.Build$VERSION;
import android.content.res.Configuration;
import android.view.View$MeasureSpec;
import android.view.View;
import android.view.ContextThemeWrapper;
import android.support.v7.appcompat.R;
import android.util.TypedValue;
import android.util.AttributeSet;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.content.Context;
import android.view.ViewGroup;

abstract class AbsActionBarView extends ViewGroup
{
    private static final int FADE_DURATION = 200;
    protected ActionMenuPresenter mActionMenuPresenter;
    protected int mContentHeight;
    private boolean mEatingHover;
    private boolean mEatingTouch;
    protected ActionMenuView mMenuView;
    protected final Context mPopupContext;
    protected final VisibilityAnimListener mVisAnimListener;
    protected ViewPropertyAnimatorCompat mVisibilityAnim;
    
    AbsActionBarView(final Context context) {
        this(context, null);
    }
    
    AbsActionBarView(final Context context, final AttributeSet set) {
        this(context, set, 0);
    }
    
    AbsActionBarView(final Context mPopupContext, final AttributeSet set, final int n) {
        super(mPopupContext, set, n);
        mVisAnimListener = new VisibilityAnimListener();
        final TypedValue typedValue = new TypedValue();
        if (mPopupContext.getTheme().resolveAttribute(R.attr.actionBarPopupTheme, typedValue, true) && typedValue.resourceId != 0) {
            mPopupContext = (Context)new ContextThemeWrapper(mPopupContext, typedValue.resourceId);
            return;
        }
        mPopupContext = mPopupContext;
    }
    
    static /* synthetic */ void access$001(final AbsActionBarView absActionBarView, final int visibility) {
        ((View)absActionBarView).setVisibility(visibility);
    }
    
    static /* synthetic */ void access$101(final AbsActionBarView absActionBarView, final int visibility) {
        ((View)absActionBarView).setVisibility(visibility);
    }
    
    protected static int next(final int n, final int n2, final boolean b) {
        if (b) {
            return n - n2;
        }
        return n + n2;
    }
    
    public void animateToVisibility(final int n) {
        this.setupAnimatorToVisibility(n, 200L).start();
    }
    
    public boolean canShowOverflowMenu() {
        return this.isOverflowReserved() && this.getVisibility() == 0;
    }
    
    public void dismissPopupMenus() {
        if (mActionMenuPresenter != null) {
            mActionMenuPresenter.dismissPopupMenus();
        }
    }
    
    public int getAnimatedVisibility() {
        if (mVisibilityAnim != null) {
            return mVisAnimListener.mFinalVisibility;
        }
        return this.getVisibility();
    }
    
    public int getContentHeight() {
        return mContentHeight;
    }
    
    public boolean hideOverflowMenu() {
        return mActionMenuPresenter != null && mActionMenuPresenter.hideOverflowMenu();
    }
    
    public boolean isOverflowMenuShowPending() {
        return mActionMenuPresenter != null && mActionMenuPresenter.isOverflowMenuShowPending();
    }
    
    public boolean isOverflowMenuShowing() {
        return mActionMenuPresenter != null && mActionMenuPresenter.isOverflowMenuShowing();
    }
    
    public boolean isOverflowReserved() {
        return mActionMenuPresenter != null && mActionMenuPresenter.isOverflowReserved();
    }
    
    protected int measureChildView(final View view, final int n, final int n2, final int n3) {
        view.measure(View$MeasureSpec.makeMeasureSpec(n, Integer.MIN_VALUE), n2);
        return Math.max(0, n - view.getMeasuredWidth() - n3);
    }
    
    protected void onConfigurationChanged(final Configuration configuration) {
        if (Build$VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        final TypedArray obtainStyledAttributes = this.getContext().obtainStyledAttributes((AttributeSet)null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
        this.setContentHeight(obtainStyledAttributes.getLayoutDimension(R.styleable.ActionBar_height, 0));
        obtainStyledAttributes.recycle();
        if (mActionMenuPresenter != null) {
            mActionMenuPresenter.onConfigurationChanged(configuration);
        }
    }
    
    public boolean onHoverEvent(final MotionEvent motionEvent) {
        final int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (actionMasked == 9) {
            mEatingHover = false;
        }
        if (!mEatingHover) {
            final boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                mEatingHover = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            mEatingHover = false;
        }
        return true;
    }
    
    public boolean onTouchEvent(final MotionEvent motionEvent) {
        final int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (actionMasked == 0) {
            mEatingTouch = false;
        }
        if (!mEatingTouch) {
            final boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                mEatingTouch = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            mEatingTouch = false;
        }
        return true;
    }
    
    protected int positionChild(final View view, final int n, final int n2, final int n3, final boolean b) {
        int measuredWidth = view.getMeasuredWidth();
        final int measuredHeight = view.getMeasuredHeight();
        final int n4 = n2 + (n3 - measuredHeight) / 2;
        if (b) {
            view.layout(n - measuredWidth, n4, n, n4 + measuredHeight);
        }
        else {
            view.layout(n, n4, n + measuredWidth, n4 + measuredHeight);
        }
        if (b) {
            measuredWidth = -measuredWidth;
        }
        return measuredWidth;
    }
    
    public void postShowOverflowMenu() {
        this.post((Runnable)new Runnable() {
            final /* synthetic */ AbsActionBarView this$0;
            
            AbsActionBarView$1() {
                this$0 = this$0;
                super();
            }
            
            @Override
            public void run() {
                this$0.showOverflowMenu();
            }
        });
    }
    
    public void setContentHeight(final int mContentHeight) {
        this.mContentHeight = mContentHeight;
        this.requestLayout();
    }
    
    public void setVisibility(final int visibility) {
        if (visibility != this.getVisibility()) {
            if (mVisibilityAnim != null) {
                mVisibilityAnim.cancel();
            }
            super.setVisibility(visibility);
        }
    }
    
    public ViewPropertyAnimatorCompat setupAnimatorToVisibility(final int n, final long n2) {
        if (mVisibilityAnim != null) {
            mVisibilityAnim.cancel();
        }
        if (n == 0) {
            if (this.getVisibility() != 0) {
                ViewCompat.setAlpha((View)this, 0.0f);
            }
            final ViewPropertyAnimatorCompat alpha = ViewCompat.animate((View)this).alpha(1.0f);
            alpha.setDuration(n2);
            alpha.setListener(mVisAnimListener.withFinalVisibility(alpha, n));
            return alpha;
        }
        final ViewPropertyAnimatorCompat alpha2 = ViewCompat.animate((View)this).alpha(0.0f);
        alpha2.setDuration(n2);
        alpha2.setListener(mVisAnimListener.withFinalVisibility(alpha2, n));
        return alpha2;
    }
    
    public boolean showOverflowMenu() {
        return mActionMenuPresenter != null && mActionMenuPresenter.showOverflowMenu();
    }
}
