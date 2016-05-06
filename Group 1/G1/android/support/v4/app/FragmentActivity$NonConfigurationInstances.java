package android.support.v4.app;

import android.support.v4.util.SimpleArrayMap;
import java.util.List;

static final class NonConfigurationInstances
{
    Object custom;
    List<Fragment> fragments;
    SimpleArrayMap<String, LoaderManager> loaders;
    
    NonConfigurationInstances() {
        super();
    }
}
