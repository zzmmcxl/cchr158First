package android.support.v4.view.accessibility;

public abstract static class AccessibilityStateChangeListenerCompat
{
    final Object mListener;
    
    public AccessibilityStateChangeListenerCompat() {
        super();
        this.mListener = AccessibilityManagerCompat.access$000().newAccessiblityStateChangeListener(this);
    }
    
    public abstract void onAccessibilityStateChanged(final boolean p0);
}
