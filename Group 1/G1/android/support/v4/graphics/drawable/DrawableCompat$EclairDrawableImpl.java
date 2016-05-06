package android.support.v4.graphics.drawable;

import android.graphics.drawable.Drawable;

static class EclairDrawableImpl extends BaseDrawableImpl
{
    EclairDrawableImpl() {
        super();
    }
    
    @Override
    public Drawable wrap(final Drawable drawable) {
        return DrawableCompatEclair.wrapForTinting(drawable);
    }
}
