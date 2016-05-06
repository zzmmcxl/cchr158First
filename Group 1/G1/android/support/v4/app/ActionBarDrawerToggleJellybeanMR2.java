package android.support.v4.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.app.ActionBar;
import android.util.AttributeSet;
import android.graphics.drawable.Drawable;
import android.app.Activity;

class ActionBarDrawerToggleJellybeanMR2
{
    private static final String TAG = "ActionBarDrawerToggleImplJellybeanMR2";
    private static final int[] THEME_ATTRS;
    
    static {
        THEME_ATTRS = new int[] { 16843531 };
    }
    
    ActionBarDrawerToggleJellybeanMR2() {
        super();
    }
    
    public static Drawable getThemeUpIndicator(final Activity activity) {
        final ActionBar actionBar = activity.getActionBar();
        Object themedContext;
        if (actionBar != null) {
            themedContext = actionBar.getThemedContext();
        }
        else {
            themedContext = activity;
        }
        final TypedArray obtainStyledAttributes = ((Context)themedContext).obtainStyledAttributes((AttributeSet)null, THEME_ATTRS, 16843470, 0);
        final Drawable drawable = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        return drawable;
    }
    
    public static Object setActionBarDescription(final Object o, final Activity activity, final int homeActionContentDescription) {
        final ActionBar actionBar = activity.getActionBar();
        if (actionBar != null) {
            actionBar.setHomeActionContentDescription(homeActionContentDescription);
        }
        return o;
    }
    
    public static Object setActionBarUpIndicator(final Object o, final Activity activity, final Drawable homeAsUpIndicator, final int homeActionContentDescription) {
        final ActionBar actionBar = activity.getActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(homeAsUpIndicator);
            actionBar.setHomeActionContentDescription(homeActionContentDescription);
        }
        return o;
    }
}
