package android.support.v4.app;

import android.support.annotation.Nullable;
import android.view.View;
import android.support.annotation.IdRes;

public abstract class FragmentContainer
{
    public FragmentContainer() {
        super();
    }
    
    @Nullable
    public abstract View onFindViewById(@IdRes final int p0);
    
    public abstract boolean onHasView();
}
