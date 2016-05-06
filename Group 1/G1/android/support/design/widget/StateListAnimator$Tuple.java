package android.support.design.widget;

import android.view.animation.Animation;

static class Tuple
{
    final Animation mAnimation;
    final int[] mSpecs;
    
    private Tuple(final int[] mSpecs, final Animation mAnimation) {
        super();
        this.mSpecs = mSpecs;
        this.mAnimation = mAnimation;
    }
    
    Tuple(final int[] array, final Animation animation, final StateListAnimator$1 animation$AnimationListener) {
        this(array, animation);
    }
    
    Animation getAnimation() {
        return mAnimation;
    }
    
    int[] getSpecs() {
        return mSpecs;
    }
}
