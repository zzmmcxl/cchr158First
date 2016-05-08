package android.support.design.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.design.widget.TextInputLayout$SavedState$1;
import android.text.TextUtils;
import android.view.View.BaseSavedState;

class TextInputLayout$SavedState extends BaseSavedState {
   public static final Creator<TextInputLayout$SavedState> CREATOR = new TextInputLayout$SavedState$1();
   CharSequence error;

   public TextInputLayout$SavedState(Parcel var1) {
      super(var1);
      this.error = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(var1);
   }

   TextInputLayout$SavedState(Parcelable var1) {
      super(var1);
   }

   public String toString() {
      return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + this.error + "}";
   }

   public void writeToParcel(Parcel var1, int var2) {
      super.writeToParcel(var1, var2);
      TextUtils.writeToParcel(this.error, var1, var2);
   }
}
