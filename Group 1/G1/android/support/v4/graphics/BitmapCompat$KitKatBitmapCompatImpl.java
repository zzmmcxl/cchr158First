package android.support.v4.graphics;

import android.graphics.Bitmap;

static class KitKatBitmapCompatImpl extends JbMr2BitmapCompatImpl
{
    KitKatBitmapCompatImpl() {
        super();
    }
    
    @Override
    public int getAllocationByteCount(final Bitmap bitmap) {
        return BitmapCompatKitKat.getAllocationByteCount(bitmap);
    }
}
