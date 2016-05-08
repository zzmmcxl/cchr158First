package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.R$dimen;
import android.support.design.R$style;
import android.support.design.R$styleable;
import android.support.design.widget.AnimationUtils;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout$1;
import android.support.design.widget.TabLayout$OnTabSelectedListener;
import android.support.design.widget.TabLayout$PagerAdapterObserver;
import android.support.design.widget.TabLayout$SlidingTabStrip;
import android.support.design.widget.TabLayout$Tab;
import android.support.design.widget.TabLayout$TabLayoutOnPageChangeListener;
import android.support.design.widget.TabLayout$TabView;
import android.support.design.widget.TabLayout$ViewPagerOnTabSelectedListener;
import android.support.design.widget.ThemeUtils;
import android.support.design.widget.ValueAnimatorCompat;
import android.support.design.widget.ViewUtils;
import android.support.v4.util.Pools$Pool;
import android.support.v4.util.Pools$SimplePool;
import android.support.v4.util.Pools$SynchronizedPool;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.HorizontalScrollView;
import android.widget.FrameLayout.LayoutParams;
import java.util.ArrayList;
import java.util.Iterator;

public class TabLayout extends HorizontalScrollView {
   private static final int ANIMATION_DURATION = 300;
   private static final int DEFAULT_GAP_TEXT_ICON = 8;
   private static final int DEFAULT_HEIGHT = 48;
   private static final int DEFAULT_HEIGHT_WITH_TEXT_ICON = 72;
   private static final int FIXED_WRAP_GUTTER_MIN = 16;
   public static final int GRAVITY_CENTER = 1;
   public static final int GRAVITY_FILL = 0;
   private static final int INVALID_WIDTH = -1;
   public static final int MODE_FIXED = 1;
   public static final int MODE_SCROLLABLE = 0;
   private static final int MOTION_NON_ADJACENT_OFFSET = 24;
   private static final int TAB_MIN_WIDTH_MARGIN = 56;
   private static final Pools$Pool<TabLayout$Tab> sTabPool = new Pools$SynchronizedPool(16);
   private int mContentInsetStart;
   private int mMode;
   private TabLayout$OnTabSelectedListener mOnTabSelectedListener;
   private TabLayout$TabLayoutOnPageChangeListener mPageChangeListener;
   private PagerAdapter mPagerAdapter;
   private DataSetObserver mPagerAdapterObserver;
   private final int mRequestedTabMaxWidth;
   private final int mRequestedTabMinWidth;
   private ValueAnimatorCompat mScrollAnimator;
   private final int mScrollableTabMinWidth;
   private TabLayout$Tab mSelectedTab;
   private final int mTabBackgroundResId;
   private int mTabGravity;
   private int mTabMaxWidth;
   private int mTabPaddingBottom;
   private int mTabPaddingEnd;
   private int mTabPaddingStart;
   private int mTabPaddingTop;
   private final TabLayout$SlidingTabStrip mTabStrip;
   private int mTabTextAppearance;
   private ColorStateList mTabTextColors;
   private float mTabTextMultiLineSize;
   private float mTabTextSize;
   private final Pools$Pool<TabLayout$TabView> mTabViewPool;
   private final ArrayList<TabLayout$Tab> mTabs;
   private ViewPager mViewPager;

   public TabLayout(Context var1) {
      this(var1, (AttributeSet)null);
   }

