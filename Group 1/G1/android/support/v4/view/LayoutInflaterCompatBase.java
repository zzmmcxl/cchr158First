package android.support.v4.view;

import android.view.View;
import android.util.AttributeSet;
import android.content.Context;
import android.view.LayoutInflater$Factory;
import android.view.LayoutInflater;

class LayoutInflaterCompatBase
{
    LayoutInflaterCompatBase() {
        super();
    }
    
    static LayoutInflaterFactory getFactory(final LayoutInflater layoutInflater) {
        final LayoutInflater$Factory factory = layoutInflater.getFactory();
        if (factory instanceof FactoryWrapper) {
            return ((FactoryWrapper)factory).mDelegateFactory;
        }
        return null;
    }
    
    static void setFactory(final LayoutInflater layoutInflater, final LayoutInflaterFactory layoutInflaterFactory) {
        Object factory;
        if (layoutInflaterFactory != null) {
            factory = new FactoryWrapper(layoutInflaterFactory);
        }
        else {
            factory = null;
        }
        layoutInflater.setFactory((LayoutInflater$Factory)factory);
    }
}
