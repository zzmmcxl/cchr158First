package android.support.v7.internal.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v7.appcompat.R;
import android.support.v7.internal.view.menu.ActionMenuItem;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuPresenter;
import android.support.v7.internal.widget.AdapterViewCompat;
import android.support.v7.internal.widget.DecorToolbar;
import android.support.v7.internal.widget.ScrollingTabContainerView;
import android.support.v7.internal.widget.SpinnerCompat;
import android.support.v7.internal.widget.TintManager;
import android.support.v7.internal.widget.TintTypedArray;
import android.support.v7.widget.ActionMenuPresenter;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window.Callback;
import android.widget.SpinnerAdapter;

public class ToolbarWidgetWrapper implements DecorToolbar {
   private static final int AFFECTS_LOGO_MASK = 3;
   private static final String TAG = "ToolbarWidgetWrapper";
   private ActionMenuPresenter mActionMenuPresenter;
   private View mCustomView;
   private int mDefaultNavigationContentDescription;
   private Drawable mDefaultNavigationIcon;
   private int mDisplayOpts;
   private CharSequence mHomeDescription;
   private Drawable mIcon;
   private Drawable mLogo;
   private boolean mMenuPrepared;
   private Drawable mNavIcon;
   private int mNavigationMode;
   private SpinnerCompat mSpinner;
   private CharSequence mSubtitle;
   private View mTabView;
   private final TintManager mTintManager;
   private CharSequence mTitle;
   private boolean mTitleSet;
   private Toolbar mToolbar;
   private Callback mWindowCallback;

   public ToolbarWidgetWrapper(Toolbar var1, boolean var2) {
      this(var1, var2, R.string.abc_action_bar_up_description, R.drawable.abc_ic_ab_back_mtrl_am_alpha);
   }

