package android.support.design.widget;

import android.support.annotation.NonNull;

public abstract static class DragCallback
{
    public DragCallback() {
        super();
    }
    
    public abstract boolean canDrag(@NonNull final AppBarLayout p0);
}
