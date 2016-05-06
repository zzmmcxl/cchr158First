package android.support.design.widget;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.RadialGradient;
import android.graphics.Shader$TileMode;
import android.graphics.Path$FillType;
import android.graphics.Rect;
import android.graphics.Paint$Style;
import android.support.design.R;
import android.graphics.drawable.Drawable;
import android.content.res.Resources;
import android.graphics.Path;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v7.graphics.drawable.DrawableWrapper;

class ShadowDrawableWrapper extends DrawableWrapper
{
    static final double COS_45 = 0.0;
    static final float SHADOW_BOTTOM_SCALE = 1.0f;
    static final float SHADOW_HORIZ_SCALE = 0.5f;
    static final float SHADOW_MULTIPLIER = 1.5f;
    static final float SHADOW_TOP_SCALE = 0.25f;
    private boolean mAddPaddingForCorners;
    final RectF mContentBounds;
    float mCornerRadius;
    final Paint mCornerShadowPaint;
    Path mCornerShadowPath;
    private boolean mDirty;
    final Paint mEdgeShadowPaint;
    float mMaxShadowSize;
    private boolean mPrintedShadowClipWarning;
    float mRawMaxShadowSize;
    float mRawShadowSize;
    private float mRotation;
    private final int mShadowEndColor;
    private final int mShadowMiddleColor;
    float mShadowSize;
    private final int mShadowStartColor;
    
    public ShadowDrawableWrapper(final Resources resources, final Drawable drawable, final float n, final float n2, final float n3) {
        super(drawable);
        mDirty = true;
        mAddPaddingForCorners = true;
        mPrintedShadowClipWarning = false;
        mShadowStartColor = resources.getColor(R.color.design_fab_shadow_start_color);
        mShadowMiddleColor = resources.getColor(R.color.design_fab_shadow_mid_color);
        mShadowEndColor = resources.getColor(R.color.design_fab_shadow_end_color);
        (mCornerShadowPaint = new Paint(5)).setStyle(Paint$Style.FILL);
        mCornerRadius = Math.round(n);
        mContentBounds = new RectF();
        (mEdgeShadowPaint = new Paint(mCornerShadowPaint)).setAntiAlias(false);
        this.setShadowSize(n2, n3);
    }
    
    private void buildComponents(final Rect rect) {
        final float n = 1.5f * mRawMaxShadowSize;
        mContentBounds.set((float)rect.left + mRawMaxShadowSize, n + (float)rect.top, (float)rect.right - mRawMaxShadowSize, (float)rect.bottom - n);
        this.getWrappedDrawable().setBounds((int)mContentBounds.left, (int)mContentBounds.top, (int)mContentBounds.right, (int)mContentBounds.bottom);
        this.buildShadowCorners();
    }
    
    private void buildShadowCorners() {
        final RectF rectF = new RectF(-mCornerRadius, -mCornerRadius, mCornerRadius, mCornerRadius);
        final RectF rectF2 = new RectF(rectF);
        rectF2.inset(-mShadowSize, -mShadowSize);
        if (mCornerShadowPath == null) {
            mCornerShadowPath = new Path();
        }
        else {
            mCornerShadowPath.reset();
        }
        mCornerShadowPath.setFillType(Path$FillType.EVEN_ODD);
        mCornerShadowPath.moveTo(-mCornerRadius, 0.0f);
        mCornerShadowPath.rLineTo(-mShadowSize, 0.0f);
        mCornerShadowPath.arcTo(rectF2, 180.0f, 90.0f, false);
        mCornerShadowPath.arcTo(rectF, 270.0f, -90.0f, false);
        mCornerShadowPath.close();
        final float n = -rectF2.top;
        if (n > 0.0f) {
            final float n2 = mCornerRadius / n;
            mCornerShadowPaint.setShader((Shader)new RadialGradient(0.0f, 0.0f, n, new int[] { 0, mShadowStartColor, mShadowMiddleColor, mShadowEndColor }, new float[] { 0.0f, n2, n2 + (1.0f - n2) / 2.0f, 1.0f }, Shader$TileMode.CLAMP));
        }
        mEdgeShadowPaint.setShader((Shader)new LinearGradient(0.0f, rectF.top, 0.0f, rectF2.top, new int[] { mShadowStartColor, mShadowMiddleColor, mShadowEndColor }, new float[] { 0.0f, 0.5f, 1.0f }, Shader$TileMode.CLAMP));
        mEdgeShadowPaint.setAntiAlias(false);
    }
    
