package android.support.v4.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.Fragment$SavedState$1;

public class Fragment$SavedState implements Parcelable {
   public static final Creator<Fragment$SavedState> CREATOR = new Fragment$SavedState$1();
   final Bundle mState;

   Fragment$SavedState(Bundle var1) {
      this.mState = var1;
   }

   Fragment$SavedState(Parcel var1, ClassLoader var2) {
      this.mState = var1.readBundle();
      if(var2 != null && this.mState != null) {
         this.mState.setClassLoader(var2);
      }

   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      var1.writeBundle(this.mState);
   }
}
