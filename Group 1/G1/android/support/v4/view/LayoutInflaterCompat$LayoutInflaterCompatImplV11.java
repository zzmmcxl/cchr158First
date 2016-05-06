package android.support.v4.view;

import android.view.LayoutInflater;

static class LayoutInflaterCompatImplV11 extends LayoutInflaterCompatImplBase
{
    LayoutInflaterCompatImplV11() {
        super();
    }
    
    @Override
    public void setFactory(final LayoutInflater layoutInflater, final LayoutInflaterFactory layoutInflaterFactory) {
        LayoutInflaterCompatHC.setFactory(layoutInflater, layoutInflaterFactory);
    }
}
