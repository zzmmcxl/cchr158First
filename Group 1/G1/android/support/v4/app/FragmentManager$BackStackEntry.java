package android.support.v4.app;

import android.support.annotation.StringRes;

public interface BackStackEntry
{
    CharSequence getBreadCrumbShortTitle();
    
    @StringRes
    int getBreadCrumbShortTitleRes();
    
    CharSequence getBreadCrumbTitle();
    
    @StringRes
    int getBreadCrumbTitleRes();
    
    int getId();
    
    String getName();
}
