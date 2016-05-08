package android.support.design.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.design.widget.BottomSheetBehavior$SavedState$1;
import android.view.View.BaseSavedState;

public class BottomSheetBehavior$SavedState extends BaseSavedState {
   public static final Creator<BottomSheetBehavior$SavedState> CREATOR = new BottomSheetBehavior$SavedState$1();
   final int state;

   public BottomSheetBehavior$SavedState(Parcel var1) {
      super(var1);
      this.state = var1.readInt();
   }

   public BottomSheetBehavior$SavedState(Parcelable var1, int var2) {
      super(var1);
      this.state = var2;
   }

   public void writeToParcel(Parcel var1, int var2) {
      super.writeToParcel(var1, var2);
      var1.writeInt(this.state);
   }
}
