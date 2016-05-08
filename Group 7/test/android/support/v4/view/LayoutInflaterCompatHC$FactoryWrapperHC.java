package android.support.v4.view;

import android.content.Context;
import android.support.v4.view.LayoutInflaterCompatBase$FactoryWrapper;
import android.support.v4.view.LayoutInflaterFactory;
import android.util.AttributeSet;
import android.view.View;
import android.view.LayoutInflater.Factory2;

class LayoutInflaterCompatHC$FactoryWrapperHC extends LayoutInflaterCompatBase$FactoryWrapper implements Factory2 {
   LayoutInflaterCompatHC$FactoryWrapperHC(LayoutInflaterFactory var1) {
      super(var1);
   }

   public View onCreateView(View var1, String var2, Context var3, AttributeSet var4) {
      return this.mDelegateFactory.onCreateView(var1, var2, var3, var4);
   }
}
