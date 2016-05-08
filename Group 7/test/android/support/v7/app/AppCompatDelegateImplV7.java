package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.content.res.Resources.Theme;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.NavUtils;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v4.view.LayoutInflaterFactory;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.widget.PopupWindowCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatCallback;
import android.support.v7.app.AppCompatDelegateImplBase;
import android.support.v7.app.AppCompatDelegateImplV7$1;
import android.support.v7.app.AppCompatDelegateImplV7$2;
import android.support.v7.app.AppCompatDelegateImplV7$3;
import android.support.v7.app.AppCompatDelegateImplV7$4;
import android.support.v7.app.AppCompatDelegateImplV7$5;
import android.support.v7.app.AppCompatDelegateImplV7$6;
import android.support.v7.app.AppCompatDelegateImplV7$ActionMenuPresenterCallback;
import android.support.v7.app.AppCompatDelegateImplV7$ActionModeCallbackWrapperV7;
import android.support.v7.app.AppCompatDelegateImplV7$ListMenuDecorView;
import android.support.v7.app.AppCompatDelegateImplV7$PanelFeatureState;
import android.support.v7.app.AppCompatDelegateImplV7$PanelMenuPresenterCallback;
import android.support.v7.app.AppCompatViewInflater;
import android.support.v7.app.ToolbarActionBar;
import android.support.v7.app.WindowDecorActionBar;
import android.support.v7.appcompat.R$attr;
import android.support.v7.appcompat.R$color;
import android.support.v7.appcompat.R$id;
import android.support.v7.appcompat.R$layout;
import android.support.v7.appcompat.R$styleable;
import android.support.v7.view.ActionMode;
import android.support.v7.view.ActionMode$Callback;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.view.StandaloneActionMode;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuBuilder$Callback;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.DecorContentParent;
import android.support.v7.widget.FitWindowsViewGroup;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ViewStubCompat;
import android.support.v7.widget.ViewUtils;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.view.LayoutInflater.Factory;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window.Callback;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

class AppCompatDelegateImplV7 extends AppCompatDelegateImplBase implements MenuBuilder$Callback, LayoutInflaterFactory {
   private AppCompatDelegateImplV7$ActionMenuPresenterCallback mActionMenuPresenterCallback;
   ActionMode mActionMode;
   PopupWindow mActionModePopup;
   ActionBarContextView mActionModeView;
   private AppCompatViewInflater mAppCompatViewInflater;
   private boolean mClosingActionMenu;
   private DecorContentParent mDecorContentParent;
   private boolean mEnableDefaultActionBarUp;
   ViewPropertyAnimatorCompat mFadeAnim = null;
   private boolean mFeatureIndeterminateProgress;
   private boolean mFeatureProgress;
   private int mInvalidatePanelMenuFeatures;
   private boolean mInvalidatePanelMenuPosted;
   private final Runnable mInvalidatePanelMenuRunnable = new AppCompatDelegateImplV7$1(this);
   private boolean mLongPressBackDown;
   private AppCompatDelegateImplV7$PanelMenuPresenterCallback mPanelMenuPresenterCallback;
   private AppCompatDelegateImplV7$PanelFeatureState[] mPanels;
   private AppCompatDelegateImplV7$PanelFeatureState mPreparedPanel;
   Runnable mShowActionModePopup;
   private View mStatusGuard;
   private ViewGroup mSubDecor;
   private boolean mSubDecorInstalled;
   private Rect mTempRect1;
   private Rect mTempRect2;
   private TextView mTitleView;

   AppCompatDelegateImplV7(Context var1, Window var2, AppCompatCallback var3) {
      super(var1, var2, var3);
   }

   private void applyFixedSizeWindow() {
      ContentFrameLayout var1 = (ContentFrameLayout)this.mSubDecor.findViewById(16908290);
      View var2 = this.mWindow.getDecorView();
      var1.setDecorPadding(var2.getPaddingLeft(), var2.getPaddingTop(), var2.getPaddingRight(), var2.getPaddingBottom());
      TypedArray var3 = this.mContext.obtainStyledAttributes(R$styleable.AppCompatTheme);
      var3.getValue(R$styleable.AppCompatTheme_windowMinWidthMajor, var1.getMinWidthMajor());
      var3.getValue(R$styleable.AppCompatTheme_windowMinWidthMinor, var1.getMinWidthMinor());
      if(var3.hasValue(R$styleable.AppCompatTheme_windowFixedWidthMajor)) {
         var3.getValue(R$styleable.AppCompatTheme_windowFixedWidthMajor, var1.getFixedWidthMajor());
      }

      if(var3.hasValue(R$styleable.AppCompatTheme_windowFixedWidthMinor)) {
         var3.getValue(R$styleable.AppCompatTheme_windowFixedWidthMinor, var1.getFixedWidthMinor());
      }

      if(var3.hasValue(R$styleable.AppCompatTheme_windowFixedHeightMajor)) {
         var3.getValue(R$styleable.AppCompatTheme_windowFixedHeightMajor, var1.getFixedHeightMajor());
      }

      if(var3.hasValue(R$styleable.AppCompatTheme_windowFixedHeightMinor)) {
         var3.getValue(R$styleable.AppCompatTheme_windowFixedHeightMinor, var1.getFixedHeightMinor());
      }

      var3.recycle();
      var1.requestLayout();
   }

   private void callOnPanelClosed(int var1, AppCompatDelegateImplV7$PanelFeatureState var2, Menu var3) {
      AppCompatDelegateImplV7$PanelFeatureState var5 = var2;
      Object var6 = var3;
      if(var3 == null) {
         AppCompatDelegateImplV7$PanelFeatureState var4 = var2;
         if(var2 == null) {
            var4 = var2;
            if(var1 >= 0) {
               var4 = var2;
               if(var1 < this.mPanels.length) {
                  var4 = this.mPanels[var1];
               }
            }
         }

         var5 = var4;
         var6 = var3;
         if(var4 != null) {
            var6 = var4.menu;
            var5 = var4;
         }
      }

      if((var5 == null || var5.isOpen) && !this.isDestroyed()) {
         this.mOriginalWindowCallback.onPanelClosed(var1, (Menu)var6);
      }
   }

