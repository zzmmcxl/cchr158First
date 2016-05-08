package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.v4.os.TraceCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.NestedScrollingChild;
import android.support.v4.view.NestedScrollingChildHelper;
import android.support.v4.view.ScrollingView;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.widget.EdgeEffectCompat;
import android.support.v7.recyclerview.R$styleable;
import android.support.v7.widget.AdapterHelper;
import android.support.v7.widget.ChildHelper;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView$1;
import android.support.v7.widget.RecyclerView$2;
import android.support.v7.widget.RecyclerView$3;
import android.support.v7.widget.RecyclerView$4;
import android.support.v7.widget.RecyclerView$5;
import android.support.v7.widget.RecyclerView$6;
import android.support.v7.widget.RecyclerView$Adapter;
import android.support.v7.widget.RecyclerView$ChildDrawingOrderCallback;
import android.support.v7.widget.RecyclerView$ItemAnimator;
import android.support.v7.widget.RecyclerView$ItemAnimator$ItemAnimatorListener;
import android.support.v7.widget.RecyclerView$ItemAnimator$ItemHolderInfo;
import android.support.v7.widget.RecyclerView$ItemAnimatorRestoreListener;
import android.support.v7.widget.RecyclerView$ItemDecoration;
import android.support.v7.widget.RecyclerView$LayoutManager;
import android.support.v7.widget.RecyclerView$LayoutParams;
import android.support.v7.widget.RecyclerView$OnChildAttachStateChangeListener;
import android.support.v7.widget.RecyclerView$OnItemTouchListener;
import android.support.v7.widget.RecyclerView$OnScrollListener;
import android.support.v7.widget.RecyclerView$RecycledViewPool;
import android.support.v7.widget.RecyclerView$Recycler;
import android.support.v7.widget.RecyclerView$RecyclerListener;
import android.support.v7.widget.RecyclerView$RecyclerViewDataObserver;
import android.support.v7.widget.RecyclerView$SavedState;
import android.support.v7.widget.RecyclerView$State;
import android.support.v7.widget.RecyclerView$ViewCacheExtension;
import android.support.v7.widget.RecyclerView$ViewFlinger;
import android.support.v7.widget.RecyclerView$ViewHolder;
import android.support.v7.widget.RecyclerViewAccessibilityDelegate;
import android.support.v7.widget.ViewInfoStore;
import android.support.v7.widget.ViewInfoStore$ProcessCallback;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.List;

public class RecyclerView extends ViewGroup implements ScrollingView, NestedScrollingChild {
   private static final boolean DEBUG = false;
   private static final boolean DISPATCH_TEMP_DETACH = false;
   private static final boolean FORCE_INVALIDATE_DISPLAY_LIST;
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
   private RecyclerView$OnItemTouchListener mActiveOnItemTouchListener;
   private RecyclerView$Adapter mAdapter;
   AdapterHelper mAdapterHelper;
   private boolean mAdapterUpdateDuringMeasure;
   private EdgeEffectCompat mBottomGlow;
   private RecyclerView$ChildDrawingOrderCallback mChildDrawingOrderCallback;
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
   RecyclerView$ItemAnimator mItemAnimator;
   private RecyclerView$ItemAnimator$ItemAnimatorListener mItemAnimatorListener;
   private Runnable mItemAnimatorRunner;
   private final ArrayList<RecyclerView$ItemDecoration> mItemDecorations;
   boolean mItemsAddedOrRemoved;
   boolean mItemsChanged;
   private int mLastTouchX;
   private int mLastTouchY;
   @VisibleForTesting
   RecyclerView$LayoutManager mLayout;
   private boolean mLayoutFrozen;
   private int mLayoutOrScrollCounter;
   private boolean mLayoutRequestEaten;
   private EdgeEffectCompat mLeftGlow;
   private final int mMaxFlingVelocity;
   private final int mMinFlingVelocity;
   private final int[] mMinMaxLayoutPositions;
   private final int[] mNestedOffsets;
   private final RecyclerView$RecyclerViewDataObserver mObserver;
   private List<RecyclerView$OnChildAttachStateChangeListener> mOnChildAttachStateListeners;
   private final ArrayList<RecyclerView$OnItemTouchListener> mOnItemTouchListeners;
   private RecyclerView$SavedState mPendingSavedState;
   private final boolean mPostUpdatesOnAnimation;
   private boolean mPostedAnimatorRunner;
   final RecyclerView$Recycler mRecycler;
   private RecyclerView$RecyclerListener mRecyclerListener;
   private EdgeEffectCompat mRightGlow;
   private final int[] mScrollConsumed;
   private float mScrollFactor;
   private RecyclerView$OnScrollListener mScrollListener;
   private List<RecyclerView$OnScrollListener> mScrollListeners;
   private final int[] mScrollOffset;
   private int mScrollPointerId;
   private int mScrollState;
   private final NestedScrollingChildHelper mScrollingChildHelper;
   final RecyclerView$State mState;
   private final Rect mTempRect;
   private EdgeEffectCompat mTopGlow;
   private int mTouchSlop;
   private final Runnable mUpdateChildViewsRunnable;
   private VelocityTracker mVelocityTracker;
   private final RecyclerView$ViewFlinger mViewFlinger;
   private final ViewInfoStore$ProcessCallback mViewInfoProcessCallback;
   final ViewInfoStore mViewInfoStore;

   static {
      boolean var0;
      if(VERSION.SDK_INT != 18 && VERSION.SDK_INT != 19 && VERSION.SDK_INT != 20) {
         var0 = false;
      } else {
         var0 = true;
      }

      FORCE_INVALIDATE_DISPLAY_LIST = var0;
      LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = new Class[]{Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE};
      sQuinticInterpolator = new RecyclerView$3();
   }

   public RecyclerView(Context var1) {
      this(var1, (AttributeSet)null);
   }

   public RecyclerView(Context var1, @Nullable AttributeSet var2) {
      this(var1, var2, 0);
   }

   public RecyclerView(Context var1, @Nullable AttributeSet var2, int var3) {
      boolean var5 = false;
      super(var1, var2, var3);
      this.mObserver = new RecyclerView$RecyclerViewDataObserver(this, (RecyclerView$1)null);
      this.mRecycler = new RecyclerView$Recycler(this);
      this.mViewInfoStore = new ViewInfoStore();
      this.mUpdateChildViewsRunnable = new RecyclerView$1(this);
      this.mTempRect = new Rect();
      this.mItemDecorations = new ArrayList();
      this.mOnItemTouchListeners = new ArrayList();
      this.mEatRequestLayout = 0;
      this.mDataSetHasChangedAfterLayout = false;
      this.mLayoutOrScrollCounter = 0;
      this.mItemAnimator = new DefaultItemAnimator();
      this.mScrollState = 0;
      this.mScrollPointerId = -1;
      this.mScrollFactor = Float.MIN_VALUE;
      this.mViewFlinger = new RecyclerView$ViewFlinger(this);
      this.mState = new RecyclerView$State();
      this.mItemsAddedOrRemoved = false;
      this.mItemsChanged = false;
      this.mItemAnimatorListener = new RecyclerView$ItemAnimatorRestoreListener(this, (RecyclerView$1)null);
      this.mPostedAnimatorRunner = false;
      this.mMinMaxLayoutPositions = new int[2];
      this.mScrollOffset = new int[2];
      this.mScrollConsumed = new int[2];
      this.mNestedOffsets = new int[2];
      this.mItemAnimatorRunner = new RecyclerView$2(this);
      this.mViewInfoProcessCallback = new RecyclerView$4(this);
      this.setScrollContainer(true);
      this.setFocusableInTouchMode(true);
      boolean var4;
      if(VERSION.SDK_INT >= 16) {
         var4 = true;
      } else {
         var4 = false;
      }

      this.mPostUpdatesOnAnimation = var4;
      ViewConfiguration var6 = ViewConfiguration.get(var1);
      this.mTouchSlop = var6.getScaledTouchSlop();
      this.mMinFlingVelocity = var6.getScaledMinimumFlingVelocity();
      this.mMaxFlingVelocity = var6.getScaledMaximumFlingVelocity();
      var4 = var5;
      if(ViewCompat.getOverScrollMode(this) == 2) {
         var4 = true;
      }

      this.setWillNotDraw(var4);
      this.mItemAnimator.setListener(this.mItemAnimatorListener);
      this.initAdapterManager();
      this.initChildrenHelper();
      if(ViewCompat.getImportantForAccessibility(this) == 0) {
         ViewCompat.setImportantForAccessibility(this, 1);
      }

      this.mAccessibilityManager = (AccessibilityManager)this.getContext().getSystemService("accessibility");
      this.setAccessibilityDelegateCompat(new RecyclerViewAccessibilityDelegate(this));
      if(var2 != null) {
         TypedArray var8 = var1.obtainStyledAttributes(var2, R$styleable.RecyclerView, var3, 0);
         String var7 = var8.getString(R$styleable.RecyclerView_layoutManager);
         var8.recycle();
         this.createLayoutManager(var1, var7, var2, var3, 0);
      }

      this.mScrollingChildHelper = new NestedScrollingChildHelper(this);
      this.setNestedScrollingEnabled(true);
   }

   private void addAnimatingView(RecyclerView$ViewHolder var1) {
      View var3 = var1.itemView;
      boolean var2;
      if(var3.getParent() == this) {
         var2 = true;
      } else {
         var2 = false;
      }

      this.mRecycler.unscrapView(this.getChildViewHolder(var3));
      if(var1.isTmpDetached()) {
         this.mChildHelper.attachViewToParent(var3, -1, var3.getLayoutParams(), true);
      } else if(!var2) {
         this.mChildHelper.addView(var3, true);
      } else {
         this.mChildHelper.hide(var3);
      }
   }

   private void animateAppearance(@NonNull RecyclerView$ViewHolder var1, @Nullable RecyclerView$ItemAnimator$ItemHolderInfo var2, @NonNull RecyclerView$ItemAnimator$ItemHolderInfo var3) {
      var1.setIsRecyclable(false);
      if(this.mItemAnimator.animateAppearance(var1, var2, var3)) {
         this.postAnimationRunner();
      }

   }

   private void animateChange(@NonNull RecyclerView$ViewHolder var1, @NonNull RecyclerView$ViewHolder var2, @NonNull RecyclerView$ItemAnimator$ItemHolderInfo var3, @NonNull RecyclerView$ItemAnimator$ItemHolderInfo var4, boolean var5, boolean var6) {
      var1.setIsRecyclable(false);
      if(var5) {
         this.addAnimatingView(var1);
      }

      if(var1 != var2) {
         if(var6) {
            this.addAnimatingView(var2);
         }

         var1.mShadowedHolder = var2;
         this.addAnimatingView(var1);
         this.mRecycler.unscrapView(var1);
         var2.setIsRecyclable(false);
         var2.mShadowingHolder = var1;
      }

      if(this.mItemAnimator.animateChange(var1, var2, var3, var4)) {
         this.postAnimationRunner();
      }

   }

   private void animateDisappearance(@NonNull RecyclerView$ViewHolder var1, @NonNull RecyclerView$ItemAnimator$ItemHolderInfo var2, @Nullable RecyclerView$ItemAnimator$ItemHolderInfo var3) {
      this.addAnimatingView(var1);
      var1.setIsRecyclable(false);
      if(this.mItemAnimator.animateDisappearance(var1, var2, var3)) {
         this.postAnimationRunner();
      }

   }

   private boolean canReuseUpdatedViewHolder(RecyclerView$ViewHolder var1) {
      return this.mItemAnimator == null || this.mItemAnimator.canReuseUpdatedViewHolder(var1, var1.getUnmodifiedPayloads());
   }

   private void cancelTouch() {
      this.resetTouch();
      this.setScrollState(0);
   }

