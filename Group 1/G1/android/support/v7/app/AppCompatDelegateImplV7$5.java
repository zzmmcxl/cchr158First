package android.support.v7.app;

import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.view.View$MeasureSpec;
import android.support.v7.widget.ViewUtils;
import android.os.Build$VERSION;
import android.view.accessibility.AccessibilityEvent;
import android.view.MotionEvent;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.ActionMenuView;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.widget.ActionMenuPresenter;
import android.support.v7.view.menu.MenuBuilder;
import android.view.View$OnClickListener;
import android.support.v7.view.ActionMode;
import android.view.ViewGroup$MarginLayoutParams;
import android.view.ViewGroup$LayoutParams;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.support.v7.widget.TintTypedArray;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.support.v7.widget.AbsActionBarView;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v4.view.ViewCompat;
import android.view.View;

class AppCompatDelegateImplV7$5 implements Runnable {
    final /* synthetic */ AppCompatDelegateImplV7 this$0;
    
    AppCompatDelegateImplV7$5(final AppCompatDelegateImplV7 this$0) {
        this$0 = this$0;
        super();
    }
    
    @Override
    public void run() {
        mActionModePopup.showAtLocation((View)mActionModeView, 55, 0, 0);
        AppCompatDelegateImplV7.access$500(this$0);
        ViewCompat.setAlpha((View)mActionModeView, 0.0f);
        (mFadeAnim = ViewCompat.animate((View)mActionModeView).alpha(1.0f)).setListener(new ViewPropertyAnimatorListenerAdapter() {
            final /* synthetic */ AppCompatDelegateImplV7$5 this$1;
            
            AppCompatDelegateImplV7$5$1() {
                this$1 = this$1;
                super();
            }
            
            @Override
            public void onAnimationEnd(final View view) {
                ViewCompat.setAlpha((View)mActionModeView, 1.0f);
                mFadeAnim.setListener(null);
                mFadeAnim = null;
            }
            
            @Override
            public void onAnimationStart(final View view) {
                mActionModeView.setVisibility(0);
            }
        });
    }
}