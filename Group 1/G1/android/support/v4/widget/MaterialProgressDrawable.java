package android.support.v4.widget;

import android.support.annotation.NonNull;
import android.graphics.Path$FillType;
import android.graphics.Paint$Style;
import android.graphics.Paint$Cap;
import android.graphics.RectF;
import android.graphics.Paint;
import android.graphics.Path;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Annotation;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.Canvas;
import android.view.animation.Animation$AnimationListener;
import android.view.animation.Transformation;
import android.content.Context;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.view.animation.LinearInterpolator;
import android.content.res.Resources;
import android.view.View;
import android.graphics.drawable.Drawable$Callback;
import java.util.ArrayList;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;

class MaterialProgressDrawable extends Drawable implements Animatable
{
    private static final int ANIMATION_DURATION = 1332;
    private static final int ARROW_HEIGHT = 5;
    private static final int ARROW_HEIGHT_LARGE = 6;
    private static final float ARROW_OFFSET_ANGLE = 5.0f;
    private static final int ARROW_WIDTH = 10;
    private static final int ARROW_WIDTH_LARGE = 12;
    private static final float CENTER_RADIUS = 8.75f;
    private static final float CENTER_RADIUS_LARGE = 12.5f;
    private static final int CIRCLE_DIAMETER = 40;
    private static final int CIRCLE_DIAMETER_LARGE = 56;
    private static final float COLOR_START_DELAY_OFFSET = 0.75f;
    static final int DEFAULT = 1;
    private static final float END_TRIM_START_DELAY_OFFSET = 0.5f;
    private static final float FULL_ROTATION = 1080.0f;
    static final int LARGE = 0;
    private static final Interpolator LINEAR_INTERPOLATOR;
    private static final Interpolator MATERIAL_INTERPOLATOR;
    private static final float MAX_PROGRESS_ARC = 0.8f;
    private static final float NUM_POINTS = 5.0f;
    private static final float START_TRIM_DURATION_OFFSET = 0.5f;
    private static final float STROKE_WIDTH = 2.5f;
    private static final float STROKE_WIDTH_LARGE = 3.0f;
    private final int[] COLORS;
    private Animation mAnimation;
    private final ArrayList<Animation> mAnimators;
    private final Drawable$Callback mCallback;
    boolean mFinishing;
    private double mHeight;
    private View mParent;
    private Resources mResources;
    private final Ring mRing;
    private float mRotation;
    private float mRotationCount;
    private double mWidth;
    
    static {
        LINEAR_INTERPOLATOR = (Interpolator)new LinearInterpolator();
        MATERIAL_INTERPOLATOR = (Interpolator)new FastOutSlowInInterpolator();
    }
    
    public MaterialProgressDrawable(final Context context, final View mParent) {
        super();
        COLORS = new int[] { -16777216 };
        mAnimators = new ArrayList<Animation>();
        mCallback = (Drawable$Callback)new Drawable$Callback() {
            final /* synthetic */ MaterialProgressDrawable this$0;
            
            MaterialProgressDrawable$3() {
                this$0 = this$0;
                super();
            }
            
            public void invalidateDrawable(final Drawable drawable) {
                this$0.invalidateSelf();
            }
            
            public void scheduleDrawable(final Drawable drawable, final Runnable runnable, final long n) {
                this$0.scheduleSelf(runnable, n);
            }
            
            public void unscheduleDrawable(final Drawable drawable, final Runnable runnable) {
                this$0.unscheduleSelf(runnable);
            }
        };
        mParent = mParent;
        mResources = context.getResources();
        (mRing = new Ring(mCallback)).setColors(COLORS);
        this.updateSizes(1);
        this.setupAnimators();
    }
    
    static /* synthetic */ void access$000(final MaterialProgressDrawable materialProgressDrawable, final float n, final Ring ring) {
        materialProgressDrawable.applyFinishTranslation(n, ring);
    }
    
    static /* synthetic */ float access$100(final MaterialProgressDrawable materialProgressDrawable, final Ring ring) {
        return materialProgressDrawable.getMinProgressArc(ring);
    }
    
    static /* synthetic */ void access$200(final MaterialProgressDrawable materialProgressDrawable, final float n, final Ring ring) {
        materialProgressDrawable.updateRingColor(n, ring);
    }
    