   private void considerReleasingGlowsOnScroll(int var1, int var2) {
      boolean var4 = false;
      boolean var3 = var4;
      if(this.mLeftGlow != null) {
         var3 = var4;
         if(!this.mLeftGlow.isFinished()) {
            var3 = var4;
            if(var1 > 0) {
               var3 = this.mLeftGlow.onRelease();
            }
         }
      }

      var4 = var3;
      if(this.mRightGlow != null) {
         var4 = var3;
         if(!this.mRightGlow.isFinished()) {
            var4 = var3;
            if(var1 < 0) {
               var4 = var3 | this.mRightGlow.onRelease();
            }
         }
      }

      var3 = var4;
      if(this.mTopGlow != null) {
         var3 = var4;
         if(!this.mTopGlow.isFinished()) {
            var3 = var4;
            if(var2 > 0) {
               var3 = var4 | this.mTopGlow.onRelease();
            }
         }
      }

      var4 = var3;
      if(this.mBottomGlow != null) {
         var4 = var3;
         if(!this.mBottomGlow.isFinished()) {
            var4 = var3;
            if(var2 < 0) {
               var4 = var3 | this.mBottomGlow.onRelease();
            }
         }
      }

      if(var4) {
         ViewCompat.postInvalidateOnAnimation(this);
      }

   }

   private void consumePendingUpdateOperations() {
      if(this.mFirstLayoutComplete) {
         if(this.mDataSetHasChangedAfterLayout) {
            TraceCompat.beginSection("RV FullInvalidate");
            this.dispatchLayout();
            TraceCompat.endSection();
            return;
         }

         if(this.mAdapterHelper.hasPendingUpdates()) {
            if(this.mAdapterHelper.hasAnyUpdateTypes(4) && !this.mAdapterHelper.hasAnyUpdateTypes(11)) {
               TraceCompat.beginSection("RV PartialInvalidate");
               this.eatRequestLayout();
               this.mAdapterHelper.preProcess();
               if(!this.mLayoutRequestEaten) {
                  if(this.hasUpdatedView()) {
                     this.dispatchLayout();
                  } else {
                     this.mAdapterHelper.consumePostponedUpdates();
                  }
               }

               this.resumeRequestLayout(true);
               TraceCompat.endSection();
               return;
            }

            if(this.mAdapterHelper.hasPendingUpdates()) {
               TraceCompat.beginSection("RV FullInvalidate");
               this.dispatchLayout();
               TraceCompat.endSection();
               return;
            }
         }
      }

   }

   private void createLayoutManager(Context param1, String param2, AttributeSet param3, int param4, int param5) {
      // $FF: Couldn't be decompiled
   }

   private boolean didChildRangeChange(int var1, int var2) {
      boolean var7 = false;
      int var4 = this.mChildHelper.getChildCount();
      boolean var6;
      if(var4 == 0) {
         if(var1 == 0) {
            var6 = var7;
            if(var2 == 0) {
               return var6;
            }
         }

         var6 = true;
      } else {
         int var3 = 0;

         while(true) {
            var6 = var7;
            if(var3 >= var4) {
               break;
            }

            RecyclerView$ViewHolder var8 = getChildViewHolderInt(this.mChildHelper.getChildAt(var3));
            if(!var8.shouldIgnore()) {
               int var5 = var8.getLayoutPosition();
               if(var5 < var1 || var5 > var2) {
                  return true;
               }
            }

            ++var3;
         }
      }

      return var6;
   }

   private void dispatchChildAttached(View var1) {
      RecyclerView$ViewHolder var3 = getChildViewHolderInt(var1);
      this.onChildAttachedToWindow(var1);
      if(this.mAdapter != null && var3 != null) {
         this.mAdapter.onViewAttachedToWindow(var3);
      }

      if(this.mOnChildAttachStateListeners != null) {
         for(int var2 = this.mOnChildAttachStateListeners.size() - 1; var2 >= 0; --var2) {
            ((RecyclerView$OnChildAttachStateChangeListener)this.mOnChildAttachStateListeners.get(var2)).onChildViewAttachedToWindow(var1);
         }
      }

   }

   private void dispatchChildDetached(View var1) {
      RecyclerView$ViewHolder var3 = getChildViewHolderInt(var1);
      this.onChildDetachedFromWindow(var1);
      if(this.mAdapter != null && var3 != null) {
         this.mAdapter.onViewDetachedFromWindow(var3);
      }

      if(this.mOnChildAttachStateListeners != null) {
         for(int var2 = this.mOnChildAttachStateListeners.size() - 1; var2 >= 0; --var2) {
            ((RecyclerView$OnChildAttachStateChangeListener)this.mOnChildAttachStateListeners.get(var2)).onChildViewDetachedFromWindow(var1);
         }
      }

   }

   private void dispatchContentChangedIfNecessary() {
      int var1 = this.mEatenAccessibilityChangeFlags;
      this.mEatenAccessibilityChangeFlags = 0;
      if(var1 != 0 && this.isAccessibilityEnabled()) {
         AccessibilityEvent var2 = AccessibilityEvent.obtain();
         var2.setEventType(2048);
         AccessibilityEventCompat.setContentChangeTypes(var2, var1);
         this.sendAccessibilityEventUnchecked(var2);
      }

   }

   private void dispatchLayoutStep1() {
      this.mState.assertLayoutStep(1);
      RecyclerView$State.access$2202(this.mState, false);
      this.eatRequestLayout();
      this.mViewInfoStore.clear();
      this.onEnterLayoutOrScroll();
      this.processAdapterUpdatesAndSetAnimationFlags();
      RecyclerView$State var7 = this.mState;
      boolean var4;
      if(RecyclerView$State.access$2500(this.mState) && this.mItemsChanged) {
         var4 = true;
      } else {
         var4 = false;
      }

      RecyclerView$State.access$2702(var7, var4);
      this.mItemsChanged = false;
      this.mItemsAddedOrRemoved = false;
      RecyclerView$State.access$2402(this.mState, RecyclerView$State.access$2300(this.mState));
      this.mState.mItemCount = this.mAdapter.getItemCount();
      this.findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
      int var1;
      int var2;
      RecyclerView$ItemAnimator$ItemHolderInfo var8;
      RecyclerView$ViewHolder var9;
      if(RecyclerView$State.access$2500(this.mState)) {
         var2 = this.mChildHelper.getChildCount();

         for(var1 = 0; var1 < var2; ++var1) {
            var9 = getChildViewHolderInt(this.mChildHelper.getChildAt(var1));
            if(!var9.shouldIgnore() && (!var9.isInvalid() || this.mAdapter.hasStableIds())) {
               var8 = this.mItemAnimator.recordPreLayoutInformation(this.mState, var9, RecyclerView$ItemAnimator.buildAdapterChangeFlagsForAnimations(var9), var9.getUnmodifiedPayloads());
               this.mViewInfoStore.addToPreLayout(var9, var8);
               if(RecyclerView$State.access$2700(this.mState) && var9.isUpdated() && !var9.isRemoved() && !var9.shouldIgnore() && !var9.isInvalid()) {
                  long var5 = this.getChangedHolderKey(var9);
                  this.mViewInfoStore.addToOldChangeHolders(var5, var9);
               }
            }
         }
      }

      if(RecyclerView$State.access$2300(this.mState)) {
         this.saveOldPositions();
         var4 = RecyclerView$State.access$1800(this.mState);
         RecyclerView$State.access$1802(this.mState, false);
         this.mLayout.onLayoutChildren(this.mRecycler, this.mState);
         RecyclerView$State.access$1802(this.mState, var4);

         for(var1 = 0; var1 < this.mChildHelper.getChildCount(); ++var1) {
            var9 = getChildViewHolderInt(this.mChildHelper.getChildAt(var1));
            if(!var9.shouldIgnore() && !this.mViewInfoStore.isInPreLayout(var9)) {
               int var3 = RecyclerView$ItemAnimator.buildAdapterChangeFlagsForAnimations(var9);
               var4 = var9.hasAnyOfTheFlags(8192);
               var2 = var3;
               if(!var4) {
                  var2 = var3 | 4096;
               }

               var8 = this.mItemAnimator.recordPreLayoutInformation(this.mState, var9, var2, var9.getUnmodifiedPayloads());
               if(var4) {
                  this.recordAnimationInfoIfBouncedHiddenView(var9, var8);
               } else {
                  this.mViewInfoStore.addToAppearedInPreLayoutHolders(var9, var8);
               }
            }
         }

         this.clearOldPositions();
      } else {
         this.clearOldPositions();
      }

      this.onExitLayoutOrScroll();
      this.resumeRequestLayout(false);
      RecyclerView$State.access$2102(this.mState, 2);
   }

   private void dispatchLayoutStep2() {
      this.eatRequestLayout();
      this.onEnterLayoutOrScroll();
      this.mState.assertLayoutStep(6);
      this.mAdapterHelper.consumeUpdatesInOnePass();
      this.mState.mItemCount = this.mAdapter.getItemCount();
      RecyclerView$State.access$1702(this.mState, 0);
      RecyclerView$State.access$2402(this.mState, false);
      this.mLayout.onLayoutChildren(this.mRecycler, this.mState);
      RecyclerView$State.access$1802(this.mState, false);
      this.mPendingSavedState = null;
      RecyclerView$State var2 = this.mState;
      boolean var1;
      if(RecyclerView$State.access$2500(this.mState) && this.mItemAnimator != null) {
         var1 = true;
      } else {
         var1 = false;
      }

      RecyclerView$State.access$2502(var2, var1);
      RecyclerView$State.access$2102(this.mState, 4);
      this.onExitLayoutOrScroll();
      this.resumeRequestLayout(false);
   }

   private void dispatchLayoutStep3() {
      this.mState.assertLayoutStep(4);
      this.eatRequestLayout();
      this.onEnterLayoutOrScroll();
      RecyclerView$State.access$2102(this.mState, 1);
      if(RecyclerView$State.access$2500(this.mState)) {
         for(int var1 = this.mChildHelper.getChildCount() - 1; var1 >= 0; --var1) {
            RecyclerView$ViewHolder var6 = getChildViewHolderInt(this.mChildHelper.getChildAt(var1));
            if(!var6.shouldIgnore()) {
               long var2 = this.getChangedHolderKey(var6);
               RecyclerView$ItemAnimator$ItemHolderInfo var9 = this.mItemAnimator.recordPostLayoutInformation(this.mState, var6);
               RecyclerView$ViewHolder var7 = this.mViewInfoStore.getFromOldChangeHolders(var2);
               if(var7 != null && !var7.shouldIgnore()) {
                  boolean var4 = this.mViewInfoStore.isDisappearing(var7);
                  boolean var5 = this.mViewInfoStore.isDisappearing(var6);
                  if(var4 && var7 == var6) {
                     this.mViewInfoStore.addToPostLayout(var6, var9);
                  } else {
                     RecyclerView$ItemAnimator$ItemHolderInfo var8 = this.mViewInfoStore.popFromPreLayout(var7);
                     this.mViewInfoStore.addToPostLayout(var6, var9);
                     var9 = this.mViewInfoStore.popFromPostLayout(var6);
                     if(var8 == null) {
                        this.handleMissingPreInfoForChangeError(var2, var6, var7);
                     } else {
                        this.animateChange(var7, var6, var8, var9, var4, var5);
                     }
                  }
               } else {
                  this.mViewInfoStore.addToPostLayout(var6, var9);
               }
            }
         }

         this.mViewInfoStore.process(this.mViewInfoProcessCallback);
      }

      this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
      RecyclerView$State.access$2802(this.mState, this.mState.mItemCount);
      this.mDataSetHasChangedAfterLayout = false;
      RecyclerView$State.access$2502(this.mState, false);
      RecyclerView$State.access$2302(this.mState, false);
      RecyclerView$LayoutManager.access$2602(this.mLayout, false);
      if(RecyclerView$Recycler.access$2900(this.mRecycler) != null) {
         RecyclerView$Recycler.access$2900(this.mRecycler).clear();
      }

      this.onExitLayoutOrScroll();
      this.resumeRequestLayout(false);
      this.mViewInfoStore.clear();
      if(this.didChildRangeChange(this.mMinMaxLayoutPositions[0], this.mMinMaxLayoutPositions[1])) {
         this.dispatchOnScrolled(0, 0);
      }

   }

