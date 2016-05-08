package android.support.v7.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.os.ParcelableCompat;
import android.support.v7.app.AppCompatDelegateImplV7$PanelFeatureState$SavedState$1;

class AppCompatDelegateImplV7$PanelFeatureState$SavedState implements Parcelable {
   public static final Creator<AppCompatDelegateImplV7$PanelFeatureState$SavedState> CREATOR = ParcelableCompat.newCreator(new AppCompatDelegateImplV7$PanelFeatureState$SavedState$1());
   int featureId;
   boolean isOpen;
   Bundle menuState;

   private AppCompatDelegateImplV7$PanelFeatureState$SavedState() {
   }

   private static AppCompatDelegateImplV7$PanelFeatureState$SavedState readFromParcel(Parcel var0, ClassLoader var1) {
      boolean var2 = true;
      AppCompatDelegateImplV7$PanelFeatureState$SavedState var3 = new AppCompatDelegateImplV7$PanelFeatureState$SavedState();
      var3.featureId = var0.readInt();
      if(var0.readInt() != 1) {
         var2 = false;
      }

      var3.isOpen = var2;
      if(var3.isOpen) {
         var3.menuState = var0.readBundle(var1);
      }

      return var3;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      var1.writeInt(this.featureId);
      byte var3;
      if(this.isOpen) {
         var3 = 1;
      } else {
         var3 = 0;
      }

      var1.writeInt(var3);
      if(this.isOpen) {
         var1.writeBundle(this.menuState);
      }

   }
}
