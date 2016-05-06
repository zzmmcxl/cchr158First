package android.support.v7.util;

import android.support.annotation.UiThread;
import android.support.annotation.WorkerThread;
import android.util.SparseBooleanArray;
import android.util.Log;
import android.util.SparseIntArray;

public class AsyncListUtil<T>
{
    private static final boolean DEBUG = false;
    private static final String TAG = "AsyncListUtil";
    private boolean mAllowScrollHints;
    private final ThreadUtil.BackgroundCallback<T> mBackgroundCallback;
    final ThreadUtil.BackgroundCallback<T> mBackgroundProxy;
    final DataCallback<T> mDataCallback;
    int mDisplayedGeneration;
    private int mItemCount;
    private final ThreadUtil.MainThreadCallback<T> mMainThreadCallback;
    final ThreadUtil.MainThreadCallback<T> mMainThreadProxy;
    private final SparseIntArray mMissingPositions;
    final int[] mPrevRange;
    int mRequestedGeneration;
    private int mScrollHint;
    final Class<T> mTClass;
    final TileList<T> mTileList;
    final int mTileSize;
    final int[] mTmpRange;
    final int[] mTmpRangeExtended;
    final ViewCallback mViewCallback;
    
    public AsyncListUtil(final Class<T> mtClass, final int mTileSize, final DataCallback<T> mDataCallback, final ViewCallback mViewCallback) {
        super();
        mTmpRange = new int[2];
        mPrevRange = new int[2];
        mTmpRangeExtended = new int[2];
        mScrollHint = 0;
        mItemCount = 0;
        mDisplayedGeneration = 0;
        mRequestedGeneration = mDisplayedGeneration;
        mMissingPositions = new SparseIntArray();
        mMainThreadCallback = new ThreadUtil.MainThreadCallback<T>() {
            final /* synthetic */ AsyncListUtil this$0;
            
            AsyncListUtil$1() {
                this$0 = this$0;
                super();
            }
            
            private boolean isRequestedGeneration(final int n) {
                return n == mRequestedGeneration;
            }
            
            private void recycleAllTiles() {
                for (int i = 0; i < mTileList.size(); ++i) {
                    mBackgroundProxy.recycleTile(mTileList.getAtIndex(i));
                }
                mTileList.clear();
            }
            
            @Override
            public void addTile(final int n, final TileList.Tile<T> tile) {
                if (!this.isRequestedGeneration(n)) {
                    mBackgroundProxy.recycleTile(tile);
                }
                else {
                    final TileList.Tile<T> addOrReplace = mTileList.addOrReplace(tile);
                    if (addOrReplace != null) {
                        Log.e("AsyncListUtil", "duplicate tile @" + addOrReplace.mStartPosition);
                        mBackgroundProxy.recycleTile(addOrReplace);
                    }
                    final int n2 = tile.mStartPosition + tile.mItemCount;
                    int i = 0;
                    while (i < mMissingPositions.size()) {
                        final int key = mMissingPositions.keyAt(i);
                        if (tile.mStartPosition <= key && key < n2) {
                            mMissingPositions.removeAt(i);
                            mViewCallback.onItemLoaded(key);
                        }
                        else {
                            ++i;
                        }
                    }
                }
            }
            
            @Override
            public void removeTile(final int n, final int n2) {
                if (!this.isRequestedGeneration(n)) {
                    return;
                }
                final TileList.Tile<T> removeAtPos = mTileList.removeAtPos(n2);
                if (removeAtPos == null) {
                    Log.e("AsyncListUtil", "tile not found @" + n2);
                    return;
                }
                mBackgroundProxy.recycleTile(removeAtPos);
            }
            
            @Override
            public void updateItemCount(final int n, final int n2) {
                if (!this.isRequestedGeneration(n)) {
                    return;
                }
                mItemCount = n2;
                mViewCallback.onDataRefresh();
                mDisplayedGeneration = mRequestedGeneration;
                this.recycleAllTiles();
                mAllowScrollHints = false;
                this$0.updateRange();
            }
        };
        mBackgroundCallback = new ThreadUtil.BackgroundCallback<T>() {
            private int mFirstRequiredTileStart;
            private int mGeneration;
            private int mItemCount;
            private int mLastRequiredTileStart;
            final SparseBooleanArray mLoadedTiles = new SparseBooleanArray();
            private TileList.Tile<T> mRecycledRoot;
            final /* synthetic */ AsyncListUtil this$0;
            
            AsyncListUtil$2() {
                this$0 = this$0;
                super();
            }
            
            private TileList.Tile<T> acquireTile() {
                if (mRecycledRoot != null) {
                    final TileList.Tile<T> mRecycledRoot = this.mRecycledRoot;
                    this.mRecycledRoot = this.mRecycledRoot.mNext;
                    return mRecycledRoot;
                }
                return (TileList.Tile<T>)new TileList.Tile((Class<Object>)mTClass, mTileSize);
            }
            
            private void addTile(final TileList.Tile<T> tile) {
                mLoadedTiles.put(tile.mStartPosition, true);
                mMainThreadProxy.addTile(mGeneration, tile);
            }
            
            private void flushTileCache(final int n) {
                while (mLoadedTiles.size() >= mDataCallback.getMaxCachedTiles()) {
                    final int key = mLoadedTiles.keyAt(0);
                    final int key2 = mLoadedTiles.keyAt(-1 + mLoadedTiles.size());
                    final int n2 = mFirstRequiredTileStart - key;
                    final int n3 = key2 - mLastRequiredTileStart;
                    if (n2 > 0 && (n2 >= n3 || n == 2)) {
                        this.removeTile(key);
                    }
                    else {
                        if (n3 <= 0 || (n2 >= n3 && n != 1)) {
                            break;
                        }
                        this.removeTile(key2);
                    }
                }
            }
            
            private int getTileStart(final int n) {
                return n - n % mTileSize;
            }
            
            private boolean isTileLoaded(final int n) {
                return mLoadedTiles.get(n);
            }
            
            private void log(final String s, final Object... array) {
                Log.d("AsyncListUtil", "[BKGR] " + String.format(s, array));
            }
            
            private void removeTile(final int n) {
                mLoadedTiles.delete(n);
                mMainThreadProxy.removeTile(mGeneration, n);
            }
            
            private void requestTiles(final int n, final int n2, final int n3, final boolean b) {
                for (int i = n; i <= n2; i += mTileSize) {
                    int n4;
                    if (b) {
                        n4 = n2 + n - i;
                    }
                    else {
                        n4 = i;
                    }
                    mBackgroundProxy.loadTile(n4, n3);
                }
            }
            
            @Override
            public void loadTile(final int mStartPosition, final int n) {
                if (this.isTileLoaded(mStartPosition)) {
                    return;
                }
                final TileList.Tile<T> acquireTile = this.acquireTile();
                acquireTile.mStartPosition = mStartPosition;
                acquireTile.mItemCount = Math.min(mTileSize, mItemCount - acquireTile.mStartPosition);
                mDataCallback.fillData((T[])acquireTile.mItems, acquireTile.mStartPosition, acquireTile.mItemCount);
                this.flushTileCache(n);
                this.addTile(acquireTile);
            }
            
            @Override
            public void recycleTile(final TileList.Tile<T> mRecycledRoot) {
                mDataCallback.recycleData((T[])mRecycledRoot.mItems, mRecycledRoot.mItemCount);
                mRecycledRoot.mNext = this.mRecycledRoot;
                this.mRecycledRoot = mRecycledRoot;
            }
            
            @Override
            public void refresh(final int mGeneration) {
                this.mGeneration = mGeneration;
                mLoadedTiles.clear();
                mItemCount = mDataCallback.refreshData();
                mMainThreadProxy.updateItemCount(this.mGeneration, mItemCount);
            }
            
            @Override
            public void updateRange(final int n, final int n2, final int n3, final int n4, final int n5) {
                if (n > n2) {
                    return;
                }
                final int tileStart = this.getTileStart(n);
                final int tileStart2 = this.getTileStart(n2);
                mFirstRequiredTileStart = this.getTileStart(n3);
                mLastRequiredTileStart = this.getTileStart(n4);
                if (n5 == 1) {
                    this.requestTiles(mFirstRequiredTileStart, tileStart2, n5, true);
                    this.requestTiles(tileStart2 + mTileSize, mLastRequiredTileStart, n5, false);
                    return;
                }
                this.requestTiles(tileStart, mLastRequiredTileStart, n5, false);
                this.requestTiles(mFirstRequiredTileStart, tileStart - mTileSize, n5, true);
            }
        };
        mTClass = mtClass;
        mTileSize = mTileSize;
        mDataCallback = mDataCallback;
        mViewCallback = mViewCallback;
        mTileList = new TileList<T>(mTileSize);
        final MessageThreadUtil<T> messageThreadUtil = new MessageThreadUtil<T>();
        mMainThreadProxy = messageThreadUtil.getMainThreadProxy(mMainThreadCallback);
        mBackgroundProxy = messageThreadUtil.getBackgroundProxy(mBackgroundCallback);
        this.refresh();
    }
    
