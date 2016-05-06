package android.support.v4.graphics.drawable;

import android.graphics.ColorFilter;
import android.graphics.Region;
import android.graphics.Rect;
import android.graphics.drawable.Drawable$ConstantState;
import android.graphics.Canvas;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.graphics.PorterDuff$Mode;
import android.graphics.drawable.Drawable$Callback;
import android.graphics.drawable.Drawable;

class DrawableWrapperDonut extends Drawable implements Drawable$Callback, DrawableWrapper
{
    static final PorterDuff$Mode DEFAULT_TINT_MODE;
    private boolean mColorFilterSet;
    private int mCurrentColor;
    private PorterDuff$Mode mCurrentMode;
    Drawable mDrawable;
    private boolean mMutated;
    DrawableWrapperState mState;
    
    static {
        DEFAULT_TINT_MODE = PorterDuff$Mode.SRC_IN;
    }
    
    DrawableWrapperDonut(@Nullable final Drawable wrappedDrawable) {
        super();
        if (wrappedDrawable != null && wrappedDrawable.getConstantState() != null) {
            mState = this.mutateConstantState();
        }
        this.setWrappedDrawable(wrappedDrawable);
    }
    
    DrawableWrapperDonut(@NonNull final DrawableWrapperState mState, @Nullable final Resources resources) {
        super();
        mState = mState;
        this.updateLocalState(resources);
    }
    
    private void updateLocalState(@Nullable final Resources resources) {
        if (mState != null && mState.mDrawableState != null) {
            this.setWrappedDrawable(this.newDrawableFromState(mState.mDrawableState, resources));
        }
    }
    
    private boolean updateTint(final int[] array) {
        if (this.isCompatTintEnabled()) {
            final ColorStateList mTint = mState.mTint;
            final PorterDuff$Mode mTintMode = mState.mTintMode;
            if (mTint == null || mTintMode == null) {
                mColorFilterSet = false;
                this.clearColorFilter();
                return false;
            }
            final int colorForState = mTint.getColorForState(array, mTint.getDefaultColor());
            if (!mColorFilterSet || colorForState != mCurrentColor || mTintMode != mCurrentMode) {
                this.setColorFilter(colorForState, mTintMode);
                mCurrentColor = colorForState;
                mCurrentMode = mTintMode;
                return mColorFilterSet = true;
            }
        }
        return false;
    }
    
    public void draw(final Canvas canvas) {
        mDrawable.draw(canvas);
    }
    
    public int getChangingConfigurations() {
        final int changingConfigurations = super.getChangingConfigurations();
        int changingConfigurations2;
        if (mState != null) {
            changingConfigurations2 = mState.getChangingConfigurations();
        }
        else {
            changingConfigurations2 = 0;
        }
        return changingConfigurations2 | changingConfigurations | mDrawable.getChangingConfigurations();
    }
    
    @Nullable
    public Drawable$ConstantState getConstantState() {
        if (mState != null && mState.canConstantState()) {
            mState.mChangingConfigurations = this.getChangingConfigurations();
            return mState;
        }
        return null;
    }
    
    public Drawable getCurrent() {
        return mDrawable.getCurrent();
    }
    
    public int getIntrinsicHeight() {
        return mDrawable.getIntrinsicHeight();
    }
    
    public int getIntrinsicWidth() {
        return mDrawable.getIntrinsicWidth();
    }
    
    public int getMinimumHeight() {
        return mDrawable.getMinimumHeight();
    }
    
    public int getMinimumWidth() {
        return mDrawable.getMinimumWidth();
    }
    
    public int getOpacity() {
        return mDrawable.getOpacity();
    }
    
    public boolean getPadding(final Rect rect) {
        return mDrawable.getPadding(rect);
    }
    
    public int[] getState() {
        return mDrawable.getState();
    }
    
    public Region getTransparentRegion() {
        return mDrawable.getTransparentRegion();
    }
    
