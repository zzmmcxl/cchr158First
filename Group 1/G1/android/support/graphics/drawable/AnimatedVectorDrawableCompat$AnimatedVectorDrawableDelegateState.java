package android.support.graphics.drawable;

import android.content.res.Resources$Theme;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable$ConstantState;

private static class AnimatedVectorDrawableDelegateState extends Drawable$ConstantState
{
    private final Drawable$ConstantState mDelegateState;
    
    public AnimatedVectorDrawableDelegateState(final Drawable$ConstantState mDelegateState) {
        super();
        this.mDelegateState = mDelegateState;
    }
    
    public boolean canApplyTheme() {
        return mDelegateState.canApplyTheme();
    }
    
    public int getChangingConfigurations() {
        return mDelegateState.getChangingConfigurations();
    }
    
    public Drawable newDrawable() {
        final AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat((AnimatedVectorDrawableCompat$1)null);
        (animatedVectorDrawableCompat.mDelegateDrawable = mDelegateState.newDrawable()).setCallback(AnimatedVectorDrawableCompat.access$100(animatedVectorDrawableCompat));
        return animatedVectorDrawableCompat;
    }
    
    public Drawable newDrawable(final Resources resources) {
        final AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat((AnimatedVectorDrawableCompat$1)null);
        (animatedVectorDrawableCompat.mDelegateDrawable = mDelegateState.newDrawable(resources)).setCallback(AnimatedVectorDrawableCompat.access$100(animatedVectorDrawableCompat));
        return animatedVectorDrawableCompat;
    }
    
    public Drawable newDrawable(final Resources resources, final Resources$Theme resources$Theme) {
        final AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat((AnimatedVectorDrawableCompat$1)null);
        (animatedVectorDrawableCompat.mDelegateDrawable = mDelegateState.newDrawable(resources, resources$Theme)).setCallback(AnimatedVectorDrawableCompat.access$100(animatedVectorDrawableCompat));
        return animatedVectorDrawableCompat;
    }
}
