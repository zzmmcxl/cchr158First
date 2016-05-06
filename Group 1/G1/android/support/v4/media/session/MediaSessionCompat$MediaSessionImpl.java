package android.support.v4.media.session;

import java.util.List;
import android.support.v4.media.VolumeProviderCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.app.PendingIntent;
import android.os.Handler;
import android.os.Bundle;

interface MediaSessionImpl
{
    Object getMediaSession();
    
    Object getRemoteControlClient();
    
    Token getSessionToken();
    
    boolean isActive();
    
    void release();
    
    void sendSessionEvent(final String p0, final Bundle p1);
    
    void setActive(final boolean p0);
    
    void setCallback(final Callback p0, final Handler p1);
    
    void setExtras(final Bundle p0);
    
    void setFlags(final int p0);
    
    void setMediaButtonReceiver(final PendingIntent p0);
    
    void setMetadata(final MediaMetadataCompat p0);
    
    void setPlaybackState(final PlaybackStateCompat p0);
    
    void setPlaybackToLocal(final int p0);
    
    void setPlaybackToRemote(final VolumeProviderCompat p0);
    
    void setQueue(final List<QueueItem> p0);
    
    void setQueueTitle(final CharSequence p0);
    
    void setRatingType(final int p0);
    
    void setSessionActivity(final PendingIntent p0);
}
