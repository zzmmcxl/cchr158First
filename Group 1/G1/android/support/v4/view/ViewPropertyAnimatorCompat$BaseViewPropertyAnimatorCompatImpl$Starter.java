package android.support.v4.view;

import android.view.View;
import java.lang.ref.WeakReference;

class Starter implements Runnable
{
    WeakReference<View> mViewRef;
    ViewPropertyAnimatorCompat mVpa;
    final /* synthetic */ BaseViewPropertyAnimatorCompatImpl this$0;
    
    private Starter(final BaseViewPropertyAnimatorCompatImpl this$0, final ViewPropertyAnimatorCompat mVpa, final View view) {
        this$0 = this$0;
        super();
        mViewRef = new WeakReference<View>(view);
        mVpa = mVpa;
    }
    
    Starter(final BaseViewPropertyAnimatorCompatImpl baseViewPropertyAnimatorCompatImpl, final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final View view, final ViewPropertyAnimatorCompat$1 object) {
        this(baseViewPropertyAnimatorCompatImpl, viewPropertyAnimatorCompat, view);
    }
    
    @Override
    public void run() {
        final View view = (View)mViewRef.get();
        if (view != null) {
            BaseViewPropertyAnimatorCompatImpl.access$200(this$0, mVpa, view);
        }
    }
}
