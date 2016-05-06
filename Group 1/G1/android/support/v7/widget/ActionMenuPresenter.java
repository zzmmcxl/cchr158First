package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.view.View$OnTouchListener;
import android.util.AttributeSet;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.view.menu.MenuPopupHelper;
import android.support.v7.transition.ActionBarTransition;
import android.support.v7.view.menu.SubMenuBuilder;
import android.os.Parcelable;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v7.view.ActionBarPolicy;
import android.view.ViewGroup$LayoutParams;
import java.util.ArrayList;
import android.view.View$MeasureSpec;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.MenuItemImpl;
import android.view.ViewGroup;
import android.view.MenuItem;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuView;
import android.support.v7.appcompat.R;
import android.content.Context;
import android.view.View;
import android.graphics.drawable.Drawable;
import android.util.SparseBooleanArray;
import android.support.v4.view.ActionProvider;
import android.support.v7.view.menu.BaseMenuPresenter;

class ActionMenuPresenter extends BaseMenuPresenter implements SubUiVisibilityListener
{
    private static final String TAG = "ActionMenuPresenter";
    private final SparseBooleanArray mActionButtonGroups;
    private ActionButtonSubmenu mActionButtonPopup;
    private int mActionItemWidthLimit;
    private boolean mExpandedActionViewsExclusive;
    private int mMaxItems;
    private boolean mMaxItemsSet;
    private int mMinCellSize;
    int mOpenSubMenuId;
    private OverflowMenuButton mOverflowButton;
    private OverflowPopup mOverflowPopup;
    private Drawable mPendingOverflowIcon;
    private boolean mPendingOverflowIconSet;
    private ActionMenuPopupCallback mPopupCallback;
    final PopupPresenterCallback mPopupPresenterCallback;
    private OpenOverflowRunnable mPostedOpenRunnable;
    private boolean mReserveOverflow;
    private boolean mReserveOverflowSet;
    private View mScrapActionButtonView;
    private boolean mStrictWidthLimit;
    private int mWidthLimit;
    private boolean mWidthLimitSet;
    
    public ActionMenuPresenter(final Context context) {
        super(context, R.layout.abc_action_menu_layout, R.layout.abc_action_menu_item_layout);
        mActionButtonGroups = new SparseBooleanArray();
        mPopupPresenterCallback = new PopupPresenterCallback(this);
    }
    
    static /* synthetic */ MenuView access$1000(final ActionMenuPresenter actionMenuPresenter) {
        return actionMenuPresenter.mMenuView;
    }
    
    static /* synthetic */ OverflowPopup access$200(final ActionMenuPresenter actionMenuPresenter) {
        return actionMenuPresenter.mOverflowPopup;
    }
    
    static /* synthetic */ OverflowPopup access$202(final ActionMenuPresenter actionMenuPresenter, final OverflowPopup mOverflowPopup) {
        return actionMenuPresenter.mOverflowPopup = mOverflowPopup;
    }
    
    static /* synthetic */ OpenOverflowRunnable access$300(final ActionMenuPresenter actionMenuPresenter) {
        return actionMenuPresenter.mPostedOpenRunnable;
    }
    
    static /* synthetic */ OpenOverflowRunnable access$302(final ActionMenuPresenter actionMenuPresenter, final OpenOverflowRunnable mPostedOpenRunnable) {
        return actionMenuPresenter.mPostedOpenRunnable = mPostedOpenRunnable;
    }
    
    static /* synthetic */ MenuBuilder access$400(final ActionMenuPresenter actionMenuPresenter) {
        return actionMenuPresenter.mMenu;
    }
    
    static /* synthetic */ MenuBuilder access$500(final ActionMenuPresenter actionMenuPresenter) {
        return actionMenuPresenter.mMenu;
    }
    
    static /* synthetic */ OverflowMenuButton access$600(final ActionMenuPresenter actionMenuPresenter) {
        return actionMenuPresenter.mOverflowButton;
    }
    
    static /* synthetic */ MenuView access$700(final ActionMenuPresenter actionMenuPresenter) {
        return actionMenuPresenter.mMenuView;
    }
    
    static /* synthetic */ ActionButtonSubmenu access$800(final ActionMenuPresenter actionMenuPresenter) {
        return actionMenuPresenter.mActionButtonPopup;
    }
    
