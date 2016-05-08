package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Notification.BigPictureStyle;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.app.Notification.InboxStyle;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.BundleUtil;
import android.support.v4.app.NotificationBuilderWithBuilderAccessor;
import android.support.v4.app.NotificationCompatBase$Action;
import android.support.v4.app.NotificationCompatBase$Action$Factory;
import android.support.v4.app.RemoteInputCompatBase$RemoteInput;
import android.support.v4.app.RemoteInputCompatBase$RemoteInput$Factory;
import android.support.v4.app.RemoteInputCompatJellybean;
import android.util.Log;
import android.util.SparseArray;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class NotificationCompatJellybean {
   static final String EXTRA_ACTION_EXTRAS = "android.support.actionExtras";
   static final String EXTRA_GROUP_KEY = "android.support.groupKey";
   static final String EXTRA_GROUP_SUMMARY = "android.support.isGroupSummary";
   static final String EXTRA_LOCAL_ONLY = "android.support.localOnly";
   static final String EXTRA_REMOTE_INPUTS = "android.support.remoteInputs";
   static final String EXTRA_SORT_KEY = "android.support.sortKey";
   static final String EXTRA_USE_SIDE_CHANNEL = "android.support.useSideChannel";
   private static final String KEY_ACTION_INTENT = "actionIntent";
   private static final String KEY_EXTRAS = "extras";
   private static final String KEY_ICON = "icon";
   private static final String KEY_REMOTE_INPUTS = "remoteInputs";
   private static final String KEY_TITLE = "title";
   public static final String TAG = "NotificationCompat";
   private static Class<?> sActionClass;
   private static Field sActionIconField;
   private static Field sActionIntentField;
   private static Field sActionTitleField;
   private static boolean sActionsAccessFailed;
   private static Field sActionsField;
   private static final Object sActionsLock = new Object();
   private static Field sExtrasField;
   private static boolean sExtrasFieldAccessFailed;
   private static final Object sExtrasLock = new Object();

   public static void addBigPictureStyle(NotificationBuilderWithBuilderAccessor var0, CharSequence var1, boolean var2, CharSequence var3, Bitmap var4, Bitmap var5, boolean var6) {
      BigPictureStyle var7 = (new BigPictureStyle(var0.getBuilder())).setBigContentTitle(var1).bigPicture(var4);
      if(var6) {
         var7.bigLargeIcon(var5);
      }

      if(var2) {
         var7.setSummaryText(var3);
      }

   }

   public static void addBigTextStyle(NotificationBuilderWithBuilderAccessor var0, CharSequence var1, boolean var2, CharSequence var3, CharSequence var4) {
      BigTextStyle var5 = (new BigTextStyle(var0.getBuilder())).setBigContentTitle(var1).bigText(var4);
      if(var2) {
         var5.setSummaryText(var3);
      }

   }

   public static void addInboxStyle(NotificationBuilderWithBuilderAccessor var0, CharSequence var1, boolean var2, CharSequence var3, ArrayList<CharSequence> var4) {
      InboxStyle var5 = (new InboxStyle(var0.getBuilder())).setBigContentTitle(var1);
      if(var2) {
         var5.setSummaryText(var3);
      }

      Iterator var6 = var4.iterator();

      while(var6.hasNext()) {
         var5.addLine((CharSequence)var6.next());
      }

   }

   public static SparseArray<Bundle> buildActionExtrasMap(List<Bundle> var0) {
      SparseArray var3 = null;
      int var1 = 0;

      SparseArray var4;
      for(int var2 = var0.size(); var1 < var2; var3 = var4) {
         Bundle var5 = (Bundle)var0.get(var1);
         var4 = var3;
         if(var5 != null) {
            var4 = var3;
            if(var3 == null) {
               var4 = new SparseArray();
            }

            var4.put(var1, var5);
         }

         ++var1;
      }

      return var3;
   }

   private static boolean ensureActionReflectionReadyLocked() {
      boolean var0 = true;
      if(sActionsAccessFailed) {
         return false;
      } else {
         try {
            if(sActionsField == null) {
               sActionClass = Class.forName("android.app.Notification$Action");
               sActionIconField = sActionClass.getDeclaredField("icon");
               sActionTitleField = sActionClass.getDeclaredField("title");
               sActionIntentField = sActionClass.getDeclaredField("actionIntent");
               sActionsField = Notification.class.getDeclaredField("actions");
               sActionsField.setAccessible(true);
            }
         } catch (ClassNotFoundException var2) {
            Log.e("NotificationCompat", "Unable to access notification actions", var2);
            sActionsAccessFailed = true;
         } catch (NoSuchFieldException var3) {
            Log.e("NotificationCompat", "Unable to access notification actions", var3);
            sActionsAccessFailed = true;
         }

         if(sActionsAccessFailed) {
            var0 = false;
         }

         return var0;
      }
   }

   public static NotificationCompatBase$Action getAction(Notification param0, int param1, NotificationCompatBase$Action$Factory param2, RemoteInputCompatBase$RemoteInput$Factory param3) {
      // $FF: Couldn't be decompiled
   }

   public static int getActionCount(Notification param0) {
      // $FF: Couldn't be decompiled
   }

   private static NotificationCompatBase$Action getActionFromBundle(Bundle var0, NotificationCompatBase$Action$Factory var1, RemoteInputCompatBase$RemoteInput$Factory var2) {
      return var1.build(var0.getInt("icon"), var0.getCharSequence("title"), (PendingIntent)var0.getParcelable("actionIntent"), var0.getBundle("extras"), RemoteInputCompatJellybean.fromBundleArray(BundleUtil.getBundleArrayFromBundle(var0, "remoteInputs"), var2));
   }

   private static Object[] getActionObjectsLocked(Notification param0) {
      // $FF: Couldn't be decompiled
   }

   public static NotificationCompatBase$Action[] getActionsFromParcelableArrayList(ArrayList<Parcelable> var0, NotificationCompatBase$Action$Factory var1, RemoteInputCompatBase$RemoteInput$Factory var2) {
      NotificationCompatBase$Action[] var4;
      if(var0 == null) {
         var4 = null;
      } else {
         NotificationCompatBase$Action[] var5 = var1.newArray(var0.size());
         int var3 = 0;

         while(true) {
            var4 = var5;
            if(var3 >= var5.length) {
               break;
            }

            var5[var3] = getActionFromBundle((Bundle)var0.get(var3), var1, var2);
            ++var3;
         }
      }

      return var4;
   }

   private static Bundle getBundleForAction(NotificationCompatBase$Action var0) {
      Bundle var1 = new Bundle();
      var1.putInt("icon", var0.getIcon());
      var1.putCharSequence("title", var0.getTitle());
      var1.putParcelable("actionIntent", var0.getActionIntent());
      var1.putBundle("extras", var0.getExtras());
      var1.putParcelableArray("remoteInputs", RemoteInputCompatJellybean.toBundleArray(var0.getRemoteInputs()));
      return var1;
   }

   public static Bundle getExtras(Notification param0) {
      // $FF: Couldn't be decompiled
   }

   public static String getGroup(Notification var0) {
      return getExtras(var0).getString("android.support.groupKey");
   }

   public static boolean getLocalOnly(Notification var0) {
      return getExtras(var0).getBoolean("android.support.localOnly");
   }

   public static ArrayList<Parcelable> getParcelableArrayListForActions(NotificationCompatBase$Action[] var0) {
      ArrayList var3;
      if(var0 == null) {
         var3 = null;
      } else {
         ArrayList var4 = new ArrayList(var0.length);
         int var2 = var0.length;
         int var1 = 0;

         while(true) {
            var3 = var4;
            if(var1 >= var2) {
               break;
            }

            var4.add(getBundleForAction(var0[var1]));
            ++var1;
         }
      }

      return var3;
   }

   public static String getSortKey(Notification var0) {
      return getExtras(var0).getString("android.support.sortKey");
   }

   public static boolean isGroupSummary(Notification var0) {
      return getExtras(var0).getBoolean("android.support.isGroupSummary");
   }

   public static NotificationCompatBase$Action readAction(NotificationCompatBase$Action$Factory var0, RemoteInputCompatBase$RemoteInput$Factory var1, int var2, CharSequence var3, PendingIntent var4, Bundle var5) {
      RemoteInputCompatBase$RemoteInput[] var6 = null;
      if(var5 != null) {
         var6 = RemoteInputCompatJellybean.fromBundleArray(BundleUtil.getBundleArrayFromBundle(var5, "android.support.remoteInputs"), var1);
      }

      return var0.build(var2, var3, var4, var5, var6);
   }

   public static Bundle writeActionAndGetExtras(Builder var0, NotificationCompatBase$Action var1) {
      var0.addAction(var1.getIcon(), var1.getTitle(), var1.getActionIntent());
      Bundle var2 = new Bundle(var1.getExtras());
      if(var1.getRemoteInputs() != null) {
         var2.putParcelableArray("android.support.remoteInputs", RemoteInputCompatJellybean.toBundleArray(var1.getRemoteInputs()));
      }

      return var2;
   }
}
