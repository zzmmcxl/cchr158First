package android.support.v4.media;

import android.os.ResultReceiver;
import android.os.Bundle;

static class ServiceBinderProxyApi21 extends Stub
{
    final ServiceImplApi21 mServiceImpl;
    
    ServiceBinderProxyApi21(final ServiceImplApi21 mServiceImpl) {
        super();
        this.mServiceImpl = mServiceImpl;
    }
    
    @Override
    public void addSubscription(final String s, final Object o) {
        mServiceImpl.addSubscription(s, new ServiceCallbacksApi21(o));
    }
    
    @Override
    public void connect(final String s, final Bundle bundle, final Object o) {
        mServiceImpl.connect(s, bundle, new ServiceCallbacksApi21(o));
    }
    
    @Override
    public void disconnect(final Object o) {
        mServiceImpl.disconnect(new ServiceCallbacksApi21(o));
    }
    
    @Override
    public void getMediaItem(final String s, final ResultReceiver resultReceiver) {
    }
    
    @Override
    public void removeSubscription(final String s, final Object o) {
        mServiceImpl.removeSubscription(s, new ServiceCallbacksApi21(o));
    }
}
