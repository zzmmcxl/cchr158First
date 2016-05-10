package android.support.v7.internal.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.v7.appcompat.R;
import android.support.v7.internal.widget.TintTypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.PopupWindow;
import java.lang.reflect.Field;

public class AppCompatPopupWindow extends PopupWindow {
   private static final String TAG = "AppCompatPopupWindow";
   private final boolean mOverlapAnchor;

   public AppCompatPopupWindow(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      TintTypedArray var4 = TintTypedArray.obtainStyledAttributes(var1, var2, R.styleable.PopupWindow, var3, 0);
      this.mOverlapAnchor = var4.getBoolean(R.styleable.PopupWindow_overlapAnchor, false);
      this.setBackgroundDrawable(var4.getDrawable(R.styleable.PopupWindow_android_popupBackground));
      var4.recycle();
      if(VERSION.SDK_INT < 14) {
         wrapOnScrollChangedListener(this);
      }

   }

   private static void wrapOnScrollChangedListener(final PopupWindow var0) {
      try {
         final Field var1 = PopupWindow.class.getDeclaredField("mAnchor");
         var1.setAccessible(true);
         Field var2 = PopupWindow.class.getDeclaredField("mOnScrollChangedListener");
         var2.setAccessible(true);
         var2.set(var0, new OnScrollChangedListener() {
            // $FF: synthetic field
            final OnScrollChangedListener val$originalListener;

            {
               this.val$originalListener = var3;
            }

            public void onScrollChanged() {
               // $FF: Couldn't be decompiled
            }
         });
      } catch (Exception var3) {
         Log.d("AppCompatPopupWindow", "Exception while installing workaround OnScrollChangedListener", var3);
      }
   }

   public void showAsDropDown(View var1, int var2, int var3) {
      int var4 = var3;
      if(VERSION.SDK_INT < 21) {
         var4 = var3;
         if(this.mOverlapAnchor) {
            var4 = var3 - var1.getHeight();
         }
      }

      super.showAsDropDown(var1, var2, var4);
   }

   @TargetApi(19)
   public void showAsDropDown(View var1, int var2, int var3, int var4) {
      int var5 = var3;
      if(VERSION.SDK_INT < 21) {
         var5 = var3;
         if(this.mOverlapAnchor) {
            var5 = var3 - var1.getHeight();
         }
      }

      super.showAsDropDown(var1, var2, var5, var4);
   }

   public void update(View var1, int var2, int var3, int var4, int var5) {
      int var6 = var3;
      if(VERSION.SDK_INT < 21) {
         var6 = var3;
         if(this.mOverlapAnchor) {
            var6 = var3 - var1.getHeight();
         }
      }

      super.update(var1, var2, var6, var4, var5);
   }
}
