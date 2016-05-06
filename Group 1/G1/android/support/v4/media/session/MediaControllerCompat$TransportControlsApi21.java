package android.support.v4.media.session;

import android.support.v4.media.RatingCompat;
import android.os.Parcelable;
import android.net.Uri;
import android.os.Bundle;

static class TransportControlsApi21 extends TransportControls
{
    protected final Object mControlsObj;
    
    public TransportControlsApi21(final Object mControlsObj) {
        super();
        this.mControlsObj = mControlsObj;
    }
    
    @Override
    public void fastForward() {
        MediaControllerCompatApi21.TransportControls.fastForward(mControlsObj);
    }
    
    @Override
    public void pause() {
        MediaControllerCompatApi21.TransportControls.pause(mControlsObj);
    }
    
    @Override
    public void play() {
        MediaControllerCompatApi21.TransportControls.play(mControlsObj);
    }
    
    @Override
    public void playFromMediaId(final String s, final Bundle bundle) {
        MediaControllerCompatApi21.TransportControls.playFromMediaId(mControlsObj, s, bundle);
    }
    
    @Override
    public void playFromSearch(final String s, final Bundle bundle) {
        MediaControllerCompatApi21.TransportControls.playFromSearch(mControlsObj, s, bundle);
    }
    
    @Override
    public void playFromUri(final Uri uri, final Bundle bundle) {
        if (uri == null || Uri.EMPTY.equals((Object)uri)) {
            throw new IllegalArgumentException("You must specify a non-empty Uri for playFromUri.");
        }
        final Bundle bundle2 = new Bundle();
        bundle2.putParcelable("android.support.v4.media.session.action.ARGUMENT_URI", (Parcelable)uri);
        bundle2.putParcelable("android.support.v4.media.session.action.ARGUMENT_EXTRAS", (Parcelable)bundle);
        this.sendCustomAction("android.support.v4.media.session.action.PLAY_FROM_URI", bundle2);
    }
    
    @Override
    public void rewind() {
        MediaControllerCompatApi21.TransportControls.rewind(mControlsObj);
    }
    
    @Override
    public void seekTo(final long n) {
        MediaControllerCompatApi21.TransportControls.seekTo(mControlsObj, n);
    }
    
    @Override
    public void sendCustomAction(final PlaybackStateCompat.CustomAction customAction, final Bundle bundle) {
        MediaControllerCompatApi21.TransportControls.sendCustomAction(mControlsObj, customAction.getAction(), bundle);
    }
    
    @Override
    public void sendCustomAction(final String s, final Bundle bundle) {
        MediaControllerCompatApi21.TransportControls.sendCustomAction(mControlsObj, s, bundle);
    }
    
    @Override
    public void setRating(final RatingCompat ratingCompat) {
        final Object mControlsObj = this.mControlsObj;
        Object rating;
        if (ratingCompat != null) {
            rating = ratingCompat.getRating();
        }
        else {
            rating = null;
        }
        MediaControllerCompatApi21.TransportControls.setRating(mControlsObj, rating);
    }
    
    @Override
    public void skipToNext() {
        MediaControllerCompatApi21.TransportControls.skipToNext(mControlsObj);
    }
    
    @Override
    public void skipToPrevious() {
        MediaControllerCompatApi21.TransportControls.skipToPrevious(mControlsObj);
    }
    
    @Override
    public void skipToQueueItem(final long n) {
        MediaControllerCompatApi21.TransportControls.skipToQueueItem(mControlsObj, n);
    }
    
    @Override
    public void stop() {
        MediaControllerCompatApi21.TransportControls.stop(mControlsObj);
    }
}
