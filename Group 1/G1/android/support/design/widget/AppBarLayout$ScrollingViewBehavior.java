package android.support.design.widget;

import android.support.v4.os.ParcelableCompat;
import android.os.Parcel;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.os.Parcelable$Creator;
import android.view.View$BaseSavedState;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.os.Parcelable;
import android.view.animation.Interpolator;
import android.support.v4.view.ViewCompat;
import java.lang.ref.WeakReference;
import java.util.List;
import android.view.View;
import android.content.res.TypedArray;
import android.support.design.R;
import android.util.AttributeSet;
import android.content.Context;

public static class ScrollingViewBehavior extends HeaderScrollingViewBehavior
{
    public ScrollingViewBehavior() {
        super();
    }
    
    public ScrollingViewBehavior(final Context context, final AttributeSet set) {
        super(context, set);
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, R.styleable.ScrollingViewBehavior_Params);
        this.setOverlayTop(obtainStyledAttributes.getDimensionPixelSize(R.styleable.ScrollingViewBehavior_Params_behavior_overlapTop, 0));
        obtainStyledAttributes.recycle();
    }
    
    private static int getAppBarLayoutOffset(final AppBarLayout appBarLayout) {
        final CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams)appBarLayout.getLayoutParams()).getBehavior();
        if (behavior instanceof AppBarLayout.Behavior) {
            return ((AppBarLayout.Behavior)behavior).getTopBottomOffsetForScrollingSibling();
        }
        return 0;
    }
    
    private void offsetChildAsNeeded(final CoordinatorLayout coordinatorLayout, final View view, final View view2) {
        final CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams)view2.getLayoutParams()).getBehavior();
        if (behavior instanceof AppBarLayout.Behavior) {
            final AppBarLayout.Behavior behavior2 = (AppBarLayout.Behavior)behavior;
            behavior2.getTopBottomOffsetForScrollingSibling();
            view.offsetTopAndBottom(view2.getBottom() - view.getTop() + behavior2.mOffsetDelta + this.getVerticalLayoutGap() - this.getOverlapPixelsForOffset(view2));
        }
    }
    
    @Override
    View findFirstDependency(final List<View> list) {
        for (int i = 0; i < list.size(); ++i) {
            final View view = (View)list.get(i);
            if (view instanceof AppBarLayout) {
                return view;
            }
        }
        return null;
    }
    
    @Override
    public /* bridge */ int getLeftAndRightOffset() {
        return super.getLeftAndRightOffset();
    }
    
    @Override
    float getOverlapRatioForOffset(final View view) {
        if (view instanceof AppBarLayout) {
            final AppBarLayout appBarLayout = (AppBarLayout)view;
            final int totalScrollRange = appBarLayout.getTotalScrollRange();
            final int access$200 = AppBarLayout.access$200(appBarLayout);
            final int appBarLayoutOffset = getAppBarLayoutOffset(appBarLayout);
            if (access$200 == 0 || totalScrollRange + appBarLayoutOffset > access$200) {
                final int n = totalScrollRange - access$200;
                if (n != 0) {
                    return 1.0f + appBarLayoutOffset / n;
                }
            }
        }
        return 0.0f;
    }
    
    @Override
    int getScrollRange(final View view) {
        if (view instanceof AppBarLayout) {
            return ((AppBarLayout)view).getTotalScrollRange();
        }
        return super.getScrollRange(view);
    }
    
    @Override
    public /* bridge */ int getTopAndBottomOffset() {
        return super.getTopAndBottomOffset();
    }
    
    @Override
    public boolean layoutDependsOn(final CoordinatorLayout coordinatorLayout, final View view, final View view2) {
        return view2 instanceof AppBarLayout;
    }
    
    @Override
    public boolean onDependentViewChanged(final CoordinatorLayout coordinatorLayout, final View view, final View view2) {
        this.offsetChildAsNeeded(coordinatorLayout, view, view2);
        return false;
    }
    
    @Override
    public /* bridge */ boolean onLayoutChild(final CoordinatorLayout coordinatorLayout, final View view, final int n) {
        return super.onLayoutChild(coordinatorLayout, view, n);
    }
    
    @Override
    public /* bridge */ boolean onMeasureChild(final CoordinatorLayout coordinatorLayout, final View view, final int n, final int n2, final int n3, final int n4) {
        return super.onMeasureChild(coordinatorLayout, view, n, n2, n3, n4);
    }
    
    @Override
    public /* bridge */ boolean setLeftAndRightOffset(final int leftAndRightOffset) {
        return super.setLeftAndRightOffset(leftAndRightOffset);
    }
    
    @Override
    public /* bridge */ boolean setTopAndBottomOffset(final int topAndBottomOffset) {
        return super.setTopAndBottomOffset(topAndBottomOffset);
    }
}
