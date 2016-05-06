package android.support.v4.graphics.drawable;

import android.util.DisplayMetrics;
import android.graphics.Shader;
import android.graphics.ColorFilter;
import android.graphics.Canvas;
import android.graphics.Shader$TileMode;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Rect;
import android.graphics.BitmapShader;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

public abstract class RoundedBitmapDrawable extends Drawable
{
    private static final int DEFAULT_PAINT_FLAGS = 3;
    private boolean mApplyGravity;
    final Bitmap mBitmap;
    private int mBitmapHeight;
    private final BitmapShader mBitmapShader;
    private int mBitmapWidth;
    private float mCornerRadius;
    final Rect mDstRect;
    private final RectF mDstRectF;
    private int mGravity;
    private boolean mIsCircular;
    private final Paint mPaint;
    private final Matrix mShaderMatrix;
    private int mTargetDensity;
    
    RoundedBitmapDrawable(final Resources resources, final Bitmap mBitmap) {
        super();
        mTargetDensity = 160;
        mGravity = 119;
        mPaint = new Paint(3);
        mShaderMatrix = new Matrix();
        mDstRect = new Rect();
        mDstRectF = new RectF();
        mApplyGravity = true;
        if (resources != null) {
            mTargetDensity = resources.getDisplayMetrics().densityDpi;
        }
        mBitmap = mBitmap;
        if (mBitmap != null) {
            this.computeBitmapSize();
            mBitmapShader = new BitmapShader(mBitmap, Shader$TileMode.CLAMP, Shader$TileMode.CLAMP);
            return;
        }
        mBitmapHeight = -1;
        mBitmapWidth = -1;
        mBitmapShader = null;
    }
    
    private void computeBitmapSize() {
        mBitmapWidth = mBitmap.getScaledWidth(mTargetDensity);
        mBitmapHeight = mBitmap.getScaledHeight(mTargetDensity);
    }
    
    private static boolean isGreaterThanZero(final float n) {
        return n > 0.05f;
    }
    
    private void updateCircularCornerRadius() {
        mCornerRadius = Math.min(mBitmapHeight, mBitmapWidth) / 2;
    }
    
    public void draw(final Canvas canvas) {
        final Bitmap mBitmap = this.mBitmap;
        if (mBitmap == null) {
            return;
        }
        this.updateDstRect();
        if (mPaint.getShader() == null) {
            canvas.drawBitmap(mBitmap, (Rect)null, mDstRect, mPaint);
            return;
        }
        canvas.drawRoundRect(mDstRectF, mCornerRadius, mCornerRadius, mPaint);
    }
    
    public int getAlpha() {
        return mPaint.getAlpha();
    }
    
    public final Bitmap getBitmap() {
        return mBitmap;
    }
    
    public ColorFilter getColorFilter() {
        return mPaint.getColorFilter();
    }
    
    public float getCornerRadius() {
        return mCornerRadius;
    }
    
    public int getGravity() {
        return mGravity;
    }
    
    public int getIntrinsicHeight() {
        return mBitmapHeight;
    }
    
    public int getIntrinsicWidth() {
        return mBitmapWidth;
    }
    
    public int getOpacity() {
        if (mGravity == 119 && !mIsCircular) {
            final Bitmap mBitmap = this.mBitmap;
            if (mBitmap != null && !mBitmap.hasAlpha() && mPaint.getAlpha() >= 255 && !isGreaterThanZero(mCornerRadius)) {
                return -1;
            }
        }
        return -3;
    }
    
    public final Paint getPaint() {
        return mPaint;
    }
    
    void gravityCompatApply(final int n, final int n2, final int n3, final Rect rect, final Rect rect2) {
        throw new UnsupportedOperationException();
    }
    
    public boolean hasAntiAlias() {
        return mPaint.isAntiAlias();
    }
    
    public boolean hasMipMap() {
        throw new UnsupportedOperationException();
    }
    
    public boolean isCircular() {
        return mIsCircular;
    }
    
