package android.support.v4.widget;

import android.support.v4.widget.SlidingPaneLayout;
import android.support.v4.widget.SlidingPaneLayout$SlidingPanelLayoutImplBase;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class SlidingPaneLayout$SlidingPanelLayoutImplJB extends SlidingPaneLayout$SlidingPanelLayoutImplBase {
   private Method mGetDisplayList;
   private Field mRecreateDisplayList;

   SlidingPaneLayout$SlidingPanelLayoutImplJB() {
      try {
         this.mGetDisplayList = View.class.getDeclaredMethod("getDisplayList", (Class[])null);
      } catch (NoSuchMethodException var3) {
         Log.e("SlidingPaneLayout", "Couldn\'t fetch getDisplayList method; dimming won\'t work right.", var3);
      }

      try {
         this.mRecreateDisplayList = View.class.getDeclaredField("mRecreateDisplayList");
         this.mRecreateDisplayList.setAccessible(true);
      } catch (NoSuchFieldException var2) {
         Log.e("SlidingPaneLayout", "Couldn\'t fetch mRecreateDisplayList field; dimming will be slow.", var2);
      }
   }

   public void invalidateChildRegion(SlidingPaneLayout var1, View var2) {
      if(this.mGetDisplayList != null && this.mRecreateDisplayList != null) {
         try {
            this.mRecreateDisplayList.setBoolean(var2, true);
            this.mGetDisplayList.invoke(var2, (Object[])null);
         } catch (Exception var4) {
            Log.e("SlidingPaneLayout", "Error refreshing display list state", var4);
         }

         super.invalidateChildRegion(var1, var2);
      } else {
         var2.invalidate();
      }
   }
}
