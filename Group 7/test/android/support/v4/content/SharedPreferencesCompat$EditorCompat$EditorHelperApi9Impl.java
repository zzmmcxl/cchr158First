package android.support.v4.content;

import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.v4.content.EditorCompatGingerbread;
import android.support.v4.content.SharedPreferencesCompat$EditorCompat$Helper;

class SharedPreferencesCompat$EditorCompat$EditorHelperApi9Impl implements SharedPreferencesCompat$EditorCompat$Helper {
   private SharedPreferencesCompat$EditorCompat$EditorHelperApi9Impl() {
   }

   public void apply(@NonNull Editor var1) {
      EditorCompatGingerbread.apply(var1);
   }
}
