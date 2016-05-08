package android.support.design.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.design.widget.AppBarLayout$Behavior$SavedState$1;
import android.support.v4.os.ParcelableCompat;
import android.view.View.BaseSavedState;

public class AppBarLayout$Behavior$SavedState extends BaseSavedState {
   public static final Creator<AppBarLayout$Behavior$SavedState> CREATOR = ParcelableCompat.newCreator(new AppBarLayout$Behavior$SavedState$1());
   boolean firstVisibileChildAtMinimumHeight;
   float firstVisibileChildPercentageShown;
   int firstVisibleChildIndex;

   public AppBarLayout$Behavior$SavedState(Parcel var1, ClassLoader var2) {
      super(var1);
      this.firstVisibleChildIndex = var1.readInt();
      this.firstVisibileChildPercentageShown = var1.readFloat();
      boolean var3;
      if(var1.readByte() != 0) {
         var3 = true;
      } else {
         var3 = false;
      }

      this.firstVisibileChildAtMinimumHeight = var3;
   }

   public AppBarLayout$Behavior$SavedState(Parcelable var1) {
      super(var1);
   }

   public void writeToParcel(Parcel var1, int var2) {
      super.writeToParcel(var1, var2);
      var1.writeInt(this.firstVisibleChildIndex);
      var1.writeFloat(this.firstVisibileChildPercentageShown);
      byte var3;
      if(this.firstVisibileChildAtMinimumHeight) {
         var3 = 1;
      } else {
         var3 = 0;
      }

      var1.writeByte((byte)var3);
   }
}
