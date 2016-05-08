package android.support.v4.media;

import android.os.Bundle;
import android.support.v4.media.MediaBrowserCompat$SubscriptionCallback;
import android.support.v4.media.MediaBrowserCompatUtils;
import java.util.ArrayList;
import java.util.List;

class MediaBrowserCompat$Subscription {
   private final List<MediaBrowserCompat$SubscriptionCallback> mCallbacks = new ArrayList();
   private final List<Bundle> mOptionsList = new ArrayList();

   public MediaBrowserCompat$SubscriptionCallback getCallback(Bundle var1) {
      for(int var2 = 0; var2 < this.mOptionsList.size(); ++var2) {
         if(MediaBrowserCompatUtils.areSameOptions((Bundle)this.mOptionsList.get(var2), var1)) {
            return (MediaBrowserCompat$SubscriptionCallback)this.mCallbacks.get(var2);
         }
      }

      return null;
   }

   public List<MediaBrowserCompat$SubscriptionCallback> getCallbacks() {
      return this.mCallbacks;
   }

   public List<Bundle> getOptionsList() {
      return this.mOptionsList;
   }

   public boolean isEmpty() {
      return this.mCallbacks.isEmpty();
   }

   public boolean remove(Bundle var1) {
      for(int var2 = 0; var2 < this.mOptionsList.size(); ++var2) {
         if(MediaBrowserCompatUtils.areSameOptions((Bundle)this.mOptionsList.get(var2), var1)) {
            this.mCallbacks.remove(var2);
            this.mOptionsList.remove(var2);
            return true;
         }
      }

      return false;
   }

   public void setCallbackForOptions(MediaBrowserCompat$SubscriptionCallback var1, Bundle var2) {
      for(int var3 = 0; var3 < this.mOptionsList.size(); ++var3) {
         if(MediaBrowserCompatUtils.areSameOptions((Bundle)this.mOptionsList.get(var3), var2)) {
            this.mCallbacks.set(var3, var1);
            return;
         }
      }

      this.mCallbacks.add(var1);
      this.mOptionsList.add(var2);
   }
}
