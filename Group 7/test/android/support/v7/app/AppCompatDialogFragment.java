package android.support.v7.app;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatDialog;

public class AppCompatDialogFragment extends DialogFragment {
   public Dialog onCreateDialog(Bundle var1) {
      return new AppCompatDialog(this.getActivity(), this.getTheme());
   }

   public void setupDialog(Dialog var1, int var2) {
      if(var1 instanceof AppCompatDialog) {
         AppCompatDialog var3 = (AppCompatDialog)var1;
         switch(var2) {
         case 3:
            var1.getWindow().addFlags(24);
         case 1:
         case 2:
            var3.supportRequestWindowFeature(1);
            return;
         default:
         }
      } else {
         super.setupDialog(var1, var2);
      }
   }
}