   public ToolbarWidgetWrapper(Toolbar var1, boolean var2, int var3, int var4) {
      this.mNavigationMode = 0;
      this.mDefaultNavigationContentDescription = 0;
      this.mToolbar = var1;
      this.mTitle = var1.getTitle();
      this.mSubtitle = var1.getSubtitle();
      boolean var7;
      if(this.mTitle != null) {
         var7 = true;
      } else {
         var7 = false;
      }

      this.mTitleSet = var7;
      this.mNavIcon = var1.getNavigationIcon();
      if(var2) {
         TintTypedArray var9 = TintTypedArray.obtainStyledAttributes(var1.getContext(), (AttributeSet)null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
         CharSequence var8 = var9.getText(R.styleable.ActionBar_title);
         if(!TextUtils.isEmpty(var8)) {
            this.setTitle(var8);
         }

         var8 = var9.getText(R.styleable.ActionBar_subtitle);
         if(!TextUtils.isEmpty(var8)) {
            this.setSubtitle(var8);
         }

         Drawable var10 = var9.getDrawable(R.styleable.ActionBar_logo);
         if(var10 != null) {
            this.setLogo(var10);
         }

         var10 = var9.getDrawable(R.styleable.ActionBar_icon);
         if(this.mNavIcon == null && var10 != null) {
            this.setIcon(var10);
         }

         var10 = var9.getDrawable(R.styleable.ActionBar_homeAsUpIndicator);
         if(var10 != null) {
            this.setNavigationIcon(var10);
         }

         this.setDisplayOptions(var9.getInt(R.styleable.ActionBar_displayOptions, 0));
         int var5 = var9.getResourceId(R.styleable.ActionBar_customNavigationLayout, 0);
         if(var5 != 0) {
            this.setCustomView(LayoutInflater.from(this.mToolbar.getContext()).inflate(var5, this.mToolbar, false));
            this.setDisplayOptions(this.mDisplayOpts | 16);
         }

         var5 = var9.getLayoutDimension(R.styleable.ActionBar_height, 0);
         if(var5 > 0) {
            LayoutParams var11 = this.mToolbar.getLayoutParams();
            var11.height = var5;
            this.mToolbar.setLayoutParams(var11);
         }

         var5 = var9.getDimensionPixelOffset(R.styleable.ActionBar_contentInsetStart, -1);
         int var6 = var9.getDimensionPixelOffset(R.styleable.ActionBar_contentInsetEnd, -1);
         if(var5 >= 0 || var6 >= 0) {
            this.mToolbar.setContentInsetsRelative(Math.max(var5, 0), Math.max(var6, 0));
         }

         var5 = var9.getResourceId(R.styleable.ActionBar_titleTextStyle, 0);
         if(var5 != 0) {
            this.mToolbar.setTitleTextAppearance(this.mToolbar.getContext(), var5);
         }

         var5 = var9.getResourceId(R.styleable.ActionBar_subtitleTextStyle, 0);
         if(var5 != 0) {
            this.mToolbar.setSubtitleTextAppearance(this.mToolbar.getContext(), var5);
         }

         var5 = var9.getResourceId(R.styleable.ActionBar_popupTheme, 0);
         if(var5 != 0) {
            this.mToolbar.setPopupTheme(var5);
         }

         var9.recycle();
         this.mTintManager = var9.getTintManager();
      } else {
         this.mDisplayOpts = this.detectDisplayOptions();
         this.mTintManager = TintManager.get(var1.getContext());
      }

      this.setDefaultNavigationContentDescription(var3);
      this.mHomeDescription = this.mToolbar.getNavigationContentDescription();
      this.setDefaultNavigationIcon(this.mTintManager.getDrawable(var4));
      this.mToolbar.setNavigationOnClickListener(new OnClickListener() {
         final ActionMenuItem mNavItem;

         {
            this.mNavItem = new ActionMenuItem(ToolbarWidgetWrapper.this.mToolbar.getContext(), 0, 16908332, 0, 0, ToolbarWidgetWrapper.this.mTitle);
         }

         public void onClick(View var1) {
            if(ToolbarWidgetWrapper.this.mWindowCallback != null && ToolbarWidgetWrapper.this.mMenuPrepared) {
               ToolbarWidgetWrapper.this.mWindowCallback.onMenuItemSelected(0, this.mNavItem);
            }

         }
      });
   }

   private int detectDisplayOptions() {
      int var1 = 11;
      if(this.mToolbar.getNavigationIcon() != null) {
         var1 = 11 | 4;
      }

      return var1;
   }

   private void ensureSpinner() {
      if(this.mSpinner == null) {
         this.mSpinner = new SpinnerCompat(this.getContext(), (AttributeSet)null, R.attr.actionDropDownStyle);
         Toolbar.LayoutParams var1 = new Toolbar.LayoutParams(-2, -2, 8388627);
         this.mSpinner.setLayoutParams(var1);
      }

   }

   private void setTitleInt(CharSequence var1) {
      this.mTitle = var1;
      if((this.mDisplayOpts & 8) != 0) {
         this.mToolbar.setTitle(var1);
      }

   }

   private void updateHomeAccessibility() {
      if((this.mDisplayOpts & 4) != 0) {
         if(!TextUtils.isEmpty(this.mHomeDescription)) {
            this.mToolbar.setNavigationContentDescription(this.mHomeDescription);
            return;
         }

         this.mToolbar.setNavigationContentDescription(this.mDefaultNavigationContentDescription);
      }

   }

   private void updateNavigationIcon() {
      if((this.mDisplayOpts & 4) != 0) {
         Toolbar var2 = this.mToolbar;
         Drawable var1;
         if(this.mNavIcon != null) {
            var1 = this.mNavIcon;
         } else {
            var1 = this.mDefaultNavigationIcon;
         }

         var2.setNavigationIcon(var1);
      }

   }

   private void updateToolbarLogo() {
      Drawable var1 = null;
      if((this.mDisplayOpts & 2) != 0) {
         if((this.mDisplayOpts & 1) != 0) {
            if(this.mLogo != null) {
               var1 = this.mLogo;
            } else {
               var1 = this.mIcon;
            }
         } else {
            var1 = this.mIcon;
         }
      }

      this.mToolbar.setLogo(var1);
   }

   public void animateToVisibility(int var1) {
      if(var1 == 8) {
         ViewCompat.animate(this.mToolbar).alpha(0.0F).setListener(new ViewPropertyAnimatorListenerAdapter() {
            private boolean mCanceled = false;

            public void onAnimationCancel(View var1) {
               this.mCanceled = true;
            }

            public void onAnimationEnd(View var1) {
               if(!this.mCanceled) {
                  ToolbarWidgetWrapper.this.mToolbar.setVisibility(8);
               }

            }
         });
      } else if(var1 == 0) {
         ViewCompat.animate(this.mToolbar).alpha(1.0F).setListener(new ViewPropertyAnimatorListenerAdapter() {
            public void onAnimationStart(View var1) {
               ToolbarWidgetWrapper.this.mToolbar.setVisibility(0);
            }
         });
         return;
      }

   }

   public boolean canShowOverflowMenu() {
      return this.mToolbar.canShowOverflowMenu();
   }

   public boolean canSplit() {
      return false;
   }

   public void collapseActionView() {
      this.mToolbar.collapseActionView();
   }

   public void dismissPopupMenus() {
      this.mToolbar.dismissPopupMenus();
   }

   public Context getContext() {
      return this.mToolbar.getContext();
   }

   public View getCustomView() {
      return this.mCustomView;
   }

   public int getDisplayOptions() {
      return this.mDisplayOpts;
   }

   public int getDropdownItemCount() {
      return this.mSpinner != null?this.mSpinner.getCount():0;
   }

   public int getDropdownSelectedPosition() {
      return this.mSpinner != null?this.mSpinner.getSelectedItemPosition():0;
   }

   public int getHeight() {
      return this.mToolbar.getHeight();
   }

   public Menu getMenu() {
      return this.mToolbar.getMenu();
   }

   public int getNavigationMode() {
      return this.mNavigationMode;
   }

   public int getPopupTheme() {
      return this.mToolbar.getPopupTheme();
   }

   public CharSequence getSubtitle() {
      return this.mToolbar.getSubtitle();
   }

   public CharSequence getTitle() {
      return this.mToolbar.getTitle();
   }

   public ViewGroup getViewGroup() {
      return this.mToolbar;
   }

   public int getVisibility() {
      return this.mToolbar.getVisibility();
   }

   public boolean hasEmbeddedTabs() {
      return this.mTabView != null;
   }

   public boolean hasExpandedActionView() {
      return this.mToolbar.hasExpandedActionView();
   }

   public boolean hasIcon() {
      return this.mIcon != null;
   }

   public boolean hasLogo() {
      return this.mLogo != null;
   }

   public boolean hideOverflowMenu() {
      return this.mToolbar.hideOverflowMenu();
   }

   public void initIndeterminateProgress() {
      Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
   }

   public void initProgress() {
      Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
   }

   public boolean isOverflowMenuShowPending() {
      return this.mToolbar.isOverflowMenuShowPending();
   }

   public boolean isOverflowMenuShowing() {
      return this.mToolbar.isOverflowMenuShowing();
   }

   public boolean isSplit() {
      return false;
   }

   public boolean isTitleTruncated() {
      return this.mToolbar.isTitleTruncated();
   }

   public void restoreHierarchyState(SparseArray var1) {
      this.mToolbar.restoreHierarchyState(var1);
   }

   public void saveHierarchyState(SparseArray var1) {
      this.mToolbar.saveHierarchyState(var1);
   }

   public void setBackgroundDrawable(Drawable var1) {
      this.mToolbar.setBackgroundDrawable(var1);
   }

   public void setCollapsible(boolean var1) {
      this.mToolbar.setCollapsible(var1);
   }

   public void setCustomView(View var1) {
      if(this.mCustomView != null && (this.mDisplayOpts & 16) != 0) {
         this.mToolbar.removeView(this.mCustomView);
      }

      this.mCustomView = var1;
      if(var1 != null && (this.mDisplayOpts & 16) != 0) {
         this.mToolbar.addView(this.mCustomView);
      }

   }

   public void setDefaultNavigationContentDescription(int var1) {
      if(var1 != this.mDefaultNavigationContentDescription) {
         this.mDefaultNavigationContentDescription = var1;
         if(TextUtils.isEmpty(this.mToolbar.getNavigationContentDescription())) {
            this.setNavigationContentDescription(this.mDefaultNavigationContentDescription);
            return;
         }
      }

   }

   public void setDefaultNavigationIcon(Drawable var1) {
      if(this.mDefaultNavigationIcon != var1) {
         this.mDefaultNavigationIcon = var1;
         this.updateNavigationIcon();
      }

   }

   public void setDisplayOptions(int var1) {
      int var2 = this.mDisplayOpts ^ var1;
      this.mDisplayOpts = var1;
      if(var2 != 0) {
         if((var2 & 4) != 0) {
            if((var1 & 4) != 0) {
               this.updateNavigationIcon();
               this.updateHomeAccessibility();
            } else {
               this.mToolbar.setNavigationIcon((Drawable)null);
            }
         }

         if((var2 & 3) != 0) {
            this.updateToolbarLogo();
         }

         if((var2 & 8) != 0) {
            if((var1 & 8) != 0) {
               this.mToolbar.setTitle(this.mTitle);
               this.mToolbar.setSubtitle(this.mSubtitle);
            } else {
               this.mToolbar.setTitle((CharSequence)null);
               this.mToolbar.setSubtitle((CharSequence)null);
            }
         }

         if((var2 & 16) != 0 && this.mCustomView != null) {
            if((var1 & 16) == 0) {
               this.mToolbar.removeView(this.mCustomView);
               return;
            }

            this.mToolbar.addView(this.mCustomView);
         }
      }

   }

   public void setDropdownParams(SpinnerAdapter var1, AdapterViewCompat.OnItemSelectedListener var2) {
      this.ensureSpinner();
      this.mSpinner.setAdapter(var1);
      this.mSpinner.setOnItemSelectedListener(var2);
   }

   public void setDropdownSelectedPosition(int var1) {
      if(this.mSpinner == null) {
         throw new IllegalStateException("Can\'t set dropdown selected position without an adapter");
      } else {
         this.mSpinner.setSelection(var1);
      }
   }

   public void setEmbeddedTabView(ScrollingTabContainerView var1) {
      if(this.mTabView != null && this.mTabView.getParent() == this.mToolbar) {
         this.mToolbar.removeView(this.mTabView);
      }

      this.mTabView = var1;
      if(var1 != null && this.mNavigationMode == 2) {
         this.mToolbar.addView(this.mTabView, 0);
         Toolbar.LayoutParams var2 = (Toolbar.LayoutParams)this.mTabView.getLayoutParams();
         var2.width = -2;
         var2.height = -2;
         var2.gravity = 8388691;
         var1.setAllowCollapse(true);
      }

   }

   public void setHomeButtonEnabled(boolean var1) {
   }

   public void setIcon(int var1) {
      Drawable var2;
      if(var1 != 0) {
         var2 = this.mTintManager.getDrawable(var1);
      } else {
         var2 = null;
      }

      this.setIcon(var2);
   }

   public void setIcon(Drawable var1) {
      this.mIcon = var1;
      this.updateToolbarLogo();
   }

   public void setLogo(int var1) {
      Drawable var2;
      if(var1 != 0) {
         var2 = this.mTintManager.getDrawable(var1);
      } else {
         var2 = null;
      }

      this.setLogo(var2);
   }

   public void setLogo(Drawable var1) {
      this.mLogo = var1;
      this.updateToolbarLogo();
   }

   public void setMenu(Menu var1, MenuPresenter.Callback var2) {
      if(this.mActionMenuPresenter == null) {
         this.mActionMenuPresenter = new ActionMenuPresenter(this.mToolbar.getContext());
         this.mActionMenuPresenter.setId(R.id.action_menu_presenter);
      }

      this.mActionMenuPresenter.setCallback(var2);
      this.mToolbar.setMenu((MenuBuilder)var1, this.mActionMenuPresenter);
   }

   public void setMenuCallbacks(MenuPresenter.Callback var1, MenuBuilder.Callback var2) {
      this.mToolbar.setMenuCallbacks(var1, var2);
   }

   public void setMenuPrepared() {
      this.mMenuPrepared = true;
   }

   public void setNavigationContentDescription(int var1) {
      String var2;
      if(var1 == 0) {
         var2 = null;
      } else {
         var2 = this.getContext().getString(var1);
      }

      this.setNavigationContentDescription(var2);
   }

   public void setNavigationContentDescription(CharSequence var1) {
      this.mHomeDescription = var1;
      this.updateHomeAccessibility();
   }

   public void setNavigationIcon(int var1) {
      Drawable var2;
      if(var1 != 0) {
         var2 = this.mTintManager.getDrawable(var1);
      } else {
         var2 = null;
      }

      this.setNavigationIcon(var2);
   }

   public void setNavigationIcon(Drawable var1) {
      this.mNavIcon = var1;
      this.updateNavigationIcon();
   }

   public void setNavigationMode(int var1) {
      int var2 = this.mNavigationMode;
      if(var1 != var2) {
         switch(var2) {
         case 1:
            if(this.mSpinner != null && this.mSpinner.getParent() == this.mToolbar) {
               this.mToolbar.removeView(this.mSpinner);
            }
            break;
         case 2:
            if(this.mTabView != null && this.mTabView.getParent() == this.mToolbar) {
               this.mToolbar.removeView(this.mTabView);
            }
         }

         this.mNavigationMode = var1;
         switch(var1) {
         case 0:
            break;
         case 1:
            this.ensureSpinner();
            this.mToolbar.addView(this.mSpinner, 0);
            break;
         case 2:
            if(this.mTabView != null) {
               this.mToolbar.addView(this.mTabView, 0);
               Toolbar.LayoutParams var3 = (Toolbar.LayoutParams)this.mTabView.getLayoutParams();
               var3.width = -2;
               var3.height = -2;
               var3.gravity = 8388691;
               return;
            }
            break;
         default:
            throw new IllegalArgumentException("Invalid navigation mode " + var1);
         }
      }

   }

   public void setSplitToolbar(boolean var1) {
      if(var1) {
         throw new UnsupportedOperationException("Cannot split an android.widget.Toolbar");
      }
   }

   public void setSplitView(ViewGroup var1) {
   }

   public void setSplitWhenNarrow(boolean var1) {
   }

   public void setSubtitle(CharSequence var1) {
      this.mSubtitle = var1;
      if((this.mDisplayOpts & 8) != 0) {
         this.mToolbar.setSubtitle(var1);
      }

   }

   public void setTitle(CharSequence var1) {
      this.mTitleSet = true;
      this.setTitleInt(var1);
   }

   public void setVisibility(int var1) {
      this.mToolbar.setVisibility(var1);
   }

   public void setWindowCallback(Callback var1) {
      this.mWindowCallback = var1;
   }

   public void setWindowTitle(CharSequence var1) {
      if(!this.mTitleSet) {
         this.setTitleInt(var1);
      }

   }

   public boolean showOverflowMenu() {
      return this.mToolbar.showOverflowMenu();
   }
}
