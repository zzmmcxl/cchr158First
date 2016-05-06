package android.support.v4.widget;

import android.support.v4.view.ViewCompat;
import android.view.animation.AnimationUtils;
import android.graphics.Canvas;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.view.View;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Rect;
import android.view.animation.Interpolator;

final class SwipeProgressBar
{
    private static final int ANIMATION_DURATION_MS = 2000;
    private static final int COLOR1 = -1291845632;
    private static final int COLOR2 = Integer.MIN_VALUE;
    private static final int COLOR3 = 1291845632;
    private static final int COLOR4 = 436207616;
    private static final int FINISH_ANIMATION_DURATION_MS = 1000;
    private static final Interpolator INTERPOLATOR;
    private Rect mBounds;
    private final RectF mClipRect;
    private int mColor1;
    private int mColor2;
    private int mColor3;
    private int mColor4;
    private long mFinishTime;
    private final Paint mPaint;
    private View mParent;
    private boolean mRunning;
    private long mStartTime;
    private float mTriggerPercentage;
    
    static {
        INTERPOLATOR = (Interpolator)new FastOutSlowInInterpolator();
    }
    
    public SwipeProgressBar(final View mParent) {
        super();
        mPaint = new Paint();
        mClipRect = new RectF();
        mBounds = new Rect();
        mParent = mParent;
        mColor1 = -1291845632;
        mColor2 = Integer.MIN_VALUE;
        mColor3 = 1291845632;
        mColor4 = 436207616;
    }
    
    private void drawCircle(final Canvas canvas, final float n, final float n2, final int color, final float n3) {
        mPaint.setColor(color);
        canvas.save();
        canvas.translate(n, n2);
        final float interpolation = INTERPOLATOR.getInterpolation(n3);
        canvas.scale(interpolation, interpolation);
        canvas.drawCircle(0.0f, 0.0f, n, mPaint);
        canvas.restore();
    }
    
    private void drawTrigger(final Canvas canvas, final int n, final int n2) {
        mPaint.setColor(mColor1);
        canvas.drawCircle((float)n, (float)n2, (float)n * mTriggerPercentage, mPaint);
    }
    
    void draw(final Canvas canvas) {
        final int width = mBounds.width();
        final int height = mBounds.height();
        final int n = width / 2;
        final int n2 = height / 2;
        int n3 = canvas.save();
        canvas.clipRect(mBounds);
        if (mRunning || mFinishTime > 0L) {
            final long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            final long n4 = (currentAnimationTimeMillis - mStartTime) % 2000L;
            final long n5 = (currentAnimationTimeMillis - mStartTime) / 2000L;
            final float n6 = n4 / 20.0f;
            final boolean mRunning = this.mRunning;
            boolean b = false;
            if (!mRunning) {
                if (currentAnimationTimeMillis - mFinishTime >= 1000L) {
                    mFinishTime = 0L;
                    return;
                }
                final float n7 = width / 2 * INTERPOLATOR.getInterpolation((currentAnimationTimeMillis - mFinishTime) % 1000L / 10.0f / 100.0f);
                mClipRect.set((float)n - n7, 0.0f, n7 + (float)n, (float)height);
                canvas.saveLayerAlpha(mClipRect, 0, 0);
                b = true;
            }
            if (n5 == 0L) {
                canvas.drawColor(mColor1);
            }
            else if (n6 >= 0.0f && n6 < 25.0f) {
                canvas.drawColor(mColor4);
            }
            else if (n6 >= 25.0f && n6 < 50.0f) {
                canvas.drawColor(mColor1);
            }
            else if (n6 >= 50.0f && n6 < 75.0f) {
                canvas.drawColor(mColor2);
            }
            else {
                canvas.drawColor(mColor3);
            }
            if (n6 >= 0.0f && n6 <= 25.0f) {
                this.drawCircle(canvas, n, n2, mColor1, 2.0f * (25.0f + n6) / 100.0f);
            }
            if (n6 >= 0.0f && n6 <= 50.0f) {
                this.drawCircle(canvas, n, n2, mColor2, 2.0f * n6 / 100.0f);
            }
            if (n6 >= 25.0f && n6 <= 75.0f) {
                this.drawCircle(canvas, n, n2, mColor3, 2.0f * (n6 - 25.0f) / 100.0f);
            }
            if (n6 >= 50.0f && n6 <= 100.0f) {
                this.drawCircle(canvas, n, n2, mColor4, 2.0f * (n6 - 50.0f) / 100.0f);
            }
            if (n6 >= 75.0f && n6 <= 100.0f) {
                this.drawCircle(canvas, n, n2, mColor1, 2.0f * (n6 - 75.0f) / 100.0f);
            }
            if (mTriggerPercentage > 0.0f && b) {
                canvas.restoreToCount(n3);
                n3 = canvas.save();
                canvas.clipRect(mBounds);
                this.drawTrigger(canvas, n, n2);
            }
            ViewCompat.postInvalidateOnAnimation(mParent, mBounds.left, mBounds.top, mBounds.right, mBounds.bottom);
        }
        else if (mTriggerPercentage > 0.0f && mTriggerPercentage <= 1.0) {
            this.drawTrigger(canvas, n, n2);
        }
        canvas.restoreToCount(n3);
    }
    
    boolean isRunning() {
        return mRunning || mFinishTime > 0L;
    }
    
    void setBounds(final int left, final int top, final int right, final int bottom) {
        mBounds.left = left;
        mBounds.top = top;
        mBounds.right = right;
        mBounds.bottom = bottom;
    }
    
    void setColorScheme(final int mColor1, final int mColor2, final int mColor3, final int mColor4) {
        this.mColor1 = mColor1;
        this.mColor2 = mColor2;
        this.mColor3 = mColor3;
        this.mColor4 = mColor4;
    }
    
    void setTriggerPercentage(final float mTriggerPercentage) {
        this.mTriggerPercentage = mTriggerPercentage;
        mStartTime = 0L;
        ViewCompat.postInvalidateOnAnimation(mParent, mBounds.left, mBounds.top, mBounds.right, mBounds.bottom);
    }
    
    void start() {
        if (!mRunning) {
            mTriggerPercentage = 0.0f;
            mStartTime = AnimationUtils.currentAnimationTimeMillis();
            mRunning = true;
            mParent.postInvalidate();
        }
    }
    
    void stop() {
        if (mRunning) {
            mTriggerPercentage = 0.0f;
            mFinishTime = AnimationUtils.currentAnimationTimeMillis();
            mRunning = false;
            mParent.postInvalidate();
        }
    }
}
