package android.support.v4.content;

import android.net.Uri;
import java.io.File;

interface FileProvider$PathStrategy {
   File getFileForUri(Uri var1);

   Uri getUriForFile(File var1);
}
