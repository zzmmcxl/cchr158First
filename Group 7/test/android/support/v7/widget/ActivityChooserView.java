package android.support.v7.widget;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ActionProvider;
import android.support.v7.appcompat.R$dimen;
import android.support.v7.appcompat.R$id;
import android.support.v7.appcompat.R$layout;
import android.support.v7.appcompat.R$string;
import android.support.v7.appcompat.R$styleable;
import android.support.v7.widget.ActivityChooserModel;
import android.support.v7.widget.ActivityChooserModel$ActivityChooserModelClient;
import android.support.v7.widget.ActivityChooserView$1;
import android.support.v7.widget.ActivityChooserView$2;
import android.support.v7.widget.ActivityChooserView$3;
import android.support.v7.widget.ActivityChooserView$4;
import android.support.v7.widget.ActivityChooserView$ActivityChooserViewAdapter;
import android.support.v7.widget.ActivityChooserView$Callbacks;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.ListPopupWindow;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.View.MeasureSpec;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow.OnDismissListener;

public class ActivityChooserView extends ViewGroup implements ActivityChooserModel$ActivityChooserModelClient {
   private static final String LOG_TAG = "ActivityChooserView";
   private final LinearLayoutCompat mActivityChooserContent;
   private final Drawable mActivityChooserContentBackground;
   private final ActivityChooserView$ActivityChooserViewAdapter mAdapter;
   private final ActivityChooserView$Callbacks mCallbacks;
   private int mDefaultActionButtonContentDescription;
   private final FrameLayout mDefaultActivityButton;
   private final ImageView mDefaultActivityButtonImage;
   private final FrameLayout mExpandActivityOverflowButton;
   private final ImageView mExpandActivityOverflowButtonImage;
   private int mInitialActivityCount;
   private boolean mIsAttachedToWindow;
   private boolean mIsSelectingDefaultActivity;
   private final int mListPopupMaxWidth;
   private ListPopupWindow mListPopupWindow;
   private final DataSetObserver mModelDataSetOberver;
   private OnDismissListener mOnDismissListener;
   private final OnGlobalLayoutListener mOnGlobalLayoutListener;
   ActionProvider mProvider;

   public ActivityChooserView(Context var1) {
      this(var1, (AttributeSet)null);
   }

   public ActivityChooserView(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   public ActivityChooserView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.mModelDataSetOberver = new ActivityChooserView$1(this);
      this.mOnGlobalLayoutListener = new ActivityChooserView$2(this);
      this.mInitialActivityCount = 4;
      TypedArray var4 = var1.obtainStyledAttributes(var2, R$styleable.ActivityChooserView, var3, 0);
      this.mInitialActivityCount = var4.getInt(R$styleable.ActivityChooserView_initialActivityCount, 4);
      Drawable var6 = var4.getDrawable(R$styleable.ActivityChooserView_expandActivityOverflowButtonDrawable);
      var4.recycle();
      LayoutInflater.from(this.getContext()).inflate(R$layout.abc_activity_chooser_view, this, true);
      this.mCallbacks = new ActivityChooserView$Callbacks(this, (ActivityChooserView$1)null);
      this.mActivityChooserContent = (LinearLayoutCompat)this.findViewById(R$id.activity_chooser_view_content);
      this.mActivityChooserContentBackground = this.mActivityChooserContent.getBackground();
      this.mDefaultActivityButton = (FrameLayout)this.findViewById(R$id.default_activity_button);
      this.mDefaultActivityButton.setOnClickListener(this.mCallbacks);
      this.mDefaultActivityButton.setOnLongClickListener(this.mCallbacks);
      this.mDefaultActivityButtonImage = (ImageView)this.mDefaultActivityButton.findViewById(R$id.image);
      FrameLayout var7 = (FrameLayout)this.findViewById(R$id.expand_activities_button);
      var7.setOnClickListener(this.mCallbacks);
      var7.setOnTouchListener(new ActivityChooserView$3(this, var7));
      this.mExpandActivityOverflowButton = var7;
      this.mExpandActivityOverflowButtonImage = (ImageView)var7.findViewById(R$id.image);
      this.mExpandActivityOverflowButtonImage.setImageDrawable(var6);
      this.mAdapter = new ActivityChooserView$ActivityChooserViewAdapter(this, (ActivityChooserView$1)null);
      this.mAdapter.registerDataSetObserver(new ActivityChooserView$4(this));
      Resources var5 = var1.getResources();
      this.mListPopupMaxWidth = Math.max(var5.getDisplayMetrics().widthPixels / 2, var5.getDimensionPixelSize(R$dimen.abc_config_prefDialogWidth));
   }

   private ListPopupWindow getListPopupWindow() {
      if(this.mListPopupWindow == null) {
         this.mListPopupWindow = new ListPopupWindow(this.getContext());
         this.mListPopupWindow.setAdapter(this.mAdapter);
         this.mListPopupWindow.setAnchorView(this);
         this.mListPopupWindow.setModal(true);
         this.mListPopupWindow.setOnItemClickListener(this.mCallbacks);
         this.mListPopupWindow.setOnDismissListener(this.mCallbacks);
      }

      return this.mListPopupWindow;
   }

