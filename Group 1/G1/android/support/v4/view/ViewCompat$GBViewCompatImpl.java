package android.support.v4.view;

import android.view.View;

static class GBViewCompatImpl extends EclairMr1ViewCompatImpl
{
    GBViewCompatImpl() {
        super();
    }
    
    @Override
    public int getOverScrollMode(final View view) {
        return ViewCompatGingerbread.getOverScrollMode(view);
    }
    
    @Override
    public void setOverScrollMode(final View view, final int n) {
        ViewCompatGingerbread.setOverScrollMode(view, n);
    }
}
