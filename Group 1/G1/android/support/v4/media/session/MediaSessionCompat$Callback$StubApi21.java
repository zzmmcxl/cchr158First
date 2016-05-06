package android.support.v4.media.session;

import android.support.v4.media.RatingCompat;
import android.content.Intent;
import android.net.Uri;
import android.os.ResultReceiver;
import android.os.Bundle;

private class StubApi21 implements MediaSessionCompatApi21.Callback
{
    final /* synthetic */ MediaSessionCompat.Callback this$0;
    
    private StubApi21(final MediaSessionCompat.Callback this$0) {
        this$0 = this$0;
        super();
    }
    
    StubApi21(final MediaSessionCompat.Callback callback, final MediaSessionCompat$1 object) {
        this(callback);
    }
    
    @Override
    public void onCommand(final String s, final Bundle bundle, final ResultReceiver resultReceiver) {
        this$0.onCommand(s, bundle, resultReceiver);
    }
    
    @Override
    public void onCustomAction(final String s, final Bundle bundle) {
        if (s.equals("android.support.v4.media.session.action.PLAY_FROM_URI")) {
            this$0.onPlayFromUri((Uri)bundle.getParcelable("android.support.v4.media.session.action.ARGUMENT_URI"), (Bundle)bundle.getParcelable("android.support.v4.media.session.action.ARGUMENT_EXTRAS"));
            return;
        }
        this$0.onCustomAction(s, bundle);
    }
    
    @Override
    public void onFastForward() {
        this$0.onFastForward();
    }
    
    @Override
    public boolean onMediaButtonEvent(final Intent intent) {
        return this$0.onMediaButtonEvent(intent);
    }
    
    @Override
    public void onPause() {
        this$0.onPause();
    }
    
    @Override
    public void onPlay() {
        this$0.onPlay();
    }
    
    @Override
    public void onPlayFromMediaId(final String s, final Bundle bundle) {
        this$0.onPlayFromMediaId(s, bundle);
    }
    
    @Override
    public void onPlayFromSearch(final String s, final Bundle bundle) {
        this$0.onPlayFromSearch(s, bundle);
    }
    
    @Override
    public void onRewind() {
        this$0.onRewind();
    }
    
    @Override
    public void onSeekTo(final long n) {
        this$0.onSeekTo(n);
    }
    
    @Override
    public void onSetRating(final Object o) {
        this$0.onSetRating(RatingCompat.fromRating(o));
    }
    
    @Override
    public void onSkipToNext() {
        this$0.onSkipToNext();
    }
    
    @Override
    public void onSkipToPrevious() {
        this$0.onSkipToPrevious();
    }
    
    @Override
    public void onSkipToQueueItem(final long n) {
        this$0.onSkipToQueueItem(n);
    }
    
    @Override
    public void onStop() {
        this$0.onStop();
    }
}
