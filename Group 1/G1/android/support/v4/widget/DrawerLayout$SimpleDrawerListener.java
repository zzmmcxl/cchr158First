package android.support.v4.widget;

import android.view.View;

public abstract static class SimpleDrawerListener implements DrawerListener
{
    public SimpleDrawerListener() {
        super();
    }
    
    @Override
    public void onDrawerClosed(final View view) {
    }
    
    @Override
    public void onDrawerOpened(final View view) {
    }
    
    @Override
    public void onDrawerSlide(final View view, final float n) {
    }
    
    @Override
    public void onDrawerStateChanged(final int n) {
    }
}