   public TabLayout(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   public TabLayout(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.mTabs = new ArrayList();
      this.mTabMaxWidth = Integer.MAX_VALUE;
      this.mTabViewPool = new Pools$SimplePool(12);
      ThemeUtils.checkAppCompatTheme(var1);
      this.setHorizontalScrollBarEnabled(false);
      this.mTabStrip = new TabLayout$SlidingTabStrip(this, var1);
      super.addView(this.mTabStrip, 0, new LayoutParams(-2, -1));
      TypedArray var9 = var1.obtainStyledAttributes(var2, R$styleable.TabLayout, var3, R$style.Widget_Design_TabLayout);
      this.mTabStrip.setSelectedIndicatorHeight(var9.getDimensionPixelSize(R$styleable.TabLayout_tabIndicatorHeight, 0));
      this.mTabStrip.setSelectedIndicatorColor(var9.getColor(R$styleable.TabLayout_tabIndicatorColor, 0));
      var3 = var9.getDimensionPixelSize(R$styleable.TabLayout_tabPadding, 0);
      this.mTabPaddingBottom = var3;
      this.mTabPaddingEnd = var3;
      this.mTabPaddingTop = var3;
      this.mTabPaddingStart = var3;
      this.mTabPaddingStart = var9.getDimensionPixelSize(R$styleable.TabLayout_tabPaddingStart, this.mTabPaddingStart);
      this.mTabPaddingTop = var9.getDimensionPixelSize(R$styleable.TabLayout_tabPaddingTop, this.mTabPaddingTop);
      this.mTabPaddingEnd = var9.getDimensionPixelSize(R$styleable.TabLayout_tabPaddingEnd, this.mTabPaddingEnd);
      this.mTabPaddingBottom = var9.getDimensionPixelSize(R$styleable.TabLayout_tabPaddingBottom, this.mTabPaddingBottom);
      this.mTabTextAppearance = var9.getResourceId(R$styleable.TabLayout_tabTextAppearance, R$style.TextAppearance_Design_Tab);
      TypedArray var7 = var1.obtainStyledAttributes(this.mTabTextAppearance, R$styleable.TextAppearance);
      boolean var5 = false;

      try {
         var5 = true;
         this.mTabTextSize = (float)var7.getDimensionPixelSize(R$styleable.TextAppearance_android_textSize, 0);
         this.mTabTextColors = var7.getColorStateList(R$styleable.TextAppearance_android_textColor);
         var5 = false;
      } finally {
         if(var5) {
            var7.recycle();
         }
      }

      var7.recycle();
      if(var9.hasValue(R$styleable.TabLayout_tabTextColor)) {
         this.mTabTextColors = var9.getColorStateList(R$styleable.TabLayout_tabTextColor);
      }

      if(var9.hasValue(R$styleable.TabLayout_tabSelectedTextColor)) {
         var3 = var9.getColor(R$styleable.TabLayout_tabSelectedTextColor, 0);
         this.mTabTextColors = createColorStateList(this.mTabTextColors.getDefaultColor(), var3);
      }

      this.mRequestedTabMinWidth = var9.getDimensionPixelSize(R$styleable.TabLayout_tabMinWidth, -1);
      this.mRequestedTabMaxWidth = var9.getDimensionPixelSize(R$styleable.TabLayout_tabMaxWidth, -1);
      this.mTabBackgroundResId = var9.getResourceId(R$styleable.TabLayout_tabBackground, 0);
      this.mContentInsetStart = var9.getDimensionPixelSize(R$styleable.TabLayout_tabContentStart, 0);
      this.mMode = var9.getInt(R$styleable.TabLayout_tabMode, 1);
      this.mTabGravity = var9.getInt(R$styleable.TabLayout_tabGravity, 0);
      var9.recycle();
      Resources var8 = this.getResources();
      this.mTabTextMultiLineSize = (float)var8.getDimensionPixelSize(R$dimen.design_tab_text_size_2line);
      this.mScrollableTabMinWidth = var8.getDimensionPixelSize(R$dimen.design_tab_scrollable_min_width);
      this.applyModeAndGravity();
   }

   private void addTabFromItemView(@NonNull TabItem var1) {
      TabLayout$Tab var2 = this.newTab();
      if(var1.mText != null) {
         var2.setText(var1.mText);
      }

      if(var1.mIcon != null) {
         var2.setIcon(var1.mIcon);
      }

      if(var1.mCustomLayout != 0) {
         var2.setCustomView(var1.mCustomLayout);
      }

      this.addTab(var2);
   }

   private void addTabView(TabLayout$Tab var1, int var2, boolean var3) {
      TabLayout$TabView var4 = TabLayout$Tab.access$200(var1);
      this.mTabStrip.addView(var4, var2, this.createLayoutParamsForTabs());
      if(var3) {
         var4.setSelected(true);
      }

   }

   private void addTabView(TabLayout$Tab var1, boolean var2) {
      TabLayout$TabView var3 = TabLayout$Tab.access$200(var1);
      this.mTabStrip.addView(var3, this.createLayoutParamsForTabs());
      if(var2) {
         var3.setSelected(true);
      }

   }

   private void addViewInternal(View var1) {
      if(var1 instanceof TabItem) {
         this.addTabFromItemView((TabItem)var1);
      } else {
         throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
      }
   }

   private void animateToTab(int var1) {
      if(var1 != -1) {
         if(this.getWindowToken() != null && ViewCompat.isLaidOut(this) && !this.mTabStrip.childrenNeedLayout()) {
            int var2 = this.getScrollX();
            int var3 = this.calculateScrollXForTab(var1, 0.0F);
            if(var2 != var3) {
               if(this.mScrollAnimator == null) {
                  this.mScrollAnimator = ViewUtils.createAnimator();
                  this.mScrollAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
                  this.mScrollAnimator.setDuration(300);
                  this.mScrollAnimator.setUpdateListener(new TabLayout$1(this));
               }

               this.mScrollAnimator.setIntValues(var2, var3);
               this.mScrollAnimator.start();
            }

            this.mTabStrip.animateIndicatorToPosition(var1, 300);
         } else {
            this.setScrollPosition(var1, 0.0F, true);
         }
      }
   }

   private void applyModeAndGravity() {
      int var1 = 0;
      if(this.mMode == 0) {
         var1 = Math.max(0, this.mContentInsetStart - this.mTabPaddingStart);
      }

      ViewCompat.setPaddingRelative(this.mTabStrip, var1, 0, 0, 0);
      switch(this.mMode) {
      case 0:
         this.mTabStrip.setGravity(8388611);
         break;
      case 1:
         this.mTabStrip.setGravity(1);
      }

      this.updateTabViews(true);
   }

   private int calculateScrollXForTab(int var1, float var2) {
      int var3 = 0;
      byte var4 = 0;
      if(this.mMode == 0) {
         View var6 = this.mTabStrip.getChildAt(var1);
         View var5;
         if(var1 + 1 < this.mTabStrip.getChildCount()) {
            var5 = this.mTabStrip.getChildAt(var1 + 1);
         } else {
            var5 = null;
         }

         if(var6 != null) {
            var1 = var6.getWidth();
         } else {
            var1 = 0;
         }

         var3 = var4;
         if(var5 != null) {
            var3 = var5.getWidth();
         }

         var3 = var6.getLeft() + (int)((float)(var1 + var3) * var2 * 0.5F) + var6.getWidth() / 2 - this.getWidth() / 2;
      }

      return var3;
   }

   private void configureTab(TabLayout$Tab var1, int var2) {
      var1.setPosition(var2);
      this.mTabs.add(var2, var1);
      int var3 = this.mTabs.size();
      ++var2;

      while(var2 < var3) {
         ((TabLayout$Tab)this.mTabs.get(var2)).setPosition(var2);
         ++var2;
      }

   }

   private static ColorStateList createColorStateList(int var0, int var1) {
      int[][] var2 = new int[2][];
      int[] var3 = new int[2];
      var2[0] = SELECTED_STATE_SET;
      var3[0] = var1;
      var1 = 0 + 1;
      var2[var1] = EMPTY_STATE_SET;
      var3[var1] = var0;
      return new ColorStateList(var2, var3);
   }

   private android.widget.LinearLayout.LayoutParams createLayoutParamsForTabs() {
      android.widget.LinearLayout.LayoutParams var1 = new android.widget.LinearLayout.LayoutParams(-2, -1);
      this.updateTabViewLayoutParams(var1);
      return var1;
   }

   private TabLayout$TabView createTabView(@NonNull TabLayout$Tab var1) {
      TabLayout$TabView var2;
      if(this.mTabViewPool != null) {
         var2 = (TabLayout$TabView)this.mTabViewPool.acquire();
      } else {
         var2 = null;
      }

      TabLayout$TabView var3 = var2;
      if(var2 == null) {
         var3 = new TabLayout$TabView(this, this.getContext());
      }

      TabLayout$TabView.access$700(var3, var1);
      var3.setFocusable(true);
      var3.setMinimumWidth(this.getTabMinWidth());
      return var3;
   }

   private int dpToPx(int var1) {
      return Math.round(this.getResources().getDisplayMetrics().density * (float)var1);
   }

   private int getDefaultHeight() {
      boolean var3 = false;
      int var1 = 0;
      int var4 = this.mTabs.size();

      boolean var2;
      while(true) {
         var2 = var3;
         if(var1 >= var4) {
            break;
         }

         TabLayout$Tab var5 = (TabLayout$Tab)this.mTabs.get(var1);
         if(var5 != null && var5.getIcon() != null && !TextUtils.isEmpty(var5.getText())) {
            var2 = true;
            break;
         }

         ++var1;
      }

      return var2?72:48;
   }

   private float getScrollPosition() {
      return this.mTabStrip.getIndicatorPosition();
   }

   private int getTabMaxWidth() {
      return this.mTabMaxWidth;
   }

   private int getTabMinWidth() {
      return this.mRequestedTabMinWidth != -1?this.mRequestedTabMinWidth:(this.mMode == 0?this.mScrollableTabMinWidth:0);
   }

   private int getTabScrollRange() {
      return Math.max(0, this.mTabStrip.getWidth() - this.getWidth() - this.getPaddingLeft() - this.getPaddingRight());
   }

   private void populateFromPagerAdapter() {
      this.removeAllTabs();
      if(this.mPagerAdapter == null) {
         this.removeAllTabs();
      } else {
         int var2 = this.mPagerAdapter.getCount();

         int var1;
         for(var1 = 0; var1 < var2; ++var1) {
            this.addTab(this.newTab().setText(this.mPagerAdapter.getPageTitle(var1)), false);
         }

         if(this.mViewPager != null && var2 > 0) {
            var1 = this.mViewPager.getCurrentItem();
            if(var1 != this.getSelectedTabPosition() && var1 < this.getTabCount()) {
               this.selectTab(this.getTabAt(var1));
            }
         }

      }
   }

   private void removeTabViewAt(int var1) {
      TabLayout$TabView var2 = (TabLayout$TabView)this.mTabStrip.getChildAt(var1);
      this.mTabStrip.removeViewAt(var1);
      if(var2 != null) {
         TabLayout$TabView.access$800(var2);
         this.mTabViewPool.release(var2);
      }

      this.requestLayout();
   }

   private void setPagerAdapter(@Nullable PagerAdapter var1, boolean var2) {
      if(this.mPagerAdapter != null && this.mPagerAdapterObserver != null) {
         this.mPagerAdapter.unregisterDataSetObserver(this.mPagerAdapterObserver);
      }

      this.mPagerAdapter = var1;
      if(var2 && var1 != null) {
         if(this.mPagerAdapterObserver == null) {
            this.mPagerAdapterObserver = new TabLayout$PagerAdapterObserver(this, (TabLayout$1)null);
         }

         var1.registerDataSetObserver(this.mPagerAdapterObserver);
      }

      this.populateFromPagerAdapter();
   }

   private void setScrollPosition(int var1, float var2, boolean var3, boolean var4) {
      int var5 = Math.round((float)var1 + var2);
      if(var5 >= 0 && var5 < this.mTabStrip.getChildCount()) {
         if(var4) {
            this.mTabStrip.setIndicatorPositionFromTabPosition(var1, var2);
         }

         if(this.mScrollAnimator != null && this.mScrollAnimator.isRunning()) {
            this.mScrollAnimator.cancel();
         }

         this.scrollTo(this.calculateScrollXForTab(var1, var2), 0);
         if(var3) {
            this.setSelectedTabView(var5);
            return;
         }
      }

   }

   private void setSelectedTabView(int var1) {
      int var3 = this.mTabStrip.getChildCount();
      if(var1 < var3 && !this.mTabStrip.getChildAt(var1).isSelected()) {
         for(int var2 = 0; var2 < var3; ++var2) {
            View var5 = this.mTabStrip.getChildAt(var2);
            boolean var4;
            if(var2 == var1) {
               var4 = true;
            } else {
               var4 = false;
            }

            var5.setSelected(var4);
         }
      }

   }

   private void updateAllTabs() {
      int var1 = 0;

      for(int var2 = this.mTabs.size(); var1 < var2; ++var1) {
         TabLayout$Tab.access$600((TabLayout$Tab)this.mTabs.get(var1));
      }

   }

   private void updateTabViewLayoutParams(android.widget.LinearLayout.LayoutParams var1) {
      if(this.mMode == 1 && this.mTabGravity == 0) {
         var1.width = 0;
         var1.weight = 1.0F;
      } else {
         var1.width = -2;
         var1.weight = 0.0F;
      }
   }

   private void updateTabViews(boolean var1) {
      for(int var2 = 0; var2 < this.mTabStrip.getChildCount(); ++var2) {
         View var3 = this.mTabStrip.getChildAt(var2);
         var3.setMinimumWidth(this.getTabMinWidth());
         this.updateTabViewLayoutParams((android.widget.LinearLayout.LayoutParams)var3.getLayoutParams());
         if(var1) {
            var3.requestLayout();
         }
      }

   }

   public void addTab(@NonNull TabLayout$Tab var1) {
      this.addTab(var1, this.mTabs.isEmpty());
   }

   public void addTab(@NonNull TabLayout$Tab var1, int var2) {
      this.addTab(var1, var2, this.mTabs.isEmpty());
   }

   public void addTab(@NonNull TabLayout$Tab var1, int var2, boolean var3) {
      if(TabLayout$Tab.access$000(var1) != this) {
         throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
      } else {
         this.addTabView(var1, var2, var3);
         this.configureTab(var1, var2);
         if(var3) {
            var1.select();
         }

      }
   }

   public void addTab(@NonNull TabLayout$Tab var1, boolean var2) {
      if(TabLayout$Tab.access$000(var1) != this) {
         throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
      } else {
         this.addTabView(var1, var2);
         this.configureTab(var1, this.mTabs.size());
         if(var2) {
            var1.select();
         }

      }
   }

   public void addView(View var1) {
      this.addViewInternal(var1);
   }

   public void addView(View var1, int var2) {
      this.addViewInternal(var1);
   }

   public void addView(View var1, int var2, android.view.ViewGroup.LayoutParams var3) {
      this.addViewInternal(var1);
   }

   public void addView(View var1, android.view.ViewGroup.LayoutParams var2) {
      this.addViewInternal(var1);
   }

   public LayoutParams generateLayoutParams(AttributeSet var1) {
      return this.generateDefaultLayoutParams();
   }

   public int getSelectedTabPosition() {
      return this.mSelectedTab != null?this.mSelectedTab.getPosition():-1;
   }

   @Nullable
   public TabLayout$Tab getTabAt(int var1) {
      return (TabLayout$Tab)this.mTabs.get(var1);
   }

   public int getTabCount() {
      return this.mTabs.size();
   }

   public int getTabGravity() {
      return this.mTabGravity;
   }

   public int getTabMode() {
      return this.mMode;
   }

   @Nullable
   public ColorStateList getTabTextColors() {
      return this.mTabTextColors;
   }

   @NonNull
   public TabLayout$Tab newTab() {
      TabLayout$Tab var2 = (TabLayout$Tab)sTabPool.acquire();
      TabLayout$Tab var1 = var2;
      if(var2 == null) {
         var1 = new TabLayout$Tab((TabLayout$1)null);
      }

      TabLayout$Tab.access$002(var1, this);
      TabLayout$Tab.access$202(var1, this.createTabView(var1));
      return var1;
   }

   protected void onMeasure(int var1, int var2) {
      int var3 = this.dpToPx(this.getDefaultHeight()) + this.getPaddingTop() + this.getPaddingBottom();
      switch(MeasureSpec.getMode(var2)) {
      case Integer.MIN_VALUE:
         var2 = MeasureSpec.makeMeasureSpec(Math.min(var3, MeasureSpec.getSize(var2)), 1073741824);
         break;
      case 0:
         var2 = MeasureSpec.makeMeasureSpec(var3, 1073741824);
      }

      var3 = MeasureSpec.getSize(var1);
      if(MeasureSpec.getMode(var1) != 0) {
         if(this.mRequestedTabMaxWidth > 0) {
            var3 = this.mRequestedTabMaxWidth;
         } else {
            var3 -= this.dpToPx(56);
         }

         this.mTabMaxWidth = var3;
      }

      super.onMeasure(var1, var2);
      if(this.getChildCount() == 1) {
         View var4 = this.getChildAt(0);
         boolean var5 = false;
         switch(this.mMode) {
         case 0:
            if(var4.getMeasuredWidth() < this.getMeasuredWidth()) {
               var5 = true;
            } else {
               var5 = false;
            }
            break;
         case 1:
            if(var4.getMeasuredWidth() != this.getMeasuredWidth()) {
               var5 = true;
            } else {
               var5 = false;
            }
         }

         if(var5) {
            var1 = getChildMeasureSpec(var2, this.getPaddingTop() + this.getPaddingBottom(), var4.getLayoutParams().height);
            var4.measure(MeasureSpec.makeMeasureSpec(this.getMeasuredWidth(), 1073741824), var1);
         }
      }

   }

   public void removeAllTabs() {
      for(int var1 = this.mTabStrip.getChildCount() - 1; var1 >= 0; --var1) {
         this.removeTabViewAt(var1);
      }

      Iterator var2 = this.mTabs.iterator();

      while(var2.hasNext()) {
         TabLayout$Tab var3 = (TabLayout$Tab)var2.next();
         var2.remove();
         TabLayout$Tab.access$300(var3);
         sTabPool.release(var3);
      }

      this.mSelectedTab = null;
   }

   public void removeTab(TabLayout$Tab var1) {
      if(TabLayout$Tab.access$000(var1) != this) {
         throw new IllegalArgumentException("Tab does not belong to this TabLayout.");
      } else {
         this.removeTabAt(var1.getPosition());
      }
   }

   public void removeTabAt(int var1) {
      int var2;
      if(this.mSelectedTab != null) {
         var2 = this.mSelectedTab.getPosition();
      } else {
         var2 = 0;
      }

      this.removeTabViewAt(var1);
      TabLayout$Tab var5 = (TabLayout$Tab)this.mTabs.remove(var1);
      if(var5 != null) {
         TabLayout$Tab.access$300(var5);
         sTabPool.release(var5);
      }

      int var4 = this.mTabs.size();

      for(int var3 = var1; var3 < var4; ++var3) {
         ((TabLayout$Tab)this.mTabs.get(var3)).setPosition(var3);
      }

      if(var2 == var1) {
         if(this.mTabs.isEmpty()) {
            var5 = null;
         } else {
            var5 = (TabLayout$Tab)this.mTabs.get(Math.max(0, var1 - 1));
         }

         this.selectTab(var5);
      }

   }

   void selectTab(TabLayout$Tab var1) {
      this.selectTab(var1, true);
   }

   void selectTab(TabLayout$Tab var1, boolean var2) {
      if(this.mSelectedTab == var1) {
         if(this.mSelectedTab != null) {
            if(this.mOnTabSelectedListener != null) {
               this.mOnTabSelectedListener.onTabReselected(this.mSelectedTab);
            }

            this.animateToTab(var1.getPosition());
         }
      } else {
         if(var2) {
            int var3;
            if(var1 != null) {
               var3 = var1.getPosition();
            } else {
               var3 = -1;
            }

            if(var3 != -1) {
               this.setSelectedTabView(var3);
            }

            if((this.mSelectedTab == null || this.mSelectedTab.getPosition() == -1) && var3 != -1) {
               this.setScrollPosition(var3, 0.0F, true);
            } else {
               this.animateToTab(var3);
            }
         }

         if(this.mSelectedTab != null && this.mOnTabSelectedListener != null) {
            this.mOnTabSelectedListener.onTabUnselected(this.mSelectedTab);
         }

         this.mSelectedTab = var1;
         if(this.mSelectedTab != null && this.mOnTabSelectedListener != null) {
            this.mOnTabSelectedListener.onTabSelected(this.mSelectedTab);
            return;
         }
      }

   }

   public void setOnTabSelectedListener(TabLayout$OnTabSelectedListener var1) {
      this.mOnTabSelectedListener = var1;
   }

   public void setScrollPosition(int var1, float var2, boolean var3) {
      this.setScrollPosition(var1, var2, var3, true);
   }

   public void setSelectedTabIndicatorColor(@ColorInt int var1) {
      this.mTabStrip.setSelectedIndicatorColor(var1);
   }

   public void setSelectedTabIndicatorHeight(int var1) {
      this.mTabStrip.setSelectedIndicatorHeight(var1);
   }

   public void setTabGravity(int var1) {
      if(this.mTabGravity != var1) {
         this.mTabGravity = var1;
         this.applyModeAndGravity();
      }

   }

   public void setTabMode(int var1) {
      if(var1 != this.mMode) {
         this.mMode = var1;
         this.applyModeAndGravity();
      }

   }

   public void setTabTextColors(int var1, int var2) {
      this.setTabTextColors(createColorStateList(var1, var2));
   }

   public void setTabTextColors(@Nullable ColorStateList var1) {
      if(this.mTabTextColors != var1) {
         this.mTabTextColors = var1;
         this.updateAllTabs();
      }

   }

   @Deprecated
   public void setTabsFromPagerAdapter(@Nullable PagerAdapter var1) {
      this.setPagerAdapter(var1, false);
   }

   public void setupWithViewPager(@Nullable ViewPager var1) {
      if(this.mViewPager != null && this.mPageChangeListener != null) {
         this.mViewPager.removeOnPageChangeListener(this.mPageChangeListener);
      }

      if(var1 != null) {
         PagerAdapter var2 = var1.getAdapter();
         if(var2 == null) {
            throw new IllegalArgumentException("ViewPager does not have a PagerAdapter set");
         } else {
            this.mViewPager = var1;
            if(this.mPageChangeListener == null) {
               this.mPageChangeListener = new TabLayout$TabLayoutOnPageChangeListener(this);
            }

            TabLayout$TabLayoutOnPageChangeListener.access$400(this.mPageChangeListener);
            var1.addOnPageChangeListener(this.mPageChangeListener);
            this.setOnTabSelectedListener(new TabLayout$ViewPagerOnTabSelectedListener(var1));
            this.setPagerAdapter(var2, true);
         }
      } else {
         this.mViewPager = null;
         this.setOnTabSelectedListener((TabLayout$OnTabSelectedListener)null);
         this.setPagerAdapter((PagerAdapter)null, true);
      }
   }

   public boolean shouldDelayChildPressedState() {
      return this.getTabScrollRange() > 0;
   }
}
