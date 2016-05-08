package android.support.v4.view;

import android.support.v4.view.LayoutInflaterCompatBase$FactoryWrapper;
import android.support.v4.view.LayoutInflaterFactory;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;

class LayoutInflaterCompatBase {
   static LayoutInflaterFactory getFactory(LayoutInflater var0) {
      Factory var1 = var0.getFactory();
      return var1 instanceof LayoutInflaterCompatBase$FactoryWrapper?((LayoutInflaterCompatBase$FactoryWrapper)var1).mDelegateFactory:null;
   }

   static void setFactory(LayoutInflater var0, LayoutInflaterFactory var1) {
      LayoutInflaterCompatBase$FactoryWrapper var2;
      if(var1 != null) {
         var2 = new LayoutInflaterCompatBase$FactoryWrapper(var1);
      } else {
         var2 = null;
      }

      var0.setFactory(var2);
   }
}
