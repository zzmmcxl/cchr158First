package android.support.v4.view.accessibility;

import android.view.accessibility.AccessibilityNodeInfo$CollectionItemInfo;

static class CollectionItemInfo
{
    CollectionItemInfo() {
        super();
    }
    
    public static boolean isSelected(final Object o) {
        return ((AccessibilityNodeInfo$CollectionItemInfo)o).isSelected();
    }
}
