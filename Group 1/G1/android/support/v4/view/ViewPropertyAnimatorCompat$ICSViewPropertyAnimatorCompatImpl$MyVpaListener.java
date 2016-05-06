package android.support.v4.view;

import android.os.Build$VERSION;
import android.graphics.Paint;
import android.view.View;

static class MyVpaListener implements ViewPropertyAnimatorListener
{
    boolean mAnimEndCalled;
    ViewPropertyAnimatorCompat mVpa;
    
    MyVpaListener(final ViewPropertyAnimatorCompat mVpa) {
        super();
        this.mVpa = mVpa;
    }
    
    @Override
    public void onAnimationCancel(final View view) {
        final Object tag = view.getTag(2113929216);
        final boolean b = tag instanceof ViewPropertyAnimatorListener;
        ViewPropertyAnimatorListener viewPropertyAnimatorListener = null;
        if (b) {
            viewPropertyAnimatorListener = (ViewPropertyAnimatorListener)tag;
        }
        if (viewPropertyAnimatorListener != null) {
            viewPropertyAnimatorListener.onAnimationCancel(view);
        }
    }
    
    @Override
    public void onAnimationEnd(final View view) {
        if (ViewPropertyAnimatorCompat.access$400(mVpa) >= 0) {
            ViewCompat.setLayerType(view, ViewPropertyAnimatorCompat.access$400(mVpa), null);
            ViewPropertyAnimatorCompat.access$402(mVpa, -1);
        }
        if (Build$VERSION.SDK_INT >= 16 || !mAnimEndCalled) {
            if (ViewPropertyAnimatorCompat.access$000(mVpa) != null) {
                final Runnable access$000 = ViewPropertyAnimatorCompat.access$000(mVpa);
                ViewPropertyAnimatorCompat.access$002(mVpa, null);
                access$000.run();
            }
            final Object tag = view.getTag(2113929216);
            final boolean b = tag instanceof ViewPropertyAnimatorListener;
            ViewPropertyAnimatorListener viewPropertyAnimatorListener = null;
            if (b) {
                viewPropertyAnimatorListener = (ViewPropertyAnimatorListener)tag;
            }
            if (viewPropertyAnimatorListener != null) {
                viewPropertyAnimatorListener.onAnimationEnd(view);
            }
            mAnimEndCalled = true;
        }
    }
    
    @Override
    public void onAnimationStart(final View view) {
        mAnimEndCalled = false;
        if (ViewPropertyAnimatorCompat.access$400(mVpa) >= 0) {
            ViewCompat.setLayerType(view, 2, null);
        }
        if (ViewPropertyAnimatorCompat.access$100(mVpa) != null) {
            final Runnable access$100 = ViewPropertyAnimatorCompat.access$100(mVpa);
            ViewPropertyAnimatorCompat.access$102(mVpa, null);
            access$100.run();
        }
        final Object tag = view.getTag(2113929216);
        final boolean b = tag instanceof ViewPropertyAnimatorListener;
        ViewPropertyAnimatorListener viewPropertyAnimatorListener = null;
        if (b) {
            viewPropertyAnimatorListener = (ViewPropertyAnimatorListener)tag;
        }
        if (viewPropertyAnimatorListener != null) {
            viewPropertyAnimatorListener.onAnimationStart(view);
        }
    }
}
