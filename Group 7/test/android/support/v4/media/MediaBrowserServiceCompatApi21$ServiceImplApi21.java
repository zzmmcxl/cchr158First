package android.support.v4.media;

import android.os.Bundle;
import android.support.v4.media.MediaBrowserServiceCompatApi21$ServiceCallbacks;

public interface MediaBrowserServiceCompatApi21$ServiceImplApi21 {
   void addSubscription(String var1, MediaBrowserServiceCompatApi21$ServiceCallbacks var2);

   void connect(String var1, Bundle var2, MediaBrowserServiceCompatApi21$ServiceCallbacks var3);

   void disconnect(MediaBrowserServiceCompatApi21$ServiceCallbacks var1);

   void removeSubscription(String var1, MediaBrowserServiceCompatApi21$ServiceCallbacks var2);
}
