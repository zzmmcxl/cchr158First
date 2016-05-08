package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.AppCompatSpinner$DropdownPopup$1;
import android.support.v7.widget.AppCompatSpinner$DropdownPopup$2;
import android.support.v7.widget.AppCompatSpinner$DropdownPopup$3;
import android.support.v7.widget.ListPopupWindow;
import android.support.v7.widget.ViewUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ListAdapter;
import android.widget.SpinnerAdapter;

class AppCompatSpinner$DropdownPopup extends ListPopupWindow {
   private ListAdapter mAdapter;
   private CharSequence mHintText;
   private final Rect mVisibleRect;

   public AppCompatSpinner$DropdownPopup(AppCompatSpinner var1, Context var2, AttributeSet var3, int var4) {
      super(var2, var3, var4);
      this.this$0 = var1;
      this.mVisibleRect = new Rect();
      this.setAnchorView(var1);
      this.setModal(true);
      this.setPromptPosition(0);
      this.setOnItemClickListener(new AppCompatSpinner$DropdownPopup$1(this, var1));
   }

   private boolean isVisibleToUser(View var1) {
      return ViewCompat.isAttachedToWindow(var1) && var1.getGlobalVisibleRect(this.mVisibleRect);
   }

   void computeContentWidth() {
      Drawable var8 = this.getBackground();
      int var1 = 0;
      if(var8 != null) {
         var8.getPadding(AppCompatSpinner.access$300(this.this$0));
         if(ViewUtils.isLayoutRtl(this.this$0)) {
            var1 = AppCompatSpinner.access$300(this.this$0).right;
         } else {
            var1 = -AppCompatSpinner.access$300(this.this$0).left;
         }
      } else {
         Rect var9 = AppCompatSpinner.access$300(this.this$0);
         AppCompatSpinner.access$300(this.this$0).right = 0;
         var9.left = 0;
      }

      int var5 = this.this$0.getPaddingLeft();
      int var6 = this.this$0.getPaddingRight();
      int var7 = this.this$0.getWidth();
      if(AppCompatSpinner.access$400(this.this$0) == -2) {
         int var3 = AppCompatSpinner.access$500(this.this$0, (SpinnerAdapter)this.mAdapter, this.getBackground());
         int var4 = this.this$0.getContext().getResources().getDisplayMetrics().widthPixels - AppCompatSpinner.access$300(this.this$0).left - AppCompatSpinner.access$300(this.this$0).right;
         int var2 = var3;
         if(var3 > var4) {
            var2 = var4;
         }

         this.setContentWidth(Math.max(var2, var7 - var5 - var6));
      } else if(AppCompatSpinner.access$400(this.this$0) == -1) {
         this.setContentWidth(var7 - var5 - var6);
      } else {
         this.setContentWidth(AppCompatSpinner.access$400(this.this$0));
      }

      if(ViewUtils.isLayoutRtl(this.this$0)) {
         var1 += var7 - var6 - this.getWidth();
      } else {
         var1 += var5;
      }

      this.setHorizontalOffset(var1);
   }

   public CharSequence getHintText() {
      return this.mHintText;
   }

   public void setAdapter(ListAdapter var1) {
      super.setAdapter(var1);
      this.mAdapter = var1;
   }

   public void setPromptText(CharSequence var1) {
      this.mHintText = var1;
   }

   public void show() {
      boolean var1 = this.isShowing();
      this.computeContentWidth();
      this.setInputMethodMode(2);
      super.show();
      this.getListView().setChoiceMode(1);
      this.setSelection(this.this$0.getSelectedItemPosition());
      if(!var1) {
         ViewTreeObserver var2 = this.this$0.getViewTreeObserver();
         if(var2 != null) {
            AppCompatSpinner$DropdownPopup$2 var3 = new AppCompatSpinner$DropdownPopup$2(this);
            var2.addOnGlobalLayoutListener(var3);
            this.setOnDismissListener(new AppCompatSpinner$DropdownPopup$3(this, var3));
            return;
         }
      }

   }
}
