package android.support.v4.view;

import android.graphics.Paint;
import java.util.WeakHashMap;
import android.view.animation.Interpolator;
import android.os.Build$VERSION;
import android.view.View;
import java.lang.ref.WeakReference;

public final class ViewPropertyAnimatorCompat
{
    static final ViewPropertyAnimatorCompatImpl IMPL;
    static final int LISTENER_TAG_ID = 2113929216;
    private static final String TAG = "ViewAnimatorCompat";
    private Runnable mEndAction;
    private int mOldLayerType;
    private Runnable mStartAction;
    private WeakReference<View> mView;
    
    static {
        final int sdk_INT = Build$VERSION.SDK_INT;
        if (sdk_INT >= 21) {
            IMPL = (ViewPropertyAnimatorCompatImpl)new LollipopViewPropertyAnimatorCompatImpl();
            return;
        }
        if (sdk_INT >= 19) {
            IMPL = (ViewPropertyAnimatorCompatImpl)new KitKatViewPropertyAnimatorCompatImpl();
            return;
        }
        if (sdk_INT >= 18) {
            IMPL = (ViewPropertyAnimatorCompatImpl)new JBMr2ViewPropertyAnimatorCompatImpl();
            return;
        }
        if (sdk_INT >= 16) {
            IMPL = (ViewPropertyAnimatorCompatImpl)new JBViewPropertyAnimatorCompatImpl();
            return;
        }
        if (sdk_INT >= 14) {
            IMPL = (ViewPropertyAnimatorCompatImpl)new ICSViewPropertyAnimatorCompatImpl();
            return;
        }
        IMPL = (ViewPropertyAnimatorCompatImpl)new BaseViewPropertyAnimatorCompatImpl();
    }
    
    ViewPropertyAnimatorCompat(final View view) {
        super();
        mStartAction = null;
        mEndAction = null;
        mOldLayerType = -1;
        mView = new WeakReference<View>(view);
    }
    
    static /* synthetic */ Runnable access$000(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat) {
        return viewPropertyAnimatorCompat.mEndAction;
    }
    
    static /* synthetic */ Runnable access$002(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final Runnable mEndAction) {
        return viewPropertyAnimatorCompat.mEndAction = mEndAction;
    }
    
    static /* synthetic */ Runnable access$100(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat) {
        return viewPropertyAnimatorCompat.mStartAction;
    }
    
    static /* synthetic */ Runnable access$102(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final Runnable mStartAction) {
        return viewPropertyAnimatorCompat.mStartAction = mStartAction;
    }
    
    static /* synthetic */ int access$400(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat) {
        return viewPropertyAnimatorCompat.mOldLayerType;
    }
    
    static /* synthetic */ int access$402(final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, final int mOldLayerType) {
        return viewPropertyAnimatorCompat.mOldLayerType = mOldLayerType;
    }
    
    public ViewPropertyAnimatorCompat alpha(final float n) {
        final View view = (View)mView.get();
        if (view != null) {
            IMPL.alpha(this, view, n);
        }
        return this;
    }
    
    public ViewPropertyAnimatorCompat alphaBy(final float n) {
        final View view = (View)mView.get();
        if (view != null) {
            IMPL.alphaBy(this, view, n);
        }
        return this;
    }
    
    public void cancel() {
        final View view = (View)mView.get();
        if (view != null) {
            IMPL.cancel(this, view);
        }
    }
    
    public long getDuration() {
        final View view = (View)mView.get();
        if (view != null) {
            return IMPL.getDuration(this, view);
        }
        return 0L;
    }
    
    public Interpolator getInterpolator() {
        final View view = (View)mView.get();
        if (view != null) {
            return IMPL.getInterpolator(this, view);
        }
        return null;
    }
    
    public long getStartDelay() {
        final View view = (View)mView.get();
        if (view != null) {
            return IMPL.getStartDelay(this, view);
        }
        return 0L;
    }
    
    public ViewPropertyAnimatorCompat rotation(final float n) {
        final View view = (View)mView.get();
        if (view != null) {
            IMPL.rotation(this, view, n);
        }
        return this;
    }
    
    public ViewPropertyAnimatorCompat rotationBy(final float n) {
        final View view = (View)mView.get();
        if (view != null) {
            IMPL.rotationBy(this, view, n);
        }
        return this;
    }
    
    public ViewPropertyAnimatorCompat rotationX(final float n) {
        final View view = (View)mView.get();
        if (view != null) {
            IMPL.rotationX(this, view, n);
        }
        return this;
    }
    
    public ViewPropertyAnimatorCompat rotationXBy(final float n) {
        final View view = (View)mView.get();
        if (view != null) {
            IMPL.rotationXBy(this, view, n);
        }
        return this;
    }
    
    public ViewPropertyAnimatorCompat rotationY(final float n) {
        final View view = (View)mView.get();
        if (view != null) {
            IMPL.rotationY(this, view, n);
        }
        return this;
    }
    
    public ViewPropertyAnimatorCompat rotationYBy(final float n) {
        final View view = (View)mView.get();
        if (view != null) {
            IMPL.rotationYBy(this, view, n);
        }
        return this;
    }
    
