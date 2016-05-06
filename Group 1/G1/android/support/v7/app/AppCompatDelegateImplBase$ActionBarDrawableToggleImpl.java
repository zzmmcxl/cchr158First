package android.support.v7.app;

import android.util.AttributeSet;
import android.support.v7.widget.TintTypedArray;
import android.support.v7.appcompat.R;
import android.graphics.drawable.Drawable;
import android.content.Context;

private class ActionBarDrawableToggleImpl implements Delegate
{
    final /* synthetic */ AppCompatDelegateImplBase this$0;
    
    private ActionBarDrawableToggleImpl(final AppCompatDelegateImplBase this$0) {
        this$0 = this$0;
        super();
    }
    
    ActionBarDrawableToggleImpl(final AppCompatDelegateImplBase appCompatDelegateImplBase, final AppCompatDelegateImplBase$1 object) {
        this(appCompatDelegateImplBase);
    }
    
    @Override
    public Context getActionBarThemedContext() {
        return this$0.getActionBarThemedContext();
    }
    
    @Override
    public Drawable getThemeUpIndicator() {
        final TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(this.getActionBarThemedContext(), null, new int[] { R.attr.homeAsUpIndicator });
        final Drawable drawable = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        return drawable;
    }
    
    @Override
    public boolean isNavigationVisible() {
        final ActionBar supportActionBar = this$0.getSupportActionBar();
        return supportActionBar != null && (0x4 & supportActionBar.getDisplayOptions()) != 0x0;
    }
    
    @Override
    public void setActionBarDescription(final int homeActionContentDescription) {
        final ActionBar supportActionBar = this$0.getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setHomeActionContentDescription(homeActionContentDescription);
        }
    }
    
    @Override
    public void setActionBarUpIndicator(final Drawable homeAsUpIndicator, final int homeActionContentDescription) {
        final ActionBar supportActionBar = this$0.getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setHomeAsUpIndicator(homeAsUpIndicator);
            supportActionBar.setHomeActionContentDescription(homeActionContentDescription);
        }
    }
}
