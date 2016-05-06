package android.support.v7.widget;

import android.support.v4.widget.ScrollerCompat;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.view.View$BaseSavedState;
import java.util.Collections;
import android.util.SparseIntArray;
import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.support.annotation.CallSuper;
import android.view.ViewGroup$MarginLayoutParams;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Annotation;
import android.database.Observable;
import android.support.v4.view.ViewConfigurationCompat;
import android.os.SystemClock;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.VelocityTrackerCompat;
import android.view.View$MeasureSpec;
import android.view.FocusFinder;
import android.view.ViewParent;
import android.graphics.Canvas;
import android.os.Parcelable;
import android.util.SparseArray;
import android.support.v4.view.MotionEventCompat;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.view.accessibility.AccessibilityEvent;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import android.support.v4.os.TraceCompat;
import android.view.ViewGroup$LayoutParams;
import android.content.res.TypedArray;
import android.support.v7.recyclerview.R;
import android.view.View;
import android.support.v4.view.ViewCompat;
import android.view.ViewConfiguration;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.content.Context;
import android.os.Build$VERSION;
import android.view.VelocityTracker;
import android.graphics.Rect;
import android.support.v4.view.NestedScrollingChildHelper;
import java.util.List;
import android.support.annotation.VisibleForTesting;
import java.util.ArrayList;
import android.support.v4.widget.EdgeEffectCompat;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.support.v4.view.NestedScrollingChild;
import android.support.v4.view.ScrollingView;
import android.view.ViewGroup;

public class RecyclerView extends ViewGroup implements ScrollingView, NestedScrollingChild
{
    private static final boolean DEBUG = false;
    private static final boolean DISPATCH_TEMP_DETACH = false;
    private static final boolean FORCE_INVALIDATE_DISPLAY_LIST = false;
    public static final int HORIZONTAL = 0;
    private static final int INVALID_POINTER = -1;
    public static final int INVALID_TYPE = -1;
    private static final Class<?>[] LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE;
    private static final int MAX_SCROLL_DURATION = 2000;
    public static final long NO_ID = -1L;
    public static final int NO_POSITION = -1;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    private static final String TAG = "RecyclerView";
    public static final int TOUCH_SLOP_DEFAULT = 0;
    public static final int TOUCH_SLOP_PAGING = 1;
    private static final String TRACE_BIND_VIEW_TAG = "RV OnBindView";
    private static final String TRACE_CREATE_VIEW_TAG = "RV CreateView";
    private static final String TRACE_HANDLE_ADAPTER_UPDATES_TAG = "RV PartialInvalidate";
    private static final String TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG = "RV FullInvalidate";
    private static final String TRACE_ON_LAYOUT_TAG = "RV OnLayout";
    private static final String TRACE_SCROLL_TAG = "RV Scroll";
    public static final int VERTICAL = 1;
    private static final Interpolator sQuinticInterpolator;
    private RecyclerViewAccessibilityDelegate mAccessibilityDelegate;
    private final AccessibilityManager mAccessibilityManager;
    private OnItemTouchListener mActiveOnItemTouchListener;
    private Adapter mAdapter;
    AdapterHelper mAdapterHelper;
    private boolean mAdapterUpdateDuringMeasure;
    private EdgeEffectCompat mBottomGlow;
    private ChildDrawingOrderCallback mChildDrawingOrderCallback;
    ChildHelper mChildHelper;
    private boolean mClipToPadding;
    private boolean mDataSetHasChangedAfterLayout;
    private int mEatRequestLayout;
    private int mEatenAccessibilityChangeFlags;
    private boolean mFirstLayoutComplete;
    private boolean mHasFixedSize;
    private boolean mIgnoreMotionEventTillDown;
    private int mInitialTouchX;
    private int mInitialTouchY;
    private boolean mIsAttached;
    ItemAnimator mItemAnimator;
    private ItemAnimatorListener mItemAnimatorListener;
    private Runnable mItemAnimatorRunner;
    private final ArrayList<ItemDecoration> mItemDecorations;
    boolean mItemsAddedOrRemoved;
    boolean mItemsChanged;
    private int mLastTouchX;
    private int mLastTouchY;
    @VisibleForTesting
    LayoutManager mLayout;
    private boolean mLayoutFrozen;
    private int mLayoutOrScrollCounter;
    private boolean mLayoutRequestEaten;
    private EdgeEffectCompat mLeftGlow;
    private final int mMaxFlingVelocity;
    private final int mMinFlingVelocity;
    private final int[] mMinMaxLayoutPositions;
    private final int[] mNestedOffsets;
    private final RecyclerViewDataObserver mObserver;
    private List<OnChildAttachStateChangeListener> mOnChildAttachStateListeners;
    private final ArrayList<OnItemTouchListener> mOnItemTouchListeners;
    private SavedState mPendingSavedState;
    private final boolean mPostUpdatesOnAnimation;
    private boolean mPostedAnimatorRunner;
    final Recycler mRecycler;
    private RecyclerListener mRecyclerListener;
    private EdgeEffectCompat mRightGlow;
    private final int[] mScrollConsumed;
    private float mScrollFactor;
    private OnScrollListener mScrollListener;
    private List<OnScrollListener> mScrollListeners;
    private final int[] mScrollOffset;
    private int mScrollPointerId;
    private int mScrollState;
    private final NestedScrollingChildHelper mScrollingChildHelper;
    final State mState;
    private final Rect mTempRect;
    private EdgeEffectCompat mTopGlow;
    private int mTouchSlop;
    private final Runnable mUpdateChildViewsRunnable;
    private VelocityTracker mVelocityTracker;
    private final ViewFlinger mViewFlinger;
    private final ViewInfoStore.ProcessCallback mViewInfoProcessCallback;
    final ViewInfoStore mViewInfoStore;
    
    static {
        LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = new Class[] { Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE };
        sQuinticInterpolator = (Interpolator)new Interpolator() {
            RecyclerView$3() {
                super();
            }
            
            public float getInterpolation(final float n) {
                final float n2 = n - 1.0f;
                return 1.0f + n2 * (n2 * (n2 * (n2 * n2)));
            }
        };
    }
    
    public RecyclerView(final Context context) {
        this(context, null);
    }
    
    public RecyclerView(final Context context, @Nullable final AttributeSet set) {
        this(context, set, 0);
    }
    
