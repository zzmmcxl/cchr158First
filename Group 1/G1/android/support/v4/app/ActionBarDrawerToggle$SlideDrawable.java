package android.support.v4.app;

import android.support.v4.view.ViewCompat;
import android.graphics.Canvas;
import android.os.Build$VERSION;
import android.graphics.drawable.Drawable;
import android.graphics.Rect;
import android.graphics.drawable.Drawable$Callback;
import android.graphics.drawable.InsetDrawable;

private class SlideDrawable extends InsetDrawable implements Drawable$Callback
{
    private final boolean mHasMirroring;
    private float mOffset;
    private float mPosition;
    private final Rect mTmpRect;
    final /* synthetic */ ActionBarDrawerToggle this$0;
    
    private SlideDrawable(final ActionBarDrawerToggle this$0, final Drawable drawable) {
        this$0 = this$0;
        super(drawable, 0);
        final int sdk_INT = Build$VERSION.SDK_INT;
        boolean mHasMirroring = false;
        if (sdk_INT > 18) {
            mHasMirroring = true;
        }
        this.mHasMirroring = mHasMirroring;
        mTmpRect = new Rect();
    }
    
    SlideDrawable(final ActionBarDrawerToggle actionBarDrawerToggle, final Drawable drawable, final ActionBarDrawerToggle$1 object) {
        this(actionBarDrawerToggle, drawable);
    }
    
    public void draw(final Canvas canvas) {
        int n = 1;
        this.copyBounds(mTmpRect);
        canvas.save();
        int n2;
        if (ViewCompat.getLayoutDirection(ActionBarDrawerToggle.access$400(this$0).getWindow().getDecorView()) == n) {
            n2 = n;
        }
        else {
            n2 = 0;
        }
        if (n2 != 0) {
            n = -1;
        }
        final int width = mTmpRect.width();
        canvas.translate(-mOffset * width * mPosition * (float)n, 0.0f);
        if (n2 != 0 && !mHasMirroring) {
            canvas.translate((float)width, 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        super.draw(canvas);
        canvas.restore();
    }
    
    public float getPosition() {
        return mPosition;
    }
    
    public void setOffset(final float mOffset) {
        this.mOffset = mOffset;
        this.invalidateSelf();
    }
    
    public void setPosition(final float mPosition) {
        this.mPosition = mPosition;
        this.invalidateSelf();
    }
}
