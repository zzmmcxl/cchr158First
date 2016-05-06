package android.support.v4.view;

import android.view.ViewGroup;

static class ViewGroupCompatHCImpl extends ViewGroupCompatStubImpl
{
    ViewGroupCompatHCImpl() {
        super();
    }
    
    @Override
    public void setMotionEventSplittingEnabled(final ViewGroup viewGroup, final boolean b) {
        ViewGroupCompatHC.setMotionEventSplittingEnabled(viewGroup, b);
    }
}
