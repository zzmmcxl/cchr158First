package android.support.v7.widget.helper;

import android.graphics.Canvas;
import android.support.v4.view.ViewCompat;
import android.support.v7.recyclerview.R$id;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchUIUtilImpl$Honeycomb;
import android.view.View;

class ItemTouchUIUtilImpl$Lollipop extends ItemTouchUIUtilImpl$Honeycomb {
   private float findMaxElevation(RecyclerView var1, View var2) {
      int var7 = var1.getChildCount();
      float var3 = 0.0F;

      float var4;
      for(int var6 = 0; var6 < var7; var3 = var4) {
         View var8 = var1.getChildAt(var6);
         if(var8 == var2) {
            var4 = var3;
         } else {
            float var5 = ViewCompat.getElevation(var8);
            var4 = var3;
            if(var5 > var3) {
               var4 = var5;
            }
         }

         ++var6;
      }

      return var3;
   }

   public void clearView(View var1) {
      Object var2 = var1.getTag(R$id.item_touch_helper_previous_elevation);
      if(var2 != null && var2 instanceof Float) {
         ViewCompat.setElevation(var1, ((Float)var2).floatValue());
      }

      var1.setTag(R$id.item_touch_helper_previous_elevation, (Object)null);
      super.clearView(var1);
   }

   public void onDraw(Canvas var1, RecyclerView var2, View var3, float var4, float var5, int var6, boolean var7) {
      if(var7 && var3.getTag(R$id.item_touch_helper_previous_elevation) == null) {
         float var8 = ViewCompat.getElevation(var3);
         ViewCompat.setElevation(var3, 1.0F + this.findMaxElevation(var2, var3));
         var3.setTag(R$id.item_touch_helper_previous_elevation, Float.valueOf(var8));
      }

      super.onDraw(var1, var2, var3, var4, var5, var6, var7);
   }
}
