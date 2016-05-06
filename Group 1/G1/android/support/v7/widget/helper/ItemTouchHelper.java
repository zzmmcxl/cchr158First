package android.support.v7.widget.helper;

import android.support.v4.animation.AnimatorUpdateListenerCompat;
import android.support.v4.animation.AnimatorCompatHelper;
import android.support.v4.animation.AnimatorListenerCompat;
import android.view.GestureDetector$SimpleOnGestureListener;
import android.view.animation.Interpolator;
import android.util.Log;
import android.graphics.Canvas;
import android.content.res.Resources;
import android.support.v7.recyclerview.R;
import android.support.annotation.Nullable;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.support.v4.animation.ValueAnimatorCompat;
import android.view.GestureDetector$OnGestureListener;
import android.support.v4.view.VelocityTrackerCompat;
import android.os.Build$VERSION;
import android.support.v4.view.MotionEventCompat;
import android.view.MotionEvent;
import android.support.v4.view.ViewCompat;
import java.util.ArrayList;
import android.view.VelocityTracker;
import android.graphics.Rect;
import android.view.View;
import android.support.v4.view.GestureDetectorCompat;
import java.util.List;
import android.support.v7.widget.RecyclerView;

public class ItemTouchHelper extends ItemDecoration implements OnChildAttachStateChangeListener
{
    private static final int ACTION_MODE_DRAG_MASK = 16711680;
    private static final int ACTION_MODE_IDLE_MASK = 255;
    private static final int ACTION_MODE_SWIPE_MASK = 65280;
    public static final int ACTION_STATE_DRAG = 2;
    public static final int ACTION_STATE_IDLE = 0;
    public static final int ACTION_STATE_SWIPE = 1;
    private static final int ACTIVE_POINTER_ID_NONE = -1;
    public static final int ANIMATION_TYPE_DRAG = 8;
    public static final int ANIMATION_TYPE_SWIPE_CANCEL = 4;
    public static final int ANIMATION_TYPE_SWIPE_SUCCESS = 2;
    private static final boolean DEBUG = false;
    private static final int DIRECTION_FLAG_COUNT = 8;
    public static final int DOWN = 2;
    public static final int END = 32;
    public static final int LEFT = 4;
    private static final int PIXELS_PER_SECOND = 1000;
    public static final int RIGHT = 8;
    public static final int START = 16;
    private static final String TAG = "ItemTouchHelper";
    public static final int UP = 1;
    int mActionState;
    int mActivePointerId;
    Callback mCallback;
    private ChildDrawingOrderCallback mChildDrawingOrderCallback;
    private List<Integer> mDistances;
    private long mDragScrollStartTimeInMs;
    float mDx;
    float mDy;
    private GestureDetectorCompat mGestureDetector;
    float mInitialTouchX;
    float mInitialTouchY;
    float mMaxSwipeVelocity;
    private final OnItemTouchListener mOnItemTouchListener;
    private View mOverdrawChild;
    private int mOverdrawChildPosition;
    final List<View> mPendingCleanup;
    List<RecoverAnimation> mRecoverAnimations;
    private RecyclerView mRecyclerView;
    private final Runnable mScrollRunnable;
    ViewHolder mSelected;
    int mSelectedFlags;
    float mSelectedStartX;
    float mSelectedStartY;
    private int mSlop;
    private List<ViewHolder> mSwapTargets;
    float mSwipeEscapeVelocity;
    private final float[] mTmpPosition;
    private Rect mTmpRect;
    private VelocityTracker mVelocityTracker;
    
