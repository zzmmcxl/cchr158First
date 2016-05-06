package android.support.v4.view.accessibility;

public static class RangeInfoCompat
{
    public static final int RANGE_TYPE_FLOAT = 1;
    public static final int RANGE_TYPE_INT = 0;
    public static final int RANGE_TYPE_PERCENT = 2;
    private final Object mInfo;
    
    private RangeInfoCompat(final Object mInfo) {
        super();
        this.mInfo = mInfo;
    }
    
    RangeInfoCompat(final Object o, final AccessibilityNodeInfoCompat$1 object) {
        this(o);
    }
    
    static /* synthetic */ Object access$600(final RangeInfoCompat rangeInfoCompat) {
        return rangeInfoCompat.mInfo;
    }
    
    public float getCurrent() {
        return AccessibilityNodeInfoCompatKitKat.RangeInfo.getCurrent(mInfo);
    }
    
    public float getMax() {
        return AccessibilityNodeInfoCompatKitKat.RangeInfo.getMax(mInfo);
    }
    
    public float getMin() {
        return AccessibilityNodeInfoCompatKitKat.RangeInfo.getMin(mInfo);
    }
    
    public int getType() {
        return AccessibilityNodeInfoCompatKitKat.RangeInfo.getType(mInfo);
    }
}
