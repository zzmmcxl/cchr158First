package android.support.v4.graphics;

import android.graphics.Bitmap;

class BitmapCompatHoneycombMr1
{
    BitmapCompatHoneycombMr1() {
        super();
    }
    
    static int getAllocationByteCount(final Bitmap bitmap) {
        return bitmap.getByteCount();
    }
}
