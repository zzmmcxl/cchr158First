package android.support.v7.view;

import android.support.v7.appcompat.R;
import android.support.annotation.StyleRes;
import android.content.Context;
import android.content.res.Resources$Theme;
import android.view.LayoutInflater;
import android.content.ContextWrapper;

public class ContextThemeWrapper extends ContextWrapper
{
    private LayoutInflater mInflater;
    private Resources$Theme mTheme;
    private int mThemeResource;
    
    public ContextThemeWrapper(final Context context, @StyleRes final int mThemeResource) {
        super(context);
        mThemeResource = mThemeResource;
    }
    
    public ContextThemeWrapper(final Context context, final Resources$Theme mTheme) {
        super(context);
        mTheme = mTheme;
    }
    
    private void initializeTheme() {
        final boolean b = mTheme == null;
        if (b) {
            mTheme = this.getResources().newTheme();
            final Resources$Theme theme = this.getBaseContext().getTheme();
            if (theme != null) {
                mTheme.setTo(theme);
            }
        }
        this.onApplyThemeResource(mTheme, mThemeResource, b);
    }
    
    public Object getSystemService(final String s) {
        if ("layout_inflater".equals(s)) {
            if (mInflater == null) {
                mInflater = LayoutInflater.from(this.getBaseContext()).cloneInContext((Context)this);
            }
            return mInflater;
        }
        return this.getBaseContext().getSystemService(s);
    }
    
    public Resources$Theme getTheme() {
        if (mTheme != null) {
            return mTheme;
        }
        if (mThemeResource == 0) {
            mThemeResource = R.style.Theme_AppCompat_Light;
        }
        this.initializeTheme();
        return mTheme;
    }
    
    public int getThemeResId() {
        return mThemeResource;
    }
    
    protected void onApplyThemeResource(final Resources$Theme resources$Theme, final int n, final boolean b) {
        resources$Theme.applyStyle(n, true);
    }
    
    public void setTheme(final int mThemeResource) {
        if (this.mThemeResource != mThemeResource) {
            this.mThemeResource = mThemeResource;
            this.initializeTheme();
        }
    }
}
