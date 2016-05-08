package android.support.v4.app;

import android.app.Notification;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.support.annotation.ColorInt;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationCompat$Builder;
import android.support.v4.app.NotificationCompat$CarExtender$UnreadConversation;
import android.support.v4.app.NotificationCompat$Extender;
import android.support.v4.app.RemoteInput;

public final class NotificationCompat$CarExtender implements NotificationCompat$Extender {
   private static final String EXTRA_CAR_EXTENDER = "android.car.EXTENSIONS";
   private static final String EXTRA_COLOR = "app_color";
   private static final String EXTRA_CONVERSATION = "car_conversation";
   private static final String EXTRA_LARGE_ICON = "large_icon";
   private static final String TAG = "CarExtender";
   private int mColor = 0;
   private Bitmap mLargeIcon;
   private NotificationCompat$CarExtender$UnreadConversation mUnreadConversation;

   public NotificationCompat$CarExtender() {
   }

   public NotificationCompat$CarExtender(Notification var1) {
      if(VERSION.SDK_INT >= 21) {
         Bundle var2;
         if(NotificationCompat.getExtras(var1) == null) {
            var2 = null;
         } else {
            var2 = NotificationCompat.getExtras(var1).getBundle("android.car.EXTENSIONS");
         }

         if(var2 != null) {
            this.mLargeIcon = (Bitmap)var2.getParcelable("large_icon");
            this.mColor = var2.getInt("app_color", 0);
            var2 = var2.getBundle("car_conversation");
            this.mUnreadConversation = (NotificationCompat$CarExtender$UnreadConversation)NotificationCompat.access$200().getUnreadConversationFromBundle(var2, NotificationCompat$CarExtender$UnreadConversation.FACTORY, RemoteInput.FACTORY);
            return;
         }
      }

   }

   public NotificationCompat$Builder extend(NotificationCompat$Builder var1) {
      if(VERSION.SDK_INT < 21) {
         return var1;
      } else {
         Bundle var2 = new Bundle();
         if(this.mLargeIcon != null) {
            var2.putParcelable("large_icon", this.mLargeIcon);
         }

         if(this.mColor != 0) {
            var2.putInt("app_color", this.mColor);
         }

         if(this.mUnreadConversation != null) {
            var2.putBundle("car_conversation", NotificationCompat.access$200().getBundleForUnreadConversation(this.mUnreadConversation));
         }

         var1.getExtras().putBundle("android.car.EXTENSIONS", var2);
         return var1;
      }
   }

   @ColorInt
   public int getColor() {
      return this.mColor;
   }

   public Bitmap getLargeIcon() {
      return this.mLargeIcon;
   }

   public NotificationCompat$CarExtender$UnreadConversation getUnreadConversation() {
      return this.mUnreadConversation;
   }

   public NotificationCompat$CarExtender setColor(@ColorInt int var1) {
      this.mColor = var1;
      return this;
   }

   public NotificationCompat$CarExtender setLargeIcon(Bitmap var1) {
      this.mLargeIcon = var1;
      return this;
   }

   public NotificationCompat$CarExtender setUnreadConversation(NotificationCompat$CarExtender$UnreadConversation var1) {
      this.mUnreadConversation = var1;
      return this;
   }
}
