package android.support.v4.media;

import android.os.Binder;
import android.os.Bundle;

private class ServiceImplApi21 implements MediaBrowserServiceCompatApi21.ServiceImplApi21
{
    final ServiceImpl mServiceImpl;
    final /* synthetic */ MediaBrowserServiceCompat this$0;
    
    ServiceImplApi21(final MediaBrowserServiceCompat this$0) {
        this$0 = this$0;
        super();
        mServiceImpl = MediaBrowserServiceCompat.access$100(this$0).getServiceImpl();
    }
    
    @Override
    public void addSubscription(final String s, final MediaBrowserServiceCompatApi21.ServiceCallbacks serviceCallbacks) {
        mServiceImpl.addSubscription(s, null, this$0.new ServiceCallbacksApi21(serviceCallbacks));
    }
    
    @Override
    public void connect(final String s, final Bundle bundle, final MediaBrowserServiceCompatApi21.ServiceCallbacks serviceCallbacks) {
        mServiceImpl.connect(s, Binder.getCallingUid(), bundle, this$0.new ServiceCallbacksApi21(serviceCallbacks));
    }
    
    @Override
    public void disconnect(final MediaBrowserServiceCompatApi21.ServiceCallbacks serviceCallbacks) {
        mServiceImpl.disconnect(this$0.new ServiceCallbacksApi21(serviceCallbacks));
    }
    
    @Override
    public void removeSubscription(final String s, final MediaBrowserServiceCompatApi21.ServiceCallbacks serviceCallbacks) {
        mServiceImpl.removeSubscription(s, null, this$0.new ServiceCallbacksApi21(serviceCallbacks));
    }
}
