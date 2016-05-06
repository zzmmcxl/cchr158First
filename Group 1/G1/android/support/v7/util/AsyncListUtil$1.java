package android.support.v7.util;

import android.util.Log;

class AsyncListUtil$1 implements MainThreadCallback<T> {
    final /* synthetic */ AsyncListUtil this$0;
    
    AsyncListUtil$1(final AsyncListUtil this$0) {
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
            while (i < AsyncListUtil.access$300(this$0).size()) {
                final int key = AsyncListUtil.access$300(this$0).keyAt(i);
                if (tile.mStartPosition <= key && key < n2) {
                    AsyncListUtil.access$300(this$0).removeAt(i);
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
        AsyncListUtil.access$002(this$0, n2);
        mViewCallback.onDataRefresh();
        mDisplayedGeneration = mRequestedGeneration;
        this.recycleAllTiles();
        AsyncListUtil.access$102(this$0, false);
        AsyncListUtil.access$200(this$0);
    }
}