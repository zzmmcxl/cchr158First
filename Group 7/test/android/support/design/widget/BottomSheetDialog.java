package android.support.design.widget;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.support.design.R$attr;
import android.support.design.R$id;
import android.support.design.R$layout;
import android.support.design.R$style;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetBehavior$BottomSheetCallback;
import android.support.design.widget.BottomSheetDialog$1;
import android.support.design.widget.BottomSheetDialog$2;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatDialog;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;

public class BottomSheetDialog extends AppCompatDialog {
   private BottomSheetBehavior$BottomSheetCallback mBottomSheetCallback;

   public BottomSheetDialog(@NonNull Context var1) {
      this(var1, 0);
   }

   public BottomSheetDialog(@NonNull Context var1, @StyleRes int var2) {
      super(var1, getThemeResId(var1, var2));
      this.mBottomSheetCallback = new BottomSheetDialog$2(this);
      this.supportRequestWindowFeature(1);
   }

   protected BottomSheetDialog(@NonNull Context var1, boolean var2, OnCancelListener var3) {
      super(var1, var2, var3);
      this.mBottomSheetCallback = new BottomSheetDialog$2(this);
      this.supportRequestWindowFeature(1);
   }

   private static int getThemeResId(Context var0, int var1) {
      int var2 = var1;
      if(var1 == 0) {
         TypedValue var3 = new TypedValue();
         if(!var0.getTheme().resolveAttribute(R$attr.bottomSheetDialogTheme, var3, true)) {
            return R$style.Theme_Design_Light_BottomSheetDialog;
         }

         var2 = var3.resourceId;
      }

      return var2;
   }

   private boolean shouldWindowCloseOnTouchOutside() {
      if(VERSION.SDK_INT >= 11) {
         TypedValue var1 = new TypedValue();
         if(!this.getContext().getTheme().resolveAttribute(16843611, var1, true)) {
            return false;
         }

         if(var1.data == 0) {
            return false;
         }
      }

      return true;
   }

   private View wrapInBottomSheet(int var1, View var2, LayoutParams var3) {
      CoordinatorLayout var5 = (CoordinatorLayout)View.inflate(this.getContext(), R$layout.design_bottom_sheet_dialog, (ViewGroup)null);
      View var4 = var2;
      if(var1 != 0) {
         var4 = var2;
         if(var2 == null) {
            var4 = this.getLayoutInflater().inflate(var1, var5, false);
         }
      }

      FrameLayout var6 = (FrameLayout)var5.findViewById(R$id.design_bottom_sheet);
      BottomSheetBehavior.from(var6).setBottomSheetCallback(this.mBottomSheetCallback);
      if(var3 == null) {
         var6.addView(var4);
      } else {
         var6.addView(var4, var3);
      }

      if(this.shouldWindowCloseOnTouchOutside()) {
         var5.findViewById(R$id.touch_outside).setOnClickListener(new BottomSheetDialog$1(this));
      }

      return var5;
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.getWindow().setLayout(-1, -1);
   }

   public void setContentView(@LayoutRes int var1) {
      super.setContentView(this.wrapInBottomSheet(var1, (View)null, (LayoutParams)null));
   }

   public void setContentView(View var1) {
      super.setContentView(this.wrapInBottomSheet(0, var1, (LayoutParams)null));
   }

   public void setContentView(View var1, LayoutParams var2) {
      super.setContentView(this.wrapInBottomSheet(0, var1, var2));
   }
}
