package android.support.v4.media;

import android.support.v4.media.session.MediaSessionCompat;
import android.content.ComponentName;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.os.Bundle;

interface MediaBrowserImpl
{
    void connect();
    
    void disconnect();
    
    @Nullable
    Bundle getExtras();
    
    void getItem(@NonNull final String p0, @NonNull final ItemCallback p1);
    
    @NonNull
    String getRoot();
    
    ComponentName getServiceComponent();
    
    @NonNull
    MediaSessionCompat.Token getSessionToken();
    
    boolean isConnected();
    
    void subscribe(@NonNull final String p0, final Bundle p1, @NonNull final SubscriptionCallback p2);
    
    void unsubscribe(@NonNull final String p0, final Bundle p1);
}
