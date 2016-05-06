package android.support.v4.graphics.drawable;

import android.graphics.drawable.Drawable;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.graphics.PorterDuff$Mode;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable$ConstantState;

protected abstract static class DrawableWrapperState extends Drawable$ConstantState
{
    int mChangingConfigurations;
    Drawable$ConstantState mDrawableState;
    ColorStateList mTint;
    PorterDuff$Mode mTintMode;
    
    DrawableWrapperState(@Nullable final DrawableWrapperState drawableWrapperState, @Nullable final Resources resources) {
        super();
        this.mTint = null;
        this.mTintMode = DEFAULT_TINT_MODE;
        if (drawableWrapperState != null) {
            this.mChangingConfigurations = drawableWrapperState.mChangingConfigurations;
            this.mDrawableState = drawableWrapperState.mDrawableState;
            this.mTint = drawableWrapperState.mTint;
            this.mTintMode = drawableWrapperState.mTintMode;
        }
    }
    
    boolean canConstantState() {
        return mDrawableState != null;
    }
    
    public int getChangingConfigurations() {
        final int mChangingConfigurations = this.mChangingConfigurations;
        int changingConfigurations;
        if (mDrawableState != null) {
            changingConfigurations = mDrawableState.getChangingConfigurations();
        }
        else {
            changingConfigurations = 0;
        }
        return changingConfigurations | mChangingConfigurations;
    }
    
    public Drawable newDrawable() {
        return this.newDrawable(null);
    }
    
    public abstract Drawable newDrawable(@Nullable final Resources p0);
}