    public RecyclerView(final Context context, @Nullable final AttributeSet set, final int n) {
        super(context, set, n);
        mObserver = new RecyclerViewDataObserver(this);
        mRecycler = new Recycler();
        mViewInfoStore = new ViewInfoStore();
        mUpdateChildViewsRunnable = new Runnable() {
            final /* synthetic */ RecyclerView this$0;
            
            RecyclerView$1() {
                this$0 = this$0;
                super();
            }
            
            @Override
            public void run() {
                if (!mFirstLayoutComplete || this$0.isLayoutRequested()) {
                    return;
                }
                if (mLayoutFrozen) {
                    mLayoutRequestEaten = true;
                    return;
                }
                this$0.consumePendingUpdateOperations();
            }
        };
        mTempRect = new Rect();
        mItemDecorations = new ArrayList<ItemDecoration>();
        mOnItemTouchListeners = new ArrayList<OnItemTouchListener>();
        mEatRequestLayout = 0;
        mDataSetHasChangedAfterLayout = false;
        mLayoutOrScrollCounter = 0;
        mItemAnimator = (ItemAnimator)new DefaultItemAnimator();
        mScrollState = 0;
        mScrollPointerId = -1;
        mScrollFactor = Float.MIN_VALUE;
        mViewFlinger = new ViewFlinger();
        mState = new State();
        mItemsAddedOrRemoved = false;
        mItemsChanged = false;
        mItemAnimatorListener = (ItemAnimatorListener)new ItemAnimatorRestoreListener(this);
        mPostedAnimatorRunner = false;
        mMinMaxLayoutPositions = new int[2];
        mScrollOffset = new int[2];
        mScrollConsumed = new int[2];
        mNestedOffsets = new int[2];
        mItemAnimatorRunner = new Runnable() {
            final /* synthetic */ RecyclerView this$0;
            
            RecyclerView$2() {
                this$0 = this$0;
                super();
            }
            
            @Override
            public void run() {
                if (mItemAnimator != null) {
                    mItemAnimator.runPendingAnimations();
                }
                mPostedAnimatorRunner = false;
            }
        };
        mViewInfoProcessCallback = new ViewInfoStore.ProcessCallback() {
            final /* synthetic */ RecyclerView this$0;
            
            RecyclerView$4() {
                this$0 = this$0;
                super();
            }
            
            @Override
            public void processAppeared(final ViewHolder viewHolder, final ItemHolderInfo itemHolderInfo, final ItemHolderInfo itemHolderInfo2) {
                this$0.animateAppearance(viewHolder, itemHolderInfo, itemHolderInfo2);
            }
            
            @Override
            public void processDisappeared(final ViewHolder viewHolder, @NonNull final ItemHolderInfo itemHolderInfo, @Nullable final ItemHolderInfo itemHolderInfo2) {
                mRecycler.unscrapView(viewHolder);
                this$0.animateDisappearance(viewHolder, itemHolderInfo, itemHolderInfo2);
            }
            
            @Override
            public void processPersistent(final ViewHolder viewHolder, @NonNull final ItemHolderInfo itemHolderInfo, @NonNull final ItemHolderInfo itemHolderInfo2) {
                viewHolder.setIsRecyclable(false);
                if (mDataSetHasChangedAfterLayout) {
                    if (mItemAnimator.animateChange(viewHolder, viewHolder, itemHolderInfo, itemHolderInfo2)) {
                        this$0.postAnimationRunner();
                    }
                }
                else if (mItemAnimator.animatePersistence(viewHolder, itemHolderInfo, itemHolderInfo2)) {
                    this$0.postAnimationRunner();
                }
            }
            
            @Override
            public void unused(final ViewHolder viewHolder) {
                mLayout.removeAndRecycleView(viewHolder.itemView, mRecycler);
            }
        };
        this.setScrollContainer(true);
        this.setFocusableInTouchMode(true);
        mPostUpdatesOnAnimation = (Build$VERSION.SDK_INT >= 16);
        final ViewConfiguration value = ViewConfiguration.get(context);
        mTouchSlop = value.getScaledTouchSlop();
        mMinFlingVelocity = value.getScaledMinimumFlingVelocity();
        mMaxFlingVelocity = value.getScaledMaximumFlingVelocity();
        final int overScrollMode = ViewCompat.getOverScrollMode((View)this);
        boolean willNotDraw = false;
        if (overScrollMode == 2) {
            willNotDraw = true;
        }
        this.setWillNotDraw(willNotDraw);
        mItemAnimator.setListener(mItemAnimatorListener);
        this.initAdapterManager();
        this.initChildrenHelper();
        if (ViewCompat.getImportantForAccessibility((View)this) == 0) {
            ViewCompat.setImportantForAccessibility((View)this, 1);
        }
        mAccessibilityManager = (AccessibilityManager)this.getContext().getSystemService("accessibility");
        this.setAccessibilityDelegateCompat(new RecyclerViewAccessibilityDelegate(this));
        if (set != null) {
            final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, R.styleable.RecyclerView, n, 0);
            final String string = obtainStyledAttributes.getString(R.styleable.RecyclerView_layoutManager);
            obtainStyledAttributes.recycle();
            this.createLayoutManager(context, string, set, n, 0);
        }
        mScrollingChildHelper = new NestedScrollingChildHelper((View)this);
        this.setNestedScrollingEnabled(true);
    }
    
    static /* synthetic */ boolean access$100(final RecyclerView recyclerView) {
        return recyclerView.mFirstLayoutComplete;
    }
    
    static /* synthetic */ void access$1000(final RecyclerView recyclerView) {
        recyclerView.postAnimationRunner();
    }
    
    static /* synthetic */ void access$1100(final RecyclerView recyclerView, final View view) {
        recyclerView.dispatchChildAttached(view);
    }
    
    static /* synthetic */ void access$1200(final RecyclerView recyclerView, final View view) {
        recyclerView.dispatchChildDetached(view);
    }
    
    static /* synthetic */ void access$1300(final RecyclerView recyclerView, final View view, final int n, final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        recyclerView.attachViewToParent(view, n, viewGroup$LayoutParams);
    }
    
    static /* synthetic */ void access$1400(final RecyclerView recyclerView, final int n) {
        recyclerView.detachViewFromParent(n);
    }
    
    static /* synthetic */ boolean access$200(final RecyclerView recyclerView) {
        return recyclerView.mLayoutFrozen;
    }
    
    static /* synthetic */ Interpolator access$3000() {
        return sQuinticInterpolator;
    }
    
    static /* synthetic */ boolean access$302(final RecyclerView recyclerView, final boolean mLayoutRequestEaten) {
        return recyclerView.mLayoutRequestEaten = mLayoutRequestEaten;
    }
    
    static /* synthetic */ Adapter access$3100(final RecyclerView recyclerView) {
        return recyclerView.mAdapter;
    }
    
    static /* synthetic */ void access$3200(final RecyclerView recyclerView) {
        recyclerView.onEnterLayoutOrScroll();
    }
    
    static /* synthetic */ void access$3300(final RecyclerView recyclerView) {
        recyclerView.repositionShadowingViews();
    }
    
    static /* synthetic */ void access$3400(final RecyclerView recyclerView) {
        recyclerView.onExitLayoutOrScroll();
    }
    
    static /* synthetic */ ArrayList access$3600(final RecyclerView recyclerView) {
        return recyclerView.mItemDecorations;
    }
    
    static /* synthetic */ void access$3700(final RecyclerView recyclerView, final int n, final int n2) {
        recyclerView.considerReleasingGlowsOnScroll(n, n2);
    }
    
    static /* synthetic */ boolean access$3800(final RecyclerView recyclerView) {
        return recyclerView.awakenScrollBars();
    }
    
    static /* synthetic */ void access$3900(final RecyclerView recyclerView, final int scrollState) {
        recyclerView.setScrollState(scrollState);
    }
    
    static /* synthetic */ void access$400(final RecyclerView recyclerView) {
        recyclerView.consumePendingUpdateOperations();
    }
    
    static /* synthetic */ void access$4000(final RecyclerView recyclerView) {
        recyclerView.setDataSetChangedAfterLayout();
    }
    
    static /* synthetic */ boolean access$4100(final RecyclerView recyclerView) {
        return recyclerView.mPostUpdatesOnAnimation;
    }
    
    static /* synthetic */ boolean access$4200(final RecyclerView recyclerView) {
        return recyclerView.mHasFixedSize;
    }
    
    static /* synthetic */ boolean access$4300(final RecyclerView recyclerView) {
        return recyclerView.mIsAttached;
    }
    
    static /* synthetic */ Runnable access$4400(final RecyclerView recyclerView) {
        return recyclerView.mUpdateChildViewsRunnable;
    }
    
    static /* synthetic */ boolean access$4502(final RecyclerView recyclerView, final boolean mAdapterUpdateDuringMeasure) {
        return recyclerView.mAdapterUpdateDuringMeasure = mAdapterUpdateDuringMeasure;
    }
    
    static /* synthetic */ boolean access$4600() {
        return FORCE_INVALIDATE_DISPLAY_LIST;
    }
    
    static /* synthetic */ void access$4700(final RecyclerView recyclerView, final ViewHolder viewHolder, final ItemHolderInfo itemHolderInfo) {
        recyclerView.recordAnimationInfoIfBouncedHiddenView(viewHolder, itemHolderInfo);
    }
    
    static /* synthetic */ RecyclerViewAccessibilityDelegate access$4800(final RecyclerView recyclerView) {
        return recyclerView.mAccessibilityDelegate;
    }
    
    static /* synthetic */ boolean access$5200(final RecyclerView recyclerView, final ViewHolder viewHolder) {
        return recyclerView.canReuseUpdatedViewHolder(viewHolder);
    }
    
    static /* synthetic */ RecyclerListener access$5300(final RecyclerView recyclerView) {
        return recyclerView.mRecyclerListener;
    }
    
    static /* synthetic */ Rect access$5400(final RecyclerView recyclerView) {
        return recyclerView.mTempRect;
    }
    
    static /* synthetic */ boolean access$5500(final RecyclerView recyclerView) {
        return recyclerView.mClipToPadding;
    }
    
    static /* synthetic */ void access$5600(final RecyclerView recyclerView, final int n, final int n2) {
        recyclerView.setMeasuredDimension(n, n2);
    }
    
    static /* synthetic */ int access$5700(final RecyclerView recyclerView, final ViewHolder viewHolder) {
        return recyclerView.getAdapterPositionFor(viewHolder);
    }
    
    static /* synthetic */ ViewFlinger access$5900(final RecyclerView recyclerView) {
        return recyclerView.mViewFlinger;
    }
    
    static /* synthetic */ boolean access$602(final RecyclerView recyclerView, final boolean mPostedAnimatorRunner) {
        return recyclerView.mPostedAnimatorRunner = mPostedAnimatorRunner;
    }
    
    static /* synthetic */ void access$6200(final RecyclerView recyclerView, final int n) {
        recyclerView.jumpToPositionForSmoothScroller(n);
    }
    
    static /* synthetic */ boolean access$6400(final RecyclerView recyclerView, final View view) {
        return recyclerView.removeAnimatingView(view);
    }
    
    static /* synthetic */ void access$700(final RecyclerView recyclerView, final ViewHolder viewHolder, final ItemHolderInfo itemHolderInfo, final ItemHolderInfo itemHolderInfo2) {
        recyclerView.animateDisappearance(viewHolder, itemHolderInfo, itemHolderInfo2);
    }
    
    static /* synthetic */ void access$800(final RecyclerView recyclerView, final ViewHolder viewHolder, final ItemHolderInfo itemHolderInfo, final ItemHolderInfo itemHolderInfo2) {
        recyclerView.animateAppearance(viewHolder, itemHolderInfo, itemHolderInfo2);
    }
    
    static /* synthetic */ boolean access$900(final RecyclerView recyclerView) {
        return recyclerView.mDataSetHasChangedAfterLayout;
    }
    
    private void addAnimatingView(final ViewHolder viewHolder) {
        final View itemView = viewHolder.itemView;
        final boolean b = itemView.getParent() == this;
        mRecycler.unscrapView(this.getChildViewHolder(itemView));
        if (viewHolder.isTmpDetached()) {
            mChildHelper.attachViewToParent(itemView, -1, itemView.getLayoutParams(), true);
            return;
        }
        if (!b) {
            mChildHelper.addView(itemView, true);
            return;
        }
        mChildHelper.hide(itemView);
    }
    
    private void animateAppearance(@NonNull final ViewHolder viewHolder, @Nullable final ItemHolderInfo itemHolderInfo, @NonNull final ItemHolderInfo itemHolderInfo2) {
        viewHolder.setIsRecyclable(false);
        if (mItemAnimator.animateAppearance(viewHolder, itemHolderInfo, itemHolderInfo2)) {
            this.postAnimationRunner();
        }
    }
    
    private void animateChange(@NonNull final ViewHolder mShadowingHolder, @NonNull final ViewHolder mShadowedHolder, @NonNull final ItemHolderInfo itemHolderInfo, @NonNull final ItemHolderInfo itemHolderInfo2, final boolean b, final boolean b2) {
        mShadowingHolder.setIsRecyclable(false);
        if (b) {
            this.addAnimatingView(mShadowingHolder);
        }
        if (mShadowingHolder != mShadowedHolder) {
            if (b2) {
                this.addAnimatingView(mShadowedHolder);
            }
            mShadowingHolder.mShadowedHolder = mShadowedHolder;
            this.addAnimatingView(mShadowingHolder);
            mRecycler.unscrapView(mShadowingHolder);
            mShadowedHolder.setIsRecyclable(false);
            mShadowedHolder.mShadowingHolder = mShadowingHolder;
        }
        if (mItemAnimator.animateChange(mShadowingHolder, mShadowedHolder, itemHolderInfo, itemHolderInfo2)) {
            this.postAnimationRunner();
        }
    }
    
    private void animateDisappearance(@NonNull final ViewHolder viewHolder, @NonNull final ItemHolderInfo itemHolderInfo, @Nullable final ItemHolderInfo itemHolderInfo2) {
        this.addAnimatingView(viewHolder);
        viewHolder.setIsRecyclable(false);
        if (mItemAnimator.animateDisappearance(viewHolder, itemHolderInfo, itemHolderInfo2)) {
            this.postAnimationRunner();
        }
    }
    
    private boolean canReuseUpdatedViewHolder(final ViewHolder viewHolder) {
        return mItemAnimator == null || mItemAnimator.canReuseUpdatedViewHolder(viewHolder, viewHolder.getUnmodifiedPayloads());
    }
    
    private void cancelTouch() {
        this.resetTouch();
        this.setScrollState(0);
    }
    
    private void considerReleasingGlowsOnScroll(final int n, final int n2) {
        final EdgeEffectCompat mLeftGlow = this.mLeftGlow;
        boolean onRelease = false;
        if (mLeftGlow != null) {
            final boolean finished = this.mLeftGlow.isFinished();
            onRelease = false;
            if (!finished) {
                onRelease = false;
                if (n > 0) {
                    onRelease = this.mLeftGlow.onRelease();
                }
            }
        }
        if (mRightGlow != null && !mRightGlow.isFinished() && n < 0) {
            onRelease |= mRightGlow.onRelease();
        }
        if (mTopGlow != null && !mTopGlow.isFinished() && n2 > 0) {
            onRelease |= mTopGlow.onRelease();
        }
        if (mBottomGlow != null && !mBottomGlow.isFinished() && n2 < 0) {
            onRelease |= mBottomGlow.onRelease();
        }
        if (onRelease) {
            ViewCompat.postInvalidateOnAnimation((View)this);
        }
    }
    
    private void consumePendingUpdateOperations() {
        if (mFirstLayoutComplete) {
            if (mDataSetHasChangedAfterLayout) {
                TraceCompat.beginSection("RV FullInvalidate");
                this.dispatchLayout();
                TraceCompat.endSection();
                return;
            }
            if (mAdapterHelper.hasPendingUpdates()) {
                if (mAdapterHelper.hasAnyUpdateTypes(4) && !mAdapterHelper.hasAnyUpdateTypes(11)) {
                    TraceCompat.beginSection("RV PartialInvalidate");
                    this.eatRequestLayout();
                    mAdapterHelper.preProcess();
                    if (!mLayoutRequestEaten) {
                        if (this.hasUpdatedView()) {
                            this.dispatchLayout();
                        }
                        else {
                            mAdapterHelper.consumePostponedUpdates();
                        }
                    }
                    this.resumeRequestLayout(true);
                    TraceCompat.endSection();
                    return;
                }
                if (mAdapterHelper.hasPendingUpdates()) {
                    TraceCompat.beginSection("RV FullInvalidate");
                    this.dispatchLayout();
                    TraceCompat.endSection();
                }
            }
        }
    }
    
    private void createLayoutManager(final Context context, final String s, final AttributeSet set, final int n, final int n2) {
        if (s != null) {
            final String trim = s.trim();
            if (trim.length() != 0) {
                final String fullClassName = this.getFullClassName(context, trim);
                try {
                    Label_0126: {
                        if (!this.isInEditMode()) {
                            break Label_0126;
                        }
                        ClassLoader classLoader = this.getClass().getClassLoader();
                        while (true) {
                            final Class<? extends LayoutManager> subclass = classLoader.loadClass(fullClassName).<LayoutManager>asSubclass(LayoutManager.class);
                            try {
                                final Constructor<? extends LayoutManager> constructor = subclass.getConstructor(LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE);
                                final Object[] array = { context, set, n, n2 };
                                constructor.setAccessible(true);
                                this.setLayoutManager((LayoutManager)constructor.newInstance(array));
                                return;
                                classLoader = context.getClassLoader();
                            }
                            catch (NoSuchMethodException ex2) {
                                try {
                                    final Constructor<? extends LayoutManager> constructor = subclass.getConstructor((Class<?>[])new Class[0]);
                                    final Object[] array = null;
                                }
                                catch (NoSuchMethodException ex) {
                                    ex.initCause(ex2);
                                    throw new IllegalStateException(set.getPositionDescription() + ": Error creating LayoutManager " + fullClassName, ex);
                                }
                            }
                        }
                    }
                }
                catch (ClassNotFoundException ex3) {
                    throw new IllegalStateException(set.getPositionDescription() + ": Unable to find LayoutManager " + fullClassName, ex3);
                }
                catch (InvocationTargetException ex4) {
                    throw new IllegalStateException(set.getPositionDescription() + ": Could not instantiate the LayoutManager: " + fullClassName, ex4);
                }
                catch (InstantiationException ex5) {
                    throw new IllegalStateException(set.getPositionDescription() + ": Could not instantiate the LayoutManager: " + fullClassName, ex5);
                }
                catch (IllegalAccessException ex6) {
                    throw new IllegalStateException(set.getPositionDescription() + ": Cannot access non-public constructor " + fullClassName, ex6);
                }
                catch (ClassCastException ex7) {
                    throw new IllegalStateException(set.getPositionDescription() + ": Class is not a LayoutManager " + fullClassName, ex7);
                }
            }
        }
    }
    
    private boolean didChildRangeChange(final int n, final int n2) {
        final int childCount = mChildHelper.getChildCount();
        if (childCount != 0) {
            int n3 = 0;
            while (true) {
                final boolean b = false;
                if (n3 >= childCount) {
                    return b;
                }
                final ViewHolder childViewHolderInt = getChildViewHolderInt(mChildHelper.getChildAt(n3));
                if (!childViewHolderInt.shouldIgnore()) {
                    final int layoutPosition = childViewHolderInt.getLayoutPosition();
                    if (layoutPosition < n || layoutPosition > n2) {
                        break;
                    }
                }
                ++n3;
            }
            return true;
        }
        if (n == 0) {
            final boolean b = false;
            if (n2 == 0) {
                return b;
            }
        }
        return true;
    }
    
    private void dispatchChildAttached(final View view) {
        final ViewHolder childViewHolderInt = getChildViewHolderInt(view);
        this.onChildAttachedToWindow(view);
        if (mAdapter != null && childViewHolderInt != null) {
            mAdapter.onViewAttachedToWindow(childViewHolderInt);
        }
        if (mOnChildAttachStateListeners != null) {
            for (int i = -1 + mOnChildAttachStateListeners.size(); i >= 0; --i) {
                ((OnChildAttachStateChangeListener)mOnChildAttachStateListeners.get(i)).onChildViewAttachedToWindow(view);
            }
        }
    }
    
    private void dispatchChildDetached(final View view) {
        final ViewHolder childViewHolderInt = getChildViewHolderInt(view);
        this.onChildDetachedFromWindow(view);
        if (mAdapter != null && childViewHolderInt != null) {
            mAdapter.onViewDetachedFromWindow(childViewHolderInt);
        }
        if (mOnChildAttachStateListeners != null) {
            for (int i = -1 + mOnChildAttachStateListeners.size(); i >= 0; --i) {
                ((OnChildAttachStateChangeListener)mOnChildAttachStateListeners.get(i)).onChildViewDetachedFromWindow(view);
            }
        }
    }
    
    private void dispatchContentChangedIfNecessary() {
        final int mEatenAccessibilityChangeFlags = this.mEatenAccessibilityChangeFlags;
        this.mEatenAccessibilityChangeFlags = 0;
        if (mEatenAccessibilityChangeFlags != 0 && this.isAccessibilityEnabled()) {
            final AccessibilityEvent obtain = AccessibilityEvent.obtain();
            obtain.setEventType(2048);
            AccessibilityEventCompat.setContentChangeTypes(obtain, mEatenAccessibilityChangeFlags);
            this.sendAccessibilityEventUnchecked(obtain);
        }
    }
    
    private void dispatchLayoutStep1() {
        mState.assertLayoutStep(1);
        mState.mIsMeasuring = false;
        this.eatRequestLayout();
        mViewInfoStore.clear();
        this.onEnterLayoutOrScroll();
        this.processAdapterUpdatesAndSetAnimationFlags();
        mState.mTrackOldChangeHolders = (mState.mRunSimpleAnimations && mItemsChanged);
        mItemsChanged = false;
        mItemsAddedOrRemoved = false;
        mState.mInPreLayout = mState.mRunPredictiveAnimations;
        mState.mItemCount = mAdapter.getItemCount();
        this.findMinMaxChildLayoutPositions(mMinMaxLayoutPositions);
        if (mState.mRunSimpleAnimations) {
            for (int childCount = mChildHelper.getChildCount(), i = 0; i < childCount; ++i) {
                final ViewHolder childViewHolderInt = getChildViewHolderInt(mChildHelper.getChildAt(i));
                if (!childViewHolderInt.shouldIgnore() && (!childViewHolderInt.isInvalid() || mAdapter.hasStableIds())) {
                    mViewInfoStore.addToPreLayout(childViewHolderInt, mItemAnimator.recordPreLayoutInformation(mState, childViewHolderInt, ItemAnimator.buildAdapterChangeFlagsForAnimations(childViewHolderInt), childViewHolderInt.getUnmodifiedPayloads()));
                    if (mState.mTrackOldChangeHolders && childViewHolderInt.isUpdated() && !childViewHolderInt.isRemoved() && !childViewHolderInt.shouldIgnore() && !childViewHolderInt.isInvalid()) {
                        mViewInfoStore.addToOldChangeHolders(this.getChangedHolderKey(childViewHolderInt), childViewHolderInt);
                    }
                }
            }
        }
        if (mState.mRunPredictiveAnimations) {
            this.saveOldPositions();
            final boolean access$1800 = mState.mStructureChanged;
            mState.mStructureChanged = false;
            mLayout.onLayoutChildren(mRecycler, mState);
            mState.mStructureChanged = access$1800;
            for (int j = 0; j < mChildHelper.getChildCount(); ++j) {
                final ViewHolder childViewHolderInt2 = getChildViewHolderInt(mChildHelper.getChildAt(j));
                if (!childViewHolderInt2.shouldIgnore() && !mViewInfoStore.isInPreLayout(childViewHolderInt2)) {
                    int buildAdapterChangeFlagsForAnimations = ItemAnimator.buildAdapterChangeFlagsForAnimations(childViewHolderInt2);
                    final boolean hasAnyOfTheFlags = childViewHolderInt2.hasAnyOfTheFlags(8192);
                    if (!hasAnyOfTheFlags) {
                        buildAdapterChangeFlagsForAnimations |= 0x1000;
                    }
                    final ItemHolderInfo recordPreLayoutInformation = mItemAnimator.recordPreLayoutInformation(mState, childViewHolderInt2, buildAdapterChangeFlagsForAnimations, childViewHolderInt2.getUnmodifiedPayloads());
                    if (hasAnyOfTheFlags) {
                        this.recordAnimationInfoIfBouncedHiddenView(childViewHolderInt2, recordPreLayoutInformation);
                    }
                    else {
                        mViewInfoStore.addToAppearedInPreLayoutHolders(childViewHolderInt2, recordPreLayoutInformation);
                    }
                }
            }
            this.clearOldPositions();
        }
        else {
            this.clearOldPositions();
        }
        this.onExitLayoutOrScroll();
        this.resumeRequestLayout(false);
        mState.mLayoutStep = 2;
    }
    
    private void dispatchLayoutStep2() {
        this.eatRequestLayout();
        this.onEnterLayoutOrScroll();
        mState.assertLayoutStep(6);
        mAdapterHelper.consumeUpdatesInOnePass();
        mState.mItemCount = mAdapter.getItemCount();
        mState.mDeletedInvisibleItemCountSincePreviousLayout = 0;
        mState.mInPreLayout = false;
        mLayout.onLayoutChildren(mRecycler, mState);
        mState.mStructureChanged = false;
        mPendingSavedState = null;
        mState.mRunSimpleAnimations = (mState.mRunSimpleAnimations && mItemAnimator != null);
        mState.mLayoutStep = 4;
        this.onExitLayoutOrScroll();
        this.resumeRequestLayout(false);
    }
    
    private void dispatchLayoutStep3() {
        mState.assertLayoutStep(4);
        this.eatRequestLayout();
        this.onEnterLayoutOrScroll();
        mState.mLayoutStep = 1;
        if (mState.mRunSimpleAnimations) {
            for (int i = -1 + mChildHelper.getChildCount(); i >= 0; --i) {
                final ViewHolder childViewHolderInt = getChildViewHolderInt(mChildHelper.getChildAt(i));
                if (!childViewHolderInt.shouldIgnore()) {
                    final long changedHolderKey = this.getChangedHolderKey(childViewHolderInt);
                    final ItemHolderInfo recordPostLayoutInformation = mItemAnimator.recordPostLayoutInformation(mState, childViewHolderInt);
                    final ViewHolder fromOldChangeHolders = mViewInfoStore.getFromOldChangeHolders(changedHolderKey);
                    if (fromOldChangeHolders != null && !fromOldChangeHolders.shouldIgnore()) {
                        final boolean disappearing = mViewInfoStore.isDisappearing(fromOldChangeHolders);
                        final boolean disappearing2 = mViewInfoStore.isDisappearing(childViewHolderInt);
                        if (disappearing && fromOldChangeHolders == childViewHolderInt) {
                            mViewInfoStore.addToPostLayout(childViewHolderInt, recordPostLayoutInformation);
                        }
                        else {
                            final ItemHolderInfo popFromPreLayout = mViewInfoStore.popFromPreLayout(fromOldChangeHolders);
                            mViewInfoStore.addToPostLayout(childViewHolderInt, recordPostLayoutInformation);
                            final ItemHolderInfo popFromPostLayout = mViewInfoStore.popFromPostLayout(childViewHolderInt);
                            if (popFromPreLayout == null) {
                                this.handleMissingPreInfoForChangeError(changedHolderKey, childViewHolderInt, fromOldChangeHolders);
                            }
                            else {
                                this.animateChange(fromOldChangeHolders, childViewHolderInt, popFromPreLayout, popFromPostLayout, disappearing, disappearing2);
                            }
                        }
                    }
                    else {
                        mViewInfoStore.addToPostLayout(childViewHolderInt, recordPostLayoutInformation);
                    }
                }
            }
            mViewInfoStore.process(mViewInfoProcessCallback);
        }
        mLayout.removeAndRecycleScrapInt(mRecycler);
        mState.mPreviousLayoutItemCount = mState.mItemCount;
        mDataSetHasChangedAfterLayout = false;
        mState.mRunSimpleAnimations = false;
        mState.mRunPredictiveAnimations = false;
        mLayout.mRequestedSimpleAnimations = false;
        if (mRecycler.mChangedScrap != null) {
            mRecycler.mChangedScrap.clear();
        }
        this.onExitLayoutOrScroll();
        this.resumeRequestLayout(false);
        mViewInfoStore.clear();
        if (this.didChildRangeChange(mMinMaxLayoutPositions[0], mMinMaxLayoutPositions[1])) {
            this.dispatchOnScrolled(0, 0);
        }
    }
    
    private boolean dispatchOnItemTouch(final MotionEvent motionEvent) {
        final int action = motionEvent.getAction();
        if (mActiveOnItemTouchListener != null) {
            if (action == 0) {
                mActiveOnItemTouchListener = null;
            }
            else {
                mActiveOnItemTouchListener.onTouchEvent(this, motionEvent);
                if (action == 3 || action == 1) {
                    mActiveOnItemTouchListener = null;
                    return true;
                }
                return true;
            }
        }
        if (action != 0) {
            for (int size = mOnItemTouchListeners.size(), i = 0; i < size; ++i) {
                final OnItemTouchListener mActiveOnItemTouchListener = (OnItemTouchListener)mOnItemTouchListeners.get(i);
                if (mActiveOnItemTouchListener.onInterceptTouchEvent(this, motionEvent)) {
                    this.mActiveOnItemTouchListener = mActiveOnItemTouchListener;
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean dispatchOnItemTouchIntercept(final MotionEvent motionEvent) {
        final int action = motionEvent.getAction();
        if (action == 3 || action == 0) {
            mActiveOnItemTouchListener = null;
        }
        for (int size = mOnItemTouchListeners.size(), i = 0; i < size; ++i) {
            final OnItemTouchListener mActiveOnItemTouchListener = (OnItemTouchListener)mOnItemTouchListeners.get(i);
            if (mActiveOnItemTouchListener.onInterceptTouchEvent(this, motionEvent) && action != 3) {
                this.mActiveOnItemTouchListener = mActiveOnItemTouchListener;
                return true;
            }
        }
        return false;
    }
    
    private void findMinMaxChildLayoutPositions(final int[] array) {
        final int childCount = mChildHelper.getChildCount();
        if (childCount == 0) {
            array[1] = (array[0] = 0);
            return;
        }
        int n = Integer.MAX_VALUE;
        int n2 = Integer.MIN_VALUE;
        for (int i = 0; i < childCount; ++i) {
            final ViewHolder childViewHolderInt = getChildViewHolderInt(mChildHelper.getChildAt(i));
            if (!childViewHolderInt.shouldIgnore()) {
                final int layoutPosition = childViewHolderInt.getLayoutPosition();
                if (layoutPosition < n) {
                    n = layoutPosition;
                }
                if (layoutPosition > n2) {
                    n2 = layoutPosition;
                }
            }
        }
        array[0] = n;
        array[1] = n2;
    }
    
    private int getAdapterPositionFor(final ViewHolder viewHolder) {
        if (viewHolder.hasAnyOfTheFlags(524) || !viewHolder.isBound()) {
            return -1;
        }
        return mAdapterHelper.applyPendingUpdatesToPosition(viewHolder.mPosition);
    }
    
    static ViewHolder getChildViewHolderInt(final View view) {
        if (view == null) {
            return null;
        }
        return ((LayoutParams)view.getLayoutParams()).mViewHolder;
    }
    
    private String getFullClassName(final Context context, String string) {
        if (string.charAt(0) == '.') {
            string = context.getPackageName() + string;
        }
        else if (!string.contains(".")) {
            return RecyclerView.class.getPackage().getName() + '.' + string;
        }
        return string;
    }
    
    private float getScrollFactor() {
        if (mScrollFactor == Float.MIN_VALUE) {
            final TypedValue typedValue = new TypedValue();
            if (!this.getContext().getTheme().resolveAttribute(16842829, typedValue, true)) {
                return 0.0f;
            }
            mScrollFactor = typedValue.getDimension(this.getContext().getResources().getDisplayMetrics());
        }
        return mScrollFactor;
    }
    
    private void handleMissingPreInfoForChangeError(final long n, final ViewHolder viewHolder, final ViewHolder viewHolder2) {
        final int childCount = mChildHelper.getChildCount();
        int i = 0;
        while (i < childCount) {
            final ViewHolder childViewHolderInt = getChildViewHolderInt(mChildHelper.getChildAt(i));
            if (childViewHolderInt != viewHolder && this.getChangedHolderKey(childViewHolderInt) == n) {
                if (mAdapter != null && mAdapter.hasStableIds()) {
                    throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + childViewHolderInt + " \n View Holder 2:" + viewHolder);
                }
                throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + childViewHolderInt + " \n View Holder 2:" + viewHolder);
            }
            else {
                ++i;
            }
        }
        Log.e("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + viewHolder2 + " cannot be found but it is necessary for " + viewHolder);
    }
    
    private boolean hasUpdatedView() {
        for (int childCount = mChildHelper.getChildCount(), i = 0; i < childCount; ++i) {
            final ViewHolder childViewHolderInt = getChildViewHolderInt(mChildHelper.getChildAt(i));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.isUpdated()) {
                return true;
            }
        }
        return false;
    }
    
    private void initChildrenHelper() {
        mChildHelper = new ChildHelper((ChildHelper.Callback)new ChildHelper.Callback() {
            final /* synthetic */ RecyclerView this$0;
            
            RecyclerView$5() {
                this$0 = this$0;
                super();
            }
            
            @Override
            public void addView(final View view, final int n) {
                this$0.addView(view, n);
                this$0.dispatchChildAttached(view);
            }
            
            @Override
            public void attachViewToParent(final View view, final int n, final ViewGroup$LayoutParams viewGroup$LayoutParams) {
                final ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                if (childViewHolderInt != null) {
                    if (!childViewHolderInt.isTmpDetached() && !childViewHolderInt.shouldIgnore()) {
                        throw new IllegalArgumentException("Called attach on a child which is not detached: " + childViewHolderInt);
                    }
                    childViewHolderInt.clearTmpDetachFlag();
                }
                RecyclerView.access$1300(this$0, view, n, viewGroup$LayoutParams);
            }
            
            @Override
            public void detachViewFromParent(final int n) {
                final View child = this.getChildAt(n);
                if (child != null) {
                    final ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(child);
                    if (childViewHolderInt != null) {
                        if (childViewHolderInt.isTmpDetached() && !childViewHolderInt.shouldIgnore()) {
                            throw new IllegalArgumentException("called detach on an already detached child " + childViewHolderInt);
                        }
                        childViewHolderInt.addFlags(256);
                    }
                }
                RecyclerView.access$1400(this$0, n);
            }
            
            @Override
            public View getChildAt(final int n) {
                return this$0.getChildAt(n);
            }
            
            @Override
            public int getChildCount() {
                return this$0.getChildCount();
            }
            
            @Override
            public ViewHolder getChildViewHolder(final View view) {
                return RecyclerView.getChildViewHolderInt(view);
            }
            
            @Override
            public int indexOfChild(final View view) {
                return this$0.indexOfChild(view);
            }
            
            @Override
            public void onEnteredHiddenState(final View view) {
                final ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                if (childViewHolderInt != null) {
                    childViewHolderInt.onEnteredHiddenState();
                }
            }
            
            @Override
            public void onLeftHiddenState(final View view) {
                final ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                if (childViewHolderInt != null) {
                    childViewHolderInt.onLeftHiddenState();
                }
            }
            
            @Override
            public void removeAllViews() {
                for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
                    this$0.dispatchChildDetached(this.getChildAt(i));
                }
                this$0.removeAllViews();
            }
            
            @Override
            public void removeViewAt(final int n) {
                final View child = this$0.getChildAt(n);
                if (child != null) {
                    this$0.dispatchChildDetached(child);
                }
                this$0.removeViewAt(n);
            }
        });
    }
    
    private void jumpToPositionForSmoothScroller(final int n) {
        if (mLayout == null) {
            return;
        }
        mLayout.scrollToPosition(n);
        this.awakenScrollBars();
    }
    
    private void onEnterLayoutOrScroll() {
        ++mLayoutOrScrollCounter;
    }
    
    private void onExitLayoutOrScroll() {
        --mLayoutOrScrollCounter;
        if (mLayoutOrScrollCounter < 1) {
            mLayoutOrScrollCounter = 0;
            this.dispatchContentChangedIfNecessary();
        }
    }
    
    private void onPointerUp(final MotionEvent motionEvent) {
        final int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (MotionEventCompat.getPointerId(motionEvent, actionIndex) == mScrollPointerId) {
            int n;
            if (actionIndex == 0) {
                n = 1;
            }
            else {
                n = 0;
            }
            mScrollPointerId = MotionEventCompat.getPointerId(motionEvent, n);
            final int n2 = (int)(0.5f + MotionEventCompat.getX(motionEvent, n));
            mLastTouchX = n2;
            mInitialTouchX = n2;
            final int n3 = (int)(0.5f + MotionEventCompat.getY(motionEvent, n));
            mLastTouchY = n3;
            mInitialTouchY = n3;
        }
    }
    
    private void postAnimationRunner() {
        if (!mPostedAnimatorRunner && mIsAttached) {
            ViewCompat.postOnAnimation((View)this, mItemAnimatorRunner);
            mPostedAnimatorRunner = true;
        }
    }
    
    private boolean predictiveItemAnimationsEnabled() {
        return mItemAnimator != null && mLayout.supportsPredictiveItemAnimations();
    }
    
    private void processAdapterUpdatesAndSetAnimationFlags() {
        boolean b = true;
        if (mDataSetHasChangedAfterLayout) {
            mAdapterHelper.reset();
            this.markKnownViewsInvalid();
            mLayout.onItemsChanged(this);
        }
        if (this.predictiveItemAnimationsEnabled()) {
            mAdapterHelper.preProcess();
        }
        else {
            mAdapterHelper.consumeUpdatesInOnePass();
        }
        final boolean b2 = (mItemsAddedOrRemoved || mItemsChanged) && b;
        mState.mRunSimpleAnimations = (mFirstLayoutComplete && mItemAnimator != null && (mDataSetHasChangedAfterLayout || b2 || mLayout.mRequestedSimpleAnimations) && (!mDataSetHasChangedAfterLayout || mAdapter.hasStableIds()) && b);
        final State mState = this.mState;
        if (!this.mState.mRunSimpleAnimations || !b2 || mDataSetHasChangedAfterLayout || !this.predictiveItemAnimationsEnabled()) {
            b = false;
        }
        mState.mRunPredictiveAnimations = b;
    }
    
    private void pullGlows(final float n, final float n2, final float n3, final float n4) {
        boolean b;
        if (n2 < 0.0f) {
            this.ensureLeftGlow();
            final boolean onPull = mLeftGlow.onPull(-n2 / (float)this.getWidth(), 1.0f - n3 / this.getHeight());
            b = false;
            if (onPull) {
                b = true;
            }
        }
        else {
            final float n5 = fcmpl(n2, 0.0f);
            b = false;
            if (n5 > 0) {
                this.ensureRightGlow();
                final boolean onPull2 = mRightGlow.onPull(n2 / (float)this.getWidth(), n3 / (float)this.getHeight());
                b = false;
                if (onPull2) {
                    b = true;
                }
            }
        }
        if (n4 < 0.0f) {
            this.ensureTopGlow();
            if (mTopGlow.onPull(-n4 / (float)this.getHeight(), n / (float)this.getWidth())) {
                b = true;
            }
        }
        else if (n4 > 0.0f) {
            this.ensureBottomGlow();
            if (mBottomGlow.onPull(n4 / (float)this.getHeight(), 1.0f - n / this.getWidth())) {
                b = true;
            }
        }
        if (b || n2 != 0.0f || n4 != 0.0f) {
            ViewCompat.postInvalidateOnAnimation((View)this);
        }
    }
    
    private void recordAnimationInfoIfBouncedHiddenView(final ViewHolder viewHolder, final ItemHolderInfo itemHolderInfo) {
        viewHolder.setFlags(0, 8192);
        if (mState.mTrackOldChangeHolders && viewHolder.isUpdated() && !viewHolder.isRemoved() && !viewHolder.shouldIgnore()) {
            mViewInfoStore.addToOldChangeHolders(this.getChangedHolderKey(viewHolder), viewHolder);
        }
        mViewInfoStore.addToPreLayout(viewHolder, itemHolderInfo);
    }
    
    private void releaseGlows() {
        final EdgeEffectCompat mLeftGlow = this.mLeftGlow;
        boolean onRelease = false;
        if (mLeftGlow != null) {
            onRelease = this.mLeftGlow.onRelease();
        }
        if (mTopGlow != null) {
            onRelease |= mTopGlow.onRelease();
        }
        if (mRightGlow != null) {
            onRelease |= mRightGlow.onRelease();
        }
        if (mBottomGlow != null) {
            onRelease |= mBottomGlow.onRelease();
        }
        if (onRelease) {
            ViewCompat.postInvalidateOnAnimation((View)this);
        }
    }
    
    private boolean removeAnimatingView(final View view) {
        this.eatRequestLayout();
        final boolean removeViewIfHidden = mChildHelper.removeViewIfHidden(view);
        if (removeViewIfHidden) {
            final ViewHolder childViewHolderInt = getChildViewHolderInt(view);
            mRecycler.unscrapView(childViewHolderInt);
            mRecycler.recycleViewHolderInternal(childViewHolderInt);
        }
        this.resumeRequestLayout(!removeViewIfHidden);
        return removeViewIfHidden;
    }
    
    private void repositionShadowingViews() {
        for (int childCount = mChildHelper.getChildCount(), i = 0; i < childCount; ++i) {
            final View child = mChildHelper.getChildAt(i);
            final ViewHolder childViewHolder = this.getChildViewHolder(child);
            if (childViewHolder != null && childViewHolder.mShadowingHolder != null) {
                final View itemView = childViewHolder.mShadowingHolder.itemView;
                final int left = child.getLeft();
                final int top = child.getTop();
                if (left != itemView.getLeft() || top != itemView.getTop()) {
                    itemView.layout(left, top, left + itemView.getWidth(), top + itemView.getHeight());
                }
            }
        }
    }
    
    private void resetTouch() {
        if (mVelocityTracker != null) {
            mVelocityTracker.clear();
        }
        this.stopNestedScroll();
        this.releaseGlows();
    }
    
    private void setAdapterInternal(final Adapter mAdapter, final boolean b, final boolean b2) {
        if (this.mAdapter != null) {
            this.mAdapter.unregisterAdapterDataObserver(mObserver);
            this.mAdapter.onDetachedFromRecyclerView(this);
        }
        if (!b || b2) {
            if (mItemAnimator != null) {
                mItemAnimator.endAnimations();
            }
            if (mLayout != null) {
                mLayout.removeAndRecycleAllViews(mRecycler);
                mLayout.removeAndRecycleScrapInt(mRecycler);
            }
            mRecycler.clear();
        }
        mAdapterHelper.reset();
        final Adapter mAdapter2 = this.mAdapter;
        if ((this.mAdapter = mAdapter) != null) {
            mAdapter.registerAdapterDataObserver(mObserver);
            mAdapter.onAttachedToRecyclerView(this);
        }
        if (mLayout != null) {
            mLayout.onAdapterChanged(mAdapter2, this.mAdapter);
        }
        mRecycler.onAdapterChanged(mAdapter2, this.mAdapter, b);
        mState.mStructureChanged = true;
        this.markKnownViewsInvalid();
    }
    
    private void setDataSetChangedAfterLayout() {
        if (mDataSetHasChangedAfterLayout) {
            return;
        }
        mDataSetHasChangedAfterLayout = true;
        for (int unfilteredChildCount = mChildHelper.getUnfilteredChildCount(), i = 0; i < unfilteredChildCount; ++i) {
            final ViewHolder childViewHolderInt = getChildViewHolderInt(mChildHelper.getUnfilteredChildAt(i));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.addFlags(512);
            }
        }
        mRecycler.setAdapterPositionsAsUnknown();
    }
    
    private void setScrollState(final int mScrollState) {
        if (mScrollState == this.mScrollState) {
            return;
        }
        if ((this.mScrollState = mScrollState) != 2) {
            this.stopScrollersInternal();
        }
        this.dispatchOnScrollStateChanged(mScrollState);
    }
    
    private void stopScrollersInternal() {
        mViewFlinger.stop();
        if (mLayout != null) {
            mLayout.stopSmoothScroller();
        }
    }
    
    void absorbGlows(final int n, final int n2) {
        if (n < 0) {
            this.ensureLeftGlow();
            mLeftGlow.onAbsorb(-n);
        }
        else if (n > 0) {
            this.ensureRightGlow();
            mRightGlow.onAbsorb(n);
        }
        if (n2 < 0) {
            this.ensureTopGlow();
            mTopGlow.onAbsorb(-n2);
        }
        else if (n2 > 0) {
            this.ensureBottomGlow();
            mBottomGlow.onAbsorb(n2);
        }
        if (n != 0 || n2 != 0) {
            ViewCompat.postInvalidateOnAnimation((View)this);
        }
    }
    
    public void addFocusables(final ArrayList<View> list, final int n, final int n2) {
        if (mLayout == null || !mLayout.onAddFocusables(this, list, n, n2)) {
            super.addFocusables((ArrayList)list, n, n2);
        }
    }
    
    public void addItemDecoration(final ItemDecoration itemDecoration) {
        this.addItemDecoration(itemDecoration, -1);
    }
    
    public void addItemDecoration(final ItemDecoration itemDecoration, final int n) {
        if (mLayout != null) {
            mLayout.assertNotInLayoutOrScroll("Cannot add item decoration during a scroll  or layout");
        }
        if (mItemDecorations.isEmpty()) {
            this.setWillNotDraw(false);
        }
        if (n < 0) {
            mItemDecorations.add(itemDecoration);
        }
        else {
            mItemDecorations.add(n, itemDecoration);
        }
        this.markItemDecorInsetsDirty();
        this.requestLayout();
    }
    
    public void addOnChildAttachStateChangeListener(final OnChildAttachStateChangeListener onChildAttachStateChangeListener) {
        if (mOnChildAttachStateListeners == null) {
            mOnChildAttachStateListeners = new ArrayList<OnChildAttachStateChangeListener>();
        }
        mOnChildAttachStateListeners.add(onChildAttachStateChangeListener);
    }
    
    public void addOnItemTouchListener(final OnItemTouchListener onItemTouchListener) {
        mOnItemTouchListeners.add(onItemTouchListener);
    }
    
    public void addOnScrollListener(final OnScrollListener onScrollListener) {
        if (mScrollListeners == null) {
            mScrollListeners = new ArrayList<OnScrollListener>();
        }
        mScrollListeners.add(onScrollListener);
    }
    
    void assertInLayoutOrScroll(final String s) {
        if (this.isComputingLayout()) {
            return;
        }
        if (s == null) {
            throw new IllegalStateException("Cannot call this method unless RecyclerView is computing a layout or scrolling");
        }
        throw new IllegalStateException(s);
    }
    
    void assertNotInLayoutOrScroll(final String s) {
        if (!this.isComputingLayout()) {
            return;
        }
        if (s == null) {
            throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling");
        }
        throw new IllegalStateException(s);
    }
    
    protected boolean checkLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        return viewGroup$LayoutParams instanceof LayoutParams && mLayout.checkLayoutParams((LayoutParams)viewGroup$LayoutParams);
    }
    
    void clearOldPositions() {
        for (int unfilteredChildCount = mChildHelper.getUnfilteredChildCount(), i = 0; i < unfilteredChildCount; ++i) {
            final ViewHolder childViewHolderInt = getChildViewHolderInt(mChildHelper.getUnfilteredChildAt(i));
            if (!childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.clearOldPosition();
            }
        }
        mRecycler.clearOldPositions();
    }
    
    public void clearOnChildAttachStateChangeListeners() {
        if (mOnChildAttachStateListeners != null) {
            mOnChildAttachStateListeners.clear();
        }
    }
    
    public void clearOnScrollListeners() {
        if (mScrollListeners != null) {
            mScrollListeners.clear();
        }
    }
    
    public int computeHorizontalScrollExtent() {
        if (mLayout != null && mLayout.canScrollHorizontally()) {
            return mLayout.computeHorizontalScrollExtent(mState);
        }
        return 0;
    }
    
    public int computeHorizontalScrollOffset() {
        if (mLayout != null && mLayout.canScrollHorizontally()) {
            return mLayout.computeHorizontalScrollOffset(mState);
        }
        return 0;
    }
    
    public int computeHorizontalScrollRange() {
        if (mLayout != null && mLayout.canScrollHorizontally()) {
            return mLayout.computeHorizontalScrollRange(mState);
        }
        return 0;
    }
    
    public int computeVerticalScrollExtent() {
        if (mLayout != null && mLayout.canScrollVertically()) {
            return mLayout.computeVerticalScrollExtent(mState);
        }
        return 0;
    }
    
    public int computeVerticalScrollOffset() {
        if (mLayout != null && mLayout.canScrollVertically()) {
            return mLayout.computeVerticalScrollOffset(mState);
        }
        return 0;
    }
    
    public int computeVerticalScrollRange() {
        if (mLayout != null && mLayout.canScrollVertically()) {
            return mLayout.computeVerticalScrollRange(mState);
        }
        return 0;
    }
    
    void defaultOnMeasure(final int n, final int n2) {
        this.setMeasuredDimension(LayoutManager.chooseSize(n, this.getPaddingLeft() + this.getPaddingRight(), ViewCompat.getMinimumWidth((View)this)), LayoutManager.chooseSize(n2, this.getPaddingTop() + this.getPaddingBottom(), ViewCompat.getMinimumHeight((View)this)));
    }
    
    void dispatchLayout() {
        if (mAdapter == null) {
            Log.e("RecyclerView", "No adapter attached; skipping layout");
            return;
        }
        if (mLayout == null) {
            Log.e("RecyclerView", "No layout manager attached; skipping layout");
            return;
        }
        mState.mIsMeasuring = false;
        if (mState.mLayoutStep == 1) {
            this.dispatchLayoutStep1();
            mLayout.setExactMeasureSpecsFrom(this);
            this.dispatchLayoutStep2();
        }
        else if (mAdapterHelper.hasUpdates() || mLayout.getWidth() != this.getWidth() || mLayout.getHeight() != this.getHeight()) {
            mLayout.setExactMeasureSpecsFrom(this);
            this.dispatchLayoutStep2();
        }
        else {
            mLayout.setExactMeasureSpecsFrom(this);
        }
        this.dispatchLayoutStep3();
    }
    
    public boolean dispatchNestedFling(final float n, final float n2, final boolean b) {
        return mScrollingChildHelper.dispatchNestedFling(n, n2, b);
    }
    
    public boolean dispatchNestedPreFling(final float n, final float n2) {
        return mScrollingChildHelper.dispatchNestedPreFling(n, n2);
    }
    
    public boolean dispatchNestedPreScroll(final int n, final int n2, final int[] array, final int[] array2) {
        return mScrollingChildHelper.dispatchNestedPreScroll(n, n2, array, array2);
    }
    
    public boolean dispatchNestedScroll(final int n, final int n2, final int n3, final int n4, final int[] array) {
        return mScrollingChildHelper.dispatchNestedScroll(n, n2, n3, n4, array);
    }
    
    void dispatchOnScrollStateChanged(final int n) {
        if (mLayout != null) {
            mLayout.onScrollStateChanged(n);
        }
        this.onScrollStateChanged(n);
        if (mScrollListener != null) {
            mScrollListener.onScrollStateChanged(this, n);
        }
        if (mScrollListeners != null) {
            for (int i = -1 + mScrollListeners.size(); i >= 0; --i) {
                ((OnScrollListener)mScrollListeners.get(i)).onScrollStateChanged(this, n);
            }
        }
    }
    
    void dispatchOnScrolled(final int n, final int n2) {
        final int scrollX = this.getScrollX();
        final int scrollY = this.getScrollY();
        this.onScrollChanged(scrollX, scrollY, scrollX, scrollY);
        this.onScrolled(n, n2);
        if (mScrollListener != null) {
            mScrollListener.onScrolled(this, n, n2);
        }
        if (mScrollListeners != null) {
            for (int i = -1 + mScrollListeners.size(); i >= 0; --i) {
                ((OnScrollListener)mScrollListeners.get(i)).onScrolled(this, n, n2);
            }
        }
    }
    
    protected void dispatchRestoreInstanceState(final SparseArray<Parcelable> sparseArray) {
        this.dispatchThawSelfOnly((SparseArray)sparseArray);
    }
    
    protected void dispatchSaveInstanceState(final SparseArray<Parcelable> sparseArray) {
        this.dispatchFreezeSelfOnly((SparseArray)sparseArray);
    }
    
    public void draw(final Canvas canvas) {
        int n = 1;
        super.draw(canvas);
        for (int size = mItemDecorations.size(), i = 0; i < size; ++i) {
            ((ItemDecoration)mItemDecorations.get(i)).onDrawOver(canvas, this, mState);
        }
        final EdgeEffectCompat mLeftGlow = this.mLeftGlow;
        int n2 = 0;
        if (mLeftGlow != null) {
            final boolean finished = this.mLeftGlow.isFinished();
            n2 = 0;
            if (!finished) {
                final int save = canvas.save();
                int paddingBottom;
                if (mClipToPadding) {
                    paddingBottom = this.getPaddingBottom();
                }
                else {
                    paddingBottom = 0;
                }
                canvas.rotate(270.0f);
                canvas.translate((float)(paddingBottom + -this.getHeight()), 0.0f);
                if (this.mLeftGlow != null && this.mLeftGlow.draw(canvas)) {
                    n2 = n;
                }
                else {
                    n2 = 0;
                }
                canvas.restoreToCount(save);
            }
        }
        if (mTopGlow != null && !mTopGlow.isFinished()) {
            final int save2 = canvas.save();
            if (mClipToPadding) {
                canvas.translate((float)this.getPaddingLeft(), (float)this.getPaddingTop());
            }
            int n3;
            if (mTopGlow != null && mTopGlow.draw(canvas)) {
                n3 = n;
            }
            else {
                n3 = 0;
            }
            n2 |= n3;
            canvas.restoreToCount(save2);
        }
        if (mRightGlow != null && !mRightGlow.isFinished()) {
            final int save3 = canvas.save();
            final int width = this.getWidth();
            int paddingTop;
            if (mClipToPadding) {
                paddingTop = this.getPaddingTop();
            }
            else {
                paddingTop = 0;
            }
            canvas.rotate(90.0f);
            canvas.translate((float)(-paddingTop), (float)(-width));
            int n4;
            if (mRightGlow != null && mRightGlow.draw(canvas)) {
                n4 = n;
            }
            else {
                n4 = 0;
            }
            n2 |= n4;
            canvas.restoreToCount(save3);
        }
        if (mBottomGlow != null && !mBottomGlow.isFinished()) {
            final int save4 = canvas.save();
            canvas.rotate(180.0f);
            if (mClipToPadding) {
                canvas.translate((float)(-this.getWidth() + this.getPaddingRight()), (float)(-this.getHeight() + this.getPaddingBottom()));
            }
            else {
                canvas.translate((float)(-this.getWidth()), (float)(-this.getHeight()));
            }
            if (mBottomGlow == null || !mBottomGlow.draw(canvas)) {
                n = 0;
            }
            n2 |= n;
            canvas.restoreToCount(save4);
        }
        if (n2 == 0 && mItemAnimator != null && mItemDecorations.size() > 0 && mItemAnimator.isRunning()) {
            n2 = 1;
        }
        if (n2 != 0) {
            ViewCompat.postInvalidateOnAnimation((View)this);
        }
    }
    
    public boolean drawChild(final Canvas canvas, final View view, final long n) {
        return super.drawChild(canvas, view, n);
    }
    
    void eatRequestLayout() {
        ++mEatRequestLayout;
        if (mEatRequestLayout == 1 && !mLayoutFrozen) {
            mLayoutRequestEaten = false;
        }
    }
    
    void ensureBottomGlow() {
        if (mBottomGlow != null) {
            return;
        }
        mBottomGlow = new EdgeEffectCompat(this.getContext());
        if (mClipToPadding) {
            mBottomGlow.setSize(this.getMeasuredWidth() - this.getPaddingLeft() - this.getPaddingRight(), this.getMeasuredHeight() - this.getPaddingTop() - this.getPaddingBottom());
            return;
        }
        mBottomGlow.setSize(this.getMeasuredWidth(), this.getMeasuredHeight());
    }
    
    void ensureLeftGlow() {
        if (mLeftGlow != null) {
            return;
        }
        mLeftGlow = new EdgeEffectCompat(this.getContext());
        if (mClipToPadding) {
            mLeftGlow.setSize(this.getMeasuredHeight() - this.getPaddingTop() - this.getPaddingBottom(), this.getMeasuredWidth() - this.getPaddingLeft() - this.getPaddingRight());
            return;
        }
        mLeftGlow.setSize(this.getMeasuredHeight(), this.getMeasuredWidth());
    }
    
    void ensureRightGlow() {
        if (mRightGlow != null) {
            return;
        }
        mRightGlow = new EdgeEffectCompat(this.getContext());
        if (mClipToPadding) {
            mRightGlow.setSize(this.getMeasuredHeight() - this.getPaddingTop() - this.getPaddingBottom(), this.getMeasuredWidth() - this.getPaddingLeft() - this.getPaddingRight());
            return;
        }
        mRightGlow.setSize(this.getMeasuredHeight(), this.getMeasuredWidth());
    }
    
    void ensureTopGlow() {
        if (mTopGlow != null) {
            return;
        }
        mTopGlow = new EdgeEffectCompat(this.getContext());
        if (mClipToPadding) {
            mTopGlow.setSize(this.getMeasuredWidth() - this.getPaddingLeft() - this.getPaddingRight(), this.getMeasuredHeight() - this.getPaddingTop() - this.getPaddingBottom());
            return;
        }
        mTopGlow.setSize(this.getMeasuredWidth(), this.getMeasuredHeight());
    }
    
    public View findChildViewUnder(final float n, final float n2) {
        for (int i = -1 + mChildHelper.getChildCount(); i >= 0; --i) {
            final View child = mChildHelper.getChildAt(i);
            final float translationX = ViewCompat.getTranslationX(child);
            final float translationY = ViewCompat.getTranslationY(child);
            if (n >= translationX + child.getLeft() && n <= translationX + child.getRight() && n2 >= translationY + child.getTop() && n2 <= translationY + child.getBottom()) {
                return child;
            }
        }
        return null;
    }
    
    @Nullable
    public View findContainingItemView(View view) {
        ViewParent viewParent;
        for (viewParent = view.getParent(); viewParent != null && viewParent != this && viewParent instanceof View; viewParent = view.getParent()) {
            view = (View)viewParent;
        }
        if (viewParent == this) {
            return view;
        }
        return null;
    }
    
    @Nullable
    public ViewHolder findContainingViewHolder(final View view) {
        final View containingItemView = this.findContainingItemView(view);
        if (containingItemView == null) {
            return null;
        }
        return this.getChildViewHolder(containingItemView);
    }
    
    public ViewHolder findViewHolderForAdapterPosition(final int n) {
        if (!mDataSetHasChangedAfterLayout) {
            for (int unfilteredChildCount = mChildHelper.getUnfilteredChildCount(), i = 0; i < unfilteredChildCount; ++i) {
                final ViewHolder childViewHolderInt = getChildViewHolderInt(mChildHelper.getUnfilteredChildAt(i));
                if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && this.getAdapterPositionFor(childViewHolderInt) == n) {
                    return childViewHolderInt;
                }
            }
            return null;
        }
        return null;
    }
    
    public ViewHolder findViewHolderForItemId(final long n) {
        for (int unfilteredChildCount = mChildHelper.getUnfilteredChildCount(), i = 0; i < unfilteredChildCount; ++i) {
            final ViewHolder childViewHolderInt = getChildViewHolderInt(mChildHelper.getUnfilteredChildAt(i));
            if (childViewHolderInt != null && childViewHolderInt.getItemId() == n) {
                return childViewHolderInt;
            }
        }
        return null;
    }
    
    public ViewHolder findViewHolderForLayoutPosition(final int n) {
        return this.findViewHolderForPosition(n, false);
    }
    
    @Deprecated
    public ViewHolder findViewHolderForPosition(final int n) {
        return this.findViewHolderForPosition(n, false);
    }
    
    ViewHolder findViewHolderForPosition(final int n, final boolean b) {
        for (int unfilteredChildCount = mChildHelper.getUnfilteredChildCount(), i = 0; i < unfilteredChildCount; ++i) {
            final ViewHolder childViewHolderInt = getChildViewHolderInt(mChildHelper.getUnfilteredChildAt(i));
            if (childViewHolderInt != null && !childViewHolderInt.isRemoved()) {
                if (b) {
                    if (childViewHolderInt.mPosition != n) {
                        continue;
                    }
                }
                else if (childViewHolderInt.getLayoutPosition() != n) {
                    continue;
                }
                return childViewHolderInt;
            }
        }
        return null;
    }
    
    public boolean fling(int n, int n2) {
        if (mLayout == null) {
            Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        }
        else if (!mLayoutFrozen) {
            final boolean canScrollHorizontally = mLayout.canScrollHorizontally();
            final boolean canScrollVertically = mLayout.canScrollVertically();
            if (!canScrollHorizontally || Math.abs(n) < mMinFlingVelocity) {
                n = 0;
            }
            if (!canScrollVertically || Math.abs(n2) < mMinFlingVelocity) {
                n2 = 0;
            }
            if ((n != 0 || n2 != 0) && !this.dispatchNestedPreFling(n, n2)) {
                final boolean b = canScrollHorizontally || canScrollVertically;
                this.dispatchNestedFling(n, n2, b);
                if (b) {
                    mViewFlinger.fling(Math.max(-mMaxFlingVelocity, Math.min(n, mMaxFlingVelocity)), Math.max(-mMaxFlingVelocity, Math.min(n2, mMaxFlingVelocity)));
                    return true;
                }
            }
        }
        return false;
    }
    
    public View focusSearch(final View view, final int n) {
        final View onInterceptFocusSearch = mLayout.onInterceptFocusSearch(view, n);
        if (onInterceptFocusSearch != null) {
            return onInterceptFocusSearch;
        }
        View view2 = FocusFinder.getInstance().findNextFocus((ViewGroup)this, view, n);
        if (view2 == null && mAdapter != null && mLayout != null && !this.isComputingLayout() && !mLayoutFrozen) {
            this.eatRequestLayout();
            view2 = mLayout.onFocusSearchFailed(view, n, mRecycler, mState);
            this.resumeRequestLayout(false);
        }
        if (view2 != null) {
            return view2;
        }
        return super.focusSearch(view, n);
    }
    
    protected ViewGroup$LayoutParams generateDefaultLayoutParams() {
        if (mLayout == null) {
            throw new IllegalStateException("RecyclerView has no LayoutManager");
        }
        return (ViewGroup$LayoutParams)mLayout.generateDefaultLayoutParams();
    }
    
    public ViewGroup$LayoutParams generateLayoutParams(final AttributeSet set) {
        if (mLayout == null) {
            throw new IllegalStateException("RecyclerView has no LayoutManager");
        }
        return (ViewGroup$LayoutParams)mLayout.generateLayoutParams(this.getContext(), set);
    }
    
    protected ViewGroup$LayoutParams generateLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        if (mLayout == null) {
            throw new IllegalStateException("RecyclerView has no LayoutManager");
        }
        return (ViewGroup$LayoutParams)mLayout.generateLayoutParams(viewGroup$LayoutParams);
    }
    
    public Adapter getAdapter() {
        return mAdapter;
    }
    
    public int getBaseline() {
        if (mLayout != null) {
            return mLayout.getBaseline();
        }
        return super.getBaseline();
    }
    
    long getChangedHolderKey(final ViewHolder viewHolder) {
        if (mAdapter.hasStableIds()) {
            return viewHolder.getItemId();
        }
        return viewHolder.mPosition;
    }
    
    public int getChildAdapterPosition(final View view) {
        final ViewHolder childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            return childViewHolderInt.getAdapterPosition();
        }
        return -1;
    }
    
    protected int getChildDrawingOrder(final int n, final int n2) {
        if (mChildDrawingOrderCallback == null) {
            return super.getChildDrawingOrder(n, n2);
        }
        return mChildDrawingOrderCallback.onGetChildDrawingOrder(n, n2);
    }
    
    public long getChildItemId(final View view) {
        if (mAdapter != null && mAdapter.hasStableIds()) {
            final ViewHolder childViewHolderInt = getChildViewHolderInt(view);
            if (childViewHolderInt != null) {
                return childViewHolderInt.getItemId();
            }
        }
        return -1L;
    }
    
    public int getChildLayoutPosition(final View view) {
        final ViewHolder childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            return childViewHolderInt.getLayoutPosition();
        }
        return -1;
    }
    
    @Deprecated
    public int getChildPosition(final View view) {
        return this.getChildAdapterPosition(view);
    }
    
    public ViewHolder getChildViewHolder(final View view) {
        final ViewParent parent = view.getParent();
        if (parent != null && parent != this) {
            throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
        }
        return getChildViewHolderInt(view);
    }
    
    public RecyclerViewAccessibilityDelegate getCompatAccessibilityDelegate() {
        return mAccessibilityDelegate;
    }
    
    public ItemAnimator getItemAnimator() {
        return mItemAnimator;
    }
    
    Rect getItemDecorInsetsForChild(final View view) {
        final LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        if (!layoutParams.mInsetsDirty) {
            return layoutParams.mDecorInsets;
        }
        final Rect mDecorInsets = layoutParams.mDecorInsets;
        mDecorInsets.set(0, 0, 0, 0);
        for (int size = mItemDecorations.size(), i = 0; i < size; ++i) {
            mTempRect.set(0, 0, 0, 0);
            ((ItemDecoration)mItemDecorations.get(i)).getItemOffsets(mTempRect, view, this, mState);
            mDecorInsets.left += mTempRect.left;
            mDecorInsets.top += mTempRect.top;
            mDecorInsets.right += mTempRect.right;
            mDecorInsets.bottom += mTempRect.bottom;
        }
        layoutParams.mInsetsDirty = false;
        return mDecorInsets;
    }
    
    public LayoutManager getLayoutManager() {
        return mLayout;
    }
    
    public int getMaxFlingVelocity() {
        return mMaxFlingVelocity;
    }
    
    public int getMinFlingVelocity() {
        return mMinFlingVelocity;
    }
    
    public RecycledViewPool getRecycledViewPool() {
        return mRecycler.getRecycledViewPool();
    }
    
    public int getScrollState() {
        return mScrollState;
    }
    
    public boolean hasFixedSize() {
        return mHasFixedSize;
    }
    
    public boolean hasNestedScrollingParent() {
        return mScrollingChildHelper.hasNestedScrollingParent();
    }
    
    public boolean hasPendingAdapterUpdates() {
        return !mFirstLayoutComplete || mDataSetHasChangedAfterLayout || mAdapterHelper.hasPendingUpdates();
    }
    
    void initAdapterManager() {
        mAdapterHelper = new AdapterHelper((AdapterHelper.Callback)new AdapterHelper.Callback() {
            final /* synthetic */ RecyclerView this$0;
            
            RecyclerView$6() {
                this$0 = this$0;
                super();
            }
            
            void dispatchUpdate(final UpdateOp updateOp) {
                switch (updateOp.cmd) {
                    default:
                    case 1:
                        mLayout.onItemsAdded(this$0, updateOp.positionStart, updateOp.itemCount);
                    case 2:
                        mLayout.onItemsRemoved(this$0, updateOp.positionStart, updateOp.itemCount);
                    case 4:
                        mLayout.onItemsUpdated(this$0, updateOp.positionStart, updateOp.itemCount, updateOp.payload);
                    case 8:
                        mLayout.onItemsMoved(this$0, updateOp.positionStart, updateOp.itemCount, 1);
                }
            }
            
            @Override
            public ViewHolder findViewHolder(final int n) {
                Object viewHolderForPosition = this$0.findViewHolderForPosition(n, true);
                if (viewHolderForPosition == null) {
                    viewHolderForPosition = null;
                }
                else if (mChildHelper.isHidden(((ViewHolder)viewHolderForPosition).itemView)) {
                    return null;
                }
                return (ViewHolder)viewHolderForPosition;
            }
            
            @Override
            public void markViewHoldersUpdated(final int n, final int n2, final Object o) {
                this$0.viewRangeUpdate(n, n2, o);
                mItemsChanged = true;
            }
            
            @Override
            public void offsetPositionsForAdd(final int n, final int n2) {
                this$0.offsetPositionRecordsForInsert(n, n2);
                mItemsAddedOrRemoved = true;
            }
            
            @Override
            public void offsetPositionsForMove(final int n, final int n2) {
                this$0.offsetPositionRecordsForMove(n, n2);
                mItemsAddedOrRemoved = true;
            }
            
            @Override
            public void offsetPositionsForRemovingInvisible(final int n, final int n2) {
                this$0.offsetPositionRecordsForRemove(n, n2, true);
                mItemsAddedOrRemoved = true;
                mState.mDeletedInvisibleItemCountSincePreviousLayout += n2;
            }
            
            @Override
            public void offsetPositionsForRemovingLaidOutOrNewView(final int n, final int n2) {
                this$0.offsetPositionRecordsForRemove(n, n2, false);
                mItemsAddedOrRemoved = true;
            }
            
            @Override
            public void onDispatchFirstPass(final UpdateOp updateOp) {
                this.dispatchUpdate(updateOp);
            }
            
            @Override
            public void onDispatchSecondPass(final UpdateOp updateOp) {
                this.dispatchUpdate(updateOp);
            }
        });
    }
    
    void invalidateGlows() {
        mBottomGlow = null;
        mTopGlow = null;
        mRightGlow = null;
        mLeftGlow = null;
    }
    
    public void invalidateItemDecorations() {
        if (mItemDecorations.size() == 0) {
            return;
        }
        if (mLayout != null) {
            mLayout.assertNotInLayoutOrScroll("Cannot invalidate item decorations during a scroll or layout");
        }
        this.markItemDecorInsetsDirty();
        this.requestLayout();
    }
    
    boolean isAccessibilityEnabled() {
        return mAccessibilityManager != null && mAccessibilityManager.isEnabled();
    }
    
    public boolean isAnimating() {
        return mItemAnimator != null && mItemAnimator.isRunning();
    }
    
    public boolean isAttachedToWindow() {
        return mIsAttached;
    }
    
    public boolean isComputingLayout() {
        return mLayoutOrScrollCounter > 0;
    }
    
    public boolean isLayoutFrozen() {
        return mLayoutFrozen;
    }
    
    public boolean isNestedScrollingEnabled() {
        return mScrollingChildHelper.isNestedScrollingEnabled();
    }
    
    void markItemDecorInsetsDirty() {
        for (int unfilteredChildCount = mChildHelper.getUnfilteredChildCount(), i = 0; i < unfilteredChildCount; ++i) {
            ((LayoutParams)mChildHelper.getUnfilteredChildAt(i).getLayoutParams()).mInsetsDirty = true;
        }
        mRecycler.markItemDecorInsetsDirty();
    }
    
    void markKnownViewsInvalid() {
        for (int unfilteredChildCount = mChildHelper.getUnfilteredChildCount(), i = 0; i < unfilteredChildCount; ++i) {
            final ViewHolder childViewHolderInt = getChildViewHolderInt(mChildHelper.getUnfilteredChildAt(i));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.addFlags(6);
            }
        }
        this.markItemDecorInsetsDirty();
        mRecycler.markKnownViewsInvalid();
    }
    
    public void offsetChildrenHorizontal(final int n) {
        for (int childCount = mChildHelper.getChildCount(), i = 0; i < childCount; ++i) {
            mChildHelper.getChildAt(i).offsetLeftAndRight(n);
        }
    }
    
    public void offsetChildrenVertical(final int n) {
        for (int childCount = mChildHelper.getChildCount(), i = 0; i < childCount; ++i) {
            mChildHelper.getChildAt(i).offsetTopAndBottom(n);
        }
    }
    
    void offsetPositionRecordsForInsert(final int n, final int n2) {
        for (int unfilteredChildCount = mChildHelper.getUnfilteredChildCount(), i = 0; i < unfilteredChildCount; ++i) {
            final ViewHolder childViewHolderInt = getChildViewHolderInt(mChildHelper.getUnfilteredChildAt(i));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.mPosition >= n) {
                childViewHolderInt.offsetPosition(n2, false);
                mState.mStructureChanged = true;
            }
        }
        mRecycler.offsetPositionRecordsForInsert(n, n2);
        this.requestLayout();
    }
    
    void offsetPositionRecordsForMove(final int n, final int n2) {
        final int unfilteredChildCount = mChildHelper.getUnfilteredChildCount();
        int n3;
        int n4;
        int n5;
        if (n < n2) {
            n3 = n;
            n4 = n2;
            n5 = -1;
        }
        else {
            n3 = n2;
            n4 = n;
            n5 = 1;
        }
        for (int i = 0; i < unfilteredChildCount; ++i) {
            final ViewHolder childViewHolderInt = getChildViewHolderInt(mChildHelper.getUnfilteredChildAt(i));
            if (childViewHolderInt != null && childViewHolderInt.mPosition >= n3 && childViewHolderInt.mPosition <= n4) {
                if (childViewHolderInt.mPosition == n) {
                    childViewHolderInt.offsetPosition(n2 - n, false);
                }
                else {
                    childViewHolderInt.offsetPosition(n5, false);
                }
                mState.mStructureChanged = true;
            }
        }
        mRecycler.offsetPositionRecordsForMove(n, n2);
        this.requestLayout();
    }
    
    void offsetPositionRecordsForRemove(final int n, final int n2, final boolean b) {
        final int n3 = n + n2;
        for (int unfilteredChildCount = mChildHelper.getUnfilteredChildCount(), i = 0; i < unfilteredChildCount; ++i) {
            final ViewHolder childViewHolderInt = getChildViewHolderInt(mChildHelper.getUnfilteredChildAt(i));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                if (childViewHolderInt.mPosition >= n3) {
                    childViewHolderInt.offsetPosition(-n2, b);
                    mState.mStructureChanged = true;
                }
                else if (childViewHolderInt.mPosition >= n) {
                    childViewHolderInt.flagRemovedAndOffsetPosition(n - 1, -n2, b);
                    mState.mStructureChanged = true;
                }
            }
        }
        mRecycler.offsetPositionRecordsForRemove(n, n2, b);
        this.requestLayout();
    }
    
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        mLayoutOrScrollCounter = 0;
        mIsAttached = true;
        mFirstLayoutComplete = false;
        if (mLayout != null) {
            mLayout.dispatchAttachedToWindow(this);
        }
        mPostedAnimatorRunner = false;
    }
    
    public void onChildAttachedToWindow(final View view) {
    }
    
    public void onChildDetachedFromWindow(final View view) {
    }
    
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (mItemAnimator != null) {
            mItemAnimator.endAnimations();
        }
        mFirstLayoutComplete = false;
        this.stopScroll();
        mIsAttached = false;
        if (mLayout != null) {
            mLayout.dispatchDetachedFromWindow(this, mRecycler);
        }
        this.removeCallbacks(mItemAnimatorRunner);
        mViewInfoStore.onDetach();
    }
    
    public void onDraw(final Canvas canvas) {
        super.onDraw(canvas);
        for (int size = mItemDecorations.size(), i = 0; i < size; ++i) {
            ((ItemDecoration)mItemDecorations.get(i)).onDraw(canvas, this, mState);
        }
    }
    
    public boolean onGenericMotionEvent(final MotionEvent motionEvent) {
        if (mLayout != null && !mLayoutFrozen && (0x2 & MotionEventCompat.getSource(motionEvent)) != 0x0 && motionEvent.getAction() == 8) {
            float n;
            if (mLayout.canScrollVertically()) {
                n = -MotionEventCompat.getAxisValue(motionEvent, 9);
            }
            else {
                n = 0.0f;
            }
            float axisValue;
            if (mLayout.canScrollHorizontally()) {
                axisValue = MotionEventCompat.getAxisValue(motionEvent, 10);
            }
            else {
                axisValue = 0.0f;
            }
            if (n != 0.0f || axisValue != 0.0f) {
                final float scrollFactor = this.getScrollFactor();
                this.scrollByInternal((int)(axisValue * scrollFactor), (int)(n * scrollFactor), motionEvent);
                return false;
            }
        }
        return false;
    }
    
    public boolean onInterceptTouchEvent(final MotionEvent motionEvent) {
        if (mLayoutFrozen) {
            return false;
        }
        if (this.dispatchOnItemTouchIntercept(motionEvent)) {
            this.cancelTouch();
            return true;
        }
        if (mLayout == null) {
            return false;
        }
        final boolean canScrollHorizontally = mLayout.canScrollHorizontally();
        final boolean canScrollVertically = mLayout.canScrollVertically();
        if (mVelocityTracker == null) {
            mVelocityTracker = VelocityTracker.obtain();
        }
        mVelocityTracker.addMovement(motionEvent);
        final int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        final int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        switch (actionMasked) {
            case 0: {
                if (mIgnoreMotionEventTillDown) {
                    mIgnoreMotionEventTillDown = false;
                }
                mScrollPointerId = MotionEventCompat.getPointerId(motionEvent, 0);
                final int n = (int)(0.5f + motionEvent.getX());
                mLastTouchX = n;
                mInitialTouchX = n;
                final int n2 = (int)(0.5f + motionEvent.getY());
                mLastTouchY = n2;
                mInitialTouchY = n2;
                if (mScrollState == 2) {
                    this.getParent().requestDisallowInterceptTouchEvent(true);
                    this.setScrollState(1);
                }
                mNestedOffsets[mNestedOffsets[1] = 0] = 0;
                int n3 = 0;
                if (canScrollHorizontally) {
                    n3 = ((false | true) ? 1 : 0);
                }
                if (canScrollVertically) {
                    n3 |= 0x2;
                }
                this.startNestedScroll(n3);
                break;
            }
            case 5: {
                mScrollPointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                final int n4 = (int)(0.5f + MotionEventCompat.getX(motionEvent, actionIndex));
                mLastTouchX = n4;
                mInitialTouchX = n4;
                final int n5 = (int)(0.5f + MotionEventCompat.getY(motionEvent, actionIndex));
                mLastTouchY = n5;
                mInitialTouchY = n5;
                break;
            }
            case 2: {
                final int pointerIndex = MotionEventCompat.findPointerIndex(motionEvent, mScrollPointerId);
                if (pointerIndex < 0) {
                    Log.e("RecyclerView", "Error processing scroll; pointer index for id " + mScrollPointerId + " not found. Did any MotionEvents get skipped?");
                    return false;
                }
                final int n6 = (int)(0.5f + MotionEventCompat.getX(motionEvent, pointerIndex));
                final int n7 = (int)(0.5f + MotionEventCompat.getY(motionEvent, pointerIndex));
                if (mScrollState == 1) {
                    break;
                }
                final int n8 = n6 - mInitialTouchX;
                final int n9 = n7 - mInitialTouchY;
                boolean b = false;
                if (canScrollHorizontally) {
                    final int abs = Math.abs(n8);
                    final int mTouchSlop = this.mTouchSlop;
                    b = false;
                    if (abs > mTouchSlop) {
                        final int mInitialTouchX = this.mInitialTouchX;
                        final int mTouchSlop2 = this.mTouchSlop;
                        int n10;
                        if (n8 < 0) {
                            n10 = -1;
                        }
                        else {
                            n10 = 1;
                        }
                        mLastTouchX = mInitialTouchX + n10 * mTouchSlop2;
                        b = true;
                    }
                }
                if (canScrollVertically && Math.abs(n9) > mTouchSlop) {
                    final int mInitialTouchY = this.mInitialTouchY;
                    final int mTouchSlop3 = mTouchSlop;
                    int n11;
                    if (n9 < 0) {
                        n11 = -1;
                    }
                    else {
                        n11 = 1;
                    }
                    mLastTouchY = mInitialTouchY + n11 * mTouchSlop3;
                    b = true;
                }
                if (b) {
                    this.setScrollState(1);
                    break;
                }
                break;
            }
            case 6:
                this.onPointerUp(motionEvent);
                break;
            case 1:
                mVelocityTracker.clear();
                this.stopNestedScroll();
                break;
            case 3:
                this.cancelTouch();
                break;
        }
        return mScrollState == 1;
    }
    
    protected void onLayout(final boolean b, final int n, final int n2, final int n3, final int n4) {
        TraceCompat.beginSection("RV OnLayout");
        this.dispatchLayout();
        TraceCompat.endSection();
        mFirstLayoutComplete = true;
    }
    
    protected void onMeasure(final int n, final int n2) {
        if (mLayout == null) {
            this.defaultOnMeasure(n, n2);
        }
        else if (mLayout.mAutoMeasure) {
            final int mode = View$MeasureSpec.getMode(n);
            final int mode2 = View$MeasureSpec.getMode(n2);
            boolean b = false;
            if (mode == 1073741824) {
                b = false;
                if (mode2 == 1073741824) {
                    b = true;
                }
            }
            mLayout.onMeasure(mRecycler, mState, n, n2);
            if (!b && mAdapter != null) {
                if (mState.mLayoutStep == 1) {
                    this.dispatchLayoutStep1();
                }
                mLayout.setMeasureSpecs(n, n2);
                mState.mIsMeasuring = true;
                this.dispatchLayoutStep2();
                mLayout.setMeasuredDimensionFromChildren(n, n2);
                if (mLayout.shouldMeasureTwice()) {
                    mLayout.setMeasureSpecs(View$MeasureSpec.makeMeasureSpec(this.getMeasuredWidth(), 1073741824), View$MeasureSpec.makeMeasureSpec(this.getMeasuredHeight(), 1073741824));
                    mState.mIsMeasuring = true;
                    this.dispatchLayoutStep2();
                    mLayout.setMeasuredDimensionFromChildren(n, n2);
                }
            }
        }
        else {
            if (mHasFixedSize) {
                mLayout.onMeasure(mRecycler, mState, n, n2);
                return;
            }
            if (mAdapterUpdateDuringMeasure) {
                this.eatRequestLayout();
                this.processAdapterUpdatesAndSetAnimationFlags();
                if (mState.mRunPredictiveAnimations) {
                    mState.mInPreLayout = true;
                }
                else {
                    mAdapterHelper.consumeUpdatesInOnePass();
                    mState.mInPreLayout = false;
                }
                this.resumeRequestLayout(mAdapterUpdateDuringMeasure = false);
            }
            if (mAdapter != null) {
                mState.mItemCount = mAdapter.getItemCount();
            }
            else {
                mState.mItemCount = 0;
            }
            this.eatRequestLayout();
            mLayout.onMeasure(mRecycler, mState, n, n2);
            this.resumeRequestLayout(false);
            mState.mInPreLayout = false;
        }
    }
    
    protected void onRestoreInstanceState(final Parcelable parcelable) {
        mPendingSavedState = (SavedState)parcelable;
        super.onRestoreInstanceState(mPendingSavedState.getSuperState());
        if (mLayout != null && mPendingSavedState.mLayoutState != null) {
            mLayout.onRestoreInstanceState(mPendingSavedState.mLayoutState);
        }
    }
    
    protected Parcelable onSaveInstanceState() {
        final SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (mPendingSavedState != null) {
            savedState.copyFrom(mPendingSavedState);
            return (Parcelable)savedState;
        }
        if (mLayout != null) {
            savedState.mLayoutState = mLayout.onSaveInstanceState();
            return (Parcelable)savedState;
        }
        savedState.mLayoutState = null;
        return (Parcelable)savedState;
    }
    
    public void onScrollStateChanged(final int n) {
    }
    
    public void onScrolled(final int n, final int n2) {
    }
    
    protected void onSizeChanged(final int n, final int n2, final int n3, final int n4) {
        super.onSizeChanged(n, n2, n3, n4);
        if (n != n3 || n2 != n4) {
            this.invalidateGlows();
        }
    }
    
    public boolean onTouchEvent(final MotionEvent motionEvent) {
        if (mLayoutFrozen || mIgnoreMotionEventTillDown) {
            return false;
        }
        if (this.dispatchOnItemTouch(motionEvent)) {
            this.cancelTouch();
            return true;
        }
        if (mLayout == null) {
            return false;
        }
        final boolean canScrollHorizontally = mLayout.canScrollHorizontally();
        final boolean canScrollVertically = mLayout.canScrollVertically();
        if (mVelocityTracker == null) {
            mVelocityTracker = VelocityTracker.obtain();
        }
        final MotionEvent obtain = MotionEvent.obtain(motionEvent);
        final int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        final int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (actionMasked == 0) {
            mNestedOffsets[mNestedOffsets[1] = 0] = 0;
        }
        obtain.offsetLocation((float)mNestedOffsets[0], (float)mNestedOffsets[1]);
        int n = 0;
        switch (actionMasked) {
            case 0: {
                mScrollPointerId = MotionEventCompat.getPointerId(motionEvent, 0);
                final int n2 = (int)(0.5f + motionEvent.getX());
                mLastTouchX = n2;
                mInitialTouchX = n2;
                final int n3 = (int)(0.5f + motionEvent.getY());
                mLastTouchY = n3;
                mInitialTouchY = n3;
                int n4 = 0;
                if (canScrollHorizontally) {
                    n4 = ((false | true) ? 1 : 0);
                }
                if (canScrollVertically) {
                    n4 |= 0x2;
                }
                this.startNestedScroll(n4);
                n = 0;
                break;
            }
            case 5: {
                mScrollPointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                final int n5 = (int)(0.5f + MotionEventCompat.getX(motionEvent, actionIndex));
                mLastTouchX = n5;
                mInitialTouchX = n5;
                final int n6 = (int)(0.5f + MotionEventCompat.getY(motionEvent, actionIndex));
                mLastTouchY = n6;
                mInitialTouchY = n6;
                n = 0;
                break;
            }
            case 2: {
                final int pointerIndex = MotionEventCompat.findPointerIndex(motionEvent, mScrollPointerId);
                if (pointerIndex < 0) {
                    Log.e("RecyclerView", "Error processing scroll; pointer index for id " + mScrollPointerId + " not found. Did any MotionEvents get skipped?");
                    return false;
                }
                final int n7 = (int)(0.5f + MotionEventCompat.getX(motionEvent, pointerIndex));
                final int n8 = (int)(0.5f + MotionEventCompat.getY(motionEvent, pointerIndex));
                int n9 = mLastTouchX - n7;
                int n10 = mLastTouchY - n8;
                if (this.dispatchNestedPreScroll(n9, n10, mScrollConsumed, mScrollOffset)) {
                    n9 -= mScrollConsumed[0];
                    n10 -= mScrollConsumed[1];
                    obtain.offsetLocation((float)mScrollOffset[0], (float)mScrollOffset[1]);
                    final int[] mNestedOffsets = this.mNestedOffsets;
                    mNestedOffsets[0] += mScrollOffset[0];
                    final int[] mNestedOffsets2 = this.mNestedOffsets;
                    mNestedOffsets2[1] += mScrollOffset[1];
                }
                if (mScrollState != 1) {
                    boolean b = false;
                    if (canScrollHorizontally) {
                        final int abs = Math.abs(n9);
                        final int mTouchSlop = this.mTouchSlop;
                        b = false;
                        if (abs > mTouchSlop) {
                            if (n9 > 0) {
                                n9 -= this.mTouchSlop;
                            }
                            else {
                                n9 += this.mTouchSlop;
                            }
                            b = true;
                        }
                    }
                    if (canScrollVertically && Math.abs(n10) > mTouchSlop) {
                        if (n10 > 0) {
                            n10 -= mTouchSlop;
                        }
                        else {
                            n10 += mTouchSlop;
                        }
                        b = true;
                    }
                    if (b) {
                        this.setScrollState(1);
                    }
                }
                final int mScrollState = this.mScrollState;
                n = 0;
                if (mScrollState != 1) {
                    break;
                }
                mLastTouchX = n7 - mScrollOffset[0];
                mLastTouchY = n8 - mScrollOffset[1];
                if (!canScrollHorizontally) {
                    n9 = 0;
                }
                if (!canScrollVertically) {
                    n10 = 0;
                }
                final boolean scrollByInternal = this.scrollByInternal(n9, n10, obtain);
                n = 0;
                if (scrollByInternal) {
                    this.getParent().requestDisallowInterceptTouchEvent(true);
                    n = 0;
                    break;
                }
                break;
            }
            case 6:
                this.onPointerUp(motionEvent);
                n = 0;
                break;
            case 1: {
                mVelocityTracker.addMovement(obtain);
                n = 1;
                mVelocityTracker.computeCurrentVelocity(1000, (float)mMaxFlingVelocity);
                float n11;
                if (canScrollHorizontally) {
                    n11 = -VelocityTrackerCompat.getXVelocity(mVelocityTracker, mScrollPointerId);
                }
                else {
                    n11 = 0.0f;
                }
                float n12;
                if (canScrollVertically) {
                    n12 = -VelocityTrackerCompat.getYVelocity(mVelocityTracker, mScrollPointerId);
                }
                else {
                    n12 = 0.0f;
                }
                if ((n11 == 0.0f && n12 == 0.0f) || !this.fling((int)n11, (int)n12)) {
                    this.setScrollState(0);
                }
                this.resetTouch();
                break;
            }
            case 3:
                this.cancelTouch();
                n = 0;
                break;
        }
        if (n == 0) {
            mVelocityTracker.addMovement(obtain);
        }
        obtain.recycle();
        return true;
    }
    
    protected void removeDetachedView(final View view, final boolean b) {
        final ViewHolder childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            if (childViewHolderInt.isTmpDetached()) {
                childViewHolderInt.clearTmpDetachFlag();
            }
            else if (!childViewHolderInt.shouldIgnore()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + childViewHolderInt);
            }
        }
        this.dispatchChildDetached(view);
        super.removeDetachedView(view, b);
    }
    
    public void removeItemDecoration(final ItemDecoration itemDecoration) {
        if (mLayout != null) {
            mLayout.assertNotInLayoutOrScroll("Cannot remove item decoration during a scroll  or layout");
        }
        mItemDecorations.remove(itemDecoration);
        if (mItemDecorations.isEmpty()) {
            this.setWillNotDraw(ViewCompat.getOverScrollMode((View)this) == 2);
        }
        this.markItemDecorInsetsDirty();
        this.requestLayout();
    }
    
    public void removeOnChildAttachStateChangeListener(final OnChildAttachStateChangeListener onChildAttachStateChangeListener) {
        if (mOnChildAttachStateListeners == null) {
            return;
        }
        mOnChildAttachStateListeners.remove(onChildAttachStateChangeListener);
    }
    
    public void removeOnItemTouchListener(final OnItemTouchListener onItemTouchListener) {
        mOnItemTouchListeners.remove(onItemTouchListener);
        if (mActiveOnItemTouchListener == onItemTouchListener) {
            mActiveOnItemTouchListener = null;
        }
    }
    
    public void removeOnScrollListener(final OnScrollListener onScrollListener) {
        if (mScrollListeners != null) {
            mScrollListeners.remove(onScrollListener);
        }
    }
    
    public void requestChildFocus(final View view, final View view2) {
        if (!mLayout.onRequestChildFocus(this, mState, view, view2) && view2 != null) {
            mTempRect.set(0, 0, view2.getWidth(), view2.getHeight());
            final ViewGroup$LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams instanceof LayoutParams) {
                final LayoutParams layoutParams2 = (LayoutParams)layoutParams;
                if (!layoutParams2.mInsetsDirty) {
                    final Rect mDecorInsets = layoutParams2.mDecorInsets;
                    final Rect mTempRect = this.mTempRect;
                    mTempRect.left -= mDecorInsets.left;
                    final Rect mTempRect2 = this.mTempRect;
                    mTempRect2.right += mDecorInsets.right;
                    final Rect mTempRect3 = this.mTempRect;
                    mTempRect3.top -= mDecorInsets.top;
                    final Rect mTempRect4 = this.mTempRect;
                    mTempRect4.bottom += mDecorInsets.bottom;
                }
            }
            this.offsetDescendantRectToMyCoords(view2, mTempRect);
            this.offsetRectIntoDescendantCoords(view, mTempRect);
            final Rect mTempRect5 = mTempRect;
            final boolean mFirstLayoutComplete = this.mFirstLayoutComplete;
            boolean b = false;
            if (!mFirstLayoutComplete) {
                b = true;
            }
            this.requestChildRectangleOnScreen(view, mTempRect5, b);
        }
        super.requestChildFocus(view, view2);
    }
    
    public boolean requestChildRectangleOnScreen(final View view, final Rect rect, final boolean b) {
        return mLayout.requestChildRectangleOnScreen(this, view, rect, b);
    }
    
    public void requestDisallowInterceptTouchEvent(final boolean b) {
        for (int size = mOnItemTouchListeners.size(), i = 0; i < size; ++i) {
            ((OnItemTouchListener)mOnItemTouchListeners.get(i)).onRequestDisallowInterceptTouchEvent(b);
        }
        super.requestDisallowInterceptTouchEvent(b);
    }
    
    public void requestLayout() {
        if (mEatRequestLayout == 0 && !mLayoutFrozen) {
            super.requestLayout();
            return;
        }
        mLayoutRequestEaten = true;
    }
    
    void resumeRequestLayout(final boolean b) {
        if (mEatRequestLayout < 1) {
            mEatRequestLayout = 1;
        }
        if (!b) {
            mLayoutRequestEaten = false;
        }
        if (mEatRequestLayout == 1) {
            if (b && mLayoutRequestEaten && !mLayoutFrozen && mLayout != null && mAdapter != null) {
                this.dispatchLayout();
            }
            if (!mLayoutFrozen) {
                mLayoutRequestEaten = false;
            }
        }
        --mEatRequestLayout;
    }
    
    void saveOldPositions() {
        for (int unfilteredChildCount = mChildHelper.getUnfilteredChildCount(), i = 0; i < unfilteredChildCount; ++i) {
            final ViewHolder childViewHolderInt = getChildViewHolderInt(mChildHelper.getUnfilteredChildAt(i));
            if (!childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.saveOldPosition();
            }
        }
    }
    
    public void scrollBy(int n, int n2) {
        if (mLayout == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        }
        else if (!mLayoutFrozen) {
            final boolean canScrollHorizontally = mLayout.canScrollHorizontally();
            final boolean canScrollVertically = mLayout.canScrollVertically();
            if (canScrollHorizontally || canScrollVertically) {
                if (!canScrollHorizontally) {
                    n = 0;
                }
                if (!canScrollVertically) {
                    n2 = 0;
                }
                this.scrollByInternal(n, n2, null);
            }
        }
    }
    
    boolean scrollByInternal(final int n, final int n2, final MotionEvent motionEvent) {
        this.consumePendingUpdateOperations();
        final Adapter mAdapter = this.mAdapter;
        int scrollHorizontallyBy = 0;
        int scrollVerticallyBy = 0;
        int n3 = 0;
        int n4 = 0;
        if (mAdapter != null) {
            this.eatRequestLayout();
            this.onEnterLayoutOrScroll();
            TraceCompat.beginSection("RV Scroll");
            scrollHorizontallyBy = 0;
            n3 = 0;
            if (n != 0) {
                scrollHorizontallyBy = mLayout.scrollHorizontallyBy(n, mRecycler, mState);
                n3 = n - scrollHorizontallyBy;
            }
            scrollVerticallyBy = 0;
            n4 = 0;
            if (n2 != 0) {
                scrollVerticallyBy = mLayout.scrollVerticallyBy(n2, mRecycler, mState);
                n4 = n2 - scrollVerticallyBy;
            }
            TraceCompat.endSection();
            this.repositionShadowingViews();
            this.onExitLayoutOrScroll();
            this.resumeRequestLayout(false);
        }
        if (!mItemDecorations.isEmpty()) {
            this.invalidate();
        }
        if (this.dispatchNestedScroll(scrollHorizontallyBy, scrollVerticallyBy, n3, n4, mScrollOffset)) {
            mLastTouchX -= mScrollOffset[0];
            mLastTouchY -= mScrollOffset[1];
            if (motionEvent != null) {
                motionEvent.offsetLocation((float)mScrollOffset[0], (float)mScrollOffset[1]);
            }
            final int[] mNestedOffsets = this.mNestedOffsets;
            mNestedOffsets[0] += mScrollOffset[0];
            final int[] mNestedOffsets2 = this.mNestedOffsets;
            mNestedOffsets2[1] += mScrollOffset[1];
        }
        else if (ViewCompat.getOverScrollMode((View)this) != 2) {
            if (motionEvent != null) {
                this.pullGlows(motionEvent.getX(), n3, motionEvent.getY(), n4);
            }
            this.considerReleasingGlowsOnScroll(n, n2);
        }
        if (scrollHorizontallyBy != 0 || scrollVerticallyBy != 0) {
            this.dispatchOnScrolled(scrollHorizontallyBy, scrollVerticallyBy);
        }
        if (!this.awakenScrollBars()) {
            this.invalidate();
        }
        return scrollHorizontallyBy != 0 || scrollVerticallyBy != 0;
    }
    
    public void scrollTo(final int n, final int n2) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }
    
    public void scrollToPosition(final int n) {
        if (mLayoutFrozen) {
            return;
        }
        this.stopScroll();
        if (mLayout == null) {
            Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        mLayout.scrollToPosition(n);
        this.awakenScrollBars();
    }
    
    public void sendAccessibilityEventUnchecked(final AccessibilityEvent accessibilityEvent) {
        if (this.shouldDeferAccessibilityEvent(accessibilityEvent)) {
            return;
        }
        super.sendAccessibilityEventUnchecked(accessibilityEvent);
    }
    
    public void setAccessibilityDelegateCompat(final RecyclerViewAccessibilityDelegate mAccessibilityDelegate) {
        ViewCompat.setAccessibilityDelegate(this, (AccessibilityDelegateCompat)(this.mAccessibilityDelegate = mAccessibilityDelegate));
    }
    
    public void setAdapter(final Adapter adapter) {
        this.setLayoutFrozen(false);
        this.setAdapterInternal(adapter, false, true);
        this.requestLayout();
    }
    
    public void setChildDrawingOrderCallback(final ChildDrawingOrderCallback mChildDrawingOrderCallback) {
        if (mChildDrawingOrderCallback == this.mChildDrawingOrderCallback) {
            return;
        }
        this.mChildDrawingOrderCallback = mChildDrawingOrderCallback;
        this.setChildrenDrawingOrderEnabled(this.mChildDrawingOrderCallback != null);
    }
    
    public void setClipToPadding(final boolean mClipToPadding) {
        if (mClipToPadding != this.mClipToPadding) {
            this.invalidateGlows();
        }
        super.setClipToPadding(this.mClipToPadding = mClipToPadding);
        if (mFirstLayoutComplete) {
            this.requestLayout();
        }
    }
    
    public void setHasFixedSize(final boolean mHasFixedSize) {
        this.mHasFixedSize = mHasFixedSize;
    }
    
    public void setItemAnimator(final ItemAnimator mItemAnimator) {
        if (this.mItemAnimator != null) {
            this.mItemAnimator.endAnimations();
            this.mItemAnimator.setListener(null);
        }
        this.mItemAnimator = mItemAnimator;
        if (this.mItemAnimator != null) {
            this.mItemAnimator.setListener(mItemAnimatorListener);
        }
    }
    
    public void setItemViewCacheSize(final int viewCacheSize) {
        mRecycler.setViewCacheSize(viewCacheSize);
    }
    
    public void setLayoutFrozen(final boolean b) {
        if (b != mLayoutFrozen) {
            this.assertNotInLayoutOrScroll("Do not setLayoutFrozen in layout or scroll");
            if (b) {
                final long uptimeMillis = SystemClock.uptimeMillis();
                this.onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                mLayoutFrozen = true;
                mIgnoreMotionEventTillDown = true;
                this.stopScroll();
                return;
            }
            mLayoutFrozen = false;
            if (mLayoutRequestEaten && mLayout != null && mAdapter != null) {
                this.requestLayout();
            }
            mLayoutRequestEaten = false;
        }
    }
    
    public void setLayoutManager(final LayoutManager mLayout) {
        if (mLayout == this.mLayout) {
            return;
        }
        this.stopScroll();
        if (this.mLayout != null) {
            if (mIsAttached) {
                this.mLayout.dispatchDetachedFromWindow(this, mRecycler);
            }
            this.mLayout.setRecyclerView(null);
        }
        mRecycler.clear();
        mChildHelper.removeAllViewsUnfiltered();
        if ((this.mLayout = mLayout) != null) {
            if (mLayout.mRecyclerView != null) {
                throw new IllegalArgumentException("LayoutManager " + mLayout + " is already attached to a RecyclerView: " + mLayout.mRecyclerView);
            }
            this.mLayout.setRecyclerView(this);
            if (mIsAttached) {
                this.mLayout.dispatchAttachedToWindow(this);
            }
        }
        this.requestLayout();
    }
    
    public void setNestedScrollingEnabled(final boolean nestedScrollingEnabled) {
        mScrollingChildHelper.setNestedScrollingEnabled(nestedScrollingEnabled);
    }
    
    @Deprecated
    public void setOnScrollListener(final OnScrollListener mScrollListener) {
        this.mScrollListener = mScrollListener;
    }
    
    public void setRecycledViewPool(final RecycledViewPool recycledViewPool) {
        mRecycler.setRecycledViewPool(recycledViewPool);
    }
    
    public void setRecyclerListener(final RecyclerListener mRecyclerListener) {
        this.mRecyclerListener = mRecyclerListener;
    }
    
    public void setScrollingTouchSlop(final int n) {
        final ViewConfiguration value = ViewConfiguration.get(this.getContext());
        switch (n) {
            default:
                Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + n + "; using default value");
            case 0:
                mTouchSlop = value.getScaledTouchSlop();
            case 1:
                mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(value);
        }
    }
    
    public void setViewCacheExtension(final ViewCacheExtension viewCacheExtension) {
        mRecycler.setViewCacheExtension(viewCacheExtension);
    }
    
    boolean shouldDeferAccessibilityEvent(final AccessibilityEvent accessibilityEvent) {
        if (this.isComputingLayout()) {
            int contentChangeTypes = 0;
            if (accessibilityEvent != null) {
                contentChangeTypes = AccessibilityEventCompat.getContentChangeTypes(accessibilityEvent);
            }
            if (contentChangeTypes == 0) {
                contentChangeTypes = 0;
            }
            mEatenAccessibilityChangeFlags |= contentChangeTypes;
            return true;
        }
        return false;
    }
    
    public void smoothScrollBy(int n, int n2) {
        if (mLayout == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        }
        else if (!mLayoutFrozen) {
            if (!mLayout.canScrollHorizontally()) {
                n = 0;
            }
            if (!mLayout.canScrollVertically()) {
                n2 = 0;
            }
            if (n != 0 || n2 != 0) {
                mViewFlinger.smoothScrollBy(n, n2);
            }
        }
    }
    
    public void smoothScrollToPosition(final int n) {
        if (mLayoutFrozen) {
            return;
        }
        if (mLayout == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        mLayout.smoothScrollToPosition(this, mState, n);
    }
    
    public boolean startNestedScroll(final int n) {
        return mScrollingChildHelper.startNestedScroll(n);
    }
    
    public void stopNestedScroll() {
        mScrollingChildHelper.stopNestedScroll();
    }
    
    public void stopScroll() {
        this.setScrollState(0);
        this.stopScrollersInternal();
    }
    
    public void swapAdapter(final Adapter adapter, final boolean b) {
        this.setLayoutFrozen(false);
        this.setAdapterInternal(adapter, true, b);
        this.setDataSetChangedAfterLayout();
        this.requestLayout();
    }
    
    void viewRangeUpdate(final int n, final int n2, final Object o) {
        final int unfilteredChildCount = mChildHelper.getUnfilteredChildCount();
        final int n3 = n + n2;
        for (int i = 0; i < unfilteredChildCount; ++i) {
            final View unfilteredChild = mChildHelper.getUnfilteredChildAt(i);
            final ViewHolder childViewHolderInt = getChildViewHolderInt(unfilteredChild);
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.mPosition >= n && childViewHolderInt.mPosition < n3) {
                childViewHolderInt.addFlags(2);
                childViewHolderInt.addChangePayload(o);
                ((LayoutParams)unfilteredChild.getLayoutParams()).mInsetsDirty = true;
            }
        }
        mRecycler.viewRangeUpdate(n, n2);
    }
}
