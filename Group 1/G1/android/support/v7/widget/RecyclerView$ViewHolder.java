package android.support.v7.widget;

import android.util.Log;
import android.support.v4.view.ViewCompat;
import java.util.ArrayList;
import java.util.Collections;
import android.view.View;
import java.util.List;

public abstract static class ViewHolder
{
    static final int FLAG_ADAPTER_FULLUPDATE = 1024;
    static final int FLAG_ADAPTER_POSITION_UNKNOWN = 512;
    static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
    static final int FLAG_BOUNCED_FROM_HIDDEN_LIST = 8192;
    static final int FLAG_BOUND = 1;
    static final int FLAG_IGNORE = 128;
    static final int FLAG_INVALID = 4;
    static final int FLAG_MOVED = 2048;
    static final int FLAG_NOT_RECYCLABLE = 16;
    static final int FLAG_REMOVED = 8;
    static final int FLAG_RETURNED_FROM_SCRAP = 32;
    static final int FLAG_TMP_DETACHED = 256;
    static final int FLAG_UPDATE = 2;
    private static final List<Object> FULLUPDATE_PAYLOADS;
    public final View itemView;
    private int mFlags;
    private boolean mInChangeScrap;
    private int mIsRecyclableCount;
    long mItemId;
    int mItemViewType;
    int mOldPosition;
    RecyclerView mOwnerRecyclerView;
    List<Object> mPayloads;
    int mPosition;
    int mPreLayoutPosition;
    private Recycler mScrapContainer;
    ViewHolder mShadowedHolder;
    ViewHolder mShadowingHolder;
    List<Object> mUnmodifiedPayloads;
    private int mWasImportantForAccessibilityBeforeHidden;
    
    static {
        FULLUPDATE_PAYLOADS = Collections.EMPTY_LIST;
    }
    
    public ViewHolder(final View itemView) {
        super();
        this.mPosition = -1;
        this.mOldPosition = -1;
        this.mItemId = -1L;
        this.mItemViewType = -1;
        this.mPreLayoutPosition = -1;
        this.mShadowedHolder = null;
        this.mShadowingHolder = null;
        this.mPayloads = null;
        this.mUnmodifiedPayloads = null;
        this.mIsRecyclableCount = 0;
        this.mScrapContainer = null;
        this.mInChangeScrap = false;
        this.mWasImportantForAccessibilityBeforeHidden = 0;
        if (itemView == null) {
            throw new IllegalArgumentException("itemView may not be null");
        }
        this.itemView = itemView;
    }
    
    static /* synthetic */ void access$1500(final ViewHolder viewHolder) {
        viewHolder.onEnteredHiddenState();
    }
    
    static /* synthetic */ void access$1600(final ViewHolder viewHolder) {
        viewHolder.onLeftHiddenState();
    }
    
    static /* synthetic */ boolean access$4900(final ViewHolder viewHolder) {
        return viewHolder.doesTransientStatePreventRecycling();
    }
    
    static /* synthetic */ Recycler access$5002(final ViewHolder viewHolder, final Recycler mScrapContainer) {
        return viewHolder.mScrapContainer = mScrapContainer;
    }
    
    static /* synthetic */ boolean access$5100(final ViewHolder viewHolder) {
        return viewHolder.mInChangeScrap;
    }
    
    static /* synthetic */ boolean access$5102(final ViewHolder viewHolder, final boolean mInChangeScrap) {
        return viewHolder.mInChangeScrap = mInChangeScrap;
    }
    
    static /* synthetic */ boolean access$6300(final ViewHolder viewHolder) {
        return viewHolder.shouldBeKeptAsChild();
    }
    
    static /* synthetic */ int access$6500(final ViewHolder viewHolder) {
        return viewHolder.mFlags;
    }
    
    private void createPayloadsIfNeeded() {
        if (mPayloads == null) {
            mPayloads = new ArrayList<Object>();
            mUnmodifiedPayloads = Collections.<Object>unmodifiableList((List<?>)mPayloads);
        }
    }
    
    private boolean doesTransientStatePreventRecycling() {
        return (0x10 & mFlags) == 0x0 && ViewCompat.hasTransientState(itemView);
    }
    
    private void onEnteredHiddenState() {
        mWasImportantForAccessibilityBeforeHidden = ViewCompat.getImportantForAccessibility(itemView);
        ViewCompat.setImportantForAccessibility(itemView, 4);
    }
    
    private void onLeftHiddenState() {
        ViewCompat.setImportantForAccessibility(itemView, mWasImportantForAccessibilityBeforeHidden);
        mWasImportantForAccessibilityBeforeHidden = 0;
    }
    
    private boolean shouldBeKeptAsChild() {
        return (0x10 & mFlags) != 0x0;
    }
    
    void addChangePayload(final Object o) {
        if (o == null) {
            this.addFlags(1024);
        }
        else if ((0x400 & mFlags) == 0x0) {
            this.createPayloadsIfNeeded();
            mPayloads.add(o);
        }
    }
    
    void addFlags(final int n) {
        mFlags |= n;
    }
    
    void clearOldPosition() {
        mOldPosition = -1;
        mPreLayoutPosition = -1;
    }
    
    void clearPayload() {
        if (mPayloads != null) {
            mPayloads.clear();
        }
        mFlags &= 0xFFFFFBFF;
    }
    
    void clearReturnedFromScrapFlag() {
        mFlags &= 0xFFFFFFDF;
    }
    
    void clearTmpDetachFlag() {
        mFlags &= 0xFFFFFEFF;
    }
    
    void flagRemovedAndOffsetPosition(final int mPosition, final int n, final boolean b) {
        this.addFlags(8);
        this.offsetPosition(n, b);
        this.mPosition = mPosition;
    }
    
