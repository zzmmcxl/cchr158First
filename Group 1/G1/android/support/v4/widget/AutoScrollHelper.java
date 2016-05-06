package android.support.v4.widget;

import android.view.animation.AnimationUtils;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.view.MotionEvent;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.content.res.Resources;
import android.view.animation.AccelerateInterpolator;
import android.view.ViewConfiguration;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.View$OnTouchListener;

public abstract class AutoScrollHelper implements View$OnTouchListener
{
    private static final int DEFAULT_ACTIVATION_DELAY = 0;
    private static final int DEFAULT_EDGE_TYPE = 1;
    private static final float DEFAULT_MAXIMUM_EDGE = Float.MAX_VALUE;
    private static final int DEFAULT_MAXIMUM_VELOCITY_DIPS = 1575;
    private static final int DEFAULT_MINIMUM_VELOCITY_DIPS = 315;
    private static final int DEFAULT_RAMP_DOWN_DURATION = 500;
    private static final int DEFAULT_RAMP_UP_DURATION = 500;
    private static final float DEFAULT_RELATIVE_EDGE = 0.2f;
    private static final float DEFAULT_RELATIVE_VELOCITY = 1.0f;
    public static final int EDGE_TYPE_INSIDE = 0;
    public static final int EDGE_TYPE_INSIDE_EXTEND = 1;
    public static final int EDGE_TYPE_OUTSIDE = 2;
    private static final int HORIZONTAL = 0;
    public static final float NO_MAX = Float.MAX_VALUE;
    public static final float NO_MIN = 0.0f;
    public static final float RELATIVE_UNSPECIFIED = 0.0f;
    private static final int VERTICAL = 1;
    private int mActivationDelay;
    private boolean mAlreadyDelayed;
    private boolean mAnimating;
    private final Interpolator mEdgeInterpolator;
    private int mEdgeType;
    private boolean mEnabled;
    private boolean mExclusive;
    private float[] mMaximumEdges;
    private float[] mMaximumVelocity;
    private float[] mMinimumVelocity;
    private boolean mNeedsCancel;
    private boolean mNeedsReset;
    private float[] mRelativeEdges;
    private float[] mRelativeVelocity;
    private Runnable mRunnable;
    private final ClampedScroller mScroller;
    private final View mTarget;
    
    public AutoScrollHelper(final View mTarget) {
        super();
        mScroller = new ClampedScroller();
        mEdgeInterpolator = (Interpolator)new AccelerateInterpolator();
        mRelativeEdges = new float[] { 0.0f, 0.0f };
        mMaximumEdges = new float[] { Float.MAX_VALUE, Float.MAX_VALUE };
        mRelativeVelocity = new float[] { 0.0f, 0.0f };
        mMinimumVelocity = new float[] { 0.0f, 0.0f };
        mMaximumVelocity = new float[] { Float.MAX_VALUE, Float.MAX_VALUE };
        mTarget = mTarget;
        final DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        final int n = (int)(0.5f + 1575.0f * displayMetrics.density);
        final int n2 = (int)(0.5f + 315.0f * displayMetrics.density);
        this.setMaximumVelocity(n, n);
        this.setMinimumVelocity(n2, n2);
        this.setEdgeType(1);
        this.setMaximumEdges(Float.MAX_VALUE, Float.MAX_VALUE);
        this.setRelativeEdges(0.2f, 0.2f);
        this.setRelativeVelocity(1.0f, 1.0f);
        this.setActivationDelay(DEFAULT_ACTIVATION_DELAY);
        this.setRampUpDuration(500);
        this.setRampDownDuration(500);
    }
    
    static /* synthetic */ boolean access$100(final AutoScrollHelper autoScrollHelper) {
        return autoScrollHelper.mAnimating;
    }
    
    static /* synthetic */ boolean access$102(final AutoScrollHelper autoScrollHelper, final boolean mAnimating) {
        return autoScrollHelper.mAnimating = mAnimating;
    }
    
    static /* synthetic */ boolean access$200(final AutoScrollHelper autoScrollHelper) {
        return autoScrollHelper.mNeedsReset;
    }
    
