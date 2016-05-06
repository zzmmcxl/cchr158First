package android.support.v4.media.session;

import android.media.Rating;
import android.media.session.MediaController$TransportControls;
import android.media.session.MediaController$PlaybackInfo;
import android.media.AudioAttributes;
import android.media.session.PlaybackState;
import android.media.MediaMetadata;
import android.os.ResultReceiver;
import android.media.session.MediaController$Callback;
import android.os.Handler;
import android.app.PendingIntent;
import java.util.Collection;
import java.util.ArrayList;
import java.util.List;
import android.os.Bundle;
import android.media.session.MediaSession$Token;
import android.content.Context;
import android.view.KeyEvent;
import android.media.session.MediaController;

class MediaControllerCompatApi21
{
    MediaControllerCompatApi21() {
        super();
    }
    
    public static void adjustVolume(final Object o, final int n, final int n2) {
        ((MediaController)o).adjustVolume(n, n2);
    }
    
    public static Object createCallback(final Callback callback) {
        return new CallbackProxy(callback);
    }
    
    public static boolean dispatchMediaButtonEvent(final Object o, final KeyEvent keyEvent) {
        return ((MediaController)o).dispatchMediaButtonEvent(keyEvent);
    }
    
    public static Object fromToken(final Context context, final Object o) {
        return new MediaController(context, (MediaSession$Token)o);
    }
    
    public static Bundle getExtras(final Object o) {
        return ((MediaController)o).getExtras();
    }
    
    public static long getFlags(final Object o) {
        return ((MediaController)o).getFlags();
    }
    
    public static Object getMetadata(final Object o) {
        return ((MediaController)o).getMetadata();
    }
    
    public static String getPackageName(final Object o) {
        return ((MediaController)o).getPackageName();
    }
    
    public static Object getPlaybackInfo(final Object o) {
        return ((MediaController)o).getPlaybackInfo();
    }
    
    public static Object getPlaybackState(final Object o) {
        return ((MediaController)o).getPlaybackState();
    }
    
    public static List<Object> getQueue(final Object o) {
        final List queue = ((MediaController)o).getQueue();
        if (queue == null) {
            return null;
        }
        return new ArrayList<Object>(queue);
    }
    
    public static CharSequence getQueueTitle(final Object o) {
        return ((MediaController)o).getQueueTitle();
    }
    
    public static int getRatingType(final Object o) {
        return ((MediaController)o).getRatingType();
    }
    
    public static PendingIntent getSessionActivity(final Object o) {
        return ((MediaController)o).getSessionActivity();
    }
    
    public static Object getTransportControls(final Object o) {
        return ((MediaController)o).getTransportControls();
    }
    
    public static void registerCallback(final Object o, final Object o2, final Handler handler) {
        ((MediaController)o).registerCallback((MediaController$Callback)o2, handler);
    }
    
    public static void sendCommand(final Object o, final String s, final Bundle bundle, final ResultReceiver resultReceiver) {
        ((MediaController)o).sendCommand(s, bundle, resultReceiver);
    }
    
    public static void setVolumeTo(final Object o, final int n, final int n2) {
        ((MediaController)o).setVolumeTo(n, n2);
    }
    
    public static void unregisterCallback(final Object o, final Object o2) {
        ((MediaController)o).unregisterCallback((MediaController$Callback)o2);
    }
}
