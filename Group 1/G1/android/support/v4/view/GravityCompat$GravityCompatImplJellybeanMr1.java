package android.support.v4.view;

import android.graphics.Rect;

static class GravityCompatImplJellybeanMr1 implements GravityCompatImpl
{
    GravityCompatImplJellybeanMr1() {
        super();
    }
    
    @Override
    public void apply(final int n, final int n2, final int n3, final Rect rect, final int n4, final int n5, final Rect rect2, final int n6) {
        GravityCompatJellybeanMr1.apply(n, n2, n3, rect, n4, n5, rect2, n6);
    }
    
    @Override
    public void apply(final int n, final int n2, final int n3, final Rect rect, final Rect rect2, final int n4) {
        GravityCompatJellybeanMr1.apply(n, n2, n3, rect, rect2, n4);
    }
    
    @Override
    public void applyDisplay(final int n, final Rect rect, final Rect rect2, final int n2) {
        GravityCompatJellybeanMr1.applyDisplay(n, rect, rect2, n2);
    }
    
    @Override
    public int getAbsoluteGravity(final int n, final int n2) {
        return GravityCompatJellybeanMr1.getAbsoluteGravity(n, n2);
    }
}
