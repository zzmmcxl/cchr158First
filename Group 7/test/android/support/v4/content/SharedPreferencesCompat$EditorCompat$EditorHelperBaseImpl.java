package android.support.v4.content;

import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.v4.content.SharedPreferencesCompat$EditorCompat$Helper;

class SharedPreferencesCompat$EditorCompat$EditorHelperBaseImpl implements SharedPreferencesCompat$EditorCompat$Helper {
   private SharedPreferencesCompat$EditorCompat$EditorHelperBaseImpl() {
   }

   public void apply(@NonNull Editor var1) {
      var1.commit();
   }
}
