package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.content.Loader;

public interface LoaderManager$LoaderCallbacks<D> {
   Loader<D> onCreateLoader(int var1, Bundle var2);

   void onLoadFinished(Loader<D> var1, D var2);

   void onLoaderReset(Loader<D> var1);
}
