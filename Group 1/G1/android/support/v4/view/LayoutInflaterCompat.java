package android.support.v4.view;

import android.view.LayoutInflater;
import android.os.Build$VERSION;

public final class LayoutInflaterCompat
{
    static final LayoutInflaterCompatImpl IMPL;
    
    static {
        final int sdk_INT = Build$VERSION.SDK_INT;
        if (sdk_INT >= 21) {
            IMPL = (LayoutInflaterCompatImpl)new LayoutInflaterCompatImplV21();
            return;
        }
        if (sdk_INT >= 11) {
            IMPL = (LayoutInflaterCompatImpl)new LayoutInflaterCompatImplV11();
            return;
        }
        IMPL = (LayoutInflaterCompatImpl)new LayoutInflaterCompatImplBase();
    }
    
    private LayoutInflaterCompat() {
        super();
    }
    
    public static LayoutInflaterFactory getFactory(final LayoutInflater layoutInflater) {
        return IMPL.getFactory(layoutInflater);
    }
    
    public static void setFactory(final LayoutInflater layoutInflater, final LayoutInflaterFactory layoutInflaterFactory) {
        IMPL.setFactory(layoutInflater, layoutInflaterFactory);
    }
}
