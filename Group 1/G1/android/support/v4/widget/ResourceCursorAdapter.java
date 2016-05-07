package android.support.v4.widget;

import android.view.View;
import android.view.ViewGroup;
import android.database.Cursor;
import android.content.Context;
import android.view.LayoutInflater;

public abstract class ResourceCursorAdapter extends CursorAdapter
{
    private int mDropDownLayout;
    private LayoutInflater mInflater;
    private int mLayout;
    
    public ResourceCursorAdapter(final Context context, final int n, final Cursor cursor) {
        super(context, cursor);
        mDropDownLayout = n;
        mLayout = n;
        mInflater = (LayoutInflater)context.getSystemService("layout_inflater");
    }
    
    public ResourceCursorAdapter(final Context context, final int n, final Cursor cursor, final int n2) {
        super(context, cursor, n2);
        mDropDownLayout = n;
        mLayout = n;
        mInflater = (LayoutInflater)context.getSystemService("layout_inflater");
    }
    
    public ResourceCursorAdapter(final Context context, final int n, final Cursor cursor, final boolean b) {
        super(context, cursor, b);
        mDropDownLayout = n;
        mLayout = n;
        mInflater = (LayoutInflater)context.getSystemService("layout_inflater");
    }
    
    @Override
    public View newDropDownView(final Context context, final Cursor cursor, final ViewGroup viewGroup) {
        return mInflater.inflate(mDropDownLayout, viewGroup, false);
    }
    
    @Override
    public View newView(final Context context, final Cursor cursor, final ViewGroup viewGroup) {
        return mInflater.inflate(mLayout, viewGroup, false);
    }
    
    public void setDropDownViewResource(final int mDropDownLayout) {
        this.mDropDownLayout = mDropDownLayout;
    }
    
    public void setViewResource(final int mLayout) {
        this.mLayout = mLayout;
    }
}