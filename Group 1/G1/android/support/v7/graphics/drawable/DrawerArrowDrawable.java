package android.support.v7.graphics.drawable;

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Annotation;
import android.graphics.ColorFilter;
import android.support.annotation.FloatRange;
import android.support.annotation.ColorInt;
import android.graphics.Rect;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.graphics.Canvas;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.support.v7.appcompat.R;
import android.graphics.Paint$Cap;
import android.graphics.Paint$Join;
import android.graphics.Paint$Style;
import android.content.Context;
import android.graphics.Path;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

public class DrawerArrowDrawable extends Drawable
{
    public static final int ARROW_DIRECTION_END = 3;
    public static final int ARROW_DIRECTION_LEFT = 0;
    public static final int ARROW_DIRECTION_RIGHT = 1;
    public static final int ARROW_DIRECTION_START = 2;
    private static final float ARROW_HEAD_ANGLE;
    private float mArrowHeadLength;
    private float mArrowShaftLength;
    private float mBarGap;
    private float mBarLength;
    private int mDirection;
    private float mMaxCutForBarSize;
    private final Paint mPaint;
    private final Path mPath;
    private float mProgress;
    private final int mSize;
    private boolean mSpin;
    private boolean mVerticalMirror;
    
    static {
        ARROW_HEAD_ANGLE = (float)Math.toRadians(45.0);
    }
    