    static /* synthetic */ boolean access$202(final AutoScrollHelper autoScrollHelper, final boolean mNeedsReset) {
        return autoScrollHelper.mNeedsReset = mNeedsReset;
    }
    
    static /* synthetic */ ClampedScroller access$300(final AutoScrollHelper autoScrollHelper) {
        return autoScrollHelper.mScroller;
    }
    
    static /* synthetic */ boolean access$400(final AutoScrollHelper autoScrollHelper) {
        return autoScrollHelper.shouldAnimate();
    }
    
    static /* synthetic */ boolean access$500(final AutoScrollHelper autoScrollHelper) {
        return autoScrollHelper.mNeedsCancel;
    }
    
    static /* synthetic */ boolean access$502(final AutoScrollHelper autoScrollHelper, final boolean mNeedsCancel) {
        return autoScrollHelper.mNeedsCancel = mNeedsCancel;
    }
    
    static /* synthetic */ void access$600(final AutoScrollHelper autoScrollHelper) {
        autoScrollHelper.cancelTargetTouch();
    }
    
    static /* synthetic */ View access$700(final AutoScrollHelper autoScrollHelper) {
        return autoScrollHelper.mTarget;
    }
    
    static /* synthetic */ int access$800(final int n, final int n2, final int n3) {
        return constrain(n, n2, n3);
    }
    
    static /* synthetic */ float access$900(final float n, final float n2, final float n3) {
        return constrain(n, n2, n3);
    }
    
    private void cancelTargetTouch() {
        final long uptimeMillis = SystemClock.uptimeMillis();
        final MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        mTarget.onTouchEvent(obtain);
        obtain.recycle();
    }
    
    private float computeTargetVelocity(final int n, final float n2, final float n3, final float n4) {
        final float edgeValue = this.getEdgeValue(mRelativeEdges[n], n3, mMaximumEdges[n], n2);
        if (edgeValue == 0.0f) {
            return 0.0f;
        }
        final float n5 = mRelativeVelocity[n];
        final float n6 = mMinimumVelocity[n];
        final float n7 = mMaximumVelocity[n];
        final float n8 = n5 * n4;
        if (edgeValue > 0.0f) {
            return constrain(edgeValue * n8, n6, n7);
        }
        return -constrain(n8 * -edgeValue, n6, n7);
    }
    
    private static float constrain(final float n, final float n2, final float n3) {
        if (n > n3) {
            return n3;
        }
        if (n < n2) {
            return n2;
        }
        return n;
    }
    
    private static int constrain(final int n, final int n2, final int n3) {
        if (n > n3) {
            return n3;
        }
        if (n < n2) {
            return n2;
        }
        return n;
    }
    
    private float constrainEdgeValue(final float n, final float n2) {
        if (n2 != 0.0f) {
            switch (mEdgeType) {
                default:
                    return 0.0f;
                case 0:
                case 1:
                    if (n >= n2) {
                        break;
                    }
                    if (n >= 0.0f) {
                        return 1.0f - n / n2;
                    }
                    if (mAnimating && mEdgeType == 1) {
                        return 1.0f;
                    }
                    break;
                case 2:
                    if (n < 0.0f) {
                        return n / -n2;
                    }
                    break;
            }
        }
        return 0.0f;
    }
    
    private float getEdgeValue(final float n, final float n2, final float n3, final float n4) {
        final float constrain = constrain(n * n2, 0.0f, n3);
        final float n5 = this.constrainEdgeValue(n2 - n4, constrain) - this.constrainEdgeValue(n4, constrain);
        float interpolation;
        if (n5 < 0.0f) {
            interpolation = -mEdgeInterpolator.getInterpolation(-n5);
        }
        else {
            final float n6 = fcmpl(n5, 0.0f);
            final float constrain2 = 0.0f;
            if (n6 <= 0) {
                return constrain2;
            }
            interpolation = mEdgeInterpolator.getInterpolation(n5);
        }
        return constrain(interpolation, -1.0f, 1.0f);
    }
    
    private void requestStop() {
        if (mNeedsReset) {
            mAnimating = false;
            return;
        }
        mScroller.requestStop();
    }
    
