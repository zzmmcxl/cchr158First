package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.graphics.drawable.DrawableWrapper;

class ListViewCompat$GateKeeperDrawable extends DrawableWrapper {
   private boolean mEnabled = true;

   public ListViewCompat$GateKeeperDrawable(Drawable var1) {
      super(var1);
   }

   public void draw(Canvas var1) {
      if(this.mEnabled) {
         super.draw(var1);
      }

   }

   void setEnabled(boolean var1) {
      this.mEnabled = var1;
   }

   public void setHotspot(float var1, float var2) {
      if(this.mEnabled) {
         super.setHotspot(var1, var2);
      }

   }

   public void setHotspotBounds(int var1, int var2, int var3, int var4) {
      if(this.mEnabled) {
         super.setHotspotBounds(var1, var2, var3, var4);
      }

   }

   public boolean setState(int[] var1) {
      return this.mEnabled?super.setState(var1):false;
   }

   public boolean setVisible(boolean var1, boolean var2) {
      return this.mEnabled?super.setVisible(var1, var2):false;
   }
}