    public ItemTouchHelper(final Callback mCallback) {
        super();
        mPendingCleanup = new ArrayList<View>();
        mTmpPosition = new float[2];
        mSelected = null;
        mActivePointerId = -1;
        mActionState = 0;
        mRecoverAnimations = new ArrayList<RecoverAnimation>();
        mScrollRunnable = new Runnable() {
            final /* synthetic */ ItemTouchHelper this$0;
            
            ItemTouchHelper$1() {
                this$0 = this$0;
                super();
            }
            
            @Override
            public void run() {
                if (mSelected != null && this$0.scrollIfNecessary()) {
                    if (mSelected != null) {
                        this$0.moveIfNecessary(mSelected);
                    }
                    mRecyclerView.removeCallbacks(mScrollRunnable);
                    ViewCompat.postOnAnimation(mRecyclerView, (Runnable)this);
                }
            }
        };
        mChildDrawingOrderCallback = null;
        mOverdrawChild = null;
        mOverdrawChildPosition = -1;
        mOnItemTouchListener = new OnItemTouchListener() {
            final /* synthetic */ ItemTouchHelper this$0;
            
            ItemTouchHelper$2() {
                this$0 = this$0;
                super();
            }
            
            @Override
            public boolean onInterceptTouchEvent(final RecyclerView recyclerView, final MotionEvent motionEvent) {
                mGestureDetector.onTouchEvent(motionEvent);
                final int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
                if (actionMasked == 0) {
                    mActivePointerId = MotionEventCompat.getPointerId(motionEvent, 0);
                    this$0.mInitialTouchX = motionEvent.getX();
                    this$0.mInitialTouchY = motionEvent.getY();
                    this$0.obtainVelocityTracker();
                    if (mSelected == null) {
                        final RecoverAnimation access$600 = this$0.findAnimation(motionEvent);
                        if (access$600 != null) {
                            final ItemTouchHelper this$0 = this.this$0;
                            this$0.mInitialTouchX -= access$600.mX;
                            final ItemTouchHelper this$2 = this.this$0;
                            this$2.mInitialTouchY -= access$600.mY;
                            this.this$0.endRecoverAnimation(access$600.mViewHolder, true);
                            if (mPendingCleanup.remove(access$600.mViewHolder.itemView)) {
                                mCallback.clearView(mRecyclerView, access$600.mViewHolder);
                            }
                            this.this$0.select(access$600.mViewHolder, access$600.mActionState);
                            this.this$0.updateDxDy(motionEvent, mSelectedFlags, 0);
                        }
                    }
                }
                else if (actionMasked == 3 || actionMasked == 1) {
                    mActivePointerId = -1;
                    this$0.select(null, 0);
                }
                else if (mActivePointerId != -1) {
                    final int pointerIndex = MotionEventCompat.findPointerIndex(motionEvent, mActivePointerId);
                    if (pointerIndex >= 0) {
                        this$0.checkSelectForSwipe(actionMasked, motionEvent, pointerIndex);
                    }
                }
                if (this$0.mVelocityTracker != null) {
                    this$0.mVelocityTracker.addMovement(motionEvent);
                }
                return mSelected != null;
            }
            
            @Override
            public void onRequestDisallowInterceptTouchEvent(final boolean b) {
                if (!b) {
                    return;
                }
                this$0.select(null, 0);
            }
            
            @Override
            public void onTouchEvent(final RecyclerView recyclerView, final MotionEvent motionEvent) {
                mGestureDetector.onTouchEvent(motionEvent);
                if (this$0.mVelocityTracker != null) {
                    this$0.mVelocityTracker.addMovement(motionEvent);
                }
                if (mActivePointerId != -1) {
                    final int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
                    final int pointerIndex = MotionEventCompat.findPointerIndex(motionEvent, mActivePointerId);
                    if (pointerIndex >= 0) {
                        this$0.checkSelectForSwipe(actionMasked, motionEvent, pointerIndex);
                    }
                    final ViewHolder mSelected = this$0.mSelected;
                    if (mSelected != null) {
                        switch (actionMasked) {
                            default:
                            case 3:
                                if (this$0.mVelocityTracker != null) {
                                    this$0.mVelocityTracker.clear();
                                }
                            case 1:
                                this$0.select(null, 0);
                                mActivePointerId = -1;
                            case 2:
                                if (pointerIndex >= 0) {
                                    this$0.updateDxDy(motionEvent, mSelectedFlags, pointerIndex);
                                    this$0.moveIfNecessary(mSelected);
                                    mRecyclerView.removeCallbacks(mScrollRunnable);
                                    mScrollRunnable.run();
                                    mRecyclerView.invalidate();
                                    return;
                                }
                                break;
                            case 6: {
                                final int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                                if (MotionEventCompat.getPointerId(motionEvent, actionIndex) == mActivePointerId) {
                                    int n = 0;
                                    if (actionIndex == 0) {
                                        n = 1;
                                    }
                                    mActivePointerId = MotionEventCompat.getPointerId(motionEvent, n);
                                    this$0.updateDxDy(motionEvent, mSelectedFlags, actionIndex);
                                    return;
                                }
                                break;
                            }
                        }
                    }
                }
            }
        };
        mCallback = mCallback;
    }
    
    static /* synthetic */ boolean access$000(final ItemTouchHelper itemTouchHelper) {
        return itemTouchHelper.scrollIfNecessary();
    }
    
    static /* synthetic */ void access$100(final ItemTouchHelper itemTouchHelper, final ViewHolder viewHolder) {
        itemTouchHelper.moveIfNecessary(viewHolder);
    }
    
    static /* synthetic */ boolean access$1000(final ItemTouchHelper itemTouchHelper, final int n, final MotionEvent motionEvent, final int n2) {
        return itemTouchHelper.checkSelectForSwipe(n, motionEvent, n2);
    }
    
    static /* synthetic */ VelocityTracker access$1100(final ItemTouchHelper itemTouchHelper) {
        return itemTouchHelper.mVelocityTracker;
    }
    
    static /* synthetic */ void access$1500(final ItemTouchHelper itemTouchHelper, final RecoverAnimation recoverAnimation, final int n) {
        itemTouchHelper.postDispatchSwipe(recoverAnimation, n);
    }
    
    static /* synthetic */ View access$1600(final ItemTouchHelper itemTouchHelper) {
        return itemTouchHelper.mOverdrawChild;
    }
    
    static /* synthetic */ void access$1700(final ItemTouchHelper itemTouchHelper, final View view) {
        itemTouchHelper.removeChildDrawingOrderCallbackIfNecessary(view);
    }
    
    static /* synthetic */ boolean access$1800(final ItemTouchHelper itemTouchHelper) {
        return itemTouchHelper.hasRunningRecoverAnim();
    }
    
    static /* synthetic */ Runnable access$200(final ItemTouchHelper itemTouchHelper) {
        return itemTouchHelper.mScrollRunnable;
    }
    
    static /* synthetic */ int access$2300(final ItemTouchHelper itemTouchHelper) {
        return itemTouchHelper.mOverdrawChildPosition;
    }
    
    static /* synthetic */ int access$2302(final ItemTouchHelper itemTouchHelper, final int mOverdrawChildPosition) {
        return itemTouchHelper.mOverdrawChildPosition = mOverdrawChildPosition;
    }
    
