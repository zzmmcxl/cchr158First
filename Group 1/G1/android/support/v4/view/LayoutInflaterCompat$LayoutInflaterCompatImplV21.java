package android.support.v4.view;

import android.view.LayoutInflater;

static class LayoutInflaterCompatImplV21 extends LayoutInflaterCompatImplV11
{
    LayoutInflaterCompatImplV21() {
        super();
    }
    
    @Override
    public void setFactory(final LayoutInflater layoutInflater, final LayoutInflaterFactory layoutInflaterFactory) {
        LayoutInflaterCompatLollipop.setFactory(layoutInflater, layoutInflaterFactory);
    }
}
