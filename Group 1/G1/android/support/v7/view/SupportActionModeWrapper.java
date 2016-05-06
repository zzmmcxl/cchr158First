package android.support.v7.view;

import android.support.v4.internal.view.SupportMenuItem;
import android.view.MenuItem;
import android.view.ActionMode$Callback;
import android.support.v4.util.SimpleArrayMap;
import java.util.ArrayList;
import android.view.MenuInflater;
import android.support.v7.view.menu.MenuWrapperFactory;
import android.support.v4.internal.view.SupportMenu;
import android.view.Menu;
import android.view.View;
import android.content.Context;
import android.annotation.TargetApi;
import android.view.ActionMode;

@TargetApi(11)
public class SupportActionModeWrapper extends ActionMode
{
    final Context mContext;
    final android.support.v7.view.ActionMode mWrappedObject;
    
    public SupportActionModeWrapper(final Context mContext, final android.support.v7.view.ActionMode mWrappedObject) {
        super();
        mContext = mContext;
        mWrappedObject = mWrappedObject;
    }
    
    public void finish() {
        mWrappedObject.finish();
    }
    
    public View getCustomView() {
        return mWrappedObject.getCustomView();
    }
    
    public Menu getMenu() {
        return MenuWrapperFactory.wrapSupportMenu(mContext, (SupportMenu)mWrappedObject.getMenu());
    }
    
    public MenuInflater getMenuInflater() {
        return mWrappedObject.getMenuInflater();
    }
    
    public CharSequence getSubtitle() {
        return mWrappedObject.getSubtitle();
    }
    
    public Object getTag() {
        return mWrappedObject.getTag();
    }
    
    public CharSequence getTitle() {
        return mWrappedObject.getTitle();
    }
    
    public boolean getTitleOptionalHint() {
        return mWrappedObject.getTitleOptionalHint();
    }
    
    public void invalidate() {
        mWrappedObject.invalidate();
    }
    
    public boolean isTitleOptional() {
        return mWrappedObject.isTitleOptional();
    }
    
    public void setCustomView(final View customView) {
        mWrappedObject.setCustomView(customView);
    }
    
    public void setSubtitle(final int subtitle) {
        mWrappedObject.setSubtitle(subtitle);
    }
    
    public void setSubtitle(final CharSequence subtitle) {
        mWrappedObject.setSubtitle(subtitle);
    }
    
    public void setTag(final Object tag) {
        mWrappedObject.setTag(tag);
    }
    
    public void setTitle(final int title) {
        mWrappedObject.setTitle(title);
    }
    
    public void setTitle(final CharSequence title) {
        mWrappedObject.setTitle(title);
    }
    
    public void setTitleOptionalHint(final boolean titleOptionalHint) {
        mWrappedObject.setTitleOptionalHint(titleOptionalHint);
    }
}
