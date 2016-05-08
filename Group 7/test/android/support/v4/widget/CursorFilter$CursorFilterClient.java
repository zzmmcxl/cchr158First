package android.support.v4.widget;

import android.database.Cursor;

interface CursorFilter$CursorFilterClient {
   void changeCursor(Cursor var1);

   CharSequence convertToString(Cursor var1);

   Cursor getCursor();

   Cursor runQueryOnBackgroundThread(CharSequence var1);
}
