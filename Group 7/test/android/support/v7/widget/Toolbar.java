package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.os.Build.VERSION;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.MenuRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.annotation.StyleRes;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MarginLayoutParamsCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.ActionBar$LayoutParams;
import android.support.v7.appcompat.R$attr;
import android.support.v7.appcompat.R$styleable;
import android.support.v7.view.SupportMenuInflater;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuBuilder$Callback;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuPresenter$Callback;
import android.support.v7.widget.ActionMenuPresenter;
import android.support.v7.widget.ActionMenuView;
import android.support.v7.widget.ActionMenuView$OnMenuItemClickListener;
import android.support.v7.widget.AppCompatDrawableManager;
import android.support.v7.widget.DecorToolbar;
import android.support.v7.widget.RtlSpacingHelper;
import android.support.v7.widget.TintTypedArray;
import android.support.v7.widget.Toolbar$1;
import android.support.v7.widget.Toolbar$2;
import android.support.v7.widget.Toolbar$3;
import android.support.v7.widget.Toolbar$ExpandedActionViewMenuPresenter;
import android.support.v7.widget.Toolbar$LayoutParams;
import android.support.v7.widget.Toolbar$OnMenuItemClickListener;
import android.support.v7.widget.Toolbar$SavedState;
import android.support.v7.widget.ToolbarWidgetWrapper;
import android.support.v7.widget.ViewUtils;
import android.text.Layout;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class Toolbar extends ViewGroup {
   private static final String TAG = "Toolbar";
   private MenuPresenter$Callback mActionMenuPresenterCallback;
   private int mButtonGravity;
   private ImageButton mCollapseButtonView;
   private CharSequence mCollapseDescription;
   private Drawable mCollapseIcon;
   private boolean mCollapsible;
   private final RtlSpacingHelper mContentInsets;
   private final AppCompatDrawableManager mDrawableManager;
   private boolean mEatingHover;
   private boolean mEatingTouch;
   View mExpandedActionView;
   private Toolbar$ExpandedActionViewMenuPresenter mExpandedMenuPresenter;
   private int mGravity;
   private final ArrayList<View> mHiddenViews;
   private ImageView mLogoView;
   private int mMaxButtonHeight;
   private MenuBuilder$Callback mMenuBuilderCallback;
   private ActionMenuView mMenuView;
   private final ActionMenuView$OnMenuItemClickListener mMenuViewItemClickListener;
   private ImageButton mNavButtonView;
   private Toolbar$OnMenuItemClickListener mOnMenuItemClickListener;
   private ActionMenuPresenter mOuterActionMenuPresenter;
   private Context mPopupContext;
   private int mPopupTheme;
   private final Runnable mShowOverflowMenuRunnable;
   private CharSequence mSubtitleText;
   private int mSubtitleTextAppearance;
   private int mSubtitleTextColor;
   private TextView mSubtitleTextView;
   private final int[] mTempMargins;
   private final ArrayList<View> mTempViews;
   private int mTitleMarginBottom;
   private int mTitleMarginEnd;
   private int mTitleMarginStart;
   private int mTitleMarginTop;
   private CharSequence mTitleText;
   private int mTitleTextAppearance;
   private int mTitleTextColor;
   private TextView mTitleTextView;
   private ToolbarWidgetWrapper mWrapper;

   public Toolbar(Context var1) {
      this(var1, (AttributeSet)null);
   }

   public Toolbar(Context var1, @Nullable AttributeSet var2) {
      this(var1, var2, R$attr.toolbarStyle);
   }

   public Toolbar(Context var1, @Nullable AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.mContentInsets = new RtlSpacingHelper();
      this.mGravity = 8388627;
      this.mTempViews = new ArrayList();
      this.mHiddenViews = new ArrayList();
      this.mTempMargins = new int[2];
      this.mMenuViewItemClickListener = new Toolbar$1(this);
      this.mShowOverflowMenuRunnable = new Toolbar$2(this);
      TintTypedArray var7 = TintTypedArray.obtainStyledAttributes(this.getContext(), var2, R$styleable.Toolbar, var3, 0);
      this.mTitleTextAppearance = var7.getResourceId(R$styleable.Toolbar_titleTextAppearance, 0);
      this.mSubtitleTextAppearance = var7.getResourceId(R$styleable.Toolbar_subtitleTextAppearance, 0);
      this.mGravity = var7.getInteger(R$styleable.Toolbar_android_gravity, this.mGravity);
      this.mButtonGravity = 48;
      var3 = var7.getDimensionPixelOffset(R$styleable.Toolbar_titleMargins, 0);
      this.mTitleMarginBottom = var3;
      this.mTitleMarginTop = var3;
      this.mTitleMarginEnd = var3;
      this.mTitleMarginStart = var3;
      var3 = var7.getDimensionPixelOffset(R$styleable.Toolbar_titleMarginStart, -1);
      if(var3 >= 0) {
         this.mTitleMarginStart = var3;
      }

      var3 = var7.getDimensionPixelOffset(R$styleable.Toolbar_titleMarginEnd, -1);
      if(var3 >= 0) {
         this.mTitleMarginEnd = var3;
      }

      var3 = var7.getDimensionPixelOffset(R$styleable.Toolbar_titleMarginTop, -1);
      if(var3 >= 0) {
         this.mTitleMarginTop = var3;
      }

      var3 = var7.getDimensionPixelOffset(R$styleable.Toolbar_titleMarginBottom, -1);
      if(var3 >= 0) {
         this.mTitleMarginBottom = var3;
      }

      this.mMaxButtonHeight = var7.getDimensionPixelSize(R$styleable.Toolbar_maxButtonHeight, -1);
      var3 = var7.getDimensionPixelOffset(R$styleable.Toolbar_contentInsetStart, Integer.MIN_VALUE);
      int var4 = var7.getDimensionPixelOffset(R$styleable.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
      int var5 = var7.getDimensionPixelSize(R$styleable.Toolbar_contentInsetLeft, 0);
      int var6 = var7.getDimensionPixelSize(R$styleable.Toolbar_contentInsetRight, 0);
      this.mContentInsets.setAbsolute(var5, var6);
      if(var3 != Integer.MIN_VALUE || var4 != Integer.MIN_VALUE) {
         this.mContentInsets.setRelative(var3, var4);
      }

      this.mCollapseIcon = var7.getDrawable(R$styleable.Toolbar_collapseIcon);
      this.mCollapseDescription = var7.getText(R$styleable.Toolbar_collapseContentDescription);
      CharSequence var8 = var7.getText(R$styleable.Toolbar_title);
      if(!TextUtils.isEmpty(var8)) {
         this.setTitle(var8);
      }

      var8 = var7.getText(R$styleable.Toolbar_subtitle);
      if(!TextUtils.isEmpty(var8)) {
         this.setSubtitle(var8);
      }

      this.mPopupContext = this.getContext();
      this.setPopupTheme(var7.getResourceId(R$styleable.Toolbar_popupTheme, 0));
      Drawable var9 = var7.getDrawable(R$styleable.Toolbar_navigationIcon);
      if(var9 != null) {
         this.setNavigationIcon(var9);
      }

      var8 = var7.getText(R$styleable.Toolbar_navigationContentDescription);
      if(!TextUtils.isEmpty(var8)) {
         this.setNavigationContentDescription(var8);
      }

      var9 = var7.getDrawable(R$styleable.Toolbar_logo);
      if(var9 != null) {
         this.setLogo(var9);
      }

      var8 = var7.getText(R$styleable.Toolbar_logoDescription);
      if(!TextUtils.isEmpty(var8)) {
         this.setLogoDescription(var8);
      }

      if(var7.hasValue(R$styleable.Toolbar_titleTextColor)) {
         this.setTitleTextColor(var7.getColor(R$styleable.Toolbar_titleTextColor, -1));
      }

      if(var7.hasValue(R$styleable.Toolbar_subtitleTextColor)) {
         this.setSubtitleTextColor(var7.getColor(R$styleable.Toolbar_subtitleTextColor, -1));
      }

      var7.recycle();
      this.mDrawableManager = AppCompatDrawableManager.get();
   }

   private void addCustomViewsWithGravity(List<View> var1, int var2) {
      boolean var3 = true;
      if(ViewCompat.getLayoutDirection(this) != 1) {
         var3 = false;
      }

      int var5 = this.getChildCount();
      int var4 = GravityCompat.getAbsoluteGravity(var2, ViewCompat.getLayoutDirection(this));
      var1.clear();
      View var6;
      Toolbar$LayoutParams var7;
      if(var3) {
         for(var2 = var5 - 1; var2 >= 0; --var2) {
            var6 = this.getChildAt(var2);
            var7 = (Toolbar$LayoutParams)var6.getLayoutParams();
            if(var7.mViewType == 0 && this.shouldLayout(var6) && this.getChildHorizontalGravity(var7.gravity) == var4) {
               var1.add(var6);
            }
         }
      } else {
         for(var2 = 0; var2 < var5; ++var2) {
            var6 = this.getChildAt(var2);
            var7 = (Toolbar$LayoutParams)var6.getLayoutParams();
            if(var7.mViewType == 0 && this.shouldLayout(var6) && this.getChildHorizontalGravity(var7.gravity) == var4) {
               var1.add(var6);
            }
         }
      }

   }

   private void addSystemView(View var1, boolean var2) {
      LayoutParams var3 = var1.getLayoutParams();
      Toolbar$LayoutParams var4;
      if(var3 == null) {
         var4 = this.generateDefaultLayoutParams();
      } else if(!this.checkLayoutParams(var3)) {
         var4 = this.generateLayoutParams(var3);
      } else {
         var4 = (Toolbar$LayoutParams)var3;
      }

      var4.mViewType = 1;
      if(var2 && this.mExpandedActionView != null) {
         var1.setLayoutParams(var4);
         this.mHiddenViews.add(var1);
      } else {
         this.addView(var1, var4);
      }
   }

   private void ensureCollapseButtonView() {
      if(this.mCollapseButtonView == null) {
         this.mCollapseButtonView = new ImageButton(this.getContext(), (AttributeSet)null, R$attr.toolbarNavigationButtonStyle);
         this.mCollapseButtonView.setImageDrawable(this.mCollapseIcon);
         this.mCollapseButtonView.setContentDescription(this.mCollapseDescription);
         Toolbar$LayoutParams var1 = this.generateDefaultLayoutParams();
         var1.gravity = 8388611 | this.mButtonGravity & 112;
         var1.mViewType = 2;
         this.mCollapseButtonView.setLayoutParams(var1);
         this.mCollapseButtonView.setOnClickListener(new Toolbar$3(this));
      }

   }

   private void ensureLogoView() {
      if(this.mLogoView == null) {
         this.mLogoView = new ImageView(this.getContext());
      }

   }

   private void ensureMenu() {
      this.ensureMenuView();
      if(this.mMenuView.peekMenu() == null) {
         MenuBuilder var1 = (MenuBuilder)this.mMenuView.getMenu();
         if(this.mExpandedMenuPresenter == null) {
            this.mExpandedMenuPresenter = new Toolbar$ExpandedActionViewMenuPresenter(this, (Toolbar$1)null);
         }

         this.mMenuView.setExpandedActionViewsExclusive(true);
         var1.addMenuPresenter(this.mExpandedMenuPresenter, this.mPopupContext);
      }

   }

   private void ensureMenuView() {
      if(this.mMenuView == null) {
         this.mMenuView = new ActionMenuView(this.getContext());
         this.mMenuView.setPopupTheme(this.mPopupTheme);
         this.mMenuView.setOnMenuItemClickListener(this.mMenuViewItemClickListener);
         this.mMenuView.setMenuCallbacks(this.mActionMenuPresenterCallback, this.mMenuBuilderCallback);
         Toolbar$LayoutParams var1 = this.generateDefaultLayoutParams();
         var1.gravity = 8388613 | this.mButtonGravity & 112;
         this.mMenuView.setLayoutParams(var1);
         this.addSystemView(this.mMenuView, false);
      }

   }

   private void ensureNavButtonView() {
      if(this.mNavButtonView == null) {
         this.mNavButtonView = new ImageButton(this.getContext(), (AttributeSet)null, R$attr.toolbarNavigationButtonStyle);
         Toolbar$LayoutParams var1 = this.generateDefaultLayoutParams();
         var1.gravity = 8388611 | this.mButtonGravity & 112;
         this.mNavButtonView.setLayoutParams(var1);
      }

   }

   private int getChildHorizontalGravity(int var1) {
      int var3 = ViewCompat.getLayoutDirection(this);
      int var2 = GravityCompat.getAbsoluteGravity(var1, var3) & 7;
      var1 = var2;
      switch(var2) {
      case 2:
      case 4:
      default:
         if(var3 == 1) {
            var1 = 5;
         } else {
            var1 = 3;
         }
      case 1:
      case 3:
      case 5:
         return var1;
      }
   }

   private int getChildTop(View var1, int var2) {
      Toolbar$LayoutParams var7 = (Toolbar$LayoutParams)var1.getLayoutParams();
      int var4 = var1.getMeasuredHeight();
      if(var2 > 0) {
         var2 = (var4 - var2) / 2;
      } else {
         var2 = 0;
      }

      switch(this.getChildVerticalGravity(var7.gravity)) {
      case 48:
         return this.getPaddingTop() - var2;
      case 80:
         return this.getHeight() - this.getPaddingBottom() - var4 - var7.bottomMargin - var2;
      default:
         int var5 = this.getPaddingTop();
         var2 = this.getPaddingBottom();
         int var6 = this.getHeight();
         int var3 = (var6 - var5 - var2 - var4) / 2;
         if(var3 < var7.topMargin) {
            var2 = var7.topMargin;
         } else {
            var4 = var6 - var2 - var4 - var3 - var5;
            var2 = var3;
            if(var4 < var7.bottomMargin) {
               var2 = Math.max(0, var3 - (var7.bottomMargin - var4));
            }
         }

         return var5 + var2;
      }
   }

   private int getChildVerticalGravity(int var1) {
      int var2 = var1 & 112;
      var1 = var2;
      switch(var2) {
      default:
         var1 = this.mGravity & 112;
      case 16:
      case 48:
      case 80:
         return var1;
      }
   }

   private int getHorizontalMargins(View var1) {
      MarginLayoutParams var2 = (MarginLayoutParams)var1.getLayoutParams();
      return MarginLayoutParamsCompat.getMarginStart(var2) + MarginLayoutParamsCompat.getMarginEnd(var2);
   }

   private MenuInflater getMenuInflater() {
      return new SupportMenuInflater(this.getContext());
   }

   private int getVerticalMargins(View var1) {
      MarginLayoutParams var2 = (MarginLayoutParams)var1.getLayoutParams();
      return var2.topMargin + var2.bottomMargin;
   }

   private int getViewListMeasuredWidth(List<View> var1, int[] var2) {
      int var6 = var2[0];
      int var5 = var2[1];
      int var4 = 0;
      int var7 = var1.size();

      for(int var3 = 0; var3 < var7; ++var3) {
         View var11 = (View)var1.get(var3);
         Toolbar$LayoutParams var10 = (Toolbar$LayoutParams)var11.getLayoutParams();
         var6 = var10.leftMargin - var6;
         var5 = var10.rightMargin - var5;
         int var8 = Math.max(0, var6);
         int var9 = Math.max(0, var5);
         var6 = Math.max(0, -var6);
         var5 = Math.max(0, -var5);
         var4 += var11.getMeasuredWidth() + var8 + var9;
      }

      return var4;
   }

   private boolean isChildOrHidden(View var1) {
      return var1.getParent() == this || this.mHiddenViews.contains(var1);
   }

   private static boolean isCustomView(View var0) {
      return ((Toolbar$LayoutParams)var0.getLayoutParams()).mViewType == 0;
   }

   private int layoutChildLeft(View var1, int var2, int[] var3, int var4) {
      Toolbar$LayoutParams var6 = (Toolbar$LayoutParams)var1.getLayoutParams();
      int var5 = var6.leftMargin - var3[0];
      var2 += Math.max(0, var5);
      var3[0] = Math.max(0, -var5);
      var4 = this.getChildTop(var1, var4);
      var5 = var1.getMeasuredWidth();
      var1.layout(var2, var4, var2 + var5, var1.getMeasuredHeight() + var4);
      return var2 + var6.rightMargin + var5;
   }

   private int layoutChildRight(View var1, int var2, int[] var3, int var4) {
      Toolbar$LayoutParams var6 = (Toolbar$LayoutParams)var1.getLayoutParams();
      int var5 = var6.rightMargin - var3[1];
      var2 -= Math.max(0, var5);
      var3[1] = Math.max(0, -var5);
      var4 = this.getChildTop(var1, var4);
      var5 = var1.getMeasuredWidth();
      var1.layout(var2 - var5, var4, var2, var1.getMeasuredHeight() + var4);
      return var2 - (var6.leftMargin + var5);
   }

   private int measureChildCollapseMargins(View var1, int var2, int var3, int var4, int var5, int[] var6) {
      MarginLayoutParams var10 = (MarginLayoutParams)var1.getLayoutParams();
      int var7 = var10.leftMargin - var6[0];
      int var8 = var10.rightMargin - var6[1];
      int var9 = Math.max(0, var7) + Math.max(0, var8);
      var6[0] = Math.max(0, -var7);
      var6[1] = Math.max(0, -var8);
      var1.measure(getChildMeasureSpec(var2, this.getPaddingLeft() + this.getPaddingRight() + var9 + var3, var10.width), getChildMeasureSpec(var4, this.getPaddingTop() + this.getPaddingBottom() + var10.topMargin + var10.bottomMargin + var5, var10.height));
      return var1.getMeasuredWidth() + var9;
   }

   private void measureChildConstrained(View var1, int var2, int var3, int var4, int var5, int var6) {
      MarginLayoutParams var8 = (MarginLayoutParams)var1.getLayoutParams();
      int var7 = getChildMeasureSpec(var2, this.getPaddingLeft() + this.getPaddingRight() + var8.leftMargin + var8.rightMargin + var3, var8.width);
      var3 = getChildMeasureSpec(var4, this.getPaddingTop() + this.getPaddingBottom() + var8.topMargin + var8.bottomMargin + var5, var8.height);
      var4 = MeasureSpec.getMode(var3);
      var2 = var3;
      if(var4 != 1073741824) {
         var2 = var3;
         if(var6 >= 0) {
            if(var4 != 0) {
               var2 = Math.min(MeasureSpec.getSize(var3), var6);
            } else {
               var2 = var6;
            }

            var2 = MeasureSpec.makeMeasureSpec(var2, 1073741824);
         }
      }

      var1.measure(var7, var2);
   }

   private void postShowOverflowMenu() {
      this.removeCallbacks(this.mShowOverflowMenuRunnable);
      this.post(this.mShowOverflowMenuRunnable);
   }

   private boolean shouldCollapse() {
      if(this.mCollapsible) {
         int var2 = this.getChildCount();
         int var1 = 0;

         while(true) {
            if(var1 >= var2) {
               return true;
            }

            View var3 = this.getChildAt(var1);
            if(this.shouldLayout(var3) && var3.getMeasuredWidth() > 0 && var3.getMeasuredHeight() > 0) {
               break;
            }

            ++var1;
         }
      }

      return false;
   }

   private boolean shouldLayout(View var1) {
      return var1 != null && var1.getParent() == this && var1.getVisibility() != 8;
   }

   void addChildrenForExpandedActionView() {
      for(int var1 = this.mHiddenViews.size() - 1; var1 >= 0; --var1) {
         this.addView((View)this.mHiddenViews.get(var1));
      }

      this.mHiddenViews.clear();
   }

   public boolean canShowOverflowMenu() {
      return this.getVisibility() == 0 && this.mMenuView != null && this.mMenuView.isOverflowReserved();
   }

   protected boolean checkLayoutParams(LayoutParams var1) {
      return super.checkLayoutParams(var1) && var1 instanceof Toolbar$LayoutParams;
   }

   public void collapseActionView() {
      MenuItemImpl var1;
      if(this.mExpandedMenuPresenter == null) {
         var1 = null;
      } else {
         var1 = this.mExpandedMenuPresenter.mCurrentExpandedItem;
      }

      if(var1 != null) {
         var1.collapseActionView();
      }

   }

   public void dismissPopupMenus() {
      if(this.mMenuView != null) {
         this.mMenuView.dismissPopupMenus();
      }

   }

   protected Toolbar$LayoutParams generateDefaultLayoutParams() {
      return new Toolbar$LayoutParams(-2, -2);
   }

   public Toolbar$LayoutParams generateLayoutParams(AttributeSet var1) {
      return new Toolbar$LayoutParams(this.getContext(), var1);
   }

   protected Toolbar$LayoutParams generateLayoutParams(LayoutParams var1) {
      return var1 instanceof Toolbar$LayoutParams?new Toolbar$LayoutParams((Toolbar$LayoutParams)var1):(var1 instanceof ActionBar$LayoutParams?new Toolbar$LayoutParams((ActionBar$LayoutParams)var1):(var1 instanceof MarginLayoutParams?new Toolbar$LayoutParams((MarginLayoutParams)var1):new Toolbar$LayoutParams(var1)));
   }

   public int getContentInsetEnd() {
      return this.mContentInsets.getEnd();
   }

   public int getContentInsetLeft() {
      return this.mContentInsets.getLeft();
   }

   public int getContentInsetRight() {
      return this.mContentInsets.getRight();
   }

   public int getContentInsetStart() {
      return this.mContentInsets.getStart();
   }

   public Drawable getLogo() {
      return this.mLogoView != null?this.mLogoView.getDrawable():null;
   }

   public CharSequence getLogoDescription() {
      return this.mLogoView != null?this.mLogoView.getContentDescription():null;
   }

   public Menu getMenu() {
      this.ensureMenu();
      return this.mMenuView.getMenu();
   }

   @Nullable
   public CharSequence getNavigationContentDescription() {
      return this.mNavButtonView != null?this.mNavButtonView.getContentDescription():null;
   }

   @Nullable
   public Drawable getNavigationIcon() {
      return this.mNavButtonView != null?this.mNavButtonView.getDrawable():null;
   }

   @Nullable
   public Drawable getOverflowIcon() {
      this.ensureMenu();
      return this.mMenuView.getOverflowIcon();
   }

   public int getPopupTheme() {
      return this.mPopupTheme;
   }

   public CharSequence getSubtitle() {
      return this.mSubtitleText;
   }

   public CharSequence getTitle() {
      return this.mTitleText;
   }

   public DecorToolbar getWrapper() {
      if(this.mWrapper == null) {
         this.mWrapper = new ToolbarWidgetWrapper(this, true);
      }

      return this.mWrapper;
   }

   public boolean hasExpandedActionView() {
      return this.mExpandedMenuPresenter != null && this.mExpandedMenuPresenter.mCurrentExpandedItem != null;
   }

   public boolean hideOverflowMenu() {
      return this.mMenuView != null && this.mMenuView.hideOverflowMenu();
   }

   public void inflateMenu(@MenuRes int var1) {
      this.getMenuInflater().inflate(var1, this.getMenu());
   }

   public boolean isOverflowMenuShowPending() {
      return this.mMenuView != null && this.mMenuView.isOverflowMenuShowPending();
   }

   public boolean isOverflowMenuShowing() {
      return this.mMenuView != null && this.mMenuView.isOverflowMenuShowing();
   }

   public boolean isTitleTruncated() {
      if(this.mTitleTextView != null) {
         Layout var3 = this.mTitleTextView.getLayout();
         if(var3 != null) {
            int var2 = var3.getLineCount();

            for(int var1 = 0; var1 < var2; ++var1) {
               if(var3.getEllipsisCount(var1) > 0) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   protected void onDetachedFromWindow() {
      super.onDetachedFromWindow();
      this.removeCallbacks(this.mShowOverflowMenuRunnable);
   }

   public boolean onHoverEvent(MotionEvent var1) {
      int var2 = MotionEventCompat.getActionMasked(var1);
      if(var2 == 9) {
         this.mEatingHover = false;
      }

      if(!this.mEatingHover) {
         boolean var3 = super.onHoverEvent(var1);
         if(var2 == 9 && !var3) {
            this.mEatingHover = true;
         }
      }

      if(var2 == 10 || var2 == 3) {
         this.mEatingHover = false;
      }

      return true;
   }

   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      boolean var7;
      if(ViewCompat.getLayoutDirection(this) == 1) {
         var7 = true;
      } else {
         var7 = false;
      }

      int var12 = this.getWidth();
      int var14 = this.getHeight();
      int var10 = this.getPaddingLeft();
      int var13 = this.getPaddingRight();
      int var9 = this.getPaddingTop();
      int var15 = this.getPaddingBottom();
      var5 = var12 - var13;
      int[] var19 = this.mTempMargins;
      var19[1] = 0;
      var19[0] = 0;
      int var11 = ViewCompat.getMinimumHeight(this);
      var2 = var10;
      var3 = var5;
      if(this.shouldLayout(this.mNavButtonView)) {
         if(var7) {
            var3 = this.layoutChildRight(this.mNavButtonView, var5, var19, var11);
            var2 = var10;
         } else {
            var2 = this.layoutChildLeft(this.mNavButtonView, var10, var19, var11);
            var3 = var5;
         }
      }

      var4 = var2;
      var5 = var3;
      if(this.shouldLayout(this.mCollapseButtonView)) {
         if(var7) {
            var5 = this.layoutChildRight(this.mCollapseButtonView, var3, var19, var11);
            var4 = var2;
         } else {
            var4 = this.layoutChildLeft(this.mCollapseButtonView, var2, var19, var11);
            var5 = var3;
         }
      }

      var3 = var4;
      var2 = var5;
      if(this.shouldLayout(this.mMenuView)) {
         if(var7) {
            var3 = this.layoutChildLeft(this.mMenuView, var4, var19, var11);
            var2 = var5;
         } else {
            var2 = this.layoutChildRight(this.mMenuView, var5, var19, var11);
            var3 = var4;
         }
      }

      var19[0] = Math.max(0, this.getContentInsetLeft() - var3);
      var19[1] = Math.max(0, this.getContentInsetRight() - (var12 - var13 - var2));
      var4 = Math.max(var3, this.getContentInsetLeft());
      var5 = Math.min(var2, var12 - var13 - this.getContentInsetRight());
      var2 = var4;
      var3 = var5;
      if(this.shouldLayout(this.mExpandedActionView)) {
         if(var7) {
            var3 = this.layoutChildRight(this.mExpandedActionView, var5, var19, var11);
            var2 = var4;
         } else {
            var2 = this.layoutChildLeft(this.mExpandedActionView, var4, var19, var11);
            var3 = var5;
         }
      }

      var4 = var2;
      var5 = var3;
      if(this.shouldLayout(this.mLogoView)) {
         if(var7) {
            var5 = this.layoutChildRight(this.mLogoView, var3, var19, var11);
            var4 = var2;
         } else {
            var4 = this.layoutChildLeft(this.mLogoView, var2, var19, var11);
            var5 = var3;
         }
      }

      var1 = this.shouldLayout(this.mTitleTextView);
      boolean var16 = this.shouldLayout(this.mSubtitleTextView);
      var2 = 0;
      Toolbar$LayoutParams var17;
      if(var1) {
         var17 = (Toolbar$LayoutParams)this.mTitleTextView.getLayoutParams();
         var2 = 0 + var17.topMargin + this.mTitleTextView.getMeasuredHeight() + var17.bottomMargin;
      }

      int var8 = var2;
      if(var16) {
         var17 = (Toolbar$LayoutParams)this.mSubtitleTextView.getLayoutParams();
         var8 = var2 + var17.topMargin + this.mSubtitleTextView.getMeasuredHeight() + var17.bottomMargin;
      }

      label174: {
         if(!var1) {
            var3 = var4;
            var2 = var5;
            if(!var16) {
               break label174;
            }
         }

         TextView var23;
         if(var1) {
            var23 = this.mTitleTextView;
         } else {
            var23 = this.mSubtitleTextView;
         }

         TextView var18;
         if(var16) {
            var18 = this.mSubtitleTextView;
         } else {
            var18 = this.mTitleTextView;
         }

         var17 = (Toolbar$LayoutParams)var23.getLayoutParams();
         Toolbar$LayoutParams var24 = (Toolbar$LayoutParams)var18.getLayoutParams();
         boolean var6;
         if((!var1 || this.mTitleTextView.getMeasuredWidth() <= 0) && (!var16 || this.mSubtitleTextView.getMeasuredWidth() <= 0)) {
            var6 = false;
         } else {
            var6 = true;
         }

         switch(this.mGravity & 112) {
         case 48:
            var2 = this.getPaddingTop() + var17.topMargin + this.mTitleMarginTop;
            break;
         case 80:
            var2 = var14 - var15 - var24.bottomMargin - this.mTitleMarginBottom - var8;
            break;
         default:
            var3 = (var14 - var9 - var15 - var8) / 2;
            if(var3 < var17.topMargin + this.mTitleMarginTop) {
               var2 = var17.topMargin + this.mTitleMarginTop;
            } else {
               var8 = var14 - var15 - var8 - var3 - var9;
               var2 = var3;
               if(var8 < var17.bottomMargin + this.mTitleMarginBottom) {
                  var2 = Math.max(0, var3 - (var24.bottomMargin + this.mTitleMarginBottom - var8));
               }
            }

            var2 += var9;
         }

         int var21;
         if(var7) {
            if(var6) {
               var3 = this.mTitleMarginStart;
            } else {
               var3 = 0;
            }

            var3 -= var19[1];
            var5 -= Math.max(0, var3);
            var19[1] = Math.max(0, -var3);
            var21 = var5;
            var9 = var2;
            if(var1) {
               var17 = (Toolbar$LayoutParams)this.mTitleTextView.getLayoutParams();
               var21 = var5 - this.mTitleTextView.getMeasuredWidth();
               var9 = var2 + this.mTitleTextView.getMeasuredHeight();
               this.mTitleTextView.layout(var21, var2, var5, var9);
               var21 -= this.mTitleMarginEnd;
               var9 += var17.bottomMargin;
            }

            var8 = var5;
            if(var16) {
               var17 = (Toolbar$LayoutParams)this.mSubtitleTextView.getLayoutParams();
               var2 = var9 + var17.topMargin;
               var8 = this.mSubtitleTextView.getMeasuredWidth();
               var9 = var2 + this.mSubtitleTextView.getMeasuredHeight();
               this.mSubtitleTextView.layout(var5 - var8, var2, var5, var9);
               var8 = var5 - this.mTitleMarginEnd;
               var2 = var17.bottomMargin;
            }

            var3 = var4;
            var2 = var5;
            if(var6) {
               var2 = Math.min(var21, var8);
               var3 = var4;
            }
         } else {
            if(var6) {
               var3 = this.mTitleMarginStart;
            } else {
               var3 = 0;
            }

            var21 = var3 - var19[0];
            var3 = var4 + Math.max(0, var21);
            var19[0] = Math.max(0, -var21);
            var21 = var3;
            var9 = var2;
            if(var1) {
               var17 = (Toolbar$LayoutParams)this.mTitleTextView.getLayoutParams();
               var21 = var3 + this.mTitleTextView.getMeasuredWidth();
               var9 = var2 + this.mTitleTextView.getMeasuredHeight();
               this.mTitleTextView.layout(var3, var2, var21, var9);
               var21 += this.mTitleMarginEnd;
               var9 += var17.bottomMargin;
            }

            var8 = var3;
            if(var16) {
               var17 = (Toolbar$LayoutParams)this.mSubtitleTextView.getLayoutParams();
               var2 = var9 + var17.topMargin;
               var8 = var3 + this.mSubtitleTextView.getMeasuredWidth();
               var9 = var2 + this.mSubtitleTextView.getMeasuredHeight();
               this.mSubtitleTextView.layout(var3, var2, var8, var9);
               var8 += this.mTitleMarginEnd;
               var2 = var17.bottomMargin;
            }

            var2 = var5;
            if(var6) {
               var3 = Math.max(var21, var8);
               var2 = var5;
            }
         }
      }

      this.addCustomViewsWithGravity(this.mTempViews, 3);
      var5 = this.mTempViews.size();

      for(var4 = 0; var4 < var5; ++var4) {
         var3 = this.layoutChildLeft((View)this.mTempViews.get(var4), var3, var19, var11);
      }

      this.addCustomViewsWithGravity(this.mTempViews, 5);
      int var20 = this.mTempViews.size();
      byte var22 = 0;
      var4 = var2;

      for(var2 = var22; var2 < var20; ++var2) {
         var4 = this.layoutChildRight((View)this.mTempViews.get(var2), var4, var19, var11);
      }

      this.addCustomViewsWithGravity(this.mTempViews, 1);
      var2 = this.getViewListMeasuredWidth(this.mTempViews, var19);
      var5 = var10 + (var12 - var10 - var13) / 2 - var2 / 2;
      var20 = var5 + var2;
      if(var5 < var3) {
         var2 = var3;
      } else {
         var2 = var5;
         if(var20 > var4) {
            var2 = var5 - (var20 - var4);
         }
      }

      var4 = this.mTempViews.size();

      for(var3 = 0; var3 < var4; ++var3) {
         var2 = this.layoutChildLeft((View)this.mTempViews.get(var3), var2, var19, var11);
      }

      this.mTempViews.clear();
   }

   protected void onMeasure(int var1, int var2) {
      int var6 = 0;
      int var5 = 0;
      int[] var13 = this.mTempMargins;
      byte var8;
      byte var9;
      if(ViewUtils.isLayoutRtl(this)) {
         var9 = 1;
         var8 = 0;
      } else {
         var9 = 0;
         var8 = 1;
      }

      int var7 = 0;
      if(this.shouldLayout(this.mNavButtonView)) {
         this.measureChildConstrained(this.mNavButtonView, var1, 0, var2, 0, this.mMaxButtonHeight);
         var7 = this.mNavButtonView.getMeasuredWidth() + this.getHorizontalMargins(this.mNavButtonView);
         var6 = Math.max(0, this.mNavButtonView.getMeasuredHeight() + this.getVerticalMargins(this.mNavButtonView));
         var5 = ViewUtils.combineMeasuredStates(0, ViewCompat.getMeasuredState(this.mNavButtonView));
      }

      int var3 = var5;
      int var4 = var6;
      if(this.shouldLayout(this.mCollapseButtonView)) {
         this.measureChildConstrained(this.mCollapseButtonView, var1, 0, var2, 0, this.mMaxButtonHeight);
         var7 = this.mCollapseButtonView.getMeasuredWidth() + this.getHorizontalMargins(this.mCollapseButtonView);
         var4 = Math.max(var6, this.mCollapseButtonView.getMeasuredHeight() + this.getVerticalMargins(this.mCollapseButtonView));
         var3 = ViewUtils.combineMeasuredStates(var5, ViewCompat.getMeasuredState(this.mCollapseButtonView));
      }

      var5 = this.getContentInsetStart();
      int var10 = 0 + Math.max(var5, var7);
      var13[var9] = Math.max(0, var5 - var7);
      var7 = 0;
      var5 = var3;
      var6 = var4;
      if(this.shouldLayout(this.mMenuView)) {
         this.measureChildConstrained(this.mMenuView, var1, var10, var2, 0, this.mMaxButtonHeight);
         var7 = this.mMenuView.getMeasuredWidth() + this.getHorizontalMargins(this.mMenuView);
         var6 = Math.max(var4, this.mMenuView.getMeasuredHeight() + this.getVerticalMargins(this.mMenuView));
         var5 = ViewUtils.combineMeasuredStates(var3, ViewCompat.getMeasuredState(this.mMenuView));
      }

      var3 = this.getContentInsetEnd();
      int var16 = var10 + Math.max(var3, var7);
      var13[var8] = Math.max(0, var3 - var7);
      int var15 = var16;
      var3 = var5;
      var4 = var6;
      if(this.shouldLayout(this.mExpandedActionView)) {
         var15 = var16 + this.measureChildCollapseMargins(this.mExpandedActionView, var1, var16, var2, 0, var13);
         var4 = Math.max(var6, this.mExpandedActionView.getMeasuredHeight() + this.getVerticalMargins(this.mExpandedActionView));
         var3 = ViewUtils.combineMeasuredStates(var5, ViewCompat.getMeasuredState(this.mExpandedActionView));
      }

      var5 = var15;
      var6 = var3;
      var7 = var4;
      if(this.shouldLayout(this.mLogoView)) {
         var5 = var15 + this.measureChildCollapseMargins(this.mLogoView, var1, var15, var2, 0, var13);
         var7 = Math.max(var4, this.mLogoView.getMeasuredHeight() + this.getVerticalMargins(this.mLogoView));
         var6 = ViewUtils.combineMeasuredStates(var3, ViewCompat.getMeasuredState(this.mLogoView));
      }

      var10 = this.getChildCount();
      var4 = 0;
      var15 = var7;
      var3 = var6;

      for(var7 = var5; var4 < var10; var15 = var16) {
         View var14 = this.getChildAt(var4);
         var5 = var7;
         var6 = var3;
         var16 = var15;
         if(((Toolbar$LayoutParams)var14.getLayoutParams()).mViewType == 0) {
            if(!this.shouldLayout(var14)) {
               var16 = var15;
               var6 = var3;
               var5 = var7;
            } else {
               var5 = var7 + this.measureChildCollapseMargins(var14, var1, var7, var2, 0, var13);
               var16 = Math.max(var15, var14.getMeasuredHeight() + this.getVerticalMargins(var14));
               var6 = ViewUtils.combineMeasuredStates(var3, ViewCompat.getMeasuredState(var14));
            }
         }

         ++var4;
         var7 = var5;
         var3 = var6;
      }

      var6 = 0;
      var5 = 0;
      int var11 = this.mTitleMarginTop + this.mTitleMarginBottom;
      int var12 = this.mTitleMarginStart + this.mTitleMarginEnd;
      var4 = var3;
      if(this.shouldLayout(this.mTitleTextView)) {
         this.measureChildCollapseMargins(this.mTitleTextView, var1, var7 + var12, var2, var11, var13);
         var6 = this.mTitleTextView.getMeasuredWidth() + this.getHorizontalMargins(this.mTitleTextView);
         var5 = this.mTitleTextView.getMeasuredHeight() + this.getVerticalMargins(this.mTitleTextView);
         var4 = ViewUtils.combineMeasuredStates(var3, ViewCompat.getMeasuredState(this.mTitleTextView));
      }

      var16 = var4;
      var10 = var5;
      var3 = var6;
      if(this.shouldLayout(this.mSubtitleTextView)) {
         var3 = Math.max(var6, this.measureChildCollapseMargins(this.mSubtitleTextView, var1, var7 + var12, var2, var5 + var11, var13));
         var10 = var5 + this.mSubtitleTextView.getMeasuredHeight() + this.getVerticalMargins(this.mSubtitleTextView);
         var16 = ViewUtils.combineMeasuredStates(var4, ViewCompat.getMeasuredState(this.mSubtitleTextView));
      }

      var4 = Math.max(var15, var10);
      var15 = this.getPaddingLeft();
      var10 = this.getPaddingRight();
      var5 = this.getPaddingTop();
      var6 = this.getPaddingBottom();
      var3 = ViewCompat.resolveSizeAndState(Math.max(var7 + var3 + var15 + var10, this.getSuggestedMinimumWidth()), var1, -16777216 & var16);
      var1 = ViewCompat.resolveSizeAndState(Math.max(var4 + var5 + var6, this.getSuggestedMinimumHeight()), var2, var16 << 16);
      if(this.shouldCollapse()) {
         var1 = 0;
      }

      this.setMeasuredDimension(var3, var1);
   }

   protected void onRestoreInstanceState(Parcelable var1) {
      Toolbar$SavedState var2 = (Toolbar$SavedState)var1;
      super.onRestoreInstanceState(var2.getSuperState());
      MenuBuilder var3;
      if(this.mMenuView != null) {
         var3 = this.mMenuView.peekMenu();
      } else {
         var3 = null;
      }

      if(var2.expandedMenuItemId != 0 && this.mExpandedMenuPresenter != null && var3 != null) {
         MenuItem var4 = var3.findItem(var2.expandedMenuItemId);
         if(var4 != null) {
            MenuItemCompat.expandActionView(var4);
         }
      }

      if(var2.isOverflowOpen) {
         this.postShowOverflowMenu();
      }

   }

   public void onRtlPropertiesChanged(int var1) {
      boolean var2 = true;
      if(VERSION.SDK_INT >= 17) {
         super.onRtlPropertiesChanged(var1);
      }

      RtlSpacingHelper var3 = this.mContentInsets;
      if(var1 != 1) {
         var2 = false;
      }

      var3.setDirection(var2);
   }

   protected Parcelable onSaveInstanceState() {
      Toolbar$SavedState var1 = new Toolbar$SavedState(super.onSaveInstanceState());
      if(this.mExpandedMenuPresenter != null && this.mExpandedMenuPresenter.mCurrentExpandedItem != null) {
         var1.expandedMenuItemId = this.mExpandedMenuPresenter.mCurrentExpandedItem.getItemId();
      }

      var1.isOverflowOpen = this.isOverflowMenuShowing();
      return var1;
   }

   public boolean onTouchEvent(MotionEvent var1) {
      int var2 = MotionEventCompat.getActionMasked(var1);
      if(var2 == 0) {
         this.mEatingTouch = false;
      }

      if(!this.mEatingTouch) {
         boolean var3 = super.onTouchEvent(var1);
         if(var2 == 0 && !var3) {
            this.mEatingTouch = true;
         }
      }

      if(var2 == 1 || var2 == 3) {
         this.mEatingTouch = false;
      }

      return true;
   }

   void removeChildrenForExpandedActionView() {
      for(int var1 = this.getChildCount() - 1; var1 >= 0; --var1) {
         View var2 = this.getChildAt(var1);
         if(((Toolbar$LayoutParams)var2.getLayoutParams()).mViewType != 2 && var2 != this.mMenuView) {
            this.removeViewAt(var1);
            this.mHiddenViews.add(var2);
         }
      }

   }

   public void setCollapsible(boolean var1) {
      this.mCollapsible = var1;
      this.requestLayout();
   }

   public void setContentInsetsAbsolute(int var1, int var2) {
      this.mContentInsets.setAbsolute(var1, var2);
   }

   public void setContentInsetsRelative(int var1, int var2) {
      this.mContentInsets.setRelative(var1, var2);
   }

   public void setLogo(@DrawableRes int var1) {
      this.setLogo(this.mDrawableManager.getDrawable(this.getContext(), var1));
   }

   public void setLogo(Drawable var1) {
      if(var1 != null) {
         this.ensureLogoView();
         if(!this.isChildOrHidden(this.mLogoView)) {
            this.addSystemView(this.mLogoView, true);
         }
      } else if(this.mLogoView != null && this.isChildOrHidden(this.mLogoView)) {
         this.removeView(this.mLogoView);
         this.mHiddenViews.remove(this.mLogoView);
      }

      if(this.mLogoView != null) {
         this.mLogoView.setImageDrawable(var1);
      }

   }

   public void setLogoDescription(@StringRes int var1) {
      this.setLogoDescription(this.getContext().getText(var1));
   }

   public void setLogoDescription(CharSequence var1) {
      if(!TextUtils.isEmpty(var1)) {
         this.ensureLogoView();
      }

      if(this.mLogoView != null) {
         this.mLogoView.setContentDescription(var1);
      }

   }

   public void setMenu(MenuBuilder var1, ActionMenuPresenter var2) {
      if(var1 != null || this.mMenuView != null) {
         this.ensureMenuView();
         MenuBuilder var3 = this.mMenuView.peekMenu();
         if(var3 != var1) {
            if(var3 != null) {
               var3.removeMenuPresenter(this.mOuterActionMenuPresenter);
               var3.removeMenuPresenter(this.mExpandedMenuPresenter);
            }

            if(this.mExpandedMenuPresenter == null) {
               this.mExpandedMenuPresenter = new Toolbar$ExpandedActionViewMenuPresenter(this, (Toolbar$1)null);
            }

            var2.setExpandedActionViewsExclusive(true);
            if(var1 != null) {
               var1.addMenuPresenter(var2, this.mPopupContext);
               var1.addMenuPresenter(this.mExpandedMenuPresenter, this.mPopupContext);
            } else {
               var2.initForMenu(this.mPopupContext, (MenuBuilder)null);
               this.mExpandedMenuPresenter.initForMenu(this.mPopupContext, (MenuBuilder)null);
               var2.updateMenuView(true);
               this.mExpandedMenuPresenter.updateMenuView(true);
            }

            this.mMenuView.setPopupTheme(this.mPopupTheme);
            this.mMenuView.setPresenter(var2);
            this.mOuterActionMenuPresenter = var2;
            return;
         }
      }

   }

   public void setMenuCallbacks(MenuPresenter$Callback var1, MenuBuilder$Callback var2) {
      this.mActionMenuPresenterCallback = var1;
      this.mMenuBuilderCallback = var2;
      if(this.mMenuView != null) {
         this.mMenuView.setMenuCallbacks(var1, var2);
      }

   }

   public void setNavigationContentDescription(@StringRes int var1) {
      CharSequence var2;
      if(var1 != 0) {
         var2 = this.getContext().getText(var1);
      } else {
         var2 = null;
      }

      this.setNavigationContentDescription(var2);
   }

   public void setNavigationContentDescription(@Nullable CharSequence var1) {
      if(!TextUtils.isEmpty(var1)) {
         this.ensureNavButtonView();
      }

      if(this.mNavButtonView != null) {
         this.mNavButtonView.setContentDescription(var1);
      }

   }

   public void setNavigationIcon(@DrawableRes int var1) {
      this.setNavigationIcon(this.mDrawableManager.getDrawable(this.getContext(), var1));
   }

   public void setNavigationIcon(@Nullable Drawable var1) {
      if(var1 != null) {
         this.ensureNavButtonView();
         if(!this.isChildOrHidden(this.mNavButtonView)) {
            this.addSystemView(this.mNavButtonView, true);
         }
      } else if(this.mNavButtonView != null && this.isChildOrHidden(this.mNavButtonView)) {
         this.removeView(this.mNavButtonView);
         this.mHiddenViews.remove(this.mNavButtonView);
      }

      if(this.mNavButtonView != null) {
         this.mNavButtonView.setImageDrawable(var1);
      }

   }

   public void setNavigationOnClickListener(OnClickListener var1) {
      this.ensureNavButtonView();
      this.mNavButtonView.setOnClickListener(var1);
   }

   public void setOnMenuItemClickListener(Toolbar$OnMenuItemClickListener var1) {
      this.mOnMenuItemClickListener = var1;
   }

   public void setOverflowIcon(@Nullable Drawable var1) {
      this.ensureMenu();
      this.mMenuView.setOverflowIcon(var1);
   }

   public void setPopupTheme(@StyleRes int var1) {
      if(this.mPopupTheme != var1) {
         this.mPopupTheme = var1;
         if(var1 != 0) {
            this.mPopupContext = new ContextThemeWrapper(this.getContext(), var1);
            return;
         }

         this.mPopupContext = this.getContext();
      }

   }

   public void setSubtitle(@StringRes int var1) {
      this.setSubtitle(this.getContext().getText(var1));
   }

   public void setSubtitle(CharSequence var1) {
      if(!TextUtils.isEmpty(var1)) {
         if(this.mSubtitleTextView == null) {
            Context var2 = this.getContext();
            this.mSubtitleTextView = new TextView(var2);
            this.mSubtitleTextView.setSingleLine();
            this.mSubtitleTextView.setEllipsize(TruncateAt.END);
            if(this.mSubtitleTextAppearance != 0) {
               this.mSubtitleTextView.setTextAppearance(var2, this.mSubtitleTextAppearance);
            }

            if(this.mSubtitleTextColor != 0) {
               this.mSubtitleTextView.setTextColor(this.mSubtitleTextColor);
            }
         }

         if(!this.isChildOrHidden(this.mSubtitleTextView)) {
            this.addSystemView(this.mSubtitleTextView, true);
         }
      } else if(this.mSubtitleTextView != null && this.isChildOrHidden(this.mSubtitleTextView)) {
         this.removeView(this.mSubtitleTextView);
         this.mHiddenViews.remove(this.mSubtitleTextView);
      }

      if(this.mSubtitleTextView != null) {
         this.mSubtitleTextView.setText(var1);
      }

      this.mSubtitleText = var1;
   }

   public void setSubtitleTextAppearance(Context var1, @StyleRes int var2) {
      this.mSubtitleTextAppearance = var2;
      if(this.mSubtitleTextView != null) {
         this.mSubtitleTextView.setTextAppearance(var1, var2);
      }

   }

   public void setSubtitleTextColor(@ColorInt int var1) {
      this.mSubtitleTextColor = var1;
      if(this.mSubtitleTextView != null) {
         this.mSubtitleTextView.setTextColor(var1);
      }

   }

   public void setTitle(@StringRes int var1) {
      this.setTitle(this.getContext().getText(var1));
   }

   public void setTitle(CharSequence var1) {
      if(!TextUtils.isEmpty(var1)) {
         if(this.mTitleTextView == null) {
            Context var2 = this.getContext();
            this.mTitleTextView = new TextView(var2);
            this.mTitleTextView.setSingleLine();
            this.mTitleTextView.setEllipsize(TruncateAt.END);
            if(this.mTitleTextAppearance != 0) {
               this.mTitleTextView.setTextAppearance(var2, this.mTitleTextAppearance);
            }

            if(this.mTitleTextColor != 0) {
               this.mTitleTextView.setTextColor(this.mTitleTextColor);
            }
         }

         if(!this.isChildOrHidden(this.mTitleTextView)) {
            this.addSystemView(this.mTitleTextView, true);
         }
      } else if(this.mTitleTextView != null && this.isChildOrHidden(this.mTitleTextView)) {
         this.removeView(this.mTitleTextView);
         this.mHiddenViews.remove(this.mTitleTextView);
      }

      if(this.mTitleTextView != null) {
         this.mTitleTextView.setText(var1);
      }

      this.mTitleText = var1;
   }

   public void setTitleTextAppearance(Context var1, @StyleRes int var2) {
      this.mTitleTextAppearance = var2;
      if(this.mTitleTextView != null) {
         this.mTitleTextView.setTextAppearance(var1, var2);
      }

   }

   public void setTitleTextColor(@ColorInt int var1) {
      this.mTitleTextColor = var1;
      if(this.mTitleTextView != null) {
         this.mTitleTextView.setTextColor(var1);
      }

   }

   public boolean showOverflowMenu() {
      return this.mMenuView != null && this.mMenuView.showOverflowMenu();
   }
}
