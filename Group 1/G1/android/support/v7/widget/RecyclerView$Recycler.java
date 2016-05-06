package android.support.v7.widget;

import android.util.SparseArray;
import android.util.Log;
import android.view.ViewGroup$LayoutParams;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.view.ViewGroup;
import android.support.v4.view.ViewCompat;
import android.view.View;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public final class Recycler
{
    private static final int DEFAULT_CACHE_SIZE = 2;
    final ArrayList<ViewHolder> mAttachedScrap;
    final ArrayList<ViewHolder> mCachedViews;
    private ArrayList<ViewHolder> mChangedScrap;
    private RecycledViewPool mRecyclerPool;
    private final List<ViewHolder> mUnmodifiableAttachedScrap;
    private ViewCacheExtension mViewCacheExtension;
    private int mViewCacheMax;
    final /* synthetic */ RecyclerView this$0;
    
    public Recycler(final RecyclerView this$0) {
        this$0 = this$0;
        super();
        mAttachedScrap = new ArrayList<ViewHolder>();
        mChangedScrap = null;
        mCachedViews = new ArrayList<ViewHolder>();
        mUnmodifiableAttachedScrap = Collections.<ViewHolder>unmodifiableList((List<? extends ViewHolder>)mAttachedScrap);
        mViewCacheMax = 2;
    }
    
    static /* synthetic */ ArrayList access$2900(final Recycler recycler) {
        return recycler.mChangedScrap;
    }
    
    private void attachAccessibilityDelegate(final View view) {
        if (this$0.isAccessibilityEnabled()) {
            if (ViewCompat.getImportantForAccessibility(view) == 0) {
                ViewCompat.setImportantForAccessibility(view, 1);
            }
            if (!ViewCompat.hasAccessibilityDelegate(view)) {
                ViewCompat.setAccessibilityDelegate(view, RecyclerView.access$4800(this$0).getItemDelegate());
            }
        }
    }
    
    private void invalidateDisplayListInt(final ViewHolder viewHolder) {
        if (viewHolder.itemView instanceof ViewGroup) {
            this.invalidateDisplayListInt((ViewGroup)viewHolder.itemView, false);
        }
    }
    
    private void invalidateDisplayListInt(final ViewGroup viewGroup, final boolean b) {
        for (int i = -1 + viewGroup.getChildCount(); i >= 0; --i) {
            final View child = viewGroup.getChildAt(i);
            if (child instanceof ViewGroup) {
                this.invalidateDisplayListInt((ViewGroup)child, true);
            }
        }
        if (!b) {
            return;
        }
        if (viewGroup.getVisibility() == 4) {
            viewGroup.setVisibility(0);
            viewGroup.setVisibility(4);
            return;
        }
        final int visibility = viewGroup.getVisibility();
        viewGroup.setVisibility(4);
        viewGroup.setVisibility(visibility);
    }
    
    void addViewHolderToRecycledViewPool(final ViewHolder viewHolder) {
        ViewCompat.setAccessibilityDelegate(viewHolder.itemView, null);
        this.dispatchViewRecycled(viewHolder);
        viewHolder.mOwnerRecyclerView = null;
        this.getRecycledViewPool().putRecycledView(viewHolder);
    }
    
    public void bindViewToPosition(final View view, final int mPreLayoutPosition) {
        boolean b = true;
        final ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        if (childViewHolderInt == null) {
            throw new IllegalArgumentException("The view does not have a ViewHolder. You cannot pass arbitrary views to this method, they should be created by the Adapter");
        }
        final int positionOffset = mAdapterHelper.findPositionOffset(mPreLayoutPosition);
        if (positionOffset < 0 || positionOffset >= RecyclerView.access$3100(this$0).getItemCount()) {
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + mPreLayoutPosition + "(offset:" + positionOffset + ")." + "state:" + mState.getItemCount());
        }
        childViewHolderInt.mOwnerRecyclerView = this$0;
        RecyclerView.access$3100(this$0).bindViewHolder(childViewHolderInt, positionOffset);
        this.attachAccessibilityDelegate(view);
        if (mState.isPreLayout()) {
            childViewHolderInt.mPreLayoutPosition = mPreLayoutPosition;
        }
        final ViewGroup$LayoutParams layoutParams = childViewHolderInt.itemView.getLayoutParams();
        LayoutParams layoutParams2;
        if (layoutParams == null) {
            layoutParams2 = (LayoutParams)this$0.generateDefaultLayoutParams();
            childViewHolderInt.itemView.setLayoutParams((ViewGroup$LayoutParams)layoutParams2);
        }
        else if (!this$0.checkLayoutParams(layoutParams)) {
            layoutParams2 = (LayoutParams)this$0.generateLayoutParams(layoutParams);
            childViewHolderInt.itemView.setLayoutParams((ViewGroup$LayoutParams)layoutParams2);
        }
        else {
            layoutParams2 = (LayoutParams)layoutParams;
        }
        layoutParams2.mInsetsDirty = b;
        layoutParams2.mViewHolder = childViewHolderInt;
        if (childViewHolderInt.itemView.getParent() != null) {
            b = false;
        }
        layoutParams2.mPendingInvalidate = b;
    }
    
    public void clear() {
        mAttachedScrap.clear();
        this.recycleAndClearCachedViews();
    }
    
    void clearOldPositions() {
        for (int size = mCachedViews.size(), i = 0; i < size; ++i) {
            ((ViewHolder)mCachedViews.get(i)).clearOldPosition();
        }
        for (int size2 = mAttachedScrap.size(), j = 0; j < size2; ++j) {
            ((ViewHolder)mAttachedScrap.get(j)).clearOldPosition();
        }
        if (mChangedScrap != null) {
            for (int size3 = mChangedScrap.size(), k = 0; k < size3; ++k) {
                ((ViewHolder)mChangedScrap.get(k)).clearOldPosition();
            }
        }
    }
    
    void clearScrap() {
        mAttachedScrap.clear();
        if (mChangedScrap != null) {
            mChangedScrap.clear();
        }
    }
    
    public int convertPreLayoutPositionToPostLayout(final int n) {
        if (n < 0 || n >= mState.getItemCount()) {
            throw new IndexOutOfBoundsException("invalid position " + n + ". State " + "item count is " + mState.getItemCount());
        }
        if (!mState.isPreLayout()) {
            return n;
        }
        return mAdapterHelper.findPositionOffset(n);
    }
    
    void dispatchViewRecycled(final ViewHolder viewHolder) {
        if (RecyclerView.access$5300(this$0) != null) {
            RecyclerView.access$5300(this$0).onViewRecycled(viewHolder);
        }
        if (RecyclerView.access$3100(this$0) != null) {
            RecyclerView.access$3100(this$0).onViewRecycled(viewHolder);
        }
        if (mState != null) {
            mViewInfoStore.removeViewHolder(viewHolder);
        }
    }
    
    ViewHolder getChangedScrapViewForPosition(final int n) {
        if (mChangedScrap != null) {
            final int size = mChangedScrap.size();
            if (size != 0) {
                for (int i = 0; i < size; ++i) {
                    final ViewHolder viewHolder = (ViewHolder)mChangedScrap.get(i);
                    if (!viewHolder.wasReturnedFromScrap() && viewHolder.getLayoutPosition() == n) {
                        viewHolder.addFlags(32);
                        return viewHolder;
                    }
                }
                if (RecyclerView.access$3100(this$0).hasStableIds()) {
                    final int positionOffset = mAdapterHelper.findPositionOffset(n);
                    if (positionOffset > 0 && positionOffset < RecyclerView.access$3100(this$0).getItemCount()) {
                        final long itemId = RecyclerView.access$3100(this$0).getItemId(positionOffset);
                        for (int j = 0; j < size; ++j) {
                            final ViewHolder viewHolder2 = (ViewHolder)mChangedScrap.get(j);
                            if (!viewHolder2.wasReturnedFromScrap() && viewHolder2.getItemId() == itemId) {
                                viewHolder2.addFlags(32);
                                return viewHolder2;
                            }
                        }
                    }
                }
                return null;
            }
        }
        return null;
    }
    
    RecycledViewPool getRecycledViewPool() {
        if (mRecyclerPool == null) {
            mRecyclerPool = new RecycledViewPool();
        }
        return mRecyclerPool;
    }
    
    int getScrapCount() {
        return mAttachedScrap.size();
    }
    
    public List<ViewHolder> getScrapList() {
        return mUnmodifiableAttachedScrap;
    }
    
    View getScrapViewAt(final int n) {
        return ((ViewHolder)mAttachedScrap.get(n)).itemView;
    }
    
    ViewHolder getScrapViewForId(final long n, final int n2, final boolean b) {
        for (int i = -1 + mAttachedScrap.size(); i >= 0; --i) {
            final ViewHolder viewHolder = (ViewHolder)mAttachedScrap.get(i);
            if (viewHolder.getItemId() == n && !viewHolder.wasReturnedFromScrap()) {
                if (n2 == viewHolder.getItemViewType()) {
                    viewHolder.addFlags(32);
                    if (viewHolder.isRemoved() && !mState.isPreLayout()) {
                        viewHolder.setFlags(2, 14);
                    }
                    return viewHolder;
                }
                if (!b) {
                    mAttachedScrap.remove(i);
                    this$0.removeDetachedView(viewHolder.itemView, false);
                    this.quickRecycleScrapView(viewHolder.itemView);
                }
            }
        }
        for (int j = -1 + mCachedViews.size(); j >= 0; --j) {
            final ViewHolder viewHolder = (ViewHolder)mCachedViews.get(j);
            if (viewHolder.getItemId() == n) {
                if (n2 == viewHolder.getItemViewType()) {
                    if (!b) {
                        mCachedViews.remove(j);
                        return viewHolder;
                    }
                    return viewHolder;
                }
                else if (!b) {
                    this.recycleCachedViewAt(j);
                }
            }
        }
        return null;
    }
    
    ViewHolder getScrapViewForPosition(final int n, final int n2, final boolean b) {
        final int size = mAttachedScrap.size();
        int i = 0;
        while (i < size) {
            final ViewHolder viewHolder = (ViewHolder)mAttachedScrap.get(i);
            if (!viewHolder.wasReturnedFromScrap() && viewHolder.getLayoutPosition() == n && !viewHolder.isInvalid() && (mState.mInPreLayout || !viewHolder.isRemoved())) {
                if (n2 != -1 && viewHolder.getItemViewType() != n2) {
                    Log.e("RecyclerView", "Scrap view for position " + n + " isn't dirty but has" + " wrong view type! (found " + viewHolder.getItemViewType() + " but expected " + n2 + ")");
                    break;
                }
                viewHolder.addFlags(32);
                return viewHolder;
            }
            else {
                ++i;
            }
        }
        if (!b) {
            final View hiddenNonRemovedView = mChildHelper.findHiddenNonRemovedView(n, n2);
            if (hiddenNonRemovedView != null) {
                final ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(hiddenNonRemovedView);
                mChildHelper.unhide(hiddenNonRemovedView);
                final int indexOfChild = mChildHelper.indexOfChild(hiddenNonRemovedView);
                if (indexOfChild == -1) {
                    throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + childViewHolderInt);
                }
                mChildHelper.detachViewFromParent(indexOfChild);
                this.scrapView(hiddenNonRemovedView);
                childViewHolderInt.addFlags(8224);
                return childViewHolderInt;
            }
        }
        final int size2 = mCachedViews.size();
        int j = 0;
        while (j < size2) {
            final ViewHolder viewHolder = (ViewHolder)mCachedViews.get(j);
            if (!viewHolder.isInvalid() && viewHolder.getLayoutPosition() == n) {
                if (!b) {
                    mCachedViews.remove(j);
                    return viewHolder;
                }
                return viewHolder;
            }
            else {
                ++j;
            }
        }
        return null;
    }
    
    public View getViewForPosition(final int n) {
        return this.getViewForPosition(n, false);
    }
    
    View getViewForPosition(final int n, final boolean b) {
        if (n < 0 || n >= mState.getItemCount()) {
            throw new IndexOutOfBoundsException("Invalid item position " + n + "(" + n + "). Item count:" + mState.getItemCount());
        }
        final boolean preLayout = mState.isPreLayout();
        boolean b2 = false;
        Object mViewHolder = null;
        if (preLayout) {
            mViewHolder = this.getChangedScrapViewForPosition(n);
            b2 = (mViewHolder != null);
        }
        if (mViewHolder == null) {
            mViewHolder = this.getScrapViewForPosition(n, -1, b);
            if (mViewHolder != null) {
                if (!this.validateViewHolderForOffsetPosition((ViewHolder)mViewHolder)) {
                    if (!b) {
                        ((ViewHolder)mViewHolder).addFlags(4);
                        if (((ViewHolder)mViewHolder).isScrap()) {
                            this$0.removeDetachedView(((ViewHolder)mViewHolder).itemView, false);
                            ((ViewHolder)mViewHolder).unScrap();
                        }
                        else if (((ViewHolder)mViewHolder).wasReturnedFromScrap()) {
                            ((ViewHolder)mViewHolder).clearReturnedFromScrapFlag();
                        }
                        this.recycleViewHolderInternal((ViewHolder)mViewHolder);
                    }
                    mViewHolder = null;
                }
                else {
                    b2 = true;
                }
            }
        }
        if (mViewHolder == null) {
            final int positionOffset = mAdapterHelper.findPositionOffset(n);
            if (positionOffset < 0 || positionOffset >= RecyclerView.access$3100(this$0).getItemCount()) {
                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + n + "(offset:" + positionOffset + ")." + "state:" + mState.getItemCount());
            }
            final int itemViewType = RecyclerView.access$3100(this$0).getItemViewType(positionOffset);
            if (RecyclerView.access$3100(this$0).hasStableIds()) {
                mViewHolder = this.getScrapViewForId(RecyclerView.access$3100(this$0).getItemId(positionOffset), itemViewType, b);
                if (mViewHolder != null) {
                    ((ViewHolder)mViewHolder).mPosition = positionOffset;
                    b2 = true;
                }
            }
            if (mViewHolder == null && mViewCacheExtension != null) {
                final View viewForPositionAndType = mViewCacheExtension.getViewForPositionAndType(this, n, itemViewType);
                if (viewForPositionAndType != null) {
                    mViewHolder = this$0.getChildViewHolder(viewForPositionAndType);
                    if (mViewHolder == null) {
                        throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder");
                    }
                    if (((ViewHolder)mViewHolder).shouldIgnore()) {
                        throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view.");
                    }
                }
            }
            if (mViewHolder == null) {
                mViewHolder = this.getRecycledViewPool().getRecycledView(itemViewType);
                if (mViewHolder != null) {
                    ((ViewHolder)mViewHolder).resetInternal();
                    if (RecyclerView.access$4600()) {
                        this.invalidateDisplayListInt((ViewHolder)mViewHolder);
                    }
                }
            }
            if (mViewHolder == null) {
                mViewHolder = RecyclerView.access$3100(this$0).createViewHolder(this$0, itemViewType);
            }
        }
        if (b2 && !mState.isPreLayout() && ((ViewHolder)mViewHolder).hasAnyOfTheFlags(8192)) {
            ((ViewHolder)mViewHolder).setFlags(0, 8192);
            if (mState.mRunSimpleAnimations) {
                RecyclerView.access$4700(this$0, (ViewHolder)mViewHolder, mItemAnimator.recordPreLayoutInformation(mState, (ViewHolder)mViewHolder, 0x1000 | ItemAnimator.buildAdapterChangeFlagsForAnimations((ViewHolder)mViewHolder), ((ViewHolder)mViewHolder).getUnmodifiedPayloads()));
            }
        }
        int n2 = 0;
        Label_0641: {
            if (mState.isPreLayout() && ((ViewHolder)mViewHolder).isBound()) {
                ((ViewHolder)mViewHolder).mPreLayoutPosition = n;
            }
            else {
                if (((ViewHolder)mViewHolder).isBound() && !((ViewHolder)mViewHolder).needsUpdate()) {
                    final boolean invalid = ((ViewHolder)mViewHolder).isInvalid();
                    n2 = 0;
                    if (!invalid) {
                        break Label_0641;
                    }
                }
                final int positionOffset2 = mAdapterHelper.findPositionOffset(n);
                ((ViewHolder)mViewHolder).mOwnerRecyclerView = this$0;
                RecyclerView.access$3100(this$0).bindViewHolder((ViewHolder)mViewHolder, positionOffset2);
                this.attachAccessibilityDelegate(((ViewHolder)mViewHolder).itemView);
                n2 = 1;
                if (mState.isPreLayout()) {
                    ((ViewHolder)mViewHolder).mPreLayoutPosition = n;
                }
            }
        }
        final ViewGroup$LayoutParams layoutParams = ((ViewHolder)mViewHolder).itemView.getLayoutParams();
        LayoutParams layoutParams2;
        if (layoutParams == null) {
            layoutParams2 = (LayoutParams)this$0.generateDefaultLayoutParams();
            ((ViewHolder)mViewHolder).itemView.setLayoutParams((ViewGroup$LayoutParams)layoutParams2);
        }
        else if (!this$0.checkLayoutParams(layoutParams)) {
            layoutParams2 = (LayoutParams)this$0.generateLayoutParams(layoutParams);
            ((ViewHolder)mViewHolder).itemView.setLayoutParams((ViewGroup$LayoutParams)layoutParams2);
        }
        else {
            layoutParams2 = (LayoutParams)layoutParams;
        }
        layoutParams2.mViewHolder = (ViewHolder)mViewHolder;
        layoutParams2.mPendingInvalidate = (b2 && n2 != 0);
        return ((ViewHolder)mViewHolder).itemView;
    }
    
    void markItemDecorInsetsDirty() {
        for (int size = mCachedViews.size(), i = 0; i < size; ++i) {
            final LayoutParams layoutParams = (LayoutParams)((ViewHolder)mCachedViews.get(i)).itemView.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.mInsetsDirty = true;
            }
        }
    }
    
    void markKnownViewsInvalid() {
        if (RecyclerView.access$3100(this$0) != null && RecyclerView.access$3100(this$0).hasStableIds()) {
            for (int size = mCachedViews.size(), i = 0; i < size; ++i) {
                final ViewHolder viewHolder = (ViewHolder)mCachedViews.get(i);
                if (viewHolder != null) {
                    viewHolder.addFlags(6);
                    viewHolder.addChangePayload(null);
                }
            }
        }
        else {
            this.recycleAndClearCachedViews();
        }
    }
    
    void offsetPositionRecordsForInsert(final int n, final int n2) {
        for (int size = mCachedViews.size(), i = 0; i < size; ++i) {
            final ViewHolder viewHolder = (ViewHolder)mCachedViews.get(i);
            if (viewHolder != null && viewHolder.mPosition >= n) {
                viewHolder.offsetPosition(n2, true);
            }
        }
    }
    
    void offsetPositionRecordsForMove(final int n, final int n2) {
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
        for (int size = mCachedViews.size(), i = 0; i < size; ++i) {
            final ViewHolder viewHolder = (ViewHolder)mCachedViews.get(i);
            if (viewHolder != null && viewHolder.mPosition >= n3 && viewHolder.mPosition <= n4) {
                if (viewHolder.mPosition == n) {
                    viewHolder.offsetPosition(n2 - n, false);
                }
                else {
                    viewHolder.offsetPosition(n5, false);
                }
            }
        }
    }
    
    void offsetPositionRecordsForRemove(final int n, final int n2, final boolean b) {
        final int n3 = n + n2;
        for (int i = -1 + mCachedViews.size(); i >= 0; --i) {
            final ViewHolder viewHolder = (ViewHolder)mCachedViews.get(i);
            if (viewHolder != null) {
                if (viewHolder.mPosition >= n3) {
                    viewHolder.offsetPosition(-n2, b);
                }
                else if (viewHolder.mPosition >= n) {
                    viewHolder.addFlags(8);
                    this.recycleCachedViewAt(i);
                }
            }
        }
    }
    
    void onAdapterChanged(final Adapter adapter, final Adapter adapter2, final boolean b) {
        this.clear();
        this.getRecycledViewPool().onAdapterChanged(adapter, adapter2, b);
    }
    
    void quickRecycleScrapView(final View view) {
        final ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        childViewHolderInt.mScrapContainer = null;
        childViewHolderInt.mInChangeScrap = false;
        childViewHolderInt.clearReturnedFromScrapFlag();
        this.recycleViewHolderInternal(childViewHolderInt);
    }
    
    void recycleAndClearCachedViews() {
        for (int i = -1 + mCachedViews.size(); i >= 0; --i) {
            this.recycleCachedViewAt(i);
        }
        mCachedViews.clear();
    }
    
    void recycleCachedViewAt(final int n) {
        this.addViewHolderToRecycledViewPool(mCachedViews.get(n));
        mCachedViews.remove(n);
    }
    
    public void recycleView(final View view) {
        final ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        if (childViewHolderInt.isTmpDetached()) {
            this$0.removeDetachedView(view, false);
        }
        if (childViewHolderInt.isScrap()) {
            childViewHolderInt.unScrap();
        }
        else if (childViewHolderInt.wasReturnedFromScrap()) {
            childViewHolderInt.clearReturnedFromScrapFlag();
        }
        this.recycleViewHolderInternal(childViewHolderInt);
    }
    
    void recycleViewHolderInternal(final ViewHolder viewHolder) {
        boolean b = true;
        if (viewHolder.isScrap() || viewHolder.itemView.getParent() != null) {
            final StringBuilder append = new StringBuilder().append("Scrapped or attached views may not be recycled. isScrap:").append(viewHolder.isScrap()).append(" isAttached:");
            if (viewHolder.itemView.getParent() == null) {
                b = false;
            }
            throw new IllegalArgumentException(append.append(b).toString());
        }
        if (viewHolder.isTmpDetached()) {
            throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + viewHolder);
        }
        if (viewHolder.shouldIgnore()) {
            throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.");
        }
        final boolean access$4900 = viewHolder.doesTransientStatePreventRecycling();
        boolean b2 = false;
        boolean b3 = false;
        Label_0278: {
            if (RecyclerView.access$3100(this$0) == null || !access$4900 || !RecyclerView.access$3100(this$0).onFailedToRecycleView(viewHolder) || !b) {
                final boolean recyclable = viewHolder.isRecyclable();
                b2 = false;
                b3 = false;
                if (!recyclable) {
                    break Label_0278;
                }
            }
            final boolean hasAnyOfTheFlags = viewHolder.hasAnyOfTheFlags(14);
            b2 = false;
            if (!hasAnyOfTheFlags) {
                final int size = mCachedViews.size();
                if (size == mViewCacheMax && size > 0) {
                    this.recycleCachedViewAt(0);
                }
                final int mViewCacheMax = this.mViewCacheMax;
                b2 = false;
                if (size < mViewCacheMax) {
                    mCachedViews.add(viewHolder);
                    b2 = true;
                }
            }
            b3 = false;
            if (!b2) {
                this.addViewHolderToRecycledViewPool(viewHolder);
                b3 = true;
            }
        }
        mViewInfoStore.removeViewHolder(viewHolder);
        if (!b2 && !b3 && access$4900) {
            viewHolder.mOwnerRecyclerView = null;
        }
    }
    
    void recycleViewInternal(final View view) {
        this.recycleViewHolderInternal(RecyclerView.getChildViewHolderInt(view));
    }
    
    void scrapView(final View view) {
        final ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        if (!childViewHolderInt.hasAnyOfTheFlags(12) && childViewHolderInt.isUpdated() && !RecyclerView.access$5200(this$0, childViewHolderInt)) {
            if (mChangedScrap == null) {
                mChangedScrap = new ArrayList<ViewHolder>();
            }
            childViewHolderInt.setScrapContainer(this, true);
            mChangedScrap.add(childViewHolderInt);
            return;
        }
        if (childViewHolderInt.isInvalid() && !childViewHolderInt.isRemoved() && !RecyclerView.access$3100(this$0).hasStableIds()) {
            throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.");
        }
        childViewHolderInt.setScrapContainer(this, false);
        mAttachedScrap.add(childViewHolderInt);
    }
    
    void setAdapterPositionsAsUnknown() {
        for (int size = mCachedViews.size(), i = 0; i < size; ++i) {
            final ViewHolder viewHolder = (ViewHolder)mCachedViews.get(i);
            if (viewHolder != null) {
                viewHolder.addFlags(512);
            }
        }
    }
    
    void setRecycledViewPool(final RecycledViewPool mRecyclerPool) {
        if (this.mRecyclerPool != null) {
            this.mRecyclerPool.detach();
        }
        if ((this.mRecyclerPool = mRecyclerPool) != null) {
            this.mRecyclerPool.attach(this$0.getAdapter());
        }
    }
    
    void setViewCacheExtension(final ViewCacheExtension mViewCacheExtension) {
        this.mViewCacheExtension = mViewCacheExtension;
    }
    
    public void setViewCacheSize(final int mViewCacheMax) {
        this.mViewCacheMax = mViewCacheMax;
        for (int n = -1 + mCachedViews.size(); n >= 0 && mCachedViews.size() > mViewCacheMax; --n) {
            this.recycleCachedViewAt(n);
        }
    }
    
    void unscrapView(final ViewHolder viewHolder) {
        if (viewHolder.mInChangeScrap) {
            mChangedScrap.remove(viewHolder);
        }
        else {
            mAttachedScrap.remove(viewHolder);
        }
        viewHolder.mScrapContainer = null;
        viewHolder.mInChangeScrap = false;
        viewHolder.clearReturnedFromScrapFlag();
    }
    
    boolean validateViewHolderForOffsetPosition(final ViewHolder viewHolder) {
        boolean preLayout = true;
        if (viewHolder.isRemoved()) {
            preLayout = mState.isPreLayout();
        }
        else {
            if (viewHolder.mPosition < 0 || viewHolder.mPosition >= RecyclerView.access$3100(this$0).getItemCount()) {
                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + viewHolder);
            }
            if (!mState.isPreLayout() && RecyclerView.access$3100(this$0).getItemViewType(viewHolder.mPosition) != viewHolder.getItemViewType()) {
                return false;
            }
            if (RecyclerView.access$3100(this$0).hasStableIds() && viewHolder.getItemId() != RecyclerView.access$3100(this$0).getItemId(viewHolder.mPosition)) {
                return false;
            }
        }
        return preLayout;
    }
    
    void viewRangeUpdate(final int n, final int n2) {
        final int n3 = n + n2;
        for (int i = -1 + mCachedViews.size(); i >= 0; --i) {
            final ViewHolder viewHolder = (ViewHolder)mCachedViews.get(i);
            if (viewHolder != null) {
                final int layoutPosition = viewHolder.getLayoutPosition();
                if (layoutPosition >= n && layoutPosition < n3) {
                    viewHolder.addFlags(2);
                    this.recycleCachedViewAt(i);
                }
            }
        }
    }
}
