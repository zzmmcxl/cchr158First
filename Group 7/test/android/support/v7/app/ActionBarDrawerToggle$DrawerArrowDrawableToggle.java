package android.support.v7.app;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.ActionBarDrawerToggle$DrawerToggle;
import android.support.v7.graphics.drawable.DrawerArrowDrawable;

class ActionBarDrawerToggle$DrawerArrowDrawableToggle extends DrawerArrowDrawable implements ActionBarDrawerToggle$DrawerToggle {
   private final Activity mActivity;

   public ActionBarDrawerToggle$DrawerArrowDrawableToggle(Activity var1, Context var2) {
      super(var2);
      this.mActivity = var1;
   }

   public float getPosition() {
      return this.getProgress();
   }

   public void setPosition(float var1) {
      if(var1 == 1.0F) {
         this.setVerticalMirror(true);
      } else if(var1 == 0.0F) {
         this.setVerticalMirror(false);
      }

      this.setProgress(var1);
   }
}
