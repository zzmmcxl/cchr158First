package android.support.v4.view.accessibility;

import android.graphics.Rect;
import android.os.Build$VERSION;

public class AccessibilityWindowInfoCompat
{
    private static final AccessibilityWindowInfoImpl IMPL;
    public static final int TYPE_ACCESSIBILITY_OVERLAY = 4;
    public static final int TYPE_APPLICATION = 1;
    public static final int TYPE_INPUT_METHOD = 2;
    public static final int TYPE_SYSTEM = 3;
    private static final int UNDEFINED = -1;
    private Object mInfo;
    
    static {
        if (Build$VERSION.SDK_INT >= 21) {
            IMPL = (AccessibilityWindowInfoImpl)new AccessibilityWindowInfoApi21Impl();
            return;
        }
        IMPL = (AccessibilityWindowInfoImpl)new AccessibilityWindowInfoStubImpl();
    }
    
    private AccessibilityWindowInfoCompat(final Object mInfo) {
        super();
        mInfo = mInfo;
    }
    
    public static AccessibilityWindowInfoCompat obtain() {
        return wrapNonNullInstance(IMPL.obtain());
    }
    
    public static AccessibilityWindowInfoCompat obtain(final AccessibilityWindowInfoCompat accessibilityWindowInfoCompat) {
        return wrapNonNullInstance(IMPL.obtain(accessibilityWindowInfoCompat.mInfo));
    }
    
    private static String typeToString(final int n) {
        switch (n) {
            default:
                return "<UNKNOWN>";
            case 1:
                return "TYPE_APPLICATION";
            case 2:
                return "TYPE_INPUT_METHOD";
            case 3:
                return "TYPE_SYSTEM";
            case 4:
                return "TYPE_ACCESSIBILITY_OVERLAY";
        }
    }
    
    static AccessibilityWindowInfoCompat wrapNonNullInstance(final Object o) {
        if (o != null) {
            return new AccessibilityWindowInfoCompat(o);
        }
        return null;
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
            final AccessibilityWindowInfoCompat accessibilityWindowInfoCompat = (AccessibilityWindowInfoCompat)o;
            if (mInfo == null) {
                if (mInfo != null) {
                    return false;
                }
            }
            else if (!mInfo.equals(mInfo)) {
                return false;
            }
        }
        return true;
    }
    
    public void getBoundsInScreen(final Rect rect) {
        IMPL.getBoundsInScreen(mInfo, rect);
    }
    
    public AccessibilityWindowInfoCompat getChild(final int n) {
        return wrapNonNullInstance(IMPL.getChild(mInfo, n));
    }
    
    public int getChildCount() {
        return IMPL.getChildCount(mInfo);
    }
    
    public int getId() {
        return IMPL.getId(mInfo);
    }
    
    public int getLayer() {
        return IMPL.getLayer(mInfo);
    }
    
    public AccessibilityWindowInfoCompat getParent() {
        return wrapNonNullInstance(IMPL.getParent(mInfo));
    }
    
    public AccessibilityNodeInfoCompat getRoot() {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(IMPL.getRoot(mInfo));
    }
    
    public int getType() {
        return IMPL.getType(mInfo);
    }
    
    @Override
    public int hashCode() {
        if (mInfo == null) {
            return 0;
        }
        return mInfo.hashCode();
    }
    
    public boolean isAccessibilityFocused() {
        return IMPL.isAccessibilityFocused(mInfo);
    }
    
    public boolean isActive() {
        return IMPL.isActive(mInfo);
    }
    
    public boolean isFocused() {
        return IMPL.isFocused(mInfo);
    }
    
    public void recycle() {
        IMPL.recycle(mInfo);
    }
    
    @Override
    public String toString() {
        boolean b = true;
        final StringBuilder sb = new StringBuilder();
        final Rect rect = new Rect();
        this.getBoundsInScreen(rect);
        sb.append("AccessibilityWindowInfo[");
        sb.append("id=").append(this.getId());
        sb.append(", type=").append(typeToString(this.getType()));
        sb.append(", layer=").append(this.getLayer());
        sb.append(", bounds=").append(rect);
        sb.append(", focused=").append(this.isFocused());
        sb.append(", active=").append(this.isActive());
        sb.append(", hasParent=").append(this.getParent() != null && b);
        final StringBuilder append = sb.append(", hasChildren=");
        if (this.getChildCount() <= 0) {
            b = false;
        }
        append.append(b);
        sb.append(']');
        return sb.toString();
    }
}