    static /* synthetic */ Interpolator access$300() {
        return MATERIAL_INTERPOLATOR;
    }
    
    static /* synthetic */ float access$400(final MaterialProgressDrawable materialProgressDrawable) {
        return materialProgressDrawable.mRotationCount;
    }
    
    static /* synthetic */ float access$402(final MaterialProgressDrawable materialProgressDrawable, final float mRotationCount) {
        return materialProgressDrawable.mRotationCount = mRotationCount;
    }
    
    private void applyFinishTranslation(final float n, final Ring ring) {
        this.updateRingColor(n, ring);
        final float n2 = (float)(1.0 + Math.floor(ring.getStartingRotation() / 0.8f));
        ring.setStartTrim(ring.getStartingStartTrim() + n * (ring.getStartingEndTrim() - this.getMinProgressArc(ring) - ring.getStartingStartTrim()));
        ring.setEndTrim(ring.getStartingEndTrim());
        ring.setRotation(ring.getStartingRotation() + n * (n2 - ring.getStartingRotation()));
    }
    
    private int evaluateColorChange(final float n, final int n2, final int n3) {
        final int intValue = (int)Integer.valueOf(n2);
        final int n4 = 0xFF & intValue >> 24;
        final int n5 = 0xFF & intValue >> 16;
        final int n6 = 0xFF & intValue >> 8;
        final int n7 = intValue & 0xFF;
        final int intValue2 = (int)Integer.valueOf(n3);
        return n4 + (int)(n * ((0xFF & intValue2 >> 24) - n4)) << 24 | n5 + (int)(n * ((0xFF & intValue2 >> 16) - n5)) << 16 | n6 + (int)(n * ((0xFF & intValue2 >> 8) - n6)) << 8 | n7 + (int)(n * ((intValue2 & 0xFF) - n7));
    }
    
    private float getMinProgressArc(final Ring ring) {
        return (float)Math.toRadians((double)ring.getStrokeWidth() / (6.283185307179586 * ring.getCenterRadius()));
    }
    
    private float getRotation() {
        return mRotation;
    }
    
    private void setSizeParameters(final double n, final double n2, final double n3, final double n4, final float n5, final float n6) {
        final Ring mRing = this.mRing;
        final float density = mResources.getDisplayMetrics().density;
        mWidth = n * density;
        mHeight = n2 * density;
        mRing.setStrokeWidth(density * (float)n4);
        mRing.setCenterRadius(n3 * (double)density);
        mRing.setColorIndex(0);
        mRing.setArrowDimensions(n5 * density, n6 * density);
        mRing.setInsets((int)mWidth, (int)mHeight);
    }
    
    private void setupAnimators() {
        final Ring mRing = this.mRing;
        final Animation mAnimation = new Animation() {
            final /* synthetic */ MaterialProgressDrawable this$0;
            final /* synthetic */ Ring val$ring;
            
            MaterialProgressDrawable$1() {
                this$0 = this$0;
                super();
            }
            
            public void applyTransformation(final float n, final Transformation transformation) {
                if (mFinishing) {
                    this$0.applyFinishTranslation(n, mRing);
                    return;
                }
                final float access$100 = this$0.getMinProgressArc(mRing);
                final float startingEndTrim = mRing.getStartingEndTrim();
                final float startingStartTrim = mRing.getStartingStartTrim();
                final float startingRotation = mRing.getStartingRotation();
                this$0.updateRingColor(n, mRing);
                if (n <= 0.5f) {
                    mRing.setStartTrim(startingStartTrim + (0.8f - access$100) * MATERIAL_INTERPOLATOR.getInterpolation(n / 0.5f));
                }
                if (n > 0.5f) {
                    mRing.setEndTrim(startingEndTrim + (0.8f - access$100) * MATERIAL_INTERPOLATOR.getInterpolation((n - 0.5f) / 0.5f));
                }
                mRing.setRotation(startingRotation + 0.25f * n);
                this$0.setRotation(216.0f * n + 1080.0f * (mRotationCount / 5.0f));
            }
        };
        mAnimation.setRepeatCount(-1);
        mAnimation.setRepeatMode(1);
        mAnimation.setInterpolator(LINEAR_INTERPOLATOR);
        mAnimation.setAnimationListener((Animation$AnimationListener)new Animation$AnimationListener() {
            final /* synthetic */ MaterialProgressDrawable this$0;
            final /* synthetic */ Ring val$ring;
            
            MaterialProgressDrawable$2() {
                this$0 = this$0;
                super();
            }
            
            public void onAnimationEnd(final Animation animation) {
            }
            
            public void onAnimationRepeat(final Animation animation) {
                mRing.storeOriginals();
                mRing.goToNextColor();
                mRing.setStartTrim(mRing.getEndTrim());
                if (mFinishing) {
                    mFinishing = false;
                    animation.setDuration(1332L);
                    mRing.setShowArrow(false);
                    return;
                }
                mRotationCount = (1.0f + mRotationCount) % 5.0f;
            }
            
            public void onAnimationStart(final Animation animation) {
                mRotationCount = 0.0f;
            }
        });
        this.mAnimation = mAnimation;
    }
    
