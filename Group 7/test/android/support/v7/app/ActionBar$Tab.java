package android.support.v7.app;

import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.v7.app.ActionBar$TabListener;
import android.view.View;

public abstract class ActionBar$Tab {
   public static final int INVALID_POSITION = -1;

   public abstract CharSequence getContentDescription();

   public abstract View getCustomView();

   public abstract Drawable getIcon();

   public abstract int getPosition();

   public abstract Object getTag();

   public abstract CharSequence getText();

   public abstract void select();

   public abstract ActionBar$Tab setContentDescription(int var1);

   public abstract ActionBar$Tab setContentDescription(CharSequence var1);

   public abstract ActionBar$Tab setCustomView(int var1);

   public abstract ActionBar$Tab setCustomView(View var1);

   public abstract ActionBar$Tab setIcon(@DrawableRes int var1);

   public abstract ActionBar$Tab setIcon(Drawable var1);

   public abstract ActionBar$Tab setTabListener(ActionBar$TabListener var1);

   public abstract ActionBar$Tab setTag(Object var1);

   public abstract ActionBar$Tab setText(int var1);

   public abstract ActionBar$Tab setText(CharSequence var1);
}