    static /* synthetic */ View access$2400(final ItemTouchHelper itemTouchHelper, final MotionEvent motionEvent) {
        return itemTouchHelper.findChildView(motionEvent);
    }
    
    static /* synthetic */ RecyclerView access$300(final ItemTouchHelper itemTouchHelper) {
        return itemTouchHelper.mRecyclerView;
    }
    
    static /* synthetic */ GestureDetectorCompat access$400(final ItemTouchHelper itemTouchHelper) {
        return itemTouchHelper.mGestureDetector;
    }
    
    static /* synthetic */ void access$500(final ItemTouchHelper itemTouchHelper) {
        itemTouchHelper.obtainVelocityTracker();
    }
    
    static /* synthetic */ RecoverAnimation access$600(final ItemTouchHelper itemTouchHelper, final MotionEvent motionEvent) {
        return itemTouchHelper.findAnimation(motionEvent);
    }
    
    static /* synthetic */ int access$700(final ItemTouchHelper itemTouchHelper, final ViewHolder viewHolder, final boolean b) {
        return itemTouchHelper.endRecoverAnimation(viewHolder, b);
    }
    
    static /* synthetic */ void access$800(final ItemTouchHelper itemTouchHelper, final ViewHolder viewHolder, final int n) {
        itemTouchHelper.select(viewHolder, n);
    }
    
    static /* synthetic */ void access$900(final ItemTouchHelper itemTouchHelper, final MotionEvent motionEvent, final int n, final int n2) {
        itemTouchHelper.updateDxDy(motionEvent, n, n2);
    }
    
    private void addChildDrawingOrderCallback() {
        if (Build$VERSION.SDK_INT >= 21) {
            return;
        }
        if (mChildDrawingOrderCallback == null) {
            mChildDrawingOrderCallback = new ChildDrawingOrderCallback() {
                final /* synthetic */ ItemTouchHelper this$0;
                
                ItemTouchHelper$5() {
                    this$0 = this$0;
                    super();
                }
                
                @Override
                public int onGetChildDrawingOrder(final int n, final int n2) {
                    if (mOverdrawChild != null) {
                        int n3 = mOverdrawChildPosition;
                        if (n3 == -1) {
                            n3 = mRecyclerView.indexOfChild(mOverdrawChild);
                            mOverdrawChildPosition = n3;
                        }
                        if (n2 == n - 1) {
                            return n3;
                        }
                        if (n2 >= n3) {
                            return n2 + 1;
                        }
                    }
                    return n2;
                }
            };
        }
        mRecyclerView.setChildDrawingOrderCallback(mChildDrawingOrderCallback);
    }
    
    private int checkHorizontalSwipe(final ViewHolder viewHolder, final int n) {
        if ((n & 0xC) != 0x0) {
            int n2;
            if (mDx > 0.0f) {
                n2 = 8;
            }
            else {
                n2 = 4;
            }
            if (mVelocityTracker != null && mActivePointerId > -1) {
                mVelocityTracker.computeCurrentVelocity(1000, mCallback.getSwipeVelocityThreshold(mMaxSwipeVelocity));
                final float xVelocity = VelocityTrackerCompat.getXVelocity(mVelocityTracker, mActivePointerId);
                final float yVelocity = VelocityTrackerCompat.getYVelocity(mVelocityTracker, mActivePointerId);
                int n3;
                if (xVelocity > 0.0f) {
                    n3 = 8;
                }
                else {
                    n3 = 4;
                }
                final float abs = Math.abs(xVelocity);
                if ((n3 & n) != 0x0 && n2 == n3 && abs >= mCallback.getSwipeEscapeVelocity(mSwipeEscapeVelocity) && abs > Math.abs(yVelocity)) {
                    return n3;
                }
            }
            final float n4 = mRecyclerView.getWidth() * mCallback.getSwipeThreshold(viewHolder);
            if ((n & n2) != 0x0 && Math.abs(mDx) > n4) {
                return n2;
            }
        }
        return 0;
    }
    
    private boolean checkSelectForSwipe(final int n, final MotionEvent motionEvent, final int n2) {
        if (mSelected != null || n != 2 || mActionState == 2 || !mCallback.isItemViewSwipeEnabled()) {
            return false;
        }
        if (mRecyclerView.getScrollState() == 1) {
            return false;
        }
        final ViewHolder swipedView = this.findSwipedView(motionEvent);
        if (swipedView == null) {
            return false;
        }
        final int n3 = (0xFF00 & mCallback.getAbsoluteMovementFlags(mRecyclerView, swipedView)) >> 8;
        if (n3 == 0) {
            return false;
        }
        final float x = MotionEventCompat.getX(motionEvent, n2);
        final float y = MotionEventCompat.getY(motionEvent, n2);
        final float n4 = x - mInitialTouchX;
        final float n5 = y - mInitialTouchY;
        final float abs = Math.abs(n4);
        final float abs2 = Math.abs(n5);
        if (abs < mSlop && abs2 < mSlop) {
            return false;
        }
        if (abs > abs2) {
            if (n4 < 0.0f && (n3 & 0x4) == 0x0) {
                return false;
            }
            if (n4 > 0.0f && (n3 & 0x8) == 0x0) {
                return false;
            }
        }
        else {
            if (n5 < 0.0f && (n3 & 0x1) == 0x0) {
                return false;
            }
            if (n5 > 0.0f && (n3 & 0x2) == 0x0) {
                return false;
            }
        }
        mDy = 0.0f;
        mDx = 0.0f;
        mActivePointerId = MotionEventCompat.getPointerId(motionEvent, 0);
        this.select(swipedView, 1);
        return true;
    }
    
