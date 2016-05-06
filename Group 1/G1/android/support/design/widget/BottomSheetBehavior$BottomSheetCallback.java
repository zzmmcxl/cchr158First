package android.support.design.widget;

import android.support.annotation.NonNull;
import android.view.View;

public abstract static class BottomSheetCallback
{
    public BottomSheetCallback() {
        super();
    }
    
    public abstract void onSlide(@NonNull final View p0, final float p1);
    
    public abstract void onStateChanged(@NonNull final View p0, final int p1);
}
