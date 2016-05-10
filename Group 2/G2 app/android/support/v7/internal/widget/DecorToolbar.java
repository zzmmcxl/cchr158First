package android.support.v7.internal.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuPresenter;
import android.support.v7.internal.widget.AdapterViewCompat;
import android.support.v7.internal.widget.ScrollingTabContainerView;
import android.util.SparseArray;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window.Callback;
import android.widget.SpinnerAdapter;

public interface DecorToolbar {
   void animateToVisibility(int var1);

   boolean canShowOverflowMenu();

   boolean canSplit();

   void collapseActionView();

   void dismissPopupMenus();

   Context getContext();

   View getCustomView();

   int getDisplayOptions();

   int getDropdownItemCount();

   int getDropdownSelectedPosition();

   int getHeight();

   Menu getMenu();

   int getNavigationMode();

   int getPopupTheme();

   CharSequence getSubtitle();

   CharSequence getTitle();

   ViewGroup getViewGroup();

   int getVisibility();

   boolean hasEmbeddedTabs();

   boolean hasExpandedActionView();

   boolean hasIcon();

   boolean hasLogo();

   boolean hideOverflowMenu();

   void initIndeterminateProgress();

   void initProgress();

   boolean isOverflowMenuShowPending();

   boolean isOverflowMenuShowing();

   boolean isSplit();

   boolean isTitleTruncated();

   void restoreHierarchyState(SparseArray var1);

   void saveHierarchyState(SparseArray var1);

   void setBackgroundDrawable(Drawable var1);

   void setCollapsible(boolean var1);

   void setCustomView(View var1);

   void setDefaultNavigationContentDescription(int var1);

   void setDefaultNavigationIcon(Drawable var1);

   void setDisplayOptions(int var1);

   void setDropdownParams(SpinnerAdapter var1, AdapterViewCompat.OnItemSelectedListener var2);

   void setDropdownSelectedPosition(int var1);

   void setEmbeddedTabView(ScrollingTabContainerView var1);

   void setHomeButtonEnabled(boolean var1);

   void setIcon(int var1);

   void setIcon(Drawable var1);

   void setLogo(int var1);

   void setLogo(Drawable var1);

   void setMenu(Menu var1, MenuPresenter.Callback var2);

   void setMenuCallbacks(MenuPresenter.Callback var1, MenuBuilder.Callback var2);

   void setMenuPrepared();

   void setNavigationContentDescription(int var1);

   void setNavigationContentDescription(CharSequence var1);

   void setNavigationIcon(int var1);

   void setNavigationIcon(Drawable var1);

   void setNavigationMode(int var1);

   void setSplitToolbar(boolean var1);

   void setSplitView(ViewGroup var1);

   void setSplitWhenNarrow(boolean var1);

   void setSubtitle(CharSequence var1);

   void setTitle(CharSequence var1);

   void setVisibility(int var1);

   void setWindowCallback(Callback var1);

   void setWindowTitle(CharSequence var1);

   boolean showOverflowMenu();
}
