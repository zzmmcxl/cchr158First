package android.support.v4.view.accessibility;

public static class CollectionItemInfoCompat
{
    private final Object mInfo;
    
    private CollectionItemInfoCompat(final Object mInfo) {
        super();
        this.mInfo = mInfo;
    }
    
    CollectionItemInfoCompat(final Object o, final AccessibilityNodeInfoCompat$1 object) {
        this(o);
    }
    
    static /* synthetic */ Object access$300(final CollectionItemInfoCompat collectionItemInfoCompat) {
        return collectionItemInfoCompat.mInfo;
    }
    
    public static CollectionItemInfoCompat obtain(final int n, final int n2, final int n3, final int n4, final boolean b, final boolean b2) {
        return new CollectionItemInfoCompat(AccessibilityNodeInfoCompat.access$000().obtainCollectionItemInfo(n, n2, n3, n4, b, b2));
    }
    
    public int getColumnIndex() {
        return AccessibilityNodeInfoCompat.access$000().getCollectionItemColumnIndex(mInfo);
    }
    
    public int getColumnSpan() {
        return AccessibilityNodeInfoCompat.access$000().getCollectionItemColumnSpan(mInfo);
    }
    
    public int getRowIndex() {
        return AccessibilityNodeInfoCompat.access$000().getCollectionItemRowIndex(mInfo);
    }
    
    public int getRowSpan() {
        return AccessibilityNodeInfoCompat.access$000().getCollectionItemRowSpan(mInfo);
    }
    
    public boolean isHeading() {
        return AccessibilityNodeInfoCompat.access$000().isCollectionItemHeading(mInfo);
    }
    
    public boolean isSelected() {
        return AccessibilityNodeInfoCompat.access$000().isCollectionItemSelected(mInfo);
    }
}
