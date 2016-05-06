package android.support.v4.graphics;

import android.graphics.Bitmap;
import android.os.Build$VERSION;

public final class BitmapCompat
{
    static final BitmapImpl IMPL;
    
    static {
        final int sdk_INT = Build$VERSION.SDK_INT;
        if (sdk_INT >= 19) {
            IMPL = (BitmapImpl)new KitKatBitmapCompatImpl();
            return;
        }
        if (sdk_INT >= 18) {
            IMPL = (BitmapImpl)new JbMr2BitmapCompatImpl();
            return;
        }
        if (sdk_INT >= 12) {
            IMPL = (BitmapImpl)new HcMr1BitmapCompatImpl();
            return;
        }
        IMPL = (BitmapImpl)new BaseBitmapImpl();
    }
    
    private BitmapCompat() {
        super();
    }
    
    public static int getAllocationByteCount(final Bitmap bitmap) {
        return IMPL.getAllocationByteCount(bitmap);
    }
    
    public static boolean hasMipMap(final Bitmap bitmap) {
        return IMPL.hasMipMap(bitmap);
    }
    
    public static void setHasMipMap(final Bitmap bitmap, final boolean b) {
        IMPL.setHasMipMap(bitmap, b);
    }
}
