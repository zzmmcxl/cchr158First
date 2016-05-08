package android.support.v7.app;

import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatDelegateImplV7;
import android.support.v7.app.AppCompatDelegateImplV7$ActionModeCallbackWrapperV7$1;
import android.support.v7.view.ActionMode;
import android.support.v7.view.ActionMode$Callback;
import android.view.Menu;
import android.view.MenuItem;

class AppCompatDelegateImplV7$ActionModeCallbackWrapperV7 implements ActionMode$Callback {
   private ActionMode$Callback mWrapped;

   public AppCompatDelegateImplV7$ActionModeCallbackWrapperV7(AppCompatDelegateImplV7 var1, ActionMode$Callback var2) {
      this.this$0 = var1;
      this.mWrapped = var2;
   }

   public boolean onActionItemClicked(ActionMode var1, MenuItem var2) {
      return this.mWrapped.onActionItemClicked(var1, var2);
   }

   public boolean onCreateActionMode(ActionMode var1, Menu var2) {
      return this.mWrapped.onCreateActionMode(var1, var2);
   }

   public void onDestroyActionMode(ActionMode var1) {
      this.mWrapped.onDestroyActionMode(var1);
      if(this.this$0.mActionModePopup != null) {
         this.this$0.mWindow.getDecorView().removeCallbacks(this.this$0.mShowActionModePopup);
      }

      if(this.this$0.mActionModeView != null) {
         AppCompatDelegateImplV7.access$500(this.this$0);
         this.this$0.mFadeAnim = ViewCompat.animate(this.this$0.mActionModeView).alpha(0.0F);
         this.this$0.mFadeAnim.setListener(new AppCompatDelegateImplV7$ActionModeCallbackWrapperV7$1(this));
      }

      if(this.this$0.mAppCompatCallback != null) {
         this.this$0.mAppCompatCallback.onSupportActionModeFinished(this.this$0.mActionMode);
      }

      this.this$0.mActionMode = null;
   }

   public boolean onPrepareActionMode(ActionMode var1, Menu var2) {
      return this.mWrapped.onPrepareActionMode(var1, var2);
   }
}
