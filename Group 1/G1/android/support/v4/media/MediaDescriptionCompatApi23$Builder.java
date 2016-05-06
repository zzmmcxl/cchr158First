package android.support.v4.media;

import android.media.MediaDescription$Builder;
import android.net.Uri;

static class Builder extends MediaDescriptionCompatApi21.Builder
{
    Builder() {
        super();
    }
    
    public static void setMediaUri(final Object o, final Uri mediaUri) {
        ((MediaDescription$Builder)o).setMediaUri(mediaUri);
    }
}
