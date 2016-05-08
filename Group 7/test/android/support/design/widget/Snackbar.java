package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Handler;
import android.os.Looper;
import android.os.Build.VERSION;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.design.R$anim;
import android.support.design.R$layout;
import android.support.design.widget.AnimationUtils;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.CoordinatorLayout$LayoutParams;
import android.support.design.widget.Snackbar$1;
import android.support.design.widget.Snackbar$10;
import android.support.design.widget.Snackbar$2;
import android.support.design.widget.Snackbar$3;
import android.support.design.widget.Snackbar$4;
import android.support.design.widget.Snackbar$5;
import android.support.design.widget.Snackbar$6;
import android.support.design.widget.Snackbar$7;
import android.support.design.widget.Snackbar$8;
import android.support.design.widget.Snackbar$9;
import android.support.design.widget.Snackbar$Behavior;
import android.support.design.widget.Snackbar$Callback;
import android.support.design.widget.Snackbar$SnackbarLayout;
import android.support.design.widget.SnackbarManager;
import android.support.design.widget.SnackbarManager$Callback;
import android.support.design.widget.ThemeUtils;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.FrameLayout;

public final class Snackbar {
   static final int ANIMATION_DURATION = 250;
   static final int ANIMATION_FADE_DURATION = 180;
   public static final int LENGTH_INDEFINITE = -2;
   public static final int LENGTH_LONG = 0;
   public static final int LENGTH_SHORT = -1;
   private static final int MSG_DISMISS = 1;
   private static final int MSG_SHOW = 0;
   private static final Handler sHandler = new Handler(Looper.getMainLooper(), new Snackbar$1());
   private final AccessibilityManager mAccessibilityManager;
   private Snackbar$Callback mCallback;
   private final Context mContext;
   private int mDuration;
   private final SnackbarManager$Callback mManagerCallback = new Snackbar$3(this);
   private final ViewGroup mTargetParent;
   private final Snackbar$SnackbarLayout mView;

   private Snackbar(ViewGroup var1) {
      this.mTargetParent = var1;
      this.mContext = var1.getContext();
      ThemeUtils.checkAppCompatTheme(this.mContext);
      this.mView = (Snackbar$SnackbarLayout)LayoutInflater.from(this.mContext).inflate(R$layout.design_layout_snackbar, this.mTargetParent, false);
      this.mAccessibilityManager = (AccessibilityManager)this.mContext.getSystemService("accessibility");
   }

