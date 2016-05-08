package android.support.v7.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.v4.internal.view.SupportMenu;
import android.support.v7.view.ActionMode;
import android.support.v7.view.menu.MenuWrapperFactory;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

@TargetApi(11)
public class SupportActionModeWrapper extends android.view.ActionMode {
   final Context mContext;
   final ActionMode mWrappedObject;

   public SupportActionModeWrapper(Context var1, ActionMode var2) {
      this.mContext = var1;
      this.mWrappedObject = var2;
   }

   public void finish() {
      this.mWrappedObject.finish();
   }

   public View getCustomView() {
      return this.mWrappedObject.getCustomView();
   }

   public Menu getMenu() {
      return MenuWrapperFactory.wrapSupportMenu(this.mContext, (SupportMenu)this.mWrappedObject.getMenu());
   }

   public MenuInflater getMenuInflater() {
      return this.mWrappedObject.getMenuInflater();
   }

   public CharSequence getSubtitle() {
      return this.mWrappedObject.getSubtitle();
   }

   public Object getTag() {
      return this.mWrappedObject.getTag();
   }

   public CharSequence getTitle() {
      return this.mWrappedObject.getTitle();
   }

   public boolean getTitleOptionalHint() {
      return this.mWrappedObject.getTitleOptionalHint();
   }

   public void invalidate() {
      this.mWrappedObject.invalidate();
   }

   public boolean isTitleOptional() {
      return this.mWrappedObject.isTitleOptional();
   }

   public void setCustomView(View var1) {
      this.mWrappedObject.setCustomView(var1);
   }

   public void setSubtitle(int var1) {
      this.mWrappedObject.setSubtitle(var1);
   }

   public void setSubtitle(CharSequence var1) {
      this.mWrappedObject.setSubtitle(var1);
   }

   public void setTag(Object var1) {
      this.mWrappedObject.setTag(var1);
   }

   public void setTitle(int var1) {
      this.mWrappedObject.setTitle(var1);
   }

   public void setTitle(CharSequence var1) {
      this.mWrappedObject.setTitle(var1);
   }

   public void setTitleOptionalHint(boolean var1) {
      this.mWrappedObject.setTitleOptionalHint(var1);
   }
}