    public ViewPropertyAnimatorCompat scaleX(final float n) {
        final View view = (View)mView.get();
        if (view != null) {
            IMPL.scaleX(this, view, n);
        }
        return this;
    }
    
    public ViewPropertyAnimatorCompat scaleXBy(final float n) {
        final View view = (View)mView.get();
        if (view != null) {
            IMPL.scaleXBy(this, view, n);
        }
        return this;
    }
    
    public ViewPropertyAnimatorCompat scaleY(final float n) {
        final View view = (View)mView.get();
        if (view != null) {
            IMPL.scaleY(this, view, n);
        }
        return this;
    }
    
    public ViewPropertyAnimatorCompat scaleYBy(final float n) {
        final View view = (View)mView.get();
        if (view != null) {
            IMPL.scaleYBy(this, view, n);
        }
        return this;
    }
    
    public ViewPropertyAnimatorCompat setDuration(final long n) {
        final View view = (View)mView.get();
        if (view != null) {
            IMPL.setDuration(this, view, n);
        }
        return this;
    }
    
    public ViewPropertyAnimatorCompat setInterpolator(final Interpolator interpolator) {
        final View view = (View)mView.get();
        if (view != null) {
            IMPL.setInterpolator(this, view, interpolator);
        }
        return this;
    }
    
    public ViewPropertyAnimatorCompat setListener(final ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        final View view = (View)mView.get();
        if (view != null) {
            IMPL.setListener(this, view, viewPropertyAnimatorListener);
        }
        return this;
    }
    
    public ViewPropertyAnimatorCompat setStartDelay(final long n) {
        final View view = (View)mView.get();
        if (view != null) {
            IMPL.setStartDelay(this, view, n);
        }
        return this;
    }
    
    public ViewPropertyAnimatorCompat setUpdateListener(final ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener) {
        final View view = (View)mView.get();
        if (view != null) {
            IMPL.setUpdateListener(this, view, viewPropertyAnimatorUpdateListener);
        }
        return this;
    }
    
    public void start() {
        final View view = (View)mView.get();
        if (view != null) {
            IMPL.start(this, view);
        }
    }
    
    public ViewPropertyAnimatorCompat translationX(final float n) {
        final View view = (View)mView.get();
        if (view != null) {
            IMPL.translationX(this, view, n);
        }
        return this;
    }
    
    public ViewPropertyAnimatorCompat translationXBy(final float n) {
        final View view = (View)mView.get();
        if (view != null) {
            IMPL.translationXBy(this, view, n);
        }
        return this;
    }
    
    public ViewPropertyAnimatorCompat translationY(final float n) {
        final View view = (View)mView.get();
        if (view != null) {
            IMPL.translationY(this, view, n);
        }
        return this;
    }
    
    public ViewPropertyAnimatorCompat translationYBy(final float n) {
        final View view = (View)mView.get();
        if (view != null) {
            IMPL.translationYBy(this, view, n);
        }
        return this;
    }
    
    public ViewPropertyAnimatorCompat translationZ(final float n) {
        final View view = (View)mView.get();
        if (view != null) {
            IMPL.translationZ(this, view, n);
        }
        return this;
    }
    
    public ViewPropertyAnimatorCompat translationZBy(final float n) {
        final View view = (View)mView.get();
        if (view != null) {
            IMPL.translationZBy(this, view, n);
        }
        return this;
    }
    
    public ViewPropertyAnimatorCompat withEndAction(final Runnable runnable) {
        final View view = (View)mView.get();
        if (view != null) {
            IMPL.withEndAction(this, view, runnable);
        }
        return this;
    }
    
    public ViewPropertyAnimatorCompat withLayer() {
        final View view = (View)mView.get();
        if (view != null) {
            IMPL.withLayer(this, view);
        }
        return this;
    }
    
    public ViewPropertyAnimatorCompat withStartAction(final Runnable runnable) {
        final View view = (View)mView.get();
        if (view != null) {
            IMPL.withStartAction(this, view, runnable);
        }
        return this;
    }
    
    public ViewPropertyAnimatorCompat x(final float n) {
        final View view = (View)mView.get();
        if (view != null) {
            IMPL.x(this, view, n);
        }
        return this;
    }
    
    public ViewPropertyAnimatorCompat xBy(final float n) {
        final View view = (View)mView.get();
        if (view != null) {
            IMPL.xBy(this, view, n);
        }
        return this;
    }
    
    public ViewPropertyAnimatorCompat y(final float n) {
        final View view = (View)mView.get();
        if (view != null) {
            IMPL.y(this, view, n);
        }
        return this;
    }
    
    public ViewPropertyAnimatorCompat yBy(final float n) {
        final View view = (View)mView.get();
        if (view != null) {
            IMPL.yBy(this, view, n);
        }
        return this;
    }
    
    public ViewPropertyAnimatorCompat z(final float n) {
        final View view = (View)mView.get();
        if (view != null) {
            IMPL.z(this, view, n);
        }
        return this;
    }
    
    public ViewPropertyAnimatorCompat zBy(final float n) {
        final View view = (View)mView.get();
        if (view != null) {
            IMPL.zBy(this, view, n);
        }
        return this;
    }
}
