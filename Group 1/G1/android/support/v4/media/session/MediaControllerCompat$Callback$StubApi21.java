package android.support.v4.media.session;

import android.os.Bundle;
import android.support.v4.media.MediaMetadataCompat;

private class StubApi21 implements MediaControllerCompatApi21.Callback
{
    final /* synthetic */ MediaControllerCompat.Callback this$0;
    
    private StubApi21(final MediaControllerCompat.Callback this$0) {
        this$0 = this$0;
        super();
    }
    
    StubApi21(final MediaControllerCompat.Callback callback, final MediaControllerCompat$1 object) {
        this(callback);
    }
    
    @Override
    public void onMetadataChanged(final Object o) {
        this$0.onMetadataChanged(MediaMetadataCompat.fromMediaMetadata(o));
    }
    
    @Override
    public void onPlaybackStateChanged(final Object o) {
        this$0.onPlaybackStateChanged(PlaybackStateCompat.fromPlaybackState(o));
    }
    
    @Override
    public void onSessionDestroyed() {
        this$0.onSessionDestroyed();
    }
    
    @Override
    public void onSessionEvent(final String s, final Bundle bundle) {
        this$0.onSessionEvent(s, bundle);
    }
}
