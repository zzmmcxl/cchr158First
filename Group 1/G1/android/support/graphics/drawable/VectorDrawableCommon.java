package android.support.graphics.drawable;

import android.graphics.PorterDuff$Mode;
import android.graphics.Region;
import android.graphics.Rect;
import android.graphics.ColorFilter;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.content.res.Resources$Theme;
import android.content.res.Resources;
import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;

@TargetApi(21)
abstract class VectorDrawableCommon extends Drawable
{
    Drawable mDelegateDrawable;
    
    VectorDrawableCommon() {
        super();
    }
    
    static TypedArray obtainAttributes(final Resources resources, final Resources$Theme resources$Theme, final AttributeSet set, final int[] array) {
        if (resources$Theme == null) {
            return resources.obtainAttributes(set, array);
        }
        return resources$Theme.obtainStyledAttributes(set, array, 0, 0);
    }
    
    public void applyTheme(final Resources$Theme resources$Theme) {
        if (mDelegateDrawable != null) {
            DrawableCompat.applyTheme(mDelegateDrawable, resources$Theme);
        }
    }
    
    public void clearColorFilter() {
        if (mDelegateDrawable != null) {
            mDelegateDrawable.clearColorFilter();
            return;
        }
        super.clearColorFilter();
    }
    
    public ColorFilter getColorFilter() {
        if (mDelegateDrawable != null) {
            return DrawableCompat.getColorFilter(mDelegateDrawable);
        }
        return null;
    }
    
    public Drawable getCurrent() {
        if (mDelegateDrawable != null) {
            return mDelegateDrawable.getCurrent();
        }
        return super.getCurrent();
    }
    
    public int getLayoutDirection() {
        if (mDelegateDrawable != null) {
            DrawableCompat.getLayoutDirection(mDelegateDrawable);
        }
        return 0;
    }
    
    public int getMinimumHeight() {
        if (mDelegateDrawable != null) {
            return mDelegateDrawable.getMinimumHeight();
        }
        return super.getMinimumHeight();
    }
    
    public int getMinimumWidth() {
        if (mDelegateDrawable != null) {
            return mDelegateDrawable.getMinimumWidth();
        }
        return super.getMinimumWidth();
    }
    
    public boolean getPadding(final Rect rect) {
        if (mDelegateDrawable != null) {
            return mDelegateDrawable.getPadding(rect);
        }
        return super.getPadding(rect);
    }
    
    public int[] getState() {
        if (mDelegateDrawable != null) {
            return mDelegateDrawable.getState();
        }
        return super.getState();
    }
    
    public Region getTransparentRegion() {
        if (mDelegateDrawable != null) {
            return mDelegateDrawable.getTransparentRegion();
        }
        return super.getTransparentRegion();
    }
    
    public boolean isAutoMirrored() {
        if (mDelegateDrawable != null) {
            DrawableCompat.isAutoMirrored(mDelegateDrawable);
        }
        return false;
    }
    
    public void jumpToCurrentState() {
        if (mDelegateDrawable != null) {
            DrawableCompat.jumpToCurrentState(mDelegateDrawable);
        }
    }
    
    protected void onBoundsChange(final Rect bounds) {
        if (mDelegateDrawable != null) {
            mDelegateDrawable.setBounds(bounds);
            return;
        }
        super.onBoundsChange(bounds);
    }
    
    protected boolean onLevelChange(final int level) {
        if (mDelegateDrawable != null) {
            return mDelegateDrawable.setLevel(level);
        }
        return super.onLevelChange(level);
    }
    
    public void setAutoMirrored(final boolean b) {
        if (mDelegateDrawable != null) {
            DrawableCompat.setAutoMirrored(mDelegateDrawable, b);
        }
    }
    
    public void setChangingConfigurations(final int n) {
        if (mDelegateDrawable != null) {
            mDelegateDrawable.setChangingConfigurations(n);
            return;
        }
        super.setChangingConfigurations(n);
    }
    
    public void setColorFilter(final int n, final PorterDuff$Mode porterDuff$Mode) {
        if (mDelegateDrawable != null) {
            mDelegateDrawable.setColorFilter(n, porterDuff$Mode);
            return;
        }
        super.setColorFilter(n, porterDuff$Mode);
    }
    
    public void setFilterBitmap(final boolean filterBitmap) {
        if (mDelegateDrawable != null) {
            mDelegateDrawable.setFilterBitmap(filterBitmap);
        }
    }
    
    public void setHotspot(final float n, final float n2) {
        if (mDelegateDrawable != null) {
            DrawableCompat.setHotspot(mDelegateDrawable, n, n2);
        }
    }
    
    public void setHotspotBounds(final int n, final int n2, final int n3, final int n4) {
        if (mDelegateDrawable != null) {
            DrawableCompat.setHotspotBounds(mDelegateDrawable, n, n2, n3, n4);
        }
    }
    
    public boolean setState(final int[] array) {
        if (mDelegateDrawable != null) {
            return mDelegateDrawable.setState(array);
        }
        return super.setState(array);
    }
}
