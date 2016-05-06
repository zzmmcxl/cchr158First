package android.support.design.widget;

import android.support.v4.view.MotionEventCompat;
import android.view.MotionEvent;
import android.support.annotation.NonNull;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.view.View;

public class SwipeDismissBehavior<V extends View> extends Behavior<V>
{
    private static final float DEFAULT_ALPHA_END_DISTANCE = 0.5f;
    private static final float DEFAULT_ALPHA_START_DISTANCE = 0.0f;
    private static final float DEFAULT_DRAG_DISMISS_THRESHOLD = 0.5f;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    public static final int SWIPE_DIRECTION_ANY = 2;
    public static final int SWIPE_DIRECTION_END_TO_START = 1;
    public static final int SWIPE_DIRECTION_START_TO_END;
    private float mAlphaEndSwipeDistance;
    private float mAlphaStartSwipeDistance;
    private final ViewDragHelper.Callback mDragCallback;
    private float mDragDismissThreshold;
    private boolean mIgnoreEvents;
    private OnDismissListener mListener;
    private float mSensitivity;
    private boolean mSensitivitySet;
    private int mSwipeDirection;
    private ViewDragHelper mViewDragHelper;
    
    public SwipeDismissBehavior() {
        super();
        mSensitivity = 0.0f;
        mSwipeDirection = 2;
        mDragDismissThreshold = 0.5f;
        mAlphaStartSwipeDistance = 0.0f;
        mAlphaEndSwipeDistance = 0.5f;
        mDragCallback = new ViewDragHelper.Callback() {
            private int mOriginalCapturedViewLeft;
            final /* synthetic */ SwipeDismissBehavior this$0;
            
            SwipeDismissBehavior$1() {
                this$0 = this$0;
                super();
            }
            
            private boolean shouldDismiss(final View view, final float n) {
                if (n != 0.0f) {
                    final boolean b = ViewCompat.getLayoutDirection(view) == 1;
                    if (mSwipeDirection != 2) {
                        if (mSwipeDirection == 0) {
                            if (b) {
                                if (n >= 0.0f) {
                                    return false;
                                }
                            }
                            else if (n <= 0.0f) {
                                return false;
                            }
                        }
                        else {
                            if (mSwipeDirection != 1) {
                                return false;
                            }
                            if (b) {
                                if (n <= 0.0f) {
                                    return false;
                                }
                            }
                            else if (n >= 0.0f) {
                                return false;
                            }
                        }
                    }
                }
                else if (Math.abs(view.getLeft() - mOriginalCapturedViewLeft) < Math.round((float)view.getWidth() * mDragDismissThreshold)) {
                    return false;
                }
                return true;
            }
            
            @Override
            public int clampViewPositionHorizontal(final View view, final int n, final int n2) {
                boolean b;
                if (ViewCompat.getLayoutDirection(view) == 1) {
                    b = true;
                }
                else {
                    b = false;
                }
                int n3;
                int n4;
                if (mSwipeDirection == 0) {
                    if (b) {
                        n3 = mOriginalCapturedViewLeft - view.getWidth();
                        n4 = mOriginalCapturedViewLeft;
                    }
                    else {
                        n3 = mOriginalCapturedViewLeft;
                        n4 = mOriginalCapturedViewLeft + view.getWidth();
                    }
                }
                else if (mSwipeDirection == 1) {
                    if (b) {
                        n3 = mOriginalCapturedViewLeft;
                        n4 = mOriginalCapturedViewLeft + view.getWidth();
                    }
                    else {
                        n3 = mOriginalCapturedViewLeft - view.getWidth();
                        n4 = mOriginalCapturedViewLeft;
                    }
                }
                else {
                    n3 = mOriginalCapturedViewLeft - view.getWidth();
                    n4 = mOriginalCapturedViewLeft + view.getWidth();
                }
                return clamp(n3, n, n4);
            }
            
            @Override
            public int clampViewPositionVertical(final View view, final int n, final int n2) {
                return view.getTop();
            }
            
            @Override
            public int getViewHorizontalDragRange(final View view) {
                return view.getWidth();
            }
            
            @Override
            public void onViewCaptured(final View view, final int n) {
                mOriginalCapturedViewLeft = view.getLeft();
                final ViewParent parent = view.getParent();
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
            }
            
            @Override
            public void onViewDragStateChanged(final int n) {
                if (mListener != null) {
                    mListener.onDragStateChanged(n);
                }
            }
            
            @Override
            public void onViewPositionChanged(final View view, final int n, final int n2, final int n3, final int n4) {
                final float n5 = mOriginalCapturedViewLeft + view.getWidth() * mAlphaStartSwipeDistance;
                final float n6 = mOriginalCapturedViewLeft + view.getWidth() * mAlphaEndSwipeDistance;
                if (n <= n5) {
                    ViewCompat.setAlpha(view, 1.0f);
                    return;
                }
                if (n >= n6) {
                    ViewCompat.setAlpha(view, 0.0f);
                    return;
                }
                ViewCompat.setAlpha(view, clamp(0.0f, 1.0f - SwipeDismissBehavior.fraction(n5, n6, n), 1.0f));
            }
            
            @Override
            public void onViewReleased(final View view, final float n, final float n2) {
                final ViewParent parent = view.getParent();
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(false);
                }
                final int width = view.getWidth();
                int mOriginalCapturedViewLeft;
                boolean b;
                if (this.shouldDismiss(view, n)) {
                    if (view.getLeft() < this.mOriginalCapturedViewLeft) {
                        mOriginalCapturedViewLeft = this.mOriginalCapturedViewLeft - width;
                    }
                    else {
                        mOriginalCapturedViewLeft = width + this.mOriginalCapturedViewLeft;
                    }
                    b = true;
                }
                else {
                    mOriginalCapturedViewLeft = this.mOriginalCapturedViewLeft;
                    b = false;
                }
                if (mViewDragHelper.settleCapturedViewAt(mOriginalCapturedViewLeft, view.getTop())) {
                    ViewCompat.postOnAnimation(view, this$0.new SettleRunnable(view, b));
                }
                else if (b && mListener != null) {
                    mListener.onDismiss(view);
                }
            }
            
            @Override
            public boolean tryCaptureView(final View view, final int n) {
                return this$0.canSwipeDismissView(view);
            }
        };
    }
    
    static /* synthetic */ OnDismissListener access$000(final SwipeDismissBehavior swipeDismissBehavior) {
        return swipeDismissBehavior.mListener;
    }
    
    static /* synthetic */ ViewDragHelper access$100(final SwipeDismissBehavior swipeDismissBehavior) {
        return swipeDismissBehavior.mViewDragHelper;
    }
    
    static /* synthetic */ int access$200(final SwipeDismissBehavior swipeDismissBehavior) {
        return swipeDismissBehavior.mSwipeDirection;
    }
    
    static /* synthetic */ float access$300(final SwipeDismissBehavior swipeDismissBehavior) {
        return swipeDismissBehavior.mDragDismissThreshold;
    }
    
    static /* synthetic */ int access$400(final int n, final int n2, final int n3) {
        return clamp(n, n2, n3);
    }
    
    static /* synthetic */ float access$500(final SwipeDismissBehavior swipeDismissBehavior) {
        return swipeDismissBehavior.mAlphaStartSwipeDistance;
    }
    
    static /* synthetic */ float access$600(final SwipeDismissBehavior swipeDismissBehavior) {
        return swipeDismissBehavior.mAlphaEndSwipeDistance;
    }
    
    static /* synthetic */ float access$700(final float n, final float n2, final float n3) {
        return clamp(n, n2, n3);
    }
    
    private static float clamp(final float n, final float n2, final float n3) {
        return Math.min(Math.max(n, n2), n3);
    }
    
    private static int clamp(final int n, final int n2, final int n3) {
        return Math.min(Math.max(n, n2), n3);
    }
    
    private void ensureViewDragHelper(final ViewGroup viewGroup) {
        if (mViewDragHelper == null) {
            ViewDragHelper mViewDragHelper;
            if (mSensitivitySet) {
                mViewDragHelper = ViewDragHelper.create(viewGroup, mSensitivity, mDragCallback);
            }
            else {
                mViewDragHelper = ViewDragHelper.create(viewGroup, mDragCallback);
            }
            this.mViewDragHelper = mViewDragHelper;
        }
    }
    
    static float fraction(final float n, final float n2, final float n3) {
        return (n3 - n) / (n2 - n);
    }
    
    public boolean canSwipeDismissView(@NonNull final View view) {
        return true;
    }
    
    public int getDragState() {
        if (mViewDragHelper != null) {
            return mViewDragHelper.getViewDragState();
        }
        return 0;
    }
    
    @Override
    public boolean onInterceptTouchEvent(final CoordinatorLayout coordinatorLayout, final V v, final MotionEvent motionEvent) {
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            default:
                mIgnoreEvents = !coordinatorLayout.isPointInChildBounds(v, (int)motionEvent.getX(), (int)motionEvent.getY());
                break;
            case 1:
            case 3:
                if (mIgnoreEvents) {
                    return mIgnoreEvents = false;
                }
                break;
        }
        if (mIgnoreEvents) {
            return false;
        }
        this.ensureViewDragHelper(coordinatorLayout);
        return mViewDragHelper.shouldInterceptTouchEvent(motionEvent);
    }
    
    @Override
    public boolean onTouchEvent(final CoordinatorLayout coordinatorLayout, final V v, final MotionEvent motionEvent) {
        if (mViewDragHelper != null) {
            mViewDragHelper.processTouchEvent(motionEvent);
            return true;
        }
        return false;
    }
    
    public void setDragDismissDistance(final float n) {
        mDragDismissThreshold = clamp(0.0f, n, 1.0f);
    }
    
    public void setEndAlphaSwipeDistance(final float n) {
        mAlphaEndSwipeDistance = clamp(0.0f, n, 1.0f);
    }
    
    public void setListener(final OnDismissListener mListener) {
        this.mListener = mListener;
    }
    
    public void setSensitivity(final float mSensitivity) {
        this.mSensitivity = mSensitivity;
        mSensitivitySet = true;
    }
    
    public void setStartAlphaSwipeDistance(final float n) {
        mAlphaStartSwipeDistance = clamp(0.0f, n, 1.0f);
    }
    
    public void setSwipeDirection(final int mSwipeDirection) {
        this.mSwipeDirection = mSwipeDirection;
    }
}
