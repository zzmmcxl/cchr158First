package android.support.v4.app;

import android.os.Bundle;

static final class TabInfo
{
    private final Bundle args;
    private final Class<?> clss;
    private Fragment fragment;
    private final String tag;
    
    TabInfo(final String tag, final Class<?> clss, final Bundle args) {
        super();
        this.tag = tag;
        this.clss = clss;
        this.args = args;
    }
    
    static /* synthetic */ Fragment access$100(final TabInfo tabInfo) {
        return tabInfo.fragment;
    }
    
    static /* synthetic */ Fragment access$102(final TabInfo tabInfo, final Fragment fragment) {
        return tabInfo.fragment = fragment;
    }
    
    static /* synthetic */ String access$200(final TabInfo tabInfo) {
        return tabInfo.tag;
    }
    
    static /* synthetic */ Class access$300(final TabInfo tabInfo) {
        return tabInfo.clss;
    }
    
    static /* synthetic */ Bundle access$400(final TabInfo tabInfo) {
        return tabInfo.args;
    }
}