    private int checkVerticalSwipe(final ViewHolder viewHolder, final int n) {
        if ((n & 0x3) != 0x0) {
            int n2;
            if (mDy > 0.0f) {
                n2 = 2;
            }
            else {
                n2 = 1;
            }
            if (mVelocityTracker != null && mActivePointerId > -1) {
                mVelocityTracker.computeCurrentVelocity(1000, mCallback.getSwipeVelocityThreshold(mMaxSwipeVelocity));
                final float xVelocity = VelocityTrackerCompat.getXVelocity(mVelocityTracker, mActivePointerId);
                final float yVelocity = VelocityTrackerCompat.getYVelocity(mVelocityTracker, mActivePointerId);
                int n3;
                if (yVelocity > 0.0f) {
                    n3 = 2;
                }
                else {
                    n3 = 1;
                }
                final float abs = Math.abs(yVelocity);
                if ((n3 & n) != 0x0 && n3 == n2 && abs >= mCallback.getSwipeEscapeVelocity(mSwipeEscapeVelocity) && abs > Math.abs(xVelocity)) {
                    return n3;
                }
            }
            final float n4 = mRecyclerView.getHeight() * mCallback.getSwipeThreshold(viewHolder);
            if ((n & n2) != 0x0 && Math.abs(mDy) > n4) {
                return n2;
            }
        }
        return 0;
    }
    
    private void destroyCallbacks() {
        mRecyclerView.removeItemDecoration((RecyclerView.ItemDecoration)this);
        mRecyclerView.removeOnItemTouchListener(mOnItemTouchListener);
        mRecyclerView.removeOnChildAttachStateChangeListener((RecyclerView.OnChildAttachStateChangeListener)this);
        for (int i = -1 + mRecoverAnimations.size(); i >= 0; --i) {
            mCallback.clearView(mRecyclerView, ((RecoverAnimation)mRecoverAnimations.get(0)).mViewHolder);
        }
        mRecoverAnimations.clear();
        mOverdrawChild = null;
        mOverdrawChildPosition = -1;
        this.releaseVelocityTracker();
    }
    
    private int endRecoverAnimation(final ViewHolder viewHolder, final boolean b) {
        for (int i = -1 + mRecoverAnimations.size(); i >= 0; --i) {
            final RecoverAnimation recoverAnimation = (RecoverAnimation)mRecoverAnimations.get(i);
            if (recoverAnimation.mViewHolder == viewHolder) {
                recoverAnimation.mOverridden |= b;
                if (!recoverAnimation.mEnded) {
                    recoverAnimation.cancel();
                }
                mRecoverAnimations.remove(i);
                return recoverAnimation.mAnimationType;
            }
        }
        return 0;
    }
    
    private RecoverAnimation findAnimation(final MotionEvent motionEvent) {
        if (!mRecoverAnimations.isEmpty()) {
            final View childView = this.findChildView(motionEvent);
            for (int i = -1 + mRecoverAnimations.size(); i >= 0; --i) {
                final RecoverAnimation recoverAnimation = (RecoverAnimation)mRecoverAnimations.get(i);
                if (recoverAnimation.mViewHolder.itemView == childView) {
                    return recoverAnimation;
                }
            }
            return null;
        }
        return null;
    }
    
    private View findChildView(final MotionEvent motionEvent) {
        final float x = motionEvent.getX();
        final float y = motionEvent.getY();
        if (mSelected != null) {
            final View itemView = mSelected.itemView;
            if (hitTest(itemView, x, y, mSelectedStartX + mDx, mSelectedStartY + mDy)) {
                return itemView;
            }
        }
        for (int i = -1 + mRecoverAnimations.size(); i >= 0; --i) {
            final RecoverAnimation recoverAnimation = (RecoverAnimation)mRecoverAnimations.get(i);
            final View itemView2 = recoverAnimation.mViewHolder.itemView;
            if (hitTest(itemView2, x, y, recoverAnimation.mX, recoverAnimation.mY)) {
                return itemView2;
            }
        }
        return mRecyclerView.findChildViewUnder(x, y);
    }
    
