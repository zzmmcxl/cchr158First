package android.support.v4.view.accessibility;

import android.view.accessibility.AccessibilityNodeInfo$CollectionInfo;

static class CollectionInfo
{
    CollectionInfo() {
        super();
    }
    
    static int getColumnCount(final Object o) {
        return ((AccessibilityNodeInfo$CollectionInfo)o).getColumnCount();
    }
    
    static int getRowCount(final Object o) {
        return ((AccessibilityNodeInfo$CollectionInfo)o).getRowCount();
    }
    
    static boolean isHierarchical(final Object o) {
        return ((AccessibilityNodeInfo$CollectionInfo)o).isHierarchical();
    }
}
