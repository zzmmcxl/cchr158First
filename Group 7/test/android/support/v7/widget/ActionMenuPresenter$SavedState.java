package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v7.widget.ActionMenuPresenter$SavedState$1;

class ActionMenuPresenter$SavedState implements Parcelable {
   public static final Creator<ActionMenuPresenter$SavedState> CREATOR = new ActionMenuPresenter$SavedState$1();
   public int openSubMenuId;

   ActionMenuPresenter$SavedState() {
   }

   ActionMenuPresenter$SavedState(Parcel var1) {
      this.openSubMenuId = var1.readInt();
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      var1.writeInt(this.openSubMenuId);
   }
}
