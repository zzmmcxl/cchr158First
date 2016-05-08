package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v7.widget.Toolbar$SavedState$1;
import android.view.View.BaseSavedState;

public class Toolbar$SavedState extends BaseSavedState {
   public static final Creator<Toolbar$SavedState> CREATOR = new Toolbar$SavedState$1();
   int expandedMenuItemId;
   boolean isOverflowOpen;

   public Toolbar$SavedState(Parcel var1) {
      super(var1);
      this.expandedMenuItemId = var1.readInt();
      boolean var2;
      if(var1.readInt() != 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      this.isOverflowOpen = var2;
   }

   public Toolbar$SavedState(Parcelable var1) {
      super(var1);
   }

   public void writeToParcel(Parcel var1, int var2) {
      super.writeToParcel(var1, var2);
      var1.writeInt(this.expandedMenuItemId);
      byte var3;
      if(this.isOverflowOpen) {
         var3 = 1;
      } else {
         var3 = 0;
      }

      var1.writeInt(var3);
   }
}
