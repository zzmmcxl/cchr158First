package android.support.v4.graphics.drawable;

import android.support.annotation.Nullable;
import android.support.annotation.NonNull;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

class DrawableWrapperKitKat extends DrawableWrapperHoneycomb
{
    DrawableWrapperKitKat(final Drawable drawable) {
        super(drawable);
    }
    
    DrawableWrapperKitKat(final DrawableWrapperState drawableWrapperState, final Resources resources) {
        super(drawableWrapperState, resources);
    }
    
    public boolean isAutoMirrored() {
        return this.mDrawable.isAutoMirrored();
    }
    
    @NonNull
    @Override
    DrawableWrapperState mutateConstantState() {
        return new DrawableWrapperStateKitKat(this.mState, null);
    }
    
    public void setAutoMirrored(final boolean autoMirrored) {
        this.mDrawable.setAutoMirrored(autoMirrored);
    }
}
