package android.support.v7.widget;

import java.util.List;
import java.util.Collection;
import java.util.Collections;
import android.support.v4.util.Pools;
import java.util.ArrayList;

class AdapterHelper implements OpReorderer.Callback
{
    private static final boolean DEBUG = false;
    static final int POSITION_TYPE_INVISIBLE = 0;
    static final int POSITION_TYPE_NEW_OR_LAID_OUT = 1;
    private static final String TAG = "AHT";
    final Callback mCallback;
    final boolean mDisableRecycler;
    private int mExistingUpdateTypes;
    Runnable mOnItemProcessedCallback;
    final OpReorderer mOpReorderer;
    final ArrayList<UpdateOp> mPendingUpdates;
    final ArrayList<UpdateOp> mPostponedList;
    private Pools.Pool<UpdateOp> mUpdateOpPool;
    
    AdapterHelper(final Callback callback) {
        this(callback, false);
    }
    
    AdapterHelper(final Callback mCallback, final boolean mDisableRecycler) {
        super();
        mUpdateOpPool = new Pools.SimplePool<UpdateOp>(30);
        mPendingUpdates = new ArrayList<UpdateOp>();
        mPostponedList = new ArrayList<UpdateOp>();
        mExistingUpdateTypes = 0;
        mCallback = mCallback;
        mDisableRecycler = mDisableRecycler;
        mOpReorderer = new OpReorderer((OpReorderer.Callback)this);
    }
    
    private void applyAdd(final UpdateOp updateOp) {
        this.postponeAndUpdateViewHolders(updateOp);
    }
    
    private void applyMove(final UpdateOp updateOp) {
        this.postponeAndUpdateViewHolders(updateOp);
    }
    
    private void applyRemove(UpdateOp obtainUpdateOp) {
        final int positionStart = obtainUpdateOp.positionStart;
        int n = 0;
        int n2 = obtainUpdateOp.positionStart + obtainUpdateOp.itemCount;
        int n3 = -1;
        for (int i = obtainUpdateOp.positionStart; i < n2; ++i) {
            int n4;
            if (mCallback.findViewHolder(i) != null || this.canFindInPreLayout(i)) {
                n4 = 0;
                if (n3 == 0) {
                    this.dispatchAndUpdateViewHolders(this.obtainUpdateOp(2, positionStart, n, (Object)null));
                    n4 = 1;
                }
                n3 = 1;
            }
            else {
                n4 = 0;
                if (n3 == 1) {
                    this.postponeAndUpdateViewHolders(this.obtainUpdateOp(2, positionStart, n, (Object)null));
                    n4 = 1;
                }
                n3 = 0;
            }
            if (n4 != 0) {
                i -= n;
                n2 -= n;
                n = 1;
            }
            else {
                ++n;
            }
        }
        if (n != obtainUpdateOp.itemCount) {
            this.recycleUpdateOp(obtainUpdateOp);
            obtainUpdateOp = this.obtainUpdateOp(2, positionStart, n, null);
        }
        if (n3 == 0) {
            this.dispatchAndUpdateViewHolders(obtainUpdateOp);
            return;
        }
        this.postponeAndUpdateViewHolders(obtainUpdateOp);
    }
    
    private void applyUpdate(UpdateOp obtainUpdateOp) {
        int positionStart = obtainUpdateOp.positionStart;
        int n = 0;
        final int n2 = obtainUpdateOp.positionStart + obtainUpdateOp.itemCount;
        int n3 = -1;
        for (int i = obtainUpdateOp.positionStart; i < n2; ++i) {
            if (mCallback.findViewHolder(i) != null || this.canFindInPreLayout(i)) {
                if (n3 == 0) {
                    this.dispatchAndUpdateViewHolders(this.obtainUpdateOp(4, positionStart, n, obtainUpdateOp.payload));
                    n = 0;
                    positionStart = i;
                }
                n3 = 1;
            }
            else {
                if (n3 == 1) {
                    this.postponeAndUpdateViewHolders(this.obtainUpdateOp(4, positionStart, n, obtainUpdateOp.payload));
                    n = 0;
                    positionStart = i;
                }
                n3 = 0;
            }
            ++n;
        }
        if (n != obtainUpdateOp.itemCount) {
            final Object payload = obtainUpdateOp.payload;
            this.recycleUpdateOp(obtainUpdateOp);
            obtainUpdateOp = this.obtainUpdateOp(4, positionStart, n, payload);
        }
        if (n3 == 0) {
            this.dispatchAndUpdateViewHolders(obtainUpdateOp);
            return;
        }
        this.postponeAndUpdateViewHolders(obtainUpdateOp);
    }
    
