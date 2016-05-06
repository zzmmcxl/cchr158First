package android.support.v4.media;

import android.os.Parcel;
import android.support.annotation.NonNull;

interface ItemCallback
{
    void onError(@NonNull final String p0);
    
    void onItemLoaded(final Parcel p0);
}
