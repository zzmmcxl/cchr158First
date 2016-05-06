package android.support.v4.view;

import android.view.LayoutInflater$Factory2;
import android.view.LayoutInflater;

class LayoutInflaterCompatLollipop
{
    LayoutInflaterCompatLollipop() {
        super();
    }
    
    static void setFactory(final LayoutInflater layoutInflater, final LayoutInflaterFactory layoutInflaterFactory) {
        Object factory2;
        if (layoutInflaterFactory != null) {
            factory2 = new LayoutInflaterCompatHC.FactoryWrapperHC(layoutInflaterFactory);
        }
        else {
            factory2 = null;
        }
        layoutInflater.setFactory2((LayoutInflater$Factory2)factory2);
    }
}