   private void checkCloseActionMenu(MenuBuilder var1) {
      if(!this.mClosingActionMenu) {
         this.mClosingActionMenu = true;
         this.mDecorContentParent.dismissPopups();
         Callback var2 = this.getWindowCallback();
         if(var2 != null && !this.isDestroyed()) {
            var2.onPanelClosed(108, var1);
         }

         this.mClosingActionMenu = false;
      }
   }

   private void closePanel(int var1) {
      this.closePanel(this.getPanelState(var1, true), true);
   }

   private void closePanel(AppCompatDelegateImplV7$PanelFeatureState var1, boolean var2) {
      if(var2 && var1.featureId == 0 && this.mDecorContentParent != null && this.mDecorContentParent.isOverflowMenuShowing()) {
         this.checkCloseActionMenu(var1.menu);
      } else {
         WindowManager var3 = (WindowManager)this.mContext.getSystemService("window");
         if(var3 != null && var1.isOpen && var1.decorView != null) {
            var3.removeView(var1.decorView);
            if(var2) {
               this.callOnPanelClosed(var1.featureId, var1, (Menu)null);
            }
         }

         var1.isPrepared = false;
         var1.isHandled = false;
         var1.isOpen = false;
         var1.shownPanelView = null;
         var1.refreshDecorView = true;
         if(this.mPreparedPanel == var1) {
            this.mPreparedPanel = null;
            return;
         }
      }

   }

