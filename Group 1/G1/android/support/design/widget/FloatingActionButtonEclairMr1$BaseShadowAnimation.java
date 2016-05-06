package android.support.design.widget;

import android.view.animation.Transformation;
import android.view.animation.Animation;

private abstract class BaseShadowAnimation extends Animation
{
    private float mShadowSizeDiff;
    private float mShadowSizeStart;
    final /* synthetic */ FloatingActionButtonEclairMr1 this$0;
    
    private BaseShadowAnimation(final FloatingActionButtonEclairMr1 this$0) {
        this$0 = this$0;
        super();
    }
    
    BaseShadowAnimation(final FloatingActionButtonEclairMr1 floatingActionButtonEclairMr1, final FloatingActionButtonEclairMr1$1 animationListenerAdapter) {
        this(floatingActionButtonEclairMr1);
    }
    
    protected void applyTransformation(final float n, final Transformation transformation) {
        mShadowDrawable.setShadowSize(mShadowSizeStart + n * mShadowSizeDiff);
    }
    
    protected abstract float getTargetShadowSize();
    
    public void reset() {
        super.reset();
        mShadowSizeStart = mShadowDrawable.getShadowSize();
        mShadowSizeDiff = this.getTargetShadowSize() - mShadowSizeStart;
    }
}