    private List<ViewHolder> findSwapTargets(final ViewHolder viewHolder) {
        if (mSwapTargets == null) {
            mSwapTargets = new ArrayList<ViewHolder>();
            mDistances = new ArrayList<Integer>();
        }
        else {
            mSwapTargets.clear();
            mDistances.clear();
        }
        final int boundingBoxMargin = mCallback.getBoundingBoxMargin();
        final int n = Math.round(mSelectedStartX + mDx) - boundingBoxMargin;
        final int n2 = Math.round(mSelectedStartY + mDy) - boundingBoxMargin;
        final int n3 = n + viewHolder.itemView.getWidth() + boundingBoxMargin * 2;
        final int n4 = n2 + viewHolder.itemView.getHeight() + boundingBoxMargin * 2;
        final int n5 = (n + n3) / 2;
        final int n6 = (n2 + n4) / 2;
        final RecyclerView.LayoutManager layoutManager = mRecyclerView.getLayoutManager();
        for (int childCount = layoutManager.getChildCount(), i = 0; i < childCount; ++i) {
            final View child = layoutManager.getChildAt(i);
            if (child != viewHolder.itemView && child.getBottom() >= n2 && child.getTop() <= n4 && child.getRight() >= n && child.getLeft() <= n3) {
                final RecyclerView.ViewHolder childViewHolder = mRecyclerView.getChildViewHolder(child);
                if (mCallback.canDropOver(mRecyclerView, mSelected, childViewHolder)) {
                    final int abs = Math.abs(n5 - (child.getLeft() + child.getRight()) / 2);
                    final int abs2 = Math.abs(n6 - (child.getTop() + child.getBottom()) / 2);
                    final int n7 = abs * abs + abs2 * abs2;
                    int n8 = 0;
                    for (int size = mSwapTargets.size(), n9 = 0; n9 < size && n7 > mDistances.get(n9); ++n9) {
                        ++n8;
                    }
                    mSwapTargets.add(n8, childViewHolder);
                    mDistances.add(n8, n7);
                }
            }
        }
        return mSwapTargets;
    }
    
    private ViewHolder findSwipedView(final MotionEvent motionEvent) {
        final RecyclerView.LayoutManager layoutManager = mRecyclerView.getLayoutManager();
        if (mActivePointerId != -1) {
            final int pointerIndex = MotionEventCompat.findPointerIndex(motionEvent, mActivePointerId);
            final float n = MotionEventCompat.getX(motionEvent, pointerIndex) - mInitialTouchX;
            final float n2 = MotionEventCompat.getY(motionEvent, pointerIndex) - mInitialTouchY;
            final float abs = Math.abs(n);
            final float abs2 = Math.abs(n2);
            if ((abs >= mSlop || abs2 >= mSlop) && (abs <= abs2 || !layoutManager.canScrollHorizontally()) && (abs2 <= abs || !layoutManager.canScrollVertically())) {
                final View childView = this.findChildView(motionEvent);
                if (childView != null) {
                    return mRecyclerView.getChildViewHolder(childView);
                }
            }
        }
        return null;
    }
    
    private void getSelectedDxDy(final float[] array) {
        if ((0xC & mSelectedFlags) != 0x0) {
            array[0] = mSelectedStartX + mDx - mSelected.itemView.getLeft();
        }
        else {
            array[0] = ViewCompat.getTranslationX(mSelected.itemView);
        }
        if ((0x3 & mSelectedFlags) != 0x0) {
            array[1] = mSelectedStartY + mDy - mSelected.itemView.getTop();
            return;
        }
        array[1] = ViewCompat.getTranslationY(mSelected.itemView);
    }
    
    private boolean hasRunningRecoverAnim() {
        for (int size = mRecoverAnimations.size(), i = 0; i < size; ++i) {
            if (!((RecoverAnimation)mRecoverAnimations.get(i)).mEnded) {
                return true;
            }
        }
        return false;
    }
    
    private static boolean hitTest(final View view, final float n, final float n2, final float n3, final float n4) {
        return n >= n3 && n <= n3 + view.getWidth() && n2 >= n4 && n2 <= n4 + view.getHeight();
    }
    
    private void initGestureDetector() {
        if (mGestureDetector != null) {
            return;
        }
        mGestureDetector = new GestureDetectorCompat(mRecyclerView.getContext(), (GestureDetector$OnGestureListener)new ItemTouchHelperGestureListener(this));
    }
    
    private void moveIfNecessary(final ViewHolder viewHolder) {
        if (!mRecyclerView.isLayoutRequested() && mActionState == 2) {
            final float moveThreshold = mCallback.getMoveThreshold(viewHolder);
            final int n = (int)(mSelectedStartX + mDx);
            final int n2 = (int)(mSelectedStartY + mDy);
            if (Math.abs(n2 - viewHolder.itemView.getTop()) >= moveThreshold * viewHolder.itemView.getHeight() || Math.abs(n - viewHolder.itemView.getLeft()) >= moveThreshold * viewHolder.itemView.getWidth()) {
                final List<ViewHolder> swapTargets = this.findSwapTargets(viewHolder);
                if (swapTargets.size() != 0) {
                    final ViewHolder chooseDropTarget = mCallback.chooseDropTarget(viewHolder, swapTargets, n, n2);
                    if (chooseDropTarget == null) {
                        mSwapTargets.clear();
                        mDistances.clear();
                        return;
                    }
                    final int adapterPosition = chooseDropTarget.getAdapterPosition();
                    final int adapterPosition2 = viewHolder.getAdapterPosition();
                    if (mCallback.onMove(mRecyclerView, viewHolder, chooseDropTarget)) {
                        mCallback.onMoved(mRecyclerView, viewHolder, adapterPosition2, chooseDropTarget, adapterPosition, n, n2);
                    }
                }
            }
        }
    }
    
    private void obtainVelocityTracker() {
        if (mVelocityTracker != null) {
            mVelocityTracker.recycle();
        }
        mVelocityTracker = VelocityTracker.obtain();
    }
    
