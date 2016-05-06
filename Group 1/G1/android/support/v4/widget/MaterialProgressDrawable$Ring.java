package android.support.v4.widget;

import android.support.annotation.NonNull;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.Path$FillType;
import android.graphics.Rect;
import android.graphics.Canvas;
import android.graphics.Paint$Style;
import android.graphics.Paint$Cap;
import android.graphics.RectF;
import android.graphics.drawable.Drawable$Callback;
import android.graphics.Paint;
import android.graphics.Path;

private static class Ring
{
    private int mAlpha;
    private Path mArrow;
    private int mArrowHeight;
    private final Paint mArrowPaint;
    private float mArrowScale;
    private int mArrowWidth;
    private int mBackgroundColor;
    private final Drawable$Callback mCallback;
    private final Paint mCirclePaint;
    private int mColorIndex;
    private int[] mColors;
    private int mCurrentColor;
    private float mEndTrim;
    private final Paint mPaint;
    private double mRingCenterRadius;
    private float mRotation;
    private boolean mShowArrow;
    private float mStartTrim;
    private float mStartingEndTrim;
    private float mStartingRotation;
    private float mStartingStartTrim;
    private float mStrokeInset;
    private float mStrokeWidth;
    private final RectF mTempBounds;
    
    public Ring(final Drawable$Callback mCallback) {
        super();
        this.mTempBounds = new RectF();
        this.mPaint = new Paint();
        this.mArrowPaint = new Paint();
        this.mStartTrim = 0.0f;
        this.mEndTrim = 0.0f;
        this.mRotation = 0.0f;
        this.mStrokeWidth = 5.0f;
        this.mStrokeInset = 2.5f;
        this.mCirclePaint = new Paint(1);
        this.mCallback = mCallback;
        this.mPaint.setStrokeCap(Paint$Cap.SQUARE);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint$Style.STROKE);
        this.mArrowPaint.setStyle(Paint$Style.FILL);
        this.mArrowPaint.setAntiAlias(true);
    }
    
    private void drawTriangle(final Canvas canvas, final float n, final float n2, final Rect rect) {
        if (mShowArrow) {
            if (mArrow == null) {
                (mArrow = new Path()).setFillType(Path$FillType.EVEN_ODD);
            }
            else {
                mArrow.reset();
            }
            final float n3 = (int)mStrokeInset / 2 * mArrowScale;
            final float n4 = (float)(mRingCenterRadius * Math.cos(0.0) + rect.exactCenterX());
            final float n5 = (float)(mRingCenterRadius * Math.sin(0.0) + rect.exactCenterY());
            mArrow.moveTo(0.0f, 0.0f);
            mArrow.lineTo((float)mArrowWidth * mArrowScale, 0.0f);
            mArrow.lineTo(mArrowWidth * mArrowScale / 2.0f, (float)mArrowHeight * mArrowScale);
            mArrow.offset(n4 - n3, n5);
            mArrow.close();
            mArrowPaint.setColor(mCurrentColor);
            canvas.rotate(n + n2 - 5.0f, rect.exactCenterX(), rect.exactCenterY());
            canvas.drawPath(mArrow, mArrowPaint);
        }
    }
    
    private int getNextColorIndex() {
        return (1 + mColorIndex) % mColors.length;
    }
    
    private void invalidateSelf() {
        mCallback.invalidateDrawable((Drawable)null);
    }
    
    public void draw(final Canvas canvas, final Rect rect) {
        final RectF mTempBounds = this.mTempBounds;
        mTempBounds.set(rect);
        mTempBounds.inset(mStrokeInset, mStrokeInset);
        final float n = 360.0f * (mStartTrim + mRotation);
        final float n2 = 360.0f * (mEndTrim + mRotation) - n;
        mPaint.setColor(mCurrentColor);
        canvas.drawArc(mTempBounds, n, n2, false, mPaint);
        this.drawTriangle(canvas, n, n2, rect);
        if (mAlpha < 255) {
            mCirclePaint.setColor(mBackgroundColor);
            mCirclePaint.setAlpha(255 - mAlpha);
            canvas.drawCircle(rect.exactCenterX(), rect.exactCenterY(), (float)(rect.width() / 2), mCirclePaint);
        }
    }
    
    public int getAlpha() {
        return mAlpha;
    }
    
    public double getCenterRadius() {
        return mRingCenterRadius;
    }
    
    public float getEndTrim() {
        return mEndTrim;
    }
    
    public float getInsets() {
        return mStrokeInset;
    }
    
    public int getNextColor() {
        return mColors[this.getNextColorIndex()];
    }
    
    public float getRotation() {
        return mRotation;
    }
    
    public float getStartTrim() {
        return mStartTrim;
    }
    
    public int getStartingColor() {
        return mColors[mColorIndex];
    }
    
    public float getStartingEndTrim() {
        return mStartingEndTrim;
    }
    
    public float getStartingRotation() {
        return mStartingRotation;
    }
    
    public float getStartingStartTrim() {
        return mStartingStartTrim;
    }
    
    public float getStrokeWidth() {
        return mStrokeWidth;
    }
    
    public void goToNextColor() {
        this.setColorIndex(this.getNextColorIndex());
    }
    
    public void resetOriginals() {
        mStartingStartTrim = 0.0f;
        mStartingEndTrim = 0.0f;
        this.setStartTrim(mStartingRotation = 0.0f);
        this.setEndTrim(0.0f);
        this.setRotation(0.0f);
    }
    
    public void setAlpha(final int mAlpha) {
        this.mAlpha = mAlpha;
    }
    
    public void setArrowDimensions(final float n, final float n2) {
        mArrowWidth = (int)n;
        mArrowHeight = (int)n2;
    }
    
    public void setArrowScale(final float mArrowScale) {
        if (mArrowScale != this.mArrowScale) {
            this.mArrowScale = mArrowScale;
            this.invalidateSelf();
        }
    }
    
    public void setBackgroundColor(final int mBackgroundColor) {
        this.mBackgroundColor = mBackgroundColor;
    }
    
    public void setCenterRadius(final double mRingCenterRadius) {
        this.mRingCenterRadius = mRingCenterRadius;
    }
    
    public void setColor(final int mCurrentColor) {
        this.mCurrentColor = mCurrentColor;
    }
    
    public void setColorFilter(final ColorFilter colorFilter) {
        mPaint.setColorFilter(colorFilter);
        this.invalidateSelf();
    }
    
    public void setColorIndex(final int mColorIndex) {
        this.mColorIndex = mColorIndex;
        mCurrentColor = mColors[this.mColorIndex];
    }
    
    public void setColors(@NonNull final int[] mColors) {
        this.mColors = mColors;
        this.setColorIndex(0);
    }
    
    public void setEndTrim(final float mEndTrim) {
        this.mEndTrim = mEndTrim;
        this.invalidateSelf();
    }
    
    public void setInsets(final int n, final int n2) {
        final float n3 = (float)Math.min(n, n2);
        float mStrokeInset;
        if (mRingCenterRadius <= 0.0 || n3 < 0.0f) {
            mStrokeInset = (float)Math.ceil(mStrokeWidth / 2.0f);
        }
        else {
            mStrokeInset = (float)(n3 / 2.0f - mRingCenterRadius);
        }
        this.mStrokeInset = mStrokeInset;
    }
    
    public void setRotation(final float mRotation) {
        this.mRotation = mRotation;
        this.invalidateSelf();
    }
    
    public void setShowArrow(final boolean mShowArrow) {
        if (this.mShowArrow != mShowArrow) {
            this.mShowArrow = mShowArrow;
            this.invalidateSelf();
        }
    }
    
    public void setStartTrim(final float mStartTrim) {
        this.mStartTrim = mStartTrim;
        this.invalidateSelf();
    }
    
    public void setStrokeWidth(final float n) {
        mStrokeWidth = n;
        mPaint.setStrokeWidth(n);
        this.invalidateSelf();
    }
    
    public void storeOriginals() {
        mStartingStartTrim = mStartTrim;
        mStartingEndTrim = mEndTrim;
        mStartingRotation = mRotation;
    }
}
