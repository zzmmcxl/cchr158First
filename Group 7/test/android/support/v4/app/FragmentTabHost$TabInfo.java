package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;

final class FragmentTabHost$TabInfo {
   private final Bundle args;
   private final Class<?> clss;
   private Fragment fragment;
   private final String tag;

   FragmentTabHost$TabInfo(String var1, Class<?> var2, Bundle var3) {
      this.tag = var1;
      this.clss = var2;
      this.args = var3;
   }
}