    private void postDispatchSwipe(final RecoverAnimation recoverAnimation, final int n) {
        mRecyclerView.post((Runnable)new Runnable() {
            final /* synthetic */ ItemTouchHelper this$0;
            final /* synthetic */ RecoverAnimation val$anim;
            final /* synthetic */ int val$swipeDir;
            
            ItemTouchHelper$4() {
                this$0 = this$0;
                super();
            }
            
            @Override
            public void run() {
                if (mRecyclerView != null && mRecyclerView.isAttachedToWindow() && !recoverAnimation.mOverridden && recoverAnimation.mViewHolder.getAdapterPosition() != -1) {
                    final RecyclerView.ItemAnimator itemAnimator = mRecyclerView.getItemAnimator();
                    if ((itemAnimator != null && itemAnimator.isRunning(null)) || this$0.hasRunningRecoverAnim()) {
                        mRecyclerView.post((Runnable)this);
                        return;
                    }
                    mCallback.onSwiped(recoverAnimation.mViewHolder, n);
                }
            }
        });
    }
    
    private void releaseVelocityTracker() {
        if (mVelocityTracker != null) {
            mVelocityTracker.recycle();
            mVelocityTracker = null;
        }
    }
    
    private void removeChildDrawingOrderCallbackIfNecessary(final View view) {
        if (view == mOverdrawChild) {
            mOverdrawChild = null;
            if (mChildDrawingOrderCallback != null) {
                mRecyclerView.setChildDrawingOrderCallback(null);
            }
        }
    }
    
    private boolean scrollIfNecessary() {
        if (mSelected == null) {
            mDragScrollStartTimeInMs = Long.MIN_VALUE;
            return false;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        long n;
        if (mDragScrollStartTimeInMs == Long.MIN_VALUE) {
            n = 0L;
        }
        else {
            n = currentTimeMillis - mDragScrollStartTimeInMs;
        }
        final RecyclerView.LayoutManager layoutManager = mRecyclerView.getLayoutManager();
        if (mTmpRect == null) {
            mTmpRect = new Rect();
        }
        layoutManager.calculateItemDecorationsForChild(mSelected.itemView, mTmpRect);
        final boolean canScrollHorizontally = layoutManager.canScrollHorizontally();
        int interpolateOutOfBoundsScroll = 0;
        if (canScrollHorizontally) {
            final int n2 = (int)(mSelectedStartX + mDx);
            final int n3 = n2 - mTmpRect.left - mRecyclerView.getPaddingLeft();
            if (mDx < 0.0f && n3 < 0) {
                interpolateOutOfBoundsScroll = n3;
            }
            else {
                final float n4 = fcmpl(mDx, 0.0f);
                interpolateOutOfBoundsScroll = 0;
                if (n4 > 0) {
                    final int n5 = n2 + mSelected.itemView.getWidth() + mTmpRect.right - (mRecyclerView.getWidth() - mRecyclerView.getPaddingRight());
                    interpolateOutOfBoundsScroll = 0;
                    if (n5 > 0) {
                        interpolateOutOfBoundsScroll = n5;
                    }
                }
            }
        }
        final boolean canScrollVertically = layoutManager.canScrollVertically();
        int interpolateOutOfBoundsScroll2 = 0;
        if (canScrollVertically) {
            final int n6 = (int)(mSelectedStartY + mDy);
            final int n7 = n6 - mTmpRect.top - mRecyclerView.getPaddingTop();
            if (mDy < 0.0f && n7 < 0) {
                interpolateOutOfBoundsScroll2 = n7;
            }
            else {
                final float n8 = fcmpl(mDy, 0.0f);
                interpolateOutOfBoundsScroll2 = 0;
                if (n8 > 0) {
                    final int n9 = n6 + mSelected.itemView.getHeight() + mTmpRect.bottom - (mRecyclerView.getHeight() - mRecyclerView.getPaddingBottom());
                    interpolateOutOfBoundsScroll2 = 0;
                    if (n9 > 0) {
                        interpolateOutOfBoundsScroll2 = n9;
                    }
                }
            }
        }
        if (interpolateOutOfBoundsScroll != 0) {
            interpolateOutOfBoundsScroll = mCallback.interpolateOutOfBoundsScroll(mRecyclerView, mSelected.itemView.getWidth(), interpolateOutOfBoundsScroll, mRecyclerView.getWidth(), n);
        }
        if (interpolateOutOfBoundsScroll2 != 0) {
            interpolateOutOfBoundsScroll2 = mCallback.interpolateOutOfBoundsScroll(mRecyclerView, mSelected.itemView.getHeight(), interpolateOutOfBoundsScroll2, mRecyclerView.getHeight(), n);
        }
        if (interpolateOutOfBoundsScroll != 0 || interpolateOutOfBoundsScroll2 != 0) {
            if (mDragScrollStartTimeInMs == Long.MIN_VALUE) {
                mDragScrollStartTimeInMs = currentTimeMillis;
            }
            mRecyclerView.scrollBy(interpolateOutOfBoundsScroll, interpolateOutOfBoundsScroll2);
            return true;
        }
        mDragScrollStartTimeInMs = Long.MIN_VALUE;
        return false;
    }
    
    private void select(final ViewHolder mSelected, final int mActionState) {
        if (mSelected == this.mSelected && mActionState == this.mActionState) {
            return;
        }
        mDragScrollStartTimeInMs = Long.MIN_VALUE;
        final int mActionState2 = this.mActionState;
        this.endRecoverAnimation(mSelected, true);
        if ((this.mActionState = mActionState) == 2) {
            mOverdrawChild = mSelected.itemView;
            this.addChildDrawingOrderCallback();
        }
        final int n = -1 + (1 << 8 + mActionState * 8);
        final ViewHolder mSelected2 = this.mSelected;
        int n2 = 0;
        if (mSelected2 != null) {
            final ViewHolder mSelected3 = this.mSelected;
            if (mSelected3.itemView.getParent() != null) {
                int swipeIfNecessary;
                if (mActionState2 == 2) {
                    swipeIfNecessary = 0;
                }
                else {
                    swipeIfNecessary = this.swipeIfNecessary(mSelected3);
                }
                this.releaseVelocityTracker();
                float n3 = 0.0f;
                float n4 = 0.0f;
                switch (swipeIfNecessary) {
                    default:
                        n3 = 0.0f;
                        n4 = 0.0f;
                        break;
                    case 4:
                    case 8:
                    case 16:
                    case 32:
                        n3 = Math.signum(mDx) * mRecyclerView.getWidth();
                        n4 = 0.0f;
                        break;
                    case 1:
                    case 2:
                        n4 = Math.signum(mDy) * mRecyclerView.getHeight();
                        n3 = 0.0f;
                        break;
                }
                int n5;
                if (mActionState2 == 2) {
                    n5 = 8;
                }
                else if (swipeIfNecessary > 0) {
                    n5 = 2;
                }
                else {
                    n5 = 4;
                }
                this.getSelectedDxDy(mTmpPosition);
                final float n6 = mTmpPosition[0];
                final float n7 = mTmpPosition[1];
                final RecoverAnimation recoverAnimation = new RecoverAnimation(mSelected3, n5, mActionState2, n6, n7, n3, n4) {
                    final /* synthetic */ ItemTouchHelper this$0;
                    final /* synthetic */ ViewHolder val$prevSelected;
                    final /* synthetic */ int val$swipeDir;
                    
                    ItemTouchHelper$3(final ViewHolder viewHolder, final int n, final int n2, final float n3, final float n4, final float n5, final float n6) {
                        this$0 = this$0;
                        this$0.super(viewHolder, n, n2, n3, n4, n5, n6);
                    }
                    
                    @Override
                    public void onAnimationEnd(final ValueAnimatorCompat valueAnimatorCompat) {
                        super.onAnimationEnd(valueAnimatorCompat);
                        if (!this.mOverridden) {
                            if (swipeIfNecessary <= 0) {
                                mCallback.clearView(mRecyclerView, mSelected3);
                            }
                            else {
                                mPendingCleanup.add(mSelected3.itemView);
                                this.mIsPendingCleanup = true;
                                if (swipeIfNecessary > 0) {
                                    this$0.postDispatchSwipe((RecoverAnimation)this, swipeIfNecessary);
                                }
                            }
                            if (mOverdrawChild == mSelected3.itemView) {
                                this$0.removeChildDrawingOrderCallbackIfNecessary(mSelected3.itemView);
                            }
                        }
                    }
                };
                ((RecoverAnimation)recoverAnimation).setDuration(mCallback.getAnimationDuration(mRecyclerView, n5, n3 - n6, n4 - n7));
                mRecoverAnimations.add((RecoverAnimation)recoverAnimation);
                ((RecoverAnimation)recoverAnimation).start();
                n2 = 1;
            }
            else {
                this.removeChildDrawingOrderCallbackIfNecessary(mSelected3.itemView);
                mCallback.clearView(mRecyclerView, mSelected3);
                n2 = 0;
            }
            this.mSelected = null;
        }
        if (mSelected != null) {
            mSelectedFlags = (n & mCallback.getAbsoluteMovementFlags(mRecyclerView, mSelected)) >> 8 * this.mActionState;
            mSelectedStartX = mSelected.itemView.getLeft();
            mSelectedStartY = mSelected.itemView.getTop();
            this.mSelected = mSelected;
            if (mActionState == 2) {
                this.mSelected.itemView.performHapticFeedback(0);
            }
        }
        final ViewParent parent = mRecyclerView.getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(this.mSelected != null);
        }
        if (n2 == 0) {
            mRecyclerView.getLayoutManager().requestSimpleAnimationsInNextLayout();
        }
        mCallback.onSelectedChanged(this.mSelected, this.mActionState);
        mRecyclerView.invalidate();
    }
    
