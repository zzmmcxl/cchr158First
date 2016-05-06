package android.support.v4.graphics.drawable;

import android.support.v4.graphics.BitmapCompat;
import android.support.v4.view.GravityCompat;
import android.graphics.Rect;
import android.graphics.Bitmap;
import android.content.res.Resources;

private static class DefaultRoundedBitmapDrawable extends RoundedBitmapDrawable
{
    DefaultRoundedBitmapDrawable(final Resources resources, final Bitmap bitmap) {
        super(resources, bitmap);
    }
    
    @Override
    void gravityCompatApply(final int n, final int n2, final int n3, final Rect rect, final Rect rect2) {
        GravityCompat.apply(n, n2, n3, rect, rect2, 0);
    }
    
    @Override
    public boolean hasMipMap() {
        return this.mBitmap != null && BitmapCompat.hasMipMap(this.mBitmap);
    }
    
    @Override
    public void setMipMap(final boolean b) {
        if (this.mBitmap != null) {
            BitmapCompat.setHasMipMap(this.mBitmap, b);
            this.invalidateSelf();
        }
    }
}