    static /* synthetic */ int access$002(final AsyncListUtil asyncListUtil, final int mItemCount) {
        return asyncListUtil.mItemCount = mItemCount;
    }
    
    static /* synthetic */ boolean access$102(final AsyncListUtil asyncListUtil, final boolean mAllowScrollHints) {
        return asyncListUtil.mAllowScrollHints = mAllowScrollHints;
    }
    
    static /* synthetic */ void access$200(final AsyncListUtil asyncListUtil) {
        asyncListUtil.updateRange();
    }
    
    static /* synthetic */ SparseIntArray access$300(final AsyncListUtil asyncListUtil) {
        return asyncListUtil.mMissingPositions;
    }
    
    private boolean isRefreshPending() {
        return mRequestedGeneration != mDisplayedGeneration;
    }
    
    private void log(final String s, final Object... array) {
        Log.d("AsyncListUtil", "[MAIN] " + String.format(s, array));
    }
    
    private void updateRange() {
        mViewCallback.getItemRangeInto(mTmpRange);
        if (mTmpRange[0] <= mTmpRange[1] && mTmpRange[0] >= 0 && mTmpRange[1] < mItemCount) {
            if (!mAllowScrollHints) {
                mScrollHint = 0;
            }
            else if (mTmpRange[0] > mPrevRange[1] || mPrevRange[0] > mTmpRange[1]) {
                mScrollHint = 0;
            }
            else if (mTmpRange[0] < mPrevRange[0]) {
                mScrollHint = 1;
            }
            else if (mTmpRange[0] > mPrevRange[0]) {
                mScrollHint = 2;
            }
            mPrevRange[0] = mTmpRange[0];
            mPrevRange[1] = mTmpRange[1];
            mViewCallback.extendRangeInto(mTmpRange, mTmpRangeExtended, mScrollHint);
            mTmpRangeExtended[0] = Math.min(mTmpRange[0], Math.max(mTmpRangeExtended[0], 0));
            mTmpRangeExtended[1] = Math.max(mTmpRange[1], Math.min(mTmpRangeExtended[1], -1 + mItemCount));
            mBackgroundProxy.updateRange(mTmpRange[0], mTmpRange[1], mTmpRangeExtended[0], mTmpRangeExtended[1], mScrollHint);
        }
    }
    
    public T getItem(final int n) {
        if (n < 0 || n >= mItemCount) {
            throw new IndexOutOfBoundsException(n + " is not within 0 and " + mItemCount);
        }
        final T item = mTileList.getItemAt(n);
        if (item == null && !this.isRefreshPending()) {
            mMissingPositions.put(n, 0);
        }
        return item;
    }
    
    public int getItemCount() {
        return mItemCount;
    }
    
    public void onRangeChanged() {
        if (this.isRefreshPending()) {
            return;
        }
        this.updateRange();
        mAllowScrollHints = true;
    }
    
    public void refresh() {
        mMissingPositions.clear();
        mBackgroundProxy.refresh(++mRequestedGeneration);
    }
}