    private void setupCallbacks() {
        mSlop = ViewConfiguration.get(mRecyclerView.getContext()).getScaledTouchSlop();
        mRecyclerView.addItemDecoration((RecyclerView.ItemDecoration)this);
        mRecyclerView.addOnItemTouchListener(mOnItemTouchListener);
        mRecyclerView.addOnChildAttachStateChangeListener((RecyclerView.OnChildAttachStateChangeListener)this);
        this.initGestureDetector();
    }
    
    private int swipeIfNecessary(final ViewHolder viewHolder) {
        int n;
        if (mActionState == 2) {
            n = 0;
        }
        else {
            final int movementFlags = mCallback.getMovementFlags(mRecyclerView, viewHolder);
            final int n2 = (0xFF00 & mCallback.convertToAbsoluteDirection(movementFlags, ViewCompat.getLayoutDirection((View)mRecyclerView))) >> 8;
            if (n2 == 0) {
                return 0;
            }
            final int n3 = (movementFlags & 0xFF00) >> 8;
            if (Math.abs(mDx) > Math.abs(mDy)) {
                n = this.checkHorizontalSwipe(viewHolder, n2);
                if (n > 0) {
                    if ((n3 & n) == 0x0) {
                        return Callback.convertToRelativeDirection(n, ViewCompat.getLayoutDirection((View)mRecyclerView));
                    }
                    return n;
                }
                else {
                    n = this.checkVerticalSwipe(viewHolder, n2);
                    if (n > 0) {
                        return n;
                    }
                }
            }
            else {
                n = this.checkVerticalSwipe(viewHolder, n2);
                if (n > 0) {
                    return n;
                }
                n = this.checkHorizontalSwipe(viewHolder, n2);
                if (n > 0) {
                    if ((n3 & n) == 0x0) {
                        return Callback.convertToRelativeDirection(n, ViewCompat.getLayoutDirection((View)mRecyclerView));
                    }
                    return n;
                }
            }
            return 0;
        }
        return n;
    }
    