    public static float calculateHorizontalPadding(float n, final float n2, final boolean b) {
        if (b) {
            n += (1.0 - COS_45) * n2;
        }
        return n;
    }
    
    public static float calculateVerticalPadding(final float n, final float n2, final boolean b) {
        if (b) {
            return (float)(1.5f * n + (1.0 - COS_45) * n2);
        }
        return 1.5f * n;
    }
    
    private void drawShadow(final Canvas canvas) {
        final int save = canvas.save();
        canvas.rotate(mRotation, mContentBounds.centerX(), mContentBounds.centerY());
        final float n = -mCornerRadius - mShadowSize;
        final float mCornerRadius = this.mCornerRadius;
        boolean b;
        if (mContentBounds.width() - 2.0f * mCornerRadius > 0.0f) {
            b = true;
        }
        else {
            b = false;
        }
        boolean b2;
        if (mContentBounds.height() - 2.0f * mCornerRadius > 0.0f) {
            b2 = true;
        }
        else {
            b2 = false;
        }
        final float n2 = mRawShadowSize - 0.25f * mRawShadowSize;
        final float n3 = mRawShadowSize - 0.5f * mRawShadowSize;
        final float n4 = mRawShadowSize - 1.0f * mRawShadowSize;
        final float n5 = mCornerRadius / (mCornerRadius + n3);
        final float n6 = mCornerRadius / (mCornerRadius + n2);
        final float n7 = mCornerRadius / (mCornerRadius + n4);
        final int save2 = canvas.save();
        canvas.translate(mCornerRadius + mContentBounds.left, mCornerRadius + mContentBounds.top);
        canvas.scale(n5, n6);
        canvas.drawPath(mCornerShadowPath, mCornerShadowPaint);
        if (b) {
            canvas.scale(1.0f / n5, 1.0f);
            canvas.drawRect(0.0f, n, mContentBounds.width() - 2.0f * mCornerRadius, -this.mCornerRadius, mEdgeShadowPaint);
        }
        canvas.restoreToCount(save2);
        final int save3 = canvas.save();
        canvas.translate(mContentBounds.right - mCornerRadius, mContentBounds.bottom - mCornerRadius);
        canvas.scale(n5, n7);
        canvas.rotate(180.0f);
        canvas.drawPath(mCornerShadowPath, mCornerShadowPaint);
        if (b) {
            canvas.scale(1.0f / n5, 1.0f);
            canvas.drawRect(0.0f, n, mContentBounds.width() - 2.0f * mCornerRadius, -this.mCornerRadius + mShadowSize, mEdgeShadowPaint);
        }
        canvas.restoreToCount(save3);
        final int save4 = canvas.save();
        canvas.translate(mCornerRadius + mContentBounds.left, mContentBounds.bottom - mCornerRadius);
        canvas.scale(n5, n7);
        canvas.rotate(270.0f);
        canvas.drawPath(mCornerShadowPath, mCornerShadowPaint);
        if (b2) {
            canvas.scale(1.0f / n7, 1.0f);
            canvas.drawRect(0.0f, n, mContentBounds.height() - 2.0f * mCornerRadius, -this.mCornerRadius, mEdgeShadowPaint);
        }
        canvas.restoreToCount(save4);
        final int save5 = canvas.save();
        canvas.translate(mContentBounds.right - mCornerRadius, mCornerRadius + mContentBounds.top);
        canvas.scale(n5, n6);
        canvas.rotate(90.0f);
        canvas.drawPath(mCornerShadowPath, mCornerShadowPaint);
        if (b2) {
            canvas.scale(1.0f / n6, 1.0f);
            canvas.drawRect(0.0f, n, mContentBounds.height() - 2.0f * mCornerRadius, -this.mCornerRadius, mEdgeShadowPaint);
        }
        canvas.restoreToCount(save5);
        canvas.restoreToCount(save);
    }
    
