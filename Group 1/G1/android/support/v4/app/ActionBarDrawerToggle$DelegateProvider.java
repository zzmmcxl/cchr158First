package android.support.v4.app;

import android.support.annotation.Nullable;

public interface DelegateProvider
{
    @Nullable
    Delegate getDrawerToggleDelegate();
}
