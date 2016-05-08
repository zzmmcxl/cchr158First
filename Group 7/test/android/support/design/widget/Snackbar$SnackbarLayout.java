package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.R$dimen;
import android.support.design.R$id;
import android.support.design.R$layout;
import android.support.design.R$styleable;
import android.support.design.widget.Snackbar$SnackbarLayout$OnAttachStateChangeListener;
import android.support.design.widget.Snackbar$SnackbarLayout$OnLayoutChangeListener;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Snackbar$SnackbarLayout extends LinearLayout {
   private Button mActionView;
   private int mMaxInlineActionWidth;
   private int mMaxWidth;
   private TextView mMessageView;
   private Snackbar$SnackbarLayout$OnAttachStateChangeListener mOnAttachStateChangeListener;
   private Snackbar$SnackbarLayout$OnLayoutChangeListener mOnLayoutChangeListener;

   public Snackbar$SnackbarLayout(Context var1) {
      this(var1, (AttributeSet)null);
   }

   public Snackbar$SnackbarLayout(Context var1, AttributeSet var2) {
      super(var1, var2);
      TypedArray var3 = var1.obtainStyledAttributes(var2, R$styleable.SnackbarLayout);
      this.mMaxWidth = var3.getDimensionPixelSize(R$styleable.SnackbarLayout_android_maxWidth, -1);
      this.mMaxInlineActionWidth = var3.getDimensionPixelSize(R$styleable.SnackbarLayout_maxActionInlineWidth, -1);
      if(var3.hasValue(R$styleable.SnackbarLayout_elevation)) {
         ViewCompat.setElevation(this, (float)var3.getDimensionPixelSize(R$styleable.SnackbarLayout_elevation, 0));
      }

      var3.recycle();
      this.setClickable(true);
      LayoutInflater.from(var1).inflate(R$layout.design_layout_snackbar_include, this);
      ViewCompat.setAccessibilityLiveRegion(this, 1);
      ViewCompat.setImportantForAccessibility(this, 1);
   }

   private static void updateTopBottomPadding(View var0, int var1, int var2) {
      if(ViewCompat.isPaddingRelative(var0)) {
         ViewCompat.setPaddingRelative(var0, ViewCompat.getPaddingStart(var0), var1, ViewCompat.getPaddingEnd(var0), var2);
      } else {
         var0.setPadding(var0.getPaddingLeft(), var1, var0.getPaddingRight(), var2);
      }
   }

   private boolean updateViewsWithinLayout(int var1, int var2, int var3) {
      boolean var4 = false;
      if(var1 != this.getOrientation()) {
         this.setOrientation(var1);
         var4 = true;
      }

      if(this.mMessageView.getPaddingTop() != var2 || this.mMessageView.getPaddingBottom() != var3) {
         updateTopBottomPadding(this.mMessageView, var2, var3);
         var4 = true;
      }

      return var4;
   }

   void animateChildrenIn(int var1, int var2) {
      ViewCompat.setAlpha(this.mMessageView, 0.0F);
      ViewCompat.animate(this.mMessageView).alpha(1.0F).setDuration((long)var2).setStartDelay((long)var1).start();
      if(this.mActionView.getVisibility() == 0) {
         ViewCompat.setAlpha(this.mActionView, 0.0F);
         ViewCompat.animate(this.mActionView).alpha(1.0F).setDuration((long)var2).setStartDelay((long)var1).start();
      }

   }

   void animateChildrenOut(int var1, int var2) {
      ViewCompat.setAlpha(this.mMessageView, 1.0F);
      ViewCompat.animate(this.mMessageView).alpha(0.0F).setDuration((long)var2).setStartDelay((long)var1).start();
      if(this.mActionView.getVisibility() == 0) {
         ViewCompat.setAlpha(this.mActionView, 1.0F);
         ViewCompat.animate(this.mActionView).alpha(0.0F).setDuration((long)var2).setStartDelay((long)var1).start();
      }

   }

   Button getActionView() {
      return this.mActionView;
   }

   TextView getMessageView() {
      return this.mMessageView;
   }

   protected void onAttachedToWindow() {
      super.onAttachedToWindow();
      if(this.mOnAttachStateChangeListener != null) {
         this.mOnAttachStateChangeListener.onViewAttachedToWindow(this);
      }

   }

   protected void onDetachedFromWindow() {
      super.onDetachedFromWindow();
      if(this.mOnAttachStateChangeListener != null) {
         this.mOnAttachStateChangeListener.onViewDetachedFromWindow(this);
      }

   }

   protected void onFinishInflate() {
      super.onFinishInflate();
      this.mMessageView = (TextView)this.findViewById(R$id.snackbar_text);
      this.mActionView = (Button)this.findViewById(R$id.snackbar_action);
   }

   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      super.onLayout(var1, var2, var3, var4, var5);
      if(this.mOnLayoutChangeListener != null) {
         this.mOnLayoutChangeListener.onLayoutChange(this, var2, var3, var4, var5);
      }

   }

   protected void onMeasure(int var1, int var2) {
      super.onMeasure(var1, var2);
      int var3 = var1;
      if(this.mMaxWidth > 0) {
         var3 = var1;
         if(this.getMeasuredWidth() > this.mMaxWidth) {
            var3 = MeasureSpec.makeMeasureSpec(this.mMaxWidth, 1073741824);
            super.onMeasure(var3, var2);
         }
      }

      int var4 = this.getResources().getDimensionPixelSize(R$dimen.design_snackbar_padding_vertical_2lines);
      int var5 = this.getResources().getDimensionPixelSize(R$dimen.design_snackbar_padding_vertical);
      boolean var7;
      if(this.mMessageView.getLayout().getLineCount() > 1) {
         var7 = true;
      } else {
         var7 = false;
      }

      boolean var6 = false;
      if(var7 && this.mMaxInlineActionWidth > 0 && this.mActionView.getMeasuredWidth() > this.mMaxInlineActionWidth) {
         var7 = var6;
         if(this.updateViewsWithinLayout(1, var4, var4 - var5)) {
            var7 = true;
         }
      } else {
         if(!var7) {
            var4 = var5;
         }

         var7 = var6;
         if(this.updateViewsWithinLayout(0, var4, var4)) {
            var7 = true;
         }
      }

      if(var7) {
         super.onMeasure(var3, var2);
      }

   }

   void setOnAttachStateChangeListener(Snackbar$SnackbarLayout$OnAttachStateChangeListener var1) {
      this.mOnAttachStateChangeListener = var1;
   }

   void setOnLayoutChangeListener(Snackbar$SnackbarLayout$OnLayoutChangeListener var1) {
      this.mOnLayoutChangeListener = var1;
   }
}
