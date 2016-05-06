package android.support.graphics.drawable;

import android.util.Log;
import android.graphics.Path;
import java.util.ArrayList;

class PathParser
{
    private static final String LOGTAG = "PathParser";
    
    PathParser() {
        super();
    }
    
    static /* synthetic */ float[] access$300(final float[] array, final int n, final int n2) {
        return copyOfRange(array, n, n2);
    }
    
    private static void addNode(final ArrayList<PathDataNode> list, final char c, final float[] array) {
        list.add(new PathDataNode(c, array));
    }
    
    public static boolean canMorph(final PathDataNode[] array, final PathDataNode[] array2) {
        if (array != null && array2 != null && array.length == array2.length) {
            for (int i = 0; i < array.length; ++i) {
                if (array[i].type != array2[i].type || array[i].params.length != array2[i].params.length) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    
    private static float[] copyOfRange(final float[] array, final int n, final int n2) {
        if (n > n2) {
            throw new IllegalArgumentException();
        }
        final int length = array.length;
        if (n < 0 || n > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        final int n3 = n2 - n;
        final int min = Math.min(n3, length - n);
        final float[] array2 = new float[n3];
        System.arraycopy(array, n, array2, 0, min);
        return array2;
    }
    
    public static PathDataNode[] createNodesFromPathData(final String s) {
        if (s == null) {
            return null;
        }
        int n = 0;
        int i = 1;
        final ArrayList<PathDataNode> list = new ArrayList<PathDataNode>();
        while (i < s.length()) {
            final int nextStart = nextStart(s, i);
            final String trim = s.substring(n, nextStart).trim();
            if (trim.length() > 0) {
                addNode(list, trim.charAt(0), getFloats(trim));
            }
            n = nextStart;
            i = nextStart + 1;
        }
        if (i - n == 1 && n < s.length()) {
            addNode(list, s.charAt(n), new float[0]);
        }
        return list.<PathDataNode>toArray(new PathDataNode[list.size()]);
    }
    
    public static Path createPathFromPathData(final String s) {
        final Path path = new Path();
        final PathDataNode[] nodesFromPathData = createNodesFromPathData(s);
        if (nodesFromPathData != null) {
            try {
                PathDataNode.nodesToPath(nodesFromPathData, path);
                return path;
            }
            catch (RuntimeException ex) {
                throw new RuntimeException("Error in parsing " + s, ex);
            }
        }
        return null;
    }
    
    public static PathDataNode[] deepCopyNodes(final PathDataNode[] array) {
        PathDataNode[] array2;
        if (array == null) {
            array2 = null;
        }
        else {
            array2 = new PathDataNode[array.length];
            for (int i = 0; i < array.length; ++i) {
                array2[i] = new PathDataNode(array[i]);
            }
        }
        return array2;
    }
    
    private static void extract(final String s, final int n, final ExtractFloatResult extractFloatResult) {
        int i = n;
        int n2 = 0;
        extractFloatResult.mEndWithNegOrDot = false;
        int n3 = 0;
        int n4 = 0;
        while (i < s.length()) {
            final int n5 = n4;
            final char char1 = s.charAt(i);
            n4 = 0;
            switch (char1) {
                case 32:
                case 44:
                    n2 = 1;
                    n4 = 0;
                    break;
                case 45:
                    n4 = 0;
                    if (i == n) {
                        break;
                    }
                    n4 = 0;
                    if (n5 == 0) {
                        n2 = 1;
                        extractFloatResult.mEndWithNegOrDot = true;
                        n4 = 0;
                        break;
                    }
                    break;
                case 46:
                    if (n3 == 0) {
                        n3 = 1;
                        n4 = 0;
                        break;
                    }
                    n2 = 1;
                    extractFloatResult.mEndWithNegOrDot = true;
                    n4 = 0;
                    break;
                case 69:
                case 101:
                    n4 = 1;
                    break;
            }
            if (n2 != 0) {
                break;
            }
            ++i;
        }
        extractFloatResult.mEndPosition = i;
    }
    
    private static float[] getFloats(final String s) {
        int n = 1;
        int n2;
        if (s.charAt(0) == 'z') {
            n2 = n;
        }
        else {
            n2 = 0;
        }
        if (s.charAt(0) != 'Z') {
            n = 0;
        }
        if ((n2 | n) != 0x0) {
            return new float[0];
        }
        while (true) {
        Label_0125_Outer:
            while (true) {
                int mEndPosition = 0;
                int n4 = 0;
            Label_0198:
                while (true) {
                    int n3 = 0;
                    Label_0191: {
                        try {
                            final float[] array = new float[s.length()];
                            int i = 1;
                            final ExtractFloatResult extractFloatResult = new ExtractFloatResult();
                            final int length = s.length();
                            n3 = 0;
                            while (i < length) {
                                extract(s, i, extractFloatResult);
                                mEndPosition = extractFloatResult.mEndPosition;
                                if (i >= mEndPosition) {
                                    break Label_0191;
                                }
                                n4 = n3 + 1;
                                array[n3] = Float.parseFloat(s.substring(i, mEndPosition));
                                if (!extractFloatResult.mEndWithNegOrDot) {
                                    break Label_0198;
                                }
                                i = mEndPosition;
                                n3 = n4;
                            }
                            return copyOfRange(array, 0, n3);
                        }
                        catch (NumberFormatException ex) {
                            throw new RuntimeException("error in parsing \"" + s + "\"", ex);
                        }
                    }
                    n4 = n3;
                    continue;
                }
                int i = mEndPosition + 1;
                int n3 = n4;
                continue Label_0125_Outer;
            }
        }
    }
    
    private static int nextStart(final String s, int i) {
        while (i < s.length()) {
            final char char1 = s.charAt(i);
            if (((char1 - 'A') * (char1 - 'Z') <= '\0' || (char1 - 'a') * (char1 - 'z') <= '\0') && char1 != 'e' && char1 != 'E') {
                break;
            }
            ++i;
        }
        return i;
    }
    
    public static void updateNodes(final PathDataNode[] array, final PathDataNode[] array2) {
        for (int i = 0; i < array2.length; ++i) {
            array[i].type = array2[i].type;
            for (int j = 0; j < array2[i].params.length; ++j) {
                array[i].params[j] = array2[i].params[j];
            }
        }
    }
}
