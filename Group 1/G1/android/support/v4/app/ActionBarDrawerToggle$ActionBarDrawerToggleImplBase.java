package android.support.v4.app;

import android.graphics.drawable.Drawable;
import android.app.Activity;

private static class ActionBarDrawerToggleImplBase implements ActionBarDrawerToggleImpl
{
    private ActionBarDrawerToggleImplBase() {
        super();
    }
    
    ActionBarDrawerToggleImplBase(final ActionBarDrawerToggle$1 object) {
        this();
    }
    
    @Override
    public Drawable getThemeUpIndicator(final Activity activity) {
        return null;
    }
    
    @Override
    public Object setActionBarDescription(final Object o, final Activity activity, final int n) {
        return o;
    }
    
    @Override
    public Object setActionBarUpIndicator(final Object o, final Activity activity, final Drawable drawable, final int n) {
        return o;
    }
}
