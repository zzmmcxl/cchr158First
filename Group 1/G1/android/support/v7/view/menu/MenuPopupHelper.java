package android.support.v7.view.menu;

import java.util.ArrayList;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.util.AttributeSet;
import android.os.Parcelable;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.view.View$MeasureSpec;
import android.content.res.Resources;
import android.support.v7.appcompat.R;
import android.view.ViewTreeObserver;
import android.support.v7.widget.ListPopupWindow;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.content.Context;
import android.view.View;
import android.widget.PopupWindow$OnDismissListener;
import android.view.ViewTreeObserver$OnGlobalLayoutListener;
import android.view.View$OnKeyListener;
import android.widget.AdapterView$OnItemClickListener;

public class MenuPopupHelper implements AdapterView$OnItemClickListener, View$OnKeyListener, ViewTreeObserver$OnGlobalLayoutListener, PopupWindow$OnDismissListener, MenuPresenter
{
    static final int ITEM_LAYOUT = 0;
    private static final String TAG = "MenuPopupHelper";
    private final MenuAdapter mAdapter;
    private View mAnchorView;
    private int mContentWidth;
    private final Context mContext;
    private int mDropDownGravity;
    boolean mForceShowIcon;
    private boolean mHasContentWidth;
    private final LayoutInflater mInflater;
    private ViewGroup mMeasureParent;
    private final MenuBuilder mMenu;
    private final boolean mOverflowOnly;
    private ListPopupWindow mPopup;
    private final int mPopupMaxWidth;
    private final int mPopupStyleAttr;
    private final int mPopupStyleRes;
    private Callback mPresenterCallback;
    private ViewTreeObserver mTreeObserver;
    
    public MenuPopupHelper(final Context context, final MenuBuilder menuBuilder) {
        this(context, menuBuilder, null, false, R.attr.popupMenuStyle);
    }
    
    public MenuPopupHelper(final Context context, final MenuBuilder menuBuilder, final View view) {
        this(context, menuBuilder, view, false, R.attr.popupMenuStyle);
    }
    
    public MenuPopupHelper(final Context context, final MenuBuilder menuBuilder, final View view, final boolean b, final int n) {
        this(context, menuBuilder, view, b, n, 0);
    }
    
    public MenuPopupHelper(final Context mContext, final MenuBuilder mMenu, final View mAnchorView, final boolean mOverflowOnly, final int mPopupStyleAttr, final int mPopupStyleRes) {
        super();
        mDropDownGravity = 0;
        mContext = mContext;
        mInflater = LayoutInflater.from(mContext);
        mMenu = mMenu;
        mAdapter = new MenuAdapter(mMenu);
        mOverflowOnly = mOverflowOnly;
        mPopupStyleAttr = mPopupStyleAttr;
        mPopupStyleRes = mPopupStyleRes;
        final Resources resources = mContext.getResources();
        mPopupMaxWidth = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        mAnchorView = mAnchorView;
        mMenu.addMenuPresenter(this, mContext);
    }
    
    static /* synthetic */ boolean access$100(final MenuPopupHelper menuPopupHelper) {
        return menuPopupHelper.mOverflowOnly;
    }
    
    static /* synthetic */ LayoutInflater access$200(final MenuPopupHelper menuPopupHelper) {
        return menuPopupHelper.mInflater;
    }
    
    static /* synthetic */ MenuBuilder access$300(final MenuPopupHelper menuPopupHelper) {
        return menuPopupHelper.mMenu;
    }
    
    private int measureContentWidth() {
        int mPopupMaxWidth = 0;
        View view = null;
        int n = 0;
        final MenuAdapter mAdapter = this.mAdapter;
        final int measureSpec = View$MeasureSpec.makeMeasureSpec(0, 0);
        final int measureSpec2 = View$MeasureSpec.makeMeasureSpec(0, 0);
        for (int count = ((ListAdapter)mAdapter).getCount(), i = 0; i < count; ++i) {
            final int itemViewType = ((ListAdapter)mAdapter).getItemViewType(i);
            if (itemViewType != n) {
                n = itemViewType;
                view = null;
            }
            if (mMeasureParent == null) {
                mMeasureParent = (ViewGroup)new FrameLayout(mContext);
            }
            view = ((ListAdapter)mAdapter).getView(i, view, mMeasureParent);
            view.measure(measureSpec, measureSpec2);
            final int measuredWidth = view.getMeasuredWidth();
            if (measuredWidth >= this.mPopupMaxWidth) {
                mPopupMaxWidth = this.mPopupMaxWidth;
                break;
            }
            if (measuredWidth > mPopupMaxWidth) {
                mPopupMaxWidth = measuredWidth;
            }
        }
        return mPopupMaxWidth;
    }
    
    public boolean collapseItemActionView(final MenuBuilder menuBuilder, final MenuItemImpl menuItemImpl) {
        return false;
    }
    
    public void dismiss() {
        if (this.isShowing()) {
            mPopup.dismiss();
        }
    }
    
    public boolean expandItemActionView(final MenuBuilder menuBuilder, final MenuItemImpl menuItemImpl) {
        return false;
    }
    
    public boolean flagActionItems() {
        return false;
    }
    
