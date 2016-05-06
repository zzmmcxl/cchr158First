package android.support.v4.media.session;

import android.os.ResultReceiver;
import android.os.Handler;
import android.app.PendingIntent;
import java.util.List;
import android.support.v4.media.MediaMetadataCompat;
import android.os.Bundle;
import android.view.KeyEvent;

interface MediaControllerImpl
{
    void adjustVolume(final int p0, final int p1);
    
    boolean dispatchMediaButtonEvent(final KeyEvent p0);
    
    Bundle getExtras();
    
    long getFlags();
    
    Object getMediaController();
    
    MediaMetadataCompat getMetadata();
    
    String getPackageName();
    
    PlaybackInfo getPlaybackInfo();
    
    PlaybackStateCompat getPlaybackState();
    
    List<MediaSessionCompat.QueueItem> getQueue();
    
    CharSequence getQueueTitle();
    
    int getRatingType();
    
    PendingIntent getSessionActivity();
    
    TransportControls getTransportControls();
    
    void registerCallback(final Callback p0, final Handler p1);
    
    void sendCommand(final String p0, final Bundle p1, final ResultReceiver p2);
    
    void setVolumeTo(final int p0, final int p1);
    
    void unregisterCallback(final Callback p0);
}
