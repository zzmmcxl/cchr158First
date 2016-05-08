package android.support.v7.app;

import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBar$Tab;
import android.support.v7.app.ActionBar$TabListener;
import android.support.v7.app.WindowDecorActionBar;
import android.support.v7.widget.AppCompatDrawableManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class WindowDecorActionBar$TabImpl extends ActionBar$Tab {
   private ActionBar$TabListener mCallback;
   private CharSequence mContentDesc;
   private View mCustomView;
   private Drawable mIcon;
   private int mPosition;
   private Object mTag;
   private CharSequence mText;

   public WindowDecorActionBar$TabImpl(WindowDecorActionBar var1) {
      this.this$0 = var1;
      this.mPosition = -1;
   }

   public ActionBar$TabListener getCallback() {
      return this.mCallback;
   }

   public CharSequence getContentDescription() {
      return this.mContentDesc;
   }

   public View getCustomView() {
      return this.mCustomView;
   }

   public Drawable getIcon() {
      return this.mIcon;
   }

   public int getPosition() {
      return this.mPosition;
   }

   public Object getTag() {
      return this.mTag;
   }

   public CharSequence getText() {
      return this.mText;
   }

   public void select() {
      this.this$0.selectTab(this);
   }

   public ActionBar$Tab setContentDescription(int var1) {
      return this.setContentDescription(WindowDecorActionBar.access$1000(this.this$0).getResources().getText(var1));
   }

   public ActionBar$Tab setContentDescription(CharSequence var1) {
      this.mContentDesc = var1;
      if(this.mPosition >= 0) {
         WindowDecorActionBar.access$1100(this.this$0).updateTab(this.mPosition);
      }

      return this;
   }

   public ActionBar$Tab setCustomView(int var1) {
      return this.setCustomView(LayoutInflater.from(this.this$0.getThemedContext()).inflate(var1, (ViewGroup)null));
   }

   public ActionBar$Tab setCustomView(View var1) {
      this.mCustomView = var1;
      if(this.mPosition >= 0) {
         WindowDecorActionBar.access$1100(this.this$0).updateTab(this.mPosition);
      }

      return this;
   }

   public ActionBar$Tab setIcon(int var1) {
      return this.setIcon(AppCompatDrawableManager.get().getDrawable(WindowDecorActionBar.access$1000(this.this$0), var1));
   }

   public ActionBar$Tab setIcon(Drawable var1) {
      this.mIcon = var1;
      if(this.mPosition >= 0) {
         WindowDecorActionBar.access$1100(this.this$0).updateTab(this.mPosition);
      }

      return this;
   }

   public void setPosition(int var1) {
      this.mPosition = var1;
   }

   public ActionBar$Tab setTabListener(ActionBar$TabListener var1) {
      this.mCallback = var1;
      return this;
   }

   public ActionBar$Tab setTag(Object var1) {
      this.mTag = var1;
      return this;
   }

   public ActionBar$Tab setText(int var1) {
      return this.setText(WindowDecorActionBar.access$1000(this.this$0).getResources().getText(var1));
   }

   public ActionBar$Tab setText(CharSequence var1) {
      this.mText = var1;
      if(this.mPosition >= 0) {
         WindowDecorActionBar.access$1100(this.this$0).updateTab(this.mPosition);
      }

      return this;
   }
}