    public int getGravity() {
        return mDropDownGravity;
    }
    
    public int getId() {
        return 0;
    }
    
    public MenuView getMenuView(final ViewGroup viewGroup) {
        throw new UnsupportedOperationException("MenuPopupHelpers manage their own views");
    }
    
    public ListPopupWindow getPopup() {
        return mPopup;
    }
    
    public void initForMenu(final Context context, final MenuBuilder menuBuilder) {
    }
    
    public boolean isShowing() {
        return mPopup != null && mPopup.isShowing();
    }
    
    public void onCloseMenu(final MenuBuilder menuBuilder, final boolean b) {
        if (menuBuilder == mMenu) {
            this.dismiss();
            if (mPresenterCallback != null) {
                mPresenterCallback.onCloseMenu(menuBuilder, b);
            }
        }
    }
    
    public void onDismiss() {
        mPopup = null;
        mMenu.close();
        if (mTreeObserver != null) {
            if (!mTreeObserver.isAlive()) {
                mTreeObserver = mAnchorView.getViewTreeObserver();
            }
            mTreeObserver.removeGlobalOnLayoutListener((ViewTreeObserver$OnGlobalLayoutListener)this);
            mTreeObserver = null;
        }
    }
    
    public void onGlobalLayout() {
        if (this.isShowing()) {
            final View mAnchorView = this.mAnchorView;
            if (mAnchorView == null || !mAnchorView.isShown()) {
                this.dismiss();
            }
            else if (this.isShowing()) {
                mPopup.show();
            }
        }
    }
    
    public void onItemClick(final AdapterView<?> adapterView, final View view, final int n, final long n2) {
        final MenuAdapter mAdapter = this.mAdapter;
        mAdapter.mAdapterMenu.performItemAction((MenuItem)mAdapter.getItem(n), 0);
    }
    
    public boolean onKey(final View view, final int n, final KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1 && n == 82) {
            this.dismiss();
            return true;
        }
        return false;
    }
    
    public void onRestoreInstanceState(final Parcelable parcelable) {
    }
    
    public Parcelable onSaveInstanceState() {
        return null;
    }
    
    public boolean onSubMenuSelected(final SubMenuBuilder subMenuBuilder) {
        if (subMenuBuilder.hasVisibleItems()) {
            final MenuPopupHelper menuPopupHelper = new MenuPopupHelper(mContext, subMenuBuilder, mAnchorView);
            menuPopupHelper.setCallback(mPresenterCallback);
            final int size = subMenuBuilder.size();
            int n = 0;
            boolean forceShowIcon;
            while (true) {
                forceShowIcon = false;
                if (n >= size) {
                    break;
                }
                final MenuItem item = subMenuBuilder.getItem(n);
                if (item.isVisible() && item.getIcon() != null) {
                    forceShowIcon = true;
                    break;
                }
                ++n;
            }
            menuPopupHelper.setForceShowIcon(forceShowIcon);
            if (menuPopupHelper.tryShow()) {
                if (mPresenterCallback != null) {
                    mPresenterCallback.onOpenSubMenu(subMenuBuilder);
                }
                return true;
            }
        }
        return false;
    }
    
    public void setAnchorView(final View mAnchorView) {
        this.mAnchorView = mAnchorView;
    }
    
    public void setCallback(final Callback mPresenterCallback) {
        this.mPresenterCallback = mPresenterCallback;
    }
    
    public void setForceShowIcon(final boolean mForceShowIcon) {
        this.mForceShowIcon = mForceShowIcon;
    }
    
    public void setGravity(final int mDropDownGravity) {
        this.mDropDownGravity = mDropDownGravity;
    }
    
    public void show() {
        if (!this.tryShow()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }
    
    public boolean tryShow() {
        (mPopup = new ListPopupWindow(mContext, null, mPopupStyleAttr, mPopupStyleRes)).setOnDismissListener((PopupWindow$OnDismissListener)this);
        mPopup.setOnItemClickListener((AdapterView$OnItemClickListener)this);
        mPopup.setAdapter((ListAdapter)mAdapter);
        mPopup.setModal(true);
        final View mAnchorView = this.mAnchorView;
        if (mAnchorView != null) {
            final ViewTreeObserver mTreeObserver = this.mTreeObserver;
            boolean b = false;
            if (mTreeObserver == null) {
                b = true;
            }
            this.mTreeObserver = mAnchorView.getViewTreeObserver();
            if (b) {
                this.mTreeObserver.addOnGlobalLayoutListener((ViewTreeObserver$OnGlobalLayoutListener)this);
            }
            mPopup.setAnchorView(mAnchorView);
            mPopup.setDropDownGravity(mDropDownGravity);
            if (!mHasContentWidth) {
                mContentWidth = this.measureContentWidth();
                mHasContentWidth = true;
            }
            mPopup.setContentWidth(mContentWidth);
            mPopup.setInputMethodMode(2);
            mPopup.show();
            mPopup.getListView().setOnKeyListener((View$OnKeyListener)this);
            return true;
        }
        return false;
    }
    
    public void updateMenuView(final boolean b) {
        mHasContentWidth = false;
        if (mAdapter != null) {
            mAdapter.notifyDataSetChanged();
        }
    }
}
