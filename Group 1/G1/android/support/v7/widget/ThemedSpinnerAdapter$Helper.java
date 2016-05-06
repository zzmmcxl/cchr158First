package android.support.v7.widget;

import android.support.v7.view.ContextThemeWrapper;
import android.support.annotation.Nullable;
import android.content.res.Resources$Theme;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.content.Context;

public static final class Helper
{
    private final Context mContext;
    private LayoutInflater mDropDownInflater;
    private final LayoutInflater mInflater;
    
    public Helper(@NonNull final Context mContext) {
        super();
        this.mContext = mContext;
        this.mInflater = LayoutInflater.from(mContext);
    }
    
    @NonNull
    public LayoutInflater getDropDownViewInflater() {
        if (mDropDownInflater != null) {
            return mDropDownInflater;
        }
        return mInflater;
    }
    
    @Nullable
    public Resources$Theme getDropDownViewTheme() {
        if (mDropDownInflater == null) {
            return null;
        }
        return mDropDownInflater.getContext().getTheme();
    }
    
    public void setDropDownViewTheme(@Nullable final Resources$Theme resources$Theme) {
        if (resources$Theme == null) {
            mDropDownInflater = null;
            return;
        }
        if (resources$Theme == mContext.getTheme()) {
            mDropDownInflater = mInflater;
            return;
        }
        mDropDownInflater = LayoutInflater.from((Context)new ContextThemeWrapper(mContext, resources$Theme));
    }
}
