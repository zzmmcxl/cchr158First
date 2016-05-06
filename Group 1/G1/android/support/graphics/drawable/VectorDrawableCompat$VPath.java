package android.support.graphics.drawable;

import android.graphics.Path;
import android.util.Log;
import android.content.res.Resources$Theme;

private static class VPath
{
    int mChangingConfigurations;
    protected PathParser.PathDataNode[] mNodes;
    String mPathName;
    
    public VPath() {
        super();
        this.mNodes = null;
    }
    
    public VPath(final VPath vPath) {
        super();
        this.mNodes = null;
        this.mPathName = vPath.mPathName;
        this.mChangingConfigurations = vPath.mChangingConfigurations;
        this.mNodes = PathParser.deepCopyNodes(vPath.mNodes);
    }
    
    public String NodesToString(final PathParser.PathDataNode[] array) {
        String s = " ";
        for (int i = 0; i < array.length; ++i) {
            s = s + array[i].type + ":";
            final float[] params = array[i].params;
            for (int j = 0; j < params.length; ++j) {
                s = s + params[j] + ",";
            }
        }
        return s;
    }
    
    public void applyTheme(final Resources$Theme resources$Theme) {
    }
    
    public boolean canApplyTheme() {
        return false;
    }
    
    public PathParser.PathDataNode[] getPathData() {
        return mNodes;
    }
    
    public String getPathName() {
        return mPathName;
    }
    
    public boolean isClipPath() {
        return false;
    }
    
    public void printVPath(final int n) {
        String string = "";
        for (int i = 0; i < n; ++i) {
            string += "    ";
        }
        Log.v("VectorDrawableCompat", string + "current path is :" + mPathName + " pathData is " + this.NodesToString(mNodes));
    }
    
    public void setPathData(final PathParser.PathDataNode[] array) {
        if (!PathParser.canMorph(mNodes, array)) {
            mNodes = PathParser.deepCopyNodes(array);
            return;
        }
        PathParser.updateNodes(mNodes, array);
    }
    
    public void toPath(final Path path) {
        path.reset();
        if (mNodes != null) {
            PathParser.PathDataNode.nodesToPath(mNodes, path);
        }
    }
}
