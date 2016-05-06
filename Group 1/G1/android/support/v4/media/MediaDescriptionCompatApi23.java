package android.support.v4.media;

import android.media.MediaDescription$Builder;
import android.media.MediaDescription;
import android.net.Uri;

class MediaDescriptionCompatApi23 extends MediaDescriptionCompatApi21
{
    MediaDescriptionCompatApi23() {
        super();
    }
    
    public static Uri getMediaUri(final Object o) {
        return ((MediaDescription)o).getMediaUri();
    }
}
