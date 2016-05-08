package android.support.v7.view;

import android.support.v7.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;

public interface ActionMode$Callback {
   boolean onActionItemClicked(ActionMode var1, MenuItem var2);

   boolean onCreateActionMode(ActionMode var1, Menu var2);

   void onDestroyActionMode(ActionMode var1);

   boolean onPrepareActionMode(ActionMode var1, Menu var2);
}
