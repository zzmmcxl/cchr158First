package android.support.v4.view;

import android.support.v4.os.ParcelableCompat;
import android.os.Parcel;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.os.Parcelable$Creator;
import android.view.View$BaseSavedState;
import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.content.res.TypedArray;
import android.support.annotation.DrawableRes;
import android.database.DataSetObserver;
import android.content.res.Resources$NotFoundException;
import android.support.annotation.CallSuper;
import android.view.View$MeasureSpec;
import android.view.ViewConfiguration;
import android.os.Build$VERSION;
import android.graphics.Canvas;
import android.view.accessibility.AccessibilityEvent;
import android.view.KeyEvent;
import android.os.SystemClock;
import android.view.SoundEffectConstants;
import android.view.FocusFinder;
import android.util.Log;
import android.view.ViewGroup$LayoutParams;
import java.util.Collections;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.content.Context;
import android.view.VelocityTracker;
import android.graphics.Rect;
import java.lang.reflect.Method;
import android.widget.Scroller;
import android.os.Parcelable;
import java.util.List;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.EdgeEffectCompat;
import android.view.View;
import java.util.ArrayList;
import android.view.animation.Interpolator;
import java.util.Comparator;
import android.view.ViewGroup;

public class ViewPager extends ViewGroup
{
    private static final int CLOSE_ENOUGH = 2;
    private static final Comparator<ItemInfo> COMPARATOR;
    private static final boolean DEBUG = false;
    private static final int DEFAULT_GUTTER_SIZE = 16;
    private static final int DEFAULT_OFFSCREEN_PAGES = 1;
    private static final int DRAW_ORDER_DEFAULT = 0;
    private static final int DRAW_ORDER_FORWARD = 1;
    private static final int DRAW_ORDER_REVERSE = 2;
    private static final int INVALID_POINTER = -1;
    private static final int[] LAYOUT_ATTRS;
    private static final int MAX_SETTLE_DURATION = 600;
    private static final int MIN_DISTANCE_FOR_FLING = 25;
    private static final int MIN_FLING_VELOCITY = 400;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    private static final String TAG = "ViewPager";
    private static final boolean USE_CACHE;
    private static final Interpolator sInterpolator;
    private static final ViewPositionComparator sPositionComparator;
    private int mActivePointerId;
    private PagerAdapter mAdapter;
    private OnAdapterChangeListener mAdapterChangeListener;
    private int mBottomPageBounds;
    private boolean mCalledSuper;
    private int mChildHeightMeasureSpec;
    private int mChildWidthMeasureSpec;
    private int mCloseEnough;
    private int mCurItem;
    private int mDecorChildCount;
    private int mDefaultGutterSize;
    private int mDrawingOrder;
    private ArrayList<View> mDrawingOrderedChildren;
    private final Runnable mEndScrollRunnable;
    private int mExpectedAdapterCount;
    private long mFakeDragBeginTime;
    private boolean mFakeDragging;
    private boolean mFirstLayout;
    private float mFirstOffset;
    private int mFlingDistance;
    private int mGutterSize;
    private boolean mInLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private OnPageChangeListener mInternalPageChangeListener;
    private boolean mIsBeingDragged;
    private boolean mIsScrollStarted;
    private boolean mIsUnableToDrag;
    private final ArrayList<ItemInfo> mItems;
    private float mLastMotionX;
    private float mLastMotionY;
    private float mLastOffset;
    private EdgeEffectCompat mLeftEdge;
    private Drawable mMarginDrawable;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private boolean mNeedCalculatePageOffsets;
    private PagerObserver mObserver;
    private int mOffscreenPageLimit;
    private OnPageChangeListener mOnPageChangeListener;
    private List<OnPageChangeListener> mOnPageChangeListeners;
    private int mPageMargin;
    private PageTransformer mPageTransformer;
    private boolean mPopulatePending;
    private Parcelable mRestoredAdapterState;
    private ClassLoader mRestoredClassLoader;
    private int mRestoredCurItem;
    private EdgeEffectCompat mRightEdge;
    private int mScrollState;
    private Scroller mScroller;
    private boolean mScrollingCacheEnabled;
    private Method mSetChildrenDrawingOrderEnabled;
    private final ItemInfo mTempItem;
    private final Rect mTempRect;
    private int mTopPageBounds;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    
    static {
        LAYOUT_ATTRS = new int[] { 16842931 };
        COMPARATOR = new Comparator<ItemInfo>() {
            ViewPager$1() {
                super();
            }
            
            @Override
            public int compare(final ItemInfo itemInfo, final ItemInfo itemInfo2) {
                return itemInfo.position - itemInfo2.position;
            }
            
            @Override
            public /* bridge */ int compare(final Object o, final Object o2) {
                return this.compare((ItemInfo)o, (ItemInfo)o2);
            }
        };
        sInterpolator = (Interpolator)new Interpolator() {
            ViewPager$2() {
                super();
            }
            
            public float getInterpolation(final float n) {
                final float n2 = n - 1.0f;
                return 1.0f + n2 * (n2 * (n2 * (n2 * n2)));
            }
        };
        sPositionComparator = new ViewPositionComparator();
    }
    
    public ViewPager(final Context context) {
        super(context);
        mItems = new ArrayList<ItemInfo>();
        mTempItem = new ItemInfo();
        mTempRect = new Rect();
        mRestoredCurItem = -1;
        mRestoredAdapterState = null;
        mRestoredClassLoader = null;
        mFirstOffset = -3.4028235E38f;
        mLastOffset = Float.MAX_VALUE;
        mOffscreenPageLimit = 1;
        mActivePointerId = -1;
        mFirstLayout = true;
        mNeedCalculatePageOffsets = false;
        mEndScrollRunnable = new Runnable() {
            final /* synthetic */ ViewPager this$0;
            
            ViewPager$3(final ViewPager this$0) {
                this$0 = this$0;
                super();
            }
            
            @Override
            public void run() {
                this$0.setScrollState(0);
                this$0.populate();
            }
        };
        mScrollState = 0;
        this.initViewPager();
    }
    
    public ViewPager(final Context context, final AttributeSet set) {
        super(context, set);
        mItems = new ArrayList<ItemInfo>();
        mTempItem = new ItemInfo();
        mTempRect = new Rect();
        mRestoredCurItem = -1;
        mRestoredAdapterState = null;
        mRestoredClassLoader = null;
        mFirstOffset = -3.4028235E38f;
        mLastOffset = Float.MAX_VALUE;
        mOffscreenPageLimit = 1;
        mActivePointerId = -1;
        mFirstLayout = true;
        mNeedCalculatePageOffsets = false;
        mEndScrollRunnable = new Runnable() {
            final /* synthetic */ ViewPager this$0;
            
            ViewPager$3() {
                this$0 = this$0;
                super();
            }
            
            @Override
            public void run() {
                this$0.setScrollState(0);
                this$0.populate();
            }
        };
        mScrollState = 0;
        this.initViewPager();
    }
    
    static /* synthetic */ void access$000(final ViewPager viewPager, final int scrollState) {
        viewPager.setScrollState(scrollState);
    }
    
    static /* synthetic */ PagerAdapter access$200(final ViewPager viewPager) {
        return viewPager.mAdapter;
    }
    
    static /* synthetic */ int access$300(final ViewPager viewPager) {
        return viewPager.mCurItem;
    }
    
    static /* synthetic */ int[] access$400() {
        return LAYOUT_ATTRS;
    }
    
    private void calculatePageOffsets(final ItemInfo itemInfo, final int n, final ItemInfo itemInfo2) {
        final int count = mAdapter.getCount();
        final int clientWidth = this.getClientWidth();
        float n2;
        if (clientWidth > 0) {
            n2 = mPageMargin / clientWidth;
        }
        else {
            n2 = 0.0f;
        }
        if (itemInfo2 != null) {
            final int position = itemInfo2.position;
            if (position < itemInfo.position) {
                int n3 = 0;
                float offset = n2 + (itemInfo2.offset + itemInfo2.widthFactor);
                for (int i = position + 1; i <= itemInfo.position && n3 < mItems.size(); ++i) {
                    ItemInfo itemInfo3;
                    for (itemInfo3 = mItems.get(n3); i > itemInfo3.position && n3 < -1 + mItems.size(); ++n3, itemInfo3 = mItems.get(n3)) {}
                    while (i < itemInfo3.position) {
                        offset += n2 + mAdapter.getPageWidth(i);
                        ++i;
                    }
                    itemInfo3.offset = offset;
                    offset += n2 + itemInfo3.widthFactor;
                }
            }
            else if (position > itemInfo.position) {
                int n4 = -1 + mItems.size();
                float offset2 = itemInfo2.offset;
                for (int j = position - 1; j >= itemInfo.position && n4 >= 0; --j) {
                    ItemInfo itemInfo4;
                    for (itemInfo4 = mItems.get(n4); j < itemInfo4.position && n4 > 0; --n4, itemInfo4 = mItems.get(n4)) {}
                    while (j > itemInfo4.position) {
                        offset2 -= n2 + mAdapter.getPageWidth(j);
                        --j;
                    }
                    offset2 -= n2 + itemInfo4.widthFactor;
                    itemInfo4.offset = offset2;
                }
            }
        }
        final int size = mItems.size();
        float offset3 = itemInfo.offset;
        int k = -1 + itemInfo.position;
        float offset4;
        if (itemInfo.position == 0) {
            offset4 = itemInfo.offset;
        }
        else {
            offset4 = -3.4028235E38f;
        }
        mFirstOffset = offset4;
        float mLastOffset;
        if (itemInfo.position == count - 1) {
            mLastOffset = itemInfo.offset + itemInfo.widthFactor - 1.0f;
        }
        else {
            mLastOffset = Float.MAX_VALUE;
        }
        this.mLastOffset = mLastOffset;
        for (int l = n - 1; l >= 0; --l, --k) {
            ItemInfo itemInfo5;
            int n5;
            for (itemInfo5 = mItems.get(l); k > itemInfo5.position; k = n5) {
                final PagerAdapter mAdapter = this.mAdapter;
                n5 = k - 1;
                offset3 -= n2 + mAdapter.getPageWidth(k);
            }
            offset3 -= n2 + itemInfo5.widthFactor;
            itemInfo5.offset = offset3;
            if (itemInfo5.position == 0) {
                mFirstOffset = offset3;
            }
        }
        float offset5 = n2 + (itemInfo.offset + itemInfo.widthFactor);
        for (int n6 = 1 + itemInfo.position, n7 = n + 1; n7 < size; ++n7, ++n6) {
            ItemInfo itemInfo6;
            int n8;
            for (itemInfo6 = mItems.get(n7); n6 < itemInfo6.position; n6 = n8) {
                final PagerAdapter mAdapter2 = mAdapter;
                n8 = n6 + 1;
                offset5 += n2 + mAdapter2.getPageWidth(n6);
            }
            if (itemInfo6.position == count - 1) {
                this.mLastOffset = offset5 + itemInfo6.widthFactor - 1.0f;
            }
            itemInfo6.offset = offset5;
            offset5 += n2 + itemInfo6.widthFactor;
        }
        mNeedCalculatePageOffsets = false;
    }
    
