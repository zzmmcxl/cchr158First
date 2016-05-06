package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

static class LazySpanLookup
{
    private static final int MIN_SIZE = 10;
    int[] mData;
    List<FullSpanItem> mFullSpanItems;
    
    LazySpanLookup() {
        super();
    }
    
    private int invalidateFullSpansAfter(final int n) {
        if (mFullSpanItems != null) {
            final FullSpanItem fullSpanItem = this.getFullSpanItem(n);
            if (fullSpanItem != null) {
                mFullSpanItems.remove(fullSpanItem);
            }
            int n2 = -1;
            for (int size = mFullSpanItems.size(), i = 0; i < size; ++i) {
                if (((FullSpanItem)mFullSpanItems.get(i)).mPosition >= n) {
                    n2 = i;
                    break;
                }
            }
            if (n2 != -1) {
                final FullSpanItem fullSpanItem2 = (FullSpanItem)mFullSpanItems.get(n2);
                mFullSpanItems.remove(n2);
                return fullSpanItem2.mPosition;
            }
        }
        return -1;
    }
    
    private void offsetFullSpansForAddition(final int n, final int n2) {
        if (mFullSpanItems != null) {
            for (int i = -1 + mFullSpanItems.size(); i >= 0; --i) {
                final FullSpanItem fullSpanItem = (FullSpanItem)mFullSpanItems.get(i);
                if (fullSpanItem.mPosition >= n) {
                    fullSpanItem.mPosition += n2;
                }
            }
        }
    }
    
    private void offsetFullSpansForRemoval(final int n, final int n2) {
        if (mFullSpanItems != null) {
            final int n3 = n + n2;
            for (int i = -1 + mFullSpanItems.size(); i >= 0; --i) {
                final FullSpanItem fullSpanItem = (FullSpanItem)mFullSpanItems.get(i);
                if (fullSpanItem.mPosition >= n) {
                    if (fullSpanItem.mPosition < n3) {
                        mFullSpanItems.remove(i);
                    }
                    else {
                        fullSpanItem.mPosition -= n2;
                    }
                }
            }
        }
    }
    
    public void addFullSpanItem(final FullSpanItem fullSpanItem) {
        if (mFullSpanItems == null) {
            mFullSpanItems = new ArrayList<FullSpanItem>();
        }
        for (int size = mFullSpanItems.size(), i = 0; i < size; ++i) {
            final FullSpanItem fullSpanItem2 = (FullSpanItem)mFullSpanItems.get(i);
            if (fullSpanItem2.mPosition == fullSpanItem.mPosition) {
                mFullSpanItems.remove(i);
            }
            if (fullSpanItem2.mPosition >= fullSpanItem.mPosition) {
                mFullSpanItems.add(i, fullSpanItem);
                return;
            }
        }
        mFullSpanItems.add(fullSpanItem);
    }
    
    void clear() {
        if (mData != null) {
            Arrays.fill(mData, -1);
        }
        mFullSpanItems = null;
    }
    
    void ensureSize(final int n) {
        if (mData == null) {
            Arrays.fill(mData = new int[1 + Math.max(n, 10)], -1);
        }
        else if (n >= mData.length) {
            final int[] mData = this.mData;
            System.arraycopy(mData, 0, this.mData = new int[this.sizeForPosition(n)], 0, mData.length);
            Arrays.fill(this.mData, mData.length, this.mData.length, -1);
        }
    }
    
    int forceInvalidateAfter(final int n) {
        if (mFullSpanItems != null) {
            for (int i = -1 + mFullSpanItems.size(); i >= 0; --i) {
                if (((FullSpanItem)mFullSpanItems.get(i)).mPosition >= n) {
                    mFullSpanItems.remove(i);
                }
            }
        }
        return this.invalidateAfter(n);
    }
    
    public FullSpanItem getFirstFullSpanItemInRange(final int n, final int n2, final int n3, final boolean b) {
        if (mFullSpanItems != null) {
            for (int size = mFullSpanItems.size(), i = 0; i < size; ++i) {
                final FullSpanItem fullSpanItem = (FullSpanItem)mFullSpanItems.get(i);
                if (fullSpanItem.mPosition >= n2) {
                    return null;
                }
                if (fullSpanItem.mPosition >= n && (n3 == 0 || fullSpanItem.mGapDir == n3 || (b && fullSpanItem.mHasUnwantedGapAfter))) {
                    return fullSpanItem;
                }
            }
            return null;
        }
        return null;
    }
    
    public FullSpanItem getFullSpanItem(final int n) {
        if (mFullSpanItems != null) {
            for (int i = -1 + mFullSpanItems.size(); i >= 0; --i) {
                final FullSpanItem fullSpanItem = (FullSpanItem)mFullSpanItems.get(i);
                if (fullSpanItem.mPosition == n) {
                    return fullSpanItem;
                }
            }
            return null;
        }
        return null;
    }
    
    int getSpan(final int n) {
        if (mData == null || n >= mData.length) {
            return -1;
        }
        return mData[n];
    }
    
    int invalidateAfter(final int n) {
        if (mData == null || n >= mData.length) {
            return -1;
        }
        final int invalidateFullSpansAfter = this.invalidateFullSpansAfter(n);
        if (invalidateFullSpansAfter == -1) {
            Arrays.fill(mData, n, mData.length, -1);
            return mData.length;
        }
        Arrays.fill(mData, n, invalidateFullSpansAfter + 1, -1);
        return invalidateFullSpansAfter + 1;
    }
    
    void offsetForAddition(final int n, final int n2) {
        if (mData == null || n >= mData.length) {
            return;
        }
        this.ensureSize(n + n2);
        System.arraycopy(mData, n, mData, n + n2, mData.length - n - n2);
        Arrays.fill(mData, n, n + n2, -1);
        this.offsetFullSpansForAddition(n, n2);
    }
    
    void offsetForRemoval(final int n, final int n2) {
        if (mData == null || n >= mData.length) {
            return;
        }
        this.ensureSize(n + n2);
        System.arraycopy(mData, n + n2, mData, n, mData.length - n - n2);
        Arrays.fill(mData, mData.length - n2, mData.length, -1);
        this.offsetFullSpansForRemoval(n, n2);
    }
    
    void setSpan(final int n, final Span span) {
        this.ensureSize(n);
        mData[n] = span.mIndex;
    }
    
    int sizeForPosition(final int n) {
        int i;
        for (i = mData.length; i <= n; i *= 2) {}
        return i;
    }
}
