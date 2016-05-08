package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.app.RemoteInput;
import android.support.v4.app.RemoteInput$1;

public final class RemoteInput$Builder {
   private boolean mAllowFreeFormInput = true;
   private CharSequence[] mChoices;
   private Bundle mExtras = new Bundle();
   private CharSequence mLabel;
   private final String mResultKey;

   public RemoteInput$Builder(String var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Result key can\'t be null");
      } else {
         this.mResultKey = var1;
      }
   }

   public RemoteInput$Builder addExtras(Bundle var1) {
      if(var1 != null) {
         this.mExtras.putAll(var1);
      }

      return this;
   }

   public RemoteInput build() {
      return new RemoteInput(this.mResultKey, this.mLabel, this.mChoices, this.mAllowFreeFormInput, this.mExtras, (RemoteInput$1)null);
   }

   public Bundle getExtras() {
      return this.mExtras;
   }

   public RemoteInput$Builder setAllowFreeFormInput(boolean var1) {
      this.mAllowFreeFormInput = var1;
      return this;
   }

   public RemoteInput$Builder setChoices(CharSequence[] var1) {
      this.mChoices = var1;
      return this;
   }

   public RemoteInput$Builder setLabel(CharSequence var1) {
      this.mLabel = var1;
      return this;
   }
}
