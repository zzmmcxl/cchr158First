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
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;

class AppCompatDelegateImplV7$ActionModeCallbackWrapperV7$1 extends ViewPropertyAnimatorListenerAdapter {
    final /* synthetic */ ActionModeCallbackWrapperV7 this$1;
    
    AppCompatDelegateImplV7$ActionModeCallbackWrapperV7$1(final ActionModeCallbackWrapperV7 this$1) {
        this$1 = this$1;
        super();
    }
    
    @Override
    public void onAnimationEnd(final View view) {
        mActionModeView.setVisibility(8);
        if (mActionModePopup != null) {
            mActionModePopup.dismiss();
        }
        else if (mActionModeView.getParent() instanceof View) {
            ViewCompat.requestApplyInsets((View)mActionModeView.getParent());
        }
        mActionModeView.removeAllViews();
        mFadeAnim.setListener(null);
        mFadeAnim = null;
    }
}