package android.support.v7.util;

import android.util.Log;
import android.util.SparseBooleanArray;

class AsyncListUtil$2 implements BackgroundCallback<T> {
    private int mFirstRequiredTileStart;
    private int mGeneration;
    private int mItemCount;
    private int mLastRequiredTileStart;
    final SparseBooleanArray mLoadedTiles = new SparseBooleanArray();
    private TileList.Tile<T> mRecycledRoot;
    final /* synthetic */ AsyncListUtil this$0;
    
    AsyncListUtil$2(final AsyncListUtil this$0) {
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
}