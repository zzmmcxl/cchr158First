package android.support.v4.widget;

import android.content.res.Resources;
import android.support.annotation.ColorRes;
import android.support.annotation.ColorInt;
import android.view.View$MeasureSpec;
import android.util.Log;
import android.widget.AbsListView;
import android.os.Build$VERSION;
import android.support.v4.view.MotionEventCompat;
import android.view.MotionEvent;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import android.util.DisplayMetrics;
import android.content.res.TypedArray;
import android.support.v4.view.ViewCompat;
import android.view.ViewConfiguration;
import android.view.animation.Transformation;
import android.util.AttributeSet;
import android.content.Context;
import android.view.View;
import android.view.animation.Animation$AnimationListener;
import android.support.v4.view.NestedScrollingParentHelper;
import android.support.v4.view.NestedScrollingChildHelper;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Animation;
import android.support.v4.view.NestedScrollingChild;
import android.support.v4.view.NestedScrollingParent;
import android.view.ViewGroup;

public class SwipeRefreshLayout extends ViewGroup implements NestedScrollingParent, NestedScrollingChild
{
    private static final int ALPHA_ANIMATION_DURATION = 300;
    private static final int ANIMATE_TO_START_DURATION = 200;
    private static final int ANIMATE_TO_TRIGGER_DURATION = 200;
    private static final int CIRCLE_BG_LIGHT = -328966;
    private static final int CIRCLE_DIAMETER = 40;
    private static final int CIRCLE_DIAMETER_LARGE = 56;
    private static final float DECELERATE_INTERPOLATION_FACTOR = 2.0f;
    public static final int DEFAULT = 1;
    private static final int DEFAULT_CIRCLE_TARGET = 64;
    private static final float DRAG_RATE = 0.5f;
    private static final int INVALID_POINTER = -1;
    public static final int LARGE = 0;
    private static final int[] LAYOUT_ATTRS;
    private static final String LOG_TAG;
    private static final int MAX_ALPHA = 255;
    private static final float MAX_PROGRESS_ANGLE = 0.8f;
    private static final int SCALE_DOWN_DURATION = 150;
    private static final int STARTING_PROGRESS_ALPHA = 76;
    private int mActivePointerId;
    private Animation mAlphaMaxAnimation;
    private Animation mAlphaStartAnimation;
    private final Animation mAnimateToCorrectPosition;
    private final Animation mAnimateToStartPosition;
    private int mCircleHeight;
    private CircleImageView mCircleView;
    private int mCircleViewIndex;
    private int mCircleWidth;
    private int mCurrentTargetOffsetTop;
    private final DecelerateInterpolator mDecelerateInterpolator;
    protected int mFrom;
    private float mInitialDownY;
    private float mInitialMotionY;
    private boolean mIsBeingDragged;
    private OnRefreshListener mListener;
    private int mMediumAnimationDuration;
    private boolean mNestedScrollInProgress;
    private final NestedScrollingChildHelper mNestedScrollingChildHelper;
    private final NestedScrollingParentHelper mNestedScrollingParentHelper;
    private boolean mNotify;
    private boolean mOriginalOffsetCalculated;
    protected int mOriginalOffsetTop;
    private final int[] mParentOffsetInWindow;
    private final int[] mParentScrollConsumed;
    private MaterialProgressDrawable mProgress;
    private Animation$AnimationListener mRefreshListener;
    private boolean mRefreshing;
    private boolean mReturningToStart;
    private boolean mScale;
    private Animation mScaleAnimation;
    private Animation mScaleDownAnimation;
    private Animation mScaleDownToStartAnimation;
    private float mSpinnerFinalOffset;
    private float mStartingScale;
    private View mTarget;
    private float mTotalDragDistance;
    private float mTotalUnconsumed;
    private int mTouchSlop;
    private boolean mUsingCustomStart;
    
    static {
        LOG_TAG = SwipeRefreshLayout.class.getSimpleName();
        LAYOUT_ATTRS = new int[] { 16842766 };
    }
    
    public SwipeRefreshLayout(final Context context) {
        this(context, null);
    }
    
