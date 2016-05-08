package android.support.v4.app;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.lang.reflect.Method;

class ActionBarDrawerToggleHoneycomb$SetIndicatorInfo {
   public Method setHomeActionContentDescription;
   public Method setHomeAsUpIndicator;
   public ImageView upIndicatorView;

   ActionBarDrawerToggleHoneycomb$SetIndicatorInfo(Activity var1) {
      try {
         this.setHomeAsUpIndicator = ActionBar.class.getDeclaredMethod("setHomeAsUpIndicator", new Class[]{Drawable.class});
         this.setHomeActionContentDescription = ActionBar.class.getDeclaredMethod("setHomeActionContentDescription", new Class[]{Integer.TYPE});
      } catch (NoSuchMethodException var3) {
         View var4 = var1.findViewById(16908332);
         if(var4 != null) {
            ViewGroup var2 = (ViewGroup)var4.getParent();
            if(var2.getChildCount() == 2) {
               var4 = var2.getChildAt(0);
               View var5 = var2.getChildAt(1);
               if(var4.getId() == 16908332) {
                  var4 = var5;
               }

               if(var4 instanceof ImageView) {
                  this.upIndicatorView = (ImageView)var4;
                  return;
               }
            }
         }
      }

   }
}