   private ViewGroup createSubDecor() {
      TypedArray var1 = this.mContext.obtainStyledAttributes(R$styleable.AppCompatTheme);
      if(!var1.hasValue(R$styleable.AppCompatTheme_windowActionBar)) {
         var1.recycle();
         throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
      } else {
         if(var1.getBoolean(R$styleable.AppCompatTheme_windowNoTitle, false)) {
            this.requestWindowFeature(1);
         } else if(var1.getBoolean(R$styleable.AppCompatTheme_windowActionBar, false)) {
            this.requestWindowFeature(108);
         }

         if(var1.getBoolean(R$styleable.AppCompatTheme_windowActionBarOverlay, false)) {
            this.requestWindowFeature(109);
         }

         if(var1.getBoolean(R$styleable.AppCompatTheme_windowActionModeOverlay, false)) {
            this.requestWindowFeature(10);
         }

         this.mIsFloating = var1.getBoolean(R$styleable.AppCompatTheme_android_windowIsFloating, false);
         var1.recycle();
         LayoutInflater var2 = LayoutInflater.from(this.mContext);
         ViewGroup var5 = null;
         ViewGroup var8;
         if(!this.mWindowNoTitle) {
            if(this.mIsFloating) {
               var5 = (ViewGroup)var2.inflate(R$layout.abc_dialog_title_material, (ViewGroup)null);
               this.mOverlayActionBar = false;
               this.mHasActionBar = false;
            } else if(this.mHasActionBar) {
               TypedValue var6 = new TypedValue();
               this.mContext.getTheme().resolveAttribute(R$attr.actionBarTheme, var6, true);
               Object var7;
               if(var6.resourceId != 0) {
                  var7 = new ContextThemeWrapper(this.mContext, var6.resourceId);
               } else {
                  var7 = this.mContext;
               }

               var8 = (ViewGroup)LayoutInflater.from((Context)var7).inflate(R$layout.abc_screen_toolbar, (ViewGroup)null);
               this.mDecorContentParent = (DecorContentParent)var8.findViewById(R$id.decor_content_parent);
               this.mDecorContentParent.setWindowCallback(this.getWindowCallback());
               if(this.mOverlayActionBar) {
                  this.mDecorContentParent.initFeature(109);
               }

               if(this.mFeatureProgress) {
                  this.mDecorContentParent.initFeature(2);
               }

               var5 = var8;
               if(this.mFeatureIndeterminateProgress) {
                  this.mDecorContentParent.initFeature(5);
                  var5 = var8;
               }
            }
         } else {
            if(this.mOverlayActionMode) {
               var5 = (ViewGroup)var2.inflate(R$layout.abc_screen_simple_overlay_action_mode, (ViewGroup)null);
            } else {
               var5 = (ViewGroup)var2.inflate(R$layout.abc_screen_simple, (ViewGroup)null);
            }

            if(VERSION.SDK_INT >= 21) {
               ViewCompat.setOnApplyWindowInsetsListener(var5, new AppCompatDelegateImplV7$2(this));
            } else {
               ((FitWindowsViewGroup)var5).setOnFitSystemWindowsListener(new AppCompatDelegateImplV7$3(this));
            }
         }

         if(var5 == null) {
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.mHasActionBar + ", windowActionBarOverlay: " + this.mOverlayActionBar + ", android:windowIsFloating: " + this.mIsFloating + ", windowActionModeOverlay: " + this.mOverlayActionMode + ", windowNoTitle: " + this.mWindowNoTitle + " }");
         } else {
            if(this.mDecorContentParent == null) {
               this.mTitleView = (TextView)var5.findViewById(R$id.title);
            }

            ViewUtils.makeOptionalFitsSystemWindows(var5);
            var8 = (ViewGroup)this.mWindow.findViewById(16908290);
            ContentFrameLayout var3 = (ContentFrameLayout)var5.findViewById(R$id.action_bar_activity_content);

            while(var8.getChildCount() > 0) {
               View var4 = var8.getChildAt(0);
               var8.removeViewAt(0);
               var3.addView(var4);
            }

            this.mWindow.setContentView(var5);
            var8.setId(-1);
            var3.setId(16908290);
            if(var8 instanceof FrameLayout) {
               ((FrameLayout)var8).setForeground((Drawable)null);
            }

            var3.setAttachListener(new AppCompatDelegateImplV7$4(this));
            return var5;
         }
      }
   }

   private void dismissPopups() {
      if(this.mDecorContentParent != null) {
         this.mDecorContentParent.dismissPopups();
      }

      if(this.mActionModePopup != null) {
         this.mWindow.getDecorView().removeCallbacks(this.mShowActionModePopup);
         if(this.mActionModePopup.isShowing()) {
            try {
               this.mActionModePopup.dismiss();
            } catch (IllegalArgumentException var2) {
               ;
            }
         }

         this.mActionModePopup = null;
      }

      this.endOnGoingFadeAnimation();
      AppCompatDelegateImplV7$PanelFeatureState var1 = this.getPanelState(0, false);
      if(var1 != null && var1.menu != null) {
         var1.menu.close();
      }

   }

   private void doInvalidatePanelMenu(int var1) {
      AppCompatDelegateImplV7$PanelFeatureState var2 = this.getPanelState(var1, true);
      if(var2.menu != null) {
         Bundle var3 = new Bundle();
         var2.menu.saveActionViewStates(var3);
         if(var3.size() > 0) {
            var2.frozenActionViewState = var3;
         }

         var2.menu.stopDispatchingItemsChanged();
         var2.menu.clear();
      }

      var2.refreshMenuContent = true;
      var2.refreshDecorView = true;
      if((var1 == 108 || var1 == 0) && this.mDecorContentParent != null) {
         var2 = this.getPanelState(0, false);
         if(var2 != null) {
            var2.isPrepared = false;
            this.preparePanel(var2, (KeyEvent)null);
         }
      }

   }

   private void endOnGoingFadeAnimation() {
      if(this.mFadeAnim != null) {
         this.mFadeAnim.cancel();
      }

   }

   private void ensureSubDecor() {
      if(!this.mSubDecorInstalled) {
         this.mSubDecor = this.createSubDecor();
         CharSequence var1 = this.getTitle();
         if(!TextUtils.isEmpty(var1)) {
            this.onTitleChanged(var1);
         }

         this.applyFixedSizeWindow();
         this.onSubDecorInstalled(this.mSubDecor);
         this.mSubDecorInstalled = true;
         AppCompatDelegateImplV7$PanelFeatureState var2 = this.getPanelState(0, false);
         if(!this.isDestroyed() && (var2 == null || var2.menu == null)) {
            this.invalidatePanelMenu(108);
         }
      }

   }

   private AppCompatDelegateImplV7$PanelFeatureState findMenuPanel(Menu var1) {
      AppCompatDelegateImplV7$PanelFeatureState[] var4 = this.mPanels;
      int var2;
      if(var4 != null) {
         var2 = var4.length;
      } else {
         var2 = 0;
      }

      for(int var3 = 0; var3 < var2; ++var3) {
         AppCompatDelegateImplV7$PanelFeatureState var5 = var4[var3];
         if(var5 != null && var5.menu == var1) {
            return var5;
         }
      }

      return null;
   }

   private AppCompatDelegateImplV7$PanelFeatureState getPanelState(int var1, boolean var2) {
      AppCompatDelegateImplV7$PanelFeatureState[] var3;
      label22: {
         AppCompatDelegateImplV7$PanelFeatureState[] var4 = this.mPanels;
         if(var4 != null) {
            var3 = var4;
            if(var4.length > var1) {
               break label22;
            }
         }

         AppCompatDelegateImplV7$PanelFeatureState[] var5 = new AppCompatDelegateImplV7$PanelFeatureState[var1 + 1];
         if(var4 != null) {
            System.arraycopy(var4, 0, var5, 0, var4.length);
         }

         var3 = var5;
         this.mPanels = var5;
      }

      AppCompatDelegateImplV7$PanelFeatureState var6 = var3[var1];
      AppCompatDelegateImplV7$PanelFeatureState var7 = var6;
      if(var6 == null) {
         var7 = new AppCompatDelegateImplV7$PanelFeatureState(var1);
         var3[var1] = var7;
      }

      return var7;
   }

   private boolean initializePanelContent(AppCompatDelegateImplV7$PanelFeatureState var1) {
      if(var1.createdPanelView != null) {
         var1.shownPanelView = var1.createdPanelView;
      } else {
         if(var1.menu == null) {
            return false;
         }

         if(this.mPanelMenuPresenterCallback == null) {
            this.mPanelMenuPresenterCallback = new AppCompatDelegateImplV7$PanelMenuPresenterCallback(this, (AppCompatDelegateImplV7$1)null);
         }

         var1.shownPanelView = (View)var1.getListMenuView(this.mPanelMenuPresenterCallback);
         if(var1.shownPanelView == null) {
            return false;
         }
      }

      return true;
   }

   private boolean initializePanelDecor(AppCompatDelegateImplV7$PanelFeatureState var1) {
      var1.setStyle(this.getActionBarThemedContext());
      var1.decorView = new AppCompatDelegateImplV7$ListMenuDecorView(this, var1.listPresenterContext);
      var1.gravity = 81;
      return true;
   }

   private boolean initializePanelMenu(AppCompatDelegateImplV7$PanelFeatureState var1) {
      Object var2;
      label28: {
         Context var4 = this.mContext;
         if(var1.featureId != 0) {
            var2 = var4;
            if(var1.featureId != 108) {
               break label28;
            }
         }

         var2 = var4;
         if(this.mDecorContentParent != null) {
            TypedValue var5 = new TypedValue();
            Theme var6 = var4.getTheme();
            var6.resolveAttribute(R$attr.actionBarTheme, var5, true);
            Theme var7 = null;
            if(var5.resourceId != 0) {
               var7 = var4.getResources().newTheme();
               var7.setTo(var6);
               var7.applyStyle(var5.resourceId, true);
               var7.resolveAttribute(R$attr.actionBarWidgetTheme, var5, true);
            } else {
               var6.resolveAttribute(R$attr.actionBarWidgetTheme, var5, true);
            }

            Theme var3 = var7;
            if(var5.resourceId != 0) {
               var3 = var7;
               if(var7 == null) {
                  var3 = var4.getResources().newTheme();
                  var3.setTo(var6);
               }

               var3.applyStyle(var5.resourceId, true);
            }

            var2 = var4;
            if(var3 != null) {
               var2 = new ContextThemeWrapper(var4, 0);
               ((Context)var2).getTheme().setTo(var3);
            }
         }
      }

      MenuBuilder var8 = new MenuBuilder((Context)var2);
      var8.setCallback(this);
      var1.setMenu(var8);
      return true;
   }

   private void invalidatePanelMenu(int var1) {
      this.mInvalidatePanelMenuFeatures |= 1 << var1;
      if(!this.mInvalidatePanelMenuPosted) {
         ViewCompat.postOnAnimation(this.mWindow.getDecorView(), this.mInvalidatePanelMenuRunnable);
         this.mInvalidatePanelMenuPosted = true;
      }

   }

   private boolean onKeyDownPanel(int var1, KeyEvent var2) {
      if(var2.getRepeatCount() == 0) {
         AppCompatDelegateImplV7$PanelFeatureState var3 = this.getPanelState(var1, true);
         if(!var3.isOpen) {
            return this.preparePanel(var3, var2);
         }
      }

      return false;
   }

   private boolean onKeyUpPanel(int var1, KeyEvent var2) {
      boolean var4;
      if(this.mActionMode != null) {
         var4 = false;
      } else {
         boolean var5 = false;
         AppCompatDelegateImplV7$PanelFeatureState var6 = this.getPanelState(var1, true);
         boolean var3;
         if(var1 == 0 && this.mDecorContentParent != null && this.mDecorContentParent.canShowOverflowMenu() && !ViewConfigurationCompat.hasPermanentMenuKey(ViewConfiguration.get(this.mContext))) {
            if(!this.mDecorContentParent.isOverflowMenuShowing()) {
               var3 = var5;
               if(!this.isDestroyed()) {
                  var3 = var5;
                  if(this.preparePanel(var6, var2)) {
                     var3 = this.mDecorContentParent.showOverflowMenu();
                  }
               }
            } else {
               var3 = this.mDecorContentParent.hideOverflowMenu();
            }
         } else if(!var6.isOpen && !var6.isHandled) {
            var3 = var5;
            if(var6.isPrepared) {
               var4 = true;
               if(var6.refreshMenuContent) {
                  var6.isPrepared = false;
                  var4 = this.preparePanel(var6, var2);
               }

               var3 = var5;
               if(var4) {
                  this.openPanel(var6, var2);
                  var3 = true;
               }
            }
         } else {
            var3 = var6.isOpen;
            this.closePanel(var6, true);
         }

         var4 = var3;
         if(var3) {
            AudioManager var7 = (AudioManager)this.mContext.getSystemService("audio");
            if(var7 != null) {
               var7.playSoundEffect(0);
               return var3;
            }

            Log.w("AppCompatDelegate", "Couldn\'t get audio manager");
            return var3;
         }
      }

      return var4;
   }

   private void openPanel(AppCompatDelegateImplV7$PanelFeatureState var1, KeyEvent var2) {
      WindowManager var6;
      byte var10;
      label82: {
         if(!var1.isOpen && !this.isDestroyed()) {
            if(var1.featureId == 0) {
               Context var5 = this.mContext;
               boolean var3;
               if((var5.getResources().getConfiguration().screenLayout & 15) == 4) {
                  var3 = true;
               } else {
                  var3 = false;
               }

               boolean var4;
               if(var5.getApplicationInfo().targetSdkVersion >= 11) {
                  var4 = true;
               } else {
                  var4 = false;
               }

               if(var3 && var4) {
                  return;
               }
            }

            Callback var12 = this.getWindowCallback();
            if(var12 != null && !var12.onMenuOpened(var1.featureId, var1.menu)) {
               this.closePanel(var1, true);
               return;
            }

            var6 = (WindowManager)this.mContext.getSystemService("window");
            if(var6 != null && this.preparePanel(var1, var2)) {
               byte var11 = -2;
               LayoutParams var7;
               if(var1.decorView != null && !var1.refreshDecorView) {
                  var10 = var11;
                  if(var1.createdPanelView != null) {
                     var7 = var1.createdPanelView.getLayoutParams();
                     var10 = var11;
                     if(var7 != null) {
                        var10 = var11;
                        if(var7.width == -1) {
                           var10 = -1;
                        }
                     }
                  }
                  break label82;
               }

               if(var1.decorView == null) {
                  if(!this.initializePanelDecor(var1) || var1.decorView == null) {
                     return;
                  }
               } else if(var1.refreshDecorView && var1.decorView.getChildCount() > 0) {
                  var1.decorView.removeAllViews();
               }

               if(this.initializePanelContent(var1) && var1.hasPanelItems()) {
                  LayoutParams var13 = var1.shownPanelView.getLayoutParams();
                  var7 = var13;
                  if(var13 == null) {
                     var7 = new LayoutParams(-2, -2);
                  }

                  int var9 = var1.background;
                  var1.decorView.setBackgroundResource(var9);
                  ViewParent var14 = var1.shownPanelView.getParent();
                  if(var14 != null && var14 instanceof ViewGroup) {
                     ((ViewGroup)var14).removeView(var1.shownPanelView);
                  }

                  var1.decorView.addView(var1.shownPanelView, var7);
                  var10 = var11;
                  if(!var1.shownPanelView.hasFocus()) {
                     var1.shownPanelView.requestFocus();
                     var10 = var11;
                  }
                  break label82;
               }
            }
         }

         return;
      }

      var1.isHandled = false;
      android.view.WindowManager.LayoutParams var8 = new android.view.WindowManager.LayoutParams(var10, -2, var1.x, var1.y, 1002, 8519680, -3);
      var8.gravity = var1.gravity;
      var8.windowAnimations = var1.windowAnimations;
      var6.addView(var1.decorView, var8);
      var1.isOpen = true;
   }

   private boolean performPanelShortcut(AppCompatDelegateImplV7$PanelFeatureState var1, int var2, KeyEvent var3, int var4) {
      boolean var6;
      if(var3.isSystem()) {
         var6 = false;
      } else {
         boolean var5;
         label22: {
            var6 = false;
            if(!var1.isPrepared) {
               var5 = var6;
               if(!this.preparePanel(var1, var3)) {
                  break label22;
               }
            }

            var5 = var6;
            if(var1.menu != null) {
               var5 = var1.menu.performShortcut(var2, var3, var4);
            }
         }

         var6 = var5;
         if(var5) {
            var6 = var5;
            if((var4 & 1) == 0) {
               var6 = var5;
               if(this.mDecorContentParent == null) {
                  this.closePanel(var1, true);
                  return var5;
               }
            }
         }
      }

      return var6;
   }

   private boolean preparePanel(AppCompatDelegateImplV7$PanelFeatureState var1, KeyEvent var2) {
      if(!this.isDestroyed()) {
         if(var1.isPrepared) {
            return true;
         } else {
            if(this.mPreparedPanel != null && this.mPreparedPanel != var1) {
               this.closePanel(this.mPreparedPanel, false);
            }

            Callback var5 = this.getWindowCallback();
            if(var5 != null) {
               var1.createdPanelView = var5.onCreatePanelView(var1.featureId);
            }

            boolean var3;
            if(var1.featureId != 0 && var1.featureId != 108) {
               var3 = false;
            } else {
               var3 = true;
            }

            if(var3 && this.mDecorContentParent != null) {
               this.mDecorContentParent.setMenuPrepared();
            }

            if(var1.createdPanelView == null && (!var3 || !(this.peekSupportActionBar() instanceof ToolbarActionBar))) {
               if(var1.menu == null || var1.refreshMenuContent) {
                  if(var1.menu == null && (!this.initializePanelMenu(var1) || var1.menu == null)) {
                     return false;
                  }

                  if(var3 && this.mDecorContentParent != null) {
                     if(this.mActionMenuPresenterCallback == null) {
                        this.mActionMenuPresenterCallback = new AppCompatDelegateImplV7$ActionMenuPresenterCallback(this, (AppCompatDelegateImplV7$1)null);
                     }

                     this.mDecorContentParent.setMenu(var1.menu, this.mActionMenuPresenterCallback);
                  }

                  var1.menu.stopDispatchingItemsChanged();
                  if(!var5.onCreatePanelMenu(var1.featureId, var1.menu)) {
                     var1.setMenu((MenuBuilder)null);
                     if(var3 && this.mDecorContentParent != null) {
                        this.mDecorContentParent.setMenu((Menu)null, this.mActionMenuPresenterCallback);
                        return false;
                     }

                     return false;
                  }

                  var1.refreshMenuContent = false;
               }

               var1.menu.stopDispatchingItemsChanged();
               if(var1.frozenActionViewState != null) {
                  var1.menu.restoreActionViewStates(var1.frozenActionViewState);
                  var1.frozenActionViewState = null;
               }

               if(!var5.onPreparePanel(0, var1.createdPanelView, var1.menu)) {
                  if(var3 && this.mDecorContentParent != null) {
                     this.mDecorContentParent.setMenu((Menu)null, this.mActionMenuPresenterCallback);
                  }

                  var1.menu.startDispatchingItemsChanged();
                  return false;
               }

               int var6;
               if(var2 != null) {
                  var6 = var2.getDeviceId();
               } else {
                  var6 = -1;
               }

               boolean var4;
               if(KeyCharacterMap.load(var6).getKeyboardType() != 1) {
                  var4 = true;
               } else {
                  var4 = false;
               }

               var1.qwertyMode = var4;
               var1.menu.setQwertyMode(var1.qwertyMode);
               var1.menu.startDispatchingItemsChanged();
            }

            var1.isPrepared = true;
            var1.isHandled = false;
            this.mPreparedPanel = var1;
            return true;
         }
      } else {
         return false;
      }
   }

   private void reopenMenu(MenuBuilder var1, boolean var2) {
      if(this.mDecorContentParent != null && this.mDecorContentParent.canShowOverflowMenu() && (!ViewConfigurationCompat.hasPermanentMenuKey(ViewConfiguration.get(this.mContext)) || this.mDecorContentParent.isOverflowMenuShowPending())) {
         Callback var5 = this.getWindowCallback();
         if(this.mDecorContentParent.isOverflowMenuShowing() && var2) {
            this.mDecorContentParent.hideOverflowMenu();
            if(!this.isDestroyed()) {
               var5.onPanelClosed(108, this.getPanelState(0, true).menu);
               return;
            }
         } else if(var5 != null && !this.isDestroyed()) {
            if(this.mInvalidatePanelMenuPosted && (this.mInvalidatePanelMenuFeatures & 1) != 0) {
               this.mWindow.getDecorView().removeCallbacks(this.mInvalidatePanelMenuRunnable);
               this.mInvalidatePanelMenuRunnable.run();
            }

            AppCompatDelegateImplV7$PanelFeatureState var3 = this.getPanelState(0, true);
            if(var3.menu != null && !var3.refreshMenuContent && var5.onPreparePanel(0, var3.createdPanelView, var3.menu)) {
               var5.onMenuOpened(108, var3.menu);
               this.mDecorContentParent.showOverflowMenu();
            }
         }

      } else {
         AppCompatDelegateImplV7$PanelFeatureState var4 = this.getPanelState(0, true);
         var4.refreshDecorView = true;
         this.closePanel(var4, false);
         this.openPanel(var4, (KeyEvent)null);
      }
   }

   private int sanitizeWindowFeatureId(int var1) {
      int var2;
      if(var1 == 8) {
         Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
         var2 = 108;
      } else {
         var2 = var1;
         if(var1 == 9) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            return 109;
         }
      }

      return var2;
   }

   private boolean shouldInheritContext(ViewParent var1) {
      if(var1 == null) {
         return false;
      } else {
         for(View var2 = this.mWindow.getDecorView(); var1 != null; var1 = var1.getParent()) {
            if(var1 == var2 || !(var1 instanceof View) || ViewCompat.isAttachedToWindow((View)var1)) {
               return false;
            }
         }

         return true;
      }
   }

   private void throwFeatureRequestIfSubDecorInstalled() {
      if(this.mSubDecorInstalled) {
         throw new AndroidRuntimeException("Window feature must be requested before adding content");
      }
   }

   private int updateStatusGuard(int var1) {
      byte var7 = 0;
      boolean var3 = false;
      boolean var8 = false;
      boolean var6 = var3;
      int var2 = var1;
      if(this.mActionModeView != null) {
         var6 = var3;
         var2 = var1;
         if(this.mActionModeView.getLayoutParams() instanceof MarginLayoutParams) {
            MarginLayoutParams var9 = (MarginLayoutParams)this.mActionModeView.getLayoutParams();
            var3 = false;
            boolean var13 = false;
            boolean var4;
            int var5;
            if(this.mActionModeView.isShown()) {
               if(this.mTempRect1 == null) {
                  this.mTempRect1 = new Rect();
                  this.mTempRect2 = new Rect();
               }

               Rect var10 = this.mTempRect1;
               Rect var11 = this.mTempRect2;
               var10.set(0, var1, 0, 0);
               ViewUtils.computeFitSystemWindows(this.mSubDecor, var10, var11);
               int var14;
               if(var11.top == 0) {
                  var14 = var1;
               } else {
                  var14 = 0;
               }

               if(var9.topMargin != var14) {
                  var3 = true;
                  var9.topMargin = var1;
                  if(this.mStatusGuard == null) {
                     this.mStatusGuard = new View(this.mContext);
                     this.mStatusGuard.setBackgroundColor(this.mContext.getResources().getColor(R$color.abc_input_method_navigation_guard));
                     this.mSubDecor.addView(this.mStatusGuard, -1, new LayoutParams(-1, var1));
                     var13 = var3;
                  } else {
                     LayoutParams var16 = this.mStatusGuard.getLayoutParams();
                     var13 = var3;
                     if(var16.height != var1) {
                        var16.height = var1;
                        this.mStatusGuard.setLayoutParams(var16);
                        var13 = var3;
                     }
                  }
               }

               if(this.mStatusGuard != null) {
                  var6 = true;
               } else {
                  var6 = false;
               }

               var3 = var13;
               var4 = var6;
               var5 = var1;
               if(!this.mOverlayActionMode) {
                  var3 = var13;
                  var4 = var6;
                  var5 = var1;
                  if(var6) {
                     var5 = 0;
                     var4 = var6;
                     var3 = var13;
                  }
               }
            } else {
               var4 = var8;
               var5 = var1;
               if(var9.topMargin != 0) {
                  var3 = true;
                  var9.topMargin = 0;
                  var4 = var8;
                  var5 = var1;
               }
            }

            var6 = var4;
            var2 = var5;
            if(var3) {
               this.mActionModeView.setLayoutParams(var9);
               var2 = var5;
               var6 = var4;
            }
         }
      }

      if(this.mStatusGuard != null) {
         View var15 = this.mStatusGuard;
         byte var12;
         if(var6) {
            var12 = var7;
         } else {
            var12 = 8;
         }

         var15.setVisibility(var12);
      }

      return var2;
   }

   public void addContentView(View var1, LayoutParams var2) {
      this.ensureSubDecor();
      ((ViewGroup)this.mSubDecor.findViewById(16908290)).addView(var1, var2);
      this.mOriginalWindowCallback.onContentChanged();
   }

   View callActivityOnCreateView(View var1, String var2, Context var3, AttributeSet var4) {
      if(this.mOriginalWindowCallback instanceof Factory) {
         var1 = ((Factory)this.mOriginalWindowCallback).onCreateView(var2, var3, var4);
         if(var1 != null) {
            return var1;
         }
      }

      return null;
   }

   public View createView(View var1, String var2, @NonNull Context var3, @NonNull AttributeSet var4) {
      boolean var5;
      if(VERSION.SDK_INT < 21) {
         var5 = true;
      } else {
         var5 = false;
      }

      if(this.mAppCompatViewInflater == null) {
         this.mAppCompatViewInflater = new AppCompatViewInflater();
      }

      boolean var6;
      if(var5 && this.shouldInheritContext((ViewParent)var1)) {
         var6 = true;
      } else {
         var6 = false;
      }

      return this.mAppCompatViewInflater.createView(var1, var2, var3, var4, var6, var5, true, var5);
   }

   boolean dispatchKeyEvent(KeyEvent var1) {
      if(var1.getKeyCode() == 82 && this.mOriginalWindowCallback.dispatchKeyEvent(var1)) {
         return true;
      } else {
         int var3 = var1.getKeyCode();
         boolean var2;
         if(var1.getAction() == 0) {
            var2 = true;
         } else {
            var2 = false;
         }

         return var2?this.onKeyDown(var3, var1):this.onKeyUp(var3, var1);
      }
   }

   @Nullable
   public View findViewById(@IdRes int var1) {
      this.ensureSubDecor();
      return this.mWindow.findViewById(var1);
   }

   ViewGroup getSubDecor() {
      return this.mSubDecor;
   }

   public boolean hasWindowFeature(int var1) {
      var1 = this.sanitizeWindowFeatureId(var1);
      switch(var1) {
      case 1:
         return this.mWindowNoTitle;
      case 2:
         return this.mFeatureProgress;
      case 5:
         return this.mFeatureIndeterminateProgress;
      case 10:
         return this.mOverlayActionMode;
      case 108:
         return this.mHasActionBar;
      case 109:
         return this.mOverlayActionBar;
      default:
         return this.mWindow.hasFeature(var1);
      }
   }

   public void initWindowDecorActionBar() {
      this.ensureSubDecor();
      if(this.mHasActionBar && this.mActionBar == null) {
         if(this.mOriginalWindowCallback instanceof Activity) {
            this.mActionBar = new WindowDecorActionBar((Activity)this.mOriginalWindowCallback, this.mOverlayActionBar);
         } else if(this.mOriginalWindowCallback instanceof Dialog) {
            this.mActionBar = new WindowDecorActionBar((Dialog)this.mOriginalWindowCallback);
         }

         if(this.mActionBar != null) {
            this.mActionBar.setDefaultDisplayHomeAsUpEnabled(this.mEnableDefaultActionBarUp);
            return;
         }
      }

   }

   public void installViewFactory() {
      LayoutInflater var1 = LayoutInflater.from(this.mContext);
      if(var1.getFactory() == null) {
         LayoutInflaterCompat.setFactory(var1, this);
      } else if(!(LayoutInflaterCompat.getFactory(var1) instanceof AppCompatDelegateImplV7)) {
         Log.i("AppCompatDelegate", "The Activity\'s LayoutInflater already has a Factory installed so we can not install AppCompat\'s");
         return;
      }

   }

   public void invalidateOptionsMenu() {
      ActionBar var1 = this.getSupportActionBar();
      if(var1 == null || !var1.invalidateOptionsMenu()) {
         this.invalidatePanelMenu(0);
      }
   }

   boolean onBackPressed() {
      if(this.mActionMode != null) {
         this.mActionMode.finish();
      } else {
         ActionBar var1 = this.getSupportActionBar();
         if(var1 == null || !var1.collapseActionView()) {
            return false;
         }
      }

      return true;
   }

   public void onConfigurationChanged(Configuration var1) {
      if(this.mHasActionBar && this.mSubDecorInstalled) {
         ActionBar var2 = this.getSupportActionBar();
         if(var2 != null) {
            var2.onConfigurationChanged(var1);
         }
      }

   }

   public void onCreate(Bundle var1) {
      if(this.mOriginalWindowCallback instanceof Activity && NavUtils.getParentActivityName((Activity)this.mOriginalWindowCallback) != null) {
         ActionBar var2 = this.peekSupportActionBar();
         if(var2 != null) {
            var2.setDefaultDisplayHomeAsUpEnabled(true);
            return;
         }

         this.mEnableDefaultActionBarUp = true;
      }

   }

   public final View onCreateView(View var1, String var2, Context var3, AttributeSet var4) {
      View var5 = this.callActivityOnCreateView(var1, var2, var3, var4);
      return var5 != null?var5:this.createView(var1, var2, var3, var4);
   }

   public void onDestroy() {
      super.onDestroy();
      if(this.mActionBar != null) {
         this.mActionBar.onDestroy();
         this.mActionBar = null;
      }

   }

   boolean onKeyDown(int var1, KeyEvent var2) {
      boolean var3 = true;
      switch(var1) {
      case 4:
         if((var2.getFlags() & 128) == 0) {
            var3 = false;
         }

         this.mLongPressBackDown = var3;
      default:
         if(VERSION.SDK_INT < 11) {
            this.onKeyShortcut(var1, var2);
         }

         return false;
      case 82:
         this.onKeyDownPanel(0, var2);
         return true;
      }
   }

   boolean onKeyShortcut(int var1, KeyEvent var2) {
      ActionBar var4 = this.getSupportActionBar();
      if(var4 == null || !var4.onKeyShortcut(var1, var2)) {
         if(this.mPreparedPanel != null && this.performPanelShortcut(this.mPreparedPanel, var2.getKeyCode(), var2, 1)) {
            if(this.mPreparedPanel != null) {
               this.mPreparedPanel.isHandled = true;
               return true;
            }
         } else {
            if(this.mPreparedPanel == null) {
               AppCompatDelegateImplV7$PanelFeatureState var5 = this.getPanelState(0, true);
               this.preparePanel(var5, var2);
               boolean var3 = this.performPanelShortcut(var5, var2.getKeyCode(), var2, 1);
               var5.isPrepared = false;
               if(var3) {
                  return true;
               }
            }

            return false;
         }
      }

      return true;
   }

   boolean onKeyUp(int var1, KeyEvent var2) {
      boolean var3 = true;
      switch(var1) {
      case 4:
         boolean var4 = this.mLongPressBackDown;
         this.mLongPressBackDown = false;
         AppCompatDelegateImplV7$PanelFeatureState var5 = this.getPanelState(0, false);
         if(var5 != null && var5.isOpen) {
            if(!var4) {
               this.closePanel(var5, true);
               return true;
            }
            break;
         } else if(this.onBackPressed()) {
            return true;
         }
      default:
         var3 = false;
         break;
      case 82:
         this.onKeyUpPanel(0, var2);
         return true;
      }

      return var3;
   }

   public boolean onMenuItemSelected(MenuBuilder var1, MenuItem var2) {
      Callback var3 = this.getWindowCallback();
      if(var3 != null && !this.isDestroyed()) {
         AppCompatDelegateImplV7$PanelFeatureState var4 = this.findMenuPanel(var1.getRootMenu());
         if(var4 != null) {
            return var3.onMenuItemSelected(var4.featureId, var2);
         }
      }

      return false;
   }

   public void onMenuModeChange(MenuBuilder var1) {
      this.reopenMenu(var1, true);
   }

   boolean onMenuOpened(int var1, Menu var2) {
      if(var1 == 108) {
         ActionBar var3 = this.getSupportActionBar();
         if(var3 != null) {
            var3.dispatchMenuVisibilityChanged(true);
         }

         return true;
      } else {
         return false;
      }
   }

   void onPanelClosed(int var1, Menu var2) {
      if(var1 == 108) {
         ActionBar var3 = this.getSupportActionBar();
         if(var3 != null) {
            var3.dispatchMenuVisibilityChanged(false);
         }
      } else if(var1 == 0) {
         AppCompatDelegateImplV7$PanelFeatureState var4 = this.getPanelState(var1, true);
         if(var4.isOpen) {
            this.closePanel(var4, false);
            return;
         }
      }

   }

   public void onPostCreate(Bundle var1) {
      this.ensureSubDecor();
   }

   public void onPostResume() {
      ActionBar var1 = this.getSupportActionBar();
      if(var1 != null) {
         var1.setShowHideAnimationEnabled(true);
      }

   }

   public void onStop() {
      ActionBar var1 = this.getSupportActionBar();
      if(var1 != null) {
         var1.setShowHideAnimationEnabled(false);
      }

   }

   void onSubDecorInstalled(ViewGroup var1) {
   }

   void onTitleChanged(CharSequence var1) {
      if(this.mDecorContentParent != null) {
         this.mDecorContentParent.setWindowTitle(var1);
      } else {
         if(this.peekSupportActionBar() != null) {
            this.peekSupportActionBar().setWindowTitle(var1);
            return;
         }

         if(this.mTitleView != null) {
            this.mTitleView.setText(var1);
            return;
         }
      }

   }

   public boolean requestWindowFeature(int var1) {
      var1 = this.sanitizeWindowFeatureId(var1);
      if(this.mWindowNoTitle && var1 == 108) {
         return false;
      } else {
         if(this.mHasActionBar && var1 == 1) {
            this.mHasActionBar = false;
         }

         switch(var1) {
         case 1:
            this.throwFeatureRequestIfSubDecorInstalled();
            this.mWindowNoTitle = true;
            return true;
         case 2:
            this.throwFeatureRequestIfSubDecorInstalled();
            this.mFeatureProgress = true;
            return true;
         case 5:
            this.throwFeatureRequestIfSubDecorInstalled();
            this.mFeatureIndeterminateProgress = true;
            return true;
         case 10:
            this.throwFeatureRequestIfSubDecorInstalled();
            this.mOverlayActionMode = true;
            return true;
         case 108:
            this.throwFeatureRequestIfSubDecorInstalled();
            this.mHasActionBar = true;
            return true;
         case 109:
            this.throwFeatureRequestIfSubDecorInstalled();
            this.mOverlayActionBar = true;
            return true;
         default:
            return this.mWindow.requestFeature(var1);
         }
      }
   }

   public void setContentView(int var1) {
      this.ensureSubDecor();
      ViewGroup var2 = (ViewGroup)this.mSubDecor.findViewById(16908290);
      var2.removeAllViews();
      LayoutInflater.from(this.mContext).inflate(var1, var2);
      this.mOriginalWindowCallback.onContentChanged();
   }

   public void setContentView(View var1) {
      this.ensureSubDecor();
      ViewGroup var2 = (ViewGroup)this.mSubDecor.findViewById(16908290);
      var2.removeAllViews();
      var2.addView(var1);
      this.mOriginalWindowCallback.onContentChanged();
   }

   public void setContentView(View var1, LayoutParams var2) {
      this.ensureSubDecor();
      ViewGroup var3 = (ViewGroup)this.mSubDecor.findViewById(16908290);
      var3.removeAllViews();
      var3.addView(var1, var2);
      this.mOriginalWindowCallback.onContentChanged();
   }

   public void setSupportActionBar(Toolbar var1) {
      if(this.mOriginalWindowCallback instanceof Activity) {
         ActionBar var2 = this.getSupportActionBar();
         if(var2 instanceof WindowDecorActionBar) {
            throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
         } else {
            this.mMenuInflater = null;
            if(var2 != null) {
               var2.onDestroy();
            }

            if(var1 != null) {
               ToolbarActionBar var3 = new ToolbarActionBar(var1, ((Activity)this.mContext).getTitle(), this.mAppCompatWindowCallback);
               this.mActionBar = var3;
               this.mWindow.setCallback(var3.getWrappedWindowCallback());
            } else {
               this.mActionBar = null;
               this.mWindow.setCallback(this.mAppCompatWindowCallback);
            }

            this.invalidateOptionsMenu();
         }
      }
   }

   public ActionMode startSupportActionMode(ActionMode$Callback var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("ActionMode callback can not be null.");
      } else {
         if(this.mActionMode != null) {
            this.mActionMode.finish();
         }

         AppCompatDelegateImplV7$ActionModeCallbackWrapperV7 var3 = new AppCompatDelegateImplV7$ActionModeCallbackWrapperV7(this, var1);
         ActionBar var2 = this.getSupportActionBar();
         if(var2 != null) {
            this.mActionMode = var2.startActionMode(var3);
            if(this.mActionMode != null && this.mAppCompatCallback != null) {
               this.mAppCompatCallback.onSupportActionModeStarted(this.mActionMode);
            }
         }

         if(this.mActionMode == null) {
            this.mActionMode = this.startSupportActionModeFromWindow(var3);
         }

         return this.mActionMode;
      }
   }

   ActionMode startSupportActionModeFromWindow(ActionMode$Callback var1) {
      this.endOnGoingFadeAnimation();
      if(this.mActionMode != null) {
         this.mActionMode.finish();
      }

      AppCompatDelegateImplV7$ActionModeCallbackWrapperV7 var6 = new AppCompatDelegateImplV7$ActionModeCallbackWrapperV7(this, var1);
      TypedValue var5 = null;
      ActionMode var4 = var5;
      if(this.mAppCompatCallback != null) {
         var4 = var5;
         if(!this.isDestroyed()) {
            try {
               var4 = this.mAppCompatCallback.onWindowStartingSupportActionMode(var6);
            } catch (AbstractMethodError var8) {
               var4 = var5;
            }
         }
      }

      if(var4 != null) {
         this.mActionMode = var4;
      } else {
         if(this.mActionModeView == null) {
            if(this.mIsFloating) {
               var5 = new TypedValue();
               Theme var9 = this.mContext.getTheme();
               var9.resolveAttribute(R$attr.actionBarTheme, var5, true);
               Object var11;
               if(var5.resourceId != 0) {
                  Theme var7 = this.mContext.getResources().newTheme();
                  var7.setTo(var9);
                  var7.applyStyle(var5.resourceId, true);
                  var11 = new ContextThemeWrapper(this.mContext, 0);
                  ((Context)var11).getTheme().setTo(var7);
               } else {
                  var11 = this.mContext;
               }

               this.mActionModeView = new ActionBarContextView((Context)var11);
               this.mActionModePopup = new PopupWindow((Context)var11, (AttributeSet)null, R$attr.actionModePopupWindowStyle);
               PopupWindowCompat.setWindowLayoutType(this.mActionModePopup, 2);
               this.mActionModePopup.setContentView(this.mActionModeView);
               this.mActionModePopup.setWidth(-1);
               ((Context)var11).getTheme().resolveAttribute(R$attr.actionBarSize, var5, true);
               int var2 = TypedValue.complexToDimensionPixelSize(var5.data, ((Context)var11).getResources().getDisplayMetrics());
               this.mActionModeView.setContentHeight(var2);
               this.mActionModePopup.setHeight(-2);
               this.mShowActionModePopup = new AppCompatDelegateImplV7$5(this);
            } else {
               ViewStubCompat var12 = (ViewStubCompat)this.mSubDecor.findViewById(R$id.action_mode_bar_stub);
               if(var12 != null) {
                  var12.setLayoutInflater(LayoutInflater.from(this.getActionBarThemedContext()));
                  this.mActionModeView = (ActionBarContextView)var12.inflate();
               }
            }
         }

         if(this.mActionModeView != null) {
            this.endOnGoingFadeAnimation();
            this.mActionModeView.killMode();
            Context var13 = this.mActionModeView.getContext();
            ActionBarContextView var10 = this.mActionModeView;
            boolean var3;
            if(this.mActionModePopup == null) {
               var3 = true;
            } else {
               var3 = false;
            }

            StandaloneActionMode var14 = new StandaloneActionMode(var13, var10, var6, var3);
            if(var1.onCreateActionMode(var14, var14.getMenu())) {
               var14.invalidate();
               this.mActionModeView.initForMode(var14);
               this.mActionMode = var14;
               ViewCompat.setAlpha(this.mActionModeView, 0.0F);
               this.mFadeAnim = ViewCompat.animate(this.mActionModeView).alpha(1.0F);
               this.mFadeAnim.setListener(new AppCompatDelegateImplV7$6(this));
               if(this.mActionModePopup != null) {
                  this.mWindow.getDecorView().post(this.mShowActionModePopup);
               }
            } else {
               this.mActionMode = null;
            }
         }
      }

      if(this.mActionMode != null && this.mAppCompatCallback != null) {
         this.mAppCompatCallback.onSupportActionModeStarted(this.mActionMode);
      }

      return this.mActionMode;
   }
}
