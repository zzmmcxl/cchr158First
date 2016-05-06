package android.support.v4.view.accessibility;

import java.util.Collections;
import android.view.View;
import java.util.List;
import android.os.Parcelable;
import android.os.Build$VERSION;

public class AccessibilityRecordCompat
{
    private static final AccessibilityRecordImpl IMPL;
    private final Object mRecord;
    
    static {
        if (Build$VERSION.SDK_INT >= 16) {
            IMPL = (AccessibilityRecordImpl)new AccessibilityRecordJellyBeanImpl();
            return;
        }
        if (Build$VERSION.SDK_INT >= 15) {
            IMPL = (AccessibilityRecordImpl)new AccessibilityRecordIcsMr1Impl();
            return;
        }
        if (Build$VERSION.SDK_INT >= 14) {
            IMPL = (AccessibilityRecordImpl)new AccessibilityRecordIcsImpl();
            return;
        }
        IMPL = (AccessibilityRecordImpl)new AccessibilityRecordStubImpl();
    }
    
    public AccessibilityRecordCompat(final Object mRecord) {
        super();
        mRecord = mRecord;
    }
    
    public static AccessibilityRecordCompat obtain() {
        return new AccessibilityRecordCompat(IMPL.obtain());
    }
    
    public static AccessibilityRecordCompat obtain(final AccessibilityRecordCompat accessibilityRecordCompat) {
        return new AccessibilityRecordCompat(IMPL.obtain(accessibilityRecordCompat.mRecord));
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o == null) {
                return false;
            }
            if (this.getClass() != o.getClass()) {
                return false;
            }
            final AccessibilityRecordCompat accessibilityRecordCompat = (AccessibilityRecordCompat)o;
            if (mRecord == null) {
                if (mRecord != null) {
                    return false;
                }
            }
            else if (!mRecord.equals(mRecord)) {
                return false;
            }
        }
        return true;
    }
    
    public int getAddedCount() {
        return IMPL.getAddedCount(mRecord);
    }
    
    public CharSequence getBeforeText() {
        return IMPL.getBeforeText(mRecord);
    }
    
    public CharSequence getClassName() {
        return IMPL.getClassName(mRecord);
    }
    
    public CharSequence getContentDescription() {
        return IMPL.getContentDescription(mRecord);
    }
    
    public int getCurrentItemIndex() {
        return IMPL.getCurrentItemIndex(mRecord);
    }
    
    public int getFromIndex() {
        return IMPL.getFromIndex(mRecord);
    }
    
    public Object getImpl() {
        return mRecord;
    }
    
    public int getItemCount() {
        return IMPL.getItemCount(mRecord);
    }
    
    public int getMaxScrollX() {
        return IMPL.getMaxScrollX(mRecord);
    }
    
    public int getMaxScrollY() {
        return IMPL.getMaxScrollY(mRecord);
    }
    
    public Parcelable getParcelableData() {
        return IMPL.getParcelableData(mRecord);
    }
    
    public int getRemovedCount() {
        return IMPL.getRemovedCount(mRecord);
    }
    
    public int getScrollX() {
        return IMPL.getScrollX(mRecord);
    }
    
    public int getScrollY() {
        return IMPL.getScrollY(mRecord);
    }
    
    public AccessibilityNodeInfoCompat getSource() {
        return IMPL.getSource(mRecord);
    }
    
    public List<CharSequence> getText() {
        return IMPL.getText(mRecord);
    }
    
    public int getToIndex() {
        return IMPL.getToIndex(mRecord);
    }
    
    public int getWindowId() {
        return IMPL.getWindowId(mRecord);
    }
    
    @Override
    public int hashCode() {
        if (mRecord == null) {
            return 0;
        }
        return mRecord.hashCode();
    }
    
    public boolean isChecked() {
        return IMPL.isChecked(mRecord);
    }
    
    public boolean isEnabled() {
        return IMPL.isEnabled(mRecord);
    }
    
    public boolean isFullScreen() {
        return IMPL.isFullScreen(mRecord);
    }
    
    public boolean isPassword() {
        return IMPL.isPassword(mRecord);
    }
    
    public boolean isScrollable() {
        return IMPL.isScrollable(mRecord);
    }
    
    public void recycle() {
        IMPL.recycle(mRecord);
    }
    
    public void setAddedCount(final int n) {
        IMPL.setAddedCount(mRecord, n);
    }
    
    public void setBeforeText(final CharSequence charSequence) {
        IMPL.setBeforeText(mRecord, charSequence);
    }
    
    public void setChecked(final boolean b) {
        IMPL.setChecked(mRecord, b);
    }
    
    public void setClassName(final CharSequence charSequence) {
        IMPL.setClassName(mRecord, charSequence);
    }
    
    public void setContentDescription(final CharSequence charSequence) {
        IMPL.setContentDescription(mRecord, charSequence);
    }
    
    public void setCurrentItemIndex(final int n) {
        IMPL.setCurrentItemIndex(mRecord, n);
    }
    
    public void setEnabled(final boolean b) {
        IMPL.setEnabled(mRecord, b);
    }
    
    public void setFromIndex(final int n) {
        IMPL.setFromIndex(mRecord, n);
    }
    
    public void setFullScreen(final boolean b) {
        IMPL.setFullScreen(mRecord, b);
    }
    
    public void setItemCount(final int n) {
        IMPL.setItemCount(mRecord, n);
    }
    
    public void setMaxScrollX(final int n) {
        IMPL.setMaxScrollX(mRecord, n);
    }
    
    public void setMaxScrollY(final int n) {
        IMPL.setMaxScrollY(mRecord, n);
    }
    
    public void setParcelableData(final Parcelable parcelable) {
        IMPL.setParcelableData(mRecord, parcelable);
    }
    
    public void setPassword(final boolean b) {
        IMPL.setPassword(mRecord, b);
    }
    
    public void setRemovedCount(final int n) {
        IMPL.setRemovedCount(mRecord, n);
    }
    
    public void setScrollX(final int n) {
        IMPL.setScrollX(mRecord, n);
    }
    
    public void setScrollY(final int n) {
        IMPL.setScrollY(mRecord, n);
    }
    
    public void setScrollable(final boolean b) {
        IMPL.setScrollable(mRecord, b);
    }
    
    public void setSource(final View view) {
        IMPL.setSource(mRecord, view);
    }
    
    public void setSource(final View view, final int n) {
        IMPL.setSource(mRecord, view, n);
    }
    
    public void setToIndex(final int n) {
        IMPL.setToIndex(mRecord, n);
    }
}
