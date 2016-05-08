package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.app.NotificationCompat$Action;
import android.support.v4.app.NotificationCompat$Action$Builder;
import android.support.v4.app.NotificationCompat$Action$Extender;

public final class NotificationCompat$Action$WearableExtender implements NotificationCompat$Action$Extender {
   private static final int DEFAULT_FLAGS = 1;
   private static final String EXTRA_WEARABLE_EXTENSIONS = "android.wearable.EXTENSIONS";
   private static final int FLAG_AVAILABLE_OFFLINE = 1;
   private static final String KEY_CANCEL_LABEL = "cancelLabel";
   private static final String KEY_CONFIRM_LABEL = "confirmLabel";
   private static final String KEY_FLAGS = "flags";
   private static final String KEY_IN_PROGRESS_LABEL = "inProgressLabel";
   private CharSequence mCancelLabel;
   private CharSequence mConfirmLabel;
   private int mFlags = 1;
   private CharSequence mInProgressLabel;

   public NotificationCompat$Action$WearableExtender() {
   }

   public NotificationCompat$Action$WearableExtender(NotificationCompat$Action var1) {
      Bundle var2 = var1.getExtras().getBundle("android.wearable.EXTENSIONS");
      if(var2 != null) {
         this.mFlags = var2.getInt("flags", 1);
         this.mInProgressLabel = var2.getCharSequence("inProgressLabel");
         this.mConfirmLabel = var2.getCharSequence("confirmLabel");
         this.mCancelLabel = var2.getCharSequence("cancelLabel");
      }

   }

   private void setFlag(int var1, boolean var2) {
      if(var2) {
         this.mFlags |= var1;
      } else {
         this.mFlags &= ~var1;
      }
   }

   public NotificationCompat$Action$WearableExtender clone() {
      NotificationCompat$Action$WearableExtender var1 = new NotificationCompat$Action$WearableExtender();
      var1.mFlags = this.mFlags;
      var1.mInProgressLabel = this.mInProgressLabel;
      var1.mConfirmLabel = this.mConfirmLabel;
      var1.mCancelLabel = this.mCancelLabel;
      return var1;
   }

   public NotificationCompat$Action$Builder extend(NotificationCompat$Action$Builder var1) {
      Bundle var2 = new Bundle();
      if(this.mFlags != 1) {
         var2.putInt("flags", this.mFlags);
      }

      if(this.mInProgressLabel != null) {
         var2.putCharSequence("inProgressLabel", this.mInProgressLabel);
      }

      if(this.mConfirmLabel != null) {
         var2.putCharSequence("confirmLabel", this.mConfirmLabel);
      }

      if(this.mCancelLabel != null) {
         var2.putCharSequence("cancelLabel", this.mCancelLabel);
      }

      var1.getExtras().putBundle("android.wearable.EXTENSIONS", var2);
      return var1;
   }

   public CharSequence getCancelLabel() {
      return this.mCancelLabel;
   }

   public CharSequence getConfirmLabel() {
      return this.mConfirmLabel;
   }

   public CharSequence getInProgressLabel() {
      return this.mInProgressLabel;
   }

   public boolean isAvailableOffline() {
      return (this.mFlags & 1) != 0;
   }

   public NotificationCompat$Action$WearableExtender setAvailableOffline(boolean var1) {
      this.setFlag(1, var1);
      return this;
   }

   public NotificationCompat$Action$WearableExtender setCancelLabel(CharSequence var1) {
      this.mCancelLabel = var1;
      return this;
   }

   public NotificationCompat$Action$WearableExtender setConfirmLabel(CharSequence var1) {
      this.mConfirmLabel = var1;
      return this;
   }

   public NotificationCompat$Action$WearableExtender setInProgressLabel(CharSequence var1) {
      this.mInProgressLabel = var1;
      return this;
   }
}