   private void animateViewIn() {
      if(VERSION.SDK_INT >= 14) {
         ViewCompat.setTranslationY(this.mView, (float)this.mView.getHeight());
         ViewCompat.animate(this.mView).translationY(0.0F).setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR).setDuration(250L).setListener(new Snackbar$7(this)).start();
      } else {
         Animation var1 = android.view.animation.AnimationUtils.loadAnimation(this.mView.getContext(), R$anim.design_snackbar_in);
         var1.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
         var1.setDuration(250L);
         var1.setAnimationListener(new Snackbar$8(this));
         this.mView.startAnimation(var1);
      }
   }

   private void animateViewOut(int var1) {
      if(VERSION.SDK_INT >= 14) {
         ViewCompat.animate(this.mView).translationY((float)this.mView.getHeight()).setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR).setDuration(250L).setListener(new Snackbar$9(this, var1)).start();
      } else {
         Animation var2 = android.view.animation.AnimationUtils.loadAnimation(this.mView.getContext(), R$anim.design_snackbar_out);
         var2.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
         var2.setDuration(250L);
         var2.setAnimationListener(new Snackbar$10(this, var1));
         this.mView.startAnimation(var2);
      }
   }

   private void dispatchDismiss(int var1) {
      SnackbarManager.getInstance().dismiss(this.mManagerCallback, var1);
   }

   private static ViewGroup findSuitableParent(View var0) {
      ViewGroup var3 = null;
      View var2 = var0;

      ViewGroup var1;
      do {
         if(var2 instanceof CoordinatorLayout) {
            return (ViewGroup)var2;
         }

         var1 = var3;
         if(var2 instanceof FrameLayout) {
            if(var2.getId() == 16908290) {
               return (ViewGroup)var2;
            }

            var1 = (ViewGroup)var2;
         }

         var0 = var2;
         if(var2 != null) {
            ViewParent var4 = var2.getParent();
            if(var4 instanceof View) {
               var0 = (View)var4;
            } else {
               var0 = null;
            }
         }

         var3 = var1;
         var2 = var0;
      } while(var0 != null);

      return var1;
   }

   @NonNull
   public static Snackbar make(@NonNull View var0, @StringRes int var1, int var2) {
      return make(var0, var0.getResources().getText(var1), var2);
   }

   @NonNull
   public static Snackbar make(@NonNull View var0, @NonNull CharSequence var1, int var2) {
      Snackbar var3 = new Snackbar(findSuitableParent(var0));
      var3.setText(var1);
      var3.setDuration(var2);
      return var3;
   }

   private void onViewHidden(int var1) {
      SnackbarManager.getInstance().onDismissed(this.mManagerCallback);
      if(this.mCallback != null) {
         this.mCallback.onDismissed(this, var1);
      }

      ViewParent var2 = this.mView.getParent();
      if(var2 instanceof ViewGroup) {
         ((ViewGroup)var2).removeView(this.mView);
      }

   }

   private void onViewShown() {
      SnackbarManager.getInstance().onShown(this.mManagerCallback);
      if(this.mCallback != null) {
         this.mCallback.onShown(this);
      }

   }

   public void dismiss() {
      this.dispatchDismiss(3);
   }

   public int getDuration() {
      return this.mDuration;
   }

   @NonNull
   public View getView() {
      return this.mView;
   }

   final void hideView(int var1) {
      if(this.mView.getVisibility() != 0) {
         this.onViewHidden(var1);
      } else {
         this.animateViewOut(var1);
      }
   }

   public boolean isShown() {
      return SnackbarManager.getInstance().isCurrent(this.mManagerCallback);
   }

   public boolean isShownOrQueued() {
      return SnackbarManager.getInstance().isCurrentOrNext(this.mManagerCallback);
   }

   @NonNull
   public Snackbar setAction(@StringRes int var1, OnClickListener var2) {
      return this.setAction(this.mContext.getText(var1), var2);
   }

   @NonNull
   public Snackbar setAction(CharSequence var1, OnClickListener var2) {
      Button var3 = this.mView.getActionView();
      if(!TextUtils.isEmpty(var1) && var2 != null) {
         var3.setVisibility(0);
         var3.setText(var1);
         var3.setOnClickListener(new Snackbar$2(this, var2));
         return this;
      } else {
         var3.setVisibility(8);
         var3.setOnClickListener((OnClickListener)null);
         return this;
      }
   }

   @NonNull
   public Snackbar setActionTextColor(@ColorInt int var1) {
      this.mView.getActionView().setTextColor(var1);
      return this;
   }

   @NonNull
   public Snackbar setActionTextColor(ColorStateList var1) {
      this.mView.getActionView().setTextColor(var1);
      return this;
   }

   @NonNull
   public Snackbar setCallback(Snackbar$Callback var1) {
      this.mCallback = var1;
      return this;
   }

   @NonNull
   public Snackbar setDuration(int var1) {
      this.mDuration = var1;
      return this;
   }

   @NonNull
   public Snackbar setText(@StringRes int var1) {
      return this.setText(this.mContext.getText(var1));
   }

   @NonNull
   public Snackbar setText(@NonNull CharSequence var1) {
      this.mView.getMessageView().setText(var1);
      return this;
   }

   public void show() {
      SnackbarManager.getInstance().show(this.mDuration, this.mManagerCallback);
   }

   final void showView() {
      if(this.mView.getParent() == null) {
         LayoutParams var1 = this.mView.getLayoutParams();
         if(var1 instanceof CoordinatorLayout$LayoutParams) {
            Snackbar$Behavior var2 = new Snackbar$Behavior(this);
            var2.setStartAlphaSwipeDistance(0.1F);
            var2.setEndAlphaSwipeDistance(0.6F);
            var2.setSwipeDirection(0);
            var2.setListener(new Snackbar$4(this));
            ((CoordinatorLayout$LayoutParams)var1).setBehavior(var2);
         }

         this.mTargetParent.addView(this.mView);
      }

      this.mView.setOnAttachStateChangeListener(new Snackbar$5(this));
      if(ViewCompat.isLaidOut(this.mView)) {
         this.animateViewIn();
      } else {
         this.mView.setOnLayoutChangeListener(new Snackbar$6(this));
      }
   }
}