   private boolean dispatchOnItemTouch(MotionEvent var1) {
      int var2 = var1.getAction();
      if(this.mActiveOnItemTouchListener != null) {
         if(var2 != 0) {
            this.mActiveOnItemTouchListener.onTouchEvent(this, var1);
            if(var2 != 3 && var2 != 1) {
               return true;
            }

            this.mActiveOnItemTouchListener = null;
            return true;
         }

         this.mActiveOnItemTouchListener = null;
      }

      if(var2 != 0) {
         int var3 = this.mOnItemTouchListeners.size();

         for(var2 = 0; var2 < var3; ++var2) {
            RecyclerView$OnItemTouchListener var4 = (RecyclerView$OnItemTouchListener)this.mOnItemTouchListeners.get(var2);
            if(var4.onInterceptTouchEvent(this, var1)) {
               this.mActiveOnItemTouchListener = var4;
               return true;
            }
         }
      }

      return false;
   }

   private boolean dispatchOnItemTouchIntercept(MotionEvent var1) {
      int var3 = var1.getAction();
      if(var3 == 3 || var3 == 0) {
         this.mActiveOnItemTouchListener = null;
      }

      int var4 = this.mOnItemTouchListeners.size();

      for(int var2 = 0; var2 < var4; ++var2) {
         RecyclerView$OnItemTouchListener var5 = (RecyclerView$OnItemTouchListener)this.mOnItemTouchListeners.get(var2);
         if(var5.onInterceptTouchEvent(this, var1) && var3 != 3) {
            this.mActiveOnItemTouchListener = var5;
            return true;
         }
      }

      return false;
   }

   private void findMinMaxChildLayoutPositions(int[] var1) {
      int var8 = this.mChildHelper.getChildCount();
      if(var8 == 0) {
         var1[0] = 0;
         var1[1] = 0;
      } else {
         int var3 = Integer.MAX_VALUE;
         int var5 = Integer.MIN_VALUE;

         int var7;
         for(int var4 = 0; var4 < var8; var3 = var7) {
            RecyclerView$ViewHolder var9 = getChildViewHolderInt(this.mChildHelper.getChildAt(var4));
            if(var9.shouldIgnore()) {
               var7 = var3;
               var3 = var5;
            } else {
               int var6 = var9.getLayoutPosition();
               int var2 = var3;
               if(var6 < var3) {
                  var2 = var6;
               }

               var3 = var5;
               var7 = var2;
               if(var6 > var5) {
                  var3 = var6;
                  var7 = var2;
               }
            }

            ++var4;
            var5 = var3;
         }

         var1[0] = var3;
         var1[1] = var5;
      }
   }

   private int getAdapterPositionFor(RecyclerView$ViewHolder var1) {
      return !var1.hasAnyOfTheFlags(524) && var1.isBound()?this.mAdapterHelper.applyPendingUpdatesToPosition(var1.mPosition):-1;
   }

   static RecyclerView$ViewHolder getChildViewHolderInt(View var0) {
      return var0 == null?null:((RecyclerView$LayoutParams)var0.getLayoutParams()).mViewHolder;
   }

   private String getFullClassName(Context var1, String var2) {
      String var3;
      if(var2.charAt(0) == 46) {
         var3 = var1.getPackageName() + var2;
      } else {
         var3 = var2;
         if(!var2.contains(".")) {
            return RecyclerView.class.getPackage().getName() + '.' + var2;
         }
      }

      return var3;
   }

   private float getScrollFactor() {
      if(this.mScrollFactor == Float.MIN_VALUE) {
         TypedValue var1 = new TypedValue();
         if(!this.getContext().getTheme().resolveAttribute(16842829, var1, true)) {
            return 0.0F;
         }

         this.mScrollFactor = var1.getDimension(this.getContext().getResources().getDisplayMetrics());
      }

      return this.mScrollFactor;
   }

