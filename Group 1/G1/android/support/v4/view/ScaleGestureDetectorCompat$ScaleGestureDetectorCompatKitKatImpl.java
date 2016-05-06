package android.support.v4.view;

private static class ScaleGestureDetectorCompatKitKatImpl implements ScaleGestureDetectorImpl
{
    private ScaleGestureDetectorCompatKitKatImpl() {
        super();
    }
    
    ScaleGestureDetectorCompatKitKatImpl(final ScaleGestureDetectorCompat$1 object) {
        this();
    }
    
    @Override
    public boolean isQuickScaleEnabled(final Object o) {
        return ScaleGestureDetectorCompatKitKat.isQuickScaleEnabled(o);
    }
    
    @Override
    public void setQuickScaleEnabled(final Object o, final boolean b) {
        ScaleGestureDetectorCompatKitKat.setQuickScaleEnabled(o, b);
    }
}
