package android.support.v4.graphics;

import android.graphics.Bitmap;

class BitmapCompatJellybeanMR2
{
    BitmapCompatJellybeanMR2() {
        super();
    }
    
    public static boolean hasMipMap(final Bitmap bitmap) {
        return bitmap.hasMipMap();
    }
    
    public static void setHasMipMap(final Bitmap bitmap, final boolean hasMipMap) {
        bitmap.setHasMipMap(hasMipMap);
    }
}
