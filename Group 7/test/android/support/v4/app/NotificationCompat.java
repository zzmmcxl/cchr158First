package android.support.v4.app;

import android.app.Notification;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.Build.VERSION;
import android.support.annotation.ColorInt;
import android.support.v4.app.NotificationBuilderWithActions;
import android.support.v4.app.NotificationBuilderWithBuilderAccessor;
import android.support.v4.app.NotificationCompat$Action;
import android.support.v4.app.NotificationCompat$BigPictureStyle;
import android.support.v4.app.NotificationCompat$BigTextStyle;
import android.support.v4.app.NotificationCompat$InboxStyle;
import android.support.v4.app.NotificationCompat$NotificationCompatImpl;
import android.support.v4.app.NotificationCompat$NotificationCompatImplApi20;
import android.support.v4.app.NotificationCompat$NotificationCompatImplApi21;
import android.support.v4.app.NotificationCompat$NotificationCompatImplBase;
import android.support.v4.app.NotificationCompat$NotificationCompatImplGingerbread;
import android.support.v4.app.NotificationCompat$NotificationCompatImplHoneycomb;
import android.support.v4.app.NotificationCompat$NotificationCompatImplIceCreamSandwich;
import android.support.v4.app.NotificationCompat$NotificationCompatImplJellybean;
import android.support.v4.app.NotificationCompat$NotificationCompatImplKitKat;
import android.support.v4.app.NotificationCompat$Style;
import android.support.v4.app.NotificationCompatJellybean;
import java.util.ArrayList;
import java.util.Iterator;

public class NotificationCompat {
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
   @ColorInt
   public static final int COLOR_DEFAULT = 0;
   public static final int DEFAULT_ALL = -1;
   public static final int DEFAULT_LIGHTS = 4;
   public static final int DEFAULT_SOUND = 1;
   public static final int DEFAULT_VIBRATE = 2;
   public static final String EXTRA_BACKGROUND_IMAGE_URI = "android.backgroundImageUri";
   public static final String EXTRA_BIG_TEXT = "android.bigText";
   public static final String EXTRA_COMPACT_ACTIONS = "android.compactActions";
   public static final String EXTRA_INFO_TEXT = "android.infoText";
   public static final String EXTRA_LARGE_ICON = "android.largeIcon";
   public static final String EXTRA_LARGE_ICON_BIG = "android.largeIcon.big";
   public static final String EXTRA_MEDIA_SESSION = "android.mediaSession";
   public static final String EXTRA_PEOPLE = "android.people";
   public static final String EXTRA_PICTURE = "android.picture";
   public static final String EXTRA_PROGRESS = "android.progress";
   public static final String EXTRA_PROGRESS_INDETERMINATE = "android.progressIndeterminate";
   public static final String EXTRA_PROGRESS_MAX = "android.progressMax";
   public static final String EXTRA_SHOW_CHRONOMETER = "android.showChronometer";
   public static final String EXTRA_SHOW_WHEN = "android.showWhen";
   public static final String EXTRA_SMALL_ICON = "android.icon";
   public static final String EXTRA_SUB_TEXT = "android.subText";
   public static final String EXTRA_SUMMARY_TEXT = "android.summaryText";
   public static final String EXTRA_TEMPLATE = "android.template";
   public static final String EXTRA_TEXT = "android.text";
   public static final String EXTRA_TEXT_LINES = "android.textLines";
   public static final String EXTRA_TITLE = "android.title";
   public static final String EXTRA_TITLE_BIG = "android.title.big";
   public static final int FLAG_AUTO_CANCEL = 16;
   public static final int FLAG_FOREGROUND_SERVICE = 64;
   public static final int FLAG_GROUP_SUMMARY = 512;
   public static final int FLAG_HIGH_PRIORITY = 128;
   public static final int FLAG_INSISTENT = 4;
   public static final int FLAG_LOCAL_ONLY = 256;
   public static final int FLAG_NO_CLEAR = 32;
   public static final int FLAG_ONGOING_EVENT = 2;
   public static final int FLAG_ONLY_ALERT_ONCE = 8;
   public static final int FLAG_SHOW_LIGHTS = 1;
   private static final NotificationCompat$NotificationCompatImpl IMPL;
   public static final int PRIORITY_DEFAULT = 0;
   public static final int PRIORITY_HIGH = 1;
   public static final int PRIORITY_LOW = -1;
   public static final int PRIORITY_MAX = 2;
   public static final int PRIORITY_MIN = -2;
   public static final int STREAM_DEFAULT = -1;
   public static final int VISIBILITY_PRIVATE = 0;
   public static final int VISIBILITY_PUBLIC = 1;
   public static final int VISIBILITY_SECRET = -1;

