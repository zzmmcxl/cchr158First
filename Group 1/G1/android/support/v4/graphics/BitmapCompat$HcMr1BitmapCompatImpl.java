package android.support.v4.graphics;

import android.graphics.Bitmap;

static class HcMr1BitmapCompatImpl extends BaseBitmapImpl
{
    HcMr1BitmapCompatImpl() {
        super();
    }
    
    @Override
    public int getAllocationByteCount(final Bitmap bitmap) {
        return BitmapCompatHoneycombMr1.getAllocationByteCount(bitmap);
    }
}
