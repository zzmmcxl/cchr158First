package android.support.v4.graphics.drawable;

import android.support.annotation.Nullable;
import android.graphics.drawable.Drawable$ConstantState;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

class DrawableWrapperEclair extends DrawableWrapperDonut
{
    DrawableWrapperEclair(final Drawable drawable) {
        super(drawable);
    }
    
    DrawableWrapperEclair(final DrawableWrapperState drawableWrapperState, final Resources resources) {
        super(drawableWrapperState, resources);
    }
    
    @Override
    DrawableWrapperState mutateConstantState() {
        return new DrawableWrapperStateEclair(this.mState, null);
    }
    
    @Override
    protected Drawable newDrawableFromState(final Drawable$ConstantState drawable$ConstantState, final Resources resources) {
        return drawable$ConstantState.newDrawable(resources);
    }
}