    private boolean shouldAnimate() {
        final ClampedScroller mScroller = this.mScroller;
        final int verticalDirection = mScroller.getVerticalDirection();
        final int horizontalDirection = mScroller.getHorizontalDirection();
        return (verticalDirection != 0 && this.canTargetScrollVertically(verticalDirection)) || (horizontalDirection != 0 && this.canTargetScrollHorizontally(horizontalDirection));
    }
    
    private void startAnimating() {
        if (mRunnable == null) {
            mRunnable = new ScrollAnimationRunnable(this);
        }
        mAnimating = true;
        mNeedsReset = true;
        if (!mAlreadyDelayed && mActivationDelay > 0) {
            ViewCompat.postOnAnimationDelayed(mTarget, mRunnable, mActivationDelay);
        }
        else {
            mRunnable.run();
        }
        mAlreadyDelayed = true;
    }
    
    public abstract boolean canTargetScrollHorizontally(final int p0);
    
    public abstract boolean canTargetScrollVertically(final int p0);
    
    public boolean isEnabled() {
        return mEnabled;
    }
    
    public boolean isExclusive() {
        return mExclusive;
    }
    
    public boolean onTouch(final View view, final MotionEvent motionEvent) {
        int mNeedsCancel = 1;
        if (!mEnabled) {
            return false;
        }
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 0:
                this.mNeedsCancel = (mNeedsCancel != 0);
                mAlreadyDelayed = false;
            case 2:
                mScroller.setTargetVelocity(this.computeTargetVelocity(0, motionEvent.getX(), (float)view.getWidth(), (float)mTarget.getWidth()), this.computeTargetVelocity(mNeedsCancel, motionEvent.getY(), (float)view.getHeight(), (float)mTarget.getHeight()));
                if (!mAnimating && this.shouldAnimate()) {
                    this.startAnimating();
                    break;
                }
                break;
            case 1:
            case 3:
                this.requestStop();
                break;
        }
        if (!mExclusive || !mAnimating) {
            mNeedsCancel = 0;
        }
        return mNeedsCancel != 0;
    }
    
    public abstract void scrollTargetBy(final int p0, final int p1);
    
    public AutoScrollHelper setActivationDelay(final int mActivationDelay) {
        this.mActivationDelay = mActivationDelay;
        return this;
    }
    
    public AutoScrollHelper setEdgeType(final int mEdgeType) {
        this.mEdgeType = mEdgeType;
        return this;
    }
    
    public AutoScrollHelper setEnabled(final boolean mEnabled) {
        if (this.mEnabled && !mEnabled) {
            this.requestStop();
        }
        this.mEnabled = mEnabled;
        return this;
    }
    
    public AutoScrollHelper setExclusive(final boolean mExclusive) {
        this.mExclusive = mExclusive;
        return this;
    }
    
    public AutoScrollHelper setMaximumEdges(final float n, final float n2) {
        mMaximumEdges[0] = n;
        mMaximumEdges[1] = n2;
        return this;
    }
    
    public AutoScrollHelper setMaximumVelocity(final float n, final float n2) {
        mMaximumVelocity[0] = n / 1000.0f;
        mMaximumVelocity[1] = n2 / 1000.0f;
        return this;
    }
    
    public AutoScrollHelper setMinimumVelocity(final float n, final float n2) {
        mMinimumVelocity[0] = n / 1000.0f;
        mMinimumVelocity[1] = n2 / 1000.0f;
        return this;
    }
    
    public AutoScrollHelper setRampDownDuration(final int rampDownDuration) {
        mScroller.setRampDownDuration(rampDownDuration);
        return this;
    }
    
    public AutoScrollHelper setRampUpDuration(final int rampUpDuration) {
        mScroller.setRampUpDuration(rampUpDuration);
        return this;
    }
    
    public AutoScrollHelper setRelativeEdges(final float n, final float n2) {
        mRelativeEdges[0] = n;
        mRelativeEdges[1] = n2;
        return this;
    }
    
    public AutoScrollHelper setRelativeVelocity(final float n, final float n2) {
        mRelativeVelocity[0] = n / 1000.0f;
        mRelativeVelocity[1] = n2 / 1000.0f;
        return this;
    }
}
