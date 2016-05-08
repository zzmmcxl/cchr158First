package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationCompat$Action;
import android.support.v4.app.NotificationCompat$Builder;
import android.support.v4.app.NotificationCompat$Extender;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class NotificationCompat$WearableExtender implements NotificationCompat$Extender {
   private static final int DEFAULT_CONTENT_ICON_GRAVITY = 8388613;
   private static final int DEFAULT_FLAGS = 1;
   private static final int DEFAULT_GRAVITY = 80;
   private static final String EXTRA_WEARABLE_EXTENSIONS = "android.wearable.EXTENSIONS";
   private static final int FLAG_CONTENT_INTENT_AVAILABLE_OFFLINE = 1;
   private static final int FLAG_HINT_AVOID_BACKGROUND_CLIPPING = 16;
   private static final int FLAG_HINT_HIDE_ICON = 2;
   private static final int FLAG_HINT_SHOW_BACKGROUND_ONLY = 4;
   private static final int FLAG_START_SCROLL_BOTTOM = 8;
   private static final String KEY_ACTIONS = "actions";
   private static final String KEY_BACKGROUND = "background";
   private static final String KEY_CONTENT_ACTION_INDEX = "contentActionIndex";
   private static final String KEY_CONTENT_ICON = "contentIcon";
   private static final String KEY_CONTENT_ICON_GRAVITY = "contentIconGravity";
   private static final String KEY_CUSTOM_CONTENT_HEIGHT = "customContentHeight";
   private static final String KEY_CUSTOM_SIZE_PRESET = "customSizePreset";
   private static final String KEY_DISPLAY_INTENT = "displayIntent";
   private static final String KEY_FLAGS = "flags";
   private static final String KEY_GRAVITY = "gravity";
   private static final String KEY_HINT_SCREEN_TIMEOUT = "hintScreenTimeout";
   private static final String KEY_PAGES = "pages";
   public static final int SCREEN_TIMEOUT_LONG = -1;
   public static final int SCREEN_TIMEOUT_SHORT = 0;
   public static final int SIZE_DEFAULT = 0;
   public static final int SIZE_FULL_SCREEN = 5;
   public static final int SIZE_LARGE = 4;
   public static final int SIZE_MEDIUM = 3;
   public static final int SIZE_SMALL = 2;
   public static final int SIZE_XSMALL = 1;
   public static final int UNSET_ACTION_INDEX = -1;
   private ArrayList<NotificationCompat$Action> mActions = new ArrayList();
   private Bitmap mBackground;
   private int mContentActionIndex = -1;
   private int mContentIcon;
   private int mContentIconGravity = 8388613;
   private int mCustomContentHeight;
   private int mCustomSizePreset = 0;
   private PendingIntent mDisplayIntent;
   private int mFlags = 1;
   private int mGravity = 80;
   private int mHintScreenTimeout;
   private ArrayList<Notification> mPages = new ArrayList();

   public NotificationCompat$WearableExtender() {
   }

   public NotificationCompat$WearableExtender(Notification var1) {
      Bundle var3 = NotificationCompat.getExtras(var1);
      if(var3 != null) {
         var3 = var3.getBundle("android.wearable.EXTENSIONS");
      } else {
         var3 = null;
      }

      if(var3 != null) {
         NotificationCompat$Action[] var2 = NotificationCompat.access$200().getActionsFromParcelableArrayList(var3.getParcelableArrayList("actions"));
         if(var2 != null) {
            Collections.addAll(this.mActions, var2);
         }

         this.mFlags = var3.getInt("flags", 1);
         this.mDisplayIntent = (PendingIntent)var3.getParcelable("displayIntent");
         Notification[] var4 = NotificationCompat.access$500(var3, "pages");
         if(var4 != null) {
            Collections.addAll(this.mPages, var4);
         }

         this.mBackground = (Bitmap)var3.getParcelable("background");
         this.mContentIcon = var3.getInt("contentIcon");
         this.mContentIconGravity = var3.getInt("contentIconGravity", 8388613);
         this.mContentActionIndex = var3.getInt("contentActionIndex", -1);
         this.mCustomSizePreset = var3.getInt("customSizePreset", 0);
         this.mCustomContentHeight = var3.getInt("customContentHeight");
         this.mGravity = var3.getInt("gravity", 80);
         this.mHintScreenTimeout = var3.getInt("hintScreenTimeout");
      }

   }

   private void setFlag(int var1, boolean var2) {
      if(var2) {
         this.mFlags |= var1;
      } else {
         this.mFlags &= ~var1;
      }
   }

   public NotificationCompat$WearableExtender addAction(NotificationCompat$Action var1) {
      this.mActions.add(var1);
      return this;
   }

   public NotificationCompat$WearableExtender addActions(List<NotificationCompat$Action> var1) {
      this.mActions.addAll(var1);
      return this;
   }

   public NotificationCompat$WearableExtender addPage(Notification var1) {
      this.mPages.add(var1);
      return this;
   }

   public NotificationCompat$WearableExtender addPages(List<Notification> var1) {
      this.mPages.addAll(var1);
      return this;
   }

   public NotificationCompat$WearableExtender clearActions() {
      this.mActions.clear();
      return this;
   }

   public NotificationCompat$WearableExtender clearPages() {
      this.mPages.clear();
      return this;
   }

   public NotificationCompat$WearableExtender clone() {
      NotificationCompat$WearableExtender var1 = new NotificationCompat$WearableExtender();
      var1.mActions = new ArrayList(this.mActions);
      var1.mFlags = this.mFlags;
      var1.mDisplayIntent = this.mDisplayIntent;
      var1.mPages = new ArrayList(this.mPages);
      var1.mBackground = this.mBackground;
      var1.mContentIcon = this.mContentIcon;
      var1.mContentIconGravity = this.mContentIconGravity;
      var1.mContentActionIndex = this.mContentActionIndex;
      var1.mCustomSizePreset = this.mCustomSizePreset;
      var1.mCustomContentHeight = this.mCustomContentHeight;
      var1.mGravity = this.mGravity;
      var1.mHintScreenTimeout = this.mHintScreenTimeout;
      return var1;
   }

   public NotificationCompat$Builder extend(NotificationCompat$Builder var1) {
      Bundle var2 = new Bundle();
      if(!this.mActions.isEmpty()) {
         var2.putParcelableArrayList("actions", NotificationCompat.access$200().getParcelableArrayListForActions((NotificationCompat$Action[])this.mActions.toArray(new NotificationCompat$Action[this.mActions.size()])));
      }

      if(this.mFlags != 1) {
         var2.putInt("flags", this.mFlags);
      }

      if(this.mDisplayIntent != null) {
         var2.putParcelable("displayIntent", this.mDisplayIntent);
      }

      if(!this.mPages.isEmpty()) {
         var2.putParcelableArray("pages", (Parcelable[])this.mPages.toArray(new Notification[this.mPages.size()]));
      }

      if(this.mBackground != null) {
         var2.putParcelable("background", this.mBackground);
      }

      if(this.mContentIcon != 0) {
         var2.putInt("contentIcon", this.mContentIcon);
      }

      if(this.mContentIconGravity != 8388613) {
         var2.putInt("contentIconGravity", this.mContentIconGravity);
      }

      if(this.mContentActionIndex != -1) {
         var2.putInt("contentActionIndex", this.mContentActionIndex);
      }

      if(this.mCustomSizePreset != 0) {
         var2.putInt("customSizePreset", this.mCustomSizePreset);
      }

      if(this.mCustomContentHeight != 0) {
         var2.putInt("customContentHeight", this.mCustomContentHeight);
      }

      if(this.mGravity != 80) {
         var2.putInt("gravity", this.mGravity);
      }

      if(this.mHintScreenTimeout != 0) {
         var2.putInt("hintScreenTimeout", this.mHintScreenTimeout);
      }

      var1.getExtras().putBundle("android.wearable.EXTENSIONS", var2);
      return var1;
   }

   public List<NotificationCompat$Action> getActions() {
      return this.mActions;
   }

   public Bitmap getBackground() {
      return this.mBackground;
   }

   public int getContentAction() {
      return this.mContentActionIndex;
   }

   public int getContentIcon() {
      return this.mContentIcon;
   }

   public int getContentIconGravity() {
      return this.mContentIconGravity;
   }

   public boolean getContentIntentAvailableOffline() {
      return (this.mFlags & 1) != 0;
   }

   public int getCustomContentHeight() {
      return this.mCustomContentHeight;
   }

   public int getCustomSizePreset() {
      return this.mCustomSizePreset;
   }

   public PendingIntent getDisplayIntent() {
      return this.mDisplayIntent;
   }

   public int getGravity() {
      return this.mGravity;
   }

   public boolean getHintAvoidBackgroundClipping() {
      return (this.mFlags & 16) != 0;
   }

   public boolean getHintHideIcon() {
      return (this.mFlags & 2) != 0;
   }

   public int getHintScreenTimeout() {
      return this.mHintScreenTimeout;
   }

   public boolean getHintShowBackgroundOnly() {
      return (this.mFlags & 4) != 0;
   }

   public List<Notification> getPages() {
      return this.mPages;
   }

   public boolean getStartScrollBottom() {
      return (this.mFlags & 8) != 0;
   }

   public NotificationCompat$WearableExtender setBackground(Bitmap var1) {
      this.mBackground = var1;
      return this;
   }

   public NotificationCompat$WearableExtender setContentAction(int var1) {
      this.mContentActionIndex = var1;
      return this;
   }

   public NotificationCompat$WearableExtender setContentIcon(int var1) {
      this.mContentIcon = var1;
      return this;
   }

   public NotificationCompat$WearableExtender setContentIconGravity(int var1) {
      this.mContentIconGravity = var1;
      return this;
   }

   public NotificationCompat$WearableExtender setContentIntentAvailableOffline(boolean var1) {
      this.setFlag(1, var1);
      return this;
   }

   public NotificationCompat$WearableExtender setCustomContentHeight(int var1) {
      this.mCustomContentHeight = var1;
      return this;
   }

   public NotificationCompat$WearableExtender setCustomSizePreset(int var1) {
      this.mCustomSizePreset = var1;
      return this;
   }

   public NotificationCompat$WearableExtender setDisplayIntent(PendingIntent var1) {
      this.mDisplayIntent = var1;
      return this;
   }

   public NotificationCompat$WearableExtender setGravity(int var1) {
      this.mGravity = var1;
      return this;
   }

   public NotificationCompat$WearableExtender setHintAvoidBackgroundClipping(boolean var1) {
      this.setFlag(16, var1);
      return this;
   }

   public NotificationCompat$WearableExtender setHintHideIcon(boolean var1) {
      this.setFlag(2, var1);
      return this;
   }

   public NotificationCompat$WearableExtender setHintScreenTimeout(int var1) {
      this.mHintScreenTimeout = var1;
      return this;
   }

   public NotificationCompat$WearableExtender setHintShowBackgroundOnly(boolean var1) {
      this.setFlag(4, var1);
      return this;
   }

   public NotificationCompat$WearableExtender setStartScrollBottom(boolean var1) {
      this.setFlag(8, var1);
      return this;
   }
}
