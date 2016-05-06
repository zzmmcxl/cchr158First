package android.support.design.widget;

private class ResetElevationAnimation extends BaseShadowAnimation
{
    final /* synthetic */ FloatingActionButtonEclairMr1 this$0;
    
    private ResetElevationAnimation(final FloatingActionButtonEclairMr1 this$0) {
        this$0 = this$0;
        this$0.super();
    }
    
    ResetElevationAnimation(final FloatingActionButtonEclairMr1 floatingActionButtonEclairMr1, final FloatingActionButtonEclairMr1$1 animationListenerAdapter) {
        this(floatingActionButtonEclairMr1);
    }
    
    @Override
    protected float getTargetShadowSize() {
        return this$0.mElevation;
    }
}
