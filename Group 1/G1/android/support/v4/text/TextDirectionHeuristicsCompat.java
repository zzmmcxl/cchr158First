package android.support.v4.text;

import java.util.Locale;
import java.nio.CharBuffer;

public final class TextDirectionHeuristicsCompat
{
    public static final TextDirectionHeuristicCompat ANYRTL_LTR;
    public static final TextDirectionHeuristicCompat FIRSTSTRONG_LTR;
    public static final TextDirectionHeuristicCompat FIRSTSTRONG_RTL;
    public static final TextDirectionHeuristicCompat LOCALE;
    public static final TextDirectionHeuristicCompat LTR;
    public static final TextDirectionHeuristicCompat RTL;
    private static final int STATE_FALSE = 1;
    private static final int STATE_TRUE = 0;
    private static final int STATE_UNKNOWN = 2;
    
    static {
        LTR = new TextDirectionHeuristicInternal((TextDirectionAlgorithm)null, false);
        RTL = new TextDirectionHeuristicInternal((TextDirectionAlgorithm)null, true);
        FIRSTSTRONG_LTR = new TextDirectionHeuristicInternal((TextDirectionAlgorithm)FirstStrong.INSTANCE, false);
        FIRSTSTRONG_RTL = new TextDirectionHeuristicInternal((TextDirectionAlgorithm)FirstStrong.INSTANCE, true);
        ANYRTL_LTR = new TextDirectionHeuristicInternal((TextDirectionAlgorithm)AnyStrong.INSTANCE_RTL, false);
        LOCALE = TextDirectionHeuristicLocale.INSTANCE;
    }
    
    private TextDirectionHeuristicsCompat() {
        super();
    }
    
    static /* synthetic */ int access$100(final int n) {
        return isRtlTextOrFormat(n);
    }
    
    static /* synthetic */ int access$200(final int n) {
        return isRtlText(n);
    }
    
    private static int isRtlText(final int n) {
        switch (n) {
            default:
                return 2;
            case 0:
                return 1;
            case 1:
            case 2:
                return 0;
        }
    }
    
    private static int isRtlTextOrFormat(final int n) {
        switch (n) {
            default:
                return 2;
            case 0:
            case 14:
            case 15:
                return 1;
            case 1:
            case 2:
            case 16:
            case 17:
                return 0;
        }
    }
}