   static {
      if(VERSION.SDK_INT >= 21) {
         IMPL = new NotificationCompat$NotificationCompatImplApi21();
      } else if(VERSION.SDK_INT >= 20) {
         IMPL = new NotificationCompat$NotificationCompatImplApi20();
      } else if(VERSION.SDK_INT >= 19) {
         IMPL = new NotificationCompat$NotificationCompatImplKitKat();
      } else if(VERSION.SDK_INT >= 16) {
         IMPL = new NotificationCompat$NotificationCompatImplJellybean();
      } else if(VERSION.SDK_INT >= 14) {
         IMPL = new NotificationCompat$NotificationCompatImplIceCreamSandwich();
      } else if(VERSION.SDK_INT >= 11) {
         IMPL = new NotificationCompat$NotificationCompatImplHoneycomb();
      } else if(VERSION.SDK_INT >= 9) {
         IMPL = new NotificationCompat$NotificationCompatImplGingerbread();
      } else {
         IMPL = new NotificationCompat$NotificationCompatImplBase();
      }
   }

   private static void addActionsToBuilder(NotificationBuilderWithActions var0, ArrayList<NotificationCompat$Action> var1) {
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         var0.addAction((NotificationCompat$Action)var2.next());
      }

   }

   private static void addStyleToBuilderJellybean(NotificationBuilderWithBuilderAccessor var0, NotificationCompat$Style var1) {
      if(var1 != null) {
         if(var1 instanceof NotificationCompat$BigTextStyle) {
            NotificationCompat$BigTextStyle var2 = (NotificationCompat$BigTextStyle)var1;
            NotificationCompatJellybean.addBigTextStyle(var0, var2.mBigContentTitle, var2.mSummaryTextSet, var2.mSummaryText, var2.mBigText);
         } else {
            if(var1 instanceof NotificationCompat$InboxStyle) {
               NotificationCompat$InboxStyle var4 = (NotificationCompat$InboxStyle)var1;
               NotificationCompatJellybean.addInboxStyle(var0, var4.mBigContentTitle, var4.mSummaryTextSet, var4.mSummaryText, var4.mTexts);
               return;
            }

            if(var1 instanceof NotificationCompat$BigPictureStyle) {
               NotificationCompat$BigPictureStyle var3 = (NotificationCompat$BigPictureStyle)var1;
               NotificationCompatJellybean.addBigPictureStyle(var0, var3.mBigContentTitle, var3.mSummaryTextSet, var3.mSummaryText, var3.mPicture, var3.mBigLargeIcon, var3.mBigLargeIconSet);
               return;
            }
         }
      }

   }

   public static NotificationCompat$Action getAction(Notification var0, int var1) {
      return IMPL.getAction(var0, var1);
   }

   public static int getActionCount(Notification var0) {
      return IMPL.getActionCount(var0);
   }

   public static String getCategory(Notification var0) {
      return IMPL.getCategory(var0);
   }

   public static Bundle getExtras(Notification var0) {
      return IMPL.getExtras(var0);
   }

   public static String getGroup(Notification var0) {
      return IMPL.getGroup(var0);
   }

   public static boolean getLocalOnly(Notification var0) {
      return IMPL.getLocalOnly(var0);
   }

   private static Notification[] getNotificationArrayFromBundle(Bundle var0, String var1) {
      Parcelable[] var3 = var0.getParcelableArray(var1);
      if(!(var3 instanceof Notification[]) && var3 != null) {
         Notification[] var4 = new Notification[var3.length];

         for(int var2 = 0; var2 < var3.length; ++var2) {
            var4[var2] = (Notification)var3[var2];
         }

         var0.putParcelableArray(var1, var4);
         return var4;
      } else {
         return (Notification[])((Notification[])var3);
      }
   }

   public static String getSortKey(Notification var0) {
      return IMPL.getSortKey(var0);
   }

   public static boolean isGroupSummary(Notification var0) {
      return IMPL.isGroupSummary(var0);
   }
}
