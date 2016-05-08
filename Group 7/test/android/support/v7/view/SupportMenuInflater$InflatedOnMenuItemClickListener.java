package android.support.v7.view;

import android.view.InflateException;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import java.lang.reflect.Method;

class SupportMenuInflater$InflatedOnMenuItemClickListener implements OnMenuItemClickListener {
   private static final Class<?>[] PARAM_TYPES = new Class[]{MenuItem.class};
   private Method mMethod;
   private Object mRealOwner;

   public SupportMenuInflater$InflatedOnMenuItemClickListener(Object var1, String var2) {
      this.mRealOwner = var1;
      Class var3 = var1.getClass();

      try {
         this.mMethod = var3.getMethod(var2, PARAM_TYPES);
      } catch (Exception var4) {
         InflateException var5 = new InflateException("Couldn\'t resolve menu item onClick handler " + var2 + " in class " + var3.getName());
         var5.initCause(var4);
         throw var5;
      }
   }

   public boolean onMenuItemClick(MenuItem var1) {
      try {
         if(this.mMethod.getReturnType() == Boolean.TYPE) {
            return ((Boolean)this.mMethod.invoke(this.mRealOwner, new Object[]{var1})).booleanValue();
         } else {
            this.mMethod.invoke(this.mRealOwner, new Object[]{var1});
            return true;
         }
      } catch (Exception var2) {
         throw new RuntimeException(var2);
      }
   }
}
