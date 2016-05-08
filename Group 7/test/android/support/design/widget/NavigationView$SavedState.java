package android.support.design.widget;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView$SavedState$1;
import android.support.v4.os.ParcelableCompat;
import android.view.View.BaseSavedState;

public class NavigationView$SavedState extends BaseSavedState {
   public static final Creator<NavigationView$SavedState> CREATOR = ParcelableCompat.newCreator(new NavigationView$SavedState$1());
   public Bundle menuState;

   public NavigationView$SavedState(Parcel var1, ClassLoader var2) {
      super(var1);
      this.menuState = var1.readBundle(var2);
   }

   public NavigationView$SavedState(Parcelable var1) {
      super(var1);
   }

   public void writeToParcel(@NonNull Parcel var1, int var2) {
      super.writeToParcel(var1, var2);
      var1.writeBundle(this.menuState);
   }
}
