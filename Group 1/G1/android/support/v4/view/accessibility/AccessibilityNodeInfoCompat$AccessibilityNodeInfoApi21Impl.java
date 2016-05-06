package android.support.v4.view.accessibility;

import android.view.View;
import java.util.List;

static class AccessibilityNodeInfoApi21Impl extends AccessibilityNodeInfoKitKatImpl
{
    AccessibilityNodeInfoApi21Impl() {
        super();
    }
    
    @Override
    public void addAction(final Object o, final Object o2) {
        AccessibilityNodeInfoCompatApi21.addAction(o, o2);
    }
    
    @Override
    public int getAccessibilityActionId(final Object o) {
        return AccessibilityNodeInfoCompatApi21.getAccessibilityActionId(o);
    }
    
    @Override
    public CharSequence getAccessibilityActionLabel(final Object o) {
        return AccessibilityNodeInfoCompatApi21.getAccessibilityActionLabel(o);
    }
    
    @Override
    public List<Object> getActionList(final Object o) {
        return AccessibilityNodeInfoCompatApi21.getActionList(o);
    }
    
    @Override
    public CharSequence getError(final Object o) {
        return AccessibilityNodeInfoCompatApi21.getError(o);
    }
    
    @Override
    public int getMaxTextLength(final Object o) {
        return AccessibilityNodeInfoCompatApi21.getMaxTextLength(o);
    }
    
    @Override
    public Object getWindow(final Object o) {
        return AccessibilityNodeInfoCompatApi21.getWindow(o);
    }
    
    @Override
    public boolean isCollectionItemSelected(final Object o) {
        return AccessibilityNodeInfoCompatApi21.CollectionItemInfo.isSelected(o);
    }
    
    @Override
    public Object newAccessibilityAction(final int n, final CharSequence charSequence) {
        return AccessibilityNodeInfoCompatApi21.newAccessibilityAction(n, charSequence);
    }
    
    @Override
    public Object obtainCollectionInfo(final int n, final int n2, final boolean b, final int n3) {
        return AccessibilityNodeInfoCompatApi21.obtainCollectionInfo(n, n2, b, n3);
    }
    
    @Override
    public Object obtainCollectionItemInfo(final int n, final int n2, final int n3, final int n4, final boolean b, final boolean b2) {
        return AccessibilityNodeInfoCompatApi21.obtainCollectionItemInfo(n, n2, n3, n4, b, b2);
    }
    
    @Override
    public boolean removeAction(final Object o, final Object o2) {
        return AccessibilityNodeInfoCompatApi21.removeAction(o, o2);
    }
    
    @Override
    public boolean removeChild(final Object o, final View view) {
        return AccessibilityNodeInfoCompatApi21.removeChild(o, view);
    }
    
    @Override
    public boolean removeChild(final Object o, final View view, final int n) {
        return AccessibilityNodeInfoCompatApi21.removeChild(o, view, n);
    }
    
    @Override
    public void setError(final Object o, final CharSequence charSequence) {
        AccessibilityNodeInfoCompatApi21.setError(o, charSequence);
    }
    
    @Override
    public void setMaxTextLength(final Object o, final int n) {
        AccessibilityNodeInfoCompatApi21.setMaxTextLength(o, n);
    }
}
