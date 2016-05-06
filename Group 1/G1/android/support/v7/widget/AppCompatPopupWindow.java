package android.support.v7.widget;

import android.annotation.TargetApi;
import android.view.View;
import android.support.v4.widget.PopupWindowCompat;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import android.view.ViewTreeObserver$OnScrollChangedListener;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.content.Context;
import android.os.Build$VERSION;
import android.widget.PopupWindow;

public class AppCompatPopupWindow extends PopupWindow
{
    private static final boolean COMPAT_OVERLAP_ANCHOR = false;
    private static final String TAG = "AppCompatPopupWindow";
    private boolean mOverlapAnchor;
    
    public AppCompatPopupWindow(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        final TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, set, R.styleable.PopupWindow, n, 0);
        if (obtainStyledAttributes.hasValue(R.styleable.PopupWindow_overlapAnchor)) {
            this.setSupportOverlapAnchor(obtainStyledAttributes.getBoolean(R.styleable.PopupWindow_overlapAnchor, false));
        }
        this.setBackgroundDrawable(obtainStyledAttributes.getDrawable(R.styleable.PopupWindow_android_popupBackground));
        obtainStyledAttributes.recycle();
        if (Build$VERSION.SDK_INT < 14) {
            wrapOnScrollChangedListener(this);
        }
    }
    
    private static void wrapOnScrollChangedListener(final PopupWindow popupWindow) {
        try {
            final Field declaredField = PopupWindow.class.getDeclaredField("mAnchor");
            declaredField.setAccessible(true);
            final Field declaredField2 = PopupWindow.class.getDeclaredField("mOnScrollChangedListener");
            declaredField2.setAccessible(true);
            declaredField2.set(popupWindow, new ViewTreeObserver$OnScrollChangedListener() {
                final /* synthetic */ Field val$fieldAnchor;
                final /* synthetic */ ViewTreeObserver$OnScrollChangedListener val$originalListener = (ViewTreeObserver$OnScrollChangedListener)declaredField2.get(popupWindow);
                final /* synthetic */ PopupWindow val$popup;
                
                AppCompatPopupWindow$1() {
                    super();
                }
                
                public void onScrollChanged() {
                    try {
                        final WeakReference weakReference = (WeakReference)declaredField.get(popupWindow);
                        if (weakReference != null) {
                            if (weakReference.get() == null) {
                                return;
                            }
                            val$originalListener.onScrollChanged();
                        }
                    }
                    catch (IllegalAccessException ex) {}
                }
            });
        }
        catch (Exception ex) {
            Log.d("AppCompatPopupWindow", "Exception while installing workaround OnScrollChangedListener", (Throwable)ex);
        }
    }
    
    public boolean getSupportOverlapAnchor() {
        if (COMPAT_OVERLAP_ANCHOR) {
            return mOverlapAnchor;
        }
        return PopupWindowCompat.getOverlapAnchor(this);
    }
    
    public void setSupportOverlapAnchor(final boolean mOverlapAnchor) {
        if (COMPAT_OVERLAP_ANCHOR) {
            this.mOverlapAnchor = mOverlapAnchor;
            return;
        }
        PopupWindowCompat.setOverlapAnchor(this, mOverlapAnchor);
    }
    
    public void showAsDropDown(final View view, final int n, int n2) {
        if (COMPAT_OVERLAP_ANCHOR && mOverlapAnchor) {
            n2 -= view.getHeight();
        }
        super.showAsDropDown(view, n, n2);
    }
    
    @TargetApi(19)
    public void showAsDropDown(final View view, final int n, int n2, final int n3) {
        if (COMPAT_OVERLAP_ANCHOR && mOverlapAnchor) {
            n2 -= view.getHeight();
        }
        super.showAsDropDown(view, n, n2, n3);
    }
    
    public void update(final View view, final int n, int n2, final int n3, final int n4) {
        if (COMPAT_OVERLAP_ANCHOR && mOverlapAnchor) {
            n2 -= view.getHeight();
        }
        super.update(view, n, n2, n3, n4);
    }
}
