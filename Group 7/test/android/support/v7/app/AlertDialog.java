package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.AlertController;
import android.support.v7.app.AppCompatDialog;
import android.support.v7.appcompat.R$attr;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class AlertDialog extends AppCompatDialog implements DialogInterface {
   static final int LAYOUT_HINT_NONE = 0;
   static final int LAYOUT_HINT_SIDE = 1;
   private AlertController mAlert;

   protected AlertDialog(Context var1) {
      this(var1, resolveDialogTheme(var1, 0), true);
   }

   protected AlertDialog(Context var1, int var2) {
      this(var1, var2, true);
   }

   AlertDialog(Context var1, int var2, boolean var3) {
      super(var1, resolveDialogTheme(var1, var2));
      this.mAlert = new AlertController(this.getContext(), this, this.getWindow());
   }

   protected AlertDialog(Context var1, boolean var2, OnCancelListener var3) {
      super(var1, resolveDialogTheme(var1, 0));
      this.setCancelable(var2);
      this.setOnCancelListener(var3);
      this.mAlert = new AlertController(var1, this, this.getWindow());
   }

   static int resolveDialogTheme(Context var0, int var1) {
      if(var1 >= 16777216) {
         return var1;
      } else {
         TypedValue var2 = new TypedValue();
         var0.getTheme().resolveAttribute(R$attr.alertDialogTheme, var2, true);
         return var2.resourceId;
      }
   }

   public Button getButton(int var1) {
      return this.mAlert.getButton(var1);
   }

   public ListView getListView() {
      return this.mAlert.getListView();
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.mAlert.installContent();
   }

   public boolean onKeyDown(int var1, KeyEvent var2) {
      return this.mAlert.onKeyDown(var1, var2)?true:super.onKeyDown(var1, var2);
   }

   public boolean onKeyUp(int var1, KeyEvent var2) {
      return this.mAlert.onKeyUp(var1, var2)?true:super.onKeyUp(var1, var2);
   }

   public void setButton(int var1, CharSequence var2, OnClickListener var3) {
      this.mAlert.setButton(var1, var2, var3, (Message)null);
   }

   public void setButton(int var1, CharSequence var2, Message var3) {
      this.mAlert.setButton(var1, var2, (OnClickListener)null, var3);
   }

   void setButtonPanelLayoutHint(int var1) {
      this.mAlert.setButtonPanelLayoutHint(var1);
   }

   public void setCustomTitle(View var1) {
      this.mAlert.setCustomTitle(var1);
   }

   public void setIcon(int var1) {
      this.mAlert.setIcon(var1);
   }

   public void setIcon(Drawable var1) {
      this.mAlert.setIcon(var1);
   }

   public void setIconAttribute(int var1) {
      TypedValue var2 = new TypedValue();
      this.getContext().getTheme().resolveAttribute(var1, var2, true);
      this.mAlert.setIcon(var2.resourceId);
   }

   public void setMessage(CharSequence var1) {
      this.mAlert.setMessage(var1);
   }

   public void setTitle(CharSequence var1) {
      super.setTitle(var1);
      this.mAlert.setTitle(var1);
   }

   public void setView(View var1) {
      this.mAlert.setView(var1);
   }

   public void setView(View var1, int var2, int var3, int var4, int var5) {
      this.mAlert.setView(var1, var2, var3, var4, var5);
   }
}
