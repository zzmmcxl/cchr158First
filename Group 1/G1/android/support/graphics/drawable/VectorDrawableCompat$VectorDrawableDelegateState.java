package android.support.graphics.drawable;

import android.content.res.Resources$Theme;
import android.content.res.Resources;
import android.graphics.drawable.VectorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable$ConstantState;

private static class VectorDrawableDelegateState extends Drawable$ConstantState
{
    private final Drawable$ConstantState mDelegateState;
    
    public VectorDrawableDelegateState(final Drawable$ConstantState mDelegateState) {
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
        final VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat((VectorDrawableCompat$1)null);
        vectorDrawableCompat.mDelegateDrawable = mDelegateState.newDrawable();
        return vectorDrawableCompat;
    }
    
    public Drawable newDrawable(final Resources resources) {
        final VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat((VectorDrawableCompat$1)null);
        vectorDrawableCompat.mDelegateDrawable = mDelegateState.newDrawable(resources);
        return vectorDrawableCompat;
    }
    
    public Drawable newDrawable(final Resources resources, final Resources$Theme resources$Theme) {
        final VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat((VectorDrawableCompat$1)null);
        vectorDrawableCompat.mDelegateDrawable = mDelegateState.newDrawable(resources, resources$Theme);
        return vectorDrawableCompat;
    }
}
