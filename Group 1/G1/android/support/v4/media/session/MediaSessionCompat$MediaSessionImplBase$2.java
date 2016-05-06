package android.support.v4.media.session;

import android.support.v4.media.RatingCompat;

class MediaSessionCompat$MediaSessionImplBase$2 implements MediaSessionCompatApi19.Callback {
    final /* synthetic */ MediaSessionImplBase this$0;
    
    MediaSessionCompat$MediaSessionImplBase$2(final MediaSessionImplBase this$0) {
        this$0 = this$0;
        super();
    }
    
    @Override
    public void onSeekTo(final long n) {
        MediaSessionImplBase.access$700(this$0, 11, n);
    }
    
    @Override
    public void onSetRating(final Object o) {
        MediaSessionImplBase.access$700(this$0, 12, RatingCompat.fromRating(o));
    }
}