    public DrawerArrowDrawable(final Context context) {
        super();
        mPaint = new Paint();
        mPath = new Path();
        mVerticalMirror = false;
        mDirection = 2;
        mPaint.setStyle(Paint$Style.STROKE);
        mPaint.setStrokeJoin(Paint$Join.MITER);
        mPaint.setStrokeCap(Paint$Cap.BUTT);
        mPaint.setAntiAlias(true);
        final TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes((AttributeSet)null, R.styleable.DrawerArrowToggle, R.attr.drawerArrowStyle, R.style.Base_Widget_AppCompat_DrawerArrowToggle);
        this.setColor(obtainStyledAttributes.getColor(R.styleable.DrawerArrowToggle_color, 0));
        this.setBarThickness(obtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_thickness, 0.0f));
        this.setSpinEnabled(obtainStyledAttributes.getBoolean(R.styleable.DrawerArrowToggle_spinBars, true));
        this.setGapSize(Math.round(obtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_gapBetweenBars, 0.0f)));
        mSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DrawerArrowToggle_drawableSize, 0);
        mBarLength = Math.round(obtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_barLength, 0.0f));
        mArrowHeadLength = Math.round(obtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_arrowHeadLength, 0.0f));
        mArrowShaftLength = obtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_arrowShaftLength, 0.0f);
        obtainStyledAttributes.recycle();
    }
    
    private static float lerp(final float n, final float n2, final float n3) {
        return n + n3 * (n2 - n);
    }
    
    public void draw(final Canvas canvas) {
        final Rect bounds = this.getBounds();
        boolean b = false;
        switch (mDirection) {
            default:
                b = (DrawableCompat.getLayoutDirection(this) == 1);
                break;
            case 0:
                b = false;
                break;
            case 1:
                b = true;
                break;
            case 3:
                b = (DrawableCompat.getLayoutDirection(this) == 0);
                break;
        }
        final float lerp = lerp(mBarLength, (float)Math.sqrt(2.0f * (mArrowHeadLength * mArrowHeadLength)), mProgress);
        final float lerp2 = lerp(mBarLength, mArrowShaftLength, mProgress);
        final float n = (float)Math.round(lerp(0.0f, mMaxCutForBarSize, mProgress));
        final float lerp3 = lerp(0.0f, ARROW_HEAD_ANGLE, mProgress);
        float n2;
        if (b) {
            n2 = 0.0f;
        }
        else {
            n2 = -180.0f;
        }
        float n3;
        if (b) {
            n3 = 180.0f;
        }
        else {
            n3 = 0.0f;
        }
        final float lerp4 = lerp(n2, n3, mProgress);
        final float n4 = (float)Math.round((double)lerp * Math.cos(lerp3));
        final float n5 = (float)Math.round((double)lerp * Math.sin(lerp3));
        mPath.rewind();
        final float lerp5 = lerp(mBarGap + mPaint.getStrokeWidth(), -mMaxCutForBarSize, mProgress);
        final float n6 = -lerp2 / 2.0f;
        mPath.moveTo(n6 + n, 0.0f);
        mPath.rLineTo(lerp2 - 2.0f * n, 0.0f);
        mPath.moveTo(n6, lerp5);
        mPath.rLineTo(n4, n5);
        mPath.moveTo(n6, -lerp5);
        mPath.rLineTo(n4, -n5);
        mPath.close();
        canvas.save();
        final float strokeWidth = mPaint.getStrokeWidth();
        canvas.translate((float)bounds.centerX(), (float)(2 * ((int)(bounds.height() - 3.0f * strokeWidth - 2.0f * mBarGap) / 4) + (1.5 * strokeWidth + mBarGap)));
        if (mSpin) {
            int n7;
            if (b ^ mVerticalMirror) {
                n7 = -1;
            }
            else {
                n7 = 1;
            }
            canvas.rotate(lerp4 * (float)n7);
        }
        else if (b) {
            canvas.rotate(180.0f);
        }
        canvas.drawPath(mPath, mPaint);
        canvas.restore();
    }
    
    public float getArrowHeadLength() {
        return mArrowHeadLength;
    }
    
    public float getArrowShaftLength() {
        return mArrowShaftLength;
    }
    
    public float getBarLength() {
        return mBarLength;
    }
    
    public float getBarThickness() {
        return mPaint.getStrokeWidth();
    }
    
    @ColorInt
    public int getColor() {
        return mPaint.getColor();
    }
    
    public int getDirection() {
        return mDirection;
    }
    
    public float getGapSize() {
        return mBarGap;
    }
    
    public int getIntrinsicHeight() {
        return mSize;
    }
    
    public int getIntrinsicWidth() {
        return mSize;
    }
    
    public int getOpacity() {
        return -3;
    }
    
    public final Paint getPaint() {
        return mPaint;
    }
    
    @FloatRange(from = 0.0, to = 1.0)
    public float getProgress() {
        return mProgress;
    }
    
    public boolean isSpinEnabled() {
        return mSpin;
    }
    
    public void setAlpha(final int alpha) {
        if (alpha != mPaint.getAlpha()) {
            mPaint.setAlpha(alpha);
            this.invalidateSelf();
        }
    }
    
    public void setArrowHeadLength(final float mArrowHeadLength) {
        if (this.mArrowHeadLength != mArrowHeadLength) {
            this.mArrowHeadLength = mArrowHeadLength;
            this.invalidateSelf();
        }
    }
    
    public void setArrowShaftLength(final float mArrowShaftLength) {
        if (this.mArrowShaftLength != mArrowShaftLength) {
            this.mArrowShaftLength = mArrowShaftLength;
            this.invalidateSelf();
        }
    }
    
    public void setBarLength(final float mBarLength) {
        if (this.mBarLength != mBarLength) {
            this.mBarLength = mBarLength;
            this.invalidateSelf();
        }
    }
    
    public void setBarThickness(final float strokeWidth) {
        if (mPaint.getStrokeWidth() != strokeWidth) {
            mPaint.setStrokeWidth(strokeWidth);
            mMaxCutForBarSize = (float)(strokeWidth / 2.0f * Math.cos(ARROW_HEAD_ANGLE));
            this.invalidateSelf();
        }
    }
    
    public void setColor(@ColorInt final int color) {
        if (color != mPaint.getColor()) {
            mPaint.setColor(color);
            this.invalidateSelf();
        }
    }
    
    public void setColorFilter(final ColorFilter colorFilter) {
        mPaint.setColorFilter(colorFilter);
        this.invalidateSelf();
    }
    
    public void setDirection(final int mDirection) {
        if (mDirection != this.mDirection) {
            this.mDirection = mDirection;
            this.invalidateSelf();
        }
    }
    
    public void setGapSize(final float mBarGap) {
        if (mBarGap != this.mBarGap) {
            this.mBarGap = mBarGap;
            this.invalidateSelf();
        }
    }
    
    public void setProgress(@FloatRange(from = 0.0, to = 1.0) final float mProgress) {
        if (this.mProgress != mProgress) {
            this.mProgress = mProgress;
            this.invalidateSelf();
        }
    }
    
    public void setSpinEnabled(final boolean mSpin) {
        if (this.mSpin != mSpin) {
            this.mSpin = mSpin;
            this.invalidateSelf();
        }
    }
    
    public void setVerticalMirror(final boolean mVerticalMirror) {
        if (this.mVerticalMirror != mVerticalMirror) {
            this.mVerticalMirror = mVerticalMirror;
            this.invalidateSelf();
        }
    }
}
