package android.support.graphics.drawable;

import android.graphics.Paint$Style;
import android.graphics.Region$Op;
import android.support.v4.util.ArrayMap;
import android.graphics.PathMeasure;
import android.graphics.Path;
import android.graphics.Matrix;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.Rect;
import android.graphics.ColorFilter;
import android.graphics.Canvas;
import android.graphics.Bitmap$Config;
import android.graphics.Paint;
import android.graphics.PorterDuff$Mode;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable$ConstantState;

private static class VectorDrawableCompatState extends Drawable$ConstantState
{
    boolean mAutoMirrored;
    boolean mCacheDirty;
    boolean mCachedAutoMirrored;
    Bitmap mCachedBitmap;
    int mCachedRootAlpha;
    int[] mCachedThemeAttrs;
    ColorStateList mCachedTint;
    PorterDuff$Mode mCachedTintMode;
    int mChangingConfigurations;
    Paint mTempPaint;
    ColorStateList mTint;
    PorterDuff$Mode mTintMode;
    VPathRenderer mVPathRenderer;
    
    public VectorDrawableCompatState() {
        super();
        this.mTint = null;
        this.mTintMode = DEFAULT_TINT_MODE;
        this.mVPathRenderer = new VPathRenderer();
    }
    
    public VectorDrawableCompatState(final VectorDrawableCompatState vectorDrawableCompatState) {
        super();
        this.mTint = null;
        this.mTintMode = DEFAULT_TINT_MODE;
        if (vectorDrawableCompatState != null) {
            this.mChangingConfigurations = vectorDrawableCompatState.mChangingConfigurations;
            this.mVPathRenderer = new VPathRenderer(vectorDrawableCompatState.mVPathRenderer);
            if (vectorDrawableCompatState.mVPathRenderer.mFillPaint != null) {
                this.mVPathRenderer.mFillPaint = new Paint(vectorDrawableCompatState.mVPathRenderer.mFillPaint);
            }
            if (vectorDrawableCompatState.mVPathRenderer.mStrokePaint != null) {
                this.mVPathRenderer.mStrokePaint = new Paint(vectorDrawableCompatState.mVPathRenderer.mStrokePaint);
            }
            this.mTint = vectorDrawableCompatState.mTint;
            this.mTintMode = vectorDrawableCompatState.mTintMode;
            this.mAutoMirrored = vectorDrawableCompatState.mAutoMirrored;
        }
    }
    
    public boolean canReuseBitmap(final int n, final int n2) {
        return n == mCachedBitmap.getWidth() && n2 == mCachedBitmap.getHeight();
    }
    
    public boolean canReuseCache() {
        return !mCacheDirty && mCachedTint == mTint && mCachedTintMode == mTintMode && mCachedAutoMirrored == mAutoMirrored && mCachedRootAlpha == mVPathRenderer.getRootAlpha();
    }
    
    public void createCachedBitmapIfNeeded(final int n, final int n2) {
        if (mCachedBitmap == null || !this.canReuseBitmap(n, n2)) {
            mCachedBitmap = Bitmap.createBitmap(n, n2, Bitmap$Config.ARGB_8888);
            mCacheDirty = true;
        }
    }
    
    public void drawCachedBitmapWithRootAlpha(final Canvas canvas, final ColorFilter colorFilter, final Rect rect) {
        canvas.drawBitmap(mCachedBitmap, (Rect)null, rect, this.getPaint(colorFilter));
    }
    
    public int getChangingConfigurations() {
        return mChangingConfigurations;
    }
    
    public Paint getPaint(final ColorFilter colorFilter) {
        if (!this.hasTranslucentRoot() && colorFilter == null) {
            return null;
        }
        if (mTempPaint == null) {
            (mTempPaint = new Paint()).setFilterBitmap(true);
        }
        mTempPaint.setAlpha(mVPathRenderer.getRootAlpha());
        mTempPaint.setColorFilter(colorFilter);
        return mTempPaint;
    }
    
    public boolean hasTranslucentRoot() {
        return mVPathRenderer.getRootAlpha() < 255;
    }
    
    public Drawable newDrawable() {
        return new VectorDrawableCompat(this, null);
    }
    
    public Drawable newDrawable(final Resources resources) {
        return new VectorDrawableCompat(this, null);
    }
    
    public void updateCacheStates() {
        mCachedTint = mTint;
        mCachedTintMode = mTintMode;
        mCachedRootAlpha = mVPathRenderer.getRootAlpha();
        mCachedAutoMirrored = mAutoMirrored;
        mCacheDirty = false;
    }
    
    public void updateCachedBitmap(final int n, final int n2) {
        mCachedBitmap.eraseColor(0);
        mVPathRenderer.draw(new Canvas(mCachedBitmap), n, n2, null);
    }
}
