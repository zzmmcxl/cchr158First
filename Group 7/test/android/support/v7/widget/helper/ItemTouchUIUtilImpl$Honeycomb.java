package android.support.v7.widget.helper;

import android.graphics.Canvas;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchUIUtil;
import android.view.View;

class ItemTouchUIUtilImpl$Honeycomb implements ItemTouchUIUtil {
   public void clearView(View var1) {
      ViewCompat.setTranslationX(var1, 0.0F);
      ViewCompat.setTranslationY(var1, 0.0F);
   }

   public void onDraw(Canvas var1, RecyclerView var2, View var3, float var4, float var5, int var6, boolean var7) {
      ViewCompat.setTranslationX(var3, var4);
      ViewCompat.setTranslationY(var3, var5);
   }

   public void onDrawOver(Canvas var1, RecyclerView var2, View var3, float var4, float var5, int var6, boolean var7) {
   }

   public void onSelected(View var1) {
   }
}
