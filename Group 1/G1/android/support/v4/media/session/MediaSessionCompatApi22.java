package android.support.v4.media.session;

import android.media.session.MediaSession;

class MediaSessionCompatApi22
{
    MediaSessionCompatApi22() {
        super();
    }
    
    public static void setRatingType(final Object o, final int ratingType) {
        ((MediaSession)o).setRatingType(ratingType);
    }
}
