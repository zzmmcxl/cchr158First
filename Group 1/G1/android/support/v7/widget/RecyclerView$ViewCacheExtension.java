package android.support.v7.widget;

import android.view.View;

public abstract static class ViewCacheExtension
{
    public ViewCacheExtension() {
        super();
    }
    
    public abstract View getViewForPositionAndType(final Recycler p0, final int p1, final int p2);
}
