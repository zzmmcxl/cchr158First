package android.support.v4.view.accessibility;

import android.graphics.Rect;

private static class AccessibilityWindowInfoStubImpl implements AccessibilityWindowInfoImpl
{
    private AccessibilityWindowInfoStubImpl() {
        super();
    }
    
    AccessibilityWindowInfoStubImpl(final AccessibilityWindowInfoCompat$1 object) {
        this();
    }
    
    @Override
    public void getBoundsInScreen(final Object o, final Rect rect) {
    }
    
    @Override
    public Object getChild(final Object o, final int n) {
        return null;
    }
    
    @Override
    public int getChildCount(final Object o) {
        return 0;
    }
    
    @Override
    public int getId(final Object o) {
        return -1;
    }
    
    @Override
    public int getLayer(final Object o) {
        return -1;
    }
    
    @Override
    public Object getParent(final Object o) {
        return null;
    }
    
    @Override
    public Object getRoot(final Object o) {
        return null;
    }
    
    @Override
    public int getType(final Object o) {
        return -1;
    }
    
    @Override
    public boolean isAccessibilityFocused(final Object o) {
        return true;
    }
    
    @Override
    public boolean isActive(final Object o) {
        return true;
    }
    
    @Override
    public boolean isFocused(final Object o) {
        return true;
    }
    
    @Override
    public Object obtain() {
        return null;
    }
    
    @Override
    public Object obtain(final Object o) {
        return null;
    }
    
    @Override
    public void recycle(final Object o) {
    }
}
