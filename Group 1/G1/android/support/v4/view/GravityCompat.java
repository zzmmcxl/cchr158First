package android.support.v4.view;

import android.view.Gravity;
import android.graphics.Rect;
import android.os.Build$VERSION;

public final class GravityCompat
{
    public static final int END = 8388613;
    static final GravityCompatImpl IMPL;
    public static final int RELATIVE_HORIZONTAL_GRAVITY_MASK = 8388615;
    public static final int RELATIVE_LAYOUT_DIRECTION = 8388608;
    public static final int START = 8388611;
    
    static {
        if (Build$VERSION.SDK_INT >= 17) {
            IMPL = (GravityCompatImpl)new GravityCompatImplJellybeanMr1();
            return;
        }
        IMPL = (GravityCompatImpl)new GravityCompatImplBase();
    }
    
    private GravityCompat() {
        super();
    }
    
    public static void apply(final int n, final int n2, final int n3, final Rect rect, final int n4, final int n5, final Rect rect2, final int n6) {
        IMPL.apply(n, n2, n3, rect, n4, n5, rect2, n6);
    }
    
    public static void apply(final int n, final int n2, final int n3, final Rect rect, final Rect rect2, final int n4) {
        IMPL.apply(n, n2, n3, rect, rect2, n4);
    }
    
    public static void applyDisplay(final int n, final Rect rect, final Rect rect2, final int n2) {
        IMPL.applyDisplay(n, rect, rect2, n2);
    }
    
    public static int getAbsoluteGravity(final int n, final int n2) {
        return IMPL.getAbsoluteGravity(n, n2);
    }
}