    private void updateRingColor(final float n, final Ring ring) {
        if (n > 0.75f) {
            ring.setColor(this.evaluateColorChange((n - 0.75f) / 0.25f, ring.getStartingColor(), ring.getNextColor()));
        }
    }
    
    public void draw(final Canvas canvas) {
        final Rect bounds = this.getBounds();
        final int save = canvas.save();
        canvas.rotate(mRotation, bounds.exactCenterX(), bounds.exactCenterY());
        mRing.draw(canvas, bounds);
        canvas.restoreToCount(save);
    }
    
    public int getAlpha() {
        return mRing.getAlpha();
    }
    
    public int getIntrinsicHeight() {
        return (int)mHeight;
    }
    
    public int getIntrinsicWidth() {
        return (int)mWidth;
    }
    
    public int getOpacity() {
        return -3;
    }
    
    public boolean isRunning() {
        final ArrayList<Animation> mAnimators = this.mAnimators;
        for (int size = mAnimators.size(), i = 0; i < size; ++i) {
            final Animation animation = (Animation)mAnimators.get(i);
            if (animation.hasStarted() && !animation.hasEnded()) {
                return true;
            }
        }
        return false;
    }
    
    public void setAlpha(final int alpha) {
        mRing.setAlpha(alpha);
    }
    
    public void setArrowScale(final float arrowScale) {
        mRing.setArrowScale(arrowScale);
    }
    
    public void setBackgroundColor(final int backgroundColor) {
        mRing.setBackgroundColor(backgroundColor);
    }
    
    public void setColorFilter(final ColorFilter colorFilter) {
        mRing.setColorFilter(colorFilter);
    }
    
    public void setColorSchemeColors(final int... colors) {
        mRing.setColors(colors);
        mRing.setColorIndex(0);
    }
    
    public void setProgressRotation(final float rotation) {
        mRing.setRotation(rotation);
    }
    
    void setRotation(final float mRotation) {
        this.mRotation = mRotation;
        this.invalidateSelf();
    }
    
    public void setStartEndTrim(final float startTrim, final float endTrim) {
        mRing.setStartTrim(startTrim);
        mRing.setEndTrim(endTrim);
    }
    
    public void showArrow(final boolean showArrow) {
        mRing.setShowArrow(showArrow);
    }
    
    public void start() {
        mAnimation.reset();
        mRing.storeOriginals();
        if (mRing.getEndTrim() != mRing.getStartTrim()) {
            mFinishing = true;
            mAnimation.setDuration(666L);
            mParent.startAnimation(mAnimation);
            return;
        }
        mRing.setColorIndex(0);
        mRing.resetOriginals();
        mAnimation.setDuration(1332L);
        mParent.startAnimation(mAnimation);
    }
    
    public void stop() {
        mParent.clearAnimation();
        this.setRotation(0.0f);
        mRing.setShowArrow(false);
        mRing.setColorIndex(0);
        mRing.resetOriginals();
    }
    
    public void updateSizes(@ProgressDrawableSize final int n) {
        if (n == 0) {
            this.setSizeParameters(56.0, 56.0, 12.5, 3.0, 12.0f, 6.0f);
            return;
        }
        this.setSizeParameters(40.0, 40.0, 8.75, 2.5, 10.0f, 5.0f);
    }
}
