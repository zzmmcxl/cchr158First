package android.support.v7.widget;

import android.support.annotation.NonNull;
import android.support.v4.util.Pools;
import android.support.annotation.Nullable;
import android.support.v4.util.LongSparseArray;
import android.support.annotation.VisibleForTesting;
import android.support.v4.util.ArrayMap;

class ViewInfoStore
{
    private static final boolean DEBUG;
    @VisibleForTesting
    final ArrayMap<RecyclerView.ViewHolder, InfoRecord> mLayoutHolderMap;
    @VisibleForTesting
    final LongSparseArray<RecyclerView.ViewHolder> mOldChangedHolders;
    
    ViewInfoStore() {
        super();
        mLayoutHolderMap = new ArrayMap<RecyclerView.ViewHolder, InfoRecord>();
        mOldChangedHolders = new LongSparseArray<RecyclerView.ViewHolder>();
    }
    
    private RecyclerView.ItemAnimator.ItemHolderInfo popFromLayoutStep(final RecyclerView.ViewHolder viewHolder, final int n) {
        final int indexOfKey = mLayoutHolderMap.indexOfKey(viewHolder);
        RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo = null;
        if (indexOfKey >= 0) {
            final InfoRecord infoRecord = (InfoRecord)mLayoutHolderMap.valueAt(indexOfKey);
            itemHolderInfo = null;
            if (infoRecord != null) {
                final int n2 = n & infoRecord.flags;
                itemHolderInfo = null;
                if (n2 != 0) {
                    infoRecord.flags &= ~n;
                    if (n == 4) {
                        itemHolderInfo = infoRecord.preInfo;
                    }
                    else {
                        if (n != 8) {
                            throw new IllegalArgumentException("Must provide flag PRE or POST");
                        }
                        itemHolderInfo = infoRecord.postInfo;
                    }
                    if ((0xC & infoRecord.flags) == 0x0) {
                        mLayoutHolderMap.removeAt(indexOfKey);
                        InfoRecord.recycle(infoRecord);
                        return itemHolderInfo;
                    }
                }
            }
        }
        return itemHolderInfo;
    }
    
    void addToAppearedInPreLayoutHolders(final RecyclerView.ViewHolder viewHolder, final RecyclerView.ItemAnimator.ItemHolderInfo preInfo) {
        InfoRecord obtain = (InfoRecord)mLayoutHolderMap.get(viewHolder);
        if (obtain == null) {
            obtain = InfoRecord.obtain();
            mLayoutHolderMap.put(viewHolder, obtain);
        }
        obtain.flags |= 0x2;
        obtain.preInfo = preInfo;
    }
    
    void addToDisappearedInLayout(final RecyclerView.ViewHolder viewHolder) {
        InfoRecord obtain = (InfoRecord)mLayoutHolderMap.get(viewHolder);
        if (obtain == null) {
            obtain = InfoRecord.obtain();
            mLayoutHolderMap.put(viewHolder, obtain);
        }
        obtain.flags |= 0x1;
    }
    
    void addToOldChangeHolders(final long n, final RecyclerView.ViewHolder viewHolder) {
        mOldChangedHolders.put(n, viewHolder);
    }
    
    void addToPostLayout(final RecyclerView.ViewHolder viewHolder, final RecyclerView.ItemAnimator.ItemHolderInfo postInfo) {
        InfoRecord obtain = (InfoRecord)mLayoutHolderMap.get(viewHolder);
        if (obtain == null) {
            obtain = InfoRecord.obtain();
            mLayoutHolderMap.put(viewHolder, obtain);
        }
        obtain.postInfo = postInfo;
        obtain.flags |= 0x8;
    }
    
    void addToPreLayout(final RecyclerView.ViewHolder viewHolder, final RecyclerView.ItemAnimator.ItemHolderInfo preInfo) {
        InfoRecord obtain = (InfoRecord)mLayoutHolderMap.get(viewHolder);
        if (obtain == null) {
            obtain = InfoRecord.obtain();
            mLayoutHolderMap.put(viewHolder, obtain);
        }
        obtain.preInfo = preInfo;
        obtain.flags |= 0x4;
    }
    
