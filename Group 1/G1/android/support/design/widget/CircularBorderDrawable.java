package android.support.design.widget;

import android.graphics.ColorFilter;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Shader$TileMode;
import android.support.v4.graphics.ColorUtils;
import android.graphics.Shader;
import android.graphics.Paint$Style;
import android.graphics.RectF;
import android.graphics.Rect;
import android.graphics.Paint;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;

class CircularBorderDrawable extends Drawable
{
    private static final float DRAW_STROKE_WIDTH_MULTIPLE = 1.3333f;
    private ColorStateList mBorderTint;
    float mBorderWidth;
    private int mBottomInnerStrokeColor;
    private int mBottomOuterStrokeColor;
    private int mCurrentBorderTintColor;
    private boolean mInvalidateShader;
    final Paint mPaint;
    final Rect mRect;
    final RectF mRectF;
    private float mRotation;
    private int mTopInnerStrokeColor;
    private int mTopOuterStrokeColor;
    
    public CircularBorderDrawable() {
        super();
        mRect = new Rect();
        mRectF = new RectF();
        mInvalidateShader = true;
        (mPaint = new Paint(1)).setStyle(Paint$Style.STROKE);
    }
    
    private Shader createGradientShader() {
        final Rect mRect = this.mRect;
        this.copyBounds(mRect);
        final float n = mBorderWidth / mRect.height();
        return (Shader)new LinearGradient(0.0f, (float)mRect.top, 0.0f, (float)mRect.bottom, new int[] { ColorUtils.compositeColors(mTopOuterStrokeColor, mCurrentBorderTintColor), ColorUtils.compositeColors(mTopInnerStrokeColor, mCurrentBorderTintColor), ColorUtils.compositeColors(ColorUtils.setAlphaComponent(mTopInnerStrokeColor, 0), mCurrentBorderTintColor), ColorUtils.compositeColors(ColorUtils.setAlphaComponent(mBottomInnerStrokeColor, 0), mCurrentBorderTintColor), ColorUtils.compositeColors(mBottomInnerStrokeColor, mCurrentBorderTintColor), ColorUtils.compositeColors(mBottomOuterStrokeColor, mCurrentBorderTintColor) }, new float[] { 0.0f, n, 0.5f, 0.5f, 1.0f - n, 1.0f }, Shader$TileMode.CLAMP);
    }
    
    public void draw(final Canvas canvas) {
        if (mInvalidateShader) {
            mPaint.setShader(this.createGradientShader());
            mInvalidateShader = false;
        }
        final float n = mPaint.getStrokeWidth() / 2.0f;
        final RectF mRectF = this.mRectF;
        this.copyBounds(mRect);
        mRectF.set(mRect);
        mRectF.left += n;
        mRectF.top += n;
        mRectF.right -= n;
        mRectF.bottom -= n;
        canvas.save();
        canvas.rotate(mRotation, mRectF.centerX(), mRectF.centerY());
        canvas.drawOval(mRectF, mPaint);
        canvas.restore();
    }
    
    public int getOpacity() {
        if (mBorderWidth > 0.0f) {
            return -3;
        }
        return -2;
    }
    
    public boolean getPadding(final Rect rect) {
        final int round = Math.round(mBorderWidth);
        rect.set(round, round, round, round);
        return true;
    }
    
    public boolean isStateful() {
        return (mBorderTint != null && mBorderTint.isStateful()) || super.isStateful();
    }
    
    protected void onBoundsChange(final Rect rect) {
        mInvalidateShader = true;
    }
    
    protected boolean onStateChange(final int[] array) {
        if (mBorderTint != null) {
            final int colorForState = mBorderTint.getColorForState(array, mCurrentBorderTintColor);
            if (colorForState != mCurrentBorderTintColor) {
                mInvalidateShader = true;
                mCurrentBorderTintColor = colorForState;
            }
        }
        if (mInvalidateShader) {
            this.invalidateSelf();
        }
        return mInvalidateShader;
    }
    
    public void setAlpha(final int alpha) {
        mPaint.setAlpha(alpha);
        this.invalidateSelf();
    }
    
    void setBorderTint(final ColorStateList mBorderTint) {
        if (mBorderTint != null) {
            mCurrentBorderTintColor = mBorderTint.getColorForState(this.getState(), mCurrentBorderTintColor);
        }
        this.mBorderTint = mBorderTint;
        mInvalidateShader = true;
        this.invalidateSelf();
    }
    
    void setBorderWidth(final float mBorderWidth) {
        if (this.mBorderWidth != mBorderWidth) {
            this.mBorderWidth = mBorderWidth;
            mPaint.setStrokeWidth(1.3333f * mBorderWidth);
            mInvalidateShader = true;
            this.invalidateSelf();
        }
    }
    
    public void setColorFilter(final ColorFilter colorFilter) {
        mPaint.setColorFilter(colorFilter);
        this.invalidateSelf();
    }
    
    void setGradientColors(final int mTopOuterStrokeColor, final int mTopInnerStrokeColor, final int mBottomOuterStrokeColor, final int mBottomInnerStrokeColor) {
        this.mTopOuterStrokeColor = mTopOuterStrokeColor;
        this.mTopInnerStrokeColor = mTopInnerStrokeColor;
        this.mBottomOuterStrokeColor = mBottomOuterStrokeColor;
        this.mBottomInnerStrokeColor = mBottomInnerStrokeColor;
    }
    
    final void setRotation(final float mRotation) {
        if (mRotation != this.mRotation) {
            this.mRotation = mRotation;
            this.invalidateSelf();
        }
    }
}
