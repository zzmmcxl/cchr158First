package android.support.v4.widget;

import android.view.animation.Transformation;
import android.view.animation.Animation;

class MaterialProgressDrawable$1 extends Animation {
    final /* synthetic */ MaterialProgressDrawable this$0;
    final /* synthetic */ Ring val$ring;
    
    MaterialProgressDrawable$1(final MaterialProgressDrawable this$0, final Ring val$ring) {
        this$0 = this$0;
        val$ring = val$ring;
        super();
    }
    
    public void applyTransformation(final float n, final Transformation transformation) {
        if (mFinishing) {
            MaterialProgressDrawable.access$000(this$0, n, val$ring);
            return;
        }
        final float access$100 = MaterialProgressDrawable.access$100(this$0, val$ring);
        final float startingEndTrim = val$ring.getStartingEndTrim();
        final float startingStartTrim = val$ring.getStartingStartTrim();
        final float startingRotation = val$ring.getStartingRotation();
        MaterialProgressDrawable.access$200(this$0, n, val$ring);
        if (n <= 0.5f) {
            val$ring.setStartTrim(startingStartTrim + (0.8f - access$100) * MaterialProgressDrawable.access$300().getInterpolation(n / 0.5f));
        }
        if (n > 0.5f) {
            val$ring.setEndTrim(startingEndTrim + (0.8f - access$100) * MaterialProgressDrawable.access$300().getInterpolation((n - 0.5f) / 0.5f));
        }
        val$ring.setRotation(startingRotation + 0.25f * n);
        this$0.setRotation(216.0f * n + 1080.0f * (MaterialProgressDrawable.access$400(this$0) / 5.0f));
    }
}