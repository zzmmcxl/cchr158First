package android.support.v4.view;

import android.view.LayoutInflater;

static class LayoutInflaterCompatImplBase implements LayoutInflaterCompatImpl
{
    LayoutInflaterCompatImplBase() {
        super();
    }
    
    @Override
    public LayoutInflaterFactory getFactory(final LayoutInflater layoutInflater) {
        return LayoutInflaterCompatBase.getFactory(layoutInflater);
    }
    
    @Override
    public void setFactory(final LayoutInflater layoutInflater, final LayoutInflaterFactory layoutInflaterFactory) {
        LayoutInflaterCompatBase.setFactory(layoutInflater, layoutInflaterFactory);
    }
}
