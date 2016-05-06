package android.support.v4.media;

import android.os.Parcelable;
import android.media.browse.MediaBrowser$MediaItem;
import android.os.Parcel;
import android.os.Bundle;
import android.service.media.MediaBrowserService;
import android.os.ResultReceiver;

private static class ServiceBinderProxyApi23 extends ServiceBinderProxyApi21
{
    ServiceImplApi23 mServiceImpl;
    
    ServiceBinderProxyApi23(final ServiceImplApi23 mServiceImpl) {
        super(mServiceImpl);
        this.mServiceImpl = mServiceImpl;
    }
    
    @Override
    public void getMediaItem(final String s, final ResultReceiver resultReceiver) {
        try {
            mServiceImpl.getMediaItem(s, new ItemCallback() {
                final /* synthetic */ ServiceBinderProxyApi23 this$0;
                final /* synthetic */ String val$KEY_MEDIA_ITEM = (String)MediaBrowserService.class.getDeclaredField("KEY_MEDIA_ITEM").get(null);
                final /* synthetic */ ResultReceiver val$receiver;
                
                MediaBrowserServiceCompatApi23$MediaBrowserServiceAdaptorApi23$ServiceBinderProxyApi23$1() {
                    this$0 = this$0;
                    super();
                }
                
                @Override
                public void onItemLoaded(final int n, final Bundle bundle, final Parcel parcel) {
                    if (parcel != null) {
                        parcel.setDataPosition(0);
                        bundle.putParcelable(val$KEY_MEDIA_ITEM, (Parcelable)(MediaBrowser$MediaItem)MediaBrowser$MediaItem.CREATOR.createFromParcel(parcel));
                        parcel.recycle();
                    }
                    resultReceiver.send(n, bundle);
                }
            });
        }
        catch (NoSuchFieldException ex) {}
        catch (IllegalAccessException ex2) {
            goto Label_0039;
        }
    }
}