    public final int getAdapterPosition() {
        if (mOwnerRecyclerView == null) {
            return -1;
        }
        return RecyclerView.access$5700(mOwnerRecyclerView, this);
    }
    
    public final long getItemId() {
        return mItemId;
    }
    
    public final int getItemViewType() {
        return mItemViewType;
    }
    
    public final int getLayoutPosition() {
        if (mPreLayoutPosition == -1) {
            return mPosition;
        }
        return mPreLayoutPosition;
    }
    
    public final int getOldPosition() {
        return mOldPosition;
    }
    
    @Deprecated
    public final int getPosition() {
        if (mPreLayoutPosition == -1) {
            return mPosition;
        }
        return mPreLayoutPosition;
    }
    
    List<Object> getUnmodifiedPayloads() {
        if ((0x400 & mFlags) != 0x0) {
            return FULLUPDATE_PAYLOADS;
        }
        if (mPayloads == null || mPayloads.size() == 0) {
            return FULLUPDATE_PAYLOADS;
        }
        return mUnmodifiedPayloads;
    }
    
    boolean hasAnyOfTheFlags(final int n) {
        return (n & mFlags) != 0x0;
    }
    
    boolean isAdapterPositionUnknown() {
        return (0x200 & mFlags) != 0x0 || this.isInvalid();
    }
    
    boolean isBound() {
        return (0x1 & mFlags) != 0x0;
    }
    
    boolean isInvalid() {
        return (0x4 & mFlags) != 0x0;
    }
    
    public final boolean isRecyclable() {
        return (0x10 & mFlags) == 0x0 && !ViewCompat.hasTransientState(itemView);
    }
    
    boolean isRemoved() {
        return (0x8 & mFlags) != 0x0;
    }
    
    boolean isScrap() {
        return mScrapContainer != null;
    }
    
    boolean isTmpDetached() {
        return (0x100 & mFlags) != 0x0;
    }
    
    boolean isUpdated() {
        return (0x2 & mFlags) != 0x0;
    }
    
    boolean needsUpdate() {
        return (0x2 & mFlags) != 0x0;
    }
    
    void offsetPosition(final int n, final boolean b) {
        if (mOldPosition == -1) {
            mOldPosition = mPosition;
        }
        if (mPreLayoutPosition == -1) {
            mPreLayoutPosition = mPosition;
        }
        if (b) {
            mPreLayoutPosition += n;
        }
        mPosition += n;
        if (itemView.getLayoutParams() != null) {
            ((LayoutParams)itemView.getLayoutParams()).mInsetsDirty = true;
        }
    }
    
    void resetInternal() {
        mFlags = 0;
        mPosition = -1;
        mOldPosition = -1;
        mItemId = -1L;
        mPreLayoutPosition = -1;
        mIsRecyclableCount = 0;
        mShadowedHolder = null;
        mShadowingHolder = null;
        this.clearPayload();
        mWasImportantForAccessibilityBeforeHidden = 0;
    }
    
    void saveOldPosition() {
        if (mOldPosition == -1) {
            mOldPosition = mPosition;
        }
    }
    
    void setFlags(final int n, final int n2) {
        mFlags = ((mFlags & ~n2) | (n & n2));
    }
    
    public final void setIsRecyclable(final boolean b) {
        int mIsRecyclableCount;
        if (b) {
            mIsRecyclableCount = -1 + this.mIsRecyclableCount;
        }
        else {
            mIsRecyclableCount = 1 + this.mIsRecyclableCount;
        }
        this.mIsRecyclableCount = mIsRecyclableCount;
        if (this.mIsRecyclableCount < 0) {
            this.mIsRecyclableCount = 0;
            Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
        }
        else {
            if (!b && this.mIsRecyclableCount == 1) {
                mFlags |= 0x10;
                return;
            }
            if (b && this.mIsRecyclableCount == 0) {
                mFlags &= 0xFFFFFFEF;
            }
        }
    }
    
    void setScrapContainer(final Recycler mScrapContainer, final boolean mInChangeScrap) {
        this.mScrapContainer = mScrapContainer;
        this.mInChangeScrap = mInChangeScrap;
    }
    
    boolean shouldIgnore() {
        return (0x80 & mFlags) != 0x0;
    }
    
    void stopIgnoring() {
        mFlags &= 0xFFFFFF7F;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ViewHolder{" + Integer.toHexString(this.hashCode()) + " position=" + mPosition + " id=" + mItemId + ", oldPos=" + mOldPosition + ", pLpos:" + mPreLayoutPosition);
        if (this.isScrap()) {
            final StringBuilder append = sb.append(" scrap ");
            String s;
            if (mInChangeScrap) {
                s = "[changeScrap]";
            }
            else {
                s = "[attachedScrap]";
            }
            append.append(s);
        }
        if (this.isInvalid()) {
            sb.append(" invalid");
        }
        if (!this.isBound()) {
            sb.append(" unbound");
        }
        if (this.needsUpdate()) {
            sb.append(" update");
        }
        if (this.isRemoved()) {
            sb.append(" removed");
        }
        if (this.shouldIgnore()) {
            sb.append(" ignored");
        }
        if (this.isTmpDetached()) {
            sb.append(" tmpDetached");
        }
        if (!this.isRecyclable()) {
            sb.append(" not recyclable(" + mIsRecyclableCount + ")");
        }
        if (this.isAdapterPositionUnknown()) {
            sb.append(" undefined adapter position");
        }
        if (itemView.getParent() == null) {
            sb.append(" no parent");
        }
        sb.append("}");
        return sb.toString();
    }
    
    void unScrap() {
        mScrapContainer.unscrapView(this);
    }
    
    boolean wasReturnedFromScrap() {
        return (0x20 & mFlags) != 0x0;
    }
}
