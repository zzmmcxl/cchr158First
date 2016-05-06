package android.support.v4.view.accessibility;

import android.view.accessibility.AccessibilityNodeInfo$RangeInfo;
import android.view.accessibility.AccessibilityNodeInfo$CollectionItemInfo;
import android.view.accessibility.AccessibilityNodeInfo$CollectionInfo;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;

class AccessibilityNodeInfoCompatKitKat
{
    AccessibilityNodeInfoCompatKitKat() {
        super();
    }
    
    public static boolean canOpenPopup(final Object o) {
        return ((AccessibilityNodeInfo)o).canOpenPopup();
    }
    
    static Object getCollectionInfo(final Object o) {
        return ((AccessibilityNodeInfo)o).getCollectionInfo();
    }
    
    static Object getCollectionItemInfo(final Object o) {
        return ((AccessibilityNodeInfo)o).getCollectionItemInfo();
    }
    
    public static Bundle getExtras(final Object o) {
        return ((AccessibilityNodeInfo)o).getExtras();
    }
    
    public static int getInputType(final Object o) {
        return ((AccessibilityNodeInfo)o).getInputType();
    }
    
    static int getLiveRegion(final Object o) {
        return ((AccessibilityNodeInfo)o).getLiveRegion();
    }
    
    static Object getRangeInfo(final Object o) {
        return ((AccessibilityNodeInfo)o).getRangeInfo();
    }
    
    public static boolean isContentInvalid(final Object o) {
        return ((AccessibilityNodeInfo)o).isContentInvalid();
    }
    
    public static boolean isDismissable(final Object o) {
        return ((AccessibilityNodeInfo)o).isDismissable();
    }
    
    public static boolean isMultiLine(final Object o) {
        return ((AccessibilityNodeInfo)o).isMultiLine();
    }
    
    public static Object obtainCollectionInfo(final int n, final int n2, final boolean b, final int n3) {
        return AccessibilityNodeInfo$CollectionInfo.obtain(n, n2, b);
    }
    
    public static Object obtainCollectionItemInfo(final int n, final int n2, final int n3, final int n4, final boolean b) {
        return AccessibilityNodeInfo$CollectionItemInfo.obtain(n, n2, n3, n4, b);
    }
    
    public static void setCanOpenPopup(final Object o, final boolean canOpenPopup) {
        ((AccessibilityNodeInfo)o).setCanOpenPopup(canOpenPopup);
    }
    
    public static void setCollectionInfo(final Object o, final Object o2) {
        ((AccessibilityNodeInfo)o).setCollectionInfo((AccessibilityNodeInfo$CollectionInfo)o2);
    }
    
    public static void setCollectionItemInfo(final Object o, final Object o2) {
        ((AccessibilityNodeInfo)o).setCollectionItemInfo((AccessibilityNodeInfo$CollectionItemInfo)o2);
    }
    
    public static void setContentInvalid(final Object o, final boolean contentInvalid) {
        ((AccessibilityNodeInfo)o).setContentInvalid(contentInvalid);
    }
    
    public static void setDismissable(final Object o, final boolean dismissable) {
        ((AccessibilityNodeInfo)o).setDismissable(dismissable);
    }
    
    public static void setInputType(final Object o, final int inputType) {
        ((AccessibilityNodeInfo)o).setInputType(inputType);
    }
    
    static void setLiveRegion(final Object o, final int liveRegion) {
        ((AccessibilityNodeInfo)o).setLiveRegion(liveRegion);
    }
    
    public static void setMultiLine(final Object o, final boolean multiLine) {
        ((AccessibilityNodeInfo)o).setMultiLine(multiLine);
    }
    
    public static void setRangeInfo(final Object o, final Object o2) {
        ((AccessibilityNodeInfo)o).setRangeInfo((AccessibilityNodeInfo$RangeInfo)o2);
    }
}
