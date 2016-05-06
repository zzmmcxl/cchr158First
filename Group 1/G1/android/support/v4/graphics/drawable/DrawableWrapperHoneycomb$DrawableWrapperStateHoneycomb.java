package android.support.v4.graphics.drawable;

import android.graphics.drawable.Drawable;
import android.content.res.Resources;
import android.support.annotation.Nullable;

private static class DrawableWrapperStateHoneycomb extends DrawableWrapperState
{
    DrawableWrapperStateHoneycomb(@Nullable final DrawableWrapperState drawableWrapperState, @Nullable final Resources resources) {
        super(drawableWrapperState, resources);
    }
    
    @Override
    public Drawable newDrawable(@Nullable final Resources resources) {
        return new DrawableWrapperHoneycomb(this, resources);
    }
}