    void clear() {
        mLayoutHolderMap.clear();
        mOldChangedHolders.clear();
    }
    
    RecyclerView.ViewHolder getFromOldChangeHolders(final long n) {
        return mOldChangedHolders.get(n);
    }
    
    boolean isDisappearing(final RecyclerView.ViewHolder viewHolder) {
        final InfoRecord infoRecord = (InfoRecord)mLayoutHolderMap.get(viewHolder);
        return infoRecord != null && (0x1 & infoRecord.flags) != 0x0;
    }
    
    boolean isInPreLayout(final RecyclerView.ViewHolder viewHolder) {
        final InfoRecord infoRecord = (InfoRecord)mLayoutHolderMap.get(viewHolder);
        return infoRecord != null && (0x4 & infoRecord.flags) != 0x0;
    }
    
    void onDetach() {
        InfoRecord.drainCache();
    }
    
    public void onViewDetached(final RecyclerView.ViewHolder viewHolder) {
        this.removeFromDisappearedInLayout(viewHolder);
    }
    
    @Nullable
    RecyclerView.ItemAnimator.ItemHolderInfo popFromPostLayout(final RecyclerView.ViewHolder viewHolder) {
        return this.popFromLayoutStep(viewHolder, 8);
    }
    
    @Nullable
    RecyclerView.ItemAnimator.ItemHolderInfo popFromPreLayout(final RecyclerView.ViewHolder viewHolder) {
        return this.popFromLayoutStep(viewHolder, 4);
    }
    
    void process(final ProcessCallback processCallback) {
        for (int i = -1 + mLayoutHolderMap.size(); i >= 0; --i) {
            final RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder)mLayoutHolderMap.keyAt(i);
            final InfoRecord infoRecord = (InfoRecord)mLayoutHolderMap.removeAt(i);
            if ((0x3 & infoRecord.flags) == 0x3) {
                processCallback.unused(viewHolder);
            }
            else if ((0x1 & infoRecord.flags) != 0x0) {
                if (infoRecord.preInfo == null) {
                    processCallback.unused(viewHolder);
                }
                else {
                    processCallback.processDisappeared(viewHolder, infoRecord.preInfo, infoRecord.postInfo);
                }
            }
            else if ((0xE & infoRecord.flags) == 0xE) {
                processCallback.processAppeared(viewHolder, infoRecord.preInfo, infoRecord.postInfo);
            }
            else if ((0xC & infoRecord.flags) == 0xC) {
                processCallback.processPersistent(viewHolder, infoRecord.preInfo, infoRecord.postInfo);
            }
            else if ((0x4 & infoRecord.flags) != 0x0) {
                processCallback.processDisappeared(viewHolder, infoRecord.preInfo, null);
            }
            else if ((0x8 & infoRecord.flags) != 0x0) {
                processCallback.processAppeared(viewHolder, infoRecord.preInfo, infoRecord.postInfo);
            }
            else if ((0x2 & infoRecord.flags) != 0x0) {}
            InfoRecord.recycle(infoRecord);
        }
    }
    
    void removeFromDisappearedInLayout(final RecyclerView.ViewHolder viewHolder) {
        final InfoRecord infoRecord = (InfoRecord)mLayoutHolderMap.get(viewHolder);
        if (infoRecord == null) {
            return;
        }
        infoRecord.flags &= 0xFFFFFFFE;
    }
    
    void removeViewHolder(final RecyclerView.ViewHolder viewHolder) {
        for (int i = -1 + mOldChangedHolders.size(); i >= 0; --i) {
            if (viewHolder == mOldChangedHolders.valueAt(i)) {
                mOldChangedHolders.removeAt(i);
                break;
            }
        }
        final InfoRecord infoRecord = (InfoRecord)mLayoutHolderMap.remove(viewHolder);
        if (infoRecord != null) {
            InfoRecord.recycle(infoRecord);
        }
    }
}
