package android.support.design.widget;

import android.view.View;
import android.support.v4.view.ViewCompat;

private class OffsetUpdateListener implements OnOffsetChangedListener
{
    final /* synthetic */ CollapsingToolbarLayout this$0;
    
    private OffsetUpdateListener(final CollapsingToolbarLayout this$0) {
        this$0 = this$0;
        super();
    }
    
    OffsetUpdateListener(final CollapsingToolbarLayout collapsingToolbarLayout, final CollapsingToolbarLayout$1 onApplyWindowInsetsListener) {
        this(collapsingToolbarLayout);
    }
    
    @Override
    public void onOffsetChanged(final AppBarLayout appBarLayout, final int n) {
        CollapsingToolbarLayout.access$302(this$0, n);
        int systemWindowInsetTop;
        if (CollapsingToolbarLayout.access$400(this$0) != null) {
            systemWindowInsetTop = CollapsingToolbarLayout.access$400(this$0).getSystemWindowInsetTop();
        }
        else {
            systemWindowInsetTop = 0;
        }
        final int totalScrollRange = appBarLayout.getTotalScrollRange();
        for (int i = 0; i < this$0.getChildCount(); ++i) {
            final View child = this$0.getChildAt(i);
            final CollapsingToolbarLayout.LayoutParams layoutParams = (CollapsingToolbarLayout.LayoutParams)child.getLayoutParams();
            final ViewOffsetHelper access$500 = CollapsingToolbarLayout.access$500(child);
            switch (layoutParams.mCollapseMode) {
                case 1:
                    if (n + (this$0.getHeight() - systemWindowInsetTop) >= child.getHeight()) {
                        access$500.setTopAndBottomOffset(-n);
                        break;
                    }
                    break;
                case 2:
                    access$500.setTopAndBottomOffset(Math.round((float)(-n) * layoutParams.mParallaxMult));
                    break;
            }
        }
        if (CollapsingToolbarLayout.access$600(this$0) != null || CollapsingToolbarLayout.access$700(this$0) != null) {
            final CollapsingToolbarLayout this$0 = this.this$0;
            final int n2 = n + this.this$0.getHeight();
            final int n3 = systemWindowInsetTop + this.this$0.getScrimTriggerOffset();
            boolean scrimsShown = false;
            if (n2 < n3) {
                scrimsShown = true;
            }
            this$0.setScrimsShown(scrimsShown);
        }
        if (CollapsingToolbarLayout.access$700(this$0) != null && systemWindowInsetTop > 0) {
            ViewCompat.postInvalidateOnAnimation((View)this$0);
        }
        CollapsingToolbarLayout.access$800(this$0).setExpansionFraction((float)Math.abs(n) / (float)(this$0.getHeight() - ViewCompat.getMinimumHeight((View)this$0) - systemWindowInsetTop));
        if (Math.abs(n) == totalScrollRange) {
            ViewCompat.setElevation((View)appBarLayout, appBarLayout.getTargetElevation());
            return;
        }
        ViewCompat.setElevation((View)appBarLayout, 0.0f);
    }
}
