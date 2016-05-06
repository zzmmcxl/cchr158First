package android.support.v4.view;

import android.view.LayoutInflater;

interface LayoutInflaterCompatImpl
{
    LayoutInflaterFactory getFactory(final LayoutInflater p0);
    
    void setFactory(final LayoutInflater p0, final LayoutInflaterFactory p1);
}