    private static int toEven(final float n) {
        int round = Math.round(n);
        if (round % 2 == 1) {
            --round;
        }
        return round;
    }
    
    @Override
    public void draw(final Canvas canvas) {
        if (mDirty) {
            this.buildComponents(this.getBounds());
            mDirty = false;
        }
        this.drawShadow(canvas);
        super.draw(canvas);
    }
    
    public float getCornerRadius() {
        return mCornerRadius;
    }
    
    public float getMaxShadowSize() {
        return mRawMaxShadowSize;
    }
    
    public float getMinHeight() {
        return 2.0f * Math.max(mRawMaxShadowSize, mCornerRadius + 1.5f * mRawMaxShadowSize / 2.0f) + 2.0f * (1.5f * mRawMaxShadowSize);
    }
    
    public float getMinWidth() {
        return 2.0f * Math.max(mRawMaxShadowSize, mCornerRadius + mRawMaxShadowSize / 2.0f) + 2.0f * mRawMaxShadowSize;
    }
    
    @Override
    public int getOpacity() {
        return -3;
    }
    
    @Override
    public boolean getPadding(final Rect rect) {
        final int n = (int)Math.ceil(calculateVerticalPadding(mRawMaxShadowSize, mCornerRadius, mAddPaddingForCorners));
        final int n2 = (int)Math.ceil(calculateHorizontalPadding(mRawMaxShadowSize, mCornerRadius, mAddPaddingForCorners));
        rect.set(n2, n, n2, n);
        return true;
    }
    
    public float getShadowSize() {
        return mRawShadowSize;
    }
    
    @Override
    protected void onBoundsChange(final Rect rect) {
        mDirty = true;
    }
    
    public void setAddPaddingForCorners(final boolean mAddPaddingForCorners) {
        this.mAddPaddingForCorners = mAddPaddingForCorners;
        this.invalidateSelf();
    }
    
    @Override
    public void setAlpha(final int alpha) {
        super.setAlpha(alpha);
        mCornerShadowPaint.setAlpha(alpha);
        mEdgeShadowPaint.setAlpha(alpha);
    }
    
    public void setCornerRadius(final float n) {
        final float mCornerRadius = (float)Math.round(n);
        if (this.mCornerRadius == mCornerRadius) {
            return;
        }
        this.mCornerRadius = mCornerRadius;
        mDirty = true;
        this.invalidateSelf();
    }
    
    public void setMaxShadowSize(final float n) {
        this.setShadowSize(mRawShadowSize, n);
    }
    
    final void setRotation(final float mRotation) {
        if (this.mRotation != mRotation) {
            this.mRotation = mRotation;
            this.invalidateSelf();
        }
    }
    
    public void setShadowSize(final float n) {
        this.setShadowSize(n, mRawMaxShadowSize);
    }
    
    void setShadowSize(final float n, final float n2) {
        if (n < 0.0f || n2 < 0.0f) {
            throw new IllegalArgumentException("invalid shadow size");
        }
        float mRawShadowSize = (float)toEven(n);
        final float n3 = (float)toEven(n2);
        if (mRawShadowSize > n3) {
            mRawShadowSize = n3;
            if (!mPrintedShadowClipWarning) {
                mPrintedShadowClipWarning = true;
            }
        }
        if (this.mRawShadowSize == mRawShadowSize && mRawMaxShadowSize == n3) {
            return;
        }
        this.mRawShadowSize = mRawShadowSize;
        mRawMaxShadowSize = n3;
        mShadowSize = Math.round(1.5f * mRawShadowSize);
        mMaxShadowSize = n3;
        mDirty = true;
        this.invalidateSelf();
    }
}