    static /* synthetic */ ActionButtonSubmenu access$802(final ActionMenuPresenter actionMenuPresenter, final ActionButtonSubmenu mActionButtonPopup) {
        return actionMenuPresenter.mActionButtonPopup = mActionButtonPopup;
    }
    
    static /* synthetic */ MenuBuilder access$900(final ActionMenuPresenter actionMenuPresenter) {
        return actionMenuPresenter.mMenu;
    }
    
    private View findViewForItem(final MenuItem menuItem) {
        final ViewGroup viewGroup = (ViewGroup)this.mMenuView;
        if (viewGroup != null) {
            for (int childCount = viewGroup.getChildCount(), i = 0; i < childCount; ++i) {
                final Object child = viewGroup.getChildAt(i);
                if (child instanceof MenuView.ItemView && ((MenuView.ItemView)child).getItemData() == menuItem) {
                    return (View)child;
                }
            }
            return null;
        }
        final Object child = null;
        return (View)child;
    }
    
    @Override
    public void bindItemView(final MenuItemImpl menuItemImpl, final MenuView.ItemView itemView) {
        itemView.initialize(menuItemImpl, 0);
        final ActionMenuView itemInvoker = (ActionMenuView)this.mMenuView;
        final ActionMenuItemView actionMenuItemView = (ActionMenuItemView)itemView;
        actionMenuItemView.setItemInvoker(itemInvoker);
        if (mPopupCallback == null) {
            mPopupCallback = new ActionMenuPopupCallback(this);
        }
        actionMenuItemView.setPopupCallback((ActionMenuItemView.PopupCallback)mPopupCallback);
    }
    
    public boolean dismissPopupMenus() {
        return this.hideOverflowMenu() | this.hideSubMenus();
    }
    
    public boolean filterLeftoverView(final ViewGroup viewGroup, final int n) {
        return viewGroup.getChildAt(n) != mOverflowButton && super.filterLeftoverView(viewGroup, n);
    }
    
    @Override
    public boolean flagActionItems() {
        final ArrayList<MenuItemImpl> visibleItems = this.mMenu.getVisibleItems();
        final int size = visibleItems.size();
        int mMaxItems = this.mMaxItems;
        int mActionItemWidthLimit = this.mActionItemWidthLimit;
        final int measureSpec = View$MeasureSpec.makeMeasureSpec(0, 0);
        final ViewGroup viewGroup = (ViewGroup)this.mMenuView;
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        boolean b = false;
        for (int i = 0; i < size; ++i) {
            final MenuItemImpl menuItemImpl = (MenuItemImpl)visibleItems.get(i);
            if (menuItemImpl.requiresActionButton()) {
                ++n;
            }
            else if (menuItemImpl.requestsActionButton()) {
                ++n2;
            }
            else {
                b = true;
            }
            if (mExpandedActionViewsExclusive && menuItemImpl.isActionViewExpanded()) {
                mMaxItems = 0;
            }
        }
        if (mReserveOverflow && (b || n + n2 > mMaxItems)) {
            --mMaxItems;
        }
        int n4 = mMaxItems - n;
        final SparseBooleanArray mActionButtonGroups = this.mActionButtonGroups;
        mActionButtonGroups.clear();
        final boolean mStrictWidthLimit = this.mStrictWidthLimit;
        int n5 = 0;
        int n6 = 0;
        if (mStrictWidthLimit) {
            n6 = mActionItemWidthLimit / mMinCellSize;
            n5 = mMinCellSize + mActionItemWidthLimit % mMinCellSize / n6;
        }
        for (int j = 0; j < size; ++j) {
            final MenuItemImpl menuItemImpl2 = (MenuItemImpl)visibleItems.get(j);
            if (menuItemImpl2.requiresActionButton()) {
                final View itemView = this.getItemView(menuItemImpl2, mScrapActionButtonView, viewGroup);
                if (mScrapActionButtonView == null) {
                    mScrapActionButtonView = itemView;
                }
                if (this.mStrictWidthLimit) {
                    n6 -= ActionMenuView.measureChildForCells(itemView, n5, n6, measureSpec, 0);
                }
                else {
                    itemView.measure(measureSpec, measureSpec);
                }
                final int measuredWidth = itemView.getMeasuredWidth();
                mActionItemWidthLimit -= measuredWidth;
                if (n3 == 0) {
                    n3 = measuredWidth;
                }
                final int groupId = menuItemImpl2.getGroupId();
                if (groupId != 0) {
                    mActionButtonGroups.put(groupId, true);
                }
                menuItemImpl2.setIsActionButton(true);
            }
            else if (menuItemImpl2.requestsActionButton()) {
                final int groupId2 = menuItemImpl2.getGroupId();
                final boolean value = mActionButtonGroups.get(groupId2);
                boolean isActionButton = (n4 > 0 || value) && mActionItemWidthLimit > 0 && (!this.mStrictWidthLimit || n6 > 0);
                if (isActionButton) {
                    final View itemView2 = this.getItemView(menuItemImpl2, mScrapActionButtonView, viewGroup);
                    if (mScrapActionButtonView == null) {
                        mScrapActionButtonView = itemView2;
                    }
                    if (this.mStrictWidthLimit) {
                        final int measureChildForCells = ActionMenuView.measureChildForCells(itemView2, n5, n6, measureSpec, 0);
                        n6 -= measureChildForCells;
                        if (measureChildForCells == 0) {
                            isActionButton = false;
                        }
                    }
                    else {
                        itemView2.measure(measureSpec, measureSpec);
                    }
                    final int measuredWidth2 = itemView2.getMeasuredWidth();
                    mActionItemWidthLimit -= measuredWidth2;
                    if (n3 == 0) {
                        n3 = measuredWidth2;
                    }
                    if (this.mStrictWidthLimit) {
                        isActionButton &= (mActionItemWidthLimit >= 0);
                    }
                    else {
                        isActionButton &= (mActionItemWidthLimit + n3 > 0);
                    }
                }
                if (isActionButton && groupId2 != 0) {
                    mActionButtonGroups.put(groupId2, true);
                }
                else if (value) {
                    mActionButtonGroups.put(groupId2, false);
                    for (int k = 0; k < j; ++k) {
                        final MenuItemImpl menuItemImpl3 = (MenuItemImpl)visibleItems.get(k);
                        if (menuItemImpl3.getGroupId() == groupId2) {
                            if (menuItemImpl3.isActionButton()) {
                                ++n4;
                            }
                            menuItemImpl3.setIsActionButton(false);
                        }
                    }
                }
                if (isActionButton) {
                    --n4;
                }
                menuItemImpl2.setIsActionButton(isActionButton);
            }
            else {
                menuItemImpl2.setIsActionButton(false);
            }
        }
        return true;
    }
    
