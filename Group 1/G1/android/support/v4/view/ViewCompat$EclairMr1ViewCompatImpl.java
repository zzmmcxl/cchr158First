package android.support.v4.view;

import android.view.ViewGroup;
import android.view.View;

static class EclairMr1ViewCompatImpl extends BaseViewCompatImpl
{
    EclairMr1ViewCompatImpl() {
        super();
    }
    
    @Override
    public boolean isOpaque(final View view) {
        return ViewCompatEclairMr1.isOpaque(view);
    }
    
    @Override
    public void setChildrenDrawingOrderEnabled(final ViewGroup viewGroup, final boolean b) {
        ViewCompatEclairMr1.setChildrenDrawingOrderEnabled(viewGroup, b);
    }
}
