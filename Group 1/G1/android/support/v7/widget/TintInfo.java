package android.support.v7.widget;

import android.graphics.PorterDuff$Mode;
import android.content.res.ColorStateList;

class TintInfo
{
    public boolean mHasTintList;
    public boolean mHasTintMode;
    public ColorStateList mTintList;
    public PorterDuff$Mode mTintMode;
    
    TintInfo() {
        super();
    }
    
    void clear() {
        mTintList = null;
        mHasTintList = false;
        mTintMode = null;
        mHasTintMode = false;
    }
}
