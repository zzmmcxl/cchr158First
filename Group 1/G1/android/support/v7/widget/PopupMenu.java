package android.support.v7.widget;

import android.view.MenuItem;
import android.support.v7.view.menu.SubMenuBuilder;
import android.support.annotation.MenuRes;
import android.support.v7.view.SupportMenuInflater;
import android.view.MenuInflater;
import android.view.Menu;
import android.support.v7.appcompat.R;
import android.support.v7.view.menu.MenuPopupHelper;
import android.view.View$OnTouchListener;
import android.content.Context;
import android.view.View;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.view.menu.MenuBuilder;

public class PopupMenu implements MenuBuilder.Callback, MenuPresenter.Callback
{
    private View mAnchor;
    private Context mContext;
    private OnDismissListener mDismissListener;
    private View$OnTouchListener mDragListener;
    private MenuBuilder mMenu;
    private OnMenuItemClickListener mMenuItemClickListener;
    private MenuPopupHelper mPopup;
    
    public PopupMenu(final Context context, final View view) {
        this(context, view, 0);
    }
    
    public PopupMenu(final Context context, final View view, final int n) {
        this(context, view, n, R.attr.popupMenuStyle, 0);
    }
    
    public PopupMenu(final Context mContext, final View mAnchor, final int gravity, final int n, final int n2) {
        super();
        mContext = mContext;
        (mMenu = new MenuBuilder(mContext)).setCallback((MenuBuilder.Callback)this);
        mAnchor = mAnchor;
        (mPopup = new MenuPopupHelper(mContext, mMenu, mAnchor, false, n, n2)).setGravity(gravity);
        mPopup.setCallback(this);
    }
    
    static /* synthetic */ MenuPopupHelper access$000(final PopupMenu popupMenu) {
        return popupMenu.mPopup;
    }
    
    public void dismiss() {
        mPopup.dismiss();
    }
    
    public View$OnTouchListener getDragToOpenListener() {
        if (mDragListener == null) {
            mDragListener = (View$OnTouchListener)new ListPopupWindow.ForwardingListener(mAnchor) {
                final /* synthetic */ PopupMenu this$0;
                
                PopupMenu$1(final View view) {
                    this$0 = this$0;
                    super(view);
                }
                
                @Override
                public ListPopupWindow getPopup() {
                    return this$0.mPopup.getPopup();
                }
                
                @Override
                protected boolean onForwardingStarted() {
                    this$0.show();
                    return true;
                }
                
                @Override
                protected boolean onForwardingStopped() {
                    this$0.dismiss();
                    return true;
                }
            };
        }
        return mDragListener;
    }
    
    public int getGravity() {
        return mPopup.getGravity();
    }
    
    public Menu getMenu() {
        return (Menu)mMenu;
    }
    
    public MenuInflater getMenuInflater() {
        return new SupportMenuInflater(mContext);
    }
    
    public void inflate(@MenuRes final int n) {
        this.getMenuInflater().inflate(n, (Menu)mMenu);
    }
    
    @Override
    public void onCloseMenu(final MenuBuilder menuBuilder, final boolean b) {
        if (mDismissListener != null) {
            mDismissListener.onDismiss(this);
        }
    }
    
    public void onCloseSubMenu(final SubMenuBuilder subMenuBuilder) {
    }
    
    @Override
    public boolean onMenuItemSelected(final MenuBuilder menuBuilder, final MenuItem menuItem) {
        return mMenuItemClickListener != null && mMenuItemClickListener.onMenuItemClick(menuItem);
    }
    
    @Override
    public void onMenuModeChange(final MenuBuilder menuBuilder) {
    }
    
    @Override
    public boolean onOpenSubMenu(final MenuBuilder menuBuilder) {
        boolean b = true;
        if (menuBuilder == null) {
            b = false;
        }
        else if (menuBuilder.hasVisibleItems()) {
            new MenuPopupHelper(mContext, menuBuilder, mAnchor).show();
            return b;
        }
        return b;
    }
    
    public void setGravity(final int gravity) {
        mPopup.setGravity(gravity);
    }
    
    public void setOnDismissListener(final OnDismissListener mDismissListener) {
        this.mDismissListener = mDismissListener;
    }
    
    public void setOnMenuItemClickListener(final OnMenuItemClickListener mMenuItemClickListener) {
        this.mMenuItemClickListener = mMenuItemClickListener;
    }
    
    public void show() {
        mPopup.show();
    }
}