    private void completeScroll(final boolean b) {
        int n = 1;
        int n2;
        if (mScrollState == 2) {
            n2 = n;
        }
        else {
            n2 = 0;
        }
        if (n2 != 0) {
            this.setScrollingCacheEnabled(false);
            if (mScroller.isFinished()) {
                n = 0;
            }
            if (n != 0) {
                mScroller.abortAnimation();
                final int scrollX = this.getScrollX();
                final int scrollY = this.getScrollY();
                final int currX = mScroller.getCurrX();
                final int currY = mScroller.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    this.scrollTo(currX, currY);
                    if (currX != scrollX) {
                        this.pageScrolled(currX);
                    }
                }
            }
        }
        mPopulatePending = false;
        for (int i = 0; i < mItems.size(); ++i) {
            final ItemInfo itemInfo = (ItemInfo)mItems.get(i);
            if (itemInfo.scrolling) {
                n2 = 1;
                itemInfo.scrolling = false;
            }
        }
        if (n2 != 0) {
            if (!b) {
                mEndScrollRunnable.run();
                return;
            }
            ViewCompat.postOnAnimation((View)this, mEndScrollRunnable);
        }
    }
    
    private int determineTargetPage(final int n, final float n2, final int n3, final int n4) {
        int max;
        if (Math.abs(n4) > mFlingDistance && Math.abs(n3) > mMinimumVelocity) {
            if (n3 > 0) {
                max = n;
            }
            else {
                max = n + 1;
            }
        }
        else {
            float n5;
            if (n >= mCurItem) {
                n5 = 0.4f;
            }
            else {
                n5 = 0.6f;
            }
            max = (int)(n5 + (n2 + n));
        }
        if (mItems.size() > 0) {
            max = Math.max(((ItemInfo)mItems.get(0)).position, Math.min(max, ((ItemInfo)mItems.get(-1 + mItems.size())).position));
        }
        return max;
    }
    
    private void dispatchOnPageScrolled(final int n, final float n2, final int n3) {
        if (mOnPageChangeListener != null) {
            mOnPageChangeListener.onPageScrolled(n, n2, n3);
        }
        if (mOnPageChangeListeners != null) {
            for (int i = 0; i < mOnPageChangeListeners.size(); ++i) {
                final OnPageChangeListener onPageChangeListener = (OnPageChangeListener)mOnPageChangeListeners.get(i);
                if (onPageChangeListener != null) {
                    onPageChangeListener.onPageScrolled(n, n2, n3);
                }
            }
        }
        if (mInternalPageChangeListener != null) {
            mInternalPageChangeListener.onPageScrolled(n, n2, n3);
        }
    }
    
    private void dispatchOnPageSelected(final int n) {
        if (mOnPageChangeListener != null) {
            mOnPageChangeListener.onPageSelected(n);
        }
        if (mOnPageChangeListeners != null) {
            for (int i = 0; i < mOnPageChangeListeners.size(); ++i) {
                final OnPageChangeListener onPageChangeListener = (OnPageChangeListener)mOnPageChangeListeners.get(i);
                if (onPageChangeListener != null) {
                    onPageChangeListener.onPageSelected(n);
                }
            }
        }
        if (mInternalPageChangeListener != null) {
            mInternalPageChangeListener.onPageSelected(n);
        }
    }
    
    private void dispatchOnScrollStateChanged(final int n) {
        if (mOnPageChangeListener != null) {
            mOnPageChangeListener.onPageScrollStateChanged(n);
        }
        if (mOnPageChangeListeners != null) {
            for (int i = 0; i < mOnPageChangeListeners.size(); ++i) {
                final OnPageChangeListener onPageChangeListener = (OnPageChangeListener)mOnPageChangeListeners.get(i);
                if (onPageChangeListener != null) {
                    onPageChangeListener.onPageScrollStateChanged(n);
                }
            }
        }
        if (mInternalPageChangeListener != null) {
            mInternalPageChangeListener.onPageScrollStateChanged(n);
        }
    }
    
    private void enableLayers(final boolean b) {
        for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
            int n;
            if (b) {
                n = 2;
            }
            else {
                n = 0;
            }
            ViewCompat.setLayerType(this.getChildAt(i), n, null);
        }
    }
    
    private void endDrag() {
        mIsBeingDragged = false;
        mIsUnableToDrag = false;
        if (mVelocityTracker != null) {
            mVelocityTracker.recycle();
            mVelocityTracker = null;
        }
    }
    
    private Rect getChildRectInPagerCoordinates(Rect rect, final View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
        }
        else {
            rect.left = view.getLeft();
            rect.right = view.getRight();
            rect.top = view.getTop();
            rect.bottom = view.getBottom();
            ViewPager viewPager;
            for (ViewParent viewParent = view.getParent(); viewParent instanceof ViewGroup && viewParent != this; viewParent = viewPager.getParent()) {
                viewPager = (ViewPager)viewParent;
                rect.left += viewPager.getLeft();
                rect.right += viewPager.getRight();
                rect.top += viewPager.getTop();
                rect.bottom += viewPager.getBottom();
            }
        }
        return rect;
    }
    
    private int getClientWidth() {
        return this.getMeasuredWidth() - this.getPaddingLeft() - this.getPaddingRight();
    }
    
    private ItemInfo infoForCurrentScrollPosition() {
        final int clientWidth = this.getClientWidth();
        float n;
        if (clientWidth > 0) {
            n = this.getScrollX() / clientWidth;
        }
        else {
            n = 0.0f;
        }
        float n2 = 0.0f;
        if (clientWidth > 0) {
            n2 = mPageMargin / clientWidth;
        }
        int position = -1;
        float n3 = 0.0f;
        float widthFactor = 0.0f;
        int n4 = 1;
        ItemInfo itemInfo = null;
        for (int i = 0; i < mItems.size(); ++i, n4 = 0) {
            ItemInfo mTempItem = (ItemInfo)mItems.get(i);
            if (n4 == 0 && mTempItem.position != position + 1) {
                mTempItem = this.mTempItem;
                mTempItem.offset = n2 + (n3 + widthFactor);
                mTempItem.position = position + 1;
                mTempItem.widthFactor = mAdapter.getPageWidth(mTempItem.position);
                --i;
            }
            final float offset = mTempItem.offset;
            final float n5 = n2 + (offset + mTempItem.widthFactor);
            if (n4 == 0 && n < offset) {
                break;
            }
            if (n < n5 || i == -1 + mItems.size()) {
                itemInfo = mTempItem;
                break;
            }
            position = mTempItem.position;
            n3 = offset;
            widthFactor = mTempItem.widthFactor;
            itemInfo = mTempItem;
        }
        return itemInfo;
    }
    
    private boolean isGutterDrag(final float n, final float n2) {
        return (n < mGutterSize && n2 > 0.0f) || (n > this.getWidth() - mGutterSize && n2 < 0.0f);
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
            mLastMotionX = MotionEventCompat.getX(motionEvent, n);
            mActivePointerId = MotionEventCompat.getPointerId(motionEvent, n);
            if (mVelocityTracker != null) {
                mVelocityTracker.clear();
            }
        }
    }
    
    private boolean pageScrolled(final int n) {
        boolean b;
        if (mItems.size() == 0) {
            mCalledSuper = false;
            this.onPageScrolled(0, 0.0f, 0);
            final boolean mCalledSuper = this.mCalledSuper;
            b = false;
            if (!mCalledSuper) {
                throw new IllegalStateException("onPageScrolled did not call superclass implementation");
            }
        }
        else {
            final ItemInfo infoForCurrentScrollPosition = this.infoForCurrentScrollPosition();
            final int clientWidth = this.getClientWidth();
            final int n2 = clientWidth + mPageMargin;
            final float n3 = mPageMargin / clientWidth;
            final int position = infoForCurrentScrollPosition.position;
            final float n4 = (n / clientWidth - infoForCurrentScrollPosition.offset) / (n3 + infoForCurrentScrollPosition.widthFactor);
            final int n5 = (int)(n4 * n2);
            mCalledSuper = false;
            this.onPageScrolled(position, n4, n5);
            if (!mCalledSuper) {
                throw new IllegalStateException("onPageScrolled did not call superclass implementation");
            }
            b = true;
        }
        return b;
    }
    
    private boolean performDrag(final float mLastMotionX) {
        final float n = this.mLastMotionX - mLastMotionX;
        this.mLastMotionX = mLastMotionX;
        float n2 = n + this.getScrollX();
        final int clientWidth = this.getClientWidth();
        float n3 = clientWidth * mFirstOffset;
        float n4 = clientWidth * mLastOffset;
        boolean b = true;
        boolean b2 = true;
        final ItemInfo itemInfo = (ItemInfo)mItems.get(0);
        final ItemInfo itemInfo2 = (ItemInfo)mItems.get(-1 + mItems.size());
        if (itemInfo.position != 0) {
            b = false;
            n3 = itemInfo.offset * clientWidth;
        }
        if (itemInfo2.position != -1 + mAdapter.getCount()) {
            b2 = false;
            n4 = itemInfo2.offset * clientWidth;
        }
        boolean b3;
        if (n2 < n3) {
            b3 = false;
            if (b) {
                b3 = mLeftEdge.onPull(Math.abs(n3 - n2) / (float)clientWidth);
            }
            n2 = n3;
        }
        else {
            final float n5 = fcmpl(n2, n4);
            b3 = false;
            if (n5 > 0) {
                b3 = false;
                if (b2) {
                    b3 = mRightEdge.onPull(Math.abs(n2 - n4) / (float)clientWidth);
                }
                n2 = n4;
            }
        }
        this.mLastMotionX += n2 - (int)n2;
        this.scrollTo((int)n2, this.getScrollY());
        this.pageScrolled((int)n2);
        return b3;
    }
    
    private void recomputeScrollPosition(final int n, final int n2, final int n3, final int n4) {
        if (n2 > 0 && !mItems.isEmpty()) {
            if (mScroller.isFinished()) {
                this.scrollTo((int)(this.getScrollX() / (n4 + (n2 - this.getPaddingLeft() - this.getPaddingRight())) * (n3 + (n - this.getPaddingLeft() - this.getPaddingRight()))), this.getScrollY());
                return;
            }
            mScroller.setFinalX(this.getCurrentItem() * this.getClientWidth());
        }
        else {
            final ItemInfo infoForPosition = this.infoForPosition(mCurItem);
            float min;
            if (infoForPosition != null) {
                min = Math.min(infoForPosition.offset, mLastOffset);
            }
            else {
                min = 0.0f;
            }
            final int n5 = (int)(min * (n - this.getPaddingLeft() - this.getPaddingRight()));
            if (n5 != this.getScrollX()) {
                this.completeScroll(false);
                this.scrollTo(n5, this.getScrollY());
            }
        }
    }
    
    private void removeNonDecorViews() {
        for (int i = 0; i < this.getChildCount(); ++i) {
            if (!((LayoutParams)this.getChildAt(i).getLayoutParams()).isDecor) {
                this.removeViewAt(i);
                --i;
            }
        }
    }
    
    private void requestParentDisallowInterceptTouchEvent(final boolean b) {
        final ViewParent parent = this.getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(b);
        }
    }
    
    private boolean resetTouch() {
        mActivePointerId = -1;
        this.endDrag();
        return mLeftEdge.onRelease() | mRightEdge.onRelease();
    }
    
    private void scrollToItem(final int n, final boolean b, final int n2, final boolean b2) {
        final ItemInfo infoForPosition = this.infoForPosition(n);
        int n3 = 0;
        if (infoForPosition != null) {
            n3 = (int)(this.getClientWidth() * Math.max(mFirstOffset, Math.min(infoForPosition.offset, mLastOffset)));
        }
        if (b) {
            this.smoothScrollTo(n3, 0, n2);
            if (b2) {
                this.dispatchOnPageSelected(n);
            }
            return;
        }
        if (b2) {
            this.dispatchOnPageSelected(n);
        }
        this.completeScroll(false);
        this.scrollTo(n3, 0);
        this.pageScrolled(n3);
    }
    
    private void setScrollState(final int mScrollState) {
        if (this.mScrollState == mScrollState) {
            return;
        }
        this.mScrollState = mScrollState;
        if (mPageTransformer != null) {
            this.enableLayers(mScrollState != 0);
        }
        this.dispatchOnScrollStateChanged(mScrollState);
    }
    
    private void setScrollingCacheEnabled(final boolean mScrollingCacheEnabled) {
        if (this.mScrollingCacheEnabled != mScrollingCacheEnabled) {
            this.mScrollingCacheEnabled = mScrollingCacheEnabled;
        }
    }
    
    private void sortChildDrawingOrder() {
        if (mDrawingOrder != 0) {
            if (mDrawingOrderedChildren == null) {
                mDrawingOrderedChildren = new ArrayList<View>();
            }
            else {
                mDrawingOrderedChildren.clear();
            }
            for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
                mDrawingOrderedChildren.add(this.getChildAt(i));
            }
            Collections.<View>sort(mDrawingOrderedChildren, sPositionComparator);
        }
    }
    
    public void addFocusables(final ArrayList<View> list, final int n, final int n2) {
        final int size = list.size();
        final int descendantFocusability = this.getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i = 0; i < this.getChildCount(); ++i) {
                final View child = this.getChildAt(i);
                if (child.getVisibility() == 0) {
                    final ItemInfo infoForChild = this.infoForChild(child);
                    if (infoForChild != null && infoForChild.position == mCurItem) {
                        child.addFocusables((ArrayList)list, n, n2);
                    }
                }
            }
        }
        if ((descendantFocusability != 262144 || size == list.size()) && this.isFocusable() && ((n2 & 0x1) != 0x1 || !this.isInTouchMode() || this.isFocusableInTouchMode()) && list != null) {
            list.add((View)this);
        }
    }
    
    ItemInfo addNewItem(final int position, final int n) {
        final ItemInfo itemInfo = new ItemInfo();
        itemInfo.position = position;
        itemInfo.object = mAdapter.instantiateItem(this, position);
        itemInfo.widthFactor = mAdapter.getPageWidth(position);
        if (n < 0 || n >= mItems.size()) {
            mItems.add(itemInfo);
            return itemInfo;
        }
        mItems.add(n, itemInfo);
        return itemInfo;
    }
    
    public void addOnPageChangeListener(final OnPageChangeListener onPageChangeListener) {
        if (mOnPageChangeListeners == null) {
            mOnPageChangeListeners = new ArrayList<OnPageChangeListener>();
        }
        mOnPageChangeListeners.add(onPageChangeListener);
    }
    
    public void addTouchables(final ArrayList<View> list) {
        for (int i = 0; i < this.getChildCount(); ++i) {
            final View child = this.getChildAt(i);
            if (child.getVisibility() == 0) {
                final ItemInfo infoForChild = this.infoForChild(child);
                if (infoForChild != null && infoForChild.position == mCurItem) {
                    child.addTouchables((ArrayList)list);
                }
            }
        }
    }
    
    public void addView(final View view, final int n, ViewGroup$LayoutParams generateLayoutParams) {
        if (!this.checkLayoutParams(generateLayoutParams)) {
            generateLayoutParams = this.generateLayoutParams(generateLayoutParams);
        }
        final LayoutParams layoutParams = (LayoutParams)generateLayoutParams;
        layoutParams.isDecor |= (view instanceof Decor);
        if (!mInLayout) {
            super.addView(view, n, generateLayoutParams);
            return;
        }
        if (layoutParams != null && layoutParams.isDecor) {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
        layoutParams.needsMeasure = true;
        this.addViewInLayout(view, n, generateLayoutParams);
    }
    
    public boolean arrowScroll(final int n) {
        Object focus = this.findFocus();
        if (focus == this) {
            focus = null;
        }
        else if (focus != null) {
            ViewParent viewParent = ((View)focus).getParent();
            boolean b2;
            while (true) {
                final boolean b = viewParent instanceof ViewGroup;
                b2 = false;
                if (!b) {
                    break;
                }
                if (viewParent == this) {
                    b2 = true;
                    break;
                }
                viewParent = viewParent.getParent();
            }
            if (!b2) {
                final StringBuilder sb = new StringBuilder();
                sb.append(((View)focus).getClass().getSimpleName());
                for (ViewParent viewParent2 = ((View)focus).getParent(); viewParent2 instanceof ViewGroup; viewParent2 = viewParent2.getParent()) {
                    sb.append(" => ").append(viewParent2.getClass().getSimpleName());
                }
                Log.e("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + sb.toString());
                focus = null;
            }
        }
        final View nextFocus = FocusFinder.getInstance().findNextFocus((ViewGroup)this, (View)focus, n);
        boolean b3 = false;
        Label_0086: {
            if (nextFocus != null && nextFocus != focus) {
                if (n == 17) {
                    final int left = this.getChildRectInPagerCoordinates(mTempRect, nextFocus).left;
                    final int left2 = this.getChildRectInPagerCoordinates(mTempRect, (View)focus).left;
                    if (focus != null && left >= left2) {
                        b3 = this.pageLeft();
                    }
                    else {
                        b3 = nextFocus.requestFocus();
                    }
                }
                else {
                    b3 = false;
                    if (n == 66) {
                        final int left3 = this.getChildRectInPagerCoordinates(mTempRect, nextFocus).left;
                        final int left4 = this.getChildRectInPagerCoordinates(mTempRect, (View)focus).left;
                        if (focus != null && left3 <= left4) {
                            b3 = this.pageRight();
                        }
                        else {
                            b3 = nextFocus.requestFocus();
                        }
                    }
                }
            }
            else if (n == 17 || n == 1) {
                b3 = this.pageLeft();
            }
            else {
                if (n != 66) {
                    b3 = false;
                    if (n != 2) {
                        break Label_0086;
                    }
                }
                b3 = this.pageRight();
            }
        }
        if (b3) {
            this.playSoundEffect(SoundEffectConstants.getContantForFocusDirection(n));
        }
        return b3;
    }
    
    public boolean beginFakeDrag() {
        if (mIsBeingDragged) {
            return false;
        }
        mFakeDragging = true;
        this.setScrollState(1);
        mLastMotionX = 0.0f;
        mInitialMotionX = 0.0f;
        if (mVelocityTracker == null) {
            mVelocityTracker = VelocityTracker.obtain();
        }
        else {
            mVelocityTracker.clear();
        }
        final long uptimeMillis = SystemClock.uptimeMillis();
        final MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, 0.0f, 0.0f, 0);
        mVelocityTracker.addMovement(obtain);
        obtain.recycle();
        mFakeDragBeginTime = uptimeMillis;
        return true;
    }
    
    protected boolean canScroll(final View view, final boolean b, final int n, final int n2, final int n3) {
        if (view instanceof ViewGroup) {
            final ViewGroup viewGroup = (ViewGroup)view;
            final int scrollX = view.getScrollX();
            final int scrollY = view.getScrollY();
            for (int i = -1 + viewGroup.getChildCount(); i >= 0; --i) {
                final View child = viewGroup.getChildAt(i);
                if (n2 + scrollX >= child.getLeft() && n2 + scrollX < child.getRight() && n3 + scrollY >= child.getTop() && n3 + scrollY < child.getBottom() && this.canScroll(child, true, n, n2 + scrollX - child.getLeft(), n3 + scrollY - child.getTop())) {
                    return true;
                }
            }
        }
        return b && ViewCompat.canScrollHorizontally(view, -n);
    }
    
    public boolean canScrollHorizontally(final int n) {
        boolean b = true;
        if (mAdapter != null) {
            final int clientWidth = this.getClientWidth();
            final int scrollX = this.getScrollX();
            if (n < 0) {
                if (scrollX <= (int)(clientWidth * mFirstOffset)) {
                    b = false;
                }
                return b;
            }
            if (n > 0) {
                if (scrollX >= (int)(clientWidth * mLastOffset)) {
                    b = false;
                }
                return b;
            }
        }
        return false;
    }
    
    protected boolean checkLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        return viewGroup$LayoutParams instanceof LayoutParams && super.checkLayoutParams(viewGroup$LayoutParams);
    }
    
    public void clearOnPageChangeListeners() {
        if (mOnPageChangeListeners != null) {
            mOnPageChangeListeners.clear();
        }
    }
    
    public void computeScroll() {
        mIsScrollStarted = true;
        if (!mScroller.isFinished() && mScroller.computeScrollOffset()) {
            final int scrollX = this.getScrollX();
            final int scrollY = this.getScrollY();
            final int currX = mScroller.getCurrX();
            final int currY = mScroller.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                this.scrollTo(currX, currY);
                if (!this.pageScrolled(currX)) {
                    mScroller.abortAnimation();
                    this.scrollTo(0, currY);
                }
            }
            ViewCompat.postInvalidateOnAnimation((View)this);
            return;
        }
        this.completeScroll(true);
    }
    
    void dataSetChanged() {
        final int count = mAdapter.getCount();
        mExpectedAdapterCount = count;
        boolean b = mItems.size() < 1 + 2 * mOffscreenPageLimit && mItems.size() < count;
        int n = mCurItem;
        int n2 = 0;
        for (int i = 0; i < mItems.size(); ++i) {
            final ItemInfo itemInfo = (ItemInfo)mItems.get(i);
            final int itemPosition = mAdapter.getItemPosition(itemInfo.object);
            if (itemPosition != -1) {
                if (itemPosition == -2) {
                    mItems.remove(i);
                    --i;
                    if (n2 == 0) {
                        mAdapter.startUpdate(this);
                        n2 = 1;
                    }
                    mAdapter.destroyItem(this, itemInfo.position, itemInfo.object);
                    b = true;
                    if (mCurItem == itemInfo.position) {
                        n = Math.max(0, Math.min(mCurItem, count - 1));
                        b = true;
                    }
                }
                else if (itemInfo.position != itemPosition) {
                    if (itemInfo.position == mCurItem) {
                        n = itemPosition;
                    }
                    itemInfo.position = itemPosition;
                    b = true;
                }
            }
        }
        if (n2 != 0) {
            mAdapter.finishUpdate(this);
        }
        Collections.<ItemInfo>sort(mItems, COMPARATOR);
        if (b) {
            for (int childCount = this.getChildCount(), j = 0; j < childCount; ++j) {
                final LayoutParams layoutParams = (LayoutParams)this.getChildAt(j).getLayoutParams();
                if (!layoutParams.isDecor) {
                    layoutParams.widthFactor = 0.0f;
                }
            }
            this.setCurrentItemInternal(n, false, true);
            this.requestLayout();
        }
    }
    
    public boolean dispatchKeyEvent(final KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || this.executeKeyEvent(keyEvent);
    }
    
    public boolean dispatchPopulateAccessibilityEvent(final AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
            final View child = this.getChildAt(i);
            if (child.getVisibility() == 0) {
                final ItemInfo infoForChild = this.infoForChild(child);
                if (infoForChild != null && infoForChild.position == mCurItem && child.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    float distanceInfluenceForSnapDuration(final float n) {
        return (float)Math.sin(0.4712389167638204 * (n - 0.5f));
    }
    
    public void draw(final Canvas canvas) {
        super.draw(canvas);
        final int overScrollMode = ViewCompat.getOverScrollMode((View)this);
        boolean b;
        if (overScrollMode == 0 || (overScrollMode == 1 && mAdapter != null && mAdapter.getCount() > 1)) {
            final boolean finished = mLeftEdge.isFinished();
            b = false;
            if (!finished) {
                final int save = canvas.save();
                final int n = this.getHeight() - this.getPaddingTop() - this.getPaddingBottom();
                final int width = this.getWidth();
                canvas.rotate(270.0f);
                canvas.translate((float)(-n + this.getPaddingTop()), mFirstOffset * (float)width);
                mLeftEdge.setSize(n, width);
                b = (false | mLeftEdge.draw(canvas));
                canvas.restoreToCount(save);
            }
            if (!mRightEdge.isFinished()) {
                final int save2 = canvas.save();
                final int width2 = this.getWidth();
                final int n2 = this.getHeight() - this.getPaddingTop() - this.getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate((float)(-this.getPaddingTop()), -(1.0f + mLastOffset) * (float)width2);
                mRightEdge.setSize(n2, width2);
                b |= mRightEdge.draw(canvas);
                canvas.restoreToCount(save2);
            }
        }
        else {
            mLeftEdge.finish();
            mRightEdge.finish();
            b = false;
        }
        if (b) {
            ViewCompat.postInvalidateOnAnimation((View)this);
        }
    }
    
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        final Drawable mMarginDrawable = this.mMarginDrawable;
        if (mMarginDrawable != null && mMarginDrawable.isStateful()) {
            mMarginDrawable.setState(this.getDrawableState());
        }
    }
    
    public void endFakeDrag() {
        if (!mFakeDragging) {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        }
        if (mAdapter != null) {
            final VelocityTracker mVelocityTracker = this.mVelocityTracker;
            mVelocityTracker.computeCurrentVelocity(1000, (float)mMaximumVelocity);
            final int n = (int)VelocityTrackerCompat.getXVelocity(mVelocityTracker, mActivePointerId);
            mPopulatePending = true;
            final int clientWidth = this.getClientWidth();
            final int scrollX = this.getScrollX();
            final ItemInfo infoForCurrentScrollPosition = this.infoForCurrentScrollPosition();
            this.setCurrentItemInternal(this.determineTargetPage(infoForCurrentScrollPosition.position, (scrollX / clientWidth - infoForCurrentScrollPosition.offset) / infoForCurrentScrollPosition.widthFactor, n, (int)(mLastMotionX - mInitialMotionX)), true, true, n);
        }
        this.endDrag();
        mFakeDragging = false;
    }
    
    public boolean executeKeyEvent(final KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            switch (keyEvent.getKeyCode()) {
                case 21:
                    return this.arrowScroll(17);
                case 22:
                    return this.arrowScroll(66);
                case 61:
                    if (Build$VERSION.SDK_INT < 11) {
                        break;
                    }
                    if (KeyEventCompat.hasNoModifiers(keyEvent)) {
                        return this.arrowScroll(2);
                    }
                    if (KeyEventCompat.hasModifiers(keyEvent, 1)) {
                        return this.arrowScroll(1);
                    }
                    break;
            }
        }
        return false;
    }
    
    public void fakeDragBy(final float n) {
        if (!mFakeDragging) {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        }
        if (mAdapter == null) {
            return;
        }
        mLastMotionX += n;
        float n2 = this.getScrollX() - n;
        final int clientWidth = this.getClientWidth();
        float n3 = clientWidth * mFirstOffset;
        float n4 = clientWidth * mLastOffset;
        final ItemInfo itemInfo = (ItemInfo)mItems.get(0);
        final ItemInfo itemInfo2 = (ItemInfo)mItems.get(-1 + mItems.size());
        if (itemInfo.position != 0) {
            n3 = itemInfo.offset * clientWidth;
        }
        if (itemInfo2.position != -1 + mAdapter.getCount()) {
            n4 = itemInfo2.offset * clientWidth;
        }
        if (n2 < n3) {
            n2 = n3;
        }
        else if (n2 > n4) {
            n2 = n4;
        }
        mLastMotionX += n2 - (int)n2;
        this.scrollTo((int)n2, this.getScrollY());
        this.pageScrolled((int)n2);
        final MotionEvent obtain = MotionEvent.obtain(mFakeDragBeginTime, SystemClock.uptimeMillis(), 2, mLastMotionX, 0.0f, 0);
        mVelocityTracker.addMovement(obtain);
        obtain.recycle();
    }
    
    protected ViewGroup$LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }
    
    public ViewGroup$LayoutParams generateLayoutParams(final AttributeSet set) {
        return new LayoutParams(this.getContext(), set);
    }
    
    protected ViewGroup$LayoutParams generateLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        return this.generateDefaultLayoutParams();
    }
    
    public PagerAdapter getAdapter() {
        return mAdapter;
    }
    
    protected int getChildDrawingOrder(final int n, final int n2) {
        int n3;
        if (mDrawingOrder == 2) {
            n3 = n - 1 - n2;
        }
        else {
            n3 = n2;
        }
        return ((LayoutParams)((View)mDrawingOrderedChildren.get(n3)).getLayoutParams()).childIndex;
    }
    
    public int getCurrentItem() {
        return mCurItem;
    }
    
    public int getOffscreenPageLimit() {
        return mOffscreenPageLimit;
    }
    
    public int getPageMargin() {
        return mPageMargin;
    }
    
    ItemInfo infoForAnyChild(View view) {
        while (true) {
            final ViewParent parent = view.getParent();
            if (parent == this) {
                return this.infoForChild(view);
            }
            if (parent == null || !(parent instanceof View)) {
                return null;
            }
            view = (View)parent;
        }
    }
    
    ItemInfo infoForChild(final View view) {
        for (int i = 0; i < mItems.size(); ++i) {
            final ItemInfo itemInfo = (ItemInfo)mItems.get(i);
            if (mAdapter.isViewFromObject(view, itemInfo.object)) {
                return itemInfo;
            }
        }
        return null;
    }
    
    ItemInfo infoForPosition(final int n) {
        for (int i = 0; i < mItems.size(); ++i) {
            final ItemInfo itemInfo = (ItemInfo)mItems.get(i);
            if (itemInfo.position == n) {
                return itemInfo;
            }
        }
        return null;
    }
    
    void initViewPager() {
        this.setWillNotDraw(false);
        this.setDescendantFocusability(262144);
        this.setFocusable(true);
        final Context context = this.getContext();
        mScroller = new Scroller(context, sInterpolator);
        final ViewConfiguration value = ViewConfiguration.get(context);
        final float density = context.getResources().getDisplayMetrics().density;
        mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(value);
        mMinimumVelocity = (int)(400.0f * density);
        mMaximumVelocity = value.getScaledMaximumFlingVelocity();
        mLeftEdge = new EdgeEffectCompat(context);
        mRightEdge = new EdgeEffectCompat(context);
        mFlingDistance = (int)(25.0f * density);
        mCloseEnough = (int)(2.0f * density);
        mDefaultGutterSize = (int)(16.0f * density);
        ViewCompat.setAccessibilityDelegate(this, (AccessibilityDelegateCompat)new MyAccessibilityDelegate());
        if (ViewCompat.getImportantForAccessibility((View)this) == 0) {
            ViewCompat.setImportantForAccessibility((View)this, 1);
        }
        ViewCompat.setOnApplyWindowInsetsListener(this, (OnApplyWindowInsetsListener)new OnApplyWindowInsetsListener() {
            private final Rect mTempRect = new Rect();
            final /* synthetic */ ViewPager this$0;
            
            ViewPager$4() {
                this$0 = this$0;
                super();
            }
            
            @Override
            public WindowInsetsCompat onApplyWindowInsets(final View view, final WindowInsetsCompat windowInsetsCompat) {
                final WindowInsetsCompat onApplyWindowInsets = ViewCompat.onApplyWindowInsets(view, windowInsetsCompat);
                if (onApplyWindowInsets.isConsumed()) {
                    return onApplyWindowInsets;
                }
                final Rect mTempRect = this.mTempRect;
                mTempRect.left = onApplyWindowInsets.getSystemWindowInsetLeft();
                mTempRect.top = onApplyWindowInsets.getSystemWindowInsetTop();
                mTempRect.right = onApplyWindowInsets.getSystemWindowInsetRight();
                mTempRect.bottom = onApplyWindowInsets.getSystemWindowInsetBottom();
                for (int i = 0; i < this$0.getChildCount(); ++i) {
                    final WindowInsetsCompat dispatchApplyWindowInsets = ViewCompat.dispatchApplyWindowInsets(this$0.getChildAt(i), onApplyWindowInsets);
                    mTempRect.left = Math.min(dispatchApplyWindowInsets.getSystemWindowInsetLeft(), mTempRect.left);
                    mTempRect.top = Math.min(dispatchApplyWindowInsets.getSystemWindowInsetTop(), mTempRect.top);
                    mTempRect.right = Math.min(dispatchApplyWindowInsets.getSystemWindowInsetRight(), mTempRect.right);
                    mTempRect.bottom = Math.min(dispatchApplyWindowInsets.getSystemWindowInsetBottom(), mTempRect.bottom);
                }
                return onApplyWindowInsets.replaceSystemWindowInsets(mTempRect.left, mTempRect.top, mTempRect.right, mTempRect.bottom);
            }
        });
    }
    
    public boolean isFakeDragging() {
        return mFakeDragging;
    }
    
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        mFirstLayout = true;
    }
    
    protected void onDetachedFromWindow() {
        this.removeCallbacks(mEndScrollRunnable);
        if (mScroller != null && !mScroller.isFinished()) {
            mScroller.abortAnimation();
        }
        super.onDetachedFromWindow();
    }
    
    protected void onDraw(final Canvas canvas) {
        super.onDraw(canvas);
        if (mPageMargin > 0 && mMarginDrawable != null && mItems.size() > 0 && mAdapter != null) {
            final int scrollX = this.getScrollX();
            final int width = this.getWidth();
            final float n = mPageMargin / width;
            int n2 = 0;
            ItemInfo itemInfo = (ItemInfo)mItems.get(0);
            float offset = itemInfo.offset;
            final int size = mItems.size();
            final int position = itemInfo.position;
            for (int position2 = ((ItemInfo)mItems.get(size - 1)).position, i = position; i < position2; ++i) {
                while (i > itemInfo.position && n2 < size) {
                    final ArrayList<ItemInfo> mItems = this.mItems;
                    ++n2;
                    itemInfo = mItems.get(n2);
                }
                float n3;
                if (i == itemInfo.position) {
                    n3 = (itemInfo.offset + itemInfo.widthFactor) * width;
                    offset = n + (itemInfo.offset + itemInfo.widthFactor);
                }
                else {
                    final float pageWidth = mAdapter.getPageWidth(i);
                    n3 = (offset + pageWidth) * width;
                    offset += pageWidth + n;
                }
                if (n3 + mPageMargin > scrollX) {
                    mMarginDrawable.setBounds((int)n3, mTopPageBounds, (int)(0.5f + (n3 + mPageMargin)), mBottomPageBounds);
                    mMarginDrawable.draw(canvas);
                }
                if (n3 > scrollX + width) {
                    break;
                }
            }
        }
    }
    
    public boolean onInterceptTouchEvent(final MotionEvent motionEvent) {
        final int n = 0xFF & motionEvent.getAction();
        if (n == 3 || n == 1) {
            this.resetTouch();
            return false;
        }
        if (n != 0) {
            if (mIsBeingDragged) {
                return true;
            }
            if (mIsUnableToDrag) {
                return false;
            }
        }
        switch (n) {
            case 2: {
                final int mActivePointerId = this.mActivePointerId;
                if (mActivePointerId == -1) {
                    break;
                }
                final int pointerIndex = MotionEventCompat.findPointerIndex(motionEvent, mActivePointerId);
                final float x = MotionEventCompat.getX(motionEvent, pointerIndex);
                final float n2 = x - mLastMotionX;
                final float abs = Math.abs(n2);
                final float y = MotionEventCompat.getY(motionEvent, pointerIndex);
                final float abs2 = Math.abs(y - mInitialMotionY);
                if (n2 != 0.0f && !this.isGutterDrag(mLastMotionX, n2) && this.canScroll((View)this, false, (int)n2, (int)x, (int)y)) {
                    mLastMotionX = x;
                    mLastMotionY = y;
                    mIsUnableToDrag = true;
                    return false;
                }
                if (abs > mTouchSlop && 0.5f * abs > abs2) {
                    this.requestParentDisallowInterceptTouchEvent(mIsBeingDragged = true);
                    this.setScrollState(1);
                    float mLastMotionX;
                    if (n2 > 0.0f) {
                        mLastMotionX = mInitialMotionX + mTouchSlop;
                    }
                    else {
                        mLastMotionX = mInitialMotionX - mTouchSlop;
                    }
                    this.mLastMotionX = mLastMotionX;
                    mLastMotionY = y;
                    this.setScrollingCacheEnabled(true);
                }
                else if (abs2 > mTouchSlop) {
                    mIsUnableToDrag = true;
                }
                if (mIsBeingDragged && this.performDrag(x)) {
                    ViewCompat.postInvalidateOnAnimation((View)this);
                    break;
                }
                break;
            }
            case 0: {
                final float x2 = motionEvent.getX();
                mInitialMotionX = x2;
                mLastMotionX = x2;
                final float y2 = motionEvent.getY();
                mInitialMotionY = y2;
                mLastMotionY = y2;
                mActivePointerId = MotionEventCompat.getPointerId(motionEvent, 0);
                mIsUnableToDrag = false;
                mIsScrollStarted = true;
                mScroller.computeScrollOffset();
                if (mScrollState == 2 && Math.abs(mScroller.getFinalX() - mScroller.getCurrX()) > mCloseEnough) {
                    mScroller.abortAnimation();
                    mPopulatePending = false;
                    this.populate();
                    this.requestParentDisallowInterceptTouchEvent(mIsBeingDragged = true);
                    this.setScrollState(1);
                    break;
                }
                this.completeScroll(false);
                mIsBeingDragged = false;
                break;
            }
            case 6:
                this.onSecondaryPointerUp(motionEvent);
                break;
        }
        if (mVelocityTracker == null) {
            mVelocityTracker = VelocityTracker.obtain();
        }
        mVelocityTracker.addMovement(motionEvent);
        return mIsBeingDragged;
    }
    
    protected void onLayout(final boolean b, final int n, final int n2, final int n3, final int n4) {
        final int childCount = this.getChildCount();
        final int n5 = n3 - n;
        final int n6 = n4 - n2;
        int paddingLeft = this.getPaddingLeft();
        int paddingTop = this.getPaddingTop();
        int paddingRight = this.getPaddingRight();
        int paddingBottom = this.getPaddingBottom();
        final int scrollX = this.getScrollX();
        int mDecorChildCount = 0;
        for (int i = 0; i < childCount; ++i) {
            final View child = this.getChildAt(i);
            if (child.getVisibility() != 8) {
                final LayoutParams layoutParams = (LayoutParams)child.getLayoutParams();
                if (layoutParams.isDecor) {
                    final int n7 = 0x7 & layoutParams.gravity;
                    final int n8 = 0x70 & layoutParams.gravity;
                    int max = 0;
                    switch (n7) {
                        default:
                            max = paddingLeft;
                            break;
                        case 3:
                            max = paddingLeft;
                            paddingLeft += child.getMeasuredWidth();
                            break;
                        case 1:
                            max = Math.max((n5 - child.getMeasuredWidth()) / 2, paddingLeft);
                            break;
                        case 5:
                            max = n5 - paddingRight - child.getMeasuredWidth();
                            paddingRight += child.getMeasuredWidth();
                            break;
                    }
                    int max2 = 0;
                    switch (n8) {
                        default:
                            max2 = paddingTop;
                            break;
                        case 48:
                            max2 = paddingTop;
                            paddingTop += child.getMeasuredHeight();
                            break;
                        case 16:
                            max2 = Math.max((n6 - child.getMeasuredHeight()) / 2, paddingTop);
                            break;
                        case 80:
                            max2 = n6 - paddingBottom - child.getMeasuredHeight();
                            paddingBottom += child.getMeasuredHeight();
                            break;
                    }
                    final int n9 = max + scrollX;
                    child.layout(n9, max2, n9 + child.getMeasuredWidth(), max2 + child.getMeasuredHeight());
                    ++mDecorChildCount;
                }
            }
        }
        final int n10 = n5 - paddingLeft - paddingRight;
        for (int j = 0; j < childCount; ++j) {
            final View child2 = this.getChildAt(j);
            if (child2.getVisibility() != 8) {
                final LayoutParams layoutParams2 = (LayoutParams)child2.getLayoutParams();
                if (!layoutParams2.isDecor) {
                    final ItemInfo infoForChild = this.infoForChild(child2);
                    if (infoForChild != null) {
                        final int n11 = paddingLeft + (int)(n10 * infoForChild.offset);
                        final int n12 = paddingTop;
                        if (layoutParams2.needsMeasure) {
                            layoutParams2.needsMeasure = false;
                            child2.measure(View$MeasureSpec.makeMeasureSpec((int)(n10 * layoutParams2.widthFactor), 1073741824), View$MeasureSpec.makeMeasureSpec(n6 - paddingTop - paddingBottom, 1073741824));
                        }
                        child2.layout(n11, n12, n11 + child2.getMeasuredWidth(), n12 + child2.getMeasuredHeight());
                    }
                }
            }
        }
        mTopPageBounds = paddingTop;
        mBottomPageBounds = n6 - paddingBottom;
        this.mDecorChildCount = mDecorChildCount;
        if (mFirstLayout) {
            this.scrollToItem(mCurItem, false, 0, false);
        }
        mFirstLayout = false;
    }
    
    protected void onMeasure(final int n, final int n2) {
        this.setMeasuredDimension(getDefaultSize(0, n), getDefaultSize(0, n2));
        final int measuredWidth = this.getMeasuredWidth();
        mGutterSize = Math.min(measuredWidth / 10, mDefaultGutterSize);
        int n3 = measuredWidth - this.getPaddingLeft() - this.getPaddingRight();
        int n4 = this.getMeasuredHeight() - this.getPaddingTop() - this.getPaddingBottom();
        for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
            final View child = this.getChildAt(i);
            if (child.getVisibility() != 8) {
                final LayoutParams layoutParams = (LayoutParams)child.getLayoutParams();
                if (layoutParams != null && layoutParams.isDecor) {
                    final int n5 = 0x7 & layoutParams.gravity;
                    final int n6 = 0x70 & layoutParams.gravity;
                    int n7 = Integer.MIN_VALUE;
                    int n8 = Integer.MIN_VALUE;
                    boolean b;
                    if (n6 == 48 || n6 == 80) {
                        b = true;
                    }
                    else {
                        b = false;
                    }
                    final boolean b2 = n5 == 3 || n5 == 5;
                    if (b) {
                        n7 = 1073741824;
                    }
                    else if (b2) {
                        n8 = 1073741824;
                    }
                    int width = n3;
                    int height = n4;
                    if (layoutParams.width != -2) {
                        n7 = 1073741824;
                        if (layoutParams.width != -1) {
                            width = layoutParams.width;
                        }
                    }
                    if (layoutParams.height != -2) {
                        n8 = 1073741824;
                        if (layoutParams.height != -1) {
                            height = layoutParams.height;
                        }
                    }
                    child.measure(View$MeasureSpec.makeMeasureSpec(width, n7), View$MeasureSpec.makeMeasureSpec(height, n8));
                    if (b) {
                        n4 -= child.getMeasuredHeight();
                    }
                    else if (b2) {
                        n3 -= child.getMeasuredWidth();
                    }
                }
            }
        }
        mChildWidthMeasureSpec = View$MeasureSpec.makeMeasureSpec(n3, 1073741824);
        mChildHeightMeasureSpec = View$MeasureSpec.makeMeasureSpec(n4, 1073741824);
        mInLayout = true;
        this.populate();
        mInLayout = false;
        for (int childCount2 = this.getChildCount(), j = 0; j < childCount2; ++j) {
            final View child2 = this.getChildAt(j);
            if (child2.getVisibility() != 8) {
                final LayoutParams layoutParams2 = (LayoutParams)child2.getLayoutParams();
                if (layoutParams2 == null || !layoutParams2.isDecor) {
                    child2.measure(View$MeasureSpec.makeMeasureSpec((int)(n3 * layoutParams2.widthFactor), 1073741824), mChildHeightMeasureSpec);
                }
            }
        }
    }
    
    @CallSuper
    protected void onPageScrolled(final int n, final float n2, final int n3) {
        if (mDecorChildCount > 0) {
            final int scrollX = this.getScrollX();
            int paddingLeft = this.getPaddingLeft();
            int paddingRight = this.getPaddingRight();
            final int width = this.getWidth();
            for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
                final View child = this.getChildAt(i);
                final LayoutParams layoutParams = (LayoutParams)child.getLayoutParams();
                if (layoutParams.isDecor) {
                    int max = 0;
                    switch (0x7 & layoutParams.gravity) {
                        default:
                            max = paddingLeft;
                            break;
                        case 3:
                            max = paddingLeft;
                            paddingLeft += child.getWidth();
                            break;
                        case 1:
                            max = Math.max((width - child.getMeasuredWidth()) / 2, paddingLeft);
                            break;
                        case 5:
                            max = width - paddingRight - child.getMeasuredWidth();
                            paddingRight += child.getMeasuredWidth();
                            break;
                    }
                    final int n4 = max + scrollX - child.getLeft();
                    if (n4 != 0) {
                        child.offsetLeftAndRight(n4);
                    }
                }
            }
        }
        this.dispatchOnPageScrolled(n, n2, n3);
        if (mPageTransformer != null) {
            final int scrollX2 = this.getScrollX();
            for (int childCount2 = this.getChildCount(), j = 0; j < childCount2; ++j) {
                final View child2 = this.getChildAt(j);
                if (!((LayoutParams)child2.getLayoutParams()).isDecor) {
                    mPageTransformer.transformPage(child2, (float)(child2.getLeft() - scrollX2) / (float)this.getClientWidth());
                }
            }
        }
        mCalledSuper = true;
    }
    
    protected boolean onRequestFocusInDescendants(final int n, final Rect rect) {
        final int childCount = this.getChildCount();
        int n2;
        int n3;
        int n4;
        if ((n & 0x2) != 0x0) {
            n2 = 0;
            n3 = 1;
            n4 = childCount;
        }
        else {
            n2 = childCount - 1;
            n3 = -1;
            n4 = -1;
        }
        for (int i = n2; i != n4; i += n3) {
            final View child = this.getChildAt(i);
            if (child.getVisibility() == 0) {
                final ItemInfo infoForChild = this.infoForChild(child);
                if (infoForChild != null && infoForChild.position == mCurItem && child.requestFocus(n, rect)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public void onRestoreInstanceState(final Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        final SavedState savedState = (SavedState)parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (mAdapter != null) {
            mAdapter.restoreState(savedState.adapterState, savedState.loader);
            this.setCurrentItemInternal(savedState.position, false, true);
            return;
        }
        mRestoredCurItem = savedState.position;
        mRestoredAdapterState = savedState.adapterState;
        mRestoredClassLoader = savedState.loader;
    }
    
    public Parcelable onSaveInstanceState() {
        final SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.position = mCurItem;
        if (mAdapter != null) {
            savedState.adapterState = mAdapter.saveState();
        }
        return (Parcelable)savedState;
    }
    
    protected void onSizeChanged(final int n, final int n2, final int n3, final int n4) {
        super.onSizeChanged(n, n2, n3, n4);
        if (n != n3) {
            this.recomputeScrollPosition(n, n3, mPageMargin, mPageMargin);
        }
    }
    
    public boolean onTouchEvent(final MotionEvent motionEvent) {
        if (mFakeDragging) {
            return true;
        }
        if (motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) {
            return false;
        }
        if (mAdapter == null || mAdapter.getCount() == 0) {
            return false;
        }
        if (mVelocityTracker == null) {
            mVelocityTracker = VelocityTracker.obtain();
        }
        mVelocityTracker.addMovement(motionEvent);
        final int n = 0xFF & motionEvent.getAction();
        int n2 = 0;
        switch (n) {
            case 0: {
                mScroller.abortAnimation();
                mPopulatePending = false;
                this.populate();
                final float x = motionEvent.getX();
                mInitialMotionX = x;
                mLastMotionX = x;
                final float y = motionEvent.getY();
                mInitialMotionY = y;
                mLastMotionY = y;
                mActivePointerId = MotionEventCompat.getPointerId(motionEvent, 0);
                n2 = 0;
                break;
            }
            case 2: {
                if (!mIsBeingDragged) {
                    final int pointerIndex = MotionEventCompat.findPointerIndex(motionEvent, mActivePointerId);
                    if (pointerIndex == -1) {
                        n2 = (this.resetTouch() ? 1 : 0);
                        break;
                    }
                    final float x2 = MotionEventCompat.getX(motionEvent, pointerIndex);
                    final float abs = Math.abs(x2 - mLastMotionX);
                    final float y2 = MotionEventCompat.getY(motionEvent, pointerIndex);
                    final float abs2 = Math.abs(y2 - mLastMotionY);
                    if (abs > mTouchSlop && abs > abs2) {
                        this.requestParentDisallowInterceptTouchEvent(mIsBeingDragged = true);
                        float mLastMotionX;
                        if (x2 - mInitialMotionX > 0.0f) {
                            mLastMotionX = mInitialMotionX + mTouchSlop;
                        }
                        else {
                            mLastMotionX = mInitialMotionX - mTouchSlop;
                        }
                        this.mLastMotionX = mLastMotionX;
                        mLastMotionY = y2;
                        this.setScrollState(1);
                        this.setScrollingCacheEnabled(true);
                        final ViewParent parent = this.getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                }
                final boolean mIsBeingDragged = this.mIsBeingDragged;
                n2 = 0;
                if (mIsBeingDragged) {
                    n2 = ((false | this.performDrag(MotionEventCompat.getX(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, mActivePointerId)))) ? 1 : 0);
                    break;
                }
                break;
            }
            case 1: {
                final boolean mIsBeingDragged2 = mIsBeingDragged;
                n2 = 0;
                if (mIsBeingDragged2) {
                    final VelocityTracker mVelocityTracker = this.mVelocityTracker;
                    mVelocityTracker.computeCurrentVelocity(1000, (float)mMaximumVelocity);
                    final int n3 = (int)VelocityTrackerCompat.getXVelocity(mVelocityTracker, mActivePointerId);
                    mPopulatePending = true;
                    final int clientWidth = this.getClientWidth();
                    final int scrollX = this.getScrollX();
                    final ItemInfo infoForCurrentScrollPosition = this.infoForCurrentScrollPosition();
                    this.setCurrentItemInternal(this.determineTargetPage(infoForCurrentScrollPosition.position, (scrollX / clientWidth - infoForCurrentScrollPosition.offset) / infoForCurrentScrollPosition.widthFactor, n3, (int)(MotionEventCompat.getX(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, mActivePointerId)) - mInitialMotionX)), true, true, n3);
                    n2 = (this.resetTouch() ? 1 : 0);
                    break;
                }
                break;
            }
            case 3: {
                final boolean mIsBeingDragged3 = mIsBeingDragged;
                n2 = 0;
                if (mIsBeingDragged3) {
                    this.scrollToItem(mCurItem, true, 0, false);
                    n2 = (this.resetTouch() ? 1 : 0);
                    break;
                }
                break;
            }
            case 5: {
                final int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                mLastMotionX = MotionEventCompat.getX(motionEvent, actionIndex);
                mActivePointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                n2 = 0;
                break;
            }
            case 6:
                this.onSecondaryPointerUp(motionEvent);
                mLastMotionX = MotionEventCompat.getX(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, mActivePointerId));
                n2 = 0;
                break;
        }
        if (n2 != 0) {
            ViewCompat.postInvalidateOnAnimation((View)this);
        }
        return true;
    }
    
    boolean pageLeft() {
        if (mCurItem > 0) {
            this.setCurrentItem(-1 + mCurItem, true);
            return true;
        }
        return false;
    }
    
    boolean pageRight() {
        if (mAdapter != null && mCurItem < -1 + mAdapter.getCount()) {
            this.setCurrentItem(1 + mCurItem, true);
            return true;
        }
        return false;
    }
    
    void populate() {
        this.populate(mCurItem);
    }
    
    void populate(final int mCurItem) {
        final int mCurItem2 = this.mCurItem;
        ItemInfo infoForPosition = null;
        if (mCurItem2 != mCurItem) {
            infoForPosition = this.infoForPosition(this.mCurItem);
            this.mCurItem = mCurItem;
        }
        if (mAdapter == null) {
            this.sortChildDrawingOrder();
        }
        else {
            if (mPopulatePending) {
                this.sortChildDrawingOrder();
                return;
            }
            if (this.getWindowToken() != null) {
                mAdapter.startUpdate(this);
                final int mOffscreenPageLimit = this.mOffscreenPageLimit;
                final int max = Math.max(0, this.mCurItem - mOffscreenPageLimit);
                final int count = mAdapter.getCount();
                final int min = Math.min(count - 1, mOffscreenPageLimit + this.mCurItem);
                if (count != mExpectedAdapterCount) {
                    try {
                        final String s = this.getResources().getResourceName(this.getId());
                        throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + mExpectedAdapterCount + ", found: " + count + " Pager id: " + s + " Pager class: " + this.getClass() + " Problematic adapter: " + mAdapter.getClass());
                    }
                    catch (Resources$NotFoundException ex) {
                        final String s = Integer.toHexString(this.getId());
                        throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + mExpectedAdapterCount + ", found: " + count + " Pager id: " + s + " Pager class: " + this.getClass() + " Problematic adapter: " + mAdapter.getClass());
                    }
                }
                int n = 0;
                ItemInfo addNewItem;
                while (true) {
                    final int size = mItems.size();
                    addNewItem = null;
                    if (n >= size) {
                        break;
                    }
                    final ItemInfo itemInfo = (ItemInfo)mItems.get(n);
                    if (itemInfo.position >= this.mCurItem) {
                        final int position = itemInfo.position;
                        final int mCurItem3 = this.mCurItem;
                        addNewItem = null;
                        if (position == mCurItem3) {
                            addNewItem = itemInfo;
                            break;
                        }
                        break;
                    }
                    else {
                        ++n;
                    }
                }
                if (addNewItem == null && count > 0) {
                    addNewItem = this.addNewItem(this.mCurItem, n);
                }
                if (addNewItem != null) {
                    float n2 = 0.0f;
                    int n3 = n - 1;
                    ItemInfo itemInfo2;
                    if (n3 >= 0) {
                        itemInfo2 = mItems.get(n3);
                    }
                    else {
                        itemInfo2 = null;
                    }
                    final int clientWidth = this.getClientWidth();
                    float n4;
                    if (clientWidth <= 0) {
                        n4 = 0.0f;
                    }
                    else {
                        n4 = 2.0f - addNewItem.widthFactor + this.getPaddingLeft() / clientWidth;
                    }
                    for (int i = -1 + this.mCurItem; i >= 0; --i) {
                        if (n2 >= n4 && i < max) {
                            if (itemInfo2 == null) {
                                break;
                            }
                            if (i == itemInfo2.position && !itemInfo2.scrolling) {
                                mItems.remove(n3);
                                mAdapter.destroyItem(this, i, itemInfo2.object);
                                --n3;
                                --n;
                                if (n3 >= 0) {
                                    itemInfo2 = mItems.get(n3);
                                }
                                else {
                                    itemInfo2 = null;
                                }
                            }
                        }
                        else if (itemInfo2 != null && i == itemInfo2.position) {
                            n2 += itemInfo2.widthFactor;
                            if (--n3 >= 0) {
                                itemInfo2 = mItems.get(n3);
                            }
                            else {
                                itemInfo2 = null;
                            }
                        }
                        else {
                            n2 += this.addNewItem(i, n3 + 1).widthFactor;
                            ++n;
                            if (n3 >= 0) {
                                itemInfo2 = mItems.get(n3);
                            }
                            else {
                                itemInfo2 = null;
                            }
                        }
                    }
                    float widthFactor = addNewItem.widthFactor;
                    int n5 = n + 1;
                    if (widthFactor < 2.0f) {
                        ItemInfo itemInfo3;
                        if (n5 < mItems.size()) {
                            itemInfo3 = mItems.get(n5);
                        }
                        else {
                            itemInfo3 = null;
                        }
                        float n6;
                        if (clientWidth <= 0) {
                            n6 = 0.0f;
                        }
                        else {
                            n6 = 2.0f + this.getPaddingRight() / clientWidth;
                        }
                        for (int j = 1 + this.mCurItem; j < count; ++j) {
                            if (widthFactor >= n6 && j > min) {
                                if (itemInfo3 == null) {
                                    break;
                                }
                                if (j == itemInfo3.position && !itemInfo3.scrolling) {
                                    mItems.remove(n5);
                                    mAdapter.destroyItem(this, j, itemInfo3.object);
                                    if (n5 < mItems.size()) {
                                        itemInfo3 = mItems.get(n5);
                                    }
                                    else {
                                        itemInfo3 = null;
                                    }
                                }
                            }
                            else if (itemInfo3 != null && j == itemInfo3.position) {
                                widthFactor += itemInfo3.widthFactor;
                                ++n5;
                                if (n5 < mItems.size()) {
                                    itemInfo3 = mItems.get(n5);
                                }
                                else {
                                    itemInfo3 = null;
                                }
                            }
                            else {
                                final ItemInfo addNewItem2 = this.addNewItem(j, n5);
                                ++n5;
                                widthFactor += addNewItem2.widthFactor;
                                if (n5 < mItems.size()) {
                                    itemInfo3 = mItems.get(n5);
                                }
                                else {
                                    itemInfo3 = null;
                                }
                            }
                        }
                    }
                    this.calculatePageOffsets(addNewItem, n, infoForPosition);
                }
                final PagerAdapter mAdapter = this.mAdapter;
                final int mCurItem4 = this.mCurItem;
                Object object;
                if (addNewItem != null) {
                    object = addNewItem.object;
                }
                else {
                    object = null;
                }
                mAdapter.setPrimaryItem(this, mCurItem4, object);
                this.mAdapter.finishUpdate(this);
                for (int childCount = this.getChildCount(), k = 0; k < childCount; ++k) {
                    final View child = this.getChildAt(k);
                    final LayoutParams layoutParams = (LayoutParams)child.getLayoutParams();
                    layoutParams.childIndex = k;
                    if (!layoutParams.isDecor && layoutParams.widthFactor == 0.0f) {
                        final ItemInfo infoForChild = this.infoForChild(child);
                        if (infoForChild != null) {
                            layoutParams.widthFactor = infoForChild.widthFactor;
                            layoutParams.position = infoForChild.position;
                        }
                    }
                }
                this.sortChildDrawingOrder();
                if (this.hasFocus()) {
                    final View focus = this.findFocus();
                    ItemInfo infoForAnyChild;
                    if (focus != null) {
                        infoForAnyChild = this.infoForAnyChild(focus);
                    }
                    else {
                        infoForAnyChild = null;
                    }
                    if (infoForAnyChild == null || infoForAnyChild.position != this.mCurItem) {
                        for (int l = 0; l < this.getChildCount(); ++l) {
                            final View child2 = this.getChildAt(l);
                            final ItemInfo infoForChild2 = this.infoForChild(child2);
                            if (infoForChild2 != null && infoForChild2.position == this.mCurItem && child2.requestFocus(2)) {
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
    
    public void removeOnPageChangeListener(final OnPageChangeListener onPageChangeListener) {
        if (mOnPageChangeListeners != null) {
            mOnPageChangeListeners.remove(onPageChangeListener);
        }
    }
    
    public void removeView(final View view) {
        if (mInLayout) {
            this.removeViewInLayout(view);
            return;
        }
        super.removeView(view);
    }
    
    public void setAdapter(final PagerAdapter mAdapter) {
        if (this.mAdapter != null) {
            this.mAdapter.setViewPagerObserver(null);
            this.mAdapter.startUpdate(this);
            for (int i = 0; i < mItems.size(); ++i) {
                final ItemInfo itemInfo = (ItemInfo)mItems.get(i);
                this.mAdapter.destroyItem(this, itemInfo.position, itemInfo.object);
            }
            this.mAdapter.finishUpdate(this);
            mItems.clear();
            this.removeNonDecorViews();
            this.scrollTo(mCurItem = 0, 0);
        }
        final PagerAdapter mAdapter2 = this.mAdapter;
        this.mAdapter = mAdapter;
        mExpectedAdapterCount = 0;
        if (this.mAdapter != null) {
            if (mObserver == null) {
                mObserver = new PagerObserver(this);
            }
            this.mAdapter.setViewPagerObserver(mObserver);
            mPopulatePending = false;
            final boolean mFirstLayout = this.mFirstLayout;
            this.mFirstLayout = true;
            mExpectedAdapterCount = this.mAdapter.getCount();
            if (mRestoredCurItem >= 0) {
                this.mAdapter.restoreState(mRestoredAdapterState, mRestoredClassLoader);
                this.setCurrentItemInternal(mRestoredCurItem, false, true);
                mRestoredCurItem = -1;
                mRestoredAdapterState = null;
                mRestoredClassLoader = null;
            }
            else if (!mFirstLayout) {
                this.populate();
            }
            else {
                this.requestLayout();
            }
        }
        if (mAdapterChangeListener != null && mAdapter2 != mAdapter) {
            mAdapterChangeListener.onAdapterChanged(mAdapter2, mAdapter);
        }
    }
    
    void setChildrenDrawingOrderEnabledCompat(final boolean p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: bipush          7
        //     5: if_icmplt       71
        //     8: aload_0        
        //     9: getfield        android/support/v4/view/ViewPager.mSetChildrenDrawingOrderEnabled:Ljava/lang/reflect/Method;
        //    12: ifnonnull       42
        //    15: iconst_1       
        //    16: anewarray       Ljava/lang/Class;
        //    19: astore          9
        //    21: aload           9
        //    23: iconst_0       
        //    24: getstatic       java/lang/Boolean.TYPE:Ljava/lang/Class;
        //    27: aastore        
        //    28: aload_0        
        //    29: ldc             Landroid/view/ViewGroup;.class
        //    31: ldc_w           "setChildrenDrawingOrderEnabled"
        //    34: aload           9
        //    36: invokevirtual   java/lang/Class.getDeclaredMethod:(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
        //    39: putfield        android/support/v4/view/ViewPager.mSetChildrenDrawingOrderEnabled:Ljava/lang/reflect/Method;
        //    42: aload_0        
        //    43: getfield        android/support/v4/view/ViewPager.mSetChildrenDrawingOrderEnabled:Ljava/lang/reflect/Method;
        //    46: astore          4
        //    48: iconst_1       
        //    49: anewarray       Ljava/lang/Object;
        //    52: astore          5
        //    54: aload           5
        //    56: iconst_0       
        //    57: iload_1        
        //    58: invokestatic    java/lang/Boolean.valueOf:(Z)Ljava/lang/Boolean;
        //    61: aastore        
        //    62: aload           4
        //    64: aload_0        
        //    65: aload           5
        //    67: invokevirtual   java/lang/reflect/Method.invoke:(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
        //    70: pop            
        //    71: return         
        //    72: astore          7
        //    74: ldc             "ViewPager"
        //    76: ldc_w           "Can't find setChildrenDrawingOrderEnabled"
        //    79: aload           7
        //    81: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //    84: pop            
        //    85: goto            42
        //    88: astore_2       
        //    89: ldc             "ViewPager"
        //    91: ldc_w           "Error changing children drawing order"
        //    94: aload_2        
        //    95: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //    98: pop            
        //    99: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                             
        //  -----  -----  -----  -----  ---------------------------------
        //  15     42     72     88     Ljava/lang/NoSuchMethodException;
        //  42     71     88     100    Ljava/lang/Exception;
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public void setCurrentItem(final int n) {
        mPopulatePending = false;
        this.setCurrentItemInternal(n, !mFirstLayout, false);
    }
    
    public void setCurrentItem(final int n, final boolean b) {
        this.setCurrentItemInternal(n, b, mPopulatePending = false);
    }
    
    void setCurrentItemInternal(final int n, final boolean b, final boolean b2) {
        this.setCurrentItemInternal(n, b, b2, 0);
    }
    
    void setCurrentItemInternal(int mCurItem, final boolean b, final boolean b2, final int n) {
        boolean scrolling = true;
        if (mAdapter == null || mAdapter.getCount() <= 0) {
            this.setScrollingCacheEnabled(false);
            return;
        }
        if (!b2 && this.mCurItem == mCurItem && mItems.size() != 0) {
            this.setScrollingCacheEnabled(false);
            return;
        }
        if (mCurItem < 0) {
            mCurItem = 0;
        }
        else if (mCurItem >= mAdapter.getCount()) {
            mCurItem = -1 + mAdapter.getCount();
        }
        final int mOffscreenPageLimit = this.mOffscreenPageLimit;
        if (mCurItem > mOffscreenPageLimit + this.mCurItem || mCurItem < this.mCurItem - mOffscreenPageLimit) {
            for (int i = 0; i < mItems.size(); ++i) {
                ((ItemInfo)mItems.get(i)).scrolling = scrolling;
            }
        }
        if (this.mCurItem == mCurItem) {
            scrolling = false;
        }
        if (mFirstLayout) {
            this.mCurItem = mCurItem;
            if (scrolling) {
                this.dispatchOnPageSelected(mCurItem);
            }
            this.requestLayout();
            return;
        }
        this.populate(mCurItem);
        this.scrollToItem(mCurItem, b, n, scrolling);
    }
    
    OnPageChangeListener setInternalPageChangeListener(final OnPageChangeListener mInternalPageChangeListener) {
        final OnPageChangeListener mInternalPageChangeListener2 = this.mInternalPageChangeListener;
        this.mInternalPageChangeListener = mInternalPageChangeListener;
        return mInternalPageChangeListener2;
    }
    
    public void setOffscreenPageLimit(int mOffscreenPageLimit) {
        if (mOffscreenPageLimit < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + mOffscreenPageLimit + " too small; defaulting to " + 1);
            mOffscreenPageLimit = 1;
        }
        if (mOffscreenPageLimit != this.mOffscreenPageLimit) {
            this.mOffscreenPageLimit = mOffscreenPageLimit;
            this.populate();
        }
    }
    
    void setOnAdapterChangeListener(final OnAdapterChangeListener mAdapterChangeListener) {
        this.mAdapterChangeListener = mAdapterChangeListener;
    }
    
    @Deprecated
    public void setOnPageChangeListener(final OnPageChangeListener mOnPageChangeListener) {
        this.mOnPageChangeListener = mOnPageChangeListener;
    }
    
    public void setPageMargin(final int mPageMargin) {
        final int mPageMargin2 = this.mPageMargin;
        this.mPageMargin = mPageMargin;
        final int width = this.getWidth();
        this.recomputeScrollPosition(width, width, mPageMargin, mPageMargin2);
        this.requestLayout();
    }
    
    public void setPageMarginDrawable(@DrawableRes final int n) {
        this.setPageMarginDrawable(this.getContext().getResources().getDrawable(n));
    }
    
    public void setPageMarginDrawable(final Drawable mMarginDrawable) {
        this.mMarginDrawable = mMarginDrawable;
        if (mMarginDrawable != null) {
            this.refreshDrawableState();
        }
        this.setWillNotDraw(mMarginDrawable == null);
        this.invalidate();
    }
    
    public void setPageTransformer(final boolean b, final PageTransformer mPageTransformer) {
        int mDrawingOrder = 1;
        if (Build$VERSION.SDK_INT >= 11) {
            int childrenDrawingOrderEnabledCompat;
            if (mPageTransformer != null) {
                childrenDrawingOrderEnabledCompat = mDrawingOrder;
            }
            else {
                childrenDrawingOrderEnabledCompat = 0;
            }
            boolean b2;
            if (this.mPageTransformer != null) {
                b2 = (mDrawingOrder != 0);
            }
            else {
                b2 = false;
            }
            int n;
            if (childrenDrawingOrderEnabledCompat != (b2 ? 1 : 0)) {
                n = mDrawingOrder;
            }
            else {
                n = 0;
            }
            this.mPageTransformer = mPageTransformer;
            this.setChildrenDrawingOrderEnabledCompat(childrenDrawingOrderEnabledCompat != 0);
            if (childrenDrawingOrderEnabledCompat != 0) {
                if (b) {
                    mDrawingOrder = 2;
                }
                this.mDrawingOrder = mDrawingOrder;
            }
            else {
                this.mDrawingOrder = 0;
            }
            if (n != 0) {
                this.populate();
            }
        }
    }
    
    void smoothScrollTo(final int n, final int n2) {
        this.smoothScrollTo(n, n2, 0);
    }
    
    void smoothScrollTo(final int n, final int n2, final int n3) {
        if (this.getChildCount() == 0) {
            this.setScrollingCacheEnabled(false);
            return;
        }
        int n4;
        if (mScroller != null && !mScroller.isFinished()) {
            n4 = 1;
        }
        else {
            n4 = 0;
        }
        int n5;
        if (n4 != 0) {
            if (mIsScrollStarted) {
                n5 = mScroller.getCurrX();
            }
            else {
                n5 = mScroller.getStartX();
            }
            mScroller.abortAnimation();
            this.setScrollingCacheEnabled(false);
        }
        else {
            n5 = this.getScrollX();
        }
        final int scrollY = this.getScrollY();
        final int n6 = n - n5;
        final int n7 = n2 - scrollY;
        if (n6 == 0 && n7 == 0) {
            this.completeScroll(false);
            this.populate();
            this.setScrollState(0);
            return;
        }
        this.setScrollingCacheEnabled(true);
        this.setScrollState(2);
        final int clientWidth = this.getClientWidth();
        final int n8 = clientWidth / 2;
        final float n9 = n8 + n8 * this.distanceInfluenceForSnapDuration(Math.min(1.0f, 1.0f * Math.abs(n6) / (float)clientWidth));
        final int abs = Math.abs(n3);
        int n10;
        if (abs > 0) {
            n10 = 4 * Math.round(1000.0f * Math.abs(n9 / (float)abs));
        }
        else {
            n10 = (int)(100.0f * (1.0f + Math.abs(n6) / (clientWidth * mAdapter.getPageWidth(mCurItem) + mPageMargin)));
        }
        final int min = Math.min(n10, 600);
        mIsScrollStarted = false;
        mScroller.startScroll(n5, scrollY, n6, n7, min);
        ViewCompat.postInvalidateOnAnimation((View)this);
    }
    
    protected boolean verifyDrawable(final Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == mMarginDrawable;
    }
}
