package android.support.v7.app;

import android.support.annotation.Nullable;

public interface DelegateProvider
{
    @Nullable
    Delegate getDrawerToggleDelegate();
}