    public SwipeRefreshLayout(final Context context, final AttributeSet set) {
        super(context, set);
        mRefreshing = false;
        mTotalDragDistance = -1.0f;
        mParentScrollConsumed = new int[2];
        mParentOffsetInWindow = new int[2];
        mOriginalOffsetCalculated = false;
        mActivePointerId = -1;
        mCircleViewIndex = -1;
        mRefreshListener = (Animation$AnimationListener)new Animation$AnimationListener() {
            final /* synthetic */ SwipeRefreshLayout this$0;
            
            SwipeRefreshLayout$1() {
                this$0 = this$0;
                super();
            }
            
            public void onAnimationEnd(final Animation animation) {
                if (mRefreshing) {
                    mProgress.setAlpha(255);
                    mProgress.start();
                    if (mNotify && mListener != null) {
                        mListener.onRefresh();
                    }
                    mCurrentTargetOffsetTop = mCircleView.getTop();
                    return;
                }
                this$0.reset();
            }
            
            public void onAnimationRepeat(final Animation animation) {
            }
            
            public void onAnimationStart(final Animation animation) {
            }
        };
        mAnimateToCorrectPosition = new Animation() {
            final /* synthetic */ SwipeRefreshLayout this$0;
            
            SwipeRefreshLayout$6() {
                this$0 = this$0;
                super();
            }
            
            public void applyTransformation(final float n, final Transformation transformation) {
                int n2;
                if (!mUsingCustomStart) {
                    n2 = (int)(mSpinnerFinalOffset - Math.abs(mOriginalOffsetTop));
                }
                else {
                    n2 = (int)mSpinnerFinalOffset;
                }
                this$0.setTargetOffsetTopAndBottom(mFrom + (int)(n * (n2 - mFrom)) - mCircleView.getTop(), false);
                mProgress.setArrowScale(1.0f - n);
            }
        };
        mAnimateToStartPosition = new Animation() {
            final /* synthetic */ SwipeRefreshLayout this$0;
            
            SwipeRefreshLayout$7() {
                this$0 = this$0;
                super();
            }
            
            public void applyTransformation(final float n, final Transformation transformation) {
                this$0.moveToStart(n);
            }
        };
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        mMediumAnimationDuration = this.getResources().getInteger(17694721);
        this.setWillNotDraw(false);
        mDecelerateInterpolator = new DecelerateInterpolator(2.0f);
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, LAYOUT_ATTRS);
        this.setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
        final DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        mCircleWidth = (int)(40.0f * displayMetrics.density);
        mCircleHeight = (int)(40.0f * displayMetrics.density);
        this.createProgressView();
        ViewCompat.setChildrenDrawingOrderEnabled(this, true);
        mSpinnerFinalOffset = 64.0f * displayMetrics.density;
        mTotalDragDistance = mSpinnerFinalOffset;
        mNestedScrollingParentHelper = new NestedScrollingParentHelper(this);
        mNestedScrollingChildHelper = new NestedScrollingChildHelper((View)this);
        this.setNestedScrollingEnabled(true);
    }
    
    static /* synthetic */ boolean access$000(final SwipeRefreshLayout swipeRefreshLayout) {
        return swipeRefreshLayout.mRefreshing;
    }
    
    static /* synthetic */ MaterialProgressDrawable access$100(final SwipeRefreshLayout swipeRefreshLayout) {
        return swipeRefreshLayout.mProgress;
    }
    
    static /* synthetic */ boolean access$1000(final SwipeRefreshLayout swipeRefreshLayout) {
        return swipeRefreshLayout.mUsingCustomStart;
    }
    
    static /* synthetic */ float access$1100(final SwipeRefreshLayout swipeRefreshLayout) {
        return swipeRefreshLayout.mSpinnerFinalOffset;
    }
    
    static /* synthetic */ void access$1200(final SwipeRefreshLayout swipeRefreshLayout, final int n, final boolean b) {
        swipeRefreshLayout.setTargetOffsetTopAndBottom(n, b);
    }
    
    static /* synthetic */ void access$1300(final SwipeRefreshLayout swipeRefreshLayout, final float n) {
        swipeRefreshLayout.moveToStart(n);
    }
    
    static /* synthetic */ float access$1400(final SwipeRefreshLayout swipeRefreshLayout) {
        return swipeRefreshLayout.mStartingScale;
    }
    
    static /* synthetic */ boolean access$200(final SwipeRefreshLayout swipeRefreshLayout) {
        return swipeRefreshLayout.mNotify;
    }
    
    static /* synthetic */ OnRefreshListener access$300(final SwipeRefreshLayout swipeRefreshLayout) {
        return swipeRefreshLayout.mListener;
    }
    
    static /* synthetic */ int access$402(final SwipeRefreshLayout swipeRefreshLayout, final int mCurrentTargetOffsetTop) {
        return swipeRefreshLayout.mCurrentTargetOffsetTop = mCurrentTargetOffsetTop;
    }
    
    static /* synthetic */ CircleImageView access$500(final SwipeRefreshLayout swipeRefreshLayout) {
        return swipeRefreshLayout.mCircleView;
    }
    
    static /* synthetic */ void access$600(final SwipeRefreshLayout swipeRefreshLayout) {
        swipeRefreshLayout.reset();
    }
    
    static /* synthetic */ void access$700(final SwipeRefreshLayout swipeRefreshLayout, final float animationProgress) {
        swipeRefreshLayout.setAnimationProgress(animationProgress);
    }
    
    static /* synthetic */ boolean access$800(final SwipeRefreshLayout swipeRefreshLayout) {
        return swipeRefreshLayout.mScale;
    }
    
    static /* synthetic */ void access$900(final SwipeRefreshLayout swipeRefreshLayout, final Animation$AnimationListener animation$AnimationListener) {
        swipeRefreshLayout.startScaleDownAnimation(animation$AnimationListener);
    }
    
    private void animateOffsetToCorrectPosition(final int mFrom, final Animation$AnimationListener animationListener) {
        this.mFrom = mFrom;
        mAnimateToCorrectPosition.reset();
        mAnimateToCorrectPosition.setDuration(200L);
        mAnimateToCorrectPosition.setInterpolator((Interpolator)mDecelerateInterpolator);
        if (animationListener != null) {
            mCircleView.setAnimationListener(animationListener);
        }
        mCircleView.clearAnimation();
        mCircleView.startAnimation(mAnimateToCorrectPosition);
    }
    
    private void animateOffsetToStartPosition(final int mFrom, final Animation$AnimationListener animationListener) {
        if (mScale) {
            this.startScaleDownReturnToStartAnimation(mFrom, animationListener);
            return;
        }
        this.mFrom = mFrom;
        mAnimateToStartPosition.reset();
        mAnimateToStartPosition.setDuration(200L);
        mAnimateToStartPosition.setInterpolator((Interpolator)mDecelerateInterpolator);
        if (animationListener != null) {
            mCircleView.setAnimationListener(animationListener);
        }
        mCircleView.clearAnimation();
        mCircleView.startAnimation(mAnimateToStartPosition);
    }
    
    private void createProgressView() {
        mCircleView = new CircleImageView(this.getContext(), -328966, 20.0f);
        (mProgress = new MaterialProgressDrawable(this.getContext(), (View)this)).setBackgroundColor(-328966);
        mCircleView.setImageDrawable((Drawable)mProgress);
        mCircleView.setVisibility(8);
        this.addView((View)mCircleView);
    }
    
    private void ensureTarget() {
        if (mTarget == null) {
            for (int i = 0; i < this.getChildCount(); ++i) {
                final View child = this.getChildAt(i);
                if (!child.equals(mCircleView)) {
                    mTarget = child;
                    break;
                }
            }
        }
    }
    
    private void finishSpinner(final float n) {
        if (n > mTotalDragDistance) {
            this.setRefreshing(true, true);
            return;
        }
        mRefreshing = false;
        mProgress.setStartEndTrim(0.0f, 0.0f);
        final boolean mScale = this.mScale;
        Object o = null;
        if (!mScale) {
            o = new Animation$AnimationListener() {
                final /* synthetic */ SwipeRefreshLayout this$0;
                
                SwipeRefreshLayout$5() {
                    this$0 = this$0;
                    super();
                }
                
                public void onAnimationEnd(final Animation animation) {
                    if (!mScale) {
                        this$0.startScaleDownAnimation(null);
                    }
                }
                
                public void onAnimationRepeat(final Animation animation) {
                }
                
                public void onAnimationStart(final Animation animation) {
                }
            };
        }
        this.animateOffsetToStartPosition(mCurrentTargetOffsetTop, (Animation$AnimationListener)o);
        mProgress.showArrow(false);
    }
    
    private float getMotionEventY(final MotionEvent motionEvent, final int n) {
        final int pointerIndex = MotionEventCompat.findPointerIndex(motionEvent, n);
        if (pointerIndex < 0) {
            return -1.0f;
        }
        return MotionEventCompat.getY(motionEvent, pointerIndex);
    }
    
    private boolean isAlphaUsedForScale() {
        return Build$VERSION.SDK_INT < 11;
    }
    
    private boolean isAnimationRunning(final Animation animation) {
        return animation != null && animation.hasStarted() && !animation.hasEnded();
    }
    
    private void moveSpinner(final float n) {
        mProgress.showArrow(true);
        final float min = Math.min(1.0f, Math.abs(n / mTotalDragDistance));
        final float n2 = 5.0f * (float)Math.max((double)min - 0.4, 0.0) / 3.0f;
        final float n3 = Math.abs(n) - mTotalDragDistance;
        float mSpinnerFinalOffset;
        if (mUsingCustomStart) {
            mSpinnerFinalOffset = this.mSpinnerFinalOffset - mOriginalOffsetTop;
        }
        else {
            mSpinnerFinalOffset = this.mSpinnerFinalOffset;
        }
        final float max = Math.max(0.0f, Math.min(n3, 2.0f * mSpinnerFinalOffset) / mSpinnerFinalOffset);
        final float n4 = 2.0f * (float)(max / 4.0f - Math.pow(max / 4.0f, 2.0));
        final int n5 = mOriginalOffsetTop + (int)(2.0f * (mSpinnerFinalOffset * n4) + mSpinnerFinalOffset * min);
        if (mCircleView.getVisibility() != 0) {
            mCircleView.setVisibility(0);
        }
        if (!mScale) {
            ViewCompat.setScaleX((View)mCircleView, 1.0f);
            ViewCompat.setScaleY((View)mCircleView, 1.0f);
        }
        if (mScale) {
            this.setAnimationProgress(Math.min(1.0f, n / mTotalDragDistance));
        }
        if (n < mTotalDragDistance) {
            if (mProgress.getAlpha() > 76 && !this.isAnimationRunning(mAlphaStartAnimation)) {
                this.startProgressAlphaStartAnimation();
            }
        }
        else if (mProgress.getAlpha() < 255 && !this.isAnimationRunning(mAlphaMaxAnimation)) {
            this.startProgressAlphaMaxAnimation();
        }
        mProgress.setStartEndTrim(0.0f, Math.min(0.8f, n2 * 0.8f));
        mProgress.setArrowScale(Math.min(1.0f, n2));
        mProgress.setProgressRotation(0.5f * (-0.25f + 0.4f * n2 + 2.0f * n4));
        this.setTargetOffsetTopAndBottom(n5 - mCurrentTargetOffsetTop, true);
    }
    
    private void moveToStart(final float n) {
        this.setTargetOffsetTopAndBottom(mFrom + (int)(n * (mOriginalOffsetTop - mFrom)) - mCircleView.getTop(), false);
    }
    
    private void onSecondaryPointerUp(final MotionEvent motionEvent) {
        final int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (MotionEventCompat.getPointerId(motionEvent, actionIndex) == mActivePointerId) {
            int n;
            if (actionIndex == 0) {
                n = 1;
            }
            else {
                n = 0;
            }
            mActivePointerId = MotionEventCompat.getPointerId(motionEvent, n);
        }
    }
    
    private void reset() {
        mCircleView.clearAnimation();
        mProgress.stop();
        mCircleView.setVisibility(8);
        this.setColorViewAlpha(255);
        if (mScale) {
            this.setAnimationProgress(0.0f);
        }
        else {
            this.setTargetOffsetTopAndBottom(mOriginalOffsetTop - mCurrentTargetOffsetTop, true);
        }
        mCurrentTargetOffsetTop = mCircleView.getTop();
    }
    
    private void setAnimationProgress(final float n) {
        if (this.isAlphaUsedForScale()) {
            this.setColorViewAlpha((int)(255.0f * n));
            return;
        }
        ViewCompat.setScaleX((View)mCircleView, n);
        ViewCompat.setScaleY((View)mCircleView, n);
    }
    
    private void setColorViewAlpha(final int n) {
        mCircleView.getBackground().setAlpha(n);
        mProgress.setAlpha(n);
    }
    
    private void setRefreshing(final boolean mRefreshing, final boolean mNotify) {
        if (this.mRefreshing != mRefreshing) {
            this.mNotify = mNotify;
            this.ensureTarget();
            this.mRefreshing = mRefreshing;
            if (!this.mRefreshing) {
                this.startScaleDownAnimation(mRefreshListener);
                return;
            }
            this.animateOffsetToCorrectPosition(mCurrentTargetOffsetTop, mRefreshListener);
        }
    }
    
    private void setTargetOffsetTopAndBottom(final int n, final boolean b) {
        mCircleView.bringToFront();
        mCircleView.offsetTopAndBottom(n);
        mCurrentTargetOffsetTop = mCircleView.getTop();
        if (b && Build$VERSION.SDK_INT < 11) {
            this.invalidate();
        }
    }
    
    private Animation startAlphaAnimation(final int n, final int n2) {
        if (mScale && this.isAlphaUsedForScale()) {
            return null;
        }
        final Animation animation = new Animation() {
            final /* synthetic */ SwipeRefreshLayout this$0;
            final /* synthetic */ int val$endingAlpha;
            final /* synthetic */ int val$startingAlpha;
            
            SwipeRefreshLayout$4() {
                this$0 = this$0;
                super();
            }
            
            public void applyTransformation(final float n, final Transformation transformation) {
                mProgress.setAlpha((int)(n + n * (n2 - n)));
            }
        };
        animation.setDuration(300L);
        mCircleView.setAnimationListener(null);
        mCircleView.clearAnimation();
        mCircleView.startAnimation((Animation)animation);
        return animation;
    }
    
    private void startProgressAlphaMaxAnimation() {
        mAlphaMaxAnimation = this.startAlphaAnimation(mProgress.getAlpha(), 255);
    }
    
    private void startProgressAlphaStartAnimation() {
        mAlphaStartAnimation = this.startAlphaAnimation(mProgress.getAlpha(), 76);
    }
    
    private void startScaleDownAnimation(final Animation$AnimationListener animationListener) {
        (mScaleDownAnimation = new Animation() {
            final /* synthetic */ SwipeRefreshLayout this$0;
            
            SwipeRefreshLayout$3() {
                this$0 = this$0;
                super();
            }
            
            public void applyTransformation(final float n, final Transformation transformation) {
                this$0.setAnimationProgress(1.0f - n);
            }
        }).setDuration(150L);
        mCircleView.setAnimationListener(animationListener);
        mCircleView.clearAnimation();
        mCircleView.startAnimation(mScaleDownAnimation);
    }
    
    private void startScaleDownReturnToStartAnimation(final int mFrom, final Animation$AnimationListener animationListener) {
        this.mFrom = mFrom;
        if (this.isAlphaUsedForScale()) {
            mStartingScale = mProgress.getAlpha();
        }
        else {
            mStartingScale = ViewCompat.getScaleX((View)mCircleView);
        }
        (mScaleDownToStartAnimation = new Animation() {
            final /* synthetic */ SwipeRefreshLayout this$0;
            
            SwipeRefreshLayout$8() {
                this$0 = this$0;
                super();
            }
            
            public void applyTransformation(final float n, final Transformation transformation) {
                this$0.setAnimationProgress(mStartingScale + n * -mStartingScale);
                this$0.moveToStart(n);
            }
        }).setDuration(150L);
        if (animationListener != null) {
            mCircleView.setAnimationListener(animationListener);
        }
        mCircleView.clearAnimation();
        mCircleView.startAnimation(mScaleDownToStartAnimation);
    }
    
    private void startScaleUpAnimation(final Animation$AnimationListener animationListener) {
        mCircleView.setVisibility(0);
        if (Build$VERSION.SDK_INT >= 11) {
            mProgress.setAlpha(255);
        }
        (mScaleAnimation = new Animation() {
            final /* synthetic */ SwipeRefreshLayout this$0;
            
            SwipeRefreshLayout$2() {
                this$0 = this$0;
                super();
            }
            
            public void applyTransformation(final float n, final Transformation transformation) {
                this$0.setAnimationProgress(n);
            }
        }).setDuration((long)mMediumAnimationDuration);
        if (animationListener != null) {
            mCircleView.setAnimationListener(animationListener);
        }
        mCircleView.clearAnimation();
        mCircleView.startAnimation(mScaleAnimation);
    }
    
    public boolean canChildScrollUp() {
        if (Build$VERSION.SDK_INT >= 14) {
            return ViewCompat.canScrollVertically(mTarget, -1);
        }
        if (mTarget instanceof AbsListView) {
            final AbsListView absListView = (AbsListView)mTarget;
            return absListView.getChildCount() > 0 && (absListView.getFirstVisiblePosition() > 0 || absListView.getChildAt(0).getTop() < absListView.getPaddingTop());
        }
        if (!ViewCompat.canScrollVertically(mTarget, -1)) {
            final int scrollY = mTarget.getScrollY();
            final boolean b = false;
            if (scrollY <= 0) {
                return b;
            }
        }
        return true;
    }
    
    public boolean dispatchNestedFling(final float n, final float n2, final boolean b) {
        return mNestedScrollingChildHelper.dispatchNestedFling(n, n2, b);
    }
    
    public boolean dispatchNestedPreFling(final float n, final float n2) {
        return mNestedScrollingChildHelper.dispatchNestedPreFling(n, n2);
    }
    
    public boolean dispatchNestedPreScroll(final int n, final int n2, final int[] array, final int[] array2) {
        return mNestedScrollingChildHelper.dispatchNestedPreScroll(n, n2, array, array2);
    }
    
    public boolean dispatchNestedScroll(final int n, final int n2, final int n3, final int n4, final int[] array) {
        return mNestedScrollingChildHelper.dispatchNestedScroll(n, n2, n3, n4, array);
    }
    
    protected int getChildDrawingOrder(final int n, final int n2) {
        if (mCircleViewIndex >= 0) {
            if (n2 == n - 1) {
                return mCircleViewIndex;
            }
            if (n2 >= mCircleViewIndex) {
                return n2 + 1;
            }
        }
        return n2;
    }
    
    public int getNestedScrollAxes() {
        return mNestedScrollingParentHelper.getNestedScrollAxes();
    }
    
    public int getProgressCircleDiameter() {
        if (mCircleView != null) {
            return mCircleView.getMeasuredHeight();
        }
        return 0;
    }
    
    public boolean hasNestedScrollingParent() {
        return mNestedScrollingChildHelper.hasNestedScrollingParent();
    }
    
    public boolean isNestedScrollingEnabled() {
        return mNestedScrollingChildHelper.isNestedScrollingEnabled();
    }
    
    public boolean isRefreshing() {
        return mRefreshing;
    }
    
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.reset();
    }
    
    public boolean onInterceptTouchEvent(final MotionEvent motionEvent) {
        this.ensureTarget();
        final int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (mReturningToStart && actionMasked == 0) {
            mReturningToStart = false;
        }
        if (this.isEnabled() && !mReturningToStart && !this.canChildScrollUp() && !mRefreshing && !mNestedScrollInProgress) {
            switch (actionMasked) {
                case 0: {
                    this.setTargetOffsetTopAndBottom(mOriginalOffsetTop - mCircleView.getTop(), true);
                    mActivePointerId = MotionEventCompat.getPointerId(motionEvent, 0);
                    mIsBeingDragged = false;
                    final float motionEventY = this.getMotionEventY(motionEvent, mActivePointerId);
                    if (motionEventY != -1.0f) {
                        mInitialDownY = motionEventY;
                        break;
                    }
                    return false;
                }
                case 2: {
                    if (mActivePointerId == -1) {
                        Log.e(LOG_TAG, "Got ACTION_MOVE event but don't have an active pointer id.");
                        return false;
                    }
                    final float motionEventY2 = this.getMotionEventY(motionEvent, mActivePointerId);
                    if (motionEventY2 == -1.0f) {
                        return false;
                    }
                    if (motionEventY2 - mInitialDownY > mTouchSlop && !mIsBeingDragged) {
                        mInitialMotionY = mInitialDownY + mTouchSlop;
                        mIsBeingDragged = true;
                        mProgress.setAlpha(76);
                        break;
                    }
                    break;
                }
                case 6:
                    this.onSecondaryPointerUp(motionEvent);
                    break;
                case 1:
                case 3:
                    mIsBeingDragged = false;
                    mActivePointerId = -1;
                    break;
            }
            return mIsBeingDragged;
        }
        return false;
    }
    
    protected void onLayout(final boolean b, final int n, final int n2, final int n3, final int n4) {
        final int measuredWidth = this.getMeasuredWidth();
        final int measuredHeight = this.getMeasuredHeight();
        if (this.getChildCount() != 0) {
            if (mTarget == null) {
                this.ensureTarget();
            }
            if (mTarget != null) {
                final View mTarget = this.mTarget;
                final int paddingLeft = this.getPaddingLeft();
                final int paddingTop = this.getPaddingTop();
                mTarget.layout(paddingLeft, paddingTop, paddingLeft + (measuredWidth - this.getPaddingLeft() - this.getPaddingRight()), paddingTop + (measuredHeight - this.getPaddingTop() - this.getPaddingBottom()));
                final int measuredWidth2 = mCircleView.getMeasuredWidth();
                mCircleView.layout(measuredWidth / 2 - measuredWidth2 / 2, mCurrentTargetOffsetTop, measuredWidth / 2 + measuredWidth2 / 2, mCircleView.getMeasuredHeight() + mCurrentTargetOffsetTop);
            }
        }
    }
    
    public void onMeasure(final int n, final int n2) {
        super.onMeasure(n, n2);
        if (mTarget == null) {
            this.ensureTarget();
        }
        if (mTarget != null) {
            mTarget.measure(View$MeasureSpec.makeMeasureSpec(this.getMeasuredWidth() - this.getPaddingLeft() - this.getPaddingRight(), 1073741824), View$MeasureSpec.makeMeasureSpec(this.getMeasuredHeight() - this.getPaddingTop() - this.getPaddingBottom(), 1073741824));
            mCircleView.measure(View$MeasureSpec.makeMeasureSpec(mCircleWidth, 1073741824), View$MeasureSpec.makeMeasureSpec(mCircleHeight, 1073741824));
            if (!mUsingCustomStart && !mOriginalOffsetCalculated) {
                mOriginalOffsetCalculated = true;
                final int n3 = -mCircleView.getMeasuredHeight();
                mOriginalOffsetTop = n3;
                mCurrentTargetOffsetTop = n3;
            }
            mCircleViewIndex = -1;
            for (int i = 0; i < this.getChildCount(); ++i) {
                if (this.getChildAt(i) == mCircleView) {
                    mCircleViewIndex = i;
                    return;
                }
            }
        }
    }
    
    public boolean onNestedFling(final View view, final float n, final float n2, final boolean b) {
        return this.dispatchNestedFling(n, n2, b);
    }
    
    public boolean onNestedPreFling(final View view, final float n, final float n2) {
        return this.dispatchNestedPreFling(n, n2);
    }
    
    public void onNestedPreScroll(final View view, final int n, final int n2, final int[] array) {
        if (n2 > 0 && mTotalUnconsumed > 0.0f) {
            if (n2 > mTotalUnconsumed) {
                array[1] = n2 - (int)mTotalUnconsumed;
                mTotalUnconsumed = 0.0f;
            }
            else {
                mTotalUnconsumed -= n2;
                array[1] = n2;
            }
            this.moveSpinner(mTotalUnconsumed);
        }
        if (mUsingCustomStart && n2 > 0 && mTotalUnconsumed == 0.0f && Math.abs(n2 - array[1]) > 0) {
            mCircleView.setVisibility(8);
        }
        final int[] mParentScrollConsumed = this.mParentScrollConsumed;
        if (this.dispatchNestedPreScroll(n - array[0], n2 - array[1], mParentScrollConsumed, null)) {
            array[0] += mParentScrollConsumed[0];
            array[1] += mParentScrollConsumed[1];
        }
    }
    
    public void onNestedScroll(final View view, final int n, final int n2, final int n3, final int n4) {
        this.dispatchNestedScroll(n, n2, n3, n4, mParentOffsetInWindow);
        final int n5 = n4 + mParentOffsetInWindow[1];
        if (n5 < 0) {
            this.moveSpinner(mTotalUnconsumed += (float)Math.abs(n5));
        }
    }
    
    public void onNestedScrollAccepted(final View view, final View view2, final int n) {
        mNestedScrollingParentHelper.onNestedScrollAccepted(view, view2, n);
        this.startNestedScroll(n & 0x2);
        mTotalUnconsumed = 0.0f;
        mNestedScrollInProgress = true;
    }
    
    public boolean onStartNestedScroll(final View view, final View view2, final int n) {
        return this.isEnabled() && this.canChildScrollUp() && !mReturningToStart && !mRefreshing && (n & 0x2) != 0x0;
    }
    
    public void onStopNestedScroll(final View view) {
        mNestedScrollingParentHelper.onStopNestedScroll(view);
        mNestedScrollInProgress = false;
        if (mTotalUnconsumed > 0.0f) {
            this.finishSpinner(mTotalUnconsumed);
            mTotalUnconsumed = 0.0f;
        }
        this.stopNestedScroll();
    }
    
    public boolean onTouchEvent(final MotionEvent motionEvent) {
        final int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (mReturningToStart && actionMasked == 0) {
            mReturningToStart = false;
        }
        if (this.isEnabled() && !mReturningToStart && !this.canChildScrollUp() && !mNestedScrollInProgress) {
            switch (actionMasked) {
                case 3:
                    return false;
                case 0:
                    mActivePointerId = MotionEventCompat.getPointerId(motionEvent, 0);
                    mIsBeingDragged = false;
                    break;
                case 2: {
                    final int pointerIndex = MotionEventCompat.findPointerIndex(motionEvent, mActivePointerId);
                    if (pointerIndex < 0) {
                        Log.e(LOG_TAG, "Got ACTION_MOVE event but have an invalid active pointer id.");
                        return false;
                    }
                    final float n = 0.5f * (MotionEventCompat.getY(motionEvent, pointerIndex) - mInitialMotionY);
                    if (!mIsBeingDragged) {
                        break;
                    }
                    if (n > 0.0f) {
                        this.moveSpinner(n);
                        break;
                    }
                    return false;
                }
                case 5: {
                    final int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                    if (actionIndex < 0) {
                        Log.e(LOG_TAG, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
                        return false;
                    }
                    mActivePointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                    break;
                }
                case 6:
                    this.onSecondaryPointerUp(motionEvent);
                    break;
                case 1: {
                    final int pointerIndex2 = MotionEventCompat.findPointerIndex(motionEvent, mActivePointerId);
                    if (pointerIndex2 < 0) {
                        Log.e(LOG_TAG, "Got ACTION_UP event but don't have an active pointer id.");
                        return false;
                    }
                    final float n2 = 0.5f * (MotionEventCompat.getY(motionEvent, pointerIndex2) - mInitialMotionY);
                    mIsBeingDragged = false;
                    this.finishSpinner(n2);
                    mActivePointerId = -1;
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    
    public void requestDisallowInterceptTouchEvent(final boolean b) {
        if ((Build$VERSION.SDK_INT < 21 && mTarget instanceof AbsListView) || (mTarget != null && !ViewCompat.isNestedScrollingEnabled(mTarget))) {
            return;
        }
        super.requestDisallowInterceptTouchEvent(b);
    }
    
    @Deprecated
    public void setColorScheme(@ColorInt final int... colorSchemeResources) {
        this.setColorSchemeResources(colorSchemeResources);
    }
    
    @ColorInt
    public void setColorSchemeColors(final int... colorSchemeColors) {
        this.ensureTarget();
        mProgress.setColorSchemeColors(colorSchemeColors);
    }
    
    public void setColorSchemeResources(@ColorRes final int... array) {
        final Resources resources = this.getResources();
        final int[] colorSchemeColors = new int[array.length];
        for (int i = 0; i < array.length; ++i) {
            colorSchemeColors[i] = resources.getColor(array[i]);
        }
        this.setColorSchemeColors(colorSchemeColors);
    }
    
    public void setDistanceToTriggerSync(final int n) {
        mTotalDragDistance = n;
    }
    
    public void setNestedScrollingEnabled(final boolean nestedScrollingEnabled) {
        mNestedScrollingChildHelper.setNestedScrollingEnabled(nestedScrollingEnabled);
    }
    
    public void setOnRefreshListener(final OnRefreshListener mListener) {
        this.mListener = mListener;
    }
    
    @Deprecated
    public void setProgressBackgroundColor(final int progressBackgroundColorSchemeResource) {
        this.setProgressBackgroundColorSchemeResource(progressBackgroundColorSchemeResource);
    }
    
    public void setProgressBackgroundColorSchemeColor(@ColorInt final int n) {
        mCircleView.setBackgroundColor(n);
        mProgress.setBackgroundColor(n);
    }
    
    public void setProgressBackgroundColorSchemeResource(@ColorRes final int n) {
        this.setProgressBackgroundColorSchemeColor(this.getResources().getColor(n));
    }
    
    public void setProgressViewEndTarget(final boolean mScale, final int n) {
        mSpinnerFinalOffset = n;
        this.mScale = mScale;
        mCircleView.invalidate();
    }
    
    public void setProgressViewOffset(final boolean mScale, final int n, final int n2) {
        this.mScale = mScale;
        mCircleView.setVisibility(8);
        mCurrentTargetOffsetTop = n;
        mOriginalOffsetTop = n;
        mSpinnerFinalOffset = n2;
        mUsingCustomStart = true;
        mCircleView.invalidate();
    }
    
    public void setRefreshing(final boolean mRefreshing) {
        if (mRefreshing && this.mRefreshing != mRefreshing) {
            this.mRefreshing = mRefreshing;
            int n;
            if (!mUsingCustomStart) {
                n = (int)(mSpinnerFinalOffset + mOriginalOffsetTop);
            }
            else {
                n = (int)mSpinnerFinalOffset;
            }
            this.setTargetOffsetTopAndBottom(n - mCurrentTargetOffsetTop, true);
            mNotify = false;
            this.startScaleUpAnimation(mRefreshListener);
            return;
        }
        this.setRefreshing(mRefreshing, false);
    }
    
    public void setSize(final int n) {
        if (n != 0 && n != 1) {
            return;
        }
        final DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        if (n == 0) {
            final int n2 = (int)(56.0f * displayMetrics.density);
            mCircleWidth = n2;
            mCircleHeight = n2;
        }
        else {
            final int n3 = (int)(40.0f * displayMetrics.density);
            mCircleWidth = n3;
            mCircleHeight = n3;
        }
        mCircleView.setImageDrawable((Drawable)null);
        mProgress.updateSizes(n);
        mCircleView.setImageDrawable((Drawable)mProgress);
    }
    
    public boolean startNestedScroll(final int n) {
        return mNestedScrollingChildHelper.startNestedScroll(n);
    }
    
    public void stopNestedScroll() {
        mNestedScrollingChildHelper.stopNestedScroll();
    }
}
