package android.support.v7.widget.helper;

import android.graphics.Canvas;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchUIUtil;
import android.view.View;

class ItemTouchUIUtilImpl$Gingerbread implements ItemTouchUIUtil {
   private void draw(Canvas var1, RecyclerView var2, View var3, float var4, float var5) {
      var1.save();
      var1.translate(var4, var5);
      var2.drawChild(var1, var3, 0L);
      var1.restore();
   }

   public void clearView(View var1) {
      var1.setVisibility(0);
   }

   public void onDraw(Canvas var1, RecyclerView var2, View var3, float var4, float var5, int var6, boolean var7) {
      if(var6 != 2) {
         this.draw(var1, var2, var3, var4, var5);
      }

   }

   public void onDrawOver(Canvas var1, RecyclerView var2, View var3, float var4, float var5, int var6, boolean var7) {
      if(var6 == 2) {
         this.draw(var1, var2, var3, var4, var5);
      }

   }

   public void onSelected(View var1) {
      var1.setVisibility(4);
   }
}
