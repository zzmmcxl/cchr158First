package android.support.v4.graphics;

import android.graphics.Bitmap;

class BitmapCompatKitKat
{
    BitmapCompatKitKat() {
        super();
    }
    
    static int getAllocationByteCount(final Bitmap bitmap) {
        return bitmap.getAllocationByteCount();
    }
}
