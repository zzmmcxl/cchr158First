package android.support.v4.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.widget.SlidingPaneLayout$SavedState$1;
import android.view.View.BaseSavedState;

class SlidingPaneLayout$SavedState extends BaseSavedState {
   public static final Creator<SlidingPaneLayout$SavedState> CREATOR = new SlidingPaneLayout$SavedState$1();
   boolean isOpen;

   private SlidingPaneLayout$SavedState(Parcel var1) {
      super(var1);
      boolean var2;
      if(var1.readInt() != 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      this.isOpen = var2;
   }

   SlidingPaneLayout$SavedState(Parcelable var1) {
      super(var1);
   }

   public void writeToParcel(Parcel var1, int var2) {
      super.writeToParcel(var1, var2);
      byte var3;
      if(this.isOpen) {
         var3 = 1;
      } else {
         var3 = 0;
      }

      var1.writeInt(var3);
   }
}