   private void handleMissingPreInfoForChangeError(long var1, RecyclerView$ViewHolder var3, RecyclerView$ViewHolder var4) {
      int var6 = this.mChildHelper.getChildCount();

      for(int var5 = 0; var5 < var6; ++var5) {
         RecyclerView$ViewHolder var7 = getChildViewHolderInt(this.mChildHelper.getChildAt(var5));
         if(var7 != var3 && this.getChangedHolderKey(var7) == var1) {
            if(this.mAdapter != null && this.mAdapter.hasStableIds()) {
               throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + var7 + " \n View Holder 2:" + var3);
            }

            throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + var7 + " \n View Holder 2:" + var3);
         }
      }

      Log.e("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + var4 + " cannot be found but it is necessary for " + var3);
   }

   private boolean hasUpdatedView() {
      int var2 = this.mChildHelper.getChildCount();

      for(int var1 = 0; var1 < var2; ++var1) {
         RecyclerView$ViewHolder var3 = getChildViewHolderInt(this.mChildHelper.getChildAt(var1));
         if(var3 != null && !var3.shouldIgnore() && var3.isUpdated()) {
            return true;
         }
      }

      return false;
   }

   private void initChildrenHelper() {
      this.mChildHelper = new ChildHelper(new RecyclerView$5(this));
   }

   private void jumpToPositionForSmoothScroller(int var1) {
      if(this.mLayout != null) {
         this.mLayout.scrollToPosition(var1);
         this.awakenScrollBars();
      }
   }

   private void onEnterLayoutOrScroll() {
      ++this.mLayoutOrScrollCounter;
   }

   private void onExitLayoutOrScroll() {
      --this.mLayoutOrScrollCounter;
      if(this.mLayoutOrScrollCounter < 1) {
         this.mLayoutOrScrollCounter = 0;
         this.dispatchContentChangedIfNecessary();
      }

   }

   private void onPointerUp(MotionEvent var1) {
      int var2 = MotionEventCompat.getActionIndex(var1);
      if(MotionEventCompat.getPointerId(var1, var2) == this.mScrollPointerId) {
         byte var4;
         if(var2 == 0) {
            var4 = 1;
         } else {
            var4 = 0;
         }

         this.mScrollPointerId = MotionEventCompat.getPointerId(var1, var4);
         int var3 = (int)(MotionEventCompat.getX(var1, var4) + 0.5F);
         this.mLastTouchX = var3;
         this.mInitialTouchX = var3;
         var2 = (int)(MotionEventCompat.getY(var1, var4) + 0.5F);
         this.mLastTouchY = var2;
         this.mInitialTouchY = var2;
      }

   }

   private void postAnimationRunner() {
      if(!this.mPostedAnimatorRunner && this.mIsAttached) {
         ViewCompat.postOnAnimation(this, this.mItemAnimatorRunner);
         this.mPostedAnimatorRunner = true;
      }

   }

   private boolean predictiveItemAnimationsEnabled() {
      return this.mItemAnimator != null && this.mLayout.supportsPredictiveItemAnimations();
   }

   private void processAdapterUpdatesAndSetAnimationFlags() {
      boolean var3 = true;
      if(this.mDataSetHasChangedAfterLayout) {
         this.mAdapterHelper.reset();
         this.markKnownViewsInvalid();
         this.mLayout.onItemsChanged(this);
      }

      if(this.predictiveItemAnimationsEnabled()) {
         this.mAdapterHelper.preProcess();
      } else {
         this.mAdapterHelper.consumeUpdatesInOnePass();
      }

      boolean var1;
      if(!this.mItemsAddedOrRemoved && !this.mItemsChanged) {
         var1 = false;
      } else {
         var1 = true;
      }

      RecyclerView$State var4 = this.mState;
      boolean var2;
      if(this.mFirstLayoutComplete && this.mItemAnimator != null && (this.mDataSetHasChangedAfterLayout || var1 || RecyclerView$LayoutManager.access$2600(this.mLayout)) && (!this.mDataSetHasChangedAfterLayout || this.mAdapter.hasStableIds())) {
         var2 = true;
      } else {
         var2 = false;
      }

      RecyclerView$State.access$2502(var4, var2);
      var4 = this.mState;
      if(RecyclerView$State.access$2500(this.mState) && var1 && !this.mDataSetHasChangedAfterLayout && this.predictiveItemAnimationsEnabled()) {
         var2 = var3;
      } else {
         var2 = false;
      }

      RecyclerView$State.access$2302(var4, var2);
   }

   private void pullGlows(float var1, float var2, float var3, float var4) {
      boolean var6 = false;
      boolean var5;
      if(var2 < 0.0F) {
         this.ensureLeftGlow();
         var5 = var6;
         if(this.mLeftGlow.onPull(-var2 / (float)this.getWidth(), 1.0F - var3 / (float)this.getHeight())) {
            var5 = true;
         }
      } else {
         var5 = var6;
         if(var2 > 0.0F) {
            this.ensureRightGlow();
            var5 = var6;
            if(this.mRightGlow.onPull(var2 / (float)this.getWidth(), var3 / (float)this.getHeight())) {
               var5 = true;
            }
         }
      }

      if(var4 < 0.0F) {
         this.ensureTopGlow();
         var6 = var5;
         if(this.mTopGlow.onPull(-var4 / (float)this.getHeight(), var1 / (float)this.getWidth())) {
            var6 = true;
         }
      } else {
         var6 = var5;
         if(var4 > 0.0F) {
            this.ensureBottomGlow();
            var6 = var5;
            if(this.mBottomGlow.onPull(var4 / (float)this.getHeight(), 1.0F - var1 / (float)this.getWidth())) {
               var6 = true;
            }
         }
      }

      if(var6 || var2 != 0.0F || var4 != 0.0F) {
         ViewCompat.postInvalidateOnAnimation(this);
      }

   }

   private void recordAnimationInfoIfBouncedHiddenView(RecyclerView$ViewHolder var1, RecyclerView$ItemAnimator$ItemHolderInfo var2) {
      var1.setFlags(0, 8192);
      if(RecyclerView$State.access$2700(this.mState) && var1.isUpdated() && !var1.isRemoved() && !var1.shouldIgnore()) {
         long var3 = this.getChangedHolderKey(var1);
         this.mViewInfoStore.addToOldChangeHolders(var3, var1);
      }

      this.mViewInfoStore.addToPreLayout(var1, var2);
   }

   private void releaseGlows() {
      boolean var2 = false;
      if(this.mLeftGlow != null) {
         var2 = this.mLeftGlow.onRelease();
      }

      boolean var1 = var2;
      if(this.mTopGlow != null) {
         var1 = var2 | this.mTopGlow.onRelease();
      }

      var2 = var1;
      if(this.mRightGlow != null) {
         var2 = var1 | this.mRightGlow.onRelease();
      }

      var1 = var2;
      if(this.mBottomGlow != null) {
         var1 = var2 | this.mBottomGlow.onRelease();
      }

      if(var1) {
         ViewCompat.postInvalidateOnAnimation(this);
      }

   }

   private boolean removeAnimatingView(View var1) {
      this.eatRequestLayout();
      boolean var3 = this.mChildHelper.removeViewIfHidden(var1);
      if(var3) {
         RecyclerView$ViewHolder var4 = getChildViewHolderInt(var1);
         this.mRecycler.unscrapView(var4);
         this.mRecycler.recycleViewHolderInternal(var4);
      }

      boolean var2;
      if(!var3) {
         var2 = true;
      } else {
         var2 = false;
      }

      this.resumeRequestLayout(var2);
      return var3;
   }

   private void repositionShadowingViews() {
      int var2 = this.mChildHelper.getChildCount();

      for(int var1 = 0; var1 < var2; ++var1) {
         View var5 = this.mChildHelper.getChildAt(var1);
         RecyclerView$ViewHolder var6 = this.getChildViewHolder(var5);
         if(var6 != null && var6.mShadowingHolder != null) {
            View var7 = var6.mShadowingHolder.itemView;
            int var3 = var5.getLeft();
            int var4 = var5.getTop();
            if(var3 != var7.getLeft() || var4 != var7.getTop()) {
               var7.layout(var3, var4, var7.getWidth() + var3, var7.getHeight() + var4);
            }
         }
      }

   }

   private void resetTouch() {
      if(this.mVelocityTracker != null) {
         this.mVelocityTracker.clear();
      }

      this.stopNestedScroll();
      this.releaseGlows();
   }

   private void setAdapterInternal(RecyclerView$Adapter var1, boolean var2, boolean var3) {
      if(this.mAdapter != null) {
         this.mAdapter.unregisterAdapterDataObserver(this.mObserver);
         this.mAdapter.onDetachedFromRecyclerView(this);
      }

      if(!var2 || var3) {
         if(this.mItemAnimator != null) {
            this.mItemAnimator.endAnimations();
         }

         if(this.mLayout != null) {
            this.mLayout.removeAndRecycleAllViews(this.mRecycler);
            this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
         }

         this.mRecycler.clear();
      }

      this.mAdapterHelper.reset();
      RecyclerView$Adapter var4 = this.mAdapter;
      this.mAdapter = var1;
      if(var1 != null) {
         var1.registerAdapterDataObserver(this.mObserver);
         var1.onAttachedToRecyclerView(this);
      }

      if(this.mLayout != null) {
         this.mLayout.onAdapterChanged(var4, this.mAdapter);
      }

      this.mRecycler.onAdapterChanged(var4, this.mAdapter, var2);
      RecyclerView$State.access$1802(this.mState, true);
      this.markKnownViewsInvalid();
   }

   private void setDataSetChangedAfterLayout() {
      if(!this.mDataSetHasChangedAfterLayout) {
         this.mDataSetHasChangedAfterLayout = true;
         int var2 = this.mChildHelper.getUnfilteredChildCount();

         for(int var1 = 0; var1 < var2; ++var1) {
            RecyclerView$ViewHolder var3 = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(var1));
            if(var3 != null && !var3.shouldIgnore()) {
               var3.addFlags(512);
            }
         }

         this.mRecycler.setAdapterPositionsAsUnknown();
      }
   }

   private void setScrollState(int var1) {
      if(var1 != this.mScrollState) {
         this.mScrollState = var1;
         if(var1 != 2) {
            this.stopScrollersInternal();
         }

         this.dispatchOnScrollStateChanged(var1);
      }
   }

   private void stopScrollersInternal() {
      this.mViewFlinger.stop();
      if(this.mLayout != null) {
         this.mLayout.stopSmoothScroller();
      }

   }

   void absorbGlows(int var1, int var2) {
      if(var1 < 0) {
         this.ensureLeftGlow();
         this.mLeftGlow.onAbsorb(-var1);
      } else if(var1 > 0) {
         this.ensureRightGlow();
         this.mRightGlow.onAbsorb(var1);
      }

      if(var2 < 0) {
         this.ensureTopGlow();
         this.mTopGlow.onAbsorb(-var2);
      } else if(var2 > 0) {
         this.ensureBottomGlow();
         this.mBottomGlow.onAbsorb(var2);
      }

      if(var1 != 0 || var2 != 0) {
         ViewCompat.postInvalidateOnAnimation(this);
      }

   }

   public void addFocusables(ArrayList<View> var1, int var2, int var3) {
      if(this.mLayout == null || !this.mLayout.onAddFocusables(this, var1, var2, var3)) {
         super.addFocusables(var1, var2, var3);
      }

   }

   public void addItemDecoration(RecyclerView$ItemDecoration var1) {
      this.addItemDecoration(var1, -1);
   }

   public void addItemDecoration(RecyclerView$ItemDecoration var1, int var2) {
      if(this.mLayout != null) {
         this.mLayout.assertNotInLayoutOrScroll("Cannot add item decoration during a scroll  or layout");
      }

      if(this.mItemDecorations.isEmpty()) {
         this.setWillNotDraw(false);
      }

      if(var2 < 0) {
         this.mItemDecorations.add(var1);
      } else {
         this.mItemDecorations.add(var2, var1);
      }

      this.markItemDecorInsetsDirty();
      this.requestLayout();
   }

   public void addOnChildAttachStateChangeListener(RecyclerView$OnChildAttachStateChangeListener var1) {
      if(this.mOnChildAttachStateListeners == null) {
         this.mOnChildAttachStateListeners = new ArrayList();
      }

      this.mOnChildAttachStateListeners.add(var1);
   }

   public void addOnItemTouchListener(RecyclerView$OnItemTouchListener var1) {
      this.mOnItemTouchListeners.add(var1);
   }

   public void addOnScrollListener(RecyclerView$OnScrollListener var1) {
      if(this.mScrollListeners == null) {
         this.mScrollListeners = new ArrayList();
      }

      this.mScrollListeners.add(var1);
   }

   void assertInLayoutOrScroll(String var1) {
      if(!this.isComputingLayout()) {
         if(var1 == null) {
            throw new IllegalStateException("Cannot call this method unless RecyclerView is computing a layout or scrolling");
         } else {
            throw new IllegalStateException(var1);
         }
      }
   }

   void assertNotInLayoutOrScroll(String var1) {
      if(this.isComputingLayout()) {
         if(var1 == null) {
            throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling");
         } else {
            throw new IllegalStateException(var1);
         }
      }
   }

   protected boolean checkLayoutParams(LayoutParams var1) {
      return var1 instanceof RecyclerView$LayoutParams && this.mLayout.checkLayoutParams((RecyclerView$LayoutParams)var1);
   }

   void clearOldPositions() {
      int var2 = this.mChildHelper.getUnfilteredChildCount();

      for(int var1 = 0; var1 < var2; ++var1) {
         RecyclerView$ViewHolder var3 = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(var1));
         if(!var3.shouldIgnore()) {
            var3.clearOldPosition();
         }
      }

      this.mRecycler.clearOldPositions();
   }

   public void clearOnChildAttachStateChangeListeners() {
      if(this.mOnChildAttachStateListeners != null) {
         this.mOnChildAttachStateListeners.clear();
      }

   }

   public void clearOnScrollListeners() {
      if(this.mScrollListeners != null) {
         this.mScrollListeners.clear();
      }

   }

   public int computeHorizontalScrollExtent() {
      return this.mLayout != null && this.mLayout.canScrollHorizontally()?this.mLayout.computeHorizontalScrollExtent(this.mState):0;
   }

   public int computeHorizontalScrollOffset() {
      return this.mLayout != null && this.mLayout.canScrollHorizontally()?this.mLayout.computeHorizontalScrollOffset(this.mState):0;
   }

   public int computeHorizontalScrollRange() {
      return this.mLayout != null && this.mLayout.canScrollHorizontally()?this.mLayout.computeHorizontalScrollRange(this.mState):0;
   }

   public int computeVerticalScrollExtent() {
      return this.mLayout != null && this.mLayout.canScrollVertically()?this.mLayout.computeVerticalScrollExtent(this.mState):0;
   }

   public int computeVerticalScrollOffset() {
      return this.mLayout != null && this.mLayout.canScrollVertically()?this.mLayout.computeVerticalScrollOffset(this.mState):0;
   }

   public int computeVerticalScrollRange() {
      return this.mLayout != null && this.mLayout.canScrollVertically()?this.mLayout.computeVerticalScrollRange(this.mState):0;
   }

   void defaultOnMeasure(int var1, int var2) {
      this.setMeasuredDimension(RecyclerView$LayoutManager.chooseSize(var1, this.getPaddingLeft() + this.getPaddingRight(), ViewCompat.getMinimumWidth(this)), RecyclerView$LayoutManager.chooseSize(var2, this.getPaddingTop() + this.getPaddingBottom(), ViewCompat.getMinimumHeight(this)));
   }

   void dispatchLayout() {
      if(this.mAdapter == null) {
         Log.e("RecyclerView", "No adapter attached; skipping layout");
      } else if(this.mLayout == null) {
         Log.e("RecyclerView", "No layout manager attached; skipping layout");
      } else {
         RecyclerView$State.access$2202(this.mState, false);
         if(RecyclerView$State.access$2100(this.mState) == 1) {
            this.dispatchLayoutStep1();
            this.mLayout.setExactMeasureSpecsFrom(this);
            this.dispatchLayoutStep2();
         } else if(!this.mAdapterHelper.hasUpdates() && this.mLayout.getWidth() == this.getWidth() && this.mLayout.getHeight() == this.getHeight()) {
            this.mLayout.setExactMeasureSpecsFrom(this);
         } else {
            this.mLayout.setExactMeasureSpecsFrom(this);
            this.dispatchLayoutStep2();
         }

         this.dispatchLayoutStep3();
      }
   }

   public boolean dispatchNestedFling(float var1, float var2, boolean var3) {
      return this.mScrollingChildHelper.dispatchNestedFling(var1, var2, var3);
   }

   public boolean dispatchNestedPreFling(float var1, float var2) {
      return this.mScrollingChildHelper.dispatchNestedPreFling(var1, var2);
   }

   public boolean dispatchNestedPreScroll(int var1, int var2, int[] var3, int[] var4) {
      return this.mScrollingChildHelper.dispatchNestedPreScroll(var1, var2, var3, var4);
   }

   public boolean dispatchNestedScroll(int var1, int var2, int var3, int var4, int[] var5) {
      return this.mScrollingChildHelper.dispatchNestedScroll(var1, var2, var3, var4, var5);
   }

   void dispatchOnScrollStateChanged(int var1) {
      if(this.mLayout != null) {
         this.mLayout.onScrollStateChanged(var1);
      }

      this.onScrollStateChanged(var1);
      if(this.mScrollListener != null) {
         this.mScrollListener.onScrollStateChanged(this, var1);
      }

      if(this.mScrollListeners != null) {
         for(int var2 = this.mScrollListeners.size() - 1; var2 >= 0; --var2) {
            ((RecyclerView$OnScrollListener)this.mScrollListeners.get(var2)).onScrollStateChanged(this, var1);
         }
      }

   }

   void dispatchOnScrolled(int var1, int var2) {
      int var3 = this.getScrollX();
      int var4 = this.getScrollY();
      this.onScrollChanged(var3, var4, var3, var4);
      this.onScrolled(var1, var2);
      if(this.mScrollListener != null) {
         this.mScrollListener.onScrolled(this, var1, var2);
      }

      if(this.mScrollListeners != null) {
         for(var3 = this.mScrollListeners.size() - 1; var3 >= 0; --var3) {
            ((RecyclerView$OnScrollListener)this.mScrollListeners.get(var3)).onScrolled(this, var1, var2);
         }
      }

   }

   protected void dispatchRestoreInstanceState(SparseArray<Parcelable> var1) {
      this.dispatchThawSelfOnly(var1);
   }

   protected void dispatchSaveInstanceState(SparseArray<Parcelable> var1) {
      this.dispatchFreezeSelfOnly(var1);
   }

   public void draw(Canvas var1) {
      boolean var4 = true;
      super.draw(var1);
      int var3 = this.mItemDecorations.size();

      int var2;
      for(var2 = 0; var2 < var3; ++var2) {
         ((RecyclerView$ItemDecoration)this.mItemDecorations.get(var2)).onDrawOver(var1, this, this.mState);
      }

      boolean var7 = false;
      boolean var8 = var7;
      int var5;
      if(this.mLeftGlow != null) {
         var8 = var7;
         if(!this.mLeftGlow.isFinished()) {
            var5 = var1.save();
            if(this.mClipToPadding) {
               var2 = this.getPaddingBottom();
            } else {
               var2 = 0;
            }

            var1.rotate(270.0F);
            var1.translate((float)(-this.getHeight() + var2), 0.0F);
            if(this.mLeftGlow != null && this.mLeftGlow.draw(var1)) {
               var8 = true;
            } else {
               var8 = false;
            }

            var1.restoreToCount(var5);
         }
      }

      var7 = var8;
      if(this.mTopGlow != null) {
         var7 = var8;
         if(!this.mTopGlow.isFinished()) {
            var5 = var1.save();
            if(this.mClipToPadding) {
               var1.translate((float)this.getPaddingLeft(), (float)this.getPaddingTop());
            }

            if(this.mTopGlow != null && this.mTopGlow.draw(var1)) {
               var7 = true;
            } else {
               var7 = false;
            }

            var7 |= var8;
            var1.restoreToCount(var5);
         }
      }

      var8 = var7;
      if(this.mRightGlow != null) {
         var8 = var7;
         if(!this.mRightGlow.isFinished()) {
            var5 = var1.save();
            int var6 = this.getWidth();
            if(this.mClipToPadding) {
               var3 = this.getPaddingTop();
            } else {
               var3 = 0;
            }

            var1.rotate(90.0F);
            var1.translate((float)(-var3), (float)(-var6));
            if(this.mRightGlow != null && this.mRightGlow.draw(var1)) {
               var8 = true;
            } else {
               var8 = false;
            }

            var8 |= var7;
            var1.restoreToCount(var5);
         }
      }

      var7 = var8;
      if(this.mBottomGlow != null) {
         var7 = var8;
         if(!this.mBottomGlow.isFinished()) {
            var5 = var1.save();
            var1.rotate(180.0F);
            if(this.mClipToPadding) {
               var1.translate((float)(-this.getWidth() + this.getPaddingRight()), (float)(-this.getHeight() + this.getPaddingBottom()));
            } else {
               var1.translate((float)(-this.getWidth()), (float)(-this.getHeight()));
            }

            if(this.mBottomGlow != null && this.mBottomGlow.draw(var1)) {
               var7 = var4;
            } else {
               var7 = false;
            }

            var7 |= var8;
            var1.restoreToCount(var5);
         }
      }

      var8 = var7;
      if(!var7) {
         var8 = var7;
         if(this.mItemAnimator != null) {
            var8 = var7;
            if(this.mItemDecorations.size() > 0) {
               var8 = var7;
               if(this.mItemAnimator.isRunning()) {
                  var8 = true;
               }
            }
         }
      }

      if(var8) {
         ViewCompat.postInvalidateOnAnimation(this);
      }

   }

   public boolean drawChild(Canvas var1, View var2, long var3) {
      return super.drawChild(var1, var2, var3);
   }

   void eatRequestLayout() {
      ++this.mEatRequestLayout;
      if(this.mEatRequestLayout == 1 && !this.mLayoutFrozen) {
         this.mLayoutRequestEaten = false;
      }

   }

   void ensureBottomGlow() {
      if(this.mBottomGlow == null) {
         this.mBottomGlow = new EdgeEffectCompat(this.getContext());
         if(this.mClipToPadding) {
            this.mBottomGlow.setSize(this.getMeasuredWidth() - this.getPaddingLeft() - this.getPaddingRight(), this.getMeasuredHeight() - this.getPaddingTop() - this.getPaddingBottom());
         } else {
            this.mBottomGlow.setSize(this.getMeasuredWidth(), this.getMeasuredHeight());
         }
      }
   }

   void ensureLeftGlow() {
      if(this.mLeftGlow == null) {
         this.mLeftGlow = new EdgeEffectCompat(this.getContext());
         if(this.mClipToPadding) {
            this.mLeftGlow.setSize(this.getMeasuredHeight() - this.getPaddingTop() - this.getPaddingBottom(), this.getMeasuredWidth() - this.getPaddingLeft() - this.getPaddingRight());
         } else {
            this.mLeftGlow.setSize(this.getMeasuredHeight(), this.getMeasuredWidth());
         }
      }
   }

   void ensureRightGlow() {
      if(this.mRightGlow == null) {
         this.mRightGlow = new EdgeEffectCompat(this.getContext());
         if(this.mClipToPadding) {
            this.mRightGlow.setSize(this.getMeasuredHeight() - this.getPaddingTop() - this.getPaddingBottom(), this.getMeasuredWidth() - this.getPaddingLeft() - this.getPaddingRight());
         } else {
            this.mRightGlow.setSize(this.getMeasuredHeight(), this.getMeasuredWidth());
         }
      }
   }

   void ensureTopGlow() {
      if(this.mTopGlow == null) {
         this.mTopGlow = new EdgeEffectCompat(this.getContext());
         if(this.mClipToPadding) {
            this.mTopGlow.setSize(this.getMeasuredWidth() - this.getPaddingLeft() - this.getPaddingRight(), this.getMeasuredHeight() - this.getPaddingTop() - this.getPaddingBottom());
         } else {
            this.mTopGlow.setSize(this.getMeasuredWidth(), this.getMeasuredHeight());
         }
      }
   }

   public View findChildViewUnder(float var1, float var2) {
      for(int var5 = this.mChildHelper.getChildCount() - 1; var5 >= 0; --var5) {
         View var6 = this.mChildHelper.getChildAt(var5);
         float var3 = ViewCompat.getTranslationX(var6);
         float var4 = ViewCompat.getTranslationY(var6);
         if(var1 >= (float)var6.getLeft() + var3 && var1 <= (float)var6.getRight() + var3 && var2 >= (float)var6.getTop() + var4 && var2 <= (float)var6.getBottom() + var4) {
            return var6;
         }
      }

      return null;
   }

   @Nullable
   public View findContainingItemView(View var1) {
      ViewParent var3 = var1.getParent();
      View var2 = var1;

      ViewParent var4;
      for(var4 = var3; var4 != null && var4 != this && var4 instanceof View; var4 = var2.getParent()) {
         var2 = (View)var4;
      }

      return var4 == this?var2:null;
   }

   @Nullable
   public RecyclerView$ViewHolder findContainingViewHolder(View var1) {
      var1 = this.findContainingItemView(var1);
      return var1 == null?null:this.getChildViewHolder(var1);
   }

   public RecyclerView$ViewHolder findViewHolderForAdapterPosition(int var1) {
      RecyclerView$ViewHolder var4;
      if(this.mDataSetHasChangedAfterLayout) {
         var4 = null;
      } else {
         int var3 = this.mChildHelper.getUnfilteredChildCount();
         int var2 = 0;

         while(true) {
            if(var2 >= var3) {
               return null;
            }

            RecyclerView$ViewHolder var5 = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(var2));
            if(var5 != null && !var5.isRemoved()) {
               var4 = var5;
               if(this.getAdapterPositionFor(var5) == var1) {
                  break;
               }
            }

            ++var2;
         }
      }

      return var4;
   }

   public RecyclerView$ViewHolder findViewHolderForItemId(long var1) {
      int var4 = this.mChildHelper.getUnfilteredChildCount();

      for(int var3 = 0; var3 < var4; ++var3) {
         RecyclerView$ViewHolder var5 = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(var3));
         if(var5 != null && var5.getItemId() == var1) {
            return var5;
         }
      }

      return null;
   }

   public RecyclerView$ViewHolder findViewHolderForLayoutPosition(int var1) {
      return this.findViewHolderForPosition(var1, false);
   }

   @Deprecated
   public RecyclerView$ViewHolder findViewHolderForPosition(int var1) {
      return this.findViewHolderForPosition(var1, false);
   }

   RecyclerView$ViewHolder findViewHolderForPosition(int var1, boolean var2) {
      int var4 = this.mChildHelper.getUnfilteredChildCount();
      int var3 = 0;

      RecyclerView$ViewHolder var5;
      while(true) {
         if(var3 >= var4) {
            return null;
         }

         var5 = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(var3));
         if(var5 != null && !var5.isRemoved()) {
            if(var2) {
               if(var5.mPosition == var1) {
                  break;
               }
            } else if(var5.getLayoutPosition() == var1) {
               break;
            }
         }

         ++var3;
      }

      return var5;
   }

   public boolean fling(int var1, int var2) {
      if(this.mLayout == null) {
         Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
      } else if(!this.mLayoutFrozen) {
         int var3;
         boolean var4;
         boolean var5;
         label42: {
            var4 = this.mLayout.canScrollHorizontally();
            var5 = this.mLayout.canScrollVertically();
            if(var4) {
               var3 = var1;
               if(Math.abs(var1) >= this.mMinFlingVelocity) {
                  break label42;
               }
            }

            var3 = 0;
         }

         label37: {
            if(var5) {
               var1 = var2;
               if(Math.abs(var2) >= this.mMinFlingVelocity) {
                  break label37;
               }
            }

            var1 = 0;
         }

         if((var3 != 0 || var1 != 0) && !this.dispatchNestedPreFling((float)var3, (float)var1)) {
            if(!var4 && !var5) {
               var4 = false;
            } else {
               var4 = true;
            }

            this.dispatchNestedFling((float)var3, (float)var1, var4);
            if(var4) {
               var2 = Math.max(-this.mMaxFlingVelocity, Math.min(var3, this.mMaxFlingVelocity));
               var1 = Math.max(-this.mMaxFlingVelocity, Math.min(var1, this.mMaxFlingVelocity));
               this.mViewFlinger.fling(var2, var1);
               return true;
            }
         }
      }

      return false;
   }

   public View focusSearch(View var1, int var2) {
      View var3 = this.mLayout.onInterceptFocusSearch(var1, var2);
      if(var3 != null) {
         return var3;
      } else {
         View var4 = FocusFinder.getInstance().findNextFocus(this, var1, var2);
         var3 = var4;
         if(var4 == null) {
            var3 = var4;
            if(this.mAdapter != null) {
               var3 = var4;
               if(this.mLayout != null) {
                  var3 = var4;
                  if(!this.isComputingLayout()) {
                     var3 = var4;
                     if(!this.mLayoutFrozen) {
                        this.eatRequestLayout();
                        var3 = this.mLayout.onFocusSearchFailed(var1, var2, this.mRecycler, this.mState);
                        this.resumeRequestLayout(false);
                     }
                  }
               }
            }
         }

         return var3 != null?var3:super.focusSearch(var1, var2);
      }
   }

   protected LayoutParams generateDefaultLayoutParams() {
      if(this.mLayout == null) {
         throw new IllegalStateException("RecyclerView has no LayoutManager");
      } else {
         return this.mLayout.generateDefaultLayoutParams();
      }
   }

   public LayoutParams generateLayoutParams(AttributeSet var1) {
      if(this.mLayout == null) {
         throw new IllegalStateException("RecyclerView has no LayoutManager");
      } else {
         return this.mLayout.generateLayoutParams(this.getContext(), var1);
      }
   }

   protected LayoutParams generateLayoutParams(LayoutParams var1) {
      if(this.mLayout == null) {
         throw new IllegalStateException("RecyclerView has no LayoutManager");
      } else {
         return this.mLayout.generateLayoutParams(var1);
      }
   }

   public RecyclerView$Adapter getAdapter() {
      return this.mAdapter;
   }

   public int getBaseline() {
      return this.mLayout != null?this.mLayout.getBaseline():super.getBaseline();
   }

   long getChangedHolderKey(RecyclerView$ViewHolder var1) {
      return this.mAdapter.hasStableIds()?var1.getItemId():(long)var1.mPosition;
   }

   public int getChildAdapterPosition(View var1) {
      RecyclerView$ViewHolder var2 = getChildViewHolderInt(var1);
      return var2 != null?var2.getAdapterPosition():-1;
   }

   protected int getChildDrawingOrder(int var1, int var2) {
      return this.mChildDrawingOrderCallback == null?super.getChildDrawingOrder(var1, var2):this.mChildDrawingOrderCallback.onGetChildDrawingOrder(var1, var2);
   }

   public long getChildItemId(View var1) {
      if(this.mAdapter != null && this.mAdapter.hasStableIds()) {
         RecyclerView$ViewHolder var2 = getChildViewHolderInt(var1);
         if(var2 != null) {
            return var2.getItemId();
         }
      }

      return -1L;
   }

   public int getChildLayoutPosition(View var1) {
      RecyclerView$ViewHolder var2 = getChildViewHolderInt(var1);
      return var2 != null?var2.getLayoutPosition():-1;
   }

   @Deprecated
   public int getChildPosition(View var1) {
      return this.getChildAdapterPosition(var1);
   }

   public RecyclerView$ViewHolder getChildViewHolder(View var1) {
      ViewParent var2 = var1.getParent();
      if(var2 != null && var2 != this) {
         throw new IllegalArgumentException("View " + var1 + " is not a direct child of " + this);
      } else {
         return getChildViewHolderInt(var1);
      }
   }

   public RecyclerViewAccessibilityDelegate getCompatAccessibilityDelegate() {
      return this.mAccessibilityDelegate;
   }

   public RecyclerView$ItemAnimator getItemAnimator() {
      return this.mItemAnimator;
   }

   Rect getItemDecorInsetsForChild(View var1) {
      RecyclerView$LayoutParams var4 = (RecyclerView$LayoutParams)var1.getLayoutParams();
      if(!var4.mInsetsDirty) {
         return var4.mDecorInsets;
      } else {
         Rect var5 = var4.mDecorInsets;
         var5.set(0, 0, 0, 0);
         int var3 = this.mItemDecorations.size();

         for(int var2 = 0; var2 < var3; ++var2) {
            this.mTempRect.set(0, 0, 0, 0);
            ((RecyclerView$ItemDecoration)this.mItemDecorations.get(var2)).getItemOffsets(this.mTempRect, var1, this, this.mState);
            var5.left += this.mTempRect.left;
            var5.top += this.mTempRect.top;
            var5.right += this.mTempRect.right;
            var5.bottom += this.mTempRect.bottom;
         }

         var4.mInsetsDirty = false;
         return var5;
      }
   }

   public RecyclerView$LayoutManager getLayoutManager() {
      return this.mLayout;
   }

   public int getMaxFlingVelocity() {
      return this.mMaxFlingVelocity;
   }

   public int getMinFlingVelocity() {
      return this.mMinFlingVelocity;
   }

   public RecyclerView$RecycledViewPool getRecycledViewPool() {
      return this.mRecycler.getRecycledViewPool();
   }

   public int getScrollState() {
      return this.mScrollState;
   }

   public boolean hasFixedSize() {
      return this.mHasFixedSize;
   }

   public boolean hasNestedScrollingParent() {
      return this.mScrollingChildHelper.hasNestedScrollingParent();
   }

   public boolean hasPendingAdapterUpdates() {
      return !this.mFirstLayoutComplete || this.mDataSetHasChangedAfterLayout || this.mAdapterHelper.hasPendingUpdates();
   }

   void initAdapterManager() {
      this.mAdapterHelper = new AdapterHelper(new RecyclerView$6(this));
   }

   void invalidateGlows() {
      this.mBottomGlow = null;
      this.mTopGlow = null;
      this.mRightGlow = null;
      this.mLeftGlow = null;
   }

   public void invalidateItemDecorations() {
      if(this.mItemDecorations.size() != 0) {
         if(this.mLayout != null) {
            this.mLayout.assertNotInLayoutOrScroll("Cannot invalidate item decorations during a scroll or layout");
         }

         this.markItemDecorInsetsDirty();
         this.requestLayout();
      }
   }

   boolean isAccessibilityEnabled() {
      return this.mAccessibilityManager != null && this.mAccessibilityManager.isEnabled();
   }

   public boolean isAnimating() {
      return this.mItemAnimator != null && this.mItemAnimator.isRunning();
   }

   public boolean isAttachedToWindow() {
      return this.mIsAttached;
   }

   public boolean isComputingLayout() {
      return this.mLayoutOrScrollCounter > 0;
   }

   public boolean isLayoutFrozen() {
      return this.mLayoutFrozen;
   }

   public boolean isNestedScrollingEnabled() {
      return this.mScrollingChildHelper.isNestedScrollingEnabled();
   }

   void markItemDecorInsetsDirty() {
      int var2 = this.mChildHelper.getUnfilteredChildCount();

      for(int var1 = 0; var1 < var2; ++var1) {
         ((RecyclerView$LayoutParams)this.mChildHelper.getUnfilteredChildAt(var1).getLayoutParams()).mInsetsDirty = true;
      }

      this.mRecycler.markItemDecorInsetsDirty();
   }

   void markKnownViewsInvalid() {
      int var2 = this.mChildHelper.getUnfilteredChildCount();

      for(int var1 = 0; var1 < var2; ++var1) {
         RecyclerView$ViewHolder var3 = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(var1));
         if(var3 != null && !var3.shouldIgnore()) {
            var3.addFlags(6);
         }
      }

      this.markItemDecorInsetsDirty();
      this.mRecycler.markKnownViewsInvalid();
   }

   public void offsetChildrenHorizontal(int var1) {
      int var3 = this.mChildHelper.getChildCount();

      for(int var2 = 0; var2 < var3; ++var2) {
         this.mChildHelper.getChildAt(var2).offsetLeftAndRight(var1);
      }

   }

   public void offsetChildrenVertical(int var1) {
      int var3 = this.mChildHelper.getChildCount();

      for(int var2 = 0; var2 < var3; ++var2) {
         this.mChildHelper.getChildAt(var2).offsetTopAndBottom(var1);
      }

   }

   void offsetPositionRecordsForInsert(int var1, int var2) {
      int var4 = this.mChildHelper.getUnfilteredChildCount();

      for(int var3 = 0; var3 < var4; ++var3) {
         RecyclerView$ViewHolder var5 = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(var3));
         if(var5 != null && !var5.shouldIgnore() && var5.mPosition >= var1) {
            var5.offsetPosition(var2, false);
            RecyclerView$State.access$1802(this.mState, true);
         }
      }

      this.mRecycler.offsetPositionRecordsForInsert(var1, var2);
      this.requestLayout();
   }

   void offsetPositionRecordsForMove(int var1, int var2) {
      int var7 = this.mChildHelper.getUnfilteredChildCount();
      int var3;
      byte var4;
      int var5;
      if(var1 < var2) {
         var5 = var1;
         var3 = var2;
         var4 = -1;
      } else {
         var5 = var2;
         var3 = var1;
         var4 = 1;
      }

      for(int var6 = 0; var6 < var7; ++var6) {
         RecyclerView$ViewHolder var8 = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(var6));
         if(var8 != null && var8.mPosition >= var5 && var8.mPosition <= var3) {
            if(var8.mPosition == var1) {
               var8.offsetPosition(var2 - var1, false);
            } else {
               var8.offsetPosition(var4, false);
            }

            RecyclerView$State.access$1802(this.mState, true);
         }
      }

      this.mRecycler.offsetPositionRecordsForMove(var1, var2);
      this.requestLayout();
   }

   void offsetPositionRecordsForRemove(int var1, int var2, boolean var3) {
      int var5 = this.mChildHelper.getUnfilteredChildCount();

      for(int var4 = 0; var4 < var5; ++var4) {
         RecyclerView$ViewHolder var6 = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(var4));
         if(var6 != null && !var6.shouldIgnore()) {
            if(var6.mPosition >= var1 + var2) {
               var6.offsetPosition(-var2, var3);
               RecyclerView$State.access$1802(this.mState, true);
            } else if(var6.mPosition >= var1) {
               var6.flagRemovedAndOffsetPosition(var1 - 1, -var2, var3);
               RecyclerView$State.access$1802(this.mState, true);
            }
         }
      }

      this.mRecycler.offsetPositionRecordsForRemove(var1, var2, var3);
      this.requestLayout();
   }

   protected void onAttachedToWindow() {
      super.onAttachedToWindow();
      this.mLayoutOrScrollCounter = 0;
      this.mIsAttached = true;
      this.mFirstLayoutComplete = false;
      if(this.mLayout != null) {
         this.mLayout.dispatchAttachedToWindow(this);
      }

      this.mPostedAnimatorRunner = false;
   }

   public void onChildAttachedToWindow(View var1) {
   }

   public void onChildDetachedFromWindow(View var1) {
   }

   protected void onDetachedFromWindow() {
      super.onDetachedFromWindow();
      if(this.mItemAnimator != null) {
         this.mItemAnimator.endAnimations();
      }

      this.mFirstLayoutComplete = false;
      this.stopScroll();
      this.mIsAttached = false;
      if(this.mLayout != null) {
         this.mLayout.dispatchDetachedFromWindow(this, this.mRecycler);
      }

      this.removeCallbacks(this.mItemAnimatorRunner);
      this.mViewInfoStore.onDetach();
   }

   public void onDraw(Canvas var1) {
      super.onDraw(var1);
      int var3 = this.mItemDecorations.size();

      for(int var2 = 0; var2 < var3; ++var2) {
         ((RecyclerView$ItemDecoration)this.mItemDecorations.get(var2)).onDraw(var1, this, this.mState);
      }

   }

   public boolean onGenericMotionEvent(MotionEvent var1) {
      if(this.mLayout != null && !this.mLayoutFrozen && (MotionEventCompat.getSource(var1) & 2) != 0 && var1.getAction() == 8) {
         float var2;
         if(this.mLayout.canScrollVertically()) {
            var2 = -MotionEventCompat.getAxisValue(var1, 9);
         } else {
            var2 = 0.0F;
         }

         float var3;
         if(this.mLayout.canScrollHorizontally()) {
            var3 = MotionEventCompat.getAxisValue(var1, 10);
         } else {
            var3 = 0.0F;
         }

         if(var2 != 0.0F || var3 != 0.0F) {
            float var4 = this.getScrollFactor();
            this.scrollByInternal((int)(var3 * var4), (int)(var2 * var4), var1);
            return false;
         }
      }

      return false;
   }

   public boolean onInterceptTouchEvent(MotionEvent var1) {
      if(this.mLayoutFrozen) {
         return false;
      } else if(this.dispatchOnItemTouchIntercept(var1)) {
         this.cancelTouch();
         return true;
      } else if(this.mLayout == null) {
         return false;
      } else {
         boolean var7 = this.mLayout.canScrollHorizontally();
         boolean var8 = this.mLayout.canScrollVertically();
         if(this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
         }

         this.mVelocityTracker.addMovement(var1);
         int var3 = MotionEventCompat.getActionMasked(var1);
         int var2 = MotionEventCompat.getActionIndex(var1);
         switch(var3) {
         case 0:
            if(this.mIgnoreMotionEventTillDown) {
               this.mIgnoreMotionEventTillDown = false;
            }

            this.mScrollPointerId = MotionEventCompat.getPointerId(var1, 0);
            var2 = (int)(var1.getX() + 0.5F);
            this.mLastTouchX = var2;
            this.mInitialTouchX = var2;
            var2 = (int)(var1.getY() + 0.5F);
            this.mLastTouchY = var2;
            this.mInitialTouchY = var2;
            if(this.mScrollState == 2) {
               this.getParent().requestDisallowInterceptTouchEvent(true);
               this.setScrollState(1);
            }

            int[] var9 = this.mNestedOffsets;
            this.mNestedOffsets[1] = 0;
            var9[0] = 0;
            var2 = 0;
            if(var7) {
               var2 = 0 | 1;
            }

            var3 = var2;
            if(var8) {
               var3 = var2 | 2;
            }

            this.startNestedScroll(var3);
            break;
         case 1:
            this.mVelocityTracker.clear();
            this.stopNestedScroll();
            break;
         case 2:
            var3 = MotionEventCompat.findPointerIndex(var1, this.mScrollPointerId);
            if(var3 < 0) {
               Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.mScrollPointerId + " not found. Did any MotionEvents get skipped?");
               return false;
            }

            var2 = (int)(MotionEventCompat.getX(var1, var3) + 0.5F);
            var3 = (int)(MotionEventCompat.getY(var1, var3) + 0.5F);
            if(this.mScrollState != 1) {
               int var5 = var2 - this.mInitialTouchX;
               int var4 = var3 - this.mInitialTouchY;
               boolean var12 = false;
               boolean var10 = var12;
               byte var11;
               if(var7) {
                  var10 = var12;
                  if(Math.abs(var5) > this.mTouchSlop) {
                     var3 = this.mInitialTouchX;
                     int var6 = this.mTouchSlop;
                     if(var5 < 0) {
                        var11 = -1;
                     } else {
                        var11 = 1;
                     }

                     this.mLastTouchX = var11 * var6 + var3;
                     var10 = true;
                  }
               }

               var12 = var10;
               if(var8) {
                  var12 = var10;
                  if(Math.abs(var4) > this.mTouchSlop) {
                     var3 = this.mInitialTouchY;
                     var5 = this.mTouchSlop;
                     if(var4 < 0) {
                        var11 = -1;
                     } else {
                        var11 = 1;
                     }

                     this.mLastTouchY = var11 * var5 + var3;
                     var12 = true;
                  }
               }

               if(var12) {
                  this.setScrollState(1);
               }
            }
            break;
         case 3:
            this.cancelTouch();
         case 4:
         default:
            break;
         case 5:
            this.mScrollPointerId = MotionEventCompat.getPointerId(var1, var2);
            var3 = (int)(MotionEventCompat.getX(var1, var2) + 0.5F);
            this.mLastTouchX = var3;
            this.mInitialTouchX = var3;
            var2 = (int)(MotionEventCompat.getY(var1, var2) + 0.5F);
            this.mLastTouchY = var2;
            this.mInitialTouchY = var2;
            break;
         case 6:
            this.onPointerUp(var1);
         }

         return this.mScrollState == 1;
      }
   }

   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      TraceCompat.beginSection("RV OnLayout");
      this.dispatchLayout();
      TraceCompat.endSection();
      this.mFirstLayoutComplete = true;
   }

   protected void onMeasure(int var1, int var2) {
      boolean var4 = false;
      if(this.mLayout == null) {
         this.defaultOnMeasure(var1, var2);
      } else {
         if(!RecyclerView$LayoutManager.access$2000(this.mLayout)) {
            if(this.mHasFixedSize) {
               this.mLayout.onMeasure(this.mRecycler, this.mState, var1, var2);
               return;
            }

            if(this.mAdapterUpdateDuringMeasure) {
               this.eatRequestLayout();
               this.processAdapterUpdatesAndSetAnimationFlags();
               if(RecyclerView$State.access$2300(this.mState)) {
                  RecyclerView$State.access$2402(this.mState, true);
               } else {
                  this.mAdapterHelper.consumeUpdatesInOnePass();
                  RecyclerView$State.access$2402(this.mState, false);
               }

               this.mAdapterUpdateDuringMeasure = false;
               this.resumeRequestLayout(false);
            }

            if(this.mAdapter != null) {
               this.mState.mItemCount = this.mAdapter.getItemCount();
            } else {
               this.mState.mItemCount = 0;
            }

            this.eatRequestLayout();
            this.mLayout.onMeasure(this.mRecycler, this.mState, var1, var2);
            this.resumeRequestLayout(false);
            RecyclerView$State.access$2402(this.mState, false);
            return;
         }

         int var5 = MeasureSpec.getMode(var1);
         int var6 = MeasureSpec.getMode(var2);
         boolean var3 = var4;
         if(var5 == 1073741824) {
            var3 = var4;
            if(var6 == 1073741824) {
               var3 = true;
            }
         }

         this.mLayout.onMeasure(this.mRecycler, this.mState, var1, var2);
         if(!var3 && this.mAdapter != null) {
            if(RecyclerView$State.access$2100(this.mState) == 1) {
               this.dispatchLayoutStep1();
            }

            this.mLayout.setMeasureSpecs(var1, var2);
            RecyclerView$State.access$2202(this.mState, true);
            this.dispatchLayoutStep2();
            this.mLayout.setMeasuredDimensionFromChildren(var1, var2);
            if(this.mLayout.shouldMeasureTwice()) {
               this.mLayout.setMeasureSpecs(MeasureSpec.makeMeasureSpec(this.getMeasuredWidth(), 1073741824), MeasureSpec.makeMeasureSpec(this.getMeasuredHeight(), 1073741824));
               RecyclerView$State.access$2202(this.mState, true);
               this.dispatchLayoutStep2();
               this.mLayout.setMeasuredDimensionFromChildren(var1, var2);
               return;
            }
         }
      }

   }

   protected void onRestoreInstanceState(Parcelable var1) {
      this.mPendingSavedState = (RecyclerView$SavedState)var1;
      super.onRestoreInstanceState(this.mPendingSavedState.getSuperState());
      if(this.mLayout != null && this.mPendingSavedState.mLayoutState != null) {
         this.mLayout.onRestoreInstanceState(this.mPendingSavedState.mLayoutState);
      }

   }

   protected Parcelable onSaveInstanceState() {
      RecyclerView$SavedState var1 = new RecyclerView$SavedState(super.onSaveInstanceState());
      if(this.mPendingSavedState != null) {
         RecyclerView$SavedState.access$1900(var1, this.mPendingSavedState);
         return var1;
      } else if(this.mLayout != null) {
         var1.mLayoutState = this.mLayout.onSaveInstanceState();
         return var1;
      } else {
         var1.mLayoutState = null;
         return var1;
      }
   }

   public void onScrollStateChanged(int var1) {
   }

   public void onScrolled(int var1, int var2) {
   }

   protected void onSizeChanged(int var1, int var2, int var3, int var4) {
      super.onSizeChanged(var1, var2, var3, var4);
      if(var1 != var3 || var2 != var4) {
         this.invalidateGlows();
      }

   }

   public boolean onTouchEvent(MotionEvent var1) {
      if(!this.mLayoutFrozen && !this.mIgnoreMotionEventTillDown) {
         if(this.dispatchOnItemTouch(var1)) {
            this.cancelTouch();
            return true;
         } else if(this.mLayout == null) {
            return false;
         } else {
            boolean var13 = this.mLayout.canScrollHorizontally();
            boolean var14 = this.mLayout.canScrollVertically();
            if(this.mVelocityTracker == null) {
               this.mVelocityTracker = VelocityTracker.obtain();
            }

            boolean var10 = false;
            MotionEvent var15 = MotionEvent.obtain(var1);
            int var6 = MotionEventCompat.getActionMasked(var1);
            int var5 = MotionEventCompat.getActionIndex(var1);
            if(var6 == 0) {
               int[] var16 = this.mNestedOffsets;
               this.mNestedOffsets[1] = 0;
               var16[0] = 0;
            }

            var15.offsetLocation((float)this.mNestedOffsets[0], (float)this.mNestedOffsets[1]);
            boolean var4 = var10;
            int var18;
            switch(var6) {
            case 0:
               this.mScrollPointerId = MotionEventCompat.getPointerId(var1, 0);
               var18 = (int)(var1.getX() + 0.5F);
               this.mLastTouchX = var18;
               this.mInitialTouchX = var18;
               var18 = (int)(var1.getY() + 0.5F);
               this.mLastTouchY = var18;
               this.mInitialTouchY = var18;
               var18 = 0;
               if(var13) {
                  var18 = 0 | 1;
               }

               var5 = var18;
               if(var14) {
                  var5 = var18 | 2;
               }

               this.startNestedScroll(var5);
               var4 = var10;
               break;
            case 1:
               this.mVelocityTracker.addMovement(var15);
               var4 = true;
               this.mVelocityTracker.computeCurrentVelocity(1000, (float)this.mMaxFlingVelocity);
               float var2;
               if(var13) {
                  var2 = -VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, this.mScrollPointerId);
               } else {
                  var2 = 0.0F;
               }

               float var3;
               if(var14) {
                  var3 = -VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, this.mScrollPointerId);
               } else {
                  var3 = 0.0F;
               }

               if(var2 == 0.0F && var3 == 0.0F || !this.fling((int)var2, (int)var3)) {
                  this.setScrollState(0);
               }

               this.resetTouch();
               break;
            case 2:
               var18 = MotionEventCompat.findPointerIndex(var1, this.mScrollPointerId);
               if(var18 < 0) {
                  Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.mScrollPointerId + " not found. Did any MotionEvents get skipped?");
                  return false;
               }

               int var11 = (int)(MotionEventCompat.getX(var1, var18) + 0.5F);
               int var12 = (int)(MotionEventCompat.getY(var1, var18) + 0.5F);
               int var7 = this.mLastTouchX - var11;
               var6 = this.mLastTouchY - var12;
               var5 = var7;
               var18 = var6;
               if(this.dispatchNestedPreScroll(var7, var6, this.mScrollConsumed, this.mScrollOffset)) {
                  var5 = var7 - this.mScrollConsumed[0];
                  var18 = var6 - this.mScrollConsumed[1];
                  var15.offsetLocation((float)this.mScrollOffset[0], (float)this.mScrollOffset[1]);
                  int[] var17 = this.mNestedOffsets;
                  var17[0] += this.mScrollOffset[0];
                  var17 = this.mNestedOffsets;
                  var17[1] += this.mScrollOffset[1];
               }

               int var8 = var5;
               var7 = var18;
               if(this.mScrollState != 1) {
                  boolean var20 = false;
                  var6 = var5;
                  boolean var19 = var20;
                  if(var13) {
                     var6 = var5;
                     var19 = var20;
                     if(Math.abs(var5) > this.mTouchSlop) {
                        if(var5 > 0) {
                           var6 = var5 - this.mTouchSlop;
                        } else {
                           var6 = var5 + this.mTouchSlop;
                        }

                        var19 = true;
                     }
                  }

                  var5 = var18;
                  boolean var9 = var19;
                  if(var14) {
                     var5 = var18;
                     var9 = var19;
                     if(Math.abs(var18) > this.mTouchSlop) {
                        if(var18 > 0) {
                           var5 = var18 - this.mTouchSlop;
                        } else {
                           var5 = var18 + this.mTouchSlop;
                        }

                        var9 = true;
                     }
                  }

                  var8 = var6;
                  var7 = var5;
                  if(var9) {
                     this.setScrollState(1);
                     var7 = var5;
                     var8 = var6;
                  }
               }

               var4 = var10;
               if(this.mScrollState == 1) {
                  this.mLastTouchX = var11 - this.mScrollOffset[0];
                  this.mLastTouchY = var12 - this.mScrollOffset[1];
                  if(!var13) {
                     var8 = 0;
                  }

                  if(!var14) {
                     var7 = 0;
                  }

                  var4 = var10;
                  if(this.scrollByInternal(var8, var7, var15)) {
                     this.getParent().requestDisallowInterceptTouchEvent(true);
                     var4 = var10;
                  }
               }
               break;
            case 3:
               this.cancelTouch();
               var4 = var10;
            case 4:
               break;
            case 5:
               this.mScrollPointerId = MotionEventCompat.getPointerId(var1, var5);
               var18 = (int)(MotionEventCompat.getX(var1, var5) + 0.5F);
               this.mLastTouchX = var18;
               this.mInitialTouchX = var18;
               var18 = (int)(MotionEventCompat.getY(var1, var5) + 0.5F);
               this.mLastTouchY = var18;
               this.mInitialTouchY = var18;
               var4 = var10;
               break;
            case 6:
               this.onPointerUp(var1);
               var4 = var10;
               break;
            default:
               var4 = var10;
            }

            if(!var4) {
               this.mVelocityTracker.addMovement(var15);
            }

            var15.recycle();
            return true;
         }
      } else {
         return false;
      }
   }

   protected void removeDetachedView(View var1, boolean var2) {
      RecyclerView$ViewHolder var3 = getChildViewHolderInt(var1);
      if(var3 != null) {
         if(var3.isTmpDetached()) {
            var3.clearTmpDetachFlag();
         } else if(!var3.shouldIgnore()) {
            throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + var3);
         }
      }

      this.dispatchChildDetached(var1);
      super.removeDetachedView(var1, var2);
   }

   public void removeItemDecoration(RecyclerView$ItemDecoration var1) {
      if(this.mLayout != null) {
         this.mLayout.assertNotInLayoutOrScroll("Cannot remove item decoration during a scroll  or layout");
      }

      this.mItemDecorations.remove(var1);
      if(this.mItemDecorations.isEmpty()) {
         boolean var2;
         if(ViewCompat.getOverScrollMode(this) == 2) {
            var2 = true;
         } else {
            var2 = false;
         }

         this.setWillNotDraw(var2);
      }

      this.markItemDecorInsetsDirty();
      this.requestLayout();
   }

   public void removeOnChildAttachStateChangeListener(RecyclerView$OnChildAttachStateChangeListener var1) {
      if(this.mOnChildAttachStateListeners != null) {
         this.mOnChildAttachStateListeners.remove(var1);
      }
   }

   public void removeOnItemTouchListener(RecyclerView$OnItemTouchListener var1) {
      this.mOnItemTouchListeners.remove(var1);
      if(this.mActiveOnItemTouchListener == var1) {
         this.mActiveOnItemTouchListener = null;
      }

   }

   public void removeOnScrollListener(RecyclerView$OnScrollListener var1) {
      if(this.mScrollListeners != null) {
         this.mScrollListeners.remove(var1);
      }

   }

   public void requestChildFocus(View var1, View var2) {
      boolean var3 = false;
      if(!this.mLayout.onRequestChildFocus(this, this.mState, var1, var2) && var2 != null) {
         this.mTempRect.set(0, 0, var2.getWidth(), var2.getHeight());
         LayoutParams var4 = var2.getLayoutParams();
         Rect var7;
         if(var4 instanceof RecyclerView$LayoutParams) {
            RecyclerView$LayoutParams var6 = (RecyclerView$LayoutParams)var4;
            if(!var6.mInsetsDirty) {
               var7 = var6.mDecorInsets;
               Rect var5 = this.mTempRect;
               var5.left -= var7.left;
               var5 = this.mTempRect;
               var5.right += var7.right;
               var5 = this.mTempRect;
               var5.top -= var7.top;
               var5 = this.mTempRect;
               var5.bottom += var7.bottom;
            }
         }

         this.offsetDescendantRectToMyCoords(var2, this.mTempRect);
         this.offsetRectIntoDescendantCoords(var1, this.mTempRect);
         var7 = this.mTempRect;
         if(!this.mFirstLayoutComplete) {
            var3 = true;
         }

         this.requestChildRectangleOnScreen(var1, var7, var3);
      }

      super.requestChildFocus(var1, var2);
   }

   public boolean requestChildRectangleOnScreen(View var1, Rect var2, boolean var3) {
      return this.mLayout.requestChildRectangleOnScreen(this, var1, var2, var3);
   }

   public void requestDisallowInterceptTouchEvent(boolean var1) {
      int var3 = this.mOnItemTouchListeners.size();

      for(int var2 = 0; var2 < var3; ++var2) {
         ((RecyclerView$OnItemTouchListener)this.mOnItemTouchListeners.get(var2)).onRequestDisallowInterceptTouchEvent(var1);
      }

      super.requestDisallowInterceptTouchEvent(var1);
   }

   public void requestLayout() {
      if(this.mEatRequestLayout == 0 && !this.mLayoutFrozen) {
         super.requestLayout();
      } else {
         this.mLayoutRequestEaten = true;
      }
   }

   void resumeRequestLayout(boolean var1) {
      if(this.mEatRequestLayout < 1) {
         this.mEatRequestLayout = 1;
      }

      if(!var1) {
         this.mLayoutRequestEaten = false;
      }

      if(this.mEatRequestLayout == 1) {
         if(var1 && this.mLayoutRequestEaten && !this.mLayoutFrozen && this.mLayout != null && this.mAdapter != null) {
            this.dispatchLayout();
         }

         if(!this.mLayoutFrozen) {
            this.mLayoutRequestEaten = false;
         }
      }

      --this.mEatRequestLayout;
   }

   void saveOldPositions() {
      int var2 = this.mChildHelper.getUnfilteredChildCount();

      for(int var1 = 0; var1 < var2; ++var1) {
         RecyclerView$ViewHolder var3 = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(var1));
         if(!var3.shouldIgnore()) {
            var3.saveOldPosition();
         }
      }

   }

   public void scrollBy(int var1, int var2) {
      if(this.mLayout == null) {
         Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
      } else if(!this.mLayoutFrozen) {
         boolean var3 = this.mLayout.canScrollHorizontally();
         boolean var4 = this.mLayout.canScrollVertically();
         if(var3 || var4) {
            if(!var3) {
               var1 = 0;
            }

            if(!var4) {
               var2 = 0;
            }

            this.scrollByInternal(var1, var2, (MotionEvent)null);
            return;
         }
      }

   }

   boolean scrollByInternal(int var1, int var2, MotionEvent var3) {
      int var5 = 0;
      byte var10 = 0;
      int var7 = 0;
      byte var8 = 0;
      int var4 = 0;
      byte var11 = 0;
      int var6 = 0;
      byte var9 = 0;
      this.consumePendingUpdateOperations();
      if(this.mAdapter != null) {
         this.eatRequestLayout();
         this.onEnterLayoutOrScroll();
         TraceCompat.beginSection("RV Scroll");
         var4 = var11;
         var5 = var10;
         if(var1 != 0) {
            var4 = this.mLayout.scrollHorizontallyBy(var1, this.mRecycler, this.mState);
            var5 = var1 - var4;
         }

         var6 = var9;
         var7 = var8;
         if(var2 != 0) {
            var6 = this.mLayout.scrollVerticallyBy(var2, this.mRecycler, this.mState);
            var7 = var2 - var6;
         }

         TraceCompat.endSection();
         this.repositionShadowingViews();
         this.onExitLayoutOrScroll();
         this.resumeRequestLayout(false);
      }

      if(!this.mItemDecorations.isEmpty()) {
         this.invalidate();
      }

      if(this.dispatchNestedScroll(var4, var6, var5, var7, this.mScrollOffset)) {
         this.mLastTouchX -= this.mScrollOffset[0];
         this.mLastTouchY -= this.mScrollOffset[1];
         if(var3 != null) {
            var3.offsetLocation((float)this.mScrollOffset[0], (float)this.mScrollOffset[1]);
         }

         int[] var12 = this.mNestedOffsets;
         var12[0] += this.mScrollOffset[0];
         var12 = this.mNestedOffsets;
         var12[1] += this.mScrollOffset[1];
      } else if(ViewCompat.getOverScrollMode(this) != 2) {
         if(var3 != null) {
            this.pullGlows(var3.getX(), (float)var5, var3.getY(), (float)var7);
         }

         this.considerReleasingGlowsOnScroll(var1, var2);
      }

      if(var4 != 0 || var6 != 0) {
         this.dispatchOnScrolled(var4, var6);
      }

      if(!this.awakenScrollBars()) {
         this.invalidate();
      }

      return var4 != 0 || var6 != 0;
   }

   public void scrollTo(int var1, int var2) {
      Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
   }

   public void scrollToPosition(int var1) {
      if(!this.mLayoutFrozen) {
         this.stopScroll();
         if(this.mLayout == null) {
            Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
         } else {
            this.mLayout.scrollToPosition(var1);
            this.awakenScrollBars();
         }
      }
   }

   public void sendAccessibilityEventUnchecked(AccessibilityEvent var1) {
      if(!this.shouldDeferAccessibilityEvent(var1)) {
         super.sendAccessibilityEventUnchecked(var1);
      }
   }

   public void setAccessibilityDelegateCompat(RecyclerViewAccessibilityDelegate var1) {
      this.mAccessibilityDelegate = var1;
      ViewCompat.setAccessibilityDelegate(this, this.mAccessibilityDelegate);
   }

   public void setAdapter(RecyclerView$Adapter var1) {
      this.setLayoutFrozen(false);
      this.setAdapterInternal(var1, false, true);
      this.requestLayout();
   }

   public void setChildDrawingOrderCallback(RecyclerView$ChildDrawingOrderCallback var1) {
      if(var1 != this.mChildDrawingOrderCallback) {
         this.mChildDrawingOrderCallback = var1;
         boolean var2;
         if(this.mChildDrawingOrderCallback != null) {
            var2 = true;
         } else {
            var2 = false;
         }

         this.setChildrenDrawingOrderEnabled(var2);
      }
   }

   public void setClipToPadding(boolean var1) {
      if(var1 != this.mClipToPadding) {
         this.invalidateGlows();
      }

      this.mClipToPadding = var1;
      super.setClipToPadding(var1);
      if(this.mFirstLayoutComplete) {
         this.requestLayout();
      }

   }

   public void setHasFixedSize(boolean var1) {
      this.mHasFixedSize = var1;
   }

   public void setItemAnimator(RecyclerView$ItemAnimator var1) {
      if(this.mItemAnimator != null) {
         this.mItemAnimator.endAnimations();
         this.mItemAnimator.setListener((RecyclerView$ItemAnimator$ItemAnimatorListener)null);
      }

      this.mItemAnimator = var1;
      if(this.mItemAnimator != null) {
         this.mItemAnimator.setListener(this.mItemAnimatorListener);
      }

   }

   public void setItemViewCacheSize(int var1) {
      this.mRecycler.setViewCacheSize(var1);
   }

   public void setLayoutFrozen(boolean var1) {
      if(var1 != this.mLayoutFrozen) {
         this.assertNotInLayoutOrScroll("Do not setLayoutFrozen in layout or scroll");
         if(var1) {
            long var2 = SystemClock.uptimeMillis();
            this.onTouchEvent(MotionEvent.obtain(var2, var2, 3, 0.0F, 0.0F, 0));
            this.mLayoutFrozen = true;
            this.mIgnoreMotionEventTillDown = true;
            this.stopScroll();
            return;
         }

         this.mLayoutFrozen = false;
         if(this.mLayoutRequestEaten && this.mLayout != null && this.mAdapter != null) {
            this.requestLayout();
         }

         this.mLayoutRequestEaten = false;
      }

   }

   public void setLayoutManager(RecyclerView$LayoutManager var1) {
      if(var1 != this.mLayout) {
         this.stopScroll();
         if(this.mLayout != null) {
            if(this.mIsAttached) {
               this.mLayout.dispatchDetachedFromWindow(this, this.mRecycler);
            }

            this.mLayout.setRecyclerView((RecyclerView)null);
         }

         this.mRecycler.clear();
         this.mChildHelper.removeAllViewsUnfiltered();
         this.mLayout = var1;
         if(var1 != null) {
            if(var1.mRecyclerView != null) {
               throw new IllegalArgumentException("LayoutManager " + var1 + " is already attached to a RecyclerView: " + var1.mRecyclerView);
            }

            this.mLayout.setRecyclerView(this);
            if(this.mIsAttached) {
               this.mLayout.dispatchAttachedToWindow(this);
            }
         }

         this.requestLayout();
      }
   }

   public void setNestedScrollingEnabled(boolean var1) {
      this.mScrollingChildHelper.setNestedScrollingEnabled(var1);
   }

   @Deprecated
   public void setOnScrollListener(RecyclerView$OnScrollListener var1) {
      this.mScrollListener = var1;
   }

   public void setRecycledViewPool(RecyclerView$RecycledViewPool var1) {
      this.mRecycler.setRecycledViewPool(var1);
   }

   public void setRecyclerListener(RecyclerView$RecyclerListener var1) {
      this.mRecyclerListener = var1;
   }

   public void setScrollingTouchSlop(int var1) {
      ViewConfiguration var2 = ViewConfiguration.get(this.getContext());
      switch(var1) {
      case 1:
         this.mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(var2);
         return;
      default:
         Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + var1 + "; using default value");
      case 0:
         this.mTouchSlop = var2.getScaledTouchSlop();
      }
   }

   public void setViewCacheExtension(RecyclerView$ViewCacheExtension var1) {
      this.mRecycler.setViewCacheExtension(var1);
   }

   boolean shouldDeferAccessibilityEvent(AccessibilityEvent var1) {
      if(this.isComputingLayout()) {
         int var2 = 0;
         if(var1 != null) {
            var2 = AccessibilityEventCompat.getContentChangeTypes(var1);
         }

         int var3 = var2;
         if(var2 == 0) {
            var3 = 0;
         }

         this.mEatenAccessibilityChangeFlags |= var3;
         return true;
      } else {
         return false;
      }
   }

   public void smoothScrollBy(int var1, int var2) {
      if(this.mLayout == null) {
         Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
      } else if(!this.mLayoutFrozen) {
         if(!this.mLayout.canScrollHorizontally()) {
            var1 = 0;
         }

         if(!this.mLayout.canScrollVertically()) {
            var2 = 0;
         }

         if(var1 != 0 || var2 != 0) {
            this.mViewFlinger.smoothScrollBy(var1, var2);
            return;
         }
      }

   }

   public void smoothScrollToPosition(int var1) {
      if(!this.mLayoutFrozen) {
         if(this.mLayout == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
         } else {
            this.mLayout.smoothScrollToPosition(this, this.mState, var1);
         }
      }
   }

   public boolean startNestedScroll(int var1) {
      return this.mScrollingChildHelper.startNestedScroll(var1);
   }

   public void stopNestedScroll() {
      this.mScrollingChildHelper.stopNestedScroll();
   }

   public void stopScroll() {
      this.setScrollState(0);
      this.stopScrollersInternal();
   }

   public void swapAdapter(RecyclerView$Adapter var1, boolean var2) {
      this.setLayoutFrozen(false);
      this.setAdapterInternal(var1, true, var2);
      this.setDataSetChangedAfterLayout();
      this.requestLayout();
   }

   void viewRangeUpdate(int var1, int var2, Object var3) {
      int var5 = this.mChildHelper.getUnfilteredChildCount();

      for(int var4 = 0; var4 < var5; ++var4) {
         View var6 = this.mChildHelper.getUnfilteredChildAt(var4);
         RecyclerView$ViewHolder var7 = getChildViewHolderInt(var6);
         if(var7 != null && !var7.shouldIgnore() && var7.mPosition >= var1 && var7.mPosition < var1 + var2) {
            var7.addFlags(2);
            var7.addChangePayload(var3);
            ((RecyclerView$LayoutParams)var6.getLayoutParams()).mInsetsDirty = true;
         }
      }

      this.mRecycler.viewRangeUpdate(var1, var2);
   }
}
