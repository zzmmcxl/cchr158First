package android.support.v4.widget;

import android.graphics.Canvas;
import android.content.Context;
import android.os.Build$VERSION;

public final class EdgeEffectCompat
{
    private static final EdgeEffectImpl IMPL;
    private Object mEdgeEffect;
    
    static {
        if (Build$VERSION.SDK_INT >= 21) {
            IMPL = (EdgeEffectImpl)new EdgeEffectLollipopImpl();
            return;
        }
        if (Build$VERSION.SDK_INT >= 14) {
            IMPL = (EdgeEffectImpl)new EdgeEffectIcsImpl();
            return;
        }
        IMPL = (EdgeEffectImpl)new BaseEdgeEffectImpl();
    }
    
    public EdgeEffectCompat(final Context context) {
        super();
        mEdgeEffect = IMPL.newEdgeEffect(context);
    }
    
    public boolean draw(final Canvas canvas) {
        return IMPL.draw(mEdgeEffect, canvas);
    }
    
    public void finish() {
        IMPL.finish(mEdgeEffect);
    }
    
    public boolean isFinished() {
        return IMPL.isFinished(mEdgeEffect);
    }
    
    public boolean onAbsorb(final int n) {
        return IMPL.onAbsorb(mEdgeEffect, n);
    }
    
    public boolean onPull(final float n) {
        return IMPL.onPull(mEdgeEffect, n);
    }
    
    public boolean onPull(final float n, final float n2) {
        return IMPL.onPull(mEdgeEffect, n, n2);
    }
    
    public boolean onRelease() {
        return IMPL.onRelease(mEdgeEffect);
    }
    
    public void setSize(final int n, final int n2) {
        IMPL.setSize(mEdgeEffect, n, n2);
    }
}