    protected void onBoundsChange(final Rect rect) {
        super.onBoundsChange(rect);
        if (mIsCircular) {
            this.updateCircularCornerRadius();
        }
        mApplyGravity = true;
    }
    
    public void setAlpha(final int alpha) {
        if (alpha != mPaint.getAlpha()) {
            mPaint.setAlpha(alpha);
            this.invalidateSelf();
        }
    }
    
    public void setAntiAlias(final boolean antiAlias) {
        mPaint.setAntiAlias(antiAlias);
        this.invalidateSelf();
    }
    
    public void setCircular(final boolean mIsCircular) {
        this.mIsCircular = mIsCircular;
        mApplyGravity = true;
        if (mIsCircular) {
            this.updateCircularCornerRadius();
            mPaint.setShader((Shader)mBitmapShader);
            this.invalidateSelf();
            return;
        }
        this.setCornerRadius(0.0f);
    }
    
    public void setColorFilter(final ColorFilter colorFilter) {
        mPaint.setColorFilter(colorFilter);
        this.invalidateSelf();
    }
    
    public void setCornerRadius(final float mCornerRadius) {
        if (this.mCornerRadius == mCornerRadius) {
            return;
        }
        mIsCircular = false;
        if (isGreaterThanZero(mCornerRadius)) {
            mPaint.setShader((Shader)mBitmapShader);
        }
        else {
            mPaint.setShader((Shader)null);
        }
        this.mCornerRadius = mCornerRadius;
        this.invalidateSelf();
    }
    
    public void setDither(final boolean dither) {
        mPaint.setDither(dither);
        this.invalidateSelf();
    }
    
    public void setFilterBitmap(final boolean filterBitmap) {
        mPaint.setFilterBitmap(filterBitmap);
        this.invalidateSelf();
    }
    
    public void setGravity(final int mGravity) {
        if (this.mGravity != mGravity) {
            this.mGravity = mGravity;
            mApplyGravity = true;
            this.invalidateSelf();
        }
    }
    
    public void setMipMap(final boolean b) {
        throw new UnsupportedOperationException();
    }
    
    public void setTargetDensity(int mTargetDensity) {
        if (this.mTargetDensity != mTargetDensity) {
            if (mTargetDensity == 0) {
                mTargetDensity = 160;
            }
            this.mTargetDensity = mTargetDensity;
            if (mBitmap != null) {
                this.computeBitmapSize();
            }
            this.invalidateSelf();
        }
    }
    
    public void setTargetDensity(final Canvas canvas) {
        this.setTargetDensity(canvas.getDensity());
    }
    
    public void setTargetDensity(final DisplayMetrics displayMetrics) {
        this.setTargetDensity(displayMetrics.densityDpi);
    }
    
    void updateDstRect() {
        if (mApplyGravity) {
            if (mIsCircular) {
                final int min = Math.min(mBitmapWidth, mBitmapHeight);
                this.gravityCompatApply(mGravity, min, min, this.getBounds(), mDstRect);
                final int min2 = Math.min(mDstRect.width(), mDstRect.height());
                mDstRect.inset(Math.max(0, (mDstRect.width() - min2) / 2), Math.max(0, (mDstRect.height() - min2) / 2));
                mCornerRadius = 0.5f * min2;
            }
            else {
                this.gravityCompatApply(mGravity, mBitmapWidth, mBitmapHeight, this.getBounds(), mDstRect);
            }
            mDstRectF.set(mDstRect);
            if (mBitmapShader != null) {
                mShaderMatrix.setTranslate(mDstRectF.left, mDstRectF.top);
                mShaderMatrix.preScale(mDstRectF.width() / (float)mBitmap.getWidth(), mDstRectF.height() / (float)mBitmap.getHeight());
                mBitmapShader.setLocalMatrix(mShaderMatrix);
                mPaint.setShader((Shader)mBitmapShader);
            }
            mApplyGravity = false;
        }
    }
}
