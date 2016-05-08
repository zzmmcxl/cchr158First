package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.RemoteInput.Builder;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.NotificationCompatBase$UnreadConversation;
import android.support.v4.app.NotificationCompatBase$UnreadConversation$Factory;
import android.support.v4.app.RemoteInputCompatBase$RemoteInput;
import android.support.v4.app.RemoteInputCompatBase$RemoteInput$Factory;

class NotificationCompatApi21 {
   public static final String CATEGORY_ALARM = "alarm";
   public static final String CATEGORY_CALL = "call";
   public static final String CATEGORY_EMAIL = "email";
   public static final String CATEGORY_ERROR = "err";
   public static final String CATEGORY_EVENT = "event";
   public static final String CATEGORY_MESSAGE = "msg";
   public static final String CATEGORY_PROGRESS = "progress";
   public static final String CATEGORY_PROMO = "promo";
   public static final String CATEGORY_RECOMMENDATION = "recommendation";
   public static final String CATEGORY_SERVICE = "service";
   public static final String CATEGORY_SOCIAL = "social";
   public static final String CATEGORY_STATUS = "status";
   public static final String CATEGORY_SYSTEM = "sys";
   public static final String CATEGORY_TRANSPORT = "transport";
   private static final String KEY_AUTHOR = "author";
   private static final String KEY_MESSAGES = "messages";
   private static final String KEY_ON_READ = "on_read";
   private static final String KEY_ON_REPLY = "on_reply";
   private static final String KEY_PARTICIPANTS = "participants";
   private static final String KEY_REMOTE_INPUT = "remote_input";
   private static final String KEY_TEXT = "text";
   private static final String KEY_TIMESTAMP = "timestamp";

   private static android.app.RemoteInput fromCompatRemoteInput(RemoteInputCompatBase$RemoteInput var0) {
      return (new Builder(var0.getResultKey())).setLabel(var0.getLabel()).setChoices(var0.getChoices()).setAllowFreeFormInput(var0.getAllowFreeFormInput()).addExtras(var0.getExtras()).build();
   }

   static Bundle getBundleForUnreadConversation(NotificationCompatBase$UnreadConversation var0) {
      if(var0 == null) {
         return null;
      } else {
         Bundle var4 = new Bundle();
         Parcelable[] var3 = null;
         String var2 = var3;
         if(var0.getParticipants() != null) {
            var2 = var3;
            if(var0.getParticipants().length > 1) {
               var2 = var0.getParticipants()[0];
            }
         }

         var3 = new Parcelable[var0.getMessages().length];

         for(int var1 = 0; var1 < var3.length; ++var1) {
            Bundle var5 = new Bundle();
            var5.putString("text", var0.getMessages()[var1]);
            var5.putString("author", var2);
            var3[var1] = var5;
         }

         var4.putParcelableArray("messages", var3);
         RemoteInputCompatBase$RemoteInput var6 = var0.getRemoteInput();
         if(var6 != null) {
            var4.putParcelable("remote_input", fromCompatRemoteInput(var6));
         }

         var4.putParcelable("on_reply", var0.getReplyPendingIntent());
         var4.putParcelable("on_read", var0.getReadPendingIntent());
         var4.putStringArray("participants", var0.getParticipants());
         var4.putLong("timestamp", var0.getLatestTimestamp());
         return var4;
      }
   }

   public static String getCategory(Notification var0) {
      return var0.category;
   }

   static NotificationCompatBase$UnreadConversation getUnreadConversationFromBundle(Bundle var0, NotificationCompatBase$UnreadConversation$Factory var1, RemoteInputCompatBase$RemoteInput$Factory var2) {
      RemoteInputCompatBase$RemoteInput var7 = null;
      if(var0 != null) {
         Parcelable[] var8 = var0.getParcelableArray("messages");
         String[] var6 = null;
         if(var8 != null) {
            var6 = new String[var8.length];
            boolean var5 = true;
            int var4 = 0;

            boolean var3;
            while(true) {
               var3 = var5;
               if(var4 >= var6.length) {
                  break;
               }

               if(!(var8[var4] instanceof Bundle)) {
                  var3 = false;
                  break;
               }

               var6[var4] = ((Bundle)var8[var4]).getString("text");
               if(var6[var4] == null) {
                  var3 = false;
                  break;
               }

               ++var4;
            }

            if(!var3) {
               return null;
            }
         }

         PendingIntent var12 = (PendingIntent)var0.getParcelable("on_read");
         PendingIntent var9 = (PendingIntent)var0.getParcelable("on_reply");
         android.app.RemoteInput var11 = (android.app.RemoteInput)var0.getParcelable("remote_input");
         String[] var10 = var0.getStringArray("participants");
         if(var10 != null && var10.length == 1) {
            if(var11 != null) {
               var7 = toCompatRemoteInput(var11, var2);
            }

            return var1.build(var6, var7, var9, var12, var10, var0.getLong("timestamp"));
         }
      }

      return null;
   }

   private static RemoteInputCompatBase$RemoteInput toCompatRemoteInput(android.app.RemoteInput var0, RemoteInputCompatBase$RemoteInput$Factory var1) {
      return var1.build(var0.getResultKey(), var0.getLabel(), var0.getChoices(), var0.getAllowFreeFormInput(), var0.getExtras());
   }
}