   private void showPopupUnchecked(int var1) {
      if(this.mAdapter.getDataModel() == null) {
         throw new IllegalStateException("No data model. Did you call #setDataModel?");
      } else {
         this.getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
         boolean var4;
         if(this.mDefaultActivityButton.getVisibility() == 0) {
            var4 = true;
         } else {
            var4 = false;
         }

         int var3 = this.mAdapter.getActivityCount();
         byte var2;
         if(var4) {
            var2 = 1;
         } else {
            var2 = 0;
         }

         if(var1 != Integer.MAX_VALUE && var3 > var1 + var2) {
            this.mAdapter.setShowFooterView(true);
            this.mAdapter.setMaxActivityCount(var1 - 1);
         } else {
            this.mAdapter.setShowFooterView(false);
            this.mAdapter.setMaxActivityCount(var1);
         }

         ListPopupWindow var5 = this.getListPopupWindow();
         if(!var5.isShowing()) {
            if(!this.mIsSelectingDefaultActivity && var4) {
               this.mAdapter.setShowDefaultActivity(false, false);
            } else {
               this.mAdapter.setShowDefaultActivity(true, var4);
            }

            var5.setContentWidth(Math.min(this.mAdapter.measureContentWidth(), this.mListPopupMaxWidth));
            var5.show();
            if(this.mProvider != null) {
               this.mProvider.subUiVisibilityChanged(true);
            }

            var5.getListView().setContentDescription(this.getContext().getString(R$string.abc_activitychooserview_choose_application));
         }

      }
   }

   private void updateAppearance() {
      if(this.mAdapter.getCount() > 0) {
         this.mExpandActivityOverflowButton.setEnabled(true);
      } else {
         this.mExpandActivityOverflowButton.setEnabled(false);
      }

      int var1 = this.mAdapter.getActivityCount();
      int var2 = this.mAdapter.getHistorySize();
      if(var1 != 1 && (var1 <= 1 || var2 <= 0)) {
         this.mDefaultActivityButton.setVisibility(8);
      } else {
         this.mDefaultActivityButton.setVisibility(0);
         ResolveInfo var3 = this.mAdapter.getDefaultActivity();
         PackageManager var4 = this.getContext().getPackageManager();
         this.mDefaultActivityButtonImage.setImageDrawable(var3.loadIcon(var4));
         if(this.mDefaultActionButtonContentDescription != 0) {
            CharSequence var5 = var3.loadLabel(var4);
            String var6 = this.getContext().getString(this.mDefaultActionButtonContentDescription, new Object[]{var5});
            this.mDefaultActivityButton.setContentDescription(var6);
         }
      }

      if(this.mDefaultActivityButton.getVisibility() == 0) {
         this.mActivityChooserContent.setBackgroundDrawable(this.mActivityChooserContentBackground);
      } else {
         this.mActivityChooserContent.setBackgroundDrawable((Drawable)null);
      }
   }

   public boolean dismissPopup() {
      if(this.isShowingPopup()) {
         this.getListPopupWindow().dismiss();
         ViewTreeObserver var1 = this.getViewTreeObserver();
         if(var1.isAlive()) {
            var1.removeGlobalOnLayoutListener(this.mOnGlobalLayoutListener);
         }
      }

      return true;
   }

   public ActivityChooserModel getDataModel() {
      return this.mAdapter.getDataModel();
   }

   public boolean isShowingPopup() {
      return this.getListPopupWindow().isShowing();
   }

   protected void onAttachedToWindow() {
      super.onAttachedToWindow();
      ActivityChooserModel var1 = this.mAdapter.getDataModel();
      if(var1 != null) {
         var1.registerObserver(this.mModelDataSetOberver);
      }

      this.mIsAttachedToWindow = true;
   }

   protected void onDetachedFromWindow() {
      super.onDetachedFromWindow();
      ActivityChooserModel var1 = this.mAdapter.getDataModel();
      if(var1 != null) {
         var1.unregisterObserver(this.mModelDataSetOberver);
      }

      ViewTreeObserver var2 = this.getViewTreeObserver();
      if(var2.isAlive()) {
         var2.removeGlobalOnLayoutListener(this.mOnGlobalLayoutListener);
      }

      if(this.isShowingPopup()) {
         this.dismissPopup();
      }

      this.mIsAttachedToWindow = false;
   }

   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      this.mActivityChooserContent.layout(0, 0, var4 - var2, var5 - var3);
      if(!this.isShowingPopup()) {
         this.dismissPopup();
      }

   }

   protected void onMeasure(int var1, int var2) {
      LinearLayoutCompat var4 = this.mActivityChooserContent;
      int var3 = var2;
      if(this.mDefaultActivityButton.getVisibility() != 0) {
         var3 = MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(var2), 1073741824);
      }

      this.measureChild(var4, var1, var3);
      this.setMeasuredDimension(var4.getMeasuredWidth(), var4.getMeasuredHeight());
   }

   public void setActivityChooserModel(ActivityChooserModel var1) {
      this.mAdapter.setDataModel(var1);
      if(this.isShowingPopup()) {
         this.dismissPopup();
         this.showPopup();
      }

   }

   public void setDefaultActionButtonContentDescription(int var1) {
      this.mDefaultActionButtonContentDescription = var1;
   }

   public void setExpandActivityOverflowButtonContentDescription(int var1) {
      String var2 = this.getContext().getString(var1);
      this.mExpandActivityOverflowButtonImage.setContentDescription(var2);
   }

   public void setExpandActivityOverflowButtonDrawable(Drawable var1) {
      this.mExpandActivityOverflowButtonImage.setImageDrawable(var1);
   }

   public void setInitialActivityCount(int var1) {
      this.mInitialActivityCount = var1;
   }

   public void setOnDismissListener(OnDismissListener var1) {
      this.mOnDismissListener = var1;
   }

   public void setProvider(ActionProvider var1) {
      this.mProvider = var1;
   }

   public boolean showPopup() {
      if(!this.isShowingPopup() && this.mIsAttachedToWindow) {
         this.mIsSelectingDefaultActivity = false;
         this.showPopupUnchecked(this.mInitialActivityCount);
         return true;
      } else {
         return false;
      }
   }
}
