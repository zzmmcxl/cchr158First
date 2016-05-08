package android.support.v4.media;

import android.os.Bundle;
import android.os.Messenger;
import android.support.v4.media.session.MediaSessionCompat$Token;
import java.util.List;

interface MediaBrowserCompat$MediaBrowserServiceCallbackImpl {
   void onConnectionFailed(Messenger var1);

   void onLoadChildren(Messenger var1, String var2, List var3, Bundle var4);

   void onServiceConnected(Messenger var1, String var2, MediaSessionCompat$Token var3, Bundle var4);
}