    private boolean canFindInPreLayout(final int n) {
        for (int size = mPostponedList.size(), i = 0; i < size; ++i) {
            final UpdateOp updateOp = (UpdateOp)mPostponedList.get(i);
            if (updateOp.cmd == 8) {
                if (this.findPositionOffset(updateOp.itemCount, i + 1) == n) {
                    return true;
                }
            }
            else if (updateOp.cmd == 1) {
                for (int n2 = updateOp.positionStart + updateOp.itemCount, j = updateOp.positionStart; j < n2; ++j) {
                    if (this.findPositionOffset(j, i + 1) == n) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private void dispatchAndUpdateViewHolders(final UpdateOp updateOp) {
        if (updateOp.cmd == 1 || updateOp.cmd == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int updatePositionWithPostponed = this.updatePositionWithPostponed(updateOp.positionStart, updateOp.cmd);
        int n = 1;
        int positionStart = updateOp.positionStart;
        int n2 = 0;
        switch (updateOp.cmd) {
            default:
                throw new IllegalArgumentException("op should be remove or update." + updateOp);
            case 4:
                n2 = 1;
                break;
            case 2:
                n2 = 0;
                break;
        }
        for (int i = 1; i < updateOp.itemCount; ++i) {
            final int updatePositionWithPostponed2 = this.updatePositionWithPostponed(updateOp.positionStart + n2 * i, updateOp.cmd);
            final int cmd = updateOp.cmd;
            int n3 = 0;
            switch (cmd) {
                case 4:
                    if (updatePositionWithPostponed2 == updatePositionWithPostponed + 1) {
                        n3 = 1;
                    }
                    else {
                        n3 = 0;
                    }
                    break;
                case 2:
                    if (updatePositionWithPostponed2 == updatePositionWithPostponed) {
                        n3 = 1;
                    }
                    else {
                        n3 = 0;
                    }
                    break;
            }
            if (n3 != 0) {
                ++n;
            }
            else {
                final UpdateOp obtainUpdateOp = this.obtainUpdateOp(updateOp.cmd, updatePositionWithPostponed, n, updateOp.payload);
                this.dispatchFirstPassAndUpdateViewHolders(obtainUpdateOp, positionStart);
                this.recycleUpdateOp(obtainUpdateOp);
                if (updateOp.cmd == 4) {
                    positionStart += n;
                }
                updatePositionWithPostponed = updatePositionWithPostponed2;
                n = 1;
            }
        }
        final Object payload = updateOp.payload;
        this.recycleUpdateOp(updateOp);
        if (n > 0) {
            final UpdateOp obtainUpdateOp2 = this.obtainUpdateOp(updateOp.cmd, updatePositionWithPostponed, n, payload);
            this.dispatchFirstPassAndUpdateViewHolders(obtainUpdateOp2, positionStart);
            this.recycleUpdateOp(obtainUpdateOp2);
        }
    }
    
    private void postponeAndUpdateViewHolders(final UpdateOp updateOp) {
        mPostponedList.add(updateOp);
        switch (updateOp.cmd) {
            default:
                throw new IllegalArgumentException("Unknown update op type for " + updateOp);
            case 1:
                mCallback.offsetPositionsForAdd(updateOp.positionStart, updateOp.itemCount);
            case 8:
                mCallback.offsetPositionsForMove(updateOp.positionStart, updateOp.itemCount);
            case 2:
                mCallback.offsetPositionsForRemovingLaidOutOrNewView(updateOp.positionStart, updateOp.itemCount);
            case 4:
                mCallback.markViewHoldersUpdated(updateOp.positionStart, updateOp.itemCount, updateOp.payload);
        }
    }
    
    private int updatePositionWithPostponed(int n, final int n2) {
        for (int i = -1 + mPostponedList.size(); i >= 0; --i) {
            final UpdateOp updateOp = (UpdateOp)mPostponedList.get(i);
            if (updateOp.cmd == 8) {
                int n3;
                int n4;
                if (updateOp.positionStart < updateOp.itemCount) {
                    n3 = updateOp.positionStart;
                    n4 = updateOp.itemCount;
                }
                else {
                    n3 = updateOp.itemCount;
                    n4 = updateOp.positionStart;
                }
                if (n >= n3 && n <= n4) {
                    if (n3 == updateOp.positionStart) {
                        if (n2 == 1) {
                            ++updateOp.itemCount;
                        }
                        else if (n2 == 2) {
                            --updateOp.itemCount;
                        }
                        ++n;
                    }
                    else {
                        if (n2 == 1) {
                            ++updateOp.positionStart;
                        }
                        else if (n2 == 2) {
                            --updateOp.positionStart;
                        }
                        --n;
                    }
                }
                else if (n < updateOp.positionStart) {
                    if (n2 == 1) {
                        ++updateOp.positionStart;
                        ++updateOp.itemCount;
                    }
                    else if (n2 == 2) {
                        --updateOp.positionStart;
                        --updateOp.itemCount;
                    }
                }
            }
            else if (updateOp.positionStart <= n) {
                if (updateOp.cmd == 1) {
                    n -= updateOp.itemCount;
                }
                else if (updateOp.cmd == 2) {
                    n += updateOp.itemCount;
                }
            }
            else if (n2 == 1) {
                ++updateOp.positionStart;
            }
            else if (n2 == 2) {
                --updateOp.positionStart;
            }
        }
        for (int j = -1 + mPostponedList.size(); j >= 0; --j) {
            final UpdateOp updateOp2 = (UpdateOp)mPostponedList.get(j);
            if (updateOp2.cmd == 8) {
                if (updateOp2.itemCount == updateOp2.positionStart || updateOp2.itemCount < 0) {
                    mPostponedList.remove(j);
                    this.recycleUpdateOp(updateOp2);
                }
            }
            else if (updateOp2.itemCount <= 0) {
                mPostponedList.remove(j);
                this.recycleUpdateOp(updateOp2);
            }
        }
        return n;
    }
    
    AdapterHelper addUpdateOp(final UpdateOp... array) {
        Collections.<UpdateOp>addAll(mPendingUpdates, array);
        return this;
    }
    
    public int applyPendingUpdatesToPosition(int itemCount) {
    Label_0120:
        for (int size = mPendingUpdates.size(), i = 0; i < size; ++i) {
            final UpdateOp updateOp = (UpdateOp)mPendingUpdates.get(i);
            switch (updateOp.cmd) {
                case 1:
                    if (updateOp.positionStart <= itemCount) {
                        itemCount += updateOp.itemCount;
                        break;
                    }
                    break;
                case 2:
                    if (updateOp.positionStart > itemCount) {
                        break;
                    }
                    if (updateOp.positionStart + updateOp.itemCount > itemCount) {
                        itemCount = -1;
                        break Label_0120;
                    }
                    itemCount -= updateOp.itemCount;
                    break;
                case 8:
                    if (updateOp.positionStart == itemCount) {
                        itemCount = updateOp.itemCount;
                        break;
                    }
                    if (updateOp.positionStart < itemCount) {
                        --itemCount;
                    }
                    if (updateOp.itemCount <= itemCount) {
                        ++itemCount;
                        break;
                    }
                    break;
            }
        }
        return itemCount;
    }
    
    void consumePostponedUpdates() {
        for (int size = mPostponedList.size(), i = 0; i < size; ++i) {
            mCallback.onDispatchSecondPass((UpdateOp)mPostponedList.get(i));
        }
        this.recycleUpdateOpsAndClearList(mPostponedList);
        mExistingUpdateTypes = 0;
    }
    
    void consumeUpdatesInOnePass() {
        this.consumePostponedUpdates();
        for (int size = mPendingUpdates.size(), i = 0; i < size; ++i) {
            final UpdateOp updateOp = (UpdateOp)mPendingUpdates.get(i);
            switch (updateOp.cmd) {
                case 1:
                    mCallback.onDispatchSecondPass(updateOp);
                    mCallback.offsetPositionsForAdd(updateOp.positionStart, updateOp.itemCount);
                    break;
                case 2:
                    mCallback.onDispatchSecondPass(updateOp);
                    mCallback.offsetPositionsForRemovingInvisible(updateOp.positionStart, updateOp.itemCount);
                    break;
                case 4:
                    mCallback.onDispatchSecondPass(updateOp);
                    mCallback.markViewHoldersUpdated(updateOp.positionStart, updateOp.itemCount, updateOp.payload);
                    break;
                case 8:
                    mCallback.onDispatchSecondPass(updateOp);
                    mCallback.offsetPositionsForMove(updateOp.positionStart, updateOp.itemCount);
                    break;
            }
            if (mOnItemProcessedCallback != null) {
                mOnItemProcessedCallback.run();
            }
        }
        this.recycleUpdateOpsAndClearList(mPendingUpdates);
        mExistingUpdateTypes = 0;
    }
    
    void dispatchFirstPassAndUpdateViewHolders(final UpdateOp updateOp, final int n) {
        mCallback.onDispatchFirstPass(updateOp);
        switch (updateOp.cmd) {
            default:
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
            case 2:
                mCallback.offsetPositionsForRemovingInvisible(n, updateOp.itemCount);
            case 4:
                mCallback.markViewHoldersUpdated(n, updateOp.itemCount, updateOp.payload);
        }
    }
    
    int findPositionOffset(final int n) {
        return this.findPositionOffset(n, 0);
    }
    
    int findPositionOffset(int itemCount, final int n) {
        for (int size = mPostponedList.size(), i = n; i < size; ++i) {
            final UpdateOp updateOp = (UpdateOp)mPostponedList.get(i);
            if (updateOp.cmd == 8) {
                if (updateOp.positionStart == itemCount) {
                    itemCount = updateOp.itemCount;
                }
                else {
                    if (updateOp.positionStart < itemCount) {
                        --itemCount;
                    }
                    if (updateOp.itemCount <= itemCount) {
                        ++itemCount;
                    }
                }
            }
            else if (updateOp.positionStart <= itemCount) {
                if (updateOp.cmd == 2) {
                    if (itemCount < updateOp.positionStart + updateOp.itemCount) {
                        itemCount = -1;
                        break;
                    }
                    itemCount -= updateOp.itemCount;
                }
                else if (updateOp.cmd == 1) {
                    itemCount += updateOp.itemCount;
                }
            }
        }
        return itemCount;
    }
    
    boolean hasAnyUpdateTypes(final int n) {
        return (n & mExistingUpdateTypes) != 0x0;
    }
    
    boolean hasPendingUpdates() {
        return mPendingUpdates.size() > 0;
    }
    
    boolean hasUpdates() {
        return !mPostponedList.isEmpty() && !mPendingUpdates.isEmpty();
    }
    
    @Override
    public UpdateOp obtainUpdateOp(final int cmd, final int positionStart, final int itemCount, final Object payload) {
        final UpdateOp updateOp = (UpdateOp)mUpdateOpPool.acquire();
        if (updateOp == null) {
            return new UpdateOp(cmd, positionStart, itemCount, payload);
        }
        updateOp.cmd = cmd;
        updateOp.positionStart = positionStart;
        updateOp.itemCount = itemCount;
        updateOp.payload = payload;
        return updateOp;
    }
    
    boolean onItemRangeChanged(final int n, final int n2, final Object o) {
        mPendingUpdates.add(this.obtainUpdateOp(4, n, n2, o));
        mExistingUpdateTypes |= 0x4;
        return mPendingUpdates.size() == 1;
    }
    
    boolean onItemRangeInserted(final int n, final int n2) {
        mPendingUpdates.add(this.obtainUpdateOp(1, n, n2, (Object)null));
        mExistingUpdateTypes |= 0x1;
        return mPendingUpdates.size() == 1;
    }
    
    boolean onItemRangeMoved(final int n, final int n2, final int n3) {
        boolean b = true;
        if (n == n2) {
            return false;
        }
        if (n3 != (b ? 1 : 0)) {
            throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
        }
        mPendingUpdates.add(this.obtainUpdateOp(8, n, n2, (Object)null));
        mExistingUpdateTypes |= 0x8;
        if (mPendingUpdates.size() != (b ? 1 : 0)) {
            b = false;
        }
        return b;
    }
    
    boolean onItemRangeRemoved(final int n, final int n2) {
        mPendingUpdates.add(this.obtainUpdateOp(2, n, n2, (Object)null));
        mExistingUpdateTypes |= 0x2;
        return mPendingUpdates.size() == 1;
    }
    
    void preProcess() {
        mOpReorderer.reorderOps(mPendingUpdates);
        for (int size = mPendingUpdates.size(), i = 0; i < size; ++i) {
            final UpdateOp updateOp = (UpdateOp)mPendingUpdates.get(i);
            switch (updateOp.cmd) {
                case 1:
                    this.applyAdd(updateOp);
                    break;
                case 2:
                    this.applyRemove(updateOp);
                    break;
                case 4:
                    this.applyUpdate(updateOp);
                    break;
                case 8:
                    this.applyMove(updateOp);
                    break;
            }
            if (mOnItemProcessedCallback != null) {
                mOnItemProcessedCallback.run();
            }
        }
        mPendingUpdates.clear();
    }
    
    @Override
    public void recycleUpdateOp(final UpdateOp updateOp) {
        if (!mDisableRecycler) {
            updateOp.payload = null;
            mUpdateOpPool.release(updateOp);
        }
    }
    
    void recycleUpdateOpsAndClearList(final List<UpdateOp> list) {
        for (int size = list.size(), i = 0; i < size; ++i) {
            this.recycleUpdateOp(list.get(i));
        }
        list.clear();
    }
    
    void reset() {
        this.recycleUpdateOpsAndClearList(mPendingUpdates);
        this.recycleUpdateOpsAndClearList(mPostponedList);
        mExistingUpdateTypes = 0;
    }
}
