package android.support.design.widget;

import android.view.ViewGroup;
import java.util.List;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.os.Build$VERSION;
import android.graphics.Rect;

public static class Behavior extends CoordinatorLayout.Behavior<FloatingActionButton>
{
    private static final boolean SNACKBAR_BEHAVIOR_ENABLED;
    private float mFabTranslationY;
    private ValueAnimatorCompat mFabTranslationYAnimator;
    private Rect mTmpRect;
    
    static {
        SNACKBAR_BEHAVIOR_ENABLED = (Build$VERSION.SDK_INT >= 11);
    }
    
    public Behavior() {
        super();
    }
    
    private float getFabTranslationYForSnackbar(final CoordinatorLayout coordinatorLayout, final FloatingActionButton floatingActionButton) {
        float min = 0.0f;
        final List<View> dependencies = coordinatorLayout.getDependencies((View)floatingActionButton);
        for (int i = 0; i < dependencies.size(); ++i) {
            final View view = (View)dependencies.get(i);
            if (view instanceof Snackbar.SnackbarLayout && coordinatorLayout.doViewsOverlap((View)floatingActionButton, view)) {
                min = Math.min(min, ViewCompat.getTranslationY(view) - (float)view.getHeight());
            }
        }
        return min;
    }
    
    private void offsetIfNeeded(final CoordinatorLayout coordinatorLayout, final FloatingActionButton floatingActionButton) {
        final Rect access$200 = FloatingActionButton.access$200(floatingActionButton);
        if (access$200 != null && access$200.centerX() > 0 && access$200.centerY() > 0) {
            final LayoutParams layoutParams = (LayoutParams)floatingActionButton.getLayoutParams();
            int right;
            if (floatingActionButton.getRight() >= coordinatorLayout.getWidth() - layoutParams.rightMargin) {
                right = access$200.right;
            }
            else {
                final int left = floatingActionButton.getLeft();
                final int leftMargin = layoutParams.leftMargin;
                right = 0;
                if (left <= leftMargin) {
                    right = -access$200.left;
                }
            }
            int bottom;
            if (floatingActionButton.getBottom() >= coordinatorLayout.getBottom() - layoutParams.bottomMargin) {
                bottom = access$200.bottom;
            }
            else {
                final int top = floatingActionButton.getTop();
                final int topMargin = layoutParams.topMargin;
                bottom = 0;
                if (top <= topMargin) {
                    bottom = -access$200.top;
                }
            }
            floatingActionButton.offsetTopAndBottom(bottom);
            floatingActionButton.offsetLeftAndRight(right);
        }
    }
    
    private void updateFabTranslationForSnackbar(final CoordinatorLayout coordinatorLayout, final FloatingActionButton floatingActionButton, final View view) {
        final float fabTranslationYForSnackbar = this.getFabTranslationYForSnackbar(coordinatorLayout, floatingActionButton);
        if (mFabTranslationY == fabTranslationYForSnackbar) {
            return;
        }
        final float translationY = ViewCompat.getTranslationY((View)floatingActionButton);
        if (mFabTranslationYAnimator != null && mFabTranslationYAnimator.isRunning()) {
            mFabTranslationYAnimator.cancel();
        }
        if (floatingActionButton.isShown() && Math.abs(translationY - fabTranslationYForSnackbar) > 0.667f * floatingActionButton.getHeight()) {
            if (mFabTranslationYAnimator == null) {
                (mFabTranslationYAnimator = ViewUtils.createAnimator()).setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
                mFabTranslationYAnimator.setUpdateListener((ValueAnimatorCompat.AnimatorUpdateListener)new ValueAnimatorCompat.AnimatorUpdateListener() {
                    final /* synthetic */ Behavior this$0;
                    final /* synthetic */ FloatingActionButton val$fab;
                    
                    FloatingActionButton$Behavior$1() {
                        this$0 = this$0;
                        super();
                    }
                    
                    @Override
                    public void onAnimationUpdate(final ValueAnimatorCompat valueAnimatorCompat) {
                        ViewCompat.setTranslationY((View)floatingActionButton, valueAnimatorCompat.getAnimatedFloatValue());
                    }
                });
            }
            mFabTranslationYAnimator.setFloatValues(translationY, fabTranslationYForSnackbar);
            mFabTranslationYAnimator.start();
        }
        else {
            ViewCompat.setTranslationY((View)floatingActionButton, fabTranslationYForSnackbar);
        }
        mFabTranslationY = fabTranslationYForSnackbar;
    }
    
    private boolean updateFabVisibility(final CoordinatorLayout coordinatorLayout, final AppBarLayout appBarLayout, final FloatingActionButton floatingActionButton) {
        if (((LayoutParams)floatingActionButton.getLayoutParams()).getAnchorId() == appBarLayout.getId() && floatingActionButton.getUserSetVisibility() == 0) {
            if (mTmpRect == null) {
                mTmpRect = new Rect();
            }
            final Rect mTmpRect = this.mTmpRect;
            ViewGroupUtils.getDescendantRect(coordinatorLayout, (View)appBarLayout, mTmpRect);
            if (mTmpRect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                FloatingActionButton.access$000(floatingActionButton, null, false);
            }
            else {
                FloatingActionButton.access$100(floatingActionButton, null, false);
            }
            return true;
        }
        return false;
    }
    
    public boolean layoutDependsOn(final CoordinatorLayout coordinatorLayout, final FloatingActionButton floatingActionButton, final View view) {
        return SNACKBAR_BEHAVIOR_ENABLED && view instanceof Snackbar.SnackbarLayout;
    }
    
    @Override
    public /* bridge */ boolean layoutDependsOn(final CoordinatorLayout coordinatorLayout, final View view, final View view2) {
        return this.layoutDependsOn(coordinatorLayout, (FloatingActionButton)view, view2);
    }
    
    public boolean onDependentViewChanged(final CoordinatorLayout coordinatorLayout, final FloatingActionButton floatingActionButton, final View view) {
        if (view instanceof Snackbar.SnackbarLayout) {
            this.updateFabTranslationForSnackbar(coordinatorLayout, floatingActionButton, view);
        }
        else if (view instanceof AppBarLayout) {
            this.updateFabVisibility(coordinatorLayout, (AppBarLayout)view, floatingActionButton);
        }
        return false;
    }
    
    @Override
    public /* bridge */ boolean onDependentViewChanged(final CoordinatorLayout coordinatorLayout, final View view, final View view2) {
        return this.onDependentViewChanged(coordinatorLayout, (FloatingActionButton)view, view2);
    }
    
    public boolean onLayoutChild(final CoordinatorLayout coordinatorLayout, final FloatingActionButton floatingActionButton, final int n) {
        final List<View> dependencies = coordinatorLayout.getDependencies((View)floatingActionButton);
        for (int i = 0; i < dependencies.size(); ++i) {
            final View view = (View)dependencies.get(i);
            if (view instanceof AppBarLayout && this.updateFabVisibility(coordinatorLayout, (AppBarLayout)view, floatingActionButton)) {
                break;
            }
        }
        coordinatorLayout.onLayoutChild((View)floatingActionButton, n);
        this.offsetIfNeeded(coordinatorLayout, floatingActionButton);
        return true;
    }
    
    @Override
    public /* bridge */ boolean onLayoutChild(final CoordinatorLayout coordinatorLayout, final View view, final int n) {
        return this.onLayoutChild(coordinatorLayout, (FloatingActionButton)view, n);
    }
}
