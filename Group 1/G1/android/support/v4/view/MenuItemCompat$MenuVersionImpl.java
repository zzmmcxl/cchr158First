package android.support.v4.view;

import android.view.View;
import android.view.MenuItem;

interface MenuVersionImpl
{
    boolean collapseActionView(final MenuItem p0);
    
    boolean expandActionView(final MenuItem p0);
    
    View getActionView(final MenuItem p0);
    
    boolean isActionViewExpanded(final MenuItem p0);
    
    MenuItem setActionView(final MenuItem p0, final int p1);
    
    MenuItem setActionView(final MenuItem p0, final View p1);
    
    MenuItem setOnActionExpandListener(final MenuItem p0, final OnActionExpandListener p1);
    
    void setShowAsAction(final MenuItem p0, final int p1);
}