    public final Drawable getWrappedDrawable() {
        return mDrawable;
    }
    
    public void invalidateDrawable(final Drawable drawable) {
        this.invalidateSelf();
    }
    
    protected boolean isCompatTintEnabled() {
        return true;
    }
    
    public boolean isStateful() {
        ColorStateList mTint;
        if (this.isCompatTintEnabled()) {
            mTint = mState.mTint;
        }
        else {
            mTint = null;
        }
        return (mTint != null && mTint.isStateful()) || mDrawable.isStateful();
    }
    
    public Drawable mutate() {
        if (!mMutated && super.mutate() == this) {
            mState = this.mutateConstantState();
            if (mDrawable != null) {
                mDrawable.mutate();
            }
            if (mState != null) {
                final DrawableWrapperState mState = this.mState;
                Drawable$ConstantState constantState;
                if (mDrawable != null) {
                    constantState = mDrawable.getConstantState();
                }
                else {
                    constantState = null;
                }
                mState.mDrawableState = constantState;
            }
            mMutated = true;
        }
        return this;
    }
    
    @NonNull
    DrawableWrapperState mutateConstantState() {
        return (DrawableWrapperState)new DrawableWrapperStateDonut(mState, null);
    }
    
    protected Drawable newDrawableFromState(@NonNull final Drawable$ConstantState drawable$ConstantState, @Nullable final Resources resources) {
        return drawable$ConstantState.newDrawable();
    }
    
    protected void onBoundsChange(final Rect bounds) {
        if (mDrawable != null) {
            mDrawable.setBounds(bounds);
        }
    }
    
    protected boolean onLevelChange(final int level) {
        return mDrawable.setLevel(level);
    }
    
    public void scheduleDrawable(final Drawable drawable, final Runnable runnable, final long n) {
        this.scheduleSelf(runnable, n);
    }
    
    public void setAlpha(final int alpha) {
        mDrawable.setAlpha(alpha);
    }
    
    public void setChangingConfigurations(final int changingConfigurations) {
        mDrawable.setChangingConfigurations(changingConfigurations);
    }
    
    public void setColorFilter(final ColorFilter colorFilter) {
        mDrawable.setColorFilter(colorFilter);
    }
    
    public void setCompatTint(final int n) {
        this.setCompatTintList(ColorStateList.valueOf(n));
    }
    
    public void setCompatTintList(final ColorStateList mTint) {
        mState.mTint = mTint;
        this.updateTint(this.getState());
    }
    
    public void setCompatTintMode(final PorterDuff$Mode mTintMode) {
        mState.mTintMode = mTintMode;
        this.updateTint(this.getState());
    }
    
    public void setDither(final boolean dither) {
        mDrawable.setDither(dither);
    }
    
    public void setFilterBitmap(final boolean filterBitmap) {
        mDrawable.setFilterBitmap(filterBitmap);
    }
    
    public boolean setState(final int[] state) {
        final boolean setState = mDrawable.setState(state);
        return this.updateTint(state) || setState;
    }
    
    public boolean setVisible(final boolean b, final boolean b2) {
        return super.setVisible(b, b2) || mDrawable.setVisible(b, b2);
    }
    
    public final void setWrappedDrawable(final Drawable mDrawable) {
        if (this.mDrawable != null) {
            this.mDrawable.setCallback((Drawable$Callback)null);
        }
        if ((this.mDrawable = mDrawable) != null) {
            mDrawable.setCallback((Drawable$Callback)this);
            mDrawable.setVisible(this.isVisible(), true);
            mDrawable.setState(this.getState());
            mDrawable.setLevel(this.getLevel());
            mDrawable.setBounds(this.getBounds());
            if (mState != null) {
                mState.mDrawableState = mDrawable.getConstantState();
            }
        }
        this.invalidateSelf();
    }
    
    public void unscheduleDrawable(final Drawable drawable, final Runnable runnable) {
        this.unscheduleSelf(runnable);
    }
}
