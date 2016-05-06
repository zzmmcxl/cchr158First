package android.support.design.widget;

private class ElevateToTranslationZAnimation extends BaseShadowAnimation
{
    final /* synthetic */ FloatingActionButtonEclairMr1 this$0;
    
    private ElevateToTranslationZAnimation(final FloatingActionButtonEclairMr1 this$0) {
        this$0 = this$0;
        this$0.super();
    }
    
    ElevateToTranslationZAnimation(final FloatingActionButtonEclairMr1 floatingActionButtonEclairMr1, final FloatingActionButtonEclairMr1$1 animationListenerAdapter) {
        this(floatingActionButtonEclairMr1);
    }
    
    @Override
    protected float getTargetShadowSize() {
        return this$0.mElevation + this$0.mPressedTranslationZ;
    }
}
