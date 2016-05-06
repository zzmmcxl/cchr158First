package android.support.v7.graphics.drawable;

import android.graphics.PorterDuff$Mode;
import android.content.res.ColorStateList;
import android.graphics.ColorFilter;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.graphics.Region;
import android.graphics.Rect;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable$Callback;
import android.graphics.drawable.Drawable;

public class DrawableWrapper extends Drawable implements Drawable$Callback
{
    private Drawable mDrawable;
    
    public DrawableWrapper(final Drawable wrappedDrawable) {
        super();
        this.setWrappedDrawable(wrappedDrawable);
    }
    
    public void draw(final Canvas canvas) {
        mDrawable.draw(canvas);
    }
    
    public int getChangingConfigurations() {
        return mDrawable.getChangingConfigurations();
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
    
    public Drawable getWrappedDrawable() {
        return mDrawable;
    }
    
    public void invalidateDrawable(final Drawable drawable) {
        this.invalidateSelf();
    }
    
    public boolean isAutoMirrored() {
        return DrawableCompat.isAutoMirrored(mDrawable);
    }
    
    public boolean isStateful() {
        return mDrawable.isStateful();
    }
    
    public void jumpToCurrentState() {
        DrawableCompat.jumpToCurrentState(mDrawable);
    }
    
    protected void onBoundsChange(final Rect bounds) {
        mDrawable.setBounds(bounds);
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
    
    public void setAutoMirrored(final boolean b) {
        DrawableCompat.setAutoMirrored(mDrawable, b);
    }
    
    public void setChangingConfigurations(final int changingConfigurations) {
        mDrawable.setChangingConfigurations(changingConfigurations);
    }
    
    public void setColorFilter(final ColorFilter colorFilter) {
        mDrawable.setColorFilter(colorFilter);
    }
    
    public void setDither(final boolean dither) {
        mDrawable.setDither(dither);
    }
    
    public void setFilterBitmap(final boolean filterBitmap) {
        mDrawable.setFilterBitmap(filterBitmap);
    }
    
    public void setHotspot(final float n, final float n2) {
        DrawableCompat.setHotspot(mDrawable, n, n2);
    }
    
    public void setHotspotBounds(final int n, final int n2, final int n3, final int n4) {
        DrawableCompat.setHotspotBounds(mDrawable, n, n2, n3, n4);
    }
    
    public boolean setState(final int[] state) {
        return mDrawable.setState(state);
    }
    
    public void setTint(final int n) {
        DrawableCompat.setTint(mDrawable, n);
    }
    
    public void setTintList(final ColorStateList list) {
        DrawableCompat.setTintList(mDrawable, list);
    }
    
    public void setTintMode(final PorterDuff$Mode porterDuff$Mode) {
        DrawableCompat.setTintMode(mDrawable, porterDuff$Mode);
    }
    
    public boolean setVisible(final boolean b, final boolean b2) {
        return super.setVisible(b, b2) || mDrawable.setVisible(b, b2);
    }
    
    public void setWrappedDrawable(final Drawable mDrawable) {
        if (this.mDrawable != null) {
            this.mDrawable.setCallback((Drawable$Callback)null);
        }
        if ((this.mDrawable = mDrawable) != null) {
            mDrawable.setCallback((Drawable$Callback)this);
        }
    }
    
    public void unscheduleDrawable(final Drawable drawable, final Runnable runnable) {
        this.unscheduleSelf(runnable);
    }
}
