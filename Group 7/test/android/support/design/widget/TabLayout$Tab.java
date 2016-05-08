package android.support.design.widget;

import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout$TabView;
import android.support.v7.widget.AppCompatDrawableManager;
import android.view.LayoutInflater;
import android.view.View;

public final class TabLayout$Tab {
   public static final int INVALID_POSITION = -1;
   private CharSequence mContentDesc;
   private View mCustomView;
   private Drawable mIcon;
   private TabLayout mParent;
   private int mPosition;
   private Object mTag;
   private CharSequence mText;
   private TabLayout$TabView mView;

   private TabLayout$Tab() {
      this.mPosition = -1;
   }

   private void reset() {
      this.mParent = null;
      this.mView = null;
      this.mTag = null;
      this.mIcon = null;
      this.mText = null;
      this.mContentDesc = null;
      this.mPosition = -1;
      this.mCustomView = null;
   }

   private void updateView() {
      if(this.mView != null) {
         this.mView.update();
      }

   }

   @Nullable
   public CharSequence getContentDescription() {
      return this.mContentDesc;
   }

   @Nullable
   public View getCustomView() {
      return this.mCustomView;
   }

   @Nullable
   public Drawable getIcon() {
      return this.mIcon;
   }

   public int getPosition() {
      return this.mPosition;
   }

   @Nullable
   public Object getTag() {
      return this.mTag;
   }

   @Nullable
   public CharSequence getText() {
      return this.mText;
   }

   public boolean isSelected() {
      if(this.mParent == null) {
         throw new IllegalArgumentException("Tab not attached to a TabLayout");
      } else {
         return this.mParent.getSelectedTabPosition() == this.mPosition;
      }
   }

   public void select() {
      if(this.mParent == null) {
         throw new IllegalArgumentException("Tab not attached to a TabLayout");
      } else {
         this.mParent.selectTab(this);
      }
   }

   @NonNull
   public TabLayout$Tab setContentDescription(@StringRes int var1) {
      if(this.mParent == null) {
         throw new IllegalArgumentException("Tab not attached to a TabLayout");
      } else {
         return this.setContentDescription(this.mParent.getResources().getText(var1));
      }
   }

   @NonNull
   public TabLayout$Tab setContentDescription(@Nullable CharSequence var1) {
      this.mContentDesc = var1;
      this.updateView();
      return this;
   }

   @NonNull
   public TabLayout$Tab setCustomView(@LayoutRes int var1) {
      return this.setCustomView(LayoutInflater.from(this.mView.getContext()).inflate(var1, this.mView, false));
   }

   @NonNull
   public TabLayout$Tab setCustomView(@Nullable View var1) {
      this.mCustomView = var1;
      this.updateView();
      return this;
   }

   @NonNull
   public TabLayout$Tab setIcon(@DrawableRes int var1) {
      if(this.mParent == null) {
         throw new IllegalArgumentException("Tab not attached to a TabLayout");
      } else {
         return this.setIcon(AppCompatDrawableManager.get().getDrawable(this.mParent.getContext(), var1));
      }
   }

   @NonNull
   public TabLayout$Tab setIcon(@Nullable Drawable var1) {
      this.mIcon = var1;
      this.updateView();
      return this;
   }

   void setPosition(int var1) {
      this.mPosition = var1;
   }

   @NonNull
   public TabLayout$Tab setTag(@Nullable Object var1) {
      this.mTag = var1;
      return this;
   }

   @NonNull
   public TabLayout$Tab setText(@StringRes int var1) {
      if(this.mParent == null) {
         throw new IllegalArgumentException("Tab not attached to a TabLayout");
      } else {
         return this.setText(this.mParent.getResources().getText(var1));
      }
   }

   @NonNull
   public TabLayout$Tab setText(@Nullable CharSequence var1) {
      this.mText = var1;
      this.updateView();
      return this;
   }
}