    private void updateDxDy(final MotionEvent motionEvent, final int n, final int n2) {
        final float x = MotionEventCompat.getX(motionEvent, n2);
        final float y = MotionEventCompat.getY(motionEvent, n2);
        mDx = x - mInitialTouchX;
        mDy = y - mInitialTouchY;
        if ((n & 0x4) == 0x0) {
            mDx = Math.max(0.0f, mDx);
        }
        if ((n & 0x8) == 0x0) {
            mDx = Math.min(0.0f, mDx);
        }
        if ((n & 0x1) == 0x0) {
            mDy = Math.max(0.0f, mDy);
        }
        if ((n & 0x2) == 0x0) {
            mDy = Math.min(0.0f, mDy);
        }
    }
    
    public void attachToRecyclerView(@Nullable final RecyclerView mRecyclerView) {
        if (this.mRecyclerView != mRecyclerView) {
            if (this.mRecyclerView != null) {
                this.destroyCallbacks();
            }
            this.mRecyclerView = mRecyclerView;
            if (this.mRecyclerView != null) {
                final Resources resources = mRecyclerView.getResources();
                mSwipeEscapeVelocity = resources.getDimension(R.dimen.item_touch_helper_swipe_escape_velocity);
                mMaxSwipeVelocity = resources.getDimension(R.dimen.item_touch_helper_swipe_escape_max_velocity);
                this.setupCallbacks();
            }
        }
    }
    
    @Override
    public void getItemOffsets(final Rect rect, final View view, final RecyclerView recyclerView, final State state) {
        rect.setEmpty();
    }
    
    @Override
    public void onChildViewAttachedToWindow(final View view) {
    }
    
    @Override
    public void onChildViewDetachedFromWindow(final View view) {
        this.removeChildDrawingOrderCallbackIfNecessary(view);
        final RecyclerView.ViewHolder childViewHolder = mRecyclerView.getChildViewHolder(view);
        if (childViewHolder != null) {
            if (mSelected != null && childViewHolder == mSelected) {
                this.select(null, 0);
                return;
            }
            this.endRecoverAnimation(childViewHolder, false);
            if (mPendingCleanup.remove(childViewHolder.itemView)) {
                mCallback.clearView(mRecyclerView, childViewHolder);
            }
        }
    }
    
    @Override
    public void onDraw(final Canvas canvas, final RecyclerView recyclerView, final State state) {
        mOverdrawChildPosition = -1;
        final ViewHolder mSelected = this.mSelected;
        float n = 0.0f;
        float n2 = 0.0f;
        if (mSelected != null) {
            this.getSelectedDxDy(mTmpPosition);
            n = mTmpPosition[0];
            n2 = mTmpPosition[1];
        }
        mCallback.onDraw(canvas, recyclerView, this.mSelected, mRecoverAnimations, mActionState, n, n2);
    }
    
    @Override
    public void onDrawOver(final Canvas canvas, final RecyclerView recyclerView, final State state) {
        final ViewHolder mSelected = this.mSelected;
        float n = 0.0f;
        float n2 = 0.0f;
        if (mSelected != null) {
            this.getSelectedDxDy(mTmpPosition);
            n = mTmpPosition[0];
            n2 = mTmpPosition[1];
        }
        mCallback.onDrawOver(canvas, recyclerView, this.mSelected, mRecoverAnimations, mActionState, n, n2);
    }
    
    public void startDrag(final ViewHolder viewHolder) {
        if (!mCallback.hasDragFlag(mRecyclerView, viewHolder)) {
            Log.e("ItemTouchHelper", "Start drag has been called but swiping is not enabled");
            return;
        }
        if (viewHolder.itemView.getParent() != mRecyclerView) {
            Log.e("ItemTouchHelper", "Start drag has been called with a view holder which is not a child of the RecyclerView which is controlled by this ItemTouchHelper.");
            return;
        }
        this.obtainVelocityTracker();
        mDy = 0.0f;
        mDx = 0.0f;
        this.select(viewHolder, 2);
    }
    
    public void startSwipe(final ViewHolder viewHolder) {
        if (!mCallback.hasSwipeFlag(mRecyclerView, viewHolder)) {
            Log.e("ItemTouchHelper", "Start swipe has been called but dragging is not enabled");
            return;
        }
        if (viewHolder.itemView.getParent() != mRecyclerView) {
            Log.e("ItemTouchHelper", "Start swipe has been called with a view holder which is not a child of the RecyclerView controlled by this ItemTouchHelper.");
            return;
        }
        this.obtainVelocityTracker();
        mDy = 0.0f;
        mDx = 0.0f;
        this.select(viewHolder, 1);
    }
}
