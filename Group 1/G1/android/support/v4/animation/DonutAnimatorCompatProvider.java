package android.support.v4.animation;

import java.util.ArrayList;
import java.util.List;
import android.view.View;

class DonutAnimatorCompatProvider implements AnimatorProvider
{
    DonutAnimatorCompatProvider() {
        super();
    }
    
    @Override
    public void clearInterpolator(final View view) {
    }
    
    @Override
    public ValueAnimatorCompat emptyValueAnimator() {
        return new DonutFloatValueAnimator();
    }
}
