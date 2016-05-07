package android.support.v4.graphics.drawable;

import android.support.annotation.Nullable;
import android.support.annotation.NonNull;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

class DrawableWrapperHoneycomb extends DrawableWrapperDonut
{
    DrawableWrapperHoneycomb(final Drawable drawable) {
        super(drawable);
    }
    
    DrawableWrapperHoneycomb(final DrawableWrapperState drawableWrapperState, final Resources resources) {
        super(drawableWrapperState, resources);
    }
    
    public void jumpToCurrentState() {
        this.mDrawable.jumpToCurrentState();
    }
    
    @NonNull
    @Override
    DrawableWrapperState mutateConstantState() {
        return new DrawableWrapperStateHoneycomb(this.mState, null);
    }
}