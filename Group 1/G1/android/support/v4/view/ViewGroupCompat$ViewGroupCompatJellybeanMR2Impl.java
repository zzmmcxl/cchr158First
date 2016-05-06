package android.support.v4.view;

import android.view.ViewGroup;

static class ViewGroupCompatJellybeanMR2Impl extends ViewGroupCompatIcsImpl
{
    ViewGroupCompatJellybeanMR2Impl() {
        super();
    }
    
    @Override
    public int getLayoutMode(final ViewGroup viewGroup) {
        return ViewGroupCompatJellybeanMR2.getLayoutMode(viewGroup);
    }
    
    @Override
    public void setLayoutMode(final ViewGroup viewGroup, final int n) {
        ViewGroupCompatJellybeanMR2.setLayoutMode(viewGroup, n);
    }
}
