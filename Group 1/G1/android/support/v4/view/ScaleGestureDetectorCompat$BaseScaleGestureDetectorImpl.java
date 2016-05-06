package android.support.v4.view;

private static class BaseScaleGestureDetectorImpl implements ScaleGestureDetectorImpl
{
    private BaseScaleGestureDetectorImpl() {
        super();
    }
    
    BaseScaleGestureDetectorImpl(final ScaleGestureDetectorCompat$1 object) {
        this();
    }
    
    @Override
    public boolean isQuickScaleEnabled(final Object o) {
        return false;
    }
    
    @Override
    public void setQuickScaleEnabled(final Object o, final boolean b) {
    }
}