    @Override
    public View getItemView(final MenuItemImpl menuItemImpl, final View view, final ViewGroup viewGroup) {
        View view2 = menuItemImpl.getActionView();
        if (view2 == null || menuItemImpl.hasCollapsibleActionView()) {
            view2 = super.getItemView(menuItemImpl, view, viewGroup);
        }
        int visibility;
        if (menuItemImpl.isActionViewExpanded()) {
            visibility = 8;
        }
        else {
            visibility = 0;
        }
        view2.setVisibility(visibility);
        final ActionMenuView actionMenuView = (ActionMenuView)viewGroup;
        final ViewGroup$LayoutParams layoutParams = view2.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            view2.setLayoutParams((ViewGroup$LayoutParams)actionMenuView.generateLayoutParams(layoutParams));
        }
        return view2;
    }
    
    @Override
    public MenuView getMenuView(final ViewGroup viewGroup) {
        final MenuView menuView = super.getMenuView(viewGroup);
        ((ActionMenuView)menuView).setPresenter(this);
        return menuView;
    }
    
    public Drawable getOverflowIcon() {
        if (mOverflowButton != null) {
            return mOverflowButton.getDrawable();
        }
        if (mPendingOverflowIconSet) {
            return mPendingOverflowIcon;
        }
        return null;
    }
    
    public boolean hideOverflowMenu() {
        if (mPostedOpenRunnable != null && this.mMenuView != null) {
            ((View)this.mMenuView).removeCallbacks((Runnable)mPostedOpenRunnable);
            mPostedOpenRunnable = null;
            return true;
        }
        final OverflowPopup mOverflowPopup = this.mOverflowPopup;
        if (mOverflowPopup != null) {
            mOverflowPopup.dismiss();
            return true;
        }
        return false;
    }
    
    public boolean hideSubMenus() {
        if (mActionButtonPopup != null) {
            mActionButtonPopup.dismiss();
            return true;
        }
        return false;
    }
    
    @Override
    public void initForMenu(final Context context, final MenuBuilder menuBuilder) {
        super.initForMenu(context, menuBuilder);
        final Resources resources = context.getResources();
        final ActionBarPolicy value = ActionBarPolicy.get(context);
        if (!mReserveOverflowSet) {
            mReserveOverflow = value.showsOverflowMenuButton();
        }
        if (!mWidthLimitSet) {
            mWidthLimit = value.getEmbeddedMenuWidthLimit();
        }
        if (!mMaxItemsSet) {
            mMaxItems = value.getMaxActionButtons();
        }
        int mWidthLimit = this.mWidthLimit;
        if (mReserveOverflow) {
            if (mOverflowButton == null) {
                mOverflowButton = new OverflowMenuButton(this.mSystemContext);
                if (mPendingOverflowIconSet) {
                    mOverflowButton.setImageDrawable(mPendingOverflowIcon);
                    mPendingOverflowIcon = null;
                    mPendingOverflowIconSet = false;
                }
                final int measureSpec = View$MeasureSpec.makeMeasureSpec(0, 0);
                mOverflowButton.measure(measureSpec, measureSpec);
            }
            mWidthLimit -= mOverflowButton.getMeasuredWidth();
        }
        else {
            mOverflowButton = null;
        }
        mActionItemWidthLimit = mWidthLimit;
        mMinCellSize = (int)(56.0f * resources.getDisplayMetrics().density);
        mScrapActionButtonView = null;
    }
    
    public boolean isOverflowMenuShowPending() {
        return mPostedOpenRunnable != null || this.isOverflowMenuShowing();
    }
    
    public boolean isOverflowMenuShowing() {
        return mOverflowPopup != null && mOverflowPopup.isShowing();
    }
    
    public boolean isOverflowReserved() {
        return mReserveOverflow;
    }
    
    @Override
    public void onCloseMenu(final MenuBuilder menuBuilder, final boolean b) {
        this.dismissPopupMenus();
        super.onCloseMenu(menuBuilder, b);
    }
    
    public void onConfigurationChanged(final Configuration configuration) {
        if (!mMaxItemsSet) {
            mMaxItems = this.mContext.getResources().getInteger(R.integer.abc_max_action_buttons);
        }
        if (this.mMenu != null) {
            this.mMenu.onItemsChanged(true);
        }
    }
    
    @Override
    public void onRestoreInstanceState(final Parcelable parcelable) {
        final SavedState savedState = (SavedState)parcelable;
        if (savedState.openSubMenuId > 0) {
            final MenuItem item = this.mMenu.findItem(savedState.openSubMenuId);
            if (item != null) {
                this.onSubMenuSelected((SubMenuBuilder)item.getSubMenu());
            }
        }
    }
    
    @Override
    public Parcelable onSaveInstanceState() {
        final SavedState savedState = new SavedState();
        savedState.openSubMenuId = mOpenSubMenuId;
        return (Parcelable)savedState;
    }
    
    @Override
    public boolean onSubMenuSelected(final SubMenuBuilder subMenuBuilder) {
        if (subMenuBuilder.hasVisibleItems()) {
            SubMenuBuilder subMenuBuilder2;
            for (subMenuBuilder2 = subMenuBuilder; subMenuBuilder2.getParentMenu() != this.mMenu; subMenuBuilder2 = (SubMenuBuilder)subMenuBuilder2.getParentMenu()) {}
            Object anchorView = this.findViewForItem(subMenuBuilder2.getItem());
            if (anchorView == null) {
                if (mOverflowButton == null) {
                    return false;
                }
                anchorView = mOverflowButton;
            }
            mOpenSubMenuId = subMenuBuilder.getItem().getItemId();
            (mActionButtonPopup = new ActionButtonSubmenu(this.mContext, subMenuBuilder)).setAnchorView((View)anchorView);
            mActionButtonPopup.show();
            super.onSubMenuSelected(subMenuBuilder);
            return true;
        }
        return false;
    }
    
    @Override
    public void onSubUiVisibilityChanged(final boolean b) {
        if (b) {
            super.onSubMenuSelected(null);
            return;
        }
        this.mMenu.close(false);
    }
    
    public void setExpandedActionViewsExclusive(final boolean mExpandedActionViewsExclusive) {
        this.mExpandedActionViewsExclusive = mExpandedActionViewsExclusive;
    }
    
    public void setItemLimit(final int mMaxItems) {
        this.mMaxItems = mMaxItems;
        mMaxItemsSet = true;
    }
    
    public void setMenuView(final ActionMenuView mMenuView) {
        ((ActionMenuView)(this.mMenuView = mMenuView)).initialize(this.mMenu);
    }
    
    public void setOverflowIcon(final Drawable drawable) {
        if (mOverflowButton != null) {
            mOverflowButton.setImageDrawable(drawable);
            return;
        }
        mPendingOverflowIconSet = true;
        mPendingOverflowIcon = drawable;
    }
    
    public void setReserveOverflow(final boolean mReserveOverflow) {
        this.mReserveOverflow = mReserveOverflow;
        mReserveOverflowSet = true;
    }
    
    public void setWidthLimit(final int mWidthLimit, final boolean mStrictWidthLimit) {
        this.mWidthLimit = mWidthLimit;
        this.mStrictWidthLimit = mStrictWidthLimit;
        mWidthLimitSet = true;
    }
    
    @Override
    public boolean shouldIncludeItem(final int n, final MenuItemImpl menuItemImpl) {
        return menuItemImpl.isActionButton();
    }
    
    public boolean showOverflowMenu() {
        if (mReserveOverflow && !this.isOverflowMenuShowing() && this.mMenu != null && this.mMenuView != null && mPostedOpenRunnable == null && !this.mMenu.getNonActionItems().isEmpty()) {
            mPostedOpenRunnable = new OpenOverflowRunnable(new OverflowPopup(this.mContext, this.mMenu, (View)mOverflowButton, true));
            ((View)this.mMenuView).post((Runnable)mPostedOpenRunnable);
            super.onSubMenuSelected(null);
            return true;
        }
        return false;
    }
    
    @Override
    public void updateMenuView(final boolean b) {
        final ViewGroup viewGroup = (ViewGroup)((View)this.mMenuView).getParent();
        if (viewGroup != null) {
            ActionBarTransition.beginDelayedTransition(viewGroup);
        }
        super.updateMenuView(b);
        ((View)this.mMenuView).requestLayout();
        if (this.mMenu != null) {
            final ArrayList<MenuItemImpl> actionItems = this.mMenu.getActionItems();
            for (int size = actionItems.size(), i = 0; i < size; ++i) {
                final ActionProvider supportActionProvider = ((MenuItemImpl)actionItems.get(i)).getSupportActionProvider();
                if (supportActionProvider != null) {
                    supportActionProvider.setSubUiVisibilityListener((ActionProvider.SubUiVisibilityListener)this);
                }
            }
        }
        ArrayList<MenuItemImpl> nonActionItems;
        if (this.mMenu != null) {
            nonActionItems = this.mMenu.getNonActionItems();
        }
        else {
            nonActionItems = null;
        }
        final boolean mReserveOverflow = this.mReserveOverflow;
        int n = 0;
        if (mReserveOverflow) {
            n = 0;
            if (nonActionItems != null) {
                final int size2 = nonActionItems.size();
                if (size2 == 1) {
                    if (!((MenuItemImpl)nonActionItems.get(0)).isActionViewExpanded()) {
                        n = 1;
                    }
                    else {
                        n = 0;
                    }
                }
                else if (size2 > 0) {
                    n = 1;
                }
                else {
                    n = 0;
                }
            }
        }
        if (n != 0) {
            if (mOverflowButton == null) {
                mOverflowButton = new OverflowMenuButton(this.mSystemContext);
            }
            final ViewGroup viewGroup2 = (ViewGroup)mOverflowButton.getParent();
            if (viewGroup2 != this.mMenuView) {
                if (viewGroup2 != null) {
                    viewGroup2.removeView((View)mOverflowButton);
                }
                final ActionMenuView actionMenuView = (ActionMenuView)this.mMenuView;
                actionMenuView.addView((View)mOverflowButton, (ViewGroup$LayoutParams)actionMenuView.generateOverflowButtonLayoutParams());
            }
        }
        else if (mOverflowButton != null && mOverflowButton.getParent() == this.mMenuView) {
            ((ViewGroup)this.mMenuView).removeView((View)mOverflowButton);
        }
        ((ActionMenuView)this.mMenuView).setOverflowReserved(this.mReserveOverflow);
    }
}
