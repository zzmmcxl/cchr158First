package android.support.v7.util;

import java.lang.reflect.Array;
import android.util.SparseArray;

class TileList<T>
{
    Tile<T> mLastAccessedTile;
    final int mTileSize;
    private final SparseArray<Tile<T>> mTiles;
    
    public TileList(final int mTileSize) {
        super();
        mTiles = (SparseArray<Tile<T>>)new SparseArray(10);
        mTileSize = mTileSize;
    }
    
    public Tile<T> addOrReplace(final Tile<T> mLastAccessedTile) {
        final int indexOfKey = mTiles.indexOfKey(mLastAccessedTile.mStartPosition);
        Tile<T> tile;
        if (indexOfKey < 0) {
            mTiles.put(mLastAccessedTile.mStartPosition, (Object)mLastAccessedTile);
            tile = null;
        }
        else {
            tile = (Tile<T>)mTiles.valueAt(indexOfKey);
            mTiles.setValueAt(indexOfKey, (Object)mLastAccessedTile);
            if (this.mLastAccessedTile == tile) {
                this.mLastAccessedTile = mLastAccessedTile;
                return tile;
            }
        }
        return tile;
    }
    
    public void clear() {
        mTiles.clear();
    }
    
    public Tile<T> getAtIndex(final int n) {
        return (Tile<T>)mTiles.valueAt(n);
    }
    
    public T getItemAt(final int n) {
        if (mLastAccessedTile == null || !mLastAccessedTile.containsPosition(n)) {
            final int indexOfKey = mTiles.indexOfKey(n - n % mTileSize);
            if (indexOfKey < 0) {
                return null;
            }
            mLastAccessedTile = (Tile<T>)mTiles.valueAt(indexOfKey);
        }
        return mLastAccessedTile.getByPosition(n);
    }
    
    public Tile<T> removeAtPos(final int n) {
        final Tile tile = (Tile)mTiles.get(n);
        if (mLastAccessedTile == tile) {
            mLastAccessedTile = null;
        }
        mTiles.delete(n);
        return (Tile<T>)tile;
    }
    
    public int size() {
        return mTiles.size();
    }
}
