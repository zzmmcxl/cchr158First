package android.support.v7.app;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.View.OnClickListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class AppCompatViewInflater$DeclaredOnClickListener implements OnClickListener {
   private final View mHostView;
   private final String mMethodName;
   private Context mResolvedContext;
   private Method mResolvedMethod;

   public AppCompatViewInflater$DeclaredOnClickListener(@NonNull View var1, @NonNull String var2) {
      this.mHostView = var1;
      this.mMethodName = var2;
   }

   @NonNull
   private void resolveMethod(@Nullable Context param1, @NonNull String param2) {
      // $FF: Couldn't be decompiled
   }

   public void onClick(@NonNull View var1) {
      if(this.mResolvedMethod == null) {
         this.resolveMethod(this.mHostView.getContext(), this.mMethodName);
      }

      try {
         this.mResolvedMethod.invoke(this.mResolvedContext, new Object[]{var1});
      } catch (IllegalAccessException var2) {
         throw new IllegalStateException("Could not execute non-public method for android:onClick", var2);
      } catch (InvocationTargetException var3) {
         throw new IllegalStateException("Could not execute method for android:onClick", var3);
      }
   }
}
