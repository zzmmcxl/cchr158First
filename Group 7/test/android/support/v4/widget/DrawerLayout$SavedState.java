package android.support.v4.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.widget.DrawerLayout$SavedState$1;
import android.view.View.BaseSavedState;

public class DrawerLayout$SavedState extends BaseSavedState {
   public static final Creator<DrawerLayout$SavedState> CREATOR = new DrawerLayout$SavedState$1();
   int lockModeEnd;
   int lockModeLeft;
   int lockModeRight;
   int lockModeStart;
   int openDrawerGravity = 0;

   public DrawerLayout$SavedState(Parcel var1) {
      super(var1);
      this.openDrawerGravity = var1.readInt();
      this.lockModeLeft = var1.readInt();
      this.lockModeRight = var1.readInt();
      this.lockModeStart = var1.readInt();
      this.lockModeEnd = var1.readInt();
   }

   public DrawerLayout$SavedState(Parcelable var1) {
      super(var1);
   }

   public void writeToParcel(Parcel var1, int var2) {
      super.writeToParcel(var1, var2);
      var1.writeInt(this.openDrawerGravity);
      var1.writeInt(this.lockModeLeft);
      var1.writeInt(this.lockModeRight);
      var1.writeInt(this.lockModeStart);
      var1.writeInt(this.lockModeEnd);
   }
}
